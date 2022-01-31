package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.HashSet;

public final class j
{
  public HashMap<String, a> riP = new HashMap();
  public HashMap<String, a> riQ = new HashMap();
  public HashSet<Integer> riR = new HashSet();
  
  public final void aX(int paramInt, String paramString)
  {
    if (bk.getBoolean(paramString, false))
    {
      this.riR.add(Integer.valueOf(paramInt));
      return;
    }
    this.riR.remove(Integer.valueOf(paramInt));
  }
  
  public static final class a
  {
    public String desc;
    public String eAl;
    public String oOp;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.j
 * JD-Core Version:    0.7.0.1
 */