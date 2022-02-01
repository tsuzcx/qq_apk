package com.tencent.mm.ui.chatting.a;

import android.content.Context;
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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.gallery.l;
import com.tencent.mm.ui.chatting.gallery.l.a;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class b
  extends RecyclerView.a
{
  private long WFI;
  public b WFJ;
  private com.tencent.mm.ay.a.a.c jjH;
  private String jkq;
  private Context mContext;
  public List<c> rEV;
  private boolean tMW;
  public boolean tMZ;
  private boolean wIf;
  public boolean wQS;
  
  public b(Context paramContext, List<c> paramList, String paramString)
  {
    AppMethodBeat.i(35029);
    this.rEV = null;
    this.jjH = null;
    this.tMW = true;
    this.wIf = false;
    this.wQS = false;
    this.rEV = paramList;
    this.jkq = paramString;
    bh.beI();
    this.tMW = com.tencent.mm.model.c.isSDCardAvailable();
    this.mContext = paramContext;
    lh(paramContext);
    AppMethodBeat.o(35029);
  }
  
  public b(Context paramContext, List<c> paramList, String paramString, long paramLong)
  {
    AppMethodBeat.i(35030);
    this.rEV = null;
    this.jjH = null;
    this.tMW = true;
    this.wIf = false;
    this.wQS = false;
    this.rEV = paramList;
    this.WFI = paramLong;
    this.jkq = paramString;
    bh.beI();
    this.tMW = com.tencent.mm.model.c.isSDCardAvailable();
    this.wIf = true;
    this.mContext = paramContext;
    lh(paramContext);
    AppMethodBeat.o(35030);
  }
  
  private static long Im(long paramLong)
  {
    AppMethodBeat.i(35037);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.hWZ().b(localDate);
    AppMethodBeat.o(35037);
    return paramLong;
  }
  
  private void lh(Context paramContext)
  {
    AppMethodBeat.i(35031);
    c.a locala = new c.a();
    locala.lRG = 1;
    locala.lRX = true;
    locala.kOg = (com.tencent.mm.ci.a.kr(paramContext) / 4);
    locala.kOf = (com.tencent.mm.ci.a.kr(paramContext) / 4);
    locala.lRS = R.e.pic_thum_bg_color;
    this.jjH = locala.bmL();
    AppMethodBeat.o(35031);
  }
  
  public final String Il(long paramLong)
  {
    AppMethodBeat.i(35036);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.hWZ().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35036);
    return localObject;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(271431);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramv).checkBox.setChecked(false);
        ((d)paramv).checkBox.setVisibility(0);
        ((d)paramv).wRk.setVisibility(0);
        AppMethodBeat.o(271431);
        return;
      }
      ((d)paramv).checkBox.setChecked(false);
      ((d)paramv).checkBox.setVisibility(8);
      ((d)paramv).wRk.setVisibility(8);
      AppMethodBeat.o(271431);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(271431);
  }
  
  public final c avx(int paramInt)
  {
    AppMethodBeat.i(35039);
    c localc = (c)this.rEV.get(paramInt);
    AppMethodBeat.o(35039);
    return localc;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(271430);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ehs, paramViewGroup, false));
      AppMethodBeat.o(271430);
      return paramViewGroup;
    }
    paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ehA, paramViewGroup, false));
    AppMethodBeat.o(271430);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(271432);
    if (!this.tMW)
    {
      Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.tMW) });
      AppMethodBeat.o(271432);
      return;
    }
    c localc = avx(paramInt);
    if (paramv.amo == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (Im(avx(paramInt + 1).timeStamp) != Im(localc.timeStamp)))
      {
        ((a)paramv).mMb.setVisibility(8);
        AppMethodBeat.o(271432);
        return;
      }
      ((a)paramv).mMb.setVisibility(0);
      ((a)paramv).mMb.setText(Il(localc.timeStamp));
      if (this.tMZ)
      {
        ((a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(271432);
        return;
      }
      ((a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(271432);
      return;
    }
    ((d)paramv).wRg.setTag(Integer.valueOf(paramInt));
    ((d)paramv).wRk.setTag(Integer.valueOf(paramInt));
    if (localc.wRc)
    {
      String str1 = com.tencent.mm.pluginsdk.model.w.bpO(localc.imagePath);
      com.tencent.mm.ay.a.a locala = q.bml();
      String str2 = localc.imagePath;
      ImageView localImageView = ((d)paramv).wRg;
      c.a locala1 = new c.a();
      locala1.fullPath = str1;
      locala1.lRD = true;
      locala.a(str2, localImageView, locala1.bmL());
      if ((!localc.wRb) && (!localc.wRc)) {
        break label438;
      }
      ((d)paramv).wRh.setVisibility(0);
      ((d)paramv).tMO.setVisibility(0);
      ((d)paramv).tMO.setText(Util.nullAs(localc.WFL.wRe, ""));
    }
    for (;;)
    {
      if (this.wQS)
      {
        ((d)paramv).wRk.setVisibility(0);
        ((d)paramv).checkBox.setVisibility(0);
        if (l.a.hRO().da(localc.fNz))
        {
          ((d)paramv).wRi.setVisibility(0);
          ((d)paramv).checkBox.setChecked(true);
          AppMethodBeat.o(271432);
          return;
          q.bml().a(localc.imagePath, ((d)paramv).wRg, this.jjH);
          break;
          label438:
          ((d)paramv).tMO.setVisibility(8);
          ((d)paramv).wRh.setVisibility(8);
          continue;
        }
        ((d)paramv).wRi.setVisibility(8);
        ((d)paramv).checkBox.setChecked(false);
        AppMethodBeat.o(271432);
        return;
      }
    }
    ((d)paramv).wRk.setVisibility(8);
    ((d)paramv).checkBox.setVisibility(8);
    AppMethodBeat.o(271432);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35038);
    int i = this.rEV.size();
    AppMethodBeat.o(35038);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35032);
    paramInt = avx(paramInt).type;
    AppMethodBeat.o(35032);
    return paramInt;
  }
  
  public final class a
    extends RecyclerView.v
  {
    TextView mMb;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35022);
      this.mMb = ((TextView)paramView.findViewById(R.h.date_info));
      this.progressBar = ((ProgressBar)paramView.findViewById(R.h.load_progress));
      AppMethodBeat.o(35022);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, b.c paramc, int paramInt);
  }
  
  public static final class c
  {
    public a WFL;
    public ca fNz;
    public String imagePath;
    public long timeStamp;
    public int type;
    boolean wRb;
    boolean wRc;
    
    public c(long paramLong)
    {
      AppMethodBeat.i(35025);
      this.type = 0;
      this.wRc = false;
      this.WFL = new a();
      this.timeStamp = paramLong;
      this.type = 2147483647;
      AppMethodBeat.o(35025);
    }
    
    public c(ca paramca)
    {
      AppMethodBeat.i(35024);
      this.type = 0;
      this.wRc = false;
      this.WFL = new a();
      this.fNz = paramca;
      Object localObject1 = "";
      Object localObject2;
      if ((paramca.dlR()) || (paramca.dlT()))
      {
        this.wRb = true;
        s.bqB();
        localObject1 = x.XU(paramca.field_imgPath);
        localObject2 = com.tencent.mm.modelvideo.y.Yk(paramca.field_imgPath);
        if (localObject2 != null) {
          this.WFL.wRe = Util.formatSecToMin(((com.tencent.mm.modelvideo.w)localObject2).lvw);
        }
        this.WFL.fQY = k.b.aG(paramca.field_content, paramca.field_reserved);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (paramca.hzF())
        {
          Object localObject4 = k.b.OQ(paramca.field_content);
          localObject3 = null;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (((k.b)localObject4).fvr != null)
            {
              localObject2 = localObject3;
              if (((k.b)localObject4).fvr.length() > 0)
              {
                localObject4 = ao.ctZ().bpR(((k.b)localObject4).fvr);
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
        if (paramca.dlS())
        {
          this.wRc = true;
          localObject2 = k.b.OQ(paramca.field_content);
          if (localObject2 != null)
          {
            localObject1 = ((k.b)localObject2).thumburl;
            localObject2 = (e)((k.b)localObject2).ar(e.class);
            if ((localObject2 != null) && (((e)localObject2).llv != null)) {
              this.WFL.wRe = Util.formatSecToMin(((e)localObject2).llv.videoDuration);
            }
          }
        }
        else
        {
          localObject2 = q.bmh().d(paramca.field_imgPath, false, false);
          localObject1 = localObject2;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).endsWith("hd"))
            {
              localObject1 = localObject2;
              if (u.agG((String)localObject2 + "hd")) {
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
      if ((this.fNz != null) && ((paramObject instanceof ca)) && (paramObject != null))
      {
        if (this.fNz.field_msgId == ((ca)paramObject).field_msgId)
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
      public k.b fQY;
      public String wRe;
      
      a() {}
    }
  }
  
  public final class d
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView tMO;
    ImageView wRg;
    View wRh;
    ImageView wRi;
    View wRj;
    View wRk;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35028);
      this.wRg = ((ImageView)paramView.findViewById(R.h.grid_header_item));
      this.wRh = paramView.findViewById(R.h.video_tips_root);
      this.wRj = paramView.findViewById(R.h.sight_tips_root);
      this.tMO = ((TextView)paramView.findViewById(R.h.video_time_tv));
      this.wRi = ((ImageView)paramView.findViewById(R.h.grid_selected_item_mask));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.media_cbx));
      this.wRk = paramView.findViewById(R.h.media_cbx_clickarea);
      this.wRk.setVisibility(8);
      this.checkBox.setVisibility(8);
      this.wRh.setVisibility(8);
      this.tMO.setVisibility(8);
      this.wRj.setVisibility(8);
      this.wRg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35026);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Integer)))
          {
            Log.e("MicroMsg.MediaHistoryGalleryAdapter", "getTag is %s", new Object[] { paramAnonymousView.getTag() });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35026);
            return;
          }
          localObject = b.this.avx(((Integer)paramAnonymousView.getTag()).intValue());
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
      this.wRk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35027);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          boolean bool;
          if (!b.d.this.checkBox.isChecked())
          {
            bool = true;
            if (l.a.hRO().wQK.size() >= 9) {
              break label194;
            }
            b.d.this.checkBox.setChecked(bool);
            if (b.d.this.wRi != null)
            {
              if (bool) {
                break label180;
              }
              b.d.this.wRi.setVisibility(8);
            }
          }
          for (;;)
          {
            if (b.a(b.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = b.this.avx(i);
              b.a(b.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35027);
            return;
            bool = false;
            break;
            label180:
            b.d.this.wRi.setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b
 * JD-Core Version:    0.7.0.1
 */