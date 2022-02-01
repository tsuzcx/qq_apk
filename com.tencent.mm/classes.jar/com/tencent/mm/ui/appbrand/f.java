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
import com.tencent.mm.model.bh;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.af.p;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.base.v;

public final class f
  implements b.k
{
  private TextView JfT;
  private TextView JfU;
  v Ykl;
  public boolean Ykm;
  MMHandler adNA;
  private long adNu;
  private ImageView adNv;
  private String adNw;
  private ChatFooter adNx;
  private boolean adNy;
  public a adNz;
  private Bitmap bitmap;
  private View contentView;
  private Context context;
  private ImageView hNV;
  private ProgressBar hNX;
  private View lBX;
  
  public f(Context paramContext, View paramView, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(33824);
    this.adNu = 10000L;
    this.contentView = null;
    this.JfT = null;
    this.JfU = null;
    this.hNV = null;
    this.adNv = null;
    this.hNX = null;
    this.adNw = null;
    this.bitmap = null;
    this.Ykm = true;
    this.adNy = false;
    this.adNA = null;
    this.context = paramContext;
    this.lBX = paramView;
    this.adNx = paramChatFooter;
    this.contentView = View.inflate(this.context, R.i.geX, null);
    this.JfT = ((TextView)this.contentView.findViewById(R.h.fKp));
    this.JfU = ((TextView)this.contentView.findViewById(R.h.fKq));
    this.hNV = ((ImageView)this.contentView.findViewById(R.h.image_iv));
    this.adNv = ((ImageView)this.contentView.findViewById(R.h.error_iv));
    this.hNX = ((ProgressBar)this.contentView.findViewById(R.h.fKn));
    this.Ykl = new v(this.contentView, -2, -2, true);
    this.Ykl.setBackgroundDrawable(new ColorDrawable(0));
    this.Ykl.setOutsideTouchable(true);
    this.Ykl.setFocusable(false);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33815);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (f.this.adNz != null) {
          f.this.adNz.onSendImg();
        }
        f.this.Ykl.dismiss();
        a.a(this, "com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33815);
      }
    });
    this.adNA = new MMHandler(this.context.getMainLooper())
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
  
  public final void bFg()
  {
    AppMethodBeat.i(33820);
    Log.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.hNX.setVisibility(0);
    this.hNV.setVisibility(8);
    this.adNv.setVisibility(8);
    AppMethodBeat.o(33820);
  }
  
  public final void bFh()
  {
    AppMethodBeat.i(33822);
    Log.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.adNv.setVisibility(0);
    this.hNX.setVisibility(8);
    this.hNV.setVisibility(8);
    AppMethodBeat.o(33822);
  }
  
  public final String key()
  {
    AppMethodBeat.i(33823);
    String str = p.el(this);
    AppMethodBeat.o(33823);
    return str;
  }
  
  public final void onBitmapLoaded(Bitmap paramBitmap)
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
    this.hNX.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.hNV.setVisibility(0);
      this.hNV.setImageBitmap(paramBitmap);
      this.adNv.setVisibility(8);
      AppMethodBeat.o(33821);
      return;
    }
    this.adNv.setVisibility(0);
    this.hNV.setVisibility(8);
    AppMethodBeat.o(33821);
  }
  
  public final void show()
  {
    AppMethodBeat.i(249684);
    Log.d("MicroMsg.AppBrandServiceImageBubble", "show");
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33818);
        f.this.adNA.sendEmptyMessage(0);
        AppMethodBeat.o(33818);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(33819);
        String str = super.toString() + "MicroMsg.AppBrandServiceImageBubbleshow";
        AppMethodBeat.o(33819);
        return str;
      }
    });
    AppMethodBeat.o(249684);
  }
  
  public static abstract interface a
  {
    public abstract void onSendImg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.f
 * JD-Core Version:    0.7.0.1
 */