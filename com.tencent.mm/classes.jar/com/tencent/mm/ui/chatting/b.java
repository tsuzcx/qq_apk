package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

final class b
  extends BaseAdapter
{
  private List<y> Gkv;
  boolean Gkw;
  private Context context;
  private c paS;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(34220);
    this.Gkw = false;
    this.context = paramContext;
    this.Gkv = new ArrayList();
    paramContext = new c.a();
    paramContext.hkf = 2131233401;
    this.paS = paramContext.azc();
    ad(null);
    AppMethodBeat.o(34220);
  }
  
  private y Ym(int paramInt)
  {
    AppMethodBeat.i(34225);
    y localy = (y)this.Gkv.get(paramInt);
    AppMethodBeat.o(34225);
    return localy;
  }
  
  private y eUB()
  {
    AppMethodBeat.i(34222);
    y localy = new y();
    localy.resId = 2131233942;
    localy.fyo = this.context.getString(2131763457);
    AppMethodBeat.o(34222);
    return localy;
  }
  
  private y eUC()
  {
    AppMethodBeat.i(34223);
    y localy = new y();
    localy.resId = 2131233943;
    localy.fyo = this.context.getString(2131757313);
    AppMethodBeat.o(34223);
    return localy;
  }
  
  public final void ad(List<y> paramList)
  {
    AppMethodBeat.i(34221);
    this.Gkv.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.Gkv.addAll(paramList);
    }
    if (this.Gkw) {
      this.Gkv.add(eUC());
    }
    this.Gkv.add(eUB());
    ad.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.Gkv.size()) });
    AppMethodBeat.o(34221);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34224);
    int i = this.Gkv.size();
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
    y localy = Ym(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new aq();
      localObject = View.inflate(paramViewGroup.getContext(), 2131495368, null);
      paramView.pdS = ((View)localObject).findViewById(2131298736);
      paramView.imt = ((TextView)((View)localObject).findViewById(2131302656));
      paramView.kXS = ((ImageView)((View)localObject).findViewById(2131300880));
      paramView.Gpr = ((TextView)((View)localObject).findViewById(2131304561));
      paramView.Grl = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(2131304560));
      paramView.Grl.setVisibility(4);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.imt.setText(localy.fyo);
      ad.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localy.fyo });
      if (localy.resId == 0) {
        break label209;
      }
      paramViewGroup.kXS.setImageResource(localy.resId);
    }
    for (;;)
    {
      paramViewGroup.pdS.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(34226);
      return paramView;
      paramViewGroup = (aq)paramView.getTag();
      break;
      label209:
      localObject = h.c(localy.appId, 1, com.tencent.mm.cd.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.kXS.setImageBitmap((Bitmap)localObject);
      } else {
        o.ayJ().a(localy.iconUrl, paramViewGroup.kXS, this.paS);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b
 * JD-Core Version:    0.7.0.1
 */