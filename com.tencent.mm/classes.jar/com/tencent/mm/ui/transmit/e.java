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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends Dialog
  implements DialogInterface
{
  private LinearLayout Gph;
  private a IXP;
  private Button IXQ;
  private Context mContext;
  
  private e(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(180117);
    this.IXP = null;
    this.mContext = paramContext;
    this.Gph = ((LinearLayout)View.inflate(this.mContext, 2131495767, null));
    this.IXQ = ((Button)this.Gph.findViewById(2131305966));
    paramContext = (ImageView)this.Gph.findViewById(2131305961);
    if (ab.eUK()) {
      paramContext.setImageResource(2131234395);
    }
    for (;;)
    {
      this.IXQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180115);
          ac.i("MicroMsg.grouptodo.TodoIntroduceView", "click i know");
          e.this.dismiss();
          if (e.a(e.this) != null) {
            e.a(e.this).fqB();
          }
          AppMethodBeat.o(180115);
        }
      });
      AppMethodBeat.o(180117);
      return;
      paramContext.setImageResource(2131234396);
    }
  }
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(180121);
    paramContext = new e(paramContext);
    paramContext.IXP = parama;
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
          e.this.dismiss();
          AppMethodBeat.o(180116);
        }
      });
      ac.e("MicroMsg.grouptodo.TodoIntroduceView", "dialog dismiss error!");
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
      ac.e("MicroMsg.grouptodo.TodoIntroduceView", "dismiss exception, e = " + localException.getMessage());
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
    setContentView(this.Gph);
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
      ac.e("MicroMsg.grouptodo.TodoIntroduceView", "%s:%s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(180119);
    }
  }
  
  public static abstract interface a
  {
    public abstract void fqB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.e
 * JD-Core Version:    0.7.0.1
 */