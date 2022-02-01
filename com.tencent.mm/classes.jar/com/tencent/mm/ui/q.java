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
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.c.c.a;
import com.tencent.mm.live.d.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ap;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashSet;
import java.util.LinkedList;

public final class q
{
  private static HashSet<a> OFt;
  private LiveTalkRoomTipsBar OFq;
  private LinkedList<com.tencent.mm.live.b.c.b> OFr;
  public b OFs;
  c.a hLf;
  String hwa;
  
  static
  {
    AppMethodBeat.i(232636);
    OFt = new HashSet();
    AppMethodBeat.o(232636);
  }
  
  public q(LiveTalkRoomTipsBar paramLiveTalkRoomTipsBar)
  {
    AppMethodBeat.i(232628);
    this.OFs = new b();
    this.hLf = new c.a()
    {
      public final void Ha(String paramAnonymousString)
      {
        AppMethodBeat.i(232617);
        if ((q.a(q.this) != null) && (q.a(q.this).equals(paramAnonymousString)))
        {
          Log.i("MicroMsg.LiveTalkRoomTipsBarController", "liveTipsBarStorage notify, hostRoomId:%s", new Object[] { q.a(q.this) });
          q.this.gIH();
          q.Pn(paramAnonymousString);
        }
        AppMethodBeat.o(232617);
      }
    };
    this.OFq = paramLiveTalkRoomTipsBar;
    gIH();
    AppMethodBeat.o(232628);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(232632);
    if (OFt != null) {
      OFt.add(parama);
    }
    AppMethodBeat.o(232632);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(232633);
    if (OFt != null) {
      OFt.remove(parama);
    }
    AppMethodBeat.o(232633);
  }
  
