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
import com.tencent.mm.be.s;
import com.tencent.mm.be.w;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.gs;
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
  private String Ejr;
  final Map<Integer, Integer> KAF;
  final Map<Integer, Integer> KAG;
  int KAH;
  int KAI;
  private final b KAJ;
  private final g KAK;
  final a KAL;
  gs KAM;
  private final Activity fDf;
  private final MMHandler handler;
  final List<cvt> list;
  
  public f(Activity paramActivity, String paramString, b paramb, a parama)
  {
    AppMethodBeat.i(97707);
    this.list = new ArrayList();
    this.KAF = new HashMap();
    this.KAG = new HashMap();
    this.KAH = 0;
    this.KAI = 0;
    this.handler = new MMHandler();
    this.Ejr = "";
    this.fDf = paramActivity;
    this.Ejr = paramString;
    this.KAJ = paramb;
    this.KAL = parama;
    this.KAK = new g(new g.a()
    {
      public final void a(List<cvt> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, int paramAnonymousInt1, int paramAnonymousInt2, gs paramAnonymousgs)
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
          localf.KAM = ((gs)new gs().parseFrom(paramAnonymousgs.toByteArray()));
          localf.KAL.a(localf.KAM);
          Log.d("MicroMsg.ArtistAdapter", "copy list info");
          j = paramAnonymousList.size();
          localf.list.clear();
          localf.KAF.clear();
          localf.KAG.clear();
          i = 0;
          while (i < j)
          {
            paramAnonymousgs = (cvt)paramAnonymousList.get(i);
            paramAnonymousgs = o.a(paramAnonymousgs.Id, paramAnonymousgs.rWu, paramAnonymousgs.Url, paramAnonymousgs.TDF, paramAnonymousgs.TlV, paramAnonymousgs.TDG, paramAnonymousgs.CMB);
            localf.list.add(paramAnonymousgs);
            i += 1;
          }
        }
        catch (Exception paramAnonymousgs)
        {
          int j;
          int i;
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ArtistAdapter", paramAnonymousgs, "", new Object[0]);
          }
          paramAnonymousgs = paramAnonymousMap1.keySet().iterator();
          while (paramAnonymousgs.hasNext())
          {
            i = ((Integer)paramAnonymousgs.next()).intValue();
            j = ((Integer)paramAnonymousMap1.get(Integer.valueOf(i))).intValue();
            localf.KAF.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousgs = paramAnonymousMap2.keySet().iterator();
          while (paramAnonymousgs.hasNext())
          {
            i = ((Integer)paramAnonymousgs.next()).intValue();
            j = ((Integer)paramAnonymousMap2.get(Integer.valueOf(i))).intValue();
            localf.KAG.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousList.clear();
          paramAnonymousMap1.clear();
          paramAnonymousMap2.clear();
          localf.KAI = paramAnonymousInt1;
          localf.KAH = paramAnonymousInt2;
          Log.d("MicroMsg.ArtistAdapter", "reallyCount " + paramAnonymousInt1 + " icount " + paramAnonymousInt2);
          localf.notifyDataSetChanged();
          AppMethodBeat.o(97702);
        }
      }
      
      public final void fTd()
      {
        AppMethodBeat.i(97703);
        f localf = f.this;
        if (localf.KAL != null) {
          localf.KAL.fTe();
        }
        AppMethodBeat.o(97703);
      }
    });
    atr();
    AppMethodBeat.o(97707);
  }
  
  private void a(int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(97711);
    cvt localcvt = (cvt)getItem(paramInt);
    paramImageView.setVisibility(0);
    f.b.a locala = new f.b.a();
    locala.fLp = "";
    locala.position = paramInt;
    paramImageView.setTag(locala);
    aj.fOF().b(localcvt, paramImageView, this.fDf.hashCode(), bp.VGp);
    AppMethodBeat.o(97711);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(97708);
    if (this.KAK != null)
    {
      w.bnU();
      String str = s.bnR();
      Log.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(str)));
      this.KAK.lk(this.Ejr, str);
    }
    AppMethodBeat.o(97708);
  }
  
  public final int getCount()
  {
    return this.KAH;
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
      paramView = View.inflate(this.fDf, i.g.sns_artist_item, null);
      paramViewGroup.jMg = ((TextView)paramView.findViewById(i.f.sns_title));
      paramViewGroup.KAT = ((TextView)paramView.findViewById(i.f.sns_title_en));
      paramViewGroup.KAU = ((ImageView)paramView.findViewById(i.f.img1));
      paramViewGroup.KAV = ((ImageView)paramView.findViewById(i.f.img2));
      paramViewGroup.KAW = ((ImageView)paramView.findViewById(i.f.img3));
      paramViewGroup.KAX = ((LinearLayout)paramView.findViewById(i.f.listener_keeper));
      paramViewGroup.KAY = paramView.findViewById(i.f.line_add);
      paramViewGroup.KAU.setOnClickListener(this.KAJ.KAO);
      paramViewGroup.KAV.setOnClickListener(this.KAJ.KAP);
      paramViewGroup.KAW.setOnClickListener(this.KAJ.KAQ);
      paramView.setTag(paramViewGroup);
      if (this.KAF.get(Integer.valueOf(paramInt)) == null) {
        break label646;
      }
    }
    label646:
    for (int i = ((Integer)this.KAF.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      paramViewGroup.KAU.setVisibility(8);
      paramViewGroup.KAV.setVisibility(8);
      paramViewGroup.KAW.setVisibility(8);
      paramViewGroup.KAY.setVisibility(8);
      if (paramViewGroup.KAN.Ejr.equals("en"))
      {
        paramViewGroup.jMg.setVisibility(8);
        paramViewGroup.KAT.setVisibility(4);
      }
      for (;;)
      {
        if ((i < this.KAI) && (i != -1)) {
          break label350;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(97710);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        paramViewGroup.jMg.setVisibility(4);
        paramViewGroup.KAT.setVisibility(8);
      }
      label350:
      if (i - 1 >= 0) {}
      for (String str = ((cvt)getItem(i - 1)).CMB;; str = "")
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.setVisibility(0);
        if (this.KAG.get(Integer.valueOf(paramInt)) != null) {}
        for (paramInt = ((Integer)this.KAG.get(Integer.valueOf(paramInt))).intValue();; paramInt = 1)
        {
          cvt localcvt = (cvt)getItem(i);
          if ((localcvt.CMB.equals("")) || (!localcvt.CMB.equals(str)))
          {
            if (!this.Ejr.equals("en")) {
              break label590;
            }
            paramViewGroup.KAT.setVisibility(0);
            paramViewGroup.KAT.setText(localcvt.CMB);
            paramViewGroup.KAY.setVisibility(0);
          }
          for (;;)
          {
            if (paramInt > 0) {
              a(i, paramViewGroup.KAU);
            }
            if (paramInt >= 2) {
              a(i + 1, paramViewGroup.KAV);
            }
            if (paramInt >= 3) {
              a(i + 2, paramViewGroup.KAW);
            }
            if (this.KAL == null) {
              break;
            }
            this.KAL.b(this.KAM);
            break;
            label590:
            paramViewGroup.jMg.setVisibility(0);
            paramViewGroup.jMg.setText(localcvt.CMB);
            paramViewGroup.KAY.setVisibility(0);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(gs paramgs);
    
    public abstract void b(gs paramgs);
    
    public abstract void fTe();
  }
  
  static abstract class b
  {
    View.OnClickListener KAO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97704);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        f.b.this.KAR = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.KAR.position;
        f.b.this.agK(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97704);
      }
    };
    View.OnClickListener KAP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97705);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        f.b.this.KAR = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.KAR.position;
        f.b.this.agK(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97705);
      }
    };
    View.OnClickListener KAQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97706);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        f.b.this.KAR = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.KAR.position;
        f.b.this.agK(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97706);
      }
    };
    public a KAR = new a();
    
    public abstract void agK(int paramInt);
    
    public static final class a
    {
      public String fLp;
      public int position;
    }
  }
  
  final class c
  {
    TextView KAT;
    ImageView KAU;
    ImageView KAV;
    ImageView KAW;
    LinearLayout KAX;
    View KAY;
    TextView jMg;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f
 * JD-Core Version:    0.7.0.1
 */