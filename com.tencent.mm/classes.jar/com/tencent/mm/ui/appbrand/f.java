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
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.ui.base.o;

public final class f
  implements b.k
{
  o DyG;
  public boolean DyH;
  private long HtH;
  private ImageView HtI;
  private String HtJ;
  private ChatFooter HtK;
  private boolean HtL;
  public a HtM;
  ao HtN;
  private Bitmap bitmap;
  private View contentView;
  private Context context;
  private ImageView dkL;
  private ProgressBar dkN;
  private View fvu;
  private TextView yQG;
  private TextView yQH;
  
  public f(Context paramContext, View paramView, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(33824);
    this.HtH = 10000L;
    this.contentView = null;
    this.yQG = null;
    this.yQH = null;
    this.dkL = null;
    this.HtI = null;
    this.dkN = null;
    this.HtJ = null;
    this.bitmap = null;
    this.DyH = true;
    this.HtL = false;
    this.HtN = null;
    this.context = paramContext;
    this.fvu = paramView;
    this.HtK = paramChatFooter;
    this.contentView = View.inflate(this.context, 2131493398, null);
    this.yQG = ((TextView)this.contentView.findViewById(2131300963));
    this.yQH = ((TextView)this.contentView.findViewById(2131300964));
    this.dkL = ((ImageView)this.contentView.findViewById(2131300943));
    this.HtI = ((ImageView)this.contentView.findViewById(2131299520));
    this.dkN = ((ProgressBar)this.contentView.findViewById(2131300955));
    this.DyG = new o(this.contentView, -2, -2, true);
    this.DyG.setBackgroundDrawable(new ColorDrawable(0));
    this.DyG.setOutsideTouchable(true);
    this.DyG.setFocusable(false);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33815);
        if (f.this.HtM != null) {
          f.this.HtM.fhW();
        }
        f.this.DyG.dismiss();
        AppMethodBeat.o(33815);
      }
    });
    this.HtN = new ao(this.context.getMainLooper())
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
  
  public final String Ap()
  {
    AppMethodBeat.i(33823);
    String str = m.cE(this);
    AppMethodBeat.o(33823);
    return str;
  }
  
  public final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(33821);
    ac.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
    if (paramBitmap == null)
    {
      ac.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
      AppMethodBeat.o(33821);
      return;
    }
    this.bitmap = paramBitmap;
    this.dkN.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.dkL.setVisibility(0);
      this.dkL.setImageBitmap(paramBitmap);
      this.HtI.setVisibility(8);
      AppMethodBeat.o(33821);
      return;
    }
    this.HtI.setVisibility(0);
    this.dkL.setVisibility(8);
    AppMethodBeat.o(33821);
  }
  
  public final void aBa()
  {
    AppMethodBeat.i(33820);
    ac.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.dkN.setVisibility(0);
    this.dkL.setVisibility(8);
    this.HtI.setVisibility(8);
    AppMethodBeat.o(33820);
  }
  
  public final void of()
  {
    AppMethodBeat.i(33822);
    ac.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.HtI.setVisibility(0);
    this.dkN.setVisibility(8);
    this.dkL.setVisibility(8);
    AppMethodBeat.o(33822);
  }
  
  public static abstract interface a
  {
    public abstract void fhW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.f
 * JD-Core Version:    0.7.0.1
 */