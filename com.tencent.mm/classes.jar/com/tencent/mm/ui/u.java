package com.tencent.mm.ui;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.c.f;
import com.tencent.mm.live.model.c.c;
import com.tencent.mm.live.model.c.c.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.report.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashSet;
import java.util.LinkedList;

public final class u
{
  private static HashSet<a> adDj;
  private LiveTalkRoomTipsBar adDg;
  private LinkedList<com.tencent.mm.live.model.c.b> adDh;
  public b adDi;
  String mIz;
  c.a nbW;
  
  static
  {
    AppMethodBeat.i(249221);
    adDj = new HashSet();
    AppMethodBeat.o(249221);
  }
  
  public u(LiveTalkRoomTipsBar paramLiveTalkRoomTipsBar)
  {
    AppMethodBeat.i(249179);
    this.adDi = new b();
    this.nbW = new c.a()
    {
      public final void Gy(String paramAnonymousString)
      {
        AppMethodBeat.i(249592);
        if ((u.a(u.this) != null) && (u.a(u.this).equals(paramAnonymousString)))
        {
          Log.i("MicroMsg.LiveTalkRoomTipsBarController", "liveTipsBarStorage notify, hostRoomId:%s", new Object[] { u.a(u.this) });
          u.this.jjH();
          u.OJ(paramAnonymousString);
        }
        AppMethodBeat.o(249592);
      }
    };
    this.adDg = paramLiveTalkRoomTipsBar;
    jjH();
    AppMethodBeat.o(249179);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(249190);
    if (adDj != null) {
      adDj.add(parama);
    }
    AppMethodBeat.o(249190);
  }
  
