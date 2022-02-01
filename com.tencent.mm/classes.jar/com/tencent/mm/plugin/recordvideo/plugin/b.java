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
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addPoiBtn", "Landroid/widget/ImageView;", "addPoiGroup", "Landroid/widget/RelativeLayout;", "addPoiTip", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "checkLocation", "", "getLocationResult", "data", "Landroid/content/Intent;", "initSafeArea", "name", "", "onActivityResult", "requestCode", "", "resultCode", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"})
public final class b
  implements View.OnClickListener, t
{
  private ViewGroup fWU;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d rTT;
  private final RelativeLayout wsb;
  private final ImageView wsc;
  private final ImageView wsd;
  private cna wse;
  
  public b(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75464);
    this.fWU = paramViewGroup;
    this.rTT = paramd;
    paramViewGroup = this.fWU.findViewById(2131299279);
    k.g(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_group)");
    this.wsb = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.fWU.findViewById(2131299277);
    k.g(paramViewGroup, "parent.findViewById(R.id.editor_add_location)");
    this.wsc = ((ImageView)paramViewGroup);
    paramViewGroup = this.fWU.findViewById(2131299278);
    k.g(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_check)");
    this.wsd = ((ImageView)paramViewGroup);
    this.wse = new cna();
    this.wsc.setImageDrawable(am.k(this.fWU.getContext(), 2131690422, -1));
    paramViewGroup = this.wsd;
    paramd = this.fWU.getContext();
    k.g(paramd, "parent.context");
    paramViewGroup.setImageDrawable(paramd.getResources().getDrawable(2131691035));
    this.wsb.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = ap.cl(this.fWU.getContext());
    int i = paramViewGroup.y;
    i = paramViewGroup.x;
    AppMethodBeat.o(75464);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final void dvL()
  {
    AppMethodBeat.i(75459);
    Intent localIntent = new Intent();
    localIntent.putExtra("get_poi_classify_id", this.wse.EFm);
    localIntent.putExtra("get_poi_from_scene", "story");
    localIntent.putExtra("get_city", this.wse.iJV);
    localIntent.putExtra("poi_show_none", true);
    localIntent.putExtra("select_radio_icon_color", "#0E9CE6");
    com.tencent.mm.br.d.b(this.fWU.getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 2);
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
      this.wse.gPy = bs.bG(paramIntent.getStringExtra("get_poi_name"), "");
      this.wse.iJV = bs.bG(paramIntent.getStringExtra("get_city"), "");
      this.wse.Ehu = paramIntent.getFloatExtra("get_lat", -1000.0F);
      this.wse.Eht = paramIntent.getFloatExtra("get_lng", -1000.0F);
      this.wse.EFm = paramIntent.getStringExtra("get_poi_classify_id");
      if ((!bs.isNullOrNil(this.wse.gPy)) || (!bs.isNullOrNil(this.wse.iJV)))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label184;
        }
        this.wsd.setVisibility(0);
      }
      for (;;)
      {
        paramIntent = new Bundle();
        paramIntent.putByteArray("PARAM_EDIT_POI_INFO", this.wse.toByteArray());
        this.rTT.a(d.c.wwv, paramIntent);
        AppMethodBeat.o(75462);
        return;
        paramInt1 = 0;
        break;
        label184:
        this.wsd.setVisibility(8);
      }
    }
    AppMethodBeat.o(75462);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75460);
    dvL();
    paramView = c.wyg;
    c.Mo(10);
    AppMethodBeat.o(75460);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75463);
    this.wse = new cna();
    this.wsd.setVisibility(8);
    AppMethodBeat.o(75463);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75461);
    this.wsb.setVisibility(paramInt);
    AppMethodBeat.o(75461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.b
 * JD-Core Version:    0.7.0.1
 */