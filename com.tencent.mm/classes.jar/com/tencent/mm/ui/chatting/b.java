package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

final class b
  extends BaseAdapter
{
  private List<y> HKk;
  boolean HKl;
  private Context context;
  private c pEd;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(34220);
    this.HKl = false;
    this.context = paramContext;
    this.HKk = new ArrayList();
    paramContext = new c.a();
    paramContext.hKI = 2131233401;
    this.pEd = paramContext.aFT();
    U(null);
    AppMethodBeat.o(34220);
  }
  
  private y aax(int paramInt)
  {
    AppMethodBeat.i(34225);
    y localy = (y)this.HKk.get(paramInt);
    AppMethodBeat.o(34225);
    return localy;
  }
  
  private y fko()
  {
    AppMethodBeat.i(34222);
    y localy = new y();
    localy.resId = 2131233942;
    localy.fBV = this.context.getString(2131763457);
    AppMethodBeat.o(34222);
    return localy;
  }
  
  private y fkp()
  {
    AppMethodBeat.i(34223);
    y localy = new y();
    localy.resId = 2131233943;
    localy.fBV = this.context.getString(2131757313);
    AppMethodBeat.o(34223);
    return localy;
  }
  
  public final void U(List<y> paramList)
  {
    AppMethodBeat.i(34221);
    this.HKk.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.HKk.addAll(paramList);
    }
    if (this.HKl) {
      this.HKk.add(fkp());
    }
    this.HKk.add(fko());
    ac.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.HKk.size()) });
    AppMethodBeat.o(34221);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34224);
    int i = this.HKk.size();
    AppMethodBeat.o(34224);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34226);
    y localy = aax(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new aq();
      localObject = View.inflate(paramViewGroup.getContext(), 2131495368, null);
      paramView.pHd = ((View)localObject).findViewById(2131298736);
      paramView.iMz = ((TextView)((View)localObject).findViewById(2131302656));
      paramView.lzC = ((ImageView)((View)localObject).findViewById(2131300880));
      paramView.HPi = ((TextView)((View)localObject).findViewById(2131304561));
      paramView.HRd = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(2131304560));
      paramView.HRd.setVisibility(4);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.iMz.setText(localy.fBV);
      ac.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localy.fBV });
      if (localy.resId == 0) {
        break label209;
      }
      paramViewGroup.lzC.setImageResource(localy.resId);
    }
    for (;;)
    {
      paramViewGroup.pHd.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(34226);
      return paramView;
      paramViewGroup = (aq)paramView.getTag();
      break;
      label209:
      localObject = h.c(localy.appId, 1, com.tencent.mm.cc.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.lzC.setImageBitmap((Bitmap)localObject);
      } else {
        o.aFB().a(localy.iconUrl, paramViewGroup.lzC, this.pEd);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b
 * JD-Core Version:    0.7.0.1
 */