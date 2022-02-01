package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper;", "", "()V", "Companion", "plugin-webview_release"})
public final class f
{
  public static final a Jfx;
  private static final String TAG = "MicroMsg.WebViewUI.SMSQueryHelper";
  
  static
  {
    AppMethodBeat.i(210375);
    Jfx = new a((byte)0);
    TAG = "MicroMsg.WebViewUI.SMSQueryHelper";
    AppMethodBeat.o(210375);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper$Companion;", "", "()V", "TAG", "", "getMsgText", "context", "Landroid/content/Context;", "url", "handleSMSQuery", "", "showDialog", "msg", "plugin-webview_release"})
  public static final class a
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      public a(Context paramContext, String paramString1, String paramString2)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class b
      implements f.c
    {
      b(Uri paramUri, Context paramContext) {}
      
      public final void e(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(210372);
        if (paramBoolean)
        {
          Object localObject = new Intent("android.intent.action.SENDTO", this.IMQ);
          ((Intent)localObject).addFlags(268435456);
          try
          {
            paramString = this.$context;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper$Companion$showDialog$build$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper$Companion$showDialog$build$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(210372);
            return;
          }
          catch (Exception paramString)
          {
            Log.e(f.access$getTAG$cp(), "start sms app failed:[%s]", new Object[] { paramString.getMessage() });
          }
        }
        AppMethodBeat.o(210372);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class c
      implements DialogInterface.OnDismissListener
    {
      public static final c Jfy;
      
      static
      {
        AppMethodBeat.i(210374);
        Jfy = new c();
        AppMethodBeat.o(210374);
      }
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(210373);
        Log.d(f.access$getTAG$cp(), "OnDismissListener ");
        AppMethodBeat.o(210373);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */