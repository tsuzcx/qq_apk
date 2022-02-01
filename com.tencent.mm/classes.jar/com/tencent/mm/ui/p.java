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
import com.tencent.mm.model.ak;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashSet;
import java.util.LinkedList;

public final class p
{
  private static HashSet<a> Jar;
  private LiveTalkRoomTipsBar Jao;
  private LinkedList<com.tencent.mm.live.b.c.b> Jap;
  public b Jaq;
  String gGz;
  private c.a gRd;
  
  static
  {
    AppMethodBeat.i(193716);
    Jar = new HashSet();
    AppMethodBeat.o(193716);
  }
  
  public p(LiveTalkRoomTipsBar paramLiveTalkRoomTipsBar)
  {
    AppMethodBeat.i(193709);
    this.Jaq = new b();
    this.gRd = new c.a()
    {
      public final void xS(String paramAnonymousString)
      {
        AppMethodBeat.i(193698);
        if ((p.a(p.this) != null) && (p.a(p.this).equals(paramAnonymousString)))
        {
          ad.i("MicroMsg.LiveTalkRoomTipsBarController", "liveTipsBarStorage notify, hostRoomId:%s", new Object[] { p.a(p.this) });
          p.this.fwN();
          p.FZ(paramAnonymousString);
        }
        AppMethodBeat.o(193698);
      }
    };
    this.Jao = paramLiveTalkRoomTipsBar;
    fwN();
    ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().gRd = this.gRd;
    AppMethodBeat.o(193709);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(193712);
    if (Jar != null) {
      Jar.add(parama);
    }
    AppMethodBeat.o(193712);
  }
  
  public static void aVo(String paramString)
  {
    AppMethodBeat.i(193711);
    com.tencent.mm.live.b.c.c localc = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
    long l;
    boolean bool;
    if ((com.tencent.mm.live.b.c.c.gRb != null) && (((String)com.tencent.mm.live.b.c.c.gRb.first).equals(paramString)))
    {
      l = ((Long)com.tencent.mm.live.b.c.c.gRb.second).longValue();
      String str = String.format("DELETE FROM %s WHERE %s = '%s' AND %s != '%s'", new Object[] { "LiveTipsBar", "hostRoomId", paramString, "liveId", com.tencent.mm.live.b.c.c.gRb.second });
      bool = localc.db.execSQL("LiveTipsBar", str);
      if (!bool) {
        ad.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      }
    }
    for (;;)
    {
      if (localc.gRd != null) {
        localc.gRd.xS(paramString);
      }
      AppMethodBeat.o(193711);
      return;
      ad.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      continue;
      int i = localc.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
      if (i < 0) {
        ad.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      } else {
        ad.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      }
    }
  }
  
  public static LinkedList<com.tencent.mm.live.b.c.b> aVp(String paramString)
  {
    AppMethodBeat.i(193714);
    paramString = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().xP(paramString);
    AppMethodBeat.o(193714);
    return paramString;
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(193713);
    if (Jar != null) {
      Jar.remove(parama);
    }
    AppMethodBeat.o(193713);
  }
  
  public final boolean aVn(String paramString)
  {
    AppMethodBeat.i(193708);
    if ((this.gGz != null) && (this.gGz.equals(paramString)))
    {
      AppMethodBeat.o(193708);
      return true;
    }
    AppMethodBeat.o(193708);
    return false;
  }
  
  public final LinkedList<com.tencent.mm.live.b.c.b> fwN()
  {
    AppMethodBeat.i(193710);
    this.Jap = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().xP(this.gGz);
    LinkedList localLinkedList = this.Jap;
    AppMethodBeat.o(193710);
    return localLinkedList;
  }
  
