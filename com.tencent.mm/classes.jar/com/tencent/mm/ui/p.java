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
import com.tencent.mm.model.al;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashSet;
import java.util.LinkedList;

public final class p
{
  private static HashSet<a> JuZ;
  private LiveTalkRoomTipsBar JuW;
  private LinkedList<com.tencent.mm.live.b.c.b> JuX;
  public b JuY;
  String gJi;
  c.a gTL;
  
  static
  {
    AppMethodBeat.i(187005);
    JuZ = new HashSet();
    AppMethodBeat.o(187005);
  }
  
  public p(LiveTalkRoomTipsBar paramLiveTalkRoomTipsBar)
  {
    AppMethodBeat.i(186997);
    this.JuY = new b();
    this.gTL = new c.a()
    {
      public final void yB(String paramAnonymousString)
      {
        AppMethodBeat.i(186986);
        if ((p.a(p.this) != null) && (p.a(p.this).equals(paramAnonymousString)))
        {
          ae.i("MicroMsg.LiveTalkRoomTipsBarController", "liveTipsBarStorage notify, hostRoomId:%s", new Object[] { p.a(p.this) });
          p.this.fAP();
          p.GB(paramAnonymousString);
        }
        AppMethodBeat.o(186986);
      }
    };
    this.JuW = paramLiveTalkRoomTipsBar;
    fAP();
    AppMethodBeat.o(186997);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(187001);
    if (JuZ != null) {
      JuZ.add(parama);
    }
    AppMethodBeat.o(187001);
  }
  
  public static void aWP(String paramString)
  {
    AppMethodBeat.i(187000);
    com.tencent.mm.live.b.c.c localc = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
    long l;
    boolean bool;
    if ((com.tencent.mm.live.b.c.c.gTJ != null) && (((String)com.tencent.mm.live.b.c.c.gTJ.first).equals(paramString)))
    {
      l = ((Long)com.tencent.mm.live.b.c.c.gTJ.second).longValue();
      String str = String.format("DELETE FROM %s WHERE %s = '%s' AND %s != '%s'", new Object[] { "LiveTipsBar", "hostRoomId", paramString, "liveId", com.tencent.mm.live.b.c.c.gTJ.second });
      bool = localc.db.execSQL("LiveTipsBar", str);
      if (!bool) {
        ae.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      }
    }
    for (;;)
    {
      if (localc.gTL != null) {
        localc.gTL.yB(paramString);
      }
      AppMethodBeat.o(187000);
      return;
      ae.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      continue;
      int i = localc.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
      if (i < 0) {
        ae.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      } else {
        ae.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      }
    }
  }
  
  public static LinkedList<com.tencent.mm.live.b.c.b> aWQ(String paramString)
  {
    AppMethodBeat.i(187003);
    paramString = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().yy(paramString);
    AppMethodBeat.o(187003);
    return paramString;
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(187002);
    if (JuZ != null) {
      JuZ.remove(parama);
    }
    AppMethodBeat.o(187002);
  }
  
  public static void fAO()
  {
    AppMethodBeat.i(186998);
    ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().gTL = null;
    AppMethodBeat.o(186998);
  }
  
  public final boolean aWO(String paramString)
  {
    AppMethodBeat.i(186996);
    if ((this.gJi != null) && (this.gJi.equals(paramString)))
    {
      AppMethodBeat.o(186996);
      return true;
    }
    AppMethodBeat.o(186996);
    return false;
  }
  
  public final LinkedList<com.tencent.mm.live.b.c.b> fAP()
  {
    AppMethodBeat.i(186999);
    this.JuX = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().yy(this.gJi);
    LinkedList localLinkedList = this.JuX;
    AppMethodBeat.o(186999);
    return localLinkedList;
  }
  
