package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.y;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class b
  extends RecyclerView.a
{
  private long KaB;
  public b KaC;
  private com.tencent.mm.av.a.a.c fUx;
  private String fVg;
  private Context mContext;
  public List<c> ndS;
  private boolean oZq;
  public boolean oZt;
  private boolean rCv;
  public boolean rKP;
  
  public b(Context paramContext, List<c> paramList, String paramString)
  {
    AppMethodBeat.i(35029);
    this.ndS = null;
    this.fUx = null;
    this.oZq = true;
    this.rCv = false;
    this.rKP = false;
    this.ndS = paramList;
    this.fVg = paramString;
    bc.aCg();
    this.oZq = com.tencent.mm.model.c.isSDCardAvailable();
    this.mContext = paramContext;
    ks(paramContext);
    AppMethodBeat.o(35029);
  }
  
  public b(Context paramContext, List<c> paramList, String paramString, long paramLong)
  {
    AppMethodBeat.i(35030);
    this.ndS = null;
    this.fUx = null;
    this.oZq = true;
    this.rCv = false;
    this.rKP = false;
    this.ndS = paramList;
    this.KaB = paramLong;
    this.fVg = paramString;
    bc.aCg();
    this.oZq = com.tencent.mm.model.c.isSDCardAvailable();
    this.rCv = true;
    this.mContext = paramContext;
    ks(paramContext);
    AppMethodBeat.o(35030);
  }
  
  private void ks(Context paramContext)
  {
    AppMethodBeat.i(35031);
    c.a locala = new c.a();
    locala.ign = 1;
    locala.igD = true;
    locala.hgG = (com.tencent.mm.cb.a.iu(paramContext) / 4);
    locala.hgF = (com.tencent.mm.cb.a.iu(paramContext) / 4);
    locala.igy = 2131100734;
    this.fUx = locala.aJu();
    AppMethodBeat.o(35031);
  }
  
  private static long tY(long paramLong)
  {
    AppMethodBeat.i(35037);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fNX().b(localDate);
    AppMethodBeat.o(35037);
    return paramLong;
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(35033);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494231, paramViewGroup, false));
      AppMethodBeat.o(35033);
      return paramViewGroup;
    }
    paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494459, paramViewGroup, false));
    AppMethodBeat.o(35033);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(35035);
    if (!this.oZq)
    {
      ae.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.oZq) });
      AppMethodBeat.o(35035);
      return;
    }
    c localc = adM(paramInt);
    if (paramw.auy == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (tY(adM(paramInt + 1).timeStamp) != tY(localc.timeStamp)))
      {
        ((a)paramw).iXP.setVisibility(8);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramw).iXP.setVisibility(0);
      ((a)paramw).iXP.setText(tX(localc.timeStamp));
      if (this.oZt)
      {
        ((a)paramw).progressBar.setVisibility(0);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramw).progressBar.setVisibility(8);
      AppMethodBeat.o(35035);
      return;
    }
    ((d)paramw).rKW.setTag(Integer.valueOf(paramInt));
    ((d)paramw).rLa.setTag(Integer.valueOf(paramInt));
    if (localc.rKS)
    {
      String str1 = r.aMY(localc.imagePath);
      com.tencent.mm.av.a.a locala = q.aJb();
      String str2 = localc.imagePath;
      ImageView localImageView = ((d)paramw).rKW;
      c.a locala1 = new c.a();
      locala1.hgD = str1;
      locala1.igk = true;
      locala.a(str2, localImageView, locala1.aJu());
      if ((!localc.pGA) && (!localc.rKS)) {
        break label438;
      }
      ((d)paramw).rKX.setVisibility(0);
      ((d)paramw).oZi.setVisibility(0);
      ((d)paramw).oZi.setText(bu.bI(localc.KaE.rKU, ""));
    }
    for (;;)
    {
      if (this.rKP)
      {
        ((d)paramw).rLa.setVisibility(0);
        ((d)paramw).iFD.setVisibility(0);
        if (h.a.fKb().co(localc.dCi))
        {
          ((d)paramw).rKY.setVisibility(0);
          ((d)paramw).iFD.setChecked(true);
          AppMethodBeat.o(35035);
          return;
          q.aJb().a(localc.imagePath, ((d)paramw).rKW, this.fUx);
          break;
          label438:
          ((d)paramw).oZi.setVisibility(8);
          ((d)paramw).rKX.setVisibility(8);
          continue;
        }
        ((d)paramw).rKY.setVisibility(8);
        ((d)paramw).iFD.setChecked(false);
        AppMethodBeat.o(35035);
        return;
      }
    }
    ((d)paramw).rLa.setVisibility(8);
    ((d)paramw).iFD.setVisibility(8);
    AppMethodBeat.o(35035);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    AppMethodBeat.i(35034);
    if ((paramList != null) && (paramList.size() > 0) && ((paramw instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramw).iFD.setChecked(false);
        ((d)paramw).iFD.setVisibility(0);
        ((d)paramw).rLa.setVisibility(0);
        AppMethodBeat.o(35034);
        return;
      }
      ((d)paramw).iFD.setChecked(false);
      ((d)paramw).iFD.setVisibility(8);
      ((d)paramw).rLa.setVisibility(8);
      AppMethodBeat.o(35034);
      return;
    }
    super.a(paramw, paramInt, paramList);
    AppMethodBeat.o(35034);
  }
  
  public final c adM(int paramInt)
  {
    AppMethodBeat.i(35039);
    c localc = (c)this.ndS.get(paramInt);
    AppMethodBeat.o(35039);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35038);
    int i = this.ndS.size();
    AppMethodBeat.o(35038);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35032);
    paramInt = adM(paramInt).type;
    AppMethodBeat.o(35032);
    return paramInt;
  }
  
  public final String tX(long paramLong)
  {
    AppMethodBeat.i(35036);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fNX().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35036);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.w
  {
    TextView iXP;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35022);
      this.iXP = ((TextView)paramView.findViewById(2131298930));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131301489));
      AppMethodBeat.o(35022);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, b.c paramc, int paramInt);
  }
  
  public static final class c
  {
    public a KaE;
    public bv dCi;
    public String imagePath;
    boolean pGA;
    boolean rKS;
    public long timeStamp;
    public int type;
    
    public c(long paramLong)
    {
      AppMethodBeat.i(35025);
      this.type = 0;
      this.rKS = false;
      this.KaE = new a();
      this.timeStamp = paramLong;
      this.type = 2147483647;
      AppMethodBeat.o(35025);
    }
    
    public c(bv parambv)
    {
      AppMethodBeat.i(35024);
      this.type = 0;
      this.rKS = false;
      this.KaE = new a();
      this.dCi = parambv;
      Object localObject1 = "";
      Object localObject2;
      if ((parambv.cyG()) || (parambv.cyI()))
      {
        this.pGA = true;
        com.tencent.mm.modelvideo.o.aNh();
        localObject1 = t.HK(parambv.field_imgPath);
        localObject2 = u.Ia(parambv.field_imgPath);
        if (localObject2 != null) {
          this.KaE.rKU = bu.rb(((s)localObject2).hKI);
        }
        this.KaE.dFz = k.b.aB(parambv.field_content, parambv.field_reserved);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (parambv.fvK())
        {
          Object localObject4 = k.b.zb(parambv.field_content);
          localObject3 = null;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (((k.b)localObject4).dlu != null)
            {
              localObject2 = localObject3;
              if (((k.b)localObject4).dlu.length() > 0)
              {
                localObject4 = ao.bJV().aMZ(((k.b)localObject4).dlu);
                localObject2 = localObject3;
                if (localObject4 != null) {
                  localObject2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath;
                }
              }
            }
          }
          localObject3 = localObject1;
          if (localObject2 != null) {
            localObject3 = localObject2;
          }
        }
        this.imagePath = localObject3;
        this.timeStamp = parambv.field_createTime;
        AppMethodBeat.o(35024);
        return;
        if (parambv.cyH())
        {
          this.rKS = true;
          localObject2 = k.b.zb(parambv.field_content);
          if (localObject2 != null)
          {
            localObject1 = ((k.b)localObject2).thumburl;
            localObject2 = (e)((k.b)localObject2).ao(e.class);
            if ((localObject2 != null) && (((e)localObject2).hCc != null)) {
              this.KaE.rKU = bu.rb(((e)localObject2).hCc.videoDuration);
            }
          }
        }
        else
        {
          localObject2 = q.aIX().c(parambv.field_imgPath, false, false);
          localObject1 = localObject2;
          if (!bu.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).endsWith("hd"))
            {
              localObject1 = localObject2;
              if (com.tencent.mm.vfs.o.fB((String)localObject2 + "hd")) {
                localObject1 = (String)localObject2 + "hd";
              }
            }
          }
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(35023);
      if ((this.dCi != null) && ((paramObject instanceof bv)) && (paramObject != null))
      {
        if (this.dCi.field_msgId == ((bv)paramObject).field_msgId)
        {
          AppMethodBeat.o(35023);
          return true;
        }
        AppMethodBeat.o(35023);
        return false;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(35023);
      return bool;
    }
    
    final class a
    {
      public k.b dFz;
      public String rKU;
      
      a() {}
    }
  }
  
  public final class d
    extends RecyclerView.w
  {
    CheckBox iFD;
    TextView oZi;
    ImageView rKW;
    View rKX;
    ImageView rKY;
    View rKZ;
    View rLa;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35028);
      this.rKW = ((ImageView)paramView.findViewById(2131300612));
      this.rKX = paramView.findViewById(2131306404);
      this.rKZ = paramView.findViewById(2131304817);
      this.oZi = ((TextView)paramView.findViewById(2131306401));
      this.rKY = ((ImageView)paramView.findViewById(2131300615));
      this.iFD = ((CheckBox)paramView.findViewById(2131302204));
      this.rLa = paramView.findViewById(2131302205);
      this.rLa.setVisibility(8);
      this.iFD.setVisibility(8);
      this.rKX.setVisibility(8);
      this.oZi.setVisibility(8);
      this.rKZ.setVisibility(8);
      this.rKW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35026);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Integer)))
          {
            ae.e("MicroMsg.MediaHistoryGalleryAdapter", "getTag is %s", new Object[] { paramAnonymousView.getTag() });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35026);
            return;
          }
          localObject = b.this.adM(((Integer)paramAnonymousView.getTag()).intValue());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35026);
            return;
          }
          b.a(b.this, paramAnonymousView, (b.c)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(35026);
        }
      });
      this.rLa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35027);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          boolean bool;
          if (!b.d.this.iFD.isChecked())
          {
            bool = true;
            if (h.a.fKb().rKI.size() >= 9) {
              break label194;
            }
            b.d.this.iFD.setChecked(bool);
            if (b.d.this.rKY != null)
            {
              if (bool) {
                break label180;
              }
              b.d.this.rKY.setVisibility(8);
            }
          }
          for (;;)
          {
            if (b.a(b.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = b.this.adM(i);
              b.a(b.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35027);
            return;
            bool = false;
            break;
            label180:
            b.d.this.rKY.setVisibility(0);
            continue;
            label194:
            if (!bool) {
              b.d.this.iFD.setChecked(false);
            }
          }
        }
      });
      AppMethodBeat.o(35028);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b
 * JD-Core Version:    0.7.0.1
 */