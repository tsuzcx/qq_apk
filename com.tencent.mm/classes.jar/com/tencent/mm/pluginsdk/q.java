package com.tencent.mm.pluginsdk;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.c;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/IRecentForwardMenuHelper;", "Lcom/tencent/mm/kernel/service/IService;", "addMenus", "", "context", "Landroid/content/Context;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "overrideAvatarLoader", "Lcom/tencent/mm/ui/base/MMMenuListener$IImageLoader;", "type", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "show", "addQuickShare", "bottomSheet", "clickCb", "", "userName", "alive", "createRecentForwardMenuHelper", "dead", "disableQuickMenuItems", "getItemCount", "onMenuItemSelect", "Lcom/tencent/mm/ui/base/MMMenuItem;", "onMenuLongSelect", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface q
  extends a
{
  public abstract void a(Context paramContext, s params, f paramf);
  
  public abstract void a(Context paramContext, s params, f paramf, int paramInt, b<? super Boolean, ah> paramb);
  
  public abstract void a(Context paramContext, s params, f paramf, u.c paramc, int paramInt, b<? super Boolean, ah> paramb);
  
  public abstract void a(Context paramContext, f paramf, b<? super String, ah> paramb);
  
  public abstract void a(f paramf, s params);
  
  public abstract boolean a(t paramt, b<? super String, ah> paramb);
  
  public abstract boolean a(f paramf, t paramt);
  
  public abstract boolean a(f paramf, t paramt, int paramInt);
  
  public abstract int getItemCount();
  
  public abstract q iGI();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.q
 * JD-Core Version:    0.7.0.1
 */