package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

final class BaseLifeUI$7
  implements b.a
{
  BaseLifeUI$7(BaseLifeUI paramBaseLifeUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(22948);
    if (this.pfa.eUJ)
    {
      AppMethodBeat.o(22948);
      return false;
    }
    if (this.pfa.dZw)
    {
      AppMethodBeat.o(22948);
      return false;
    }
    if (!paramBoolean)
    {
      if ((!BaseLifeUI.j(this.pfa)) && (!d.agR()))
      {
        BaseLifeUI.k(this.pfa);
        h.a(this.pfa, this.pfa.getString(2131300538), this.pfa.getString(2131297087), this.pfa.getString(2131300996), this.pfa.getString(2131296888), false, new BaseLifeUI.7.1(this), null);
      }
      AppMethodBeat.o(22948);
      return true;
    }
    o.a(2003, paramFloat1, paramFloat2, (int)paramDouble2);
    this.pfa.dZw = true;
    ab.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    this.pfa.peJ = new azt();
    this.pfa.peJ.wSm = "";
    this.pfa.peJ.wSn = 0;
    this.pfa.peJ.wDi = paramFloat2;
    this.pfa.peJ.wDh = paramFloat1;
    this.pfa.peJ.wSl = "";
    this.pfa.peJ.wSk = ((int)paramDouble2);
    this.pfa.peK = paramFloat2;
    this.pfa.peL = paramFloat1;
    this.pfa.peM = paramInt;
    this.pfa.peN = ((float)paramDouble2);
    Object localObject = this.pfa;
    label418:
    BaseLifeUI localBaseLifeUI;
    if (BaseLifeUI.l(this.pfa) == null)
    {
      paramBoolean = false;
      ((BaseLifeUI)localObject).fBM = paramBoolean;
      localObject = BaseLifeUI.f(this.pfa).per;
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label569;
      }
      localObject = (BackwardSupportUtil.ExifHelper.LatLongData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      this.pfa.p(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).cyV, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).fFN);
      this.pfa.peU = BaseLifeUI.h(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).cyV, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).fFN, paramFloat2, paramFloat1);
      BaseLifeUI.f(this.pfa).pev = new BackwardSupportUtil.ExifHelper.LatLongData(this.pfa.peJ.wDi, this.pfa.peJ.wDh);
      BaseLifeUI.b(this.pfa).pev = new BackwardSupportUtil.ExifHelper.LatLongData(this.pfa.peJ.wDi, this.pfa.peJ.wDh);
      localBaseLifeUI = this.pfa;
      if (!this.pfa.gzX) {
        break label583;
      }
    }
    label569:
    label583:
    for (localObject = BaseLifeUI.b(this.pfa);; localObject = BaseLifeUI.f(this.pfa))
    {
      BaseLifeUI.a(localBaseLifeUI, (a)localObject);
      BaseLifeUI.m(this.pfa);
      this.pfa.addSearchMenu(true, BaseLifeUI.i(this.pfa));
      AppMethodBeat.o(22948);
      return false;
      paramBoolean = BaseLifeUI.l(this.pfa).fBM;
      break;
      this.pfa.p(paramFloat2, paramFloat1);
      break label418;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.7
 * JD-Core Version:    0.7.0.1
 */