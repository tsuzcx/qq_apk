package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.h.a.si;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.ai.a.b;
import com.tencent.mm.plugin.ai.a.e;
import com.tencent.mm.plugin.ai.a.f;
import com.tencent.mm.plugin.ai.a.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.i;

public final class c
  extends i
  implements d.a
{
  public int cbW = 0;
  public String erh;
  private com.tencent.mm.model.d gEB = new com.tencent.mm.model.d();
  public int hkH = 0;
  public String imagePath;
  private f iuC = null;
  private TextView ofU = null;
  private boolean ofV = false;
  public int ofb = 0;
  
  public c(Context paramContext)
  {
    super(paramContext, a.i.videodialog);
  }
  
  private void bBn()
  {
    y.v("check", "onclick");
    if (this.iuC.isPlaying())
    {
      this.iuC.pause();
      this.gEB.bH(false);
    }
    new ah().post(new c.4(this));
  }
  
  public final void dismiss()
  {
    y.d("MicroMsg.VideoPopupHelper", "on dismiss");
    if (com.tencent.mm.booter.a.vR() != null) {
      com.tencent.mm.booter.a.vR().vS();
    }
    if (this.iuC != null)
    {
      this.iuC.setVideoCallback(null);
      this.iuC.stop();
      this.iuC.onDetach();
      findViewById(a.e.video_container).setOnClickListener(null);
    }
    if ((!this.ofV) && (isShowing()))
    {
      si localsi = new si();
      localsi.cbT.type = 0;
      localsi.cbT.cbU = this.ofb;
      localsi.cbT.cbV = this.hkH;
      localsi.cbT.cbW = this.cbW;
      com.tencent.mm.sdk.b.a.udP.m(localsi);
    }
    super.dismiss();
    this.gEB.bH(true);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    y.d("MicroMsg.VideoPopupHelper", l + " initView beg");
    super.onCreate(paramBundle);
    getWindow().setFlags(16777216, 16777216);
    setContentView(a.f.shortvideoplayer);
    if (com.tencent.mm.booter.a.vR() != null) {
      com.tencent.mm.booter.a.vR().vT();
    }
    y.d("MicroMsg.VideoPopupHelper", g.zH() + " initView: fullpath:" + this.erh + ", imagepath:" + this.imagePath);
    this.ofU = ((TextView)findViewById(a.e.tips_tv));
    findViewById(a.e.show_ad_sight).setVisibility(8);
    paramBundle = (ViewGroup)findViewById(a.e.video_container);
    paramBundle.setBackgroundResource(a.b.black);
    y.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
    if (com.tencent.mm.compatible.util.d.gF(14)) {}
    for (this.iuC = new VideoTextureView(getContext());; this.iuC = new VideoSurfaceView(getContext()))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      paramBundle.addView((View)this.iuC, localLayoutParams);
      this.iuC.setVideoCallback(new c.1(this));
      findViewById(a.e.video_container).setOnClickListener(new c.2(this));
      ((View)this.iuC).setOnClickListener(new c.3(this));
      if (this.erh != null)
      {
        this.iuC.stop();
        this.iuC.setVideoPath(this.erh);
      }
      y.d("MicroMsg.VideoPopupHelper", System.currentTimeMillis() - l + " initView end");
      paramBundle = new si();
      paramBundle.cbT.type = 1;
      com.tencent.mm.sdk.b.a.udP.m(paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c
 * JD-Core Version:    0.7.0.1
 */