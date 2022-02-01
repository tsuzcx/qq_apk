package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.am.f;
import com.tencent.mm.aw.g;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends q<bl>
  implements View.OnClickListener
{
  private static Map<String, Integer> GAQ;
  private static Map<String, Integer> mFE;
  private final ImageGalleryGridUI GAO;
  boolean GAP;
  long Gsa;
  protected com.tencent.mm.aw.a.a.c fvx;
  String fwd;
  Context mContext;
  private LayoutInflater mInflater;
  private boolean nMt;
  public boolean qHI;
  boolean qbB;
  
  static
  {
    AppMethodBeat.i(35949);
    HashMap localHashMap = new HashMap();
    mFE = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689582));
    mFE.put("m4v", Integer.valueOf(2131689582));
    mFE.put("vob", Integer.valueOf(2131689582));
    mFE.put("mpeg", Integer.valueOf(2131689582));
    mFE.put("mpe", Integer.valueOf(2131689582));
    mFE.put("asx", Integer.valueOf(2131689582));
    mFE.put("asf", Integer.valueOf(2131689582));
    mFE.put("f4v", Integer.valueOf(2131689582));
    mFE.put("flv", Integer.valueOf(2131689582));
    mFE.put("mkv", Integer.valueOf(2131689582));
    mFE.put("wmv", Integer.valueOf(2131689582));
    mFE.put("wm", Integer.valueOf(2131689582));
    mFE.put("3gp", Integer.valueOf(2131689582));
    mFE.put("mp4", Integer.valueOf(2131689582));
    mFE.put("rmvb", Integer.valueOf(2131689582));
    mFE.put("rm", Integer.valueOf(2131689582));
    mFE.put("ra", Integer.valueOf(2131689582));
    mFE.put("ram", Integer.valueOf(2131689582));
    mFE.put("mp3pro", Integer.valueOf(2131689565));
    mFE.put("vqf", Integer.valueOf(2131689565));
    mFE.put("cd", Integer.valueOf(2131689565));
    mFE.put("md", Integer.valueOf(2131689565));
    mFE.put("mod", Integer.valueOf(2131689565));
    mFE.put("vorbis", Integer.valueOf(2131689565));
    mFE.put("au", Integer.valueOf(2131689565));
    mFE.put("amr", Integer.valueOf(2131689565));
    mFE.put("silk", Integer.valueOf(2131689565));
    mFE.put("wma", Integer.valueOf(2131689565));
    mFE.put("mmf", Integer.valueOf(2131689565));
    mFE.put("mid", Integer.valueOf(2131689565));
    mFE.put("midi", Integer.valueOf(2131689565));
    mFE.put("mp3", Integer.valueOf(2131689565));
    mFE.put("aac", Integer.valueOf(2131689565));
    mFE.put("ape", Integer.valueOf(2131689565));
    mFE.put("aiff", Integer.valueOf(2131689565));
    mFE.put("aif", Integer.valueOf(2131689565));
    mFE.put("doc", Integer.valueOf(2131689586));
    mFE.put("docx", Integer.valueOf(2131689586));
    mFE.put("ppt", Integer.valueOf(2131689572));
    mFE.put("pptx", Integer.valueOf(2131689572));
    mFE.put("xls", Integer.valueOf(2131689558));
    mFE.put("xlsx", Integer.valueOf(2131689558));
    mFE.put("pdf", Integer.valueOf(2131689569));
    mFE.put("unknown", Integer.valueOf(2131689578));
    localHashMap = new HashMap();
    GAQ = localHashMap;
    localHashMap.put("doc", Integer.valueOf(2131099910));
    GAQ.put("docx", Integer.valueOf(2131099910));
    GAQ.put("ppt", Integer.valueOf(2131099913));
    GAQ.put("pptx", Integer.valueOf(2131099913));
    GAQ.put("xls", Integer.valueOf(2131099916));
    GAQ.put("xlsx", Integer.valueOf(2131099916));
    GAQ.put("pdf", Integer.valueOf(2131099912));
    GAQ.put("unknown", Integer.valueOf(2131099914));
    GAQ.put("mp3pro", Integer.valueOf(2131099911));
    GAQ.put("vqf", Integer.valueOf(2131099911));
    GAQ.put("cd", Integer.valueOf(2131099911));
    GAQ.put("md", Integer.valueOf(2131099911));
    GAQ.put("mod", Integer.valueOf(2131099911));
    GAQ.put("vorbis", Integer.valueOf(2131099911));
    GAQ.put("au", Integer.valueOf(2131099911));
    GAQ.put("amr", Integer.valueOf(2131099911));
    GAQ.put("silk", Integer.valueOf(2131099911));
    GAQ.put("wma", Integer.valueOf(2131099911));
    GAQ.put("mmf", Integer.valueOf(2131099911));
    GAQ.put("mid", Integer.valueOf(2131099911));
    GAQ.put("midi", Integer.valueOf(2131099911));
    GAQ.put("mp3", Integer.valueOf(2131099911));
    GAQ.put("aac", Integer.valueOf(2131099911));
    GAQ.put("ape", Integer.valueOf(2131099911));
    GAQ.put("aiff", Integer.valueOf(2131099911));
    GAQ.put("aif", Integer.valueOf(2131099911));
    AppMethodBeat.o(35949);
  }
  
  public c(Context paramContext, bl parambl, String paramString)
  {
    super(paramContext, parambl);
    AppMethodBeat.i(35938);
    this.fvx = null;
    this.GAP = false;
    this.qHI = false;
    this.GAO = ((ImageGalleryGridUI)paramContext);
    this.fwd = paramString;
    this.qbB = f.pc(this.fwd);
    if (this.qbB) {
      this.Gsa = parambl.field_bizChatId;
    }
    az.arV();
    this.nMt = com.tencent.mm.model.c.isSDCardAvailable();
    this.mInflater = LayoutInflater.from(paramContext);
    parambl = new com.tencent.mm.aw.a.a.c.a();
    parambl.hjX = 1;
    parambl.hkn = true;
    parambl.gjw = (com.tencent.mm.cd.a.hV(paramContext) / 3);
    parambl.gjv = (com.tencent.mm.cd.a.hV(paramContext) / 3);
    parambl.hki = 2131100734;
    this.fvx = parambl.azc();
    AppMethodBeat.o(35938);
  }
  
  private static String bW(bl parambl)
  {
    AppMethodBeat.i(35944);
    Object localObject1;
    if ((parambl.cjM()) || (parambl.cjO()))
    {
      com.tencent.mm.modelvideo.o.aCI();
      localObject1 = t.zR(parambl.field_imgPath);
    }
    for (;;)
    {
      ad.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (parambl.eMb())
      {
        Object localObject3 = k.b.rx(parambl.field_content);
        localObject2 = null;
        parambl = (bl)localObject2;
        if (localObject3 != null)
        {
          parambl = (bl)localObject2;
          if (((k.b)localObject3).dbA != null)
          {
            parambl = (bl)localObject2;
            if (((k.b)localObject3).dbA.length() > 0)
            {
              localObject3 = ap.bxS().aAL(((k.b)localObject3).dbA);
              parambl = (bl)localObject2;
              if (localObject3 != null) {
                parambl = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (parambl != null) {
          localObject2 = parambl;
        }
      }
      AppMethodBeat.o(35944);
      return localObject2;
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
  
  private static int h(k.b paramb)
  {
    AppMethodBeat.i(35942);
    if (paramb == null)
    {
      ad.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131689577");
      AppMethodBeat.o(35942);
      return 2131689578;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      AppMethodBeat.o(35942);
      return 2131689580;
    }
    if (paramb.type == 3)
    {
      AppMethodBeat.o(35942);
      return 2131689565;
    }
    if ((paramb.type == 6) && (mFE.containsKey(bt.nullAsNil(paramb.gHf))))
    {
      ad.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + mFE.get(bt.nullAsNil(paramb.gHf)));
      int i = ((Integer)mFE.get(bt.nullAsNil(paramb.gHf))).intValue();
      AppMethodBeat.o(35942);
      return i;
    }
    AppMethodBeat.o(35942);
    return 2131689578;
  }
  
  private static int i(k.b paramb)
  {
    AppMethodBeat.i(35943);
    if (paramb == null)
    {
      ad.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131099914");
      AppMethodBeat.o(35943);
      return 2131099914;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      AppMethodBeat.o(35943);
      return 2131099915;
    }
    if ((paramb.type == 6) && (GAQ.containsKey(bt.nullAsNil(paramb.gHf))))
    {
      ad.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + GAQ.get(bt.nullAsNil(paramb.gHf)));
      int i = ((Integer)GAQ.get(bt.nullAsNil(paramb.gHf))).intValue();
      AppMethodBeat.o(35943);
      return i;
    }
    AppMethodBeat.o(35943);
    return 2131099914;
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(35939);
    if (this.qbB)
    {
      az.arV();
      setCursor(com.tencent.mm.model.c.apP().bV(this.fwd, this.Gsa));
      AppMethodBeat.o(35939);
      return;
    }
    az.arV();
    setCursor(com.tencent.mm.model.c.apO().agu(this.fwd));
    AppMethodBeat.o(35939);
  }
  
  public final void We()
  {
    AppMethodBeat.i(35940);
    if (this.qbB)
    {
      az.arV();
      setCursor(com.tencent.mm.model.c.apP().bV(this.fwd, this.Gsa));
      AppMethodBeat.o(35940);
      return;
    }
    az.arV();
    setCursor(com.tencent.mm.model.c.apO().agu(this.fwd));
    AppMethodBeat.o(35940);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void cjK()
  {
    AppMethodBeat.i(35945);
    this.qHI = false;
    notifyDataSetChanged();
    AppMethodBeat.o(35945);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35941);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131494459, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.qkg = ((ImageView)paramView.findViewById(2131300612));
      paramViewGroup.qkh = paramView.findViewById(2131306404);
      paramViewGroup.GAU = ((TextView)paramView.findViewById(2131299925));
      paramViewGroup.GAU.setVisibility(8);
      paramViewGroup.GAT = ((ImageView)paramView.findViewById(2131299918));
      paramViewGroup.nMl = ((TextView)paramView.findViewById(2131306401));
      paramViewGroup.qkh.setVisibility(8);
      paramViewGroup.qkj = paramView.findViewById(2131304817);
      paramViewGroup.qkj.setVisibility(8);
      paramViewGroup.GAV = paramView.findViewById(2131299932);
      paramViewGroup.GAV.setVisibility(8);
      paramViewGroup.qki = ((ImageView)paramView.findViewById(2131300615));
      paramViewGroup.hIS = ((CheckBox)paramView.findViewById(2131302204));
      paramViewGroup.qkk = paramView.findViewById(2131302205);
      paramView.setTag(paramViewGroup);
    }
    bl localbl;
    for (;;)
    {
      paramViewGroup.qkj.setVisibility(8);
      paramViewGroup.qkh.setVisibility(8);
      paramViewGroup.GAV.setVisibility(8);
      paramViewGroup.GAU.setVisibility(8);
      localbl = (bl)getItem(paramInt);
      if (localbl != null) {
        break;
      }
      AppMethodBeat.o(35941);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (this.nMt)
    {
      if (!(this.GAO instanceof ImageGalleryGridUI))
      {
        paramView = new IllegalArgumentException("the context should be ImageGalleryGridUI");
        AppMethodBeat.o(35941);
        throw paramView;
      }
      localObject2 = localbl.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.ar((String)localObject2, localbl.field_reserved);
      }
      if (this.GAO.GAW == paramInt)
      {
        paramViewGroup.qki.setVisibility(0);
        if ((b.bP(localbl)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
        {
          paramViewGroup.GAT.setImageDrawable(this.GAO.getResources().getDrawable(h((k.b)localObject1)));
          paramViewGroup.qkg.setImageResource(i((k.b)localObject1));
          paramViewGroup.qkg.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.qkg.getMeasuredWidth();
          i = paramViewGroup.qkg.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label774;
          }
          label445:
          if (!b.m(localbl)) {
            break label808;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.qkh.setVisibility(0);
            localObject1 = j.ch(localbl);
            if (localObject1 != null) {
              paramViewGroup.nMl.setText(bt.pL(((s)localObject1).gOY));
            }
          }
          label492:
          paramViewGroup.hIS.setChecked(h.a.eZA().cf(localbl));
          paramViewGroup.hIS.setTag(localbl);
          paramViewGroup.qkk.setTag(paramViewGroup);
          paramViewGroup.qkk.setOnClickListener(this);
          if (!h.a.eZA().qjU) {
            break label979;
          }
          paramViewGroup.hIS.setVisibility(0);
          paramViewGroup.qkk.setVisibility(0);
          paramViewGroup.qki.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35941);
      return paramView;
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.GAT.setImageDrawable(this.GAO.getResources().getDrawable(h((k.b)localObject1)));
      }
      com.tencent.mm.aw.o.ayJ().a(bW(localbl), paramViewGroup.qkg, this.fvx, new com.tencent.mm.aw.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(35937);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35936);
              AppMethodBeat.o(35936);
            }
          });
          AppMethodBeat.o(35937);
        }
      });
      break;
      paramViewGroup.qki.setVisibility(0);
      paramViewGroup.qki.setBackgroundResource(2131100506);
      if ((b.bP(localbl)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
      {
        paramViewGroup.GAT.setImageDrawable(this.GAO.getResources().getDrawable(h((k.b)localObject1)));
        paramViewGroup.qkg.setImageResource(i((k.b)localObject1));
        break;
      }
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.GAT.setImageDrawable(this.GAO.getResources().getDrawable(h((k.b)localObject1)));
      }
      com.tencent.mm.aw.o.ayJ().a(bW(localbl), paramViewGroup.qkg, this.fvx);
      break;
      label774:
      localObject2 = paramViewGroup.qki.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.qki.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label445;
      label808:
      if (b.bO(localbl))
      {
        paramViewGroup.qkj.setVisibility(0);
        break label492;
      }
      if ((!b.bP(localbl)) || (paramViewGroup == null)) {
        break label492;
      }
      paramViewGroup.GAV.setVisibility(0);
      paramViewGroup.GAU.setVisibility(0);
      if (localObject1 == null) {
        break label492;
      }
      ad.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { bt.nullAsNil(((k.b)localObject1).title) });
      if (((k.b)localObject1).type != 24)
      {
        paramViewGroup.GAU.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, bt.nullAsNil(((k.b)localObject1).title), paramViewGroup.GAU.getTextSize()));
        break label492;
      }
      paramViewGroup.GAU.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramViewGroup.GAU.getContext(), paramViewGroup.GAU.getContext().getString(2131759034), paramViewGroup.GAU.getTextSize()));
      break label492;
      paramViewGroup.qkg.setImageResource(2131233476);
      break label492;
      label979:
      paramViewGroup.hIS.setVisibility(8);
      paramViewGroup.qkk.setVisibility(8);
      paramViewGroup.qki.setVisibility(8);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35946);
    super.notifyDataSetChanged();
    this.GAP = false;
    AppMethodBeat.o(35946);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35947);
    paramView = (a)paramView.getTag();
    if (paramView.hIS == null)
    {
      AppMethodBeat.o(35947);
      return;
    }
    bl localbl = (bl)paramView.hIS.getTag();
    if (localbl == null)
    {
      AppMethodBeat.o(35947);
      return;
    }
    h localh = h.a.eZA();
    if (localh.cf(localbl))
    {
      localh.ce(localbl);
      if (!h.a.eZA().cf(localbl)) {
        break label151;
      }
      paramView.hIS.setChecked(true);
      paramView.qki.setBackgroundResource(2131100482);
    }
    for (;;)
    {
      if ((!this.qHI) && (h.a.eZA().qjT.size() > 1))
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 20L, 1L, true);
        this.qHI = true;
      }
      AppMethodBeat.o(35947);
      return;
      localh.cd(localbl);
      break;
      label151:
      paramView.hIS.setChecked(false);
      paramView.qki.setBackgroundResource(2131100506);
    }
  }
  
  protected static final class a
  {
    public ImageView GAT;
    public TextView GAU;
    public View GAV;
    public CheckBox hIS;
    public TextView nMl;
    public ImageView qkg;
    public View qkh;
    public ImageView qki;
    public View qkj;
    public View qkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c
 * JD-Core Version:    0.7.0.1
 */