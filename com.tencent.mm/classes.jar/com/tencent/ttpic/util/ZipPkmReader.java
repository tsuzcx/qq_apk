package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.ETC1;
import android.opengl.ETC1Util.ETC1Texture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.etc.ETC1File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipPkmReader
{
  private ByteBuffer headerBuffer;
  private ZipEntry mZipEntry;
  private ZipInputStream mZipStream;
  private String path;
  
  public ZipPkmReader(String paramString)
  {
    this.path = paramString;
  }
  
  private ETC1Util.ETC1Texture createTexture(InputStream paramInputStream)
  {
    AppMethodBeat.i(84314);
    byte[] arrayOfByte = new byte[4096];
    if (paramInputStream.read(arrayOfByte, 0, 16) != 16)
    {
      paramInputStream = new IOException("Unable to read PKM file header.");
      AppMethodBeat.o(84314);
      throw paramInputStream;
    }
    if (this.headerBuffer == null) {
      this.headerBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder());
    }
    this.headerBuffer.put(arrayOfByte, 0, 16).position(0);
    if (!ETC1.isValid(this.headerBuffer))
    {
      paramInputStream = new IOException("Not a PKM file.");
      AppMethodBeat.o(84314);
      throw paramInputStream;
    }
    int i = ETC1.getWidth(this.headerBuffer);
    int j = ETC1.getHeight(this.headerBuffer);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(ETC1.getEncodedDataSize(i, j)).order(ByteOrder.nativeOrder());
    for (;;)
    {
      int k = paramInputStream.read(arrayOfByte);
      if (k == -1) {
        break;
      }
      localByteBuffer.put(arrayOfByte, 0, k);
    }
    localByteBuffer.position(0);
    paramInputStream = new ETC1Util.ETC1Texture(i, j, localByteBuffer);
    AppMethodBeat.o(84314);
    return paramInputStream;
  }
  
  private boolean hasElements()
  {
    AppMethodBeat.i(84310);
    try
    {
      if (this.mZipStream != null)
      {
        this.mZipEntry = this.mZipStream.getNextEntry();
        ZipEntry localZipEntry = this.mZipEntry;
        if (localZipEntry != null)
        {
          AppMethodBeat.o(84310);
          return true;
        }
      }
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(84310);
    }
    return false;
  }
  
  public void close()
  {
    AppMethodBeat.i(84309);
    if (this.mZipStream != null) {}
    try
    {
      this.mZipStream.closeEntry();
      this.mZipStream.close();
      label26:
      if (this.headerBuffer != null)
      {
        this.headerBuffer.clear();
        this.headerBuffer = null;
      }
      AppMethodBeat.o(84309);
      return;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public ETC1File getNextEntry()
  {
    AppMethodBeat.i(84313);
    Object localObject = getNextTexture();
    if ((localObject != null) && (!this.mZipEntry.getName().contains("../")))
    {
      localObject = new ETC1File(this.mZipEntry.getName(), (ETC1Util.ETC1Texture)localObject);
      AppMethodBeat.o(84313);
      return localObject;
    }
    AppMethodBeat.o(84313);
    return null;
  }
  
  public InputStream getNextStream()
  {
    AppMethodBeat.i(84311);
    if (hasElements())
    {
      ZipInputStream localZipInputStream = this.mZipStream;
      AppMethodBeat.o(84311);
      return localZipInputStream;
    }
    AppMethodBeat.o(84311);
    return null;
  }
  
  public ETC1Util.ETC1Texture getNextTexture()
  {
    AppMethodBeat.i(84312);
    if (hasElements()) {
      try
      {
        ETC1Util.ETC1Texture localETC1Texture = createTexture(this.mZipStream);
        AppMethodBeat.o(84312);
        return localETC1Texture;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(84312);
    return null;
  }
  
  public boolean open()
  {
    AppMethodBeat.i(84308);
    if (this.path == null)
    {
      AppMethodBeat.o(84308);
      return false;
    }
    try
    {
      if (this.path.startsWith("assets://")) {
        this.mZipStream = new ZipInputStream(VideoGlobalContext.getContext().getAssets().open(FileUtils.getRealPath(this.path)));
      }
      for (;;)
      {
        AppMethodBeat.o(84308);
        return true;
        this.mZipStream = new ZipInputStream(new FileInputStream(this.path));
        this.mZipStream.reset();
      }
      return false;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(84308);
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(84315);
    close();
    open();
    AppMethodBeat.o(84315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.ZipPkmReader
 * JD-Core Version:    0.7.0.1
 */