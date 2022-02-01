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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends BaseAdapter
{
  final Map<Integer, Integer> AeZ;
  final Map<Integer, Integer> Afa;
  int Afb;
  int Afc;
  private final b Afd;
  private final g Afe;
  final a Aff;
  gr Afg;
  private final Activity dtg;
  private final aq handler;
  final List<bzh> list;
  private String vlG;
  
  public f(Activity paramActivity, String paramString, b paramb, a parama)
  {
    AppMethodBeat.i(97707);
    this.list = new ArrayList();
    this.AeZ = new HashMap();
    this.Afa = new HashMap();
    this.Afb = 0;
    this.Afc = 0;
    this.handler = new aq();
    this.vlG = "";
    this.dtg = paramActivity;
    this.vlG = paramString;
    this.Afd = paramb;
    this.Aff = parama;
    this.Afe = new g(new g.a()
    {
      public final void a(List<bzh> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, int paramAnonymousInt1, int paramAnonymousInt2, gr paramAnonymousgr)
      {
        AppMethodBeat.i(97702);
        ae.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
        f localf = f.this;
        if ((paramAnonymousList == null) || (paramAnonymousList.size() <= 0))
        {
          AppMethodBeat.o(97702);
          return;
        }
        try
        {
          localf.Afg = ((gr)new gr().parseFrom(paramAnonymousgr.toByteArray()));
          localf.Aff.a(localf.Afg);
          ae.d("MicroMsg.ArtistAdapter", "copy list info");
          j = paramAnonymousList.size();
          localf.list.clear();
          localf.AeZ.clear();
          localf.Afa.clear();
          i = 0;
          while (i < j)
          {
            paramAnonymousgr = (bzh)paramAnonymousList.get(i);
            paramAnonymousgr = h.a(paramAnonymousgr.Id, paramAnonymousgr.nJA, paramAnonymousgr.Url, paramAnonymousgr.Hmj, paramAnonymousgr.GXH, paramAnonymousgr.Hmk, paramAnonymousgr.Desc);
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
            ae.printErrStackTrace("MicroMsg.ArtistAdapter", paramAnonymousgr, "", new Object[0]);
          }
          paramAnonymousgr = paramAnonymousMap1.keySet().iterator();
          while (paramAnonymousgr.hasNext())
          {
            i = ((Integer)paramAnonymousgr.next()).intValue();
            j = ((Integer)paramAnonymousMap1.get(Integer.valueOf(i))).intValue();
            localf.AeZ.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousgr = paramAnonymousMap2.keySet().iterator();
          while (paramAnonymousgr.hasNext())
          {
            i = ((Integer)paramAnonymousgr.next()).intValue();
            j = ((Integer)paramAnonymousMap2.get(Integer.valueOf(i))).intValue();
            localf.Afa.put(Integer.valueOf(i), Integer.valueOf(j));
          }
          paramAnonymousList.clear();
          paramAnonymousMap1.clear();
          paramAnonymousMap2.clear();
          localf.Afc = paramAnonymousInt1;
          localf.Afb = paramAnonymousInt2;
          ae.d("MicroMsg.ArtistAdapter", "reallyCount " + paramAnonymousInt1 + " icount " + paramAnonymousInt2);
          localf.notifyDataSetChanged();
          AppMethodBeat.o(97702);
        }
      }
      
      public final void ecV()
      {
        AppMethodBeat.i(97703);
        f localf = f.this;
        if (localf.Aff != null) {
          localf.Aff.ecW();
        }
        AppMethodBeat.o(97703);
      }
    });
    ZD();
    AppMethodBeat.o(97707);
  }
  
  private void a(int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(97711);
    bzh localbzh = (bzh)getItem(paramInt);
    paramImageView.setVisibility(0);
    f.b.a locala = new f.b.a();
    locala.dAg = "";
    locala.position = paramInt;
    paramImageView.setTag(locala);
    ah.dXB().b(localbzh, paramImageView, this.dtg.hashCode(), bk.JgC);
    AppMethodBeat.o(97711);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(97708);
    if (this.Afe != null)
    {
      t.aKs();
      String str = p.aKp();
      ae.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(str)));
      this.Afe.ka(this.vlG, str);
    }
    AppMethodBeat.o(97708);
  }
  
  public final int getCount()
  {
    return this.Afb;
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
      paramView = View.inflate(this.dtg, 2131495528, null);
      paramViewGroup.gqi = ((TextView)paramView.findViewById(2131305087));
      paramViewGroup.Afn = ((TextView)paramView.findViewById(2131305088));
      paramViewGroup.Afo = ((ImageView)paramView.findViewById(2131300977));
      paramViewGroup.Afp = ((ImageView)paramView.findViewById(2131300978));
      paramViewGroup.Afq = ((ImageView)paramView.findViewById(2131300979));
      paramViewGroup.Afr = ((LinearLayout)paramView.findViewById(2131301456));
      paramViewGroup.Afs = paramView.findViewById(2131301422);
      paramViewGroup.Afo.setOnClickListener(this.Afd.Afi);
      paramViewGroup.Afp.setOnClickListener(this.Afd.Afj);
      paramViewGroup.Afq.setOnClickListener(this.Afd.Afk);
      paramView.setTag(paramViewGroup);
      if (this.AeZ.get(Integer.valueOf(paramInt)) == null) {
        break label638;
      }
    }
    label342:
    label638:
    for (int i = ((Integer)this.AeZ.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      paramViewGroup.Afo.setVisibility(8);
      paramViewGroup.Afp.setVisibility(8);
      paramViewGroup.Afq.setVisibility(8);
      paramViewGroup.Afs.setVisibility(8);
      if (paramViewGroup.Afh.vlG.equals("en"))
      {
        paramViewGroup.gqi.setVisibility(8);
        paramViewGroup.Afn.setVisibility(4);
      }
      for (;;)
      {
        if ((i < this.Afc) && (i != -1)) {
          break label342;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(97710);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        paramViewGroup.gqi.setVisibility(4);
        paramViewGroup.Afn.setVisibility(8);
      }
      if (i - 1 >= 0) {}
      for (String str = ((bzh)getItem(i - 1)).Desc;; str = "")
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.setVisibility(0);
        if (this.Afa.get(Integer.valueOf(paramInt)) != null) {}
        for (paramInt = ((Integer)this.Afa.get(Integer.valueOf(paramInt))).intValue();; paramInt = 1)
        {
          bzh localbzh = (bzh)getItem(i);
          if ((localbzh.Desc.equals("")) || (!localbzh.Desc.equals(str)))
          {
            if (!this.vlG.equals("en")) {
              break label582;
            }
            paramViewGroup.Afn.setVisibility(0);
            paramViewGroup.Afn.setText(localbzh.Desc);
            paramViewGroup.Afs.setVisibility(0);
          }
          for (;;)
          {
            if (paramInt > 0) {
              a(i, paramViewGroup.Afo);
            }
            if (paramInt >= 2) {
              a(i + 1, paramViewGroup.Afp);
            }
            if (paramInt >= 3) {
              a(i + 2, paramViewGroup.Afq);
            }
            if (this.Aff == null) {
              break;
            }
            this.Aff.b(this.Afg);
            break;
            paramViewGroup.gqi.setVisibility(0);
            paramViewGroup.gqi.setText(localbzh.Desc);
            paramViewGroup.Afs.setVisibility(0);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(gr paramgr);
    
    public abstract void b(gr paramgr);
    
    public abstract void ecW();
  }
  
  static abstract class b
  {
    View.OnClickListener Afi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97704);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.b.this.Afl = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.Afl.position;
        f.b.this.Ry(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97704);
      }
    };
    View.OnClickListener Afj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97705);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.b.this.Afl = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.Afl.position;
        f.b.this.Ry(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97705);
      }
    };
    View.OnClickListener Afk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97706);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.b.this.Afl = ((f.b.a)paramAnonymousView.getTag());
        int i = f.b.this.Afl.position;
        f.b.this.Ry(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97706);
      }
    };
    public a Afl = new a();
    
    public abstract void Ry(int paramInt);
    
    public static final class a
    {
      public String dAg;
      public int position;
    }
  }
  
  final class c
  {
    TextView Afn;
    ImageView Afo;
    ImageView Afp;
    ImageView Afq;
    LinearLayout Afr;
    View Afs;
    TextView gqi;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f
 * JD-Core Version:    0.7.0.1
 */