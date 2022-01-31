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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.r;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
  extends r<bi>
  implements View.OnClickListener
{
  private static Map<String, Integer> kbL;
  private static Map<String, Integer> vuv;
  private LayoutInflater Lu;
  String drJ;
  protected com.tencent.mm.as.a.a.c drd = null;
  boolean kax;
  private boolean khG;
  Context mContext;
  public boolean nHq = false;
  long voj;
  private final ImageGalleryGridUI vut;
  boolean vuu = false;
  
  static
  {
    HashMap localHashMap = new HashMap();
    kbL = localHashMap;
    localHashMap.put("avi", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("m4v", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("vob", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("mpeg", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("mpe", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("asx", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("asf", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("f4v", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("flv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("mkv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("wmv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("wm", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("3gp", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("mp4", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("rmvb", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("rm", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("ra", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("ram", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
    kbL.put("mp3pro", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("vqf", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("cd", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("md", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("mod", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("vorbis", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("au", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("amr", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("silk", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("wma", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("mmf", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("mid", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("midi", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("mp3", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("aac", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("ape", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("aiff", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("aif", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
    kbL.put("doc", Integer.valueOf(R.k.app_attach_file_icon_word_in_gird));
    kbL.put("docx", Integer.valueOf(R.k.app_attach_file_icon_word_in_gird));
    kbL.put("ppt", Integer.valueOf(R.k.app_attach_file_icon_ppt_in_gird));
    kbL.put("pptx", Integer.valueOf(R.k.app_attach_file_icon_ppt_in_gird));
    kbL.put("xls", Integer.valueOf(R.k.app_attach_file_icon_excel_in_gird));
    kbL.put("xlsx", Integer.valueOf(R.k.app_attach_file_icon_excel_in_gird));
    kbL.put("pdf", Integer.valueOf(R.k.app_attach_file_icon_pdf_in_gird));
    kbL.put("unknown", Integer.valueOf(R.k.app_attach_file_icon_unknow_in_gird));
    localHashMap = new HashMap();
    vuv = localHashMap;
    localHashMap.put("doc", Integer.valueOf(R.e.app_attach_file_bg_doc_in_gird));
    vuv.put("docx", Integer.valueOf(R.e.app_attach_file_bg_doc_in_gird));
    vuv.put("ppt", Integer.valueOf(R.e.app_attach_file_bg_ppt_in_gird));
    vuv.put("pptx", Integer.valueOf(R.e.app_attach_file_bg_ppt_in_gird));
    vuv.put("xls", Integer.valueOf(R.e.app_attach_file_bg_xls_in_gird));
    vuv.put("xlsx", Integer.valueOf(R.e.app_attach_file_bg_xls_in_gird));
    vuv.put("pdf", Integer.valueOf(R.e.app_attach_file_bg_pdf_in_gird));
    vuv.put("unknown", Integer.valueOf(R.e.app_attach_file_bg_unknow_in_gird));
    vuv.put("mp3pro", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("vqf", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("cd", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("md", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("mod", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("vorbis", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("au", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("amr", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("silk", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("wma", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("mmf", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("mid", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("midi", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("mp3", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("aac", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("ape", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("aiff", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    vuv.put("aif", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
  }
  
  public d(Context paramContext, bi parambi, String paramString)
  {
    super(paramContext, parambi);
    this.vut = ((ImageGalleryGridUI)paramContext);
    this.drJ = paramString;
    this.kax = f.eW(this.drJ);
    if (this.kax) {
      this.voj = parambi.field_bizChatId;
    }
    au.Hx();
    this.khG = com.tencent.mm.model.c.isSDCardAvailable();
    this.Lu = LayoutInflater.from(paramContext);
    parambi = new c.a();
    parambi.erk = 1;
    parambi.erF = true;
    parambi.erm = (com.tencent.mm.cb.a.fj(paramContext) / 3);
    parambi.erl = (com.tencent.mm.cb.a.fj(paramContext) / 3);
    parambi.ery = R.e.pic_thum_bg_color;
    this.drd = parambi.OV();
  }
  
  private static String bp(bi parambi)
  {
    Object localObject1;
    if ((parambi.aRQ()) || (parambi.aRR()))
    {
      com.tencent.mm.modelvideo.o.Sr();
      localObject1 = t.nT(parambi.field_imgPath);
    }
    for (;;)
    {
      y.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (parambi.cvr())
      {
        Object localObject3 = g.a.gp(parambi.field_content);
        localObject2 = null;
        parambi = (bi)localObject2;
        if (localObject3 != null)
        {
          parambi = (bi)localObject2;
          if (((g.a)localObject3).bFE != null)
          {
            parambi = (bi)localObject2;
            if (((g.a)localObject3).bFE.length() > 0)
            {
              localObject3 = ap.avh().VQ(((g.a)localObject3).bFE);
              parambi = (bi)localObject2;
              if (localObject3 != null) {
                parambi = ((b)localObject3).field_fileFullPath;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (parambi != null) {
          localObject2 = parambi;
        }
      }
      return localObject2;
      localObject2 = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, false, false);
      localObject1 = localObject2;
      if (!ah.bl((String)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("hd"))
        {
          localObject1 = localObject2;
          if (e.bK((String)localObject2 + "hd")) {
            localObject1 = (String)localObject2 + "hd";
          }
        }
      }
    }
  }
  
  private static int f(g.a parama)
  {
    if (parama == null)
    {
      y.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.k.app_attach_file_icon_unknow);
      return R.k.app_attach_file_icon_unknow_in_gird;
    }
    if ((parama.type == 5) || (parama.type == 7) || (parama.type == 15)) {
      return R.k.app_attach_file_icon_url_in_gird;
    }
    if (parama.type == 3) {
      return R.k.app_attach_file_icon_music_in_gird;
    }
    if ((parama.type == 6) && (kbL.containsKey(ah.pm(parama.dQw))))
    {
      y.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + kbL.get(ah.pm(parama.dQw)));
      return ((Integer)kbL.get(ah.pm(parama.dQw))).intValue();
    }
    return R.k.app_attach_file_icon_unknow_in_gird;
  }
  
  private static int g(g.a parama)
  {
    if (parama == null)
    {
      y.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.e.app_attach_file_bg_unknow_in_gird);
      return R.e.app_attach_file_bg_unknow_in_gird;
    }
    if ((parama.type == 5) || (parama.type == 7) || (parama.type == 15)) {
      return R.e.app_attach_file_bg_url_in_gird;
    }
    if ((parama.type == 6) && (vuv.containsKey(ah.pm(parama.dQw))))
    {
      y.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + vuv.get(ah.pm(parama.dQw)));
      return ((Integer)vuv.get(ah.pm(parama.dQw))).intValue();
    }
    return R.e.app_attach_file_bg_unknow_in_gird;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.Lu.inflate(R.i.image_gallary_grid_item, paramViewGroup, false);
      paramViewGroup = new d.a();
      paramViewGroup.khQ = ((ImageView)paramView.findViewById(R.h.grid_header_item));
      paramViewGroup.khR = paramView.findViewById(R.h.video_tips_root);
      paramViewGroup.vuz = ((TextView)paramView.findViewById(R.h.file_name_tv));
      paramViewGroup.vuz.setVisibility(8);
      paramViewGroup.vuy = ((ImageView)paramView.findViewById(R.h.file_icon));
      paramViewGroup.khS = ((TextView)paramView.findViewById(R.h.video_time_tv));
      paramViewGroup.khR.setVisibility(8);
      paramViewGroup.khU = paramView.findViewById(R.h.sight_tips_root);
      paramViewGroup.khU.setVisibility(8);
      paramViewGroup.vuA = paramView.findViewById(R.h.file_tips_root);
      paramViewGroup.vuA.setVisibility(8);
      paramViewGroup.khT = ((ImageView)paramView.findViewById(R.h.grid_selected_item_mask));
      paramViewGroup.khV = ((CheckBox)paramView.findViewById(R.h.media_cbx));
      paramViewGroup.khW = paramView.findViewById(R.h.media_cbx_clickarea);
      paramView.setTag(paramViewGroup);
    }
    bi localbi;
    for (;;)
    {
      paramViewGroup.khU.setVisibility(8);
      paramViewGroup.khR.setVisibility(8);
      paramViewGroup.vuA.setVisibility(8);
      paramViewGroup.vuz.setVisibility(8);
      localbi = (bi)getItem(paramInt);
      if (localbi != null) {
        break;
      }
      return paramView;
      paramViewGroup = (d.a)paramView.getTag();
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (this.khG)
    {
      if (!(this.vut instanceof ImageGalleryGridUI)) {
        throw new IllegalArgumentException("the context should be ImageGalleryGridUI");
      }
      localObject2 = localbi.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = g.a.M((String)localObject2, localbi.field_reserved);
      }
      if (this.vut.vuB == paramInt)
      {
        paramViewGroup.khT.setVisibility(0);
        if ((c.bh(localbi)) && (localObject1 != null) && (((g.a)localObject1).type != 3))
        {
          paramViewGroup.vuy.setImageDrawable(this.vut.getResources().getDrawable(f((g.a)localObject1)));
          paramViewGroup.khQ.setImageResource(g((g.a)localObject1));
          paramViewGroup.khQ.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.khQ.getMeasuredWidth();
          i = paramViewGroup.khQ.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label748;
          }
          label425:
          if (!c.bf(localbi)) {
            break label782;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.khR.setVisibility(0);
            localObject1 = j.bz(localbi);
            if (localObject1 != null) {
              paramViewGroup.khS.setText(ah.jL(((s)localObject1).eHH));
            }
          }
        }
      }
    }
    for (;;)
    {
      paramViewGroup.khV.setChecked(h.a.cGc().bx(localbi));
      paramViewGroup.khV.setTag(localbi);
      paramViewGroup.khW.setTag(paramViewGroup);
      paramViewGroup.khW.setOnClickListener(this);
      if (!h.a.cGc().khC) {
        break label953;
      }
      paramViewGroup.khV.setVisibility(0);
      paramViewGroup.khW.setVisibility(0);
      paramViewGroup.khT.setVisibility(0);
      return paramView;
      if ((localObject1 != null) && (((g.a)localObject1).type == 3)) {
        paramViewGroup.vuy.setImageDrawable(this.vut.getResources().getDrawable(f((g.a)localObject1)));
      }
      com.tencent.mm.as.o.ON().a(bp(localbi), paramViewGroup.khQ, this.drd, new d.1(this));
      break;
      paramViewGroup.khT.setVisibility(0);
      paramViewGroup.khT.setBackgroundResource(R.e.image_gallery_mask);
      if ((c.bh(localbi)) && (localObject1 != null) && (((g.a)localObject1).type != 3))
      {
        paramViewGroup.vuy.setImageDrawable(this.vut.getResources().getDrawable(f((g.a)localObject1)));
        paramViewGroup.khQ.setImageResource(g((g.a)localObject1));
        break;
      }
      if ((localObject1 != null) && (((g.a)localObject1).type == 3)) {
        paramViewGroup.vuy.setImageDrawable(this.vut.getResources().getDrawable(f((g.a)localObject1)));
      }
      com.tencent.mm.as.o.ON().a(bp(localbi), paramViewGroup.khQ, this.drd);
      break;
      label748:
      localObject2 = paramViewGroup.khT.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.khT.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label425;
      label782:
      if (c.bg(localbi))
      {
        paramViewGroup.khU.setVisibility(0);
      }
      else if ((c.bh(localbi)) && (paramViewGroup != null))
      {
        paramViewGroup.vuA.setVisibility(0);
        paramViewGroup.vuz.setVisibility(0);
        if (localObject1 != null)
        {
          y.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { ah.pm(((g.a)localObject1).title) });
          if (((g.a)localObject1).type != 24)
          {
            paramViewGroup.vuz.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, ah.pm(((g.a)localObject1).title), paramViewGroup.vuz.getTextSize()));
          }
          else
          {
            paramViewGroup.vuz.setText(com.tencent.mm.pluginsdk.ui.d.j.a(paramViewGroup.vuz.getContext(), paramViewGroup.vuz.getContext().getString(R.l.favorite_wenote), paramViewGroup.vuz.getTextSize()));
            continue;
            paramViewGroup.khQ.setImageResource(R.g.nosdcard_chatting_bg);
          }
        }
      }
    }
    label953:
    paramViewGroup.khV.setVisibility(8);
    paramViewGroup.khW.setVisibility(8);
    paramViewGroup.khT.setVisibility(8);
    return paramView;
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.vuu = false;
  }
  
  public final void onClick(View paramView)
  {
    paramView = (d.a)paramView.getTag();
    if (paramView.khV == null) {}
    label145:
    for (;;)
    {
      return;
      bi localbi = (bi)paramView.khV.getTag();
      if (localbi != null)
      {
        h localh = h.a.cGc();
        if (localh.bx(localbi))
        {
          localh.bw(localbi);
          if (!h.a.cGc().bx(localbi)) {
            break label126;
          }
          paramView.khV.setChecked(true);
          paramView.khT.setBackgroundResource(R.e.half_alpha_black);
        }
        for (;;)
        {
          if ((this.nHq) || (h.a.cGc().khB.size() <= 1)) {
            break label145;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 20L, 1L, true);
          this.nHq = true;
          return;
          localh.bv(localbi);
          break;
          label126:
          paramView.khV.setChecked(false);
          paramView.khT.setBackgroundResource(R.e.image_gallery_mask);
        }
      }
    }
  }
  
  public final void yc()
  {
    if (this.kax)
    {
      au.Hx();
      setCursor(com.tencent.mm.model.c.Fz().au(this.drJ, this.voj));
      return;
    }
    au.Hx();
    setCursor(com.tencent.mm.model.c.Fy().HE(this.drJ));
  }
  
  protected final void yd()
  {
    if (this.kax)
    {
      au.Hx();
      setCursor(com.tencent.mm.model.c.Fz().au(this.drJ, this.voj));
      return;
    }
    au.Hx();
    setCursor(com.tencent.mm.model.c.Fy().HE(this.drJ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d
 * JD-Core Version:    0.7.0.1
 */