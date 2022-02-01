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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.t.a;
import java.lang.reflect.Field;

public class WXActionMenuView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int XMM;
  private TextView Yee;
  private ImageView Yef;
  private View Yeg;
  private MenuItem Yeh;
  private b Yei;
  private a Yej;
  private CharSequence cZ;
  private Drawable eK;
  private int ll;
  private Activity mActivity;
  private Context mContext;
  private float mDensity;
  
  public WXActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  private WXActionMenuView(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192452);
    this.Yee = null;
    this.Yef = null;
    paramAttributeSet = paramContext.getResources();
    this.mContext = paramContext;
    this.mDensity = paramAttributeSet.getDisplayMetrics().density;
    this.ll = ((int)(32.0F * this.mDensity + 0.5F));
    paramAttributeSet = (Activity)paramContext;
    Resources localResources = paramContext.getResources();
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      paramByte = 1;
      if (paramByte == 0) {
        break label217;
      }
    }
    label217:
    for (paramByte = a.e.DefaultActionbarHeightLand;; paramByte = a.e.DefaultActionbarHeightPort)
    {
      this.XMM = com.tencent.mm.compatible.util.a.c(paramAttributeSet, (int)localResources.getDimension(paramByte));
      Log.i("MicroMsg.WXActionMenuView", "mMaxIconSize : %s, mDefaultNormalActionbarHeight: %s.", new Object[] { Integer.valueOf(this.ll), Integer.valueOf(this.XMM) });
      setOnClickListener(this);
      this.Yeg = LayoutInflater.from(this.mContext).inflate(a.h.actionbar_custom_menu_item_new, this);
      this.Yeg.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
      this.Yee = ((TextView)findViewById(a.g.menu_desc));
      this.Yef = ((ImageView)findViewById(a.g.menu_icon));
      AppMethodBeat.o(192452);
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
    AppMethodBeat.i(192488);
    if (paramMenuItem.getActionView() != null)
    {
      Log.i("MicroMsg.WXActionMenuView", "makeMMActionMenuView : getActionView.");
      if ((paramMenuItem.getActionView().getParent() instanceof ViewGroup)) {
        ((ViewGroup)paramMenuItem.getActionView().getParent()).removeView(paramMenuItem.getActionView());
      }
      paramActivity = paramMenuItem.getActionView();
      AppMethodBeat.o(192488);
      return paramActivity;
    }
    Log.i("MicroMsg.WXActionMenuView", "makeMMActionMenuView : icon.");
    View localView = LayoutInflater.from(paramActivity).inflate(a.h.actionbar_custom_menu, null);
    ((WXActionMenuView)localView.findViewById(a.g.action_menu_view_root)).b(paramActivity, paramMenuItem, parama, paramb);
    localView.setTag(paramMenuItem);
    AppMethodBeat.o(192488);
    return localView;
  }
  
  /* Error */
  public static View a(final Activity paramActivity, final MenuItem paramMenuItem, a parama, final b paramb, final com.tencent.mm.ui.w paramw)
  {
    // Byte code:
    //   0: ldc 230
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 234	java/lang/Object:getClass	()Ljava/lang/Class;
    //   9: ldc 236
    //   11: invokevirtual 242	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   14: astore 10
    //   16: aload 10
    //   18: iconst_1
    //   19: invokevirtual 248	java/lang/reflect/Field:setAccessible	(Z)V
    //   22: aload 10
    //   24: aload_1
    //   25: invokevirtual 252	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 122	java/lang/Integer
    //   31: invokevirtual 256	java/lang/Integer:intValue	()I
    //   34: istore 5
    //   36: ldc 116
    //   38: ldc_w 258
    //   41: iconst_1
    //   42: anewarray 120	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload 5
    //   49: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload 4
    //   58: getfield 264	com/tencent/mm/ui/w:jjS	Lcom/tencent/mm/ui/tools/t;
    //   61: astore 10
    //   63: aload 10
    //   65: getfield 270	com/tencent/mm/ui/tools/t:XUv	Lcom/tencent/mm/ui/tools/t$a;
    //   68: astore 4
    //   70: aload 10
    //   72: getfield 274	com/tencent/mm/ui/tools/t:XUf	Z
    //   75: istore 7
    //   77: aload 10
    //   79: getfield 277	com/tencent/mm/ui/tools/t:XUg	Z
    //   82: istore 8
    //   84: aload_1
    //   85: invokeinterface 281 1 0
    //   90: istore 9
    //   92: iload 5
    //   94: bipush 8
    //   96: iand
    //   97: bipush 8
    //   99: if_icmpne +139 -> 238
    //   102: iconst_1
    //   103: istore 6
    //   105: ldc 116
    //   107: ldc_w 283
    //   110: iconst_4
    //   111: anewarray 120	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload 10
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: iload 8
    //   123: invokestatic 288	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   126: aastore
    //   127: dup
    //   128: iconst_2
    //   129: iload 9
    //   131: invokestatic 288	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   134: aastore
    //   135: dup
    //   136: iconst_3
    //   137: iload 6
    //   139: invokestatic 288	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   142: aastore
    //   143: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: iload 8
    //   148: ifne +96 -> 244
    //   151: aload_0
    //   152: invokestatic 141	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   155: getstatic 215	com/tencent/mm/ah/a$h:actionbar_custom_menu	I
    //   158: aconst_null
    //   159: invokevirtual 150	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   162: astore 10
    //   164: aload 10
    //   166: getstatic 218	com/tencent/mm/ah/a$g:action_menu_view_root	I
    //   169: invokevirtual 219	android/view/View:findViewById	(I)Landroid/view/View;
    //   172: checkcast 2	com/tencent/mm/ui/widget/WXActionMenuView
    //   175: astore 11
    //   177: aload 11
    //   179: aload_0
    //   180: aload_1
    //   181: aload_2
    //   182: aload_3
    //   183: invokespecial 222	com/tencent/mm/ui/widget/WXActionMenuView:b	(Landroid/app/Activity;Landroid/view/MenuItem;Lcom/tencent/mm/ui/widget/WXActionMenuView$a;Lcom/tencent/mm/ui/widget/WXActionMenuView$b;)V
    //   186: aload 11
    //   188: new 8	com/tencent/mm/ui/widget/WXActionMenuView$1
    //   191: dup
    //   192: iload 7
    //   194: aload 4
    //   196: aload_3
    //   197: aload_0
    //   198: aload_1
    //   199: invokespecial 291	com/tencent/mm/ui/widget/WXActionMenuView$1:<init>	(ZLcom/tencent/mm/ui/tools/t$a;Lcom/tencent/mm/ui/widget/WXActionMenuView$b;Landroid/app/Activity;Landroid/view/MenuItem;)V
    //   202: invokevirtual 135	com/tencent/mm/ui/widget/WXActionMenuView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   205: aload 10
    //   207: getstatic 294	com/tencent/mm/ah/a$g:menu_search	I
    //   210: aload_1
    //   211: invokevirtual 297	android/view/View:setTag	(ILjava/lang/Object;)V
    //   214: aload_1
    //   215: invokeinterface 301 1 0
    //   220: ifnonnull +10 -> 230
    //   223: aload 10
    //   225: bipush 8
    //   227: invokevirtual 304	android/view/View:setVisibility	(I)V
    //   230: ldc 230
    //   232: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload 10
    //   237: areturn
    //   238: iconst_0
    //   239: istore 6
    //   241: goto -136 -> 105
    //   244: aload_1
    //   245: invokeinterface 195 1 0
    //   250: ifnull +74 -> 324
    //   253: ldc 116
    //   255: ldc_w 306
    //   258: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_1
    //   262: invokeinterface 195 1 0
    //   267: invokevirtual 204	android/view/View:getParent	()Landroid/view/ViewParent;
    //   270: instanceof 206
    //   273: ifeq +24 -> 297
    //   276: aload_1
    //   277: invokeinterface 195 1 0
    //   282: invokevirtual 204	android/view/View:getParent	()Landroid/view/ViewParent;
    //   285: checkcast 206	android/view/ViewGroup
    //   288: aload_1
    //   289: invokeinterface 195 1 0
    //   294: invokevirtual 210	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   297: aload_1
    //   298: invokeinterface 195 1 0
    //   303: getstatic 294	com/tencent/mm/ah/a$g:menu_search	I
    //   306: aload_1
    //   307: invokevirtual 297	android/view/View:setTag	(ILjava/lang/Object;)V
    //   310: aload_1
    //   311: invokeinterface 195 1 0
    //   316: astore_0
    //   317: ldc 230
    //   319: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: aload_0
    //   323: areturn
    //   324: new 159	android/view/View
    //   327: dup
    //   328: aload_0
    //   329: invokespecial 309	android/view/View:<init>	(Landroid/content/Context;)V
    //   332: astore_0
    //   333: ldc 230
    //   335: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	353	4	paramw	com.tencent.mm.ui.w
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
    AppMethodBeat.i(192511);
    this.mActivity = paramActivity;
    this.Yei = paramb;
    this.Yej = parama;
    Log.i("MicroMsg.WXActionMenuView", "buildMMActionMenuView, menuCustomParam: %s.", new Object[] { parama });
    j(paramMenuItem);
    iac();
    AppMethodBeat.o(192511);
  }
  
  private int getShowAsAction()
  {
    AppMethodBeat.i(192498);
    try
    {
      Field localField = this.Yeh.getClass().getDeclaredField("mShowAsAction");
      localField.setAccessible(true);
      i = ((Integer)localField.get(this.Yeh)).intValue();
      AppMethodBeat.o(192498);
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
  
  private void iac()
  {
    AppMethodBeat.i(192507);
    if (this.Yeh == null)
    {
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction, mItemData is null");
      AppMethodBeat.o(192507);
      return;
    }
    if (this.Yeg != null) {
      this.Yeg.setVisibility(0);
    }
    int i = getShowAsAction();
    Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction, showAsAction: %s.", new Object[] { Integer.valueOf(i) });
    if (((i & 0x2) == 2) || ((i & 0x1) == 1) || ((i & 0x8) == 8))
    {
      if ((this.Yeh.getIcon() != null) && (this.Yef != null))
      {
        this.Yef.setVisibility(0);
        if (this.Yee != null) {
          this.Yee.setVisibility(8);
        }
        Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle gone, menuIcon show.");
        AppMethodBeat.o(192507);
        return;
      }
      if ((this.Yeh.getTitle() != null) && (this.Yee != null))
      {
        this.Yee.setVisibility(0);
        if (this.Yef != null) {
          this.Yef.setVisibility(8);
        }
        Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle show, menuIcon gone.");
        AppMethodBeat.o(192507);
        return;
      }
      if (this.Yef != null) {
        this.Yef.setVisibility(8);
      }
      if (this.Yee != null) {
        this.Yee.setVisibility(8);
      }
      if (this.Yeg != null) {
        this.Yeg.setVisibility(8);
      }
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is all gone");
      AppMethodBeat.o(192507);
      return;
    }
    if (((i & 0x4) == 4) || ((i & 0x0) == 0))
    {
      if (this.Yef != null) {
        this.Yef.setVisibility(8);
      }
      if ((this.Yeh.getTitle() != null) && (this.Yee != null))
      {
        this.Yee.setVisibility(0);
        if (this.Yef != null) {
          this.Yef.setVisibility(8);
        }
      }
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle show, menuIcon gone.");
      AppMethodBeat.o(192507);
      return;
    }
    if ((this.Yeh.getIcon() != null) && (this.Yef != null))
    {
      this.Yef.setVisibility(0);
      if (this.Yee != null) {
        this.Yee.setVisibility(8);
      }
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle gone, menuIcon show.");
      AppMethodBeat.o(192507);
      return;
    }
    if ((this.Yeh.getTitle() != null) && (this.Yee != null))
    {
      this.Yee.setVisibility(0);
      if (this.Yef != null) {
        this.Yef.setVisibility(8);
      }
      Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is menuTitle show, menuIcon gone.");
      AppMethodBeat.o(192507);
      return;
    }
    if (this.Yef != null) {
      this.Yef.setVisibility(8);
    }
    if (this.Yee != null) {
      this.Yee.setVisibility(8);
    }
    if (this.Yeg != null) {
      this.Yeg.setVisibility(8);
    }
    Log.i("MicroMsg.WXActionMenuView", "adapterMenuShowAsAction is all gone");
    AppMethodBeat.o(192507);
  }
  
  private void j(MenuItem paramMenuItem)
  {
    int i = 0;
    AppMethodBeat.i(192464);
    Log.i("MicroMsg.WXActionMenuView", "initialize : itemData: %s.", new Object[] { paramMenuItem });
    this.Yeh = paramMenuItem;
    this.ll = ((int)(this.Yej.Yep * this.mDensity + 0.5F));
    setMenuBackgroundColor(this.Yej.backgroundColor);
    setMenuBackgroundDrawble(this.Yej.backgroundDrawable);
    setMenuTitleTextColor(this.Yej.Yen);
    setMenuTitleTextSize(this.Yej.Yeo);
    int j = this.Yej.Yet;
    int k = this.Yej.Yeu;
    if ((this.Yeg != null) && (j > 0) && (k > 0)) {
      this.Yef.setLayoutParams(new ViewGroup.LayoutParams(j, k));
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
      AppMethodBeat.o(192464);
      return;
      i = 8;
    }
  }
  
  private void setMenuBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(192468);
    if (this.Yeg != null) {
      this.Yeg.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(192468);
  }
  
  private void setMenuBackgroundDrawble(Drawable paramDrawable)
  {
    AppMethodBeat.i(192469);
    if ((this.Yeg != null) && (paramDrawable != null)) {
      this.Yeg.setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(192469);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(192455);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/WXActionMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((paramView == this.Yeg) && (this.Yei != null)) {
      this.Yei.b(this.mActivity, this.Yeh);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/WXActionMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(192455);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(192473);
    this.eK = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      float f;
      if (m > this.ll)
      {
        f = this.ll / m;
        i = this.ll;
        j = (int)(k * f);
      }
      m = j;
      k = i;
      if (j > this.ll)
      {
        f = this.ll / j;
        m = this.ll;
        k = (int)(i * f);
      }
      paramDrawable.setBounds(0, 0, k, m);
    }
    setMenuIcon(paramDrawable);
    AppMethodBeat.o(192473);
  }
  
  public void setMenuIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(192483);
    if (this.Yef != null)
    {
      this.Yef.setImageDrawable(paramDrawable);
      if (!Util.isNullOrNil(this.cZ)) {
        this.Yef.setContentDescription(this.cZ);
      }
    }
    AppMethodBeat.o(192483);
  }
  
  public void setMenuTitleText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(192481);
    if (this.Yee != null)
    {
      this.Yee.setText(paramCharSequence);
      this.Yee.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(192481);
  }
  
  public void setMenuTitleTextColor(int paramInt)
  {
    AppMethodBeat.i(192479);
    if ((this.Yee != null) && (paramInt > 0)) {
      this.Yee.setTextColor(paramInt);
    }
    AppMethodBeat.o(192479);
  }
  
  public void setMenuTitleTextSize(float paramFloat)
  {
    AppMethodBeat.i(192475);
    if ((this.Yee != null) && (paramFloat > 0.0F)) {
      this.Yee.setTextSize(paramFloat);
    }
    AppMethodBeat.o(192475);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(192474);
    this.cZ = paramCharSequence;
    setMenuTitleText(this.cZ);
    AppMethodBeat.o(192474);
  }
  
  public static final class a
  {
    public int VQW;
    public int Yen = -1;
    public float Yeo = -1.0F;
    public int Yep = 32;
    public int Yeq = 4;
    public boolean Yer = true;
    public boolean Yes = false;
    public int Yet = -1;
    public int Yeu = -1;
    public String Yev = "";
    public Drawable Yew;
    public int backgroundColor;
    public Drawable backgroundDrawable;
    boolean rED = false;
    
    public final String toString()
    {
      AppMethodBeat.i(193012);
      String str = "MenuCustomParam{menuTextColor=" + this.Yen + ", menuTextSize=" + this.Yeo + ", maxIconSize=" + this.Yep + ", maxMenuSize=" + this.Yeq + ", needTitleCenterMode=" + this.Yer + ", useOrginalSysMode=" + this.Yes + ", normalActionbarHeight=" + this.VQW + ", previewIconWidth=" + this.Yet + ", previewIconHeight=" + this.Yeu + ", menuText='" + this.Yev + '\'' + ", iconDrawabled=" + this.Yew + ", hide=" + this.rED + ", backgroundColor=" + this.backgroundColor + ", backgroundDrawable=" + this.backgroundDrawable + '}';
      AppMethodBeat.o(193012);
      return str;
    }
    
    public static final class a
    {
      public static WXActionMenuView.a Yex;
      
      public a()
      {
        AppMethodBeat.i(222037);
        Yex = new WXActionMenuView.a();
        AppMethodBeat.o(222037);
      }
      
      public final a Hq(boolean paramBoolean)
      {
        Yex.Yer = paramBoolean;
        return this;
      }
      
      public final a Hr(boolean paramBoolean)
      {
        Yex.Yes = paramBoolean;
        return this;
      }
      
      public final a axF(int paramInt)
      {
        Yex.VQW = paramInt;
        return this;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean b(Activity paramActivity, MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.WXActionMenuView
 * JD-Core Version:    0.7.0.1
 */