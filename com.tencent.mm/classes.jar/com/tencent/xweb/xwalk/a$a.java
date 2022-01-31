package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkUpdater.UpdateConfig;

final class a$a
  extends XWalkUpdater.UpdateConfig
{
  String xlx;
  
  private a$a(int paramInt)
  {
    super(null, false, paramInt);
  }
  
  public a$a(String paramString1, String paramString2)
  {
    this(i);
    this.xlx = paramString1;
    this.isMatchMd5 = false;
    this.isPatchUpdate = false;
    this.versionDetail = ("local:" + paramString2);
  }
  
  public final boolean checkValid()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.a
 * JD-Core Version:    0.7.0.1
 */