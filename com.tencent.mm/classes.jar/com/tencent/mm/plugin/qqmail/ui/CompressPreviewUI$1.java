package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;

final class CompressPreviewUI$1
  implements AdapterView.OnItemClickListener
{
  CompressPreviewUI$1(CompressPreviewUI paramCompressPreviewUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(68238);
    paramView = CompressPreviewUI.a(this.pMs).BY(paramInt);
    String str1 = paramView.id;
    paramAdapterView = CompressPreviewUI.a(this.pMs);
    if (paramAdapterView.pMv == null) {}
    for (paramAdapterView = null; str1.equals(paramAdapterView); paramAdapterView = paramAdapterView.pMv.id)
    {
      CompressPreviewUI.a(this.pMs, CompressPreviewUI.a(this.pMs).cel());
      AppMethodBeat.o(68238);
      return;
    }
    if (paramView.cek())
    {
      CompressPreviewUI.a(this.pMs, paramView.id);
      AppMethodBeat.o(68238);
      return;
    }
    if (paramView.aqX)
    {
      paramAdapterView = "mailid=" + CompressPreviewUI.b(this.pMs);
      str1 = "attachid=" + paramView.id;
      String str2 = "compressfilepath=" + CompressPreviewUI.c(this.pMs);
      Intent localIntent = new Intent(this.pMs, MailWebViewUI.class);
      localIntent.putExtra("uri", "/cgi-bin/viewdocument");
      localIntent.putExtra("params", new String[] { paramAdapterView, str1, str2, "texttype=html" });
      localIntent.putExtra("baseurl", v.cdK());
      localIntent.putExtra("method", "get");
      localIntent.putExtra("singleColumn", FileExplorerUI.amG(paramView.name));
      localIntent.putExtra("title", this.pMs.getString(2131302308));
      this.pMs.startActivity(localIntent);
    }
    AppMethodBeat.o(68238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */