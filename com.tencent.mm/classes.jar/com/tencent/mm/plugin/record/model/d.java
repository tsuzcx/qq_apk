package com.tencent.mm.plugin.record.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.vfs.y;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class d
{
  private static final SimpleDateFormat NAb;
  
  static
  {
    AppMethodBeat.i(305354);
    NAb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(305354);
  }
  
  private static String a(com.tencent.mm.modelimage.h paramh, cc paramcc)
  {
    AppMethodBeat.i(305343);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (au.bwE(paramcc.field_talker)) {
        localStringWriter.write(br.JJ(paramcc.field_content) + ":\n");
      }
      localStringWriter.write(br.JJ(paramcc.field_content) + ":\n");
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = XmlParser.parseXml(paramh.oGC, "msg", null);
      if (localMap != null)
      {
        localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.img.$aeskey"));
        localXmlSerializer.attribute(null, "encryver", (String)localMap.get(".msg.img.$encryver"));
        localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.img.$cdnthumbaeskey"));
        localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.img.$cdnthumburl"));
        localXmlSerializer.attribute(null, "cdnthumblength", Util.getLong((String)localMap.get(".msg.img.$cdnthumblength"), 10240L));
        localXmlSerializer.attribute(null, "cdnthumbheight", Util.getInt((String)localMap.get(".msg.img.$cdnthumbheight"), 0));
        localXmlSerializer.attribute(null, "cdnthumbwidth", Util.getInt((String)localMap.get(".msg.img.$cdnthumbwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidheight", Util.getInt((String)localMap.get(".msg.img.$cdnmidheight"), 0));
        localXmlSerializer.attribute(null, "cdnmidwidth", Util.getInt((String)localMap.get(".msg.img.$cdnmidwidth"), 0));
        localXmlSerializer.attribute(null, "cdnhdheight", Util.getInt((String)localMap.get(".msg.img.$cdnhdheight"), 0));
        localXmlSerializer.attribute(null, "cdnhdwidth", Util.getInt((String)localMap.get(".msg.img.$cdnhdwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidimgurl", (String)localMap.get(".msg.img.$cdnmidimgurl"));
        long l2 = Util.getLong((String)localMap.get(".msg.img.$length"), 0L);
        StringBuilder localStringBuilder = new StringBuilder();
        long l1 = l2;
        if (l2 == 0L) {
          l1 = y.bEl(r.bKa().v(paramh.oGr, "", ""));
        }
        localXmlSerializer.attribute(null, "length", l1);
        if ((paramcc.field_isSend != 1) || (paramh.oGu == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", Util.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localXmlSerializer.attribute(null, "md5", (String)localMap.get(".msg.img.$md5"));
      }
      localXmlSerializer.endTag(null, "img");
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      localStringWriter.flush();
      localStringWriter.close();
      paramh = localStringWriter.getBuffer().toString();
      Log.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parseContent xml:%s", new Object[] { paramh });
      AppMethodBeat.o(305343);
      return paramh;
    }
    catch (Exception paramh)
    {
      Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "packetImg xml error: " + paramh.toString());
      AppMethodBeat.o(305343);
    }
    return null;
  }
  
  private static String a(cc paramcc, com.tencent.mm.modelvideo.z paramz)
  {
    AppMethodBeat.i(305333);
    if (paramz == null)
    {
      AppMethodBeat.o(305333);
      return null;
    }
    if (paramcc.getType() == 62) {}
    for (int i = 62; Util.isNullOrNil(paramcc.field_content); i = 43)
    {
      AppMethodBeat.o(305333);
      return null;
    }
    if (au.bwE(paramcc.field_talker)) {}
    for (paramcc = paramz.bOq();; paramcc = paramcc.aJO())
    {
      StringWriter localStringWriter = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(localStringWriter);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = XmlParser.parseXml(paramz.bOu(), "msg", null);
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", paramz.omT);
        localXmlSerializer.attribute(null, "length", paramz.osy);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!Util.isNullOrNil(paramcc)) {
          localXmlSerializer.attribute(null, "fromusername", paramcc);
        }
        localXmlSerializer.attribute(null, "md5", paramz.ibd);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        localStringWriter.flush();
        localStringWriter.close();
        paramcc = localStringWriter.getBuffer().toString();
        AppMethodBeat.o(305333);
        return paramcc;
      }
      catch (Exception paramcc)
      {
        Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "packetVoice xml error: " + paramcc.toString());
        AppMethodBeat.o(305333);
      }
    }
    return null;
  }
  
  private static void a(String paramString, dl paramdl)
  {
    AppMethodBeat.i(305344);
    paramdl.IIs = 1;
    paramdl.YFG = new etl().btH(paramString);
    AppMethodBeat.o(305344);
  }
  
  private static boolean a(Context paramContext, dl paramdl, int paramInt)
  {
    AppMethodBeat.i(305334);
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(a.c.app_emoji);
    }
    for (;;)
    {
      boolean bool = b(paramdl, str);
      AppMethodBeat.o(305334);
      return bool;
      if (paramInt == 2) {
        str = paramContext.getString(a.c.app_pay);
      } else if (paramInt == 3) {
        str = paramContext.getString(a.c.app_special);
      }
    }
  }
  
  public static boolean b(Context paramContext, cc paramcc, dl paramdl)
  {
    AppMethodBeat.i(305318);
    if (paramcc == null)
    {
      AppMethodBeat.o(305318);
      return false;
    }
    if (bt.F(paramcc)) {
      switch (paramcc.getType() & 0xFFFF)
      {
      }
    }
    for (;;)
    {
      boolean bool = c(paramContext, paramcc, paramdl);
      AppMethodBeat.o(305318);
      return bool;
      paramcc.setContent(paramContext.getString(a.c.app_text));
      continue;
      paramcc.setContent(paramContext.getString(a.c.app_pic));
      paramcc.setType(1);
      continue;
      paramcc.setContent(paramContext.getString(a.c.app_video));
      paramcc.setType(1);
      continue;
      paramcc.setContent(paramContext.getString(a.c.app_unknown_msg));
      paramcc.setType(1);
    }
  }
  
  private static boolean b(dl paramdl, String paramString)
  {
    AppMethodBeat.i(305337);
    paramdl.IIs = 1;
    paramdl.YFG = new etl().btH(paramString);
    AppMethodBeat.o(305337);
    return true;
  }
  
  private static boolean b(cc paramcc, dl paramdl)
  {
    AppMethodBeat.i(305338);
    paramdl.YFG = new etl().btH(Util.nullAs(paramcc.field_content, ""));
    AppMethodBeat.o(305338);
    return true;
  }
  
  private static boolean c(Context paramContext, cc paramcc, dl paramdl)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    AppMethodBeat.i(305326);
    if (bt.aa(paramcc))
    {
      paramdl.IIs = 1;
      paramdl.YFG = new etl().btH(paramContext.getString(a.c.app_msg));
    }
    for (;;)
    {
      AppMethodBeat.o(305326);
      return bool1;
      if (paramcc.iYl())
      {
        bool1 = b(paramcc, paramdl);
      }
      else if (paramcc.iYj())
      {
        paramdl.IIs = 1;
        paramdl.YFG = new etl().btH(paramContext.getString(a.c.app_voice));
      }
      else if (paramcc.fxT())
      {
        bool1 = b(paramcc, paramdl);
      }
      else
      {
        Object localObject;
        if (paramcc.iYk())
        {
          localObject = null;
          if (paramcc.field_msgId > 0L) {
            localObject = r.bKa().H(paramcc.field_talker, (int)paramcc.field_msgId);
          }
          if (localObject != null)
          {
            paramContext = (Context)localObject;
            if (((com.tencent.mm.modelimage.h)localObject).localId > 0L) {}
          }
          else
          {
            paramContext = (Context)localObject;
            if (paramcc.field_msgSvrId > 0L) {
              paramContext = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
            }
          }
          if (paramContext == null) {
            Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
          }
          for (bool1 = false;; bool1 = true)
          {
            break;
            localObject = paramContext;
            if (paramContext.bJE())
            {
              localObject = paramContext;
              if (paramContext.osy == 0) {
                localObject = r.bKa().wq(paramContext.oGB);
              }
            }
            paramContext = a((com.tencent.mm.modelimage.h)localObject, paramcc);
            paramdl.YFG = new etl().btH(Util.nullAs(paramContext, ""));
            paramdl.YFH = 2;
          }
        }
        if ((paramcc.dSH()) || (paramcc.dSJ()))
        {
          paramContext = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
          if (paramContext == null)
          {
            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
            bool1 = bool2;
          }
          for (;;)
          {
            break;
            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", new Object[] { Integer.valueOf(paramContext.osy) });
            bool1 = bool2;
            if (paramContext.osy <= ((ah)com.tencent.mm.kernel.h.az(ah.class)).getVideoSizeLimit(true)) {
              if (paramcc.dSJ())
              {
                bool1 = bool2;
                if (com.tencent.mm.modelvideo.ab.Qp(paramContext.getFileName())) {}
              }
              else
              {
                paramContext = a(paramcc, paramContext);
                paramdl.YFG = new etl().btH(Util.nullAs(paramContext, ""));
                bool1 = true;
              }
            }
          }
        }
        if (paramcc.dSI())
        {
          bool1 = b(paramcc, paramdl);
        }
        else if (paramcc.getType() == 318767153)
        {
          bool1 = a(paramContext, paramdl, 3);
        }
        else if (paramcc.iYe())
        {
          bool1 = b(paramcc, paramdl);
        }
        else if ((paramcc.jbG()) || (paramcc.jbH()))
        {
          bool1 = a(paramContext, paramdl, 1);
        }
        else if (paramcc.getType() == 419430449)
        {
          bool1 = a(paramContext, paramdl, 2);
        }
        else if (paramcc.getType() == 436207665)
        {
          try
          {
            paramcc = k.b.Hf(paramcc.field_content);
            if (paramcc != null)
            {
              bool1 = b(paramdl, "[" + paramcc.nSI + "]");
              continue;
            }
            bool1 = a(paramContext, paramdl, 3);
            continue;
          }
          finally
          {
            Log.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", paramcc, "fill msg err", new Object[0]);
          }
        }
        else
        {
          do
          {
            bool1 = a(paramContext, paramdl, 3);
            break;
            if (paramcc.jbB())
            {
              localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(paramcc.field_content);
              if ((localObject != null) && (com.tencent.mm.model.ab.uY(((cc.a)localObject).WAW)))
              {
                b(paramcc, paramdl);
                break;
              }
              if ((localObject != null) && (au.bwO(((cc.a)localObject).hgk)))
              {
                paramcc = ((e)com.tencent.mm.kernel.h.ax(e.class)).a(((cc.a)localObject).adkD, "openim_card_type_name", e.a.prb);
                if (TextUtils.isEmpty(paramcc)) {}
                for (paramContext = paramContext.getResources().getString(a.c.app_friend_card_personal);; paramContext = String.format("[%s]", new Object[] { paramcc }))
                {
                  paramdl.IIs = 1;
                  paramdl.YFG = new etl().btH(paramContext);
                  break;
                }
              }
              paramContext = paramContext.getString(a.c.app_friend_card_personal);
              paramdl.IIs = 1;
              paramdl.YFG = new etl().btH(paramContext);
              break;
            }
          } while (!paramcc.fxR());
          if (paramcc.jbH()) {
            bool1 = a(paramContext, paramdl, 1);
          } else {
            bool1 = d(paramContext, paramcc, paramdl);
          }
        }
      }
    }
  }
  
  private static boolean d(Context paramContext, cc paramcc, dl paramdl)
  {
    AppMethodBeat.i(305352);
    arg localarg = new arg();
    arh localarh = new arh();
    if (paramcc != null)
    {
      if (paramcc.field_isSend != 0) {
        break label422;
      }
      localarh.bsX(paramcc.field_talker);
      localarh.bsY(com.tencent.mm.model.z.bAM());
      if (au.bwE(paramcc.field_talker))
      {
        if (paramcc.field_content == null) {
          break label415;
        }
        localObject1 = paramcc.field_content.substring(0, Math.max(0, paramcc.field_content.indexOf(':')));
        localarh.bta((String)localObject1);
        if ((!Util.isNullOrNil(localarh.ZAT)) && (!paramcc.iYj()))
        {
          paramcc.setContent(paramcc.field_content.substring(localarh.ZAT.length() + 1));
          if ((paramcc.field_content.length() > 0) && ('\n' == paramcc.field_content.charAt(0))) {
            paramcc.setContent(paramcc.field_content.substring(1));
          }
          if (paramcc.jbT())
          {
            if ((!Util.isNullOrNil(paramcc.field_transContent)) && (paramcc.field_transContent.startsWith(localarh.ZAT))) {
              paramcc.BV(paramcc.field_transContent.substring(localarh.ZAT.length() + 1));
            }
            if ((paramcc.field_transContent.length() > 0) && ('\n' == paramcc.field_transContent.charAt(0))) {
              paramcc.BV(paramcc.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.an.g.Dn(paramcc.field_talker))
      {
        localObject2 = paramcc.field_bizChatUserId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = br.JP(paramcc.jUr).userId;
        }
        localarh.bta((String)localObject1);
      }
      localarh.axC(1);
      localarh.yr(paramcc.getCreateTime());
      localarh.btb(paramcc.field_msgSvrId);
      if (paramcc.field_msgSvrId > 0L) {
        localarh.bsZ(paramcc.field_msgSvrId);
      }
      localarg.c(localarh);
      localObject1 = paramcc.field_content;
      if (localObject1 != null) {
        break label465;
      }
      a(paramContext, paramdl, 3);
      AppMethodBeat.o(305352);
      return false;
      label415:
      localObject1 = "";
      break;
      label422:
      localarh.bsX(com.tencent.mm.model.z.bAM());
      localarh.bsY(paramcc.field_talker);
      if (au.bwE(paramcc.field_talker)) {
        localarh.bta(localarh.hQQ);
      }
    }
    label465:
    Object localObject1 = k.b.Hf((String)localObject1);
    if (localObject1 == null)
    {
      a(paramContext, paramdl, 3);
      AppMethodBeat.o(305352);
      return false;
    }
    localarg.ZAf.btc(((k.b)localObject1).appId);
    localarg.ZAf.bte(((k.b)localObject1).iaa);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject1).appId, true, false);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).aqJ()))
    {
      a(paramContext.getString(a.c.app_game), paramdl);
      AppMethodBeat.o(305352);
      return true;
    }
    switch (((k.b)localObject1).type)
    {
    default: 
      a(paramContext.getString(a.c.app_special), paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 1: 
    case 53: 
    case 57: 
    case 74: 
      paramcc = new StringBuilder();
      if (((k.b)localObject1).type == 74) {
        paramcc.append(paramContext.getString(a.c.app_file));
      }
      paramcc.append(((k.b)localObject1).title);
      a(paramcc.toString(), paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 2: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 3: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 76: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 4: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        if (((k.b)localObject1).bwp())
        {
          a(paramContext.getString(a.c.app_not_show), paramdl);
          AppMethodBeat.o(305352);
          return true;
        }
        b(paramcc, paramdl);
        AppMethodBeat.o(305352);
        return true;
      }
      a(paramContext.getString(a.c.app_special), paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 51: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 63: 
    case 88: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 59: 
    case 72: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 50: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 73: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 6: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 7: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 10: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 20: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 13: 
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 46: 
      a(paramContext.getString(a.c.app_not_show), paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 33: 
    case 36: 
      if ((((k.b)localObject1).nTF == 3) || (((k.b)localObject1).nTM == 1))
      {
        a(paramContext.getString(a.c.app_not_show), paramdl);
        AppMethodBeat.o(305352);
        return true;
      }
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 48: 
      a(paramContext.getString(a.c.app_game_recording) + ((k.b)localObject1).title, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 44: 
      if (Util.isNullOrNil(((k.b)localObject1).B(paramContext, true)))
      {
        a(paramContext.getString(a.c.app_special), paramdl);
        AppMethodBeat.o(305352);
        return true;
      }
      b(paramcc, paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 19: 
      int i;
      if ((((k.b)localObject1).nRF != null) && (((k.b)localObject1).nRF.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
      {
        localObject2 = new tr();
        ((tr)localObject2).hXt.type = 0;
        ((tr)localObject2).hXt.hXv = ((k.b)localObject1).nRF;
        ((tr)localObject2).publish();
        localObject1 = ((tr)localObject2).hXu.hXD;
        if (localObject1 != null)
        {
          localObject1 = ((c)localObject1).nUC.iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (!Util.isNullOrNil(((arf)((Iterator)localObject1).next()).ZzW))
              {
                a(paramContext.getString(a.c.app_special), paramdl);
                AppMethodBeat.o(305352);
                return false;
                i = 0;
                break;
              }
            }
          }
        }
        b(paramcc, paramdl);
        AppMethodBeat.o(305352);
        return true;
      }
    case 24: 
      a(paramContext.getString(a.c.favorite_wenote_msg), paramdl);
      AppMethodBeat.o(305352);
      return true;
    case 16: 
      a(paramContext.getString(a.c.app_product_card_ticket), paramdl);
      AppMethodBeat.o(305352);
      return true;
    }
    b(paramcc, paramdl);
    AppMethodBeat.o(305352);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.d
 * JD-Core Version:    0.7.0.1
 */