package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import java.text.DecimalFormat;

final class b$1$1
  implements a.a
{
  b$1$1(b.1 param1, a parama) {}
  
  public final void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49401);
    this.udA.hide();
    if (paramBoolean)
    {
      localObject = this.udA.dPo();
      if (bo.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(49401);
        return;
      }
      String[] arrayOfString = ((String)localObject).split("-");
      if (arrayOfString.length < 2)
      {
        AppMethodBeat.o(49401);
        return;
      }
      ab.d("MicroMsg.FormatViewUtil", "result: %s", new Object[] { localObject });
      paramInt1 = bo.apV(arrayOfString[0]);
      this.AZc.AZb = (bo.apV(arrayOfString[1]) - 1);
      ab.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.AZc.AZb) });
      if ((paramInt1 >= b.access$000()) || (this.AZc.AZb >= b.access$100())) {
        break label221;
      }
      h.b(this.AZc.lHl, this.AZc.lHl.getString(2131305058), null, true);
      if (this.AZc.AYP.getInputValidChangeListener() != null) {
        this.AZc.AYP.getInputValidChangeListener().onInputValidChange(this.AZc.AYP.asv());
      }
    }
    AppMethodBeat.o(49401);
    return;
    label221:
    Object localObject = new DecimalFormat("00");
    if (r.ZB()) {
      this.AZc.AYP.setTag(((DecimalFormat)localObject).format(this.AZc.AZb + 1) + paramInt1);
    }
    for (;;)
    {
      this.AZc.AYP.setText(((DecimalFormat)localObject).format(this.AZc.AZb + 1) + ((DecimalFormat)localObject).format(paramInt1).substring(2));
      break;
      this.AZc.AYP.setTag(((DecimalFormat)localObject).format(paramInt1).substring(2) + ((DecimalFormat)localObject).format(this.AZc.AZb + 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.b.1.1
 * JD-Core Version:    0.7.0.1
 */