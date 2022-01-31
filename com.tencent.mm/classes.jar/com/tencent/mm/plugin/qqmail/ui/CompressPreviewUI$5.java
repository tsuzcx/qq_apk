package com.tencent.mm.plugin.qqmail.ui;

import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

final class CompressPreviewUI$5
  extends v.a
{
  CompressPreviewUI$5(CompressPreviewUI paramCompressPreviewUI) {}
  
  public final void onError(int paramInt, String paramString)
  {
    if (paramInt == -5)
    {
      CompressPreviewUI.j(this.nhe).a(new CompressPreviewUI.5.1(this));
      return;
    }
    CompressPreviewUI.k(this.nhe).setVisibility(8);
    CompressPreviewUI.l(this.nhe).setVisibility(0);
    CompressPreviewUI.d(this.nhe).setVisibility(8);
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    CompressPreviewUI.b(this.nhe, (String)paramMap.get(".Response.result.compressfilepath"));
    int j = bk.getInt((String)paramMap.get(".Response.result.filelist.count"), 0);
    int i = 0;
    if (i < j) {}
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder(".Response.result.filelist.list.item");
        if (i <= 0) {
          break label395;
        }
        paramString = Integer.valueOf(i);
        paramString = paramString;
        localObject = (String)paramMap.get(paramString + ".path");
        if (localObject == null) {
          break label388;
        }
        localObject = URLDecoder.decode((String)localObject, "utf-8");
        String str1 = (String)paramMap.get(paramString + ".parentpath");
        int k = bk.getInt((String)paramMap.get(paramString + ".size"), 0);
        int m = bk.getInt((String)paramMap.get(paramString + ".type"), 0);
        boolean bool = ((String)paramMap.get(paramString + ".preview")).equals("1");
        String str2 = (String)paramMap.get(paramString + ".name");
        List localList = CompressPreviewUI.h(this.nhe);
        CompressPreviewUI localCompressPreviewUI = this.nhe;
        if (k == 0)
        {
          paramString = "";
          localList.add(new CompressPreviewUI.a(localCompressPreviewUI, (String)localObject, str2, str1, m, paramString, bool));
          break label388;
        }
        paramString = "(" + bk.cm(k) + ")";
        continue;
        CompressPreviewUI.a(this.nhe, "");
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.CompressPreviewUI", paramString, "", new Object[0]);
      }
      return;
      label388:
      i += 1;
      break;
      label395:
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */