package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.d.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.i;

public final class c
  extends i
  implements d.a
{
  public int cKC;
  public String eNO;
  private com.tencent.mm.model.d idF;
  public String imagePath;
  private e kvG;
  public int mwo;
  public int qTq;
  private TextView qUj;
  private boolean qUk;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131493913);
    AppMethodBeat.i(70285);
    this.kvG = null;
    this.qUj = null;
    this.cKC = 0;
    this.qTq = 0;
    this.mwo = 0;
    this.qUk = false;
    this.idF = new com.tencent.mm.model.d();
    AppMethodBeat.o(70285);
  }
  
  private void cmN()
  {
    AppMethodBeat.i(70287);
    ab.v("check", "onclick");
    if (this.kvG.isPlaying())
    {
      this.kvG.pause();
      this.idF.cJ(false);
    }
    new ak().post(new c.4(this));
    AppMethodBeat.o(70287);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(70288);
    ab.d("MicroMsg.VideoPopupHelper", "on dismiss");
    if (com.tencent.mm.booter.a.Ia() != null) {
      com.tencent.mm.booter.a.Ia().Ib();
    }
    if (this.kvG != null)
    {
      this.kvG.setVideoCallback(null);
      this.kvG.stop();
      this.kvG.onDetach();
      findViewById(2131824108).setOnClickListener(null);
    }
    if ((!this.qUk) && (isShowing()))
    {
      ua localua = new ua();
      localua.cKz.type = 0;
      localua.cKz.cKA = this.qTq;
      localua.cKz.cKB = this.mwo;
      localua.cKz.cKC = this.cKC;
      com.tencent.mm.sdk.b.a.ymk.l(localua);
    }
    super.dismiss();
    this.idF.cJ(true);
    AppMethodBeat.o(70288);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70286);
    long l = System.currentTimeMillis();
    ab.d("MicroMsg.VideoPopupHelper", l + " initView beg");
    super.onCreate(paramBundle);
    getWindow().setFlags(16777216, 16777216);
    setContentView(2130970730);
    if (com.tencent.mm.booter.a.Ia() != null) {
      com.tencent.mm.booter.a.Ia().Ic();
    }
    ab.d("MicroMsg.VideoPopupHelper", g.Mk() + " initView: fullpath:" + this.eNO + ", imagepath:" + this.imagePath);
    this.qUj = ((TextView)findViewById(2131823916));
    findViewById(2131827797).setVisibility(8);
    paramBundle = (ViewGroup)findViewById(2131824108);
    paramBundle.setBackgroundResource(2131689763);
    ab.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
    if (com.tencent.mm.compatible.util.d.fv(14)) {}
    for (this.kvG = new VideoTextureView(getContext());; this.kvG = new VideoSurfaceView(getContext()))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      paramBundle.addView((View)this.kvG, localLayoutParams);
      this.kvG.setVideoCallback(new c.1(this));
      findViewById(2131824108).setOnClickListener(new c.2(this));
      ((View)this.kvG).setOnClickListener(new c.3(this));
      if (this.eNO != null)
      {
        this.kvG.stop();
        this.kvG.setVideoPath(this.eNO);
      }
      ab.d("MicroMsg.VideoPopupHelper", System.currentTimeMillis() - l + " initView end");
      paramBundle = new ua();
      paramBundle.cKz.type = 1;
      com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
      AppMethodBeat.o(70286);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c
 * JD-Core Version:    0.7.0.1
 */