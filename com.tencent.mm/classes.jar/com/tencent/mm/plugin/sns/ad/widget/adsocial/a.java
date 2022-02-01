package com.tencent.mm.plugin.sns.ad.widget.adsocial;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.g.a;
import com.tencent.mm.plugin.sns.ui.item.f.a;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import java.util.Collection;
import java.util.LinkedList;

public final class a
{
  public static g.a a(g paramg)
  {
    AppMethodBeat.i(310279);
    g.a locala = new g.a();
    if (paramg == null)
    {
      AppMethodBeat.o(310279);
      return locala;
    }
    for (;;)
    {
      try
      {
        str1 = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        if (!"zh_CN".equals(str1)) {
          continue;
        }
        str1 = i.nullAsNil(paramg.QYh);
        str3 = i.nullAsNil(paramg.QYk);
        str2 = i.nullAsNil(paramg.QYn);
        paramg = str3;
        locala.QYs = str1;
        locala.QYk = paramg;
        locala.QYn = str2;
      }
      finally
      {
        String str1;
        String str3;
        String str2;
        continue;
      }
      AppMethodBeat.o(310279);
      return locala;
      if (("zh_TW".equals(str1)) || ("zh_HK".equals(str1)))
      {
        str1 = i.nullAsNil(paramg.QYi);
        str3 = i.nullAsNil(paramg.QYl);
        str2 = i.nullAsNil(paramg.QYo);
        paramg = str3;
      }
      else
      {
        str1 = i.nullAsNil(paramg.QYj);
        str3 = i.nullAsNil(paramg.QYm);
        str2 = i.nullAsNil(paramg.QYp);
        paramg = str3;
      }
    }
  }
  
  private static void a(int paramInt, a.b paramb)
  {
    AppMethodBeat.i(310269);
    if (paramb.Qcx.source == 0)
    {
      paramb = (ImageView)paramb.Qcs.findViewById(b.f.album_show_comment_tv);
      if (paramb != null) {
        paramb.setVisibility(paramInt);
      }
      AppMethodBeat.o(310269);
      return;
    }
    paramb = (ImageButton)paramb.Qcs.findViewById(b.f.album_show_comment_tv);
    if (paramb != null) {
      paramb.setVisibility(paramInt);
    }
    AppMethodBeat.o(310269);
  }
  
  public static void a(a.b paramb, SnsInfo paramSnsInfo, c paramc, f.a parama)
  {
    AppMethodBeat.i(310262);
    int i;
    Object localObject1;
    label163:
    Object localObject2;
    label294:
    int j;
    if (paramSnsInfo != null)
    {
      try
      {
        if (!paramSnsInfo.isSocialAttitudeAd()) {
          break label744;
        }
        i = 1;
        if (i == 0) {
          break label695;
        }
        if (paramb.Qcw == null) {
          paramb.Qcw = ((AdAttitudePlayView)paramb.Qcv.inflate());
        }
        if (paramb.Qcu == null)
        {
          paramb.Qcu = ((AdSocialAttitudeView)paramb.Qct.inflate());
          paramb.Qcu.setOnShowAttitudeListener(paramb.Qcw);
          paramb.Qcw.setOnAnimationStatusListener(paramb.Qcu);
        }
        a(8, paramb);
        paramb.Qcu.setTag(parama);
        paramb.Qcu.setOnCommentClickListener(paramc);
        paramb.Qcu.setVisibility(0);
        paramc = paramb.Qcu;
        paramc.Qee = paramb;
        paramc.PJQ = paramSnsInfo;
        localObject1 = ap.E(paramc.PJQ);
        parama = z.bAM();
        if ((localObject1 == null) || (TextUtils.isEmpty(parama))) {
          paramc.ajU(0);
        }
        for (;;)
        {
          paramc.Qef = paramSnsInfo.getAdXml().adSocialInfo;
          paramc.Qeg = ((ViewGroup)paramc.Qee.Qcs.findViewById(b.f.base_info_view));
          paramc.Qeh = ((LinearLayout)paramc.Qee.Qcs.findViewById(b.f.ad_social_left));
          paramc.Qei = ((LinearLayout)paramc.Qee.Qcs.findViewById(b.f.sns_timeline_content));
          localObject2 = a(paramc.Qef);
          parama = Util.nullAsNil(((g.a)localObject2).QYs);
          localObject1 = Util.nullAsNil(((g.a)localObject2).QYk);
          localObject2 = Util.nullAsNil(((g.a)localObject2).QYn);
          if (paramc.QdX != null)
          {
            if (!paramc.hcz()) {
              break label643;
            }
            paramc.QdX.setText(parama);
            paramc.Qej = ((int)Math.max(paramc.QdX.getPaint().measureText(parama), paramc.QdX.getPaint().measureText((String)localObject1)));
          }
          if (paramc.Qec != null)
          {
            paramc.Qec.setText((CharSequence)localObject2);
            paramc.Qek = ((int)paramc.Qec.getPaint().measureText((String)localObject2));
          }
          paramc.Qez = paramc.Qef.QYg;
          paramc.Qey = bb.m(paramc.getContext(), b.e.normal_like_icon, paramc.getContext().getResources().getColor(b.c.Link));
          paramc.Qey.setBounds(0, 0, paramc.Qey.getIntrinsicWidth(), paramc.Qey.getIntrinsicHeight());
          paramc.QdW.setTag(b.f.sns_ad_social_img_url, paramc.Qez);
          parama = new AdSocialAttitudeView.a(paramc);
          com.tencent.mm.plugin.sns.ad.j.a.a(paramc.Qez, parama);
          paramc.Qeb.setImageDrawable(bb.m(paramc.getContext(), b.e.ad_social_comment, paramc.getContext().getResources().getColor(b.c.Link)));
          paramc.hcA();
          paramc = paramb.Qcw;
          if (paramSnsInfo == null) {
            break label689;
          }
          parama = paramSnsInfo.getSnsId();
          if (!Util.isNullOrNil(parama)) {
            break label655;
          }
          Log.e("AdAttitudePlayView", "resetUI, snsId is null");
          AppMethodBeat.o(310262);
          return;
          localObject1 = ((SnsObject)localObject1).LikeUserList;
          if (!d.isEmpty((Collection)localObject1)) {
            break;
          }
          paramc.ajU(0);
        }
        j = ((LinkedList)localObject1).size();
      }
      finally
      {
        Log.e("AdSocialAttitudeHelper", "checkShowAdAttitude exp: " + paramb.toString());
        AppMethodBeat.o(310262);
        return;
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject2 = (fdv)((LinkedList)localObject1).get(i);
        if ((localObject2 != null) && (Util.isEqual(parama, ((fdv)localObject2).Username))) {
          paramc.ajU(1);
        }
      }
      else
      {
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label742;
          }
          paramc.ajU(0);
          break;
          label643:
          paramc.QdX.setText((CharSequence)localObject1);
          break label294;
          label655:
          if (!Util.isEqual(parama, paramc.QdJ))
          {
            paramc.QdJ = parama;
            paramc.PJQ = paramSnsInfo;
            paramc.QdI = paramb;
            paramc.hcx();
            paramc.hcv();
          }
          label689:
          AppMethodBeat.o(310262);
          return;
          label695:
          if (paramb.Qcu != null) {
            paramb.Qcu.setVisibility(8);
          }
          if (paramb.Qcw != null) {
            paramb.Qcw.setVisibility(8);
          }
          a(0, paramb);
          AppMethodBeat.o(310262);
          return;
        }
        label742:
        break label163;
        label744:
        i = 0;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.adsocial.a
 * JD-Core Version:    0.7.0.1
 */