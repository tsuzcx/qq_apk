package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.ui.AlertActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.widget.a.i;

public final class z
  extends i
  implements DialogInterface
{
  private ImageView adUl;
  Handler handler;
  private Context mContext;
  private View plc;
  private int style;
  private TextView uPs;
  
  public z(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    AppMethodBeat.i(251340);
    this.handler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(142225);
        bc.i("MicroMsg.MMTipsDialog", "mTipsBuilder handleMessage", new Object[0]);
        if (((z.a(z.this) instanceof Activity)) && (((Activity)z.a(z.this)).isFinishing()))
        {
          AppMethodBeat.o(142225);
          return;
        }
        z.this.dismiss();
        AppMethodBeat.o(142225);
      }
    };
    this.mContext = paramContext;
    this.style = paramInt2;
    switch (this.style)
    {
    default: 
      paramInt1 = a.g.mm_tips_dialog;
    }
    for (;;)
    {
      this.plc = View.inflate(this.mContext, paramInt1, null);
      this.uPs = ((TextView)this.plc.findViewById(a.f.msg));
      this.adUl = ((ImageView)this.plc.findViewById(a.f.icon));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(251340);
      return;
      paramInt1 = a.g.mm_tips_dialog;
      continue;
      paramInt1 = a.g.mm_tips_dialog_with_bg;
      continue;
      paramInt1 = a.g.mm_small_tips_dialog;
    }
  }
  
  public static z a(Drawable paramDrawable, CharSequence paramCharSequence, Context paramContext, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(251341);
    int i;
    switch (paramInt)
    {
    default: 
      i = a.j.mmtipsdialog;
      paramContext = new a(paramContext);
      paramContext.adUo.theme = i;
      paramContext.adUo.style = paramInt;
      paramContext.adUo.adKH = paramCharSequence;
      paramContext.adUo.dqY = paramDrawable;
      paramContext.adUo.dqS = true;
      paramContext.b(paramOnDismissListener);
      if ((paramContext.mContext instanceof Activity))
      {
        if (paramContext.adUn == null) {
          paramContext.adUn = paramContext.jmN();
        }
        paramContext.adUn.show();
      }
      break;
    }
    for (;;)
    {
      paramDrawable = paramContext.adUn;
      AppMethodBeat.o(251341);
      return paramDrawable;
      i = a.j.mmtipsdialog;
      break;
      i = a.j.mmalertdialog;
      break;
      i = a.j.mmtipsdialog;
      break;
      AlertActivity.a(paramContext);
      paramCharSequence = new Intent(paramContext.mContext, AlertActivity.class);
      paramCharSequence.setFlags(335544320);
      paramCharSequence.putExtra("dialog_scene", 2);
      paramDrawable = paramContext.mContext;
      paramCharSequence = new com.tencent.mm.hellhoundlib.b.a().cG(paramCharSequence);
      com.tencent.mm.hellhoundlib.a.a.b(paramDrawable, paramCharSequence.aYi(), "com/tencent/mm/ui/base/MMTipsDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDrawable.startActivity((Intent)paramCharSequence.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramDrawable, "com/tencent/mm/ui/base/MMTipsDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public final void a(ar paramar)
  {
    AppMethodBeat.i(251345);
    Object localObject;
    if ((paramar.adKH != null) && (paramar.adKH.length() > 0))
    {
      localObject = paramar.adKH;
      this.uPs.setText((CharSequence)localObject);
    }
    if (paramar.dqY != null)
    {
      localObject = paramar.dqY;
      if ((localObject != null) && (this.adUl != null)) {
        break label104;
      }
    }
    for (;;)
    {
      setCanceledOnTouchOutside(paramar.dqS);
      if (paramar.iaY != null) {
        setOnDismissListener(paramar.iaY);
      }
      if (paramar.mOnCancelListener != null) {
        setOnCancelListener(paramar.mOnCancelListener);
      }
      AppMethodBeat.o(251345);
      return;
      label104:
      this.adUl.setImageDrawable((Drawable)localObject);
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(142229);
    try
    {
      super.dismiss();
      AppMethodBeat.o(142229);
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("dismiss exception, e = ").append(localException.getMessage());
      AppMethodBeat.o(142229);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142227);
    super.onCreate(paramBundle);
    setContentView(this.plc, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(142227);
  }
  
  public final void show()
  {
    AppMethodBeat.i(251343);
    try
    {
      super.show();
      this.handler.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(251343);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bc.printErrStackTrace("MicroMsg.MMTipsDialog", localException, "", new Object[0]);
      }
    }
  }
  
  public static final class a
  {
    z adUn;
    public ar adUo;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(251463);
      this.mContext = paramContext;
      this.adUo = new ar();
      AppMethodBeat.o(251463);
    }
    
    public final a b(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.adUo.iaY = paramOnDismissListener;
      return this;
    }
    
    public final z jmN()
    {
      AppMethodBeat.i(251466);
      z localz = new z(this.mContext, this.adUo.theme, this.adUo.style);
      localz.a(this.adUo);
      AppMethodBeat.o(251466);
      return localz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.base.z
 * JD-Core Version:    0.7.0.1
 */