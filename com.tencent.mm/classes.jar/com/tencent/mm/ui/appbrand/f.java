package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.base.r;

public final class f
  implements b.k
{
  private TextView KWK;
  private TextView KWL;
  r RnU;
  public boolean RnV;
  private String WgA;
  private ChatFooter WgB;
  private boolean WgC;
  public a WgD;
  MMHandler WgE;
  private long Wgy;
  private ImageView Wgz;
  private Bitmap bitmap;
  private View contentView;
  private Context context;
  private ImageView fIv;
  private ProgressBar fIx;
  private View jac;
  
  public f(Context paramContext, View paramView, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(33824);
    this.Wgy = 10000L;
    this.contentView = null;
    this.KWK = null;
    this.KWL = null;
    this.fIv = null;
    this.Wgz = null;
    this.fIx = null;
    this.WgA = null;
    this.bitmap = null;
    this.RnV = true;
    this.WgC = false;
    this.WgE = null;
    this.context = paramContext;
    this.jac = paramView;
    this.WgB = paramChatFooter;
    this.contentView = View.inflate(this.context, R.i.ecp, null);
    this.KWK = ((TextView)this.contentView.findViewById(R.h.dIU));
    this.KWL = ((TextView)this.contentView.findViewById(R.h.dIV));
    this.fIv = ((ImageView)this.contentView.findViewById(R.h.image_iv));
    this.Wgz = ((ImageView)this.contentView.findViewById(R.h.error_iv));
    this.fIx = ((ProgressBar)this.contentView.findViewById(R.h.dIS));
    this.RnU = new r(this.contentView, -2, -2, true);
    this.RnU.setBackgroundDrawable(new ColorDrawable(0));
    this.RnU.setOutsideTouchable(true);
    this.RnU.setFocusable(false);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33815);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (f.this.WgD != null) {
          f.this.WgD.hJo();
        }
        f.this.RnU.dismiss();
        a.a(this, "com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33815);
      }
    });
    this.WgE = new MMHandler(this.context.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33816);
        f.a(f.this);
        AppMethodBeat.o(33816);
      }
    };
    AppMethodBeat.o(33824);
  }
  
  public final void G(Bitmap paramBitmap)
  {
    AppMethodBeat.i(33821);
    Log.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
    if (paramBitmap == null)
    {
      Log.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
      AppMethodBeat.o(33821);
      return;
    }
    this.bitmap = paramBitmap;
    this.fIx.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.fIv.setVisibility(0);
      this.fIv.setImageBitmap(paramBitmap);
      this.Wgz.setVisibility(8);
      AppMethodBeat.o(33821);
      return;
    }
    this.Wgz.setVisibility(0);
    this.fIv.setVisibility(8);
    AppMethodBeat.o(33821);
  }
  
  public final void bhq()
  {
    AppMethodBeat.i(33820);
    Log.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.fIx.setVisibility(0);
    this.fIv.setVisibility(8);
    this.Wgz.setVisibility(8);
    AppMethodBeat.o(33820);
  }
  
  public final void bhr()
  {
    AppMethodBeat.i(33822);
    Log.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.Wgz.setVisibility(0);
    this.fIx.setVisibility(8);
    this.fIv.setVisibility(8);
    AppMethodBeat.o(33822);
  }
  
  public final String key()
  {
    AppMethodBeat.i(33823);
    String str = n.cP(this);
    AppMethodBeat.o(33823);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void hJo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.f
 * JD-Core Version:    0.7.0.1
 */