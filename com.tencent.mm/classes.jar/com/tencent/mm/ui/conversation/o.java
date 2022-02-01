package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class o
{
  private static com.tencent.mm.ui.widget.a.d Kxu = null;
  
  private static void I(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(38716);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("show_rating_preferences", 0);
    final boolean bool = localSharedPreferences.getBoolean("show_rating_again", false);
    final int i = localSharedPreferences.getInt("show_rating_wait_days", 0);
    final int j = localSharedPreferences.getInt("show_rating_first_second_time", 0);
    String str1;
    String str2;
    Object localObject2;
    if (paramBoolean)
    {
      str1 = paramContext.getString(2131763687);
      localObject1 = paramContext.getString(2131763686);
      str2 = paramContext.getString(2131763685);
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = paramContext.getString(2131763682))
    {
      Kxu = h.a(paramContext, false, str1, "", (String)localObject2, (String)localObject1, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38711);
          this.Kxv.edit().putInt("show_rating_flag", 4).commit();
          Object localObject2 = "market://details?id=" + aj.getPackageName();
          Object localObject1 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject1).setData(Uri.parse((String)localObject2));
          localObject2 = paramContext;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/conversation/RatingDialogHelper$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/conversation/RatingDialogHelper$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ad.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          this.Kxv.edit().putBoolean("show_rating_again", false).commit();
          o.fJx();
          if (bool)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(11216, new Object[] { Integer.valueOf(5), Integer.valueOf(j), Integer.valueOf(i) });
            AppMethodBeat.o(38711);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(11216, new Object[] { Integer.valueOf(4), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(38711);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38712);
          this.Kxv.edit().putInt("show_rating_flag", 4).commit();
          if (bool)
          {
            this.Kxv.edit().putBoolean("show_rating_again", false).commit();
            com.tencent.mm.plugin.report.service.g.yhR.f(11216, new Object[] { Integer.valueOf(3), Integer.valueOf(j), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            o.fJx();
            AppMethodBeat.o(38712);
            return;
            ad.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
            this.Kxv.edit().putBoolean("show_rating_again", true).commit();
            com.tencent.mm.plugin.report.service.g.yhR.f(11216, new Object[] { Integer.valueOf(6), Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      });
      AppMethodBeat.o(38716);
      return;
      str1 = paramContext.getString(2131763684);
      localObject2 = paramContext.getString(2131763683);
    }
  }
  
  public static void fJw()
  {
    AppMethodBeat.i(38718);
    if (Kxu != null)
    {
      Kxu.dismiss();
      Kxu = null;
    }
    AppMethodBeat.o(38718);
  }
  
  public static void kq(final Context paramContext)
  {
    AppMethodBeat.i(38715);
    if (!j.fjZ())
    {
      AppMethodBeat.o(38715);
      return;
    }
    Object localObject = com.tencent.mm.n.g.acA().getValue("NewShowRating");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(38715);
      return;
    }
    Map localMap = bw.M((String)localObject, "ShowRatingNode");
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
      if ((m <= com.tencent.mm.protocal.d.Fnj) && (com.tencent.mm.protocal.d.Fnj <= n)) {
        break label215;
      }
      AppMethodBeat.o(38715);
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
        ((SharedPreferences)localObject).edit().putInt("show_rating_version", com.tencent.mm.protocal.d.Fnj).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 0).commit();
        j = 0;
        l1 = System.currentTimeMillis();
        ((SharedPreferences)localObject).edit().putLong("show_rating_timestamp", l1).commit();
        ((SharedPreferences)localObject).edit().putBoolean("show_rating_again", false).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_wait_days", k).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_first_second_time", (int)(System.currentTimeMillis() / 1000L)).commit();
        ad.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Fnj), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l2) });
      }
      if ((m > com.tencent.mm.protocal.d.Fnj) || (com.tencent.mm.protocal.d.Fnj > n) || (j != 0) || (l1 == 0L) || (System.currentTimeMillis() < l1 + l2)) {
        break label616;
      }
      ad.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
      Kxu = h.a(paramContext, false, paramContext.getString(2131763688), "", paramContext.getString(2131763681), paramContext.getString(2131763680), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38709);
          this.Kxv.edit().putInt("show_rating_flag", 1).commit();
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          o.fJx();
          o.ks(paramContext);
          ad.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
          AppMethodBeat.o(38709);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38710);
          this.Kxv.edit().putInt("show_rating_flag", 2).commit();
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          o.fJx();
          o.kt(paramContext);
          ad.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
          AppMethodBeat.o(38710);
        }
      });
      AppMethodBeat.o(38715);
      return;
      i = k;
      break;
    }
    label616:
    if ((bool) && (l1 != 0L) && (System.currentTimeMillis() >= l1 + l2 + 345600000L))
    {
      ad.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
      I(paramContext, false);
      ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 3).commit();
      AppMethodBeat.o(38715);
      return;
    }
    if (j == 1)
    {
      I(paramContext, true);
      AppMethodBeat.o(38715);
      return;
    }
    if (j == 2)
    {
      kr(paramContext);
      AppMethodBeat.o(38715);
      return;
    }
    if (j == 3) {
      I(paramContext, false);
    }
    AppMethodBeat.o(38715);
  }
  
  private static void kr(final Context paramContext)
  {
    AppMethodBeat.i(38717);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("show_rating_preferences", 0);
    final int i = localSharedPreferences.getInt("show_rating_wait_days", 0);
    final int j = localSharedPreferences.getInt("show_rating_first_second_time", 0);
    Kxu = h.a(paramContext, false, paramContext.getString(2131763691), "", paramContext.getString(2131763690), paramContext.getString(2131763689), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(38713);
        this.Kxv.edit().putInt("show_rating_flag", 4).commit();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        com.tencent.mm.pluginsdk.g.a(paramContext, (int)System.currentTimeMillis(), new byte[0], "weixin://dl/feedback");
        o.fJx();
        com.tencent.mm.plugin.report.service.g.yhR.f(11216, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(38713);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(38714);
        this.Kxv.edit().putInt("show_rating_flag", 4).commit();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        o.fJx();
        com.tencent.mm.plugin.report.service.g.yhR.f(11216, new Object[] { Integer.valueOf(1), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(38714);
      }
    });
    AppMethodBeat.o(38717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.o
 * JD-Core Version:    0.7.0.1
 */