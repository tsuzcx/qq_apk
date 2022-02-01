package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;

@com.tencent.mm.ui.base.a(3)
public class PrepareBindXMailUI
  extends MMActivity
  implements i
{
  private TextView Hrd;
  private Button Hre;
  private TextView Hrf;
  private String Hrg;
  private String Hrh;
  private String Hri;
  private ImageView jiu;
  private TextView mRJ;
  private ProgressDialog ndq;
  
  private void D(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(249964);
    paramString1 = new p(3, paramString1, paramString2, paramString3, paramString4);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    this.ndq = com.tencent.mm.ui.base.h.a(this, getString(e.i.app_waiting), false, null);
    AppMethodBeat.o(249964);
  }
  
  private void ax(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(249966);
    View localView = View.inflate(this, e.f.secondpass, null);
    final EditText localEditText = (EditText)localView.findViewById(e.e.secondpass_et);
    com.tencent.mm.ui.base.h.a(this, getString(e.i.contact_info_qqmailhelper_secondpass), localView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(250075);
        if ((localEditText.getText() != null) && (!Util.isNullOrNil(localEditText.getText()))) {
          PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramString1, paramString2, paramString3, localEditText.getText().toString());
        }
        AppMethodBeat.o(250075);
      }
    });
    AppMethodBeat.o(249966);
  }
  
  public int getLayoutId()
  {
    return e.f.prepare_bind_xmail;
  }
  
  public void initView()
  {
    AppMethodBeat.i(249962);
    setMMTitle("");
    showMMLogo();
    getSupportActionBar().hide();
    getController().q(this, getContext().getResources().getColor(e.c.white));
    this.jiu = ((ImageView)findViewById(e.e.avatar_iv));
    this.Hrd = ((TextView)findViewById(e.e.wx_mail));
    this.Hre = ((Button)findViewById(e.e.bind_wx_mail_btn));
    this.mRJ = ((TextView)findViewById(e.e.cancel_btn));
    this.Hrf = ((TextView)findViewById(e.e.bind_qq_mail_btn));
    if (Util.isNullOrNil(this.Hrg)) {
      this.Hre.setEnabled(false);
    }
    for (;;)
    {
      this.Hre.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(250662);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((!Util.isNullOrNil(PrepareBindXMailUI.a(PrepareBindXMailUI.this))) && (!PrepareBindXMailUI.a(PrepareBindXMailUI.this).equals(PrepareBindXMailUI.b(PrepareBindXMailUI.this)))) {
            com.tencent.mm.ui.base.h.a(PrepareBindXMailUI.this, PrepareBindXMailUI.this.getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(249717);
                PrepareBindXMailUI.c(PrepareBindXMailUI.this);
                AppMethodBeat.o(249717);
              }
            }, null);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250662);
            return;
            PrepareBindXMailUI.c(PrepareBindXMailUI.this);
          }
        }
      });
      this.mRJ.setOnClickListener(new PrepareBindXMailUI.2(this));
      this.Hrf.setOnClickListener(new PrepareBindXMailUI.3(this));
      com.tencent.mm.ui.h.a.a.c(this.jiu, z.bcZ());
      AppMethodBeat.o(249962);
      return;
      this.Hrd.setText(this.Hrg);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(249967);
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
              if ((!Util.isNullOrNil(this.Hrh)) && (!this.Hrh.equals(paramIntent)))
              {
                com.tencent.mm.ui.base.h.a(this, getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(249668);
                    PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, this.HpJ);
                    AppMethodBeat.o(249668);
                  }
                }, null);
                AppMethodBeat.o(249967);
                return;
              }
              ax(paramIntent, str, (String)localObject);
              AppMethodBeat.o(249967);
              return;
            }
            Toast.makeText(this, getString(e.i.settings_mail_install_fail), 1).show();
            AppMethodBeat.o(249967);
            return;
          }
          if ((!Util.isNullOrNil(this.Hrh)) && (!this.Hrh.equals(paramIntent)))
          {
            com.tencent.mm.ui.base.h.a(this, getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(249979);
                PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, "", "");
                AppMethodBeat.o(249979);
              }
            }, null);
            AppMethodBeat.o(249967);
            return;
          }
          D(paramIntent, str, "", "");
        }
      }
    }
    AppMethodBeat.o(249967);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249960);
    super.onCreate(paramBundle);
    this.Hrg = getIntent().getStringExtra("Key_WeXin_Mail");
    this.Hri = getIntent().getStringExtra("Key_QQMail_Login_Url");
    this.Hrh = getIntent().getStringExtra("Key_Last_Bind_Mail");
    Log.i("MicroMsg.PrepareBindXMailUI", "wxMail %s, loginQQ %s, lastBindMail %s", new Object[] { this.Hrg, this.Hri, this.Hrh });
    initView();
    com.tencent.mm.kernel.h.aGY().a(586, this);
    AppMethodBeat.o(249960);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(249969);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(586, this);
    AppMethodBeat.o(249969);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(249963);
    Log.i("MicroMsg.PrepareBindXMailUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.ndq != null) {
      this.ndq.dismiss();
    }
    int i = ((p)paramq).fsp();
    if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
    {
      Toast.makeText(this, getString(e.i.settings_mail_install_success), 0).show();
      paramString = new Intent();
      paramString.putExtra("Key_Bind_XMail", ((p)paramq).Hmh);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(249963);
      return;
    }
    if (i == -39006)
    {
      String str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = getString(e.i.qqmail_verify_second_pwd_error);
      }
      Toast.makeText(this, str, 0).show();
      ax(((p)paramq).Hmh, ((p)paramq).fAo, ((p)paramq).Hmi);
      AppMethodBeat.o(249963);
      return;
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(e.i.settings_mail_install_fail);
    }
    Toast.makeText(this, paramq, 1).show();
    AppMethodBeat.o(249963);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI
 * JD-Core Version:    0.7.0.1
 */