  private static String aV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249202);
    if (paramString1 == null)
    {
      AppMethodBeat.o(249202);
      return "";
    }
    String str2 = aa.IE(paramString1);
    String str1 = str2;
    if (Util.isNullOrNil(str2))
    {
      paramString2 = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString2);
      if (paramString2 != null) {
        break label67;
      }
      str1 = aa.getDisplayName(paramString1);
    }
    for (;;)
    {
      AppMethodBeat.o(249202);
      return str1;
      label67:
      paramString2 = paramString2.getDisplayName(paramString1);
      str1 = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        str1 = aa.getDisplayName(paramString1);
      }
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(249196);
    if (adDj != null) {
      adDj.remove(parama);
    }
    AppMethodBeat.o(249196);
  }
  
  public static void bzJ(String paramString)
  {
    AppMethodBeat.i(249185);
    c localc = ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
    long l;
    boolean bool;
    if ((c.nbU != null) && (((String)c.nbU.first).equals(paramString)))
    {
      l = ((Long)c.nbU.second).longValue();
      String str = String.format("DELETE FROM %s WHERE %s = '%s' AND %s != '%s'", new Object[] { "LiveTipsBar", "hostRoomId", paramString, "liveId", c.nbU.second });
      bool = localc.db.execSQL("LiveTipsBar", str);
      if (!bool) {
        Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      }
    }
    for (;;)
    {
      if (localc.nbW != null) {
        localc.nbW.Gy(paramString);
      }
      AppMethodBeat.o(249185);
      return;
      Log.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      continue;
      int i = localc.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
      if (i < 0) {
        Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      } else {
        Log.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      }
    }
  }
  
  public static LinkedList<com.tencent.mm.live.model.c.b> bzK(String paramString)
  {
    AppMethodBeat.i(249198);
    paramString = ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Gv(paramString);
    AppMethodBeat.o(249198);
    return paramString;
  }
  
  public static void jjG()
  {
    AppMethodBeat.i(249180);
    ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().nbW = null;
    AppMethodBeat.o(249180);
  }
  
  public final boolean bzI(String paramString)
  {
    AppMethodBeat.i(249223);
    if ((this.mIz != null) && (this.mIz.equals(paramString)))
    {
      AppMethodBeat.o(249223);
      return true;
    }
    AppMethodBeat.o(249223);
    return false;
  }
  
  public final String c(LinkedList<com.tencent.mm.live.model.c.b> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(249229);
    if (paramLinkedList.size() == 1)
    {
      if (paramBoolean1) {}
      for (i = R.l.live_tipsbar_other_one_live;; i = R.l.live_tipsbar_one_live)
      {
        paramLinkedList = this.adDg.context.getString(i, new Object[] { aV(((com.tencent.mm.live.model.c.b)paramLinkedList.get(0)).field_anchorUsername, this.mIz) });
        AppMethodBeat.o(249229);
        return paramLinkedList;
      }
    }
    if (paramBoolean2) {}
    for (int i = R.l.live_tipsbar_other_lives;; i = R.l.live_tipsbar_total_lives)
    {
      paramLinkedList = this.adDg.context.getString(i, new Object[] { Integer.valueOf(paramLinkedList.size()) });
      AppMethodBeat.o(249229);
      return paramLinkedList;
    }
  }
  
  public final LinkedList<com.tencent.mm.live.model.c.b> jjH()
  {
    AppMethodBeat.i(249225);
    this.adDh = ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Gv(this.mIz);
    LinkedList localLinkedList = this.adDh;
    AppMethodBeat.o(249225);
    return localLinkedList;
  }
  
  public final int jjI()
  {
    AppMethodBeat.i(249226);
    if (this.adDh != null)
    {
      int i = this.adDh.size();
      AppMethodBeat.o(249226);
      return i;
    }
    AppMethodBeat.o(249226);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void bzL(String paramString);
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.live.model.c.b aAh(int paramInt)
    {
      AppMethodBeat.i(249451);
      if (u.b(u.this) == null)
      {
        AppMethodBeat.o(249451);
        return null;
      }
      com.tencent.mm.live.model.c.b localb = (com.tencent.mm.live.model.c.b)u.b(u.this).get(paramInt);
      AppMethodBeat.o(249451);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(249454);
      if (u.b(u.this) != null)
      {
        int i = u.b(u.this).size();
        AppMethodBeat.o(249454);
        return i;
      }
      AppMethodBeat.o(249454);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(249464);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(u.c(u.this).context).inflate(R.i.live_talkroom_tipsbar_item, paramViewGroup, false);
        paramViewGroup = new u.c(u.this);
        paramViewGroup.adDq = ((LinearLayout)paramView.findViewById(R.h.live_tipsbar_click_area));
        paramViewGroup.adDr = ((WeImageView)paramView.findViewById(R.h.live_tipsbar_avatar));
        paramViewGroup.adCV = ((RelativeLayout)paramView.findViewById(R.h.live_tipsbar_close_btn));
        paramViewGroup.adDs = ((TextView)paramView.findViewById(R.h.live_tipsbar_livename));
        paramViewGroup.adDt = ((TextView)paramView.findViewById(R.h.live_tipsbar_anchor));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        final com.tencent.mm.live.model.c.b localb = aAh(paramInt);
        if (localb != null)
        {
          a.b.g(paramViewGroup.adDr, localb.field_anchorUsername);
          paramViewGroup.adDs.setText(p.b(u.c(u.this).context, localb.field_liveName));
          paramViewGroup.adDt.setText("主播：" + p.b(u.c(u.this).context, u.pU(localb.field_anchorUsername, u.a(u.this)), paramViewGroup.adDt.getTextSize()));
        }
        paramViewGroup.adDq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(249805);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
            if (localb != null)
            {
              paramAnonymousView = d.afBU;
              d.a(u.a(u.this), u.this.jjI(), String.valueOf(localb.field_liveId), 4L, System.currentTimeMillis());
            }
            Object localObject2;
            int i;
            if (localb != null)
            {
              paramAnonymousView = u.c(u.this);
              localObject1 = localb;
              localObject2 = new LiveConfig.a();
              if ((((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.n.a.p(paramAnonymousView.context, true)) && (!com.tencent.mm.n.a.dm(paramAnonymousView.context)) && (!com.tencent.mm.n.a.dl(paramAnonymousView.context)) && (!com.tencent.mm.n.a.dp(paramAnonymousView.context))))
              {
                if (!((com.tencent.mm.live.model.c.b)localObject1).field_isSender) {
                  break label341;
                }
                i = LiveConfig.mIs;
                ((LiveConfig.a)localObject2).mIy = i;
                ((LiveConfig.a)localObject2).thumbUrl = ((com.tencent.mm.live.model.c.b)localObject1).field_thumbUrl;
                ((LiveConfig.a)localObject2).mIz = ((com.tencent.mm.live.model.c.b)localObject1).field_hostRoomId;
                ((LiveConfig.a)localObject2).liveId = ((com.tencent.mm.live.model.c.b)localObject1).field_liveId;
                ((LiveConfig.a)localObject2).mIA = ((com.tencent.mm.live.model.c.b)localObject1).field_liveName;
                ((LiveConfig.a)localObject2).fromScene = LiveConfig.mIv;
                ((LiveConfig.a)localObject2).mIC = ((com.tencent.mm.live.model.c.b)localObject1).field_anchorUsername;
                localObject2 = ((LiveConfig.a)localObject2).bcd();
                if (!((com.tencent.mm.live.model.c.b)localObject1).field_isSender) {
                  break label348;
                }
                ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).liveEntranceJumper().c(paramAnonymousView.context, (LiveConfig)localObject2);
              }
            }
            for (;;)
            {
              if (u.c(u.this) != null) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(250707);
                    if (u.c(u.this) != null) {
                      u.c(u.this).bK(true, false);
                    }
                    AppMethodBeat.o(250707);
                  }
                });
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(249805);
              return;
              label341:
              i = LiveConfig.mIt;
              break;
              label348:
              f.bkx();
              ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).liveEntranceJumper().b(paramAnonymousView.context, (LiveConfig)localObject2);
            }
          }
        });
        paramViewGroup.adCV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(249804);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = (com.tencent.mm.live.model.c.b)u.b(u.this).get(paramInt);
            localObject = d.afBU;
            d.a(u.a(u.this), u.this.jjI(), String.valueOf(paramAnonymousView.field_liveId), 3L, System.currentTimeMillis());
            ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().hT(paramAnonymousView.field_liveId);
            u.this.jjH();
            if (u.c(u.this) != null) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(249471);
                  if (u.c(u.this) != null) {
                    u.c(u.this).jjC();
                  }
                  AppMethodBeat.o(249471);
                }
              });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(249804);
          }
        });
        AppMethodBeat.o(249464);
        return paramView;
        paramViewGroup = (u.c)paramView.getTag();
      }
    }
  }
  
  final class c
  {
    RelativeLayout adCV;
    LinearLayout adDq;
    WeImageView adDr;
    TextView adDs;
    TextView adDt;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.u
 * JD-Core Version:    0.7.0.1
 */