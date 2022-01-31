package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.bb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ShowQRCodeStep1UI
  extends MMActivity
  implements f
{
  private ProgressDialog eeN = null;
  private ImageView qFD = null;
  byte[] qFE = null;
  private int qFy = 1;
  
  final void cjS()
  {
    AppMethodBeat.i(126939);
    a locala = new a();
    com.tencent.mm.kernel.g.Rc().a(locala, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    this.eeN = h.b(localAppCompatActivity, getString(2131303082), true, new ShowQRCodeStep1UI.5(this, locala));
    AppMethodBeat.o(126939);
  }
  
  public int getLayoutId()
  {
    return 2130970738;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126938);
    setMMTitle(2131303118);
    this.qFD = ((ImageView)findViewById(2131821065));
    this.qFy = getIntent().getIntExtra("show_to", 1);
    TextView localTextView = (TextView)findViewById(2131827785);
    if (this.qFy == 3) {
      localTextView.setText(getString(2131303087, new Object[] { getString(2131303091) }));
    }
    for (;;)
    {
      cjS();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(126931);
          ShowQRCodeStep1UI.this.hideVKB();
          ShowQRCodeStep1UI.this.finish();
          AppMethodBeat.o(126931);
          return true;
        }
      });
      addIconOptionMenu(0, 2130839668, new ShowQRCodeStep1UI.2(this));
      ((Button)findViewById(2131827786)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126933);
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 3)
          {
            paramAnonymousView = com.tencent.mm.kernel.g.RK().jN(1);
            Object localObject = r.Zn();
            int i = bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(66561, null));
            ab.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[] { bo.aqg(bo.cg(paramAnonymousView)), localObject, Integer.valueOf(i) });
            paramAnonymousView = "http://weixin.qq.com/cgi-bin/rweibourl?sid=" + com.tencent.mm.a.g.w(paramAnonymousView) + "&u=" + (String)localObject + "&qr=" + i + "&device=" + com.tencent.mm.protocal.d.eQs + "&version=" + com.tencent.mm.protocal.d.whH;
            ab.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[] { paramAnonymousView });
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("title", ShowQRCodeStep1UI.this.getString(2131303097));
            com.tencent.mm.bq.d.b(ShowQRCodeStep1UI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            ShowQRCodeStep1UI.this.finish();
            AppMethodBeat.o(126933);
            return;
          }
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 4)
          {
            if (r.ZP())
            {
              paramAnonymousView = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
              paramAnonymousView.putExtra("show_to", 4);
              ShowQRCodeStep1UI.this.startActivity(paramAnonymousView);
            }
            for (;;)
            {
              ShowQRCodeStep1UI.this.finish();
              AppMethodBeat.o(126933);
              return;
              ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this, FacebookAuthUI.class);
            }
          }
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 2)
          {
            paramAnonymousView = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
            paramAnonymousView.putExtra("show_to", 2);
            ShowQRCodeStep1UI.this.startActivity(paramAnonymousView);
            ShowQRCodeStep1UI.this.finish();
            AppMethodBeat.o(126933);
            return;
          }
          paramAnonymousView = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
          paramAnonymousView.putExtra("show_to", 1);
          ShowQRCodeStep1UI.this.startActivity(paramAnonymousView);
          ShowQRCodeStep1UI.this.finish();
          AppMethodBeat.o(126933);
        }
      });
      AppMethodBeat.o(126938);
      return;
      if (this.qFy == 4) {
        localTextView.setText(getString(2131303087, new Object[] { getString(2131303088) }));
      } else if (this.qFy == 2) {
        localTextView.setText(getString(2131303087, new Object[] { getString(2131303090) }));
      } else {
        localTextView.setText(getString(2131303087, new Object[] { getString(2131303089) }));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126936);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.Rc().a(168, this);
    AppMethodBeat.o(126936);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126937);
    com.tencent.mm.kernel.g.Rc().b(168, this);
    super.onDestroy();
    AppMethodBeat.o(126937);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(126940);
    ab.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (com.tencent.mm.plugin.setting.b.gmP.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(126940);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(2131300095, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(126940);
      return;
    }
    this.qFE = ((a)paramm).fMU;
    this.qFD.setImageBitmap(com.tencent.mm.sdk.platformtools.d.bT(this.qFE));
    AppMethodBeat.o(126940);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI
 * JD-Core Version:    0.7.0.1
 */