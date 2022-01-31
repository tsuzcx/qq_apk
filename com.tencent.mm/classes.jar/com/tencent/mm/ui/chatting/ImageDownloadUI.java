package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.k;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

public class ImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.ai.f, com.tencent.mm.ai.g
{
  private long cFn = 0L;
  private long cpO = 0L;
  private int fDP;
  private TextView lbt;
  private ProgressBar pNT;
  private TextView pNU;
  private TextView pNV;
  private TextView pNW;
  private com.tencent.mm.at.e pNY;
  private k pNZ;
  private String username;
  private ImageView zBR;
  
  private void Cb(int paramInt)
  {
    AppMethodBeat.i(30951);
    this.pNT.setProgress(paramInt);
    this.pNU.setText(getString(2131300064, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.pNT.getMax())
    {
      AppMethodBeat.o(30951);
      return;
    }
    com.tencent.mm.at.e locale = o.ahC().b(Long.valueOf(this.pNZ.fFk));
    String str = locale.fDM;
    if (this.fDP == 1) {
      str = com.tencent.mm.at.f.c(locale);
    }
    atO(o.ahC().q(str, null, null));
    AppMethodBeat.o(30951);
  }
  
  private void atO(String paramString)
  {
    AppMethodBeat.i(30952);
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.e.cN(paramString)))
    {
      ab.d("ImageDownloadUI", "showImg : imgPath is null");
      AppMethodBeat.o(30952);
      return;
    }
    ab.i("ImageDownloadUI", "[ImageGalleryUI] showImg");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_message_id", this.cpO);
    localIntent.putExtra("key_image_path", paramString);
    localIntent.putExtra("key_compress_type", this.fDP);
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("img_gallery_msg_id", this.cpO);
    localIntent.putExtra("img_gallery_talker", this.username);
    finish();
    AppMethodBeat.o(30952);
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(30950);
    ab.d("ImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramm.getType() == 109) {
      if (paramInt2 == 0) {
        break label74;
      }
    }
    label74:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      Cb(Math.max(0, paramInt1));
      AppMethodBeat.o(30950);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130971061;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30949);
    this.pNU = ((TextView)findViewById(2131825880));
    this.pNV = ((TextView)findViewById(2131828693));
    this.lbt = ((TextView)findViewById(2131828694));
    this.pNW = ((TextView)findViewById(2131828695));
    this.zBR = ((ImageView)findViewById(2131828691));
    this.zBR.setImageResource(2131231253);
    this.pNU.setVisibility(0);
    this.pNV.setVisibility(8);
    this.lbt.setVisibility(8);
    this.pNW.setVisibility(8);
    setBackBtn(new ImageDownloadUI.1(this));
    this.pNT = ((ProgressBar)findViewById(2131828692));
    AppMethodBeat.o(30949);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30946);
    super.onCreate(paramBundle);
    this.cpO = getIntent().getLongExtra("img_msg_id", 0L);
    this.cFn = getIntent().getLongExtra("img_server_id", 0L);
    this.fDP = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.cpO > 0L) {
      this.pNY = o.ahC().gT(this.cpO);
    }
    if (((this.pNY == null) || (this.pNY.fDL <= 0L)) && (this.cFn > 0L)) {
      this.pNY = o.ahC().gS(this.cFn);
    }
    if ((this.pNY == null) || (this.pNY.fDL <= 0L))
    {
      ab.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.cpO + ", or msgSvrId = " + this.cFn);
      AppMethodBeat.o(30946);
      return;
    }
    if ((this.cpO <= 0L) && (this.cFn > 0L))
    {
      aw.aaz();
      this.cpO = c.YC().ag(this.username, this.cFn).field_msgId;
    }
    this.pNZ = new k(this.pNY.fDL, this.cpO, this.fDP, this);
    aw.Rc().a(this.pNZ, 0);
    AppMethodBeat.o(30946);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30947);
    super.onPause();
    aw.Rc().b(109, this);
    AppMethodBeat.o(30947);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30948);
    super.onResume();
    aw.Rc().a(109, this);
    AppMethodBeat.o(30948);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(30953);
    if (paramm.getType() != 109)
    {
      AppMethodBeat.o(30953);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Cb(this.pNT.getMax());
      AppMethodBeat.o(30953);
      return;
    }
    ab.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, 2131300726, 1).show();
    AppMethodBeat.o(30953);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */