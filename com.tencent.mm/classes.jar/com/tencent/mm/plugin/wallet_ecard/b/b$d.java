package com.tencent.mm.plugin.wallet_ecard.b;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

final class b$d
  extends g
{
  com.tencent.mm.ui.widget.b.c gNn;
  
  public b$d(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  final void a(awn paramawn, TextView paramTextView)
  {
    AppMethodBeat.i(48092);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramawn.xma != null) && (!bo.isNullOrNil(paramawn.xma.desc)))
    {
      localSpannableStringBuilder.append(paramawn.xma.desc);
      if (!bo.isNullOrNil(paramawn.xma.color)) {
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(paramawn.xma.color)), 0, localSpannableStringBuilder.length(), 18);
      }
    }
    if ((paramawn.xmb != null) && (!bo.isNullOrNil(paramawn.xmb.desc)))
    {
      int i = localSpannableStringBuilder.length();
      localSpannableStringBuilder.append(paramawn.xmb.desc);
      localSpannableStringBuilder.setSpan(new o(paramawn.xmb.color, new b.d.1(this)), i, localSpannableStringBuilder.length(), 18);
    }
    paramTextView.setText(localSpannableStringBuilder);
    AppMethodBeat.o(48092);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(48093);
    if ((paramm instanceof d))
    {
      this.AXB.removeSceneEndListener(1985);
      paramm = (d)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.uzl.koj == 0) {
          if (paramm.uzl.xwU != null)
          {
            ab.i("MicroMsg.OpenECardProcess", "show input alert");
            paramString = paramm.uzl.xwU;
            if (this.gNn == null)
            {
              View localView = View.inflate(this.hwZ, 2130969347, null);
              EditText localEditText = (EditText)localView.findViewById(2131823491);
              TextView localTextView = (TextView)localView.findViewById(2131823492);
              localTextView.setClickable(true);
              localTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this.hwZ));
              if (!bo.isNullOrNil(paramString.xlZ)) {
                localEditText.setHint(paramm.uzl.xwU.xlZ);
              }
              c.a locala = new c.a(this.hwZ);
              locala.avm(paramm.uzl.xwU.xlY);
              locala.Rd(4);
              locala.fu(localView);
              if (!bo.isNullOrNil(paramString.xmd)) {
                locala.avs(paramString.xmd);
              }
              if (!bo.isNullOrNil(paramString.xmc)) {
                locala.avt(paramString.xmc);
              }
              locala.a(false, new b.d.2(this, localEditText, paramm, localTextView));
              locala.rG(false);
              locala.a(new b.d.3(this));
              this.gNn = locala.aLZ();
              a(paramString, localTextView);
              this.gNn.show();
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(48093);
        return true;
        a(paramString, (TextView)this.gNn.findViewById(2131823492));
        continue;
        b.p(this.uzs).putInt(a.uyN, a.uze);
        b.q(this.uzs).putString(a.uyQ, paramm.uzm);
        b.r(this.uzs).putString(a.uyR, paramm.uzn);
        b.s(this.uzs).putString(a.uyS, paramm.uzo);
        paramString = new Bundle();
        if (paramm.uzl.wvr != null)
        {
          ab.i("MicroMsg.OpenECardProcess", "no need verify sms");
          paramString.putBoolean(a.uyY, false);
        }
        for (;;)
        {
          try
          {
            b.t(this.uzs).putByteArray(a.uzc, paramm.uzl.wvr.toByteArray());
            this.uzs.a(this.hwZ, 0, paramString);
          }
          catch (IOException paramm)
          {
            ab.printErrStackTrace("MicroMsg.OpenECardProcess", paramm, "", new Object[0]);
            continue;
          }
          ab.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(a.uyY, true);
          paramString.putString(a.uyW, paramm.uzl.wvp);
          paramString.putString(a.uyX, paramm.uzl.xwT);
        }
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.hwZ, paramm.uzl.wvq)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.hwZ, paramm, paramm.cnK, paramm.kNv, paramm.uzl.koj, paramm.uzl.kok)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramm.uzl.kok, paramm.kNv, paramString });
          h.b(this.hwZ, paramString, "", false);
          continue;
          ab.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramString });
          h.b(this.hwZ, paramString, "", false);
        }
      }
    }
    AppMethodBeat.o(48093);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48091);
    paramVarArgs = (hg)paramVarArgs[0];
    String str1 = b.l(this.uzs).getString(a.uyL, "");
    if (paramVarArgs == null)
    {
      ab.w("MicroMsg.OpenECardProcess", "empty bank item");
      AppMethodBeat.o(48091);
      return false;
    }
    this.AXB.addSceneEndListener(1985);
    String str2 = String.format("%s %s(%s)", new Object[] { paramVarArgs.nLq, paramVarArgs.kwK, paramVarArgs.wtU });
    b.m(this.uzs).putInt(a.uzg, 1);
    paramVarArgs = new d(b.b(this.uzs), str1, paramVarArgs.wtV, paramVarArgs.ubQ, paramVarArgs.poq, b.n(this.uzs), true, 1, str2);
    this.AXB.a(paramVarArgs, true, 1);
    AppMethodBeat.o(48091);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.d
 * JD-Core Version:    0.7.0.1
 */