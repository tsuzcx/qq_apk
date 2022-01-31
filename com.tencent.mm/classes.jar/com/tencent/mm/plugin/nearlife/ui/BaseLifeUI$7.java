package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class BaseLifeUI$7
  implements a.a
{
  BaseLifeUI$7(BaseLifeUI paramBaseLifeUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (this.mEV.edT) {
      return false;
    }
    if (this.mEV.dic) {
      return false;
    }
    if (!paramBoolean) {
      return true;
    }
    o.a(2003, paramFloat1, paramFloat2, (int)paramDouble2);
    this.mEV.dic = true;
    y.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    this.mEV.mEG = new ato();
    this.mEV.mEG.sUp = "";
    this.mEV.mEG.sUq = 0;
    this.mEV.mEG.sGK = paramFloat2;
    this.mEV.mEG.sGJ = paramFloat1;
    this.mEV.mEG.sUo = "";
    this.mEV.mEG.sUn = ((int)paramDouble2);
    this.mEV.mEH = paramFloat2;
    this.mEV.mEI = paramFloat1;
    this.mEV.mEJ = paramInt;
    this.mEV.mEK = ((float)paramDouble2);
    Object localObject = this.mEV;
    label316:
    BaseLifeUI localBaseLifeUI;
    if (BaseLifeUI.j(this.mEV) == null)
    {
      paramBoolean = false;
      ((BaseLifeUI)localObject).elu = paramBoolean;
      localObject = BaseLifeUI.f(this.mEV).mEo;
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label460;
      }
      localObject = (BackwardSupportUtil.ExifHelper.LatLongData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      this.mEV.m(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).bRt, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).epo);
      this.mEV.mER = BaseLifeUI.f(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).bRt, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).epo, paramFloat2, paramFloat1);
      BaseLifeUI.f(this.mEV).mEs = new BackwardSupportUtil.ExifHelper.LatLongData(this.mEV.mEG.sGK, this.mEV.mEG.sGJ);
      BaseLifeUI.b(this.mEV).mEs = new BackwardSupportUtil.ExifHelper.LatLongData(this.mEV.mEG.sGK, this.mEV.mEG.sGJ);
      localBaseLifeUI = this.mEV;
      if (!this.mEV.fiq) {
        break label474;
      }
    }
    label460:
    label474:
    for (localObject = BaseLifeUI.b(this.mEV);; localObject = BaseLifeUI.f(this.mEV))
    {
      BaseLifeUI.a(localBaseLifeUI, (a)localObject);
      BaseLifeUI.k(this.mEV);
      this.mEV.a(BaseLifeUI.i(this.mEV));
      return false;
      paramBoolean = BaseLifeUI.j(this.mEV).elu;
      break;
      this.mEV.m(paramFloat2, paramFloat1);
      break label316;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.7
 * JD-Core Version:    0.7.0.1
 */