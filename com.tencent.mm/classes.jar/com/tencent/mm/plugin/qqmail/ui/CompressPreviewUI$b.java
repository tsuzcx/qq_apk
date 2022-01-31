package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

final class CompressPreviewUI$b
  extends BaseAdapter
{
  CompressPreviewUI.a nhh;
  List<CompressPreviewUI.a> nhi = null;
  
  private CompressPreviewUI$b(CompressPreviewUI paramCompressPreviewUI) {}
  
  public final String btZ()
  {
    if ((this.nhh == null) || (this.nhh.nhg == null)) {}
    int i;
    do
    {
      return null;
      if (this.nhh.nhg.length() == 0) {
        return "";
      }
      i = this.nhh.id.indexOf(this.nhh.nhg);
    } while (i < 0);
    return this.nhh.id.substring(0, i) + this.nhh.nhg;
  }
  
  public final int getCount()
  {
    if (this.nhi != null) {
      return this.nhi.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.nhe.mController.uMN, b.g.mail_compress_preview_item, null);
      paramView = new CompressPreviewUI.b.a(this, (byte)0);
      paramView.gSx = ((ImageView)paramViewGroup.findViewById(b.f.file_icon_iv));
      paramView.fhD = ((TextView)paramViewGroup.findViewById(b.f.file_name_tv));
      paramView.nhj = ((TextView)paramViewGroup.findViewById(b.f.file_size_tv));
      paramView.nhk = ((ImageView)paramViewGroup.findViewById(b.f.file_sub_tv));
      paramViewGroup.setTag(paramView);
    }
    CompressPreviewUI.b.a locala = (CompressPreviewUI.b.a)paramViewGroup.getTag();
    CompressPreviewUI.a locala1 = wn(paramInt);
    if ((paramInt == 0) && (btZ() != null))
    {
      paramView = locala.gSx;
      paramInt = b.e.qqmail_attach_back;
      paramView.setImageResource(paramInt);
      paramView = locala.nhk;
      if (!locala1.aoD) {
        break label219;
      }
    }
    label219:
    for (paramInt = 0;; paramInt = 4)
    {
      paramView.setVisibility(paramInt);
      locala.fhD.setText(locala1.name);
      locala.nhj.setText(locala1.size);
      return paramViewGroup;
      paramView = locala.gSx;
      if (locala1.btY())
      {
        paramInt = b.e.qqmail_attach_folder;
        break;
      }
      paramInt = FileExplorerUI.WV(locala1.name);
      break;
    }
  }
  
  public final CompressPreviewUI.a wn(int paramInt)
  {
    if ((this.nhi != null) && (this.nhi.size() > paramInt)) {
      return (CompressPreviewUI.a)this.nhi.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.b
 * JD-Core Version:    0.7.0.1
 */