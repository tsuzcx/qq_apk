package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements b.h
{
  private ImageView bQf = null;
  private ProgressBar bQh = null;
  private Bitmap bitmap = null;
  private View contentView = null;
  private Context context;
  private View khn;
  private View lHw;
  private TextView pcv = null;
  private TextView pcw = null;
  com.tencent.mm.ui.base.o sgx;
  public boolean sgy = true;
  private long uRM = 10000L;
  private ImageView uRN = null;
  private String uRO = null;
  private boolean uRP = false;
  private boolean uRQ = false;
  public c.a uRR;
  ah uRS = null;
  
  public c(Context paramContext, View paramView1, View paramView2, boolean paramBoolean)
  {
    this.context = paramContext;
    this.khn = paramView1;
    this.lHw = paramView2;
    this.uRQ = paramBoolean;
    this.contentView = View.inflate(this.context, R.i.chatting_footer_app_brand_image_bubble, null);
    this.pcv = ((TextView)this.contentView.findViewById(R.h.image_tv_1));
    this.pcw = ((TextView)this.contentView.findViewById(R.h.image_tv_2));
    this.bQf = ((ImageView)this.contentView.findViewById(R.h.image_iv));
    this.uRN = ((ImageView)this.contentView.findViewById(R.h.error_iv));
    this.bQh = ((ProgressBar)this.contentView.findViewById(R.h.image_pb));
    this.sgx = new com.tencent.mm.ui.base.o(this.contentView, -2, -2, true);
    this.sgx.setBackgroundDrawable(new ColorDrawable(0));
    this.sgx.setOutsideTouchable(true);
    this.sgx.setFocusable(false);
    this.contentView.setOnClickListener(new c.1(this));
    this.uRS = new c.2(this, this.context.getMainLooper());
  }
  
  public final void JG()
  {
    y.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.bQh.setVisibility(0);
    this.bQf.setVisibility(8);
    this.uRN.setVisibility(8);
  }
  
  public final void JH()
  {
    y.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.uRN.setVisibility(0);
    this.bQh.setVisibility(8);
    this.bQf.setVisibility(8);
  }
  
  public final void p(Bitmap paramBitmap)
  {
    y.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
    if (paramBitmap == null)
    {
      y.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
      return;
    }
    this.bitmap = paramBitmap;
    this.bQh.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.bQf.setVisibility(0);
      this.bQf.setImageBitmap(paramBitmap);
      this.uRN.setVisibility(8);
      return;
    }
    this.uRN.setVisibility(0);
    this.bQf.setVisibility(8);
  }
  
  public final String pU()
  {
    return com.tencent.mm.plugin.appbrand.u.o.aX(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c
 * JD-Core Version:    0.7.0.1
 */