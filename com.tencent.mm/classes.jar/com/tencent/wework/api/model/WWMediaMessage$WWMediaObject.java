package com.tencent.wework.api.model;

import java.io.File;

public abstract class WWMediaMessage$WWMediaObject
  extends WWMediaMessage
{
  protected static int getFileSize(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        return (int)paramString.length();
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMessage.WWMediaObject
 * JD-Core Version:    0.7.0.1
 */