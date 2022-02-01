package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addPoiBtn", "Landroid/widget/ImageView;", "addPoiGroup", "Landroid/widget/RelativeLayout;", "addPoiTip", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "checkLocation", "", "getLocationResult", "data", "Landroid/content/Intent;", "initSafeArea", "name", "", "onActivityResult", "requestCode", "", "resultCode", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"})
public final class b
  implements View.OnClickListener, t
{
  private ViewGroup gqv;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  private final RelativeLayout xzS;
  private final ImageView xzT;
  private final ImageView xzU;
  private csd xzV;
  
  public b(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75464);
    this.gqv = paramViewGroup;
    this.sQE = paramd;
    paramViewGroup = this.gqv.findViewById(2131299279);
    p.g(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_group)");
    this.xzS = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.gqv.findViewById(2131299277);
    p.g(paramViewGroup, "parent.findViewById(R.id.editor_add_location)");
    this.xzT = ((ImageView)paramViewGroup);
    paramViewGroup = this.gqv.findViewById(2131299278);
    p.g(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_check)");
    this.xzU = ((ImageView)paramViewGroup);
    this.xzV = new csd();
    this.xzT.setImageDrawable(ao.k(this.gqv.getContext(), 2131690422, -1));
    paramViewGroup = this.xzU;
    paramd = this.gqv.getContext();
    p.g(paramd, "parent.context");
    paramViewGroup.setImageDrawable(paramd.getResources().getDrawable(2131691035));
    this.xzS.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = ar.ci(this.gqv.getContext());
    int i = paramViewGroup.y;
    i = paramViewGroup.x;
    AppMethodBeat.o(75464);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final void dGj()
  {
    AppMethodBeat.i(75459);
    Intent localIntent = new Intent();
    localIntent.putExtra("get_poi_classify_id", this.xzV.Gnu);
    localIntent.putExtra("get_poi_from_scene", "story");
    localIntent.putExtra("get_city", this.xzV.jde);
    localIntent.putExtra("poi_show_none", true);
    localIntent.putExtra("select_radio_icon_color", "#0E9CE6");
    com.tencent.mm.bs.d.b(this.gqv.getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 2);
    AppMethodBeat.o(75459);
  }
  
  public final String name()
  {
    return "plugin_tip";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75462);
    if ((2 == paramInt1) && (paramInt2 == -1) && (paramIntent != null))
    {
      this.xzV.jDf = bt.bI(paramIntent.getStringExtra("get_poi_name"), "");
      this.xzV.jde = bt.bI(paramIntent.getStringExtra("get_city"), "");
      this.xzV.FOB = paramIntent.getFloatExtra("get_lat", -1000.0F);
      this.xzV.FOA = paramIntent.getFloatExtra("get_lng", -1000.0F);
      this.xzV.Gnu = paramIntent.getStringExtra("get_poi_classify_id");
      if ((!bt.isNullOrNil(this.xzV.jDf)) || (!bt.isNullOrNil(this.xzV.jde)))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label184;
        }
        this.xzU.setVisibility(0);
      }
      for (;;)
      {
        paramIntent = new Bundle();
        paramIntent.putByteArray("PARAM_EDIT_POI_INFO", this.xzV.toByteArray());
        this.sQE.a(d.c.xEE, paramIntent);
        AppMethodBeat.o(75462);
        return;
        paramInt1 = 0;
        break;
        label184:
        this.xzU.setVisibility(8);
      }
    }
    AppMethodBeat.o(75462);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75460);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    dGj();
    paramView = c.xHa;
    c.NN(10);
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75460);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200296);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200296);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75463);
    this.xzV = new csd();
    this.xzU.setVisibility(8);
    AppMethodBeat.o(75463);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75461);
    this.xzS.setVisibility(paramInt);
    AppMethodBeat.o(75461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.b
 * JD-Core Version:    0.7.0.1
 */