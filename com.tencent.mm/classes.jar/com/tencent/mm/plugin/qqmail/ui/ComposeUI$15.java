package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.k;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.util.Map;

final class ComposeUI$15
  extends v.a
{
  ComposeUI$15(ComposeUI paramComposeUI) {}
  
  public final void onComplete()
  {
    AppMethodBeat.i(68193);
    if (ComposeUI.G(this.pLX) != null)
    {
      ComposeUI.G(this.pLX).dismiss();
      ComposeUI.a(this.pLX, null);
    }
    AppMethodBeat.o(68193);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(68192);
    if (paramInt == -5)
    {
      this.pLX.pLx.a(new ComposeUI.15.2(this));
      AppMethodBeat.o(68192);
      return;
    }
    h.a(this.pLX, paramString, this.pLX.getString(2131302113), null);
    AppMethodBeat.o(68192);
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(68191);
    h.a(this.pLX, 2131302115, 2131297087, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68189);
        paramAnonymousDialogInterface = ac.cdQ().pJD;
        String str = ComposeUI.J(ComposeUI.15.this.pLX);
        paramAnonymousInt = ComposeUI.K(ComposeUI.15.this.pLX);
        paramAnonymousDialogInterface = new File(paramAnonymousDialogInterface.pIH.pIR + i.db(str, paramAnonymousInt));
        if (paramAnonymousDialogInterface.exists()) {
          paramAnonymousDialogInterface.delete();
        }
        ComposeUI.15.this.pLX.setResult(-1);
        ComposeUI.15.this.pLX.finish();
        AppMethodBeat.o(68189);
      }
    });
    ComposeUI.d(this.pLX).cC(this.pLX.pLe.getMailAddrs());
    ComposeUI.d(this.pLX).cC(ComposeUI.e(this.pLX).getMailAddrs());
    ComposeUI.d(this.pLX).cC(ComposeUI.f(this.pLX).getMailAddrs());
    AppMethodBeat.o(68191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.15
 * JD-Core Version:    0.7.0.1
 */