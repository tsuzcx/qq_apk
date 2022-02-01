package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca.a;

public final class e
{
  public static void a(Context paramContext, com.tencent.mm.storage.as paramas, ca.a parama)
  {
    AppMethodBeat.i(37733);
    a(paramContext, paramas, parama, false, false, null, parama.mTO);
    AppMethodBeat.o(37733);
  }
  
  public static void a(Context paramContext, com.tencent.mm.storage.as paramas, ca.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(37734);
    if ((paramas == null) || (parama == null))
    {
      AppMethodBeat.o(37734);
      return;
    }
    if ((paramas.field_username == null) || (paramas.field_username.length() <= 0))
    {
      AppMethodBeat.o(37734);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramas.field_username);
    localIntent.putExtra("Contact_Alias", paramas.apf());
    localIntent.putExtra("Contact_Nick", paramas.ayr());
    localIntent.putExtra("Contact_QuanPin", paramas.api());
    localIntent.putExtra("Contact_PyInitial", paramas.aph());
    localIntent.putExtra("Contact_Sex", parama.sex);
    localIntent.putExtra("Contact_Province", parama.getProvince());
    localIntent.putExtra("Contact_City", parama.getCity());
    localIntent.putExtra("Contact_Signature", parama.signature);
    localIntent.putExtra("Contact_Uin", parama.GZN);
    localIntent.putExtra("Contact_Mobile_MD5", parama.VGG);
    localIntent.putExtra("Contact_full_Mobile_MD5", parama.VGH);
    localIntent.putExtra("Contact_QQNick", parama.hAp());
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
  
  public static void a(Context paramContext, ca.a parama)
  {
    AppMethodBeat.i(37731);
    a(paramContext, parama, false, false, null);
    AppMethodBeat.o(37731);
  }
  
  public static void a(Context paramContext, ca.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(37732);
    if ((paramContext == null) || (parama == null))
    {
      AppMethodBeat.o(37732);
      return;
    }
    com.tencent.mm.storage.as localas = new com.tencent.mm.storage.as();
    localas.setUsername(parama.fcC);
    localas.setNickname(parama.getDisplayName());
    localas.It(parama.mXp);
    localas.Iu(parama.mXq);
    a(paramContext, localas, parama, paramBoolean1, paramBoolean2, paramBundle, parama.mTO);
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
    com.tencent.mm.plugin.account.friend.a.as localas = com.tencent.mm.plugin.account.b.getQQListStg().aaM(paramString);
    if (localas != null)
    {
      paramIntent.putExtra("Contact_Uin", localas.mXm);
      paramIntent.putExtra("Contact_QQNick", localas.getDisplayName());
    }
    paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(paramString);
    if (paramString != null) {
      paramIntent.putExtra("Contact_Mobile_MD5", paramString.getMd5());
    }
    AppMethodBeat.o(37730);
  }
  
  public static void r(Intent paramIntent, String paramString)
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