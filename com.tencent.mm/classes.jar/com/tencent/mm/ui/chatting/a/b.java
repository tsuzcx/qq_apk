package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.e;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.gallery.n;
import com.tencent.mm.ui.chatting.gallery.n.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class b
  extends RecyclerView.a
{
  private boolean Aet;
  public boolean Anw;
  private long aenl;
  public b aenm;
  private String lMU;
  private com.tencent.mm.modelimage.loader.a.c lMm;
  private Context mContext;
  public List<c> uQh;
  private boolean wQm;
  public boolean wQp;
  private SimpleDateFormat xiR;
  
  public b(Context paramContext, List<c> paramList, String paramString)
  {
    AppMethodBeat.i(35029);
    this.uQh = null;
    this.lMm = null;
    this.wQm = true;
    this.Aet = false;
    this.xiR = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.Anw = false;
    this.uQh = paramList;
    this.lMU = paramString;
    bh.bCz();
    this.wQm = com.tencent.mm.model.c.isSDCardAvailable();
    this.mContext = paramContext;
    nl(paramContext);
    AppMethodBeat.o(35029);
  }
  
  public b(Context paramContext, List<c> paramList, String paramString, long paramLong)
  {
    AppMethodBeat.i(35030);
    this.uQh = null;
    this.lMm = null;
    this.wQm = true;
    this.Aet = false;
    this.xiR = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.Anw = false;
    this.uQh = paramList;
    this.aenl = paramLong;
    this.lMU = paramString;
    bh.bCz();
    this.wQm = com.tencent.mm.model.c.isSDCardAvailable();
    this.Aet = true;
    this.mContext = paramContext;
    nl(paramContext);
    AppMethodBeat.o(35030);
  }
  
  private static long kE(long paramLong)
  {
    AppMethodBeat.i(35037);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.jBw().b(localDate);
    AppMethodBeat.o(35037);
    return paramLong;
  }
  
  private void nl(Context paramContext)
  {
    AppMethodBeat.i(35031);
    c.a locala = new c.a();
    locala.oKs = 1;
    locala.oKJ = true;
    locala.npV = (com.tencent.mm.cd.a.ms(paramContext) / 4);
    locala.npU = (com.tencent.mm.cd.a.ms(paramContext) / 4);
    locala.oKE = R.e.pic_thum_bg_color;
    this.lMm = locala.bKx();
    AppMethodBeat.o(35031);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(254387);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramv).checkBox.setChecked(false);
        ((d)paramv).checkBox.setVisibility(0);
        ((d)paramv).AnN.setVisibility(0);
        AppMethodBeat.o(254387);
        return;
      }
      ((d)paramv).checkBox.setChecked(false);
      ((d)paramv).checkBox.setVisibility(8);
      ((d)paramv).AnN.setVisibility(8);
      AppMethodBeat.o(254387);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(254387);
  }
  
  public final c aBZ(int paramInt)
  {
    AppMethodBeat.i(35039);
    c localc = (c)this.uQh.get(paramInt);
    AppMethodBeat.o(35039);
    return localc;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(254383);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new b.a(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gkn, paramViewGroup, false));
      AppMethodBeat.o(254383);
      return paramViewGroup;
    }
    paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gkv, paramViewGroup, false));
    AppMethodBeat.o(254383);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(254393);
    if (!this.wQm)
    {
      Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.wQm) });
      AppMethodBeat.o(254393);
      return;
    }
    Object localObject = aBZ(paramInt);
    if (paramv.caO == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (kE(aBZ(paramInt + 1).timeStamp) != kE(((c)localObject).timeStamp)))
      {
        ((b.a)paramv).pIJ.setVisibility(8);
        AppMethodBeat.o(254393);
        return;
      }
      ((b.a)paramv).pIJ.setVisibility(0);
      ((b.a)paramv).pIJ.setText(kD(((c)localObject).timeStamp));
      if (this.wQp)
      {
        ((b.a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(254393);
        return;
      }
      ((b.a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(254393);
      return;
    }
    ((d)paramv).cqj.setTag(Integer.valueOf(paramInt));
    ((d)paramv).AnN.setTag(Integer.valueOf(paramInt));
    String str1;
    if (((c)localObject).AnG)
    {
      str1 = com.tencent.mm.pluginsdk.model.y.bpF(((c)localObject).imagePath);
      com.tencent.mm.modelimage.loader.a locala = r.bKe();
      String str2 = ((c)localObject).imagePath;
      ImageView localImageView = ((d)paramv).cqj;
      c.a locala1 = new c.a();
      locala1.fullPath = str1;
      locala1.oKp = true;
      locala.a(str2, localImageView, locala1.bKx());
      if ((!((c)localObject).AnF) && (!((c)localObject).AnG)) {
        break label537;
      }
      ((d)paramv).AnK.setVisibility(0);
      ((d)paramv).wQe.setVisibility(0);
      ((d)paramv).wQe.setText(Util.nullAs(((c)localObject).aeno.AnI, ""));
      label343:
      if (!this.Anw) {
        break label590;
      }
      ((d)paramv).AnN.setVisibility(0);
      ((d)paramv).checkBox.setVisibility(0);
      if (!n.a.jvm().dx(((c)localObject).hTm)) {
        break label564;
      }
      ((d)paramv).AnL.setVisibility(0);
      ((d)paramv).checkBox.setChecked(true);
      label407:
      str1 = this.xiR.format(new Date(((c)localObject).timeStamp));
      str1 = paramInt - 1 + ", " + str1;
      if (!((c)localObject).AnF) {
        break label617;
      }
    }
    label537:
    label564:
    label590:
    label617:
    for (localObject = this.mContext.getResources().getString(R.l.app_field_video) + str1;; localObject = this.mContext.getResources().getString(R.l.app_field_pic) + str1)
    {
      ((d)paramv).cqj.setContentDescription((CharSequence)localObject);
      AppMethodBeat.o(254393);
      return;
      r.bKe().a(((c)localObject).imagePath, ((d)paramv).cqj, this.lMm);
      break;
      ((d)paramv).wQe.setVisibility(8);
      ((d)paramv).AnK.setVisibility(8);
      break label343;
      ((d)paramv).AnL.setVisibility(8);
      ((d)paramv).checkBox.setChecked(false);
      break label407;
      ((d)paramv).AnN.setVisibility(8);
      ((d)paramv).checkBox.setVisibility(8);
      break label407;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35038);
    int i = this.uQh.size();
    AppMethodBeat.o(35038);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35032);
    paramInt = aBZ(paramInt).type;
    AppMethodBeat.o(35032);
    return paramInt;
  }
  
  public final String kD(long paramLong)
  {
    AppMethodBeat.i(35036);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.jBw().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35036);
    return localObject;
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, b.c paramc, int paramInt);
  }
  
  public static final class c
  {
    boolean AnF;
    boolean AnG;
    public a aeno;
    public cc hTm;
    public String imagePath;
    public long timeStamp;
    public int type;
    
    public c(long paramLong)
    {
      AppMethodBeat.i(35025);
      this.type = 0;
      this.AnG = false;
      this.aeno = new a();
      this.timeStamp = paramLong;
      this.type = 2147483647;
      AppMethodBeat.o(35025);
    }
    
    public c(cc paramcc)
    {
      AppMethodBeat.i(35024);
      this.type = 0;
      this.AnG = false;
      this.aeno = new a();
      this.hTm = paramcc;
      Object localObject1 = "";
      Object localObject2;
      if ((paramcc.dSH()) || (paramcc.dSJ()))
      {
        this.AnF = true;
        v.bOh();
        localObject1 = aa.PY(paramcc.field_imgPath);
        localObject2 = ab.Qo(paramcc.field_imgPath);
        if (localObject2 != null) {
          this.aeno.AnI = Util.formatSecToMin(((z)localObject2).omT);
        }
        this.aeno.hWV = k.b.aP(paramcc.field_content, paramcc.field_reserved);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (paramcc.jbK())
        {
          Object localObject4 = k.b.Hf(paramcc.field_content);
          localObject3 = null;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (((k.b)localObject4).hzM != null)
            {
              localObject2 = localObject3;
              if (((k.b)localObject4).hzM.length() > 0)
              {
                localObject4 = as.cWJ().bpI(((k.b)localObject4).hzM);
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
        this.timeStamp = paramcc.getCreateTime();
        AppMethodBeat.o(35024);
        return;
        if (paramcc.dSI())
        {
          this.AnG = true;
          localObject2 = k.b.Hf(paramcc.field_content);
          if (localObject2 != null)
          {
            localObject1 = ((k.b)localObject2).thumburl;
            localObject2 = (e)((k.b)localObject2).aK(e.class);
            if ((localObject2 != null) && (((e)localObject2).nQs != null)) {
              this.aeno.AnI = Util.formatSecToMin(((e)localObject2).nQs.videoDuration);
            }
          }
        }
        else
        {
          localObject2 = r.bKa().d(paramcc.field_imgPath, false, false);
          localObject1 = localObject2;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).endsWith("hd"))
            {
              localObject1 = localObject2;
              if (com.tencent.mm.vfs.y.ZC((String)localObject2 + "hd")) {
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
      if ((this.hTm != null) && ((paramObject instanceof cc)) && (paramObject != null))
      {
        if (this.hTm.field_msgId == ((cc)paramObject).field_msgId)
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
      public String AnI;
      public k.b hWV;
      
      a() {}
    }
  }
  
  public final class d
    extends RecyclerView.v
  {
    View AnK;
    ImageView AnL;
    View AnM;
    View AnN;
    CheckBox checkBox;
    ImageView cqj;
    TextView wQe;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35028);
      this.cqj = ((ImageView)paramView.findViewById(R.h.grid_header_item));
      this.AnK = paramView.findViewById(R.h.video_tips_root);
      this.AnM = paramView.findViewById(R.h.sight_tips_root);
      this.wQe = ((TextView)paramView.findViewById(R.h.video_time_tv));
      this.AnL = ((ImageView)paramView.findViewById(R.h.grid_selected_item_mask));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.media_cbx));
      this.AnN = paramView.findViewById(R.h.media_cbx_clickarea);
      this.AnN.setVisibility(8);
      this.checkBox.setVisibility(8);
      this.AnK.setVisibility(8);
      this.wQe.setVisibility(8);
      this.AnM.setVisibility(8);
      this.cqj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35026);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Integer)))
          {
            Log.e("MicroMsg.MediaHistoryGalleryAdapter", "getTag is %s", new Object[] { paramAnonymousView.getTag() });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35026);
            return;
          }
          localObject = b.this.aBZ(((Integer)paramAnonymousView.getTag()).intValue());
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
      this.AnN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35027);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          boolean bool;
          if (!b.d.this.checkBox.isChecked())
          {
            bool = true;
            if (n.a.jvm().Ann.size() >= 9) {
              break label194;
            }
            b.d.this.checkBox.setChecked(bool);
            if (b.d.this.AnL != null)
            {
              if (bool) {
                break label180;
              }
              b.d.this.AnL.setVisibility(8);
            }
          }
          for (;;)
          {
            if (b.a(b.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = b.this.aBZ(i);
              b.a(b.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35027);
            return;
            bool = false;
            break;
            label180:
            b.d.this.AnL.setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b
 * JD-Core Version:    0.7.0.1
 */