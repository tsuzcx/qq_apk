package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Collections;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

public class RC4EncryptedFileSystem
  extends FileBasedFileSystem
{
  public static final Parcelable.Creator<RC4EncryptedFileSystem> CREATOR;
  private final FileSystemManager.b AQp;
  private final boolean AQq;
  private volatile Key AQr;
  private final String equ;
  
  static
  {
    AppMethodBeat.i(54578);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(54578);
  }
  
  private RC4EncryptedFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(54572);
    j.a(paramParcel, getClass());
    this.AQp = FileSystemManager.erR();
    this.equ = paramParcel.readString();
    if (this.AQp == null)
    {
      paramParcel = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(54572);
      throw paramParcel;
    }
    this.AQr = this.AQp.e(this.equ, Collections.unmodifiableMap(FileSystemManager.dQE().APJ));
    if (this.AQr != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.AQq = bool;
      AppMethodBeat.o(54572);
      return;
    }
  }
  
  public RC4EncryptedFileSystem(String paramString1, String paramString2)
  {
    super(paramString1);
    AppMethodBeat.i(54571);
    this.AQp = FileSystemManager.erR();
    this.equ = paramString2;
    if (this.AQp == null)
    {
      paramString1 = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
      AppMethodBeat.o(54571);
      throw paramString1;
    }
    this.AQr = this.AQp.e(this.equ, Collections.unmodifiableMap(FileSystemManager.dQE().APJ));
    if (this.AQr != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.AQq = bool;
      AppMethodBeat.o(54571);
      return;
    }
  }
  
  public final OutputStream M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54574);
    Key localKey = this.AQr;
    if (localKey == null)
    {
      paramString = new IOException("Key is not initialized.");
      AppMethodBeat.o(54574);
      throw paramString;
    }
    if (this.mReadOnly)
    {
      paramString = new IOException("Cannot open files for writing on read-only file systems");
      AppMethodBeat.o(54574);
      throw paramString;
    }
    String str = P(paramString, true);
    if (str == null)
    {
      paramString = new IOException("Invalid path: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(54574);
      throw paramString;
    }
    try
    {
      paramString = Cipher.getInstance("RC4");
      paramString.init(1, localKey);
      paramString = new CipherOutputStream(new FileOutputStream(str, paramBoolean), paramString);
      AppMethodBeat.o(54574);
      return paramString;
    }
    catch (GeneralSecurityException paramString)
    {
      paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
      AppMethodBeat.o(54574);
      throw paramString;
    }
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(54573);
    Key localKey = this.AQr;
    if (localKey == null)
    {
      paramString = new IOException("Key is not initialized.");
      AppMethodBeat.o(54573);
      throw paramString;
    }
    String str = P(paramString, false);
    if (str == null)
    {
      paramString = new IOException("Invalid path: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(54573);
      throw paramString;
    }
    try
    {
      paramString = Cipher.getInstance("RC4");
      paramString.init(2, localKey);
      paramString = new CipherInputStream(new FileInputStream(str), paramString);
      AppMethodBeat.o(54573);
      return paramString;
    }
    catch (GeneralSecurityException paramString)
    {
      paramString = (FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString);
      AppMethodBeat.o(54573);
      throw paramString;
    }
  }
  
  public final void q(Map<String, String> paramMap)
  {
    AppMethodBeat.i(54575);
    super.q(paramMap);
    if (!this.AQq) {
      this.AQr = this.AQp.e(this.equ, paramMap);
    }
    AppMethodBeat.o(54575);
  }
  
  public String toString()
  {
    AppMethodBeat.i(54576);
    Object localObject = new StringBuilder("RC4FS [").append(dQz());
    if (this.mReadOnly) {
      ((StringBuilder)localObject).append(", read-only");
    }
    localObject = ']';
    AppMethodBeat.o(54576);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(54577);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(1);
    paramParcel.writeString(this.equ);
    AppMethodBeat.o(54577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem
 * JD-Core Version:    0.7.0.1
 */