package com.tencent.mm.plugin.sns.ui;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.Map;

final class SnsAdNativeLandingPagesUI$12
  extends ViewPager.h
{
  SnsAdNativeLandingPagesUI$12(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void Q(int paramInt)
  {
    super.Q(paramInt);
    SnsAdNativeLandingPagesUI.i(this.oUU).oJu = paramInt;
    Object localObject;
    if (paramInt == 1)
    {
      paramInt = 0;
      while (paramInt < this.oUU.oUb.size())
      {
        localObject = (g)this.oUU.oUb.get(paramInt);
        localObject = (Fragment)SnsAdNativeLandingPagesUI.j(this.oUU).get(Integer.valueOf(((g)localObject).id));
        if (localObject != null) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b)localObject).bFP();
        }
        paramInt += 1;
      }
      ad.ee(this.oUU.mController.uMN);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = (Fragment)SnsAdNativeLandingPagesUI.j(this.oUU).get(Integer.valueOf(((g)this.oUU.oUb.get(SnsAdNativeLandingPagesUI.a(this.oUU).getCurrentItem())).id));
    } while (localObject == null);
    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b)localObject).bFQ();
  }
  
  public final void R(int paramInt)
  {
    super.R(paramInt);
    int i = 0;
    if (i < this.oUU.oUb.size())
    {
      Object localObject = (g)this.oUU.oUb.get(i);
      localObject = (Fragment)SnsAdNativeLandingPagesUI.j(this.oUU).get(Integer.valueOf(((g)localObject).id));
      if (localObject != null)
      {
        if (i != paramInt) {
          break label82;
        }
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b)localObject).bFQ();
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b)localObject).bFP();
      }
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    super.a(paramInt1, paramFloat, paramInt2);
    if (SnsAdNativeLandingPagesUI.i(this.oUU) != null)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b localb = SnsAdNativeLandingPagesUI.i(this.oUU);
      if (localb.oJm != null) {
        localb.oJm.bFH();
      }
    }
    if (this.oUU.mController.uNh == 1) {
      this.oUU.XM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.12
 * JD-Core Version:    0.7.0.1
 */