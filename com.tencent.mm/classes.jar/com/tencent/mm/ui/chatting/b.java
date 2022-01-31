package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

final class b
  extends BaseAdapter
{
  private Context context;
  private c lKi;
  private List<y> zwi;
  boolean zwj;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(30370);
    this.zwj = false;
    this.context = paramContext;
    this.zwi = new ArrayList();
    paramContext = new c.a();
    paramContext.eNY = 2130839759;
    this.lKi = paramContext.ahY();
    bt(null);
    AppMethodBeat.o(30370);
  }
  
  private y Pg(int paramInt)
  {
    AppMethodBeat.i(30375);
    y localy = (y)this.zwi.get(paramInt);
    AppMethodBeat.o(30375);
    return localy;
  }
  
  private y dFG()
  {
    AppMethodBeat.i(30372);
    y localy = new y();
    localy.resId = 2130840235;
    localy.elx = this.context.getString(2131303475);
    AppMethodBeat.o(30372);
    return localy;
  }
  
  private y dFH()
  {
    AppMethodBeat.i(30373);
    y localy = new y();
    localy.resId = 2130840236;
    localy.elx = this.context.getString(2131298322);
    AppMethodBeat.o(30373);
    return localy;
  }
  
  public final void bt(List<y> paramList)
  {
    AppMethodBeat.i(30371);
    this.zwi.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.zwi.addAll(paramList);
    }
    if (this.zwj) {
      this.zwi.add(dFH());
    }
    this.zwi.add(dFG());
    ab.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.zwi.size()) });
    AppMethodBeat.o(30371);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(30374);
    int i = this.zwi.size();
    AppMethodBeat.o(30374);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30376);
    y localy = Pg(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new ap();
      localObject = View.inflate(paramViewGroup.getContext(), 2130970673, null);
      paramView.lNh = ((View)localObject).findViewById(2131821084);
      paramView.gzk = ((TextView)((View)localObject).findViewById(2131823741));
      paramView.ivs = ((ImageView)((View)localObject).findViewById(2131823740));
      paramView.zBd = ((TextView)((View)localObject).findViewById(2131827568));
      paramView.zCQ = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(2131827567));
      paramView.zCQ.setVisibility(4);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.gzk.setText(localy.elx);
      ab.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localy.elx });
      if (localy.resId == 0) {
        break label211;
      }
      paramViewGroup.ivs.setImageResource(localy.resId);
    }
    for (;;)
    {
      paramViewGroup.lNh.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(30376);
      return paramView;
      paramViewGroup = (ap)paramView.getTag();
      break;
      label211:
      localObject = g.b(localy.appId, 1, com.tencent.mm.cb.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.ivs.setImageBitmap((Bitmap)localObject);
      } else {
        o.ahG().a(localy.iconUrl, paramViewGroup.ivs, this.lKi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b
 * JD-Core Version:    0.7.0.1
 */