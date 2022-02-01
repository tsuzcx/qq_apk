package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.List;

final class Sort3rdAppUI$a
  extends ArrayAdapter<g>
{
  private long NlD;
  private Context mContext;
  List<g> xGG;
  private c yxG;
  
  public Sort3rdAppUI$a(Context paramContext, List<g> paramList, long paramLong)
  {
    super(paramContext, R.i.gov, paramList);
    AppMethodBeat.i(33754);
    this.NlD = paramLong;
    this.mContext = paramContext;
    this.xGG = paramList;
    paramContext = new c.a();
    paramContext.oKB = R.g.foC;
    this.yxG = paramContext.bKx();
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
      paramView = View.inflate(this.mContext, R.i.gov, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localg = (g)getItem(paramInt);
      paramViewGroup.pJJ.setText(localg.field_appName);
      localObject = h.c(localg.field_appId, 1, com.tencent.mm.cd.a.getDensity(this.mContext));
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label165;
      }
      paramViewGroup.ttT.setImageBitmap((Bitmap)localObject);
      label100:
      localObject = paramViewGroup.zNX;
      if ((localg.field_appInfoFlag & 0x4000) != 0) {
        break label187;
      }
    }
    for (;;)
    {
      ((MMSwitchBtn)localObject).setCheck(bool);
      paramViewGroup.zNX.setSwitchListener(new MMSwitchBtn.a()
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
            as.gxn().a(localg, new String[0]);
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
      label165:
      r.bKe().a(localg.field_appIconUrl, paramViewGroup.ttT, this.yxG);
      break label100;
      label187:
      bool = false;
    }
  }
  
  static final class a
  {
    TextView pJJ;
    ImageView ttT;
    View xGH;
    ImageView xGI;
    MMSwitchBtn zNX;
    
    public a(View paramView)
    {
      AppMethodBeat.i(33753);
      this.xGI = ((ImageView)paramView.findViewById(R.h.fJN));
      this.ttT = ((ImageView)paramView.findViewById(R.h.iconIV));
      this.pJJ = ((TextView)paramView.findViewById(R.h.gac));
      this.zNX = ((MMSwitchBtn)paramView.findViewById(R.h.fYx));
      this.xGH = paramView.findViewById(R.h.container);
      AppMethodBeat.o(33753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI.a
 * JD-Core Version:    0.7.0.1
 */