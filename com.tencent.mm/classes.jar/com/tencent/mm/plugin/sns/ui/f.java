package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
  extends BaseAdapter
{
  private final Activity cup;
  private final ak handler;
  final List<bcs> list;
  private String nZZ;
  final Map<Integer, Integer> rEd;
  final Map<Integer, Integer> rEe;
  int rEf;
  int rEg;
  private final f.b rEh;
  private final g rEi;
  final f.a rEj;
  fo rEk;
  
  public f(Activity paramActivity, String paramString, f.b paramb, f.a parama)
  {
    AppMethodBeat.i(38086);
    this.list = new ArrayList();
    this.rEd = new HashMap();
    this.rEe = new HashMap();
    this.rEf = 0;
    this.rEg = 0;
    this.handler = new ak();
    this.nZZ = "";
    this.cup = paramActivity;
    this.nZZ = paramString;
    this.rEh = paramb;
    this.rEj = parama;
    this.rEi = new g(new f.1(this));
    Ku();
    AppMethodBeat.o(38086);
  }
  
  private void a(int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(38090);
    bcs localbcs = (bcs)getItem(paramInt);
    paramImageView.setVisibility(0);
    f.b.a locala = new f.b.a();
    locala.czw = "";
    locala.position = paramInt;
    paramImageView.setTag(locala);
    ag.cpc().b(localbcs, paramImageView, this.cup.hashCode(), az.yNU);
    AppMethodBeat.o(38090);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(38087);
    if (this.rEi != null)
    {
      r.aiP();
      String str = n.aiM();
      ab.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(str)));
      this.rEi.gH(this.nZZ, str);
    }
    AppMethodBeat.o(38087);
  }
  
  public final int getCount()
  {
    return this.rEf;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(38088);
    Object localObject = this.list.get(paramInt);
    AppMethodBeat.o(38088);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38089);
    if (paramView == null)
    {
      paramViewGroup = new f.c(this);
      paramView = View.inflate(this.cup, 2130970808, null);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827911));
      paramViewGroup.rEr = ((TextView)paramView.findViewById(2131827912));
      paramViewGroup.rEs = ((ImageView)paramView.findViewById(2131827913));
      paramViewGroup.rEt = ((ImageView)paramView.findViewById(2131827914));
      paramViewGroup.rEu = ((ImageView)paramView.findViewById(2131827915));
      paramViewGroup.rEv = ((LinearLayout)paramView.findViewById(2131827910));
      paramViewGroup.rEw = paramView.findViewById(2131827909);
      paramViewGroup.rEs.setOnClickListener(this.rEh.rEm);
      paramViewGroup.rEt.setOnClickListener(this.rEh.rEn);
      paramViewGroup.rEu.setOnClickListener(this.rEh.rEo);
      paramView.setTag(paramViewGroup);
      if (this.rEd.get(Integer.valueOf(paramInt)) == null) {
        break label638;
      }
    }
    label342:
    label638:
    for (int i = ((Integer)this.rEd.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      paramViewGroup.rEs.setVisibility(8);
      paramViewGroup.rEt.setVisibility(8);
      paramViewGroup.rEu.setVisibility(8);
      paramViewGroup.rEw.setVisibility(8);
      if (paramViewGroup.rEl.nZZ.equals("en"))
      {
        paramViewGroup.gui.setVisibility(8);
        paramViewGroup.rEr.setVisibility(4);
      }
      for (;;)
      {
        if ((i < this.rEg) && (i != -1)) {
          break label342;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(38089);
        return paramView;
        paramViewGroup = (f.c)paramView.getTag();
        break;
        paramViewGroup.gui.setVisibility(4);
        paramViewGroup.rEr.setVisibility(8);
      }
      if (i - 1 >= 0) {}
      for (String str = ((bcs)getItem(i - 1)).Desc;; str = "")
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.setVisibility(0);
        if (this.rEe.get(Integer.valueOf(paramInt)) != null) {}
        for (paramInt = ((Integer)this.rEe.get(Integer.valueOf(paramInt))).intValue();; paramInt = 1)
        {
          bcs localbcs = (bcs)getItem(i);
          if ((localbcs.Desc.equals("")) || (!localbcs.Desc.equals(str)))
          {
            if (!this.nZZ.equals("en")) {
              break label582;
            }
            paramViewGroup.rEr.setVisibility(0);
            paramViewGroup.rEr.setText(localbcs.Desc);
            paramViewGroup.rEw.setVisibility(0);
          }
          for (;;)
          {
            if (paramInt > 0) {
              a(i, paramViewGroup.rEs);
            }
            if (paramInt >= 2) {
              a(i + 1, paramViewGroup.rEt);
            }
            if (paramInt >= 3) {
              a(i + 2, paramViewGroup.rEu);
            }
            if (this.rEj == null) {
              break;
            }
            this.rEj.b(this.rEk);
            break;
            paramViewGroup.gui.setVisibility(0);
            paramViewGroup.gui.setText(localbcs.Desc);
            paramViewGroup.rEw.setVisibility(0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f
 * JD-Core Version:    0.7.0.1
 */