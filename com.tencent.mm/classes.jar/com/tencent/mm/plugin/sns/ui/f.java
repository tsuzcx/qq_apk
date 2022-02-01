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
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends BaseAdapter
{
  private final b EnA;
  private final g EnB;
  final a EnC;
  he EnD;
  final Map<Integer, Integer> Enw;
  final Map<Integer, Integer> Enx;
  int Eny;
  int Enz;
  private final Activity dKq;
  private final MMHandler handler;
  final List<cnb> list;
  private String yFy;
  
  public f(Activity paramActivity, String paramString, b paramb, a parama)
  {
    AppMethodBeat.i(97707);
    this.list = new ArrayList();
    this.Enw = new HashMap();
    this.Enx = new HashMap();
    this.Eny = 0;
    this.Enz = 0;
    this.handler = new MMHandler();
    this.yFy = "";
    this.dKq = paramActivity;
    this.yFy = paramString;
    this.EnA = paramb;
    this.EnC = parama;
    this.EnB = new g(new g.a()
    {
      public final void a(List<cnb> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, int paramAnonymousInt1, int paramAnonymousInt2, he paramAnonymoushe)
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
          localf.EnD = ((he)new he().parseFrom(paramAnonymoushe.toByteArray()));
          localf.EnC.a(localf.EnD);
          Log.d("MicroMsg.ArtistAdapter", "copy list info");
          j = paramAnonymousList.size();
          localf.list.clear();
          localf.Enw.clear();
          localf.Enx.clear();
          i = 0;
          while (i < j)
          {
            paramAnonymoushe = (cnb)paramAnonymousList.get(i);
            paramAnonymoushe = n.a(paramAnonymoushe.Id, paramAnonymoushe.oUv, paramAnonymoushe.Url, paramAnonymoushe.Msz, paramAnonymoushe.Mcw, paramAnonymoushe.MsA, paramAnonymoushe.Desc);
            localf.list.add(paramAnonymoushe);
            i += 1;
          }
        }
        catch (Exception paramAnonymoushe)
        {
          int j;
          int i;
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ArtistAdapter", paramAnonymoushe, "", new Object[0]);
          }
          paramAnonymoushe = paramAnonymousMap1.keySet().iterator();
          while (paramAnonymoushe.hasNext())
          {
            i = ((Integer)paramAnonymoushe.next()).intValue();
            j = ((Integer)paramAnonymousMap1.get(Integer.valueOf(i))).intValue();
            localf.Enw.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymoushe = paramAnonymousMap2.keySet().iterator();
          while (paramAnonymoushe.hasNext())
          {
            i = ((Integer)paramAnonymoushe.next()).intValue();
            j = ((Integer)paramAnonymousMap2.get(Integer.valueOf(i))).intValue();
            localf.Enx.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousList.clear();
          paramAnonymousMap1.clear();
          paramAnonymousMap2.clear();
          localf.Enz = paramAnonymousInt1;
          localf.Eny = paramAnonymousInt2;
          Log.d("MicroMsg.ArtistAdapter", "reallyCount " + paramAnonymousInt1 + " icount " + paramAnonymousInt2);
          localf.notifyDataSetChanged();
          AppMethodBeat.o(97702);
        }
      }
      
      public final void ffi()
      {
        AppMethodBeat.i(97703);
        f localf = f.this;
        if (localf.EnC != null) {
          localf.EnC.ffj();
        }
        AppMethodBeat.o(97703);
      }
    });
    anp();
    AppMethodBeat.o(97707);
  }
  
  private void a(int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(97711);
    cnb localcnb = (cnb)getItem(paramInt);
    paramImageView.setVisibility(0);
    f.b.a locala = new f.b.a();
    locala.dRS = "";
    locala.position = paramInt;
    paramImageView.setTag(locala);
    aj.faL().b(localcnb, paramImageView, this.dKq.hashCode(), bp.Oqt);
    AppMethodBeat.o(97711);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(97708);
    if (this.EnB != null)
    {
      v.bev();
      String str = r.bes();
      Log.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(str)));
      this.EnB.kO(this.yFy, str);
    }
    AppMethodBeat.o(97708);
  }
  
  public final int getCount()
  {
    return this.Eny;
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
      paramView = View.inflate(this.dKq, 2131496416, null);
      paramViewGroup.hbb = ((TextView)paramView.findViewById(2131308244));
      paramViewGroup.EnK = ((TextView)paramView.findViewById(2131308245));
      paramViewGroup.EnL = ((ImageView)paramView.findViewById(2131302614));
      paramViewGroup.EnM = ((ImageView)paramView.findViewById(2131302615));
      paramViewGroup.EnN = ((ImageView)paramView.findViewById(2131302616));
      paramViewGroup.EnO = ((LinearLayout)paramView.findViewById(2131303241));
      paramViewGroup.EnP = paramView.findViewById(2131303198);
      paramViewGroup.EnL.setOnClickListener(this.EnA.EnF);
      paramViewGroup.EnM.setOnClickListener(this.EnA.EnG);
      paramViewGroup.EnN.setOnClickListener(this.EnA.EnH);
      paramView.setTag(paramViewGroup);
      if (this.Enw.get(Integer.valueOf(paramInt)) == null) {
        break label638;
      }
    }
    label342:
    label638:
    for (int i = ((Integer)this.Enw.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      paramViewGroup.EnL.setVisibility(8);
      paramViewGroup.EnM.setVisibility(8);
      paramViewGroup.EnN.setVisibility(8);
      paramViewGroup.EnP.setVisibility(8);
      if (paramViewGroup.EnE.yFy.equals("en"))
      {
        paramViewGroup.hbb.setVisibility(8);
        paramViewGroup.EnK.setVisibility(4);
      }
      for (;;)
      {
        if ((i < this.Enz) && (i != -1)) {
          break label342;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(97710);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        paramViewGroup.hbb.setVisibility(4);
        paramViewGroup.EnK.setVisibility(8);
      }
      if (i - 1 >= 0) {}
      for (String str = ((cnb)getItem(i - 1)).Desc;; str = "")
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.setVisibility(0);
        if (this.Enx.get(Integer.valueOf(paramInt)) != null) {}
        for (paramInt = ((Integer)this.Enx.get(Integer.valueOf(paramInt))).intValue();; paramInt = 1)
        {
          cnb localcnb = (cnb)getItem(i);
          if ((localcnb.Desc.equals("")) || (!localcnb.Desc.equals(str)))
          {
            if (!this.yFy.equals("en")) {
              break label582;
            }
            paramViewGroup.EnK.setVisibility(0);
            paramViewGroup.EnK.setText(localcnb.Desc);
            paramViewGroup.EnP.setVisibility(0);
          }
          for (;;)
          {
            if (paramInt > 0) {
              a(i, paramViewGroup.EnL);
            }
            if (paramInt >= 2) {
              a(i + 1, paramViewGroup.EnM);
            }
            if (paramInt >= 3) {
              a(i + 2, paramViewGroup.EnN);
            }
            if (this.EnC == null) {
              break;
            }
            this.EnC.b(this.EnD);
            break;
            paramViewGroup.hbb.setVisibility(0);
            paramViewGroup.hbb.setText(localcnb.Desc);
            paramViewGroup.EnP.setVisibility(0);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(he paramhe);
    
    public abstract void b(he paramhe);
    
    public abstract void ffj();
  }
  
  static abstract class b
  {
    View.OnClickListener EnF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97704);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.b.this.EnI = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.EnI.position;
        f.b.this.Zt(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97704);
      }
    };
    View.OnClickListener EnG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97705);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.b.this.EnI = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.EnI.position;
        f.b.this.Zt(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97705);
      }
    };
    View.OnClickListener EnH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97706);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.b.this.EnI = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.EnI.position;
        f.b.this.Zt(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97706);
      }
    };
    public a EnI = new a();
    
    public abstract void Zt(int paramInt);
    
    public static final class a
    {
      public String dRS;
      public int position;
    }
  }
  
  final class c
  {
    TextView EnK;
    ImageView EnL;
    ImageView EnM;
    ImageView EnN;
    LinearLayout EnO;
    View EnP;
    TextView hbb;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f
 * JD-Core Version:    0.7.0.1
 */