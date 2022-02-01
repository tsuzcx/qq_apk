package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.j;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.f.k.e;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ah.a;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/BackPreview;", "Lcom/tencent/mm/plugin/textstatus/api/IBackPreview;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "back", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBack", "()Landroid/view/View;", "setBack", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "setContext", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "isInOpen", "", "()Z", "setInOpen", "(Z)V", "isPlaying", "setPlaying", "ivMask", "Landroid/widget/ImageView;", "getIvMask", "()Landroid/widget/ImageView;", "setIvMask", "(Landroid/widget/ImageView;)V", "ivPreview", "getIvPreview", "setIvPreview", "lastId", "", "getLastId", "()J", "setLastId", "(J)V", "lastIsLocal", "getLastIsLocal", "setLastIsLocal", "lastVideoHeight", "", "getLastVideoHeight", "()I", "setLastVideoHeight", "(I)V", "lastVideoWidth", "getLastVideoWidth", "setLastVideoWidth", "layoutVideo", "Landroid/widget/FrameLayout;", "getLayoutVideo", "()Landroid/widget/FrameLayout;", "setLayoutVideo", "(Landroid/widget/FrameLayout;)V", "statusUIListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;", "getStatusUIListener", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;", "setStatusUIListener", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;)V", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;)V", "destroyVideo", "", "getView", "init", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTransAnim", "persent", "", "play", "setCardView", "cardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "setStatusBrowseUIListener", "listener", "stop", "update", "updateMask", "Companion", "plugin-textstatus_release"})
public final class a
  implements com.tencent.mm.plugin.textstatus.a.b
{
  public static final a.a GcC;
  private MMTPRecyclerVideoLayout AuG;
  private com.tencent.mm.plugin.textstatus.f.f.a FYx;
  private int GcA;
  private int GcB;
  private View Gcs;
  private ImageView Gct;
  private FrameLayout Gcu;
  private ImageView Gcv;
  private e Gcw;
  private boolean Gcx;
  private long Gcy;
  private boolean Gcz;
  private Context context;
  private boolean gVd;
  private String username;
  
  static
  {
    AppMethodBeat.i(216360);
    GcC = new a.a((byte)0);
    AppMethodBeat.o(216360);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(216359);
    this.context = paramContext;
    this.Gcs = LayoutInflater.from(this.context).inflate(2131496676, null, false);
    this.username = "";
    paramContext = this.Gcs.findViewById(2131302903);
    p.g(paramContext, "back.findViewById(R.id.iv_preview)");
    this.Gct = ((ImageView)paramContext);
    paramContext = this.Gcs.findViewById(2131303103);
    p.g(paramContext, "back.findViewById(R.id.layout_video)");
    this.Gcu = ((FrameLayout)paramContext);
    paramContext = this.Gcs.findViewById(2131302900);
    p.g(paramContext, "back.findViewById(R.id.iv_mask)");
    this.Gcv = ((ImageView)paramContext);
    this.Gcy = -1L;
    AppMethodBeat.o(216359);
  }
  
  private void fwh()
  {
    AppMethodBeat.i(216351);
    Log.i("MicroMsg.TxtStatus.BackPreview", "[destroyVideo]");
    Object localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stopAsync();
      }
    }
    localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
    }
    localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getEffector();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).release();
      }
    }
    this.AuG = null;
    this.Gcu.removeAllViews();
    AppMethodBeat.o(216351);
  }
  
  private void fwi()
  {
    AppMethodBeat.i(216358);
    Object localObject = this.FYx;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_backgroundId;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (!n.aL((CharSequence)localObject))) {
        break label80;
      }
    }
    label80:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.FYx;
        if ((localObject == null) || (((com.tencent.mm.plugin.textstatus.f.f.a)localObject).fvV() != true)) {
          break label85;
        }
      }
      this.Gcv.setVisibility(8);
      AppMethodBeat.o(216358);
      return;
      localObject = null;
      break;
    }
    label85:
    this.Gcv.setVisibility(0);
    AppMethodBeat.o(216358);
  }
  
  private void play()
  {
    AppMethodBeat.i(216350);
    Object localObject1 = (CharSequence)this.username;
    if ((localObject1 == null) || (n.aL((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216350);
      return;
    }
    this.gVd = true;
    localObject1 = f.FXJ;
    com.tencent.mm.plugin.textstatus.f.f.a locala = f.aTf(this.username);
    if (locala == null)
    {
      AppMethodBeat.o(216350);
      return;
    }
    Log.i("MicroMsg.TxtStatus.BackPreview", "[play] mediaType:%s, field_MediaUrl:%s, username:%s", new Object[] { Integer.valueOf(locala.field_MediaType), locala.field_MediaUrl, this.username });
    Object localObject2;
    MMTPRecyclerVideoLayout localMMTPRecyclerVideoLayout;
    Object localObject3;
    int k;
    long l;
    if (locala.field_MediaType == 2)
    {
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      if (this.AuG == null)
      {
        this.AuG = new MMTPRecyclerVideoLayout(this.context);
        localObject2 = this.AuG;
        if (localObject2 != null) {
          ((MMTPRecyclerVideoLayout)localObject2).fxf();
        }
      }
      localMMTPRecyclerVideoLayout = this.AuG;
      if (localMMTPRecyclerVideoLayout == null)
      {
        AppMethodBeat.o(216350);
        return;
      }
      this.Gcu.removeAllViews();
      this.Gcu.addView((View)localMMTPRecyclerVideoLayout, (ViewGroup.LayoutParams)localObject1);
      this.Gcu.setVisibility(0);
      if (locala.field_MediaUrl != null)
      {
        localObject1 = locala.field_MediaUrl;
        p.g(localObject1, "info.field_MediaUrl");
        localObject2 = kotlin.n.d.UTF_8;
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(216350);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
        p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
        localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      if (locala.field_MediaUrl != null)
      {
        localObject3 = locala.field_MediaUrl;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      int j = locala.field_mediaWidth;
      k = locala.field_mediaHeight;
      if (j > 0)
      {
        i = k;
        if (k > 0) {}
      }
      else
      {
        j = ah.jS(this.context).width;
        i = ah.jS(this.context).height;
      }
      localObject3 = com.tencent.mm.plugin.textstatus.j.a.GfU;
      localObject3 = com.tencent.mm.plugin.textstatus.j.a.aTo(this.username);
      boolean bool = s.YS((String)localObject3);
      if (bool)
      {
        localObject1 = new com.tencent.mm.plugin.thumbplayer.d.a((String)localObject1, (String)localObject3, (String)localObject2, j, i);
        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).dLQ = bool;
        if (bool)
        {
          localObject2 = MultiMediaVideoChecker.GyY.cA((String)localObject3, true);
          if (localObject2 == null) {
            break label689;
          }
          l = ((MultiMediaVideoChecker.a)localObject2).duration;
          label471:
          ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).pLQ = l;
          if (localObject2 == null) {
            break label695;
          }
          k = ((MultiMediaVideoChecker.a)localObject2).dYT;
          label489:
          ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).dYT = k;
        }
        Log.i("MicroMsg.TxtStatus.BackPreview", "[play] isLocal:%s, videoWidth:%s, videoHeight:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i) });
        localMMTPRecyclerVideoLayout.fxd();
        localMMTPRecyclerVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.d.a)localObject1);
        localObject2 = localMMTPRecyclerVideoLayout.getPlayer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).wcA = true;
        }
        localObject2 = localMMTPRecyclerVideoLayout.getPlayer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setLoop(true);
        }
        localMMTPRecyclerVideoLayout.getEffector().scaleType = 3;
        if (!locala.fvV()) {
          break label700;
        }
        localMMTPRecyclerVideoLayout.getEffector().fwM();
        label602:
        this.AuG = localMMTPRecyclerVideoLayout;
        this.Gcy = locala.systemRowid;
        this.Gcz = bool;
        this.GcA = j;
        this.GcB = i;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = localMMTPRecyclerVideoLayout.getPlayer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).fwU();
        }
        this.Gcu.setVisibility(0);
        fwi();
        AppMethodBeat.o(216350);
        return;
      }
      catch (Exception localException)
      {
        label689:
        label695:
        label700:
        Log.e("MicroMsg.TxtStatus.BackPreview", "unable to play video! mediaInfo:" + localObject1 + " error:" + localException.getLocalizedMessage());
      }
      localObject3 = com.tencent.mm.plugin.textstatus.j.a.GfU;
      localObject3 = com.tencent.mm.plugin.textstatus.j.a.lf("video", this.username);
      break;
      l = 0L;
      break label471;
      k = 0;
      break label489;
      localMMTPRecyclerVideoLayout.getEffector().fwN();
      break label602;
      this.Gcu.setVisibility(8);
      this.Gct.setVisibility(0);
    }
  }
  
  private void stop()
  {
    AppMethodBeat.i(216352);
    Object localObject = (CharSequence)this.username;
    if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216352);
      return;
    }
    this.gVd = false;
    localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).pause();
      }
    }
    this.Gcu.setVisibility(8);
    this.Gct.setVisibility(0);
    fwh();
    fwi();
    AppMethodBeat.o(216352);
  }
  
  public final void DV(String paramString)
  {
    AppMethodBeat.i(216353);
    p.h(paramString, "username");
    this.username = paramString;
    new k.e(paramString, (j)this);
    Object localObject = f.FXJ;
    this.FYx = f.aTf(paramString);
    Log.i("MicroMsg.TxtStatus.BackPreview", "[update TextStatusinfo]:" + this.FYx);
    localObject = this.FYx;
    if (localObject == null)
    {
      paramString = this.Gcw;
      if (paramString != null)
      {
        paramString.eEe();
        AppMethodBeat.o(216353);
        return;
      }
      AppMethodBeat.o(216353);
      return;
    }
    if (((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_MediaType == 2) {
      com.tencent.mm.plugin.textstatus.e.a.a(com.tencent.mm.plugin.textstatus.e.a.FYI, this.context, paramString, this.Gct);
    }
    for (;;)
    {
      paramString = this.Gcw;
      if (paramString != null) {
        paramString.eEf();
      }
      fwi();
      AppMethodBeat.o(216353);
      return;
      localObject = com.tencent.mm.plugin.textstatus.e.a.FYI;
      com.tencent.mm.plugin.textstatus.e.a.a(this.context, paramString, this.Gct, false);
    }
  }
  
  public final void UC(int paramInt) {}
  
  public final void UD(int paramInt) {}
  
  public final void UE(int paramInt) {}
  
  public final void a(e parame)
  {
    this.Gcw = parame;
  }
  
  public final void cd(float paramFloat)
  {
    AppMethodBeat.i(216357);
    this.Gcv.setAlpha(0.4F * (1.0F - paramFloat));
    AppMethodBeat.o(216357);
  }
  
  public final void eEk()
  {
    this.Gcx = true;
  }
  
  public final void eEl()
  {
    this.Gcx = false;
  }
  
  public final void eEm() {}
  
  public final void eEn() {}
  
  public final void fvv()
  {
    AppMethodBeat.i(216354);
    Log.i("MicroMsg.TxtStatus.BackPreview", "onStatusShowDestroy:%s", new Object[] { Boolean.valueOf(this.Gcx) });
    fwh();
    this.Gcw = null;
    AppMethodBeat.o(216354);
  }
  
  public final void fvw()
  {
    AppMethodBeat.i(216355);
    Log.i("MicroMsg.TxtStatus.BackPreview", "onStatusShowResume:%s", new Object[] { Boolean.valueOf(this.Gcx) });
    if (this.Gcx) {
      play();
    }
    AppMethodBeat.o(216355);
  }
  
  public final void fvx()
  {
    AppMethodBeat.i(216356);
    Log.i("MicroMsg.TxtStatus.BackPreview", "onStatusShowPause:%s", new Object[] { Boolean.valueOf(this.Gcx) });
    if (this.Gcx) {
      stop();
    }
    AppMethodBeat.o(216356);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(216349);
    View localView = this.Gcs;
    p.g(localView, "back");
    AppMethodBeat.o(216349);
    return localView;
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(216348);
    Log.i("MicroMsg.TxtStatus.BackPreview", "[onPostClose]");
    stop();
    AppMethodBeat.o(216348);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(216347);
    Log.i("MicroMsg.TxtStatus.BackPreview", "[onPostOpen]");
    play();
    AppMethodBeat.o(216347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.a
 * JD-Core Version:    0.7.0.1
 */