package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.x;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i
  extends x<cc>
  implements View.OnClickListener
{
  private static Map<String, Integer> aeBp;
  private static Map<String, Integer> vlV;
  boolean Aet;
  private final ImageGalleryGridUI aeBn;
  boolean aeBo;
  long aenl;
  public boolean lAr;
  String lMU;
  protected com.tencent.mm.modelimage.loader.a.c lMm;
  Context mContext;
  private LayoutInflater mInflater;
  private boolean wQm;
  
  static
  {
    AppMethodBeat.i(35949);
    HashMap localHashMap = new HashMap();
    vlV = localHashMap;
    localHashMap.put("avi", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("m4v", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("vob", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("mpeg", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("mpe", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("asx", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("asf", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("f4v", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("flv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("mkv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("wmv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("wm", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("3gp", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("mp4", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("rmvb", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("rm", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("ra", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("ram", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    vlV.put("mp3pro", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("vqf", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("cd", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("md", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("mod", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("vorbis", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("au", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("amr", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("silk", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("wma", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("mmf", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("mid", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("midi", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("mp3", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("aac", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("ape", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("aiff", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("aif", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    vlV.put("doc", Integer.valueOf(R.k.app_attach_file_icon_word_in_gird));
    vlV.put("docx", Integer.valueOf(R.k.app_attach_file_icon_word_in_gird));
    vlV.put("ppt", Integer.valueOf(R.k.app_attach_file_icon_ppt_in_gird));
    vlV.put("pptx", Integer.valueOf(R.k.app_attach_file_icon_ppt_in_gird));
    vlV.put("xls", Integer.valueOf(R.k.app_attach_file_icon_excel_in_gird));
    vlV.put("xlsx", Integer.valueOf(R.k.app_attach_file_icon_excel_in_gird));
    vlV.put("pdf", Integer.valueOf(R.k.app_attach_file_icon_pdf_in_gird));
    vlV.put("unknown", Integer.valueOf(R.k.app_attach_file_icon_unknow_in_gird));
    localHashMap = new HashMap();
    aeBp = localHashMap;
    localHashMap.put("doc", Integer.valueOf(R.e.fjY));
    aeBp.put("docx", Integer.valueOf(R.e.fjY));
    aeBp.put("ppt", Integer.valueOf(R.e.fkb));
    aeBp.put("pptx", Integer.valueOf(R.e.fkb));
    aeBp.put("xls", Integer.valueOf(R.e.fke));
    aeBp.put("xlsx", Integer.valueOf(R.e.fke));
    aeBp.put("pdf", Integer.valueOf(R.e.fka));
    aeBp.put("unknown", Integer.valueOf(R.e.fkc));
    aeBp.put("mp3pro", Integer.valueOf(R.e.fjZ));
    aeBp.put("vqf", Integer.valueOf(R.e.fjZ));
    aeBp.put("cd", Integer.valueOf(R.e.fjZ));
    aeBp.put("md", Integer.valueOf(R.e.fjZ));
    aeBp.put("mod", Integer.valueOf(R.e.fjZ));
    aeBp.put("vorbis", Integer.valueOf(R.e.fjZ));
    aeBp.put("au", Integer.valueOf(R.e.fjZ));
    aeBp.put("amr", Integer.valueOf(R.e.fjZ));
    aeBp.put("silk", Integer.valueOf(R.e.fjZ));
    aeBp.put("wma", Integer.valueOf(R.e.fjZ));
    aeBp.put("mmf", Integer.valueOf(R.e.fjZ));
    aeBp.put("mid", Integer.valueOf(R.e.fjZ));
    aeBp.put("midi", Integer.valueOf(R.e.fjZ));
    aeBp.put("mp3", Integer.valueOf(R.e.fjZ));
    aeBp.put("aac", Integer.valueOf(R.e.fjZ));
    aeBp.put("ape", Integer.valueOf(R.e.fjZ));
    aeBp.put("aiff", Integer.valueOf(R.e.fjZ));
    aeBp.put("aif", Integer.valueOf(R.e.fjZ));
    AppMethodBeat.o(35949);
  }
  
  public i(Context paramContext, cc paramcc, String paramString)
  {
    super(paramContext, paramcc);
    AppMethodBeat.i(35938);
    this.lMm = null;
    this.aeBo = false;
    this.lAr = false;
    this.aeBn = ((ImageGalleryGridUI)paramContext);
    this.lMU = paramString;
    this.Aet = g.Dn(this.lMU);
    if (this.Aet) {
      this.aenl = paramcc.field_bizChatId;
    }
    bh.bCz();
    this.wQm = com.tencent.mm.model.c.isSDCardAvailable();
    this.mInflater = LayoutInflater.from(paramContext);
    paramcc = new c.a();
    paramcc.oKs = 1;
    paramcc.oKJ = true;
    paramcc.npV = (com.tencent.mm.cd.a.ms(paramContext) / 3);
    paramcc.npU = (com.tencent.mm.cd.a.ms(paramContext) / 3);
    paramcc.oKE = R.e.pic_thum_bg_color;
    this.lMm = paramcc.bKx();
    AppMethodBeat.o(35938);
  }
  
  private static String jdMethod_do(cc paramcc)
  {
    AppMethodBeat.i(35944);
    Object localObject1;
    if ((paramcc.dSH()) || (paramcc.dSJ()))
    {
      v.bOh();
      localObject1 = aa.PY(paramcc.field_imgPath);
    }
    for (;;)
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (paramcc.jbK())
      {
        Object localObject3 = k.b.Hf(paramcc.field_content);
        localObject2 = null;
        paramcc = (cc)localObject2;
        if (localObject3 != null)
        {
          paramcc = (cc)localObject2;
          if (((k.b)localObject3).hzM != null)
          {
            paramcc = (cc)localObject2;
            if (((k.b)localObject3).hzM.length() > 0)
            {
              localObject3 = as.cWJ().bpI(((k.b)localObject3).hzM);
              paramcc = (cc)localObject2;
              if (localObject3 != null) {
                paramcc = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (paramcc != null) {
          localObject2 = paramcc;
        }
      }
      AppMethodBeat.o(35944);
      return localObject2;
      localObject2 = r.bKa().d(paramcc.field_imgPath, false, false);
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("hd"))
        {
          localObject1 = localObject2;
          if (y.ZC((String)localObject2 + "hd")) {
            localObject1 = (String)localObject2 + "hd";
          }
        }
      }
    }
  }
  
  private static int k(k.b paramb)
  {
    AppMethodBeat.i(35942);
    if (paramb == null)
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.k.app_attach_file_icon_unknow);
      i = R.k.app_attach_file_icon_unknow_in_gird;
      AppMethodBeat.o(35942);
      return i;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      i = R.k.app_attach_file_icon_url_in_gird;
      AppMethodBeat.o(35942);
      return i;
    }
    if (paramb.type == 3)
    {
      i = R.k.app_attach_file_icon_music_in_gird;
      AppMethodBeat.o(35942);
      return i;
    }
    if ((paramb.type == 6) && (vlV.containsKey(Util.nullAsNil(paramb.nRe))))
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + vlV.get(Util.nullAsNil(paramb.nRe)));
      i = ((Integer)vlV.get(Util.nullAsNil(paramb.nRe))).intValue();
      AppMethodBeat.o(35942);
      return i;
    }
    int i = R.k.app_attach_file_icon_unknow_in_gird;
    AppMethodBeat.o(35942);
    return i;
  }
  
  private static int l(k.b paramb)
  {
    AppMethodBeat.i(35943);
    if (paramb == null)
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.e.fkc);
      i = R.e.fkc;
      AppMethodBeat.o(35943);
      return i;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      i = R.e.fkd;
      AppMethodBeat.o(35943);
      return i;
    }
    if ((paramb.type == 6) && (aeBp.containsKey(Util.nullAsNil(paramb.nRe))))
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + aeBp.get(Util.nullAsNil(paramb.nRe)));
      i = ((Integer)aeBp.get(Util.nullAsNil(paramb.nRe))).intValue();
      AppMethodBeat.o(35943);
      return i;
    }
    int i = R.e.fkc;
    AppMethodBeat.o(35943);
    return i;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(35939);
    if (this.Aet)
    {
      bh.bCz();
      w(com.tencent.mm.model.c.bzE().cr(this.lMU, this.aenl));
      AppMethodBeat.o(35939);
      return;
    }
    bh.bCz();
    w(com.tencent.mm.model.c.bzD().aLM(this.lMU));
    AppMethodBeat.o(35939);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(35940);
    if (this.Aet)
    {
      bh.bCz();
      w(com.tencent.mm.model.c.bzE().cr(this.lMU, this.aenl));
      AppMethodBeat.o(35940);
      return;
    }
    bh.bCz();
    w(com.tencent.mm.model.c.bzD().aLM(this.lMU));
    AppMethodBeat.o(35940);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void dSF()
  {
    AppMethodBeat.i(35945);
    this.lAr = false;
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
      paramView = this.mInflater.inflate(R.i.gkv, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.cqj = ((ImageView)paramView.findViewById(R.h.grid_header_item));
      paramViewGroup.AnK = paramView.findViewById(R.h.video_tips_root);
      paramViewGroup.aeBt = ((TextView)paramView.findViewById(R.h.file_name_tv));
      paramViewGroup.aeBt.setVisibility(8);
      paramViewGroup.aeBs = ((ImageView)paramView.findViewById(R.h.file_icon));
      paramViewGroup.wQe = ((TextView)paramView.findViewById(R.h.video_time_tv));
      paramViewGroup.AnK.setVisibility(8);
      paramViewGroup.AnM = paramView.findViewById(R.h.sight_tips_root);
      paramViewGroup.AnM.setVisibility(8);
      paramViewGroup.aeBu = paramView.findViewById(R.h.file_tips_root);
      paramViewGroup.aeBu.setVisibility(8);
      paramViewGroup.AnL = ((ImageView)paramView.findViewById(R.h.grid_selected_item_mask));
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(R.h.media_cbx));
      paramViewGroup.AnN = paramView.findViewById(R.h.media_cbx_clickarea);
      paramView.setTag(paramViewGroup);
    }
    cc localcc;
    for (;;)
    {
      paramViewGroup.AnM.setVisibility(8);
      paramViewGroup.AnK.setVisibility(8);
      paramViewGroup.aeBu.setVisibility(8);
      paramViewGroup.aeBt.setVisibility(8);
      localcc = (cc)getItem(paramInt);
      if (localcc != null) {
        break;
      }
      AppMethodBeat.o(35941);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (this.wQm)
    {
      if (!(this.aeBn instanceof ImageGalleryGridUI))
      {
        paramView = new IllegalArgumentException("the context should be ImageGalleryGridUI");
        AppMethodBeat.o(35941);
        throw paramView;
      }
      localObject2 = localcc.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aP((String)localObject2, localcc.field_reserved);
      }
      if (this.aeBn.aeBv == paramInt)
      {
        paramViewGroup.AnL.setVisibility(0);
        if ((h.dg(localcc)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
        {
          paramViewGroup.aeBs.setImageDrawable(this.aeBn.getResources().getDrawable(k((k.b)localObject1)));
          paramViewGroup.cqj.setImageResource(l((k.b)localObject1));
          paramViewGroup.cqj.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.cqj.getMeasuredWidth();
          i = paramViewGroup.cqj.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label774;
          }
          label445:
          if (!h.m(localcc)) {
            break label808;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.AnK.setVisibility(0);
            localObject1 = p.dd(localcc);
            if (localObject1 != null) {
              paramViewGroup.wQe.setText(Util.formatSecToMin(((z)localObject1).omT));
            }
          }
          label492:
          paramViewGroup.checkBox.setChecked(n.a.jvm().dx(localcc));
          paramViewGroup.checkBox.setTag(localcc);
          paramViewGroup.AnN.setTag(paramViewGroup);
          paramViewGroup.AnN.setOnClickListener(this);
          if (!n.a.jvm().Ano) {
            break label979;
          }
          paramViewGroup.checkBox.setVisibility(0);
          paramViewGroup.AnN.setVisibility(0);
          paramViewGroup.AnL.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35941);
      return paramView;
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.aeBs.setImageDrawable(this.aeBn.getResources().getDrawable(k((k.b)localObject1)));
      }
      r.bKe().a(jdMethod_do(localcc), paramViewGroup.cqj, this.lMm, new i.1(this));
      break;
      paramViewGroup.AnL.setVisibility(0);
      paramViewGroup.AnL.setBackgroundResource(R.e.image_gallery_mask);
      if ((h.dg(localcc)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
      {
        paramViewGroup.aeBs.setImageDrawable(this.aeBn.getResources().getDrawable(k((k.b)localObject1)));
        paramViewGroup.cqj.setImageResource(l((k.b)localObject1));
        break;
      }
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.aeBs.setImageDrawable(this.aeBn.getResources().getDrawable(k((k.b)localObject1)));
      }
      r.bKe().a(jdMethod_do(localcc), paramViewGroup.cqj, this.lMm);
      break;
      label774:
      localObject2 = paramViewGroup.AnL.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.AnL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label445;
      label808:
      if (h.df(localcc))
      {
        paramViewGroup.AnM.setVisibility(0);
        break label492;
      }
      if ((!h.dg(localcc)) || (paramViewGroup == null)) {
        break label492;
      }
      paramViewGroup.aeBu.setVisibility(0);
      paramViewGroup.aeBt.setVisibility(0);
      if (localObject1 == null) {
        break label492;
      }
      Log.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { Util.nullAsNil(((k.b)localObject1).title) });
      if (((k.b)localObject1).type != 24)
      {
        paramViewGroup.aeBt.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.mContext, Util.nullAsNil(((k.b)localObject1).title), paramViewGroup.aeBt.getTextSize()));
        break label492;
      }
      paramViewGroup.aeBt.setText(com.tencent.mm.pluginsdk.ui.span.p.b(paramViewGroup.aeBt.getContext(), paramViewGroup.aeBt.getContext().getString(R.l.favorite_wenote), paramViewGroup.aeBt.getTextSize()));
      break label492;
      paramViewGroup.cqj.setImageResource(R.g.nosdcard_chatting_bg);
      break label492;
      label979:
      paramViewGroup.checkBox.setVisibility(8);
      paramViewGroup.AnN.setVisibility(8);
      paramViewGroup.AnL.setVisibility(8);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35946);
    super.notifyDataSetChanged();
    this.aeBo = false;
    AppMethodBeat.o(35946);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35947);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = (a)paramView.getTag();
    if (paramView.checkBox == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
    }
    localObject = (cc)paramView.checkBox.getTag();
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
    }
    n localn = n.a.jvm();
    if (localn.dx((cc)localObject))
    {
      localn.dw((cc)localObject);
      if (!n.a.jvm().dx((cc)localObject)) {
        break label232;
      }
      paramView.checkBox.setChecked(true);
      paramView.AnL.setBackgroundResource(R.e.half_alpha_black);
    }
    for (;;)
    {
      if ((!this.lAr) && (n.a.jvm().Ann.size() > 1))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 20L, 1L, true);
        this.lAr = true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
      localn.dv((cc)localObject);
      break;
      label232:
      paramView.checkBox.setChecked(false);
      paramView.AnL.setBackgroundResource(R.e.image_gallery_mask);
    }
  }
  
  protected static final class a
  {
    public View AnK;
    public ImageView AnL;
    public View AnM;
    public View AnN;
    public ImageView aeBs;
    public TextView aeBt;
    public View aeBu;
    public CheckBox checkBox;
    public ImageView cqj;
    public TextView wQe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.i
 * JD-Core Version:    0.7.0.1
 */