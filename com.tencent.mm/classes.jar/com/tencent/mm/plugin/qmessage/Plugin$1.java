package com.tencent.mm.plugin.qmessage;

import android.content.Context;

final class Plugin$1
  implements com.tencent.mm.pluginsdk.b.b
{
  Plugin$1(Plugin paramPlugin) {}
  
  public final com.tencent.mm.pluginsdk.b.a Y(Context paramContext, String paramString)
  {
    if ("widget_type_contact".equals(paramString)) {
      return new com.tencent.mm.plugin.qmessage.ui.a(paramContext);
    }
    return new com.tencent.mm.plugin.qmessage.ui.b(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.Plugin.1
 * JD-Core Version:    0.7.0.1
 */