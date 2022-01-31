package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.R.l;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;
import java.util.Map;

public final class m
{
  private static c vTO = null;
  
  public static void cIt()
  {
    if (vTO != null)
    {
      vTO.dismiss();
      vTO = null;
    }
  }
  
  public static void gW(final Context paramContext)
  {
    if (!com.tencent.mm.sdk.platformtools.e.cqq()) {}
    label86:
    label117:
    int j;
    label205:
    label592:
    do
    {
      Map localMap;
      int m;
      int n;
      int k;
      do
      {
        do
        {
          return;
          localObject = g.AA().getValue("NewShowRating");
        } while (bk.bl((String)localObject));
        localMap = bn.s((String)localObject, "ShowRatingNode");
        if ((localMap != null) && (localMap.get(".ShowRatingNode.MinVer") != null)) {
          break;
        }
        localObject = "0";
        m = Integer.decode((String)localObject).intValue();
        if ((localMap != null) && (localMap.get(".ShowRatingNode.MaxVer") != null)) {
          break label548;
        }
        localObject = "0";
        n = Integer.decode((String)localObject).intValue();
        if ((localMap != null) && (localMap.get(".ShowRatingNode.WaitDays") != null)) {
          break label565;
        }
        localObject = "0";
        k = Integer.decode((String)localObject).intValue();
      } while ((m > com.tencent.mm.protocal.d.spa) || (com.tencent.mm.protocal.d.spa > n));
      Object localObject = paramContext.getSharedPreferences("show_rating_preferences", 0);
      j = ((SharedPreferences)localObject).getInt("show_rating_flag", 0);
      int i1 = ((SharedPreferences)localObject).getInt("show_rating_version", 0);
      long l1 = ((SharedPreferences)localObject).getLong("show_rating_timestamp", 0L);
      boolean bool = ((SharedPreferences)localObject).getBoolean("show_rating_again", false);
      long l2;
      if (k == 0)
      {
        i = 7;
        l2 = i * 86400000L;
        if ((i1 == 0) || (m > i1) || (i1 > n)) {
          break label587;
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0)
        {
          ((SharedPreferences)localObject).edit().putInt("show_rating_version", com.tencent.mm.protocal.d.spa).commit();
          ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 0).commit();
          j = 0;
          l1 = System.currentTimeMillis();
          ((SharedPreferences)localObject).edit().putLong("show_rating_timestamp", l1).commit();
          ((SharedPreferences)localObject).edit().putBoolean("show_rating_again", false).commit();
          ((SharedPreferences)localObject).edit().putInt("show_rating_wait_days", k).commit();
          ((SharedPreferences)localObject).edit().putInt("show_rating_first_second_time", (int)(System.currentTimeMillis() / 1000L)).commit();
          y.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.spa), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l2) });
        }
        if ((m > com.tencent.mm.protocal.d.spa) || (com.tencent.mm.protocal.d.spa > n) || (j != 0) || (l1 == 0L) || (System.currentTimeMillis() < l1 + l2)) {
          break label592;
        }
        y.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
        vTO = com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(R.l.show_rating_enjoy_dialog_wording), "", paramContext.getString(R.l.show_rating_button_yes), paramContext.getString(R.l.show_rating_button_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            this.vTP.edit().putInt("show_rating_flag", 1).commit();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            m.cIu();
            m.gY(paramContext);
            y.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            this.vTP.edit().putInt("show_rating_flag", 2).commit();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            m.cIu();
            m.gZ(paramContext);
            y.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
          }
        });
        return;
        localObject = (String)localMap.get(".ShowRatingNode.MinVer");
        break;
        localObject = (String)localMap.get(".ShowRatingNode.MaxVer");
        break label86;
        localObject = (String)localMap.get(".ShowRatingNode.WaitDays");
        break label117;
        i = k;
        break label205;
      }
      if ((bool) && (l1 != 0L) && (System.currentTimeMillis() >= l1 + l2 + 345600000L))
      {
        y.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
        w(paramContext, false);
        ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 3).commit();
        return;
      }
      if (j == 1)
      {
        w(paramContext, true);
        return;
      }
      if (j == 2)
      {
        gX(paramContext);
        return;
      }
    } while (j != 3);
    label548:
    label565:
    label587:
    w(paramContext, false);
  }
  
  private static void gX(final Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("show_rating_preferences", 0);
    final int i = localSharedPreferences.getInt("show_rating_wait_days", 0);
    final int j = localSharedPreferences.getInt("show_rating_first_second_time", 0);
    vTO = com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(R.l.show_rating_feedback_dialog_wording), "", paramContext.getString(R.l.show_rating_feedback_dialog_button_yes), paramContext.getString(R.l.show_rating_feedback_dialog_button_no), new DialogInterface.OnClickListener()new m.6
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.vTP.edit().putInt("show_rating_flag", 4).commit();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        com.tencent.mm.pluginsdk.d.a(paramContext, (int)System.currentTimeMillis(), new byte[0], "weixin://dl/feedback");
        m.cIu();
        com.tencent.mm.plugin.report.service.h.nFQ.f(11216, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }, new m.6(localSharedPreferences, j, i));
  }
  
  private static void w(Context paramContext, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("show_rating_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean("show_rating_again", false);
    int i = localSharedPreferences.getInt("show_rating_wait_days", 0);
    int j = localSharedPreferences.getInt("show_rating_first_second_time", 0);
    String str1;
    String str2;
    Object localObject2;
    if (paramBoolean)
    {
      str1 = paramContext.getString(R.l.show_rating_dialog_wording);
      localObject1 = paramContext.getString(R.l.show_rating_dialog_button_yes);
      str2 = paramContext.getString(R.l.show_rating_dialog_button_no);
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = paramContext.getString(R.l.show_rating_dialog_again_button_no))
    {
      vTO = com.tencent.mm.ui.base.h.a(paramContext, false, str1, "", (String)localObject2, (String)localObject1, new m.3(localSharedPreferences, paramContext, bool, j, i), new m.4(localSharedPreferences, bool, j, i));
      return;
      str1 = paramContext.getString(R.l.show_rating_dialog_again_wording);
      localObject2 = paramContext.getString(R.l.show_rating_dialog_again_button_yes);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m
 * JD-Core Version:    0.7.0.1
 */