package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.p;
import com.tencent.mm.bb.t;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.bf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends BaseAdapter
{
  private final Activity dgE;
  private final ao handler;
  final List<btz> list;
  private String tWM;
  final Map<Integer, Integer> ywG;
  final Map<Integer, Integer> ywH;
  int ywI;
  int ywJ;
  private final b ywK;
  private final g ywL;
  final a ywM;
  gk ywN;
  
  public f(Activity paramActivity, String paramString, b paramb, a parama)
  {
    AppMethodBeat.i(97707);
    this.list = new ArrayList();
    this.ywG = new HashMap();
    this.ywH = new HashMap();
    this.ywI = 0;
    this.ywJ = 0;
    this.handler = new ao();
    this.tWM = "";
    this.dgE = paramActivity;
    this.tWM = paramString;
    this.ywK = paramb;
    this.ywM = parama;
    this.ywL = new g(new g.a()
    {
      public final void a(List<btz> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, int paramAnonymousInt1, int paramAnonymousInt2, gk paramAnonymousgk)
      {
        AppMethodBeat.i(97702);
        ac.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
        f localf = f.this;
        if ((paramAnonymousList == null) || (paramAnonymousList.size() <= 0))
        {
          AppMethodBeat.o(97702);
          return;
        }
        try
        {
          localf.ywN = ((gk)new gk().parseFrom(paramAnonymousgk.toByteArray()));
          localf.ywM.a(localf.ywN);
          ac.d("MicroMsg.ArtistAdapter", "copy list info");
          j = paramAnonymousList.size();
          localf.list.clear();
          localf.ywG.clear();
          localf.ywH.clear();
          i = 0;
          while (i < j)
          {
            paramAnonymousgk = (btz)paramAnonymousList.get(i);
            paramAnonymousgk = com.tencent.mm.modelsns.g.a(paramAnonymousgk.Id, paramAnonymousgk.ndI, paramAnonymousgk.Url, paramAnonymousgk.Fjh, paramAnonymousgk.EUH, paramAnonymousgk.Fji, paramAnonymousgk.Desc);
            localf.list.add(paramAnonymousgk);
            i += 1;
          }
        }
        catch (Exception paramAnonymousgk)
        {
          int j;
          int i;
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.ArtistAdapter", paramAnonymousgk, "", new Object[0]);
          }
          paramAnonymousgk = paramAnonymousMap1.keySet().iterator();
          while (paramAnonymousgk.hasNext())
          {
            i = ((Integer)paramAnonymousgk.next()).intValue();
            j = ((Integer)paramAnonymousMap1.get(Integer.valueOf(i))).intValue();
            localf.ywG.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousgk = paramAnonymousMap2.keySet().iterator();
          while (paramAnonymousgk.hasNext())
          {
            i = ((Integer)paramAnonymousgk.next()).intValue();
            j = ((Integer)paramAnonymousMap2.get(Integer.valueOf(i))).intValue();
            localf.ywH.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousList.clear();
          paramAnonymousMap1.clear();
          paramAnonymousMap2.clear();
          localf.ywJ = paramAnonymousInt1;
          localf.ywI = paramAnonymousInt2;
          ac.d("MicroMsg.ArtistAdapter", "reallyCount " + paramAnonymousInt1 + " icount " + paramAnonymousInt2);
          localf.notifyDataSetChanged();
          AppMethodBeat.o(97702);
        }
      }
      
      public final void dNb()
      {
        AppMethodBeat.i(97703);
        f localf = f.this;
        if (localf.ywM != null) {
          localf.ywM.dNc();
        }
        AppMethodBeat.o(97703);
      }
    });
    Xb();
    AppMethodBeat.o(97707);
  }
  
  private void a(int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(97711);
    btz localbtz = (btz)getItem(paramInt);
    paramImageView.setVisibility(0);
    f.b.a locala = new f.b.a();
    locala.dnn = "";
    locala.position = paramInt;
    paramImageView.setTag(locala);
    af.dHO().b(localbtz, paramImageView, this.dgE.hashCode(), bf.GYH);
    AppMethodBeat.o(97711);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(97708);
    if (this.ywL != null)
    {
      t.aGO();
      String str = p.aGL();
      ac.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(str)));
      this.ywL.jG(this.tWM, str);
    }
    AppMethodBeat.o(97708);
  }
  
  public final int getCount()
  {
    return this.ywI;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(97709);
    Object localObject = this.list.get(paramInt);
    AppMethodBeat.o(97709);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(97710);
    if (paramView == null)
    {
      paramViewGroup = new c();
      paramView = View.inflate(this.dgE, 2131495528, null);
      paramViewGroup.fUk = ((TextView)paramView.findViewById(2131305087));
      paramViewGroup.ywU = ((TextView)paramView.findViewById(2131305088));
      paramViewGroup.ywV = ((ImageView)paramView.findViewById(2131300977));
      paramViewGroup.ywW = ((ImageView)paramView.findViewById(2131300978));
      paramViewGroup.ywX = ((ImageView)paramView.findViewById(2131300979));
      paramViewGroup.ywY = ((LinearLayout)paramView.findViewById(2131301456));
      paramViewGroup.ywZ = paramView.findViewById(2131301422);
      paramViewGroup.ywV.setOnClickListener(this.ywK.ywP);
      paramViewGroup.ywW.setOnClickListener(this.ywK.ywQ);
      paramViewGroup.ywX.setOnClickListener(this.ywK.ywR);
      paramView.setTag(paramViewGroup);
      if (this.ywG.get(Integer.valueOf(paramInt)) == null) {
        break label638;
      }
    }
    label342:
    label638:
    for (int i = ((Integer)this.ywG.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      paramViewGroup.ywV.setVisibility(8);
      paramViewGroup.ywW.setVisibility(8);
      paramViewGroup.ywX.setVisibility(8);
      paramViewGroup.ywZ.setVisibility(8);
      if (paramViewGroup.ywO.tWM.equals("en"))
      {
        paramViewGroup.fUk.setVisibility(8);
        paramViewGroup.ywU.setVisibility(4);
      }
      for (;;)
      {
        if ((i < this.ywJ) && (i != -1)) {
          break label342;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(97710);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        paramViewGroup.fUk.setVisibility(4);
        paramViewGroup.ywU.setVisibility(8);
      }
      if (i - 1 >= 0) {}
      for (String str = ((btz)getItem(i - 1)).Desc;; str = "")
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.setVisibility(0);
        if (this.ywH.get(Integer.valueOf(paramInt)) != null) {}
        for (paramInt = ((Integer)this.ywH.get(Integer.valueOf(paramInt))).intValue();; paramInt = 1)
        {
          btz localbtz = (btz)getItem(i);
          if ((localbtz.Desc.equals("")) || (!localbtz.Desc.equals(str)))
          {
            if (!this.tWM.equals("en")) {
              break label582;
            }
            paramViewGroup.ywU.setVisibility(0);
            paramViewGroup.ywU.setText(localbtz.Desc);
            paramViewGroup.ywZ.setVisibility(0);
          }
          for (;;)
          {
            if (paramInt > 0) {
              a(i, paramViewGroup.ywV);
            }
            if (paramInt >= 2) {
              a(i + 1, paramViewGroup.ywW);
            }
            if (paramInt >= 3) {
              a(i + 2, paramViewGroup.ywX);
            }
            if (this.ywM == null) {
              break;
            }
            this.ywM.b(this.ywN);
            break;
            paramViewGroup.fUk.setVisibility(0);
            paramViewGroup.fUk.setText(localbtz.Desc);
            paramViewGroup.ywZ.setVisibility(0);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(gk paramgk);
    
    public abstract void b(gk paramgk);
    
    public abstract void dNc();
  }
  
  static abstract class b
  {
    View.OnClickListener ywP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97704);
        f.b.this.ywS = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.ywS.position;
        f.b.this.Pj(i);
        AppMethodBeat.o(97704);
      }
    };
    View.OnClickListener ywQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97705);
        f.b.this.ywS = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.ywS.position;
        f.b.this.Pj(i);
        AppMethodBeat.o(97705);
      }
    };
    View.OnClickListener ywR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97706);
        f.b.this.ywS = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.ywS.position;
        f.b.this.Pj(i);
        AppMethodBeat.o(97706);
      }
    };
    public a ywS = new a();
    
    public abstract void Pj(int paramInt);
    
    public static final class a
    {
      public String dnn;
      public int position;
    }
  }
  
  final class c
  {
    TextView fUk;
    TextView ywU;
    ImageView ywV;
    ImageView ywW;
    ImageView ywX;
    LinearLayout ywY;
    View ywZ;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f
 * JD-Core Version:    0.7.0.1
 */