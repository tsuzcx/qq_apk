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
import com.tencent.mm.plugin.appbrand.z.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.base.o;

public final class f
  implements b.k
{
  private TextView Aic;
  private TextView Aid;
  o FdP;
  public boolean FdQ;
  private ChatFooter JhA;
  private boolean JhB;
  public a JhC;
  ap JhD;
  private long Jhx;
  private ImageView Jhy;
  private String Jhz;
  private Bitmap bitmap;
  private View contentView;
  private Context context;
  private ProgressBar dwA;
  private ImageView dwy;
  private View fOB;
  
  public f(Context paramContext, View paramView, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(33824);
    this.Jhx = 10000L;
    this.contentView = null;
    this.Aic = null;
    this.Aid = null;
    this.dwy = null;
    this.Jhy = null;
    this.dwA = null;
    this.Jhz = null;
    this.bitmap = null;
    this.FdQ = true;
    this.JhB = false;
    this.JhD = null;
    this.context = paramContext;
    this.fOB = paramView;
    this.JhA = paramChatFooter;
    this.contentView = View.inflate(this.context, 2131493398, null);
    this.Aic = ((TextView)this.contentView.findViewById(2131300963));
    this.Aid = ((TextView)this.contentView.findViewById(2131300964));
    this.dwy = ((ImageView)this.contentView.findViewById(2131300943));
    this.Jhy = ((ImageView)this.contentView.findViewById(2131299520));
    this.dwA = ((ProgressBar)this.contentView.findViewById(2131300955));
    this.FdP = new o(this.contentView, -2, -2, true);
    this.FdP.setBackgroundDrawable(new ColorDrawable(0));
    this.FdP.setOutsideTouchable(true);
    this.FdP.setFocusable(false);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33815);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (f.this.JhC != null) {
          f.this.JhC.fym();
        }
        f.this.FdP.dismiss();
        a.a(this, "com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33815);
      }
    });
    this.JhD = new ap(this.context.getMainLooper())
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
  
  public final String BM()
  {
    AppMethodBeat.i(33823);
    String str = n.cG(this);
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
    this.dwA.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.dwy.setVisibility(0);
      this.dwy.setImageBitmap(paramBitmap);
      this.Jhy.setVisibility(8);
      AppMethodBeat.o(33821);
      return;
    }
    this.Jhy.setVisibility(0);
    this.dwy.setVisibility(8);
    AppMethodBeat.o(33821);
  }
  
  public final void aEd()
  {
    AppMethodBeat.i(33820);
    ad.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.dwA.setVisibility(0);
    this.dwy.setVisibility(8);
    this.Jhy.setVisibility(8);
    AppMethodBeat.o(33820);
  }
  
  public final void ox()
  {
    AppMethodBeat.i(33822);
    ad.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.Jhy.setVisibility(0);
    this.dwA.setVisibility(8);
    this.dwy.setVisibility(8);
    AppMethodBeat.o(33822);
  }
  
  public static abstract interface a
  {
    public abstract void fym();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.f
 * JD-Core Version:    0.7.0.1
 */