package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.g;
import java.util.ArrayList;

public final class a
{
  c EYA;
  c EYB;
  c EYC;
  public c EYD;
  ArrayList<a> EYE;
  c EYc;
  c EYd;
  c EYe;
  c EYf;
  c EYg;
  c EYh;
  c EYi;
  c EYj;
  c EYk;
  c EYl;
  c EYm;
  c EYn;
  c EYo;
  c EYp;
  c EYq;
  c EYr;
  c EYs;
  c EYt;
  public c EYu;
  c EYv;
  c EYw;
  public c EYx;
  private c EYy;
  c EYz;
  public final String TAG;
  
  public a()
  {
    AppMethodBeat.i(31493);
    this.TAG = "MircoMsg.AppPanelControl";
    this.EYc = new c();
    this.EYd = new c();
    this.EYe = new c();
    this.EYf = new c();
    this.EYg = new c();
    this.EYh = new c();
    this.EYi = new c();
    this.EYr = new c();
    this.EYp = new c();
    this.EYj = new c();
    this.EYk = new c();
    this.EYl = new c();
    this.EYm = new c();
    this.EYn = new c();
    this.EYo = new c();
    this.EYq = new c();
    this.EYs = new c();
    this.EYt = new c();
    this.EYu = new c();
    this.EYv = new c();
    this.EYw = new c();
    this.EYx = new c();
    this.EYy = new c();
    this.EYz = new c();
    this.EYC = new c();
    this.EYD = new c();
    this.EYA = new c();
    this.EYB = new c();
    AppMethodBeat.o(31493);
  }
  
  public final void fdh()
  {
    this.EYc.value = true;
    this.EYd.value = true;
    this.EYe.value = true;
    this.EYf.value = true;
    this.EYg.value = true;
    this.EYh.value = true;
    this.EYi.value = true;
    this.EYr.value = true;
    this.EYp.value = true;
    this.EYj.value = true;
    this.EYk.value = true;
    this.EYl.value = true;
    this.EYm.value = true;
    this.EYn.value = true;
    this.EYo.value = true;
    this.EYq.value = true;
    this.EYs.value = true;
    this.EYt.value = false;
    this.EYu.value = true;
    this.EYv.value = true;
    this.EYx.value = true;
    this.EYy.value = true;
    this.EYx.value = false;
    this.EYD.value = false;
    this.EYz.value = true;
    this.EYA.value = true;
    this.EYB.value = true;
  }
  
  public final void fdi()
  {
    this.EYi.value = true;
  }
  
  public final void fdj()
  {
    this.EYq.value = true;
  }
  
  public final ArrayList<a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163211);
    if (this.EYE == null)
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(163211);
      return localArrayList;
    }
    ArrayList localArrayList = this.EYE;
    AppMethodBeat.o(163211);
    return localArrayList;
  }
  
  public final void vU(boolean paramBoolean)
  {
    this.EYj.value = paramBoolean;
  }
  
  public final void vV(boolean paramBoolean)
  {
    this.EYk.value = paramBoolean;
  }
  
  public final void vW(boolean paramBoolean)
  {
    this.EYo.value = paramBoolean;
  }
  
  public final void vX(boolean paramBoolean)
  {
    this.EYs.value = paramBoolean;
  }
  
  public final void vY(boolean paramBoolean)
  {
    this.EYv.value = paramBoolean;
  }
  
  public final void vZ(boolean paramBoolean)
  {
    this.EYy.value = paramBoolean;
  }
  
  public final void wa(boolean paramBoolean)
  {
    this.EYC.value = paramBoolean;
  }
  
  public static final class a
    extends g
  {
    public String EYF;
    public int EYG;
    public String EYH;
    public int EYI;
    public String EYJ;
    public String EYK;
    public a.b EYL;
    public a.b EYM;
    public a.b EYN;
    public a.b EYO;
    public String EYP;
    public long EYQ;
    public String iconUrl;
    public String jCX;
    public String lYC;
    public int uxt;
    
    public a()
    {
      AppMethodBeat.i(163209);
      this.EYL = new a.b();
      this.EYM = new a.b();
      this.EYN = new a.b();
      this.EYO = new a.b();
      AppMethodBeat.o(163209);
    }
  }
  
  public static final class b
  {
    public String desc;
    public String title;
  }
  
  public final class c
  {
    private boolean EYR;
    public boolean value;
    
    public c()
    {
      AppMethodBeat.i(31492);
      this.EYR = true;
      this.value = true;
      AppMethodBeat.o(31492);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.a
 * JD-Core Version:    0.7.0.1
 */