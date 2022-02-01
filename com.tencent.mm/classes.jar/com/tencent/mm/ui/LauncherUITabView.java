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
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class LauncherUITabView
  extends RelativeLayout
  implements d
{
  private long CZh;
  private int HQb;
  protected View.OnClickListener VXP;
  private MMHandler VXQ;
  private LinearLayout VXR;
  private int VXS;
  private int VXT;
  private int VXU;
  private boolean VXV;
  private int VXX;
  private boolean VXY;
  private d.a VXz;
  private int VYg;
  private Bitmap VYh;
  private ImageView VYi;
  protected a VYj;
  protected a VYk;
  protected a VYl;
  protected a VYm;
  private Matrix aHZ;
  protected int wzx;
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33371);
    this.wzx = 0;
    this.aHZ = new Matrix();
    this.CZh = 0L;
    this.HQb = -1;
    this.VXP = new View.OnClickListener()
    {
      private final long Qhx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          ((com.tencent.mm.v.a)LifecycleEventCenter.getEvent(com.tencent.mm.v.a.class)).publish(Integer.valueOf(0));
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
    this.VXQ = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.VXS = 0;
    this.VXT = 0;
    this.VXU = 0;
    this.VXX = 0;
    this.VXV = false;
    this.VXY = false;
    init();
    AppMethodBeat.o(33371);
  }
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33372);
    this.wzx = 0;
    this.aHZ = new Matrix();
    this.CZh = 0L;
    this.HQb = -1;
    this.VXP = new View.OnClickListener()
    {
      private final long Qhx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          ((com.tencent.mm.v.a)LifecycleEventCenter.getEvent(com.tencent.mm.v.a.class)).publish(Integer.valueOf(0));
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
    this.VXQ = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.VXS = 0;
    this.VXT = 0;
    this.VXU = 0;
    this.VXX = 0;
    this.VXV = false;
    this.VXY = false;
    init();
    AppMethodBeat.o(33372);
  }
  
  private a atN(int paramInt)
  {
    AppMethodBeat.i(33373);
    a locala = new a();
    locala.VYo = new MMTabView(getContext(), paramInt);
    locala.VYo.setTag(Integer.valueOf(paramInt));
    locala.VYo.setOnClickListener(this.VXP);
    AppMethodBeat.o(33373);
    return locala;
  }
  
  private void hHl()
  {
    AppMethodBeat.i(33378);
    this.VYi = new ImageView(getContext());
    this.VYi.setImageMatrix(this.aHZ);
    this.VYi.setScaleType(ImageView.ScaleType.MATRIX);
    this.VYi.setId(2307142);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2307141);
    addView(this.VYi, localLayoutParams);
    AppMethodBeat.o(33378);
  }
  
  private a i(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33374);
    a locala = atN(0);
    locala.VYo.setText(R.l.eKY);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.VYo, localLayoutParams);
    AppMethodBeat.o(33374);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33379);
    this.VXR = new LinearLayout(getContext());
    this.VXR.setBackgroundColor(getContext().getResources().getColor(R.e.BG_1));
    this.VXR.setId(2307141);
    this.VXR.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.VXR, localLayoutParams);
    hHl();
    this.VYj = i(this.VXR);
    this.VYk = j(this.VXR);
    this.VYl = k(this.VXR);
    this.VYm = l(this.VXR);
    AppMethodBeat.o(33379);
  }
  
  private a j(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33375);
    a locala = atN(1);
    locala.VYo.setText(R.l.eKZ);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.VYo, localLayoutParams);
    AppMethodBeat.o(33375);
    return locala;
  }
  
  private a k(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33376);
    a locala = atN(2);
    locala.VYo.setText(R.l.eKX);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.VYo, localLayoutParams);
    AppMethodBeat.o(33376);
    return locala;
  }
  
  private a l(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33377);
    a locala = atN(3);
    locala.VYo.setText(R.l.eLu);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.VYo, localLayoutParams);
    AppMethodBeat.o(33377);
    return locala;
  }
  
  public final void Fi(boolean paramBoolean)
  {
    AppMethodBeat.i(33386);
    this.VXV = paramBoolean;
    this.VYl.VYo.FA(paramBoolean);
    AppMethodBeat.o(33386);
  }
  
  public final void Fj(boolean paramBoolean)
  {
    AppMethodBeat.i(33387);
    this.VXY = paramBoolean;
    this.VYm.VYo.FA(paramBoolean);
    AppMethodBeat.o(33387);
  }
  
  public final void atB(int paramInt)
  {
    AppMethodBeat.i(33381);
    Log.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.VXS = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.VYj.VYo.setUnread(getContext().getString(R.l.unread_count_overt_100));
        AppMethodBeat.o(33381);
        return;
      }
      this.VYj.VYo.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33381);
      return;
    }
    this.VYj.VYo.setUnread(null);
    AppMethodBeat.o(33381);
  }
  
  public final void atC(int paramInt)
  {
    AppMethodBeat.i(33383);
    this.VXT = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.VYk.VYo.setUnread(getContext().getString(R.l.unread_count_overt_100));
        AppMethodBeat.o(33383);
        return;
      }
      this.VYk.VYo.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33383);
      return;
    }
    this.VYk.VYo.setUnread(null);
    AppMethodBeat.o(33383);
  }
  
  public final void atD(int paramInt)
  {
    AppMethodBeat.i(33384);
    this.VXU = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.VYl.VYo.setUnread(getContext().getString(R.l.unread_count_overt_100));
        AppMethodBeat.o(33384);
        return;
      }
      this.VYl.VYo.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33384);
      return;
    }
    this.VYl.VYo.setUnread(null);
    AppMethodBeat.o(33384);
  }
  
  public final void atE(int paramInt)
  {
    AppMethodBeat.i(33385);
    this.VXX = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.VYm.VYo.setUnread(getContext().getString(R.l.unread_count_overt_100));
        AppMethodBeat.o(33385);
        return;
      }
      this.VYm.VYo.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33385);
      return;
    }
    this.VYm.VYo.setUnread(null);
    AppMethodBeat.o(33385);
  }
  
  public int getContactTabUnread()
  {
    return this.VXT;
  }
  
  public int getCurIdx()
  {
    return this.wzx;
  }
  
  public int getFriendTabUnread()
  {
    return this.VXU;
  }
  
  public int getMainTabUnread()
  {
    return this.VXS;
  }
  
  public boolean getSettingsPoint()
  {
    return this.VXY;
  }
  
  public int getSettingsTabUnread()
  {
    return this.VXX;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.VXV;
  }
  
  public final void hFw()
  {
    AppMethodBeat.i(33382);
    if ((this.VYj == null) || (this.VYk == null) || (this.VYl == null) || (this.VYm == null))
    {
      AppMethodBeat.o(33382);
      return;
    }
    this.VYj.VYo.hHT();
    this.VYk.VYo.hHT();
    this.VYl.VYo.hHT();
    this.VYm.VYo.hHT();
    AppMethodBeat.o(33382);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(33380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[] { Integer.valueOf(paramInt3 - paramInt1) });
    this.VYg = ((paramInt3 - paramInt1) / 4);
    paramInt2 = this.VYg;
    if ((this.VYh == null) || (this.VYh.getWidth() != paramInt2)) {
      if (this.VYh != null) {
        break label187;
      }
    }
    label187:
    for (paramInt1 = -1;; paramInt1 = this.VYh.getWidth())
    {
      Log.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.VYh = Bitmap.createBitmap(paramInt2, com.tencent.mm.ci.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.VYh).drawColor(getResources().getColor(R.e.wechat_green));
      q(this.wzx, 0.0F);
      this.VYi.setImageBitmap(this.VYh);
      setTo(this.wzx);
      AppMethodBeat.o(33380);
      return;
    }
  }
  
  public final void q(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33388);
    this.aHZ.setTranslate(this.VYg * (paramInt + paramFloat), 0.0F);
    this.VYi.setImageMatrix(this.aHZ);
    AppMethodBeat.o(33388);
  }
  
  public void setOnTabClickListener(d.a parama)
  {
    this.VXz = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33389);
    this.wzx = paramInt;
    MMTabView localMMTabView = this.VYj.VYo;
    int i;
    if (paramInt == 0)
    {
      i = getResources().getColor(R.e.wechat_green);
      localMMTabView.setTextColor(i);
      localMMTabView = this.VYk.VYo;
      if (paramInt != 1) {
        break label165;
      }
      i = getResources().getColor(R.e.wechat_green);
      label63:
      localMMTabView.setTextColor(i);
      localMMTabView = this.VYl.VYo;
      if (paramInt != 2) {
        break label182;
      }
      i = getResources().getColor(R.e.wechat_green);
      label92:
      localMMTabView.setTextColor(i);
      localMMTabView = this.VYm.VYo;
      if (paramInt != 3) {
        break label199;
      }
    }
    label165:
    label182:
    label199:
    for (paramInt = getResources().getColor(R.e.wechat_green);; paramInt = getContext().getResources().getColor(R.e.FG_0))
    {
      localMMTabView.setTextColor(paramInt);
      this.CZh = System.currentTimeMillis();
      this.HQb = this.wzx;
      AppMethodBeat.o(33389);
      return;
      i = getContext().getResources().getColor(R.e.FG_0);
      break;
      i = getContext().getResources().getColor(R.e.FG_0);
      break label63;
      i = getContext().getResources().getColor(R.e.FG_0);
      break label92;
    }
  }
  
  protected final class a
  {
    MMTabView VYo;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView
 * JD-Core Version:    0.7.0.1
 */