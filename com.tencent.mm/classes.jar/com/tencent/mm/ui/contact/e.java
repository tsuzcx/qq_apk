package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu.a;

public final class e
{
  public static void a(Context paramContext, am paramam, bu.a parama)
  {
    AppMethodBeat.i(37733);
    a(paramContext, paramam, parama, false, false, null, parama.jbt);
    AppMethodBeat.o(37733);
  }
  
  public static void a(Context paramContext, am paramam, bu.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(37734);
    if ((paramam == null) || (parama == null))
    {
      AppMethodBeat.o(37734);
      return;
    }
    if ((paramam.field_username == null) || (paramam.field_username.length() <= 0))
    {
      AppMethodBeat.o(37734);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramam.field_username);
    localIntent.putExtra("Contact_Alias", paramam.VA());
    localIntent.putExtra("Contact_Nick", paramam.adu());
    localIntent.putExtra("Contact_QuanPin", paramam.VE());
    localIntent.putExtra("Contact_PyInitial", paramam.VD());
    localIntent.putExtra("Contact_Sex", parama.ePk);
    localIntent.putExtra("Contact_Province", parama.getProvince());
    localIntent.putExtra("Contact_City", parama.getCity());
    localIntent.putExtra("Contact_Signature", parama.signature);
    localIntent.putExtra("Contact_Uin", parama.wSt);
    localIntent.putExtra("Contact_Mobile_MD5", parama.IMm);
    localIntent.putExtra("Contact_full_Mobile_MD5", parama.IMn);
    localIntent.putExtra("Contact_QQNick", parama.fss());
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
  
  public static void a(Context paramContext, bu.a parama)
  {
    AppMethodBeat.i(37731);
    a(paramContext, parama, false, false, null);
    AppMethodBeat.o(37731);
  }
  
  public static void a(Context paramContext, bu.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(37732);
    if ((paramContext == null) || (parama == null))
    {
      AppMethodBeat.o(37732);
      return;
    }
    am localam = new am();
    localam.setUsername(parama.dHm);
    localam.sT(parama.getDisplayName());
    localam.sU(parama.jeU);
    localam.sV(parama.jeV);
    a(paramContext, localam, parama, paramBoolean1, paramBoolean2, paramBundle, parama.jbt);
    AppMethodBeat.o(37732);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(37730);
    if ((paramIntent == null) || (paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + paramIntent + ", username = " + paramString);
      AppMethodBeat.o(37730);
      return;
    }
    as localas = com.tencent.mm.plugin.account.a.getQQListStg().JJ(paramString);
    if (localas != null)
    {
      paramIntent.putExtra("Contact_Uin", localas.jeR);
      paramIntent.putExtra("Contact_QQNick", localas.getDisplayName());
    }
    paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(paramString);
    if (paramString != null) {
      paramIntent.putExtra("Contact_Mobile_MD5", paramString.Lb());
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