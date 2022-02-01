package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatBrands$PlaceHolderHandler$StringSpan
{
  protected final String mText;
  
  public WeChatBrands$PlaceHolderHandler$StringSpan(String paramString)
  {
    this.mText = paramString;
  }
  
  public boolean isReplaceable()
  {
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(248790);
    String str = String.valueOf(this.mText);
    AppMethodBeat.o(248790);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands.PlaceHolderHandler.StringSpan
 * JD-Core Version:    0.7.0.1
 */