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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addPoiBtn", "Landroid/widget/ImageView;", "addPoiGroup", "Landroid/widget/RelativeLayout;", "addPoiTip", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "checkLocation", "", "getLocationResult", "data", "Landroid/content/Intent;", "initSafeArea", "name", "", "onActivityResult", "requestCode", "", "resultCode", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"})
public final class b
  implements View.OnClickListener, t
{
  private final RelativeLayout BPR;
  private final ImageView BPS;
  private final ImageView BPT;
  private dlg BPU;
  private ViewGroup parent;
  private d wgr;
  
  public b(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75464);
    this.parent = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.parent.findViewById(2131299865);
    p.g(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_group)");
    this.BPR = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.parent.findViewById(2131299863);
    p.g(paramViewGroup, "parent.findViewById(R.id.editor_add_location)");
    this.BPS = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(2131299864);
    p.g(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_check)");
    this.BPT = ((ImageView)paramViewGroup);
    this.BPU = new dlg();
    this.BPS.setImageDrawable(ar.m(this.parent.getContext(), 2131690589, -1));
    paramViewGroup = this.BPT;
    paramd = this.parent.getContext();
    p.g(paramd, "parent.context");
    paramViewGroup.setImageDrawable(paramd.getResources().getDrawable(2131691336));
    this.BPR.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = au.az(this.parent.getContext());
    int i = paramViewGroup.y;
    i = paramViewGroup.x;
    AppMethodBeat.o(75464);
  }
  
  public final void aSs() {}
  
  public final void eKn()
  {
    AppMethodBeat.i(75459);
    Intent localIntent = new Intent();
    localIntent.putExtra("get_poi_classify_id", this.BPU.LIb);
    localIntent.putExtra("get_poi_from_scene", "story");
    localIntent.putExtra("get_city", this.BPU.kea);
    localIntent.putExtra("poi_show_none", true);
    localIntent.putExtra("select_radio_icon_color", "#0E9CE6");
    com.tencent.mm.br.c.b(this.parent.getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 2);
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
      this.BPU.kHV = Util.nullAs(paramIntent.getStringExtra("get_poi_name"), "");
      this.BPU.kea = Util.nullAs(paramIntent.getStringExtra("get_city"), "");
      this.BPU.LbD = paramIntent.getFloatExtra("get_lat", -1000.0F);
      this.BPU.LbC = paramIntent.getFloatExtra("get_lng", -1000.0F);
      this.BPU.LIb = paramIntent.getStringExtra("get_poi_classify_id");
      if ((!Util.isNullOrNil(this.BPU.kHV)) || (!Util.isNullOrNil(this.BPU.kea)))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label184;
        }
        this.BPT.setVisibility(0);
      }
      for (;;)
      {
        paramIntent = new Bundle();
        paramIntent.putByteArray("PARAM_EDIT_POI_INFO", this.BPU.toByteArray());
        this.wgr.a(d.c.BVc, paramIntent);
        AppMethodBeat.o(75462);
        return;
        paramInt1 = 0;
        break;
        label184:
        this.BPT.setVisibility(8);
      }
    }
    AppMethodBeat.o(75462);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75460);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    localObject = WeChatBrands.Business.Entries.SessionLocation;
    if (localObject != null)
    {
      if (paramView != null) {}
      for (paramView = paramView.getContext(); !((WeChatBrands.Business.Entries)localObject).checkAvailable(paramView); paramView = null)
      {
        a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75460);
        return;
      }
    }
    eKn();
    paramView = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.VI(10);
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75460);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237267);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237267);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75463);
    this.BPU = new dlg();
    this.BPT.setVisibility(8);
    AppMethodBeat.o(75463);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75461);
    this.BPR.setVisibility(paramInt);
    AppMethodBeat.o(75461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.b
 * JD-Core Version:    0.7.0.1
 */