package com.tencent.mm.plugin.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.ct;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.f;
import java.util.List;
import junit.framework.Assert;

public final class c
{
  public static SpannableString a(Context paramContext, String paramString, SpannableString paramSpannableString)
  {
    AppMethodBeat.i(305396);
    if (au.bwJ(paramString))
    {
      if (com.tencent.mm.model.ab.bBX())
      {
        paramContext = new SpannableString(paramContext.getString(R.l.Common_OfficialNickName_Oversea));
        AppMethodBeat.o(305396);
        return paramContext;
      }
      paramContext = new SpannableString(paramContext.getString(R.l.Common_OfficialNickName_domestic));
      AppMethodBeat.o(305396);
      return paramContext;
    }
    AppMethodBeat.o(305396);
    return paramSpannableString;
  }
  
  public static boolean aRQ(String paramString)
  {
    AppMethodBeat.i(305403);
    paramString = ((n)h.ax(n.class)).gaZ().aLG(paramString);
    if ((paramString != null) && (paramString.field_msgId != 0L))
    {
      AppMethodBeat.o(305403);
      return true;
    }
    AppMethodBeat.o(305403);
    return false;
  }
  
  public static String bG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(305386);
    if (au.bwJ(paramString))
    {
      if (com.tencent.mm.model.ab.bBX())
      {
        paramContext = paramContext.getString(R.l.app_field_username_wechat);
        AppMethodBeat.o(305386);
        return paramContext;
      }
      paramContext = paramContext.getString(R.l.app_field_username_weixin);
      AppMethodBeat.o(305386);
      return paramContext;
    }
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      paramContext = paramContext.getString(R.l.app_field_username);
      AppMethodBeat.o(305386);
      return paramContext;
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (boolean bool = false; bool; bool = paramString.equals(z.bAM()))
    {
      paramContext = paramContext.getString(R.l.app_field_username);
      AppMethodBeat.o(305386);
      return paramContext;
    }
    paramContext = paramContext.getString(R.l.app_field_username_others);
    AppMethodBeat.o(305386);
    return paramContext;
  }
  
  public static String bn(Intent paramIntent)
  {
    AppMethodBeat.i(305408);
    if (paramIntent == null)
    {
      AppMethodBeat.o(305408);
      return "";
    }
    Bundle localBundle = paramIntent.getBundleExtra("Contact_Ext_Args");
    paramIntent = "";
    if (localBundle != null) {
      paramIntent = localBundle.getString("Contact_Ext_Args_Search_Click_Id", "");
    }
    AppMethodBeat.o(305408);
    return paramIntent;
  }
  
  public static String la(String paramString1, String paramString2)
  {
    AppMethodBeat.i(305391);
    if (au.bwJ(paramString1))
    {
      if (com.tencent.mm.model.ab.bBX())
      {
        AppMethodBeat.o(305391);
        return "WeChat";
      }
      AppMethodBeat.o(305391);
      return "Weixin";
    }
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(305391);
      return paramString2;
    }
    if (au.bwJ(paramString1))
    {
      paramString1 = ct.Ki("OfficialAliasName");
      AppMethodBeat.o(305391);
      return paramString1;
    }
    AppMethodBeat.o(305391);
    return paramString2;
  }
  
  public static void lb(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(305411);
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305401);
        boolean bool = com.tencent.mm.modelverify.d.bNI().fP(c.this, 1);
        if (bool) {
          Log.d("MicroMsg.ProfileUtils", "fmsgConversation updateState succ, user = " + c.this);
        }
        for (;;)
        {
          Log.i("MicroMsg.ProfileUtils", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(bool)));
          AppMethodBeat.o(305401);
          return;
          bool = com.tencent.mm.modelverify.d.bNI().fP(paramString2, 1);
          Log.d("MicroMsg.ProfileUtils", "fmsgConversation updateState succ, encryptUser = " + paramString2);
        }
      }
    });
    AppMethodBeat.o(305411);
  }
  
  public static void p(String paramString1, final String paramString2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(305416);
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305382);
        label1511:
        label1517:
        label1520:
        label1527:
        label1534:
        for (;;)
        {
          Object localObject5;
          Object localObject4;
          try
          {
            localObject5 = c.this;
            bh.bCz();
            au localau = com.tencent.mm.model.c.bzA().JE((String)localObject5);
            if (com.tencent.mm.contact.d.rs(localau.field_type))
            {
              Log.i("MicroMsg.ProfileUtils", "createSendMessage, iscontact, contactTmp.getUsername() = %s, contactTmp.getEncryptUsername() = %s.", new Object[] { localau.field_username, localau.field_encryptUsername });
              c.lb(localau.field_username, localau.field_encryptUsername);
            }
            bh.bCz();
            Object localObject8 = com.tencent.mm.model.c.bzA().JE((String)localObject5);
            localObject4 = ((az)localObject8).field_encryptUsername;
            localObject7 = ((az)localObject8).kas;
            if ((paramInt1 != 2) && (paramInt1 != 3)) {
              break label1527;
            }
            localObject6 = com.tencent.mm.modelverify.d.bNH().byn((String)localObject5);
            if (localObject6 == null) {
              break label1527;
            }
            Object localObject1 = ((bp)localObject6).field_talker;
            localObject4 = ((bp)localObject6).field_encryptTalker;
            if (paramInt1 != 1) {
              break label1520;
            }
            localObject4 = localObject1;
            if (!com.tencent.mm.platformtools.ab.isNullOrNil(((az)localObject8).field_encryptUsername))
            {
              localObject4 = localObject1;
              if (((az)localObject8).field_encryptUsername.equals(localObject5))
              {
                localObject6 = com.tencent.mm.modelverify.d.bNI().byl(((az)localObject8).field_encryptUsername);
                localObject4 = localObject1;
                if (localObject6 != null)
                {
                  localObject4 = localObject1;
                  if (!com.tencent.mm.platformtools.ab.isNullOrNil(((bn)localObject6).field_talker))
                  {
                    localObject4 = localObject1;
                    if (!((bn)localObject6).field_talker.equals(localObject5)) {
                      localObject4 = ((bn)localObject6).field_talker;
                    }
                  }
                }
              }
            }
            localObject6 = ((az)localObject8).field_encryptUsername;
            localObject1 = localObject4;
            if (com.tencent.mm.platformtools.ab.isNullOrNil((String)localObject7))
            {
              Object localObject9 = com.tencent.mm.modelverify.d.bNH().byn((String)localObject1);
              localObject4 = localObject7;
              if (localObject9 == null) {
                break label1534;
              }
              localObject4 = localObject7;
              if (com.tencent.mm.platformtools.ab.isNullOrNil(((bp)localObject9).field_msgContent)) {
                break label1534;
              }
              bh.bCz();
              localObject9 = com.tencent.mm.model.c.bzD().aLT(((bp)localObject9).field_msgContent);
              localObject4 = localObject7;
              if (localObject9 == null) {
                break label1534;
              }
              localObject4 = localObject7;
              if (com.tencent.mm.platformtools.ab.isNullOrNil(((cc.f)localObject9).pPi)) {
                break label1534;
              }
              localObject4 = ((cc.f)localObject9).pPi;
              Log.i("MicroMsg.ProfileUtils", "lastRecvFMsg, antiSpamTicket = %s.", new Object[] { localObject4 });
              break label1534;
              localObject9 = paramString2;
              localObject7 = localObject9;
              if (1 == paramInt1)
              {
                localObject7 = localObject9;
                if (Util.isNullOrNil(paramString2))
                {
                  localObject7 = MMApplicationContext.getContext().getString(R.l.gPK);
                  Log.i("MicroMsg.ProfileUtils", "reset verifyContentTmp");
                }
              }
              Log.i("MicroMsg.ProfileUtils", "createSendMessage, before change username talker = %s, talkerAddBySayHi = %s, targetTalker = %s.", new Object[] { localObject5, c.this, localObject1 });
              bh.bCz();
              localObject9 = com.tencent.mm.model.c.bzA().JE((String)localObject5);
              if (!com.tencent.mm.contact.d.rs(((az)localObject9).field_type)) {
                break label1517;
              }
              localObject5 = ((az)localObject9).field_username;
              localObject1 = ((az)localObject9).field_username;
              Log.i("MicroMsg.ProfileUtils", "createSendMessage, iscontact.");
              localObject8 = localObject9;
              Log.i("MicroMsg.ProfileUtils", "createSendMessage, after change username talker = %s, talkerAddBySayHi = %s, targetTalker = %s.", new Object[] { localObject5, c.this, localObject1 });
              localObject4 = String.format("<msg fromusername=\"%s\" encryptusername=\"%s\" fromnickname=\"%s\" content=\"%s\" scene=\"%s\" ticket=\"%s\"> </msg>", new Object[] { localObject1, localObject6, ((au)localObject8).aSU(), localObject7, Integer.valueOf(paramInt2), localObject4 });
              Log.i("MicroMsg.ProfileUtils", "createSendMessage, change username talker = %s, talkerAddBySayHi = %s, targetTalker = %s.", new Object[] { localObject5, c.this, localObject1 });
              localObject7 = new bp();
              ((bp)localObject7).field_createTime = br.D((String)localObject5, cn.bDv() / 1000L);
              ((bp)localObject7).field_isSend = 1;
              ((bp)localObject7).field_msgContent = ((String)localObject4);
              ((bp)localObject7).field_talker = ((String)localObject1);
              ((bp)localObject7).field_encryptTalker = ((String)localObject6);
              ((bp)localObject7).field_type = paramInt1;
              bool1 = com.tencent.mm.modelverify.d.bNH().b((bp)localObject7);
              localObject1 = cc.f.byv(((bp)localObject7).field_msgContent);
              Log.i("MicroMsg.ProfileUtils", "FMessageConversationStorage createSendMessage, insert fmsg, ret = %s, lastRecvFmsg  = %s, verify = %s, Content = %s, DisplayName = %s, fMessageMsgInfoType = %s, fmsgInfo.field_createTime = %s, sytime = %s， xmlContent = %s.", new Object[] { Boolean.valueOf(bool1), "", localObject1, ((cc.f)localObject1).content, ((cc.f)localObject1).getDisplayName(), Integer.valueOf(paramInt1), Long.valueOf(((bp)localObject7).field_createTime), Long.valueOf(System.currentTimeMillis() / 1000L), localObject4 });
              bh.bCz();
              localObject1 = com.tencent.mm.model.c.bzA().JE((String)localObject5);
              if (!com.tencent.mm.contact.d.rs(((az)localObject1).field_type)) {
                continue;
              }
              Log.i("MicroMsg.ProfileUtils", "createSendMessage, iscontact, contactTmp.getUsername() = %s, contactTmp.getEncryptUsername() = %s.", new Object[] { ((az)localObject1).field_username, localau.field_encryptUsername });
              c.lb(((az)localObject1).field_username, ((az)localObject1).field_encryptUsername);
              localObject4 = ((az)localObject1).field_username;
              localObject5 = new bp[1];
              localObject5[0] = localObject7;
              localObject6 = b.a(MMApplicationContext.getContext(), (bp[])localObject5);
              if ((localObject6 == null) || (localObject6.length == 0)) {
                Log.i("MicroMsg.ProfileUtils", "insertMsg, providerList = null.");
              }
            }
            else
            {
              Log.i("MicroMsg.ProfileUtils", "contact, antiSpamTicket = %s.", new Object[] { localObject7 });
              localObject4 = localObject7;
              continue;
            }
            if (localObject6.length <= 0) {
              break label1511;
            }
            localObject1 = localObject6[0];
            bh.bCz();
            localObject7 = com.tencent.mm.model.c.bzD().ka((String)localObject4, 1);
            boolean bool3 = false;
            boolean bool2 = false;
            bool1 = bool3;
            if (((List)localObject7).size() > 0)
            {
              bool1 = bool3;
              if (((List)localObject7).get(0) != null)
              {
                bool1 = bool3;
                if (localObject1 != null)
                {
                  localObject7 = (cc)((List)localObject7).get(0);
                  bool1 = bool2;
                  if (((fi)localObject7).field_isSend == 1)
                  {
                    bool1 = bool2;
                    if (Math.abs(cn.bDv() - ((cc)localObject7).getCreateTime()) < 3000L)
                    {
                      bool1 = bool2;
                      if (((b)localObject1).nUO != null)
                      {
                        bool1 = bool2;
                        if (((b)localObject1).nUO.equals(((fi)localObject7).field_content)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                  Log.i("MicroMsg.ProfileUtils", "insertMsg, getIsSend = %s, sendMsgInfo.getCreateTime(), = %s, TimeHelper.getSyncServerTimeMs() = %s， sendMsgInfo.getStatus() = %s, Math.abs(TimeHelper.getSyncServerTimeMs() - sendMsgInfo.getCreateTime()) = %s, provider.digest = %s, sendMsgInfo.getContent() = %s.", new Object[] { Integer.valueOf(((fi)localObject7).field_isSend), Long.valueOf(((cc)localObject7).getCreateTime()), Long.valueOf(cn.bDv()), Integer.valueOf(((fi)localObject7).field_status), Long.valueOf(Math.abs(cn.bDv() - ((cc)localObject7).getCreateTime())), ((b)localObject1).nUO, ((fi)localObject7).field_content });
                }
              }
            }
            Log.i("MicroMsg.ProfileUtils", "insertMsg insertMsg , hasRepeatMessage = ".concat(String.valueOf(bool1)));
            if (bool1) {
              continue;
            }
            i = 0;
            int k = localObject6.length;
            j = 0;
            if (j >= k) {
              continue;
            }
            localObject1 = localObject6[j];
            localObject7 = new cc();
            ((cc)localObject7).setContent(((b)localObject1).nUO);
            int m = com.tencent.mm.model.ab.IX((String)localObject4);
            ((cc)localObject7).setCreateTime(localObject5[i].field_createTime);
            ((cc)localObject7).BS((String)localObject4);
            ((cc)localObject7).setType(m);
            if (!((b)localObject1).ihD) {
              continue;
            }
            ((cc)localObject7).setStatus(2);
            ((cc)localObject7).pI(1);
            bh.bCz();
            l = com.tencent.mm.model.c.bzD().ba((cc)localObject7);
            if (l == -1L) {
              continue;
            }
            bool1 = true;
          }
          catch (Exception localException)
          {
            Object localObject7;
            int i;
            int j;
            long l;
            Log.e("MicroMsg.ProfileUtils", "exception in createSendMessage : " + localException.getMessage());
            return;
            boolean bool1 = false;
            continue;
            cc localcc = new cc();
            localcc.setCreateTime(localObject5[0].field_createTime + 1L);
            localcc.BS((String)localObject4);
            localcc.setContent(MMApplicationContext.getContext().getString(R.l.gXv));
            localcc.setType(10000);
            localcc.setStatus(6);
            localcc.pI(0);
            bh.bCz();
            Log.i("MicroMsg.ProfileUtils", "insertMsg ， msgId = ".concat(String.valueOf(com.tencent.mm.model.c.bzD().ba(localcc))));
            return;
          }
          finally
          {
            AppMethodBeat.o(305382);
          }
          Assert.assertTrue(bool1);
          Log.i("MicroMsg.ProfileUtils", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
          j += 1;
          i += 1;
          continue;
          ((cc)localObject7).setStatus(6);
          ((cc)localObject7).pI(0);
          continue;
          Object localObject3 = null;
          continue;
          continue;
          Object localObject6 = localObject4;
          continue;
          localObject3 = localObject5;
        }
      }
    });
    AppMethodBeat.o(305416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.c
 * JD-Core Version:    0.7.0.1
 */