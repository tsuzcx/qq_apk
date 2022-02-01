package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.d.e;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.d;
import java.util.List;

final class BaseScanUI$26
  implements e.b
{
  BaseScanUI$26(BaseScanUI paramBaseScanUI, long paramLong) {}
  
  public final void a(final long paramLong, e.d paramd)
  {
    final List localList2 = null;
    AppMethodBeat.i(189464);
    if (paramd != null) {}
    for (final List localList1 = paramd.yEe;; localList1 = null)
    {
      if (paramd != null) {
        localList2 = paramd.MhJ;
      }
      if ((paramLong == this.yGq) && (BaseScanUI.S(this.yGg))) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(189463);
            BaseScanUI.d(BaseScanUI.26.this.yGg, false);
            Bundle localBundle;
            Object localObject;
            if ((localList1 != null) && (!localList1.isEmpty()))
            {
              localBundle = new Bundle();
              localBundle.putString("result_content", ((a.a)localList1.get(0)).data);
              localBundle.putInt("result_code_format", ((a.a)localList1.get(0)).typeID);
              localBundle.putString("result_code_name", ((a.a)localList1.get(0)).typeName);
              localObject = ((a.a)localList1.get(0)).rawData;
              if (localObject != null) {
                localBundle.putByteArray("result_raw_data", (byte[])localObject);
              }
              if ((localList2 == null) || (localList2.isEmpty())) {
                break label392;
              }
            }
            label392:
            for (int i = ((WxQbarNative.QBarReportMsg)localList2.get(0)).qrcodeVersion;; i = 0)
            {
              localBundle.putInt("result_code_version", i);
              ad.a(BaseScanUI.b(BaseScanUI.26.this.yGg), true, 2, 1);
              if (BaseScanUI.f(BaseScanUI.26.this.yGg))
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("key_scan_result", localBundle.getString("result_content"));
                ((Intent)localObject).putExtra("key_scan_result_raw", localBundle.getByteArray("result_raw_data"));
                ((Intent)localObject).putExtra("key_scan_result_code_name", localBundle.getString("result_code_name"));
                ((Intent)localObject).putExtra("key_scan_result_code_version", i);
                BaseScanUI.26.this.yGg.setResult(-1, (Intent)localObject);
                BaseScanUI.26.this.yGg.bXx();
                AppMethodBeat.o(189463);
                return;
              }
              localBundle.putInt("qbar_string_scan_source", 1);
              if (BaseScanUI.c(BaseScanUI.26.this.yGg) != null) {
                BaseScanUI.c(BaseScanUI.26.this.yGg).c(paramLong, localBundle);
              }
              BaseScanUI.k(BaseScanUI.26.this.yGg);
              AppMethodBeat.o(189463);
              return;
              BaseScanUI.d(BaseScanUI.26.this.yGg, true);
              BaseScanUI.h(BaseScanUI.26.this.yGg, true);
              ad.a(BaseScanUI.b(BaseScanUI.26.this.yGg), false, 2, 1);
              AppMethodBeat.o(189463);
              return;
            }
          }
        });
      }
      AppMethodBeat.o(189464);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.26
 * JD-Core Version:    0.7.0.1
 */