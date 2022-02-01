package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQUI
  extends MMActivity
  implements i
{
  private TextView Jep;
  private int Jeq;
  private boolean Jer = false;
  private ProgressDialog iXX = null;
  private EditText qDO;
  
  public int getLayoutId()
  {
    return b.g.edit_sharetoqq;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73857);
    setMMTitle(b.i.send_qrcode_to_microblog);
    this.qDO = ((EditText)findViewById(b.f.content));
    this.Jep = ((TextView)findViewById(b.f.wordcount));
    this.qDO.addTextChangedListener(new MMEditText.c(this.qDO, this.Jep, 280));
    this.Jeq = getIntent().getIntExtra("show_to", 2);
    if (this.Jeq == 4) {
      this.qDO.setText(b.i.self_qrcode_show_facebook_et_content);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73845);
          ShareToQQUI.this.hideVKB();
          ShareToQQUI.this.finish();
          AppMethodBeat.o(73845);
          return true;
        }
      });
      addTextOptionMenu(0, getString(b.i.app_share), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73849);
          ShareToQQUI.a(ShareToQQUI.this);
          boolean bool1;
          boolean bool2;
          if ((ShareToQQUI.b(ShareToQQUI.this) == 2) || (ShareToQQUI.b(ShareToQQUI.this) == 1))
          {
            paramAnonymousMenuItem = ShareToQQUI.c(ShareToQQUI.this).getText().toString();
            if (ShareToQQUI.b(ShareToQQUI.this) == 1)
            {
              bool1 = true;
              if (ShareToQQUI.b(ShareToQQUI.this) != 2) {
                break label164;
              }
              bool2 = true;
            }
          }
          label75:
          for (paramAnonymousMenuItem = new y(paramAnonymousMenuItem, bool1, bool2);; paramAnonymousMenuItem = new y(ShareToQQUI.c(ShareToQQUI.this).getText().toString()))
          {
            com.tencent.mm.kernel.h.aGY().a(paramAnonymousMenuItem, 0);
            Object localObject = ShareToQQUI.this;
            AppCompatActivity localAppCompatActivity = ShareToQQUI.this.getContext();
            ShareToQQUI.this.getString(b.i.app_tip);
            ShareToQQUI.a((ShareToQQUI)localObject, com.tencent.mm.ui.base.h.a(localAppCompatActivity, ShareToQQUI.this.getString(b.i.app_sending), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(73848);
                com.tencent.mm.kernel.h.aGY().a(paramAnonymousMenuItem);
                AppMethodBeat.o(73848);
              }
            }));
            AppMethodBeat.o(73849);
            return true;
            bool1 = false;
            break;
            bool2 = false;
            break label75;
            if (ShareToQQUI.b(ShareToQQUI.this) != 4) {
              break label307;
            }
            long l = Util.nullAsNil((Long)com.tencent.mm.kernel.h.aHG().aHp().b(65831, null));
            paramAnonymousMenuItem = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(65830, null));
            if ((Util.milliSecondsToNow(l) > 86400000L) && (paramAnonymousMenuItem.length() > 0))
            {
              localObject = new com.tencent.mm.ui.i.a.c(ShareToQQUI.this.getString(b.i.facebook_app_id));
              ((com.tencent.mm.ui.i.a.c)localObject).bAo(paramAnonymousMenuItem);
              new j((com.tencent.mm.ui.i.a.c)localObject, new k()
              {
                public final void K(Bundle paramAnonymous2Bundle)
                {
                  AppMethodBeat.i(73846);
                  super.K(paramAnonymous2Bundle);
                  AppMethodBeat.o(73846);
                }
                
                public final void onError(int paramAnonymous2Int, String paramAnonymous2String)
                {
                  AppMethodBeat.i(73847);
                  super.onError(paramAnonymous2Int, paramAnonymous2String);
                  AppMethodBeat.o(73847);
                }
              }).bxF();
            }
          }
          label164:
          label307:
          com.tencent.mm.ui.base.h.p(ShareToQQUI.this.getContext(), b.i.share_at_least_one_item, b.i.app_tip);
          AppMethodBeat.o(73849);
          return true;
        }
      });
      AppMethodBeat.o(73857);
      return;
      this.qDO.setText(b.i.self_qrcode_show_qq_et_content);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73855);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(26, this);
    initView();
    if (z.bdH())
    {
      paramBundle = new com.tencent.mm.ui.i.a.c(getString(b.i.facebook_app_id));
      paramBundle.bAo(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(65830, null)));
      new j(paramBundle, new k()
      {
        public final void K(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(73852);
          super.K(paramAnonymousBundle);
          AppMethodBeat.o(73852);
        }
        
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(73853);
          super.onError(paramAnonymousInt, paramAnonymousString);
          if (paramAnonymousInt == 3) {
            ShareToQQUI.d(ShareToQQUI.this);
          }
          AppMethodBeat.o(73853);
        }
      }).bxF();
    }
    AppMethodBeat.o(73855);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73856);
    com.tencent.mm.kernel.h.aGY().b(26, this);
    super.onDestroy();
    AppMethodBeat.o(73856);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(73858);
    Log.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 26)
    {
      AppMethodBeat.o(73858);
      return;
    }
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = "error";
      }
      com.tencent.mm.ui.base.h.a(this, paramq, getString(b.i.app_tip), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73850);
          Object localObject = new Intent(ShareToQQUI.this.getContext(), FacebookAuthUI.class);
          ((Intent)localObject).putExtra("is_force_unbind", true);
          paramAnonymousDialogInterface = ShareToQQUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareToQQUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/setting/ui/qrcode/ShareToQQUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ShareToQQUI.this.hideVKB();
          ShareToQQUI.this.finish();
          AppMethodBeat.o(73850);
        }
      }, null);
      AppMethodBeat.o(73858);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      hideVKB();
      paramString = getString(b.i.share_ok);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(73851);
          ShareToQQUI.this.finish();
          AppMethodBeat.o(73851);
        }
      };
      com.tencent.mm.ui.base.h.cO(this, paramString);
      AppMethodBeat.o(73858);
      return;
    }
    this.Jer = false;
    if (com.tencent.mm.plugin.setting.c.mIH.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(73858);
      return;
    }
    Toast.makeText(this, getString(b.i.share_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(73858);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI
 * JD-Core Version:    0.7.0.1
 */