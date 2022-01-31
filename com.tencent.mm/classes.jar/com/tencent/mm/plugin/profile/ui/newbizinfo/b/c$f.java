package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import a.a.e;
import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.t;
import a.g;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$TopSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "collapseTextLayout", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "getCollapseTextLayout", "()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "collapseTextLayout$delegate", "Lkotlin/Lazy;", "descMask", "Landroid/view/View;", "getDescMask", "()Landroid/view/View;", "descMask$delegate", "digestTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigestTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "digestTv$delegate", "value", "", "hasAudioDesc", "getHasAudioDesc", "()Z", "setHasAudioDesc", "(Z)V", "hasDesc", "setHasDesc", "hasSingleInfo", "hasTitle", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isSingleImage", "picCntTv", "Landroid/widget/TextView;", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "singleDescLayout", "getSingleDescLayout", "singleDescLayout$delegate", "singleTitleTv", "getSingleTitleTv", "singleTitleTv$delegate", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleDescViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "titleTv", "getTitleTv", "titleTv$delegate", "topMask", "Landroid/widget/ImageView;", "getTopMask", "()Landroid/widget/ImageView;", "topMask$delegate", "videPlayImg", "getVidePlayImg", "videPlayImg$delegate", "videoDurationTv", "getVideoDurationTv", "videoDurationTv$delegate", "voiceDurationTv", "getVoiceDurationTv", "voiceDurationTv$delegate", "fillBackground", "", "selector", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "onImageLoadStart", "setText", "id", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "text", "setTitleDescTextColor", "color", "app_release"})
final class c$f
  extends c.e
{
  final f pEM;
  final f pEN;
  private final f pEO;
  private boolean pFj;
  private boolean pFk;
  private boolean pFl;
  private ArrayList<View> pFm;
  private final f pFn;
  private final f pFo;
  final f pFp;
  final f pFq;
  private final f pFr;
  private final f pFs;
  private final f pFt;
  final f pFu;
  private final f pFv;
  boolean pFw;
  private String title;
  
  static
  {
    AppMethodBeat.i(154110);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "topMask", "getTopMask()Landroid/widget/ImageView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "descMask", "getDescMask()Landroid/view/View;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "showDescTv", "getShowDescTv()Landroid/widget/TextView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "videoDurationTv", "getVideoDurationTv()Landroid/widget/TextView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "voiceDurationTv", "getVoiceDurationTv()Landroid/widget/TextView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "picCntTv", "getPicCntTv()Landroid/widget/TextView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "titleTv", "getTitleTv()Lcom/tencent/mm/ui/widget/MMNeat7extView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "videPlayImg", "getVidePlayImg()Landroid/widget/ImageView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "singleDescLayout", "getSingleDescLayout()Landroid/view/View;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "singleTitleTv", "getSingleTitleTv()Lcom/tencent/mm/ui/widget/MMNeat7extView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "digestTv", "getDigestTv()Lcom/tencent/mm/ui/widget/MMNeat7extView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(f.class), "collapseTextLayout", "getCollapseTextLayout()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;")) };
    AppMethodBeat.o(154110);
  }
  
  public c$f(int paramInt, c.d paramd, ViewGroup paramViewGroup)
  {
    super(paramInt, paramd, paramViewGroup);
    AppMethodBeat.i(154125);
    this.pFm = new ArrayList();
    this.pFn = g.j((a)new c.f.k(this));
    this.pFo = g.j((a)new c.f.b(this));
    this.pEN = g.j((a)new c.f.g(this));
    this.pFp = g.j((a)new c.f.m(this));
    this.pFq = g.j((a)new c.f.n(this));
    this.pEM = g.j((a)new c.f.d(this));
    this.pEO = g.j((a)new c.f.j(this, paramInt));
    this.pFr = g.j((a)new c.f.l(this));
    this.pFs = g.j((a)new c.f.h(this));
    this.pFt = g.j((a)new i(this));
    this.pFu = g.j((a)new c.f.c(this));
    this.pFv = g.j((a)new c.f.a(this));
    this.title = "";
    AppMethodBeat.o(154125);
  }
  
  private final void BP(int paramInt)
  {
    AppMethodBeat.i(154124);
    Iterator localIterator = ((Iterable)this.pFm).iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((localView instanceof TextView)) {
        ((TextView)localView).setTextColor(paramInt);
      } else if ((localView instanceof MMNeat7extView)) {
        ((MMNeat7extView)localView).setTextColor(paramInt);
      }
    }
    AppMethodBeat.o(154124);
  }
  
  private final void cdc()
  {
    AppMethodBeat.i(154115);
    this.pFj = true;
    if (this.fgh == 5)
    {
      Object localObject = cdg();
      j.p(localObject, "videPlayImg");
      localObject = ((ImageView)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new a.v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(154115);
        throw ((Throwable)localObject);
      }
      localObject = (ConstraintLayout.LayoutParams)localObject;
      if (((ConstraintLayout.LayoutParams)localObject).verticalBias != 0.56F)
      {
        ((ConstraintLayout.LayoutParams)localObject).verticalBias = 0.56F;
        ImageView localImageView = cdg();
        j.p(localImageView, "videPlayImg");
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    AppMethodBeat.o(154115);
  }
  
  private final boolean cdd()
  {
    return (this.pFd == c.d.pET) && (!this.pFl);
  }
  
  private final ImageView cde()
  {
    AppMethodBeat.i(154116);
    ImageView localImageView = (ImageView)this.pFn.getValue();
    AppMethodBeat.o(154116);
    return localImageView;
  }
  
  private final MMNeat7extView cdf()
  {
    AppMethodBeat.i(154117);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.pEO.getValue();
    AppMethodBeat.o(154117);
    return localMMNeat7extView;
  }
  
  private final ImageView cdg()
  {
    AppMethodBeat.i(154118);
    ImageView localImageView = (ImageView)this.pFr.getValue();
    AppMethodBeat.o(154118);
    return localImageView;
  }
  
  protected final void a(View paramView, c.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(154112);
    j.q(paramView, "container");
    j.q(paramd, "slotType");
    switch (this.fgh)
    {
    case 8: 
    case 9: 
    default: 
      paramView.setPadding(0, 0, 0, 0);
      paramView.setBackgroundResource(0);
      AppMethodBeat.o(154112);
      return;
    case 6: 
    case 7: 
      if (paramd == c.d.pEQ)
      {
        View localView = paramView.findViewById(2131823069);
        j.p(localView, "container.findViewById<V…R.id.biz_slot_top_line_v)");
        localView.setVisibility(0);
      }
      super.a(paramView, paramd, false);
      paramView.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(154112);
      return;
    }
    super.a(paramView, paramd, false);
    AppMethodBeat.o(154112);
  }
  
  protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(154111);
    j.q(paramContext, "context");
    j.q(paramViewGroup, "container");
    paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969227, paramViewGroup, false);
    if (paramContext == null)
    {
      paramContext = new a.v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(154111);
      throw paramContext;
    }
    paramContext = (ViewGroup)paramContext;
    int i;
    switch (this.fgh)
    {
    case 9: 
    default: 
      i = 2131823063;
    }
    for (;;)
    {
      ((ViewStub)paramContext.findViewById(i)).inflate();
      paramViewGroup.addView((View)paramContext);
      AppMethodBeat.o(154111);
      return paramContext;
      i = 2131823064;
      continue;
      cdc();
      i = 2131823065;
      continue;
      i = 2131823067;
      continue;
      i = 2131823066;
    }
  }
  
  protected final void ccW()
  {
    AppMethodBeat.i(154123);
    Object localObject = getContext();
    j.p(localObject, "context");
    BP(((Context)localObject).getResources().getColor(2131690709));
    if (this.pFj)
    {
      localObject = (View)this.pFo.getValue();
      if (!cdd()) {
        break label113;
      }
      if (this.pFk)
      {
        i = 2130839993;
        ((View)localObject).setBackgroundResource(i);
      }
    }
    else
    {
      localObject = cde();
      if (this.pFd != c.d.pEQ) {
        break label134;
      }
    }
    label134:
    for (int i = 2130837945;; i = 2130837947)
    {
      ((ImageView)localObject).setBackgroundResource(i);
      AppMethodBeat.o(154123);
      return;
      i = 2130839992;
      break;
      label113:
      if (this.pFk)
      {
        i = 2130839991;
        break;
      }
      i = 2130839990;
      break;
    }
  }
  
  protected final float[] ccX()
  {
    AppMethodBeat.i(154113);
    if (cdd())
    {
      arrayOfFloat = e.a(new Float[] { Float.valueOf(aU(8.0F)), Float.valueOf(aU(8.0F)), Float.valueOf(aU(8.0F)), Float.valueOf(aU(8.0F)) });
      AppMethodBeat.o(154113);
      return arrayOfFloat;
    }
    float[] arrayOfFloat = e.a(new Float[] { Float.valueOf(aU(8.0F)), Float.valueOf(aU(8.0F)), Float.valueOf(0.0F), Float.valueOf(0.0F) });
    AppMethodBeat.o(154113);
    return arrayOfFloat;
  }
  
  protected final int ccY()
  {
    AppMethodBeat.i(154114);
    if (cdd())
    {
      AppMethodBeat.o(154114);
      return 2130839988;
    }
    AppMethodBeat.o(154114);
    return 2130839989;
  }
  
  protected final void cdb()
  {
    AppMethodBeat.i(154122);
    Context localContext = getContext();
    j.p(localContext, "context");
    BP(localContext.getResources().getColor(2131690208));
    AppMethodBeat.o(154122);
  }
  
  final View cdh()
  {
    AppMethodBeat.i(154119);
    View localView = (View)this.pFs.getValue();
    AppMethodBeat.o(154119);
    return localView;
  }
  
  public final MMCollapsibleTextView cdi()
  {
    AppMethodBeat.i(154120);
    MMCollapsibleTextView localMMCollapsibleTextView = (MMCollapsibleTextView)this.pFv.getValue();
    AppMethodBeat.o(154120);
    return localMMCollapsibleTextView;
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(154121);
    j.q(paramString, "value");
    switch (this.fgh)
    {
    default: 
      if (this.pFd != c.d.pET) {
        break;
      }
    }
    for (MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.pFt.getValue();; localMMNeat7extView = cdf())
    {
      j.p(localMMNeat7extView, "if (slotType == SlotType…ingleTitleTv else titleTv");
      a(localMMNeat7extView, paramString);
      AppMethodBeat.o(154121);
      return;
      localMMNeat7extView = cdf();
      j.p(localMMNeat7extView, "titleTv");
      a(localMMNeat7extView, paramString);
      paramString = cde();
      if (this.pFd == c.d.pEQ) {}
      for (int i = 2130837947;; i = 2130837945)
      {
        paramString.setBackgroundResource(i);
        AppMethodBeat.o(154121);
        return;
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends a.f.b.k
    implements a<MMNeat7extView>
  {
    i(c.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.f
 * JD-Core Version:    0.7.0.1
 */