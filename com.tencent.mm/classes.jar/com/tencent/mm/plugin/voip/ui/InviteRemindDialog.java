package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.voip.d;
import com.tencent.mm.plugin.voip.model.h;
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
  private TextView HcE;
  private TextView hbb;
  private String talker = "";
  private int type = 0;
  
  public static void o(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(115296);
    Intent localIntent = new Intent(paramContext, InviteRemindDialog.class);
    localIntent.putExtra("InviteRemindDialog_User", paramString);
    localIntent.putExtra("InviteRemindDialog_Type", paramInt);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/voip/ui/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.pG(0));
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
    setContentView(2131495651);
    this.hbb = ((TextView)findViewById(2131304708));
    this.HcE = ((TextView)findViewById(2131304704));
    this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
    this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
    if (this.type == 0)
    {
      this.hbb.setText(getString(2131767356));
      this.HcE.setText(getString(2131767312));
    }
    for (;;)
    {
      findViewById(2131304709).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115292);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          if (InviteRemindDialog.a(InviteRemindDialog.this) != null) {
            try
            {
              paramAnonymousView = i.a.aUx((String)g.aAh().azQ().get(77829, null));
              if (paramAnonymousView == null) {
                break label409;
              }
              if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
              {
                if (!paramAnonymousView.containsKey(InviteRemindDialog.a(InviteRemindDialog.this))) {
                  break label373;
                }
                localObject = (i.a)paramAnonymousView.get(InviteRemindDialog.a(InviteRemindDialog.this));
                ((i.a)localObject).jgU += 1;
                paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
              }
              g.aAh().azQ().set(77829, i.a.aV(paramAnonymousView));
              paramAnonymousView = paramAnonymousView.entrySet().iterator();
              while (paramAnonymousView.hasNext())
              {
                localObject = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
                Log.d("MMInviteRemindDialog", "val " + ((i.a)localObject).hitCount + " " + ((i.a)localObject).jgU);
              }
              if (InviteRemindDialog.b(InviteRemindDialog.this) != 0) {
                break label543;
              }
            }
            catch (Exception paramAnonymousView)
            {
              Log.printErrStackTrace("MMInviteRemindDialog", paramAnonymousView, "", new Object[0]);
            }
          } else {
            label244:
            paramAnonymousView = InviteRemindDialog.this.getString(2131767311);
          }
          for (;;)
          {
            paramAnonymousView = new h(InviteRemindDialog.a(InviteRemindDialog.this), paramAnonymousView, ab.JG(InviteRemindDialog.a(InviteRemindDialog.this)));
            g.azz().a(paramAnonymousView, 0);
            paramAnonymousView = new Intent();
            paramAnonymousView.addFlags(536870912);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("Chat_User", InviteRemindDialog.a(InviteRemindDialog.this));
            d.jRt.d(paramAnonymousView, InviteRemindDialog.this);
            InviteRemindDialog.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115292);
            return;
            label373:
            localObject = new i.a();
            ((i.a)localObject).jgU += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
            break;
            label409:
            paramAnonymousView = new HashMap();
            localObject = new i.a();
            ((i.a)localObject).jgU += 1;
            paramAnonymousView.put(InviteRemindDialog.a(InviteRemindDialog.this), localObject);
            g.aAh().azQ().set(77829, i.a.aV(paramAnonymousView));
            paramAnonymousView = paramAnonymousView.entrySet().iterator();
            while (paramAnonymousView.hasNext())
            {
              localObject = (i.a)((Map.Entry)paramAnonymousView.next()).getValue();
              Log.d("MMInviteRemindDialog", "val " + ((i.a)localObject).hitCount + " " + ((i.a)localObject).jgU);
            }
            break label244;
            label543:
            if (InviteRemindDialog.b(InviteRemindDialog.this) == 1) {
              paramAnonymousView = InviteRemindDialog.this.getString(2131767379);
            } else {
              paramAnonymousView = null;
            }
          }
        }
      });
      findViewById(2131304695).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115293);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          InviteRemindDialog.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115293);
        }
      });
      AppMethodBeat.o(115294);
      return;
      if (this.type == 1)
      {
        this.hbb.setText(getString(2131767389));
        this.HcE.setText(getString(2131767380));
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