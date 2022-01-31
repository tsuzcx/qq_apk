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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

final class UnfamiliarContactDetailUI$a
  extends RecyclerView.a
{
  UnfamiliarContactDetailUI$a(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final UnfamiliarContactDetailUI.b Dg(int paramInt)
  {
    AppMethodBeat.i(127657);
    if (UnfamiliarContactDetailUI.f(this.qLi).size() > paramInt)
    {
      localb = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(this.qLi).get(paramInt);
      AppMethodBeat.o(127657);
      return localb;
    }
    UnfamiliarContactDetailUI.b localb = new UnfamiliarContactDetailUI.b(this.qLi, new ad());
    AppMethodBeat.o(127657);
    return localb;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(127654);
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130971049, paramViewGroup, false);
    paramViewGroup = new UnfamiliarContactDetailUI.c(this.qLi, paramViewGroup);
    AppMethodBeat.o(127654);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(127655);
    if ((paramv instanceof UnfamiliarContactDetailUI.c))
    {
      paramv = (UnfamiliarContactDetailUI.c)paramv;
      paramv.qLs.setTag(Integer.valueOf(paramInt));
      paramv.aku.setTag(Integer.valueOf(paramInt));
      Object localObject = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(this.qLi).get(paramInt);
      a.b.c((ImageView)paramv.ejS.getContentView(), ((UnfamiliarContactDetailUI.b)localObject).contact.field_username);
      paramv.kgG.setText(j.b(this.qLi.getContext(), ((UnfamiliarContactDetailUI.b)localObject).elx, paramv.kgG.getTextSize()));
      ImageView localImageView = paramv.qLr;
      int i;
      if (((UnfamiliarContactDetailUI.b)localObject).contact.NZ())
      {
        i = 0;
        localImageView.setVisibility(i);
        localImageView = paramv.qLq;
        localObject = ((UnfamiliarContactDetailUI.b)localObject).contact.field_username;
        if ((n.raT != null) && (UnfamiliarContactDetailUI.n(this.qLi).size() == 0))
        {
          List localList = n.raT.lo(5L);
          UnfamiliarContactDetailUI.n(this.qLi).addAll(localList);
        }
        if (!UnfamiliarContactDetailUI.n(this.qLi).contains(localObject)) {
          break label347;
        }
        i = 0;
        label208:
        localImageView.setVisibility(i);
        if (!UnfamiliarContactDetailUI.m(this.qLi).containsKey(Integer.valueOf(paramInt))) {
          break label353;
        }
        paramv.qLp.setVisibility(0);
        paramv.qLp.setText((CharSequence)UnfamiliarContactDetailUI.m(this.qLi).get(Integer.valueOf(paramInt)));
        label263:
        if (!UnfamiliarContactDetailUI.a(this.qLi)) {
          break label376;
        }
        paramv.qLt.setPadding(paramv.qLt.getPaddingLeft(), paramv.qLt.getPaddingTop(), 0, paramv.qLt.getPaddingBottom());
        if (!UnfamiliarContactDetailUI.b(this.qLi).contains(Integer.valueOf(paramInt))) {
          break label365;
        }
        paramv.mCC.setChecked(true);
      }
      for (;;)
      {
        paramv.qLs.setVisibility(0);
        AppMethodBeat.o(127655);
        return;
        i = 8;
        break;
        label347:
        i = 8;
        break label208;
        label353:
        paramv.qLp.setVisibility(8);
        break label263;
        label365:
        paramv.mCC.setChecked(false);
      }
      label376:
      paramv.qLt.setPadding(paramv.qLt.getPaddingLeft(), paramv.qLt.getPaddingTop(), (int)this.qLi.getResources().getDimension(2131427781), paramv.qLt.getPaddingBottom());
      paramv.qLs.setVisibility(8);
    }
    AppMethodBeat.o(127655);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(127656);
    int i = UnfamiliarContactDetailUI.f(this.qLi).size();
    AppMethodBeat.o(127656);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.a
 * JD-Core Version:    0.7.0.1
 */