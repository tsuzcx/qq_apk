package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.b.g;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.protocal.protobuf.evj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.a.e.a.b;

public final class p
  implements com.tencent.mm.pluginsdk.j
{
  public final void G(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(245253);
    Object localObject = new evj();
    try
    {
      ((evj)localObject).parseFrom(paramArrayOfByte);
      label21:
      paramArrayOfByte = new EmojiInfo();
      String str = EmojiLogic.W(d.bzQ(), "", ((evj)localObject).abye);
      paramArrayOfByte.field_md5 = ((evj)localObject).abye;
      paramArrayOfByte.field_catalog = EmojiInfo.aklG;
      int i;
      if (ImgUtil.isGif(str))
      {
        i = EmojiInfo.aklO;
        paramArrayOfByte.field_type = i;
        paramArrayOfByte.field_groupId = ((evj)localObject).abyg;
        paramArrayOfByte.field_size = ((int)com.tencent.mm.vfs.y.bEl(str));
        paramArrayOfByte.field_temp = 1;
        paramArrayOfByte.field_activityid = ((evj)localObject).aaro;
        paramArrayOfByte.field_designerID = ((evj)localObject).abyi;
        paramArrayOfByte.field_thumbUrl = ((evj)localObject).abyh;
        if (Util.isNullOrNil(((evj)localObject).AesKey)) {
          break label217;
        }
        paramArrayOfByte.field_encrypturl = ((evj)localObject).EncryptUrl;
        paramArrayOfByte.field_aeskey = ((evj)localObject).AesKey;
        label157:
        if (!s.getEmojiStorageMgr().adju.bzd(((evj)localObject).abye)) {
          break label229;
        }
        s.getEmojiStorageMgr().adju.M(paramArrayOfByte);
      }
      for (;;)
      {
        localObject = com.tencent.mm.emoji.b.e.mgl;
        com.tencent.mm.emoji.b.e.a(paramArrayOfByte, new p..ExternalSyntheticLambda0(paramString, paramArrayOfByte));
        AppMethodBeat.o(245253);
        return;
        i = EmojiInfo.aklN;
        break;
        label217:
        paramArrayOfByte.field_cdnUrl = ((evj)localObject).EncryptUrl;
        break label157;
        label229:
        s.getEmojiStorageMgr().adju.K(paramArrayOfByte);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      break label21;
    }
  }
  
  public final v a(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31416);
    paramy = o.a(paramy, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31416);
    return paramy;
  }
  
  public final com.tencent.mm.ui.widget.a.e a(Context paramContext, String paramString1, Bitmap paramBitmap, String paramString2, int paramInt, y.a parama)
  {
    AppMethodBeat.i(245242);
    paramContext = new o.a(paramContext);
    paramContext.m(paramBitmap, paramInt);
    paramContext = paramContext.gA(paramString1).I(Boolean.TRUE).iLo();
    paramContext.GGQ = paramString2;
    paramContext = paramContext.b(parama).pRv;
    AppMethodBeat.o(245242);
    return paramContext;
  }
  
  public final com.tencent.mm.ui.widget.a.e a(Context paramContext, String paramString1, View paramView, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31419);
    paramContext = new o.a(paramContext).gA(paramString1).kL(paramView).I(Boolean.TRUE).iLo();
    paramContext.GGQ = paramString2;
    paramContext = paramContext.b(parama).pRv;
    AppMethodBeat.o(31419);
    return paramContext;
  }
  
  public final com.tencent.mm.ui.widget.a.e a(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(245247);
    o.a locala = new o.a(paramContext);
    Object localObject5 = k.b.Hf(Util.processXml(paramString2));
    Object localObject3 = (com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject5).aK(com.tencent.mm.pluginsdk.ui.tools.b.class);
    paramString2 = new aa();
    Object localObject1;
    View localView1;
    View localView2;
    Object localObject2;
    TextView localTextView1;
    TextView localTextView3;
    label277:
    Object localObject4;
    if (localObject3 != null)
    {
      localObject1 = new com.tencent.mm.loader.b.e.a();
      ((com.tencent.mm.loader.b.e.a)localObject1).nqd = true;
      ((com.tencent.mm.loader.b.e.a)localObject1).nqc = true;
      ((com.tencent.mm.loader.b.e.a)localObject1).nqp = true;
      ((com.tencent.mm.loader.b.e.a)localObject1).blI();
      localObject1 = View.inflate(paramContext, R.i.gol, null);
      ((RoundCornerRelativeLayout)((View)localObject1).findViewById(R.h.round_corner_rl)).setRadius(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4));
      localView1 = ((View)localObject1).findViewById(R.h.blur_bg_view);
      localView2 = ((View)localObject1).findViewById(R.h.music_container);
      if (!aw.isDarkMode()) {
        break label548;
      }
      localView2.setBackgroundResource(R.g.sns_music_mv_dark_gradient_bg);
      localObject2 = (MMRoundCornerImageView)localView2.findViewById(R.h.chatting_music_cover);
      localTextView1 = (TextView)localView2.findViewById(R.h.chatting_music_singer_name);
      TextView localTextView2 = (TextView)localView2.findViewById(R.h.chatting_music_song_name);
      localTextView3 = (TextView)localView2.findViewById(R.h.chatting_music_mv_info);
      ((MMRoundCornerImageView)localObject2).setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_lightmode));
      if (aw.isDarkMode()) {
        ((MMRoundCornerImageView)localObject2).setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_darkmode));
      }
      localTextView2.setText(((k.b)localObject5).getTitle());
      if (Util.isNullOrNil(((k.b)localObject5).getDescription())) {
        break label559;
      }
      localTextView1.setText(((k.b)localObject5).getDescription());
      localTextView1.setVisibility(0);
      localObject4 = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqP;
      localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqQ;
      if (Util.isNullOrNil((String)localObject3)) {
        break label576;
      }
      ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6);
      ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
      localView2.findViewById(R.h.padding_view).setVisibility(0);
      localTextView3.setText((String)localObject3 + paramContext.getString(R.l.music_mv_info_share_suffix));
      localTextView3.setVisibility(0);
      label384:
      localObject3 = new boolean[1];
      localObject3[0] = 0;
      if (Util.isNullOrNil((String)localObject4)) {
        break label593;
      }
      paramString3 = new c.a();
      paramString3.fullPath = com.tencent.mm.plugin.music.h.b.aPp((String)localObject4);
      paramString3.oKp = true;
      paramString3.nrc = true;
      paramString3.oKn = true;
      paramString3.oKI = com.tencent.mm.cd.a.fromDPToPix(paramContext, 2);
      paramString3 = paramString3.bKx();
      r.bKe().a((String)localObject4, (ImageView)localObject2, paramString3, new aa.1(paramString2, paramContext, localView1, (boolean[])localObject3));
    }
    for (;;)
    {
      localView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      locala.kL((View)localObject1);
      locala.iLo();
      paramContext = locala.gA(paramString1).I(Boolean.TRUE).iLo().awo(R.l.app_send).b(parama).pRv;
      AppMethodBeat.o(245247);
      return paramContext;
      label548:
      localView2.setBackgroundResource(R.g.sns_music_mv_light_gradient_bg);
      break;
      label559:
      localTextView1.setText("");
      localTextView1.setVisibility(8);
      break label277;
      label576:
      localTextView3.setText("");
      localTextView3.setVisibility(8);
      break label384;
      label593:
      if (!((k.b)localObject5).bwo())
      {
        bh.bCz();
        if (c.isSDCardAvailable())
        {
          paramString2 = null;
          localObject5 = r.bKa().d(paramString3, false, true);
          int j;
          if (!com.tencent.mm.vfs.y.ZC((String)localObject5)) {
            j = 0;
          }
          for (;;)
          {
            if (j == 0) {
              paramString2 = r.bKa().b(paramString3, com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext()), false);
            }
            if ((paramString2 == null) || (paramString2.isRecycled())) {
              break label773;
            }
            ((MMRoundCornerImageView)localObject2).setImageBitmap(paramString2);
            paramString3 = g.getMessageDigest(paramString3.getBytes());
            localObject2 = com.tencent.mm.plugin.comm.b.xeH;
            com.tencent.mm.plugin.comm.b.a(paramContext, localView1, paramString2, paramString3);
            break;
            int i = 0;
            localObject4 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject4).inJustDecodeBounds = true;
            localObject5 = BitmapUtil.decodeFile((String)localObject5, (BitmapFactory.Options)localObject4);
            j = ((BitmapFactory.Options)localObject4).outWidth;
            if (((BitmapFactory.Options)localObject4).outHeight * j > 1048576) {
              i = 1;
            }
            j = i;
            if (localObject5 != null)
            {
              ((Bitmap)localObject5).recycle();
              j = i;
            }
          }
          localObject3[0] = 1;
          continue;
        }
      }
      label773:
      ((MMRoundCornerImageView)localObject2).setImageBitmap(BitmapFactory.decodeResource(MMApplicationContext.getResources(), R.g.foI));
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, y.a parama, e.a.b paramb, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(245261);
    paramContext = new o.a(paramContext);
    paramContext.gA(paramString1);
    paramContext.I(Boolean.TRUE);
    paramContext.iLo();
    paramContext.bra(paramString2);
    paramContext.JH(false);
    paramContext.uBy = paramOnDismissListener;
    paramContext.a(paramb);
    paramContext.awo(R.l.app_send).b(new p.1(this, parama));
    paramContext.pRv.show();
    AppMethodBeat.o(245261);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, y.a parama)
  {
    AppMethodBeat.i(245257);
    EmojiInfo localEmojiInfo2 = s.getEmojiStorageMgr().adju.bza(paramString1);
    String str = EmojiLogic.W(d.bzQ(), "", paramString1);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      if (!ImgUtil.isGif(str)) {
        break label179;
      }
    }
    label179:
    for (int i = EmojiInfo.aklO;; i = EmojiInfo.aklN)
    {
      localEmojiInfo1 = new EmojiInfo();
      localEmojiInfo1.field_md5 = paramString1;
      localEmojiInfo1.field_catalog = EmojiInfo.aklG;
      localEmojiInfo1.field_type = i;
      localEmojiInfo1.field_size = ((int)com.tencent.mm.vfs.y.bEl(str));
      localEmojiInfo1.field_temp = 1;
      localEmojiInfo1.field_designerID = paramString2;
      localEmojiInfo1.field_thumbUrl = paramString4;
      s.getEmojiStorageMgr().adju.K(localEmojiInfo1);
      paramString1 = new o.a(paramContext);
      paramString1.a(localEmojiInfo1, paramString3);
      paramString1.I(Boolean.FALSE);
      paramString1.GGQ = paramContext.getString(R.l.app_choose);
      paramString1.b(parama).pRv.show();
      AppMethodBeat.o(245257);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31420);
    paramContext = new o.a(paramContext);
    paramContext.gA(paramString1).bra(paramString2).GGQ = paramString3;
    paramContext.brb(paramString5).iLn();
    paramContext.GGP.bDA(paramString4);
    paramContext.b(parama).pRv.show();
    AppMethodBeat.o(31420);
  }
  
  public final void a(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31417);
    o.a(paramy, paramString1, paramString2, paramString3, parama);
    AppMethodBeat.o(31417);
  }
  
  public final com.tencent.mm.ui.widget.a.e b(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31418);
    paramy = o.b(paramy, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31418);
    return paramy;
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31421);
    paramContext = new o.a(paramContext);
    paramContext.gA(paramString1);
    paramContext.brc(paramString2);
    paramContext.I(Boolean.TRUE);
    paramContext.GGQ = paramString3;
    paramContext.b(parama).pRv.show();
    AppMethodBeat.o(31421);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(245255);
    EmojiInfo localEmojiInfo2 = s.getEmojiStorageMgr().adju.bza(paramString2);
    String str = EmojiLogic.W(d.bzQ(), "", paramString2);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      if (!ImgUtil.isGif(str)) {
        break label186;
      }
    }
    label186:
    for (int i = EmojiInfo.aklO;; i = EmojiInfo.aklN)
    {
      localEmojiInfo1 = new EmojiInfo();
      localEmojiInfo1.field_md5 = paramString2;
      localEmojiInfo1.field_catalog = EmojiInfo.aklG;
      localEmojiInfo1.field_type = i;
      localEmojiInfo1.field_size = ((int)com.tencent.mm.vfs.y.bEl(str));
      localEmojiInfo1.field_temp = 1;
      localEmojiInfo1.field_designerID = paramString3;
      localEmojiInfo1.field_thumbUrl = paramString5;
      s.getEmojiStorageMgr().adju.K(localEmojiInfo1);
      paramString2 = new o.a(paramContext);
      paramString2.gA(paramString1);
      paramString2.a(localEmojiInfo1, paramString4);
      paramString2.I(Boolean.TRUE);
      paramString2.GGQ = paramContext.getString(R.l.app_send);
      paramString2.b(parama).pRv.show();
      AppMethodBeat.o(245255);
      return;
    }
  }
  
  public final void c(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(245252);
    paramContext = new o.a(paramContext);
    paramContext.gA(paramString1);
    paramContext.bra(paramString2);
    paramContext.I(Boolean.TRUE);
    paramContext.iLm();
    paramContext.GGQ = paramString3;
    paramContext.b(parama).pRv.show();
    AppMethodBeat.o(245252);
  }
  
  public final void d(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31422);
    paramString2 = bl.jba().adju.bza(paramString2);
    o.a locala = new o.a(paramContext);
    locala.gA(paramString1).a(paramString2, paramString3).I(Boolean.FALSE).awo(R.l.app_send);
    locala.bqZ(paramContext.getResources().getString(R.l.retransmit_to_conv_comfirm));
    locala.b(parama).pRv.show();
    AppMethodBeat.o(31422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.p
 * JD-Core Version:    0.7.0.1
 */