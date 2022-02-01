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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class PrepareBindXMailUI
  extends MMActivity
  implements f
{
  private ImageView fTj;
  private TextView jcn;
  private ProgressDialog jns;
  private TextView xwG;
  private Button xwH;
  private TextView xwI;
  private String xwJ;
  private String xwK;
  private String xwL;
  
  private void ar(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(218076);
    View localView = View.inflate(this, 2131495329, null);
    final EditText localEditText = (EditText)localView.findViewById(2131304470);
    h.a(this, getString(2131757770), localView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(218069);
        if ((localEditText.getText() != null) && (!bu.ah(localEditText.getText()))) {
          PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramString1, paramString2, paramString3, localEditText.getText().toString());
        }
        AppMethodBeat.o(218069);
      }
    });
    AppMethodBeat.o(218076);
  }
  
  private void u(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(218075);
    paramString1 = new p(3, paramString1, paramString2, paramString3, paramString4);
    g.ajj().a(paramString1, 0);
    this.jns = h.b(this, getString(2131755936), false, null);
    AppMethodBeat.o(218075);
  }
  
  public int getLayoutId()
  {
    return 2131496485;
  }
  
  public void initView()
  {
    AppMethodBeat.i(218073);
    setMMTitle("");
    showMMLogo();
    getSupportActionBar().hide();
    getController().q(this, getContext().getResources().getColor(2131101179));
    this.fTj = ((ImageView)findViewById(2131297008));
    this.xwG = ((TextView)findViewById(2131308469));
    this.xwH = ((Button)findViewById(2131308231));
    this.jcn = ((TextView)findViewById(2131297690));
    this.xwI = ((TextView)findViewById(2131308230));
    if (bu.isNullOrNil(this.xwJ)) {
      this.xwH.setEnabled(false);
    }
    for (;;)
    {
      this.xwH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(218066);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((!bu.isNullOrNil(PrepareBindXMailUI.a(PrepareBindXMailUI.this))) && (!PrepareBindXMailUI.a(PrepareBindXMailUI.this).equals(PrepareBindXMailUI.b(PrepareBindXMailUI.this)))) {
            h.a(PrepareBindXMailUI.this, PrepareBindXMailUI.this.getString(2131766920), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(218065);
                PrepareBindXMailUI.c(PrepareBindXMailUI.this);
                AppMethodBeat.o(218065);
              }
            }, null);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(218066);
            return;
            PrepareBindXMailUI.c(PrepareBindXMailUI.this);
          }
        }
      });
      this.jcn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(218067);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          PrepareBindXMailUI.this.onBackPressed();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218067);
        }
      });
      this.xwI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(218068);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", PrepareBindXMailUI.d(PrepareBindXMailUI.this));
          paramAnonymousView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
          paramAnonymousView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
          d.b(PrepareBindXMailUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView, 293);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218068);
        }
      });
      com.tencent.mm.ui.f.a.a.c(this.fTj, v.aAC());
      AppMethodBeat.o(218073);
      return;
      this.xwG.setText(this.xwJ);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(218077);
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
        ae.i("MicroMsg.PrepareBindXMailUI", "mail %s, ticket %s, needSecondPwd %s, secPwdKey %s", new Object[] { paramIntent, str, Boolean.valueOf(bool), localObject });
        if (!bu.V(new String[] { paramIntent, str }))
        {
          if (bool)
          {
            if (!bu.isNullOrNil((String)localObject))
            {
              if ((!bu.isNullOrNil(this.xwK)) && (!this.xwK.equals(paramIntent)))
              {
                h.a(this, getString(2131766920), "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(218070);
                    PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, this.xvl);
                    AppMethodBeat.o(218070);
                  }
                }, null);
                AppMethodBeat.o(218077);
                return;
              }
              ar(paramIntent, str, (String)localObject);
              AppMethodBeat.o(218077);
              return;
            }
            Toast.makeText(this, getString(2131767175), 1).show();
            AppMethodBeat.o(218077);
            return;
          }
          if ((!bu.isNullOrNil(this.xwK)) && (!this.xwK.equals(paramIntent)))
          {
            h.a(this, getString(2131766920), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(218071);
                PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, "", "");
                AppMethodBeat.o(218071);
              }
            }, null);
            AppMethodBeat.o(218077);
            return;
          }
          u(paramIntent, str, "", "");
        }
      }
    }
    AppMethodBeat.o(218077);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(218072);
    super.onCreate(paramBundle);
    this.xwJ = getIntent().getStringExtra("Key_WeXin_Mail");
    this.xwL = getIntent().getStringExtra("Key_QQMail_Login_Url");
    this.xwK = getIntent().getStringExtra("Key_Last_Bind_Mail");
    ae.i("MicroMsg.PrepareBindXMailUI", "wxMail %s, loginQQ %s, lastBindMail %s", new Object[] { this.xwJ, this.xwL, this.xwK });
    initView();
    g.ajj().a(586, this);
    AppMethodBeat.o(218072);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(218078);
    super.onDestroy();
    g.ajj().b(586, this);
    AppMethodBeat.o(218078);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(218074);
    ae.i("MicroMsg.PrepareBindXMailUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.jns != null) {
      this.jns.dismiss();
    }
    int i = ((p)paramn).dFz();
    if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
    {
      Toast.makeText(this, getString(2131767176), 0).show();
      paramString = new Intent();
      paramString.putExtra("Key_Bind_XMail", ((p)paramn).xrM);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(218074);
      return;
    }
    if (i == -39006)
    {
      String str = paramString;
      if (bu.isNullOrNil(paramString)) {
        str = getString(2131767115);
      }
      Toast.makeText(this, str, 0).show();
      ar(((p)paramn).xrM, ((p)paramn).dqk, ((p)paramn).xrN);
      AppMethodBeat.o(218074);
      return;
    }
    paramn = paramString;
    if (bu.isNullOrNil(paramString)) {
      paramn = getString(2131767175);
    }
    Toast.makeText(this, paramn, 1).show();
    AppMethodBeat.o(218074);
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