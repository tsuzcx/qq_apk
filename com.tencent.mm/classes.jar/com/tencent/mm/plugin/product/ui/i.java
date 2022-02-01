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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class i
  extends BaseAdapter
{
  private c BaP;
  LinkedList<m> BbA;
  AdapterView.OnItemClickListener BbB;
  private Context mContext;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(67026);
    this.mContext = paramContext;
    com.tencent.mm.plugin.product.a.a.eDb();
    this.BaP = com.tencent.mm.plugin.product.a.a.eDc();
    AppMethodBeat.o(67026);
  }
  
  private m Uv(int paramInt)
  {
    AppMethodBeat.i(67028);
    m localm = (m)this.BbA.get(paramInt);
    AppMethodBeat.o(67028);
    return localm;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67027);
    if (this.BbA != null)
    {
      int i = this.BbA.size();
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
    m localm = Uv(paramInt);
    Object localObject2;
    Object localObject1;
    label163:
    int i;
    float f1;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.mContext, 2131495970, null);
      paramViewGroup.BbC = ((TextView)paramView.findViewById(2131304447));
      paramViewGroup.BbD = ((MaxGridView)paramView.findViewById(2131304445));
      paramViewGroup.BbE = new j(this.mContext);
      paramView.setTag(paramViewGroup);
      paramViewGroup.BbC.setText(localm.Baf);
      paramViewGroup.BbD.setOnItemClickListener(this.BbB);
      localObject2 = paramViewGroup.BbE;
      localObject1 = this.BaP;
      Object localObject3 = localm.Bae;
      if (!((c)localObject1).AZj.containsKey(localObject3)) {
        break label303;
      }
      localObject1 = (String)((c)localObject1).AZj.get(localObject3);
      ((j)localObject2).BbG = localm;
      ((j)localObject2).BbH = ((String)localObject1);
      localObject1 = this.mContext;
      localObject3 = localm.Bag;
      i = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 16) * 2;
      localObject2 = ((TextView)((LayoutInflater)((Context)localObject1).getSystemService("layout_inflater")).inflate(2131495969, null)).getPaint();
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
        Log.d("MicroMsg.MallProductImageAdapter", localm.Baf + " numColumns = " + localObject1);
        paramViewGroup.BbD.setColumnWidth(((Integer)((Pair)localObject1).second).intValue());
        paramViewGroup.BbE.notifyDataSetChanged();
        paramViewGroup.BbD.setAdapter(paramViewGroup.BbE);
        AppMethodBeat.o(67029);
        return paramView;
        paramInt -= 1;
        break;
      }
    }
  }
  
  final class a
  {
    public TextView BbC = null;
    public MaxGridView BbD = null;
    public j BbE = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.i
 * JD-Core Version:    0.7.0.1
 */