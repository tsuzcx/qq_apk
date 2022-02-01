package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.g;
import java.util.ArrayList;

public final class a
{
  c FqA;
  c FqB;
  c FqC;
  c FqD;
  c FqE;
  c FqF;
  c FqG;
  c FqH;
  c FqI;
  c FqJ;
  c FqK;
  c FqL;
  c FqM;
  c FqN;
  public c FqO;
  c FqP;
  c FqQ;
  public c FqR;
  private c FqS;
  c FqT;
  c FqU;
  c FqV;
  c FqW;
  c FqX;
  ArrayList<a> FqY;
  c Fqw;
  c Fqx;
  c Fqy;
  c Fqz;
  public final String TAG;
  
  public a()
  {
    AppMethodBeat.i(31493);
    this.TAG = "MircoMsg.AppPanelControl";
    this.Fqw = new c();
    this.Fqx = new c();
    this.Fqy = new c();
    this.Fqz = new c();
    this.FqA = new c();
    this.FqB = new c();
    this.FqC = new c();
    this.FqL = new c();
    this.FqJ = new c();
    this.FqD = new c();
    this.FqE = new c();
    this.FqF = new c();
    this.FqG = new c();
    this.FqH = new c();
    this.FqI = new c();
    this.FqK = new c();
    this.FqM = new c();
    this.FqN = new c();
    this.FqO = new c();
    this.FqP = new c();
    this.FqQ = new c();
    this.FqR = new c();
    this.FqS = new c();
    this.FqT = new c();
    this.FqW = new c();
    this.FqX = new c();
    this.FqU = new c();
    this.FqV = new c();
    AppMethodBeat.o(31493);
  }
  
  public final void fgV()
  {
    this.Fqw.value = true;
    this.Fqx.value = true;
    this.Fqy.value = true;
    this.Fqz.value = true;
    this.FqA.value = true;
    this.FqB.value = true;
    this.FqC.value = true;
    this.FqL.value = true;
    this.FqJ.value = true;
    this.FqD.value = true;
    this.FqE.value = true;
    this.FqF.value = true;
    this.FqG.value = true;
    this.FqH.value = true;
    this.FqI.value = true;
    this.FqK.value = true;
    this.FqM.value = true;
    this.FqN.value = false;
    this.FqO.value = true;
    this.FqP.value = true;
    this.FqR.value = true;
    this.FqS.value = true;
    this.FqR.value = false;
    this.FqX.value = false;
    this.FqT.value = true;
    this.FqU.value = true;
    this.FqV.value = true;
  }
  
  public final void fgW()
  {
    this.FqC.value = true;
  }
  
  public final void fgX()
  {
    this.FqK.value = true;
  }
  
  public final ArrayList<a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163211);
    if (this.FqY == null)
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(163211);
      return localArrayList;
    }
    ArrayList localArrayList = this.FqY;
    AppMethodBeat.o(163211);
    return localArrayList;
  }
  
  public final void wc(boolean paramBoolean)
  {
    this.FqD.value = paramBoolean;
  }
  
  public final void wd(boolean paramBoolean)
  {
    this.FqE.value = paramBoolean;
  }
  
  public final void we(boolean paramBoolean)
  {
    this.FqI.value = paramBoolean;
  }
  
  public final void wf(boolean paramBoolean)
  {
    this.FqM.value = paramBoolean;
  }
  
  public final void wg(boolean paramBoolean)
  {
    this.FqP.value = paramBoolean;
  }
  
  public final void wh(boolean paramBoolean)
  {
    this.FqS.value = paramBoolean;
  }
  
  public final void wi(boolean paramBoolean)
  {
    this.FqW.value = paramBoolean;
  }
  
  public static final class a
    extends g
  {
    public String FqZ;
    public int Fra;
    public String Frb;
    public String Frc;
    public int Frd;
    public String Fre;
    public String Frf;
    public a.b Frg;
    public a.b Frh;
    public a.b Fri;
    public a.b Frj;
    public String Frk;
    public int Frl;
    public int Frm;
    public long Frn;
    public a Fro;
    public String iconUrl;
    public String jFV;
    public String mdj;
    public int uIW;
    
    public a()
    {
      AppMethodBeat.i(163209);
      this.Frg = new a.b();
      this.Frh = new a.b();
      this.Fri = new a.b();
      this.Frj = new a.b();
      AppMethodBeat.o(163209);
    }
    
    public static abstract interface a
    {
      public abstract String fgY();
    }
  }
  
  public static final class b
  {
    public String desc;
    public String title;
  }
  
  public final class c
  {
    private boolean Frp;
    public boolean value;
    
    public c()
    {
      AppMethodBeat.i(31492);
      this.Frp = true;
      this.value = true;
      AppMethodBeat.o(31492);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.a
 * JD-Core Version:    0.7.0.1
 */