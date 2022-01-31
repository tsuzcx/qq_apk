package com.tencent.wework.api.model;

import android.os.Bundle;

public class WWMediaLink
  extends WWMediaMessage.WWMediaObject
{
  public String thumbUrl;
  public String webpageUrl;
  
  public final boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    while ((this.webpageUrl == null) || (this.webpageUrl.length() == 0) || (this.webpageUrl.length() > 10240)) {
      return false;
    }
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_wwwebpageobject_thumbUrl", this.thumbUrl);
    paramBundle.putString("_wwwebpageobject_webpageUrl", this.webpageUrl);
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaLink
 * JD-Core Version:    0.7.0.1
 */