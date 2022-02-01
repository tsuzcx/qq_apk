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
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.y;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.g;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class b
  extends RecyclerView.a
{
  private long Gsa;
  public b Gsb;
  private com.tencent.mm.aw.a.a.c fvx;
  private String fwd;
  public List<c> lWb;
  private Context mContext;
  private boolean nMt;
  public boolean nMw;
  private boolean qbB;
  public boolean qjZ;
  
  public b(Context paramContext, List<c> paramList, String paramString)
  {
    AppMethodBeat.i(35029);
    this.lWb = null;
    this.fvx = null;
    this.nMt = true;
    this.qbB = false;
    this.qjZ = false;
    this.lWb = paramList;
    this.fwd = paramString;
    az.arV();
    this.nMt = com.tencent.mm.model.c.isSDCardAvailable();
    this.mContext = paramContext;
    jO(paramContext);
    AppMethodBeat.o(35029);
  }
  
  public b(Context paramContext, List<c> paramList, String paramString, long paramLong)
  {
    AppMethodBeat.i(35030);
    this.lWb = null;
    this.fvx = null;
    this.nMt = true;
    this.qbB = false;
    this.qjZ = false;
    this.lWb = paramList;
    this.Gsa = paramLong;
    this.fwd = paramString;
    az.arV();
    this.nMt = com.tencent.mm.model.c.isSDCardAvailable();
    this.qbB = true;
    this.mContext = paramContext;
    jO(paramContext);
    AppMethodBeat.o(35030);
  }
  
  private void jO(Context paramContext)
  {
    AppMethodBeat.i(35031);
    c.a locala = new c.a();
    locala.hjX = 1;
    locala.hkn = true;
    locala.gjw = (com.tencent.mm.cd.a.hV(paramContext) / 4);
    locala.gjv = (com.tencent.mm.cd.a.hV(paramContext) / 4);
    locala.hki = 2131100734;
    this.fvx = locala.azc();
    AppMethodBeat.o(35031);
  }
  
  private static long nW(long paramLong)
  {
    AppMethodBeat.i(35037);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fcX().b(localDate);
    AppMethodBeat.o(35037);
    return paramLong;
  }
  
  public final c YI(int paramInt)
  {
    AppMethodBeat.i(35039);
    c localc = (c)this.lWb.get(paramInt);
    AppMethodBeat.o(35039);
    return localc;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
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
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(35035);
    if (!this.nMt)
    {
      ad.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.nMt) });
      AppMethodBeat.o(35035);
      return;
    }
    c localc = YI(paramInt);
    if (paramv.arM == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (nW(YI(paramInt + 1).timeStamp) != nW(localc.timeStamp)))
      {
        ((a)paramv).ibF.setVisibility(8);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramv).ibF.setVisibility(0);
      ((a)paramv).ibF.setText(nV(localc.timeStamp));
      if (this.nMw)
      {
        ((a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(35035);
        return;
      }
      ((a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(35035);
      return;
    }
    ((d)paramv).qkg.setTag(Integer.valueOf(paramInt));
    ((d)paramv).qkk.setTag(Integer.valueOf(paramInt));
    if (localc.qkc)
    {
      String str1 = r.aAK(localc.imagePath);
      com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.o.ayJ();
      String str2 = localc.imagePath;
      ImageView localImageView = ((d)paramv).qkg;
      c.a locala1 = new c.a();
      locala1.gjt = str1;
      locala1.hjU = true;
      locala.a(str2, localImageView, locala1.azc());
      if ((!localc.osM) && (!localc.qkc)) {
        break label438;
      }
      ((d)paramv).qkh.setVisibility(0);
      ((d)paramv).nMl.setVisibility(0);
      ((d)paramv).nMl.setText(bt.by(localc.Gsd.qke, ""));
    }
    for (;;)
    {
      if (this.qjZ)
      {
        ((d)paramv).qkk.setVisibility(0);
        ((d)paramv).hIS.setVisibility(0);
        if (h.a.eZA().cf(localc.drF))
        {
          ((d)paramv).qki.setVisibility(0);
          ((d)paramv).hIS.setChecked(true);
          AppMethodBeat.o(35035);
          return;
          com.tencent.mm.aw.o.ayJ().a(localc.imagePath, ((d)paramv).qkg, this.fvx);
          break;
          label438:
          ((d)paramv).nMl.setVisibility(8);
          ((d)paramv).qkh.setVisibility(8);
          continue;
        }
        ((d)paramv).qki.setVisibility(8);
        ((d)paramv).hIS.setChecked(false);
        AppMethodBeat.o(35035);
        return;
      }
    }
    ((d)paramv).qkk.setVisibility(8);
    ((d)paramv).hIS.setVisibility(8);
    AppMethodBeat.o(35035);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(35034);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramv).hIS.setChecked(false);
        ((d)paramv).hIS.setVisibility(0);
        ((d)paramv).qkk.setVisibility(0);
        AppMethodBeat.o(35034);
        return;
      }
      ((d)paramv).hIS.setChecked(false);
      ((d)paramv).hIS.setVisibility(8);
      ((d)paramv).qkk.setVisibility(8);
      AppMethodBeat.o(35034);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(35034);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35038);
    int i = this.lWb.size();
    AppMethodBeat.o(35038);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35032);
    paramInt = YI(paramInt).type;
    AppMethodBeat.o(35032);
    return paramInt;
  }
  
  public final String nV(long paramLong)
  {
    AppMethodBeat.i(35036);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fcX().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35036);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.v
  {
    TextView ibF;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35022);
      this.ibF = ((TextView)paramView.findViewById(2131298930));
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
    public a Gsd;
    public bl drF;
    public String imagePath;
    boolean osM;
    boolean qkc;
    public long timeStamp;
    public int type;
    
    public c(long paramLong)
    {
      AppMethodBeat.i(35025);
      this.type = 0;
      this.qkc = false;
      this.Gsd = new a();
      this.timeStamp = paramLong;
      this.type = 2147483647;
      AppMethodBeat.o(35025);
    }
    
    public c(bl parambl)
    {
      AppMethodBeat.i(35024);
      this.type = 0;
      this.qkc = false;
      this.Gsd = new a();
      this.drF = parambl;
      Object localObject1 = "";
      Object localObject2;
      if ((parambl.cjM()) || (parambl.cjO()))
      {
        this.osM = true;
        com.tencent.mm.modelvideo.o.aCI();
        localObject1 = t.zR(parambl.field_imgPath);
        localObject2 = u.Ae(parambl.field_imgPath);
        if (localObject2 != null) {
          this.Gsd.qke = bt.pL(((s)localObject2).gOY);
        }
        this.Gsd.duP = k.b.ar(parambl.field_content, parambl.field_reserved);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (parambl.eMb())
        {
          Object localObject4 = k.b.rx(parambl.field_content);
          localObject3 = null;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (((k.b)localObject4).dbA != null)
            {
              localObject2 = localObject3;
              if (((k.b)localObject4).dbA.length() > 0)
              {
                localObject4 = ap.bxS().aAL(((k.b)localObject4).dbA);
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
        this.timeStamp = parambl.field_createTime;
        AppMethodBeat.o(35024);
        return;
        if (parambl.cjN())
        {
          this.qkc = true;
          localObject2 = k.b.rx(parambl.field_content);
          if (localObject2 != null)
          {
            localObject1 = ((k.b)localObject2).thumburl;
            localObject2 = (e)((k.b)localObject2).ao(e.class);
            if ((localObject2 != null) && (((e)localObject2).gGE != null)) {
              this.Gsd.qke = bt.pL(((e)localObject2).gGE.videoDuration);
            }
          }
        }
        else
        {
          localObject2 = com.tencent.mm.aw.o.ayF().b(parambl.field_imgPath, false, false);
          localObject1 = localObject2;
          if (!bt.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).endsWith("hd"))
            {
              localObject1 = localObject2;
              if (i.eK((String)localObject2 + "hd")) {
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
      if ((this.drF != null) && ((paramObject instanceof bl)) && (paramObject != null))
      {
        if (this.drF.field_msgId == ((bl)paramObject).field_msgId)
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
      public k.b duP;
      public String qke;
      
      a() {}
    }
  }
  
  public final class d
    extends RecyclerView.v
  {
    CheckBox hIS;
    TextView nMl;
    ImageView qkg;
    View qkh;
    ImageView qki;
    View qkj;
    View qkk;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35028);
      this.qkg = ((ImageView)paramView.findViewById(2131300612));
      this.qkh = paramView.findViewById(2131306404);
      this.qkj = paramView.findViewById(2131304817);
      this.nMl = ((TextView)paramView.findViewById(2131306401));
      this.qki = ((ImageView)paramView.findViewById(2131300615));
      this.hIS = ((CheckBox)paramView.findViewById(2131302204));
      this.qkk = paramView.findViewById(2131302205);
      this.qkk.setVisibility(8);
      this.hIS.setVisibility(8);
      this.qkh.setVisibility(8);
      this.nMl.setVisibility(8);
      this.qkj.setVisibility(8);
      this.qkg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35026);
          if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Integer)))
          {
            ad.e("MicroMsg.MediaHistoryGalleryAdapter", "getTag is %s", new Object[] { paramAnonymousView.getTag() });
            AppMethodBeat.o(35026);
            return;
          }
          b.c localc = b.this.YI(((Integer)paramAnonymousView.getTag()).intValue());
          if (localc == null)
          {
            AppMethodBeat.o(35026);
            return;
          }
          b.a(b.this, paramAnonymousView, localc);
          AppMethodBeat.o(35026);
        }
      });
      this.qkk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35027);
          boolean bool;
          if (!b.d.this.hIS.isChecked())
          {
            bool = true;
            if (h.a.eZA().qjT.size() >= 9) {
              break label140;
            }
            b.d.this.hIS.setChecked(bool);
            if (bool) {
              break label126;
            }
            b.d.this.qki.setVisibility(8);
          }
          for (;;)
          {
            if (b.a(b.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = b.this.YI(i);
              b.a(b.this).a(bool, paramAnonymousView, i);
            }
            AppMethodBeat.o(35027);
            return;
            bool = false;
            break;
            label126:
            b.d.this.qki.setVisibility(0);
            continue;
            label140:
            if (!bool) {
              b.d.this.hIS.setChecked(false);
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