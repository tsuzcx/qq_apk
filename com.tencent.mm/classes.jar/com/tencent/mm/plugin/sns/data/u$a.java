package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.u;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/data/SnsUtilExt$Companion;", "", "()V", "getDisplayRemarkSpan", "", "remarkname", "", "username", "clickCb", "Lkotlin/Function2;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "", "getWithTaText", "context", "snsId", "isSelfBrowser", "", "withTaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/SnsCommentInfo;", "startProfile", "scene", "", "source", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u$a
{
  public static CharSequence a(Context paramContext, String paramString, boolean paramBoolean, LinkedList<fdv> paramLinkedList)
  {
    AppMethodBeat.i(306427);
    s.u(paramString, "snsId");
    s.u(paramLinkedList, "withTaList");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)MMApplicationContext.getString(b.j.sns_together_he));
    StringBuffer localStringBuffer = new StringBuffer();
    List localList = t.a(Boolean.valueOf(paramBoolean), paramLinkedList);
    String str1 = al.hgg();
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      label112:
      String str3;
      if (i == 0)
      {
        i = 1;
        localSpannableStringBuilder.append((CharSequence)"");
        localObject = (kotlin.g.a.m)new u.a.a(paramString);
        if (!s.p(str2, str1)) {
          break label209;
        }
        str3 = MMApplicationContext.getString(b.j.app_me);
        s.s(str3, "getString(R.string.app_me)");
        s.s(str1, "selfName");
      }
      for (Object localObject = a(str3, str1, (kotlin.g.a.m)localObject);; localObject = a(str3, str2, (kotlin.g.a.m)localObject))
      {
        localSpannableStringBuilder.append((CharSequence)localObject);
        localStringBuffer.append(str2);
        break;
        localSpannableStringBuilder.append((CharSequence)"、");
        localStringBuffer.append("#");
        break label112;
        label209:
        str3 = ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).IE(str2);
        s.s(str3, "remarkName");
        com.tencent.mm.plugin.sns.model.d.b.aZb(str3);
        s.s(str2, "name");
      }
    }
    if ((paramContext instanceof SnsTimeLineUI)) {
      e.xfd.b(com.tencent.mm.plugin.comm.b.b.xeQ.name(), paramString, "ccuserList", localStringBuffer);
    }
    for (;;)
    {
      if (localList.isEmpty()) {
        localSpannableStringBuilder.clear();
      }
      localSpannableStringBuilder.append((CharSequence)t.lo(paramLinkedList.size(), localList.size()));
      paramContext = (CharSequence)localSpannableStringBuilder;
      AppMethodBeat.o(306427);
      return paramContext;
      if ((paramContext instanceof SnsCommentDetailUI)) {
        e.xfd.b(com.tencent.mm.plugin.comm.b.b.xeP.name(), paramString, "ccuserList", localStringBuffer);
      }
    }
  }
  
  private static CharSequence a(String paramString1, String paramString2, kotlin.g.a.m<? super Context, ? super String, ah> paramm)
  {
    AppMethodBeat.i(306435);
    s.u(paramString1, "remarkname");
    s.u(paramString2, "username");
    s.u(paramm, "clickCb");
    SpannableString localSpannableString = p.b(MMApplicationContext.getContext(), (CharSequence)paramString1);
    paramString2 = new u(paramString1, new u.a..ExternalSyntheticLambda0(paramm, paramString2), (byte)0);
    paramString2.Ypd = Boolean.FALSE;
    localSpannableString.setSpan(paramString2, 0, paramString1.length(), 33);
    s.s(localSpannableString, "spannableString");
    paramString1 = (CharSequence)localSpannableString;
    AppMethodBeat.o(306435);
    return paramString1;
  }
  
  private static final void a(kotlin.g.a.m paramm, String paramString, View paramView, Object paramObject)
  {
    AppMethodBeat.i(306449);
    s.u(paramm, "$clickCb");
    s.u(paramString, "$username");
    paramView = paramView.getContext();
    s.s(paramView, "widget.context");
    paramm.invoke(paramView, paramString);
    AppMethodBeat.o(306449);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(306441);
    s.u(paramContext, "context");
    s.u(paramString, "username");
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("Contact_Scene", paramInt1);
    localIntent.putExtra("CONTACT_INFO_UI_SOURCE", paramInt2);
    a.pFn.c(localIntent, paramContext);
    AppMethodBeat.o(306441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.u.a
 * JD-Core Version:    0.7.0.1
 */