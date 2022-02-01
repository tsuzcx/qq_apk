package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public class au
  extends com.tencent.mm.contact.d
  implements Cloneable
{
  public static long adid = 86400L;
  public CharSequence acDG;
  public String adie = null;
  
  public au() {}
  
  public au(String paramString)
  {
    super(paramString);
  }
  
  public static boolean Hh(String paramString)
  {
    AppMethodBeat.i(43175);
    if ((paramString != null) && (paramString.endsWith("@app")))
    {
      AppMethodBeat.o(43175);
      return true;
    }
    AppMethodBeat.o(43175);
    return false;
  }
  
  public static boolean aAy(String paramString)
  {
    AppMethodBeat.i(248862);
    if ((paramString != null) && (paramString.endsWith("@findermsg")))
    {
      AppMethodBeat.o(248862);
      return true;
    }
    AppMethodBeat.o(248862);
    return false;
  }
  
  public static boolean ayS(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean bvS(String paramString)
  {
    AppMethodBeat.i(248550);
    if ((paramString != null) && (paramString.equalsIgnoreCase("qqmail")))
    {
      AppMethodBeat.o(248550);
      return true;
    }
    AppMethodBeat.o(248550);
    return false;
  }
  
  public static boolean bvT(String paramString)
  {
    AppMethodBeat.i(248559);
    if ((paramString != null) && (paramString.equalsIgnoreCase("fmessage")))
    {
      AppMethodBeat.o(248559);
      return true;
    }
    AppMethodBeat.o(248559);
    return false;
  }
  
  public static boolean bvU(String paramString)
  {
    AppMethodBeat.i(248564);
    boolean bool = "@placeholder_foldgroup".equals(paramString);
    AppMethodBeat.o(248564);
    return bool;
  }
  
  public static boolean bvV(String paramString)
  {
    AppMethodBeat.i(248575);
    if ((paramString != null) && (paramString.equalsIgnoreCase("tmessage")))
    {
      AppMethodBeat.o(248575);
      return true;
    }
    AppMethodBeat.o(248575);
    return false;
  }
  
  public static boolean bvW(String paramString)
  {
    AppMethodBeat.i(248580);
    if ((paramString != null) && (paramString.equalsIgnoreCase("floatbottle")))
    {
      AppMethodBeat.o(248580);
      return true;
    }
    AppMethodBeat.o(248580);
    return false;
  }
  
  public static boolean bvX(String paramString)
  {
    AppMethodBeat.i(248589);
    if ((paramString != null) && (paramString.equalsIgnoreCase("qmessage")))
    {
      AppMethodBeat.o(248589);
      return true;
    }
    AppMethodBeat.o(248589);
    return false;
  }
  
  public static boolean bvY(String paramString)
  {
    AppMethodBeat.i(248596);
    if ((paramString != null) && (paramString.equalsIgnoreCase("facebookapp")))
    {
      AppMethodBeat.o(248596);
      return true;
    }
    AppMethodBeat.o(248596);
    return false;
  }
  
  public static boolean bvZ(String paramString)
  {
    AppMethodBeat.i(248603);
    if ((paramString != null) && (paramString.equalsIgnoreCase("masssendapp")))
    {
      AppMethodBeat.o(248603);
      return true;
    }
    AppMethodBeat.o(248603);
    return false;
  }
  
  public static boolean bwA(String paramString)
  {
    AppMethodBeat.i(248769);
    if ((paramString != null) && (paramString.equalsIgnoreCase("appbrand_notify_message")))
    {
      AppMethodBeat.o(248769);
      return true;
    }
    AppMethodBeat.o(248769);
    return false;
  }
  
  public static boolean bwB(String paramString)
  {
    AppMethodBeat.i(248776);
    if ((paramString != null) && (paramString.equalsIgnoreCase("message_fold")))
    {
      AppMethodBeat.o(248776);
      return true;
    }
    AppMethodBeat.o(248776);
    return false;
  }
  
  public static boolean bwC(String paramString)
  {
    AppMethodBeat.i(248783);
    if ((paramString != null) && (paramString.equalsIgnoreCase("findersayhisessionholder")))
    {
      AppMethodBeat.o(248783);
      return true;
    }
    AppMethodBeat.o(248783);
    return false;
  }
  
  public static boolean bwD(String paramString)
  {
    AppMethodBeat.i(248789);
    if ((paramString != null) && (paramString.equalsIgnoreCase("opencustomerservicemsg")))
    {
      AppMethodBeat.o(248789);
      return true;
    }
    AppMethodBeat.o(248789);
    return false;
  }
  
  public static boolean bwE(String paramString)
  {
    AppMethodBeat.i(248799);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(248799);
      return false;
    }
    if ((paramString.endsWith("@chatroom")) || (paramString.endsWith("@im.chatroom")))
    {
      AppMethodBeat.o(248799);
      return true;
    }
    AppMethodBeat.o(248799);
    return false;
  }
  
  public static boolean bwF(String paramString)
  {
    AppMethodBeat.i(248804);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(248804);
      return false;
    }
    boolean bool = paramString.endsWith("@im.chatroom");
    AppMethodBeat.o(248804);
    return bool;
  }
  
  public static boolean bwG(String paramString)
  {
    AppMethodBeat.i(248807);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(248807);
      return false;
    }
    boolean bool = paramString.endsWith("@chatroom");
    AppMethodBeat.o(248807);
    return bool;
  }
  
  public static boolean bwH(String paramString)
  {
    AppMethodBeat.i(248812);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(248812);
      return false;
    }
    if ((!paramString.contains("@")) || (paramString.endsWith("@micromsg.qq.com")))
    {
      AppMethodBeat.o(248812);
      return true;
    }
    AppMethodBeat.o(248812);
    return false;
  }
  
  public static boolean bwI(String paramString)
  {
    AppMethodBeat.i(248814);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(248814);
      return false;
    }
    boolean bool = bwH(paramString);
    AppMethodBeat.o(248814);
    return bool;
  }
  
  public static boolean bwJ(String paramString)
  {
    AppMethodBeat.i(248817);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(248817);
      return false;
    }
    boolean bool = paramString.equalsIgnoreCase("weixin");
    AppMethodBeat.o(248817);
    return bool;
  }
  
  public static boolean bwK(String paramString)
  {
    AppMethodBeat.i(248819);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(248819);
      return false;
    }
    boolean bool = paramString.endsWith("@lbsroom");
    AppMethodBeat.o(248819);
    return bool;
  }
  
  public static boolean bwL(String paramString)
  {
    AppMethodBeat.i(43168);
    if ((paramString != null) && (paramString.endsWith("@t.qq.com")))
    {
      AppMethodBeat.o(43168);
      return true;
    }
    AppMethodBeat.o(43168);
    return false;
  }
  
  public static boolean bwM(String paramString)
  {
    AppMethodBeat.i(43169);
    if ((paramString != null) && (paramString.endsWith("@qr")))
    {
      AppMethodBeat.o(43169);
      return true;
    }
    AppMethodBeat.o(43169);
    return false;
  }
  
  public static boolean bwN(String paramString)
  {
    AppMethodBeat.i(248831);
    if ((paramString != null) && (paramString.endsWith("@qqim")))
    {
      AppMethodBeat.o(248831);
      return true;
    }
    AppMethodBeat.o(248831);
    return false;
  }
  
  public static boolean bwO(String paramString)
  {
    AppMethodBeat.i(43171);
    if ((paramString != null) && (paramString.endsWith("@openim")))
    {
      AppMethodBeat.o(43171);
      return true;
    }
    AppMethodBeat.o(43171);
    return false;
  }
  
  public static boolean bwP(String paramString)
  {
    AppMethodBeat.i(43172);
    if ((paramString != null) && (paramString.endsWith("@im.chatroom")))
    {
      AppMethodBeat.o(43172);
      return true;
    }
    AppMethodBeat.o(43172);
    return false;
  }
  
  public static boolean bwQ(String paramString)
  {
    AppMethodBeat.i(248844);
    if ((paramString != null) && (paramString.endsWith("@kefu.openim")))
    {
      AppMethodBeat.o(248844);
      return true;
    }
    AppMethodBeat.o(248844);
    return false;
  }
  
  public static boolean bwR(String paramString)
  {
    AppMethodBeat.i(43173);
    if ((paramString != null) && (paramString.endsWith("@fb")))
    {
      AppMethodBeat.o(43173);
      return true;
    }
    AppMethodBeat.o(43173);
    return false;
  }
  
  public static boolean bwS(String paramString)
  {
    AppMethodBeat.i(43174);
    if ((paramString != null) && ((paramString.contains("@bottle:")) || (paramString.endsWith("@bottle"))))
    {
      AppMethodBeat.o(43174);
      return true;
    }
    AppMethodBeat.o(43174);
    return false;
  }
  
  public static boolean bwT(String paramString)
  {
    AppMethodBeat.i(248868);
    if ((paramString != null) && (paramString.endsWith("@findermsgstranger")))
    {
      AppMethodBeat.o(248868);
      return true;
    }
    AppMethodBeat.o(248868);
    return false;
  }
  
  public static boolean bwU(String paramString)
  {
    AppMethodBeat.i(248876);
    if ((paramString != null) && (paramString.endsWith("@findermsgalias")))
    {
      AppMethodBeat.o(248876);
      return true;
    }
    AppMethodBeat.o(248876);
    return false;
  }
  
  public static boolean bwV(String paramString)
  {
    AppMethodBeat.i(248882);
    if ((paramString != null) && (paramString.endsWith("@finder")))
    {
      AppMethodBeat.o(248882);
      return true;
    }
    AppMethodBeat.o(248882);
    return false;
  }
  
  public static boolean bwW(String paramString)
  {
    AppMethodBeat.i(248888);
    if ((paramString != null) && (paramString.endsWith("@gamelifesess")))
    {
      AppMethodBeat.o(248888);
      return true;
    }
    AppMethodBeat.o(248888);
    return false;
  }
  
  public static boolean bwX(String paramString)
  {
    AppMethodBeat.i(248896);
    if ((paramString != null) && (paramString.endsWith("@gamelife")))
    {
      AppMethodBeat.o(248896);
      return true;
    }
    AppMethodBeat.o(248896);
    return false;
  }
  
  public static boolean bwY(String paramString)
  {
    AppMethodBeat.i(248902);
    if ((paramString != null) && (paramString.endsWith("@statussquaremsg")))
    {
      AppMethodBeat.o(248902);
      return true;
    }
    AppMethodBeat.o(248902);
    return false;
  }
  
  public static boolean bwZ(String paramString)
  {
    AppMethodBeat.i(248906);
    if (!Util.isNullOrNil(paramString))
    {
      if ((paramString.endsWith("@findermsg")) || (paramString.endsWith("@gamelifesess")) || (paramString.endsWith("@statussquaremsg")))
      {
        AppMethodBeat.o(248906);
        return true;
      }
      AppMethodBeat.o(248906);
      return false;
    }
    AppMethodBeat.o(248906);
    return false;
  }
  
  public static boolean bwa(String paramString)
  {
    AppMethodBeat.i(248627);
    if ((paramString != null) && (paramString.equalsIgnoreCase("feedsapp")))
    {
      AppMethodBeat.o(248627);
      return true;
    }
    AppMethodBeat.o(248627);
    return false;
  }
  
  public static boolean bwb(String paramString)
  {
    AppMethodBeat.i(248632);
    boolean bool = "qqsync".equalsIgnoreCase(paramString);
    AppMethodBeat.o(248632);
    return bool;
  }
  
  public static boolean bwc(String paramString)
  {
    AppMethodBeat.i(248639);
    if ((paramString != null) && ((paramString.equalsIgnoreCase("weixin")) || (paramString.equalsIgnoreCase("gh_9639b5a92773"))))
    {
      AppMethodBeat.o(248639);
      return true;
    }
    AppMethodBeat.o(248639);
    return false;
  }
  
  public static boolean bwd(String paramString)
  {
    AppMethodBeat.i(248645);
    if ((paramString != null) && (paramString.equalsIgnoreCase("lbsapp")))
    {
      AppMethodBeat.o(248645);
      return true;
    }
    AppMethodBeat.o(248645);
    return false;
  }
  
  public static boolean bwe(String paramString)
  {
    AppMethodBeat.i(248649);
    if ((paramString != null) && (paramString.equalsIgnoreCase("shakeapp")))
    {
      AppMethodBeat.o(248649);
      return true;
    }
    AppMethodBeat.o(248649);
    return false;
  }
  
  public static boolean bwf(String paramString)
  {
    AppMethodBeat.i(248654);
    if ((paramString != null) && (paramString.equalsIgnoreCase("medianote")))
    {
      AppMethodBeat.o(248654);
      return true;
    }
    AppMethodBeat.o(248654);
    return false;
  }
  
  public static boolean bwg(String paramString)
  {
    AppMethodBeat.i(248659);
    if ((paramString != null) && (paramString.equalsIgnoreCase("newsapp")))
    {
      AppMethodBeat.o(248659);
      return true;
    }
    AppMethodBeat.o(248659);
    return false;
  }
  
  public static boolean bwh(String paramString)
  {
    AppMethodBeat.i(248669);
    if ((paramString != null) && (paramString.equalsIgnoreCase("topstoryapp")))
    {
      AppMethodBeat.o(248669);
      return true;
    }
    AppMethodBeat.o(248669);
    return false;
  }
  
  public static boolean bwi(String paramString)
  {
    AppMethodBeat.i(248674);
    if ((paramString != null) && (paramString.equalsIgnoreCase("voipapp")))
    {
      AppMethodBeat.o(248674);
      return true;
    }
    AppMethodBeat.o(248674);
    return false;
  }
  
  public static boolean bwj(String paramString)
  {
    AppMethodBeat.i(248678);
    if ((paramString != null) && (paramString.equalsIgnoreCase("voicevoipapp")))
    {
      AppMethodBeat.o(248678);
      return true;
    }
    AppMethodBeat.o(248678);
    return false;
  }
  
  public static boolean bwk(String paramString)
  {
    AppMethodBeat.i(248684);
    if ((paramString != null) && (paramString.equalsIgnoreCase("voiceinputapp")))
    {
      AppMethodBeat.o(248684);
      return true;
    }
    AppMethodBeat.o(248684);
    return false;
  }
  
  public static boolean bwl(String paramString)
  {
    AppMethodBeat.i(248686);
    if ((paramString != null) && (paramString.equalsIgnoreCase("linkedinplugin")))
    {
      AppMethodBeat.o(248686);
      return true;
    }
    AppMethodBeat.o(248686);
    return false;
  }
  
  public static boolean bwm(String paramString)
  {
    AppMethodBeat.i(248691);
    boolean bool = bwn(paramString);
    AppMethodBeat.o(248691);
    return bool;
  }
  
  public static boolean bwn(String paramString)
  {
    AppMethodBeat.i(248695);
    if ((paramString != null) && (paramString.equalsIgnoreCase("gh_22b87fa7cb3c")))
    {
      AppMethodBeat.o(248695);
      return true;
    }
    AppMethodBeat.o(248695);
    return false;
  }
  
  public static boolean bwo(String paramString)
  {
    AppMethodBeat.i(248700);
    if ((paramString != null) && (paramString.equalsIgnoreCase("blogapp")))
    {
      AppMethodBeat.o(248700);
      return true;
    }
    AppMethodBeat.o(248700);
    return false;
  }
  
  public static boolean bwp(String paramString)
  {
    AppMethodBeat.i(248705);
    if ((paramString != null) && (paramString.equalsIgnoreCase("officialaccounts")))
    {
      AppMethodBeat.o(248705);
      return true;
    }
    AppMethodBeat.o(248705);
    return false;
  }
  
  public static boolean bwq(String paramString)
  {
    AppMethodBeat.i(248712);
    if ((paramString != null) && (paramString.equalsIgnoreCase("helper_entry")))
    {
      AppMethodBeat.o(248712);
      return true;
    }
    AppMethodBeat.o(248712);
    return false;
  }
  
  public static boolean bwr(String paramString)
  {
    AppMethodBeat.i(248719);
    if ((paramString != null) && (paramString.equalsIgnoreCase("qqfriend")))
    {
      AppMethodBeat.o(248719);
      return true;
    }
    AppMethodBeat.o(248719);
    return false;
  }
  
  public static boolean bws(String paramString)
  {
    AppMethodBeat.i(248723);
    boolean bool = "filehelper".equalsIgnoreCase(paramString);
    AppMethodBeat.o(248723);
    return bool;
  }
  
  public static boolean bwt(String paramString)
  {
    AppMethodBeat.i(248729);
    if ((paramString != null) && (paramString.equalsIgnoreCase("pc_share")))
    {
      AppMethodBeat.o(248729);
      return true;
    }
    AppMethodBeat.o(248729);
    return false;
  }
  
  public static boolean bwu(String paramString)
  {
    AppMethodBeat.i(248738);
    if ((paramString != null) && (paramString.equalsIgnoreCase("notifymessage")))
    {
      AppMethodBeat.o(248738);
      return true;
    }
    AppMethodBeat.o(248738);
    return false;
  }
  
  public static boolean bwv(String paramString)
  {
    AppMethodBeat.i(248742);
    if ((paramString != null) && (paramString.equalsIgnoreCase("notification_messages")))
    {
      AppMethodBeat.o(248742);
      return true;
    }
    AppMethodBeat.o(248742);
    return false;
  }
  
  public static boolean bww(String paramString)
  {
    AppMethodBeat.i(248746);
    if (bwx(paramString))
    {
      AppMethodBeat.o(248746);
      return true;
    }
    if (ab.IV(paramString))
    {
      AppMethodBeat.o(248746);
      return true;
    }
    if (bwp(paramString))
    {
      AppMethodBeat.o(248746);
      return true;
    }
    if (bwq(paramString))
    {
      AppMethodBeat.o(248746);
      return true;
    }
    AppMethodBeat.o(248746);
    return false;
  }
  
  public static boolean bwx(String paramString)
  {
    AppMethodBeat.i(248750);
    if ("weixin".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(248750);
      return true;
    }
    if (Util.nullAs((String)h.baE().ban().d(21, null), "").equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(248750);
      return true;
    }
    AppMethodBeat.o(248750);
    return false;
  }
  
  public static boolean bwy(String paramString)
  {
    AppMethodBeat.i(248756);
    if ((paramString != null) && (paramString.equalsIgnoreCase("appbrandcustomerservicemsg")))
    {
      AppMethodBeat.o(248756);
      return true;
    }
    AppMethodBeat.o(248756);
    return false;
  }
  
  public static boolean bwz(String paramString)
  {
    AppMethodBeat.i(248763);
    if ((paramString != null) && (paramString.equalsIgnoreCase("conversationboxservice")))
    {
      AppMethodBeat.o(248763);
      return true;
    }
    AppMethodBeat.o(248763);
    return false;
  }
  
  public static boolean bxa(String paramString)
  {
    AppMethodBeat.i(248911);
    if ((paramString != null) && (paramString.endsWith("@stranger")))
    {
      AppMethodBeat.o(248911);
      return true;
    }
    AppMethodBeat.o(248911);
    return false;
  }
  
  public static boolean bxb(String paramString)
  {
    AppMethodBeat.i(43176);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
      AppMethodBeat.o(43176);
      return false;
    }
    if (bwO(paramString))
    {
      AppMethodBeat.o(43176);
      return true;
    }
    Object localObject = ((a)h.ax(a.class)).aRD().at("HideWechatID", "idprefix");
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      int i = 0;
      while (i < localObject.length)
      {
        if ((localObject[i] != null) && (paramString.startsWith(localObject[i])))
        {
          AppMethodBeat.o(43176);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(43176);
    return false;
  }
  
  public static boolean bxc(String paramString)
  {
    AppMethodBeat.i(43177);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43177);
      return true;
    }
    String[] arrayOfString = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if ((!Util.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(43177);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(43177);
    return false;
  }
  
  public static String bxd(String paramString)
  {
    AppMethodBeat.i(43178);
    if (bwS(paramString))
    {
      String[] arrayOfString = paramString.split(":");
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(43178);
        return paramString;
      }
      paramString = arrayOfString[0];
      AppMethodBeat.o(43178);
      return paramString;
    }
    if ((paramString != null) && (paramString.contains("@")))
    {
      AppMethodBeat.o(43178);
      return "";
    }
    paramString = paramString + "@bottle";
    AppMethodBeat.o(43178);
    return paramString;
  }
  
  public static boolean bxe(String paramString)
  {
    AppMethodBeat.i(248946);
    boolean bool = "gh_43f2581f6fd6".equals(paramString);
    AppMethodBeat.o(248946);
    return bool;
  }
  
  public static boolean bxf(String paramString)
  {
    AppMethodBeat.i(248952);
    boolean bool = "gh_3dfda90e39d6".equals(paramString);
    AppMethodBeat.o(248952);
    return bool;
  }
  
  public static boolean bxg(String paramString)
  {
    AppMethodBeat.i(248955);
    boolean bool = "gh_b4af18eac3d5".equals(paramString);
    AppMethodBeat.o(248955);
    return bool;
  }
  
  public static boolean bxh(String paramString)
  {
    AppMethodBeat.i(248958);
    boolean bool = "gh_f0a92aa7146c".equals(paramString);
    AppMethodBeat.o(248958);
    return bool;
  }
  
  public static boolean bxi(String paramString)
  {
    AppMethodBeat.i(248963);
    boolean bool = "gh_e087bb5b95e6".equals(paramString);
    AppMethodBeat.o(248963);
    return bool;
  }
  
  public static boolean bxj(String paramString)
  {
    AppMethodBeat.i(248967);
    if ("gh_3dfda90e39d6".equals(paramString))
    {
      AppMethodBeat.o(248967);
      return true;
    }
    if ("gh_b4af18eac3d5".equals(paramString))
    {
      AppMethodBeat.o(248967);
      return true;
    }
    if ("gh_f0a92aa7146c".equals(paramString))
    {
      AppMethodBeat.o(248967);
      return true;
    }
    if ("gh_e087bb5b95e6".equals(paramString))
    {
      AppMethodBeat.o(248967);
      return true;
    }
    AppMethodBeat.o(248967);
    return false;
  }
  
  public static boolean iZB()
  {
    return false;
  }
  
  public static int iZG()
  {
    return 16;
  }
  
  public static int iZH()
  {
    return 8;
  }
  
  public static HashSet<String> iZM()
  {
    AppMethodBeat.i(248971);
    HashSet localHashSet = new HashSet();
    localHashSet.add("gh_3dfda90e39d6");
    localHashSet.add("gh_b4af18eac3d5");
    localHashSet.add("gh_f0a92aa7146c");
    localHashSet.add("gh_e087bb5b95e6");
    AppMethodBeat.o(248971);
    return localHashSet;
  }
  
  public static String t(Cursor paramCursor)
  {
    AppMethodBeat.i(43180);
    paramCursor = paramCursor.getString(paramCursor.getColumnIndex("username"));
    AppMethodBeat.o(43180);
    return paramCursor;
  }
  
  @Deprecated
  public final void Bp(String paramString)
  {
    AppMethodBeat.i(43185);
    super.Bp(paramString);
    AppMethodBeat.o(43185);
  }
  
  @Deprecated
  public final void Bq(String paramString)
  {
    AppMethodBeat.i(43186);
    super.Bq(paramString);
    AppMethodBeat.o(43186);
  }
  
  public final void Bu(String paramString)
  {
    AppMethodBeat.i(43181);
    super.Bu(paramString);
    iZK();
    AppMethodBeat.o(43181);
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(43188);
    String str = super.getCity();
    AppMethodBeat.o(43188);
    return str;
  }
  
  public final String getCityCode()
  {
    AppMethodBeat.i(43184);
    Object localObject = this.kaj;
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43184);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 3))
    {
      AppMethodBeat.o(43184);
      return "";
    }
    localObject = Util.nullAsNil(localObject[2]);
    AppMethodBeat.o(43184);
    return localObject;
  }
  
  public final String getCountryCode()
  {
    AppMethodBeat.i(43182);
    Object localObject = this.kaj;
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43182);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(43182);
      return "";
    }
    localObject = Util.nullAsNil(localObject[0]);
    AppMethodBeat.o(43182);
    return localObject;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(43187);
    String str = super.getProvince();
    AppMethodBeat.o(43187);
    return str;
  }
  
  public final boolean iZC()
  {
    return (this.field_verifyFlag & 0x8) > 0;
  }
  
  public final boolean iZD()
  {
    return (this.field_verifyFlag & 0x80) > 0;
  }
  
  public final boolean iZE()
  {
    return (this.extFlag & 0x2) > 0;
  }
  
  public final boolean iZF()
  {
    return (this.extFlag & 0x4) > 0;
  }
  
  public final boolean iZI()
  {
    AppMethodBeat.i(43179);
    if ((int)Util.nowSecond() - this.kak > adid)
    {
      AppMethodBeat.o(43179);
      return true;
    }
    AppMethodBeat.o(43179);
    return false;
  }
  
  public final String iZJ()
  {
    AppMethodBeat.i(43183);
    Object localObject = this.kaj;
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43183);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 2))
    {
      AppMethodBeat.o(43183);
      return "";
    }
    localObject = Util.nullAsNil(localObject[1]);
    AppMethodBeat.o(43183);
    return localObject;
  }
  
  public final void iZK()
  {
    AppMethodBeat.i(43189);
    Object localObject = this.kaj;
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(43189);
      return;
    }
    localObject = ((String)localObject).split("_");
    if (localObject.length > 0)
    {
      if (localObject.length > 2)
      {
        if (RegionCodeDecoder.byG(localObject[0]))
        {
          RegionCodeDecoder.jcF();
          super.Bp(RegionCodeDecoder.pM(localObject[0], localObject[1]));
        }
        for (;;)
        {
          RegionCodeDecoder.jcF();
          super.Bq(RegionCodeDecoder.bK(localObject[0], localObject[1], localObject[2]));
          AppMethodBeat.o(43189);
          return;
          RegionCodeDecoder.jcF();
          super.Bp(RegionCodeDecoder.byH(localObject[0]));
        }
      }
      if (localObject.length == 2)
      {
        RegionCodeDecoder.jcF();
        super.Bp(RegionCodeDecoder.byH(localObject[0]));
        RegionCodeDecoder.jcF();
        super.Bq(RegionCodeDecoder.pM(localObject[0], localObject[1]));
        AppMethodBeat.o(43189);
        return;
      }
      RegionCodeDecoder.jcF();
      super.Bp(RegionCodeDecoder.byH(localObject[0]));
      super.Bq("");
    }
    AppMethodBeat.o(43189);
  }
  
  public final au iZL()
  {
    AppMethodBeat.i(43190);
    try
    {
      au localau = (au)super.clone();
      AppMethodBeat.o(43190);
      return localau;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Contact", localException, "", new Object[0]);
        Log.e("MicroMsg.Contact", "clone Contact error. e: " + localException.toString());
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.au
 * JD-Core Version:    0.7.0.1
 */