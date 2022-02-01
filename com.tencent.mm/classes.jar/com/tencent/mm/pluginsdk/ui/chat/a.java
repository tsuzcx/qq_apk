package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
{
  a.c CaH;
  a.c CaI;
  public a.c CaJ;
  a.c CaK;
  a.c CaL;
  a.c CaM;
  a.c CaN;
  a.c CaO;
  a.c CaP;
  a.c CaQ;
  a.c CaR;
  a.c CaS;
  a.c CaT;
  a.c CaU;
  a.c CaV;
  a.c CaW;
  a.c CaX;
  a.c CaY;
  public a.c CaZ;
  a.c Cba;
  a.c Cbb;
  public a.c Cbc;
  private a.c Cbd;
  a.c Cbe;
  a.c Cbf;
  a.c Cbg;
  ArrayList<a.a> Cbh;
  a.c Lwz;
  public final String TAG;
  
  public a()
  {
    AppMethodBeat.i(31493);
    this.TAG = "MircoMsg.AppPanelControl";
    this.CaH = new a.c(this);
    this.CaI = new a.c(this);
    this.CaJ = new a.c(this);
    this.CaK = new a.c(this);
    this.CaL = new a.c(this);
    this.CaM = new a.c(this);
    this.CaN = new a.c(this);
    this.CaW = new a.c(this);
    this.CaU = new a.c(this);
    this.CaO = new a.c(this);
    this.CaP = new a.c(this);
    this.CaQ = new a.c(this);
    this.CaR = new a.c(this);
    this.CaS = new a.c(this);
    this.CaT = new a.c(this);
    this.CaV = new a.c(this);
    this.CaX = new a.c(this);
    this.CaY = new a.c(this);
    this.CaZ = new a.c(this);
    this.Cba = new a.c(this);
    this.Cbb = new a.c(this);
    this.Cbc = new a.c(this);
    this.Cbd = new a.c(this);
    this.Cbe = new a.c(this);
    this.Lwz = new a.c(this);
    this.Cbf = new a.c(this);
    this.Cbg = new a.c(this);
    AppMethodBeat.o(31493);
  }
  
  public final void eyN()
  {
    this.CaH.value = true;
    this.CaI.value = true;
    this.CaJ.value = true;
    this.CaK.value = true;
    this.CaL.value = true;
    this.CaM.value = true;
    this.CaN.value = true;
    this.CaW.value = true;
    this.CaU.value = true;
    this.CaO.value = true;
    this.CaP.value = true;
    this.CaQ.value = true;
    this.CaR.value = true;
    this.CaS.value = true;
    this.CaT.value = true;
    this.CaV.value = true;
    this.CaX.value = true;
    this.CaY.value = false;
    this.CaZ.value = true;
    this.Cba.value = true;
    this.Cbc.value = true;
    this.Cbd.value = true;
    this.Cbc.value = false;
    this.Cbe.value = true;
    this.Cbf.value = true;
    this.Cbg.value = true;
  }
  
  public final void eyO()
  {
    this.CaN.value = true;
  }
  
  public final void eyP()
  {
    this.CaV.value = true;
  }
  
  public final int eyQ()
  {
    AppMethodBeat.i(163210);
    if (this.Cbh != null)
    {
      int i = this.Cbh.size();
      AppMethodBeat.o(163210);
      return i;
    }
    AppMethodBeat.o(163210);
    return 0;
  }
  
  public final ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163211);
    if (this.Cbh == null)
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(163211);
      return localArrayList;
    }
    ArrayList localArrayList = this.Cbh;
    AppMethodBeat.o(163211);
    return localArrayList;
  }
  
  public final void uh(boolean paramBoolean)
  {
    this.CaO.value = paramBoolean;
  }
  
  public final void ui(boolean paramBoolean)
  {
    this.CaP.value = paramBoolean;
  }
  
  public final void uj(boolean paramBoolean)
  {
    this.CaT.value = paramBoolean;
  }
  
  public final void uk(boolean paramBoolean)
  {
    this.CaX.value = paramBoolean;
  }
  
  public final void ul(boolean paramBoolean)
  {
    this.Cba.value = paramBoolean;
  }
  
  public final void um(boolean paramBoolean)
  {
    this.Cbd.value = paramBoolean;
  }
  
  public final void zh(boolean paramBoolean)
  {
    this.Lwz.value = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.a
 * JD-Core Version:    0.7.0.1
 */