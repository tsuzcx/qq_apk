package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public final class a
{
  public static com.tencent.mm.ui.widget.a.d a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, h.b paramb, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(71462);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, false, paramInt, paramb, paramOnClickListener);
    AppMethodBeat.o(71462);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.a.d a(final Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, h.b paramb, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(71463);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(71463);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.yR(false);
    locala.yS(true);
    locala.afm(2131755691).d(paramOnClickListener);
    locala.aXF(paramString1);
    paramString1 = View.inflate(paramContext, 2131495895, null);
    paramOnClickListener = (EditText)paramString1.findViewById(2131299306);
    if (!bt.isNullOrNil(paramString2)) {
      paramOnClickListener.append(k.b(paramContext, paramString2, paramOnClickListener.getTextSize()));
    }
    ((TextView)paramString1.findViewById(2131305896)).setVisibility(8);
    if (!bt.isNullOrNil(paramString3)) {
      paramOnClickListener.setHint(paramString3);
    }
    locala.afl(2131755835).a(false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71453);
        boolean bool = true;
        if (this.DlI != null) {
          bool = this.DlI.onFinish(paramOnClickListener.getText().toString().trim());
        }
        if (bool)
        {
          paramAnonymousDialogInterface.dismiss();
          if ((paramContext instanceof MMActivity)) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(71452);
                ((MMActivity)a.1.this.val$context).hideVKB();
                AppMethodBeat.o(71452);
              }
            });
          }
        }
        AppMethodBeat.o(71453);
      }
    });
    if (paramInt > 0) {
      c.d(paramOnClickListener).aeU(paramInt).a(null);
    }
    locala.gY(paramString1);
    paramString2 = locala.fMb();
    paramString2.show();
    a(paramContext, paramString2);
    if ((paramContext instanceof MMActivity)) {
      paramString1.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(71454);
          if ((this.DlL) && (paramOnClickListener != null) && (com.tencent.mm.compatible.util.d.ly(28))) {
            paramOnClickListener.requestFocus();
          }
          ((MMActivity)paramContext).showVKB();
          AppMethodBeat.o(71454);
        }
      });
    }
    AppMethodBeat.o(71463);
    return paramString2;
  }
  
  public static com.tencent.mm.ui.widget.a.d a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6, a parama, f.c paramc)
  {
    AppMethodBeat.i(71464);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, paramBoolean, paramString4, paramString5, paramString6, false, parama, paramc);
    AppMethodBeat.o(71464);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.a.d a(final Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, final String paramString4, final String paramString5, String paramString6, boolean paramBoolean2, final a parama, final f.c paramc)
  {
    AppMethodBeat.i(71465);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(71465);
      return null;
    }
    final f.a locala = new f.a(paramContext);
    locala.yU(true);
    locala.a(paramc);
    locala.av(paramString1);
    paramString1 = View.inflate(paramContext, 2131495896, null);
    paramc = (EditText)paramString1.findViewById(2131299306);
    if (!bt.isNullOrNil(paramString2)) {
      paramc.append(k.b(paramContext, paramString2, paramc.getTextSize()));
    }
    if (!bt.isNullOrNil(paramString3)) {
      paramc.setHint(paramString3);
    }
    paramString2 = (LinearLayout)paramString1.findViewById(2131296452);
    paramString3 = (LinearLayout)paramString1.findViewById(2131296480);
    final TextView localTextView1 = (TextView)paramString1.findViewById(2131302665);
    final TextView localTextView2 = (TextView)paramString1.findViewById(2131296478);
    TextView localTextView3 = (TextView)paramString1.findViewById(2131296481);
    ((ImageView)paramString1.findViewById(2131296451)).getDrawable().setColorFilter(-15970418, PorterDuff.Mode.SRC_ATOP);
    localTextView3.setText(aj.getContext().getString(2131762416));
    paramString2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71455);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (this.DlM != null) {
          this.DlM.a(true, paramc.getText().toString().trim(), null, null, null);
        }
        a.a(paramContext, locala.jcs);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71455);
      }
    });
    if (paramBoolean1)
    {
      paramString2.setVisibility(0);
      paramString3.setVisibility(8);
    }
    for (;;)
    {
      locala.afp(2131755835).b(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(71459);
          if ((this.val$context instanceof MMActivity)) {
            if (parama != null) {
              if (!bt.isNullOrNil(localTextView1.getText().toString().trim())) {
                break label119;
              }
            }
          }
          label119:
          for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
          {
            parama.a(paramAnonymousBoolean, paramc.getText().toString().trim(), paramString4, paramString5, localTextView2.getText().toString().trim());
            if ((this.val$context instanceof MMActivity)) {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71458);
                  ((MMActivity)a.6.this.val$context).hideVKB();
                  AppMethodBeat.o(71458);
                }
              });
            }
            AppMethodBeat.o(71459);
            return;
          }
        }
      });
      c.d(paramc).aeU(20).a(null);
      locala.hb(paramString1);
      locala.show();
      if ((paramContext instanceof MMActivity)) {
        locala.jcs.getContentView().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71460);
            if ((this.DlL) && (localTextView2 != null) && (com.tencent.mm.compatible.util.d.ly(28))) {
              localTextView2.requestFocus();
            }
            ((MMActivity)paramContext).showVKB();
            AppMethodBeat.o(71460);
          }
        });
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(71461);
          ((InputMethodManager)this.val$context.getSystemService("input_method")).showSoftInput(paramc, 2);
          AppMethodBeat.o(71461);
        }
      });
      AppMethodBeat.o(71465);
      return null;
      paramString2.setVisibility(8);
      paramString3.setVisibility(0);
      localTextView1.setText(paramString4 + "  " + paramString5);
      localTextView2.setText(paramString6);
      paramString1.findViewById(2131299540).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71456);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (this.DlM != null) {
            this.DlM.a(false, paramc.getText().toString().trim(), paramString4, paramString5, localTextView2.getText().toString().trim());
          }
          a.a(paramContext, locala.jcs);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71456);
        }
      });
      paramString1.findViewById(2131298985).setOnClickListener(new a.5(paramString2, paramString3, localTextView1, localTextView2));
    }
  }
  
  private static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(71466);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).addDialog(paramDialog);
    }
    AppMethodBeat.o(71466);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a
 * JD-Core Version:    0.7.0.1
 */