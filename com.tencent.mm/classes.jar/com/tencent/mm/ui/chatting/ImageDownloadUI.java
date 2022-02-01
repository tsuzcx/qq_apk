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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.h;
import com.tencent.mm.av.m;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.vfs.o;

public class ImageDownloadUI
  extends MMActivity
  implements f, com.tencent.mm.ak.g
{
  private ImageView JYF;
  private long dCd = 0L;
  private int icr;
  private long msgId = 0L;
  private TextView pwi;
  private String username;
  private ProgressBar xws;
  private TextView xwt;
  private TextView xwu;
  private TextView xwv;
  private com.tencent.mm.av.g xwx;
  private m xwy;
  
  private void NU(int paramInt)
  {
    AppMethodBeat.i(34831);
    this.xws.setProgress(paramInt);
    this.xwt.setText(getString(2131759531, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.xws.getMax())
    {
      AppMethodBeat.o(34831);
      return;
    }
    com.tencent.mm.av.g localg = com.tencent.mm.av.q.aIX().c(Long.valueOf(this.xwy.idT));
    String str = localg.ico;
    if (this.icr == 1) {
      str = h.c(localg);
    }
    aXw(com.tencent.mm.av.q.aIX().o(str, null, null));
    AppMethodBeat.o(34831);
  }
  
  private void aXw(String paramString)
  {
    AppMethodBeat.i(34832);
    if ((paramString == null) || (paramString.equals("")) || (!o.fB(paramString)))
    {
      ae.d("ImageDownloadUI", "showImg : imgPath is null");
      AppMethodBeat.o(34832);
      return;
    }
    ae.i("ImageDownloadUI", "[ImageGalleryUI] showImg");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_message_id", this.msgId);
    localIntent.putExtra("key_image_path", paramString);
    localIntent.putExtra("key_compress_type", this.icr);
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("img_gallery_msg_id", this.msgId);
    localIntent.putExtra("img_gallery_talker", this.username);
    finish();
    AppMethodBeat.o(34832);
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(34830);
    ae.d("ImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramn.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      NU(Math.max(0, paramInt1));
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
    this.xwt = ((TextView)findViewById(2131300925));
    this.xwu = ((TextView)findViewById(2131306329));
    this.pwi = ((TextView)findViewById(2131306330));
    this.xwv = ((TextView)findViewById(2131306327));
    this.JYF = ((ImageView)findViewById(2131299189));
    this.JYF.setImageResource(2131690066);
    this.xwt.setVisibility(0);
    this.xwu.setVisibility(8);
    this.pwi.setVisibility(8);
    this.xwv.setVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34825);
        bc.ajj().a(ImageDownloadUI.a(ImageDownloadUI.this));
        ImageDownloadUI.this.finish();
        AppMethodBeat.o(34825);
        return true;
      }
    });
    this.xws = ((ProgressBar)findViewById(2131306328));
    AppMethodBeat.o(34829);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34826);
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
      ae.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dCd);
      AppMethodBeat.o(34826);
      return;
    }
    if ((this.msgId <= 0L) && (this.dCd > 0L))
    {
      bc.aCg();
      this.msgId = c.azI().aJ(this.username, this.dCd).field_msgId;
    }
    this.xwy = new m(this.xwx.doE, this.msgId, this.icr, this);
    bc.ajj().a(this.xwy, 0);
    AppMethodBeat.o(34826);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34827);
    super.onPause();
    bc.ajj().b(109, this);
    AppMethodBeat.o(34827);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34828);
    super.onResume();
    bc.ajj().a(109, this);
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
      NU(this.xws.getMax());
      AppMethodBeat.o(34833);
      return;
    }
    ae.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
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