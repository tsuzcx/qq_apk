package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "", "itemType", "", "(I)V", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "isDefault", "", "()Z", "setDefault", "(Z)V", "getItemType", "()I", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "getResolveInfo", "()Landroid/content/pm/ResolveInfo;", "setResolveInfo", "(Landroid/content/pm/ResolveInfo;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Companion", "ItemType", "plugin-webview_release"})
public final class f
{
  public static final a Qjg;
  public Drawable Qjf;
  public final int fNO;
  public ResolveInfo pN;
  public String title;
  
  static
  {
    AppMethodBeat.i(254240);
    Qjg = new a((byte)0);
    AppMethodBeat.o(254240);
  }
  
  public f(int paramInt)
  {
    this.fNO = paramInt;
    this.title = "";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.f
 * JD-Core Version:    0.7.0.1
 */