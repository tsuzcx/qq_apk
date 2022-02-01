package com.tencent.mm.plugin.qqmail.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y;

@com.tencent.mm.ui.base.a(3)
public class PrepareBindXMailUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private TextView NoQ;
  private Button NoR;
  private TextView NoS;
  private String NoT;
  private String NoU;
  private String NoV;
  private ImageView lKK;
  private TextView pOq;
  private ProgressDialog qaH;
  
  private void F(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(266957);
    paramString1 = new o(3, paramString1, paramString2, paramString3, paramString4);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    this.qaH = k.a(this, getString(e.i.app_waiting), false, null);
    AppMethodBeat.o(266957);
  }
  
  private void aL(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(266961);
    View localView = View.inflate(this, e.f.secondpass, null);
    final EditText localEditText = (EditText)localView.findViewById(e.e.secondpass_et);
    k.a(this, getString(e.i.contact_info_qqmailhelper_secondpass), localView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(266970);
        if ((localEditText.getText() != null) && (!Util.isNullOrNil(localEditText.getText()))) {
          PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramString1, paramString2, paramString3, localEditText.getText().toString());
        }
        AppMethodBeat.o(266970);
      }
    });
    AppMethodBeat.o(266961);
  }
  
  public int getLayoutId()
  {
    return e.f.prepare_bind_xmail;
  }
  
  public void initView()
  {
    AppMethodBeat.i(266983);
    setMMTitle("");
    showMMLogo();
    getSupportActionBar().hide();
    getController().s(this, getContext().getResources().getColor(e.c.white));
    this.lKK = ((ImageView)findViewById(e.e.avatar_iv));
    this.NoQ = ((TextView)findViewById(e.e.wx_mail));
    this.NoR = ((Button)findViewById(e.e.bind_wx_mail_btn));
    this.pOq = ((TextView)findViewById(e.e.cancel_btn));
    this.NoS = ((TextView)findViewById(e.e.bind_qq_mail_btn));
    if (Util.isNullOrNil(this.NoT)) {
      this.NoR.setEnabled(false);
    }
    for (;;)
    {
      this.NoR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(266960);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((!Util.isNullOrNil(PrepareBindXMailUI.a(PrepareBindXMailUI.this))) && (!PrepareBindXMailUI.a(PrepareBindXMailUI.this).equals(PrepareBindXMailUI.b(PrepareBindXMailUI.this)))) {
            k.a(PrepareBindXMailUI.this, PrepareBindXMailUI.this.getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(266964);
                PrepareBindXMailUI.c(PrepareBindXMailUI.this);
                AppMethodBeat.o(266964);
              }
            }, null);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(266960);
            return;
            PrepareBindXMailUI.c(PrepareBindXMailUI.this);
          }
        }
      });
      this.pOq.setOnClickListener(new PrepareBindXMailUI.2(this));
      this.NoS.setOnClickListener(new PrepareBindXMailUI.3(this));
      com.tencent.mm.ui.i.a.a.g(this.lKK, z.bAM());
      AppMethodBeat.o(266983);
      return;
      this.NoQ.setText(this.NoT);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(266989);
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
              if ((!Util.isNullOrNil(this.NoU)) && (!this.NoU.equals(paramIntent)))
              {
                k.a(this, getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(266972);
                    PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, this.Nnx);
                    AppMethodBeat.o(266972);
                  }
                }, null);
                AppMethodBeat.o(266989);
                return;
              }
              aL(paramIntent, str, (String)localObject);
              AppMethodBeat.o(266989);
              return;
            }
            Toast.makeText(this, getString(e.i.settings_mail_install_fail), 1).show();
            AppMethodBeat.o(266989);
            return;
          }
          if ((!Util.isNullOrNil(this.NoU)) && (!this.NoU.equals(paramIntent)))
          {
            k.a(this, getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(266974);
                PrepareBindXMailUI.a(PrepareBindXMailUI.this, paramIntent, str, "", "");
                AppMethodBeat.o(266974);
              }
            }, null);
            AppMethodBeat.o(266989);
            return;
          }
          F(paramIntent, str, "", "");
        }
      }
    }
    AppMethodBeat.o(266989);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(266982);
    super.onCreate(paramBundle);
    this.NoT = getIntent().getStringExtra("Key_WeXin_Mail");
    this.NoV = getIntent().getStringExtra("Key_QQMail_Login_Url");
    this.NoU = getIntent().getStringExtra("Key_Last_Bind_Mail");
    Log.i("MicroMsg.PrepareBindXMailUI", "wxMail %s, loginQQ %s, lastBindMail %s", new Object[] { this.NoT, this.NoV, this.NoU });
    initView();
    com.tencent.mm.kernel.h.aZW().a(586, this);
    AppMethodBeat.o(266982);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(266991);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(586, this);
    AppMethodBeat.o(266991);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(266988);
    Log.i("MicroMsg.PrepareBindXMailUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.qaH != null) {
      this.qaH.dismiss();
    }
    int i = ((o)paramp).gDX();
    if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
    {
      Toast.makeText(this, getString(e.i.settings_mail_install_success), 0).show();
      paramString = new Intent();
      paramString.putExtra("Key_Bind_XMail", ((o)paramp).NjV);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(266988);
      return;
    }
    if (i == -39006)
    {
      String str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = getString(e.i.qqmail_verify_second_pwd_error);
      }
      Toast.makeText(this, str, 0).show();
      aL(((o)paramp).NjV, ((o)paramp).hFb, ((o)paramp).NjW);
      AppMethodBeat.o(266988);
      return;
    }
    paramp = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramp = getString(e.i.settings_mail_install_fail);
    }
    Toast.makeText(this, paramp, 1).show();
    AppMethodBeat.o(266988);
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