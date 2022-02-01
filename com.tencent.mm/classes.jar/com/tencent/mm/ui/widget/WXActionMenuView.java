package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.s.a;
import java.lang.reflect.Field;

public class WXActionMenuView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int afCZ;
  private TextView afVX;
  private ImageView afVY;
  private View afVZ;
  private MenuItem afWa;
  private b afWb;
  private a afWc;
  private CharSequence cZ;
  private Drawable fM;
  private Activity mActivity;
  private Context mContext;
  private float mDensity;
  private int mh;
  
  public WXActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  private WXActionMenuView(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251745);
    this.afVX = null;
    this.afVY = null;
    paramAttributeSet = paramContext.getResources();
    this.mContext = paramContext;
    this.mDensity = paramAttributeSet.getDisplayMetrics().density;
    this.mh = ((int)(32.0F * this.mDensity + 0.5F));
    paramAttributeSet = (Activity)paramContext;
    Resources localResources = paramContext.getResources();
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      paramByte = 1;
      if (paramByte == 0) {
        break label227;
      }
    }
    label227:
    for (paramByte = a.e.DefaultActionbarHeightLand;; paramByte = a.e.DefaultActionbarHeightPort)
    {
      this.afCZ = com.tencent.mm.compatible.util.a.c(paramAttributeSet, (int)localResources.getDimension(paramByte));
      Log.i("MicroMsg.WXActionMenuView", "mMaxIconSize : %s, mDefaultNormalActionbarHeight: %s.", new Object[] { Integer.valueOf(this.mh), Integer.valueOf(this.afCZ) });
      setOnClickListener(this);
      this.afVZ = LayoutInflater.from(this.mContext).inflate(a.h.actionbar_custom_menu_item_new, this);
      this.afVZ.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
      this.afVX = ((TextView)findViewById(a.g.menu_desc));
      this.afVY = ((ImageView)findViewById(a.g.menu_icon));
      com.tencent.mm.ui.a.v(this.afVX, a.e.ActionBarTextSize);
      AppMethodBeat.o(251745);
      return;
      paramByte = 0;
      break;
    }
  }
  
  public WXActionMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public static View a(Activity paramActivity, MenuItem paramMenuItem, a parama, b paramb)
  {
    AppMethodBeat.i(251753);
    if (paramMenuItem.getActionView() != null)
    {
      Log.i("MicroMsg.WXActionMenuView", "makeMMActionMenuView : getActionView.");
      if ((paramMenuItem.getActionView().getParent() instanceof ViewGroup)) {
        ((ViewGroup)paramMenuItem.getActionView().getParent()).removeView(paramMenuItem.getActionView());
      }
      paramActivity = paramMenuItem.getActionView();
      AppMethodBeat.o(251753);
      return paramActivity;
    }
    Log.i("MicroMsg.WXActionMenuView", "makeMMActionMenuView : icon.");
    View localView = LayoutInflater.from(paramActivity).inflate(a.h.actionbar_custom_menu, null);
    ((WXActionMenuView)localView.findViewById(a.g.action_menu_view_root)).b(paramActivity, paramMenuItem, parama, paramb);
    localView.setTag(paramMenuItem);
    AppMethodBeat.o(251753);
    return localView;
  }
  
  /* Error */
  public static View a(final Activity paramActivity, final MenuItem paramMenuItem, a parama, final b paramb, final com.tencent.mm.ui.y paramy)
  {
    // Byte code:
    //   0: ldc 239
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 243	java/lang/Object:getClass	()Ljava/lang/Class;
    //   9: ldc 245
    //   11: invokevirtual 251	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   14: astore 10
    //   16: aload 10
    //   18: iconst_1
    //   19: invokevirtual 257	java/lang/reflect/Field:setAccessible	(Z)V
    //   22: aload 10
    //   24: aload_1
    //   25: invokevirtual 261	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 122	java/lang/Integer
    //   31: invokevirtual 265	java/lang/Integer:intValue	()I
    //   34: istore 5
    //   36: ldc 116
    //   38: ldc_w 267
    //   41: iconst_1
    //   42: anewarray 120	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload 5
    //   49: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload 4
    //   58: getfield 273	com/tencent/mm/ui/y:lMw	Lcom/tencent/mm/ui/tools/s;
    //   61: astore 10
    //   63: aload 10
    //   65: getfield 279	com/tencent/mm/ui/tools/s:afKK	Lcom/tencent/mm/ui/tools/s$a;
    //   68: astore 4
    //   70: aload 10
    //   72: getfield 283	com/tencent/mm/ui/tools/s:afKt	Z
    //   75: istore 7
    //   77: aload 10
    //   79: getfield 286	com/tencent/mm/ui/tools/s:afKu	Z
    //   82: istore 8
    //   84: aload_1
    //   85: invokeinterface 290 1 0
    //   90: istore 9
    //   92: iload 5
    //   94: bipush 8
    //   96: iand
    //   97: bipush 8
    //   99: if_icmpne +139 -> 238
    //   102: iconst_1
    //   103: istore 6
    //   105: ldc 116
    //   107: ldc_w 292
    //   110: iconst_4
    //   111: anewarray 120	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload 10
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: iload 8
    //   123: invokestatic 297	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   126: aastore
    //   127: dup
    //   128: iconst_2
    //   129: iload 9
    //   131: invokestatic 297	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   134: aastore
    //   135: dup
    //   136: iconst_3
    //   137: iload 6
    //   139: invokestatic 297	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   142: aastore
    //   143: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: iload 8
    //   148: ifne +96 -> 244
    //   151: aload_0
    //   152: invokestatic 141	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   155: getstatic 224	com/tencent/mm/ah/a$h:actionbar_custom_menu	I
    //   158: aconst_null
    //   159: invokevirtual 150	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   162: astore 10
    //   164: aload 10
    //   166: getstatic 227	com/tencent/mm/ah/a$g:action_menu_view_root	I
    //   169: invokevirtual 228	android/view/View:findViewById	(I)Landroid/view/View;
    //   172: checkcast 2	com/tencent/mm/ui/widget/WXActionMenuView
    //   175: astore 11
    //   177: aload 11
    //   179: aload_0
    //   180: aload_1
    //   181: aload_2
    //   182: aload_3
    //   183: invokespecial 231	com/tencent/mm/ui/widget/WXActionMenuView:b	(Landroid/app/Activity;Landroid/view/MenuItem;Lcom/tencent/mm/ui/widget/WXActionMenuView$a;Lcom/tencent/mm/ui/widget/WXActionMenuView$b;)V
    //   186: aload 11
    //   188: new 8	com/tencent/mm/ui/widget/WXActionMenuView$1
    //   191: dup
    //   192: iload 7
    //   194: aload 4
    //   196: aload_3
    //   197: aload_0
    //   198: aload_1
    //   199: invokespecial 300	com/tencent/mm/ui/widget/WXActionMenuView$1:<init>	(ZLcom/tencent/mm/ui/tools/s$a;Lcom/tencent/mm/ui/widget/WXActionMenuView$b;Landroid/app/Activity;Landroid/view/MenuItem;)V
    //   202: invokevirtual 135	com/tencent/mm/ui/widget/WXActionMenuView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   205: aload 10
    //   207: getstatic 303	com/tencent/mm/ah/a$g:menu_search	I
    //   210: aload_1
    //   211: invokevirtual 306	android/view/View:setTag	(ILjava/lang/Object;)V
    //   214: aload_1
    //   215: invokeinterface 310 1 0
    //   220: ifnonnull +10 -> 230
    //   223: aload 10
    //   225: bipush 8
    //   227: invokevirtual 313	android/view/View:setVisibility	(I)V
    //   230: ldc 239
    //   232: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload 10
    //   237: areturn
    //   238: iconst_0
    //   239: istore 6
    //   241: goto -136 -> 105
    //   244: aload_1
    //   245: invokeinterface 204 1 0
    //   250: ifnull +74 -> 324
    //   253: ldc 116
    //   255: ldc_w 315
    //   258: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_1
    //   262: invokeinterface 204 1 0
    //   267: invokevirtual 213	android/view/View:getParent	()Landroid/view/ViewParent;
    //   270: instanceof 215
    //   273: ifeq +24 -> 297
    //   276: aload_1
    //   277: invokeinterface 204 1 0
    //   282: invokevirtual 213	android/view/View:getParent	()Landroid/view/ViewParent;
    //   285: checkcast 215	android/view/ViewGroup
    //   288: aload_1
    //   289: invokeinterface 204 1 0
    //   294: invokevirtual 219	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   297: aload_1
    //   298: invokeinterface 204 1 0
    //   303: getstatic 303	com/tencent/mm/ah/a$g:menu_search	I
    //   306: aload_1
    //   307: invokevirtual 306	android/view/View:setTag	(ILjava/lang/Object;)V
    //   310: aload_1
    //   311: invokeinterface 204 1 0
    //   316: astore_0
    //   317: ldc 239
    //   319: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: aload_0
    //   323: areturn
    //   324: new 159	android/view/View
    //   327: dup
    //   328: aload_0
    //   329: invokespecial 318	android/view/View:<init>	(Landroid/content/Context;)V
    //   332: astore_0
    //   333: ldc 239
    //   335: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: areturn
    //   340: astore 10
    //   342: iconst_2
    //   343: istore 5
    //   345: goto -289 -> 56
    //   348: astore 10
    //   350: goto -294 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramActivity	Activity
    //   0	353	1	paramMenuItem	MenuItem
    //   0	353	2	parama	a
    //   0	353	3	paramb	b
    //   0	353	4	paramy	com.tencent.mm.ui.y
    //   34	310	5	i	int
    //   103	137	6	bool1	boolean
    //   75	118	7	bool2	boolean
    //   82	65	8	bool3	boolean
    //   90	40	9	bool4	boolean
    //   14	222	10	localObject	Object
    //   340	1	10	localException1	Exception
    //   348	1	10	localException2	Exception
    //   175	12	11	localWXActionMenuView	WXActionMenuView
    // Exception table:
    //   from	to	target	type
    //   5	36	340	java/lang/Exception
    //   36	56	348	java/lang/Exception
  }
  
  private void b(Activity paramActivity, MenuItem paramMenuItem, a parama, b paramb)
  {
    AppMethodBeat.i(251762);
    this.mActivity = paramActivity;
    this.afWb = paramb;
    this.afWc = parama;
    Log.i("MicroMsg.WXActionMenuView", "buildMMActionMenuView, menuCustomParam: %s.", new Object[] { parama });
    m(paramMenuItem);
    jFj();
    AppMethodBeat.o(251762);
  }
  
  private int getShowAsAction()
  {
    AppMethodBeat.i(251757);
    try
    {
      Field localField = this.afWa.getClass().getDeclaredField("mShowAsAction");
      localField.setAccessible(true);
      i = ((Integer)localField.get(this.afWa)).intValue();
      AppMethodBeat.o(251757);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 2;
      }
    }
  }
  
  private void jFj()
  {
    AppMethodBeat.i(251761);
    if (this.afWa == null)
    {
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction, mItemData is null");
      AppMethodBeat.o(251761);
      return;
    }
    if (this.afVZ != null) {
      this.afVZ.setVisibility(0);
    }
    int i = getShowAsAction();
    Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction, showAsAction: %s.", new Object[] { Integer.valueOf(i) });
    if (((i & 0x2) == 2) || ((i & 0x1) == 1) || ((i & 0x8) == 8))
    {
      if ((this.afWa.getIcon() != null) && (this.afVY != null))
      {
        this.afVY.setVisibility(0);
        if (this.afVX != null) {
          this.afVX.setVisibility(8);
        }
        Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle gone, menuIcon show.");
        AppMethodBeat.o(251761);
        return;
      }
      if ((this.afWa.getTitle() != null) && (this.afVX != null))
      {
        this.afVX.setVisibility(0);
        if (this.afVY != null) {
          this.afVY.setVisibility(8);
        }
        Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle show, menuIcon gone.");
        AppMethodBeat.o(251761);
        return;
      }
      if (this.afVY != null) {
        this.afVY.setVisibility(8);
      }
      if (this.afVX != null) {
        this.afVX.setVisibility(8);
      }
      if (this.afVZ != null) {
        this.afVZ.setVisibility(8);
      }
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is all gone");
      AppMethodBeat.o(251761);
      return;
    }
    if (((i & 0x4) == 4) || ((i & 0x0) == 0))
    {
      if (this.afVY != null) {
        this.afVY.setVisibility(8);
      }
      if ((this.afWa.getTitle() != null) && (this.afVX != null))
      {
        this.afVX.setVisibility(0);
        if (this.afVY != null) {
          this.afVY.setVisibility(8);
        }
      }
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle show, menuIcon gone.");
      AppMethodBeat.o(251761);
      return;
    }
    if ((this.afWa.getIcon() != null) && (this.afVY != null))
    {
      this.afVY.setVisibility(0);
      if (this.afVX != null) {
        this.afVX.setVisibility(8);
      }
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle gone, menuIcon show.");
      AppMethodBeat.o(251761);
      return;
    }
    if ((this.afWa.getTitle() != null) && (this.afVX != null))
    {
      this.afVX.setVisibility(0);
      if (this.afVY != null) {
        this.afVY.setVisibility(8);
      }
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle show, menuIcon gone.");
      AppMethodBeat.o(251761);
      return;
    }
    if (this.afVY != null) {
      this.afVY.setVisibility(8);
    }
    if (this.afVX != null) {
      this.afVX.setVisibility(8);
    }
    if (this.afVZ != null) {
      this.afVZ.setVisibility(8);
    }
    Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is all gone");
    AppMethodBeat.o(251761);
  }
  
  private void m(MenuItem paramMenuItem)
  {
    int i = 0;
    AppMethodBeat.i(251749);
    Log.i("MicroMsg.WXActionMenuView", "initialize : itemData: %s.", new Object[] { paramMenuItem });
    this.afWa = paramMenuItem;
    this.mh = ((int)(this.afWc.afWi * this.mDensity + 0.5F));
    setMenuBackgroundColor(this.afWc.backgroundColor);
    setMenuBackgroundDrawble(this.afWc.backgroundDrawable);
    setMenuTitleTextColor(this.afWc.afWg);
    setMenuTitleTextSize(this.afWc.afWh);
    int j = this.afWc.afWm;
    int k = this.afWc.afWn;
    if ((this.afVZ != null) && (j > 0) && (k > 0)) {
      this.afVY.setLayoutParams(new ViewGroup.LayoutParams(j, k));
    }
    setIcon(paramMenuItem.getIcon());
    setTitle(paramMenuItem.getTitle());
    setId(paramMenuItem.getItemId());
    if (paramMenuItem.isVisible()) {}
    for (;;)
    {
      setVisibility(i);
      setEnabled(paramMenuItem.isEnabled());
      paramMenuItem.hasSubMenu();
      AppMethodBeat.o(251749);
      return;
      i = 8;
    }
  }
  
  private void setMenuBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(251750);
    if (this.afVZ != null) {
      this.afVZ.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(251750);
  }
  
  private void setMenuBackgroundDrawble(Drawable paramDrawable)
  {
    AppMethodBeat.i(251751);
    if ((this.afVZ != null) && (paramDrawable != null)) {
      this.afVZ.setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(251751);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(251763);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/WXActionMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView == this.afVZ) && (this.afWb != null)) {
      this.afWb.b(this.mActivity, this.afWa);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/WXActionMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251763);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(251768);
    this.fM = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      float f;
      if (m > this.mh)
      {
        f = this.mh / m;
        i = this.mh;
        j = (int)(k * f);
      }
      m = j;
      k = i;
      if (j > this.mh)
      {
        f = this.mh / j;
        m = this.mh;
        k = (int)(i * f);
      }
      paramDrawable.setBounds(0, 0, k, m);
    }
    setMenuIcon(paramDrawable);
    AppMethodBeat.o(251768);
  }
  
  public void setMenuIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(251781);
    if (this.afVY != null) {
      this.afVY.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(251781);
  }
  
  public void setMenuTitleText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251779);
    if (this.afVX != null)
    {
      this.afVX.setText(paramCharSequence);
      this.afVX.setContentDescription(paramCharSequence);
    }
    if ((!Util.isNullOrNil(paramCharSequence)) && (!Util.isNullOrNil(paramCharSequence.toString())) && (!paramCharSequence.toString().contains(getContext().getResources().getString(a.k.common_btn)))) {
      this.afVY.setContentDescription(paramCharSequence + getContext().getResources().getString(a.k.common_btn));
    }
    AppMethodBeat.o(251779);
  }
  
  public void setMenuTitleTextColor(int paramInt)
  {
    AppMethodBeat.i(251775);
    if ((this.afVX != null) && (paramInt > 0)) {
      this.afVX.setTextColor(paramInt);
    }
    AppMethodBeat.o(251775);
  }
  
  public void setMenuTitleTextSize(float paramFloat)
  {
    AppMethodBeat.i(251772);
    if ((this.afVX != null) && (paramFloat > 0.0F)) {
      this.afVX.setTextSize(paramFloat);
    }
    AppMethodBeat.o(251772);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251770);
    this.cZ = paramCharSequence;
    setMenuTitleText(this.cZ);
    AppMethodBeat.o(251770);
  }
  
  public static final class a
  {
    public int adve;
    public int afWg = -1;
    public float afWh = -1.0F;
    public int afWi = 32;
    public int afWj = 4;
    public boolean afWk = true;
    public boolean afWl = false;
    public int afWm = -1;
    public int afWn = -1;
    public String afWo = "";
    public Drawable afWp;
    public int backgroundColor;
    public Drawable backgroundDrawable;
    boolean uPP = false;
    
    public final String toString()
    {
      AppMethodBeat.i(251630);
      String str = "MenuCustomParam{menuTextColor=" + this.afWg + ", menuTextSize=" + this.afWh + ", maxIconSize=" + this.afWi + ", maxMenuSize=" + this.afWj + ", needTitleCenterMode=" + this.afWk + ", useOrginalSysMode=" + this.afWl + ", normalActionbarHeight=" + this.adve + ", previewIconWidth=" + this.afWm + ", previewIconHeight=" + this.afWn + ", menuText='" + this.afWo + '\'' + ", iconDrawabled=" + this.afWp + ", hide=" + this.uPP + ", backgroundColor=" + this.backgroundColor + ", backgroundDrawable=" + this.backgroundDrawable + '}';
      AppMethodBeat.o(251630);
      return str;
    }
    
    public static final class a
    {
      public static WXActionMenuView.a afWq;
      
      public a()
      {
        AppMethodBeat.i(251525);
        afWq = new WXActionMenuView.a();
        AppMethodBeat.o(251525);
      }
      
      public final a Nm(boolean paramBoolean)
      {
        afWq.afWk = paramBoolean;
        return this;
      }
      
      public final a Nn(boolean paramBoolean)
      {
        afWq.afWl = paramBoolean;
        return this;
      }
      
      public final a aEo(int paramInt)
      {
        afWq.adve = paramInt;
        return this;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean b(Activity paramActivity, MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.WXActionMenuView
 * JD-Core Version:    0.7.0.1
 */