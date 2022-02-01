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
  extends WrapperFileSystem<FileSystem>
{
  public static final Parcelable.Creator<RC4EncryptedFileSystem> CREATOR;
  private final a.b Jth;
  private final boolean Jti;
  private volatile Key Jtj;
  private final String fHr;
  
  static
  {
    AppMethodBeat.i(13214);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13214);
  }
  
  private RC4EncryptedFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(13205);
    q.a(paramParcel, RC4EncryptedFileSystem.class, 2);
    this.Jth = a.ghl();
    this.fHr = paramParcel.readString();
    if (this.Jth == null)
    {
      paramParcel = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13205);
      throw paramParcel;
    }
    this.Jtj = this.Jth.P(this.fHr, a.ghk().Kgz.fxQ());
    if (this.Jtj != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.Jti = bool;
      AppMethodBeat.o(13205);
      return;
    }
  }
  
  public RC4EncryptedFileSystem(FileSystem paramFileSystem, String paramString)
  {
    super(paramFileSystem);
    AppMethodBeat.i(13204);
    this.Jth = a.ghl();
    this.fHr = paramString;
    if (this.Jth == null)
    {
      paramFileSystem = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13204);
      throw paramFileSystem;
    }
    this.Jtj = this.Jth.P(this.fHr, a.ghk().Kgz.fxQ());
    if (this.Jtj != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.Jti = bool;
      AppMethodBeat.o(13204);
      return;
    }
  }
  
  protected final boolean b(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    AppMethodBeat.i(13209);
    if ((paramFileSystem instanceof RC4EncryptedFileSystem))
    {
      RC4EncryptedFileSystem localRC4EncryptedFileSystem = (RC4EncryptedFileSystem)paramFileSystem;
      if ((localRC4EncryptedFileSystem.Jth == this.Jth) && (localRC4EncryptedFileSystem.fHr.equals(this.fHr)) && (localRC4EncryptedFileSystem.Jtj.equals(this.Jtj)) && ((this.JrA instanceof AbstractFileSystem)))
      {
        bool = ((AbstractFileSystem)this.JrA).b(paramString1, localRC4EncryptedFileSystem.JrA, paramString2);
        AppMethodBeat.o(13209);
        return bool;
      }
    }
    boolean bool = super.b(paramString1, paramFileSystem, paramString2);
    AppMethodBeat.o(13209);
    return bool;
  }
  
  public final void bS(Map<String, String> paramMap)
  {
    AppMethodBeat.i(13211);
    super.bS(paramMap);
    if (!this.Jti) {
      this.Jtj = this.Jth.P(this.fHr, paramMap);
    }
    AppMethodBeat.o(13211);
  }
  
  public final OutputStream cS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13208);
    Key localKey = this.Jtj;
    if (localKey == null)
    {
      paramString = new FileNotFoundException("Key is not initialized.");
      AppMethodBeat.o(13208);
      throw paramString;
    }
    if (paramBoolean)
    {
      paramString = new FileNotFoundException("Appending encrypted files is not supported.");
      AppMethodBeat.o(13208);
      throw paramString;
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, localKey);
      paramString = new CipherOutputStream(this.JrA.cS(paramString, false), localCipher);
      AppMethodBeat.o(13208);
      return paramString;
    }
    catch (GeneralSecurityException paramString)
    {
      paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
      AppMethodBeat.o(13208);
      throw paramString;
    }
  }
  
  protected final long d(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    AppMethodBeat.i(13210);
    if ((paramFileSystem instanceof RC4EncryptedFileSystem))
    {
      RC4EncryptedFileSystem localRC4EncryptedFileSystem = (RC4EncryptedFileSystem)paramFileSystem;
      if ((localRC4EncryptedFileSystem.Jth == this.Jth) && (localRC4EncryptedFileSystem.fHr.equals(this.fHr)) && (localRC4EncryptedFileSystem.Jtj.equals(this.Jtj)) && ((this.JrA instanceof AbstractFileSystem)))
      {
        l = ((AbstractFileSystem)this.JrA).d(paramString1, localRC4EncryptedFileSystem.JrA, paramString2);
        AppMethodBeat.o(13210);
        return l;
      }
    }
    long l = super.d(paramString1, paramFileSystem, paramString2);
    AppMethodBeat.o(13210);
    return l;
  }
  
  public final int fxC()
  {
    AppMethodBeat.i(13206);
    int i = this.JrA.fxC();
    AppMethodBeat.o(13206);
    return i & 0xFFFFFFED;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(13207);
    Key localKey = this.Jtj;
    if (localKey == null)
    {
      paramString = new FileNotFoundException("Key is not initialized.");
      AppMethodBeat.o(13207);
      throw paramString;
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(2, localKey);
      paramString = new CipherInputStream(this.JrA.openRead(paramString), localCipher);
      AppMethodBeat.o(13207);
      return paramString;
    }
    catch (GeneralSecurityException paramString)
    {
      paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
      AppMethodBeat.o(13207);
      throw paramString;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(13212);
    String str = "RC4 [" + this.JrA.toString() + "]";
    AppMethodBeat.o(13212);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13213);
    super.writeToParcel(paramParcel, paramInt);
    q.b(paramParcel, RC4EncryptedFileSystem.class, 2);
    paramParcel.writeString(this.fHr);
    AppMethodBeat.o(13213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem
 * JD-Core Version:    0.7.0.1
 */