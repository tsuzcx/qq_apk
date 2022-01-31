package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;

final class CompressPreviewUI$1
  implements AdapterView.OnItemClickListener
{
  CompressPreviewUI$1(CompressPreviewUI paramCompressPreviewUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = CompressPreviewUI.a(this.nhe).wn(paramInt);
    String str1 = paramView.id;
    paramAdapterView = CompressPreviewUI.a(this.nhe);
    if (paramAdapterView.nhh == null)
    {
      paramAdapterView = null;
      if (!str1.equals(paramAdapterView)) {
        break label73;
      }
      CompressPreviewUI.a(this.nhe, CompressPreviewUI.a(this.nhe).btZ());
    }
    label73:
    do
    {
      return;
      paramAdapterView = paramAdapterView.nhh.id;
      break;
      if (paramView.btY())
      {
        CompressPreviewUI.a(this.nhe, paramView.id);
        return;
      }
    } while (!paramView.aoD);
    paramAdapterView = "mailid=" + CompressPreviewUI.b(this.nhe);
    str1 = "attachid=" + paramView.id;
    String str2 = "compressfilepath=" + CompressPreviewUI.c(this.nhe);
    Intent localIntent = new Intent(this.nhe, MailWebViewUI.class);
    localIntent.putExtra("uri", "/cgi-bin/viewdocument");
    localIntent.putExtra("params", new String[] { paramAdapterView, str1, str2, "texttype=html" });
    localIntent.putExtra("baseurl", v.btz());
    localIntent.putExtra("method", "get");
    localIntent.putExtra("singleColumn", FileExplorerUI.WW(paramView.name));
    localIntent.putExtra("title", this.nhe.getString(b.j.readmail_attachment_preview));
    this.nhe.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */