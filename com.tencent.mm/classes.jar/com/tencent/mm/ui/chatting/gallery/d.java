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
import com.tencent.mm.af.j.b;
import com.tencent.mm.aj.f;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.g;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.p;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
  extends p<bi>
  implements View.OnClickListener
{
  private static Map<String, Integer> mwh;
  private static Map<String, Integer> zKw;
  protected com.tencent.mm.at.a.a.c eiK;
  String ejr;
  private boolean kFs;
  Context mContext;
  private LayoutInflater mInflater;
  boolean muT;
  public boolean quM;
  long zDF;
  private final ImageGalleryGridUI zKu;
  boolean zKv;
  
  static
  {
    AppMethodBeat.i(32033);
    HashMap localHashMap = new HashMap();
    mwh = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131230827));
    mwh.put("m4v", Integer.valueOf(2131230827));
    mwh.put("vob", Integer.valueOf(2131230827));
    mwh.put("mpeg", Integer.valueOf(2131230827));
    mwh.put("mpe", Integer.valueOf(2131230827));
    mwh.put("asx", Integer.valueOf(2131230827));
    mwh.put("asf", Integer.valueOf(2131230827));
    mwh.put("f4v", Integer.valueOf(2131230827));
    mwh.put("flv", Integer.valueOf(2131230827));
    mwh.put("mkv", Integer.valueOf(2131230827));
    mwh.put("wmv", Integer.valueOf(2131230827));
    mwh.put("wm", Integer.valueOf(2131230827));
    mwh.put("3gp", Integer.valueOf(2131230827));
    mwh.put("mp4", Integer.valueOf(2131230827));
    mwh.put("rmvb", Integer.valueOf(2131230827));
    mwh.put("rm", Integer.valueOf(2131230827));
    mwh.put("ra", Integer.valueOf(2131230827));
    mwh.put("ram", Integer.valueOf(2131230827));
    mwh.put("mp3pro", Integer.valueOf(2131230810));
    mwh.put("vqf", Integer.valueOf(2131230810));
    mwh.put("cd", Integer.valueOf(2131230810));
    mwh.put("md", Integer.valueOf(2131230810));
    mwh.put("mod", Integer.valueOf(2131230810));
    mwh.put("vorbis", Integer.valueOf(2131230810));
    mwh.put("au", Integer.valueOf(2131230810));
    mwh.put("amr", Integer.valueOf(2131230810));
    mwh.put("silk", Integer.valueOf(2131230810));
    mwh.put("wma", Integer.valueOf(2131230810));
    mwh.put("mmf", Integer.valueOf(2131230810));
    mwh.put("mid", Integer.valueOf(2131230810));
    mwh.put("midi", Integer.valueOf(2131230810));
    mwh.put("mp3", Integer.valueOf(2131230810));
    mwh.put("aac", Integer.valueOf(2131230810));
    mwh.put("ape", Integer.valueOf(2131230810));
    mwh.put("aiff", Integer.valueOf(2131230810));
    mwh.put("aif", Integer.valueOf(2131230810));
    mwh.put("doc", Integer.valueOf(2131230831));
    mwh.put("docx", Integer.valueOf(2131230831));
    mwh.put("ppt", Integer.valueOf(2131230817));
    mwh.put("pptx", Integer.valueOf(2131230817));
    mwh.put("xls", Integer.valueOf(2131230803));
    mwh.put("xlsx", Integer.valueOf(2131230803));
    mwh.put("pdf", Integer.valueOf(2131230814));
    mwh.put("unknown", Integer.valueOf(2131230823));
    localHashMap = new HashMap();
    zKw = localHashMap;
    localHashMap.put("doc", Integer.valueOf(2131689671));
    zKw.put("docx", Integer.valueOf(2131689671));
    zKw.put("ppt", Integer.valueOf(2131689674));
    zKw.put("pptx", Integer.valueOf(2131689674));
    zKw.put("xls", Integer.valueOf(2131689677));
    zKw.put("xlsx", Integer.valueOf(2131689677));
    zKw.put("pdf", Integer.valueOf(2131689673));
    zKw.put("unknown", Integer.valueOf(2131689675));
    zKw.put("mp3pro", Integer.valueOf(2131689672));
    zKw.put("vqf", Integer.valueOf(2131689672));
    zKw.put("cd", Integer.valueOf(2131689672));
    zKw.put("md", Integer.valueOf(2131689672));
    zKw.put("mod", Integer.valueOf(2131689672));
    zKw.put("vorbis", Integer.valueOf(2131689672));
    zKw.put("au", Integer.valueOf(2131689672));
    zKw.put("amr", Integer.valueOf(2131689672));
    zKw.put("silk", Integer.valueOf(2131689672));
    zKw.put("wma", Integer.valueOf(2131689672));
    zKw.put("mmf", Integer.valueOf(2131689672));
    zKw.put("mid", Integer.valueOf(2131689672));
    zKw.put("midi", Integer.valueOf(2131689672));
    zKw.put("mp3", Integer.valueOf(2131689672));
    zKw.put("aac", Integer.valueOf(2131689672));
    zKw.put("ape", Integer.valueOf(2131689672));
    zKw.put("aiff", Integer.valueOf(2131689672));
    zKw.put("aif", Integer.valueOf(2131689672));
    AppMethodBeat.o(32033);
  }
  
  public d(Context paramContext, bi parambi, String paramString)
  {
    super(paramContext, parambi);
    AppMethodBeat.i(32022);
    this.eiK = null;
    this.zKv = false;
    this.quM = false;
    this.zKu = ((ImageGalleryGridUI)paramContext);
    this.ejr = paramString;
    this.muT = f.lg(this.ejr);
    if (this.muT) {
      this.zDF = parambi.field_bizChatId;
    }
    aw.aaz();
    this.kFs = com.tencent.mm.model.c.isSDCardAvailable();
    this.mInflater = LayoutInflater.from(paramContext);
    parambi = new c.a();
    parambi.fHt = 1;
    parambi.eOf = true;
    parambi.eNT = (com.tencent.mm.cb.a.gw(paramContext) / 3);
    parambi.eNS = (com.tencent.mm.cb.a.gw(paramContext) / 3);
    parambi.eOa = 2131690341;
    this.eiK = parambi.ahY();
    AppMethodBeat.o(32022);
  }
  
  private static String by(bi parambi)
  {
    AppMethodBeat.i(32028);
    Object localObject1;
    if ((parambi.byj()) || (parambi.byk()))
    {
      com.tencent.mm.modelvideo.o.alE();
      localObject1 = t.vg(parambi.field_imgPath);
    }
    for (;;)
    {
      ab.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (parambi.dxV())
      {
        Object localObject3 = j.b.mY(parambi.field_content);
        localObject2 = null;
        parambi = (bi)localObject2;
        if (localObject3 != null)
        {
          parambi = (bi)localObject2;
          if (((j.b)localObject3).cmN != null)
          {
            parambi = (bi)localObject2;
            if (((j.b)localObject3).cmN.length() > 0)
            {
              localObject3 = al.aUJ().alo(((j.b)localObject3).cmN);
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
      AppMethodBeat.o(32028);
      return localObject2;
      localObject2 = com.tencent.mm.at.o.ahC().c(parambi.field_imgPath, false, false);
      localObject1 = localObject2;
      if (!ah.isNullOrNil((String)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("hd"))
        {
          localObject1 = localObject2;
          if (e.cN((String)localObject2 + "hd")) {
            localObject1 = (String)localObject2 + "hd";
          }
        }
      }
    }
  }
  
  private static int e(j.b paramb)
  {
    AppMethodBeat.i(32026);
    if (paramb == null)
    {
      ab.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131230822");
      AppMethodBeat.o(32026);
      return 2131230823;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      AppMethodBeat.o(32026);
      return 2131230825;
    }
    if (paramb.type == 3)
    {
      AppMethodBeat.o(32026);
      return 2131230810;
    }
    if ((paramb.type == 6) && (mwh.containsKey(ah.nullAsNil(paramb.fgx))))
    {
      ab.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + mwh.get(ah.nullAsNil(paramb.fgx)));
      int i = ((Integer)mwh.get(ah.nullAsNil(paramb.fgx))).intValue();
      AppMethodBeat.o(32026);
      return i;
    }
    AppMethodBeat.o(32026);
    return 2131230823;
  }
  
  private static int f(j.b paramb)
  {
    AppMethodBeat.i(32027);
    if (paramb == null)
    {
      ab.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131689675");
      AppMethodBeat.o(32027);
      return 2131689675;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      AppMethodBeat.o(32027);
      return 2131689676;
    }
    if ((paramb.type == 6) && (zKw.containsKey(ah.nullAsNil(paramb.fgx))))
    {
      ab.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + zKw.get(ah.nullAsNil(paramb.fgx)));
      int i = ((Integer)zKw.get(ah.nullAsNil(paramb.fgx))).intValue();
      AppMethodBeat.o(32027);
      return i;
    }
    AppMethodBeat.o(32027);
    return 2131689675;
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(32023);
    if (this.muT)
    {
      aw.aaz();
      setCursor(com.tencent.mm.model.c.YD().bc(this.ejr, this.zDF));
      AppMethodBeat.o(32023);
      return;
    }
    aw.aaz();
    setCursor(com.tencent.mm.model.c.YC().Tq(this.ejr));
    AppMethodBeat.o(32023);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(32024);
    if (this.muT)
    {
      aw.aaz();
      setCursor(com.tencent.mm.model.c.YD().bc(this.ejr, this.zDF));
      AppMethodBeat.o(32024);
      return;
    }
    aw.aaz();
    setCursor(com.tencent.mm.model.c.YC().Tq(this.ejr));
    AppMethodBeat.o(32024);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void byh()
  {
    AppMethodBeat.i(32029);
    this.quM = false;
    notifyDataSetChanged();
    AppMethodBeat.o(32029);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(32025);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130969882, paramViewGroup, false);
      paramViewGroup = new d.a();
      paramViewGroup.mCy = ((ImageView)paramView.findViewById(2131824016));
      paramViewGroup.mCz = paramView.findViewById(2131824020);
      paramViewGroup.zKA = ((TextView)paramView.findViewById(2131824017));
      paramViewGroup.zKA.setVisibility(8);
      paramViewGroup.zKz = ((ImageView)paramView.findViewById(2131824019));
      paramViewGroup.kFj = ((TextView)paramView.findViewById(2131822813));
      paramViewGroup.mCz.setVisibility(8);
      paramViewGroup.mCB = paramView.findViewById(2131824022);
      paramViewGroup.mCB.setVisibility(8);
      paramViewGroup.zKB = paramView.findViewById(2131824018);
      paramViewGroup.zKB.setVisibility(8);
      paramViewGroup.mCA = ((ImageView)paramView.findViewById(2131824024));
      paramViewGroup.mCC = ((CheckBox)paramView.findViewById(2131824025));
      paramViewGroup.mCD = paramView.findViewById(2131824026);
      paramView.setTag(paramViewGroup);
    }
    bi localbi;
    for (;;)
    {
      paramViewGroup.mCB.setVisibility(8);
      paramViewGroup.mCz.setVisibility(8);
      paramViewGroup.zKB.setVisibility(8);
      paramViewGroup.zKA.setVisibility(8);
      localbi = (bi)getItem(paramInt);
      if (localbi != null) {
        break;
      }
      AppMethodBeat.o(32025);
      return paramView;
      paramViewGroup = (d.a)paramView.getTag();
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (this.kFs)
    {
      if (!(this.zKu instanceof ImageGalleryGridUI))
      {
        paramView = new IllegalArgumentException("the context should be ImageGalleryGridUI");
        AppMethodBeat.o(32025);
        throw paramView;
      }
      localObject2 = localbi.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = j.b.ab((String)localObject2, localbi.field_reserved);
      }
      if (this.zKu.zKC == paramInt)
      {
        paramViewGroup.mCA.setVisibility(0);
        if ((c.br(localbi)) && (localObject1 != null) && (((j.b)localObject1).type != 3))
        {
          paramViewGroup.zKz.setImageDrawable(this.zKu.getResources().getDrawable(e((j.b)localObject1)));
          paramViewGroup.mCy.setImageResource(f((j.b)localObject1));
          paramViewGroup.mCy.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.mCy.getMeasuredWidth();
          i = paramViewGroup.mCy.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label774;
          }
          label445:
          if (!c.f(localbi)) {
            break label808;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.mCz.setVisibility(0);
            localObject1 = j.bH(localbi);
            if (localObject1 != null) {
              paramViewGroup.kFj.setText(ah.mH(((s)localObject1).fXx));
            }
          }
          label492:
          paramViewGroup.mCC.setChecked(h.a.dKg().bF(localbi));
          paramViewGroup.mCC.setTag(localbi);
          paramViewGroup.mCD.setTag(paramViewGroup);
          paramViewGroup.mCD.setOnClickListener(this);
          if (!h.a.dKg().mCm) {
            break label979;
          }
          paramViewGroup.mCC.setVisibility(0);
          paramViewGroup.mCD.setVisibility(0);
          paramViewGroup.mCA.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(32025);
      return paramView;
      if ((localObject1 != null) && (((j.b)localObject1).type == 3)) {
        paramViewGroup.zKz.setImageDrawable(this.zKu.getResources().getDrawable(e((j.b)localObject1)));
      }
      com.tencent.mm.at.o.ahG().a(by(localbi), paramViewGroup.mCy, this.eiK, new d.1(this));
      break;
      paramViewGroup.mCA.setVisibility(0);
      paramViewGroup.mCA.setBackgroundResource(2131690180);
      if ((c.br(localbi)) && (localObject1 != null) && (((j.b)localObject1).type != 3))
      {
        paramViewGroup.zKz.setImageDrawable(this.zKu.getResources().getDrawable(e((j.b)localObject1)));
        paramViewGroup.mCy.setImageResource(f((j.b)localObject1));
        break;
      }
      if ((localObject1 != null) && (((j.b)localObject1).type == 3)) {
        paramViewGroup.zKz.setImageDrawable(this.zKu.getResources().getDrawable(e((j.b)localObject1)));
      }
      com.tencent.mm.at.o.ahG().a(by(localbi), paramViewGroup.mCy, this.eiK);
      break;
      label774:
      localObject2 = paramViewGroup.mCA.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.mCA.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label445;
      label808:
      if (c.bq(localbi))
      {
        paramViewGroup.mCB.setVisibility(0);
        break label492;
      }
      if ((!c.br(localbi)) || (paramViewGroup == null)) {
        break label492;
      }
      paramViewGroup.zKB.setVisibility(0);
      paramViewGroup.zKA.setVisibility(0);
      if (localObject1 == null) {
        break label492;
      }
      ab.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { ah.nullAsNil(((j.b)localObject1).title) });
      if (((j.b)localObject1).type != 24)
      {
        paramViewGroup.zKA.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, ah.nullAsNil(((j.b)localObject1).title), paramViewGroup.zKA.getTextSize()));
        break label492;
      }
      paramViewGroup.zKA.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramViewGroup.zKA.getContext(), paramViewGroup.zKA.getContext().getString(2131299857), paramViewGroup.zKA.getTextSize()));
      break label492;
      paramViewGroup.mCy.setImageResource(2130839821);
      break label492;
      label979:
      paramViewGroup.mCC.setVisibility(8);
      paramViewGroup.mCD.setVisibility(8);
      paramViewGroup.mCA.setVisibility(8);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(32030);
    super.notifyDataSetChanged();
    this.zKv = false;
    AppMethodBeat.o(32030);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(32031);
    paramView = (d.a)paramView.getTag();
    if (paramView.mCC == null)
    {
      AppMethodBeat.o(32031);
      return;
    }
    bi localbi = (bi)paramView.mCC.getTag();
    if (localbi == null)
    {
      AppMethodBeat.o(32031);
      return;
    }
    h localh = h.a.dKg();
    if (localh.bF(localbi))
    {
      localh.bE(localbi);
      if (!h.a.dKg().bF(localbi)) {
        break label151;
      }
      paramView.mCC.setChecked(true);
      paramView.mCA.setBackgroundResource(2131690159);
    }
    for (;;)
    {
      if ((!this.quM) && (h.a.dKg().mCl.size() > 1))
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 20L, 1L, true);
        this.quM = true;
      }
      AppMethodBeat.o(32031);
      return;
      localh.bD(localbi);
      break;
      label151:
      paramView.mCC.setChecked(false);
      paramView.mCA.setBackgroundResource(2131690180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d
 * JD-Core Version:    0.7.0.1
 */