package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper;", "", "()V", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private static final String TAG;
  public static final a WUj;
  
  static
  {
    AppMethodBeat.i(296235);
    WUj = new a((byte)0);
    TAG = "MicroMsg.WebViewUI.SMSQueryHelper";
    AppMethodBeat.o(296235);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper$Companion;", "", "()V", "TAG", "", "getMsgText", "context", "Landroid/content/Context;", "url", "handleSMSQuery", "", "showDialog", "msg", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final void F(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(296224);
      Log.d(i.access$getTAG$cp(), "OnDismissListener ");
      AppMethodBeat.o(296224);
    }
    
    public static void Y(Context paramContext, String paramString1, String paramString2)
    {
      AppMethodBeat.i(296213);
      s.u(paramContext, "context");
      s.u(paramString1, "msg");
      s.u(paramString2, "url");
      paramString2 = Uri.parse(paramString2);
      new g.a(paramContext).bDE(paramString1).NF(true).c(new i.a..ExternalSyntheticLambda1(paramString2, paramContext)).d(i.a..ExternalSyntheticLambda0.INSTANCE).show();
      paramContext = ah.aiuX;
      AppMethodBeat.o(296213);
    }
    
    private static final void a(Uri paramUri, Context paramContext, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(296221);
      s.u(paramContext, "$context");
      if (paramBoolean)
      {
        paramUri = new Intent("android.intent.action.SENDTO", paramUri);
        paramUri.addFlags(268435456);
        try
        {
          paramUri = new com.tencent.mm.hellhoundlib.b.a().cG(paramUri);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramUri.aYi(), "com/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper$Companion", "showDialog$lambda-0", "(Landroid/net/Uri;Landroid/content/Context;ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramUri.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper$Companion", "showDialog$lambda-0", "(Landroid/net/Uri;Landroid/content/Context;ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(296221);
          return;
        }
        catch (Exception paramUri)
        {
          Log.e(i.access$getTAG$cp(), "start sms app failed:[%s]", new Object[] { paramUri.getMessage() });
        }
      }
      AppMethodBeat.o(296221);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      public a(Context paramContext, String paramString1, String paramString2)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */