package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class k
{
  String bRO = "";
  long createTime;
  String fileId;
  public View kKz;
  public TextView kfj;
  public int mPosition;
  int oHM = 0;
  public c vuf;
  public c.b vwY;
  public HashMap<String, Boolean> vwZ = new HashMap();
  public RelativeLayout vxa;
  public f vxb;
  public ImageView vxc;
  public ImageView vxd;
  public MMPinProgressBtn vxe;
  public View vxf;
  public RelativeLayout vxg;
  public ImageView vxh;
  public ImageView vxi;
  public f vxj;
  public MMPinProgressBtn vxk;
  public TextView vxl;
  public LinearLayout vxm;
  public TextView vxn;
  public TextView vxo;
  public ImageView vxp;
  public ProgressBar vxq;
  public ProgressBar vxr;
  public LinearLayout vxs;
  public TextView vxt;
  public ImageView vxu;
  public MultiTouchImageView vxv;
  public WxImageView vxw;
  int vxx = 0;
  int vxy = 0;
  
  @TargetApi(11)
  public k(c paramc, View paramView)
  {
    this.kKz = paramView;
    this.vuf = paramc;
    this.vxv = ((MultiTouchImageView)paramView.findViewById(R.h.image));
    this.vxw = ((WxImageView)paramView.findViewById(R.h.wx_image));
    this.vxr = ((ProgressBar)paramView.findViewById(R.h.image_gallery_download_circle_pb));
    if (this.vxw != null) {
      this.vxw.setForceTileFlag(com.tencent.mm.graphics.a.c.dDd);
    }
    if ((com.tencent.mm.compatible.util.d.gF(11)) && (paramView.getLayerType() != 2)) {
      paramView.setLayerType(2, null);
    }
  }
  
  public static void X(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    y.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)cGH().vxj;
      localView.setAlpha(paramFloat);
      X(localView, 0);
      if (paramFloat >= 1.0D)
      {
        X(cGH().vxh, 8);
        X(cGH().vxi, 8);
      }
      return;
    }
    X((View)cGH().vxj, 8);
    X(cGH().vxh, 0);
    X(cGH().vxi, 0);
  }
  
  public final k cGE()
  {
    if (this.vxm == null)
    {
      this.vxm = ((LinearLayout)((ViewStub)this.kKz.findViewById(R.h.image_gallery_downloading)).inflate());
      this.vxq = ((ProgressBar)this.vxm.findViewById(R.h.downloading_pb));
      this.vxn = ((TextView)this.vxm.findViewById(R.h.downloading_percent_tv));
      this.vxo = ((TextView)this.vxm.findViewById(R.h.downloading_hd_tip_tv));
      this.vxp = ((ImageView)this.vxm.findViewById(R.h.downloading_thumb_iv));
    }
    return this;
  }
  
  public final k cGF()
  {
    if (this.vxs == null)
    {
      this.vxs = ((LinearLayout)((ViewStub)this.kKz.findViewById(R.h.image_gallery_download_fail)).inflate());
      this.vxu = ((ImageView)this.vxs.findViewById(R.h.download_fail_iv));
      this.vxt = ((TextView)this.vxs.findViewById(R.h.download_fail_text));
    }
    return this;
  }
  
  public final k cGG()
  {
    if (this.vxa == null)
    {
      this.vxa = ((RelativeLayout)((ViewStub)this.kKz.findViewById(R.h.sight_root)).inflate());
      this.vxb = o.fb(this.kKz.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.vxa.addView((View)this.vxb, localLayoutParams);
      ((View)this.vxb).setVisibility(8);
      this.vxf = this.vxa.findViewById(R.h.tips_tv);
      this.vxf.setVisibility(8);
      this.kfj = ((TextView)this.vxa.findViewById(R.h.show_ad_sight));
      this.vxe = ((MMPinProgressBtn)this.vxa.findViewById(R.h.sight_downloading_pb));
      this.vxe.setVisibility(8);
      this.vxc = ((ImageView)this.vxa.findViewById(R.h.sight_image));
      this.vxd = ((ImageView)this.vxa.findViewById(R.h.videoplayer_icon));
      this.vxb.setVideoCallback(new k.1(this));
      this.kfj.setOnClickListener(new k.2(this));
    }
    return this;
  }
  
  public final k cGH()
  {
    if (this.vxg == null)
    {
      if (this.vxw != null) {
        this.vxw.setVisibility(8);
      }
      if (this.vxv != null) {
        this.vxv.setVisibility(8);
      }
      this.vxg = ((RelativeLayout)((ViewStub)this.kKz.findViewById(R.h.video_root)).inflate());
      this.vxh = ((ImageView)this.vxg.findViewById(R.h.video_image));
      this.vxi = ((ImageView)this.vxg.findViewById(R.h.video_wait_play_btn));
      this.vxi.setOnClickListener(new k.3(this));
      com.tencent.mm.modelcontrol.d.Nl();
      if (!com.tencent.mm.modelcontrol.d.Ns()) {
        break label263;
      }
      this.vxj = new VideoPlayerTextureView(this.kKz.getContext());
      h.nFQ.a(354L, 150L, 1L, false);
    }
    for (;;)
    {
      this.vxl = ((TextView)this.kKz.findViewById(R.h.debuginfo_tv));
      this.vxj.setPlayProgressCallback(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.vxg.addView((View)this.vxj, 2, localLayoutParams);
      this.vxk = ((MMPinProgressBtn)this.vxg.findViewById(R.h.video_downloading_pb));
      this.vxk.setVisibility(8);
      ((View)this.vxj).setVisibility(8);
      this.vxj.setVideoCallback(new k.4(this));
      return this;
      label263:
      this.vxj = new VideoTextureView(this.kKz.getContext());
      h.nFQ.a(354L, 151L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k
 * JD-Core Version:    0.7.0.1
 */