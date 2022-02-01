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
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

final class b
  extends BaseAdapter
{
  private List<ab> aeeH;
  boolean aeeI;
  private Context context;
  private c yxG;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(34220);
    this.aeeI = false;
    this.context = paramContext;
    this.aeeH = new ArrayList();
    paramContext = new c.a();
    paramContext.oKB = R.g.foC;
    this.yxG = paramContext.bKx();
    bz(null);
    AppMethodBeat.o(34220);
  }
  
  private ab aBB(int paramInt)
  {
    AppMethodBeat.i(34225);
    ab localab = (ab)this.aeeH.get(paramInt);
    AppMethodBeat.o(34225);
    return localab;
  }
  
  private ab jox()
  {
    AppMethodBeat.i(34222);
    ab localab = new ab();
    localab.resId = R.g.foY;
    localab.displayName = this.context.getString(R.l.settings_title);
    AppMethodBeat.o(34222);
    return localab;
  }
  
  private ab joy()
  {
    AppMethodBeat.i(34223);
    ab localab = new ab();
    localab.resId = R.g.foZ;
    localab.displayName = this.context.getString(R.l.gzG);
    AppMethodBeat.o(34223);
    return localab;
  }
  
  public final void bz(List<ab> paramList)
  {
    AppMethodBeat.i(34221);
    this.aeeH.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.aeeH.addAll(paramList);
    }
    if (this.aeeI) {
      this.aeeH.add(joy());
    }
    this.aeeH.add(jox());
    Log.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.aeeH.size()) });
    AppMethodBeat.o(34221);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34224);
    int i = this.aeeH.size();
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
    ab localab = aBB(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new au();
      localObject = View.inflate(paramViewGroup.getContext(), R.i.gnR, null);
      paramView.rIY = ((View)localObject).findViewById(R.h.container);
      paramView.pUL = ((TextView)((View)localObject).findViewById(R.h.fOX));
      paramView.ttT = ((ImageView)((View)localObject).findViewById(R.h.iconIV));
      paramView.aejX = ((TextView)((View)localObject).findViewById(R.h.fVR));
      paramView.aemr = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(R.h.fVQ));
      paramView.aemr.setVisibility(4);
      paramView.Aov = ((ImageView)((View)localObject).findViewById(R.h.app_avatar_mask_iv));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.jqh();
      paramViewGroup.pUL.setText(localab.displayName);
      Log.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localab.displayName });
      if (localab.resId == 0) {
        break label234;
      }
      paramViewGroup.ttT.setImageResource(localab.resId);
    }
    for (;;)
    {
      paramViewGroup.rIY.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(34226);
      return paramView;
      paramViewGroup = (au)paramView.getTag();
      break;
      label234:
      localObject = h.c(localab.appId, 1, com.tencent.mm.cd.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.ttT.setImageBitmap((Bitmap)localObject);
      } else {
        r.bKe().a(localab.iconUrl, paramViewGroup.ttT, this.yxG);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b
 * JD-Core Version:    0.7.0.1
 */