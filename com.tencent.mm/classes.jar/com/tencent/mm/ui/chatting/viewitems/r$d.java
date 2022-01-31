package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
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
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class r$d
  extends c.a
{
  public ImageView jfv;
  public TextView mCZ;
  public ProgressBar progressBar;
  public ImageView zTT;
  public ImageView zUt;
  
  @SuppressLint({"ResourceType"})
  public static void a(d paramd, int paramInt, com.tencent.mm.ui.chatting.d.a parama, bi parambi, boolean paramBoolean, r.c paramc, c.c paramc1)
  {
    AppMethodBeat.i(33020);
    j.b localb = j.b.mY(bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    if (localb == null)
    {
      ab.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
      AppMethodBeat.o(33020);
      return;
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.em(localb.appId, localb.bDc);
    String str;
    if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.f)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.f)localObject).field_appName.trim().length() <= 0))
    {
      str = localb.appName;
      if ((localb.appId == null) || (localb.appId.length() <= 0) || (!c.dF(str))) {
        break label713;
      }
      paramd.mCZ.setText(com.tencent.mm.pluginsdk.model.app.g.b(parama.zJz.getContext(), (com.tencent.mm.pluginsdk.model.app.f)localObject, str));
      paramd.mCZ.setVisibility(0);
      c.a(parama, paramd.mCZ, localb.appId);
      label161:
      paramd.jfv.setImageDrawable(com.tencent.mm.cb.a.k(parama.zJz.getContext(), 2131231980));
      if (paramd.progressBar != null) {
        paramd.progressBar.setVisibility(8);
      }
      str = o.ahC().c(parambi.field_imgPath, false, true);
      ab.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", new Object[] { parambi.field_imgPath, str });
      localObject = o.ahC().a(str, com.tencent.mm.cb.a.getDensity(parama.zJz.getContext()), parama.zJz.getContext(), 2130838228);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label725;
      }
      paramd.zTT.setImageBitmap((Bitmap)localObject);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      paramd.zTT.setLayoutParams(localLayoutParams);
      localObject = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      paramd.zUt.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label340:
      if (paramBoolean)
      {
        if ((parambi.field_status != 5) && (parambi.field_status != 2)) {
          break label868;
        }
        if (paramd.progressBar != null) {
          paramd.progressBar.setVisibility(8);
        }
      }
      label377:
      paramd.jYu.setTag(new az(parambi, parama.dJG(), paramInt, parambi.field_talker, '\000'));
      paramd.jYu.setOnClickListener(paramc);
      paramd.jYu.setOnLongClickListener(paramc1);
      paramd.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
      com.tencent.mm.plugin.report.service.h.qsU.e(16979, new Object[] { localb.fiY, localb.fiW, Integer.valueOf(0), Integer.valueOf(0) });
      com.tencent.mm.modelappbrand.a.b.acD().qx("file://".concat(String.valueOf(str)));
      paramd = (com.tencent.mm.af.a)localb.R(com.tencent.mm.af.a.class);
      if ((paramd != null) && (!bo.isNullOrNil(paramd.appThumbUrl))) {
        com.tencent.mm.modelappbrand.a.b.acD().qx(paramd.appThumbUrl);
      }
      if ((paramd == null) || (bo.isNullOrNil(paramd.videoSource))) {
        break label894;
      }
      paramd = paramd.videoSource;
      if (com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.f.class) == null) {
        break label894;
      }
      parama = (com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.f.class);
      if (!parama.aLz()) {
        break label886;
      }
      paramInt = parama.aLA();
      if (com.tencent.mm.kernel.g.E(com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b.class) != null)
      {
        parama = (com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b)com.tencent.mm.kernel.g.E(com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b.class);
        if (paramInt == -1) {
          break label900;
        }
        paramInt = paramInt * 1024 * 1024;
      }
    }
    label900:
    for (;;)
    {
      paramBoolean = parama.k(paramd, 0L, paramInt);
      ab.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, weishi video preload size:%s, check cached:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if (!paramBoolean)
      {
        ab.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, weishi video preload url:%s", new Object[] { paramd });
        parama.j(paramd, 0L, paramInt);
      }
      AppMethodBeat.o(33020);
      return;
      str = ((com.tencent.mm.pluginsdk.model.app.f)localObject).field_appName;
      break;
      label713:
      paramd.mCZ.setVisibility(8);
      break label161;
      label725:
      ab.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
      paramd.zUt.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
      int i = com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), 85);
      int j = com.tencent.mm.cb.a.ao(parama.zJz.getContext(), 2131427520);
      localObject = d.a(d.au(parama.zJz.getContext().getResources().getColor(2131690155), i, j), 2130838228, i, j);
      paramd.zTT.setImageBitmap((Bitmap)localObject);
      localObject = new FrameLayout.LayoutParams(i, j);
      paramd.zTT.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new FrameLayout.LayoutParams(i, j);
      paramd.zUt.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label340;
      label868:
      if (paramd.progressBar == null) {
        break label377;
      }
      paramd.progressBar.setVisibility(0);
      break label377;
      label886:
      ab.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, weishi video preload disabled");
      label894:
      AppMethodBeat.o(33020);
      return;
    }
  }
  
  public final c.a fi(View paramView)
  {
    AppMethodBeat.i(33019);
    super.eV(paramView);
    this.zTT = ((ImageView)paramView.findViewById(2131822642));
    this.zUt = ((ImageView)paramView.findViewById(2131822646));
    this.jYu = paramView.findViewById(2131822580);
    this.jfv = ((ImageView)paramView.findViewById(2131822645));
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.mCZ = ((TextView)paramView.findViewById(2131822607));
    this.progressBar = ((ProgressBar)paramView.findViewById(2131822742));
    this.zRC = ((ImageView)paramView.findViewById(2131822695));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    AppMethodBeat.o(33019);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.d
 * JD-Core Version:    0.7.0.1
 */