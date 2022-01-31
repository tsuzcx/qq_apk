package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import a.a.e;
import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.t;
import a.g;
import a.j.k;
import a.l;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$CommonSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "picCntTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "Lkotlin/Lazy;", "picInfo", "Landroid/support/constraint/ConstraintLayout;", "getPicInfo", "()Landroid/support/constraint/ConstraintLayout;", "picInfo$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "titleTv$delegate", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "app_release"})
final class c$b
  extends c.e
{
  private final int pEK;
  private final f pEL;
  final f pEM;
  final f pEN;
  private final f pEO;
  private String title;
  
  static
  {
    AppMethodBeat.i(154067);
    eOJ = new k[] { (k)a.f.b.v.a(new t(a.f.b.v.aG(b.class), "picInfo", "getPicInfo()Landroid/support/constraint/ConstraintLayout;")), (k)a.f.b.v.a(new t(a.f.b.v.aG(b.class), "picCntTv", "getPicCntTv()Landroid/widget/TextView;")), (k)a.f.b.v.a(new t(a.f.b.v.aG(b.class), "showDescTv", "getShowDescTv()Landroid/widget/TextView;")), (k)a.f.b.v.a(new t(a.f.b.v.aG(b.class), "titleTv", "getTitleTv()Lcom/tencent/mm/ui/widget/MMNeat7extView;")) };
    AppMethodBeat.o(154067);
  }
  
  public c$b(int paramInt, c.d paramd, ViewGroup paramViewGroup)
  {
    super(paramInt, paramd, paramViewGroup);
    AppMethodBeat.i(154073);
    this.pEK = 2130839987;
    this.pEL = g.j((a)new c.b.b(this));
    this.pEM = g.j((a)new c.b.a(this));
    this.pEN = g.j((a)new c.b.c(this));
    this.pEO = g.j((a)new c.b.d(this));
    this.title = "";
    AppMethodBeat.o(154073);
  }
  
  protected final void a(View paramView, c.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(154069);
    j.q(paramView, "container");
    j.q(paramd, "slotType");
    Object localObject1;
    switch (d.bLo[paramd.ordinal()])
    {
    default: 
      switch (this.fgh)
      {
      case 6: 
      case 9: 
      default: 
        localObject1 = paramView.findViewById(2131823046);
        j.p(localObject1, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject1).setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      super.a(paramView, paramd, paramBoolean);
      AppMethodBeat.o(154069);
      return;
      localObject1 = paramView.findViewById(2131823057);
      j.p(localObject1, "container.findViewById<V…d.biz_slot_common_line_v)");
      ((View)localObject1).setVisibility(0);
      break;
      localObject1 = paramView.findViewById(2131823046);
      j.p(localObject1, "container.findViewById<I…iew>(R.id.biz_slot_image)");
      ((ImageView)localObject1).setVisibility(0);
      localObject1 = paramView.findViewById(2131823050);
      j.p(localObject1, "container.findViewById<I….biz_slot_video_play_img)");
      ((ImageView)localObject1).setVisibility(0);
      continue;
      localObject1 = paramView.findViewById(2131823046);
      j.p(localObject1, "container.findViewById<I…iew>(R.id.biz_slot_image)");
      ((ImageView)localObject1).setVisibility(0);
      localObject1 = paramView.findViewById(2131823051);
      j.p(localObject1, "container.findViewById<C…slot_common_content_desc)");
      ((ConstraintLayout)localObject1).setVisibility(0);
      continue;
      localObject1 = paramView.findViewById(2131823049);
      j.p(localObject1, "container.findViewById<I…iew>(R.id.biz_slot_voice)");
      ((ImageView)localObject1).setVisibility(0);
      continue;
      localObject1 = (MMNeat7extView)paramView.findViewById(2131823055);
      j.p(localObject1, "tv");
      Object localObject2 = ((MMNeat7extView)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        paramView = new a.v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(154069);
        throw paramView;
      }
      localObject2 = (ConstraintLayout.LayoutParams)localObject2;
      ((ConstraintLayout.LayoutParams)localObject2).setMarginEnd(0);
      ((MMNeat7extView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = paramView.findViewById(2131823046);
      j.p(localObject1, "container.findViewById<I…iew>(R.id.biz_slot_image)");
      ((ImageView)localObject1).setVisibility(8);
    }
  }
  
  protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(154068);
    j.q(paramContext, "context");
    j.q(paramViewGroup, "container");
    paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969223, paramViewGroup, false);
    if (paramContext == null)
    {
      paramContext = new a.v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(154068);
      throw paramContext;
    }
    paramContext = (ViewGroup)paramContext;
    paramViewGroup.addView((View)paramContext);
    AppMethodBeat.o(154068);
    return paramContext;
  }
  
  protected final void ccW()
  {
    AppMethodBeat.i(154070);
    ConstraintLayout localConstraintLayout = (ConstraintLayout)this.pEL.getValue();
    if (localConstraintLayout != null)
    {
      localConstraintLayout.setBackgroundResource(2130837928);
      AppMethodBeat.o(154070);
      return;
    }
    AppMethodBeat.o(154070);
  }
  
  protected final float[] ccX()
  {
    AppMethodBeat.i(154071);
    float[] arrayOfFloat = e.a(new Float[] { Float.valueOf(aU(1.0F)), Float.valueOf(aU(1.0F)), Float.valueOf(aU(1.0F)), Float.valueOf(aU(1.0F)) });
    AppMethodBeat.o(154071);
    return arrayOfFloat;
  }
  
  protected final int ccY()
  {
    return this.pEK;
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(154072);
    j.q(paramString, "value");
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.pEO.getValue();
    j.p(localMMNeat7extView, "titleTv");
    a(localMMNeat7extView, paramString);
    AppMethodBeat.o(154072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.b
 * JD-Core Version:    0.7.0.1
 */