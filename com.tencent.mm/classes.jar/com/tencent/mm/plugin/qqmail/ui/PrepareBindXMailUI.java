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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class PrepareBindXMailUI
  extends MMActivity
  implements f
{
  private ImageView fRd;
  private TextView iZu;
  private ProgressDialog jky;
  private TextView xgO;
  private Button xgP;
  private TextView xgQ;
  private String xgR;
  private String xgS;
  private String xgT;
  
  private void ar(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(215329);
    View localView = View.inflate(this, 2131495329, null);
    final EditText localEditText = (EditText)localView.findViewById(2131304470);
    h.a(this, getString(2131757770), localView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(215322);
        if ((localEditText.getText() != null) && (!bt.ai(localEditText.getText()))) {
          PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramString1, paramString2, paramString3, localEditText.getText().toString());
        }
        AppMethodBeat.o(215322);
      }
    });
    AppMethodBeat.o(215329);
  }
  
  private void u(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(215328);
    paramString1 = new p(3, paramString1, paramString2, paramString3, paramString4);
    g.aiU().a(paramString1, 0);
    this.jky = h.b(this, getString(2131755936), false, null);
    AppMethodBeat.o(215328);
  }
  
  public int getLayoutId()
  {
    return 2131496485;
  }
  
  public void initView()
  {
    AppMethodBeat.i(215326);
    setMMTitle("");
    showMMLogo();
    getSupportActionBar().hide();
    getController().q(this, getContext().getResources().getColor(2131101179));
    this.fRd = ((ImageView)findViewById(2131297008));
    this.xgO = ((TextView)findViewById(2131308469));
    this.xgP = ((Button)findViewById(2131308231));
    this.iZu = ((TextView)findViewById(2131297690));
    this.xgQ = ((TextView)findViewById(2131308230));
    if (bt.isNullOrNil(this.xgR)) {
      this.xgP.setEnabled(false);
    }
    for (;;)
    {
      this.xgP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215319);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((!bt.isNullOrNil(PrepareBindXMailUI.a(PrepareBindXMailUI.this))) && (!PrepareBindXMailUI.a(PrepareBindXMailUI.this).equals(PrepareBindXMailUI.b(PrepareBindXMailUI.this)))) {
            h.a(PrepareBindXMailUI.this, PrepareBindXMailUI.this.getString(2131766920), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(215318);
                PrepareBindXMailUI.c(PrepareBindXMailUI.this);
                AppMethodBeat.o(215318);
              }
            }, null);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(215319);
            return;
            PrepareBindXMailUI.c(PrepareBindXMailUI.this);
          }
        }
      });
      this.iZu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215320);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          PrepareBindXMailUI.this.onBackPressed();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215320);
        }
      });
      this.xgQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215321);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", PrepareBindXMailUI.d(PrepareBindXMailUI.this));
          paramAnonymousView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
          paramAnonymousView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
          d.b(PrepareBindXMailUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView, 293);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215321);
        }
      });
      com.tencent.mm.ui.f.a.a.c(this.fRd, u.aAm());
      AppMethodBeat.o(215326);
      return;
      this.xgO.setText(this.xgR);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(215330);
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
        ad.i("MicroMsg.PrepareBindXMailUI", "mail %s, ticket %s, needSecondPwd %s, secPwdKey %s", new Object[] { paramIntent, str, Boolean.valueOf(bool), localObject });
        if (!bt.V(new String[] { paramIntent, str }))
        {
          if (bool)
          {
            if (!bt.isNullOrNil((String)localObject))
            {
              if ((!bt.isNullOrNil(this.xgS)) && (!this.xgS.equals(paramIntent)))
              {
                h.a(this, getString(2131766920), "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(215323);
                    PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, this.xft);
                    AppMethodBeat.o(215323);
                  }
                }, null);
                AppMethodBeat.o(215330);
                return;
              }
              ar(paramIntent, str, (String)localObject);
              AppMethodBeat.o(215330);
              return;
            }
            Toast.makeText(this, getString(2131767175), 1).show();
            AppMethodBeat.o(215330);
            return;
          }
          if ((!bt.isNullOrNil(this.xgS)) && (!this.xgS.equals(paramIntent)))
          {
            h.a(this, getString(2131766920), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(215324);
                PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, "", "");
                AppMethodBeat.o(215324);
              }
            }, null);
            AppMethodBeat.o(215330);
            return;
          }
          u(paramIntent, str, "", "");
        }
      }
    }
    AppMethodBeat.o(215330);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(215325);
    super.onCreate(paramBundle);
    this.xgR = getIntent().getStringExtra("Key_WeXin_Mail");
    this.xgT = getIntent().getStringExtra("Key_QQMail_Login_Url");
    this.xgS = getIntent().getStringExtra("Key_Last_Bind_Mail");
    ad.i("MicroMsg.PrepareBindXMailUI", "wxMail %s, loginQQ %s, lastBindMail %s", new Object[] { this.xgR, this.xgT, this.xgS });
    initView();
    g.aiU().a(586, this);
    AppMethodBeat.o(215325);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(215331);
    super.onDestroy();
    g.aiU().b(586, this);
    AppMethodBeat.o(215331);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(215327);
    ad.i("MicroMsg.PrepareBindXMailUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.jky != null) {
      this.jky.dismiss();
    }
    int i = ((p)paramn).dCi();
    if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
    {
      Toast.makeText(this, getString(2131767176), 0).show();
      paramString = new Intent();
      paramString.putExtra("Key_Bind_XMail", ((p)paramn).xbV);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(215327);
      return;
    }
    if (i == -39006)
    {
      String str = paramString;
      if (bt.isNullOrNil(paramString)) {
        str = getString(2131767115);
      }
      Toast.makeText(this, str, 0).show();
      ar(((p)paramn).xbV, ((p)paramn).dpf, ((p)paramn).xbW);
      AppMethodBeat.o(215327);
      return;
    }
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramn = getString(2131767175);
    }
    Toast.makeText(this, paramn, 1).show();
    AppMethodBeat.o(215327);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI
 * JD-Core Version:    0.7.0.1
 */