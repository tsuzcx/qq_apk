package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends Dialog
  implements DialogInterface
{
  private LinearLayout acrm;
  private a afPK;
  private Button afPL;
  private Context mContext;
  
  private g(Context paramContext)
  {
    super(paramContext, R.m.mmalertdialog);
    AppMethodBeat.i(180117);
    this.afPK = null;
    this.mContext = paramContext;
    this.acrm = ((LinearLayout)View.inflate(this.mContext, R.i.goC, null));
    this.afPL = ((Button)this.acrm.findViewById(R.h.gap));
    paramContext = (ImageView)this.acrm.findViewById(R.h.gal);
    if (LocaleUtil.isChineseAppLang()) {
      paramContext.setImageResource(R.g.todo_introduce_chinease);
    }
    for (;;)
    {
      this.afPL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180115);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/transmit/TodoIntroduceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.grouptodo.TodoIntroduceView", "click i know");
          g.this.dismiss();
          if (g.a(g.this) != null) {
            g.a(g.this).jxp();
          }
          a.a(this, "com/tencent/mm/ui/transmit/TodoIntroduceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180115);
        }
      });
      AppMethodBeat.o(180117);
      return;
      paramContext.setImageResource(R.g.todo_introduce_english);
    }
  }
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(180121);
    paramContext = new g(paramContext);
    paramContext.afPK = parama;
    paramContext.setCancelable(false);
    paramContext.show();
    AppMethodBeat.o(180121);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(180120);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180116);
          g.this.dismiss();
          AppMethodBeat.o(180116);
        }
      });
      Log.e("MicroMsg.grouptodo.TodoIntroduceView", "dialog dismiss error!");
      AppMethodBeat.o(180120);
      return;
    }
    try
    {
      if ((this.mContext != null) && ((this.mContext instanceof Activity)))
      {
        if (((Activity)this.mContext).isFinishing()) {
          break label124;
        }
        super.dismiss();
        AppMethodBeat.o(180120);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.grouptodo.TodoIntroduceView", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(180120);
      return;
    }
    super.dismiss();
    label124:
    AppMethodBeat.o(180120);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(180118);
    super.onCreate(paramBundle);
    setContentView(this.acrm);
    AppMethodBeat.o(180118);
  }
  
  public final void show()
  {
    AppMethodBeat.i(180119);
    try
    {
      super.show();
      AppMethodBeat.o(180119);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.grouptodo.TodoIntroduceView", "%s:%s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(180119);
    }
  }
  
  public static abstract interface a
  {
    public abstract void jxp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.g
 * JD-Core Version:    0.7.0.1
 */