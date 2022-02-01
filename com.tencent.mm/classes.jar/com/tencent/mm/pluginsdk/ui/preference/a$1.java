package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31812);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/FMessageItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = View.inflate(a.a(this.Kpb), 2131496232, null);
    ((TextView)paramView.findViewById(2131307637)).setVisibility(8);
    localObject = (TextView)paramView.findViewById(2131310528);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText("50");
    final EditText localEditText = (EditText)paramView.findViewById(2131307636);
    localEditText.setSingleLine(false);
    c.f(localEditText).aoq(100).a(null);
    localEditText.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(31809);
        int i = f.dp(100, paramAnonymousEditable.toString());
        if (this.Kpc != null) {
          this.Kpc.setText(String.valueOf(i));
        }
        AppMethodBeat.o(31809);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    h.a(a.a(this.Kpb), a.a(this.Kpb).getString(2131755964), paramView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31810);
        paramAnonymousDialogInterface = localEditText.getText().toString().trim();
        if ((paramAnonymousDialogInterface != null) && (paramAnonymousDialogInterface.length() > 0)) {
          try
          {
            a.a(a.1.this.Kpb, paramAnonymousDialogInterface);
            AppMethodBeat.o(31810);
            return;
          }
          catch (ArrayIndexOutOfBoundsException paramAnonymousDialogInterface)
          {
            Log.printErrStackTrace("MicroMsg.FMessageItemView", paramAnonymousDialogInterface, "", new Object[0]);
            if ((a.b(a.1.this.Kpb) != null) && (a.b(a.1.this.Kpb).isShowing())) {
              a.b(a.1.this.Kpb).dismiss();
            }
          }
        }
        AppMethodBeat.o(31810);
      }
    }, null);
    localEditText.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31811);
        if ((a.a(a.1.this.Kpb) instanceof MMActivity)) {
          ((MMActivity)a.a(a.1.this.Kpb)).showVKB();
        }
        AppMethodBeat.o(31811);
      }
    });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/FMessageItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a.1
 * JD-Core Version:    0.7.0.1
 */