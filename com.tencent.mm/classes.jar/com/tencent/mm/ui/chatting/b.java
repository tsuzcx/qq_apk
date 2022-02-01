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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

final class b
  extends BaseAdapter
{
  private List<z> PdW;
  boolean PdX;
  private Context context;
  private c rFu;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(34220);
    this.PdX = false;
    this.context = paramContext;
    this.PdW = new ArrayList();
    paramContext = new c.a();
    paramContext.jbq = 2131234199;
    this.rFu = paramContext.bdv();
    ad(null);
    AppMethodBeat.o(34220);
  }
  
  private z alZ(int paramInt)
  {
    AppMethodBeat.i(34225);
    z localz = (z)this.PdW.get(paramInt);
    AppMethodBeat.o(34225);
    return localz;
  }
  
  private z gMM()
  {
    AppMethodBeat.i(34222);
    z localz = new z();
    localz.resId = 2131234778;
    localz.gCv = this.context.getString(2131765640);
    AppMethodBeat.o(34222);
    return localz;
  }
  
  private z gMN()
  {
    AppMethodBeat.i(34223);
    z localz = new z();
    localz.resId = 2131234779;
    localz.gCv = this.context.getString(2131757527);
    AppMethodBeat.o(34223);
    return localz;
  }
  
  public final void ad(List<z> paramList)
  {
    AppMethodBeat.i(34221);
    this.PdW.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.PdW.addAll(paramList);
    }
    if (this.PdX) {
      this.PdW.add(gMN());
    }
    this.PdW.add(gMM());
    Log.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.PdW.size()) });
    AppMethodBeat.o(34221);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34224);
    int i = this.PdW.size();
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
    z localz = alZ(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new as();
      localObject = View.inflate(paramViewGroup.getContext(), 2131496229, null);
      paramView.rII = ((View)localObject).findViewById(2131299174);
      paramView.kgE = ((TextView)((View)localObject).findViewById(2131305210));
      paramView.nnL = ((ImageView)((View)localObject).findViewById(2131302475));
      paramView.Pjb = ((TextView)((View)localObject).findViewById(2131307603));
      paramView.Plh = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(2131307602));
      paramView.Plh.setVisibility(4);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.kgE.setText(localz.gCv);
      Log.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localz.gCv });
      if (localz.resId == 0) {
        break label209;
      }
      paramViewGroup.nnL.setImageResource(localz.resId);
    }
    for (;;)
    {
      paramViewGroup.rII.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(34226);
      return paramView;
      paramViewGroup = (as)paramView.getTag();
      break;
      label209:
      localObject = h.c(localz.appId, 1, com.tencent.mm.cb.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.nnL.setImageBitmap((Bitmap)localObject);
      } else {
        q.bcV().a(localz.iconUrl, paramViewGroup.nnL, this.rFu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b
 * JD-Core Version:    0.7.0.1
 */