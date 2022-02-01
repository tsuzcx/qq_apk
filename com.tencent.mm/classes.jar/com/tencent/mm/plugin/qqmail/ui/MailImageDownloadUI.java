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
import com.tencent.mm.an.j;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.m;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;

public class MailImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.an.i, j
{
  private ProgressBar HqO;
  private TextView HqP;
  private TextView HqQ;
  private TextView HqR;
  private RelativeLayout HqS;
  private g HqT;
  private m HqU;
  private ImageView HqV;
  private LinearLayout HqW;
  private long fNu;
  private MMHandler handler;
  private int lNK;
  private long msgId;
  private TextView umL;
  private String username;
  
  public MailImageDownloadUI()
  {
    AppMethodBeat.i(123110);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.msgId = 0L;
    this.fNu = 0L;
    AppMethodBeat.o(123110);
  }
  
  private void abR(int paramInt)
  {
    AppMethodBeat.i(123115);
    this.HqP.setText(getString(e.i.fmt_percent, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.HqO.getMax())
    {
      AppMethodBeat.o(123115);
      return;
    }
    Object localObject = com.tencent.mm.ay.q.bmh().b(Long.valueOf(this.HqU.lPj));
    if (this.lNK == 1) {
      com.tencent.mm.ay.h.c((g)localObject);
    }
    finish();
    localObject = getIntent();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123115);
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(123116);
    Log.d("MicroMsg.MailImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramq.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      abR(Math.max(0, paramInt1));
      AppMethodBeat.o(123116);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return e.f.mail_image_download;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123114);
    this.HqP = ((TextView)findViewById(e.e.image_download_percent_tv));
    this.HqQ = ((TextView)findViewById(e.e.image_download_percent_tv));
    this.umL = ((TextView)findViewById(e.e.image_download_size_tv));
    this.HqR = ((TextView)findViewById(e.e.image_download_length_tv));
    this.HqV = ((ImageView)findViewById(e.e.mail_image));
    this.HqP.setVisibility(0);
    this.HqW = ((LinearLayout)findViewById(e.e.image_bottom_info_layout));
    this.HqS = ((RelativeLayout)findViewById(e.e.mail_img_download_layout));
    this.HqQ.setVisibility(8);
    this.umL.setVisibility(8);
    this.HqR.setVisibility(8);
    setTitleVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123109);
        com.tencent.mm.kernel.h.aHF().kcd.a(MailImageDownloadUI.a(MailImageDownloadUI.this));
        MailImageDownloadUI.this.finish();
        AppMethodBeat.o(123109);
        return true;
      }
    });
    this.HqO = ((ProgressBar)findViewById(e.e.image_download_pb));
    AppMethodBeat.o(123114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123111);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("img_msg_id", 0L);
    this.fNu = getIntent().getLongExtra("img_server_id", 0L);
    this.lNK = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.msgId > 0L) {
      this.HqT = com.tencent.mm.ay.q.bmh().D(this.username, this.msgId);
    }
    if (((this.HqT == null) || (this.HqT.localId <= 0L)) && (this.fNu > 0L)) {
      this.HqT = com.tencent.mm.ay.q.bmh().C(this.username, this.fNu);
    }
    if ((this.HqT == null) || (this.HqT.localId <= 0L))
    {
      Log.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.fNu);
      AppMethodBeat.o(123111);
      return;
    }
    if ((this.msgId <= 0L) && (this.fNu > 0L)) {
      this.msgId = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(this.username, this.fNu).field_msgId;
    }
    paramBundle = this.HqT.lNH;
    String str = com.tencent.mm.ay.q.bmh().r(paramBundle, null, null);
    if ((!Util.isNullOrNil(paramBundle)) && (u.agG(str)))
    {
      Log.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[] { paramBundle, Boolean.valueOf(this.HqT.blK()), str });
      this.HqT.blK();
      if ((str == null) || (str.equals("")) || (!u.agG(str)))
      {
        Log.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
        AppMethodBeat.o(123111);
        return;
      }
      this.HqW.setVisibility(8);
      this.HqO.setVisibility(8);
      this.HqV.setVisibility(0);
      paramBundle = BitmapUtil.getBitmapNative(str);
      this.HqV.setImageBitmap(paramBundle);
      this.HqS.invalidate();
      AppMethodBeat.o(123111);
      return;
    }
    this.HqU = new m(this.HqT.localId, this.msgId, this.lNK, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.HqU, 0);
    AppMethodBeat.o(123111);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123112);
    super.onPause();
    com.tencent.mm.kernel.h.aHF().kcd.b(109, this);
    AppMethodBeat.o(123112);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123113);
    super.onResume();
    com.tencent.mm.kernel.h.aHF().kcd.a(109, this);
    AppMethodBeat.o(123113);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(123117);
    if (paramq.getType() != 109)
    {
      AppMethodBeat.o(123117);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      abR(this.HqO.getMax());
      AppMethodBeat.o(123117);
      return;
    }
    Log.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, e.i.imgdownload_fail, 1).show();
    AppMethodBeat.o(123117);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */