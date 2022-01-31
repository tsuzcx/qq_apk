package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;

public final class e
{
  public static void a(Context paramContext, ad paramad, bi.a parama)
  {
    AppMethodBeat.i(33611);
    a(paramContext, paramad, parama, false, false, null, parama.gvd);
    AppMethodBeat.o(33611);
  }
  
  public static void a(Context paramContext, ad paramad, bi.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(33612);
    if ((paramad == null) || (parama == null))
    {
      AppMethodBeat.o(33612);
      return;
    }
    if ((paramad.field_username == null) || (paramad.field_username.length() <= 0))
    {
      AppMethodBeat.o(33612);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramad.field_username);
    localIntent.putExtra("Contact_Alias", paramad.Hq());
    localIntent.putExtra("Contact_Nick", paramad.Oe());
    localIntent.putExtra("Contact_QuanPin", paramad.Hu());
    localIntent.putExtra("Contact_PyInitial", paramad.Ht());
    localIntent.putExtra("Contact_Sex", parama.dqC);
    localIntent.putExtra("Contact_Province", parama.getProvince());
    localIntent.putExtra("Contact_City", parama.getCity());
    localIntent.putExtra("Contact_Signature", parama.signature);
    localIntent.putExtra("Contact_Uin", parama.pAI);
    localIntent.putExtra("Contact_Mobile_MD5", parama.yOi);
    localIntent.putExtra("Contact_full_Mobile_MD5", parama.yOj);
    localIntent.putExtra("Contact_QQNick", parama.dyu());
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
    AppMethodBeat.o(33612);
  }
  
  public static void a(Context paramContext, bi.a parama)
  {
    AppMethodBeat.i(33609);
    a(paramContext, parama, false, false, null);
    AppMethodBeat.o(33609);
  }
  
  public static void a(Context paramContext, bi.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(33610);
    if ((paramContext == null) || (parama == null))
    {
      AppMethodBeat.o(33610);
      return;
    }
    ad localad = new ad();
    localad.setUsername(parama.tac);
    localad.jp(parama.getDisplayName());
    localad.jq(parama.gyH);
    localad.jr(parama.gyI);
    a(paramContext, localad, parama, paramBoolean1, paramBoolean2, paramBundle, parama.gvd);
    AppMethodBeat.o(33610);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(33608);
    if ((paramIntent == null) || (paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + paramIntent + ", username = " + paramString);
      AppMethodBeat.o(33608);
      return;
    }
    ao localao = com.tencent.mm.plugin.account.a.getQQListStg().xn(paramString);
    if (localao != null)
    {
      paramIntent.putExtra("Contact_Uin", localao.gyE);
      paramIntent.putExtra("Contact_QQNick", localao.getDisplayName());
    }
    paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(paramString);
    if (paramString != null) {
      paramIntent.putExtra("Contact_Mobile_MD5", paramString.Al());
    }
    AppMethodBeat.o(33608);
  }
  
  public static void r(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(33607);
    paramIntent.putExtra("Contact_User", paramString);
    AppMethodBeat.o(33607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.e
 * JD-Core Version:    0.7.0.1
 */