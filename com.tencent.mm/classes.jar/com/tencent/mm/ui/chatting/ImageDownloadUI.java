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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.h;
import com.tencent.mm.aw.m;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

public class ImageDownloadUI
  extends MMActivity
  implements f, com.tencent.mm.al.g
{
  private ImageView JDO;
  private long dAY = 0L;
  private int hZz;
  private long msgId = 0L;
  private TextView ppC;
  private String username;
  private ProgressBar xgA;
  private TextView xgB;
  private TextView xgC;
  private TextView xgD;
  private com.tencent.mm.aw.g xgF;
  private m xgG;
  
  private void No(int paramInt)
  {
    AppMethodBeat.i(34831);
    this.xgA.setProgress(paramInt);
    this.xgB.setText(getString(2131759531, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.xgA.getMax())
    {
      AppMethodBeat.o(34831);
      return;
    }
    com.tencent.mm.aw.g localg = com.tencent.mm.aw.q.aIF().c(Long.valueOf(this.xgG.iba));
    String str = localg.hZw;
    if (this.hZz == 1) {
      str = h.c(localg);
    }
    aVV(com.tencent.mm.aw.q.aIF().o(str, null, null));
    AppMethodBeat.o(34831);
  }
  
  private void aVV(String paramString)
  {
    AppMethodBeat.i(34832);
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.i.fv(paramString)))
    {
      ad.d("ImageDownloadUI", "showImg : imgPath is null");
      AppMethodBeat.o(34832);
      return;
    }
    ad.i("ImageDownloadUI", "[ImageGalleryUI] showImg");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_message_id", this.msgId);
    localIntent.putExtra("key_image_path", paramString);
    localIntent.putExtra("key_compress_type", this.hZz);
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("img_gallery_msg_id", this.msgId);
    localIntent.putExtra("img_gallery_talker", this.username);
    finish();
    AppMethodBeat.o(34832);
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(34830);
    ad.d("ImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramn.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      No(Math.max(0, paramInt1));
      AppMethodBeat.o(34830);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495827;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34829);
    this.xgB = ((TextView)findViewById(2131300925));
    this.xgC = ((TextView)findViewById(2131306329));
    this.ppC = ((TextView)findViewById(2131306330));
    this.xgD = ((TextView)findViewById(2131306327));
    this.JDO = ((ImageView)findViewById(2131299189));
    this.JDO.setImageResource(2131690066);
    this.xgB.setVisibility(0);
    this.xgC.setVisibility(8);
    this.ppC.setVisibility(8);
    this.xgD.setVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34825);
        ba.aiU().a(ImageDownloadUI.a(ImageDownloadUI.this));
        ImageDownloadUI.this.finish();
        AppMethodBeat.o(34825);
        return true;
      }
    });
    this.xgA = ((ProgressBar)findViewById(2131306328));
    AppMethodBeat.o(34829);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34826);
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
      ad.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dAY);
      AppMethodBeat.o(34826);
      return;
    }
    if ((this.msgId <= 0L) && (this.dAY > 0L))
    {
      ba.aBQ();
      this.msgId = c.azs().aI(this.username, this.dAY).field_msgId;
    }
    this.xgG = new m(this.xgF.dnz, this.msgId, this.hZz, this);
    ba.aiU().a(this.xgG, 0);
    AppMethodBeat.o(34826);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34827);
    super.onPause();
    ba.aiU().b(109, this);
    AppMethodBeat.o(34827);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34828);
    super.onResume();
    ba.aiU().a(109, this);
    AppMethodBeat.o(34828);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34833);
    if (paramn.getType() != 109)
    {
      AppMethodBeat.o(34833);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      No(this.xgA.getMax());
      AppMethodBeat.o(34833);
      return;
    }
    ad.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, 2131760323, 1).show();
    AppMethodBeat.o(34833);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */