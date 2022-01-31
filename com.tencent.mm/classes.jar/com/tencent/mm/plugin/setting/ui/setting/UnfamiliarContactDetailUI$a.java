package com.tencent.mm.plugin.setting.ui.setting;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

final class UnfamiliarContactDetailUI$a
  extends RecyclerView.a
{
  UnfamiliarContactDetailUI$a(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.g.unfamiliar_contact_item_layout, paramViewGroup, false);
    return new UnfamiliarContactDetailUI.c(this.nWX, paramViewGroup);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    int i;
    if ((paramv instanceof UnfamiliarContactDetailUI.c))
    {
      paramv = (UnfamiliarContactDetailUI.c)paramv;
      paramv.nXi.setTag(Integer.valueOf(paramInt));
      paramv.aie.setTag(Integer.valueOf(paramInt));
      Object localObject = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(this.nWX).get(paramInt);
      a.b.a((ImageView)paramv.dsk.getContentView(), ((UnfamiliarContactDetailUI.b)localObject).dnp.field_username);
      paramv.nXe.setText(j.a(this.nWX.mController.uMN, ((UnfamiliarContactDetailUI.b)localObject).dtK, paramv.nXe.getTextSize()));
      ImageView localImageView = paramv.nXh;
      if (!((UnfamiliarContactDetailUI.b)localObject).dnp.Bk()) {
        break label334;
      }
      i = 0;
      localImageView.setVisibility(i);
      localImageView = paramv.nXg;
      localObject = ((UnfamiliarContactDetailUI.b)localObject).dnp.field_username;
      if ((n.omF != null) && (UnfamiliarContactDetailUI.n(this.nWX).size() == 0))
      {
        List localList = n.omF.fL(5L);
        UnfamiliarContactDetailUI.n(this.nWX).addAll(localList);
      }
      if (!UnfamiliarContactDetailUI.n(this.nWX).contains(localObject)) {
        break label340;
      }
      i = 0;
      label206:
      localImageView.setVisibility(i);
      if (!UnfamiliarContactDetailUI.m(this.nWX).containsKey(Integer.valueOf(paramInt))) {
        break label346;
      }
      paramv.nXf.setVisibility(0);
      paramv.nXf.setText((CharSequence)UnfamiliarContactDetailUI.m(this.nWX).get(Integer.valueOf(paramInt)));
      label261:
      if (!UnfamiliarContactDetailUI.a(this.nWX)) {
        break label369;
      }
      paramv.nXj.setPadding(paramv.nXj.getPaddingLeft(), paramv.nXj.getPaddingTop(), 0, paramv.nXj.getPaddingBottom());
      if (!UnfamiliarContactDetailUI.b(this.nWX).contains(Integer.valueOf(paramInt))) {
        break label358;
      }
      paramv.khV.setChecked(true);
    }
    for (;;)
    {
      paramv.nXi.setVisibility(0);
      return;
      label334:
      i = 8;
      break;
      label340:
      i = 8;
      break label206;
      label346:
      paramv.nXf.setVisibility(8);
      break label261;
      label358:
      paramv.khV.setChecked(false);
    }
    label369:
    paramv.nXj.setPadding(paramv.nXj.getPaddingLeft(), paramv.nXj.getPaddingTop(), (int)this.nWX.getResources().getDimension(a.d.ListPadding), paramv.nXj.getPaddingBottom());
    paramv.nXi.setVisibility(8);
  }
  
  public final int getItemCount()
  {
    return UnfamiliarContactDetailUI.f(this.nWX).size();
  }
  
  public final UnfamiliarContactDetailUI.b xi(int paramInt)
  {
    if (UnfamiliarContactDetailUI.f(this.nWX).size() > paramInt) {
      return (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(this.nWX).get(paramInt);
    }
    return new UnfamiliarContactDetailUI.b(this.nWX, new ad());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.a
 * JD-Core Version:    0.7.0.1
 */