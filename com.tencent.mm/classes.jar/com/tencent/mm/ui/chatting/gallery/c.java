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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.al.g;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.ui.s<ca>
  implements View.OnClickListener
{
  private static Map<String, Integer> Pxk;
  private static Map<String, Integer> oYD;
  long PlX;
  private final ImageGalleryGridUI Pxi;
  boolean Pxj;
  String gAn;
  protected com.tencent.mm.av.a.a.c gzE;
  Context mContext;
  private LayoutInflater mInflater;
  private boolean qoo;
  boolean tca;
  public boolean vtY;
  
  static
  {
    AppMethodBeat.i(35949);
    HashMap localHashMap = new HashMap();
    oYD = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689585));
    oYD.put("m4v", Integer.valueOf(2131689585));
    oYD.put("vob", Integer.valueOf(2131689585));
    oYD.put("mpeg", Integer.valueOf(2131689585));
    oYD.put("mpe", Integer.valueOf(2131689585));
    oYD.put("asx", Integer.valueOf(2131689585));
    oYD.put("asf", Integer.valueOf(2131689585));
    oYD.put("f4v", Integer.valueOf(2131689585));
    oYD.put("flv", Integer.valueOf(2131689585));
    oYD.put("mkv", Integer.valueOf(2131689585));
    oYD.put("wmv", Integer.valueOf(2131689585));
    oYD.put("wm", Integer.valueOf(2131689585));
    oYD.put("3gp", Integer.valueOf(2131689585));
    oYD.put("mp4", Integer.valueOf(2131689585));
    oYD.put("rmvb", Integer.valueOf(2131689585));
    oYD.put("rm", Integer.valueOf(2131689585));
    oYD.put("ra", Integer.valueOf(2131689585));
    oYD.put("ram", Integer.valueOf(2131689585));
    oYD.put("mp3pro", Integer.valueOf(2131689568));
    oYD.put("vqf", Integer.valueOf(2131689568));
    oYD.put("cd", Integer.valueOf(2131689568));
    oYD.put("md", Integer.valueOf(2131689568));
    oYD.put("mod", Integer.valueOf(2131689568));
    oYD.put("vorbis", Integer.valueOf(2131689568));
    oYD.put("au", Integer.valueOf(2131689568));
    oYD.put("amr", Integer.valueOf(2131689568));
    oYD.put("silk", Integer.valueOf(2131689568));
    oYD.put("wma", Integer.valueOf(2131689568));
    oYD.put("mmf", Integer.valueOf(2131689568));
    oYD.put("mid", Integer.valueOf(2131689568));
    oYD.put("midi", Integer.valueOf(2131689568));
    oYD.put("mp3", Integer.valueOf(2131689568));
    oYD.put("aac", Integer.valueOf(2131689568));
    oYD.put("ape", Integer.valueOf(2131689568));
    oYD.put("aiff", Integer.valueOf(2131689568));
    oYD.put("aif", Integer.valueOf(2131689568));
    oYD.put("doc", Integer.valueOf(2131689589));
    oYD.put("docx", Integer.valueOf(2131689589));
    oYD.put("ppt", Integer.valueOf(2131689575));
    oYD.put("pptx", Integer.valueOf(2131689575));
    oYD.put("xls", Integer.valueOf(2131689561));
    oYD.put("xlsx", Integer.valueOf(2131689561));
    oYD.put("pdf", Integer.valueOf(2131689572));
    oYD.put("unknown", Integer.valueOf(2131689581));
    localHashMap = new HashMap();
    Pxk = localHashMap;
    localHashMap.put("doc", Integer.valueOf(2131099928));
    Pxk.put("docx", Integer.valueOf(2131099928));
    Pxk.put("ppt", Integer.valueOf(2131099931));
    Pxk.put("pptx", Integer.valueOf(2131099931));
    Pxk.put("xls", Integer.valueOf(2131099934));
    Pxk.put("xlsx", Integer.valueOf(2131099934));
    Pxk.put("pdf", Integer.valueOf(2131099930));
    Pxk.put("unknown", Integer.valueOf(2131099932));
    Pxk.put("mp3pro", Integer.valueOf(2131099929));
    Pxk.put("vqf", Integer.valueOf(2131099929));
    Pxk.put("cd", Integer.valueOf(2131099929));
    Pxk.put("md", Integer.valueOf(2131099929));
    Pxk.put("mod", Integer.valueOf(2131099929));
    Pxk.put("vorbis", Integer.valueOf(2131099929));
    Pxk.put("au", Integer.valueOf(2131099929));
    Pxk.put("amr", Integer.valueOf(2131099929));
    Pxk.put("silk", Integer.valueOf(2131099929));
    Pxk.put("wma", Integer.valueOf(2131099929));
    Pxk.put("mmf", Integer.valueOf(2131099929));
    Pxk.put("mid", Integer.valueOf(2131099929));
    Pxk.put("midi", Integer.valueOf(2131099929));
    Pxk.put("mp3", Integer.valueOf(2131099929));
    Pxk.put("aac", Integer.valueOf(2131099929));
    Pxk.put("ape", Integer.valueOf(2131099929));
    Pxk.put("aiff", Integer.valueOf(2131099929));
    Pxk.put("aif", Integer.valueOf(2131099929));
    AppMethodBeat.o(35949);
  }
  
  public c(Context paramContext, ca paramca, String paramString)
  {
    super(paramContext, paramca);
    AppMethodBeat.i(35938);
    this.gzE = null;
    this.Pxj = false;
    this.vtY = false;
    this.Pxi = ((ImageGalleryGridUI)paramContext);
    this.gAn = paramString;
    this.tca = g.DQ(this.gAn);
    if (this.tca) {
      this.PlX = paramca.field_bizChatId;
    }
    bg.aVF();
    this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
    this.mInflater = LayoutInflater.from(paramContext);
    paramca = new com.tencent.mm.av.a.a.c.a();
    paramca.jbi = 1;
    paramca.jby = true;
    paramca.hZA = (com.tencent.mm.cb.a.jn(paramContext) / 3);
    paramca.hZz = (com.tencent.mm.cb.a.jn(paramContext) / 3);
    paramca.jbt = 2131100928;
    this.gzE = paramca.bdv();
    AppMethodBeat.o(35938);
  }
  
  private static String cv(ca paramca)
  {
    AppMethodBeat.i(35944);
    Object localObject1;
    if ((paramca.cWJ()) || (paramca.cWL()))
    {
      o.bhj();
      localObject1 = com.tencent.mm.modelvideo.t.Qx(paramca.field_imgPath);
    }
    for (;;)
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (paramca.gDr())
      {
        Object localObject3 = k.b.HD(paramca.field_content);
        localObject2 = null;
        paramca = (ca)localObject2;
        if (localObject3 != null)
        {
          paramca = (ca)localObject2;
          if (((k.b)localObject3).dCK != null)
          {
            paramca = (ca)localObject2;
            if (((k.b)localObject3).dCK.length() > 0)
            {
              localObject3 = ao.cgO().bdx(((k.b)localObject3).dCK);
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
      localObject2 = q.bcR().d(paramca.field_imgPath, false, false);
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("hd"))
        {
          localObject1 = localObject2;
          if (com.tencent.mm.vfs.s.YS((String)localObject2 + "hd")) {
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
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131689580");
      AppMethodBeat.o(35942);
      return 2131689581;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      AppMethodBeat.o(35942);
      return 2131689583;
    }
    if (paramb.type == 3)
    {
      AppMethodBeat.o(35942);
      return 2131689568;
    }
    if ((paramb.type == 6) && (oYD.containsKey(Util.nullAsNil(paramb.iwJ))))
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + oYD.get(Util.nullAsNil(paramb.iwJ)));
      int i = ((Integer)oYD.get(Util.nullAsNil(paramb.iwJ))).intValue();
      AppMethodBeat.o(35942);
      return i;
    }
    AppMethodBeat.o(35942);
    return 2131689581;
  }
  
  private static int k(k.b paramb)
  {
    AppMethodBeat.i(35943);
    if (paramb == null)
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131099932");
      AppMethodBeat.o(35943);
      return 2131099932;
    }
    if ((paramb.type == 5) || (paramb.type == 7) || (paramb.type == 15))
    {
      AppMethodBeat.o(35943);
      return 2131099933;
    }
    if ((paramb.type == 6) && (Pxk.containsKey(Util.nullAsNil(paramb.iwJ))))
    {
      Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + Pxk.get(Util.nullAsNil(paramb.iwJ)));
      int i = ((Integer)Pxk.get(Util.nullAsNil(paramb.iwJ))).intValue();
      AppMethodBeat.o(35943);
      return i;
    }
    AppMethodBeat.o(35943);
    return 2131099932;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(35939);
    if (this.tca)
    {
      bg.aVF();
      setCursor(com.tencent.mm.model.c.aSR().bY(this.gAn, this.PlX));
      AppMethodBeat.o(35939);
      return;
    }
    bg.aVF();
    setCursor(com.tencent.mm.model.c.aSQ().aEC(this.gAn));
    AppMethodBeat.o(35939);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(35940);
    if (this.tca)
    {
      bg.aVF();
      setCursor(com.tencent.mm.model.c.aSR().bY(this.gAn, this.PlX));
      AppMethodBeat.o(35940);
      return;
    }
    bg.aVF();
    setCursor(com.tencent.mm.model.c.aSQ().aEC(this.gAn));
    AppMethodBeat.o(35940);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void cWH()
  {
    AppMethodBeat.i(35945);
    this.vtY = false;
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
      paramView = this.mInflater.inflate(2131495048, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.tkI = ((ImageView)paramView.findViewById(2131302167));
      paramViewGroup.tkJ = paramView.findViewById(2131309835);
      paramViewGroup.Pxo = ((TextView)paramView.findViewById(2131300628));
      paramViewGroup.Pxo.setVisibility(8);
      paramViewGroup.Pxn = ((ImageView)paramView.findViewById(2131300621));
      paramViewGroup.qog = ((TextView)paramView.findViewById(2131309832));
      paramViewGroup.tkJ.setVisibility(8);
      paramViewGroup.tkL = paramView.findViewById(2131307900);
      paramViewGroup.tkL.setVisibility(8);
      paramViewGroup.Pxp = paramView.findViewById(2131300636);
      paramViewGroup.Pxp.setVisibility(8);
      paramViewGroup.tkK = ((ImageView)paramView.findViewById(2131302170));
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131304550));
      paramViewGroup.tkM = paramView.findViewById(2131304551);
      paramView.setTag(paramViewGroup);
    }
    ca localca;
    for (;;)
    {
      paramViewGroup.tkL.setVisibility(8);
      paramViewGroup.tkJ.setVisibility(8);
      paramViewGroup.Pxp.setVisibility(8);
      paramViewGroup.Pxo.setVisibility(8);
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
    if (this.qoo)
    {
      if (!(this.Pxi instanceof ImageGalleryGridUI))
      {
        paramView = new IllegalArgumentException("the context should be ImageGalleryGridUI");
        AppMethodBeat.o(35941);
        throw paramView;
      }
      localObject2 = localca.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aD((String)localObject2, localca.field_reserved);
      }
      if (this.Pxi.Pxq == paramInt)
      {
        paramViewGroup.tkK.setVisibility(0);
        if ((b.co(localca)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
        {
          paramViewGroup.Pxn.setImageDrawable(this.Pxi.getResources().getDrawable(j((k.b)localObject1)));
          paramViewGroup.tkI.setImageResource(k((k.b)localObject1));
          paramViewGroup.tkI.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.tkI.getMeasuredWidth();
          i = paramViewGroup.tkI.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label774;
          }
          label445:
          if (!b.m(localca)) {
            break label808;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.tkJ.setVisibility(0);
            localObject1 = j.cF(localca);
            if (localObject1 != null) {
              paramViewGroup.qog.setText(Util.formatSecToMin(((com.tencent.mm.modelvideo.s)localObject1).iFw));
            }
          }
          label492:
          paramViewGroup.checkBox.setChecked(h.a.gSp().cE(localca));
          paramViewGroup.checkBox.setTag(localca);
          paramViewGroup.tkM.setTag(paramViewGroup);
          paramViewGroup.tkM.setOnClickListener(this);
          if (!h.a.gSp().tku) {
            break label979;
          }
          paramViewGroup.checkBox.setVisibility(0);
          paramViewGroup.tkM.setVisibility(0);
          paramViewGroup.tkK.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35941);
      return paramView;
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.Pxn.setImageDrawable(this.Pxi.getResources().getDrawable(j((k.b)localObject1)));
      }
      q.bcV().a(cv(localca), paramViewGroup.tkI, this.gzE, new k()
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
      paramViewGroup.tkK.setVisibility(0);
      paramViewGroup.tkK.setBackgroundResource(2131100641);
      if ((b.co(localca)) && (localObject1 != null) && (((k.b)localObject1).type != 3))
      {
        paramViewGroup.Pxn.setImageDrawable(this.Pxi.getResources().getDrawable(j((k.b)localObject1)));
        paramViewGroup.tkI.setImageResource(k((k.b)localObject1));
        break;
      }
      if ((localObject1 != null) && (((k.b)localObject1).type == 3)) {
        paramViewGroup.Pxn.setImageDrawable(this.Pxi.getResources().getDrawable(j((k.b)localObject1)));
      }
      q.bcV().a(cv(localca), paramViewGroup.tkI, this.gzE);
      break;
      label774:
      localObject2 = paramViewGroup.tkK.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.tkK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label445;
      label808:
      if (b.cn(localca))
      {
        paramViewGroup.tkL.setVisibility(0);
        break label492;
      }
      if ((!b.co(localca)) || (paramViewGroup == null)) {
        break label492;
      }
      paramViewGroup.Pxp.setVisibility(0);
      paramViewGroup.Pxo.setVisibility(0);
      if (localObject1 == null) {
        break label492;
      }
      Log.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { Util.nullAsNil(((k.b)localObject1).title) });
      if (((k.b)localObject1).type != 24)
      {
        paramViewGroup.Pxo.setText(l.b(this.mContext, Util.nullAsNil(((k.b)localObject1).title), paramViewGroup.Pxo.getTextSize()));
        break label492;
      }
      paramViewGroup.Pxo.setText(l.b(paramViewGroup.Pxo.getContext(), paramViewGroup.Pxo.getContext().getString(2131759360), paramViewGroup.Pxo.getTextSize()));
      break label492;
      paramViewGroup.tkI.setImageResource(2131234279);
      break label492;
      label979:
      paramViewGroup.checkBox.setVisibility(8);
      paramViewGroup.tkM.setVisibility(8);
      paramViewGroup.tkK.setVisibility(8);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35946);
    super.notifyDataSetChanged();
    this.Pxj = false;
    AppMethodBeat.o(35946);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35947);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
    h localh = h.a.gSp();
    if (localh.cE((ca)localObject))
    {
      localh.cD((ca)localObject);
      if (!h.a.gSp().cE((ca)localObject)) {
        break label232;
      }
      paramView.checkBox.setChecked(true);
      paramView.tkK.setBackgroundResource(2131100584);
    }
    for (;;)
    {
      if ((!this.vtY) && (h.a.gSp().tkt.size() > 1))
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 20L, 1L, true);
        this.vtY = true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35947);
      return;
      localh.cC((ca)localObject);
      break;
      label232:
      paramView.checkBox.setChecked(false);
      paramView.tkK.setBackgroundResource(2131100641);
    }
  }
  
  protected static final class a
  {
    public ImageView Pxn;
    public TextView Pxo;
    public View Pxp;
    public CheckBox checkBox;
    public TextView qog;
    public ImageView tkI;
    public View tkJ;
    public ImageView tkK;
    public View tkL;
    public View tkM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c
 * JD-Core Version:    0.7.0.1
 */