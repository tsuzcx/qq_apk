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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
{
  static String wcr;
  
  private static void a(Activity paramActivity, ad paramad, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(28151);
    Object localObject = new bej();
    ((bej)localObject).xtI = paramString;
    bmi localbmi = new bmi();
    localbmi.jJu = paramArrayList.size();
    localbmi.xAM = new LinkedList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      bmh localbmh = new bmh();
      localbmh.xAL = str;
      localbmi.xAM.add(localbmh);
    }
    ((bej)localObject).xtE = localbmi;
    ((j)g.E(j.class)).Yz().c(new j.a(60, (com.tencent.mm.bv.a)localObject));
    paramString = ((j)g.E(j.class)).YA().arw(paramString);
    if ((paramString != null) && ((int)paramString.euF > 0) && (com.tencent.mm.n.a.je(paramString.field_type)))
    {
      paramArrayList = paramArrayList.iterator();
      for (paramString = ""; paramArrayList.hasNext(); paramString = paramString + ",")
      {
        localObject = (String)paramArrayList.next();
        paramString = paramString + (String)localObject;
      }
      paramad.jS(paramString);
      ((j)g.E(j.class)).YA().X(paramad);
    }
    Toast.makeText(paramActivity, paramActivity.getString(2131304204), 0).show();
    AppMethodBeat.o(28151);
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
  {
    AppMethodBeat.i(28147);
    if (!(paramContext instanceof Activity)) {
      ab.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[] { bo.dtY() });
    }
    if (g.RJ().QU()) {}
    label398:
    label409:
    for (boolean bool = ((Boolean)g.RL().Ru().get(ac.a.yAp, Boolean.FALSE)).booleanValue();; bool = false)
    {
      int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fromScene");
        if (!dpo()) {
          break label658;
        }
        if (paramBundle != null) {
          break label398;
        }
        localObject = "";
        label89:
        localObject = bo.nullAsNil((String)localObject);
        if ((localObject != null) && (localObject != "") && (!r.nB((String)localObject)) && (!ad.arf((String)localObject))) {
          break label460;
        }
        if (!bool) {
          break label409;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(2131298279);
        localObject[1] = paramContext.getResources().getString(2131298280);
        localObject[2] = paramContext.getResources().getString(2131298273);
        localObject[3] = paramContext.getResources().getString(2131298271);
      }
      label191:
      for (Object localObject = bo.P((String[])localObject);; localObject = bo.P(new String[] { paramContext.getResources().getString(2131298279), paramContext.getResources().getString(2131298273) }))
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        if (q.BT())
        {
          ((List)localObject).add(paramContext.getResources().getString(2131298275));
          com.tencent.mm.plugin.report.service.h.qsU.e(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(3) });
          if (PlatformComm.C2Java.isNetworkConnected()) {
            q.dpr();
          }
        }
        k localk = new k(paramContext);
        localk.setTitle(paramString);
        l.a locala = new l.a((List)localObject, paramContext, paramOnDismissListener, paramBundle);
        locala.wcz = new l.5(localk, paramOnDismissListener);
        localk.krV = locala;
        com.tencent.mm.ui.base.h.a(paramContext, localk);
        localk.setOnCancelListener(new l.6(paramOnDismissListener));
        localk.wdV = new l.7(paramString, (List)localObject, paramContext, localk, paramOnDismissListener, i, paramBundle);
        localk.show();
        AppMethodBeat.o(28147);
        return;
        i = 0;
        break;
        localObject = paramBundle.getString("Contact_User");
        break label89;
        localObject = new String[3];
        localObject[0] = paramContext.getResources().getString(2131298279);
        localObject[1] = paramContext.getResources().getString(2131298273);
        localObject[2] = paramContext.getResources().getString(2131298271);
        break label191;
        label460:
        localObject = ((j)g.E(j.class)).YA().arw((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(28147);
          return;
        }
        localObject = ((ad)localObject).Of();
        wcr = paramContext.getResources().getString(2131298272, new Object[] { localObject });
        if (bool)
        {
          localObject = new String[5];
          localObject[0] = paramContext.getResources().getString(2131298279);
          localObject[1] = paramContext.getResources().getString(2131298280);
          localObject[2] = wcr;
          localObject[3] = paramContext.getResources().getString(2131298273);
          localObject[4] = paramContext.getResources().getString(2131298271);
          break label191;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(2131298279);
        localObject[1] = wcr;
        localObject[2] = paramContext.getResources().getString(2131298273);
        localObject[3] = paramContext.getResources().getString(2131298271);
        break label191;
      }
    }
  }
  
  public static void b(final Context paramContext, final String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(28146);
    if ((r.Zy() & 0x1) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramString, paramContext.getResources().getStringArray(2131755014), "", new h.c()
      {
        public final void iA(int paramAnonymousInt)
        {
          AppMethodBeat.i(28131);
          if (this.wcs != null) {
            this.wcs.onDismiss(null);
          }
          String str1 = paramString.replace(" ", "").replace("#", "@");
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(28131);
            return;
            Context localContext = paramContext;
            Intent localIntent = new Intent();
            localIntent.putExtra("composeType", 4);
            String str2 = str1.substring(0, str1.indexOf('@'));
            localIntent.putExtra("toList", new String[] { str2 + " " + str1 });
            d.b(localContext, "qqmail", ".ui.ComposeUI", localIntent);
            AppMethodBeat.o(28131);
            return;
            l.bA(paramContext, str1);
          }
        }
      });
      AppMethodBeat.o(28146);
      return;
    }
    String str = paramContext.getResources().getString(2131298163);
    paramOnDismissListener = new h.c()
    {
      public final void iA(int paramAnonymousInt)
      {
        AppMethodBeat.i(28132);
        if (this.wcs != null) {
          this.wcs.onDismiss(null);
        }
        String str = paramString.replace(" ", "").replace("#", "@");
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(28132);
          return;
          l.bA(paramContext, str);
        }
      }
    };
    com.tencent.mm.ui.base.h.a(paramContext, paramString, new String[] { str }, "", paramOnDismissListener);
    AppMethodBeat.o(28146);
  }
  
  private static boolean dpo()
  {
    AppMethodBeat.i(28148);
    if ((dpp()) || (dpq()))
    {
      AppMethodBeat.o(28148);
      return true;
    }
    AppMethodBeat.o(28148);
    return false;
  }
  
  static boolean dpp()
  {
    AppMethodBeat.i(28149);
    Context localContext = ah.getContext();
    Intent localIntent = new Intent("android.intent.action.INSERT");
    localIntent.setType("vnd.android.cursor.dir/contact");
    localIntent.putExtra("phone", "10086");
    boolean bool = bo.k(localContext, localIntent);
    AppMethodBeat.o(28149);
    return bool;
  }
  
  static boolean dpq()
  {
    AppMethodBeat.i(28150);
    boolean bool = bo.k(ah.getContext(), new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI));
    AppMethodBeat.o(28150);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l
 * JD-Core Version:    0.7.0.1
 */