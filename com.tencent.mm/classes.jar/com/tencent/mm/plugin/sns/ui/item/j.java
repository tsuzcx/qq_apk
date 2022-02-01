package com.tencent.mm.plugin.sns.ui.item;

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
import com.tencent.mm.b.g;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

public final class j
  extends BaseTimeLineItem
{
  public final void a(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, final TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(309010);
    String str = parambo.Rdg;
    final a locala = (a)paramBaseViewHolder;
    locala.RMU.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(b.e.music_mv_cover_empty_lightmode));
    if (aw.isDarkMode()) {
      locala.RMU.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(b.e.music_mv_cover_empty_darkmode));
    }
    Object localObject1 = "";
    paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
    label248:
    Object localObject2;
    if (paramTimeLineObject != null)
    {
      paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
      if (paramTimeLineObject.ContentObj != null)
      {
        paramBaseViewHolder = "";
        if (paramTimeLineObject.ContentObj.oPb == null) {
          break label1007;
        }
        paramBaseViewHolder = paramTimeLineObject.ContentObj.oPb.YqQ;
        if (Util.isNullOrNil(paramBaseViewHolder)) {
          break label932;
        }
        Log.i("MicroMsg.BaseTimeLineItem", "has mvInfo:%s", new Object[] { paramBaseViewHolder });
        locala.RMQ.findViewById(b.f.padding_view).setVisibility(0);
        ((ViewGroup.MarginLayoutParams)locala.RMS.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6);
        ((ViewGroup.MarginLayoutParams)locala.RfE.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
        locala.RMT.setVisibility(0);
        locala.RMT.setText(paramBaseViewHolder + MMApplicationContext.getContext().getString(b.j.music_mv_info_share_suffix));
        localObject1 = paramTimeLineObject.ContentObj.oPb.YqP;
        localObject1 = Util.nullAs((String)localObject1, "");
        Log.i("MicroMsg.BaseTimeLineItem", "coverInfo: coverUrl:%s, postInfo:%s", new Object[] { localObject1, paramBaseViewHolder });
        localObject2 = paramTimeLineObject.ContentObj.oPb;
        paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
        if (localObject2 != null)
        {
          paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
          if (paramTimeLineObject.ContentObj != null)
          {
            paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
            if (paramTimeLineObject.ContentObj.Zpr != null)
            {
              paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
              if (!paramTimeLineObject.ContentObj.Zpr.isEmpty())
              {
                paramBaseViewHolder = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
                if (Util.isNullOrNil(((dtj)localObject2).songName)) {
                  ((dtj)localObject2).songName = paramBaseViewHolder.hAP;
                }
                if (Util.isNullOrNil(((dtj)localObject2).singerName)) {
                  ((dtj)localObject2).singerName = paramBaseViewHolder.IGG;
                }
                if (Util.isNullOrNil(((dtj)localObject2).songLyric)) {
                  ((dtj)localObject2).songLyric = paramBaseViewHolder.songLyric;
                }
                if (Util.isNullOrNil(((dtj)localObject2).RfH)) {
                  ((dtj)localObject2).RfH = paramBaseViewHolder.songAlbumUrl;
                }
                paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
                if (Util.isNullOrNil(((dtj)localObject2).extraInfo))
                {
                  paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
                  if (paramTimeLineObject.actionInfo != null)
                  {
                    paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
                    if (paramTimeLineObject.actionInfo.YCC != null)
                    {
                      ((dtj)localObject2).extraInfo = paramTimeLineObject.actionInfo.YCC.YCn;
                      paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    dmz localdmz;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (!paramTimeLineObject.ContentObj.Zpr.isEmpty()))
    {
      localdmz = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
      if (Util.isNullOrNil(paramBaseViewHolder)) {
        break label1029;
      }
      Log.i("MicroMsg.BaseTimeLineItem", "loadMusicCover use mv, title: %s", new Object[] { localdmz.hAP });
      localObject2 = com.tencent.mm.plugin.music.h.b.aPp(paramBaseViewHolder);
      localObject1 = paramBaseViewHolder;
      paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject2;
      label573:
      localObject2 = new c.a();
      ((c.a)localObject2).fullPath = paramBaseViewHolder;
      ((c.a)localObject2).oKp = true;
      ((c.a)localObject2).nrc = true;
      ((c.a)localObject2).oKn = true;
      ((c.a)localObject2).nqa = true;
      ((c.a)localObject2).oKI = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
      localObject2 = ((c.a)localObject2).bKx();
      r.bKe().a((String)localObject1, locala.RMU, (com.tencent.mm.modelimage.loader.a.c)localObject2, new com.tencent.mm.modelimage.loader.b.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          AppMethodBeat.i(308971);
          if ((paramAnonymousb.bitmap != null) && (!paramAnonymousb.bitmap.isRecycled()))
          {
            ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).bK(paramTimeLineObject.Id, paramBaseViewHolder);
            paramAnonymousString = g.getMessageDigest(paramAnonymousString.getBytes());
            paramAnonymousView = com.tencent.mm.plugin.comm.b.xeH;
            com.tencent.mm.plugin.comm.b.a(MMApplicationContext.getContext(), locala.RMR, paramAnonymousb.bitmap, paramAnonymousString);
          }
          AppMethodBeat.o(308971);
        }
        
        public final void c(String paramAnonymousString, View paramAnonymousView) {}
      });
      paramTimeLineObject.ContentObj.oPb.oPc = paramBaseViewHolder;
      locala.RMV.setPressed(false);
      if (Util.isNullOrNil(paramTimeLineObject.ContentObj.oPb.singerName)) {
        break label1173;
      }
      locala.RfE.setVisibility(0);
      locala.RfE.setText(paramTimeLineObject.ContentObj.oPb.singerName);
      label726:
      paramBaseViewHolder = localdmz.hAP;
      if (Util.isNullOrNil(paramBaseViewHolder)) {
        break label1232;
      }
      locala.RMS.setVisibility(0);
      paramBaseViewHolder = new SpannableString(paramBaseViewHolder);
      locala.RMS.setText(paramBaseViewHolder, TextView.BufferType.SPANNABLE);
      label769:
      if (!bn.aUY(paramTimeLineObject.Id)) {
        break label1243;
      }
      locala.RMV.setImageResource(b.i.icons_outlined_pause2);
      locala.RMV.setContentDescription(MMApplicationContext.getString(b.j.sns_stop_music));
    }
    for (;;)
    {
      locala.RMV.setIconColor(MMApplicationContext.getContext().getResources().getColor(b.c.black_color));
      paramBaseViewHolder = new s(paramTimeLineObject, str);
      paramBaseViewHolder.nSq = 1;
      locala.RMV.setTag(paramBaseViewHolder);
      locala.RMV.setOnClickListener(parambn.RoS.RFF);
      locala.RMQ.setTag(paramBaseViewHolder);
      locala.RMQ.setOnClickListener(parambn.RoS.RFt);
      parambn.hpB().c(locala.RMQ, parambn.QBf.RQj, parambn.QBf.RPU);
      a(parambo, 2);
      AppMethodBeat.o(309010);
      return;
      label932:
      locala.RMQ.findViewById(b.f.padding_view).setVisibility(8);
      ((ViewGroup.MarginLayoutParams)locala.RMS.getLayoutParams()).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)locala.RfE.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
      locala.RMT.setText("");
      locala.RMT.setVisibility(8);
      break;
      label1007:
      paramTimeLineObject.ContentObj.oPb = new dtj();
      localObject1 = "";
      break label248;
      label1029:
      if (!Util.isNullOrNil(localdmz.aaTl))
      {
        Log.i("MicroMsg.BaseTimeLineItem", "loadMusicCover use media.Thumb, title: %s", new Object[] { localdmz.hAP });
        paramBaseViewHolder = com.tencent.mm.plugin.music.h.b.aPp(localdmz.aaTl);
        localObject1 = localdmz.aaTl;
        break label573;
      }
      paramBaseViewHolder = al.hgq().vk(localdmz.icg);
      localObject1 = t.aXq(paramBaseViewHolder.Oxm);
      localObject1 = as.mg(al.getAccSnsPath(), paramBaseViewHolder.Oxm) + (String)localObject1;
      Log.v("MicroMsg.BaseTimeLineItem", "loadMusicCover use thumb path: %s, exist: %s, title: %s", new Object[] { localObject1, Boolean.valueOf(y.ZC((String)localObject1)), localdmz.hAP });
      paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject1;
      break label573;
      label1173:
      if (!Util.isNullOrNil(localdmz.IGG))
      {
        locala.RfE.setVisibility(0);
        locala.RfE.setText(localdmz.IGG);
        break label726;
      }
      locala.RfE.setVisibility(8);
      locala.RfE.setText("");
      break label726;
      label1232:
      Log.e("MicroMsg.BaseTimeLineItem", "songName must make sure not empty");
      break label769;
      label1243:
      locala.RMV.setImageResource(b.i.icons_outlined_play2);
      locala.RMV.setContentDescription(MMApplicationContext.getString(b.j.sns_play_music));
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(308999);
    a locala = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.RKG != null) && (paramBaseViewHolder.RKG.getParent() != null))
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_media_music_item);
      if (!locala.RMO)
      {
        locala.RMP = ((RoundCornerRelativeLayout)paramBaseViewHolder.RKG.inflate().findViewById(b.f.round_corner_rl));
        locala.RMO = true;
      }
      locala.RMP.setRadius(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4));
      locala.RMR = locala.RMP.findViewById(b.f.blur_bg_view);
      locala.RMQ = locala.RMP.findViewById(b.f.music_container);
      if (!aw.isDarkMode()) {
        break label246;
      }
      locala.RMQ.setBackgroundResource(b.e.sns_music_mv_dark_gradient_bg);
    }
    for (;;)
    {
      locala.RMU = ((MMRoundCornerImageView)locala.RMQ.findViewById(b.f.chatting_music_cover));
      locala.RfE = ((TextView)locala.RMQ.findViewById(b.f.chatting_music_singer_name));
      locala.RMS = ((TextView)locala.RMQ.findViewById(b.f.chatting_music_song_name));
      locala.RMT = ((TextView)locala.RMQ.findViewById(b.f.chatting_music_mv_info));
      locala.RMV = ((WeImageView)locala.RMQ.findViewById(b.f.chatting_music_media_icon));
      AppMethodBeat.o(308999);
      return;
      locala.RMP = ((RoundCornerRelativeLayout)paramBaseViewHolder.convertView.findViewById(b.f.round_corner_rl));
      locala.RMO = true;
      break;
      label246:
      locala.RMQ.setBackgroundResource(b.e.sns_music_mv_light_gradient_bg);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean RMO = false;
    RoundCornerRelativeLayout RMP;
    View RMQ;
    View RMR;
    TextView RMS;
    TextView RMT;
    MMRoundCornerImageView RMU;
    WeImageView RMV;
    TextView RfE;
    
    public final String hqU()
    {
      AppMethodBeat.i(309019);
      Object localObject = new StringBuffer(this.RMU.getContext().getString(b.j.sns_link) + ",");
      if (this.RMS != null) {
        ((StringBuffer)localObject).append(this.RMS.getText() + ",");
      }
      if (this.RMT != null) {
        ((StringBuffer)localObject).append(this.RMT.getText() + ",");
      }
      if (this.RfE != null) {
        ((StringBuffer)localObject).append(this.RfE.getText() + ",");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(309019);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j
 * JD-Core Version:    0.7.0.1
 */