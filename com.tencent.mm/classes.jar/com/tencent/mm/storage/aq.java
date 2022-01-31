package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class aq
{
  public boolean mInit;
  public String yMM;
  public int yMN;
  public int yMO;
  HashMap<String, String> yMP;
  public HashMap<String, ArrayList<String>> yMQ;
  public HashMap<String, String> yMR;
  public HashMap<String, ArrayList<a>> yMS;
  public Comparator yMT;
  
  public aq()
  {
    AppMethodBeat.i(62703);
    this.mInit = false;
    this.yMN = 2;
    this.yMO = 32;
    this.yMP = new HashMap();
    this.yMQ = new HashMap();
    this.yMR = new HashMap();
    this.yMS = new HashMap();
    this.yMT = new aq.1(this);
    AppMethodBeat.o(62703);
  }
  
  public final String Kx(String paramString)
  {
    AppMethodBeat.i(62706);
    if ((this.yMP != null) && (this.yMP.containsKey(paramString)))
    {
      paramString = (String)this.yMP.get(paramString);
      AppMethodBeat.o(62706);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNp.Kx(paramString);
    AppMethodBeat.o(62706);
    return paramString;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(62704);
    if (this.yMP != null) {
      this.yMP.clear();
    }
    if (this.yMQ != null) {
      this.yMQ.clear();
    }
    if (this.yMR != null) {
      this.yMR.clear();
    }
    if (this.yMS != null) {
      this.yMS.clear();
    }
    AppMethodBeat.o(62704);
  }
  
  public final void dxs()
  {
    AppMethodBeat.i(62705);
    com.tencent.mm.sdk.g.d.ysn.a(new aq.2(this), "MicroMsg.emoji.EmojiDescNewMgr|newinit");
    AppMethodBeat.o(62705);
  }
  
  public final class a
  {
    public String cqq;
    int index;
    
    a(String paramString, int paramInt)
    {
      this.cqq = paramString;
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.aq
 * JD-Core Version:    0.7.0.1
 */