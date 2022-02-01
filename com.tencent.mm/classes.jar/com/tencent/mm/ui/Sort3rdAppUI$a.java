package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.List;

final class Sort3rdAppUI$a
  extends ArrayAdapter<g>
{
  private Context mContext;
  List<g> pAZ;
  private c qhI;
  private long xdB;
  
  public Sort3rdAppUI$a(Context paramContext, List<g> paramList, long paramLong)
  {
    super(paramContext, 2131495628, paramList);
    AppMethodBeat.i(33754);
    this.xdB = paramLong;
    this.mContext = paramContext;
    this.pAZ = paramList;
    paramContext = new c.a();
    paramContext.idD = 2131233401;
    this.qhI = paramContext.aJc();
    AppMethodBeat.o(33754);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    AppMethodBeat.i(33755);
    final g localg;
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131495628, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localg = (g)getItem(paramInt);
      paramViewGroup.iVq.setText(localg.field_appName);
      localObject = h.c(localg.field_appId, 1, com.tencent.mm.cc.a.getDensity(this.mContext));
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label164;
      }
      paramViewGroup.lZa.setImageBitmap((Bitmap)localObject);
      label99:
      localObject = paramViewGroup.rck;
      if ((localg.field_appInfoFlag & 0x4000) != 0) {
        break label186;
      }
    }
    for (;;)
    {
      ((MMSwitchBtn)localObject).setCheck(bool);
      paramViewGroup.rck.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(33752);
          g localg;
          if (paramAnonymousBoolean) {
            localg = localg;
          }
          for (localg.field_appInfoFlag &= 0xFFFFBFFF;; localg.field_appInfoFlag |= 0x4000)
          {
            ao.dxQ().a(localg, new String[0]);
            AppMethodBeat.o(33752);
            return;
            localg = localg;
          }
        }
      });
      paramView.setVisibility(0);
      AppMethodBeat.o(33755);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label164:
      q.aIJ().a(localg.field_appIconUrl, paramViewGroup.lZa, this.qhI);
      break label99;
      label186:
      bool = false;
    }
  }
  
  static final class a
  {
    TextView iVq;
    ImageView lZa;
    View pBa;
    ImageView pBb;
    MMSwitchBtn rck;
    
    public a(View paramView)
    {
      AppMethodBeat.i(33753);
      this.pBb = ((ImageView)paramView.findViewById(2131300760));
      this.lZa = ((ImageView)paramView.findViewById(2131300880));
      this.iVq = ((TextView)paramView.findViewById(2131305905));
      this.rck = ((MMSwitchBtn)paramView.findViewById(2131305590));
      this.pBa = paramView.findViewById(2131298736);
      AppMethodBeat.o(33753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI.a
 * JD-Core Version:    0.7.0.1
 */