package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "", "itemType", "", "(I)V", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "isDefault", "", "()Z", "setDefault", "(Z)V", "getItemType", "()I", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "getResolveInfo", "()Landroid/content/pm/ResolveInfo;", "setResolveInfo", "(Landroid/content/pm/ResolveInfo;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Companion", "ItemType", "plugin-webview_release"})
public final class f
{
  public static final f.a JlO;
  public Drawable JlN;
  public final int dUm;
  public ResolveInfo resolveInfo;
  public String title;
  
  static
  {
    AppMethodBeat.i(210441);
    JlO = new f.a((byte)0);
    AppMethodBeat.o(210441);
  }
  
  public f(int paramInt)
  {
    this.dUm = paramInt;
    this.title = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.f
 * JD-Core Version:    0.7.0.1
 */