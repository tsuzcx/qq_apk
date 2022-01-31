package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public abstract interface FileSystem
  extends Parcelable
{
  public abstract OutputStream I(String paramString, boolean paramBoolean);
  
  public abstract List<a> J(String paramString, boolean paramBoolean);
  
  public abstract boolean K(String paramString, boolean paramBoolean);
  
  public abstract String L(String paramString, boolean paramBoolean);
  
  public abstract int Qd();
  
  public abstract void a(CancellationSignal paramCancellationSignal);
  
  public abstract boolean aC(String paramString1, String paramString2);
  
  public abstract boolean exists(String paramString);
  
  public abstract boolean jJ(String paramString);
  
  public abstract void m(Map<String, String> paramMap);
  
  public abstract b mZ(String paramString);
  
  public abstract a na(String paramString);
  
  public abstract boolean nb(String paramString);
  
  public abstract InputStream openRead(String paramString);
  
  public abstract boolean r(String paramString, long paramLong);
  
  public static final class a
  {
    public final String name;
    public final long size;
    public final String wus;
    public final long wut;
    public final long wuu;
    public final boolean wuv;
    private FileSystem wuw;
    
    public a(FileSystem paramFileSystem, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
    {
      this.wuw = paramFileSystem;
      this.wus = paramString1;
      this.name = paramString2;
      this.size = paramLong1;
      this.wut = paramLong2;
      this.wuu = paramLong3;
      this.wuv = paramBoolean;
    }
    
    public final InputStream cLi()
    {
      return this.wuw.openRead(this.wus);
    }
    
    public final boolean delete()
    {
      if (this.wuv) {
        return this.wuw.K(this.wus, false);
      }
      return this.wuw.jJ(this.wus);
    }
    
    public final String toString()
    {
      String str2 = this.wus + " -> " + this.wuw.toString();
      String str1 = str2;
      if (this.wuv) {
        str1 = "[DIR] " + str2;
      }
      return str1;
    }
  }
  
  public static final class b
  {
    public long uhY;
    public long uia;
    public long uib;
    public long wux;
    public long wuy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */