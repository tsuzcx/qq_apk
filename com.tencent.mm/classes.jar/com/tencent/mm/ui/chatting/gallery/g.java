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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.v;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
  extends v<ca>
  implements View.OnClickListener
{
  private static Map<String, Integer> WRK;
  private static Map<String, Integer> saE;
  public boolean Aaj;
  long WFI;
  private final ImageGalleryGridUI WRI;
  boolean WRJ;
  protected com.tencent.mm.ay.a.a.c jjH;
  String jkq;
  Context mContext;
  private LayoutInflater mInflater;
  private boolean tMW;
  boolean wIf;
  
  static
  {
    AppMethodBeat.i(35949);
    HashMap localHashMap = new HashMap();
    saE = localHashMap;
    localHashMap.put("avi", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("m4v", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("vob", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("mpeg", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("mpe", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("asx", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("asf", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("f4v", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("flv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("mkv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("wmv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("wm", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("3gp", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("mp4", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("rmvb", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("rm", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("ra", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("ram", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    saE.put("mp3pro", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("vqf", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("cd", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("md", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("mod", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("vorbis", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("au", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("amr", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("silk", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("wma", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("mmf", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("mid", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("midi", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("mp3", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("aac", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("ape", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("aiff", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("aif", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    saE.put("doc", Integer.valueOf(R.k.app_attach_file_icon_word_in_gird));
    saE.put("docx", Integer.valueOf(R.k.app_attach_file_icon_word_in_gird));
    saE.put("ppt", Integer.valueOf(R.k.app_attach_file_icon_ppt_in_gird));
    saE.put("pptx", Integer.valueOf(R.k.app_attach_file_icon_ppt_in_gird));
    saE.put("xls", Integer.valueOf(R.k.app_attach_file_icon_excel_in_gird));
    saE.put("xlsx", Integer.valueOf(R.k.app_attach_file_icon_excel_in_gird));
    saE.put("pdf", Integer.valueOf(R.k.app_attach_file_icon_pdf_in_gird));
    saE.put("unknown", Integer.valueOf(R.k.app_attach_file_icon_unknow_in_gird));
    localHashMap = new HashMap();
    WRK = localHashMap;
    localHashMap.put("doc", Integer.valueOf(R.e.djX));
    WRK.put("docx", Integer.valueOf(R.e.djX));
    WRK.put("ppt", Integer.valueOf(R.e.dka));
    WRK.put("pptx", Integer.valueOf(R.e.dka));
    WRK.put("xls", Integer.valueOf(R.e.dkd));
    WRK.put("xlsx", Integer.valueOf(R.e.dkd));
    WRK.put("pdf", Integer.valueOf(R.e.djZ));
    WRK.put("unknown", Integer.valueOf(R.e.dkb));
    WRK.put("mp3pro", Integer.valueOf(R.e.djY));
    WRK.put("vqf", Integer.valueOf(R.e.djY));
    WRK.put("cd", Integer.valueOf(R.e.djY));
    WRK.put("md", Integer.valueOf(R.e.djY));
    WRK.put("mod", Integer.valueOf(R.e.djY));
    WRK.put("vorbis", Integer.valueOf(R.e.djY));
    WRK.put("au", Integer.valueOf(R.e.djY));
    WRK.put("amr", Integer.valueOf(R.e.djY));
    WRK.put("silk", Integer.valueOf(R.e.djY));
    WRK.put("wma", Integer.valueOf(R.e.djY));
    WRK.put("mmf", Integer.valueOf(R.e.djY));
    WRK.put("mid", Integer.valueOf(R.e.djY));
    WRK.put("midi", Integer.valueOf(R.e.djY));
    WRK.put("mp3", Integer.valueOf(R.e.djY));
    WRK.put("aac", Integer.valueOf(R.e.djY));
    WRK.put("ape", Integer.valueOf(R.e.djY));
    WRK.put("aiff", Integer.valueOf(R.e.djY));
    WRK.put("aif", Integer.valueOf(R.e.djY));
    AppMethodBeat.o(35949);
  }
  
  public g(Context paramContext, ca paramca, String paramString)
  {
    super(paramContext, paramca);
    AppMethodBeat.i(35938);
    this.jjH = null;
    this.WRJ = false;
    this.Aaj = false;
    this.WRI = ((ImageGalleryGridUI)paramContext);
    this.jkq = paramString;
    this.wIf = com.tencent.mm.ao.g.KI(this.jkq);
    if (this.wIf) {
      this.WFI = paramca.field_bizChatId;
    }
    bh.beI();
    this.tMW = com.tencent.mm.model.c.isSDCardAvailable();
    this.mInflater = LayoutInflater.from(paramContext);
    paramca = new c.a();
    paramca.lRG = 1;
    paramca.lRX = true;
    paramca.kOg = (com.tencent.mm.ci.a.kr(paramContext) / 3);
    paramca.kOf = (com.tencent.mm.ci.a.kr(paramContext) / 3);
    paramca.lRS = R.e.pic_thum_bg_color;
    this.jjH = paramca.bmL();
    AppMethodBeat.o(35938);
  }
  
  private static String cR(ca paramca)
  {
    AppMethodBeat.i(35944);
    Object localObject1;
    if ((paramca.dlR()) || (paramca.dlT()))
    {
      s.bqB();
      localObject1 = x.XU(paramca.field_imgPath);
    }
    for (;;)
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (paramca.hzF())
      {
        Object localObject3 = k.b.OQ(paramca.field_content);
        localObject2 = null;
        paramca = (ca)localObject2;
        if (localObject3 != null)
        {
          paramca = (ca)localObject2;
          if (((k.b)localObject3).fvr != null)
          {
            paramca = (ca)localObject2;
            if (((k.b)localObject3).fvr.length() > 0)
            {
              localObject3 = ao.ctZ().bpR(((k.b)localObject3).fvr);
              paramca = (ca)localObject2;
              if (localObject3 != null) {
                paramca = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (paramca != null) {
          localObject2 = paramca;
        }
      }
      AppMethodBeat.o(35944);
      return localObject2;
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
  
  private static int j(k.b paramb)
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
    if ((paramb.type == 6) && (saE.containsKey(Util.nullAsNil(paramb.llY))))
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + saE.get(Util.nullAsNil(paramb.llY)));
      i = ((Integer)saE.get(Util.nullAsNil(paramb.llY))).intValue();
      AppMethodBeat.o(35942);
      return i;
    }
    int i = R.k.app_attach_file_icon_unknow_in_gird;
    AppMethodBeat.o(35942);
    return i;
  }
  
  private static int k(k.b paramb)
  {
    AppMethodBeat.i(35943);
    if (paramb == null)
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.e.dkb);
      i = R.e.dkb;
      AppMethodBeat.o(35943);
      return i;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      i = R.e.dkc;
      AppMethodBeat.o(35943);
      return i;
    }
    if ((paramb.type == 6) && (WRK.containsKey(Util.nullAsNil(paramb.llY))))
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + WRK.get(Util.nullAsNil(paramb.llY)));
      i = ((Integer)WRK.get(Util.nullAsNil(paramb.llY))).intValue();
      AppMethodBeat.o(35943);
      return i;
    }
    int i = R.e.dkb;
    AppMethodBeat.o(35943);
    return i;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void atr()
  {
    AppMethodBeat.i(35939);
    if (this.wIf)
    {
      bh.beI();
      v(com.tencent.mm.model.c.bbP().cf(this.jkq, this.WFI));
      AppMethodBeat.o(35939);
      return;
    }
    bh.beI();
    v(com.tencent.mm.model.c.bbO().aOM(this.jkq));
    AppMethodBeat.o(35939);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(35940);
    if (this.wIf)
    {
      bh.beI();
      v(com.tencent.mm.model.c.bbP().cf(this.jkq, this.WFI));
      AppMethodBeat.o(35940);
      return;
    }
    bh.beI();
    v(com.tencent.mm.model.c.bbO().aOM(this.jkq));
    AppMethodBeat.o(35940);
  }
  
  public final void dlP()
  {
    AppMethodBeat.i(35945);
    this.Aaj = false;
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
      paramView = this.mInflater.inflate(R.i.ehA, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.wRg = ((ImageView)paramView.findViewById(R.h.grid_header_item));
      paramViewGroup.wRh = paramView.findViewById(R.h.video_tips_root);
      paramViewGroup.WRO = ((TextView)paramView.findViewById(R.h.file_name_tv));
      paramViewGroup.WRO.setVisibility(8);
      paramViewGroup.WRN = ((ImageView)paramView.findViewById(R.h.file_icon));
      paramViewGroup.tMO = ((TextView)paramView.findViewById(R.h.video_time_tv));
      paramViewGroup.wRh.setVisibility(8);
      paramViewGroup.wRj = paramView.findViewById(R.h.sight_tips_root);
      paramViewGroup.wRj.setVisibility(8);
      paramViewGroup.WRP = paramView.findViewById(R.h.file_tips_root);
      paramViewGroup.WRP.setVisibility(8);
      paramViewGroup.wRi = ((ImageView)paramView.findViewById(R.h.grid_selected_item_mask));
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(R.h.media_cbx));
      paramViewGroup.wRk = paramView.findViewById(R.h.media_cbx_clickarea);
      paramView.setTag(paramViewGroup);
    }
    ca localca;
    for (;;)
    {
      paramViewGroup.wRj.setVisibility(8);
      paramViewGroup.wRh.setVisibility(8);
      paramViewGroup.WRP.setVisibility(8);
      paramViewGroup.WRO.setVisibility(8);
      localca = (ca)getItem(paramInt);
      if (localca != null) {
        break;
      }
      AppMethodBeat.o(35941);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (this.tMW)
    {
      if (!(this.WRI instanceof ImageGalleryGridUI))
      {
        paramView = new IllegalArgumentException("the context should be ImageGalleryGridUI");
        AppMethodBeat.o(35941);
        throw paramView;
      }
      localObject2 = localca.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aG((String)localObject2, localca.field_reserved);
      }
      if (this.WRI.WRQ == paramInt)
      {
        paramViewGroup.wRi.setVisibility(0);
        if ((f.cK(localca)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
        {
          paramViewGroup.WRN.setImageDrawable(this.WRI.getResources().getDrawable(j((k.b)localObject1)));
          paramViewGroup.wRg.setImageResource(k((k.b)localObject1));
          paramViewGroup.wRg.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.wRg.getMeasuredWidth();
          i = paramViewGroup.wRg.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label774;
          }
          label445:
          if (!f.m(localca)) {
            break label808;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.wRh.setVisibility(0);
            localObject1 = n.cH(localca);
            if (localObject1 != null) {
              paramViewGroup.tMO.setText(Util.formatSecToMin(((w)localObject1).lvw));
            }
          }
          label492:
          paramViewGroup.checkBox.setChecked(l.a.hRO().da(localca));
          paramViewGroup.checkBox.setTag(localca);
          paramViewGroup.wRk.setTag(paramViewGroup);
          paramViewGroup.wRk.setOnClickListener(this);
          if (!l.a.hRO().wQL) {
            break label979;
          }
          paramViewGroup.checkBox.setVisibility(0);
          paramViewGroup.wRk.setVisibility(0);
          paramViewGroup.wRi.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35941);
      return paramView;
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.WRN.setImageDrawable(this.WRI.getResources().getDrawable(j((k.b)localObject1)));
      }
      q.bml().a(cR(localca), paramViewGroup.wRg, this.jjH, new k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(35937);
          MMHandlerThread.postToMainThread(new Runnable()
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
      paramViewGroup.wRi.setVisibility(0);
      paramViewGroup.wRi.setBackgroundResource(R.e.image_gallery_mask);
      if ((f.cK(localca)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
      {
        paramViewGroup.WRN.setImageDrawable(this.WRI.getResources().getDrawable(j((k.b)localObject1)));
        paramViewGroup.wRg.setImageResource(k((k.b)localObject1));
        break;
      }
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.WRN.setImageDrawable(this.WRI.getResources().getDrawable(j((k.b)localObject1)));
      }
      q.bml().a(cR(localca), paramViewGroup.wRg, this.jjH);
      break;
      label774:
      localObject2 = paramViewGroup.wRi.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.wRi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label445;
      label808:
      if (f.cJ(localca))
      {
        paramViewGroup.wRj.setVisibility(0);
        break label492;
      }
      if ((!f.cK(localca)) || (paramViewGroup == null)) {
        break label492;
      }
      paramViewGroup.WRP.setVisibility(0);
      paramViewGroup.WRO.setVisibility(0);
      if (localObject1 == null) {
        break label492;
      }
      Log.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { Util.nullAsNil(((k.b)localObject1).title) });
      if (((k.b)localObject1).type != 24)
      {
        paramViewGroup.WRO.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, Util.nullAsNil(((k.b)localObject1).title), paramViewGroup.WRO.getTextSize()));
        break label492;
      }
      paramViewGroup.WRO.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramViewGroup.WRO.getContext(), paramViewGroup.WRO.getContext().getString(R.l.favorite_wenote), paramViewGroup.WRO.getTextSize()));
      break label492;
      paramViewGroup.wRg.setImageResource(R.g.nosdcard_chatting_bg);
      break label492;
      label979:
      paramViewGroup.checkBox.setVisibility(8);
      paramViewGroup.wRk.setVisibility(8);
      paramViewGroup.wRi.setVisibility(8);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35946);
    super.notifyDataSetChanged();
    this.WRJ = false;
    AppMethodBeat.o(35946);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35947);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = (a)paramView.getTag();
    if (paramView.checkBox == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
    }
    localObject = (ca)paramView.checkBox.getTag();
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
    }
    l locall = l.a.hRO();
    if (locall.da((ca)localObject))
    {
      locall.cZ((ca)localObject);
      if (!l.a.hRO().da((ca)localObject)) {
        break label232;
      }
      paramView.checkBox.setChecked(true);
      paramView.wRi.setBackgroundResource(R.e.half_alpha_black);
    }
    for (;;)
    {
      if ((!this.Aaj) && (l.a.hRO().wQK.size() > 1))
      {
        h.IzE.idkeyStat(219L, 20L, 1L, true);
        this.Aaj = true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
      locall.cY((ca)localObject);
      break;
      label232:
      paramView.checkBox.setChecked(false);
      paramView.wRi.setBackgroundResource(R.e.image_gallery_mask);
    }
  }
  
  protected static final class a
  {
    public ImageView WRN;
    public TextView WRO;
    public View WRP;
    public CheckBox checkBox;
    public TextView tMO;
    public ImageView wRg;
    public View wRh;
    public ImageView wRi;
    public View wRj;
    public View wRk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.g
 * JD-Core Version:    0.7.0.1
 */