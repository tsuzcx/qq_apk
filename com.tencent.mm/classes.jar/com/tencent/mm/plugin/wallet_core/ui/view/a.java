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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
    locala.Dk(false);
    locala.Dl(true);
    locala.aoW(2131755761).d(paramOnClickListener);
    locala.bon(paramString1);
    paramString1 = View.inflate(paramContext, 2131496875, null);
    paramOnClickListener = (EditText)paramString1.findViewById(2131299910);
    if (!Util.isNullOrNil(paramString2)) {
      paramOnClickListener.append(l.b(paramContext, paramString2, paramOnClickListener.getTextSize()));
    }
    ((TextView)paramString1.findViewById(2131309187)).setVisibility(8);
    if (!Util.isNullOrNil(paramString3)) {
      paramOnClickListener.setHint(paramString3);
    }
    locala.aoV(2131755921).a(false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71453);
        boolean bool = true;
        if (this.Imy != null) {
          bool = this.Imy.onFinish(paramOnClickListener.getText().toString().trim());
        }
        if (bool)
        {
          paramAnonymousDialogInterface.dismiss();
          if ((paramContext instanceof MMActivity)) {
            MMHandlerThread.postToMainThread(new Runnable()
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
      c.f(paramOnClickListener).aoq(paramInt).a(null);
    }
    locala.hs(paramString1);
    paramString2 = locala.hbn();
    paramString2.show();
    a(paramContext, paramString2);
    if ((paramContext instanceof MMActivity)) {
      paramString1.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(71454);
          if ((this.ImB) && (paramOnClickListener != null) && (com.tencent.mm.compatible.util.d.oD(28))) {
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
    locala.Dq(true);
    locala.a(paramc);
    locala.aC(paramString1);
    paramString1 = View.inflate(paramContext, 2131496876, null);
    paramc = (EditText)paramString1.findViewById(2131299910);
    if (!Util.isNullOrNil(paramString2)) {
      paramc.append(l.b(paramContext, paramString2, paramc.getTextSize()));
    }
    if (!Util.isNullOrNil(paramString3)) {
      paramc.setHint(paramString3);
    }
    paramString2 = (LinearLayout)paramString1.findViewById(2131296524);
    paramString3 = (LinearLayout)paramString1.findViewById(2131296554);
    final TextView localTextView1 = (TextView)paramString1.findViewById(2131305219);
    final TextView localTextView2 = (TextView)paramString1.findViewById(2131296552);
    TextView localTextView3 = (TextView)paramString1.findViewById(2131296555);
    ((ImageView)paramString1.findViewById(2131296523)).getDrawable().setColorFilter(-15970418, PorterDuff.Mode.SRC_ATOP);
    localTextView3.setText(MMApplicationContext.getContext().getString(2131764482));
    paramString2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71455);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.ImC != null) {
          this.ImC.a(true, paramc.getText().toString().trim(), null, null, null);
        }
        a.a(paramContext, locala.kdo);
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
      locala.apa(2131755921).b(new f.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(71459);
          if ((this.val$context instanceof MMActivity)) {
            if (parama != null) {
              if (!Util.isNullOrNil(localTextView1.getText().toString().trim())) {
                break label119;
              }
            }
          }
          label119:
          for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
          {
            parama.a(paramAnonymousBoolean, paramc.getText().toString().trim(), paramString4, paramString5, localTextView2.getText().toString().trim());
            if ((this.val$context instanceof MMActivity)) {
              MMHandlerThread.postToMainThread(new Runnable()
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
      c.f(paramc).aoq(20).a(null);
      locala.hu(paramString1);
      locala.show();
      if ((paramContext instanceof MMActivity)) {
        locala.kdo.getContentView().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71460);
            if ((this.ImB) && (localTextView2 != null) && (com.tencent.mm.compatible.util.d.oD(28))) {
              localTextView2.requestFocus();
            }
            ((MMActivity)paramContext).showVKB();
            AppMethodBeat.o(71460);
          }
        });
      }
      MMHandlerThread.postToMainThread(new Runnable()
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
      paramString1.findViewById(2131300188).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71456);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (this.ImC != null) {
            this.ImC.a(false, paramc.getText().toString().trim(), paramString4, paramString5, localTextView2.getText().toString().trim());
          }
          a.a(paramContext, locala.kdo);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71456);
        }
      });
      paramString1.findViewById(2131299479).setOnClickListener(new a.5(paramString2, paramString3, localTextView1, localTextView2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a
 * JD-Core Version:    0.7.0.1
 */