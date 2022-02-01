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
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.c.c;
import com.tencent.mm.live.b.c.c.a;
import com.tencent.mm.live.d.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.aq;
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

public final class s
{
  private static HashSet<a> VYO;
  private LiveTalkRoomTipsBar VYL;
  private LinkedList<com.tencent.mm.live.b.c.b> VYM;
  public b VYN;
  String kid;
  c.a kyz;
  
  static
  {
    AppMethodBeat.i(281219);
    VYO = new HashSet();
    AppMethodBeat.o(281219);
  }
  
  public s(LiveTalkRoomTipsBar paramLiveTalkRoomTipsBar)
  {
    AppMethodBeat.i(281207);
    this.VYN = new b();
    this.kyz = new c.a()
    {
      public final void Ol(String paramAnonymousString)
      {
        AppMethodBeat.i(279027);
        if ((s.a(s.this) != null) && (s.a(s.this).equals(paramAnonymousString)))
        {
          Log.i("MicroMsg.LiveTalkRoomTipsBarController", "liveTipsBarStorage notify, hostRoomId:%s", new Object[] { s.a(s.this) });
          s.this.hHw();
          s.WK(paramAnonymousString);
        }
        AppMethodBeat.o(279027);
      }
    };
    this.VYL = paramLiveTalkRoomTipsBar;
    hHw();
    AppMethodBeat.o(281207);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(281213);
    if (VYO != null) {
      VYO.add(parama);
    }
    AppMethodBeat.o(281213);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(281214);
    if (VYO != null) {
      VYO.remove(parama);
    }
    AppMethodBeat.o(281214);
  }
  
