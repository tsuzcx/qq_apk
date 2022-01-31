package com.tencent.mm.ui.chatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMImageView;
import java.util.ArrayList;
import junit.framework.Assert;

final class AppAttachFileListUI$b
  extends BaseAdapter
{
  private AppAttachFileListUI$b(AppAttachFileListUI paramAppAttachFileListUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(30335);
    int i = AppAttachFileListUI.a(this.zvW).size();
    AppMethodBeat.o(30335);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(30336);
    Object localObject = AppAttachFileListUI.a(this.zvW).get(paramInt);
    AppMethodBeat.o(30336);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30337);
    AppAttachFileListUI.c localc;
    if (paramView == null)
    {
      paramView = this.zvW.getLayoutInflater().inflate(2130968652, paramViewGroup, false);
      Assert.assertNotNull(paramView);
      paramViewGroup = new AppAttachFileListUI.d(this.zvW, (byte)0);
      paramViewGroup.zvY = ((MMImageView)paramView.findViewById(2131821124));
      paramViewGroup.zvZ = ((TextView)paramView.findViewById(2131821125));
      paramViewGroup.zwa = ((TextView)paramView.findViewById(2131821127));
      paramViewGroup.zwb = ((TextView)paramView.findViewById(2131821126));
      paramView.setTag(paramViewGroup);
      Assert.assertNotNull(paramViewGroup);
      localc = (AppAttachFileListUI.c)AppAttachFileListUI.a(this.zvW).get(paramInt);
      paramViewGroup.zvZ.setText(localc.zvX.title);
      if (localc.cEE.field_isSend != 1) {
        break label246;
      }
    }
    label246:
    for (String str = "自己";; str = s.nE(localc.zvX.czp))
    {
      paramViewGroup.zwa.setText(String.format("大小：%s，来自：%s", new Object[] { bo.hk(localc.zvX.fgw), str }));
      paramViewGroup.zwb.setText(h.c(this.zvW, localc.cEE.field_createTime, true));
      paramViewGroup.zvY.setImageResource(o.alm(localc.zvX.fgx));
      AppMethodBeat.o(30337);
      return paramView;
      paramViewGroup = (AppAttachFileListUI.d)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI.b
 * JD-Core Version:    0.7.0.1
 */