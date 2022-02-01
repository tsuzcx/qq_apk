package com.tencent.mm.plugin.textstatus.conversation.d;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.conversation.g.d;
import com.tencent.mm.plugin.textstatus.h.f.h;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusReportUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "curTabClickTag", "", "getCurTabClickTag", "()I", "setCurTabClickTag", "(I)V", "reportEnterScene", "getReportEnterScene", "reportEnterScene$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "reportEnter", "reportExpose", "conv", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "item", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "reportOnlyAction", "action", "reportTabSelect", "selectIndex", "tabConvCnt", "tabInteractiveCnt", "reportWithUnreadCount", "unreadInteractCount", "unreadMsgCount", "unreadHelloCount", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
{
  public static final a Tjd;
  public static String Tjg;
  private final j Tje;
  public int Tjf;
  
  static
  {
    AppMethodBeat.i(290960);
    Tjd = new a((byte)0);
    Tjg = "";
    AppMethodBeat.o(290960);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(290918);
    this.Tje = kotlin.k.cm((kotlin.g.a.a)new f.b(this));
    AppMethodBeat.o(290918);
  }
  
  public static void hGx()
  {
    AppMethodBeat.i(290937);
    com.tencent.mm.plugin.textstatus.i.b localb = com.tencent.mm.plugin.textstatus.i.b.Trt;
    com.tencent.mm.plugin.textstatus.i.b.a(51L, null, Tjg, 0, null, 0, 0, 0, 0, null, null, null, null, null, 16378);
    AppMethodBeat.o(290937);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(290965);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    int i = com.tencent.mm.plugin.textstatus.b.f.hGP();
    paramBundle = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    int j = com.tencent.mm.plugin.textstatus.b.f.hGL().hGB();
    paramBundle = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    int k = com.tencent.mm.plugin.textstatus.conversation.h.b.a(com.tencent.mm.plugin.textstatus.b.f.hGN());
    paramBundle = d.Tjx;
    if (d.hGA()) {}
    for (paramBundle = "1";; paramBundle = "0")
    {
      Object localObject = e.TiZ;
      localObject = (Context)getContext();
      s.u(localObject, "context");
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      localObject = com.tencent.mm.ui.component.k.nq((Context)localObject).q(e.class);
      s.s(localObject, "UICProvider.of(context).…PagerDataUIC::class.java)");
      int m = ((e)localObject).hGw();
      localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(1L, paramBundle, Tjg, ((Number)this.Tje.getValue()).intValue(), null, m, i, j, k, null, null, null, null, null, 15888);
      AppMethodBeat.o(290965);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusReportUIC$Companion;", "", "()V", "TAG", "", "notifySessionId", "getNotifySessionId", "()Ljava/lang/String;", "setNotifySessionId", "(Ljava/lang/String;)V", "of", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusReportUIC;", "context", "Landroid/content/Context;", "reportWithFriend", "", "username", "action", "", "reportWithUser", "sessionId", "getHashTag", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static String a(TextStatusTopicInfo paramTextStatusTopicInfo)
    {
      AppMethodBeat.i(290985);
      s.u(paramTextStatusTopicInfo, "<this>");
      StringBuilder localStringBuilder = new StringBuilder();
      paramTextStatusTopicInfo = paramTextStatusTopicInfo.topics.iterator();
      if (paramTextStatusTopicInfo.hasNext())
      {
        String str = (String)paramTextStatusTopicInfo.next();
        if (((CharSequence)localStringBuilder).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            localStringBuilder.append(";");
          }
          localStringBuilder.append(str);
          break;
        }
      }
      paramTextStatusTopicInfo = localStringBuilder.toString();
      AppMethodBeat.o(290985);
      return paramTextStatusTopicInfo;
    }
    
    public static void bdG(String paramString)
    {
      AppMethodBeat.i(290994);
      s.u(paramString, "username");
      Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      Object localObject4 = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString);
      Object localObject2;
      label37:
      Object localObject3;
      if (localObject4 == null)
      {
        localObject2 = "";
        if (localObject4 != null) {
          break label98;
        }
        localObject1 = "";
        if (localObject4 != null) {
          break label131;
        }
        localObject3 = "";
      }
      for (;;)
      {
        localObject4 = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.a(201L, null, f.hGy(), 0, null, 0, 0, 0, 0, paramString, (String)localObject2, (String)localObject1, null, (String)localObject3, 4602);
        AppMethodBeat.o(290994);
        return;
        localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject4).field_IconID;
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        localObject2 = "";
        break;
        label98:
        localObject1 = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject4);
        if (localObject1 == null)
        {
          localObject1 = "";
          break label37;
        }
        localObject3 = ((TextStatusTopicInfo)localObject1).sourceId;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label37;
        }
        localObject1 = "";
        break label37;
        label131:
        localObject4 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject4).field_StatusID;
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = "";
        }
      }
    }
    
    public static void bdH(String paramString)
    {
      AppMethodBeat.i(290999);
      s.u(paramString, "<set-?>");
      f.bdF(paramString);
      AppMethodBeat.o(290999);
    }
    
    public static void hp(String paramString, int paramInt)
    {
      AppMethodBeat.i(290979);
      s.u(paramString, "sessionId");
      Object localObject3;
      label48:
      Object localObject4;
      label57:
      Object localObject2;
      if (s.p(paramString, com.tencent.mm.plugin.auth.a.a.cUx()))
      {
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        localObject5 = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString);
        if (localObject5 == null)
        {
          localObject3 = "";
          if (localObject5 != null) {
            break label129;
          }
          localObject1 = "";
          if (localObject5 != null) {
            break label162;
          }
          localObject4 = "";
          if (localObject5 != null) {
            break label182;
          }
          localObject2 = "";
        }
        for (;;)
        {
          localObject5 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          localObject3 = com.tencent.mm.plugin.textstatus.i.b.Trt;
          com.tencent.mm.plugin.textstatus.i.b.a(paramInt, null, f.hGy(), 0, null, 0, 0, 0, 0, paramString, (String)localObject1, (String)localObject2, (String)localObject5, (String)localObject4, 506);
          AppMethodBeat.o(290979);
          return;
          localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject5).field_IconID;
          localObject3 = localObject1;
          if (localObject1 != null) {
            break;
          }
          localObject3 = "";
          break;
          label129:
          localObject1 = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject5);
          if (localObject1 == null)
          {
            localObject1 = "";
            break label48;
          }
          localObject2 = ((TextStatusTopicInfo)localObject1).sourceId;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label48;
          }
          localObject1 = "";
          break label48;
          label162:
          localObject2 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject5).field_StatusID;
          localObject4 = localObject2;
          if (localObject2 != null) {
            break label57;
          }
          localObject4 = "";
          break label57;
          label182:
          localObject2 = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject5);
          if (localObject2 == null)
          {
            localObject2 = "";
          }
          else
          {
            localObject5 = a((TextStatusTopicInfo)localObject2);
            localObject2 = localObject5;
            if (localObject5 == null) {
              localObject2 = "";
            }
          }
        }
      }
      Object localObject1 = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
      Object localObject5 = com.tencent.mm.plugin.textstatus.conversation.g.a.bdK(paramString);
      if (localObject5 == null)
      {
        localObject1 = "";
        label236:
        if (localObject5 != null) {
          break label317;
        }
        localObject2 = "";
        label244:
        if (localObject5 != null) {
          break label368;
        }
        localObject4 = "";
        label253:
        if (localObject5 != null) {
          break label391;
        }
        localObject3 = "";
      }
      for (;;)
      {
        localObject5 = localObject3;
        break;
        localObject1 = ((h)localObject5).hHR();
        if (localObject1 == null)
        {
          localObject1 = "";
          break label236;
        }
        localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label236;
        }
        localObject2 = ((TextStatusTopicInfo)localObject1).iconId;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label236;
        }
        localObject1 = "";
        break label236;
        label317:
        localObject2 = ((h)localObject5).hHR();
        if (localObject2 == null)
        {
          localObject2 = "";
          break label244;
        }
        localObject2 = ((TextStatusExtInfo)localObject2).topicInfo;
        if (localObject2 == null)
        {
          localObject2 = "";
          break label244;
        }
        localObject3 = ((TextStatusTopicInfo)localObject2).sourceId;
        localObject2 = localObject3;
        if (localObject3 != null) {
          break label244;
        }
        localObject2 = "";
        break label244;
        label368:
        localObject3 = ((h)localObject5).field_textStatusId;
        localObject4 = localObject3;
        if (localObject3 != null) {
          break label253;
        }
        localObject4 = "";
        break label253;
        label391:
        localObject3 = ((h)localObject5).hHR();
        if (localObject3 == null)
        {
          localObject3 = "";
        }
        else
        {
          localObject3 = ((TextStatusExtInfo)localObject3).topicInfo;
          if (localObject3 == null)
          {
            localObject3 = "";
          }
          else
          {
            localObject5 = a((TextStatusTopicInfo)localObject3);
            localObject3 = localObject5;
            if (localObject5 == null) {
              localObject3 = "";
            }
          }
        }
      }
    }
    
    public static f ko(Context paramContext)
    {
      AppMethodBeat.i(290970);
      s.u(paramContext, "context");
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      paramContext = com.tencent.mm.ui.component.k.nq(paramContext).q(f.class);
      s.s(paramContext, "UICProvider.of(context).…tusReportUIC::class.java)");
      paramContext = (f)paramContext;
      AppMethodBeat.o(290970);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.d.f
 * JD-Core Version:    0.7.0.1
 */