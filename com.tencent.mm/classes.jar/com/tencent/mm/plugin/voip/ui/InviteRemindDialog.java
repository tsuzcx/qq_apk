package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.d;
import com.tencent.mm.plugin.voip.model.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class InviteRemindDialog
  extends MMBaseActivity
{
  private TextView NTu;
  private TextView jMg;
  private String talker = "";
  private int type = 0;
  
  public static void q(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(115296);
    Intent localIntent = new Intent(paramContext, InviteRemindDialog.class);
    localIntent.putExtra("InviteRemindDialog_User", paramString);
    localIntent.putExtra("InviteRemindDialog_Type", paramInt);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/voip/ui/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    setContentView(b.e.mm_voip_invite_alert);
    this.jMg = ((TextView)findViewById(b.d.mm_alert_msg_title));
    this.NTu = ((TextView)findViewById(b.d.mm_alert_msg_content));
    this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
    this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
    if (this.type == 0)
    {
      this.jMg.setText(getString(b.g.voip_send_request_title));
      this.NTu.setText(getString(b.g.voip_invite_remind_tip));
    }
    for (;;)
    {
      findViewById(b.d.mm_alert_ok_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115292);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          if (InviteRemindDialog.a(InviteRemindDialog.this) != null) {
            try
            {
              paramAnonymousView = i.a.bgc((String)com.tencent.mm.kernel.h.aHG().aHp().b(77829, null));
              if (paramAnonymousView == null) {
                break label410;
              }
              if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
              {
                if (!paramAnonymousView.containsKey(InviteRemindDialog.a(InviteRemindDialog.this))) {
                  break label374;
                }
                localObject = (i.a)paramAnonymousView.get(InviteRemindDialog.a(InviteRemindDialog.this));
                ((i.a)localObject).lXw += 1;
                paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
              }
              com.tencent.mm.kernel.h.aHG().aHp().i(77829, i.a.aP(paramAnonymousView));
              paramAnonymousView = paramAnonymousView.entrySet().iterator();
              while (paramAnonymousView.hasNext())
              {
                localObject = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
                Log.d("MMInviteRemindDialog", "val " + ((i.a)localObject).hitCount + " " + ((i.a)localObject).lXw);
              }
              if (InviteRemindDialog.b(InviteRemindDialog.this) != 0) {
                break label544;
              }
            }
            catch (Exception paramAnonymousView)
            {
              Log.printErrStackTrace("MMInviteRemindDialog", paramAnonymousView, "", new Object[0]);
            }
          } else {
            label244:
            paramAnonymousView = InviteRemindDialog.this.getString(b.g.voip_invite_msg_text);
          }
          for (;;)
          {
            paramAnonymousView = new com.tencent.mm.plugin.voip.model.h(InviteRemindDialog.a(InviteRemindDialog.this), paramAnonymousView, ab.QZ(InviteRemindDialog.a(InviteRemindDialog.this)));
            com.tencent.mm.kernel.h.aGY().a(paramAnonymousView, 0);
            paramAnonymousView = new Intent();
            paramAnonymousView.addFlags(536870912);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("Chat_User", InviteRemindDialog.a(InviteRemindDialog.this));
            d.mIG.d(paramAnonymousView, InviteRemindDialog.this);
            InviteRemindDialog.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115292);
            return;
            label374:
            localObject = new i.a();
            ((i.a)localObject).lXw += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
            break;
            label410:
            paramAnonymousView = new HashMap();
            localObject = new i.a();
            ((i.a)localObject).lXw += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
            com.tencent.mm.kernel.h.aHG().aHp().i(77829, i.a.aP(paramAnonymousView));
            paramAnonymousView = paramAnonymousView.entrySet().iterator();
            while (paramAnonymousView.hasNext())
            {
              localObject = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
              Log.d("MMInviteRemindDialog", "val " + ((i.a)localObject).hitCount + " " + ((i.a)localObject).lXw);
            }
            break label244;
            label544:
            if (InviteRemindDialog.b(InviteRemindDialog.this) == 1) {
              paramAnonymousView = InviteRemindDialog.this.getString(b.g.voip_voice_invite_msg_text);
            } else {
              paramAnonymousView = null;
            }
          }
        }
      });
      findViewById(b.d.mm_alert_cancel_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115293);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          InviteRemindDialog.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115293);
        }
      });
      AppMethodBeat.o(115294);
      return;
      if (this.type == 1)
      {
        this.jMg.setText(getString(b.g.voip_voice_send_request_title));
        this.NTu.setText(getString(b.g.voip_voice_invite_remind_tip));
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