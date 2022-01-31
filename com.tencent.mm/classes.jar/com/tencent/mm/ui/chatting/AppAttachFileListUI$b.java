package com.tencent.mm.ui.chatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMImageView;
import java.util.ArrayList;
import junit.framework.Assert;

final class AppAttachFileListUI$b
  extends BaseAdapter
{
  private AppAttachFileListUI$b(AppAttachFileListUI paramAppAttachFileListUI) {}
  
  public final int getCount()
  {
    return AppAttachFileListUI.a(this.vgU).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return AppAttachFileListUI.a(this.vgU).get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppAttachFileListUI.c localc;
    if (paramView == null)
    {
      paramView = this.vgU.getLayoutInflater().inflate(R.i.app_attach_file_list_item, paramViewGroup, false);
      Assert.assertNotNull(paramView);
      paramViewGroup = new AppAttachFileListUI.d(this.vgU, (byte)0);
      paramViewGroup.vgW = ((MMImageView)paramView.findViewById(R.h.file_list_item_icon));
      paramViewGroup.vgX = ((TextView)paramView.findViewById(R.h.file_list_item_title));
      paramViewGroup.vgY = ((TextView)paramView.findViewById(R.h.file_list_item_from));
      paramViewGroup.vgZ = ((TextView)paramView.findViewById(R.h.file_list_item_time));
      paramView.setTag(paramViewGroup);
      Assert.assertNotNull(paramViewGroup);
      localc = (AppAttachFileListUI.c)AppAttachFileListUI.a(this.vgU).get(paramInt);
      paramViewGroup.vgX.setText(localc.vgV.title);
      if (localc.bWO.field_isSend != 1) {
        break label239;
      }
    }
    label239:
    for (String str = "自己";; str = r.gV(localc.vgV.bRO))
    {
      paramViewGroup.vgY.setText(String.format("大小：%s，来自：%s", new Object[] { bk.cm(localc.vgV.dQv), str }));
      paramViewGroup.vgZ.setText(h.c(this.vgU, localc.bWO.field_createTime, true));
      paramViewGroup.vgW.setImageResource(o.VP(localc.vgV.dQw));
      return paramView;
      paramViewGroup = (AppAttachFileListUI.d)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI.b
 * JD-Core Version:    0.7.0.1
 */