package com.tencent.mm.plugin.multitalk.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.voip.d.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkFloatCardManager;", "Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager;", "()V", "curChildViewList", "", "", "Landroid/view/View;", "gridViewWidth", "", "inviteUser", "memberList", "", "multiTalkGroup", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroup;", "getMultiTalkGroup", "()Lcom/tencent/pb/talkroom/sdk/MultiTalkGroup;", "setMultiTalkGroup", "(Lcom/tencent/pb/talkroom/sdk/MultiTalkGroup;)V", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkFloatCardManager$MultiTalkUiCallback;", "getUiCallback", "()Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkFloatCardManager$MultiTalkUiCallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkFloatCardManager$MultiTalkUiCallback;)V", "createAccDesc", "dismissCard", "", "quickHide", "", "releaseViewAndIntent", "getAccButtonDrawable", "getNotificationText", "hideCard", "initView", "intent", "Landroid/content/Intent;", "toUser", "isMultitalk", "onAccept", "onBackground", "onFling", "onFullscreen", "onReject", "updateGroup", "updateMemberUi", "Companion", "MultiTalkUiCallback", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.voip.floatcard.a
{
  public static final a.a Lrr;
  public MultiTalkGroup Liy;
  public b Lrs;
  private String Lrt;
  private int Lru;
  private final Map<String, View> Lrv;
  
  static
  {
    AppMethodBeat.i(285298);
    Lrr = new a.a((byte)0);
    AppMethodBeat.o(285298);
  }
  
  public a()
  {
    AppMethodBeat.i(285260);
    this.Lrt = "";
    this.Lrv = ((Map)new LinkedHashMap());
    AppMethodBeat.o(285260);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(285283);
    s.u(parama, "this$0");
    parama = parama.Lrs;
    if (parama != null) {
      parama.ggw();
    }
    AppMethodBeat.o(285283);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(285278);
    s.u(parama, "this$0");
    b localb = parama.Lrs;
    if (localb != null) {
      localb.ggu();
    }
    if (paramView != null) {
      parama.kw(paramView);
    }
    AppMethodBeat.o(285278);
  }
  
  private static final void a(a parama, GridLayout paramGridLayout)
  {
    AppMethodBeat.i(285290);
    s.u(parama, "this$0");
    parama.Lru = paramGridLayout.getMeasuredWidth();
    parama.ghe();
    AppMethodBeat.o(285290);
  }
  
  private static final void a(MultiTalkGroup paramMultiTalkGroup, a parama, Intent paramIntent)
  {
    AppMethodBeat.i(285280);
    s.u(parama, "this$0");
    s.u(paramIntent, "$intent");
    if (paramMultiTalkGroup != null)
    {
      parama = parama.Lrs;
      if (parama != null) {
        parama.a(paramIntent, paramMultiTalkGroup);
      }
    }
    AppMethodBeat.o(285280);
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(285288);
    s.u(parama, "this$0");
    parama = parama.Lrs;
    if (parama != null) {
      parama.ggw();
    }
    AppMethodBeat.o(285288);
  }
  
  private static final void c(a parama)
  {
    AppMethodBeat.i(285293);
    s.u(parama, "this$0");
    parama.ghe();
    AppMethodBeat.o(285293);
  }
  
  private final void ghe()
  {
    AppMethodBeat.i(285273);
    View localView = this.RWj;
    if (localView != null)
    {
      GridLayout localGridLayout = (GridLayout)localView.findViewById(a.e.notification_other_member_avatar);
      Object localObject1 = this.Liy;
      if (localObject1 != null)
      {
        localObject1 = ((MultiTalkGroup)localObject1).ahhh;
        if (localObject1 != null)
        {
          localObject1 = (Iterable)localObject1;
          Object localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
          Object localObject4 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject2 = ((MultiTalkGroupMember)((Iterator)localObject4).next()).ahhi;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            ((Collection)localObject3).add(localObject1);
          }
          Object localObject2 = (Iterable)localObject3;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          label225:
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (!s.p((String)localObject3, this.Lrt)) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label225;
              }
              ((Collection)localObject1).add(localObject3);
              break;
            }
          }
          localObject3 = (List)localObject1;
          localObject1 = (Iterable)localObject3;
          localObject4 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
          Iterator localIterator = ((Iterable)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localObject2 = (View)this.Lrv.get(str);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new ImageView(localView.getContext());
              com.tencent.mm.pluginsdk.ui.a.b.g((ImageView)localObject1, str);
              localObject2 = ah.aiuX;
              localObject1 = (View)localObject1;
            }
            ((Collection)localObject4).add(v.Y(str, localObject1));
          }
          localObject1 = ak.F((Iterable)localObject4);
          this.Lrv.clear();
          this.Lrv.putAll((Map)localObject1);
          localGridLayout.removeAllViews();
          if (((List)localObject3).size() > 13) {
            hVy();
          }
          int j;
          int k;
          for (int i = 2;; i = 1)
          {
            localGridLayout.setRowCount(i);
            j = (int)(localGridLayout.getResources().getDisplayMetrics().density * 2.0F + 0.5F);
            k = (this.Lru - j * 2 * 13) / 13;
            if (k > 0) {
              break;
            }
            AppMethodBeat.o(285273);
            return;
            hVy();
          }
          localObject2 = this.Lrv.entrySet().iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            localView = (View)((Map.Entry)((Iterator)localObject2).next()).getValue();
            if (i < 13) {}
            for (localObject1 = new GridLayout.LayoutParams(GridLayout.spec(0, 1), GridLayout.spec(i, 1));; localObject1 = new GridLayout.LayoutParams(GridLayout.spec(1, 1), GridLayout.spec(i - 13, 1)))
            {
              ((GridLayout.LayoutParams)localObject1).setMargins(j, j, j, j);
              ((GridLayout.LayoutParams)localObject1).setGravity(8388659);
              ((GridLayout.LayoutParams)localObject1).width = k;
              ((GridLayout.LayoutParams)localObject1).height = k;
              localGridLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
              i += 1;
              break;
            }
          }
        }
      }
    }
    AppMethodBeat.o(285273);
  }
  
  public final void aB(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(285388);
    super.aB(paramBoolean1, paramBoolean2);
    this.Lrv.clear();
    this.Liy = null;
    this.Lrt = "";
    AppMethodBeat.o(285388);
  }
  
  public final void bf(Intent paramIntent)
  {
    AppMethodBeat.i(285349);
    s.u(paramIntent, "intent");
    aB(false, false);
    paramIntent = this.RWj;
    com.tencent.threadpool.h.ahAA.o(new a..ExternalSyntheticLambda3(this, paramIntent), 200L);
    paramIntent = d.UGN;
    d.z(hVw(), 4, 3);
    AppMethodBeat.o(285349);
  }
  
  public final void bg(Intent paramIntent)
  {
    AppMethodBeat.i(285354);
    s.u(paramIntent, "intent");
    MultiTalkGroup localMultiTalkGroup = this.Liy;
    com.tencent.mm.plugin.voip.floatcard.a.a((com.tencent.mm.plugin.voip.floatcard.a)this, false, false, 2);
    com.tencent.threadpool.h.ahAA.o(new a..ExternalSyntheticLambda5(localMultiTalkGroup, this, paramIntent), 200L);
    paramIntent = d.UGN;
    d.z(hVw(), 1, 3);
    AppMethodBeat.o(285354);
  }
  
  public final void fvW()
  {
    AppMethodBeat.i(285345);
    Object localObject = this.Lrs;
    if (localObject != null) {
      ((b)localObject).ggv();
    }
    localObject = d.UGN;
    d.z(hVw(), 3, 3);
    AppMethodBeat.o(285345);
  }
  
  public final void g(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(285383);
    s.u(paramIntent, "intent");
    s.u(paramString, "toUser");
    super.g(paramIntent, paramString);
    this.Lrt = paramString;
    paramIntent = this.RWj;
    if (paramIntent != null)
    {
      paramString = (TextView)paramIntent.findViewById(a.e.notification_other_member);
      paramString.setVisibility(0);
      paramString.setText(a.h.multitalk_member_wording);
      paramString = paramIntent.findViewById(a.e.notification_other_member_avatar);
      GridLayout localGridLayout = (GridLayout)paramString;
      localGridLayout.setVisibility(0);
      localGridLayout.setColumnCount(13);
      paramIntent.post(new a..ExternalSyntheticLambda4(this, (GridLayout)paramString));
    }
    AppMethodBeat.o(285383);
  }
  
  public final void gha()
  {
    AppMethodBeat.i(285358);
    com.tencent.threadpool.h.ahAA.o(new a..ExternalSyntheticLambda0(this), 200L);
    d locald = d.UGN;
    d.z(hVw(), 2, 3);
    AppMethodBeat.o(285358);
  }
  
  public final void ghb()
  {
    AppMethodBeat.i(285364);
    super.ghb();
    com.tencent.threadpool.h.ahAA.o(new a..ExternalSyntheticLambda2(this), 200L);
    AppMethodBeat.o(285364);
  }
  
  public final int ghc()
  {
    return a.h.multitalk_invite_wording;
  }
  
  public final int ghd()
  {
    return a.d.accept_button_selector;
  }
  
  public final String ghf()
  {
    AppMethodBeat.i(285410);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(MMApplicationContext.getString(a.h.multitalk_members_join));
    Object localObject1 = this.Liy;
    if (localObject1 != null)
    {
      localObject1 = ((MultiTalkGroup)localObject1).ahhh;
      if (localObject1 != null)
      {
        localObject1 = (Iterable)localObject1;
        Object localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
        Object localObject4 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject2 = ((MultiTalkGroupMember)((Iterator)localObject4).next()).ahhi;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((Collection)localObject3).add(localObject1);
        }
        Object localObject2 = (Iterable)localObject3;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        label201:
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (!s.p((String)localObject3, this.Lrt)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label201;
            }
            ((Collection)localObject1).add(localObject3);
            break;
          }
        }
        localObject1 = (Iterable)localObject1;
        localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
        localObject3 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = (String)((Iterator)localObject3).next();
          localObject4 = (b)com.tencent.mm.kernel.h.ax(b.class);
          if (localObject4 == null) {}
          for (localObject1 = null;; localObject1 = ((b)localObject4).getDisplayName((String)localObject1))
          {
            ((Collection)localObject2).add(localStringBuffer.append(s.X((String)localObject1, ",")));
            break;
          }
        }
      }
    }
    localObject1 = s.X(super.ghf(), localStringBuffer);
    AppMethodBeat.o(285410);
    return localObject1;
  }
  
  public final void m(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(285395);
    s.u(paramMultiTalkGroup, "multiTalkGroup");
    this.Liy = paramMultiTalkGroup;
    paramMultiTalkGroup = this.RWj;
    if (paramMultiTalkGroup != null) {
      paramMultiTalkGroup.post(new a..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(285395);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(285400);
    super.onBackground();
    b localb = this.Lrs;
    if (localb != null) {
      localb.onBackground();
    }
    AppMethodBeat.o(285400);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkFloatCardManager$MultiTalkUiCallback;", "", "accept", "", "fullscreen", "intent", "Landroid/content/Intent;", "multiGroup", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroup;", "mini", "onBackground", "reject", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(Intent paramIntent, MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void ggu();
    
    public abstract void ggv();
    
    public abstract void ggw();
    
    public abstract void onBackground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a
 * JD-Core Version:    0.7.0.1
 */