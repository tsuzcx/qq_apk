package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class PrepareBindXMailUI
  extends MMActivity
  implements i
{
  private TextView BwI;
  private Button BwJ;
  private TextView BwK;
  private String BwL;
  private String BwM;
  private String BwN;
  private ImageView gyr;
  private TextView kaq;
  private ProgressDialog klA;
  
  private void aC(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(198732);
    View localView = View.inflate(this, 2131496190, null);
    final EditText localEditText = (EditText)localView.findViewById(2131307448);
    h.a(this, getString(2131758010), localView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(198725);
        if ((localEditText.getText() != null) && (!Util.isNullOrNil(localEditText.getText()))) {
          PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramString1, paramString2, paramString3, localEditText.getText().toString());
        }
        AppMethodBeat.o(198725);
      }
    });
    AppMethodBeat.o(198732);
  }
  
  private void y(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(198731);
    paramString1 = new p(3, paramString1, paramString2, paramString3, paramString4);
    g.azz().a(paramString1, 0);
    this.klA = h.a(this, getString(2131756029), false, null);
    AppMethodBeat.o(198731);
  }
  
  public int getLayoutId()
  {
    return 2131495948;
  }
  
  public void initView()
  {
    AppMethodBeat.i(198729);
    setMMTitle("");
    showMMLogo();
    getSupportActionBar().hide();
    getController().p(this, getContext().getResources().getColor(2131101424));
    this.gyr = ((ImageView)findViewById(2131297134));
    this.BwI = ((TextView)findViewById(2131310636));
    this.BwJ = ((Button)findViewById(2131297426));
    this.kaq = ((TextView)findViewById(2131297963));
    this.BwK = ((TextView)findViewById(2131297414));
    if (Util.isNullOrNil(this.BwL)) {
      this.BwJ.setEnabled(false);
    }
    for (;;)
    {
      this.BwJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198722);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((!Util.isNullOrNil(PrepareBindXMailUI.a(PrepareBindXMailUI.this))) && (!PrepareBindXMailUI.a(PrepareBindXMailUI.this).equals(PrepareBindXMailUI.b(PrepareBindXMailUI.this)))) {
            h.a(PrepareBindXMailUI.this, PrepareBindXMailUI.this.getString(2131758008), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(198721);
                PrepareBindXMailUI.c(PrepareBindXMailUI.this);
                AppMethodBeat.o(198721);
              }
            }, null);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198722);
            return;
            PrepareBindXMailUI.c(PrepareBindXMailUI.this);
          }
        }
      });
      this.kaq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198723);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          PrepareBindXMailUI.this.onBackPressed();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198723);
        }
      });
      this.BwK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198724);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", PrepareBindXMailUI.d(PrepareBindXMailUI.this));
          paramAnonymousView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
          paramAnonymousView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
          c.b(PrepareBindXMailUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView, 293);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198724);
        }
      });
      com.tencent.mm.ui.g.a.a.c(this.gyr, z.aTY());
      AppMethodBeat.o(198729);
      return;
      this.BwI.setText(this.BwL);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(198733);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 293)
    {
      Object localObject = null;
      if (paramIntent != null) {
        localObject = paramIntent.getBundleExtra("result_data");
      }
      if (localObject != null)
      {
        paramIntent = ((Bundle)localObject).getString("key_qq_mail");
        final String str = ((Bundle)localObject).getString("key_bind_ticket");
        boolean bool = ((Bundle)localObject).getBoolean("key_need_second_pwd", false);
        localObject = ((Bundle)localObject).getString("key_second_pwd_key");
        Log.i("MicroMsg.PrepareBindXMailUI", "mail %s, ticket %s, needSecondPwd %s, secPwdKey %s", new Object[] { paramIntent, str, Boolean.valueOf(bool), localObject });
        if (!Util.isNullOrNil(new String[] { paramIntent, str }))
        {
          if (bool)
          {
            if (!Util.isNullOrNil((String)localObject))
            {
              if ((!Util.isNullOrNil(this.BwM)) && (!this.BwM.equals(paramIntent)))
              {
                h.a(this, getString(2131758008), "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(198726);
                    PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, this.Bvo);
                    AppMethodBeat.o(198726);
                  }
                }, null);
                AppMethodBeat.o(198733);
                return;
              }
              aC(paramIntent, str, (String)localObject);
              AppMethodBeat.o(198733);
              return;
            }
            Toast.makeText(this, getString(2131765437), 1).show();
            AppMethodBeat.o(198733);
            return;
          }
          if ((!Util.isNullOrNil(this.BwM)) && (!this.BwM.equals(paramIntent)))
          {
            h.a(this, getString(2131758008), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(198727);
                PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, "", "");
                AppMethodBeat.o(198727);
              }
            }, null);
            AppMethodBeat.o(198733);
            return;
          }
          y(paramIntent, str, "", "");
        }
      }
    }
    AppMethodBeat.o(198733);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198728);
    super.onCreate(paramBundle);
    this.BwL = getIntent().getStringExtra("Key_WeXin_Mail");
    this.BwN = getIntent().getStringExtra("Key_QQMail_Login_Url");
    this.BwM = getIntent().getStringExtra("Key_Last_Bind_Mail");
    Log.i("MicroMsg.PrepareBindXMailUI", "wxMail %s, loginQQ %s, lastBindMail %s", new Object[] { this.BwL, this.BwN, this.BwM });
    initView();
    g.azz().a(586, this);
    AppMethodBeat.o(198728);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(198734);
    super.onDestroy();
    g.azz().b(586, this);
    AppMethodBeat.o(198734);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(198730);
    Log.i("MicroMsg.PrepareBindXMailUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.klA != null) {
      this.klA.dismiss();
    }
    int i = ((p)paramq).eGo();
    if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
    {
      Toast.makeText(this, getString(2131765438), 0).show();
      paramString = new Intent();
      paramString.putExtra("Key_Bind_XMail", ((p)paramq).BrO);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(198730);
      return;
    }
    if (i == -39006)
    {
      String str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = getString(2131764103);
      }
      Toast.makeText(this, str, 0).show();
      aC(((p)paramq).BrO, ((p)paramq).dHx, ((p)paramq).BrP);
      AppMethodBeat.o(198730);
      return;
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(2131765437);
    }
    Toast.makeText(this, paramq, 1).show();
    AppMethodBeat.o(198730);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI
 * JD-Core Version:    0.7.0.1
 */