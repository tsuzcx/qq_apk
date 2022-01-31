package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class i
  extends BaseAdapter
{
  private Context mContext;
  private c pvR;
  LinkedList<m> pwC;
  AdapterView.OnItemClickListener pwD;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(44119);
    this.mContext = paramContext;
    com.tencent.mm.plugin.product.a.a.caT();
    this.pvR = com.tencent.mm.plugin.product.a.a.caU();
    AppMethodBeat.o(44119);
  }
  
  private m Bo(int paramInt)
  {
    AppMethodBeat.i(44121);
    m localm = (m)this.pwC.get(paramInt);
    AppMethodBeat.o(44121);
    return localm;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44120);
    if (this.pwC != null)
    {
      int i = this.pwC.size();
      AppMethodBeat.o(44120);
      return i;
    }
    AppMethodBeat.o(44120);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44122);
    m localm = Bo(paramInt);
    Object localObject2;
    Object localObject1;
    label163:
    int i;
    float f1;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new i.a(this);
      paramView = View.inflate(this.mContext, 2130970454, null);
      paramViewGroup.pwE = ((TextView)paramView.findViewById(2131826802));
      paramViewGroup.pwF = ((MaxGridView)paramView.findViewById(2131826803));
      paramViewGroup.pwG = new j(this.mContext);
      paramView.setTag(paramViewGroup);
      paramViewGroup.pwE.setText(localm.pvg);
      paramViewGroup.pwF.setOnItemClickListener(this.pwD);
      localObject2 = paramViewGroup.pwG;
      localObject1 = this.pvR;
      Object localObject3 = localm.pvf;
      if (!((c)localObject1).pui.containsKey(localObject3)) {
        break label303;
      }
      localObject1 = (String)((c)localObject1).pui.get(localObject3);
      ((j)localObject2).pwI = localm;
      ((j)localObject2).pwJ = ((String)localObject1);
      localObject1 = this.mContext;
      localObject3 = localm.pvh;
      i = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 16) * 2;
      localObject2 = ((TextView)((LayoutInflater)((Context)localObject1).getSystemService("layout_inflater")).inflate(2130970453, null)).getPaint();
      f1 = 0.0F;
      localObject3 = ((LinkedList)localObject3).iterator();
      label247:
      if (!((Iterator)localObject3).hasNext()) {
        break label309;
      }
      float f2 = ((TextPaint)localObject2).measureText(((h)((Iterator)localObject3).next()).name);
      if (f1 >= f2) {
        break label514;
      }
      f1 = f2;
    }
    label514:
    for (;;)
    {
      break label247;
      paramViewGroup = (i.a)paramView.getTag();
      break;
      label303:
      localObject1 = null;
      break label163;
      label309:
      int j = (int)f1;
      int k = com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 10);
      localObject2 = new int[4];
      int m = com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 12);
      paramInt = 0;
      while (paramInt < 4)
      {
        localObject2[paramInt] = ((i - m * paramInt) / (paramInt + 1));
        paramInt += 1;
      }
      paramInt = 4;
      if (paramInt > 0) {
        if (j + k * 2 >= localObject2[(paramInt - 1)]) {}
      }
      for (localObject1 = new Pair(Integer.valueOf(paramInt), Integer.valueOf(localObject2[(paramInt - 1)]));; localObject1 = new Pair(Integer.valueOf(1), Integer.valueOf(i)))
      {
        ab.d("MicroMsg.MallProductImageAdapter", localm.pvg + " numColumns = " + localObject1);
        paramViewGroup.pwF.setColumnWidth(((Integer)((Pair)localObject1).second).intValue());
        paramViewGroup.pwG.notifyDataSetChanged();
        paramViewGroup.pwF.setAdapter(paramViewGroup.pwG);
        AppMethodBeat.o(44122);
        return paramView;
        paramInt -= 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.i
 * JD-Core Version:    0.7.0.1
 */