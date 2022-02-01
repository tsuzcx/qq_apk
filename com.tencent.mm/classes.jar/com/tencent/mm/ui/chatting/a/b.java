package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class b
  extends RecyclerView.a
{
  private long PlX;
  public b PlY;
  private String gAn;
  private com.tencent.mm.av.a.a.c gzE;
  private Context mContext;
  public List<c> opg;
  private boolean qoo;
  public boolean qor;
  private boolean tca;
  public boolean tkA;
  
  public b(Context paramContext, List<c> paramList, String paramString)
  {
    AppMethodBeat.i(35029);
    this.opg = null;
    this.gzE = null;
    this.qoo = true;
    this.tca = false;
    this.tkA = false;
    this.opg = paramList;
    this.gAn = paramString;
    bg.aVF();
    this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
    this.mContext = paramContext;
    kj(paramContext);
    AppMethodBeat.o(35029);
  }
  
  public b(Context paramContext, List<c> paramList, String paramString, long paramLong)
  {
    AppMethodBeat.i(35030);
    this.opg = null;
    this.gzE = null;
    this.qoo = true;
    this.tca = false;
    this.tkA = false;
    this.opg = paramList;
    this.PlX = paramLong;
    this.gAn = paramString;
    bg.aVF();
    this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
    this.tca = true;
    this.mContext = paramContext;
    kj(paramContext);
    AppMethodBeat.o(35030);
  }
  
  private static long Cd(long paramLong)
  {
    AppMethodBeat.i(35037);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.gWr().b(localDate);
    AppMethodBeat.o(35037);
    return paramLong;
  }
  
  private void kj(Context paramContext)
  {
    AppMethodBeat.i(35031);
    c.a locala = new c.a();
    locala.jbi = 1;
    locala.jby = true;
    locala.hZA = (com.tencent.mm.cb.a.jn(paramContext) / 4);
    locala.hZz = (com.tencent.mm.cb.a.jn(paramContext) / 4);
    locala.jbt = 2131100928;
    this.gzE = locala.bdv();
    AppMethodBeat.o(35031);
  }
  
  public final String Cc(long paramLong)
  {
    AppMethodBeat.i(35036);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.gWr().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35036);
    return localObject;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(35033);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494792, paramViewGroup, false));
      AppMethodBeat.o(35033);
      return paramViewGroup;
    }
    paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495048, paramViewGroup, false));
    AppMethodBeat.o(35033);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(35035);
    if (!this.qoo)
    {
      Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.qoo) });
      AppMethodBeat.o(35035);
      return;
    }
    c localc = amx(paramInt);
    if (paramv.auw == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (Cd(amx(paramInt + 1).timeStamp) != Cd(localc.timeStamp)))
      {
        ((a)paramv).jUO.setVisibility(8);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramv).jUO.setVisibility(0);
      ((a)paramv).jUO.setText(Cc(localc.timeStamp));
      if (this.qor)
      {
        ((a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(35035);
      return;
    }
    ((d)paramv).tkI.setTag(Integer.valueOf(paramInt));
    ((d)paramv).tkM.setTag(Integer.valueOf(paramInt));
    if (localc.tkE)
    {
      String str1 = com.tencent.mm.pluginsdk.model.s.bdu(localc.imagePath);
      com.tencent.mm.av.a.a locala = q.bcV();
      String str2 = localc.imagePath;
      ImageView localImageView = ((d)paramv).tkI;
      c.a locala1 = new c.a();
      locala1.fullPath = str1;
      locala1.jbf = true;
      locala.a(str2, localImageView, locala1.bdv());
      if ((!localc.tkD) && (!localc.tkE)) {
        break label438;
      }
      ((d)paramv).tkJ.setVisibility(0);
      ((d)paramv).qog.setVisibility(0);
      ((d)paramv).qog.setText(Util.nullAs(localc.Pma.tkG, ""));
    }
    for (;;)
    {
      if (this.tkA)
      {
        ((d)paramv).tkM.setVisibility(0);
        ((d)paramv).checkBox.setVisibility(0);
        if (h.a.gSp().cE(localc.dTX))
        {
          ((d)paramv).tkK.setVisibility(0);
          ((d)paramv).checkBox.setChecked(true);
          AppMethodBeat.o(35035);
          return;
          q.bcV().a(localc.imagePath, ((d)paramv).tkI, this.gzE);
          break;
          label438:
          ((d)paramv).qog.setVisibility(8);
          ((d)paramv).tkJ.setVisibility(8);
          continue;
        }
        ((d)paramv).tkK.setVisibility(8);
        ((d)paramv).checkBox.setChecked(false);
        AppMethodBeat.o(35035);
        return;
      }
    }
    ((d)paramv).tkM.setVisibility(8);
    ((d)paramv).checkBox.setVisibility(8);
    AppMethodBeat.o(35035);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(35034);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramv).checkBox.setChecked(false);
        ((d)paramv).checkBox.setVisibility(0);
        ((d)paramv).tkM.setVisibility(0);
        AppMethodBeat.o(35034);
        return;
      }
      ((d)paramv).checkBox.setChecked(false);
      ((d)paramv).checkBox.setVisibility(8);
      ((d)paramv).tkM.setVisibility(8);
      AppMethodBeat.o(35034);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(35034);
  }
  
  public final c amx(int paramInt)
  {
    AppMethodBeat.i(35039);
    c localc = (c)this.opg.get(paramInt);
    AppMethodBeat.o(35039);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35038);
    int i = this.opg.size();
    AppMethodBeat.o(35038);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35032);
    paramInt = amx(paramInt).type;
    AppMethodBeat.o(35032);
    return paramInt;
  }
  
  public final class a
    extends RecyclerView.v
  {
    TextView jUO;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35022);
      this.jUO = ((TextView)paramView.findViewById(2131299414));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131303688));
      AppMethodBeat.o(35022);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, b.c paramc, int paramInt);
  }
  
  public static final class c
  {
    public a Pma;
    public ca dTX;
    public String imagePath;
    public long timeStamp;
    boolean tkD;
    boolean tkE;
    public int type;
    
    public c(long paramLong)
    {
      AppMethodBeat.i(35025);
      this.type = 0;
      this.tkE = false;
      this.Pma = new a();
      this.timeStamp = paramLong;
      this.type = 2147483647;
      AppMethodBeat.o(35025);
    }
    
    public c(ca paramca)
    {
      AppMethodBeat.i(35024);
      this.type = 0;
      this.tkE = false;
      this.Pma = new a();
      this.dTX = paramca;
      Object localObject1 = "";
      Object localObject2;
      if ((paramca.cWJ()) || (paramca.cWL()))
      {
        this.tkD = true;
        o.bhj();
        localObject1 = t.Qx(paramca.field_imgPath);
        localObject2 = u.QN(paramca.field_imgPath);
        if (localObject2 != null) {
          this.Pma.tkG = Util.formatSecToMin(((com.tencent.mm.modelvideo.s)localObject2).iFw);
        }
        this.Pma.dXm = k.b.aD(paramca.field_content, paramca.field_reserved);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (paramca.gDr())
        {
          Object localObject4 = k.b.HD(paramca.field_content);
          localObject3 = null;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (((k.b)localObject4).dCK != null)
            {
              localObject2 = localObject3;
              if (((k.b)localObject4).dCK.length() > 0)
              {
                localObject4 = ao.cgO().bdx(((k.b)localObject4).dCK);
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
        this.timeStamp = paramca.field_createTime;
        AppMethodBeat.o(35024);
        return;
        if (paramca.cWK())
        {
          this.tkE = true;
          localObject2 = k.b.HD(paramca.field_content);
          if (localObject2 != null)
          {
            localObject1 = ((k.b)localObject2).thumburl;
            localObject2 = (e)((k.b)localObject2).as(e.class);
            if ((localObject2 != null) && (((e)localObject2).iwi != null)) {
              this.Pma.tkG = Util.formatSecToMin(((e)localObject2).iwi.videoDuration);
            }
          }
        }
        else
        {
          localObject2 = q.bcR().d(paramca.field_imgPath, false, false);
          localObject1 = localObject2;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).endsWith("hd"))
            {
              localObject1 = localObject2;
              if (com.tencent.mm.vfs.s.YS((String)localObject2 + "hd")) {
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
      if ((this.dTX != null) && ((paramObject instanceof ca)) && (paramObject != null))
      {
        if (this.dTX.field_msgId == ((ca)paramObject).field_msgId)
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
      public k.b dXm;
      public String tkG;
      
      a() {}
    }
  }
  
  public final class d
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView qog;
    ImageView tkI;
    View tkJ;
    ImageView tkK;
    View tkL;
    View tkM;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35028);
      this.tkI = ((ImageView)paramView.findViewById(2131302167));
      this.tkJ = paramView.findViewById(2131309835);
      this.tkL = paramView.findViewById(2131307900);
      this.qog = ((TextView)paramView.findViewById(2131309832));
      this.tkK = ((ImageView)paramView.findViewById(2131302170));
      this.checkBox = ((CheckBox)paramView.findViewById(2131304550));
      this.tkM = paramView.findViewById(2131304551);
      this.tkM.setVisibility(8);
      this.checkBox.setVisibility(8);
      this.tkJ.setVisibility(8);
      this.qog.setVisibility(8);
      this.tkL.setVisibility(8);
      this.tkI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35026);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Integer)))
          {
            Log.e("MicroMsg.MediaHistoryGalleryAdapter", "getTag is %s", new Object[] { paramAnonymousView.getTag() });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35026);
            return;
          }
          localObject = b.this.amx(((Integer)paramAnonymousView.getTag()).intValue());
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
      this.tkM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35027);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          boolean bool;
          if (!b.d.this.checkBox.isChecked())
          {
            bool = true;
            if (h.a.gSp().tkt.size() >= 9) {
              break label194;
            }
            b.d.this.checkBox.setChecked(bool);
            if (b.d.this.tkK != null)
            {
              if (bool) {
                break label180;
              }
              b.d.this.tkK.setVisibility(8);
            }
          }
          for (;;)
          {
            if (b.a(b.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = b.this.amx(i);
              b.a(b.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35027);
            return;
            bool = false;
            break;
            label180:
            b.d.this.tkK.setVisibility(0);
            continue;
            label194:
            if (!bool) {
              b.d.this.checkBox.setChecked(false);
            }
          }
        }
      });
      AppMethodBeat.o(35028);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b
 * JD-Core Version:    0.7.0.1
 */