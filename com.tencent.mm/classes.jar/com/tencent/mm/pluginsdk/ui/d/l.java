package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.R.c;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
{
  static String sjK;
  
  private static void a(Activity paramActivity, ad paramad, String paramString, ArrayList<String> paramArrayList)
  {
    Object localObject = new axq();
    ((axq)localObject).ttJ = paramString;
    beo localbeo = new beo();
    localbeo.hPS = paramArrayList.size();
    localbeo.tzz = new LinkedList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ben localben = new ben();
      localben.tzy = str;
      localbeo.tzz.add(localben);
    }
    ((axq)localObject).ttF = localbeo;
    ((j)g.r(j.class)).Fv().b(new i.a(60, (com.tencent.mm.bv.a)localObject));
    paramString = ((j)g.r(j.class)).Fw().abl(paramString);
    if ((paramString != null) && ((int)paramString.dBe > 0) && (com.tencent.mm.n.a.gR(paramString.field_type)))
    {
      paramArrayList = paramArrayList.iterator();
      for (paramString = ""; paramArrayList.hasNext(); paramString = paramString + ",")
      {
        localObject = (String)paramArrayList.next();
        paramString = paramString + (String)localObject;
      }
      paramad.dM(paramString);
      ((j)g.r(j.class)).Fw().U(paramad);
    }
    Toast.makeText(paramActivity, paramActivity.getString(R.l.succeed_add_to_remark), 0).show();
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
  {
    if (!(paramContext instanceof Activity)) {
      y.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[] { bk.csb() });
    }
    if (g.DN().Dc()) {}
    label528:
    for (boolean bool = ((Boolean)g.DP().Dz().get(ac.a.uqp, Boolean.valueOf(false))).booleanValue();; bool = false)
    {
      int i;
      int j;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fromScene");
        if ((!coc()) && (!cod())) {
          break label460;
        }
        j = 1;
        label85:
        if (j == 0) {
          break label719;
        }
        if (paramBundle != null) {
          break label466;
        }
        localObject = "";
        label98:
        localObject = bk.pm((String)localObject);
        if ((localObject != null) && (localObject != "") && (!com.tencent.mm.model.q.gS((String)localObject)) && (!ad.aaU((String)localObject))) {
          break label528;
        }
        if (!bool) {
          break label477;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(R.l.chatting_phone_use);
        localObject[1] = paramContext.getResources().getString(R.l.chatting_phone_use_by_ipcall);
        localObject[2] = paramContext.getResources().getString(R.l.chatting_phone_copy);
        localObject[3] = paramContext.getResources().getString(R.l.chatting_phone_add_op);
      }
      label200:
      label460:
      label719:
      for (Object localObject = bk.G((String[])localObject);; localObject = bk.G(new String[] { paramContext.getResources().getString(R.l.chatting_phone_use), paramContext.getResources().getString(R.l.chatting_phone_copy) }))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        if (q.tp())
        {
          ((List)localObject).add(paramContext.getResources().getString(R.l.chatting_phone_download_wxpb));
          com.tencent.mm.plugin.report.service.h.nFQ.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(3) });
          if (PlatformComm.C2Java.isNetworkConnected())
          {
            j = bk.a((Integer)g.DP().Dz().get(ac.a.uoH, null), 3);
            y.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", new Object[] { Integer.valueOf(j) });
            g.DP().Dz().c(ac.a.uoH, Integer.valueOf(j - 1));
          }
        }
        k localk = new k(paramContext);
        localk.setTitle(paramString);
        l.a locala = new l.a((List)localObject, paramContext, paramOnDismissListener, paramBundle);
        locala.sjS = new l.5(localk, paramOnDismissListener);
        localk.iqN = locala;
        com.tencent.mm.ui.base.h.a(paramContext, localk);
        localk.setOnCancelListener(new l.6(paramOnDismissListener));
        localk.slt = new l.7(paramString, (List)localObject, paramContext, localk, paramOnDismissListener, i, paramBundle);
        localk.show();
        label466:
        label477:
        do
        {
          return;
          i = 0;
          break;
          j = 0;
          break label85;
          localObject = paramBundle.getString("Contact_User");
          break label98;
          localObject = new String[3];
          localObject[0] = paramContext.getResources().getString(R.l.chatting_phone_use);
          localObject[1] = paramContext.getResources().getString(R.l.chatting_phone_copy);
          localObject[2] = paramContext.getResources().getString(R.l.chatting_phone_add_op);
          break label200;
          localObject = ((j)g.r(j.class)).Fw().abl((String)localObject);
        } while (localObject == null);
        localObject = ((ad)localObject).Bq();
        sjK = paramContext.getResources().getString(R.l.chatting_phone_add_remark, new Object[] { localObject });
        if (bool)
        {
          localObject = new String[5];
          localObject[0] = paramContext.getResources().getString(R.l.chatting_phone_use);
          localObject[1] = paramContext.getResources().getString(R.l.chatting_phone_use_by_ipcall);
          localObject[2] = sjK;
          localObject[3] = paramContext.getResources().getString(R.l.chatting_phone_copy);
          localObject[4] = paramContext.getResources().getString(R.l.chatting_phone_add_op);
          break label200;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(R.l.chatting_phone_use);
        localObject[1] = sjK;
        localObject[2] = paramContext.getResources().getString(R.l.chatting_phone_copy);
        localObject[3] = paramContext.getResources().getString(R.l.chatting_phone_add_op);
        break label200;
      }
    }
  }
  
  public static void b(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((com.tencent.mm.model.q.Gu() & 0x1) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramString, paramContext.getResources().getStringArray(R.c.email_url), "", new l.1(paramOnDismissListener, paramString, paramContext));
      return;
    }
    String str = paramContext.getResources().getString(R.l.chatting_email_by_default_account);
    paramOnDismissListener = new l.2(paramOnDismissListener, paramString, paramContext);
    com.tencent.mm.ui.base.h.a(paramContext, paramString, new String[] { str }, "", paramOnDismissListener);
  }
  
  static boolean coc()
  {
    Context localContext = ae.getContext();
    Intent localIntent = new Intent("android.intent.action.INSERT");
    localIntent.setType("vnd.android.cursor.dir/contact");
    localIntent.putExtra("phone", "10086");
    return bk.i(localContext, localIntent);
  }
  
  static boolean cod()
  {
    return bk.i(ae.getContext(), new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l
 * JD-Core Version:    0.7.0.1
 */