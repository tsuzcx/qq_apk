package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class InviteRemindDialog
  extends MMBaseActivity
{
  private TextView Evl;
  private TextView mll;
  private String talker = "";
  private int type = 0;
  
  public static void s(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(293502);
    Intent localIntent = new Intent(paramContext, InviteRemindDialog.class);
    localIntent.putExtra("InviteRemindDialog_User", paramString);
    localIntent.putExtra("InviteRemindDialog_Type", paramInt);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/voip/widget/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/voip/widget/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(293502);
  }
  
  public void finish()
  {
    AppMethodBeat.i(293515);
    super.finish();
    AppMethodBeat.o(293515);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(293514);
    super.onCreate(paramBundle);
    setContentView(b.e.mm_voip_invite_alert);
    this.mll = ((TextView)findViewById(b.d.mm_alert_msg_title));
    this.Evl = ((TextView)findViewById(b.d.mm_alert_msg_content));
    this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
    this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
    if (this.type == 0)
    {
      this.mll.setText(getString(b.g.voip_send_request_title));
      this.Evl.setText(getString(b.g.voip_invite_remind_tip));
    }
    for (;;)
    {
      findViewById(b.d.mm_alert_ok_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(293479);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/widget/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          if (InviteRemindDialog.a(InviteRemindDialog.this) != null) {
            try
            {
              paramAnonymousView = i.a.bfH((String)com.tencent.mm.kernel.h.baE().ban().d(77829, null));
              if (paramAnonymousView == null) {
                break label410;
              }
              if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
              {
                if (!paramAnonymousView.containsKey(InviteRemindDialog.a(InviteRemindDialog.this))) {
                  break label374;
                }
                localObject = (i.a)paramAnonymousView.get(InviteRemindDialog.a(InviteRemindDialog.this));
                ((i.a)localObject).oQA += 1;
                paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
              }
              com.tencent.mm.kernel.h.baE().ban().B(77829, i.a.bg(paramAnonymousView));
              paramAnonymousView = paramAnonymousView.entrySet().iterator();
              while (paramAnonymousView.hasNext())
              {
                localObject = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
                Log.d("MMInviteRemindDialog", "val " + ((i.a)localObject).hitCount + " " + ((i.a)localObject).oQA);
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
            paramAnonymousView = new com.tencent.mm.plugin.voip.model.h(InviteRemindDialog.a(InviteRemindDialog.this), paramAnonymousView, ab.IX(InviteRemindDialog.a(InviteRemindDialog.this)));
            com.tencent.mm.kernel.h.aZW().a(paramAnonymousView, 0);
            paramAnonymousView = new Intent();
            paramAnonymousView.addFlags(536870912);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("Chat_User", InviteRemindDialog.a(InviteRemindDialog.this));
            c.pFn.d(paramAnonymousView, InviteRemindDialog.this);
            InviteRemindDialog.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/widget/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(293479);
            return;
            label374:
            localObject = new i.a();
            ((i.a)localObject).oQA += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
            break;
            label410:
            paramAnonymousView = new HashMap();
            localObject = new i.a();
            ((i.a)localObject).oQA += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
            com.tencent.mm.kernel.h.baE().ban().B(77829, i.a.bg(paramAnonymousView));
            paramAnonymousView = paramAnonymousView.entrySet().iterator();
            while (paramAnonymousView.hasNext())
            {
              localObject = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
              Log.d("MMInviteRemindDialog", "val " + ((i.a)localObject).hitCount + " " + ((i.a)localObject).oQA);
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
          AppMethodBeat.i(293469);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/widget/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          InviteRemindDialog.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/widget/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(293469);
        }
      });
      AppMethodBeat.o(293514);
      return;
      if (this.type == 1)
      {
        this.mll.setText(getString(b.g.voip_voice_send_request_title));
        this.Evl.setText(getString(b.g.voip_voice_invite_remind_tip));
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
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.InviteRemindDialog
 * JD-Core Version:    0.7.0.1
 */