package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;

public final class e
{
  public static void a(Context paramContext, ad paramad, bi.a parama)
  {
    a(paramContext, paramad, parama, false, false, null, parama.fds);
  }
  
  public static void a(Context paramContext, ad paramad, bi.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, String paramString)
  {
    if ((paramad == null) || (parama == null)) {}
    while ((paramad.field_username == null) || (paramad.field_username.length() <= 0)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramad.field_username);
    localIntent.putExtra("Contact_Alias", paramad.vk());
    localIntent.putExtra("Contact_Nick", paramad.Bp());
    localIntent.putExtra("Contact_QuanPin", paramad.vo());
    localIntent.putExtra("Contact_PyInitial", paramad.vn());
    localIntent.putExtra("Contact_Sex", parama.sex);
    localIntent.putExtra("Contact_Province", parama.getProvince());
    localIntent.putExtra("Contact_City", parama.getCity());
    localIntent.putExtra("Contact_Signature", parama.signature);
    localIntent.putExtra("Contact_Uin", parama.mXV);
    localIntent.putExtra("Contact_Mobile_MD5", parama.uBW);
    localIntent.putExtra("Contact_full_Mobile_MD5", parama.uBX);
    localIntent.putExtra("Contact_QQNick", parama.cvM());
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
  }
  
  public static void a(Context paramContext, bi.a parama)
  {
    a(paramContext, parama, false, false, null);
  }
  
  public static void a(Context paramContext, bi.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    if ((paramContext == null) || (parama == null)) {
      return;
    }
    ad localad = new ad();
    localad.setUsername(parama.pyp);
    localad.dk(parama.getDisplayName());
    localad.dl(parama.fgZ);
    localad.dm(parama.fha);
    a(paramContext, localad, parama, paramBoolean1, paramBoolean2, paramBundle, parama.fds);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (paramString == null) || (paramString.length() == 0)) {
      y.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + paramIntent + ", username = " + paramString);
    }
    do
    {
      return;
      com.tencent.mm.plugin.account.friend.a.ao localao = com.tencent.mm.plugin.account.b.getQQListStg().pR(paramString);
      if (localao != null)
      {
        paramIntent.putExtra("Contact_Uin", localao.fgW);
        paramIntent.putExtra("Contact_QQNick", localao.getDisplayName());
      }
      paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(paramString);
    } while (paramString == null);
    paramIntent.putExtra("Contact_Mobile_MD5", paramString.Wv());
  }
  
  public static void m(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("Contact_User", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.e
 * JD-Core Version:    0.7.0.1
 */