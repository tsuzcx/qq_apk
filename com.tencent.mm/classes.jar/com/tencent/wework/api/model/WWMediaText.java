package com.tencent.wework.api.model;

import android.os.Bundle;

public class WWMediaText
  extends WWMediaMessage.WWMediaObject
{
  public String text;
  
  public WWMediaText() {}
  
  public WWMediaText(String paramString)
  {
    this.text = paramString;
  }
  
  public final boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    while ((this.text == null) || (this.text.length() == 0) || (this.text.length() > 10240)) {
      return false;
    }
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_wwtextobject_text", this.text);
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaText
 * JD-Core Version:    0.7.0.1
 */