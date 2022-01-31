package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.api.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bbe;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.a;

public final class c
{
  public static void a(Intent paramIntent, bnm parambnm, int paramInt)
  {
    ((i)g.r(i.class)).a(paramIntent, parambnm, paramInt);
  }
  
  public static void a(Intent paramIntent, bob parambob, int paramInt)
  {
    paramIntent.putExtra("Contact_User", parambob.hPY);
    paramIntent.putExtra("Contact_Nick", parambob.hRf);
    paramIntent.putExtra("Contact_PyInitial", parambob.sPp);
    paramIntent.putExtra("Contact_QuanPin", parambob.sPq);
    paramIntent.putExtra("Contact_Sex", parambob.ffh);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra(e.a.uHO, parambob.tac);
    paramIntent.putExtra("key_add_contact_openim_appid", parambob.euK);
    paramIntent.putExtra("key_add_contact_match_type", parambob.tGq);
    paramIntent.putExtra("key_add_contact_custom_detail_visible", parambob.tGH.txn);
    paramIntent.putExtra("key_add_contact_custom_detail", parambob.tGH.kSY);
    y.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { parambob.tac });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */