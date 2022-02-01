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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.m;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;

public class MailImageDownloadUI
  extends MMActivity
  implements f, com.tencent.mm.ak.g
{
  private long dCd;
  private aq handler;
  private int icr;
  private long msgId;
  private TextView pwi;
  private String username;
  private LinearLayout xwA;
  private ProgressBar xws;
  private TextView xwt;
  private TextView xwu;
  private TextView xwv;
  private RelativeLayout xww;
  private com.tencent.mm.av.g xwx;
  private m xwy;
  private ImageView xwz;
  
  public MailImageDownloadUI()
  {
    AppMethodBeat.i(123110);
    this.handler = new aq(Looper.getMainLooper());
    this.msgId = 0L;
    this.dCd = 0L;
    AppMethodBeat.o(123110);
  }
  
  private void NU(int paramInt)
  {
    AppMethodBeat.i(123115);
    this.xwt.setText(getString(2131759531, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.xws.getMax())
    {
      AppMethodBeat.o(123115);
      return;
    }
    Object localObject = com.tencent.mm.av.q.aIX().c(Long.valueOf(this.xwy.idT));
    if (this.icr == 1) {
      com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject);
    }
    finish();
    localObject = getIntent();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123115);
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(123116);
    ae.d("MicroMsg.MailImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramn.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      NU(Math.max(0, paramInt1));
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
    this.xwt = ((TextView)findViewById(2131300925));
    this.xwu = ((TextView)findViewById(2131300925));
    this.pwi = ((TextView)findViewById(2131300926));
    this.xwv = ((TextView)findViewById(2131300923));
    this.xwz = ((ImageView)findViewById(2131301979));
    this.xwt.setVisibility(0);
    this.xwA = ((LinearLayout)findViewById(2131300922));
    this.xww = ((RelativeLayout)findViewById(2131301980));
    this.xwu.setVisibility(8);
    this.pwi.setVisibility(8);
    this.xwv.setVisibility(8);
    setTitleVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123109);
        com.tencent.mm.kernel.g.ajQ().gDv.a(MailImageDownloadUI.a(MailImageDownloadUI.this));
        MailImageDownloadUI.this.finish();
        AppMethodBeat.o(123109);
        return true;
      }
    });
    this.xws = ((ProgressBar)findViewById(2131300924));
    AppMethodBeat.o(123114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123111);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("img_msg_id", 0L);
    this.dCd = getIntent().getLongExtra("img_server_id", 0L);
    this.icr = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.msgId > 0L) {
      this.xwx = com.tencent.mm.av.q.aIX().G(this.username, this.msgId);
    }
    if (((this.xwx == null) || (this.xwx.doE <= 0L)) && (this.dCd > 0L)) {
      this.xwx = com.tencent.mm.av.q.aIX().F(this.username, this.dCd);
    }
    if ((this.xwx == null) || (this.xwx.doE <= 0L))
    {
      ae.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dCd);
      AppMethodBeat.o(123111);
      return;
    }
    if ((this.msgId <= 0L) && (this.dCd > 0L)) {
      this.msgId = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(this.username, this.dCd).field_msgId;
    }
    paramBundle = this.xwx.ico;
    String str = com.tencent.mm.av.q.aIX().o(paramBundle, null, null);
    if ((!bu.isNullOrNil(paramBundle)) && (o.fB(str)))
    {
      ae.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[] { paramBundle, Boolean.valueOf(this.xwx.aIB()), str });
      if ((str == null) || (str.equals("")) || (!o.fB(str)))
      {
        ae.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
        AppMethodBeat.o(123111);
        return;
      }
      this.xwA.setVisibility(8);
      this.xws.setVisibility(8);
      this.xwz.setVisibility(0);
      paramBundle = com.tencent.mm.sdk.platformtools.h.aRC(str);
      this.xwz.setImageBitmap(paramBundle);
      this.xww.invalidate();
      AppMethodBeat.o(123111);
      return;
    }
    this.xwy = new m(this.xwx.doE, this.msgId, this.icr, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.xwy, 0);
    AppMethodBeat.o(123111);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123112);
    super.onPause();
    com.tencent.mm.kernel.g.ajQ().gDv.b(109, this);
    AppMethodBeat.o(123112);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123113);
    super.onResume();
    com.tencent.mm.kernel.g.ajQ().gDv.a(109, this);
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
      NU(this.xws.getMax());
      AppMethodBeat.o(123117);
      return;
    }
    ae.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, 2131760323, 1).show();
    AppMethodBeat.o(123117);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */