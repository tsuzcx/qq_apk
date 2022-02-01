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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.voip.d;
import com.tencent.mm.plugin.voip.model.h;
import com.tencent.mm.plugin.voip.model.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class InviteRemindDialog
  extends MMBaseActivity
{
  private TextView Cho;
  private TextView gnM;
  private String talker = "";
  private int type = 0;
  
  public static void p(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(115296);
    Intent localIntent = new Intent(paramContext, InviteRemindDialog.class);
    localIntent.putExtra("InviteRemindDialog_User", paramString);
    localIntent.putExtra("InviteRemindDialog_Type", paramInt);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/plugin/voip/ui/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.mq(0));
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
    this.gnM = ((TextView)findViewById(2131302313));
    this.Cho = ((TextView)findViewById(2131302309));
    this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
    this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
    if (this.type == 0)
    {
      this.gnM.setText(getString(2131764915));
      this.Cho.setText(getString(2131764873));
    }
    for (;;)
    {
      findViewById(2131302314).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115292);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          if (InviteRemindDialog.a(InviteRemindDialog.this) != null) {
            try
            {
              paramAnonymousView = i.a.aDE((String)g.ajC().ajl().get(77829, null));
              if (paramAnonymousView == null) {
                break label409;
              }
              if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
              {
                if (!paramAnonymousView.containsKey(InviteRemindDialog.a(InviteRemindDialog.this))) {
                  break label373;
                }
                localObject = (i.a)paramAnonymousView.get(InviteRemindDialog.a(InviteRemindDialog.this));
                ((i.a)localObject).iiY += 1;
                paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
              }
              g.ajC().ajl().set(77829, i.a.aQ(paramAnonymousView));
              paramAnonymousView = paramAnonymousView.entrySet().iterator();
              while (paramAnonymousView.hasNext())
              {
                localObject = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
                ad.d("MMInviteRemindDialog", "val " + ((i.a)localObject).hitCount + " " + ((i.a)localObject).iiY);
              }
              if (InviteRemindDialog.b(InviteRemindDialog.this) != 0) {
                break label543;
              }
            }
            catch (Exception paramAnonymousView)
            {
              ad.printErrStackTrace("MMInviteRemindDialog", paramAnonymousView, "", new Object[0]);
            }
          } else {
            label244:
            paramAnonymousView = InviteRemindDialog.this.getString(2131764872);
          }
          for (;;)
          {
            paramAnonymousView = new h(InviteRemindDialog.a(InviteRemindDialog.this), paramAnonymousView, w.Ar(InviteRemindDialog.a(InviteRemindDialog.this)));
            g.aiU().a(paramAnonymousView, 0);
            paramAnonymousView = new Intent();
            paramAnonymousView.addFlags(536870912);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("Chat_User", InviteRemindDialog.a(InviteRemindDialog.this));
            d.iRG.d(paramAnonymousView, InviteRemindDialog.this);
            InviteRemindDialog.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115292);
            return;
            label373:
            localObject = new i.a();
            ((i.a)localObject).iiY += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
            break;
            label409:
            paramAnonymousView = new HashMap();
            localObject = new i.a();
            ((i.a)localObject).iiY += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
            g.ajC().ajl().set(77829, i.a.aQ(paramAnonymousView));
            paramAnonymousView = paramAnonymousView.entrySet().iterator();
            while (paramAnonymousView.hasNext())
            {
              localObject = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
              ad.d("MMInviteRemindDialog", "val " + ((i.a)localObject).hitCount + " " + ((i.a)localObject).iiY);
            }
            break label244;
            label543:
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
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          InviteRemindDialog.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115293);
        }
      });
      AppMethodBeat.o(115294);
      return;
      if (this.type == 1)
      {
        this.gnM.setText(getString(2131764948));
        this.Cho.setText(getString(2131764939));
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