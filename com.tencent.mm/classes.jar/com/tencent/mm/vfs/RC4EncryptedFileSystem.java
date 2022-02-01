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
  private final a.b LkM;
  private final boolean LkN;
  private volatile Key LkO;
  private final String gaR;
  
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
    this.LkM = a.gzV();
    this.gaR = paramParcel.readString();
    if (this.LkM == null)
    {
      paramParcel = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13205);
      throw paramParcel;
    }
    this.LkO = this.LkM.R(this.gaR, a.gzU().Ofy.fOF());
    if (this.LkO != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.LkN = bool;
      AppMethodBeat.o(13205);
      return;
    }
  }
  
  public RC4EncryptedFileSystem(FileSystem paramFileSystem, String paramString)
  {
    super(paramFileSystem);
    AppMethodBeat.i(13204);
    this.LkM = a.gzV();
    this.gaR = paramString;
    if (this.LkM == null)
    {
      paramFileSystem = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(13204);
      throw paramFileSystem;
    }
    this.LkO = this.LkM.R(this.gaR, a.gzU().Ofy.fOF());
    if (this.LkO != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.LkN = bool;
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
      if ((localRC4EncryptedFileSystem.LkM == this.LkM) && (localRC4EncryptedFileSystem.gaR.equals(this.gaR)) && (localRC4EncryptedFileSystem.LkO.equals(this.LkO)) && ((this.Ljf instanceof AbstractFileSystem)))
      {
        bool = ((AbstractFileSystem)this.Ljf).b(paramString1, localRC4EncryptedFileSystem.Ljf, paramString2);
        AppMethodBeat.o(13209);
        return bool;
      }
    }
    boolean bool = super.b(paramString1, paramFileSystem, paramString2);
    AppMethodBeat.o(13209);
    return bool;
  }
  
  public final void bY(Map<String, String> paramMap)
  {
    AppMethodBeat.i(13211);
    super.bY(paramMap);
    if (!this.LkN) {
      this.LkO = this.LkM.R(this.gaR, paramMap);
    }
    AppMethodBeat.o(13211);
  }
  
  public final OutputStream cX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13208);
    Key localKey = this.LkO;
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
      paramString = new CipherOutputStream(this.Ljf.cX(paramString, false), localCipher);
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
      if ((localRC4EncryptedFileSystem.LkM == this.LkM) && (localRC4EncryptedFileSystem.gaR.equals(this.gaR)) && (localRC4EncryptedFileSystem.LkO.equals(this.LkO)) && ((this.Ljf instanceof AbstractFileSystem)))
      {
        l = ((AbstractFileSystem)this.Ljf).d(paramString1, localRC4EncryptedFileSystem.Ljf, paramString2);
        AppMethodBeat.o(13210);
        return l;
      }
    }
    long l = super.d(paramString1, paramFileSystem, paramString2);
    AppMethodBeat.o(13210);
    return l;
  }
  
  public final int fOp()
  {
    AppMethodBeat.i(13206);
    int i = this.Ljf.fOp();
    AppMethodBeat.o(13206);
    return i & 0xFFFFFFED;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(13207);
    Key localKey = this.LkO;
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
      paramString = new CipherInputStream(this.Ljf.openRead(paramString), localCipher);
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
    String str = "RC4 [" + this.Ljf.toString() + "]";
    AppMethodBeat.o(13212);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13213);
    super.writeToParcel(paramParcel, paramInt);
    q.b(paramParcel, RC4EncryptedFileSystem.class, 2);
    paramParcel.writeString(this.gaR);
    AppMethodBeat.o(13213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem
 * JD-Core Version:    0.7.0.1
 */