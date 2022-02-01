package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import com.tencent.mm.g.a.th;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsAdLandingPageFloatView
  extends FrameLayout
{
  public String dqx;
  public String dtx;
  private boolean isResume;
  public String jyU;
  public ValueAnimator ukz;
  private List<k> yGM;
  public String yGm;
  public boolean yZo;
  public String yeP;
  private Map<String, String> ykd;
  public LinkedList<g> yuE;
  public int zkd;
  public String zke;
  public String zkf;
  public v zkg;
  public g zkh;
  public k zki;
  public View zkj;
  public AnimatorSet zkk;
  
  public SnsAdLandingPageFloatView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(100462);
    this.yuE = new LinkedList();
    this.ykd = new HashMap();
    this.zkk = new AnimatorSet();
    this.ukz = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    AppMethodBeat.o(100462);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(100463);
    this.yuE = new LinkedList();
    this.ykd = new HashMap();
    this.zkk = new AnimatorSet();
    this.ukz = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    AppMethodBeat.o(100463);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, -1);
    AppMethodBeat.i(100464);
    this.yuE = new LinkedList();
    this.ykd = new HashMap();
    this.zkk = new AnimatorSet();
    this.ukz = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    AppMethodBeat.o(100464);
  }
  
  public final void dSA()
  {
    AppMethodBeat.i(100467);
    Map localMap;
    int i;
    if ((this.zkh != null) && (!bs.isNullOrNil(this.yeP)))
    {
      localMap = bv.L(this.yeP, "adCardItemList");
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
        String str2 = bs.bG((String)localMap.get(str1 + ".cardTpId"), "");
        str1 = bs.bG((String)localMap.get(str1 + ".cardExt"), "");
        if ((!bs.isNullOrNil(str2)) && (!bs.isNullOrNil(str1))) {
          this.ykd.put(str2, str1);
        }
        i += 1;
        break;
      }
      AppMethodBeat.o(100467);
      return;
    }
  }
  
  public List<k> getAllComp()
  {
    AppMethodBeat.i(100468);
    if (this.yGM != null)
    {
      localList = this.yGM;
      AppMethodBeat.o(100468);
      return localList;
    }
    this.yGM = new ArrayList();
    this.yGM.add(this.zki);
    i.fD(this.yGM);
    List localList = this.yGM;
    AppMethodBeat.o(100468);
    return localList;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(100466);
    this.isResume = false;
    if (this.zkh != null) {
      this.zki.dJZ();
    }
    AppMethodBeat.o(100466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100465);
    this.isResume = true;
    if (this.zkh != null)
    {
      this.zki.dJY();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100461);
          SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).dKa();
          AppMethodBeat.o(100461);
        }
      });
    }
    AppMethodBeat.o(100465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView
 * JD-Core Version:    0.7.0.1
 */