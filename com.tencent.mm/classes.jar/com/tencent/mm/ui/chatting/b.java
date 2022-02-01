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
import com.tencent.mm.aw.q;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

final class b
  extends BaseAdapter
{
  private List<y> Jyb;
  boolean Jyc;
  private Context context;
  private c qhI;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(34220);
    this.Jyc = false;
    this.context = paramContext;
    this.Jyb = new ArrayList();
    paramContext = new c.a();
    paramContext.idD = 2131233401;
    this.qhI = paramContext.aJc();
    V(null);
    AppMethodBeat.o(34220);
  }
  
  private y acH(int paramInt)
  {
    AppMethodBeat.i(34225);
    y localy = (y)this.Jyb.get(paramInt);
    AppMethodBeat.o(34225);
    return localy;
  }
  
  private y fAD()
  {
    AppMethodBeat.i(34222);
    y localy = new y();
    localy.resId = 2131233942;
    localy.fVj = this.context.getString(2131763457);
    AppMethodBeat.o(34222);
    return localy;
  }
  
  private y fAE()
  {
    AppMethodBeat.i(34223);
    y localy = new y();
    localy.resId = 2131233943;
    localy.fVj = this.context.getString(2131757313);
    AppMethodBeat.o(34223);
    return localy;
  }
  
  public final void V(List<y> paramList)
  {
    AppMethodBeat.i(34221);
    this.Jyb.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.Jyb.addAll(paramList);
    }
    if (this.Jyc) {
      this.Jyb.add(fAE());
    }
    this.Jyb.add(fAD());
    ad.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.Jyb.size()) });
    AppMethodBeat.o(34221);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34224);
    int i = this.Jyb.size();
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
    y localy = acH(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new aq();
      localObject = View.inflate(paramViewGroup.getContext(), 2131495368, null);
      paramView.qkI = ((View)localObject).findViewById(2131298736);
      paramView.jfJ = ((TextView)((View)localObject).findViewById(2131302656));
      paramView.lZa = ((ImageView)((View)localObject).findViewById(2131300880));
      paramView.JCW = ((TextView)((View)localObject).findViewById(2131304561));
      paramView.JET = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(2131304560));
      paramView.JET.setVisibility(4);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.jfJ.setText(localy.fVj);
      ad.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localy.fVj });
      if (localy.resId == 0) {
        break label209;
      }
      paramViewGroup.lZa.setImageResource(localy.resId);
    }
    for (;;)
    {
      paramViewGroup.qkI.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(34226);
      return paramView;
      paramViewGroup = (aq)paramView.getTag();
      break;
      label209:
      localObject = h.c(localy.appId, 1, com.tencent.mm.cc.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.lZa.setImageBitmap((Bitmap)localObject);
      } else {
        q.aIJ().a(localy.iconUrl, paramViewGroup.lZa, this.qhI);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b
 * JD-Core Version:    0.7.0.1
 */