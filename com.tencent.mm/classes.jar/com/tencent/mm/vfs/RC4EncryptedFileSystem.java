package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
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
  public static final Parcelable.Creator<RC4EncryptedFileSystem> CREATOR = new Parcelable.Creator() {};
  private final String dIX;
  private final FileSystemManager.b wvp;
  private final boolean wvq;
  private volatile Key wvr;
  
  private RC4EncryptedFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    j.a(paramParcel, getClass());
    this.wvp = FileSystemManager.cVx();
    this.dIX = paramParcel.readString();
    if (this.wvp == null) {
      throw new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
    }
    this.wvr = this.wvp.d(this.dIX, Collections.unmodifiableMap(FileSystemManager.cVw().xvU));
    if (this.wvr != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.wvq = bool;
      return;
    }
  }
  
  public RC4EncryptedFileSystem(String paramString1, String paramString2)
  {
    super(paramString1);
    this.wvp = FileSystemManager.cVx();
    this.dIX = paramString2;
    if (this.wvp == null) {
      throw new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
    }
    this.wvr = this.wvp.d(this.dIX, Collections.unmodifiableMap(FileSystemManager.cVw().xvU));
    if (this.wvr != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.wvq = bool;
      return;
    }
  }
  
  public final OutputStream I(String paramString, boolean paramBoolean)
  {
    Key localKey = this.wvr;
    if (localKey == null) {
      throw new IOException("Key is not initialized.");
    }
    if (this.mReadOnly) {
      throw new IOException("Cannot open files for writing on read-only file systems");
    }
    String str = L(paramString, true);
    if (str == null) {
      throw new IOException("Invalid path: " + paramString);
    }
    try
    {
      paramString = Cipher.getInstance("RC4");
      paramString.init(1, localKey);
      paramString = new CipherOutputStream(new FileOutputStream(str, paramBoolean), paramString);
      return paramString;
    }
    catch (GeneralSecurityException paramString)
    {
      throw ((FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString));
    }
  }
  
  public final void m(Map<String, String> paramMap)
  {
    super.m(paramMap);
    if (!this.wvq) {
      this.wvr = this.wvp.d(this.dIX, paramMap);
    }
  }
  
  public final InputStream openRead(String paramString)
  {
    Key localKey = this.wvr;
    if (localKey == null) {
      throw new IOException("Key is not initialized.");
    }
    String str = L(paramString, false);
    if (str == null) {
      throw new IOException("Invalid path: " + paramString);
    }
    try
    {
      paramString = Cipher.getInstance("RC4");
      paramString.init(2, localKey);
      paramString = new CipherInputStream(new FileInputStream(str), paramString);
      return paramString;
    }
    catch (GeneralSecurityException paramString)
    {
      throw ((FileNotFoundException)new FileNotFoundException("Failed to initialize cipher: " + paramString.getMessage()).initCause(paramString));
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RC4FS [").append(cLh());
    if (this.mReadOnly) {
      localStringBuilder.append(", read-only");
    }
    return ']';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(1);
    paramParcel.writeString(this.dIX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem
 * JD-Core Version:    0.7.0.1
 */