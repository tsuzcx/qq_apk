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
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.aa.m;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.base.o;

public final class f
  implements b.k
{
  o Cgp;
  public boolean Cgq;
  private long FTS;
  private ImageView FTT;
  private String FTU;
  private ChatFooter FTV;
  private boolean FTW;
  public a FTX;
  ap FTY;
  private Bitmap bitmap;
  private View contentView;
  private Context context;
  private ImageView dnd;
  private ProgressBar dnf;
  private View frN;
  private TextView xDS;
  private TextView xDT;
  
  public f(Context paramContext, View paramView, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(33824);
    this.FTS = 10000L;
    this.contentView = null;
    this.xDS = null;
    this.xDT = null;
    this.dnd = null;
    this.FTT = null;
    this.dnf = null;
    this.FTU = null;
    this.bitmap = null;
    this.Cgq = true;
    this.FTW = false;
    this.FTY = null;
    this.context = paramContext;
    this.frN = paramView;
    this.FTV = paramChatFooter;
    this.contentView = View.inflate(this.context, 2131493398, null);
    this.xDS = ((TextView)this.contentView.findViewById(2131300963));
    this.xDT = ((TextView)this.contentView.findViewById(2131300964));
    this.dnd = ((ImageView)this.contentView.findViewById(2131300943));
    this.FTT = ((ImageView)this.contentView.findViewById(2131299520));
    this.dnf = ((ProgressBar)this.contentView.findViewById(2131300955));
    this.Cgp = new o(this.contentView, -2, -2, true);
    this.Cgp.setBackgroundDrawable(new ColorDrawable(0));
    this.Cgp.setOutsideTouchable(true);
    this.Cgp.setFocusable(false);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33815);
        if (f.this.FTX != null) {
          f.this.FTX.eSm();
        }
        f.this.Cgp.dismiss();
        AppMethodBeat.o(33815);
      }
    });
    this.FTY = new ap(this.context.getMainLooper())
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
  
  public final String AL()
  {
    AppMethodBeat.i(33823);
    String str = m.cF(this);
    AppMethodBeat.o(33823);
    return str;
  }
  
  public final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(33821);
    ad.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
    if (paramBitmap == null)
    {
      ad.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
      AppMethodBeat.o(33821);
      return;
    }
    this.bitmap = paramBitmap;
    this.dnf.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.dnd.setVisibility(0);
      this.dnd.setImageBitmap(paramBitmap);
      this.FTT.setVisibility(8);
      AppMethodBeat.o(33821);
      return;
    }
    this.FTT.setVisibility(0);
    this.dnd.setVisibility(8);
    AppMethodBeat.o(33821);
  }
  
  public final void auj()
  {
    AppMethodBeat.i(33820);
    ad.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.dnf.setVisibility(0);
    this.dnd.setVisibility(8);
    this.FTT.setVisibility(8);
    AppMethodBeat.o(33820);
  }
  
  public final void nV()
  {
    AppMethodBeat.i(33822);
    ad.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.FTT.setVisibility(0);
    this.dnf.setVisibility(8);
    this.dnd.setVisibility(8);
    AppMethodBeat.o(33822);
  }
  
  public static abstract interface a
  {
    public abstract void eSm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.f
 * JD-Core Version:    0.7.0.1
 */