  public static void blO(String paramString)
  {
    AppMethodBeat.i(232631);
    com.tencent.mm.live.b.c.c localc = ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
    long l;
    boolean bool;
    if ((com.tencent.mm.live.b.c.c.hLd != null) && (((String)com.tencent.mm.live.b.c.c.hLd.first).equals(paramString)))
    {
      l = ((Long)com.tencent.mm.live.b.c.c.hLd.second).longValue();
      String str = String.format("DELETE FROM %s WHERE %s = '%s' AND %s != '%s'", new Object[] { "LiveTipsBar", "hostRoomId", paramString, "liveId", com.tencent.mm.live.b.c.c.hLd.second });
      bool = localc.db.execSQL("LiveTipsBar", str);
      if (!bool) {
        Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      }
    }
    for (;;)
    {
      if (localc.hLf != null) {
        localc.hLf.Ha(paramString);
      }
      AppMethodBeat.o(232631);
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
  
  public static LinkedList<com.tencent.mm.live.b.c.b> blP(String paramString)
  {
    AppMethodBeat.i(232634);
    paramString = ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().GX(paramString);
    AppMethodBeat.o(232634);
    return paramString;
  }
  
  public static void gIG()
  {
    AppMethodBeat.i(232629);
    ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().hLf = null;
    AppMethodBeat.o(232629);
  }
  
  public final boolean blN(String paramString)
  {
    AppMethodBeat.i(232627);
    if ((this.hwa != null) && (this.hwa.equals(paramString)))
    {
      AppMethodBeat.o(232627);
      return true;
    }
    AppMethodBeat.o(232627);
    return false;
  }
  
  public final LinkedList<com.tencent.mm.live.b.c.b> gIH()
  {
    AppMethodBeat.i(232630);
    this.OFr = ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().GX(this.hwa);
    LinkedList localLinkedList = this.OFr;
    AppMethodBeat.o(232630);
    return localLinkedList;
  }
  
  public static abstract interface a
  {
    public abstract void blQ(String paramString);
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.live.b.c.b akV(int paramInt)
    {
      AppMethodBeat.i(232624);
      if (q.b(q.this) == null)
      {
        AppMethodBeat.o(232624);
        return null;
      }
      com.tencent.mm.live.b.c.b localb = (com.tencent.mm.live.b.c.b)q.b(q.this).get(paramInt);
      AppMethodBeat.o(232624);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(232623);
      if (q.b(q.this) != null)
      {
        int i = q.b(q.this).size();
        AppMethodBeat.o(232623);
        return i;
      }
      AppMethodBeat.o(232623);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(232625);
      View localView;
      final com.tencent.mm.live.b.c.b localb;
      TextView localTextView;
      StringBuilder localStringBuilder;
      Context localContext;
      String str2;
      String str3;
      if (paramView == null)
      {
        localView = LayoutInflater.from(q.c(q.this).context).inflate(2131495283, paramViewGroup, false);
        paramViewGroup = new q.c(q.this);
        paramViewGroup.OFA = ((LinearLayout)localView.findViewById(2131303578));
        paramViewGroup.OFB = ((WeImageView)localView.findViewById(2131303577));
        paramViewGroup.OFe = ((RelativeLayout)localView.findViewById(2131303579));
        paramViewGroup.OFC = ((TextView)localView.findViewById(2131303585));
        paramViewGroup.OFD = ((TextView)localView.findViewById(2131303576));
        localView.setTag(paramViewGroup);
        localb = akV(paramInt);
        if (localb != null)
        {
          a.b.c(paramViewGroup.OFB, localb.field_anchorUsername);
          paramViewGroup.OFC.setText(l.c(q.c(q.this).context, localb.field_liveName));
          localTextView = paramViewGroup.OFD;
          localStringBuilder = new StringBuilder("主播：");
          localContext = q.c(q.this).context;
          str2 = localb.field_anchorUsername;
          str3 = q.a(q.this);
          if (str2 != null) {
            break label302;
          }
          paramView = "";
        }
      }
      for (;;)
      {
        localTextView.setText(l.b(localContext, paramView, paramViewGroup.OFD.getTextSize()));
        paramViewGroup.OFA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(232620);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
            Object localObject2;
            int i;
            if (localb != null)
            {
              paramAnonymousView = q.c(q.this);
              localObject1 = localb;
              localObject2 = new LiveConfig.a();
              if ((((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.q.a.o(paramAnonymousView.context, true)) && (!com.tencent.mm.q.a.cC(paramAnonymousView.context)) && (!com.tencent.mm.q.a.cA(paramAnonymousView.context)) && (!com.tencent.mm.q.a.cE(paramAnonymousView.context))))
              {
                if (!((com.tencent.mm.live.b.c.b)localObject1).field_isSender) {
                  break label290;
                }
                i = LiveConfig.hvT;
                ((LiveConfig.a)localObject2).hvZ = i;
                ((LiveConfig.a)localObject2).thumbUrl = ((com.tencent.mm.live.b.c.b)localObject1).field_thumbUrl;
                ((LiveConfig.a)localObject2).hwa = ((com.tencent.mm.live.b.c.b)localObject1).field_hostRoomId;
                ((LiveConfig.a)localObject2).liveId = ((com.tencent.mm.live.b.c.b)localObject1).field_liveId;
                ((LiveConfig.a)localObject2).hwb = ((com.tencent.mm.live.b.c.b)localObject1).field_liveName;
                ((LiveConfig.a)localObject2).fromScene = LiveConfig.hvW;
                ((LiveConfig.a)localObject2).hwd = ((com.tencent.mm.live.b.c.b)localObject1).field_anchorUsername;
                localObject2 = ((LiveConfig.a)localObject2).aBR();
                if (!((com.tencent.mm.live.b.c.b)localObject1).field_isSender) {
                  break label297;
                }
                ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(paramAnonymousView.context, (LiveConfig)localObject2);
              }
            }
            for (;;)
            {
              if (q.c(q.this) != null) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(232619);
                    if (q.c(q.this) != null) {
                      q.c(q.this).bc(true, false);
                    }
                    AppMethodBeat.o(232619);
                  }
                });
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(232620);
              return;
              label290:
              i = LiveConfig.hvU;
              break;
              label297:
              f.aIM();
              ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().b(paramAnonymousView.context, (LiveConfig)localObject2);
            }
          }
        });
        paramViewGroup.OFe.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(232622);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = (com.tencent.mm.live.b.c.b)q.b(q.this).get(paramInt);
            ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().zF(paramAnonymousView.field_liveId);
            q.this.gIH();
            if (q.c(q.this) != null) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(232621);
                  if (q.c(q.this) != null) {
                    q.c(q.this).gIE();
                  }
                  AppMethodBeat.o(232621);
                }
              });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232622);
          }
        });
        AppMethodBeat.o(232625);
        return localView;
        paramViewGroup = (q.c)paramView.getTag();
        localView = paramView;
        break;
        label302:
        String str1 = aa.Is(str2);
        paramView = str1;
        if (Util.isNullOrNil(str1))
        {
          paramView = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str3);
          if (paramView == null)
          {
            paramView = aa.getDisplayName(str2);
          }
          else
          {
            str1 = paramView.getDisplayName(str2);
            paramView = str1;
            if (Util.isNullOrNil(str1)) {
              paramView = aa.getDisplayName(str2);
            }
          }
        }
      }
    }
  }
  
  final class c
  {
    LinearLayout OFA;
    WeImageView OFB;
    TextView OFC;
    TextView OFD;
    RelativeLayout OFe;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.q
 * JD-Core Version:    0.7.0.1
 */