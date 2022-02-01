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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.h;
import com.tencent.mm.aw.m;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class MailImageDownloadUI
  extends MMActivity
  implements f, com.tencent.mm.al.g
{
  private long dAY;
  private int hZz;
  private ap handler;
  private long msgId;
  private TextView ppC;
  private String username;
  private ProgressBar xgA;
  private TextView xgB;
  private TextView xgC;
  private TextView xgD;
  private RelativeLayout xgE;
  private com.tencent.mm.aw.g xgF;
  private m xgG;
  private ImageView xgH;
  private LinearLayout xgI;
  
  public MailImageDownloadUI()
  {
    AppMethodBeat.i(123110);
    this.handler = new ap(Looper.getMainLooper());
    this.msgId = 0L;
    this.dAY = 0L;
    AppMethodBeat.o(123110);
  }
  
  private void No(int paramInt)
  {
    AppMethodBeat.i(123115);
    this.xgB.setText(getString(2131759531, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.xgA.getMax())
    {
      AppMethodBeat.o(123115);
      return;
    }
    Object localObject = com.tencent.mm.aw.q.aIF().c(Long.valueOf(this.xgG.iba));
    if (this.hZz == 1) {
      h.c((com.tencent.mm.aw.g)localObject);
    }
    finish();
    localObject = getIntent();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
      No(Math.max(0, paramInt1));
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
    this.xgB = ((TextView)findViewById(2131300925));
    this.xgC = ((TextView)findViewById(2131300925));
    this.ppC = ((TextView)findViewById(2131300926));
    this.xgD = ((TextView)findViewById(2131300923));
    this.xgH = ((ImageView)findViewById(2131301979));
    this.xgB.setVisibility(0);
    this.xgI = ((LinearLayout)findViewById(2131300922));
    this.xgE = ((RelativeLayout)findViewById(2131301980));
    this.xgC.setVisibility(8);
    this.ppC.setVisibility(8);
    this.xgD.setVisibility(8);
    setTitleVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123109);
        com.tencent.mm.kernel.g.ajB().gAO.a(MailImageDownloadUI.a(MailImageDownloadUI.this));
        MailImageDownloadUI.this.finish();
        AppMethodBeat.o(123109);
        return true;
      }
    });
    this.xgA = ((ProgressBar)findViewById(2131300924));
    AppMethodBeat.o(123114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123111);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("img_msg_id", 0L);
    this.dAY = getIntent().getLongExtra("img_server_id", 0L);
    this.hZz = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.msgId > 0L) {
      this.xgF = com.tencent.mm.aw.q.aIF().G(this.username, this.msgId);
    }
    if (((this.xgF == null) || (this.xgF.dnz <= 0L)) && (this.dAY > 0L)) {
      this.xgF = com.tencent.mm.aw.q.aIF().F(this.username, this.dAY);
    }
    if ((this.xgF == null) || (this.xgF.dnz <= 0L))
    {
      ad.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dAY);
      AppMethodBeat.o(123111);
      return;
    }
    if ((this.msgId <= 0L) && (this.dAY > 0L)) {
      this.msgId = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI(this.username, this.dAY).field_msgId;
    }
    paramBundle = this.xgF.hZw;
    String str = com.tencent.mm.aw.q.aIF().o(paramBundle, null, null);
    if ((!bt.isNullOrNil(paramBundle)) && (com.tencent.mm.vfs.i.fv(str)))
    {
      ad.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[] { paramBundle, Boolean.valueOf(this.xgF.aIj()), str });
      if ((str == null) || (str.equals("")) || (!com.tencent.mm.vfs.i.fv(str)))
      {
        ad.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
        AppMethodBeat.o(123111);
        return;
      }
      this.xgI.setVisibility(8);
      this.xgA.setVisibility(8);
      this.xgH.setVisibility(0);
      paramBundle = com.tencent.mm.sdk.platformtools.g.aQf(str);
      this.xgH.setImageBitmap(paramBundle);
      this.xgE.invalidate();
      AppMethodBeat.o(123111);
      return;
    }
    this.xgG = new m(this.xgF.dnz, this.msgId, this.hZz, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.xgG, 0);
    AppMethodBeat.o(123111);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123112);
    super.onPause();
    com.tencent.mm.kernel.g.ajB().gAO.b(109, this);
    AppMethodBeat.o(123112);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123113);
    super.onResume();
    com.tencent.mm.kernel.g.ajB().gAO.a(109, this);
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
      No(this.xgA.getMax());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */