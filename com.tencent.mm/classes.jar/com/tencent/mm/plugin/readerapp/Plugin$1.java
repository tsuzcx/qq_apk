package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class Plugin$1
  implements com.tencent.mm.pluginsdk.b.b
{
  Plugin$1(Plugin paramPlugin) {}
  
  public final a Y(Context paramContext, String paramString)
  {
    y.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", new Object[] { paramString });
    if ("widget_type_news".equals(paramString)) {
      return new com.tencent.mm.plugin.readerapp.ui.b(paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.Plugin.1
 * JD-Core Version:    0.7.0.1
 */