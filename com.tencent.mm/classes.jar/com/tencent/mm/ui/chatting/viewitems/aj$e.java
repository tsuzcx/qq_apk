package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;

final class aj$e
  extends c.a
{
  public TextView Aoo;
  public ImageView aePK;
  public ImageView aeRQ;
  public ProgressBar progressBar;
  public ImageView uAw;
  
  public static void a(e parame, int paramInt, com.tencent.mm.ui.chatting.d.a parama, cc paramcc, boolean paramBoolean, aj.d paramd, c.c paramc)
  {
    AppMethodBeat.i(37082);
    k.b localb = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
    if (localb == null)
    {
      Log.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
      AppMethodBeat.o(37082);
      return;
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.is(localb.appId, localb.appVersion);
    String str;
    label161:
    int i;
    if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
    {
      str = localb.appName;
      if ((localb.appId == null) || (localb.appId.length() <= 0) || (!c.iA(str))) {
        break label708;
      }
      parame.Aoo.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama.aezO.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, str));
      parame.Aoo.setVisibility(0);
      c.a(parama, parame.Aoo, localb.appId);
      parame.uAw.setImageDrawable(com.tencent.mm.cd.a.m(parama.aezO.getContext(), R.k.shortvideo_play_btn));
      if (parame.progressBar != null) {
        parame.progressBar.setVisibility(8);
      }
      str = r.bKa().d(paramcc.field_imgPath, false, true);
      Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", new Object[] { paramcc.field_imgPath, str });
      i = R.g.chat_img_template;
      localObject = r.bKa();
      float f = com.tencent.mm.cd.a.getDensity(parama.aezO.getContext());
      parama.aezO.getContext();
      localObject = ((j)localObject).a(str, f, i);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label720;
      }
      parame.aePK.setImageBitmap((Bitmap)localObject);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      parame.aePK.setLayoutParams(localLayoutParams);
      localObject = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      parame.aeRQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label355:
      if (paramBoolean)
      {
        if ((paramcc.field_status != 5) && (paramcc.field_status != 2)) {
          break label863;
        }
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      parame.clickArea.setTag(new bz(paramcc, parama.juG(), paramInt, paramcc.field_talker, '\000'));
      parame.clickArea.setOnClickListener(paramd);
      parame.clickArea.setOnLongClickListener(paramc);
      parame.clickArea.setOnTouchListener(((m)parama.cm(m.class)).jqv());
      com.tencent.mm.plugin.report.service.h.OAn.b(16979, new Object[] { localb.nTE, localb.nTC, Integer.valueOf(0), Integer.valueOf(0) });
      b.bEY().KZ("file://".concat(String.valueOf(str)));
      parame = (com.tencent.mm.message.a)localb.aK(com.tencent.mm.message.a.class);
      if ((parame != null) && (!Util.isNullOrNil(parame.appThumbUrl))) {
        b.bEY().KZ(parame.appThumbUrl);
      }
      if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class) != null) {
        ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a(ab.tTX);
      }
      if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (parame == null) || (Util.isNullOrNil(parame.videoSource))) {
        break label889;
      }
      parame = parame.videoSource;
      if (com.tencent.mm.kernel.h.ax(l.class) == null) {
        break label889;
      }
      parama = (l)com.tencent.mm.kernel.h.ax(l.class);
      if (!parama.cJs()) {
        break label881;
      }
      Log.i("MicroMsg.WeishiVideoItemViewHolder", "[weishi] parseMsgInfo, invoke video cache task");
      i = parama.cJt();
      paramInt = i;
      if (i != -1) {
        paramInt = i * 1024 * 1024;
      }
      XIPCInvoker.a(Appbrand0IPCService.PROCESS_NAME, new AppBrandWeishiVideoOperation(parame, paramInt), aj.c.class, null);
      AppMethodBeat.o(37082);
      return;
      str = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
      break;
      label708:
      parame.Aoo.setVisibility(8);
      break label161;
      label720:
      Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
      parame.aeRQ.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
      int j = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 85);
      int k = com.tencent.mm.cd.a.br(parama.aezO.getContext(), R.f.ChatImgLimitWidth);
      localObject = BitmapUtil.createMaskImage(BitmapUtil.createColorBitmap(parama.aezO.getContext().getResources().getColor(R.e.grey_color_01), j, k), i, j, k);
      parame.aePK.setImageBitmap((Bitmap)localObject);
      localObject = new FrameLayout.LayoutParams(j, k);
      parame.aePK.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new FrameLayout.LayoutParams(j, k);
      parame.aeRQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label355;
      label863:
      if (parame.progressBar != null) {
        parame.progressBar.setVisibility(0);
      }
    }
    label881:
    Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, weishi video preload disabled");
    label889:
    AppMethodBeat.o(37082);
  }
  
  public final c.a lK(View paramView)
  {
    AppMethodBeat.i(37081);
    super.create(paramView);
    this.aePK = ((ImageView)paramView.findViewById(R.h.fxz));
    this.aeRQ = ((ImageView)paramView.findViewById(R.h.fxB));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.uAw = ((ImageView)paramView.findViewById(R.h.fAk));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.Aoo = ((TextView)paramView.findViewById(R.h.fwZ));
    this.progressBar = ((ProgressBar)paramView.findViewById(R.h.fAq));
    this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(37081);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.e
 * JD-Core Version:    0.7.0.1
 */