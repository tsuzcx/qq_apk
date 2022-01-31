package com.tencent.smtt.sandbox;

import android.os.ParcelFileDescriptor;

public final class FileDescriptorInfo
{
  public final ParcelFileDescriptor fd;
  public final int id;
  public final long offset;
  public final long size;
  
  public FileDescriptorInfo(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, long paramLong2)
  {
    this.id = paramInt;
    this.fd = paramParcelFileDescriptor;
    this.offset = paramLong1;
    this.size = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sandbox.FileDescriptorInfo
 * JD-Core Version:    0.7.0.1
 */