package com.tencent.mm.plugin.textstatus.third;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.d.b;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/MixCustomParts;", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "()V", "backJumpType", "", "backParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "foreJumpType", "foreParts", "createRefParams", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "doJumpAuthor", "", "context", "Landroid/content/Context;", "doJumpDetail", "doJumpSource", "extParam", "Landroid/os/Bundle;", "getAuthorName", "", "getBackPart", "getForePart", "getReportFeedId", "getSourceDesc", "isHasCustomPullDown", "isHidePullDownWhenClose", "isHideSourceInfo", "isPure", "isShowSourceWhenPullDown", "isStatusValid", "onAttach", "", "textStatusID", "sourceJumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "backJumpInfos", "onDetach", "setCustomAuthorView", "container", "Landroid/widget/FrameLayout;", "setCustomSourceView", "setCustomThumbView", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends e
{
  private k TuR;
  private String TuS;
  private k TuT;
  private String TuU;
  
  public final void d(String paramString, List<TextStatusJumpInfo> paramList1, List<TextStatusJumpInfo> paramList2)
  {
    AppMethodBeat.i(290102);
    onDetach();
    Object localObject2;
    label32:
    label45:
    label62:
    label75:
    label87:
    Object localObject3;
    if (paramList2 == null)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramList1 != null) {
          break label269;
        }
        localObject1 = null;
      }
      localObject2 = i.TuX;
      if (localObject1 != null) {
        break label278;
      }
      localObject2 = null;
      this.TuT = i.bed((String)localObject2);
      if (localObject1 != null) {
        break label288;
      }
      localObject2 = null;
      this.TuU = ((String)localObject2);
      if (paramList1 != null) {
        break label298;
      }
      localObject2 = null;
      if (localObject2 != null) {
        break label316;
      }
      if (paramList2 != null) {
        break label307;
      }
      localObject2 = null;
      if (localObject2 != null) {
        break label319;
      }
      localObject3 = null;
      label95:
      if (!s.p(localObject3, this.TuU)) {
        break label335;
      }
      if ((localObject2 == null) || (b.a((TextStatusJumpInfo)localObject2, (TextStatusJumpInfo)localObject1) != true)) {
        break label329;
      }
    }
    label269:
    label278:
    label288:
    label298:
    label307:
    label316:
    label319:
    label329:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label335;
      }
      this.TuR = this.TuT;
      this.TuS = this.TuU;
      try
      {
        localObject1 = this.TuT;
        if (localObject1 != null) {
          ((k)localObject1).y(paramString, paramList2);
        }
      }
      finally
      {
        for (;;)
        {
          this.TuT = null;
          this.TuU = null;
          Log.printErrStackTrace("MicroMsg.TextStatus.StatusThirdShareManager", paramList2, "backParts onAttach err", new Object[0]);
        }
      }
      if (!s.p(this.TuT, this.TuR)) {}
      try
      {
        paramList2 = this.TuR;
        if (paramList2 != null) {
          paramList2.y(paramString, paramList1);
        }
      }
      finally
      {
        for (;;)
        {
          this.TuR = null;
          this.TuS = null;
          Log.printErrStackTrace("MicroMsg.TextStatus.StatusThirdShareManager", paramString, "foreParts onAttach err", new Object[0]);
        }
      }
      Log.i("MicroMsg.TextStatus.StatusThirdShareManager", "onAttach foreType:" + this.TuS + " foreParts:" + this.TuR + " backType:" + this.TuU + " backParts:" + this.TuT);
      AppMethodBeat.o(290102);
      return;
      localObject2 = j.lu(paramList2);
      break;
      localObject1 = j.lu(paramList1);
      break label32;
      localObject2 = ((TextStatusJumpInfo)localObject1).jumpType;
      break label45;
      localObject2 = ((TextStatusJumpInfo)localObject1).jumpType;
      break label62;
      localObject2 = j.lu(paramList1);
      break label75;
      localObject2 = j.lu(paramList2);
      break label87;
      break label87;
      localObject3 = ((TextStatusJumpInfo)localObject2).jumpType;
      break label95;
    }
    label335:
    Object localObject1 = i.TuX;
    if (localObject2 == null)
    {
      localObject1 = null;
      label348:
      this.TuR = i.bed((String)localObject1);
      if (localObject2 != null) {
        break label384;
      }
    }
    label384:
    for (localObject1 = null;; localObject1 = ((TextStatusJumpInfo)localObject2).jumpType)
    {
      this.TuS = ((String)localObject1);
      break;
      localObject1 = ((TextStatusJumpInfo)localObject2).jumpType;
      break label348;
    }
  }
  
  public final boolean d(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(290142);
    k localk = this.TuT;
    if (localk == null)
    {
      AppMethodBeat.o(290142);
      return false;
    }
    boolean bool = localk.d(paramFrameLayout);
    AppMethodBeat.o(290142);
    return bool;
  }
  
  public final boolean e(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(290129);
    k localk = this.TuR;
    if (localk == null)
    {
      AppMethodBeat.o(290129);
      return false;
    }
    boolean bool = localk.e(paramFrameLayout);
    AppMethodBeat.o(290129);
    return bool;
  }
  
  public final boolean eKU()
  {
    AppMethodBeat.i(290187);
    k localk = this.TuT;
    if (localk == null)
    {
      AppMethodBeat.o(290187);
      return true;
    }
    boolean bool = localk.eKU();
    AppMethodBeat.o(290187);
    return bool;
  }
  
  public final boolean eKV()
  {
    AppMethodBeat.i(290177);
    k localk = this.TuT;
    if (localk == null)
    {
      AppMethodBeat.o(290177);
      return true;
    }
    boolean bool = localk.eKV();
    AppMethodBeat.o(290177);
    return bool;
  }
  
  public final w eKW()
  {
    AppMethodBeat.i(290199);
    Object localObject = this.TuT;
    if (localObject == null)
    {
      AppMethodBeat.o(290199);
      return null;
    }
    localObject = ((k)localObject).eKW();
    AppMethodBeat.o(290199);
    return localObject;
  }
  
  public final String etP()
  {
    AppMethodBeat.i(290181);
    Object localObject = this.TuT;
    if (localObject == null)
    {
      AppMethodBeat.o(290181);
      return "";
    }
    localObject = ((k)localObject).etP();
    if (localObject == null)
    {
      AppMethodBeat.o(290181);
      return "";
    }
    AppMethodBeat.o(290181);
    return localObject;
  }
  
  public final boolean etQ()
  {
    AppMethodBeat.i(290193);
    k localk = this.TuT;
    if (localk == null)
    {
      AppMethodBeat.o(290193);
      return false;
    }
    boolean bool = localk.etQ();
    AppMethodBeat.o(290193);
    return bool;
  }
  
  public final CharSequence etS()
  {
    AppMethodBeat.i(290150);
    Object localObject = this.TuT;
    if (localObject == null)
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(290150);
      return localObject;
    }
    localObject = ((k)localObject).etS();
    if (localObject == null)
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(290150);
      return localObject;
    }
    AppMethodBeat.o(290150);
    return localObject;
  }
  
  public final CharSequence etT()
  {
    AppMethodBeat.i(290165);
    Object localObject = this.TuT;
    if (localObject == null)
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(290165);
      return localObject;
    }
    localObject = ((k)localObject).etT();
    if (localObject == null)
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(290165);
      return localObject;
    }
    AppMethodBeat.o(290165);
    return localObject;
  }
  
  public final boolean f(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(290156);
    k localk = this.TuT;
    if (localk == null)
    {
      AppMethodBeat.o(290156);
      return false;
    }
    boolean bool = localk.f(paramFrameLayout);
    AppMethodBeat.o(290156);
    return bool;
  }
  
  public final boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(290123);
    k localk = this.TuR;
    if (localk == null)
    {
      AppMethodBeat.o(290123);
      return false;
    }
    boolean bool = localk.g(paramContext, paramBundle);
    AppMethodBeat.o(290123);
    return bool;
  }
  
  public final boolean gz(Context paramContext)
  {
    AppMethodBeat.i(290139);
    s.u(paramContext, "context");
    k localk = this.TuT;
    if (localk == null)
    {
      AppMethodBeat.o(290139);
      return false;
    }
    boolean bool = localk.gz(paramContext);
    AppMethodBeat.o(290139);
    return bool;
  }
  
  public final k hFs()
  {
    return this.TuR;
  }
  
  public final boolean hFt()
  {
    AppMethodBeat.i(290108);
    boolean bool = s.p(this.TuT, this.TuR);
    AppMethodBeat.o(290108);
    return bool;
  }
  
  public final boolean km(Context paramContext)
  {
    AppMethodBeat.i(290133);
    k localk = this.TuT;
    if (localk == null)
    {
      AppMethodBeat.o(290133);
      return false;
    }
    boolean bool = localk.km(paramContext);
    AppMethodBeat.o(290133);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(290118);
    k localk = this.TuR;
    if (localk != null) {
      localk.onDetach();
    }
    this.TuR = null;
    this.TuS = "";
    localk = this.TuT;
    if (localk != null) {
      localk.onDetach();
    }
    this.TuT = null;
    this.TuU = "";
    AppMethodBeat.o(290118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.g
 * JD-Core Version:    0.7.0.1
 */