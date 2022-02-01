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
  protected final FileSystem Rbo;
  protected final g.b RcY;
  private final Key RcZ;
  protected final String gIx;
  
  static
  {
    AppMethodBeat.i(13214);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13214);
  }
  
  private RC4EncryptedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13205);
    aa.a(paramParcel, RC4EncryptedFileSystem.class, 3);
    this.RcY = g.hRS();
    if (this.RcY == null)
    {
      paramParcel = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13205);
      throw paramParcel;
    }
    this.Rbo = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    this.gIx = paramParcel.readString();
    this.RcZ = this.RcY.Z(this.gIx, g.hRR().Uvh.hej());
    AppMethodBeat.o(13205);
  }
  
  public RC4EncryptedFileSystem(FileSystem paramFileSystem, String paramString)
  {
    AppMethodBeat.i(13204);
    this.RcY = g.hRS();
    if (this.RcY == null)
    {
      paramFileSystem = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13204);
      throw paramFileSystem;
    }
    this.Rbo = paramFileSystem;
    this.gIx = paramString;
    this.RcZ = this.RcY.Z(this.gIx, g.hRR().Uvh.hej());
    AppMethodBeat.o(13204);
  }
  
  public final FileSystem.b cj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(187730);
    Object localObject;
    if (this.RcZ != null) {
      localObject = this.RcZ;
    }
    Key localKey;
    do
    {
      paramMap = new a(this.Rbo.cj(paramMap), (Key)localObject);
      AppMethodBeat.o(187730);
      return paramMap;
      localKey = this.RcY.Z(this.gIx, paramMap);
      localObject = localKey;
    } while (localKey != null);
    paramMap = new RuntimeException("Cannot generate key.");
    AppMethodBeat.o(187730);
    throw paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13212);
    String str = "RC4 [" + this.Rbo.toString() + "]";
    AppMethodBeat.o(13212);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13213);
    aa.b(paramParcel, RC4EncryptedFileSystem.class, 3);
    paramParcel.writeParcelable(this.Rbo, paramInt);
    paramParcel.writeString(this.gIx);
    AppMethodBeat.o(13213);
  }
  
  protected final class a
    extends ab
  {
    protected final Key Rda;
    
    a(FileSystem.b paramb, Key paramKey)
    {
      super();
      this.Rda = paramKey;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(187728);
      if ((paramb instanceof a))
      {
        a locala = (a)paramb;
        if ((locala.Rdb.RcY == RC4EncryptedFileSystem.this.RcY) && (locala.Rdb.gIx.equals(RC4EncryptedFileSystem.this.gIx)) && (locala.Rda.equals(this.Rda)) && ((this.Rbp instanceof a)))
        {
          bool = ((a)this.Rbp).b(paramString1, ((a)paramb).Rbp, paramString2);
          AppMethodBeat.o(187728);
          return bool;
        }
      }
      boolean bool = super.b(paramString1, paramb, paramString2);
      AppMethodBeat.o(187728);
      return bool;
    }
    
    protected final long d(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(187729);
      if ((paramb instanceof a))
      {
        a locala = (a)paramb;
        if ((locala.Rdb.RcY == RC4EncryptedFileSystem.this.RcY) && (locala.Rdb.gIx.equals(RC4EncryptedFileSystem.this.gIx)) && (locala.Rda.equals(this.Rda)) && ((this.Rbp instanceof a)))
        {
          l = ((a)this.Rbp).d(paramString1, ((a)paramb).Rbp, paramString2);
          AppMethodBeat.o(187729);
          return l;
        }
      }
      long l = super.d(paramString1, paramb, paramString2);
      AppMethodBeat.o(187729);
      return l;
    }
    
    public final OutputStream dw(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187727);
      Key localKey = this.Rda;
      if (localKey == null)
      {
        paramString = new FileNotFoundException("Key is not initialized.");
        AppMethodBeat.o(187727);
        throw paramString;
      }
      if (paramBoolean)
      {
        paramString = new FileNotFoundException("Appending encrypted files is not supported.");
        AppMethodBeat.o(187727);
        throw paramString;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance("RC4");
        localCipher.init(1, localKey);
        paramString = new CipherOutputStream(this.Rbp.dw(paramString, false), localCipher);
        AppMethodBeat.o(187727);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
        AppMethodBeat.o(187727);
        throw paramString;
      }
    }
    
    public final int hdR()
    {
      AppMethodBeat.i(187725);
      int i = this.Rbp.hdR();
      AppMethodBeat.o(187725);
      return i & 0xFFFFFFED;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(187726);
      Key localKey = this.Rda;
      if (localKey == null)
      {
        paramString = new FileNotFoundException("Key is not initialized.");
        AppMethodBeat.o(187726);
        throw paramString;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance("RC4");
        localCipher.init(2, localKey);
        paramString = new CipherInputStream(this.Rbp.openRead(paramString), localCipher);
        AppMethodBeat.o(187726);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
        AppMethodBeat.o(187726);
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem
 * JD-Core Version:    0.7.0.1
 */