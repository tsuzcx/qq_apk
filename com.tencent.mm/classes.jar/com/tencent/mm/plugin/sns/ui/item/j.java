package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public final class j
  extends BaseTimeLineItem
{
  @SuppressLint({"ResourceType"})
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(203932);
    String str = parambl.Eql;
    a locala = (a)paramBaseViewHolder;
    parambl = "";
    paramBaseViewHolder = parambl;
    if (paramTimeLineObject != null)
    {
      paramBaseViewHolder = parambl;
      if (paramTimeLineObject.ContentObj != null)
      {
        paramBaseViewHolder = "";
        if (paramTimeLineObject.ContentObj.jfy == null) {
          break label963;
        }
        paramBaseViewHolder = paramTimeLineObject.ContentObj.jfy.Ktq;
        if (Util.isNullOrNil(paramBaseViewHolder)) {
          break label668;
        }
        Log.i("MicroMsg.BaseTimeLineItem", "has mvInfo:%s", new Object[] { paramBaseViewHolder });
        locala.EYT.findViewById(2131305768).setVisibility(0);
        ((ViewGroup.MarginLayoutParams)locala.EYV.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
        ((ViewGroup.MarginLayoutParams)locala.EsH.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
        locala.EYW.setVisibility(0);
        locala.EYW.setText(paramBaseViewHolder + MMApplicationContext.getContext().getString(2131763368));
      }
    }
    label300:
    label949:
    label963:
    for (parambl = paramTimeLineObject.ContentObj.jfy.Ktp;; parambl = "")
    {
      parambl = Util.nullAs(parambl, "");
      Log.i("MicroMsg.BaseTimeLineItem", "coverInfo: coverUrl:%s, postInfo:%s", new Object[] { parambl, paramBaseViewHolder });
      paramBaseViewHolder = parambl;
      cnb localcnb;
      if ((paramTimeLineObject.ContentObj != null) && (!paramTimeLineObject.ContentObj.LoV.isEmpty()))
      {
        localcnb = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
        if (Util.isNullOrNil(paramBaseViewHolder)) {
          break label742;
        }
        Log.i("MicroMsg.BaseTimeLineItem", "loadMusicCover use mv, title: %s", new Object[] { localcnb.Title });
        Object localObject = b.aIf(paramBaseViewHolder);
        parambl = paramBaseViewHolder;
        paramBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)localObject;
        localObject = new c.a();
        ((c.a)localObject).fullPath = paramBaseViewHolder;
        ((c.a)localObject).jbf = true;
        ((c.a)localObject).iaT = true;
        ((c.a)localObject).jbd = true;
        ((c.a)localObject).hZF = true;
        ((c.a)localObject).jbx = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
        localObject = ((c.a)localObject).bdv();
        com.tencent.mm.av.q.bcV().a(parambl, locala.EYX, (com.tencent.mm.av.a.a.c)localObject, new j.1(this, paramTimeLineObject, paramBaseViewHolder, locala));
        if (paramTimeLineObject.ContentObj.jfy == null) {
          paramTimeLineObject.ContentObj.jfy = new css();
        }
        paramTimeLineObject.ContentObj.jfy.jfz = paramBaseViewHolder;
        locala.EYY.setPressed(false);
        if (Util.isNullOrNil(paramTimeLineObject.ContentObj.jfy.singerName)) {
          break label879;
        }
        locala.EsH.setVisibility(0);
        locala.EsH.setText(paramTimeLineObject.ContentObj.jfy.singerName);
        label478:
        paramBaseViewHolder = localcnb.Title;
        if (Util.isNullOrNil(paramBaseViewHolder)) {
          break label938;
        }
        locala.EYV.setVisibility(0);
        paramBaseViewHolder = new SpannableString(paramBaseViewHolder);
        locala.EYV.setText(paramBaseViewHolder, TextView.BufferType.SPANNABLE);
        if (!bk.aMJ(paramTimeLineObject.Id)) {
          break label949;
        }
        locala.EYY.setImageResource(2131690862);
      }
      for (;;)
      {
        locala.EYY.setIconColor(MMApplicationContext.getContext().getResources().getColor(2131100044));
        locala.EYY.setTag(new com.tencent.mm.plugin.sns.ui.s(paramTimeLineObject, str));
        locala.EYY.setOnClickListener(parambk.EBo.ERr);
        locala.EYT.setTag(new com.tencent.mm.plugin.sns.ui.s(paramTimeLineObject, str));
        locala.EYT.setOnClickListener(parambk.EBo.ERf);
        parambk.fiV().c(locala.EYT, parambk.DQs.FaG, parambk.DQs.Far);
        AppMethodBeat.o(203932);
        return;
        locala.EYT.findViewById(2131305768).setVisibility(8);
        ((ViewGroup.MarginLayoutParams)locala.EYV.getLayoutParams()).topMargin = 0;
        ((ViewGroup.MarginLayoutParams)locala.EsH.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
        locala.EYW.setText("");
        locala.EYW.setVisibility(8);
        break;
        label742:
        if (!Util.isNullOrNil(localcnb.Msz))
        {
          Log.i("MicroMsg.BaseTimeLineItem", "loadMusicCover use media.Thumb, title: %s", new Object[] { localcnb.Title });
          paramBaseViewHolder = b.aIf(localcnb.Msz);
          parambl = localcnb.Msz;
          break label300;
        }
        paramBaseViewHolder = aj.faD().JK(localcnb.ecf);
        parambl = com.tencent.mm.plugin.sns.data.r.aOj(paramBaseViewHolder.EmN);
        parambl = ar.ki(aj.getAccSnsPath(), paramBaseViewHolder.EmN) + parambl;
        Log.v("MicroMsg.BaseTimeLineItem", "loadMusicCover use thumb path: %s, exist: %s, title: %s", new Object[] { parambl, Boolean.valueOf(com.tencent.mm.vfs.s.YS(parambl)), localcnb.Title });
        paramBaseViewHolder = parambl;
        break label300;
        label879:
        if (!Util.isNullOrNil(localcnb.Desc))
        {
          locala.EsH.setVisibility(0);
          locala.EsH.setText(localcnb.Desc);
          break label478;
        }
        locala.EsH.setVisibility(8);
        locala.EsH.setText("");
        break label478;
        Log.e("MicroMsg.BaseTimeLineItem", "songName must make sure not empty");
        break label521;
        locala.EYY.setImageResource(2131690885);
      }
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(203931);
    a locala = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.EWD != null) && (paramBaseViewHolder.EWD.getParent() != null))
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496458);
      if (!locala.EYR)
      {
        locala.EYS = ((RoundCornerRelativeLayout)paramBaseViewHolder.EWD.inflate().findViewById(2131307176));
        locala.EYR = true;
      }
      locala.EYS.setRadius(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4));
      locala.EYU = locala.EYS.findViewById(2131297645);
      locala.EYT = locala.EYS.findViewById(2131305087);
      if (!ao.isDarkMode()) {
        break label246;
      }
      locala.EYT.setBackgroundResource(2131234996);
    }
    for (;;)
    {
      locala.EYX = ((MMRoundCornerImageView)locala.EYT.findViewById(2131298519));
      locala.EsH = ((TextView)locala.EYT.findViewById(2131298523));
      locala.EYV = ((TextView)locala.EYT.findViewById(2131298524));
      locala.EYW = ((TextView)locala.EYT.findViewById(2131298521));
      locala.EYY = ((WeImageView)locala.EYT.findViewById(2131298520));
      AppMethodBeat.o(203931);
      return;
      locala.EYS = ((RoundCornerRelativeLayout)paramBaseViewHolder.convertView.findViewById(2131307176));
      locala.EYR = true;
      break;
      label246:
      locala.EYT.setBackgroundResource(2131234997);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean EYR = false;
    RoundCornerRelativeLayout EYS;
    View EYT;
    View EYU;
    TextView EYV;
    TextView EYW;
    MMRoundCornerImageView EYX;
    WeImageView EYY;
    TextView EsH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j
 * JD-Core Version:    0.7.0.1
 */