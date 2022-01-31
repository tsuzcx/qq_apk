package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class LauncherUITabView
  extends RelativeLayout
  implements c
{
  private Matrix aqv = new Matrix();
  protected int jQL = 0;
  private long ldT = 0L;
  private boolean uLA = false;
  private int uLB = 0;
  private boolean uLC = false;
  private int uLL;
  private Bitmap uLM;
  private ImageView uLN;
  protected a uLO;
  protected a uLP;
  protected a uLQ;
  protected a uLR;
  private c.a uLd;
  private int uLt = -1;
  protected View.OnClickListener uLv = new LauncherUITabView.1(this);
  private ah uLw = new LauncherUITabView.2(this);
  private int uLx = 0;
  private int uLy = 0;
  private int uLz = 0;
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private a FN(int paramInt)
  {
    a locala = new a();
    locala.uLT = new MMTabView(getContext(), paramInt);
    locala.uLT.setTag(Integer.valueOf(paramInt));
    locala.uLT.setOnClickListener(this.uLv);
    return locala;
  }
  
  private void init()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setBackgroundResource(R.e.white);
    localLinearLayout.setId(2307141);
    localLinearLayout.setOrientation(0);
    addView(localLinearLayout, new RelativeLayout.LayoutParams(-1, -2));
    this.uLN = new ImageView(getContext());
    this.uLN.setImageMatrix(this.aqv);
    this.uLN.setScaleType(ImageView.ScaleType.MATRIX);
    this.uLN.setId(2307142);
    Object localObject = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    ((RelativeLayout.LayoutParams)localObject).addRule(8, 2307141);
    addView(this.uLN, (ViewGroup.LayoutParams)localObject);
    localObject = FN(0);
    ((a)localObject).uLT.setText(R.l.main_chat);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(((a)localObject).uLT, localLayoutParams);
    this.uLO = ((a)localObject);
    localObject = FN(1);
    ((a)localObject).uLT.setText(R.l.main_contact);
    localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(((a)localObject).uLT, localLayoutParams);
    this.uLP = ((a)localObject);
    localObject = FN(2);
    ((a)localObject).uLT.setText(R.l.main_addcontact);
    localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(((a)localObject).uLT, localLayoutParams);
    this.uLQ = ((a)localObject);
    localObject = FN(3);
    ((a)localObject).uLT.setText(R.l.main_more);
    localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(((a)localObject).uLT, localLayoutParams);
    this.uLR = ((a)localObject);
  }
  
  public final void FH(int paramInt)
  {
    y.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.uLx = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uLO.uLT.setUnread(getContext().getString(R.l.unread_count_overt_100));
        return;
      }
      this.uLO.uLT.setUnread(String.valueOf(paramInt));
      return;
    }
    this.uLO.uLT.setUnread(null);
  }
  
  public final void FI(int paramInt)
  {
    this.uLy = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uLP.uLT.setUnread(getContext().getString(R.l.unread_count_overt_100));
        return;
      }
      this.uLP.uLT.setUnread(String.valueOf(paramInt));
      return;
    }
    this.uLP.uLT.setUnread(null);
  }
  
  public final void FJ(int paramInt)
  {
    this.uLz = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uLQ.uLT.setUnread(getContext().getString(R.l.unread_count_overt_100));
        return;
      }
      this.uLQ.uLT.setUnread(String.valueOf(paramInt));
      return;
    }
    this.uLQ.uLT.setUnread(null);
  }
  
  public final void FK(int paramInt)
  {
    this.uLB = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uLR.uLT.setUnread(getContext().getString(R.l.unread_count_overt_100));
        return;
      }
      this.uLR.uLT.setUnread(String.valueOf(paramInt));
      return;
    }
    this.uLR.uLT.setUnread(null);
  }
  
  public final void cxS()
  {
    if ((this.uLO == null) || (this.uLP == null) || (this.uLQ == null) || (this.uLR == null)) {
      return;
    }
    this.uLO.uLT.czG();
    this.uLP.uLT.czG();
    this.uLQ.uLT.czG();
    this.uLR.uLT.czG();
  }
  
  public int getContactTabUnread()
  {
    return this.uLy;
  }
  
  public int getCurIdx()
  {
    return this.jQL;
  }
  
  public int getFriendTabUnread()
  {
    return this.uLz;
  }
  
  public int getMainTabUnread()
  {
    return this.uLx;
  }
  
  public boolean getSettingsPoint()
  {
    return this.uLC;
  }
  
  public int getSettingsTabUnread()
  {
    return this.uLB;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.uLA;
  }
  
  public final void i(int paramInt, float paramFloat)
  {
    this.aqv.setTranslate(this.uLL * (paramInt + paramFloat), 0.0F);
    this.uLN.setImageMatrix(this.aqv);
  }
  
  public final void mH(boolean paramBoolean)
  {
    this.uLA = paramBoolean;
    this.uLQ.uLT.mV(paramBoolean);
  }
  
  public final void mI(boolean paramBoolean)
  {
    this.uLC = paramBoolean;
    this.uLR.uLT.mV(paramBoolean);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    y.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[] { Integer.valueOf(paramInt3 - paramInt1) });
    this.uLL = ((paramInt3 - paramInt1) / 4);
    paramInt2 = this.uLL;
    if ((this.uLM == null) || (this.uLM.getWidth() != paramInt2)) {
      if (this.uLM != null) {
        break label173;
      }
    }
    label173:
    for (paramInt1 = -1;; paramInt1 = this.uLM.getWidth())
    {
      y.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.uLM = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.uLM).drawColor(getResources().getColor(R.e.wechat_green));
      i(this.jQL, 0.0F);
      this.uLN.setImageBitmap(this.uLM);
      setTo(this.jQL);
      return;
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.uLd = parama;
  }
  
  public void setTo(int paramInt)
  {
    this.jQL = paramInt;
    MMTabView localMMTabView = this.uLO.uLT;
    if (paramInt == 0)
    {
      localColorStateList = getResources().getColorStateList(R.e.wechat_green);
      localMMTabView.setTextColor(localColorStateList);
      localMMTabView = this.uLP.uLT;
      if (paramInt != 1) {
        break label150;
      }
      localColorStateList = getResources().getColorStateList(R.e.wechat_green);
      label57:
      localMMTabView.setTextColor(localColorStateList);
      localMMTabView = this.uLQ.uLT;
      if (paramInt != 2) {
        break label164;
      }
      localColorStateList = getResources().getColorStateList(R.e.wechat_green);
      label86:
      localMMTabView.setTextColor(localColorStateList);
      localMMTabView = this.uLR.uLT;
      if (paramInt != 3) {
        break label178;
      }
    }
    label150:
    label164:
    label178:
    for (ColorStateList localColorStateList = getResources().getColorStateList(R.e.wechat_green);; localColorStateList = getResources().getColorStateList(R.e.launcher_tab_text_selector))
    {
      localMMTabView.setTextColor(localColorStateList);
      this.ldT = System.currentTimeMillis();
      this.uLt = this.jQL;
      return;
      localColorStateList = getResources().getColorStateList(R.e.launcher_tab_text_selector);
      break;
      localColorStateList = getResources().getColorStateList(R.e.launcher_tab_text_selector);
      break label57;
      localColorStateList = getResources().getColorStateList(R.e.launcher_tab_text_selector);
      break label86;
    }
  }
  
  protected final class a
  {
    MMTabView uLT;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView
 * JD-Core Version:    0.7.0.1
 */