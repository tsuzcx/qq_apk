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
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsAdLandingPageFloatView
  extends FrameLayout
{
  public String dsN;
  public String dvK;
  public String iYE;
  private boolean isResume;
  public ValueAnimator tck;
  public String wSj;
  private Map<String, String> wXp;
  public boolean xMz;
  public int xXi;
  public String xXj;
  public String xXk;
  public v xXl;
  public g xXm;
  public k xXn;
  public View xXo;
  public AnimatorSet xXp;
  public LinkedList<g> xhQ;
  private List<k> xtW;
  public String xtw;
  
  public SnsAdLandingPageFloatView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(100462);
    this.xhQ = new LinkedList();
    this.wXp = new HashMap();
    this.xXp = new AnimatorSet();
    this.tck = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    AppMethodBeat.o(100462);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(100463);
    this.xhQ = new LinkedList();
    this.wXp = new HashMap();
    this.xXp = new AnimatorSet();
    this.tck = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    AppMethodBeat.o(100463);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, -1);
    AppMethodBeat.i(100464);
    this.xhQ = new LinkedList();
    this.wXp = new HashMap();
    this.xXp = new AnimatorSet();
    this.tck = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    AppMethodBeat.o(100464);
  }
  
  public final void dEc()
  {
    AppMethodBeat.i(100467);
    Map localMap;
    int i;
    if ((this.xXm != null) && (!bt.isNullOrNil(this.wSj)))
    {
      localMap = bw.K(this.wSj, "adCardItemList");
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
        String str2 = bt.by((String)localMap.get(str1 + ".cardTpId"), "");
        str1 = bt.by((String)localMap.get(str1 + ".cardExt"), "");
        if ((!bt.isNullOrNil(str2)) && (!bt.isNullOrNil(str1))) {
          this.wXp.put(str2, str1);
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
    if (this.xtW != null)
    {
      localList = this.xtW;
      AppMethodBeat.o(100468);
      return localList;
    }
    this.xtW = new ArrayList();
    this.xtW.add(this.xXn);
    i.fv(this.xtW);
    List localList = this.xtW;
    AppMethodBeat.o(100468);
    return localList;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(100466);
    this.isResume = false;
    if (this.xXm != null) {
      this.xXn.dvA();
    }
    AppMethodBeat.o(100466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100465);
    this.isResume = true;
    if (this.xXm != null)
    {
      this.xXn.dvz();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100461);
          SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).dvB();
          AppMethodBeat.o(100461);
        }
      });
    }
    AppMethodBeat.o(100465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView
 * JD-Core Version:    0.7.0.1
 */