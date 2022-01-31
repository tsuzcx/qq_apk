package com.tencent.mm.plugin.qqmail.ui;

import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

final class CompressPreviewUI$5
  extends v.a
{
  CompressPreviewUI$5(CompressPreviewUI paramCompressPreviewUI) {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(68244);
    if (paramInt == -5)
    {
      CompressPreviewUI.j(this.pMs).a(new CompressPreviewUI.5.1(this));
      AppMethodBeat.o(68244);
      return;
    }
    CompressPreviewUI.k(this.pMs).setVisibility(8);
    CompressPreviewUI.l(this.pMs).setVisibility(0);
    CompressPreviewUI.d(this.pMs).setVisibility(8);
    AppMethodBeat.o(68244);
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(68243);
    CompressPreviewUI.b(this.pMs, (String)paramMap.get(".Response.result.compressfilepath"));
    int j = bo.getInt((String)paramMap.get(".Response.result.filelist.count"), 0);
    int i = 0;
    if (i < j) {}
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder(".Response.result.filelist.list.item");
        if (i <= 0) {
          break label405;
        }
        paramString = Integer.valueOf(i);
        paramString = paramString;
        localObject = (String)paramMap.get(paramString + ".path");
        if (localObject == null) {
          break label398;
        }
        localObject = URLDecoder.decode((String)localObject, "utf-8");
        String str1 = (String)paramMap.get(paramString + ".parentpath");
        int k = bo.getInt((String)paramMap.get(paramString + ".size"), 0);
        int m = bo.getInt((String)paramMap.get(paramString + ".type"), 0);
        boolean bool = ((String)paramMap.get(paramString + ".preview")).equals("1");
        String str2 = (String)paramMap.get(paramString + ".name");
        List localList = CompressPreviewUI.h(this.pMs);
        CompressPreviewUI localCompressPreviewUI = this.pMs;
        if (k == 0)
        {
          paramString = "";
          localList.add(new CompressPreviewUI.a(localCompressPreviewUI, (String)localObject, str2, str1, m, paramString, bool));
          break label398;
        }
        paramString = "(" + bo.hk(k) + ")";
        continue;
        CompressPreviewUI.a(this.pMs, "");
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.CompressPreviewUI", paramString, "", new Object[0]);
      }
      AppMethodBeat.o(68243);
      return;
      label398:
      i += 1;
      break;
      label405:
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */