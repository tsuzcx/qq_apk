package com.tencent.wework.api.model;

import android.os.Bundle;
import java.io.File;

public class WWMediaMessage
  extends WWBaseMessage
{
  public String description;
  public byte[] thumbData;
  public String title;
  
  public boolean checkArgs()
  {
    if ((this.thumbData != null) && (this.thumbData.length > 32768)) {}
    while (((this.title != null) && (this.title.length() > 512)) || ((this.description != null) && (this.description.length() > 1024))) {
      return false;
    }
    return true;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wwobject_title", this.title);
    paramBundle.putString("_wwobject_description", this.description);
    paramBundle.putByteArray("_wwobject_thumbdata", this.thumbData);
  }
  
  public static abstract class WWMediaObject
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMessage
 * JD-Core Version:    0.7.0.1
 */