package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.n;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.vfs.y;

public class ImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.am.h, com.tencent.mm.am.i
{
  private TextView NoC;
  private TextView NoD;
  private TextView NoE;
  private com.tencent.mm.modelimage.h NoG;
  private n NoH;
  private ImageView aela;
  private long hTh = 0L;
  private long msgId = 0L;
  private int oGu;
  private String username;
  private TextView xsX;
  private ProgressBar ycl;
  
  private void agf(int paramInt)
  {
    AppMethodBeat.i(34831);
    this.ycl.setProgress(paramInt);
    this.NoC.setText(getString(R.l.fmt_percent, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.ycl.getMax())
    {
      AppMethodBeat.o(34831);
      return;
    }
    com.tencent.mm.modelimage.h localh = r.bKa().b(Long.valueOf(this.NoH.oHT));
    String str = localh.oGr;
    if (this.oGu == 1) {
      str = com.tencent.mm.modelimage.i.c(localh);
    }
    str = r.bKa().v(str, null, null);
    localh.bJE();
    bAF(str);
    AppMethodBeat.o(34831);
  }
  
  private void bAF(String paramString)
  {
    AppMethodBeat.i(34832);
    if ((paramString == null) || (paramString.equals("")) || (!y.ZC(paramString)))
    {
      Log.d("ImageDownloadUI", "showImg : imgPath is null");
      AppMethodBeat.o(34832);
      return;
    }
    Log.i("ImageDownloadUI", "[ImageGalleryUI] showImg");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_message_id", this.msgId);
    localIntent.putExtra("key_image_path", paramString);
    localIntent.putExtra("key_compress_type", this.oGu);
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("img_gallery_msg_id", this.msgId);
    localIntent.putExtra("img_gallery_talker", this.username);
    finish();
    AppMethodBeat.o(34832);
  }
  
  public final void a(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(34830);
    Log.d("ImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramp.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      agf(Math.max(0, paramInt1));
      AppMethodBeat.o(34830);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.goL;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34829);
    this.NoC = ((TextView)findViewById(R.h.image_download_percent_tv));
    this.NoD = ((TextView)findViewById(R.h.gby));
    this.xsX = ((TextView)findViewById(R.h.gbz));
    this.NoE = ((TextView)findViewById(R.h.gbw));
    this.aela = ((ImageView)findViewById(R.h.fGa));
    this.aela.setImageResource(R.k.download_image_icon);
    this.NoC.setVisibility(0);
    this.NoD.setVisibility(8);
    this.xsX.setVisibility(8);
    this.NoE.setVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34825);
        bh.aZW().a(ImageDownloadUI.a(ImageDownloadUI.this));
        ImageDownloadUI.this.finish();
        AppMethodBeat.o(34825);
        return true;
      }
    });
    this.ycl = ((ProgressBar)findViewById(R.h.gbx));
    AppMethodBeat.o(34829);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34826);
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
      Log.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.hTh);
      AppMethodBeat.o(34826);
      return;
    }
    if ((this.msgId <= 0L) && (this.hTh > 0L))
    {
      bh.bCz();
      this.msgId = c.bzD().aU(this.username, this.hTh).field_msgId;
    }
    this.NoH = new n(this.NoG.localId, this.msgId, this.oGu, this);
    bh.aZW().a(this.NoH, 0);
    AppMethodBeat.o(34826);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34827);
    super.onPause();
    bh.aZW().b(109, this);
    AppMethodBeat.o(34827);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34828);
    super.onResume();
    bh.aZW().a(109, this);
    AppMethodBeat.o(34828);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(34833);
    if (paramp.getType() != 109)
    {
      AppMethodBeat.o(34833);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      agf(this.ycl.getMax());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */