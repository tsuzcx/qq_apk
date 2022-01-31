package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import a.f.b.t;
import a.f.b.v;
import a.l;
import a.l.m;
import a.n;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.a.c.b;
import com.tencent.mm.at.o;
import com.tencent.mm.at.q;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "audioPadding", "getAudioPadding", "()I", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "imageDefaultRes", "getImageDefaultRes", "imageIv", "Landroid/widget/ImageView;", "getImageIv", "()Landroid/widget/ImageView;", "imageIv$delegate", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "value", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "item", "getItem", "()Landroid/view/ViewGroup;", "item$delegate", "getItemShowType", "largePading", "getLargePading", "listPadding", "getListPadding", "normalPading", "getNormalPading", "getSlotType", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "smallPadding", "getSmallPadding", "dpToPixel", "", "getDpToPixel", "(F)F", "resFromRaw", "getResFromRaw", "(I)F", "resToPixel", "getResToPixel", "(I)I", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "app_release"})
class c$e
{
  private String ffp;
  final int fgh;
  private final int nfo;
  private final int pEK;
  private final a.f pEV;
  private final a.f pEW;
  private final a.f pEX;
  final int pEY;
  private final int pEZ;
  final int pFa;
  final int pFb;
  private final float[] pFc;
  final c.d pFd;
  
  static
  {
    AppMethodBeat.i(154084);
    eOJ = new a.j.k[] { (a.j.k)v.a(new t(v.aG(e.class), "item", "getItem()Landroid/view/ViewGroup;")), (a.j.k)v.a(new t(v.aG(e.class), "imageIv", "getImageIv()Landroid/widget/ImageView;")), (a.j.k)v.a(new t(v.aG(e.class), "context", "getContext()Landroid/content/Context;")) };
    AppMethodBeat.o(154084);
  }
  
  public c$e(int paramInt, c.d paramd, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(154094);
    this.fgh = paramInt;
    this.pFd = paramd;
    this.pEV = a.g.j((a.f.a.a)new c.e.e(this, paramViewGroup));
    this.pEW = a.g.j((a.f.a.a)new b(this));
    this.pEX = a.g.j((a.f.a.a)new c.e.a(this));
    this.pEY = ((int)aU(36.0F));
    this.pEZ = ah.getResources().getDimensionPixelSize(2131427781);
    this.pFa = ah.getResources().getDimensionPixelSize(2131427808);
    this.pFb = ah.getResources().getDimensionPixelSize(2131427772);
    this.nfo = ah.getResources().getDimensionPixelSize(2131427854);
    this.pFc = a.a.e.a(new Float[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) });
    this.pEK = 2131689878;
    this.ffp = "";
    AppMethodBeat.o(154094);
  }
  
  protected static void a(MMNeat7extView paramMMNeat7extView, String paramString)
  {
    AppMethodBeat.i(154091);
    a.f.b.j.q(paramMMNeat7extView, "neatText");
    a.f.b.j.q(paramString, "text");
    paramMMNeat7extView.af((CharSequence)com.tencent.mm.pluginsdk.ui.d.j.b(paramMMNeat7extView.getContext(), (CharSequence)paramString));
    AppMethodBeat.o(154091);
  }
  
  protected static float aU(float paramFloat)
  {
    AppMethodBeat.i(154093);
    Resources localResources = ah.getResources();
    a.f.b.j.p(localResources, "MMApplicationContext.getResources()");
    float f = localResources.getDisplayMetrics().density;
    AppMethodBeat.o(154093);
    return f * paramFloat + 0.5F;
  }
  
  private final ImageView cda()
  {
    AppMethodBeat.i(154086);
    ImageView localImageView = (ImageView)this.pEW.getValue();
    AppMethodBeat.o(154086);
    return localImageView;
  }
  
  protected void a(View paramView, c.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(154089);
    a.f.b.j.q(paramView, "container");
    a.f.b.j.q(paramd, "slotType");
    int i;
    switch (e.bLo[paramd.ordinal()])
    {
    default: 
      AppMethodBeat.o(154089);
      return;
    case 1: 
      paramView.setPadding(this.pFb, this.nfo, this.pFb, 0);
      if (paramBoolean) {}
      for (i = 2130837940;; i = 2130837938)
      {
        paramView.setBackgroundResource(i);
        AppMethodBeat.o(154089);
        return;
      }
    case 2: 
      paramView.setPadding(this.pFb, this.nfo, this.pFb, 0);
      i = 2130837934;
    }
    for (;;)
    {
      paramView.setBackgroundResource(i);
      break;
      paramView.setPadding(this.pFb, this.nfo, this.pFb, this.pFb);
      i = 2130837933;
      continue;
      paramView.setPadding(this.pFb, this.nfo, this.pFb, this.nfo);
      if (paramBoolean) {
        i = 2130837937;
      } else {
        i = 2130837935;
      }
    }
  }
  
  protected ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(154087);
    a.f.b.j.q(paramContext, "context");
    a.f.b.j.q(paramViewGroup, "container");
    paramContext = (Throwable)new n();
    AppMethodBeat.o(154087);
    throw paramContext;
  }
  
  protected void ccW() {}
  
  protected float[] ccX()
  {
    return this.pFc;
  }
  
  protected int ccY()
  {
    return this.pEK;
  }
  
  public final ViewGroup ccZ()
  {
    AppMethodBeat.i(154085);
    ViewGroup localViewGroup = (ViewGroup)this.pEV.getValue();
    AppMethodBeat.o(154085);
    return localViewGroup;
  }
  
  protected void cdb() {}
  
  protected final Context getContext()
  {
    AppMethodBeat.i(154088);
    Context localContext = (Context)this.pEX.getValue();
    AppMethodBeat.o(154088);
    return localContext;
  }
  
  public final void setImageUrl(String paramString)
  {
    AppMethodBeat.i(154092);
    a.f.b.j.q(paramString, "value");
    if (m.ap((CharSequence)paramString)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(154092);
      return;
    }
    paramString = q.ts(paramString);
    a.f.b.j.p(paramString, "WebpUtil.getUrl(value)");
    this.ffp = paramString;
    paramString = c.pEB;
    ab.v(c.access$getTAG$cp(), "imageUrl:" + this.ffp);
    paramString = ccX();
    String str = this.ffp;
    Object localObject1 = new c.a().ahU();
    Object localObject2 = new StringBuilder("radius_");
    Object localObject3 = Arrays.toString(paramString);
    a.f.b.j.p(localObject3, "java.util.Arrays.toString(this)");
    localObject1 = ((c.a)localObject1).tA((String)localObject3).lI(ccY()).a((b)new com.tencent.mm.pluginsdk.ui.applet.f()).ty(p.aln(this.ffp)).ahY();
    localObject2 = new c.e.d(this);
    localObject3 = new com.tencent.mm.pluginsdk.ui.applet.e(-1, -1, paramString, (e.a)localObject2);
    ((com.tencent.mm.pluginsdk.ui.applet.e)localObject3).aa((Runnable)new c.e.c(this, str, (com.tencent.mm.at.a.a.c)localObject1, paramString, (c.e.d)localObject2));
    o.ahG().a(str, cda(), (com.tencent.mm.at.a.a.c)localObject1, (com.tencent.mm.at.a.c.g)localObject3);
    AppMethodBeat.o(154092);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends a.f.b.k
    implements a.f.a.a<ImageView>
  {
    b(c.e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.e
 * JD-Core Version:    0.7.0.1
 */