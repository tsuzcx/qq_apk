package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.j.a;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

final class d$c
  extends c.a
{
  public static int[] kka = { R.h.chatting_note_thumb_iv_0, R.h.chatting_note_thumb_iv_1, R.h.chatting_note_thumb_iv_2, R.h.chatting_note_thumb_iv_3, R.h.chatting_note_thumb_iv_4 };
  protected TextView eXO;
  protected TextView eXP;
  protected TextView kiv;
  private ArrayList<MMImageView> oSb = new ArrayList();
  protected ChattingItemFooter vBA;
  protected ImageView vBB;
  protected LinearLayout vBC;
  protected ViewGroup vBD;
  protected TextView vBE;
  protected LinearLayout vBF;
  protected RelativeLayout vBG;
  protected FrameLayout vBH;
  protected LinearLayout vBI;
  protected LinearLayout vBJ;
  protected ViewStub vBK;
  protected ImageView vBL;
  protected ImageView vBM;
  ImageView vBN;
  protected LinearLayout vBO;
  protected ImageView vBP;
  protected TextView vBQ;
  protected TextView vBR;
  protected ImageView vBS;
  protected TextView vBT;
  protected TextView vBU;
  protected LinearLayout vBV;
  protected ImageView vBW;
  protected ImageView vBX;
  protected TextView vBY;
  public int vBZ = 0;
  protected MMImageView vBn;
  protected ImageView vBo;
  protected ImageView vBp;
  protected TextView vBq;
  protected LinearLayout vBr;
  protected TextView vBs;
  protected ImageView vBt;
  protected MMPinProgressBtn vBu;
  protected ImageView vBv;
  protected ImageView vBw;
  protected ImageView vBx;
  protected ImageView vBy;
  protected TextView vBz;
  private int vCa = 2147483647;
  
  private static void a(com.tencent.mm.ui.chatting.c.a parama, c paramc, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt1, String[] paramArrayOfString4, String[] paramArrayOfString5, int[] paramArrayOfInt2, String paramString)
  {
    int i = 0;
    while (i <= 4)
    {
      localObject1 = (MMImageView)paramc.vBJ.findViewById(kka[i]);
      if (localObject1 != null)
      {
        ((MMImageView)localObject1).setImageDrawable(null);
        ((MMImageView)localObject1).setVisibility(8);
      }
      i += 1;
    }
    Object localObject1 = (ImageView)paramc.vBJ.findViewById(R.h.chatting_note_thumb_mask);
    Object localObject2 = (TextView)paramc.vBJ.findViewById(R.h.chatting_note_thumb_exceed_num);
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(8);
    }
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(8);
    }
    i = 0;
    if (i < paramInt)
    {
      label148:
      Object localObject3;
      if (paramInt == 1)
      {
        localObject1 = (MMImageView)paramc.vBJ.findViewById(kka[i]);
        ((MMImageView)localObject1).setImageResource(R.k.chatting_note_default_img_one);
        ((MMImageView)localObject1).setVisibility(0);
        ap.clb().a((j.a)parama.ac(com.tencent.mm.ui.chatting.b.b.g.class), paramArrayOfString1[i], bk.UY(), paramArrayOfString2[i], paramArrayOfString3[i], paramArrayOfInt1[i], paramString);
        localObject2 = o.OJ().o("Note_" + paramArrayOfString1[i], "", "");
        localObject3 = new com.tencent.mm.as.a.a.c.a();
        ((com.tencent.mm.as.a.a.c.a)localObject3).erk = 1;
        ((com.tencent.mm.as.a.a.c.a)localObject3).erF = true;
        ((com.tencent.mm.as.a.a.c.a)localObject3).ery = R.k.chatting_note_default_img;
        ((com.tencent.mm.as.a.a.c.a)localObject3).erl = ((int)parama.vtz.getMMResources().getDimension(R.f.ChatItemThumWidth));
        ((com.tencent.mm.as.a.a.c.a)localObject3).erm = ((int)parama.vtz.getMMResources().getDimension(R.f.ChatItemThumWidth));
        localObject3 = ((com.tencent.mm.as.a.a.c.a)localObject3).OV();
        if (!com.tencent.mm.vfs.e.bK((String)localObject2)) {
          break label359;
        }
        o.ON().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.as.a.a.c)localObject3);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (MMImageView)paramc.vBJ.findViewById(kka[(i + 1)]);
        ((MMImageView)localObject1).setImageResource(R.k.chatting_note_default_img);
        break label148;
        label359:
        ap.clb().a((j.a)parama.ac(com.tencent.mm.ui.chatting.b.b.g.class), paramArrayOfString1[i], bk.UY(), paramArrayOfString4[i], paramArrayOfString5[i], paramArrayOfInt2[i], paramString);
        o.OJ().o("Note_" + paramArrayOfString1[i], "", "");
        com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), 45);
        if (com.tencent.mm.vfs.e.bK((String)localObject2)) {
          o.ON().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.as.a.a.c)localObject3);
        } else {
          y.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
        }
      }
    }
  }
  
  static void a(com.tencent.mm.ui.chatting.c.a parama, c paramc, g.a parama1, bi parambi, boolean paramBoolean)
  {
    Object localObject1 = new nd();
    ((nd)localObject1).bWJ.type = 0;
    ((nd)localObject1).bWJ.bWL = parama1.dRd;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = ((nd)localObject1).bWK.bWT;
    paramc.vBG.setVisibility(8);
    String[] arrayOfString1 = new String[4];
    String[] arrayOfString2 = new String[4];
    int[] arrayOfInt1 = new int[4];
    String[] arrayOfString3 = new String[4];
    String[] arrayOfString4 = new String[4];
    int[] arrayOfInt2 = new int[4];
    String[] arrayOfString5 = new String[4];
    int k;
    Object localObject3;
    int i;
    Object localObject4;
    label260:
    String str;
    if (localObject2 != null)
    {
      localObject1 = null;
      parama1 = bk.aM(((com.tencent.mm.protocal.b.a.c)localObject2).desc, parama1.description);
      k = 0;
      localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject2).dTx.iterator();
      i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (xv)((Iterator)localObject3).next();
        if ((bk.bl(((xv)localObject4).sUV)) || (!((xv)localObject4).sUV.equals(".htm")) || (bk.bl(((xv)localObject4).sVI)) || (!((xv)localObject4).sVI.equals("WeNoteHtmlFile"))) {
          switch (((xv)localObject4).aYU)
          {
          case 3: 
          case 6: 
          case 4: 
          case 5: 
          case 7: 
          default: 
          case 1: 
            do
            {
              do
              {
                break;
              } while (k != 0);
              str = ((xv)localObject4).desc;
            } while (bk.bl(str));
            if (bk.bl(str.replaceAll("\n", "").trim())) {
              break label1213;
            }
            localObject1 = ((xv)localObject4).desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
        }
      }
    }
    label803:
    label1204:
    label1207:
    label1213:
    for (;;)
    {
      k = 1;
      break;
      if (paramBoolean)
      {
        paramc.vBG.setVisibility(0);
        paramc.vBn.setVisibility(0);
        paramc.vBn.setImageResource(R.g.app_attach_file_icon_pic);
      }
      if (i < 4)
      {
        arrayOfString1[i] = ((xv)localObject4).dQL;
        arrayOfString2[i] = ((xv)localObject4).sUC;
        arrayOfInt1[i] = ((int)((xv)localObject4).sVm);
        arrayOfString3[i] = ((xv)localObject4).sUG;
        arrayOfString4[i] = ((xv)localObject4).sUI;
        arrayOfInt2[i] = ((int)((xv)localObject4).sVb);
        arrayOfString5[i] = ((xv)localObject4).kgC;
      }
      i += 1;
      break;
      if (!bk.bl(parama1)) {
        break label260;
      }
      parama1 = ae.getContext().getString(R.l.app_file) + ((xv)localObject4).title;
      break label260;
      if (localObject1 != null)
      {
        localObject4 = ((String)localObject1).split("\n", 2);
        localObject3 = new ArrayList();
        if (localObject4.length > 0)
        {
          int m = localObject4.length;
          j = 0;
          while (j < m)
          {
            str = localObject4[j];
            if (str.length() > 0) {
              ((ArrayList)localObject3).add(str);
            }
            j += 1;
          }
        }
        if (((ArrayList)localObject3).size() != 1) {
          break label1207;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).dTx.size() == 2))
        {
          localObject2 = ae.getContext().getString(R.l.favorite_wenote);
          parama1 = (g.a)localObject1;
          localObject1 = localObject2;
          localObject1 = ((String)localObject1).trim();
          label628:
          if (localObject1 == null) {
            break label1204;
          }
          localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(paramc.vBs.getContext(), (CharSequence)localObject1, (int)paramc.vBs.getTextSize());
          paramc.vBs.setText((CharSequence)localObject1);
          if ((parama1 != null) && (parama1.length() > 100)) {
            parama1 = parama1.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
          for (;;)
          {
            for (;;)
            {
              localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(paramc.eXP.getContext(), parama1, (int)paramc.eXP.getTextSize());
              paramc.eXP.setText((CharSequence)localObject1);
              if (i > 0)
              {
                paramc.vBG.setVisibility(8);
                if ((j != 0) || (k == 0) || (bk.bl(parama1)))
                {
                  paramc.eXP.setVisibility(8);
                  paramc.vBs.setMaxLines(2);
                  paramc.vBL.setVisibility(8);
                  paramc.vBK.setLayoutResource(R.i.chatting_item_note_image_multi);
                }
                try
                {
                  if (paramc.vBJ == null) {
                    paramc.vBJ = ((LinearLayout)paramc.vBK.inflate());
                  }
                  for (;;)
                  {
                    if (i <= 4) {
                      break label1176;
                    }
                    j = 4;
                    a(parama, paramc, j, arrayOfString5, arrayOfString2, arrayOfString1, arrayOfInt1, arrayOfString4, arrayOfString3, arrayOfInt2, parambi.field_talker);
                    parama = (ImageView)paramc.vBJ.findViewById(R.h.chatting_note_thumb_mask);
                    paramc = (TextView)paramc.vBJ.findViewById(R.h.chatting_note_thumb_exceed_num);
                    if (paramc != null) {
                      paramc.setTextSize(0, ae.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding));
                    }
                    if (i > 4)
                    {
                      if (parama != null) {
                        parama.setVisibility(0);
                      }
                      if (paramc != null)
                      {
                        paramc.setText("(" + i + ")");
                        paramc.setVisibility(0);
                      }
                    }
                    return;
                    if (i > 0)
                    {
                      localObject1 = (String)((ArrayList)localObject3).get(0);
                      if (((ArrayList)localObject3).size() > 1)
                      {
                        parama1 = (String)((ArrayList)localObject3).get(1);
                        break;
                      }
                      parama1 = null;
                      break;
                    }
                    localObject2 = (String)((ArrayList)localObject3).get(0);
                    localObject3 = parama1.split(Pattern.quote((String)localObject2), 2);
                    parama1 = localObject3[0].trim();
                    localObject1 = localObject2;
                    if (localObject3.length <= 1) {
                      break;
                    }
                    parama1 = (localObject3[0].trim() + "\n" + localObject3[1].trim()).trim();
                    localObject1 = localObject2;
                    break;
                    localObject1 = ae.getContext().getString(R.l.favorite_wenote);
                    j = 0;
                    break label628;
                    paramc.eXP.setMaxLines(1);
                    paramc.eXP.setVisibility(0);
                    paramc.vBs.setMaxLines(1);
                    break label803;
                    paramc.vBJ.setVisibility(0);
                  }
                }
                catch (Exception parama1)
                {
                  for (;;)
                  {
                    paramc.vBK.setVisibility(0);
                    continue;
                    j = i;
                  }
                }
              }
            }
            paramc.vBK.setVisibility(8);
            paramc.vBL.setVisibility(0);
            return;
          }
        }
      }
    }
  }
  
  static void a(com.tencent.mm.ui.chatting.c.a parama, c paramc, g.a parama1, boolean paramBoolean)
  {
    paramc.eXO.setVisibility(8);
    String str;
    Object localObject1;
    Object localObject3;
    label215:
    Object localObject2;
    int i;
    if ((parama1.title != null) && (parama1.title.trim().length() > 0))
    {
      str = parama1.title;
      paramc.vBs.setVisibility(0);
      paramc.vBs.setMaxLines(2);
      paramc.eXP.setMaxLines(4);
      paramc.vBy.setVisibility(8);
      paramc.vBt.setVisibility(4);
      if (paramBoolean) {
        paramc.vBn.setVisibility(8);
      }
      localObject1 = new nd();
      ((nd)localObject1).bWJ.type = 0;
      ((nd)localObject1).bWJ.bWL = parama1.dRd;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject3 = ((nd)localObject1).bWK.bWT;
      if (localObject3 == null) {
        break label992;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.d.j.a(paramc.vBs.getContext(), bk.aM(((com.tencent.mm.protocal.b.a.c)localObject3).title, parama1.title), paramc.vBs.getTextSize());
      paramc.vBs.setText((CharSequence)localObject1);
      localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject3).desc;
      if (localObject1 != null) {
        break label502;
      }
      y.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { parama1.dRd });
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 100) {
          localObject2 = ((String)localObject1).substring(0, 100);
        }
      }
      paramc.eXP.setText(com.tencent.mm.pluginsdk.ui.d.j.a(paramc.eXP.getContext(), bk.aM((String)localObject2, parama1.description), paramc.eXP.getTextSize()));
      parama1 = ((com.tencent.mm.protocal.b.a.c)localObject3).dTx.iterator();
      i = 0;
      localObject2 = null;
      localObject1 = null;
      label299:
      do
      {
        if (!parama1.hasNext()) {
          break;
        }
        localObject3 = (xv)parama1.next();
      } while ((!bk.bl(((xv)localObject3).sUV)) && (((xv)localObject3).sUV.equals(".htm")) && (!bk.bl(((xv)localObject3).sVI)) && (((xv)localObject3).sVI.equals("WeNoteHtmlFile")));
      if (((xv)localObject3).sVA.sWd.sWB == null) {
        break label527;
      }
      str = parama.vtz.getContext().getString(R.l.record_chatroom_title);
      i = 1;
      label401:
      switch (((xv)localObject3).aYU)
      {
      }
    }
    for (;;)
    {
      break label299;
      paramc.vBs.setVisibility(8);
      str = null;
      break;
      label502:
      localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
      break label215;
      label527:
      if (((xv)localObject3).sVA.sWd.bRO == null) {
        break label989;
      }
      if (localObject1 == null)
      {
        localObject1 = ((xv)localObject3).sVC;
        break label401;
      }
      if (localObject1 == ((xv)localObject3).sVC) {
        break label989;
      }
      localObject2 = ((xv)localObject3).sVC;
      break label401;
      if (paramBoolean)
      {
        paramc.vBn.setVisibility(0);
        paramc.vBn.setImageResource(R.k.app_attach_file_icon_voice);
      }
      break label299;
      break label299;
      if (paramBoolean)
      {
        paramc.vBn.setVisibility(0);
        paramc.vBn.setImageResource(R.g.app_attach_file_icon_pic);
      }
      break label299;
      if (paramBoolean)
      {
        paramc.vBn.setVisibility(0);
        paramc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
      }
      break label299;
      if (paramBoolean)
      {
        paramc.vBn.setVisibility(0);
        paramc.vBn.setImageResource(R.k.app_attach_file_icon_video);
      }
      paramc.vBy.setVisibility(0);
      paramc.vBy.setImageResource(R.g.video_download_btn);
      break label299;
      paramc.vBn.setVisibility(0);
      paramc.vBn.setImageResource(R.k.app_attach_file_icon_location);
      break label299;
      if (paramBoolean)
      {
        paramc.vBn.setVisibility(0);
        paramc.vBn.setImageResource(R.k.app_attach_file_icon_music);
      }
      paramc.vBy.setVisibility(0);
      paramc.vBy.setImageResource(R.g.music_playicon);
      break label299;
      if (paramBoolean)
      {
        paramc.vBn.setVisibility(0);
        paramc.vBn.setImageResource(com.tencent.mm.pluginsdk.c.Vy(((xv)localObject3).sUV));
      }
      break label299;
      if (paramBoolean)
      {
        paramc.vBn.setVisibility(0);
        paramc.vBn.setImageResource(R.k.app_attach_file_icon_unknow);
      }
      break label299;
      if (paramBoolean)
      {
        paramc.vBn.setVisibility(0);
        paramc.vBn.setImageResource(R.g.default_avatar);
      }
    }
    if ((localObject1 != null) && (localObject2 == null) && (i == 0)) {
      parama1 = parama.vtz.getContext().getString(R.l.favorite_record_chatroom_title, new Object[] { localObject1 });
    }
    for (;;)
    {
      if (!bk.bl(parama1))
      {
        paramc.vBs.setText(parama1);
        paramc.vBs.setVisibility(0);
      }
      paramc.vBn.setVisibility(8);
      paramc.vBG.setVisibility(8);
      return;
      parama1 = str;
      if (localObject1 != null)
      {
        parama1 = str;
        if (localObject2 != null)
        {
          parama1 = str;
          if (!((String)localObject1).equals(localObject2))
          {
            parama1 = str;
            if (i == 0)
            {
              parama1 = parama.vtz.getContext().getString(R.l.favorite_record_chat_title, new Object[] { localObject1, localObject2 });
              continue;
              label989:
              break;
              label992:
              parama1 = str;
            }
          }
        }
      }
    }
  }
  
  public static void a(c paramc, Boolean paramBoolean, bi parambi, String paramString1, String paramString2)
  {
    long l = parambi.field_msgId;
    com.tencent.mm.pluginsdk.model.app.b localb = ap.avh().gY(l);
    if (localb == null)
    {
      y.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString2 });
      return;
    }
    if (paramBoolean.booleanValue()) {
      if (localb.field_status == 101L)
      {
        paramc.vBx.setVisibility(0);
        paramc.vBu.setVisibility(0);
        paramc.vBv.setVisibility(0);
      }
    }
    for (;;)
    {
      if (parambi.field_status == 5)
      {
        paramc.vBx.setVisibility(8);
        paramc.vBw.setVisibility(8);
      }
      paramc.vBx.setOnClickListener(new d.c.1(paramBoolean, l, paramString1, paramString2, parambi));
      paramc.vBw.setOnClickListener(new d.c.2(paramBoolean, l, paramString2, parambi));
      return;
      if (localb.field_status == 102L)
      {
        paramc.vBx.setVisibility(8);
        paramc.vBu.setVisibility(8);
        paramc.vBv.setVisibility(8);
      }
      else
      {
        paramc.vBx.setVisibility(8);
        paramc.vBu.setVisibility(8);
        paramc.vBv.setVisibility(8);
        continue;
        if (localb.field_status == 101L)
        {
          paramc.vBx.setVisibility(0);
          paramc.vBw.setVisibility(8);
        }
        else if (localb.field_status == 105L)
        {
          paramc.vBx.setVisibility(8);
          paramc.vBw.setVisibility(0);
        }
        else
        {
          paramc.vBx.setVisibility(8);
          paramc.vBw.setVisibility(8);
        }
      }
    }
  }
  
  public static void a(c paramc, String paramString, int paramInt)
  {
    int i = l.VW(paramString);
    if ((i == -1) || (i >= 100) || (paramInt <= 0))
    {
      paramc.vBu.setVisibility(8);
      paramc.vBv.setVisibility(8);
      return;
    }
    paramc.vBu.setVisibility(0);
    paramc.vBv.setVisibility(0);
    paramc.vBu.setProgress(i);
  }
  
  public final c r(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.vBn = ((MMImageView)paramView.findViewById(R.h.chatting_appmsg_thumb_iv));
    this.eXO = ((TextView)paramView.findViewById(R.h.chatting_appmsg_title_tv));
    this.vBs = ((TextView)paramView.findViewById(R.h.chatting_appmsg_top_title_tv));
    this.eXP = ((TextView)paramView.findViewById(R.h.chatting_appmsg_desc_tv));
    this.kiv = ((TextView)paramView.findViewById(R.h.chatting_appmsg_source_tv));
    this.vBo = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_source_iv));
    this.vBq = ((TextView)paramView.findViewById(R.h.chatting_appmsg_source_tag_tv));
    this.vBp = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_source_tag_iv));
    this.vBr = ((LinearLayout)paramView.findViewById(R.h.chatting_appmsg_source_area));
    this.vBt = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_sub_menu_icon));
    this.vBu = ((MMPinProgressBtn)paramView.findViewById(R.h.chatting_file_progress));
    this.vBv = ((ImageView)this.kKz.findViewById(R.h.chatting_file_mask));
    this.vBw = ((ImageView)this.kKz.findViewById(R.h.chatting_continue_btn));
    this.vBx = ((ImageView)this.kKz.findViewById(R.h.chatting_stop_btn));
    this.vBy = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_media_icon));
    this.vBz = ((TextView)paramView.findViewById(R.h.chatting_appmsg_comment_tv));
    this.vBB = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_refuse_iv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.vBA = ((ChattingItemFooter)paramView.findViewById(R.h.footer));
    this.vBC = ((LinearLayout)paramView.findViewById(R.h.app_msg_layout));
    this.vBD = ((ViewGroup)paramView.findViewById(R.h.location_share_layout));
    this.vBE = ((TextView)paramView.findViewById(R.h.location_share_content));
    this.vBF = ((LinearLayout)paramView.findViewById(R.h.chatting_area));
    this.vBH = ((FrameLayout)paramView.findViewById(R.h.chatting_click_area));
    this.vBI = ((LinearLayout)paramView.findViewById(R.h.chatting_appmsg_content));
    this.vBM = ((ImageView)paramView.findViewById(R.h.chatting_content_mask_iv));
    this.vBG = ((RelativeLayout)paramView.findViewById(R.h.chatting_appmsg_thumb_area));
    this.vBK = ((ViewStub)paramView.findViewById(R.h.note_image_ll));
    this.vBL = ((ImageView)paramView.findViewById(R.h.chatting_dividing_line));
    if (!paramBoolean)
    {
      this.vBN = ((ImageView)this.kKz.findViewById(R.h.chatting_status_tick));
      this.nhQ = ((ProgressBar)this.kKz.findViewById(R.h.uploading_pb));
    }
    this.vBV = ((LinearLayout)paramView.findViewById(R.h.chatting_appmsg_appbrand_content));
    this.vBW = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_appbrand_cover_iv));
    this.vBX = ((ImageView)paramView.findViewById(R.h.error_icon_iv));
    this.vBY = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_nickname_tv));
    this.vBO = ((LinearLayout)paramView.findViewById(R.h.chatting_appmsg_appbrand_card_content));
    this.vBP = ((ImageView)paramView.findViewById(R.h.chatting_appbrand_card_avatar_iv));
    this.vBQ = ((TextView)paramView.findViewById(R.h.chatting_appbrand_card_nickname_tv));
    this.vBR = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_desc_tv));
    this.vBS = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_appbrand_source_iv));
    this.vBT = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_source_tv));
    this.vBU = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_source_tag_tv));
    if ((this.vBs != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.vCa = this.vBs.getMaxLines();
    }
    this.vBZ = c.gS(ae.getContext());
    return this;
  }
  
  public final void reset()
  {
    if (this.vBs != null) {
      this.vBs.setMaxLines(this.vCa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.c
 * JD-Core Version:    0.7.0.1
 */