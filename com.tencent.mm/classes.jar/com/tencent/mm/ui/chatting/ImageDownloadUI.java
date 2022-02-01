package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.j;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.h;
import com.tencent.mm.ay.m;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.vfs.u;

public class ImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.an.i, j
{
  private ProgressBar HqO;
  private TextView HqP;
  private TextView HqQ;
  private TextView HqR;
  private g HqT;
  private m HqU;
  private ImageView WDz;
  private long fNu = 0L;
  private int lNK;
  private long msgId = 0L;
  private TextView umL;
  private String username;
  
  private void abR(int paramInt)
  {
    AppMethodBeat.i(34831);
    this.HqO.setProgress(paramInt);
    this.HqP.setText(getString(R.l.fmt_percent, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.HqO.getMax())
    {
      AppMethodBeat.o(34831);
      return;
    }
    g localg = com.tencent.mm.ay.q.bmh().b(Long.valueOf(this.HqU.lPj));
    String str = localg.lNH;
    if (this.lNK == 1) {
      str = h.c(localg);
    }
    str = com.tencent.mm.ay.q.bmh().r(str, null, null);
    localg.blK();
    bzb(str);
    AppMethodBeat.o(34831);
  }
  
  private void bzb(String paramString)
  {
    AppMethodBeat.i(34832);
    if ((paramString == null) || (paramString.equals("")) || (!u.agG(paramString)))
    {
      Log.d("ImageDownloadUI", "showImg : imgPath is null");
      AppMethodBeat.o(34832);
      return;
    }
    Log.i("ImageDownloadUI", "[ImageGalleryUI] showImg");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_message_id", this.msgId);
    localIntent.putExtra("key_image_path", paramString);
    localIntent.putExtra("key_compress_type", this.lNK);
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("img_gallery_msg_id", this.msgId);
    localIntent.putExtra("img_gallery_talker", this.username);
    finish();
    AppMethodBeat.o(34832);
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(34830);
    Log.d("ImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramq.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      abR(Math.max(0, paramInt1));
      AppMethodBeat.o(34830);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.elH;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34829);
    this.HqP = ((TextView)findViewById(R.h.image_download_percent_tv));
    this.HqQ = ((TextView)findViewById(R.h.dYK));
    this.umL = ((TextView)findViewById(R.h.dYL));
    this.HqR = ((TextView)findViewById(R.h.dYI));
    this.WDz = ((ImageView)findViewById(R.h.dEW));
    this.WDz.setImageResource(R.k.download_image_icon);
    this.HqP.setVisibility(0);
    this.HqQ.setVisibility(8);
    this.umL.setVisibility(8);
    this.HqR.setVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34825);
        bh.aGY().a(ImageDownloadUI.a(ImageDownloadUI.this));
        ImageDownloadUI.this.finish();
        AppMethodBeat.o(34825);
        return true;
      }
    });
    this.HqO = ((ProgressBar)findViewById(R.h.dYJ));
    AppMethodBeat.o(34829);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34826);
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
      Log.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.fNu);
      AppMethodBeat.o(34826);
      return;
    }
    if ((this.msgId <= 0L) && (this.fNu > 0L))
    {
      bh.beI();
      this.msgId = c.bbO().aL(this.username, this.fNu).field_msgId;
    }
    this.HqU = new m(this.HqT.localId, this.msgId, this.lNK, this);
    bh.aGY().a(this.HqU, 0);
    AppMethodBeat.o(34826);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34827);
    super.onPause();
    bh.aGY().b(109, this);
    AppMethodBeat.o(34827);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34828);
    super.onResume();
    bh.aGY().a(109, this);
    AppMethodBeat.o(34828);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(34833);
    if (paramq.getType() != 109)
    {
      AppMethodBeat.o(34833);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      abR(this.HqO.getMax());
      AppMethodBeat.o(34833);
      return;
    }
    Log.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, R.l.imgdownload_fail, 1).show();
    AppMethodBeat.o(34833);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */