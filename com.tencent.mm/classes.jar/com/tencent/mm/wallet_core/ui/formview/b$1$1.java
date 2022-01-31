package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.CustomDatePicker;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import java.text.DecimalFormat;
import java.util.Locale;

final class b$1$1
  implements a.a
{
  b$1$1(b.1 param1, a parama) {}
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.qCo.hide();
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.qCo;
      if (((a)localObject).won == null) {
        break label512;
      }
      localObject = ((a)localObject).won;
      if (!((CustomDatePicker)localObject).hzL) {
        break label96;
      }
      localObject = String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(((CustomDatePicker)localObject).getYear()), Integer.valueOf(((CustomDatePicker)localObject).getMonth()), Integer.valueOf(((CustomDatePicker)localObject).getDayOfMonth()) });
    }
    for (;;)
    {
      if (bk.bl((String)localObject)) {}
      label96:
      String[] arrayOfString;
      do
      {
        return;
        if (((CustomDatePicker)localObject).hzK)
        {
          localObject = String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(((CustomDatePicker)localObject).getYear()), Integer.valueOf(((CustomDatePicker)localObject).getMonth()) });
          break;
        }
        localObject = String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(((CustomDatePicker)localObject).getYear()) });
        break;
        arrayOfString = ((String)localObject).split("-");
      } while (arrayOfString.length < 2);
      y.d("MicroMsg.FormatViewUtil", "result: %s", new Object[] { localObject });
      paramInt1 = bk.ZR(arrayOfString[0]);
      this.wCR.wCQ = (bk.ZR(arrayOfString[1]) - 1);
      y.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.wCR.wCQ) });
      if ((paramInt1 < b.access$000()) && (this.wCR.wCQ < b.access$100()))
      {
        h.b(this.wCR.jxM, this.wCR.jxM.getString(a.i.wallet_err_expired_date), null, true);
        label304:
        if (this.wCR.wCD.getInputValidChangeListener() != null) {
          this.wCR.wCD.getInputValidChangeListener().gG(this.wCR.wCD.YL());
        }
      }
      else
      {
        localObject = new DecimalFormat("00");
        if (!q.Gw()) {
          break label457;
        }
        this.wCR.wCD.setTag(((DecimalFormat)localObject).format(this.wCR.wCQ + 1) + paramInt1);
      }
      for (;;)
      {
        this.wCR.wCD.setText(((DecimalFormat)localObject).format(this.wCR.wCQ + 1) + ((DecimalFormat)localObject).format(paramInt1).substring(2));
        break label304;
        break;
        label457:
        this.wCR.wCD.setTag(((DecimalFormat)localObject).format(paramInt1).substring(2) + ((DecimalFormat)localObject).format(this.wCR.wCQ + 1));
      }
      label512:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.b.1.1
 * JD-Core Version:    0.7.0.1
 */