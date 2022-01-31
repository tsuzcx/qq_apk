package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.o;

public final class c
  implements b.i
{
  private Bitmap bitmap;
  private View contentView;
  private Context context;
  private ProgressBar cxA;
  private ImageView cxy;
  private View kgr;
  private TextView rVf;
  private TextView rVg;
  o vYP;
  public boolean vYQ;
  private long zgn;
  private ImageView zgo;
  private String zgp;
  private ChatFooter zgq;
  private boolean zgr;
  public c.a zgs;
  ak zgt;
  
  public c(Context paramContext, View paramView, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(153823);
    this.zgn = 10000L;
    this.contentView = null;
    this.rVf = null;
    this.rVg = null;
    this.cxy = null;
    this.zgo = null;
    this.cxA = null;
    this.zgp = null;
    this.bitmap = null;
    this.vYQ = true;
    this.zgr = false;
    this.zgt = null;
    this.context = paramContext;
    this.kgr = paramView;
    this.zgq = paramChatFooter;
    this.contentView = View.inflate(this.context, 2130969037, null);
    this.rVf = ((TextView)this.contentView.findViewById(2131822492));
    this.rVg = ((TextView)this.contentView.findViewById(2131822493));
    this.cxy = ((ImageView)this.contentView.findViewById(2131822243));
    this.zgo = ((ImageView)this.contentView.findViewById(2131822491));
    this.cxA = ((ProgressBar)this.contentView.findViewById(2131822490));
    this.vYP = new o(this.contentView, -2, -2, true);
    this.vYP.setBackgroundDrawable(new ColorDrawable(0));
    this.vYP.setOutsideTouchable(true);
    this.vYP.setFocusable(false);
    this.contentView.setOnClickListener(new c.1(this));
    this.zgt = new ak(this.context.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29959);
        c.a(c.this);
        AppMethodBeat.o(29959);
      }
    };
    AppMethodBeat.o(153823);
  }
  
  public final void acG()
  {
    AppMethodBeat.i(29963);
    ab.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.cxA.setVisibility(0);
    this.cxy.setVisibility(8);
    this.zgo.setVisibility(8);
    AppMethodBeat.o(29963);
  }
  
  public final void acH()
  {
    AppMethodBeat.i(29965);
    ab.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.zgo.setVisibility(0);
    this.cxA.setVisibility(8);
    this.cxy.setVisibility(8);
    AppMethodBeat.o(29965);
  }
  
  public final String tX()
  {
    AppMethodBeat.i(29966);
    String str = n.bt(this);
    AppMethodBeat.o(29966);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(29964);
    ab.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
    if (paramBitmap == null)
    {
      ab.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
      AppMethodBeat.o(29964);
      return;
    }
    this.bitmap = paramBitmap;
    this.cxA.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.cxy.setVisibility(0);
      this.cxy.setImageBitmap(paramBitmap);
      this.zgo.setVisibility(8);
      AppMethodBeat.o(29964);
      return;
    }
    this.zgo.setVisibility(0);
    this.cxy.setVisibility(8);
    AppMethodBeat.o(29964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c
 * JD-Core Version:    0.7.0.1
 */