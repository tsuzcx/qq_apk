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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelpackage.t;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends BaseAdapter
{
  private String Kca;
  final Map<Integer, Integer> Ram;
  final Map<Integer, Integer> Ran;
  int Rao;
  int Rap;
  private final b Raq;
  private final g Rar;
  final a Ras;
  hl Rat;
  private final Activity hHU;
  private final MMHandler handler;
  final List<dmz> list;
  
  public f(Activity paramActivity, String paramString, b paramb, a parama)
  {
    AppMethodBeat.i(97707);
    this.list = new ArrayList();
    this.Ram = new HashMap();
    this.Ran = new HashMap();
    this.Rao = 0;
    this.Rap = 0;
    this.handler = new MMHandler();
    this.Kca = "";
    this.hHU = paramActivity;
    this.Kca = paramString;
    this.Raq = paramb;
    this.Ras = parama;
    this.Rar = new g(new g.a()
    {
      public final void a(List<dmz> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, int paramAnonymousInt1, int paramAnonymousInt2, hl paramAnonymoushl)
      {
        AppMethodBeat.i(97702);
        Log.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
        f localf = f.this;
        if ((paramAnonymousList == null) || (paramAnonymousList.size() <= 0))
        {
          AppMethodBeat.o(97702);
          return;
        }
        try
        {
          localf.Rat = ((hl)new hl().parseFrom(paramAnonymoushl.toByteArray()));
          localf.Ras.a(localf.Rat);
          Log.d("MicroMsg.ArtistAdapter", "copy list info");
          j = paramAnonymousList.size();
          localf.list.clear();
          localf.Ram.clear();
          localf.Ran.clear();
          i = 0;
          while (i < j)
          {
            paramAnonymoushl = (dmz)paramAnonymousList.get(i);
            paramAnonymoushl = o.a(paramAnonymoushl.Id, paramAnonymoushl.vhJ, paramAnonymoushl.Url, paramAnonymoushl.aaTl, paramAnonymoushl.aazR, paramAnonymoushl.aaTm, paramAnonymoushl.IGG);
            localf.list.add(paramAnonymoushl);
            i += 1;
          }
        }
        catch (Exception paramAnonymoushl)
        {
          int j;
          int i;
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ArtistAdapter", paramAnonymoushl, "", new Object[0]);
          }
          paramAnonymoushl = paramAnonymousMap1.keySet().iterator();
          while (paramAnonymoushl.hasNext())
          {
            i = ((Integer)paramAnonymoushl.next()).intValue();
            j = ((Integer)paramAnonymousMap1.get(Integer.valueOf(i))).intValue();
            localf.Ram.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymoushl = paramAnonymousMap2.keySet().iterator();
          while (paramAnonymoushl.hasNext())
          {
            i = ((Integer)paramAnonymoushl.next()).intValue();
            j = ((Integer)paramAnonymousMap2.get(Integer.valueOf(i))).intValue();
            localf.Ran.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousList.clear();
          paramAnonymousMap1.clear();
          paramAnonymousMap2.clear();
          localf.Rap = paramAnonymousInt1;
          localf.Rao = paramAnonymousInt2;
          Log.d("MicroMsg.ArtistAdapter", "reallyCount " + paramAnonymousInt1 + " icount " + paramAnonymousInt2);
          localf.notifyDataSetChanged();
          AppMethodBeat.o(97702);
        }
      }
      
      public final void hlt()
      {
        AppMethodBeat.i(97703);
        f localf = f.this;
        if (localf.Ras != null) {
          localf.Ras.hlu();
        }
        AppMethodBeat.o(97703);
      }
    });
    aNy();
    AppMethodBeat.o(97707);
  }
  
  private void b(int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(97711);
    dmz localdmz = (dmz)getItem(paramInt);
    paramImageView.setVisibility(0);
    f.b.a locala = new f.b.a();
    locala.hQX = "";
    locala.position = paramInt;
    paramImageView.setTag(locala);
    al.hgy().b(localdmz, paramImageView, this.hHU.hashCode(), br.adkd);
    AppMethodBeat.o(97711);
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(97708);
    if (this.Rar != null)
    {
      u.bLH();
      String str = t.bLE();
      Log.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(str)));
      this.Rar.mT(this.Kca, str);
    }
    AppMethodBeat.o(97708);
  }
  
  public final int getCount()
  {
    return this.Rao;
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
      paramView = View.inflate(this.hHU, b.g.sns_artist_item, null);
      paramViewGroup.mll = ((TextView)paramView.findViewById(b.f.sns_title));
      paramViewGroup.RaA = ((TextView)paramView.findViewById(b.f.sns_title_en));
      paramViewGroup.RaB = ((ImageView)paramView.findViewById(b.f.img1));
      paramViewGroup.RaC = ((ImageView)paramView.findViewById(b.f.img2));
      paramViewGroup.RaD = ((ImageView)paramView.findViewById(b.f.img3));
      paramViewGroup.RaE = ((LinearLayout)paramView.findViewById(b.f.listener_keeper));
      paramViewGroup.RaF = paramView.findViewById(b.f.line_add);
      paramViewGroup.RaB.setOnClickListener(this.Raq.Rav);
      paramViewGroup.RaC.setOnClickListener(this.Raq.Raw);
      paramViewGroup.RaD.setOnClickListener(this.Raq.Rax);
      paramView.setTag(paramViewGroup);
      if (this.Ram.get(Integer.valueOf(paramInt)) == null) {
        break label646;
      }
    }
    label646:
    for (int i = ((Integer)this.Ram.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      paramViewGroup.RaB.setVisibility(8);
      paramViewGroup.RaC.setVisibility(8);
      paramViewGroup.RaD.setVisibility(8);
      paramViewGroup.RaF.setVisibility(8);
      if (paramViewGroup.Rau.Kca.equals("en"))
      {
        paramViewGroup.mll.setVisibility(8);
        paramViewGroup.RaA.setVisibility(4);
      }
      for (;;)
      {
        if ((i < this.Rap) && (i != -1)) {
          break label350;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(97710);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        paramViewGroup.mll.setVisibility(4);
        paramViewGroup.RaA.setVisibility(8);
      }
      label350:
      if (i - 1 >= 0) {}
      for (String str = ((dmz)getItem(i - 1)).IGG;; str = "")
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.setVisibility(0);
        if (this.Ran.get(Integer.valueOf(paramInt)) != null) {}
        for (paramInt = ((Integer)this.Ran.get(Integer.valueOf(paramInt))).intValue();; paramInt = 1)
        {
          dmz localdmz = (dmz)getItem(i);
          if ((localdmz.IGG.equals("")) || (!localdmz.IGG.equals(str)))
          {
            if (!this.Kca.equals("en")) {
              break label590;
            }
            paramViewGroup.RaA.setVisibility(0);
            paramViewGroup.RaA.setText(localdmz.IGG);
            paramViewGroup.RaF.setVisibility(0);
          }
          for (;;)
          {
            if (paramInt > 0) {
              b(i, paramViewGroup.RaB);
            }
            if (paramInt >= 2) {
              b(i + 1, paramViewGroup.RaC);
            }
            if (paramInt >= 3) {
              b(i + 2, paramViewGroup.RaD);
            }
            if (this.Ras == null) {
              break;
            }
            this.Ras.b(this.Rat);
            break;
            label590:
            paramViewGroup.mll.setVisibility(0);
            paramViewGroup.mll.setText(localdmz.IGG);
            paramViewGroup.RaF.setVisibility(0);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(hl paramhl);
    
    public abstract void b(hl paramhl);
    
    public abstract void hlu();
  }
  
  static abstract class b
  {
    View.OnClickListener Rav = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97704);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        f.b.this.Ray = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.Ray.position;
        f.b.this.alD(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97704);
      }
    };
    View.OnClickListener Raw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97705);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        f.b.this.Ray = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.Ray.position;
        f.b.this.alD(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97705);
      }
    };
    View.OnClickListener Rax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97706);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        f.b.this.Ray = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.Ray.position;
        f.b.this.alD(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97706);
      }
    };
    public a Ray = new a();
    
    public abstract void alD(int paramInt);
    
    public static final class a
    {
      public String hQX;
      public int position;
    }
  }
  
  final class c
  {
    TextView RaA;
    ImageView RaB;
    ImageView RaC;
    ImageView RaD;
    LinearLayout RaE;
    View RaF;
    TextView mll;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f
 * JD-Core Version:    0.7.0.1
 */