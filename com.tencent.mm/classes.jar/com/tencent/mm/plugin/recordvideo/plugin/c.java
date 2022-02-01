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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addPoiBtn", "Landroid/widget/ImageView;", "addPoiGroup", "Landroid/widget/RelativeLayout;", "addPoiTip", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "checkLocation", "", "getLocationResult", "data", "Landroid/content/Intent;", "initSafeArea", "onActivityResult", "requestCode", "", "resultCode", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"})
public final class c
  implements View.OnClickListener, u
{
  private d APl;
  private final RelativeLayout HMF;
  private final ImageView HMG;
  private final ImageView HMH;
  private duy HMI;
  private ViewGroup parent;
  
  public c(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75464);
    this.parent = paramViewGroup;
    this.APl = paramd;
    paramViewGroup = this.parent.findViewById(b.e.editor_add_location_group);
    p.j(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_group)");
    this.HMF = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.parent.findViewById(b.e.editor_add_location);
    p.j(paramViewGroup, "parent.findViewById(R.id.editor_add_location)");
    this.HMG = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(b.e.editor_add_location_check);
    p.j(paramViewGroup, "parent.findViewById(R.id…ditor_add_location_check)");
    this.HMH = ((ImageView)paramViewGroup);
    this.HMI = new duy();
    this.HMG.setImageDrawable(au.o(this.parent.getContext(), b.g.icons_filled_location, -1));
    paramViewGroup = this.HMH;
    paramd = this.parent.getContext();
    p.j(paramd, "parent.context");
    paramViewGroup.setImageDrawable(paramd.getResources().getDrawable(b.g.popvideo_post_selected));
    this.HMF.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = ax.au(this.parent.getContext());
    int i = paramViewGroup.y;
    i = paramViewGroup.x;
    AppMethodBeat.o(75464);
  }
  
  public final void bbp() {}
  
  public final void fwF()
  {
    AppMethodBeat.i(75459);
    Intent localIntent = new Intent();
    localIntent.putExtra("get_poi_classify_id", this.HMI.SOz);
    localIntent.putExtra("get_poi_from_scene", "story");
    localIntent.putExtra("get_city", this.HMI.mVA);
    localIntent.putExtra("poi_show_none", true);
    localIntent.putExtra("select_radio_icon_color", "#0E9CE6");
    com.tencent.mm.by.c.b(this.parent.getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 2);
    AppMethodBeat.o(75459);
  }
  
  public final String name()
  {
    AppMethodBeat.i(224782);
    String str = getClass().getName();
    AppMethodBeat.o(224782);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75462);
    if ((2 == paramInt1) && (paramInt2 == -1) && (paramIntent != null))
    {
      this.HMI.poiName = Util.nullAs(paramIntent.getStringExtra("get_poi_name"), "");
      this.HMI.mVA = Util.nullAs(paramIntent.getStringExtra("get_city"), "");
      this.HMI.ScP = paramIntent.getFloatExtra("get_lat", -1000.0F);
      this.HMI.ScO = paramIntent.getFloatExtra("get_lng", -1000.0F);
      this.HMI.SOz = paramIntent.getStringExtra("get_poi_classify_id");
      if ((!Util.isNullOrNil(this.HMI.poiName)) || (!Util.isNullOrNil(this.HMI.mVA)))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label188;
        }
        this.HMH.setVisibility(0);
      }
      for (;;)
      {
        paramIntent = new Bundle();
        paramIntent.putByteArray("PARAM_EDIT_POI_INFO", this.HMI.toByteArray());
        this.APl.a(d.c.HRP, paramIntent);
        AppMethodBeat.o(75462);
        return;
        paramInt1 = 0;
        break;
        label188:
        this.HMH.setVisibility(8);
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
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
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
    fwF();
    paramView = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.acr(10);
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75460);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(224786);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(224786);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75463);
    this.HMI = new duy();
    this.HMH.setVisibility(8);
    AppMethodBeat.o(75463);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75461);
    this.HMF.setVisibility(paramInt);
    AppMethodBeat.o(75461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.c
 * JD-Core Version:    0.7.0.1
 */