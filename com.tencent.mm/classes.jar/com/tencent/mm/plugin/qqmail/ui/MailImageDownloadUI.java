package com.tencent.mm.plugin.qqmail.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.y;

public class MailImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.am.h, com.tencent.mm.am.i
{
  private TextView NoC;
  private TextView NoD;
  private TextView NoE;
  private RelativeLayout NoF;
  private com.tencent.mm.modelimage.h NoG;
  private com.tencent.mm.modelimage.n NoH;
  private ImageView NoI;
  private LinearLayout NoJ;
  private long hTh;
  private MMHandler handler;
  private long msgId;
  private int oGu;
  private String username;
  private TextView xsX;
  private ProgressBar ycl;
  
  public MailImageDownloadUI()
  {
    AppMethodBeat.i(123110);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.msgId = 0L;
    this.hTh = 0L;
    AppMethodBeat.o(123110);
  }
  
  private void agf(int paramInt)
  {
    AppMethodBeat.i(123115);
    this.NoC.setText(getString(e.i.fmt_percent, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.ycl.getMax())
    {
      AppMethodBeat.o(123115);
      return;
    }
    Object localObject = r.bKa().b(Long.valueOf(this.NoH.oHT));
    if (this.oGu == 1) {
      com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject);
    }
    finish();
    localObject = getIntent();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123115);
  }
  
  public final void a(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(123116);
    Log.d("MicroMsg.MailImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramp.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      agf(Math.max(0, paramInt1));
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
    this.NoC = ((TextView)findViewById(e.e.image_download_percent_tv));
    this.NoD = ((TextView)findViewById(e.e.image_download_percent_tv));
    this.xsX = ((TextView)findViewById(e.e.image_download_size_tv));
    this.NoE = ((TextView)findViewById(e.e.image_download_length_tv));
    this.NoI = ((ImageView)findViewById(e.e.mail_image));
    this.NoC.setVisibility(0);
    this.NoJ = ((LinearLayout)findViewById(e.e.image_bottom_info_layout));
    this.NoF = ((RelativeLayout)findViewById(e.e.mail_img_download_layout));
    this.NoD.setVisibility(8);
    this.xsX.setVisibility(8);
    this.NoE.setVisibility(8);
    setTitleVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123109);
        com.tencent.mm.kernel.h.baD().mCm.a(MailImageDownloadUI.a(MailImageDownloadUI.this));
        MailImageDownloadUI.this.finish();
        AppMethodBeat.o(123109);
        return true;
      }
    });
    this.ycl = ((ProgressBar)findViewById(e.e.image_download_pb));
    AppMethodBeat.o(123114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123111);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("img_msg_id", 0L);
    this.hTh = getIntent().getLongExtra("img_server_id", 0L);
    this.oGu = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.msgId > 0L) {
      this.NoG = r.bKa().H(this.username, this.msgId);
    }
    if (((this.NoG == null) || (this.NoG.localId <= 0L)) && (this.hTh > 0L)) {
      this.NoG = r.bKa().G(this.username, this.hTh);
    }
    if ((this.NoG == null) || (this.NoG.localId <= 0L))
    {
      Log.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.hTh);
      AppMethodBeat.o(123111);
      return;
    }
    if ((this.msgId <= 0L) && (this.hTh > 0L)) {
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aU(this.username, this.hTh).field_msgId;
    }
    paramBundle = this.NoG.oGr;
    String str = r.bKa().v(paramBundle, null, null);
    if ((!Util.isNullOrNil(paramBundle)) && (y.ZC(str)))
    {
      Log.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[] { paramBundle, Boolean.valueOf(this.NoG.bJE()), str });
      this.NoG.bJE();
      if ((str == null) || (str.equals("")) || (!y.ZC(str)))
      {
        Log.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
        AppMethodBeat.o(123111);
        return;
      }
      this.NoJ.setVisibility(8);
      this.ycl.setVisibility(8);
      this.NoI.setVisibility(0);
      paramBundle = BitmapUtil.getBitmapNative(str);
      this.NoI.setImageBitmap(paramBundle);
      this.NoF.invalidate();
      AppMethodBeat.o(123111);
      return;
    }
    this.NoH = new com.tencent.mm.modelimage.n(this.NoG.localId, this.msgId, this.oGu, this);
    com.tencent.mm.kernel.h.baD().mCm.a(this.NoH, 0);
    AppMethodBeat.o(123111);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123112);
    super.onPause();
    com.tencent.mm.kernel.h.baD().mCm.b(109, this);
    AppMethodBeat.o(123112);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123113);
    super.onResume();
    com.tencent.mm.kernel.h.baD().mCm.a(109, this);
    AppMethodBeat.o(123113);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(123117);
    if (paramp.getType() != 109)
    {
      AppMethodBeat.o(123117);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      agf(this.ycl.getMax());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */