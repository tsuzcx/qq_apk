package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.account.friend.model.a;
import com.tencent.mm.plugin.account.friend.model.ap;
import com.tencent.mm.plugin.account.friend.model.aq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc.a;

public final class e
{
  public static void a(Context paramContext, au paramau, cc.a parama)
  {
    AppMethodBeat.i(37733);
    a(paramContext, paramau, parama, false, false, null, parama.pQw);
    AppMethodBeat.o(37733);
  }
  
  public static void a(Context paramContext, au paramau, cc.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(37734);
    if ((paramau == null) || (parama == null))
    {
      AppMethodBeat.o(37734);
      return;
    }
    if ((paramau.field_username == null) || (paramau.field_username.length() <= 0))
    {
      AppMethodBeat.o(37734);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramau.field_username);
    localIntent.putExtra("Contact_Alias", paramau.aJs());
    localIntent.putExtra("Contact_Nick", paramau.aSU());
    localIntent.putExtra("Contact_QuanPin", paramau.aJu());
    localIntent.putExtra("Contact_PyInitial", paramau.aJt());
    localIntent.putExtra("Contact_Sex", parama.sex);
    localIntent.putExtra("Contact_Province", parama.getProvince());
    localIntent.putExtra("Contact_City", parama.getCity());
    localIntent.putExtra("Contact_Signature", parama.signature);
    localIntent.putExtra("Contact_Uin", parama.MXS);
    localIntent.putExtra("Contact_Mobile_MD5", parama.adkz);
    localIntent.putExtra("Contact_full_Mobile_MD5", parama.adkA);
    localIntent.putExtra("Contact_QQNick", parama.jcv());
    localIntent.putExtra("User_From_Fmessage", true);
    localIntent.putExtra("Contact_Scene", parama.scene);
    localIntent.putExtra("Contact_from_msgType", 40);
    if (paramBoolean1) {
      localIntent.putExtra("Contact_ShowUserName", false);
    }
    if (paramBoolean2) {
      localIntent.putExtra("Contact_KSnsIFlag", 0);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("verify_gmail", paramString);
    }
    c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(37734);
  }
  
  public static void a(Context paramContext, cc.a parama)
  {
    AppMethodBeat.i(37731);
    a(paramContext, parama, false, false, null);
    AppMethodBeat.o(37731);
  }
  
  public static void a(Context paramContext, cc.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(37732);
    if ((paramContext == null) || (parama == null))
    {
      AppMethodBeat.o(37732);
      return;
    }
    au localau = new au();
    localau.setUsername(parama.hgk);
    localau.setNickname(parama.getDisplayName());
    localau.AY(parama.pTX);
    localau.AZ(parama.pTY);
    a(paramContext, localau, parama, paramBoolean1, paramBoolean2, paramBundle, parama.pQw);
    AppMethodBeat.o(37732);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(37730);
    if ((paramIntent == null) || (paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + paramIntent + ", username = " + paramString);
      AppMethodBeat.o(37730);
      return;
    }
    ap localap = com.tencent.mm.plugin.account.b.getQQListStg().Tf(paramString);
    if (localap != null)
    {
      paramIntent.putExtra("Contact_Uin", localap.pTU);
      paramIntent.putExtra("Contact_QQNick", localap.getDisplayName());
    }
    paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(paramString);
    if (paramString != null) {
      paramIntent.putExtra("Contact_Mobile_MD5", paramString.getMd5());
    }
    AppMethodBeat.o(37730);
  }
  
  public static void t(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(37729);
    paramIntent.putExtra("Contact_User", paramString);
    AppMethodBeat.o(37729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.e
 * JD-Core Version:    0.7.0.1
 */