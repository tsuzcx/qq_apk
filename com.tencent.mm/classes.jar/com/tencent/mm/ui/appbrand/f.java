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
import com.tencent.mm.plugin.appbrand.y.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.ui.base.o;

public final class f
  implements b.k
{
  private TextView Azo;
  private TextView Azp;
  o Fwn;
  public boolean Fwo;
  private long JCi;
  private ImageView JCj;
  private String JCk;
  private ChatFooter JCl;
  private boolean JCm;
  public a JCn;
  aq JCo;
  private Bitmap bitmap;
  private View contentView;
  private Context context;
  private ImageView dxD;
  private ProgressBar dxF;
  private View fQH;
  
  public f(Context paramContext, View paramView, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(33824);
    this.JCi = 10000L;
    this.contentView = null;
    this.Azo = null;
    this.Azp = null;
    this.dxD = null;
    this.JCj = null;
    this.dxF = null;
    this.JCk = null;
    this.bitmap = null;
    this.Fwo = true;
    this.JCm = false;
    this.JCo = null;
    this.context = paramContext;
    this.fQH = paramView;
    this.JCl = paramChatFooter;
    this.contentView = View.inflate(this.context, 2131493398, null);
    this.Azo = ((TextView)this.contentView.findViewById(2131300963));
    this.Azp = ((TextView)this.contentView.findViewById(2131300964));
    this.dxD = ((ImageView)this.contentView.findViewById(2131300943));
    this.JCj = ((ImageView)this.contentView.findViewById(2131299520));
    this.dxF = ((ProgressBar)this.contentView.findViewById(2131300955));
    this.Fwn = new o(this.contentView, -2, -2, true);
    this.Fwn.setBackgroundDrawable(new ColorDrawable(0));
    this.Fwn.setOutsideTouchable(true);
    this.Fwn.setFocusable(false);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33815);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (f.this.JCn != null) {
          f.this.JCn.fCo();
        }
        f.this.Fwn.dismiss();
        a.a(this, "com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33815);
      }
    });
    this.JCo = new aq(this.context.getMainLooper())
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
  
  public final String BN()
  {
    AppMethodBeat.i(33823);
    String str = n.cH(this);
    AppMethodBeat.o(33823);
    return str;
  }
  
  public final void F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(33821);
    ae.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
    if (paramBitmap == null)
    {
      ae.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
      AppMethodBeat.o(33821);
      return;
    }
    this.bitmap = paramBitmap;
    this.dxF.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.dxD.setVisibility(0);
      this.dxD.setImageBitmap(paramBitmap);
      this.JCj.setVisibility(8);
      AppMethodBeat.o(33821);
      return;
    }
    this.JCj.setVisibility(0);
    this.dxD.setVisibility(8);
    AppMethodBeat.o(33821);
  }
  
  public final void aEt()
  {
    AppMethodBeat.i(33820);
    ae.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.dxF.setVisibility(0);
    this.dxD.setVisibility(8);
    this.JCj.setVisibility(8);
    AppMethodBeat.o(33820);
  }
  
  public final void ox()
  {
    AppMethodBeat.i(33822);
    ae.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.JCj.setVisibility(0);
    this.dxF.setVisibility(8);
    this.dxD.setVisibility(8);
    AppMethodBeat.o(33822);
  }
  
  public static abstract interface a
  {
    public abstract void fCo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.f
 * JD-Core Version:    0.7.0.1
 */