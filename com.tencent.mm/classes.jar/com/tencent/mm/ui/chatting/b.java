package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

final class b
  extends BaseAdapter
{
  private List<z> Wxp;
  boolean Wxq;
  private Context context;
  private c vle;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(34220);
    this.Wxq = false;
    this.context = paramContext;
    this.Wxp = new ArrayList();
    paramContext = new c.a();
    paramContext.lRP = R.g.doe;
    this.vle = paramContext.bmL();
    aa(null);
    AppMethodBeat.o(34220);
  }
  
  private z auZ(int paramInt)
  {
    AppMethodBeat.i(34225);
    z localz = (z)this.Wxp.get(paramInt);
    AppMethodBeat.o(34225);
    return localz;
  }
  
  private z hLV()
  {
    AppMethodBeat.i(34222);
    z localz = new z();
    localz.resId = R.g.doB;
    localz.jmB = this.context.getString(R.l.settings_title);
    AppMethodBeat.o(34222);
    return localz;
  }
  
  private z hLW()
  {
    AppMethodBeat.i(34223);
    z localz = new z();
    localz.resId = R.g.doC;
    localz.jmB = this.context.getString(R.l.exc);
    AppMethodBeat.o(34223);
    return localz;
  }
  
  public final void aa(List<z> paramList)
  {
    AppMethodBeat.i(34221);
    this.Wxp.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.Wxp.addAll(paramList);
    }
    if (this.Wxq) {
      this.Wxp.add(hLW());
    }
    this.Wxp.add(hLV());
    Log.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.Wxp.size()) });
    AppMethodBeat.o(34221);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34224);
    int i = this.Wxp.size();
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
    z localz = auZ(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new as();
      localObject = View.inflate(paramViewGroup.getContext(), R.i.ekM, null);
      paramView.voq = ((View)localObject).findViewById(R.h.container);
      paramView.mYd = ((TextView)((View)localObject).findViewById(R.h.dNd));
      paramView.qps = ((ImageView)((View)localObject).findViewById(R.h.dIy));
      paramView.WCD = ((TextView)((View)localObject).findViewById(R.h.dTJ));
      paramView.WER = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(R.h.dTI));
      paramView.WER.setVisibility(4);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.mYd.setText(localz.jmB);
      Log.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localz.jmB });
      if (localz.resId == 0) {
        break label215;
      }
      paramViewGroup.qps.setImageResource(localz.resId);
    }
    for (;;)
    {
      paramViewGroup.voq.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(34226);
      return paramView;
      paramViewGroup = (as)paramView.getTag();
      break;
      label215:
      localObject = h.c(localz.appId, 1, com.tencent.mm.ci.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.qps.setImageBitmap((Bitmap)localObject);
      } else {
        q.bml().a(localz.iconUrl, paramViewGroup.qps, this.vle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b
 * JD-Core Version:    0.7.0.1
 */