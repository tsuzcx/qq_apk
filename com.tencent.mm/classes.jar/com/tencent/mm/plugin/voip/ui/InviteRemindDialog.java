package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.voip.d;
import com.tencent.mm.plugin.voip.model.h;
import com.tencent.mm.plugin.voip.model.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class InviteRemindDialog
  extends MMBaseActivity
{
  private TextView fQp;
  private String talker = "";
  private int type = 0;
  private TextView zpy;
  
  public static void p(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(115296);
    Intent localIntent = new Intent(paramContext, InviteRemindDialog.class);
    localIntent.putExtra("InviteRemindDialog_User", paramString);
    localIntent.putExtra("InviteRemindDialog_Type", paramInt);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/plugin/voip/ui/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(115296);
  }
  
  public void finish()
  {
    AppMethodBeat.i(115295);
    super.finish();
    AppMethodBeat.o(115295);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(115294);
    super.onCreate(paramBundle);
    setContentView(2131494912);
    this.fQp = ((TextView)findViewById(2131302313));
    this.zpy = ((TextView)findViewById(2131302309));
    this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
    this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
    if (this.type == 0)
    {
      this.fQp.setText(getString(2131764915));
      this.zpy.setText(getString(2131764873));
    }
    for (;;)
    {
      findViewById(2131302314).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115292);
          i.a locala;
          if (InviteRemindDialog.a(InviteRemindDialog.this) != null) {
            try
            {
              paramAnonymousView = i.a.ate((String)g.afB().afk().get(77829, null));
              if (paramAnonymousView == null) {
                break label368;
              }
              if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
              {
                if (!paramAnonymousView.containsKey(InviteRemindDialog.a(InviteRemindDialog.this))) {
                  break label332;
                }
                locala = (i.a)paramAnonymousView.get(InviteRemindDialog.a(InviteRemindDialog.this));
                locala.hpi += 1;
                paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), locala);
              }
              g.afB().afk().set(77829, i.a.aJ(paramAnonymousView));
              paramAnonymousView = paramAnonymousView.entrySet().iterator();
              while (paramAnonymousView.hasNext())
              {
                locala = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
                ad.d("MMInviteRemindDialog", "val " + locala.hitCount + " " + locala.hpi);
              }
              if (InviteRemindDialog.b(InviteRemindDialog.this) != 0) {
                break label502;
              }
            }
            catch (Exception paramAnonymousView)
            {
              ad.printErrStackTrace("MMInviteRemindDialog", paramAnonymousView, "", new Object[0]);
            }
          } else {
            label215:
            paramAnonymousView = InviteRemindDialog.this.getString(2131764872);
          }
          for (;;)
          {
            paramAnonymousView = new h(InviteRemindDialog.a(InviteRemindDialog.this), paramAnonymousView, w.tq(InviteRemindDialog.a(InviteRemindDialog.this)));
            g.aeS().a(paramAnonymousView, 0);
            paramAnonymousView = new Intent();
            paramAnonymousView.addFlags(536870912);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("Chat_User", InviteRemindDialog.a(InviteRemindDialog.this));
            d.hYt.d(paramAnonymousView, InviteRemindDialog.this);
            InviteRemindDialog.this.finish();
            AppMethodBeat.o(115292);
            return;
            label332:
            locala = new i.a();
            locala.hpi += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), locala);
            break;
            label368:
            paramAnonymousView = new HashMap();
            locala = new i.a();
            locala.hpi += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), locala);
            g.afB().afk().set(77829, i.a.aJ(paramAnonymousView));
            paramAnonymousView = paramAnonymousView.entrySet().iterator();
            while (paramAnonymousView.hasNext())
            {
              locala = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
              ad.d("MMInviteRemindDialog", "val " + locala.hitCount + " " + locala.hpi);
            }
            break label215;
            label502:
            if (InviteRemindDialog.b(InviteRemindDialog.this) == 1) {
              paramAnonymousView = InviteRemindDialog.this.getString(2131764938);
            } else {
              paramAnonymousView = null;
            }
          }
        }
      });
      findViewById(2131302301).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115293);
          InviteRemindDialog.this.finish();
          AppMethodBeat.o(115293);
        }
      });
      AppMethodBeat.o(115294);
      return;
      if (this.type == 1)
      {
        this.fQp.setText(getString(2131764948));
        this.zpy.setText(getString(2131764939));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.InviteRemindDialog
 * JD-Core Version:    0.7.0.1
 */