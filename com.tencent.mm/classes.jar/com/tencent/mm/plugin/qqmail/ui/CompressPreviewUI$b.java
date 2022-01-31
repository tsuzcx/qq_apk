package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import java.util.List;

final class CompressPreviewUI$b
  extends BaseAdapter
{
  private List<CompressPreviewUI.a> hQl = null;
  CompressPreviewUI.a pMv;
  
  private CompressPreviewUI$b(CompressPreviewUI paramCompressPreviewUI) {}
  
  public final CompressPreviewUI.a BY(int paramInt)
  {
    AppMethodBeat.i(68248);
    if ((this.hQl != null) && (this.hQl.size() > paramInt))
    {
      CompressPreviewUI.a locala = (CompressPreviewUI.a)this.hQl.get(paramInt);
      AppMethodBeat.o(68248);
      return locala;
    }
    AppMethodBeat.o(68248);
    return null;
  }
  
  public final void a(CompressPreviewUI.a parama, List<CompressPreviewUI.a> paramList)
  {
    this.pMv = parama;
    this.hQl = paramList;
  }
  
  public final String cel()
  {
    AppMethodBeat.i(68246);
    if ((this.pMv == null) || (this.pMv.pMu == null))
    {
      AppMethodBeat.o(68246);
      return null;
    }
    if (this.pMv.pMu.length() == 0)
    {
      AppMethodBeat.o(68246);
      return "";
    }
    int i = this.pMv.id.indexOf(this.pMv.pMu);
    if (i >= 0)
    {
      String str = this.pMv.id.substring(0, i) + this.pMv.pMu;
      AppMethodBeat.o(68246);
      return str;
    }
    AppMethodBeat.o(68246);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68247);
    if (this.hQl != null)
    {
      int i = this.hQl.size();
      AppMethodBeat.o(68247);
      return i;
    }
    AppMethodBeat.o(68247);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(68249);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.pMs.getContext(), 2130970061, null);
      paramView = new CompressPreviewUI.b.a(this, (byte)0);
      paramView.ivs = ((ImageView)paramViewGroup.findViewById(2131825863));
      paramView.gzk = ((TextView)paramViewGroup.findViewById(2131824017));
      paramView.pMw = ((TextView)paramViewGroup.findViewById(2131825864));
      paramView.pMx = ((ImageView)paramViewGroup.findViewById(2131825865));
      paramViewGroup.setTag(paramView);
    }
    CompressPreviewUI.b.a locala = (CompressPreviewUI.b.a)paramViewGroup.getTag();
    CompressPreviewUI.a locala1 = BY(paramInt);
    if ((paramInt == 0) && (cel() != null))
    {
      paramView = locala.ivs;
      paramInt = 2130840018;
      paramView.setImageResource(paramInt);
      paramView = locala.pMx;
      if (!locala1.aqX) {
        break label219;
      }
    }
    label219:
    for (paramInt = 0;; paramInt = 4)
    {
      paramView.setVisibility(paramInt);
      locala.gzk.setText(locala1.name);
      locala.pMw.setText(locala1.size);
      AppMethodBeat.o(68249);
      return paramViewGroup;
      paramView = locala.ivs;
      if (locala1.cek())
      {
        paramInt = 2130840019;
        break;
      }
      paramInt = FileExplorerUI.amF(locala1.name);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.b
 * JD-Core Version:    0.7.0.1
 */