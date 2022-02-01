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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public final class a
{
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, h.b paramb, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(71462);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, false, paramInt, paramb, paramOnClickListener);
    AppMethodBeat.o(71462);
    return paramContext;
  }
  
  public static d a(final Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, h.b paramb, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(71463);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(71463);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.HG(false);
    locala.HH(true);
    locala.ayk(a.i.app_cancel).d(paramOnClickListener);
    locala.bBc(paramString1);
    paramString1 = View.inflate(paramContext, a.g.wallet_alert_input_with_mmedittext, null);
    paramOnClickListener = (EditText)paramString1.findViewById(a.f.edittext);
    if (!Util.isNullOrNil(paramString2)) {
      paramOnClickListener.append(l.b(paramContext, paramString2, paramOnClickListener.getTextSize()));
    }
    ((TextView)paramString1.findViewById(a.f.tips_tv)).setVisibility(8);
    if (!Util.isNullOrNil(paramString3)) {
      paramOnClickListener.setHint(paramString3);
    }
    locala.ayj(a.i.app_ok).a(false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71453);
        boolean bool = true;
        if (this.PeQ != null) {
          bool = this.PeQ.onFinish(paramOnClickListener.getText().toString().trim());
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
      c.i(paramOnClickListener).axx(paramInt).a(null);
    }
    locala.iI(paramString1);
    paramString2 = locala.icu();
    paramString2.show();
    a(paramContext, paramString2);
    if ((paramContext instanceof MMActivity)) {
      paramString1.post(new a.2(paramBoolean, paramOnClickListener, paramContext));
    }
    AppMethodBeat.o(71463);
    return paramString2;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6, a parama, f.c paramc)
  {
    AppMethodBeat.i(71464);
    paramContext = b(paramContext, paramString1, paramString2, paramString3, paramBoolean, paramString4, paramString5, paramString6, parama, paramc);
    AppMethodBeat.o(71464);
    return paramContext;
  }
  
  private static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(71466);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).addDialog(paramDialog);
    }
    AppMethodBeat.o(71466);
  }
  
  private static d b(final Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, final String paramString4, final String paramString5, String paramString6, final a parama, final f.c paramc)
  {
    AppMethodBeat.i(269343);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(269343);
      return null;
    }
    final f.a locala = new f.a(paramContext);
    locala.HL(true);
    locala.a(paramc);
    locala.aR(paramString1);
    paramString1 = View.inflate(paramContext, a.g.wallet_alert_input_with_mmedittext_addressinfo, null);
    paramc = (EditText)paramString1.findViewById(a.f.edittext);
    if (!Util.isNullOrNil(paramString2)) {
      paramc.append(l.b(paramContext, paramString2, paramc.getTextSize()));
    }
    if (!Util.isNullOrNil(paramString3)) {
      paramc.setHint(paramString3);
    }
    paramString2 = (LinearLayout)paramString1.findViewById(a.f.add_address_ll);
    paramString3 = (LinearLayout)paramString1.findViewById(a.f.address_info_ll);
    final TextView localTextView1 = (TextView)paramString1.findViewById(a.f.name_telephone_tv);
    final TextView localTextView2 = (TextView)paramString1.findViewById(a.f.address_detail_tv);
    TextView localTextView3 = (TextView)paramString1.findViewById(a.f.address_info_tv);
    ((ImageView)paramString1.findViewById(a.f.add_address_iv)).getDrawable().setColorFilter(-15970418, PorterDuff.Mode.SRC_ATOP);
    localTextView3.setText(MMApplicationContext.getContext().getString(a.i.remittance_add_address_info));
    paramString2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71455);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.PeU != null) {
          this.PeU.a(true, paramc.getText().toString().trim(), null, null, null);
        }
        a.a(paramContext, locala.mUO);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71455);
      }
    });
    if (paramBoolean)
    {
      paramString2.setVisibility(0);
      paramString3.setVisibility(8);
    }
    for (;;)
    {
      locala.ayp(a.i.app_ok).b(new f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
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
      c.i(paramc).axx(20).a(null);
      locala.iK(paramString1);
      locala.show();
      if ((paramContext instanceof MMActivity)) {
        locala.mUO.getContentView().post(new a.7(localTextView2, paramContext));
      }
      MMHandlerThread.postToMainThread(new a.8(paramContext, paramc));
      AppMethodBeat.o(269343);
      return null;
      paramString2.setVisibility(8);
      paramString3.setVisibility(0);
      localTextView1.setText(paramString4 + "  " + paramString5);
      localTextView2.setText(paramString6);
      paramString1.findViewById(a.f.exchange_address_tv).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71456);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (this.PeU != null) {
            this.PeU.a(false, paramc.getText().toString().trim(), paramString4, paramString5, localTextView2.getText().toString().trim());
          }
          a.a(paramContext, locala.mUO);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71456);
        }
      });
      paramString1.findViewById(a.f.delete_address_tv).setOnClickListener(new a.5(paramString2, paramString3, localTextView1, localTextView2));
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a
 * JD-Core Version:    0.7.0.1
 */