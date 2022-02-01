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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class i
  extends BaseAdapter
{
  private Context mContext;
  LinkedList<m> xdY;
  AdapterView.OnItemClickListener xdZ;
  private c xdn;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(67026);
    this.mContext = paramContext;
    com.tencent.mm.plugin.product.a.a.dCJ();
    this.xdn = com.tencent.mm.plugin.product.a.a.dCK();
    AppMethodBeat.o(67026);
  }
  
  private m Ni(int paramInt)
  {
    AppMethodBeat.i(67028);
    m localm = (m)this.xdY.get(paramInt);
    AppMethodBeat.o(67028);
    return localm;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67027);
    if (this.xdY != null)
    {
      int i = this.xdY.size();
      AppMethodBeat.o(67027);
      return i;
    }
    AppMethodBeat.o(67027);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67029);
    m localm = Ni(paramInt);
    Object localObject2;
    Object localObject1;
    label163:
    int i;
    float f1;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.mContext, 2131495127, null);
      paramViewGroup.xea = ((TextView)paramView.findViewById(2131302108));
      paramViewGroup.xeb = ((MaxGridView)paramView.findViewById(2131302106));
      paramViewGroup.xec = new j(this.mContext);
      paramView.setTag(paramViewGroup);
      paramViewGroup.xea.setText(localm.xcD);
      paramViewGroup.xeb.setOnItemClickListener(this.xdZ);
      localObject2 = paramViewGroup.xec;
      localObject1 = this.xdn;
      Object localObject3 = localm.xcC;
      if (!((c)localObject1).xbH.containsKey(localObject3)) {
        break label303;
      }
      localObject1 = (String)((c)localObject1).xbH.get(localObject3);
      ((j)localObject2).xee = localm;
      ((j)localObject2).xef = ((String)localObject1);
      localObject1 = this.mContext;
      localObject3 = localm.xcE;
      i = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 16) * 2;
      localObject2 = ((TextView)((LayoutInflater)((Context)localObject1).getSystemService("layout_inflater")).inflate(2131495126, null)).getPaint();
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
      paramViewGroup = (a)paramView.getTag();
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
        ae.d("MicroMsg.MallProductImageAdapter", localm.xcD + " numColumns = " + localObject1);
        paramViewGroup.xeb.setColumnWidth(((Integer)((Pair)localObject1).second).intValue());
        paramViewGroup.xec.notifyDataSetChanged();
        paramViewGroup.xeb.setAdapter(paramViewGroup.xec);
        AppMethodBeat.o(67029);
        return paramView;
        paramInt -= 1;
        break;
      }
    }
  }
  
  final class a
  {
    public TextView xea = null;
    public MaxGridView xeb = null;
    public j xec = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.i
 * JD-Core Version:    0.7.0.1
 */