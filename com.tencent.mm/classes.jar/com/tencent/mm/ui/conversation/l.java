package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.widget.b.c;
import java.util.Map;

public final class l
{
  private static c AlK = null;
  
  private static void C(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(34586);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("show_rating_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean("show_rating_again", false);
    int i = localSharedPreferences.getInt("show_rating_wait_days", 0);
    int j = localSharedPreferences.getInt("show_rating_first_second_time", 0);
    String str1;
    String str2;
    Object localObject2;
    if (paramBoolean)
    {
      str1 = paramContext.getString(2131303704);
      localObject1 = paramContext.getString(2131303703);
      str2 = paramContext.getString(2131303702);
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = paramContext.getString(2131303699))
    {
      AlK = com.tencent.mm.ui.base.h.a(paramContext, false, str1, "", (String)localObject2, (String)localObject1, new l.3(localSharedPreferences, paramContext, bool, j, i), new l.4(localSharedPreferences, bool, j, i));
      AppMethodBeat.o(34586);
      return;
      str1 = paramContext.getString(2131303701);
      localObject2 = paramContext.getString(2131303700);
    }
  }
  
  public static void dMZ()
  {
    AppMethodBeat.i(34588);
    if (AlK != null)
    {
      AlK.dismiss();
      AlK = null;
    }
    AppMethodBeat.o(34588);
  }
  
  public static void ir(Context paramContext)
  {
    AppMethodBeat.i(34585);
    if (!com.tencent.mm.sdk.platformtools.g.dsn())
    {
      AppMethodBeat.o(34585);
      return;
    }
    Object localObject = com.tencent.mm.m.g.Nq().getValue("NewShowRating");
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(34585);
      return;
    }
    Map localMap = br.F((String)localObject, "ShowRatingNode");
    int m;
    label102:
    int n;
    if ((localMap == null) || (localMap.get(".ShowRatingNode.MinVer") == null))
    {
      localObject = "0";
      m = Integer.decode((String)localObject).intValue();
      if ((localMap != null) && (localMap.get(".ShowRatingNode.MaxVer") != null)) {
        break label181;
      }
      localObject = "0";
      n = Integer.decode((String)localObject).intValue();
      if ((localMap != null) && (localMap.get(".ShowRatingNode.WaitDays") != null)) {
        break label198;
      }
    }
    int k;
    label181:
    label198:
    for (localObject = "0";; localObject = (String)localMap.get(".ShowRatingNode.WaitDays"))
    {
      k = Integer.decode((String)localObject).intValue();
      if ((m <= d.whH) && (d.whH <= n)) {
        break label215;
      }
      AppMethodBeat.o(34585);
      return;
      localObject = (String)localMap.get(".ShowRatingNode.MinVer");
      break;
      localObject = (String)localMap.get(".ShowRatingNode.MaxVer");
      break label102;
    }
    label215:
    localObject = paramContext.getSharedPreferences("show_rating_preferences", 0);
    int j = ((SharedPreferences)localObject).getInt("show_rating_flag", 0);
    int i1 = ((SharedPreferences)localObject).getInt("show_rating_version", 0);
    long l1 = ((SharedPreferences)localObject).getLong("show_rating_timestamp", 0L);
    boolean bool = ((SharedPreferences)localObject).getBoolean("show_rating_again", false);
    long l2;
    if (k == 0)
    {
      i = 7;
      l2 = i * 86400000L;
      if ((i1 == 0) || (m > i1) || (i1 > n)) {
        break label611;
      }
    }
    label611:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ((SharedPreferences)localObject).edit().putInt("show_rating_version", d.whH).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 0).commit();
        j = 0;
        l1 = System.currentTimeMillis();
        ((SharedPreferences)localObject).edit().putLong("show_rating_timestamp", l1).commit();
        ((SharedPreferences)localObject).edit().putBoolean("show_rating_again", false).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_wait_days", k).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_first_second_time", (int)(System.currentTimeMillis() / 1000L)).commit();
        ab.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", new Object[] { Integer.valueOf(d.whH), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l2) });
      }
      if ((m > d.whH) || (d.whH > n) || (j != 0) || (l1 == 0L) || (System.currentTimeMillis() < l1 + l2)) {
        break label616;
      }
      ab.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
      AlK = com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131303705), "", paramContext.getString(2131303698), paramContext.getString(2131303697), new l.1((SharedPreferences)localObject, paramContext), new l.2((SharedPreferences)localObject, paramContext));
      AppMethodBeat.o(34585);
      return;
      i = k;
      break;
    }
    label616:
    if ((bool) && (l1 != 0L) && (System.currentTimeMillis() >= l1 + l2 + 345600000L))
    {
      ab.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
      C(paramContext, false);
      ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 3).commit();
      AppMethodBeat.o(34585);
      return;
    }
    if (j == 1)
    {
      C(paramContext, true);
      AppMethodBeat.o(34585);
      return;
    }
    if (j == 2)
    {
      is(paramContext);
      AppMethodBeat.o(34585);
      return;
    }
    if (j == 3) {
      C(paramContext, false);
    }
    AppMethodBeat.o(34585);
  }
  
  private static void is(final Context paramContext)
  {
    AppMethodBeat.i(34587);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("show_rating_preferences", 0);
    final int i = localSharedPreferences.getInt("show_rating_wait_days", 0);
    final int j = localSharedPreferences.getInt("show_rating_first_second_time", 0);
    AlK = com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131303708), "", paramContext.getString(2131303707), paramContext.getString(2131303706), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34583);
        this.AlL.edit().putInt("show_rating_flag", 4).commit();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        com.tencent.mm.pluginsdk.e.a(paramContext, (int)System.currentTimeMillis(), new byte[0], "weixin://dl/feedback");
        l.dNa();
        com.tencent.mm.plugin.report.service.h.qsU.e(11216, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(34583);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34584);
        this.AlL.edit().putInt("show_rating_flag", 4).commit();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        l.dNa();
        com.tencent.mm.plugin.report.service.h.qsU.e(11216, new Object[] { Integer.valueOf(1), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(34584);
      }
    });
    AppMethodBeat.o(34587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l
 * JD-Core Version:    0.7.0.1
 */