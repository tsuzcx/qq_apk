package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.g;
import java.util.ArrayList;

public final class a
{
  public final String TAG;
  private c YeA;
  c YeB;
  c YeC;
  c YeD;
  c YeE;
  c YeF;
  c YeG;
  c YeH;
  ArrayList<a> YeI;
  c Yee;
  c Yef;
  c Yeg;
  c Yeh;
  c Yei;
  c Yej;
  c Yek;
  c Yel;
  c Yem;
  c Yen;
  c Yeo;
  c Yep;
  c Yeq;
  c Yer;
  c Yes;
  c Yet;
  c Yeu;
  c Yev;
  public c Yew;
  c Yex;
  c Yey;
  public c Yez;
  
  public a()
  {
    AppMethodBeat.i(31493);
    this.TAG = "MircoMsg.AppPanelControl";
    this.Yee = new c();
    this.Yef = new c();
    this.Yeg = new c();
    this.Yeh = new c();
    this.Yei = new c();
    this.Yej = new c();
    this.Yek = new c();
    this.Yet = new c();
    this.Yer = new c();
    this.Yel = new c();
    this.Yem = new c();
    this.Yen = new c();
    this.Yeo = new c();
    this.Yep = new c();
    this.Yeq = new c();
    this.Yes = new c();
    this.Yeu = new c();
    this.Yev = new c();
    this.Yew = new c();
    this.Yex = new c();
    this.Yey = new c();
    this.Yez = new c();
    this.YeA = new c();
    this.YeB = new c();
    this.YeE = new c();
    this.YeF = new c();
    this.YeC = new c();
    this.YeD = new c();
    this.YeG = new c();
    this.YeH = new c();
    AppMethodBeat.o(31493);
  }
  
  public final void JP(boolean paramBoolean)
  {
    this.Yel.value = paramBoolean;
  }
  
  public final void JQ(boolean paramBoolean)
  {
    this.Yem.value = paramBoolean;
  }
  
  public final void JR(boolean paramBoolean)
  {
    this.Yeq.value = paramBoolean;
  }
  
  public final void JS(boolean paramBoolean)
  {
    this.Yeu.value = paramBoolean;
  }
  
  public final void JT(boolean paramBoolean)
  {
    this.Yex.value = paramBoolean;
  }
  
  public final void JU(boolean paramBoolean)
  {
    this.YeA.value = paramBoolean;
  }
  
  public final void JV(boolean paramBoolean)
  {
    this.YeE.value = paramBoolean;
  }
  
  public final void JW(boolean paramBoolean)
  {
    this.YeH.value = paramBoolean;
  }
  
  public final ArrayList<a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163211);
    if (this.YeI == null)
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(163211);
      return localArrayList;
    }
    ArrayList localArrayList = this.YeI;
    AppMethodBeat.o(163211);
    return localArrayList;
  }
  
  public final void iLS()
  {
    this.Yee.value = true;
    this.Yef.value = true;
    this.Yeg.value = true;
    this.Yeh.value = true;
    this.Yei.value = true;
    this.Yej.value = true;
    this.Yek.value = true;
    this.Yet.value = true;
    this.Yer.value = true;
    this.Yel.value = true;
    this.Yem.value = true;
    this.Yen.value = true;
    this.Yeo.value = true;
    this.Yep.value = true;
    this.Yeq.value = true;
    this.Yes.value = true;
    this.Yeu.value = true;
    this.Yev.value = false;
    this.Yew.value = true;
    this.Yex.value = true;
    this.Yez.value = true;
    this.YeA.value = true;
    this.Yez.value = false;
    this.YeF.value = false;
    this.YeB.value = true;
    this.YeC.value = true;
    this.YeD.value = true;
    this.YeG.value = true;
    this.YeH.value = true;
  }
  
  public final void iLT()
  {
    this.Yek.value = true;
  }
  
  public final void iLU()
  {
    this.Yes.value = true;
  }
  
  public static final class a
    extends g
  {
    public String PNd;
    public String YeJ;
    public String YeK;
    public String YeL;
    public int YeM;
    public String YeN;
    public String YeO;
    public a.b YeP;
    public a.b YeQ;
    public a.b YeR;
    public a.b YeS;
    public int YeT;
    public int YeU;
    public long YeV;
    public int YeW;
    public a YeX;
    public String icX;
    public String iconUrl;
    public int jump_type;
    public int red_dot;
    public String ttL;
    
    public a()
    {
      AppMethodBeat.i(163209);
      this.YeP = new a.b();
      this.YeQ = new a.b();
      this.YeR = new a.b();
      this.YeS = new a.b();
      AppMethodBeat.o(163209);
    }
    
    public static abstract interface a
    {
      public abstract String iLV();
    }
  }
  
  public static final class b
  {
    public String desc;
    public String title;
  }
  
  public final class c
  {
    private boolean YeY;
    public boolean value;
    
    public c()
    {
      AppMethodBeat.i(31492);
      this.YeY = true;
      this.value = true;
      AppMethodBeat.o(31492);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.a
 * JD-Core Version:    0.7.0.1
 */