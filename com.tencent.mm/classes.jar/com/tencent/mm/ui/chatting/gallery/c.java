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
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.ui.r<bu>
  implements View.OnClickListener
{
  private static Map<String, Integer> JQc;
  private static Map<String, Integer> nIf;
  long JFK;
  private final ImageGalleryGridUI JQa;
  boolean JQb;
  protected com.tencent.mm.aw.a.a.c fSr;
  String fTa;
  Context mContext;
  private LayoutInflater mInflater;
  private boolean oSO;
  boolean ruj;
  public boolean ssW;
  
  static
  {
    AppMethodBeat.i(35949);
    HashMap localHashMap = new HashMap();
    nIf = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689582));
    nIf.put("m4v", Integer.valueOf(2131689582));
    nIf.put("vob", Integer.valueOf(2131689582));
    nIf.put("mpeg", Integer.valueOf(2131689582));
    nIf.put("mpe", Integer.valueOf(2131689582));
    nIf.put("asx", Integer.valueOf(2131689582));
    nIf.put("asf", Integer.valueOf(2131689582));
    nIf.put("f4v", Integer.valueOf(2131689582));
    nIf.put("flv", Integer.valueOf(2131689582));
    nIf.put("mkv", Integer.valueOf(2131689582));
    nIf.put("wmv", Integer.valueOf(2131689582));
    nIf.put("wm", Integer.valueOf(2131689582));
    nIf.put("3gp", Integer.valueOf(2131689582));
    nIf.put("mp4", Integer.valueOf(2131689582));
    nIf.put("rmvb", Integer.valueOf(2131689582));
    nIf.put("rm", Integer.valueOf(2131689582));
    nIf.put("ra", Integer.valueOf(2131689582));
    nIf.put("ram", Integer.valueOf(2131689582));
    nIf.put("mp3pro", Integer.valueOf(2131689565));
    nIf.put("vqf", Integer.valueOf(2131689565));
    nIf.put("cd", Integer.valueOf(2131689565));
    nIf.put("md", Integer.valueOf(2131689565));
    nIf.put("mod", Integer.valueOf(2131689565));
    nIf.put("vorbis", Integer.valueOf(2131689565));
    nIf.put("au", Integer.valueOf(2131689565));
    nIf.put("amr", Integer.valueOf(2131689565));
    nIf.put("silk", Integer.valueOf(2131689565));
    nIf.put("wma", Integer.valueOf(2131689565));
    nIf.put("mmf", Integer.valueOf(2131689565));
    nIf.put("mid", Integer.valueOf(2131689565));
    nIf.put("midi", Integer.valueOf(2131689565));
    nIf.put("mp3", Integer.valueOf(2131689565));
    nIf.put("aac", Integer.valueOf(2131689565));
    nIf.put("ape", Integer.valueOf(2131689565));
    nIf.put("aiff", Integer.valueOf(2131689565));
    nIf.put("aif", Integer.valueOf(2131689565));
    nIf.put("doc", Integer.valueOf(2131689586));
    nIf.put("docx", Integer.valueOf(2131689586));
    nIf.put("ppt", Integer.valueOf(2131689572));
    nIf.put("pptx", Integer.valueOf(2131689572));
    nIf.put("xls", Integer.valueOf(2131689558));
    nIf.put("xlsx", Integer.valueOf(2131689558));
    nIf.put("pdf", Integer.valueOf(2131689569));
    nIf.put("unknown", Integer.valueOf(2131689578));
    localHashMap = new HashMap();
    JQc = localHashMap;
    localHashMap.put("doc", Integer.valueOf(2131099910));
    JQc.put("docx", Integer.valueOf(2131099910));
    JQc.put("ppt", Integer.valueOf(2131099913));
    JQc.put("pptx", Integer.valueOf(2131099913));
    JQc.put("xls", Integer.valueOf(2131099916));
    JQc.put("xlsx", Integer.valueOf(2131099916));
    JQc.put("pdf", Integer.valueOf(2131099912));
    JQc.put("unknown", Integer.valueOf(2131099914));
    JQc.put("mp3pro", Integer.valueOf(2131099911));
    JQc.put("vqf", Integer.valueOf(2131099911));
    JQc.put("cd", Integer.valueOf(2131099911));
    JQc.put("md", Integer.valueOf(2131099911));
    JQc.put("mod", Integer.valueOf(2131099911));
    JQc.put("vorbis", Integer.valueOf(2131099911));
    JQc.put("au", Integer.valueOf(2131099911));
    JQc.put("amr", Integer.valueOf(2131099911));
    JQc.put("silk", Integer.valueOf(2131099911));
    JQc.put("wma", Integer.valueOf(2131099911));
    JQc.put("mmf", Integer.valueOf(2131099911));
    JQc.put("mid", Integer.valueOf(2131099911));
    JQc.put("midi", Integer.valueOf(2131099911));
    JQc.put("mp3", Integer.valueOf(2131099911));
    JQc.put("aac", Integer.valueOf(2131099911));
    JQc.put("ape", Integer.valueOf(2131099911));
    JQc.put("aiff", Integer.valueOf(2131099911));
    JQc.put("aif", Integer.valueOf(2131099911));
    AppMethodBeat.o(35949);
  }
  
  public c(Context paramContext, bu parambu, String paramString)
  {
    super(paramContext, parambu);
    AppMethodBeat.i(35938);
    this.fSr = null;
    this.JQb = false;
    this.ssW = false;
    this.JQa = ((ImageGalleryGridUI)paramContext);
    this.fTa = paramString;
    this.ruj = com.tencent.mm.am.g.vd(this.fTa);
    if (this.ruj) {
      this.JFK = parambu.field_bizChatId;
    }
    ba.aBQ();
    this.oSO = com.tencent.mm.model.c.isSDCardAvailable();
    this.mInflater = LayoutInflater.from(paramContext);
    parambu = new com.tencent.mm.aw.a.a.c.a();
    parambu.idu = 1;
    parambu.idL = true;
    parambu.hdS = (com.tencent.mm.cc.a.ip(paramContext) / 3);
    parambu.hdR = (com.tencent.mm.cc.a.ip(paramContext) / 3);
    parambu.idG = 2131100734;
    this.fSr = parambu.aJc();
    AppMethodBeat.o(35938);
  }
  
  private static String cf(bu parambu)
  {
    AppMethodBeat.i(35944);
    Object localObject1;
    if ((parambu.cxf()) || (parambu.cxh()))
    {
      o.aMJ();
      localObject1 = t.Hi(parambu.field_imgPath);
    }
    for (;;)
    {
      ad.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (parambu.frK())
      {
        Object localObject3 = k.b.yr(parambu.field_content);
        localObject2 = null;
        parambu = (bu)localObject2;
        if (localObject3 != null)
        {
          parambu = (bu)localObject2;
          if (((k.b)localObject3).dks != null)
          {
            parambu = (bu)localObject2;
            if (((k.b)localObject3).dks.length() > 0)
            {
              localObject3 = ao.bIX().aLD(((k.b)localObject3).dks);
              parambu = (bu)localObject2;
              if (localObject3 != null) {
                parambu = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (parambu != null) {
          localObject2 = parambu;
        }
      }
      AppMethodBeat.o(35944);
      return localObject2;
      localObject2 = q.aIF().c(parambu.field_imgPath, false, false);
      localObject1 = localObject2;
      if (!bt.isNullOrNil((String)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("hd"))
        {
          localObject1 = localObject2;
          if (com.tencent.mm.vfs.i.fv((String)localObject2 + "hd")) {
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
    if ((paramb.type == 6) && (nIf.containsKey(bt.nullAsNil(paramb.hzP))))
    {
      ad.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + nIf.get(bt.nullAsNil(paramb.hzP)));
      int i = ((Integer)nIf.get(bt.nullAsNil(paramb.hzP))).intValue();
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
      ad.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131099914");
      AppMethodBeat.o(35943);
      return 2131099914;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      AppMethodBeat.o(35943);
      return 2131099915;
    }
    if ((paramb.type == 6) && (JQc.containsKey(bt.nullAsNil(paramb.hzP))))
    {
      ad.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + JQc.get(bt.nullAsNil(paramb.hzP)));
      int i = ((Integer)JQc.get(bt.nullAsNil(paramb.hzP))).intValue();
      AppMethodBeat.o(35943);
      return i;
    }
    AppMethodBeat.o(35943);
    return 2131099914;
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(35939);
    if (this.ruj)
    {
      ba.aBQ();
      setCursor(com.tencent.mm.model.c.azt().cb(this.fTa, this.JFK));
      AppMethodBeat.o(35939);
      return;
    }
    ba.aBQ();
    setCursor(com.tencent.mm.model.c.azs().aqc(this.fTa));
    AppMethodBeat.o(35939);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(35940);
    if (this.ruj)
    {
      ba.aBQ();
      setCursor(com.tencent.mm.model.c.azt().cb(this.fTa, this.JFK));
      AppMethodBeat.o(35940);
      return;
    }
    ba.aBQ();
    setCursor(com.tencent.mm.model.c.azs().aqc(this.fTa));
    AppMethodBeat.o(35940);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void cxd()
  {
    AppMethodBeat.i(35945);
    this.ssW = false;
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
      paramViewGroup.rCL = ((ImageView)paramView.findViewById(2131300612));
      paramViewGroup.rCM = paramView.findViewById(2131306404);
      paramViewGroup.JQg = ((TextView)paramView.findViewById(2131299925));
      paramViewGroup.JQg.setVisibility(8);
      paramViewGroup.JQf = ((ImageView)paramView.findViewById(2131299918));
      paramViewGroup.oSG = ((TextView)paramView.findViewById(2131306401));
      paramViewGroup.rCM.setVisibility(8);
      paramViewGroup.rCO = paramView.findViewById(2131304817);
      paramViewGroup.rCO.setVisibility(8);
      paramViewGroup.JQh = paramView.findViewById(2131299932);
      paramViewGroup.JQh.setVisibility(8);
      paramViewGroup.rCN = ((ImageView)paramView.findViewById(2131300615));
      paramViewGroup.iCK = ((CheckBox)paramView.findViewById(2131302204));
      paramViewGroup.rCP = paramView.findViewById(2131302205);
      paramView.setTag(paramViewGroup);
    }
    bu localbu;
    for (;;)
    {
      paramViewGroup.rCO.setVisibility(8);
      paramViewGroup.rCM.setVisibility(8);
      paramViewGroup.JQh.setVisibility(8);
      paramViewGroup.JQg.setVisibility(8);
      localbu = (bu)getItem(paramInt);
      if (localbu != null) {
        break;
      }
      AppMethodBeat.o(35941);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (this.oSO)
    {
      if (!(this.JQa instanceof ImageGalleryGridUI))
      {
        paramView = new IllegalArgumentException("the context should be ImageGalleryGridUI");
        AppMethodBeat.o(35941);
        throw paramView;
      }
      localObject2 = localbu.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aA((String)localObject2, localbu.field_reserved);
      }
      if (this.JQa.JQi == paramInt)
      {
        paramViewGroup.rCN.setVisibility(0);
        if ((b.bY(localbu)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
        {
          paramViewGroup.JQf.setImageDrawable(this.JQa.getResources().getDrawable(i((k.b)localObject1)));
          paramViewGroup.rCL.setImageResource(j((k.b)localObject1));
          paramViewGroup.rCL.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.rCL.getMeasuredWidth();
          i = paramViewGroup.rCL.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label774;
          }
          label445:
          if (!b.m(localbu)) {
            break label808;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.rCM.setVisibility(0);
            localObject1 = j.cq(localbu);
            if (localObject1 != null) {
              paramViewGroup.oSG.setText(bt.qY(((s)localObject1).hHQ));
            }
          }
          label492:
          paramViewGroup.iCK.setChecked(h.a.fFU().co(localbu));
          paramViewGroup.iCK.setTag(localbu);
          paramViewGroup.rCP.setTag(paramViewGroup);
          paramViewGroup.rCP.setOnClickListener(this);
          if (!h.a.fFU().rCy) {
            break label979;
          }
          paramViewGroup.iCK.setVisibility(0);
          paramViewGroup.rCP.setVisibility(0);
          paramViewGroup.rCN.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35941);
      return paramView;
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.JQf.setImageDrawable(this.JQa.getResources().getDrawable(i((k.b)localObject1)));
      }
      q.aIJ().a(cf(localbu), paramViewGroup.rCL, this.fSr, new com.tencent.mm.aw.a.c.k()
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
      paramViewGroup.rCN.setVisibility(0);
      paramViewGroup.rCN.setBackgroundResource(2131100506);
      if ((b.bY(localbu)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
      {
        paramViewGroup.JQf.setImageDrawable(this.JQa.getResources().getDrawable(i((k.b)localObject1)));
        paramViewGroup.rCL.setImageResource(j((k.b)localObject1));
        break;
      }
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.JQf.setImageDrawable(this.JQa.getResources().getDrawable(i((k.b)localObject1)));
      }
      q.aIJ().a(cf(localbu), paramViewGroup.rCL, this.fSr);
      break;
      label774:
      localObject2 = paramViewGroup.rCN.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.rCN.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label445;
      label808:
      if (b.bX(localbu))
      {
        paramViewGroup.rCO.setVisibility(0);
        break label492;
      }
      if ((!b.bY(localbu)) || (paramViewGroup == null)) {
        break label492;
      }
      paramViewGroup.JQh.setVisibility(0);
      paramViewGroup.JQg.setVisibility(0);
      if (localObject1 == null) {
        break label492;
      }
      ad.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { bt.nullAsNil(((k.b)localObject1).title) });
      if (((k.b)localObject1).type != 24)
      {
        paramViewGroup.JQg.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, bt.nullAsNil(((k.b)localObject1).title), paramViewGroup.JQg.getTextSize()));
        break label492;
      }
      paramViewGroup.JQg.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramViewGroup.JQg.getContext(), paramViewGroup.JQg.getContext().getString(2131759034), paramViewGroup.JQg.getTextSize()));
      break label492;
      paramViewGroup.rCL.setImageResource(2131233476);
      break label492;
      label979:
      paramViewGroup.iCK.setVisibility(8);
      paramViewGroup.rCP.setVisibility(8);
      paramViewGroup.rCN.setVisibility(8);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35946);
    super.notifyDataSetChanged();
    this.JQb = false;
    AppMethodBeat.o(35946);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35947);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    paramView = (a)paramView.getTag();
    if (paramView.iCK == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
    }
    localObject = (bu)paramView.iCK.getTag();
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
    }
    h localh = h.a.fFU();
    if (localh.co((bu)localObject))
    {
      localh.cn((bu)localObject);
      if (!h.a.fFU().co((bu)localObject)) {
        break label232;
      }
      paramView.iCK.setChecked(true);
      paramView.rCN.setBackgroundResource(2131100482);
    }
    for (;;)
    {
      if ((!this.ssW) && (h.a.fFU().rCx.size() > 1))
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 20L, 1L, true);
        this.ssW = true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
      localh.cm((bu)localObject);
      break;
      label232:
      paramView.iCK.setChecked(false);
      paramView.rCN.setBackgroundResource(2131100506);
    }
  }
  
  protected static final class a
  {
    public ImageView JQf;
    public TextView JQg;
    public View JQh;
    public CheckBox iCK;
    public TextView oSG;
    public ImageView rCL;
    public View rCM;
    public ImageView rCN;
    public View rCO;
    public View rCP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c
 * JD-Core Version:    0.7.0.1
 */