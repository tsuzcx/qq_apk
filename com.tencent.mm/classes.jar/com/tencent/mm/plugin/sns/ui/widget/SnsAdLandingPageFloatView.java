package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsAdLandingPageFloatView
  extends FrameLayout
{
  public String cCo;
  public String cFe;
  public String heu;
  private boolean isResume;
  public ValueAnimator omt;
  public LinkedList<g> rLY;
  private List<h> rME;
  public String rMe;
  public String rpw;
  private Map<String, String> rti;
  public boolean sdt;
  public int smE;
  public String smF;
  public String smG;
  public r smH;
  public g smI;
  public h smJ;
  public View smK;
  public AnimatorSet smL;
  
  public SnsAdLandingPageFloatView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(40447);
    this.rLY = new LinkedList();
    this.rti = new HashMap();
    this.smL = new AnimatorSet();
    this.omt = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    AppMethodBeat.o(40447);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(40448);
    this.rLY = new LinkedList();
    this.rti = new HashMap();
    this.smL = new AnimatorSet();
    this.omt = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    AppMethodBeat.o(40448);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, -1);
    AppMethodBeat.i(40449);
    this.rLY = new LinkedList();
    this.rti = new HashMap();
    this.smL = new AnimatorSet();
    this.omt = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    AppMethodBeat.o(40449);
  }
  
  public final void cxD()
  {
    AppMethodBeat.i(40452);
    Map localMap;
    int i;
    if ((this.smI != null) && (!bo.isNullOrNil(this.rpw)))
    {
      localMap = br.F(this.rpw, "adCardItemList");
      i = 0;
      if (i <= 0) {
        break label196;
      }
    }
    label196:
    for (String str1 = ".adCardItemList.cardItem" + i;; str1 = ".adCardItemList.cardItem")
    {
      if (localMap.containsKey(str1 + ".cardTpId"))
      {
        String str2 = bo.bf((String)localMap.get(str1 + ".cardTpId"), "");
        str1 = bo.bf((String)localMap.get(str1 + ".cardExt"), "");
        if ((!bo.isNullOrNil(str2)) && (!bo.isNullOrNil(str1))) {
          this.rti.put(str2, str1);
        }
        i += 1;
        break;
      }
      AppMethodBeat.o(40452);
      return;
    }
  }
  
  public List<h> getAllComp()
  {
    AppMethodBeat.i(40453);
    if (this.rME != null)
    {
      localList = this.rME;
      AppMethodBeat.o(40453);
      return localList;
    }
    this.rME = new ArrayList();
    this.rME.add(this.smJ);
    i.df(this.rME);
    List localList = this.rME;
    AppMethodBeat.o(40453);
    return localList;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(40451);
    this.isResume = false;
    if (this.smI != null) {
      this.smJ.cqB();
    }
    AppMethodBeat.o(40451);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(40450);
    this.isResume = true;
    if (this.smI != null)
    {
      this.smJ.cqA();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40446);
          SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).cqC();
          AppMethodBeat.o(40446);
        }
      });
    }
    AppMethodBeat.o(40450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView
 * JD-Core Version:    0.7.0.1
 */