package com.tencent.mm.plugin.textstatus.e;

import android.view.View;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "", "destroyCustomPartsManual", "", "getCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "init", "contentView", "Landroid/view/View;", "setDescExtraSpaceClickCallback", "callback", "Lkotlin/Function0;", "update", "", "username", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "extraParam", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "plugin-textstatus_release"})
public abstract interface e
{
  public abstract boolean aUx(String paramString);
  
  public abstract void ag(kotlin.g.a.a<x> parama);
  
  public abstract boolean b(String paramString, com.tencent.mm.plugin.textstatus.g.e.a parama, com.tencent.mm.plugin.textstatus.proto.i parami);
  
  public abstract void g(View paramView);
  
  public abstract com.tencent.mm.plugin.textstatus.a.i glR();
  
  public abstract void glS();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.e
 * JD-Core Version:    0.7.0.1
 */