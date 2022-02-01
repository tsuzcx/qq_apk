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
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.y;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class b
  extends RecyclerView.a
{
  private long JFK;
  public b JFL;
  private com.tencent.mm.aw.a.a.c fSr;
  private String fTa;
  private Context mContext;
  public List<c> mYL;
  private boolean oSO;
  public boolean oSR;
  public boolean rCE;
  private boolean ruj;
  
  public b(Context paramContext, List<c> paramList, String paramString)
  {
    AppMethodBeat.i(35029);
    this.mYL = null;
    this.fSr = null;
    this.oSO = true;
    this.ruj = false;
    this.rCE = false;
    this.mYL = paramList;
    this.fTa = paramString;
    ba.aBQ();
    this.oSO = com.tencent.mm.model.c.isSDCardAvailable();
    this.mContext = paramContext;
    kl(paramContext);
    AppMethodBeat.o(35029);
  }
  
  public b(Context paramContext, List<c> paramList, String paramString, long paramLong)
  {
    AppMethodBeat.i(35030);
    this.mYL = null;
    this.fSr = null;
    this.oSO = true;
    this.ruj = false;
    this.rCE = false;
    this.mYL = paramList;
    this.JFK = paramLong;
    this.fTa = paramString;
    ba.aBQ();
    this.oSO = com.tencent.mm.model.c.isSDCardAvailable();
    this.ruj = true;
    this.mContext = paramContext;
    kl(paramContext);
    AppMethodBeat.o(35030);
  }
  
  private void kl(Context paramContext)
  {
    AppMethodBeat.i(35031);
    c.a locala = new c.a();
    locala.idu = 1;
    locala.idL = true;
    locala.hdS = (com.tencent.mm.cc.a.ip(paramContext) / 4);
    locala.hdR = (com.tencent.mm.cc.a.ip(paramContext) / 4);
    locala.idG = 2131100734;
    this.fSr = locala.aJc();
    AppMethodBeat.o(35031);
  }
  
  private static long tH(long paramLong)
  {
    AppMethodBeat.i(35037);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fJG().b(localDate);
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
    if (!this.oSO)
    {
      ad.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.oSO) });
      AppMethodBeat.o(35035);
      return;
    }
    c localc = adf(paramInt);
    if (paramw.auy == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (tH(adf(paramInt + 1).timeStamp) != tH(localc.timeStamp)))
      {
        ((a)paramw).iUW.setVisibility(8);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramw).iUW.setVisibility(0);
      ((a)paramw).iUW.setText(tG(localc.timeStamp));
      if (this.oSR)
      {
        ((a)paramw).progressBar.setVisibility(0);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramw).progressBar.setVisibility(8);
      AppMethodBeat.o(35035);
      return;
    }
    ((d)paramw).rCL.setTag(Integer.valueOf(paramInt));
    ((d)paramw).rCP.setTag(Integer.valueOf(paramInt));
    if (localc.rCH)
    {
      String str1 = r.aLC(localc.imagePath);
      com.tencent.mm.aw.a.a locala = q.aIJ();
      String str2 = localc.imagePath;
      ImageView localImageView = ((d)paramw).rCL;
      c.a locala1 = new c.a();
      locala1.hdP = str1;
      locala1.idr = true;
      locala.a(str2, localImageView, locala1.aJc());
      if ((!localc.pzW) && (!localc.rCH)) {
        break label438;
      }
      ((d)paramw).rCM.setVisibility(0);
      ((d)paramw).oSG.setVisibility(0);
      ((d)paramw).oSG.setText(bt.bI(localc.JFN.rCJ, ""));
    }
    for (;;)
    {
      if (this.rCE)
      {
        ((d)paramw).rCP.setVisibility(0);
        ((d)paramw).iCK.setVisibility(0);
        if (h.a.fFU().co(localc.dBd))
        {
          ((d)paramw).rCN.setVisibility(0);
          ((d)paramw).iCK.setChecked(true);
          AppMethodBeat.o(35035);
          return;
          q.aIJ().a(localc.imagePath, ((d)paramw).rCL, this.fSr);
          break;
          label438:
          ((d)paramw).oSG.setVisibility(8);
          ((d)paramw).rCM.setVisibility(8);
          continue;
        }
        ((d)paramw).rCN.setVisibility(8);
        ((d)paramw).iCK.setChecked(false);
        AppMethodBeat.o(35035);
        return;
      }
    }
    ((d)paramw).rCP.setVisibility(8);
    ((d)paramw).iCK.setVisibility(8);
    AppMethodBeat.o(35035);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    AppMethodBeat.i(35034);
    if ((paramList != null) && (paramList.size() > 0) && ((paramw instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramw).iCK.setChecked(false);
        ((d)paramw).iCK.setVisibility(0);
        ((d)paramw).rCP.setVisibility(0);
        AppMethodBeat.o(35034);
        return;
      }
      ((d)paramw).iCK.setChecked(false);
      ((d)paramw).iCK.setVisibility(8);
      ((d)paramw).rCP.setVisibility(8);
      AppMethodBeat.o(35034);
      return;
    }
    super.a(paramw, paramInt, paramList);
    AppMethodBeat.o(35034);
  }
  
  public final c adf(int paramInt)
  {
    AppMethodBeat.i(35039);
    c localc = (c)this.mYL.get(paramInt);
    AppMethodBeat.o(35039);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35038);
    int i = this.mYL.size();
    AppMethodBeat.o(35038);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35032);
    paramInt = adf(paramInt).type;
    AppMethodBeat.o(35032);
    return paramInt;
  }
  
  public final String tG(long paramLong)
  {
    AppMethodBeat.i(35036);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fJG().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35036);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.w
  {
    TextView iUW;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35022);
      this.iUW = ((TextView)paramView.findViewById(2131298930));
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
    public a JFN;
    public bu dBd;
    public String imagePath;
    boolean pzW;
    boolean rCH;
    public long timeStamp;
    public int type;
    
    public c(long paramLong)
    {
      AppMethodBeat.i(35025);
      this.type = 0;
      this.rCH = false;
      this.JFN = new a();
      this.timeStamp = paramLong;
      this.type = 2147483647;
      AppMethodBeat.o(35025);
    }
    
    public c(bu parambu)
    {
      AppMethodBeat.i(35024);
      this.type = 0;
      this.rCH = false;
      this.JFN = new a();
      this.dBd = parambu;
      Object localObject1 = "";
      Object localObject2;
      if ((parambu.cxf()) || (parambu.cxh()))
      {
        this.pzW = true;
        o.aMJ();
        localObject1 = t.Hi(parambu.field_imgPath);
        localObject2 = u.Hy(parambu.field_imgPath);
        if (localObject2 != null) {
          this.JFN.rCJ = bt.qY(((s)localObject2).hHQ);
        }
        this.JFN.dEu = k.b.aA(parambu.field_content, parambu.field_reserved);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (parambu.frK())
        {
          Object localObject4 = k.b.yr(parambu.field_content);
          localObject3 = null;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (((k.b)localObject4).dks != null)
            {
              localObject2 = localObject3;
              if (((k.b)localObject4).dks.length() > 0)
              {
                localObject4 = ao.bIX().aLD(((k.b)localObject4).dks);
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
        this.timeStamp = parambu.field_createTime;
        AppMethodBeat.o(35024);
        return;
        if (parambu.cxg())
        {
          this.rCH = true;
          localObject2 = k.b.yr(parambu.field_content);
          if (localObject2 != null)
          {
            localObject1 = ((k.b)localObject2).thumburl;
            localObject2 = (e)((k.b)localObject2).ao(e.class);
            if ((localObject2 != null) && (((e)localObject2).hzo != null)) {
              this.JFN.rCJ = bt.qY(((e)localObject2).hzo.videoDuration);
            }
          }
        }
        else
        {
          localObject2 = q.aIF().c(parambu.field_imgPath, false, false);
          localObject1 = localObject2;
          if (!bt.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).endsWith("hd"))
            {
              localObject1 = localObject2;
              if (com.tencent.mm.vfs.i.fv((String)localObject2 + "hd")) {
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
      if ((this.dBd != null) && ((paramObject instanceof bu)) && (paramObject != null))
      {
        if (this.dBd.field_msgId == ((bu)paramObject).field_msgId)
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
      public k.b dEu;
      public String rCJ;
      
      a() {}
    }
  }
  
  public final class d
    extends RecyclerView.w
  {
    CheckBox iCK;
    TextView oSG;
    ImageView rCL;
    View rCM;
    ImageView rCN;
    View rCO;
    View rCP;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35028);
      this.rCL = ((ImageView)paramView.findViewById(2131300612));
      this.rCM = paramView.findViewById(2131306404);
      this.rCO = paramView.findViewById(2131304817);
      this.oSG = ((TextView)paramView.findViewById(2131306401));
      this.rCN = ((ImageView)paramView.findViewById(2131300615));
      this.iCK = ((CheckBox)paramView.findViewById(2131302204));
      this.rCP = paramView.findViewById(2131302205);
      this.rCP.setVisibility(8);
      this.iCK.setVisibility(8);
      this.rCM.setVisibility(8);
      this.oSG.setVisibility(8);
      this.rCO.setVisibility(8);
      this.rCL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35026);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Integer)))
          {
            ad.e("MicroMsg.MediaHistoryGalleryAdapter", "getTag is %s", new Object[] { paramAnonymousView.getTag() });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35026);
            return;
          }
          localObject = b.this.adf(((Integer)paramAnonymousView.getTag()).intValue());
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
      this.rCP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35027);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          boolean bool;
          if (!b.d.this.iCK.isChecked())
          {
            bool = true;
            if (h.a.fFU().rCx.size() >= 9) {
              break label194;
            }
            b.d.this.iCK.setChecked(bool);
            if (b.d.this.rCN != null)
            {
              if (bool) {
                break label180;
              }
              b.d.this.rCN.setVisibility(8);
            }
          }
          for (;;)
          {
            if (b.a(b.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = b.this.adf(i);
              b.a(b.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35027);
            return;
            bool = false;
            break;
            label180:
            b.d.this.rCN.setVisibility(0);
            continue;
            label194:
            if (!bool) {
              b.d.this.iCK.setChecked(false);
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