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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends BaseAdapter
{
  private final Activity dsa;
  private final ap handler;
  final List<byn> list;
  private String uZv;
  final Map<Integer, Integer> zNS;
  final Map<Integer, Integer> zNT;
  int zNU;
  int zNV;
  private final b zNW;
  private final g zNX;
  final a zNY;
  gr zNZ;
  
  public f(Activity paramActivity, String paramString, b paramb, a parama)
  {
    AppMethodBeat.i(97707);
    this.list = new ArrayList();
    this.zNS = new HashMap();
    this.zNT = new HashMap();
    this.zNU = 0;
    this.zNV = 0;
    this.handler = new ap();
    this.uZv = "";
    this.dsa = paramActivity;
    this.uZv = paramString;
    this.zNW = paramb;
    this.zNY = parama;
    this.zNX = new g(new g.a()
    {
      public final void a(List<byn> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, int paramAnonymousInt1, int paramAnonymousInt2, gr paramAnonymousgr)
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
          localf.zNZ = ((gr)new gr().parseFrom(paramAnonymousgr.toByteArray()));
          localf.zNY.a(localf.zNZ);
          ad.d("MicroMsg.ArtistAdapter", "copy list info");
          j = paramAnonymousList.size();
          localf.list.clear();
          localf.zNS.clear();
          localf.zNT.clear();
          i = 0;
          while (i < j)
          {
            paramAnonymousgr = (byn)paramAnonymousList.get(i);
            paramAnonymousgr = h.a(paramAnonymousgr.Id, paramAnonymousgr.nEf, paramAnonymousgr.Url, paramAnonymousgr.GSI, paramAnonymousgr.GEe, paramAnonymousgr.GSJ, paramAnonymousgr.Desc);
            localf.list.add(paramAnonymousgr);
            i += 1;
          }
        }
        catch (Exception paramAnonymousgr)
        {
          int j;
          int i;
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ArtistAdapter", paramAnonymousgr, "", new Object[0]);
          }
          paramAnonymousgr = paramAnonymousMap1.keySet().iterator();
          while (paramAnonymousgr.hasNext())
          {
            i = ((Integer)paramAnonymousgr.next()).intValue();
            j = ((Integer)paramAnonymousMap1.get(Integer.valueOf(i))).intValue();
            localf.zNS.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousgr = paramAnonymousMap2.keySet().iterator();
          while (paramAnonymousgr.hasNext())
          {
            i = ((Integer)paramAnonymousgr.next()).intValue();
            j = ((Integer)paramAnonymousMap2.get(Integer.valueOf(i))).intValue();
            localf.zNT.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousList.clear();
          paramAnonymousMap1.clear();
          paramAnonymousMap2.clear();
          localf.zNV = paramAnonymousInt1;
          localf.zNU = paramAnonymousInt2;
          ad.d("MicroMsg.ArtistAdapter", "reallyCount " + paramAnonymousInt1 + " icount " + paramAnonymousInt2);
          localf.notifyDataSetChanged();
          AppMethodBeat.o(97702);
        }
      }
      
      public final void dZq()
      {
        AppMethodBeat.i(97703);
        f localf = f.this;
        if (localf.zNY != null) {
          localf.zNY.dZr();
        }
        AppMethodBeat.o(97703);
      }
    });
    Zu();
    AppMethodBeat.o(97707);
  }
  
  private void a(int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(97711);
    byn localbyn = (byn)getItem(paramInt);
    paramImageView.setVisibility(0);
    f.b.a locala = new f.b.a();
    locala.dzb = "";
    locala.position = paramInt;
    paramImageView.setTag(locala);
    ag.dUb().b(localbyn, paramImageView, this.dsa.hashCode(), bj.ILV);
    AppMethodBeat.o(97711);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(97708);
    if (this.zNX != null)
    {
      t.aJZ();
      String str = p.aJW();
      ad.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(str)));
      this.zNX.jT(this.uZv, str);
    }
    AppMethodBeat.o(97708);
  }
  
  public final int getCount()
  {
    return this.zNU;
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
      paramView = View.inflate(this.dsa, 2131495528, null);
      paramViewGroup.gnM = ((TextView)paramView.findViewById(2131305087));
      paramViewGroup.zOg = ((TextView)paramView.findViewById(2131305088));
      paramViewGroup.zOh = ((ImageView)paramView.findViewById(2131300977));
      paramViewGroup.zOi = ((ImageView)paramView.findViewById(2131300978));
      paramViewGroup.zOj = ((ImageView)paramView.findViewById(2131300979));
      paramViewGroup.zOk = ((LinearLayout)paramView.findViewById(2131301456));
      paramViewGroup.zOl = paramView.findViewById(2131301422);
      paramViewGroup.zOh.setOnClickListener(this.zNW.zOb);
      paramViewGroup.zOi.setOnClickListener(this.zNW.zOc);
      paramViewGroup.zOj.setOnClickListener(this.zNW.zOd);
      paramView.setTag(paramViewGroup);
      if (this.zNS.get(Integer.valueOf(paramInt)) == null) {
        break label638;
      }
    }
    label342:
    label638:
    for (int i = ((Integer)this.zNS.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      paramViewGroup.zOh.setVisibility(8);
      paramViewGroup.zOi.setVisibility(8);
      paramViewGroup.zOj.setVisibility(8);
      paramViewGroup.zOl.setVisibility(8);
      if (paramViewGroup.zOa.uZv.equals("en"))
      {
        paramViewGroup.gnM.setVisibility(8);
        paramViewGroup.zOg.setVisibility(4);
      }
      for (;;)
      {
        if ((i < this.zNV) && (i != -1)) {
          break label342;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(97710);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        paramViewGroup.gnM.setVisibility(4);
        paramViewGroup.zOg.setVisibility(8);
      }
      if (i - 1 >= 0) {}
      for (String str = ((byn)getItem(i - 1)).Desc;; str = "")
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.setVisibility(0);
        if (this.zNT.get(Integer.valueOf(paramInt)) != null) {}
        for (paramInt = ((Integer)this.zNT.get(Integer.valueOf(paramInt))).intValue();; paramInt = 1)
        {
          byn localbyn = (byn)getItem(i);
          if ((localbyn.Desc.equals("")) || (!localbyn.Desc.equals(str)))
          {
            if (!this.uZv.equals("en")) {
              break label582;
            }
            paramViewGroup.zOg.setVisibility(0);
            paramViewGroup.zOg.setText(localbyn.Desc);
            paramViewGroup.zOl.setVisibility(0);
          }
          for (;;)
          {
            if (paramInt > 0) {
              a(i, paramViewGroup.zOh);
            }
            if (paramInt >= 2) {
              a(i + 1, paramViewGroup.zOi);
            }
            if (paramInt >= 3) {
              a(i + 2, paramViewGroup.zOj);
            }
            if (this.zNY == null) {
              break;
            }
            this.zNY.b(this.zNZ);
            break;
            paramViewGroup.gnM.setVisibility(0);
            paramViewGroup.gnM.setText(localbyn.Desc);
            paramViewGroup.zOl.setVisibility(0);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(gr paramgr);
    
    public abstract void b(gr paramgr);
    
    public abstract void dZr();
  }
  
  static abstract class b
  {
    View.OnClickListener zOb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97704);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        f.b.this.zOe = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.zOe.position;
        f.b.this.QR(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97704);
      }
    };
    View.OnClickListener zOc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97705);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        f.b.this.zOe = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.zOe.position;
        f.b.this.QR(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97705);
      }
    };
    View.OnClickListener zOd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97706);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        f.b.this.zOe = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.zOe.position;
        f.b.this.QR(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97706);
      }
    };
    public a zOe = new a();
    
    public abstract void QR(int paramInt);
    
    public static final class a
    {
      public String dzb;
      public int position;
    }
  }
  
  final class c
  {
    TextView gnM;
    TextView zOg;
    ImageView zOh;
    ImageView zOi;
    ImageView zOj;
    LinearLayout zOk;
    View zOl;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f
 * JD-Core Version:    0.7.0.1
 */