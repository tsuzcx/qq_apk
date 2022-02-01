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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.f;
import com.tencent.mm.aw.k;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.vfs.i;

public class ImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.al.g, com.tencent.mm.al.h
{
  private ImageView Gqh;
  private long drA = 0L;
  private int hgm;
  private long msgId = 0L;
  private TextView oiu;
  private ProgressBar uQf;
  private TextView uQg;
  private TextView uQh;
  private TextView uQi;
  private e uQk;
  private k uQl;
  private String username;
  
  private void JQ(int paramInt)
  {
    AppMethodBeat.i(34831);
    this.uQf.setProgress(paramInt);
    this.uQg.setText(getString(2131759531, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.uQf.getMax())
    {
      AppMethodBeat.o(34831);
      return;
    }
    e locale = o.ayF().b(Long.valueOf(this.uQl.hhJ));
    String str = locale.hgj;
    if (this.hgm == 1) {
      str = f.c(locale);
    }
    aKC(o.ayF().p(str, null, null));
    AppMethodBeat.o(34831);
  }
  
  private void aKC(String paramString)
  {
    AppMethodBeat.i(34832);
    if ((paramString == null) || (paramString.equals("")) || (!i.eK(paramString)))
    {
      ad.d("ImageDownloadUI", "showImg : imgPath is null");
      AppMethodBeat.o(34832);
      return;
    }
    ad.i("ImageDownloadUI", "[ImageGalleryUI] showImg");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_message_id", this.msgId);
    localIntent.putExtra("key_image_path", paramString);
    localIntent.putExtra("key_compress_type", this.hgm);
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
      JQ(Math.max(0, paramInt1));
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
    this.uQg = ((TextView)findViewById(2131300925));
    this.uQh = ((TextView)findViewById(2131306329));
    this.oiu = ((TextView)findViewById(2131306330));
    this.uQi = ((TextView)findViewById(2131306327));
    this.Gqh = ((ImageView)findViewById(2131299189));
    this.Gqh.setImageResource(2131690066);
    this.uQg.setVisibility(0);
    this.uQh.setVisibility(8);
    this.oiu.setVisibility(8);
    this.uQi.setVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34825);
        az.aeS().a(ImageDownloadUI.a(ImageDownloadUI.this));
        ImageDownloadUI.this.finish();
        AppMethodBeat.o(34825);
        return true;
      }
    });
    this.uQf = ((ProgressBar)findViewById(2131306328));
    AppMethodBeat.o(34829);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34826);
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
      ad.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.drA);
      AppMethodBeat.o(34826);
      return;
    }
    if ((this.msgId <= 0L) && (this.drA > 0L))
    {
      az.arV();
      this.msgId = c.apO().aD(this.username, this.drA).field_msgId;
    }
    this.uQl = new k(this.uQk.deI, this.msgId, this.hgm, this);
    az.aeS().a(this.uQl, 0);
    AppMethodBeat.o(34826);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34827);
    super.onPause();
    az.aeS().b(109, this);
    AppMethodBeat.o(34827);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34828);
    super.onResume();
    az.aeS().a(109, this);
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
      JQ(this.uQf.getMax());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */