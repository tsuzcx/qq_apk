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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addPoiBtn", "Landroid/widget/ImageView;", "addPoiGroup", "Landroid/widget/RelativeLayout;", "addPoiTip", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "checkLocation", "", "getLocationResult", "data", "Landroid/content/Intent;", "initSafeArea", "name", "", "onActivityResult", "requestCode", "", "resultCode", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"})
public final class b
  implements View.OnClickListener, t
{
  private ViewGroup fSZ;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  private final RelativeLayout vjq;
  private final ImageView vjr;
  private final ImageView vjs;
  private chx vjt;
  
  public b(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75464);
    this.fSZ = paramViewGroup;
    this.vjo = paramd;
    paramViewGroup = this.fSZ.findViewById(2131299279);
    k.g(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_group)");
    this.vjq = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.fSZ.findViewById(2131299277);
    k.g(paramViewGroup, "parent.findViewById(R.id.editor_add_location)");
    this.vjr = ((ImageView)paramViewGroup);
    paramViewGroup = this.fSZ.findViewById(2131299278);
    k.g(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_check)");
    this.vjs = ((ImageView)paramViewGroup);
    this.vjt = new chx();
    this.vjr.setImageDrawable(am.i(this.fSZ.getContext(), 2131690422, -1));
    paramViewGroup = this.vjs;
    paramd = this.fSZ.getContext();
    k.g(paramd, "parent.context");
    paramViewGroup.setImageDrawable(paramd.getResources().getDrawable(2131691035));
    this.vjq.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = ap.cf(this.fSZ.getContext());
    int i = paramViewGroup.y;
    i = paramViewGroup.x;
    AppMethodBeat.o(75464);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final void dib()
  {
    AppMethodBeat.i(75459);
    Intent localIntent = new Intent();
    localIntent.putExtra("get_poi_classify_id", this.vjt.DlE);
    localIntent.putExtra("get_poi_from_scene", "story");
    localIntent.putExtra("get_city", this.vjt.ijO);
    localIntent.putExtra("poi_show_none", true);
    localIntent.putExtra("select_radio_icon_color", "#0E9CE6");
    com.tencent.mm.bs.d.b(this.fSZ.getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 2);
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
      this.vjt.goQ = bt.by(paramIntent.getStringExtra("get_poi_name"), "");
      this.vjt.ijO = bt.by(paramIntent.getStringExtra("get_city"), "");
      this.vjt.COJ = paramIntent.getFloatExtra("get_lat", -1000.0F);
      this.vjt.COI = paramIntent.getFloatExtra("get_lng", -1000.0F);
      this.vjt.DlE = paramIntent.getStringExtra("get_poi_classify_id");
      if ((!bt.isNullOrNil(this.vjt.goQ)) || (!bt.isNullOrNil(this.vjt.ijO)))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label184;
        }
        this.vjs.setVisibility(0);
      }
      for (;;)
      {
        paramIntent = new Bundle();
        paramIntent.putByteArray("PARAM_EDIT_POI_INFO", this.vjt.toByteArray());
        this.vjo.a(d.c.vnO, paramIntent);
        AppMethodBeat.o(75462);
        return;
        paramInt1 = 0;
        break;
        label184:
        this.vjs.setVisibility(8);
      }
    }
    AppMethodBeat.o(75462);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75460);
    dib();
    paramView = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.Kp(10);
    AppMethodBeat.o(75460);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75463);
    this.vjt = new chx();
    this.vjs.setVisibility(8);
    AppMethodBeat.o(75463);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75461);
    this.vjq.setVisibility(paramInt);
    AppMethodBeat.o(75461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.b
 * JD-Core Version:    0.7.0.1
 */