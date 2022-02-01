package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;

public class MailImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.al.g, com.tencent.mm.al.h
{
  private long drA;
  private ap handler;
  private int hgm;
  private long msgId;
  private TextView oiu;
  private ProgressBar uQf;
  private TextView uQg;
  private TextView uQh;
  private TextView uQi;
  private RelativeLayout uQj;
  private e uQk;
  private com.tencent.mm.aw.k uQl;
  private ImageView uQm;
  private LinearLayout uQn;
  private String username;
  
  public MailImageDownloadUI()
  {
    AppMethodBeat.i(123110);
    this.handler = new ap(Looper.getMainLooper());
    this.msgId = 0L;
    this.drA = 0L;
    AppMethodBeat.o(123110);
  }
  
  private void JQ(int paramInt)
  {
    AppMethodBeat.i(123115);
    this.uQg.setText(getString(2131759531, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.uQf.getMax())
    {
      AppMethodBeat.o(123115);
      return;
    }
    Object localObject = o.ayF().b(Long.valueOf(this.uQl.hhJ));
    if (this.hgm == 1) {
      com.tencent.mm.aw.f.c((e)localObject);
    }
    finish();
    localObject = getIntent();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123115);
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(123116);
    ad.d("MicroMsg.MailImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramn.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      JQ(Math.max(0, paramInt1));
      AppMethodBeat.o(123116);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494679;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123114);
    this.uQg = ((TextView)findViewById(2131300925));
    this.uQh = ((TextView)findViewById(2131300925));
    this.oiu = ((TextView)findViewById(2131300926));
    this.uQi = ((TextView)findViewById(2131300923));
    this.uQm = ((ImageView)findViewById(2131301979));
    this.uQg.setVisibility(0);
    this.uQn = ((LinearLayout)findViewById(2131300922));
    this.uQj = ((RelativeLayout)findViewById(2131301980));
    this.uQh.setVisibility(8);
    this.oiu.setVisibility(8);
    this.uQi.setVisibility(8);
    setTitleVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123109);
        com.tencent.mm.kernel.g.afA().gcy.a(MailImageDownloadUI.a(MailImageDownloadUI.this));
        MailImageDownloadUI.this.finish();
        AppMethodBeat.o(123109);
        return true;
      }
    });
    this.uQf = ((ProgressBar)findViewById(2131300924));
    AppMethodBeat.o(123114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123111);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("img_msg_id", 0L);
    this.drA = getIntent().getLongExtra("img_server_id", 0L);
    this.hgm = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.msgId > 0L) {
      this.uQk = o.ayF().ms(this.msgId);
    }
    if (((this.uQk == null) || (this.uQk.deI <= 0L)) && (this.drA > 0L)) {
      this.uQk = o.ayF().mr(this.drA);
    }
    if ((this.uQk == null) || (this.uQk.deI <= 0L))
    {
      ad.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.drA);
      AppMethodBeat.o(123111);
      return;
    }
    if ((this.msgId <= 0L) && (this.drA > 0L)) {
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(this.username, this.drA).field_msgId;
    }
    paramBundle = this.uQk.hgj;
    String str = o.ayF().p(paramBundle, null, null);
    if ((!bt.isNullOrNil(paramBundle)) && (i.eK(str)))
    {
      ad.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[] { paramBundle, Boolean.valueOf(this.uQk.ayi()), str });
      if ((str == null) || (str.equals("")) || (!i.eK(str)))
      {
        ad.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
        AppMethodBeat.o(123111);
        return;
      }
      this.uQn.setVisibility(8);
      this.uQf.setVisibility(8);
      this.uQm.setVisibility(0);
      paramBundle = com.tencent.mm.sdk.platformtools.f.aFi(str);
      this.uQm.setImageBitmap(paramBundle);
      this.uQj.invalidate();
      AppMethodBeat.o(123111);
      return;
    }
    this.uQl = new com.tencent.mm.aw.k(this.uQk.deI, this.msgId, this.hgm, this);
    com.tencent.mm.kernel.g.afA().gcy.a(this.uQl, 0);
    AppMethodBeat.o(123111);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123112);
    super.onPause();
    com.tencent.mm.kernel.g.afA().gcy.b(109, this);
    AppMethodBeat.o(123112);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123113);
    super.onResume();
    com.tencent.mm.kernel.g.afA().gcy.a(109, this);
    AppMethodBeat.o(123113);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(123117);
    if (paramn.getType() != 109)
    {
      AppMethodBeat.o(123117);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      JQ(this.uQf.getMax());
      AppMethodBeat.o(123117);
      return;
    }
    ad.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, 2131760323, 1).show();
    AppMethodBeat.o(123117);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */