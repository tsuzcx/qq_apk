package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

public class RC4EncryptedFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<RC4EncryptedFileSystem> CREATOR;
  protected final FileSystem YBI;
  protected final h.b YDB;
  private final Key YDC;
  protected final String jsP;
  
  static
  {
    AppMethodBeat.i(13214);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13214);
  }
  
  private RC4EncryptedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13205);
    ad.a(paramParcel, RC4EncryptedFileSystem.class, 3);
    this.YDB = h.iWI();
    if (this.YDB == null)
    {
      paramParcel = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13205);
      throw paramParcel;
    }
    this.YBI = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    this.jsP = paramParcel.readString();
    this.YDC = this.YDB.ac(this.jsP, h.iWH().abSS.ift());
    AppMethodBeat.o(13205);
  }
  
  public RC4EncryptedFileSystem(FileSystem paramFileSystem, String paramString)
  {
    AppMethodBeat.i(13204);
    this.YDB = h.iWI();
    if (this.YDB == null)
    {
      paramFileSystem = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13204);
      throw paramFileSystem;
    }
    this.YBI = paramFileSystem;
    this.jsP = paramString;
    this.YDC = this.YDB.ac(this.jsP, h.iWH().abSS.ift());
    AppMethodBeat.o(13204);
  }
  
  public final FileSystem.b cp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(236574);
    Object localObject;
    if (this.YDC != null) {
      localObject = this.YDC;
    }
    Key localKey;
    do
    {
      paramMap = new a(this.YBI.cp(paramMap), (Key)localObject);
      AppMethodBeat.o(236574);
      return paramMap;
      localKey = this.YDB.ac(this.jsP, paramMap);
      localObject = localKey;
    } while (localKey != null);
    paramMap = new RuntimeException("Cannot generate key.");
    AppMethodBeat.o(236574);
    throw paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13212);
    String str = "RC4 [" + this.YBI.toString() + "]";
    AppMethodBeat.o(13212);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13213);
    ad.b(paramParcel, RC4EncryptedFileSystem.class, 3);
    paramParcel.writeParcelable(this.YBI, paramInt);
    paramParcel.writeString(this.jsP);
    AppMethodBeat.o(13213);
  }
  
  protected final class a
    extends ae
  {
    protected final Key YDD;
    
    a(FileSystem.b paramb, Key paramKey)
    {
      super();
      this.YDD = paramKey;
    }
    
    public final InputStream Tf(String paramString)
    {
      AppMethodBeat.i(236556);
      Key localKey = this.YDD;
      if (localKey == null)
      {
        paramString = new FileNotFoundException("Key is not initialized.");
        AppMethodBeat.o(236556);
        throw paramString;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance("RC4");
        localCipher.init(2, localKey);
        paramString = new CipherInputStream(this.YBJ.Tf(paramString), localCipher);
        AppMethodBeat.o(236556);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
        AppMethodBeat.o(236556);
        throw paramString;
      }
    }
    
    protected final long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(236566);
      if ((paramb instanceof a))
      {
        a locala = (a)paramb;
        if ((locala.YDE.YDB == RC4EncryptedFileSystem.this.YDB) && (locala.YDE.jsP.equals(RC4EncryptedFileSystem.this.jsP)) && (locala.YDD.equals(this.YDD)) && ((this.YBJ instanceof a)))
        {
          l = ((a)this.YBJ).b(paramString1, ((a)paramb).YBJ, paramString2, paramBoolean);
          AppMethodBeat.o(236566);
          return l;
        }
      }
      long l = super.b(paramString1, paramb, paramString2, paramBoolean);
      AppMethodBeat.o(236566);
      return l;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(236563);
      if ((paramb instanceof a))
      {
        a locala = (a)paramb;
        if ((locala.YDE.YDB == RC4EncryptedFileSystem.this.YDB) && (locala.YDE.jsP.equals(RC4EncryptedFileSystem.this.jsP)) && (locala.YDD.equals(this.YDD)) && ((this.YBJ instanceof a)))
        {
          bool = ((a)this.YBJ).b(paramString1, ((a)paramb).YBJ, paramString2);
          AppMethodBeat.o(236563);
          return bool;
        }
      }
      boolean bool = super.b(paramString1, paramb, paramString2);
      AppMethodBeat.o(236563);
      return bool;
    }
    
    public final OutputStream dI(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236560);
      Key localKey = this.YDD;
      if (localKey == null)
      {
        paramString = new FileNotFoundException("Key is not initialized.");
        AppMethodBeat.o(236560);
        throw paramString;
      }
      if (paramBoolean)
      {
        paramString = new FileNotFoundException("Appending encrypted files is not supported.");
        AppMethodBeat.o(236560);
        throw paramString;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance("RC4");
        localCipher.init(1, localKey);
        paramString = new CipherOutputStream(this.YBJ.dI(paramString, false), localCipher);
        AppMethodBeat.o(236560);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
        AppMethodBeat.o(236560);
        throw paramString;
      }
    }
    
    public final int ieY()
    {
      AppMethodBeat.i(236553);
      int i = this.YBJ.ieY();
      AppMethodBeat.o(236553);
      return i & 0xFFFFFFED;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem
 * JD-Core Version:    0.7.0.1
 */