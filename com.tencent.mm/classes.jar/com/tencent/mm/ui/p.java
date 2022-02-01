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
import com.tencent.mm.live.a;
import com.tencent.mm.live.b.c.b;
import com.tencent.mm.live.b.c.c.a;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashSet;
import java.util.LinkedList;

public final class p
{
  private static HashSet<a> HmK;
  private LiveTalkRoomTipsBar HmH;
  private LinkedList<b> HmI;
  public b HmJ;
  String gmQ;
  private c.a gxs;
  
  static
  {
    AppMethodBeat.i(196315);
    HmK = new HashSet();
    AppMethodBeat.o(196315);
  }
  
  public p(LiveTalkRoomTipsBar paramLiveTalkRoomTipsBar)
  {
    AppMethodBeat.i(196308);
    this.HmJ = new b();
    this.gxs = new c.a()
    {
      public final void vc(String paramAnonymousString)
      {
        AppMethodBeat.i(196297);
        if ((p.a(p.this) != null) && (p.a(p.this).equals(paramAnonymousString)))
        {
          p.this.fgB();
          p.CU(paramAnonymousString);
        }
        AppMethodBeat.o(196297);
      }
    };
    this.HmH = paramLiveTalkRoomTipsBar;
    fgB();
    ((a)g.ad(a.class)).getLiveTipsBarStorage().gxs = this.gxs;
    AppMethodBeat.o(196308);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(196311);
    if (HmK != null) {
      HmK.add(parama);
    }
    AppMethodBeat.o(196311);
  }
  
  public static void aPy(String paramString)
  {
    AppMethodBeat.i(196310);
    com.tencent.mm.live.b.c.c localc = ((a)g.ad(a.class)).getLiveTipsBarStorage();
    long l;
    boolean bool;
    if ((com.tencent.mm.live.b.c.c.gxq != null) && (((String)com.tencent.mm.live.b.c.c.gxq.first).equals(paramString)))
    {
      l = ((Long)com.tencent.mm.live.b.c.c.gxq.second).longValue();
      String str = String.format("DELETE FROM %s WHERE %s = '%s' AND %s != '%s'", new Object[] { "LiveTipsBar", "hostRoomId", paramString, "liveId", com.tencent.mm.live.b.c.c.gxq.second });
      bool = localc.db.execSQL("LiveTipsBar", str);
      if (!bool) {
        ac.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      }
    }
    for (;;)
    {
      if (localc.gxs != null) {
        localc.gxs.vc(paramString);
      }
      AppMethodBeat.o(196310);
      return;
      ac.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%b, visitingLive:%d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(l) });
      continue;
      int i = localc.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
      if (i < 0) {
        ac.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      } else {
        ac.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      }
    }
  }
  
  public static LinkedList<b> aPz(String paramString)
  {
    AppMethodBeat.i(196313);
    paramString = ((a)g.ad(a.class)).getLiveTipsBarStorage().uZ(paramString);
    AppMethodBeat.o(196313);
    return paramString;
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(196312);
    if (HmK != null) {
      HmK.remove(parama);
    }
    AppMethodBeat.o(196312);
  }
  
  public final boolean aPx(String paramString)
  {
    AppMethodBeat.i(196307);
    if ((this.gmQ != null) && (this.gmQ.equals(paramString)))
    {
      AppMethodBeat.o(196307);
      return true;
    }
    AppMethodBeat.o(196307);
    return false;
  }
  
  public final LinkedList<b> fgB()
  {
    AppMethodBeat.i(196309);
    this.HmI = ((a)g.ad(a.class)).getLiveTipsBarStorage().uZ(this.gmQ);
    LinkedList localLinkedList = this.HmI;
    AppMethodBeat.o(196309);
    return localLinkedList;
  }
  
  public static abstract interface a
  {
    public abstract void aPA(String paramString);
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    public final b Zv(int paramInt)
    {
      AppMethodBeat.i(196304);
      if (p.b(p.this) == null)
      {
        AppMethodBeat.o(196304);
        return null;
      }
      b localb = (b)p.b(p.this).get(paramInt);
      AppMethodBeat.o(196304);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(196303);
      if (p.b(p.this) != null)
      {
        int i = p.b(p.this).size();
        AppMethodBeat.o(196303);
        return i;
      }
      AppMethodBeat.o(196303);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(196305);
      View localView;
      final b localb;
      TextView localTextView;
      StringBuilder localStringBuilder;
      Context localContext;
      String str2;
      String str3;
      if (paramView == null)
      {
        localView = LayoutInflater.from(p.c(p.this).context).inflate(2131496343, paramViewGroup, false);
        paramViewGroup = new p.c(p.this);
        paramViewGroup.HmR = ((LinearLayout)localView.findViewById(2131307790));
        paramViewGroup.HmS = ((WeImageView)localView.findViewById(2131307789));
        paramViewGroup.Hmv = ((RelativeLayout)localView.findViewById(2131307791));
        paramViewGroup.HmT = ((TextView)localView.findViewById(2131307797));
        paramViewGroup.HmU = ((TextView)localView.findViewById(2131307788));
        localView.setTag(paramViewGroup);
        localb = Zv(paramInt);
        if (localb != null)
        {
          a.b.c(paramViewGroup.HmS, localb.field_anchorUsername);
          paramViewGroup.HmT.setText(k.c(p.c(p.this).context, localb.field_liveName));
          localTextView = paramViewGroup.HmU;
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
        localTextView.setText(k.b(localContext, paramView, paramViewGroup.HmU.getTextSize()));
        paramViewGroup.HmR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196300);
            if (localb != null) {
              p.c(p.this).b(localb);
            }
            if (p.c(p.this) != null) {
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(196299);
                  if (p.c(p.this) != null) {
                    p.c(p.this).setTipsBarLayout(true);
                  }
                  AppMethodBeat.o(196299);
                }
              });
            }
            AppMethodBeat.o(196300);
          }
        });
        paramViewGroup.Hmv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196302);
            paramAnonymousView = (b)p.b(p.this).get(paramInt);
            ((a)g.ad(a.class)).getLiveTipsBarStorage().pm(paramAnonymousView.field_liveId);
            p.this.fgB();
            if (p.c(p.this) != null) {
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(196301);
                  if (p.c(p.this) != null) {
                    p.c(p.this).fgz();
                  }
                  AppMethodBeat.o(196301);
                }
              });
            }
            AppMethodBeat.o(196302);
          }
        });
        AppMethodBeat.o(196305);
        return localView;
        paramViewGroup = (p.c)paramView.getTag();
        localView = paramView;
        break;
        label302:
        String str1 = v.wl(str2);
        paramView = str1;
        if (bs.isNullOrNil(str1))
        {
          paramView = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(str3);
          if (paramView == null)
          {
            paramView = v.wk(str2);
          }
          else
          {
            str1 = paramView.wk(str2);
            paramView = str1;
            if (bs.isNullOrNil(str1)) {
              paramView = v.wk(str2);
            }
          }
        }
      }
    }
  }
  
  final class c
  {
    LinearLayout HmR;
    WeImageView HmS;
    TextView HmT;
    TextView HmU;
    RelativeLayout Hmv;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.p
 * JD-Core Version:    0.7.0.1
 */