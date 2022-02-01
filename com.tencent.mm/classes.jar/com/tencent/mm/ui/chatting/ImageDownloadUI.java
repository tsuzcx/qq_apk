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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e;
import com.tencent.mm.av.f;
import com.tencent.mm.av.k;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.vfs.i;

public class ImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.ak.g, com.tencent.mm.ak.h
{
  private ImageView HPZ;
  private long dpl = 0L;
  private int hGP;
  private long msgId = 0L;
  private TextView oLU;
  private String username;
  private ProgressBar vYV;
  private TextView vYW;
  private TextView vYX;
  private TextView vYY;
  private e vZa;
  private k vZb;
  
  private void LP(int paramInt)
  {
    AppMethodBeat.i(34831);
    this.vYV.setProgress(paramInt);
    this.vYW.setText(getString(2131759531, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.vYV.getMax())
    {
      AppMethodBeat.o(34831);
      return;
    }
    e locale = o.aFx().c(Long.valueOf(this.vZb.hIm));
    String str = locale.hGM;
    if (this.hGP == 1) {
      str = f.c(locale);
    }
    aQf(o.aFx().p(str, null, null));
    AppMethodBeat.o(34831);
  }
  
  private void aQf(String paramString)
  {
    AppMethodBeat.i(34832);
    if ((paramString == null) || (paramString.equals("")) || (!i.eA(paramString)))
    {
      ac.d("ImageDownloadUI", "showImg : imgPath is null");
      AppMethodBeat.o(34832);
      return;
    }
    ac.i("ImageDownloadUI", "[ImageGalleryUI] showImg");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_message_id", this.msgId);
    localIntent.putExtra("key_image_path", paramString);
    localIntent.putExtra("key_compress_type", this.hGP);
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("img_gallery_msg_id", this.msgId);
    localIntent.putExtra("img_gallery_talker", this.username);
    finish();
    AppMethodBeat.o(34832);
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(34830);
    ac.d("ImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramn.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      LP(Math.max(0, paramInt1));
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
    this.vYW = ((TextView)findViewById(2131300925));
    this.vYX = ((TextView)findViewById(2131306329));
    this.oLU = ((TextView)findViewById(2131306330));
    this.vYY = ((TextView)findViewById(2131306327));
    this.HPZ = ((ImageView)findViewById(2131299189));
    this.HPZ.setImageResource(2131690066);
    this.vYW.setVisibility(0);
    this.vYX.setVisibility(8);
    this.oLU.setVisibility(8);
    this.vYY.setVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34825);
        az.agi().a(ImageDownloadUI.a(ImageDownloadUI.this));
        ImageDownloadUI.this.finish();
        AppMethodBeat.o(34825);
        return true;
      }
    });
    this.vYV = ((ProgressBar)findViewById(2131306328));
    AppMethodBeat.o(34829);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34826);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("img_msg_id", 0L);
    this.dpl = getIntent().getLongExtra("img_server_id", 0L);
    this.hGP = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.msgId > 0L) {
      this.vZa = o.aFx().qg(this.msgId);
    }
    if (((this.vZa == null) || (this.vZa.dcd <= 0L)) && (this.dpl > 0L)) {
      this.vZa = o.aFx().qf(this.dpl);
    }
    if ((this.vZa == null) || (this.vZa.dcd <= 0L))
    {
      ac.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dpl);
      AppMethodBeat.o(34826);
      return;
    }
    if ((this.msgId <= 0L) && (this.dpl > 0L))
    {
      az.ayM();
      this.msgId = c.awD().aF(this.username, this.dpl).field_msgId;
    }
    this.vZb = new k(this.vZa.dcd, this.msgId, this.hGP, this);
    az.agi().a(this.vZb, 0);
    AppMethodBeat.o(34826);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34827);
    super.onPause();
    az.agi().b(109, this);
    AppMethodBeat.o(34827);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34828);
    super.onResume();
    az.agi().a(109, this);
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
      LP(this.vYV.getMax());
      AppMethodBeat.o(34833);
      return;
    }
    ac.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
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