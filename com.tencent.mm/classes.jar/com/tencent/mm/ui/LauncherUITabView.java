package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class LauncherUITabView
  extends RelativeLayout
  implements c
{
  private int BTn;
  private int OEA;
  private int OEB;
  private boolean OEC;
  private int OEE;
  private boolean OEF;
  private int OEN;
  private Bitmap OEO;
  private ImageView OEP;
  protected a OEQ;
  protected a OER;
  protected a OES;
  protected a OET;
  private c.a OEg;
  protected View.OnClickListener OEw;
  private MMHandler OEx;
  private LinearLayout OEy;
  private int OEz;
  private Matrix gT;
  protected int sTB;
  private long xUW;
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33371);
    this.sTB = 0;
    this.gT = new Matrix();
    this.xUW = 0L;
    this.BTn = -1;
    this.OEw = new View.OnClickListener()
    {
      private final long EKO = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          EventCenter.instance.publish(new mh());
          LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
          LauncherUITabView.a(LauncherUITabView.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33369);
          return;
        }
        if (LauncherUITabView.d(LauncherUITabView.this) != null)
        {
          if ((i != 0) || (LauncherUITabView.a(LauncherUITabView.this) != 0))
          {
            LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
            LauncherUITabView.a(LauncherUITabView.this, i);
            LauncherUITabView.d(LauncherUITabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33369);
            return;
          }
          LauncherUITabView.c(LauncherUITabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
        LauncherUITabView.a(LauncherUITabView.this, i);
        Log.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33369);
      }
    };
    this.OEx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.OEz = 0;
    this.OEA = 0;
    this.OEB = 0;
    this.OEE = 0;
    this.OEC = false;
    this.OEF = false;
    init();
    AppMethodBeat.o(33371);
  }
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33372);
    this.sTB = 0;
    this.gT = new Matrix();
    this.xUW = 0L;
    this.BTn = -1;
    this.OEw = new View.OnClickListener()
    {
      private final long EKO = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          EventCenter.instance.publish(new mh());
          LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
          LauncherUITabView.a(LauncherUITabView.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33369);
          return;
        }
        if (LauncherUITabView.d(LauncherUITabView.this) != null)
        {
          if ((i != 0) || (LauncherUITabView.a(LauncherUITabView.this) != 0))
          {
            LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
            LauncherUITabView.a(LauncherUITabView.this, i);
            LauncherUITabView.d(LauncherUITabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33369);
            return;
          }
          LauncherUITabView.c(LauncherUITabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
        LauncherUITabView.a(LauncherUITabView.this, i);
        Log.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33369);
      }
    };
    this.OEx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.OEz = 0;
    this.OEA = 0;
    this.OEB = 0;
    this.OEE = 0;
    this.OEC = false;
    this.OEF = false;
    init();
    AppMethodBeat.o(33372);
  }
  
  private a akT(int paramInt)
  {
    AppMethodBeat.i(33373);
    a locala = new a();
    locala.OEV = new MMTabView(getContext(), paramInt);
    locala.OEV.setTag(Integer.valueOf(paramInt));
    locala.OEV.setOnClickListener(this.OEw);
    AppMethodBeat.o(33373);
    return locala;
  }
  
  private a f(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33374);
    a locala = akT(0);
    locala.OEV.setText(2131762818);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131167063));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.OEV, localLayoutParams);
    AppMethodBeat.o(33374);
    return locala;
  }
  
  private a g(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33375);
    a locala = akT(1);
    locala.OEV.setText(2131762819);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131167063));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.OEV, localLayoutParams);
    AppMethodBeat.o(33375);
    return locala;
  }
  
  private void gIA()
  {
    AppMethodBeat.i(33378);
    this.OEP = new ImageView(getContext());
    this.OEP.setImageMatrix(this.gT);
    this.OEP.setScaleType(ImageView.ScaleType.MATRIX);
    this.OEP.setId(2307142);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2307141);
    addView(this.OEP, localLayoutParams);
    AppMethodBeat.o(33378);
  }
  
  private a h(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33376);
    a locala = akT(2);
    locala.OEV.setText(2131762817);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131167063));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.OEV, localLayoutParams);
    AppMethodBeat.o(33376);
    return locala;
  }
  
  private a i(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33377);
    a locala = akT(3);
    locala.OEV.setText(2131762857);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131167063));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.OEV, localLayoutParams);
    AppMethodBeat.o(33377);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33379);
    this.OEy = new LinearLayout(getContext());
    this.OEy.setBackgroundColor(getContext().getResources().getColor(2131099649));
    this.OEy.setId(2307141);
    this.OEy.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.OEy, localLayoutParams);
    gIA();
    this.OEQ = f(this.OEy);
    this.OER = g(this.OEy);
    this.OES = h(this.OEy);
    this.OET = i(this.OEy);
    AppMethodBeat.o(33379);
  }
  
  public final void AT(boolean paramBoolean)
  {
    AppMethodBeat.i(33386);
    this.OEC = paramBoolean;
    this.OES.OEV.Bk(paramBoolean);
    AppMethodBeat.o(33386);
  }
  
  public final void AU(boolean paramBoolean)
  {
    AppMethodBeat.i(33387);
    this.OEF = paramBoolean;
    this.OET.OEV.Bk(paramBoolean);
    AppMethodBeat.o(33387);
  }
  
  public final void akH(int paramInt)
  {
    AppMethodBeat.i(33381);
    Log.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.OEz = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.OEQ.OEV.setUnread(getContext().getString(2131766913));
        AppMethodBeat.o(33381);
        return;
      }
      this.OEQ.OEV.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33381);
      return;
    }
    this.OEQ.OEV.setUnread(null);
    AppMethodBeat.o(33381);
  }
  
  public final void akI(int paramInt)
  {
    AppMethodBeat.i(33383);
    this.OEA = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.OER.OEV.setUnread(getContext().getString(2131766913));
        AppMethodBeat.o(33383);
        return;
      }
      this.OER.OEV.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33383);
      return;
    }
    this.OER.OEV.setUnread(null);
    AppMethodBeat.o(33383);
  }
  
  public final void akJ(int paramInt)
  {
    AppMethodBeat.i(33384);
    this.OEB = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.OES.OEV.setUnread(getContext().getString(2131766913));
        AppMethodBeat.o(33384);
        return;
      }
      this.OES.OEV.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33384);
      return;
    }
    this.OES.OEV.setUnread(null);
    AppMethodBeat.o(33384);
  }
  
  public final void akK(int paramInt)
  {
    AppMethodBeat.i(33385);
    this.OEE = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.OET.OEV.setUnread(getContext().getString(2131766913));
        AppMethodBeat.o(33385);
        return;
      }
      this.OET.OEV.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33385);
      return;
    }
    this.OET.OEV.setUnread(null);
    AppMethodBeat.o(33385);
  }
  
  public final void gGO()
  {
    AppMethodBeat.i(33382);
    if ((this.OEQ == null) || (this.OER == null) || (this.OES == null) || (this.OET == null))
    {
      AppMethodBeat.o(33382);
      return;
    }
    this.OEQ.OEV.gIW();
    this.OER.OEV.gIW();
    this.OES.OEV.gIW();
    this.OET.OEV.gIW();
    AppMethodBeat.o(33382);
  }
  
  public int getContactTabUnread()
  {
    return this.OEA;
  }
  
  public int getCurIdx()
  {
    return this.sTB;
  }
  
  public int getFriendTabUnread()
  {
    return this.OEB;
  }
  
  public int getMainTabUnread()
  {
    return this.OEz;
  }
  
  public boolean getSettingsPoint()
  {
    return this.OEF;
  }
  
  public int getSettingsTabUnread()
  {
    return this.OEE;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.OEC;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(33380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[] { Integer.valueOf(paramInt3 - paramInt1) });
    this.OEN = ((paramInt3 - paramInt1) / 4);
    paramInt2 = this.OEN;
    if ((this.OEO == null) || (this.OEO.getWidth() != paramInt2)) {
      if (this.OEO != null) {
        break label187;
      }
    }
    label187:
    for (paramInt1 = -1;; paramInt1 = this.OEO.getWidth())
    {
      Log.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.OEO = Bitmap.createBitmap(paramInt2, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.OEO).drawColor(getResources().getColor(2131101414));
      p(this.sTB, 0.0F);
      this.OEP.setImageBitmap(this.OEO);
      setTo(this.sTB);
      AppMethodBeat.o(33380);
      return;
    }
  }
  
  public final void p(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33388);
    this.gT.setTranslate(this.OEN * (paramInt + paramFloat), 0.0F);
    this.OEP.setImageMatrix(this.gT);
    AppMethodBeat.o(33388);
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.OEg = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33389);
    this.sTB = paramInt;
    MMTabView localMMTabView = this.OEQ.OEV;
    int i;
    if (paramInt == 0)
    {
      i = getResources().getColor(2131101414);
      localMMTabView.setTextColor(i);
      localMMTabView = this.OER.OEV;
      if (paramInt != 1) {
        break label165;
      }
      i = getResources().getColor(2131101414);
      label63:
      localMMTabView.setTextColor(i);
      localMMTabView = this.OES.OEV;
      if (paramInt != 2) {
        break label182;
      }
      i = getResources().getColor(2131101414);
      label92:
      localMMTabView.setTextColor(i);
      localMMTabView = this.OET.OEV;
      if (paramInt != 3) {
        break label199;
      }
    }
    label165:
    label182:
    label199:
    for (paramInt = getResources().getColor(2131101414);; paramInt = getContext().getResources().getColor(2131099746))
    {
      localMMTabView.setTextColor(paramInt);
      this.xUW = System.currentTimeMillis();
      this.BTn = this.sTB;
      AppMethodBeat.o(33389);
      return;
      i = getContext().getResources().getColor(2131099746);
      break;
      i = getContext().getResources().getColor(2131099746);
      break label63;
      i = getContext().getResources().getColor(2131099746);
      break label92;
    }
  }
  
  protected final class a
  {
    MMTabView OEV;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView
 * JD-Core Version:    0.7.0.1
 */