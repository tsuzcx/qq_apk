package com.tencent.shadow.core.b.a;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

final class k
  extends ZipInputStream
{
  k(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final ZipEntry getNextEntry()
  {
    ZipEntry localZipEntry = super.getNextEntry();
    if (localZipEntry != null)
    {
      Object localObject = localZipEntry.getName();
      if (localObject != null)
      {
        if ((!((String)localObject).contains("../")) && (!((String)localObject).contains("..\\"))) {
          return localZipEntry;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("非法entry路径:");
        ((StringBuilder)localObject).append(localZipEntry.getName());
        throw new SecurityException(((StringBuilder)localObject).toString());
      }
    }
    return localZipEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.k
 * JD-Core Version:    0.7.0.1
 */