package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

public class RC4EncryptedFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<RC4EncryptedFileSystem> CREATOR;
  protected final FileSystem agvG;
  protected final k.b agyX;
  protected final String lWh;
  
  static
  {
    AppMethodBeat.i(13214);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13214);
  }
  
  private RC4EncryptedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13205);
    ah.a(paramParcel, RC4EncryptedFileSystem.class, 3);
    this.agyX = k.kMt();
    if (this.agyX == null)
    {
      paramParcel = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13205);
      throw paramParcel;
    }
    this.agvG = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    this.lWh = paramParcel.readString();
    AppMethodBeat.o(13205);
  }
  
  public RC4EncryptedFileSystem(FileSystem paramFileSystem, String paramString)
  {
    AppMethodBeat.i(13204);
    this.agyX = k.kMt();
    if (this.agyX == null)
    {
      paramFileSystem = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13204);
      throw paramFileSystem;
    }
    this.agvG = paramFileSystem;
    this.lWh = paramString;
    AppMethodBeat.o(13204);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13212);
    String str = "RC4 [" + this.agvG.toString() + "]";
    AppMethodBeat.o(13212);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13213);
    ah.b(paramParcel, RC4EncryptedFileSystem.class, 3);
    paramParcel.writeParcelable(this.agvG, paramInt);
    paramParcel.writeString(this.lWh);
    AppMethodBeat.o(13213);
  }
  
  protected final class a
    extends ai
  {
    protected final Key agyY;
    
    a(FileSystem.b paramb, Key paramKey)
    {
      super();
      this.agyY = paramKey;
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(238089);
      Key localKey = this.agyY;
      if (localKey == null)
      {
        paramString = new FileNotFoundException("Key is not initialized.");
        AppMethodBeat.o(238089);
        throw paramString;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance("RC4");
        localCipher.init(2, localKey);
        paramString = new CipherInputStream(this.agwv.Lh(paramString), localCipher);
        AppMethodBeat.o(238089);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
        AppMethodBeat.o(238089);
        throw paramString;
      }
    }
    
    protected final long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(238109);
      if ((paramb instanceof a))
      {
        a locala = (a)paramb;
        if ((locala.agyZ.agyX == RC4EncryptedFileSystem.this.agyX) && (locala.agyZ.lWh.equals(RC4EncryptedFileSystem.this.lWh)) && (locala.agyY.equals(this.agyY)) && ((this.agwv instanceof a)))
        {
          l = ((a)this.agwv).b(paramString1, ((a)paramb).agwv, paramString2, paramBoolean);
          AppMethodBeat.o(238109);
          return l;
        }
      }
      long l = super.b(paramString1, paramb, paramString2, paramBoolean);
      AppMethodBeat.o(238109);
      return l;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(238103);
      if ((paramb instanceof a))
      {
        a locala = (a)paramb;
        if ((locala.agyZ.agyX == RC4EncryptedFileSystem.this.agyX) && (locala.agyZ.lWh.equals(RC4EncryptedFileSystem.this.lWh)) && (locala.agyY.equals(this.agyY)) && ((this.agwv instanceof a)))
        {
          bool = ((a)this.agwv).b(paramString1, ((a)paramb).agwv, paramString2);
          AppMethodBeat.o(238103);
          return bool;
        }
      }
      boolean bool = super.b(paramString1, paramb, paramString2);
      AppMethodBeat.o(238103);
      return bool;
    }
    
    public final OutputStream ev(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238095);
      Key localKey = this.agyY;
      if (localKey == null)
      {
        paramString = new FileNotFoundException("Key is not initialized.");
        AppMethodBeat.o(238095);
        throw paramString;
      }
      if (paramBoolean)
      {
        paramString = new FileNotFoundException("Appending encrypted files is not supported.");
        AppMethodBeat.o(238095);
        throw paramString;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance("RC4");
        localCipher.init(1, localKey);
        paramString = new CipherOutputStream(this.agwv.ev(paramString, false), localCipher);
        AppMethodBeat.o(238095);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
        AppMethodBeat.o(238095);
        throw paramString;
      }
    }
    
    public final int jKc()
    {
      AppMethodBeat.i(238082);
      int i = this.agwv.jKc();
      AppMethodBeat.o(238082);
      return i & 0xFFFFFFED;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem
 * JD-Core Version:    0.7.0.1
 */