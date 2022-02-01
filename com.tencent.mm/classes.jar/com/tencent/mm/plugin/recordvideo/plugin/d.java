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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addPoiBtn", "Landroid/widget/ImageView;", "addPoiGroup", "Landroid/widget/RelativeLayout;", "addPoiTip", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "checkLocation", "", "getLocationResult", "data", "Landroid/content/Intent;", "initSafeArea", "onActivityResult", "requestCode", "", "resultCode", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private final RelativeLayout NJC;
  private final ImageView NJD;
  private final ImageView NJE;
  private enw NJF;
  private ViewGroup parent;
  
  public d(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75464);
    this.parent = paramViewGroup;
    this.GrC = parama;
    paramViewGroup = this.parent.findViewById(b.e.editor_add_location_group);
    s.s(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_group)");
    this.NJC = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.parent.findViewById(b.e.editor_add_location);
    s.s(paramViewGroup, "parent.findViewById(R.id.editor_add_location)");
    this.NJD = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(b.e.editor_add_location_check);
    s.s(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_check)");
    this.NJE = ((ImageView)paramViewGroup);
    this.NJF = new enw();
    this.NJD.setImageDrawable(bb.m(this.parent.getContext(), b.g.icons_filled_location, -1));
    this.NJE.setImageDrawable(this.parent.getContext().getResources().getDrawable(b.g.popvideo_post_selected));
    this.NJC.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = bf.bf(this.parent.getContext());
    int i = paramViewGroup.y;
    i = paramViewGroup.x;
    AppMethodBeat.o(75464);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280542);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280542);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280553);
    s.u(this, "this");
    AppMethodBeat.o(280553);
  }
  
  public final void enT()
  {
    AppMethodBeat.i(75459);
    Intent localIntent = new Intent();
    localIntent.putExtra("get_poi_classify_id", this.NJF.ZWG);
    localIntent.putExtra("get_poi_from_scene", "story");
    localIntent.putExtra("get_city", this.NJF.pSh);
    localIntent.putExtra("poi_show_none", true);
    localIntent.putExtra("select_radio_icon_color", "#0E9CE6");
    com.tencent.mm.br.c.b(this.parent.getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 2);
    l.kK(22, 10);
    AppMethodBeat.o(75459);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280546);
    String str = v.a.b(this);
    AppMethodBeat.o(280546);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75462);
    if ((2 == paramInt1) && (paramInt2 == -1) && (paramIntent != null))
    {
      this.NJF.poiName = Util.nullAs(paramIntent.getStringExtra("get_poi_name"), "");
      this.NJF.pSh = Util.nullAs(paramIntent.getStringExtra("get_city"), "");
      this.NJF.ZaH = paramIntent.getFloatExtra("get_lat", -1000.0F);
      this.NJF.ZaG = paramIntent.getFloatExtra("get_lng", -1000.0F);
      this.NJF.ZWG = paramIntent.getStringExtra("get_poi_classify_id");
      if ((Util.isNullOrNil(this.NJF.poiName)) && (Util.isNullOrNil(this.NJF.pSh))) {
        break label188;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label193;
      }
      this.NJE.setVisibility(0);
    }
    for (;;)
    {
      paramIntent = new Bundle();
      paramIntent.putByteArray("PARAM_EDIT_POI_INFO", this.NJF.toByteArray());
      this.GrC.a(a.c.NOv, paramIntent);
      AppMethodBeat.o(75462);
      return;
      label188:
      paramInt1 = 0;
      break;
      label193:
      this.NJE.setVisibility(8);
    }
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75460);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    localObject = WeChatBrands.Business.Entries.SessionLocation;
    if (localObject != null)
    {
      if (paramView == null) {}
      for (paramView = null; !((WeChatBrands.Business.Entries)localObject).checkAvailable(paramView); paramView = paramView.getContext())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75460);
        return;
      }
    }
    enT();
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agH(10);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75460);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280562);
    s.u(this, "this");
    AppMethodBeat.o(280562);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280567);
    s.u(this, "this");
    AppMethodBeat.o(280567);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280571);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280571);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280577);
    s.u(this, "this");
    AppMethodBeat.o(280577);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280581);
    s.u(this, "this");
    AppMethodBeat.o(280581);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75463);
    this.NJF = new enw();
    this.NJE.setVisibility(8);
    AppMethodBeat.o(75463);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75461);
    s.u((v)this, "this");
    this.NJC.setVisibility(paramInt);
    AppMethodBeat.o(75461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.d
 * JD-Core Version:    0.7.0.1
 */