  public static abstract interface a
  {
    public abstract void aVq(String paramString);
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.live.b.c.b abF(int paramInt)
    {
      AppMethodBeat.i(193705);
      if (p.b(p.this) == null)
      {
        AppMethodBeat.o(193705);
        return null;
      }
      com.tencent.mm.live.b.c.b localb = (com.tencent.mm.live.b.c.b)p.b(p.this).get(paramInt);
      AppMethodBeat.o(193705);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(193704);
      if (p.b(p.this) != null)
      {
        int i = p.b(p.this).size();
        AppMethodBeat.o(193704);
        return i;
      }
      AppMethodBeat.o(193704);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(193706);
      View localView;
      final com.tencent.mm.live.b.c.b localb;
      TextView localTextView;
      StringBuilder localStringBuilder;
      Context localContext;
      String str2;
      String str3;
      if (paramView == null)
      {
        localView = LayoutInflater.from(p.c(p.this).context).inflate(2131496343, paramViewGroup, false);
        paramViewGroup = new p.c(p.this);
        paramViewGroup.Jay = ((LinearLayout)localView.findViewById(2131307790));
        paramViewGroup.Jaz = ((WeImageView)localView.findViewById(2131307789));
        paramViewGroup.Jac = ((RelativeLayout)localView.findViewById(2131307791));
        paramViewGroup.JaA = ((TextView)localView.findViewById(2131307797));
        paramViewGroup.JaB = ((TextView)localView.findViewById(2131307788));
        localView.setTag(paramViewGroup);
        localb = abF(paramInt);
        if (localb != null)
        {
          a.b.c(paramViewGroup.Jaz, localb.field_anchorUsername);
          paramViewGroup.JaA.setText(k.c(p.c(p.this).context, localb.field_liveName));
          localTextView = paramViewGroup.JaB;
          localStringBuilder = new StringBuilder("主播：");
          localContext = p.c(p.this).context;
          str2 = localb.field_anchorUsername;
          str3 = p.a(p.this);
          if (str2 != null) {
            break label302;
          }
          paramView = "";
        }
      }
      for (;;)
      {
        localTextView.setText(k.b(localContext, paramView, paramViewGroup.JaB.getTextSize()));
        paramViewGroup.Jay.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(193701);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
            Object localObject2;
            int i;
            if (localb != null)
            {
              paramAnonymousView = p.c(p.this);
              localObject1 = localb;
              localObject2 = new LiveConfig.a();
              if ((((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.s.a.n(paramAnonymousView.context, true)) && (!com.tencent.mm.s.a.cf(paramAnonymousView.context)) && (!com.tencent.mm.s.a.cd(paramAnonymousView.context)) && (!com.tencent.mm.s.a.ch(paramAnonymousView.context))))
              {
                if (!((com.tencent.mm.live.b.c.b)localObject1).field_isSender) {
                  break label290;
                }
                i = LiveConfig.gGr;
                ((LiveConfig.a)localObject2).gGx = i;
                ((LiveConfig.a)localObject2).thumbUrl = ((com.tencent.mm.live.b.c.b)localObject1).field_thumbUrl;
                ((LiveConfig.a)localObject2).gGz = ((com.tencent.mm.live.b.c.b)localObject1).field_hostRoomId;
                ((LiveConfig.a)localObject2).gGy = ((com.tencent.mm.live.b.c.b)localObject1).field_liveId;
                ((LiveConfig.a)localObject2).gGA = ((com.tencent.mm.live.b.c.b)localObject1).field_liveName;
                ((LiveConfig.a)localObject2).fromScene = LiveConfig.gGu;
                ((LiveConfig.a)localObject2).gGC = ((com.tencent.mm.live.b.c.b)localObject1).field_anchorUsername;
                localObject2 = ((LiveConfig.a)localObject2).alb();
                if (!((com.tencent.mm.live.b.c.b)localObject1).field_isSender) {
                  break label297;
                }
                ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(paramAnonymousView.context, (LiveConfig)localObject2);
              }
            }
            for (;;)
            {
              if (p.c(p.this) != null) {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(193700);
                    if (p.c(p.this) != null) {
                      p.c(p.this).aT(true, false);
                    }
                    AppMethodBeat.o(193700);
                  }
                });
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(193701);
              return;
              label290:
              i = LiveConfig.gGs;
              break;
              label297:
              f.apZ();
              ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().b(paramAnonymousView.context, (LiveConfig)localObject2);
            }
          }
        });
        paramViewGroup.Jac.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(193703);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = (com.tencent.mm.live.b.c.b)p.b(p.this).get(paramInt);
            ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().rn(paramAnonymousView.field_liveId);
            p.this.fwN();
            if (p.c(p.this) != null) {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193702);
                  if (p.c(p.this) != null) {
                    p.c(p.this).fwL();
                  }
                  AppMethodBeat.o(193702);
                }
              });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(193703);
          }
        });
        AppMethodBeat.o(193706);
        return localView;
        paramViewGroup = (p.c)paramView.getTag();
        localView = paramView;
        break;
        label302:
        String str1 = v.zg(str2);
        paramView = str1;
        if (bt.isNullOrNil(str1))
        {
          paramView = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(str3);
          if (paramView == null)
          {
            paramView = v.zf(str2);
          }
          else
          {
            str1 = paramView.zf(str2);
            paramView = str1;
            if (bt.isNullOrNil(str1)) {
              paramView = v.zf(str2);
            }
          }
        }
      }
    }
  }
  
  final class c
  {
    TextView JaA;
    TextView JaB;
    RelativeLayout Jac;
    LinearLayout Jay;
    WeImageView Jaz;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.p
 * JD-Core Version:    0.7.0.1
 */