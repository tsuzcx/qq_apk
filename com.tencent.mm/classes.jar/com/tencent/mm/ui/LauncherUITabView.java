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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.tools.v;

public class LauncherUITabView
  extends RelativeLayout
  implements d
{
  private long ITx;
  private int NMH;
  private d.a adBV;
  private int adCB;
  private Bitmap adCC;
  private ImageView adCD;
  protected a adCE;
  protected a adCF;
  protected a adCG;
  protected a adCH;
  protected View.OnClickListener adCl;
  private MMHandler adCm;
  private LinearLayout adCn;
  private int adCo;
  private int adCp;
  private int adCq;
  private boolean adCr;
  private int adCt;
  private boolean adCu;
  private boolean akmi;
  private Matrix matrix;
  protected int zVI;
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33371);
    this.zVI = 0;
    this.matrix = new Matrix();
    this.ITx = 0L;
    this.NMH = -1;
    this.adCl = new View.OnClickListener()
    {
      private final long WZx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          ((com.tencent.mm.u.a)MvvmEventCenter.getEvent(com.tencent.mm.u.a.class)).publish(Integer.valueOf(0));
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
    this.adCm = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.adCo = 0;
    this.adCp = 0;
    this.adCq = 0;
    this.adCt = 0;
    this.adCr = false;
    this.akmi = false;
    this.adCu = false;
    init();
    AppMethodBeat.o(33371);
  }
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33372);
    this.zVI = 0;
    this.matrix = new Matrix();
    this.ITx = 0L;
    this.NMH = -1;
    this.adCl = new View.OnClickListener()
    {
      private final long WZx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          ((com.tencent.mm.u.a)MvvmEventCenter.getEvent(com.tencent.mm.u.a.class)).publish(Integer.valueOf(0));
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
    this.adCm = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.adCo = 0;
    this.adCp = 0;
    this.adCq = 0;
    this.adCt = 0;
    this.adCr = false;
    this.akmi = false;
    this.adCu = false;
    init();
    AppMethodBeat.o(33372);
  }
  
  private a aAf(int paramInt)
  {
    AppMethodBeat.i(33373);
    a locala = new a();
    locala.adCJ = new MMTabView(getContext(), paramInt);
    locala.adCJ.setTag(Integer.valueOf(paramInt));
    locala.adCJ.setOnClickListener(this.adCl);
    AppMethodBeat.o(33373);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33379);
    this.adCn = new LinearLayout(getContext());
    this.adCn.setBackgroundColor(getContext().getResources().getColor(R.e.BG_1));
    this.adCn.setId(2307141);
    this.adCn.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.adCn, localLayoutParams);
    jjw();
    this.adCE = l(this.adCn);
    this.adCF = m(this.adCn);
    this.adCG = n(this.adCn);
    this.adCH = o(this.adCn);
    AppMethodBeat.o(33379);
  }
  
  private void jjw()
  {
    AppMethodBeat.i(33378);
    this.adCD = new ImageView(getContext());
    this.adCD.setImageMatrix(this.matrix);
    this.adCD.setScaleType(ImageView.ScaleType.MATRIX);
    this.adCD.setId(2307142);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2307141);
    addView(this.adCD, localLayoutParams);
    AppMethodBeat.o(33378);
  }
  
  private a l(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33374);
    a locala = aAf(0);
    locala.adCJ.setText(R.l.gMT);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.adCJ, localLayoutParams);
    AppMethodBeat.o(33374);
    return locala;
  }
  
  private a m(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33375);
    a locala = aAf(1);
    locala.adCJ.setText(R.l.gMU);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.adCJ, localLayoutParams);
    AppMethodBeat.o(33375);
    return locala;
  }
  
  private a n(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33376);
    a locala = aAf(2);
    locala.adCJ.setText(R.l.gMS);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.adCJ, localLayoutParams);
    AppMethodBeat.o(33376);
    return locala;
  }
  
  private a o(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33377);
    a locala = aAf(3);
    locala.adCJ.setText(R.l.gNo);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.adCJ, localLayoutParams);
    AppMethodBeat.o(33377);
    return locala;
  }
  
  public final void KT(boolean paramBoolean)
  {
    AppMethodBeat.i(33386);
    if (this.akmi)
    {
      Log.i("MicroMsg.LauncherUITabView", "showFriendPoint return for finderTextPoint");
      AppMethodBeat.o(33386);
      return;
    }
    this.adCr = paramBoolean;
    this.adCG.adCJ.ol(paramBoolean);
    AppMethodBeat.o(33386);
  }
  
  public final void KU(boolean paramBoolean)
  {
    AppMethodBeat.i(33387);
    this.adCu = paramBoolean;
    this.adCH.adCJ.ol(paramBoolean);
    AppMethodBeat.o(33387);
  }
  
  public final void aX(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(369620);
    Log.i("MicroMsg.LauncherUITabView", "showFriendTextPoint show:" + paramBoolean + "  text:" + paramString);
    this.adCr = paramBoolean;
    this.akmi = paramBoolean;
    if (paramBoolean)
    {
      this.adCG.adCJ.kb(paramString, v.bC(getContext(), Integer.parseInt("20")));
      AppMethodBeat.o(369620);
      return;
    }
    if (this.adCq > 0)
    {
      azU(this.adCq);
      AppMethodBeat.o(369620);
      return;
    }
    this.adCG.adCJ.setUnread("");
    AppMethodBeat.o(369620);
  }
  
  public final void azS(int paramInt)
  {
    AppMethodBeat.i(33381);
    Log.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.adCo = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.adCE.adCJ.setUnread(getContext().getString(R.l.unread_count_overt_100));
        AppMethodBeat.o(33381);
        return;
      }
      this.adCE.adCJ.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33381);
      return;
    }
    this.adCE.adCJ.setUnread(null);
    AppMethodBeat.o(33381);
  }
  
  public final void azT(int paramInt)
  {
    AppMethodBeat.i(33383);
    this.adCp = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.adCF.adCJ.setUnread(getContext().getString(R.l.unread_count_overt_100));
        AppMethodBeat.o(33383);
        return;
      }
      this.adCF.adCJ.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33383);
      return;
    }
    this.adCF.adCJ.setUnread(null);
    AppMethodBeat.o(33383);
  }
  
  public final void azU(int paramInt)
  {
    AppMethodBeat.i(33384);
    this.adCq = paramInt;
    if (this.akmi)
    {
      Log.i("MicroMsg.LauncherUITabView", "updateFriendTabUnread return for finderTextPoint");
      AppMethodBeat.o(33384);
      return;
    }
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.adCG.adCJ.setUnread(getContext().getString(R.l.unread_count_overt_100));
        AppMethodBeat.o(33384);
        return;
      }
      this.adCG.adCJ.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33384);
      return;
    }
    this.adCG.adCJ.setUnread(null);
    AppMethodBeat.o(33384);
  }
  
  public final void azV(int paramInt)
  {
    AppMethodBeat.i(33385);
    this.adCt = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.adCH.adCJ.setUnread(getContext().getString(R.l.unread_count_overt_100));
        AppMethodBeat.o(33385);
        return;
      }
      this.adCH.adCJ.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33385);
      return;
    }
    this.adCH.adCJ.setUnread(null);
    AppMethodBeat.o(33385);
  }
  
  public int getContactTabUnread()
  {
    return this.adCp;
  }
  
  public int getCurIdx()
  {
    return this.zVI;
  }
  
  public int getFriendTabUnread()
  {
    return this.adCq;
  }
  
  public int getMainTabUnread()
  {
    return this.adCo;
  }
  
  public boolean getSettingsPoint()
  {
    return this.adCu;
  }
  
  public int getSettingsTabUnread()
  {
    return this.adCt;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.adCr;
  }
  
  public final void jhJ()
  {
    AppMethodBeat.i(33382);
    if ((this.adCE == null) || (this.adCF == null) || (this.adCG == null) || (this.adCH == null))
    {
      AppMethodBeat.o(33382);
      return;
    }
    this.adCE.adCJ.dCS();
    this.adCF.adCJ.dCS();
    this.adCG.adCJ.dCS();
    this.adCH.adCJ.dCS();
    AppMethodBeat.o(33382);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(33380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[] { Integer.valueOf(paramInt3 - paramInt1) });
    this.adCB = ((paramInt3 - paramInt1) / 4);
    paramInt2 = this.adCB;
    if ((this.adCC == null) || (this.adCC.getWidth() != paramInt2)) {
      if (this.adCC != null) {
        break label187;
      }
    }
    label187:
    for (paramInt1 = -1;; paramInt1 = this.adCC.getWidth())
    {
      Log.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.adCC = Bitmap.createBitmap(paramInt2, com.tencent.mm.cd.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.adCC).drawColor(getResources().getColor(R.e.wechat_green));
      t(this.zVI, 0.0F);
      this.adCD.setImageBitmap(this.adCC);
      setTo(this.zVI);
      AppMethodBeat.o(33380);
      return;
    }
  }
  
  public void setOnTabClickListener(d.a parama)
  {
    this.adBV = parama;
  }
  
  public void setTo(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(33389);
    this.zVI = paramInt;
    MMTabView localMMTabView = this.adCE.adCJ;
    int i;
    if (paramInt == 0)
    {
      i = getResources().getColor(R.e.wechat_green);
      localMMTabView.setTextColor(i);
      localMMTabView = this.adCE.adCJ;
      i = R.h.fMs;
      if (paramInt != 0) {
        break label296;
      }
      bool1 = true;
      label63:
      localMMTabView.setTag(i, Boolean.valueOf(bool1));
      localMMTabView = this.adCF.adCJ;
      if (paramInt != 1) {
        break label301;
      }
      i = getResources().getColor(R.e.wechat_green);
      label98:
      localMMTabView.setTextColor(i);
      localMMTabView = this.adCF.adCJ;
      i = R.h.fMs;
      if (paramInt != 1) {
        break label318;
      }
      bool1 = true;
      label124:
      localMMTabView.setTag(i, Boolean.valueOf(bool1));
      localMMTabView = this.adCG.adCJ;
      if (paramInt != 2) {
        break label323;
      }
      i = getResources().getColor(R.e.wechat_green);
      label159:
      localMMTabView.setTextColor(i);
      localMMTabView = this.adCG.adCJ;
      i = R.h.fMs;
      if (paramInt != 2) {
        break label340;
      }
      bool1 = true;
      label185:
      localMMTabView.setTag(i, Boolean.valueOf(bool1));
      localMMTabView = this.adCH.adCJ;
      if (paramInt != 3) {
        break label345;
      }
      i = getResources().getColor(R.e.wechat_green);
      label220:
      localMMTabView.setTextColor(i);
      localMMTabView = this.adCH.adCJ;
      i = R.h.fMs;
      if (paramInt != 3) {
        break label362;
      }
    }
    label296:
    label301:
    label318:
    label323:
    label340:
    label345:
    label362:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localMMTabView.setTag(i, Boolean.valueOf(bool1));
      this.ITx = System.currentTimeMillis();
      this.NMH = this.zVI;
      AppMethodBeat.o(33389);
      return;
      i = getContext().getResources().getColor(R.e.FG_0);
      break;
      bool1 = false;
      break label63;
      i = getContext().getResources().getColor(R.e.FG_0);
      break label98;
      bool1 = false;
      break label124;
      i = getContext().getResources().getColor(R.e.FG_0);
      break label159;
      bool1 = false;
      break label185;
      i = getContext().getResources().getColor(R.e.FG_0);
      break label220;
    }
  }
  
  public final void t(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33388);
    this.matrix.setTranslate(this.adCB * (paramInt + paramFloat), 0.0F);
    this.adCD.setImageMatrix(this.matrix);
    AppMethodBeat.o(33388);
  }
  
  protected final class a
  {
    MMTabView adCJ;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView
 * JD-Core Version:    0.7.0.1
 */