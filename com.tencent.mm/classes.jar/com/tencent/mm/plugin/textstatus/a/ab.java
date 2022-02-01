package com.tencent.mm.plugin.textstatus.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.textstatus.i.e;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.util.a;
import com.tencent.mm.plugin.textstatus.util.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"beforeJump", "", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "isJumpPick", "", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ab
{
  public static final void a(w paramw)
  {
    AppMethodBeat.i(289807);
    s.u(paramw, "<this>");
    paramw.enterTime = cn.bDw();
    CharSequence localCharSequence = (CharSequence)paramw.sessionId;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramw.sessionId = e.Tru.getSessionId();
      }
      AppMethodBeat.o(289807);
      return;
    }
  }
  
  public static final boolean b(w paramw)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(289813);
    s.u(paramw, "<this>");
    if (paramw.Too == 1)
    {
      AppMethodBeat.o(289813);
      return false;
    }
    Object localObject1;
    if (ac.hGp())
    {
      localObject1 = paramw.Tog;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label109;
        }
        paramw = paramw.Tog;
        if (paramw != null) {
          break label101;
        }
      }
      label101:
      for (paramw = localObject3;; paramw = paramw.topicInfo)
      {
        if (paramw != null) {
          paramw.iconId = "userdefine";
        }
        AppMethodBeat.o(289813);
        return false;
        localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((TextStatusTopicInfo)localObject1).iconId;
        break;
      }
    }
    label109:
    paramw = paramw.Tog;
    if (paramw == null) {
      paramw = localObject2;
    }
    while ((TextUtils.isEmpty((CharSequence)paramw)) || (!b.hKh().beh(paramw)))
    {
      AppMethodBeat.o(289813);
      return true;
      localObject1 = paramw.topicInfo;
      paramw = localObject2;
      if (localObject1 != null) {
        paramw = ((TextStatusTopicInfo)localObject1).iconId;
      }
    }
    AppMethodBeat.o(289813);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.ab
 * JD-Core Version:    0.7.0.1
 */