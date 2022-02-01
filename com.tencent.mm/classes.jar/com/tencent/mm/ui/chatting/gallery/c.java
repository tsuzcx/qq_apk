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
import com.tencent.mm.al.f;
import com.tencent.mm.av.g;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.p;
import com.tencent.mm.ui.r;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends r<bo>
  implements View.OnClickListener
{
  private static Map<String, Integer> IaL;
  private static Map<String, Integer> nhJ;
  long HRS;
  private final ImageGalleryGridUI IaJ;
  boolean IaK;
  String fzK;
  protected com.tencent.mm.av.a.a.c fze;
  Context mContext;
  private LayoutInflater mInflater;
  private boolean opt;
  boolean qKh;
  public boolean rAJ;
  
  static
  {
    AppMethodBeat.i(35949);
    HashMap localHashMap = new HashMap();
    nhJ = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689582));
    nhJ.put("m4v", Integer.valueOf(2131689582));
    nhJ.put("vob", Integer.valueOf(2131689582));
    nhJ.put("mpeg", Integer.valueOf(2131689582));
    nhJ.put("mpe", Integer.valueOf(2131689582));
    nhJ.put("asx", Integer.valueOf(2131689582));
    nhJ.put("asf", Integer.valueOf(2131689582));
    nhJ.put("f4v", Integer.valueOf(2131689582));
    nhJ.put("flv", Integer.valueOf(2131689582));
    nhJ.put("mkv", Integer.valueOf(2131689582));
    nhJ.put("wmv", Integer.valueOf(2131689582));
    nhJ.put("wm", Integer.valueOf(2131689582));
    nhJ.put("3gp", Integer.valueOf(2131689582));
    nhJ.put("mp4", Integer.valueOf(2131689582));
    nhJ.put("rmvb", Integer.valueOf(2131689582));
    nhJ.put("rm", Integer.valueOf(2131689582));
    nhJ.put("ra", Integer.valueOf(2131689582));
    nhJ.put("ram", Integer.valueOf(2131689582));
    nhJ.put("mp3pro", Integer.valueOf(2131689565));
    nhJ.put("vqf", Integer.valueOf(2131689565));
    nhJ.put("cd", Integer.valueOf(2131689565));
    nhJ.put("md", Integer.valueOf(2131689565));
    nhJ.put("mod", Integer.valueOf(2131689565));
    nhJ.put("vorbis", Integer.valueOf(2131689565));
    nhJ.put("au", Integer.valueOf(2131689565));
    nhJ.put("amr", Integer.valueOf(2131689565));
    nhJ.put("silk", Integer.valueOf(2131689565));
    nhJ.put("wma", Integer.valueOf(2131689565));
    nhJ.put("mmf", Integer.valueOf(2131689565));
    nhJ.put("mid", Integer.valueOf(2131689565));
    nhJ.put("midi", Integer.valueOf(2131689565));
    nhJ.put("mp3", Integer.valueOf(2131689565));
    nhJ.put("aac", Integer.valueOf(2131689565));
    nhJ.put("ape", Integer.valueOf(2131689565));
    nhJ.put("aiff", Integer.valueOf(2131689565));
    nhJ.put("aif", Integer.valueOf(2131689565));
    nhJ.put("doc", Integer.valueOf(2131689586));
    nhJ.put("docx", Integer.valueOf(2131689586));
    nhJ.put("ppt", Integer.valueOf(2131689572));
    nhJ.put("pptx", Integer.valueOf(2131689572));
    nhJ.put("xls", Integer.valueOf(2131689558));
    nhJ.put("xlsx", Integer.valueOf(2131689558));
    nhJ.put("pdf", Integer.valueOf(2131689569));
    nhJ.put("unknown", Integer.valueOf(2131689578));
    localHashMap = new HashMap();
    IaL = localHashMap;
    localHashMap.put("doc", Integer.valueOf(2131099910));
    IaL.put("docx", Integer.valueOf(2131099910));
    IaL.put("ppt", Integer.valueOf(2131099913));
    IaL.put("pptx", Integer.valueOf(2131099913));
    IaL.put("xls", Integer.valueOf(2131099916));
    IaL.put("xlsx", Integer.valueOf(2131099916));
    IaL.put("pdf", Integer.valueOf(2131099912));
    IaL.put("unknown", Integer.valueOf(2131099914));
    IaL.put("mp3pro", Integer.valueOf(2131099911));
    IaL.put("vqf", Integer.valueOf(2131099911));
    IaL.put("cd", Integer.valueOf(2131099911));
    IaL.put("md", Integer.valueOf(2131099911));
    IaL.put("mod", Integer.valueOf(2131099911));
    IaL.put("vorbis", Integer.valueOf(2131099911));
    IaL.put("au", Integer.valueOf(2131099911));
    IaL.put("amr", Integer.valueOf(2131099911));
    IaL.put("silk", Integer.valueOf(2131099911));
    IaL.put("wma", Integer.valueOf(2131099911));
    IaL.put("mmf", Integer.valueOf(2131099911));
    IaL.put("mid", Integer.valueOf(2131099911));
    IaL.put("midi", Integer.valueOf(2131099911));
    IaL.put("mp3", Integer.valueOf(2131099911));
    IaL.put("aac", Integer.valueOf(2131099911));
    IaL.put("ape", Integer.valueOf(2131099911));
    IaL.put("aiff", Integer.valueOf(2131099911));
    IaL.put("aif", Integer.valueOf(2131099911));
    AppMethodBeat.o(35949);
  }
  
  public c(Context paramContext, bo parambo, String paramString)
  {
    super(paramContext, parambo);
    AppMethodBeat.i(35938);
    this.fze = null;
    this.IaK = false;
    this.rAJ = false;
    this.IaJ = ((ImageGalleryGridUI)paramContext);
    this.fzK = paramString;
    this.qKh = f.so(this.fzK);
    if (this.qKh) {
      this.HRS = parambo.field_bizChatId;
    }
    az.ayM();
    this.opt = com.tencent.mm.model.c.isSDCardAvailable();
    this.mInflater = LayoutInflater.from(paramContext);
    parambo = new com.tencent.mm.av.a.a.c.a();
    parambo.hKA = 1;
    parambo.hKQ = true;
    parambo.gKh = (com.tencent.mm.cc.a.ig(paramContext) / 3);
    parambo.gKg = (com.tencent.mm.cc.a.ig(paramContext) / 3);
    parambo.hKL = 2131100734;
    this.fze = parambo.aFT();
    AppMethodBeat.o(35938);
  }
  
  private static String bZ(bo parambo)
  {
    AppMethodBeat.i(35944);
    Object localObject1;
    if ((parambo.crt()) || (parambo.crv()))
    {
      com.tencent.mm.modelvideo.o.aJy();
      localObject1 = t.DW(parambo.field_imgPath);
    }
    for (;;)
    {
      ac.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (parambo.fbG())
      {
        Object localObject3 = k.b.vA(parambo.field_content);
        localObject2 = null;
        parambo = (bo)localObject2;
        if (localObject3 != null)
        {
          parambo = (bo)localObject2;
          if (((k.b)localObject3).cZa != null)
          {
            parambo = (bo)localObject2;
            if (((k.b)localObject3).cZa.length() > 0)
            {
              localObject3 = com.tencent.mm.pluginsdk.model.app.ap.bEO().aGd(((k.b)localObject3).cZa);
              parambo = (bo)localObject2;
              if (localObject3 != null) {
                parambo = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (parambo != null) {
          localObject2 = parambo;
        }
      }
      AppMethodBeat.o(35944);
      return localObject2;
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
  
  private static int h(k.b paramb)
  {
    AppMethodBeat.i(35942);
    if (paramb == null)
    {
      ac.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131689577");
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
    if ((paramb.type == 6) && (nhJ.containsKey(bs.nullAsNil(paramb.hhG))))
    {
      ac.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + nhJ.get(bs.nullAsNil(paramb.hhG)));
      int i = ((Integer)nhJ.get(bs.nullAsNil(paramb.hhG))).intValue();
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
      ac.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131099914");
      AppMethodBeat.o(35943);
      return 2131099914;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      AppMethodBeat.o(35943);
      return 2131099915;
    }
    if ((paramb.type == 6) && (IaL.containsKey(bs.nullAsNil(paramb.hhG))))
    {
      ac.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + IaL.get(bs.nullAsNil(paramb.hhG)));
      int i = ((Integer)IaL.get(bs.nullAsNil(paramb.hhG))).intValue();
      AppMethodBeat.o(35943);
      return i;
    }
    AppMethodBeat.o(35943);
    return 2131099914;
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(35939);
    if (this.qKh)
    {
      az.ayM();
      setCursor(com.tencent.mm.model.c.awE().bX(this.fzK, this.HRS));
      AppMethodBeat.o(35939);
      return;
    }
    az.ayM();
    setCursor(com.tencent.mm.model.c.awD().alo(this.fzK));
    AppMethodBeat.o(35939);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(35940);
    if (this.qKh)
    {
      az.ayM();
      setCursor(com.tencent.mm.model.c.awE().bX(this.fzK, this.HRS));
      AppMethodBeat.o(35940);
      return;
    }
    az.ayM();
    setCursor(com.tencent.mm.model.c.awD().alo(this.fzK));
    AppMethodBeat.o(35940);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void crr()
  {
    AppMethodBeat.i(35945);
    this.rAJ = false;
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
      paramViewGroup.qSI = ((ImageView)paramView.findViewById(2131300612));
      paramViewGroup.qSJ = paramView.findViewById(2131306404);
      paramViewGroup.IaP = ((TextView)paramView.findViewById(2131299925));
      paramViewGroup.IaP.setVisibility(8);
      paramViewGroup.IaO = ((ImageView)paramView.findViewById(2131299918));
      paramViewGroup.opl = ((TextView)paramView.findViewById(2131306401));
      paramViewGroup.qSJ.setVisibility(8);
      paramViewGroup.qSL = paramView.findViewById(2131304817);
      paramViewGroup.qSL.setVisibility(8);
      paramViewGroup.IaQ = paramView.findViewById(2131299932);
      paramViewGroup.IaQ.setVisibility(8);
      paramViewGroup.qSK = ((ImageView)paramView.findViewById(2131300615));
      paramViewGroup.ijt = ((CheckBox)paramView.findViewById(2131302204));
      paramViewGroup.qSM = paramView.findViewById(2131302205);
      paramView.setTag(paramViewGroup);
    }
    bo localbo;
    for (;;)
    {
      paramViewGroup.qSL.setVisibility(8);
      paramViewGroup.qSJ.setVisibility(8);
      paramViewGroup.IaQ.setVisibility(8);
      paramViewGroup.IaP.setVisibility(8);
      localbo = (bo)getItem(paramInt);
      if (localbo != null) {
        break;
      }
      AppMethodBeat.o(35941);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (this.opt)
    {
      if (!(this.IaJ instanceof ImageGalleryGridUI))
      {
        paramView = new IllegalArgumentException("the context should be ImageGalleryGridUI");
        AppMethodBeat.o(35941);
        throw paramView;
      }
      localObject2 = localbo.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.az((String)localObject2, localbo.field_reserved);
      }
      if (this.IaJ.IaR == paramInt)
      {
        paramViewGroup.qSK.setVisibility(0);
        if ((b.bS(localbo)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
        {
          paramViewGroup.IaO.setImageDrawable(this.IaJ.getResources().getDrawable(h((k.b)localObject1)));
          paramViewGroup.qSI.setImageResource(i((k.b)localObject1));
          paramViewGroup.qSI.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.qSI.getMeasuredWidth();
          i = paramViewGroup.qSI.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label774;
          }
          label445:
          if (!b.m(localbo)) {
            break label808;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.qSJ.setVisibility(0);
            localObject1 = j.ck(localbo);
            if (localObject1 != null) {
              paramViewGroup.opl.setText(bs.qy(((s)localObject1).hpy));
            }
          }
          label492:
          paramViewGroup.ijt.setChecked(h.a.fpp().ci(localbo));
          paramViewGroup.ijt.setTag(localbo);
          paramViewGroup.qSM.setTag(paramViewGroup);
          paramViewGroup.qSM.setOnClickListener(this);
          if (!h.a.fpp().qSw) {
            break label979;
          }
          paramViewGroup.ijt.setVisibility(0);
          paramViewGroup.qSM.setVisibility(0);
          paramViewGroup.qSK.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35941);
      return paramView;
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.IaO.setImageDrawable(this.IaJ.getResources().getDrawable(h((k.b)localObject1)));
      }
      com.tencent.mm.av.o.aFB().a(bZ(localbo), paramViewGroup.qSI, this.fze, new com.tencent.mm.av.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(35937);
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
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
      paramViewGroup.qSK.setVisibility(0);
      paramViewGroup.qSK.setBackgroundResource(2131100506);
      if ((b.bS(localbo)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
      {
        paramViewGroup.IaO.setImageDrawable(this.IaJ.getResources().getDrawable(h((k.b)localObject1)));
        paramViewGroup.qSI.setImageResource(i((k.b)localObject1));
        break;
      }
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.IaO.setImageDrawable(this.IaJ.getResources().getDrawable(h((k.b)localObject1)));
      }
      com.tencent.mm.av.o.aFB().a(bZ(localbo), paramViewGroup.qSI, this.fze);
      break;
      label774:
      localObject2 = paramViewGroup.qSK.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.qSK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label445;
      label808:
      if (b.bR(localbo))
      {
        paramViewGroup.qSL.setVisibility(0);
        break label492;
      }
      if ((!b.bS(localbo)) || (paramViewGroup == null)) {
        break label492;
      }
      paramViewGroup.IaQ.setVisibility(0);
      paramViewGroup.IaP.setVisibility(0);
      if (localObject1 == null) {
        break label492;
      }
      ac.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { bs.nullAsNil(((k.b)localObject1).title) });
      if (((k.b)localObject1).type != 24)
      {
        paramViewGroup.IaP.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, bs.nullAsNil(((k.b)localObject1).title), paramViewGroup.IaP.getTextSize()));
        break label492;
      }
      paramViewGroup.IaP.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramViewGroup.IaP.getContext(), paramViewGroup.IaP.getContext().getString(2131759034), paramViewGroup.IaP.getTextSize()));
      break label492;
      paramViewGroup.qSI.setImageResource(2131233476);
      break label492;
      label979:
      paramViewGroup.ijt.setVisibility(8);
      paramViewGroup.qSM.setVisibility(8);
      paramViewGroup.qSK.setVisibility(8);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35946);
    super.notifyDataSetChanged();
    this.IaK = false;
    AppMethodBeat.o(35946);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35947);
    paramView = (a)paramView.getTag();
    if (paramView.ijt == null)
    {
      AppMethodBeat.o(35947);
      return;
    }
    bo localbo = (bo)paramView.ijt.getTag();
    if (localbo == null)
    {
      AppMethodBeat.o(35947);
      return;
    }
    h localh = h.a.fpp();
    if (localh.ci(localbo))
    {
      localh.ch(localbo);
      if (!h.a.fpp().ci(localbo)) {
        break label151;
      }
      paramView.ijt.setChecked(true);
      paramView.qSK.setBackgroundResource(2131100482);
    }
    for (;;)
    {
      if ((!this.rAJ) && (h.a.fpp().qSv.size() > 1))
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 20L, 1L, true);
        this.rAJ = true;
      }
      AppMethodBeat.o(35947);
      return;
      localh.cg(localbo);
      break;
      label151:
      paramView.ijt.setChecked(false);
      paramView.qSK.setBackgroundResource(2131100506);
    }
  }
  
  protected static final class a
  {
    public ImageView IaO;
    public TextView IaP;
    public View IaQ;
    public CheckBox ijt;
    public TextView opl;
    public ImageView qSI;
    public View qSJ;
    public ImageView qSK;
    public View qSL;
    public View qSM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c
 * JD-Core Version:    0.7.0.1
 */