  public static abstract interface a
  {
    public abstract void aWR(String paramString);
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.live.b.c.b acn(int paramInt)
    {
      AppMethodBeat.i(186993);
      if (p.b(p.this) == null)
      {
        AppMethodBeat.o(186993);
        return null;
      }
      com.tencent.mm.live.b.c.b localb = (com.tencent.mm.live.b.c.b)p.b(p.this).get(paramInt);
      AppMethodBeat.o(186993);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(186992);
      if (p.b(p.this) != null)
      {
        int i = p.b(p.this).size();
        AppMethodBeat.o(186992);
        return i;
      }
      AppMethodBeat.o(186992);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(186994);
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
        paramViewGroup.Jvg = ((LinearLayout)localView.findViewById(2131307790));
        paramViewGroup.Jvh = ((WeImageView)localView.findViewById(2131307789));
        paramViewGroup.JuK = ((RelativeLayout)localView.findViewById(2131307791));
        paramViewGroup.Jvi = ((TextView)localView.findViewById(2131307797));
        paramViewGroup.Jvj = ((TextView)localView.findViewById(2131307788));
        localView.setTag(paramViewGroup);
        localb = acn(paramInt);
        if (localb != null)
        {
          a.b.c(paramViewGroup.Jvh, localb.field_anchorUsername);
          paramViewGroup.Jvi.setText(k.c(p.c(p.this).context, localb.field_liveName));
          localTextView = paramViewGroup.Jvj;
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
        localTextView.setText(k.b(localContext, paramView, paramViewGroup.Jvj.getTextSize()));
        paramViewGroup.Jvg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186989);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
            Object localObject2;
            int i;
            if (localb != null)
            {
              paramAnonymousView = p.c(p.this);
              localObject1 = localb;
              localObject2 = new LiveConfig.a();
              if ((((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.r.a.n(paramAnonymousView.context, true)) && (!com.tencent.mm.r.a.ch(paramAnonymousView.context)) && (!com.tencent.mm.r.a.cf(paramAnonymousView.context)) && (!com.tencent.mm.r.a.cj(paramAnonymousView.context))))
              {
                if (!((com.tencent.mm.live.b.c.b)localObject1).field_isSender) {
                  break label290;
                }
                i = LiveConfig.gJa;
                ((LiveConfig.a)localObject2).gJg = i;
                ((LiveConfig.a)localObject2).thumbUrl = ((com.tencent.mm.live.b.c.b)localObject1).field_thumbUrl;
                ((LiveConfig.a)localObject2).gJi = ((com.tencent.mm.live.b.c.b)localObject1).field_hostRoomId;
                ((LiveConfig.a)localObject2).gJh = ((com.tencent.mm.live.b.c.b)localObject1).field_liveId;
                ((LiveConfig.a)localObject2).gJj = ((com.tencent.mm.live.b.c.b)localObject1).field_liveName;
                ((LiveConfig.a)localObject2).fromScene = LiveConfig.gJd;
                ((LiveConfig.a)localObject2).gJl = ((com.tencent.mm.live.b.c.b)localObject1).field_anchorUsername;
                localObject2 = ((LiveConfig.a)localObject2).alq();
                if (!((com.tencent.mm.live.b.c.b)localObject1).field_isSender) {
                  break label297;
                }
                ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(paramAnonymousView.context, (LiveConfig)localObject2);
              }
            }
            for (;;)
            {
              if (p.c(p.this) != null) {
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(186988);
                    if (p.c(p.this) != null) {
                      p.c(p.this).aS(true, false);
                    }
                    AppMethodBeat.o(186988);
                  }
                });
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(186989);
              return;
              label290:
              i = LiveConfig.gJb;
              break;
              label297:
              f.aqo();
              ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().b(paramAnonymousView.context, (LiveConfig)localObject2);
            }
          }
        });
        paramViewGroup.JuK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186991);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = (com.tencent.mm.live.b.c.b)p.b(p.this).get(paramInt);
            ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().rA(paramAnonymousView.field_liveId);
            p.this.fAP();
            if (p.c(p.this) != null) {
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(186990);
                  if (p.c(p.this) != null) {
                    p.c(p.this).fAM();
                  }
                  AppMethodBeat.o(186990);
                }
              });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186991);
          }
        });
        AppMethodBeat.o(186994);
        return localView;
        paramViewGroup = (p.c)paramView.getTag();
        localView = paramView;
        break;
        label302:
        String str1 = w.zQ(str2);
        paramView = str1;
        if (bu.isNullOrNil(str1))
        {
          paramView = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(str3);
          if (paramView == null)
          {
            paramView = w.zP(str2);
          }
          else
          {
            str1 = paramView.zP(str2);
            paramView = str1;
            if (bu.isNullOrNil(str1)) {
              paramView = w.zP(str2);
            }
          }
        }
      }
    }
  }
  
  final class c
  {
    RelativeLayout JuK;
    LinearLayout Jvg;
    WeImageView Jvh;
    TextView Jvi;
    TextView Jvj;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.p
 * JD-Core Version:    0.7.0.1
 */