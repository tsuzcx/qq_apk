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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.ui.r<bv>
  implements View.OnClickListener
{
  private static Map<String, Integer> Kln;
  private static Map<String, Integer> nNI;
  long KaB;
  private final ImageGalleryGridUI Kll;
  boolean Klm;
  protected com.tencent.mm.av.a.a.c fUx;
  String fVg;
  Context mContext;
  private LayoutInflater mInflater;
  private boolean oZq;
  boolean rCv;
  public boolean sDg;
  
  static
  {
    AppMethodBeat.i(35949);
    HashMap localHashMap = new HashMap();
    nNI = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689582));
    nNI.put("m4v", Integer.valueOf(2131689582));
    nNI.put("vob", Integer.valueOf(2131689582));
    nNI.put("mpeg", Integer.valueOf(2131689582));
    nNI.put("mpe", Integer.valueOf(2131689582));
    nNI.put("asx", Integer.valueOf(2131689582));
    nNI.put("asf", Integer.valueOf(2131689582));
    nNI.put("f4v", Integer.valueOf(2131689582));
    nNI.put("flv", Integer.valueOf(2131689582));
    nNI.put("mkv", Integer.valueOf(2131689582));
    nNI.put("wmv", Integer.valueOf(2131689582));
    nNI.put("wm", Integer.valueOf(2131689582));
    nNI.put("3gp", Integer.valueOf(2131689582));
    nNI.put("mp4", Integer.valueOf(2131689582));
    nNI.put("rmvb", Integer.valueOf(2131689582));
    nNI.put("rm", Integer.valueOf(2131689582));
    nNI.put("ra", Integer.valueOf(2131689582));
    nNI.put("ram", Integer.valueOf(2131689582));
    nNI.put("mp3pro", Integer.valueOf(2131689565));
    nNI.put("vqf", Integer.valueOf(2131689565));
    nNI.put("cd", Integer.valueOf(2131689565));
    nNI.put("md", Integer.valueOf(2131689565));
    nNI.put("mod", Integer.valueOf(2131689565));
    nNI.put("vorbis", Integer.valueOf(2131689565));
    nNI.put("au", Integer.valueOf(2131689565));
    nNI.put("amr", Integer.valueOf(2131689565));
    nNI.put("silk", Integer.valueOf(2131689565));
    nNI.put("wma", Integer.valueOf(2131689565));
    nNI.put("mmf", Integer.valueOf(2131689565));
    nNI.put("mid", Integer.valueOf(2131689565));
    nNI.put("midi", Integer.valueOf(2131689565));
    nNI.put("mp3", Integer.valueOf(2131689565));
    nNI.put("aac", Integer.valueOf(2131689565));
    nNI.put("ape", Integer.valueOf(2131689565));
    nNI.put("aiff", Integer.valueOf(2131689565));
    nNI.put("aif", Integer.valueOf(2131689565));
    nNI.put("doc", Integer.valueOf(2131689586));
    nNI.put("docx", Integer.valueOf(2131689586));
    nNI.put("ppt", Integer.valueOf(2131689572));
    nNI.put("pptx", Integer.valueOf(2131689572));
    nNI.put("xls", Integer.valueOf(2131689558));
    nNI.put("xlsx", Integer.valueOf(2131689558));
    nNI.put("pdf", Integer.valueOf(2131689569));
    nNI.put("unknown", Integer.valueOf(2131689578));
    localHashMap = new HashMap();
    Kln = localHashMap;
    localHashMap.put("doc", Integer.valueOf(2131099910));
    Kln.put("docx", Integer.valueOf(2131099910));
    Kln.put("ppt", Integer.valueOf(2131099913));
    Kln.put("pptx", Integer.valueOf(2131099913));
    Kln.put("xls", Integer.valueOf(2131099916));
    Kln.put("xlsx", Integer.valueOf(2131099916));
    Kln.put("pdf", Integer.valueOf(2131099912));
    Kln.put("unknown", Integer.valueOf(2131099914));
    Kln.put("mp3pro", Integer.valueOf(2131099911));
    Kln.put("vqf", Integer.valueOf(2131099911));
    Kln.put("cd", Integer.valueOf(2131099911));
    Kln.put("md", Integer.valueOf(2131099911));
    Kln.put("mod", Integer.valueOf(2131099911));
    Kln.put("vorbis", Integer.valueOf(2131099911));
    Kln.put("au", Integer.valueOf(2131099911));
    Kln.put("amr", Integer.valueOf(2131099911));
    Kln.put("silk", Integer.valueOf(2131099911));
    Kln.put("wma", Integer.valueOf(2131099911));
    Kln.put("mmf", Integer.valueOf(2131099911));
    Kln.put("mid", Integer.valueOf(2131099911));
    Kln.put("midi", Integer.valueOf(2131099911));
    Kln.put("mp3", Integer.valueOf(2131099911));
    Kln.put("aac", Integer.valueOf(2131099911));
    Kln.put("ape", Integer.valueOf(2131099911));
    Kln.put("aiff", Integer.valueOf(2131099911));
    Kln.put("aif", Integer.valueOf(2131099911));
    AppMethodBeat.o(35949);
  }
  
  public c(Context paramContext, bv parambv, String paramString)
  {
    super(paramContext, parambv);
    AppMethodBeat.i(35938);
    this.fUx = null;
    this.Klm = false;
    this.sDg = false;
    this.Kll = ((ImageGalleryGridUI)paramContext);
    this.fVg = paramString;
    this.rCv = com.tencent.mm.al.g.vz(this.fVg);
    if (this.rCv) {
      this.KaB = parambv.field_bizChatId;
    }
    bc.aCg();
    this.oZq = com.tencent.mm.model.c.isSDCardAvailable();
    this.mInflater = LayoutInflater.from(paramContext);
    parambv = new com.tencent.mm.av.a.a.c.a();
    parambv.ign = 1;
    parambv.igD = true;
    parambv.hgG = (com.tencent.mm.cb.a.iu(paramContext) / 3);
    parambv.hgF = (com.tencent.mm.cb.a.iu(paramContext) / 3);
    parambv.igy = 2131100734;
    this.fUx = parambv.aJu();
    AppMethodBeat.o(35938);
  }
  
  private static String cf(bv parambv)
  {
    AppMethodBeat.i(35944);
    Object localObject1;
    if ((parambv.cyG()) || (parambv.cyI()))
    {
      com.tencent.mm.modelvideo.o.aNh();
      localObject1 = t.HK(parambv.field_imgPath);
    }
    for (;;)
    {
      ae.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (parambv.fvK())
      {
        Object localObject3 = k.b.zb(parambv.field_content);
        localObject2 = null;
        parambv = (bv)localObject2;
        if (localObject3 != null)
        {
          parambv = (bv)localObject2;
          if (((k.b)localObject3).dlu != null)
          {
            parambv = (bv)localObject2;
            if (((k.b)localObject3).dlu.length() > 0)
            {
              localObject3 = ao.bJV().aMZ(((k.b)localObject3).dlu);
              parambv = (bv)localObject2;
              if (localObject3 != null) {
                parambv = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (parambv != null) {
          localObject2 = parambv;
        }
      }
      AppMethodBeat.o(35944);
      return localObject2;
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
  
  private static int i(k.b paramb)
  {
    AppMethodBeat.i(35942);
    if (paramb == null)
    {
      ae.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131689577");
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
    if ((paramb.type == 6) && (nNI.containsKey(bu.nullAsNil(paramb.hCD))))
    {
      ae.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + nNI.get(bu.nullAsNil(paramb.hCD)));
      int i = ((Integer)nNI.get(bu.nullAsNil(paramb.hCD))).intValue();
      AppMethodBeat.o(35942);
      return i;
    }
    AppMethodBeat.o(35942);
    return 2131689578;
  }
  
  private static int j(k.b paramb)
  {
    AppMethodBeat.i(35943);
    if (paramb == null)
    {
      ae.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131099914");
      AppMethodBeat.o(35943);
      return 2131099914;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      AppMethodBeat.o(35943);
      return 2131099915;
    }
    if ((paramb.type == 6) && (Kln.containsKey(bu.nullAsNil(paramb.hCD))))
    {
      ae.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + Kln.get(bu.nullAsNil(paramb.hCD)));
      int i = ((Integer)Kln.get(bu.nullAsNil(paramb.hCD))).intValue();
      AppMethodBeat.o(35943);
      return i;
    }
    AppMethodBeat.o(35943);
    return 2131099914;
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(35939);
    if (this.rCv)
    {
      bc.aCg();
      setCursor(com.tencent.mm.model.c.azJ().cc(this.fVg, this.KaB));
      AppMethodBeat.o(35939);
      return;
    }
    bc.aCg();
    setCursor(com.tencent.mm.model.c.azI().arh(this.fVg));
    AppMethodBeat.o(35939);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(35940);
    if (this.rCv)
    {
      bc.aCg();
      setCursor(com.tencent.mm.model.c.azJ().cc(this.fVg, this.KaB));
      AppMethodBeat.o(35940);
      return;
    }
    bc.aCg();
    setCursor(com.tencent.mm.model.c.azI().arh(this.fVg));
    AppMethodBeat.o(35940);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void cyE()
  {
    AppMethodBeat.i(35945);
    this.sDg = false;
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
      paramViewGroup.rKW = ((ImageView)paramView.findViewById(2131300612));
      paramViewGroup.rKX = paramView.findViewById(2131306404);
      paramViewGroup.Klr = ((TextView)paramView.findViewById(2131299925));
      paramViewGroup.Klr.setVisibility(8);
      paramViewGroup.Klq = ((ImageView)paramView.findViewById(2131299918));
      paramViewGroup.oZi = ((TextView)paramView.findViewById(2131306401));
      paramViewGroup.rKX.setVisibility(8);
      paramViewGroup.rKZ = paramView.findViewById(2131304817);
      paramViewGroup.rKZ.setVisibility(8);
      paramViewGroup.Kls = paramView.findViewById(2131299932);
      paramViewGroup.Kls.setVisibility(8);
      paramViewGroup.rKY = ((ImageView)paramView.findViewById(2131300615));
      paramViewGroup.iFD = ((CheckBox)paramView.findViewById(2131302204));
      paramViewGroup.rLa = paramView.findViewById(2131302205);
      paramView.setTag(paramViewGroup);
    }
    bv localbv;
    for (;;)
    {
      paramViewGroup.rKZ.setVisibility(8);
      paramViewGroup.rKX.setVisibility(8);
      paramViewGroup.Kls.setVisibility(8);
      paramViewGroup.Klr.setVisibility(8);
      localbv = (bv)getItem(paramInt);
      if (localbv != null) {
        break;
      }
      AppMethodBeat.o(35941);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (this.oZq)
    {
      if (!(this.Kll instanceof ImageGalleryGridUI))
      {
        paramView = new IllegalArgumentException("the context should be ImageGalleryGridUI");
        AppMethodBeat.o(35941);
        throw paramView;
      }
      localObject2 = localbv.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aB((String)localObject2, localbv.field_reserved);
      }
      if (this.Kll.Klt == paramInt)
      {
        paramViewGroup.rKY.setVisibility(0);
        if ((b.bY(localbv)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
        {
          paramViewGroup.Klq.setImageDrawable(this.Kll.getResources().getDrawable(i((k.b)localObject1)));
          paramViewGroup.rKW.setImageResource(j((k.b)localObject1));
          paramViewGroup.rKW.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.rKW.getMeasuredWidth();
          i = paramViewGroup.rKW.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label774;
          }
          label445:
          if (!b.m(localbv)) {
            break label808;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.rKX.setVisibility(0);
            localObject1 = j.cp(localbv);
            if (localObject1 != null) {
              paramViewGroup.oZi.setText(bu.rb(((s)localObject1).hKI));
            }
          }
          label492:
          paramViewGroup.iFD.setChecked(h.a.fKb().co(localbv));
          paramViewGroup.iFD.setTag(localbv);
          paramViewGroup.rLa.setTag(paramViewGroup);
          paramViewGroup.rLa.setOnClickListener(this);
          if (!h.a.fKb().rKJ) {
            break label979;
          }
          paramViewGroup.iFD.setVisibility(0);
          paramViewGroup.rLa.setVisibility(0);
          paramViewGroup.rKY.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35941);
      return paramView;
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.Klq.setImageDrawable(this.Kll.getResources().getDrawable(i((k.b)localObject1)));
      }
      q.aJb().a(cf(localbv), paramViewGroup.rKW, this.fUx, new com.tencent.mm.av.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(35937);
          ar.f(new Runnable()
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
      paramViewGroup.rKY.setVisibility(0);
      paramViewGroup.rKY.setBackgroundResource(2131100506);
      if ((b.bY(localbv)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
      {
        paramViewGroup.Klq.setImageDrawable(this.Kll.getResources().getDrawable(i((k.b)localObject1)));
        paramViewGroup.rKW.setImageResource(j((k.b)localObject1));
        break;
      }
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.Klq.setImageDrawable(this.Kll.getResources().getDrawable(i((k.b)localObject1)));
      }
      q.aJb().a(cf(localbv), paramViewGroup.rKW, this.fUx);
      break;
      label774:
      localObject2 = paramViewGroup.rKY.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.rKY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label445;
      label808:
      if (b.bX(localbv))
      {
        paramViewGroup.rKZ.setVisibility(0);
        break label492;
      }
      if ((!b.bY(localbv)) || (paramViewGroup == null)) {
        break label492;
      }
      paramViewGroup.Kls.setVisibility(0);
      paramViewGroup.Klr.setVisibility(0);
      if (localObject1 == null) {
        break label492;
      }
      ae.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { bu.nullAsNil(((k.b)localObject1).title) });
      if (((k.b)localObject1).type != 24)
      {
        paramViewGroup.Klr.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, bu.nullAsNil(((k.b)localObject1).title), paramViewGroup.Klr.getTextSize()));
        break label492;
      }
      paramViewGroup.Klr.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramViewGroup.Klr.getContext(), paramViewGroup.Klr.getContext().getString(2131759034), paramViewGroup.Klr.getTextSize()));
      break label492;
      paramViewGroup.rKW.setImageResource(2131233476);
      break label492;
      label979:
      paramViewGroup.iFD.setVisibility(8);
      paramViewGroup.rLa.setVisibility(8);
      paramViewGroup.rKY.setVisibility(8);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35946);
    super.notifyDataSetChanged();
    this.Klm = false;
    AppMethodBeat.o(35946);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35947);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    paramView = (a)paramView.getTag();
    if (paramView.iFD == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
    }
    localObject = (bv)paramView.iFD.getTag();
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
    }
    h localh = h.a.fKb();
    if (localh.co((bv)localObject))
    {
      localh.cn((bv)localObject);
      if (!h.a.fKb().co((bv)localObject)) {
        break label232;
      }
      paramView.iFD.setChecked(true);
      paramView.rKY.setBackgroundResource(2131100482);
    }
    for (;;)
    {
      if ((!this.sDg) && (h.a.fKb().rKI.size() > 1))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 20L, 1L, true);
        this.sDg = true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
      localh.cm((bv)localObject);
      break;
      label232:
      paramView.iFD.setChecked(false);
      paramView.rKY.setBackgroundResource(2131100506);
    }
  }
  
  protected static final class a
  {
    public ImageView Klq;
    public TextView Klr;
    public View Kls;
    public CheckBox iFD;
    public TextView oZi;
    public ImageView rKW;
    public View rKX;
    public ImageView rKY;
    public View rKZ;
    public View rLa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c
 * JD-Core Version:    0.7.0.1
 */