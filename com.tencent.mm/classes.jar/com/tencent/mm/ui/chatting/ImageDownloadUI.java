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
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.g;
import com.tencent.mm.av.h;
import com.tencent.mm.av.m;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.vfs.s;

public class ImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.ak.i, j
{
  private ProgressBar Bwt;
  private TextView Bwu;
  private TextView Bwv;
  private TextView Bww;
  private g Bwy;
  private m Bwz;
  private ImageView PjS;
  private long dTS = 0L;
  private int iXp;
  private long msgId = 0L;
  private TextView qLz;
  private String username;
  
  private void Vj(int paramInt)
  {
    AppMethodBeat.i(34831);
    this.Bwt.setProgress(paramInt);
    this.Bwu.setText(getString(2131760846, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.Bwt.getMax())
    {
      AppMethodBeat.o(34831);
      return;
    }
    g localg = com.tencent.mm.av.q.bcR().c(Long.valueOf(this.Bwz.iYP));
    String str = localg.iXm;
    if (this.iXp == 1) {
      str = h.c(localg);
    }
    bmA(com.tencent.mm.av.q.bcR().o(str, null, null));
    AppMethodBeat.o(34831);
  }
  
  private void bmA(String paramString)
  {
    AppMethodBeat.i(34832);
    if ((paramString == null) || (paramString.equals("")) || (!s.YS(paramString)))
    {
      Log.d("ImageDownloadUI", "showImg : imgPath is null");
      AppMethodBeat.o(34832);
      return;
    }
    Log.i("ImageDownloadUI", "[ImageGalleryUI] showImg");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_message_id", this.msgId);
    localIntent.putExtra("key_image_path", paramString);
    localIntent.putExtra("key_compress_type", this.iXp);
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("img_gallery_msg_id", this.msgId);
    localIntent.putExtra("img_gallery_talker", this.username);
    finish();
    AppMethodBeat.o(34832);
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.ak.q paramq)
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
      Vj(Math.max(0, paramInt1));
      AppMethodBeat.o(34830);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496791;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34829);
    this.Bwu = ((TextView)findViewById(2131302554));
    this.Bwv = ((TextView)findViewById(2131309751));
    this.qLz = ((TextView)findViewById(2131309752));
    this.Bww = ((TextView)findViewById(2131309749));
    this.PjS = ((ImageView)findViewById(2131299740));
    this.PjS.setImageResource(2131690098);
    this.Bwu.setVisibility(0);
    this.Bwv.setVisibility(8);
    this.qLz.setVisibility(8);
    this.Bww.setVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34825);
        bg.azz().a(ImageDownloadUI.a(ImageDownloadUI.this));
        ImageDownloadUI.this.finish();
        AppMethodBeat.o(34825);
        return true;
      }
    });
    this.Bwt = ((ProgressBar)findViewById(2131309750));
    AppMethodBeat.o(34829);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34826);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("img_msg_id", 0L);
    this.dTS = getIntent().getLongExtra("img_server_id", 0L);
    this.iXp = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.msgId > 0L) {
      this.Bwy = com.tencent.mm.av.q.bcR().H(this.username, this.msgId);
    }
    if (((this.Bwy == null) || (this.Bwy.localId <= 0L)) && (this.dTS > 0L)) {
      this.Bwy = com.tencent.mm.av.q.bcR().G(this.username, this.dTS);
    }
    if ((this.Bwy == null) || (this.Bwy.localId <= 0L))
    {
      Log.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dTS);
      AppMethodBeat.o(34826);
      return;
    }
    if ((this.msgId <= 0L) && (this.dTS > 0L))
    {
      bg.aVF();
      this.msgId = c.aSQ().aJ(this.username, this.dTS).field_msgId;
    }
    this.Bwz = new m(this.Bwy.localId, this.msgId, this.iXp, this);
    bg.azz().a(this.Bwz, 0);
    AppMethodBeat.o(34826);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34827);
    super.onPause();
    bg.azz().b(109, this);
    AppMethodBeat.o(34827);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34828);
    super.onResume();
    bg.azz().a(109, this);
    AppMethodBeat.o(34828);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(34833);
    if (paramq.getType() != 109)
    {
      AppMethodBeat.o(34833);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Vj(this.Bwt.getMax());
      AppMethodBeat.o(34833);
      return;
    }
    Log.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, 2131761767, 1).show();
    AppMethodBeat.o(34833);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */