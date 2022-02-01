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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.base.p;

public final class f
  implements b.k
{
  private TextView EII;
  private TextView EIJ;
  p Kni;
  public boolean Knj;
  private long ONa;
  private ImageView ONb;
  private String ONc;
  private ChatFooter ONd;
  private boolean ONe;
  public a ONf;
  MMHandler ONg;
  private Bitmap bitmap;
  private View contentView;
  private Context context;
  private ImageView dPk;
  private ProgressBar dPm;
  private View gvQ;
  
  public f(Context paramContext, View paramView, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(33824);
    this.ONa = 10000L;
    this.contentView = null;
    this.EII = null;
    this.EIJ = null;
    this.dPk = null;
    this.ONb = null;
    this.dPm = null;
    this.ONc = null;
    this.bitmap = null;
    this.Knj = true;
    this.ONe = false;
    this.ONg = null;
    this.context = paramContext;
    this.gvQ = paramView;
    this.ONd = paramChatFooter;
    this.contentView = View.inflate(this.context, 2131493492, null);
    this.EII = ((TextView)this.contentView.findViewById(2131302599));
    this.EIJ = ((TextView)this.contentView.findViewById(2131302600));
    this.dPk = ((ImageView)this.contentView.findViewById(2131302573));
    this.ONb = ((ImageView)this.contentView.findViewById(2131300158));
    this.dPm = ((ProgressBar)this.contentView.findViewById(2131302591));
    this.Kni = new p(this.contentView, -2, -2, true);
    this.Kni.setBackgroundDrawable(new ColorDrawable(0));
    this.Kni.setOutsideTouchable(true);
    this.Kni.setFocusable(false);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33815);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (f.this.ONf != null) {
          f.this.ONf.gKm();
        }
        f.this.Kni.dismiss();
        a.a(this, "com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33815);
      }
    });
    this.ONg = new MMHandler(this.context.getMainLooper())
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
  
  public final void I(Bitmap paramBitmap)
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
    this.dPm.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.dPk.setVisibility(0);
      this.dPk.setImageBitmap(paramBitmap);
      this.ONb.setVisibility(8);
      AppMethodBeat.o(33821);
      return;
    }
    this.ONb.setVisibility(0);
    this.dPk.setVisibility(8);
    AppMethodBeat.o(33821);
  }
  
  public final String Lb()
  {
    AppMethodBeat.i(33823);
    String str = n.cO(this);
    AppMethodBeat.o(33823);
    return str;
  }
  
  public final void aYg()
  {
    AppMethodBeat.i(33820);
    Log.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.dPm.setVisibility(0);
    this.dPk.setVisibility(8);
    this.ONb.setVisibility(8);
    AppMethodBeat.o(33820);
  }
  
  public final void oD()
  {
    AppMethodBeat.i(33822);
    Log.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.ONb.setVisibility(0);
    this.dPm.setVisibility(8);
    this.dPk.setVisibility(8);
    AppMethodBeat.o(33822);
  }
  
  public static abstract interface a
  {
    public abstract void gKm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.f
 * JD-Core Version:    0.7.0.1
 */