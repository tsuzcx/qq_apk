package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.k;

@com.tencent.mm.ui.base.a(3)
public class MMSuperAlert
  extends HellActivity
{
  public static void q(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292412);
    Object localObject = new Intent(paramContext, MMSuperAlert.class);
    ((Intent)localObject).putExtra("MMSuperAlert_title", paramInt1);
    ((Intent)localObject).putExtra("MMSuperAlert_msg", paramInt2);
    ((Intent)localObject).putExtra("MMSuperAlert_cancelable", false);
    ((Intent)localObject).setFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/voip/ui/MMSuperAlert", "show", "(Landroid/content/Context;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/voip/ui/MMSuperAlert", "show", "(Landroid/content/Context;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(292412);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(115308);
    if ((getAssets() != null) && (MMApplicationContext.getResources() != null))
    {
      localResources = MMApplicationContext.getResources();
      AppMethodBeat.o(115308);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(115308);
    return localResources;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(115306);
    super.onCreate(paramBundle);
    setContentView(b.e.mm_super_alert_empty);
    final int i = getIntent().getIntExtra("MMSuperAlert_msg", 0);
    final int j = getIntent().getIntExtra("MMSuperAlert_title", 0);
    final boolean bool = getIntent().getBooleanExtra("MMSuperAlert_cancelable", true);
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115305);
        String str1;
        if (i == 0)
        {
          str1 = "";
          if (j != 0) {
            break label76;
          }
        }
        label76:
        for (String str2 = "";; str2 = MMSuperAlert.this.getString(j))
        {
          k.a(MMSuperAlert.this, str1, str2, bool, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115303);
              MMSuperAlert.this.finish();
              AppMethodBeat.o(115303);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115304);
              MMSuperAlert.this.finish();
              AppMethodBeat.o(115304);
            }
          });
          AppMethodBeat.o(115305);
          return;
          str1 = MMSuperAlert.this.getString(i);
          break;
        }
      }
    }, 50L);
    AppMethodBeat.o(115306);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.MMSuperAlert
 * JD-Core Version:    0.7.0.1
 */