  public static void byn(String paramString)
  {
    AppMethodBeat.i(281212);
    c localc = ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
    long l;
    boolean bool;
    if ((c.kyx != null) && (((String)c.kyx.first).equals(paramString)))
    {
      l = ((Long)c.kyx.second).longValue();
      String str = String.format("DELETE FROM %s WHERE %s = '%s' AND %s != '%s'", new Object[] { "LiveTipsBar", "hostRoomId", paramString, "liveId", c.kyx.second });
      bool = localc.db.execSQL("LiveTipsBar", str);
      if (!bool) {
        Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      }
    }
    for (;;)
    {
      if (localc.kyz != null) {
        localc.kyz.Ol(paramString);
      }
      AppMethodBeat.o(281212);
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
  
  public static LinkedList<com.tencent.mm.live.b.c.b> byo(String paramString)
  {
    AppMethodBeat.i(281215);
    paramString = ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Oi(paramString);
    AppMethodBeat.o(281215);
    return paramString;
  }
  
  public static void hHv()
  {
    AppMethodBeat.i(281209);
    ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().kyz = null;
    AppMethodBeat.o(281209);
  }
  
  public final boolean bym(String paramString)
  {
    AppMethodBeat.i(281205);
    if ((this.kid != null) && (this.kid.equals(paramString)))
    {
      AppMethodBeat.o(281205);
      return true;
    }
    AppMethodBeat.o(281205);
    return false;
  }
  
  public final LinkedList<com.tencent.mm.live.b.c.b> hHw()
  {
    AppMethodBeat.i(281211);
    this.VYM = ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Oi(this.kid);
    LinkedList localLinkedList = this.VYM;
    AppMethodBeat.o(281211);
    return localLinkedList;
  }
  
  public final int hHx()
  {
    AppMethodBeat.i(281216);
    if (this.VYM != null)
    {
      int i = this.VYM.size();
      AppMethodBeat.o(281216);
      return i;
    }
    AppMethodBeat.o(281216);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void byp(String paramString);
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.live.b.c.b atP(int paramInt)
    {
      AppMethodBeat.i(266845);
      if (s.b(s.this) == null)
      {
        AppMethodBeat.o(266845);
        return null;
      }
      com.tencent.mm.live.b.c.b localb = (com.tencent.mm.live.b.c.b)s.b(s.this).get(paramInt);
      AppMethodBeat.o(266845);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(266844);
      if (s.b(s.this) != null)
      {
        int i = s.b(s.this).size();
        AppMethodBeat.o(266844);
        return i;
      }
      AppMethodBeat.o(266844);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(266848);
      View localView;
      final com.tencent.mm.live.b.c.b localb;
      TextView localTextView;
      StringBuilder localStringBuilder;
      Context localContext;
      String str2;
      String str3;
      if (paramView == null)
      {
        localView = LayoutInflater.from(s.c(s.this).context).inflate(R.i.live_talkroom_tipsbar_item, paramViewGroup, false);
        paramViewGroup = new s.c(s.this);
        paramViewGroup.VYV = ((LinearLayout)localView.findViewById(R.h.live_tipsbar_click_area));
        paramViewGroup.VYW = ((WeImageView)localView.findViewById(R.h.live_tipsbar_avatar));
        paramViewGroup.VYA = ((RelativeLayout)localView.findViewById(R.h.live_tipsbar_close_btn));
        paramViewGroup.VYX = ((TextView)localView.findViewById(R.h.live_tipsbar_livename));
        paramViewGroup.VYY = ((TextView)localView.findViewById(R.h.live_tipsbar_anchor));
        localView.setTag(paramViewGroup);
        localb = atP(paramInt);
        if (localb != null)
        {
          a.b.c(paramViewGroup.VYW, localb.field_anchorUsername);
          paramViewGroup.VYX.setText(l.c(s.c(s.this).context, localb.field_liveName));
          localTextView = paramViewGroup.VYY;
          localStringBuilder = new StringBuilder("主播：");
          localContext = s.c(s.this).context;
          str2 = localb.field_anchorUsername;
          str3 = s.a(s.this);
          if (str2 != null) {
            break label308;
          }
          paramView = "";
        }
      }
      for (;;)
      {
        localTextView.setText(l.b(localContext, paramView, paramViewGroup.VYY.getTextSize()));
        paramViewGroup.VYV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(287047);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
            if (localb != null)
            {
              paramAnonymousView = com.tencent.mm.ui.report.b.XLO;
              com.tencent.mm.ui.report.b.a(s.a(s.this), s.this.hHx(), String.valueOf(localb.field_liveId), 4L, System.currentTimeMillis());
            }
            Object localObject2;
            int i;
            if (localb != null)
            {
              paramAnonymousView = s.c(s.this);
              localObject1 = localb;
              localObject2 = new LiveConfig.a();
              if ((((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.q.a.p(paramAnonymousView.context, true)) && (!com.tencent.mm.q.a.cy(paramAnonymousView.context)) && (!com.tencent.mm.q.a.cw(paramAnonymousView.context)) && (!com.tencent.mm.q.a.cB(paramAnonymousView.context))))
              {
                if (!((com.tencent.mm.live.b.c.b)localObject1).field_isSender) {
                  break label341;
                }
                i = LiveConfig.khW;
                ((LiveConfig.a)localObject2).kic = i;
                ((LiveConfig.a)localObject2).thumbUrl = ((com.tencent.mm.live.b.c.b)localObject1).field_thumbUrl;
                ((LiveConfig.a)localObject2).kid = ((com.tencent.mm.live.b.c.b)localObject1).field_hostRoomId;
                ((LiveConfig.a)localObject2).liveId = ((com.tencent.mm.live.b.c.b)localObject1).field_liveId;
                ((LiveConfig.a)localObject2).kie = ((com.tencent.mm.live.b.c.b)localObject1).field_liveName;
                ((LiveConfig.a)localObject2).fromScene = LiveConfig.khZ;
                ((LiveConfig.a)localObject2).kig = ((com.tencent.mm.live.b.c.b)localObject1).field_anchorUsername;
                localObject2 = ((LiveConfig.a)localObject2).aJw();
                if (!((com.tencent.mm.live.b.c.b)localObject1).field_isSender) {
                  break label348;
                }
                ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).liveEntranceJumper().c(paramAnonymousView.context, (LiveConfig)localObject2);
              }
            }
            for (;;)
            {
              if (s.c(s.this) != null) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(287211);
                    if (s.c(s.this) != null) {
                      s.c(s.this).bm(true, false);
                    }
                    AppMethodBeat.o(287211);
                  }
                });
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(287047);
              return;
              label341:
              i = LiveConfig.khX;
              break;
              label348:
              f.aQK();
              ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).liveEntranceJumper().b(paramAnonymousView.context, (LiveConfig)localObject2);
            }
          }
        });
        paramViewGroup.VYA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(273103);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = (com.tencent.mm.live.b.c.b)s.b(s.this).get(paramInt);
            localObject = com.tencent.mm.ui.report.b.XLO;
            com.tencent.mm.ui.report.b.a(s.a(s.this), s.this.hHx(), String.valueOf(paramAnonymousView.field_liveId), 3L, System.currentTimeMillis());
            ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().FM(paramAnonymousView.field_liveId);
            s.this.hHw();
            if (s.c(s.this) != null) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(290858);
                  if (s.c(s.this) != null) {
                    s.c(s.this).hHr();
                  }
                  AppMethodBeat.o(290858);
                }
              });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(273103);
          }
        });
        AppMethodBeat.o(266848);
        return localView;
        paramViewGroup = (s.c)paramView.getTag();
        localView = paramView;
        break;
        label308:
        String str1 = aa.PK(str2);
        paramView = str1;
        if (Util.isNullOrNil(str1))
        {
          paramView = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(str3);
          if (paramView == null)
          {
            paramView = aa.PJ(str2);
          }
          else
          {
            str1 = paramView.PJ(str2);
            paramView = str1;
            if (Util.isNullOrNil(str1)) {
              paramView = aa.PJ(str2);
            }
          }
        }
      }
    }
  }
  
  final class c
  {
    RelativeLayout VYA;
    LinearLayout VYV;
    WeImageView VYW;
    TextView VYX;
    TextView VYY;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.s
 * JD-Core Version:    0.7.0.1
 */