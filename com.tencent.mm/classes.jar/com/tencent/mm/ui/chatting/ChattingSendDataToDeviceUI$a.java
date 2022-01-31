package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ChattingSendDataToDeviceUI$a
  extends BaseAdapter
{
  private Context context;
  private c lKi;
  private Map<String, ChattingSendDataToDeviceUI.c> zBe;
  private List<Map<String, ChattingSendDataToDeviceUI.c>> zwi;
  
  public ChattingSendDataToDeviceUI$a(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI, Context paramContext)
  {
    AppMethodBeat.i(30777);
    this.context = paramContext;
    this.zwi = new ArrayList();
    paramChattingSendDataToDeviceUI = new c.a();
    paramChattingSendDataToDeviceUI.eNY = 2130839759;
    this.lKi = paramChattingSendDataToDeviceUI.ahY();
    AppMethodBeat.o(30777);
  }
  
  public final ChattingSendDataToDeviceUI.c Pt(int paramInt)
  {
    AppMethodBeat.i(30780);
    ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((Map)this.zwi.get(paramInt)).get("hard_device_info");
    AppMethodBeat.o(30780);
    return localc;
  }
  
  public final void bt(List<ChattingSendDataToDeviceUI.c> paramList)
  {
    AppMethodBeat.i(30778);
    this.zwi.clear();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      this.zBe = new HashMap();
      this.zBe.put("hard_device_info", paramList.get(i));
      this.zwi.add(this.zBe);
      i += 1;
    }
    AppMethodBeat.o(30778);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(30779);
    int i = this.zwi.size();
    AppMethodBeat.o(30779);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30781);
    ChattingSendDataToDeviceUI.c localc = Pt(paramInt);
    ab.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
    int i;
    int j;
    StringBuffer localStringBuffer;
    float f;
    label265:
    int k;
    label268:
    String str2;
    if (ChattingSendDataToDeviceUI.c(this.zAW).get(Integer.valueOf(paramInt)) == null)
    {
      paramView = new ap();
      paramViewGroup = View.inflate(paramViewGroup.getContext(), 2130970673, null);
      paramView.lNh = paramViewGroup.findViewById(2131821084);
      paramView.gzk = ((TextView)paramViewGroup.findViewById(2131823741));
      paramView.ivs = ((ImageView)paramViewGroup.findViewById(2131823740));
      paramView.zBd = ((TextView)paramViewGroup.findViewById(2131827568));
      paramView.zCQ = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(2131827567));
      paramView.zCQ.setVisibility(4);
      ChattingSendDataToDeviceUI.c(this.zAW).put(Integer.valueOf(paramInt), paramViewGroup);
      paramViewGroup.setTag(paramView);
      ChattingSendDataToDeviceUI.k(this.zAW).put(localc.deviceID, Integer.valueOf(paramInt));
      String str1 = localc.elx;
      i = 8;
      j = 0;
      localObject = new StringBuffer();
      localStringBuffer = new StringBuffer();
      f = com.tencent.mm.cb.a.dr(this.context);
      if ((f != com.tencent.mm.cb.a.gh(this.context)) && (f != com.tencent.mm.cb.a.gi(this.context))) {
        break label375;
      }
      i = 6;
      k = 0;
      if (k >= str1.length()) {
        break label428;
      }
      int m = Character.codePointAt(str1, k);
      str2 = str1.substring(k, k + 1);
      if ((m < 0) || (m > 255)) {
        break label407;
      }
      j += 1;
      label319:
      if (j > i) {
        break label416;
      }
      localObject = ((StringBuffer)localObject).append(str2);
    }
    for (;;)
    {
      k += 1;
      break label268;
      paramViewGroup = (View)ChattingSendDataToDeviceUI.c(this.zAW).get(Integer.valueOf(paramInt));
      paramView = (ap)paramViewGroup.getTag();
      break;
      label375:
      if ((f != com.tencent.mm.cb.a.gj(this.context)) && (f != com.tencent.mm.cb.a.gk(this.context))) {
        break label265;
      }
      i = 5;
      break label265;
      label407:
      j += 2;
      break label319;
      label416:
      localStringBuffer = localStringBuffer.append(str2);
    }
    label428:
    paramView.gzk.setText(((StringBuffer)localObject).toString());
    if (j >= i) {
      paramView.zBd.setText(localStringBuffer);
    }
    Object localObject = null;
    if (ChattingSendDataToDeviceUI.d(this.zAW).containsKey(Pt(paramInt).deviceID)) {
      localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.zAW).get(Pt(paramInt).deviceID);
    }
    if ((localObject != null) && (((ChattingSendDataToDeviceUI.c)localObject).csn != null))
    {
      ab.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ChattingSendDataToDeviceUI.c)localObject).csn });
      if (!((ChattingSendDataToDeviceUI.c)localObject).csn.equals("send_data_sending")) {
        break label758;
      }
      paramView.zBd.setText(this.context.getString(2131298323));
      paramView.zBd.setTextColor(this.context.getResources().getColor(2131690440));
      paramView.zCQ.Px(localc.progress);
      paramView.zCQ.setVisibility(0);
      localObject = localc.deviceID;
      localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.zAW).get(localObject);
      j = ((ChattingSendDataToDeviceUI.c)localObject).progress;
      if (j < 100) {
        break label744;
      }
      i = 0;
      d.h(new ChattingSendDataToDeviceUI.a.1(this, j, (ChattingSendDataToDeviceUI.c)localObject, paramView, i), "SendDataState_handler").start();
    }
    for (;;)
    {
      ab.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localc.elx });
      o.ahG().a(localc.iconUrl, paramView.ivs, this.lKi);
      paramView.lNh.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(30781);
      return paramViewGroup;
      label744:
      i = 500 / (100 - j);
      break;
      label758:
      if (((ChattingSendDataToDeviceUI.c)localObject).csn.equals("send_data_sucess"))
      {
        paramView.zBd.setText(this.context.getString(2131298321));
        paramView.zBd.setTextColor(this.context.getResources().getColor(2131690440));
        paramView.zCQ.setVisibility(4);
      }
      else if (((ChattingSendDataToDeviceUI.c)localObject).csn.equals("send_data_cancel"))
      {
        paramView.zBd.setText(this.context.getString(2131298314));
        paramView.zBd.setTextColor(this.context.getResources().getColor(2131690438));
        paramView.zCQ.setVisibility(4);
      }
      else if (((ChattingSendDataToDeviceUI.c)localObject).csn.equals("send_data_failed"))
      {
        paramView.zBd.setText(this.context.getString(2131298318));
        paramView.zBd.setTextColor(this.context.getResources().getColor(2131690443));
        paramView.zCQ.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a
 * JD-Core Version:    0.7.0.1
 */