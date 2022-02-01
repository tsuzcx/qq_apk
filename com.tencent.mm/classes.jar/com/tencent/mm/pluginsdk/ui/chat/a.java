package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.g;
import java.util.ArrayList;

public final class a
{
  c DsY;
  c DsZ;
  public c Dta;
  c Dtb;
  c Dtc;
  c Dtd;
  c Dte;
  c Dtf;
  c Dtg;
  c Dth;
  c Dti;
  c Dtj;
  c Dtk;
  c Dtl;
  c Dtm;
  c Dtn;
  c Dto;
  c Dtp;
  public c Dtq;
  c Dtr;
  c Dts;
  public c Dtt;
  private c Dtu;
  c Dtv;
  c Dtw;
  c Dtx;
  c Dty;
  ArrayList<a> Dtz;
  public final String TAG;
  
  public a()
  {
    AppMethodBeat.i(31493);
    this.TAG = "MircoMsg.AppPanelControl";
    this.DsY = new c();
    this.DsZ = new c();
    this.Dta = new c();
    this.Dtb = new c();
    this.Dtc = new c();
    this.Dtd = new c();
    this.Dte = new c();
    this.Dtn = new c();
    this.Dtl = new c();
    this.Dtf = new c();
    this.Dtg = new c();
    this.Dth = new c();
    this.Dti = new c();
    this.Dtj = new c();
    this.Dtk = new c();
    this.Dtm = new c();
    this.Dto = new c();
    this.Dtp = new c();
    this.Dtq = new c();
    this.Dtr = new c();
    this.Dts = new c();
    this.Dtt = new c();
    this.Dtu = new c();
    this.Dtv = new c();
    this.Dty = new c();
    this.Dtw = new c();
    this.Dtx = new c();
    AppMethodBeat.o(31493);
  }
  
  public final void eOi()
  {
    this.DsY.value = true;
    this.DsZ.value = true;
    this.Dta.value = true;
    this.Dtb.value = true;
    this.Dtc.value = true;
    this.Dtd.value = true;
    this.Dte.value = true;
    this.Dtn.value = true;
    this.Dtl.value = true;
    this.Dtf.value = true;
    this.Dtg.value = true;
    this.Dth.value = true;
    this.Dti.value = true;
    this.Dtj.value = true;
    this.Dtk.value = true;
    this.Dtm.value = true;
    this.Dto.value = true;
    this.Dtp.value = false;
    this.Dtq.value = true;
    this.Dtr.value = true;
    this.Dtt.value = true;
    this.Dtu.value = true;
    this.Dtt.value = false;
    this.Dtv.value = true;
    this.Dtw.value = true;
    this.Dtx.value = true;
  }
  
  public final void eOj()
  {
    this.Dte.value = true;
  }
  
  public final void eOk()
  {
    this.Dtm.value = true;
  }
  
  public final ArrayList<a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163211);
    if (this.Dtz == null)
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(163211);
      return localArrayList;
    }
    ArrayList localArrayList = this.Dtz;
    AppMethodBeat.o(163211);
    return localArrayList;
  }
  
  public final void vi(boolean paramBoolean)
  {
    this.Dtf.value = paramBoolean;
  }
  
  public final void vj(boolean paramBoolean)
  {
    this.Dtg.value = paramBoolean;
  }
  
  public final void vk(boolean paramBoolean)
  {
    this.Dtk.value = paramBoolean;
  }
  
  public final void vl(boolean paramBoolean)
  {
    this.Dto.value = paramBoolean;
  }
  
  public final void vm(boolean paramBoolean)
  {
    this.Dtr.value = paramBoolean;
  }
  
  public final void vn(boolean paramBoolean)
  {
    this.Dtu.value = paramBoolean;
  }
  
  public final void vo(boolean paramBoolean)
  {
    this.Dty.value = paramBoolean;
  }
  
  public static final class a
    extends g
  {
    public String DtA;
    public int DtB;
    public String DtC;
    public int DtD;
    public String DtE;
    public String DtF;
    public a.b DtG;
    public a.b DtH;
    public a.b DtI;
    public a.b DtJ;
    public String DtK;
    public long DtL;
    public String iconUrl;
    public String jjp;
    public String lze;
    public int vjP;
    
    public a()
    {
      AppMethodBeat.i(163209);
      this.DtG = new a.b();
      this.DtH = new a.b();
      this.DtI = new a.b();
      this.DtJ = new a.b();
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
    private boolean DtM;
    public boolean value;
    
    public c()
    {
      AppMethodBeat.i(31492);
      this.DtM = true;
      this.value = true;
      AppMethodBeat.o(31492);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.a
 * JD-Core Version:    0.7.0.1
 */