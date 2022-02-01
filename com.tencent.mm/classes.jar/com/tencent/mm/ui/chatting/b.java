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
import com.tencent.mm.av.q;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

final class b
  extends BaseAdapter
{
  private List<z> JSR;
  boolean JSS;
  private Context context;
  private c qon;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(34220);
    this.JSS = false;
    this.context = paramContext;
    this.JSR = new ArrayList();
    paramContext = new c.a();
    paramContext.igv = 2131233401;
    this.qon = paramContext.aJu();
    V(null);
    AppMethodBeat.o(34220);
  }
  
  private z adp(int paramInt)
  {
    AppMethodBeat.i(34225);
    z localz = (z)this.JSR.get(paramInt);
    AppMethodBeat.o(34225);
    return localz;
  }
  
  private z fEF()
  {
    AppMethodBeat.i(34222);
    z localz = new z();
    localz.resId = 2131233942;
    localz.fXp = this.context.getString(2131763457);
    AppMethodBeat.o(34222);
    return localz;
  }
  
  private z fEG()
  {
    AppMethodBeat.i(34223);
    z localz = new z();
    localz.resId = 2131233943;
    localz.fXp = this.context.getString(2131757313);
    AppMethodBeat.o(34223);
    return localz;
  }
  
  public final void V(List<z> paramList)
  {
    AppMethodBeat.i(34221);
    this.JSR.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.JSR.addAll(paramList);
    }
    if (this.JSS) {
      this.JSR.add(fEG());
    }
    this.JSR.add(fEF());
    ae.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.JSR.size()) });
    AppMethodBeat.o(34221);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34224);
    int i = this.JSR.size();
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
    z localz = adp(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new ar();
      localObject = View.inflate(paramViewGroup.getContext(), 2131495368, null);
      paramView.qrn = ((View)localObject).findViewById(2131298736);
      paramView.jiC = ((TextView)((View)localObject).findViewById(2131302656));
      paramView.mdt = ((ImageView)((View)localObject).findViewById(2131300880));
      paramView.JXN = ((TextView)((View)localObject).findViewById(2131304561));
      paramView.JZK = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(2131304560));
      paramView.JZK.setVisibility(4);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.jiC.setText(localz.fXp);
      ae.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localz.fXp });
      if (localz.resId == 0) {
        break label209;
      }
      paramViewGroup.mdt.setImageResource(localz.resId);
    }
    for (;;)
    {
      paramViewGroup.qrn.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(34226);
      return paramView;
      paramViewGroup = (ar)paramView.getTag();
      break;
      label209:
      localObject = h.c(localz.appId, 1, com.tencent.mm.cb.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.mdt.setImageBitmap((Bitmap)localObject);
      } else {
        q.aJb().a(localz.iconUrl, paramViewGroup.mdt, this.qon);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b
 * JD-Core Version:    0.7.0.1
 */