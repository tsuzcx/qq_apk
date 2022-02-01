package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.util.d;
import java.util.LinkedList;

public final class l
  extends BaseTimeLineItem
{
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(270600);
    paramViewStub = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.LkR != null) && (paramBaseViewHolder.LkR.getParent() != null))
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_media_music_item);
      if (!paramViewStub.Lnl)
      {
        paramViewStub.Lnm = ((RoundCornerRelativeLayout)paramBaseViewHolder.LkR.inflate().findViewById(i.f.round_corner_rl));
        paramViewStub.Lnl = true;
      }
      paramViewStub.Lnm.setRadius(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4));
      paramViewStub.Lno = paramViewStub.Lnm.findViewById(i.f.blur_bg_view);
      paramViewStub.Lnn = paramViewStub.Lnm.findViewById(i.f.music_container);
      if (!ar.isDarkMode()) {
        break label244;
      }
      paramViewStub.Lnn.setBackgroundResource(i.e.sns_music_mv_dark_gradient_bg);
    }
    for (;;)
    {
      paramViewStub.Lnr = ((MMRoundCornerImageView)paramViewStub.Lnn.findViewById(i.f.chatting_music_cover));
      paramViewStub.KGe = ((TextView)paramViewStub.Lnn.findViewById(i.f.chatting_music_singer_name));
      paramViewStub.Lnp = ((TextView)paramViewStub.Lnn.findViewById(i.f.chatting_music_song_name));
      paramViewStub.Lnq = ((TextView)paramViewStub.Lnn.findViewById(i.f.chatting_music_mv_info));
      paramViewStub.Lns = ((WeImageView)paramViewStub.Lnn.findViewById(i.f.chatting_music_media_icon));
      AppMethodBeat.o(270600);
      return;
      paramViewStub.Lnm = ((RoundCornerRelativeLayout)paramBaseViewHolder.convertView.findViewById(i.f.round_corner_rl));
      paramViewStub.Lnl = true;
      break;
      label244:
      paramViewStub.Lnn.setBackgroundResource(i.e.sns_music_mv_light_gradient_bg);
    }
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, final TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(270601);
    String str = parambn.KDB;
    final a locala = (a)paramBaseViewHolder;
    locala.Lnr.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(i.e.music_mv_cover_empty_lightmode));
    if (ar.isDarkMode()) {
      locala.Lnr.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(i.e.music_mv_cover_empty_darkmode));
    }
    parambn = "";
    paramBaseViewHolder = parambn;
    label244:
    Object localObject;
    if (paramTimeLineObject != null)
    {
      paramBaseViewHolder = parambn;
      if (paramTimeLineObject.ContentObj != null)
      {
        paramBaseViewHolder = "";
        if (paramTimeLineObject.ContentObj.lVY == null) {
          break label973;
        }
        paramBaseViewHolder = paramTimeLineObject.ContentObj.lVY.Rux;
        if (Util.isNullOrNil(paramBaseViewHolder)) {
          break label898;
        }
        Log.i("MicroMsg.BaseTimeLineItem", "has mvInfo:%s", new Object[] { paramBaseViewHolder });
        locala.Lnn.findViewById(i.f.padding_view).setVisibility(0);
        ((ViewGroup.MarginLayoutParams)locala.Lnp.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 6);
        ((ViewGroup.MarginLayoutParams)locala.KGe.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
        locala.Lnq.setVisibility(0);
        locala.Lnq.setText(paramBaseViewHolder + MMApplicationContext.getContext().getString(i.j.music_mv_info_share_suffix));
        parambn = paramTimeLineObject.ContentObj.lVY.Ruw;
        parambn = Util.nullAs(parambn, "");
        Log.i("MicroMsg.BaseTimeLineItem", "coverInfo: coverUrl:%s, postInfo:%s", new Object[] { parambn, paramBaseViewHolder });
        localObject = paramTimeLineObject.ContentObj.lVY;
        paramBaseViewHolder = parambn;
        if (localObject != null)
        {
          paramBaseViewHolder = parambn;
          if (paramTimeLineObject.ContentObj != null)
          {
            paramBaseViewHolder = parambn;
            if (paramTimeLineObject.ContentObj.Sqr != null)
            {
              paramBaseViewHolder = parambn;
              if (!paramTimeLineObject.ContentObj.Sqr.isEmpty())
              {
                paramBaseViewHolder = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
                if (Util.isNullOrNil(((dbr)localObject).HLH)) {
                  ((dbr)localObject).HLH = paramBaseViewHolder.fwr;
                }
                if (Util.isNullOrNil(((dbr)localObject).singerName)) {
                  ((dbr)localObject).singerName = paramBaseViewHolder.CMB;
                }
                if (Util.isNullOrNil(((dbr)localObject).songLyric)) {
                  ((dbr)localObject).songLyric = paramBaseViewHolder.songLyric;
                }
                if (Util.isNullOrNil(((dbr)localObject).KGh)) {
                  ((dbr)localObject).KGh = paramBaseViewHolder.songAlbumUrl;
                }
                paramBaseViewHolder = parambn;
                if (Util.isNullOrNil(((dbr)localObject).extraInfo))
                {
                  paramBaseViewHolder = parambn;
                  if (paramTimeLineObject.actionInfo != null)
                  {
                    paramBaseViewHolder = parambn;
                    if (paramTimeLineObject.actionInfo.RFO != null)
                    {
                      ((dbr)localObject).extraInfo = paramTimeLineObject.actionInfo.RFO.RFJ;
                      paramBaseViewHolder = parambn;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    cvt localcvt;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (!paramTimeLineObject.ContentObj.Sqr.isEmpty()))
    {
      localcvt = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
      if (Util.isNullOrNil(paramBaseViewHolder)) {
        break label994;
      }
      Log.i("MicroMsg.BaseTimeLineItem", "loadMusicCover use mv, title: %s", new Object[] { localcvt.fwr });
      localObject = com.tencent.mm.plugin.music.h.b.aSv(paramBaseViewHolder);
      parambn = paramBaseViewHolder;
      paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject;
      label559:
      localObject = new c.a();
      ((c.a)localObject).fullPath = paramBaseViewHolder;
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).kPz = true;
      ((c.a)localObject).lRB = true;
      ((c.a)localObject).kOl = true;
      ((c.a)localObject).lRW = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(parambn, locala.Lnr, (com.tencent.mm.ay.a.a.c)localObject, new com.tencent.mm.ay.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(237527);
          if ((paramAnonymousb.bitmap != null) && (!paramAnonymousb.bitmap.isRecycled()))
          {
            ((com.tencent.mm.bb.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class)).bz(paramTimeLineObject.Id, paramBaseViewHolder);
            paramAnonymousString = d.getMessageDigest(paramAnonymousString.getBytes());
            paramAnonymousView = com.tencent.mm.plugin.comm.b.ubp;
            com.tencent.mm.plugin.comm.b.a(MMApplicationContext.getContext(), locala.Lno, paramAnonymousb.bitmap, paramAnonymousString);
          }
          AppMethodBeat.o(237527);
        }
      });
      paramTimeLineObject.ContentObj.lVY.lVZ = paramBaseViewHolder;
      locala.Lns.setPressed(false);
      if (Util.isNullOrNil(paramTimeLineObject.ContentObj.lVY.singerName)) {
        break label1131;
      }
      locala.KGe.setVisibility(0);
      locala.KGe.setText(paramTimeLineObject.ContentObj.lVY.singerName);
      label711:
      paramBaseViewHolder = localcvt.fwr;
      if (Util.isNullOrNil(paramBaseViewHolder)) {
        break label1190;
      }
      locala.Lnp.setVisibility(0);
      paramBaseViewHolder = new SpannableString(paramBaseViewHolder);
      locala.Lnp.setText(paramBaseViewHolder, TextView.BufferType.SPANNABLE);
      label754:
      if (!bm.aXq(paramTimeLineObject.Id)) {
        break label1201;
      }
      locala.Lns.setImageResource(i.i.icons_outlined_pause2);
    }
    for (;;)
    {
      locala.Lns.setIconColor(MMApplicationContext.getContext().getResources().getColor(i.c.black_color));
      paramBaseViewHolder = new s(paramTimeLineObject, str);
      paramBaseViewHolder.lnm = 1;
      locala.Lns.setTag(paramBaseViewHolder);
      locala.Lns.setOnClickListener(parambm.KPg.Lft);
      locala.Lnn.setTag(paramBaseViewHolder);
      locala.Lnn.setOnClickListener(parambm.KPg.Lfh);
      parambm.fXi().c(locala.Lnn, parambm.Kdz.Lpe, parambm.Kdz.LoP);
      AppMethodBeat.o(270601);
      return;
      label898:
      locala.Lnn.findViewById(i.f.padding_view).setVisibility(8);
      ((ViewGroup.MarginLayoutParams)locala.Lnp.getLayoutParams()).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)locala.KGe.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
      locala.Lnq.setText("");
      locala.Lnq.setVisibility(8);
      break;
      label973:
      paramTimeLineObject.ContentObj.lVY = new dbr();
      parambn = "";
      break label244;
      label994:
      if (!Util.isNullOrNil(localcvt.TDF))
      {
        Log.i("MicroMsg.BaseTimeLineItem", "loadMusicCover use media.Thumb, title: %s", new Object[] { localcvt.fwr });
        paramBaseViewHolder = com.tencent.mm.plugin.music.h.b.aSv(localcvt.TDF);
        parambn = localcvt.TDF;
        break label559;
      }
      paramBaseViewHolder = aj.fOx().Re(localcvt.fWh);
      parambn = t.aZf(paramBaseViewHolder.KzW);
      parambn = aq.kD(aj.getAccSnsPath(), paramBaseViewHolder.KzW) + parambn;
      Log.v("MicroMsg.BaseTimeLineItem", "loadMusicCover use thumb path: %s, exist: %s, title: %s", new Object[] { parambn, Boolean.valueOf(u.agG(parambn)), localcvt.fwr });
      paramBaseViewHolder = parambn;
      break label559;
      label1131:
      if (!Util.isNullOrNil(localcvt.CMB))
      {
        locala.KGe.setVisibility(0);
        locala.KGe.setText(localcvt.CMB);
        break label711;
      }
      locala.KGe.setVisibility(8);
      locala.KGe.setText("");
      break label711;
      label1190:
      Log.e("MicroMsg.BaseTimeLineItem", "songName must make sure not empty");
      break label754;
      label1201:
      locala.Lns.setImageResource(i.i.icons_outlined_play2);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    TextView KGe;
    boolean Lnl = false;
    RoundCornerRelativeLayout Lnm;
    View Lnn;
    View Lno;
    TextView Lnp;
    TextView Lnq;
    MMRoundCornerImageView Lnr;
    WeImageView Lns;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.l
 * JD-Core Version:    0.7.0.1
 */