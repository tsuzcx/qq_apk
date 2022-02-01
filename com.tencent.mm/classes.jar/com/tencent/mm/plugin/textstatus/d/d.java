package com.tencent.mm.plugin.textstatus.d;

import android.view.View;
import com.tencent.mm.plugin.textstatus.f.f.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "", "init", "", "contentView", "Landroid/view/View;", "setLoadLogicParam", "loadLogicParam", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;", "update", "", "username", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "LoadLogicParam", "plugin-textstatus_release"})
public abstract interface d
{
  public abstract void a(a parama);
  
  public abstract boolean aNc(String paramString);
  
  public abstract boolean b(String paramString, a parama);
  
  public abstract void ba(View paramView);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;", "", "isLoadThumb", "", "(Z)V", "()Z", "setLoadThumb", "plugin-textstatus_release"})
  public static final class a
  {
    boolean FYG;
    
    public a(boolean paramBoolean)
    {
      this.FYG = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.d.d
 * JD-Core Version:    0.7.0.1
 */