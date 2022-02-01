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
import com.tencent.mm.bc.p;
import com.tencent.mm.bc.t;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends BaseAdapter
{
  private final Activity djj;
  private final ap handler;
  final List<bpi> list;
  private String sOz;
  final Map<Integer, Integer> xjN;
  final Map<Integer, Integer> xjO;
  int xjP;
  int xjQ;
  private final b xjR;
  private final g xjS;
  final a xjT;
  gg xjU;
  
  public f(Activity paramActivity, String paramString, b paramb, a parama)
  {
    AppMethodBeat.i(97707);
    this.list = new ArrayList();
    this.xjN = new HashMap();
    this.xjO = new HashMap();
    this.xjP = 0;
    this.xjQ = 0;
    this.handler = new ap();
    this.sOz = "";
    this.djj = paramActivity;
    this.sOz = paramString;
    this.xjR = paramb;
    this.xjT = parama;
    this.xjS = new g(new g.a()
    {
      public final void a(List<bpi> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, int paramAnonymousInt1, int paramAnonymousInt2, gg paramAnonymousgg)
      {
        AppMethodBeat.i(97702);
        ad.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
        f localf = f.this;
        if ((paramAnonymousList == null) || (paramAnonymousList.size() <= 0))
        {
          AppMethodBeat.o(97702);
          return;
        }
        try
        {
          localf.xjU = ((gg)new gg().parseFrom(paramAnonymousgg.toByteArray()));
          localf.xjT.a(localf.xjU);
          ad.d("MicroMsg.ArtistAdapter", "copy list info");
          j = paramAnonymousList.size();
          localf.list.clear();
          localf.xjN.clear();
          localf.xjO.clear();
          i = 0;
          while (i < j)
          {
            paramAnonymousgg = (bpi)paramAnonymousList.get(i);
            paramAnonymousgg = com.tencent.mm.modelsns.g.a(paramAnonymousgg.Id, paramAnonymousgg.mBH, paramAnonymousgg.Url, paramAnonymousgg.DMQ, paramAnonymousgg.Dzl, paramAnonymousgg.DMR, paramAnonymousgg.Desc);
            localf.list.add(paramAnonymousgg);
            i += 1;
          }
        }
        catch (Exception paramAnonymousgg)
        {
          int j;
          int i;
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ArtistAdapter", paramAnonymousgg, "", new Object[0]);
          }
          paramAnonymousgg = paramAnonymousMap1.keySet().iterator();
          while (paramAnonymousgg.hasNext())
          {
            i = ((Integer)paramAnonymousgg.next()).intValue();
            j = ((Integer)paramAnonymousMap1.get(Integer.valueOf(i))).intValue();
            localf.xjN.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousgg = paramAnonymousMap2.keySet().iterator();
          while (paramAnonymousgg.hasNext())
          {
            i = ((Integer)paramAnonymousgg.next()).intValue();
            j = ((Integer)paramAnonymousMap2.get(Integer.valueOf(i))).intValue();
            localf.xjO.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousList.clear();
          paramAnonymousMap1.clear();
          paramAnonymousMap2.clear();
          localf.xjQ = paramAnonymousInt1;
          localf.xjP = paramAnonymousInt2;
          ad.d("MicroMsg.ArtistAdapter", "reallyCount " + paramAnonymousInt1 + " icount " + paramAnonymousInt2);
          localf.notifyDataSetChanged();
          AppMethodBeat.o(97702);
        }
      }
      
      public final void dyE()
      {
        AppMethodBeat.i(97703);
        f localf = f.this;
        if (localf.xjT != null) {
          localf.xjT.dyF();
        }
        AppMethodBeat.o(97703);
      }
    });
    Wd();
    AppMethodBeat.o(97707);
  }
  
  private void a(int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(97711);
    bpi localbpi = (bpi)getItem(paramInt);
    paramImageView.setVisibility(0);
    f.b.a locala = new f.b.a();
    locala.dpC = "";
    locala.position = paramInt;
    paramImageView.setTag(locala);
    af.dtr().b(localbpi, paramImageView, this.djj.hashCode(), bc.FzF);
    AppMethodBeat.o(97711);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(97708);
    if (this.xjS != null)
    {
      t.azY();
      String str = p.azV();
      ad.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(str)));
      this.xjS.ji(this.sOz, str);
    }
    AppMethodBeat.o(97708);
  }
  
  public final int getCount()
  {
    return this.xjP;
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
      paramView = View.inflate(this.djj, 2131495528, null);
      paramViewGroup.fQp = ((TextView)paramView.findViewById(2131305087));
      paramViewGroup.xkb = ((TextView)paramView.findViewById(2131305088));
      paramViewGroup.xkc = ((ImageView)paramView.findViewById(2131300977));
      paramViewGroup.xkd = ((ImageView)paramView.findViewById(2131300978));
      paramViewGroup.xke = ((ImageView)paramView.findViewById(2131300979));
      paramViewGroup.xkf = ((LinearLayout)paramView.findViewById(2131301456));
      paramViewGroup.xkg = paramView.findViewById(2131301422);
      paramViewGroup.xkc.setOnClickListener(this.xjR.xjW);
      paramViewGroup.xkd.setOnClickListener(this.xjR.xjX);
      paramViewGroup.xke.setOnClickListener(this.xjR.xjY);
      paramView.setTag(paramViewGroup);
      if (this.xjN.get(Integer.valueOf(paramInt)) == null) {
        break label638;
      }
    }
    label342:
    label638:
    for (int i = ((Integer)this.xjN.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      paramViewGroup.xkc.setVisibility(8);
      paramViewGroup.xkd.setVisibility(8);
      paramViewGroup.xke.setVisibility(8);
      paramViewGroup.xkg.setVisibility(8);
      if (paramViewGroup.xjV.sOz.equals("en"))
      {
        paramViewGroup.fQp.setVisibility(8);
        paramViewGroup.xkb.setVisibility(4);
      }
      for (;;)
      {
        if ((i < this.xjQ) && (i != -1)) {
          break label342;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(97710);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        paramViewGroup.fQp.setVisibility(4);
        paramViewGroup.xkb.setVisibility(8);
      }
      if (i - 1 >= 0) {}
      for (String str = ((bpi)getItem(i - 1)).Desc;; str = "")
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.setVisibility(0);
        if (this.xjO.get(Integer.valueOf(paramInt)) != null) {}
        for (paramInt = ((Integer)this.xjO.get(Integer.valueOf(paramInt))).intValue();; paramInt = 1)
        {
          bpi localbpi = (bpi)getItem(i);
          if ((localbpi.Desc.equals("")) || (!localbpi.Desc.equals(str)))
          {
            if (!this.sOz.equals("en")) {
              break label582;
            }
            paramViewGroup.xkb.setVisibility(0);
            paramViewGroup.xkb.setText(localbpi.Desc);
            paramViewGroup.xkg.setVisibility(0);
          }
          for (;;)
          {
            if (paramInt > 0) {
              a(i, paramViewGroup.xkc);
            }
            if (paramInt >= 2) {
              a(i + 1, paramViewGroup.xkd);
            }
            if (paramInt >= 3) {
              a(i + 2, paramViewGroup.xke);
            }
            if (this.xjT == null) {
              break;
            }
            this.xjT.b(this.xjU);
            break;
            paramViewGroup.fQp.setVisibility(0);
            paramViewGroup.fQp.setText(localbpi.Desc);
            paramViewGroup.xkg.setVisibility(0);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(gg paramgg);
    
    public abstract void b(gg paramgg);
    
    public abstract void dyF();
  }
  
  static abstract class b
  {
    View.OnClickListener xjW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97704);
        f.b.this.xjZ = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.xjZ.position;
        f.b.this.Ng(i);
        AppMethodBeat.o(97704);
      }
    };
    View.OnClickListener xjX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97705);
        f.b.this.xjZ = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.xjZ.position;
        f.b.this.Ng(i);
        AppMethodBeat.o(97705);
      }
    };
    View.OnClickListener xjY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97706);
        f.b.this.xjZ = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.xjZ.position;
        f.b.this.Ng(i);
        AppMethodBeat.o(97706);
      }
    };
    public a xjZ = new a();
    
    public abstract void Ng(int paramInt);
    
    public static final class a
    {
      public String dpC;
      public int position;
    }
  }
  
  final class c
  {
    TextView fQp;
    TextView xkb;
    ImageView xkc;
    ImageView xkd;
    ImageView xke;
    LinearLayout xkf;
    View xkg;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f
 * JD-Core Version:    0.7.0.1
 */