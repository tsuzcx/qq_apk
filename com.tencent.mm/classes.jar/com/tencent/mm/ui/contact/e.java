package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo.a;

public final class e
{
  public static void a(Context paramContext, ai paramai, bo.a parama)
  {
    AppMethodBeat.i(37733);
    a(paramContext, paramai, parama, false, false, null, parama.iIk);
    AppMethodBeat.o(37733);
  }
  
  public static void a(Context paramContext, ai paramai, bo.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(37734);
    if ((paramai == null) || (parama == null))
    {
      AppMethodBeat.o(37734);
      return;
    }
    if ((paramai.field_username == null) || (paramai.field_username.length() <= 0))
    {
      AppMethodBeat.o(37734);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramai.field_username);
    localIntent.putExtra("Contact_Alias", paramai.Tl());
    localIntent.putExtra("Contact_Nick", paramai.aaR());
    localIntent.putExtra("Contact_QuanPin", paramai.Tp());
    localIntent.putExtra("Contact_PyInitial", paramai.To());
    localIntent.putExtra("Contact_Sex", parama.exL);
    localIntent.putExtra("Contact_Province", parama.getProvince());
    localIntent.putExtra("Contact_City", parama.getCity());
    localIntent.putExtra("Contact_Signature", parama.signature);
    localIntent.putExtra("Contact_Uin", parama.vLk);
    localIntent.putExtra("Contact_Mobile_MD5", parama.GYX);
    localIntent.putExtra("Contact_full_Mobile_MD5", parama.GYY);
    localIntent.putExtra("Contact_QQNick", parama.fcl());
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
    d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(37734);
  }
  
  public static void a(Context paramContext, bo.a parama)
  {
    AppMethodBeat.i(37731);
    a(paramContext, parama, false, false, null);
    AppMethodBeat.o(37731);
  }
  
  public static void a(Context paramContext, bo.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(37732);
    if ((paramContext == null) || (parama == null))
    {
      AppMethodBeat.o(37732);
      return;
    }
    ai localai = new ai();
    localai.setUsername(parama.zTO);
    localai.qj(parama.getDisplayName());
    localai.qk(parama.iLL);
    localai.ql(parama.iLM);
    a(paramContext, localai, parama, paramBoolean1, paramBoolean2, paramBundle, parama.iIk);
    AppMethodBeat.o(37732);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(37730);
    if ((paramIntent == null) || (paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + paramIntent + ", username = " + paramString);
      AppMethodBeat.o(37730);
      return;
    }
    as localas = com.tencent.mm.plugin.account.a.getQQListStg().Gu(paramString);
    if (localas != null)
    {
      paramIntent.putExtra("Contact_Uin", localas.iLI);
      paramIntent.putExtra("Contact_QQNick", localas.getDisplayName());
    }
    paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(paramString);
    if (paramString != null) {
      paramIntent.putExtra("Contact_Mobile_MD5", paramString.JC());
    }
    AppMethodBeat.o(37730);
  }
  
  public static void u(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(37729);
    paramIntent.putExtra("Contact_User", paramString);
    AppMethodBeat.o(37729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.e
 * JD-Core Version:    0.7.0.1
 */