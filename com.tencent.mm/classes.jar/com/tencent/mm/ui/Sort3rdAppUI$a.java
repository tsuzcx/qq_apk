package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.List;

final class Sort3rdAppUI$a
  extends ArrayAdapter<g>
{
  private long FwG;
  private Context mContext;
  List<g> oXp;
  private c pEd;
  
  public Sort3rdAppUI$a(Context paramContext, List<g> paramList, long paramLong)
  {
    super(paramContext, 2131495628, paramList);
    AppMethodBeat.i(33754);
    this.FwG = paramLong;
    this.mContext = paramContext;
    this.oXp = paramList;
    paramContext = new c.a();
    paramContext.hKI = 2131233401;
    this.pEd = paramContext.aFT();
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
      paramViewGroup.iCg.setText(localg.field_appName);
      localObject = h.c(localg.field_appId, 1, com.tencent.mm.cc.a.getDensity(this.mContext));
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label164;
      }
      paramViewGroup.lzC.setImageBitmap((Bitmap)localObject);
      label99:
      localObject = paramViewGroup.tTm;
      if ((localg.field_appInfoFlag & 0x4000) != 0) {
        break label186;
      }
    }
    for (;;)
    {
      ((MMSwitchBtn)localObject).setCheck(bool);
      paramViewGroup.tTm.setSwitchListener(new MMSwitchBtn.a()
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
            ap.dny().a(localg, new String[0]);
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
      o.aFB().a(localg.field_appIconUrl, paramViewGroup.lzC, this.pEd);
      break label99;
      label186:
      bool = false;
    }
  }
  
  static final class a
  {
    TextView iCg;
    ImageView lzC;
    View oXq;
    ImageView oXr;
    MMSwitchBtn tTm;
    
    public a(View paramView)
    {
      AppMethodBeat.i(33753);
      this.oXr = ((ImageView)paramView.findViewById(2131300760));
      this.lzC = ((ImageView)paramView.findViewById(2131300880));
      this.iCg = ((TextView)paramView.findViewById(2131305905));
      this.tTm = ((MMSwitchBtn)paramView.findViewById(2131305590));
      this.oXq = paramView.findViewById(2131298736);
      AppMethodBeat.o(33753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI.a
 * JD-Core Version:    0.7.0.1
 */