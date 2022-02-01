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
import com.tencent.mm.av.g;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class b
  extends RecyclerView.a
{
  private long HRS;
  public b HRT;
  private String fzK;
  private com.tencent.mm.av.a.a.c fze;
  private Context mContext;
  public List<c> myd;
  private boolean opt;
  public boolean opw;
  private boolean qKh;
  public boolean qSB;
  
  public b(Context paramContext, List<c> paramList, String paramString)
  {
    AppMethodBeat.i(35029);
    this.myd = null;
    this.fze = null;
    this.opt = true;
    this.qKh = false;
    this.qSB = false;
    this.myd = paramList;
    this.fzK = paramString;
    az.ayM();
    this.opt = com.tencent.mm.model.c.isSDCardAvailable();
    this.mContext = paramContext;
    jZ(paramContext);
    AppMethodBeat.o(35029);
  }
  
  public b(Context paramContext, List<c> paramList, String paramString, long paramLong)
  {
    AppMethodBeat.i(35030);
    this.myd = null;
    this.fze = null;
    this.opt = true;
    this.qKh = false;
    this.qSB = false;
    this.myd = paramList;
    this.HRS = paramLong;
    this.fzK = paramString;
    az.ayM();
    this.opt = com.tencent.mm.model.c.isSDCardAvailable();
    this.qKh = true;
    this.mContext = paramContext;
    jZ(paramContext);
    AppMethodBeat.o(35030);
  }
  
  private void jZ(Context paramContext)
  {
    AppMethodBeat.i(35031);
    c.a locala = new c.a();
    locala.hKA = 1;
    locala.hKQ = true;
    locala.gKh = (com.tencent.mm.cc.a.ig(paramContext) / 4);
    locala.gKg = (com.tencent.mm.cc.a.ig(paramContext) / 4);
    locala.hKL = 2131100734;
    this.fze = locala.aFT();
    AppMethodBeat.o(35031);
  }
  
  private static long rI(long paramLong)
  {
    AppMethodBeat.i(35037);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fsS().b(localDate);
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
    if (!this.opt)
    {
      ac.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.opt) });
      AppMethodBeat.o(35035);
      return;
    }
    c localc = aaT(paramInt);
    if (paramw.asH == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (rI(aaT(paramInt + 1).timeStamp) != rI(localc.timeStamp)))
      {
        ((a)paramw).iBM.setVisibility(8);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramw).iBM.setVisibility(0);
      ((a)paramw).iBM.setText(rH(localc.timeStamp));
      if (this.opw)
      {
        ((a)paramw).progressBar.setVisibility(0);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramw).progressBar.setVisibility(8);
      AppMethodBeat.o(35035);
      return;
    }
    ((d)paramw).qSI.setTag(Integer.valueOf(paramInt));
    ((d)paramw).qSM.setTag(Integer.valueOf(paramInt));
    if (localc.qSE)
    {
      String str1 = r.aGc(localc.imagePath);
      com.tencent.mm.av.a.a locala = com.tencent.mm.av.o.aFB();
      String str2 = localc.imagePath;
      ImageView localImageView = ((d)paramw).qSI;
      c.a locala1 = new c.a();
      locala1.gKe = str1;
      locala1.hKx = true;
      locala.a(str2, localImageView, locala1.aFT());
      if ((!localc.oWm) && (!localc.qSE)) {
        break label438;
      }
      ((d)paramw).qSJ.setVisibility(0);
      ((d)paramw).opl.setVisibility(0);
      ((d)paramw).opl.setText(bs.bG(localc.HRV.qSG, ""));
    }
    for (;;)
    {
      if (this.qSB)
      {
        ((d)paramw).qSM.setVisibility(0);
        ((d)paramw).ijt.setVisibility(0);
        if (h.a.fpp().ci(localc.dpq))
        {
          ((d)paramw).qSK.setVisibility(0);
          ((d)paramw).ijt.setChecked(true);
          AppMethodBeat.o(35035);
          return;
          com.tencent.mm.av.o.aFB().a(localc.imagePath, ((d)paramw).qSI, this.fze);
          break;
          label438:
          ((d)paramw).opl.setVisibility(8);
          ((d)paramw).qSJ.setVisibility(8);
          continue;
        }
        ((d)paramw).qSK.setVisibility(8);
        ((d)paramw).ijt.setChecked(false);
        AppMethodBeat.o(35035);
        return;
      }
    }
    ((d)paramw).qSM.setVisibility(8);
    ((d)paramw).ijt.setVisibility(8);
    AppMethodBeat.o(35035);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    AppMethodBeat.i(35034);
    if ((paramList != null) && (paramList.size() > 0) && ((paramw instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramw).ijt.setChecked(false);
        ((d)paramw).ijt.setVisibility(0);
        ((d)paramw).qSM.setVisibility(0);
        AppMethodBeat.o(35034);
        return;
      }
      ((d)paramw).ijt.setChecked(false);
      ((d)paramw).ijt.setVisibility(8);
      ((d)paramw).qSM.setVisibility(8);
      AppMethodBeat.o(35034);
      return;
    }
    super.a(paramw, paramInt, paramList);
    AppMethodBeat.o(35034);
  }
  
  public final c aaT(int paramInt)
  {
    AppMethodBeat.i(35039);
    c localc = (c)this.myd.get(paramInt);
    AppMethodBeat.o(35039);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35038);
    int i = this.myd.size();
    AppMethodBeat.o(35038);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35032);
    paramInt = aaT(paramInt).type;
    AppMethodBeat.o(35032);
    return paramInt;
  }
  
  public final String rH(long paramLong)
  {
    AppMethodBeat.i(35036);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fsS().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35036);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.w
  {
    TextView iBM;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35022);
      this.iBM = ((TextView)paramView.findViewById(2131298930));
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
    public a HRV;
    public bo dpq;
    public String imagePath;
    boolean oWm;
    boolean qSE;
    public long timeStamp;
    public int type;
    
    public c(long paramLong)
    {
      AppMethodBeat.i(35025);
      this.type = 0;
      this.qSE = false;
      this.HRV = new a();
      this.timeStamp = paramLong;
      this.type = 2147483647;
      AppMethodBeat.o(35025);
    }
    
    public c(bo parambo)
    {
      AppMethodBeat.i(35024);
      this.type = 0;
      this.qSE = false;
      this.HRV = new a();
      this.dpq = parambo;
      Object localObject1 = "";
      Object localObject2;
      if ((parambo.crt()) || (parambo.crv()))
      {
        this.oWm = true;
        com.tencent.mm.modelvideo.o.aJy();
        localObject1 = t.DW(parambo.field_imgPath);
        localObject2 = u.Ej(parambo.field_imgPath);
        if (localObject2 != null) {
          this.HRV.qSG = bs.qy(((s)localObject2).hpy);
        }
        this.HRV.dsB = k.b.az(parambo.field_content, parambo.field_reserved);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (parambo.fbG())
        {
          Object localObject4 = k.b.vA(parambo.field_content);
          localObject3 = null;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (((k.b)localObject4).cZa != null)
            {
              localObject2 = localObject3;
              if (((k.b)localObject4).cZa.length() > 0)
              {
                localObject4 = ap.bEO().aGd(((k.b)localObject4).cZa);
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
        this.timeStamp = parambo.field_createTime;
        AppMethodBeat.o(35024);
        return;
        if (parambo.cru())
        {
          this.qSE = true;
          localObject2 = k.b.vA(parambo.field_content);
          if (localObject2 != null)
          {
            localObject1 = ((k.b)localObject2).thumburl;
            localObject2 = (e)((k.b)localObject2).ao(e.class);
            if ((localObject2 != null) && (((e)localObject2).hhf != null)) {
              this.HRV.qSG = bs.qy(((e)localObject2).hhf.videoDuration);
            }
          }
        }
        else
        {
          localObject2 = com.tencent.mm.av.o.aFx().b(parambo.field_imgPath, false, false);
          localObject1 = localObject2;
          if (!bs.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).endsWith("hd"))
            {
              localObject1 = localObject2;
              if (i.eA((String)localObject2 + "hd")) {
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
      if ((this.dpq != null) && ((paramObject instanceof bo)) && (paramObject != null))
      {
        if (this.dpq.field_msgId == ((bo)paramObject).field_msgId)
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
      public k.b dsB;
      public String qSG;
      
      a() {}
    }
  }
  
  public final class d
    extends RecyclerView.w
  {
    CheckBox ijt;
    TextView opl;
    ImageView qSI;
    View qSJ;
    ImageView qSK;
    View qSL;
    View qSM;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35028);
      this.qSI = ((ImageView)paramView.findViewById(2131300612));
      this.qSJ = paramView.findViewById(2131306404);
      this.qSL = paramView.findViewById(2131304817);
      this.opl = ((TextView)paramView.findViewById(2131306401));
      this.qSK = ((ImageView)paramView.findViewById(2131300615));
      this.ijt = ((CheckBox)paramView.findViewById(2131302204));
      this.qSM = paramView.findViewById(2131302205);
      this.qSM.setVisibility(8);
      this.ijt.setVisibility(8);
      this.qSJ.setVisibility(8);
      this.opl.setVisibility(8);
      this.qSL.setVisibility(8);
      this.qSI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35026);
          if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Integer)))
          {
            ac.e("MicroMsg.MediaHistoryGalleryAdapter", "getTag is %s", new Object[] { paramAnonymousView.getTag() });
            AppMethodBeat.o(35026);
            return;
          }
          b.c localc = b.this.aaT(((Integer)paramAnonymousView.getTag()).intValue());
          if (localc == null)
          {
            AppMethodBeat.o(35026);
            return;
          }
          b.a(b.this, paramAnonymousView, localc);
          AppMethodBeat.o(35026);
        }
      });
      this.qSM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35027);
          boolean bool;
          if (!b.d.this.ijt.isChecked())
          {
            bool = true;
            if (h.a.fpp().qSv.size() >= 9) {
              break label140;
            }
            b.d.this.ijt.setChecked(bool);
            if (bool) {
              break label126;
            }
            b.d.this.qSK.setVisibility(8);
          }
          for (;;)
          {
            if (b.a(b.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = b.this.aaT(i);
              b.a(b.this).a(bool, paramAnonymousView, i);
            }
            AppMethodBeat.o(35027);
            return;
            bool = false;
            break;
            label126:
            b.d.this.qSK.setVisibility(0);
            continue;
            label140:
            if (!bool) {
              b.d.this.ijt.setChecked(false);
            }
          }
        }
      });
      AppMethodBeat.o(35028);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b
 * JD-Core Version:    0.7.0.1
 */