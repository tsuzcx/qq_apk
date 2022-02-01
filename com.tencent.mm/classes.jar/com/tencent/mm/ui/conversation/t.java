package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import java.util.Map;

public final class t
{
  private static e afsd = null;
  
  private static void X(final Context paramContext, boolean paramBoolean)
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
      str1 = paramContext.getString(R.l.show_rating_dialog_wording);
      localObject1 = paramContext.getString(R.l.show_rating_dialog_button_yes);
      str2 = paramContext.getString(R.l.show_rating_dialog_button_no);
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = paramContext.getString(R.l.show_rating_dialog_again_button_no))
    {
      afsd = k.a(paramContext, false, str1, "", (String)localObject2, (String)localObject1, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38711);
          t.this.edit().putInt("show_rating_flag", 4).commit();
          Object localObject2 = "market://details?id=" + MMApplicationContext.getPackageName();
          Object localObject1 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject1).setData(Uri.parse((String)localObject2));
          localObject2 = paramContext;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/conversation/RatingDialogHelper$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/conversation/RatingDialogHelper$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          Log.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          t.this.edit().putBoolean("show_rating_again", false).commit();
          t.jBd();
          if (bool)
          {
            h.OAn.b(11216, new Object[] { Integer.valueOf(5), Integer.valueOf(j), Integer.valueOf(i) });
            AppMethodBeat.o(38711);
            return;
          }
          h.OAn.b(11216, new Object[] { Integer.valueOf(4), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(38711);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38712);
          t.this.edit().putInt("show_rating_flag", 4).commit();
          if (bool)
          {
            t.this.edit().putBoolean("show_rating_again", false).commit();
            h.OAn.b(11216, new Object[] { Integer.valueOf(3), Integer.valueOf(j), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            t.jBd();
            AppMethodBeat.o(38712);
            return;
            Log.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
            t.this.edit().putBoolean("show_rating_again", true).commit();
            h.OAn.b(11216, new Object[] { Integer.valueOf(6), Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      });
      AppMethodBeat.o(38716);
      return;
      str1 = paramContext.getString(R.l.show_rating_dialog_again_wording);
      localObject2 = paramContext.getString(R.l.show_rating_dialog_again_button_yes);
    }
  }
  
  public static void jBc()
  {
    AppMethodBeat.i(38718);
    if (afsd != null)
    {
      afsd.dismiss();
      afsd = null;
    }
    AppMethodBeat.o(38718);
  }
  
  public static void nu(final Context paramContext)
  {
    AppMethodBeat.i(38715);
    if (!ChannelUtil.isGPVersion())
    {
      AppMethodBeat.o(38715);
      return;
    }
    Object localObject = i.aRC().getValue("NewShowRating");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(38715);
      return;
    }
    Map localMap = XmlParser.parseXml((String)localObject, "ShowRatingNode", "utf-8");
    int m;
    label104:
    int n;
    if ((localMap == null) || (localMap.get(".ShowRatingNode.MinVer") == null))
    {
      localObject = "0";
      m = Integer.decode((String)localObject).intValue();
      if ((localMap != null) && (localMap.get(".ShowRatingNode.MaxVer") != null)) {
        break label183;
      }
      localObject = "0";
      n = Integer.decode((String)localObject).intValue();
      if ((localMap != null) && (localMap.get(".ShowRatingNode.WaitDays") != null)) {
        break label200;
      }
    }
    int k;
    label183:
    label200:
    for (localObject = "0";; localObject = (String)localMap.get(".ShowRatingNode.WaitDays"))
    {
      k = Integer.decode((String)localObject).intValue();
      if ((m <= d.Yxh) && (d.Yxh <= n)) {
        break label217;
      }
      AppMethodBeat.o(38715);
      return;
      localObject = (String)localMap.get(".ShowRatingNode.MinVer");
      break;
      localObject = (String)localMap.get(".ShowRatingNode.MaxVer");
      break label104;
    }
    label217:
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
        break label616;
      }
    }
    label616:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ((SharedPreferences)localObject).edit().putInt("show_rating_version", d.Yxh).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 0).commit();
        j = 0;
        l1 = System.currentTimeMillis();
        ((SharedPreferences)localObject).edit().putLong("show_rating_timestamp", l1).commit();
        ((SharedPreferences)localObject).edit().putBoolean("show_rating_again", false).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_wait_days", k).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_first_second_time", (int)(System.currentTimeMillis() / 1000L)).commit();
        Log.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", new Object[] { Integer.valueOf(d.Yxh), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l2) });
      }
      if ((m > d.Yxh) || (d.Yxh > n) || (j != 0) || (l1 == 0L) || (System.currentTimeMillis() < l1 + l2)) {
        break label621;
      }
      Log.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
      afsd = k.a(paramContext, false, paramContext.getString(R.l.show_rating_enjoy_dialog_wording), "", paramContext.getString(R.l.show_rating_button_yes), paramContext.getString(R.l.show_rating_button_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38709);
          t.this.edit().putInt("show_rating_flag", 1).commit();
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          t.jBd();
          t.nw(paramContext);
          Log.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
          AppMethodBeat.o(38709);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38710);
          t.this.edit().putInt("show_rating_flag", 2).commit();
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          t.jBd();
          t.access$200(paramContext);
          Log.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
          AppMethodBeat.o(38710);
        }
      });
      AppMethodBeat.o(38715);
      return;
      i = k;
      break;
    }
    label621:
    if ((bool) && (l1 != 0L) && (System.currentTimeMillis() >= l1 + l2 + 345600000L))
    {
      Log.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
      X(paramContext, false);
      ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 3).commit();
      AppMethodBeat.o(38715);
      return;
    }
    if (j == 1)
    {
      X(paramContext, true);
      AppMethodBeat.o(38715);
      return;
    }
    if (j == 2)
    {
      nv(paramContext);
      AppMethodBeat.o(38715);
      return;
    }
    if (j == 3) {
      X(paramContext, false);
    }
    AppMethodBeat.o(38715);
  }
  
  private static void nv(final Context paramContext)
  {
    AppMethodBeat.i(38717);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("show_rating_preferences", 0);
    final int i = localSharedPreferences.getInt("show_rating_wait_days", 0);
    final int j = localSharedPreferences.getInt("show_rating_first_second_time", 0);
    afsd = k.a(paramContext, false, paramContext.getString(R.l.show_rating_feedback_dialog_wording), "", paramContext.getString(R.l.show_rating_feedback_dialog_button_yes), paramContext.getString(R.l.show_rating_feedback_dialog_button_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(38713);
        t.this.edit().putInt("show_rating_flag", 4).commit();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        g.a(paramContext, n.bMd(), new byte[0], "weixin://dl/feedback");
        t.jBd();
        h.OAn.b(11216, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(38713);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(38714);
        t.this.edit().putInt("show_rating_flag", 4).commit();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        t.jBd();
        h.OAn.b(11216, new Object[] { Integer.valueOf(1), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(38714);
      }
    });
    AppMethodBeat.o(38717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.t
 * JD-Core Version:    0.7.0.1
 */