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
  protected final FileSystem LFX;
  protected final e.b LHm;
  private final Key LHn;
  protected final String gcZ;
  
  static
  {
    AppMethodBeat.i(13214);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13214);
  }
  
  private RC4EncryptedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13205);
    w.a(paramParcel, RC4EncryptedFileSystem.class, 3);
    this.LHm = e.gEj();
    if (this.LHm == null)
    {
      paramParcel = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13205);
      throw paramParcel;
    }
    this.LFX = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    this.gcZ = paramParcel.readString();
    this.LHn = this.LHm.S(this.gcZ, e.fSU().OAF.fTa());
    AppMethodBeat.o(13205);
  }
  
  public RC4EncryptedFileSystem(FileSystem paramFileSystem, String paramString)
  {
    AppMethodBeat.i(13204);
    this.LHm = e.gEj();
    if (this.LHm == null)
    {
      paramFileSystem = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13204);
      throw paramFileSystem;
    }
    this.LFX = paramFileSystem;
    this.gcZ = paramString;
    this.LHn = this.LHm.S(this.gcZ, e.fSU().OAF.fTa());
    AppMethodBeat.o(13204);
  }
  
  public final FileSystem.b cd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(193435);
    Object localObject;
    if (this.LHn != null) {
      localObject = this.LHn;
    }
    Key localKey;
    do
    {
      paramMap = new a(this.LFX.cd(paramMap), (Key)localObject);
      AppMethodBeat.o(193435);
      return paramMap;
      localKey = this.LHm.S(this.gcZ, paramMap);
      localObject = localKey;
    } while (localKey != null);
    paramMap = new RuntimeException("Cannot generate key.");
    AppMethodBeat.o(193435);
    throw paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13212);
    String str = "RC4 [" + this.LFX.toString() + "]";
    AppMethodBeat.o(13212);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13213);
    w.b(paramParcel, RC4EncryptedFileSystem.class, 3);
    paramParcel.writeParcelable(this.LFX, paramInt);
    paramParcel.writeString(this.gcZ);
    AppMethodBeat.o(13213);
  }
  
  protected final class a
    extends x
  {
    protected final Key LHo;
    
    a(FileSystem.b paramb, Key paramKey)
    {
      super();
      this.LHo = paramKey;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(193433);
      if ((paramb instanceof a))
      {
        a locala = (a)paramb;
        if ((locala.LHp.LHm == RC4EncryptedFileSystem.this.LHm) && (locala.LHp.gcZ.equals(RC4EncryptedFileSystem.this.gcZ)) && (locala.LHo.equals(this.LHo)) && ((this.LFY instanceof a)))
        {
          bool = ((a)this.LFY).b(paramString1, ((a)paramb).LFY, paramString2);
          AppMethodBeat.o(193433);
          return bool;
        }
      }
      boolean bool = super.b(paramString1, paramb, paramString2);
      AppMethodBeat.o(193433);
      return bool;
    }
    
    protected final long d(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(193434);
      if ((paramb instanceof a))
      {
        a locala = (a)paramb;
        if ((locala.LHp.LHm == RC4EncryptedFileSystem.this.LHm) && (locala.LHp.gcZ.equals(RC4EncryptedFileSystem.this.gcZ)) && (locala.LHo.equals(this.LHo)) && ((this.LFY instanceof a)))
        {
          l = ((a)this.LFY).d(paramString1, ((a)paramb).LFY, paramString2);
          AppMethodBeat.o(193434);
          return l;
        }
      }
      long l = super.d(paramString1, paramb, paramString2);
      AppMethodBeat.o(193434);
      return l;
    }
    
    public final OutputStream db(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193432);
      Key localKey = this.LHo;
      if (localKey == null)
      {
        paramString = new FileNotFoundException("Key is not initialized.");
        AppMethodBeat.o(193432);
        throw paramString;
      }
      if (paramBoolean)
      {
        paramString = new FileNotFoundException("Appending encrypted files is not supported.");
        AppMethodBeat.o(193432);
        throw paramString;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance("RC4");
        localCipher.init(1, localKey);
        paramString = new CipherOutputStream(this.LFY.db(paramString, false), localCipher);
        AppMethodBeat.o(193432);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
        AppMethodBeat.o(193432);
        throw paramString;
      }
    }
    
    public final int fSL()
    {
      AppMethodBeat.i(193430);
      int i = this.LFY.fSL();
      AppMethodBeat.o(193430);
      return i & 0xFFFFFFED;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(193431);
      Key localKey = this.LHo;
      if (localKey == null)
      {
        paramString = new FileNotFoundException("Key is not initialized.");
        AppMethodBeat.o(193431);
        throw paramString;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance("RC4");
        localCipher.init(2, localKey);
        paramString = new CipherInputStream(this.LFY.openRead(paramString), localCipher);
        AppMethodBeat.o(193431);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
        AppMethodBeat.o(193431);
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem
 * JD-Core Version:    0.7.0.1
 */