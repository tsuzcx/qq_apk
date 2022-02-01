package com.tencent.mm.plugin.textstatus.f;

import android.view.View;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.h.f.b;
import com.tencent.mm.plugin.textstatus.proto.t;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "", "statusCardEventListener", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;", "getStatusCardEventListener", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;", "setStatusCardEventListener", "(Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;)V", "destroyCustomElementsManual", "", "destroyCustomPartsManual", "getCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "goProfile", "goReferenceEdit", "init", "contentView", "Landroid/view/View;", "onStatusPause", "setDescExtraSpaceClickCallback", "callback", "Lkotlin/Function0;", "update", "", "username", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "extraParam", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "updateLikeNum", "StatusCardEventListener", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
{
  public abstract void a(a parama);
  
  public abstract boolean aRF(String paramString);
  
  public abstract boolean b(String paramString, b paramb, t paramt);
  
  public abstract void bO(a<ah> parama);
  
  public abstract void g(View paramView);
  
  public abstract void hHt();
  
  public abstract void hHu();
  
  public abstract void hHv();
  
  public abstract void hHw();
  
  public abstract k hHx();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;", "", "beforeJumpDetail", "", "beforeJumpSource", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void gpi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.e
 * JD-Core Version:    0.7.0.1
 */