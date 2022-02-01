package com.tencent.mm.plugin.textstatus.j;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.q;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.ui.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/third/MixCustomParts;", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "()V", "backJumpType", "", "backParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "foreJumpType", "foreParts", "createRefParams", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "doJumpAuthor", "", "context", "Landroid/content/Context;", "doJumpDetail", "doJumpSource", "getAuthorName", "", "getReportFeedId", "getSourceDesc", "isHasCustomPullDown", "isHidePullDownWhenClose", "isHideSourceInfo", "isPure", "isShowSourceWhenPullDown", "isStatusValid", "onAttach", "", "textStatusID", "sourceJumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "backJumpInfos", "onDetach", "setCustomAuthorView", "container", "Landroid/widget/FrameLayout;", "setCustomSourceView", "setCustomThumbView", "plugin-textstatus_release"})
public final class c
  extends com.tencent.mm.plugin.textstatus.a.c
{
  private i MIR;
  private String MIS;
  private i MIT;
  private String MIU;
  
  public final void c(String paramString, List<TextStatusJumpInfo> paramList1, List<TextStatusJumpInfo> paramList2)
  {
    AppMethodBeat.i(235737);
    onDetach();
    Object localObject1;
    if (paramList2 != null)
    {
      localObject2 = e.in(paramList2);
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      if (paramList1 == null) {
        break label278;
      }
      localObject1 = e.in(paramList1);
    }
    Object localObject2 = d.MIW;
    if (localObject1 != null)
    {
      localObject2 = ((TextStatusJumpInfo)localObject1).jumpType;
      label55:
      this.MIT = d.beE((String)localObject2);
      if (localObject1 == null) {
        break label290;
      }
      localObject2 = ((TextStatusJumpInfo)localObject1).jumpType;
      label76:
      this.MIU = ((String)localObject2);
      if (paramList1 != null)
      {
        localObject2 = e.in(paramList1);
        if (localObject2 != null) {
          break label419;
        }
      }
      if (paramList2 == null) {
        break label296;
      }
      localObject2 = e.in(paramList2);
    }
    label278:
    label290:
    label419:
    for (;;)
    {
      label107:
      if (localObject2 != null) {}
      for (String str = ((TextStatusJumpInfo)localObject2).jumpType;; str = null)
      {
        if ((!p.h(str, this.MIU)) || (localObject2 == null) || (k.a((TextStatusJumpInfo)localObject2, (TextStatusJumpInfo)localObject1) != true)) {
          break label308;
        }
        this.MIR = this.MIT;
        this.MIS = this.MIU;
        try
        {
          localObject1 = this.MIT;
          if (localObject1 != null) {
            ((i)localObject1).s(paramString, paramList2);
          }
        }
        catch (Throwable paramList2)
        {
          for (;;)
          {
            this.MIT = null;
            this.MIU = null;
            Log.printErrStackTrace("MicroMsg.TextStatus.StatusThirdShareManager", paramList2, "backParts onAttach err", new Object[0]);
          }
        }
        if ((p.h(this.MIT, this.MIR) ^ true)) {}
        try
        {
          paramList2 = this.MIR;
          if (paramList2 != null) {
            paramList2.s(paramString, paramList1);
          }
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            this.MIR = null;
            this.MIS = null;
            Log.printErrStackTrace("MicroMsg.TextStatus.StatusThirdShareManager", paramString, "foreParts onAttach err", new Object[0]);
          }
        }
        Log.i("MicroMsg.TextStatus.StatusThirdShareManager", "onAttach foreType:" + this.MIS + " foreParts:" + this.MIR + " backType:" + this.MIU + " backParts:" + this.MIT);
        AppMethodBeat.o(235737);
        return;
        localObject1 = null;
        break;
        localObject2 = null;
        break label55;
        localObject2 = null;
        break label76;
        label296:
        localObject2 = null;
        break label107;
      }
      label308:
      localObject1 = d.MIW;
      if (localObject2 != null)
      {
        localObject1 = ((TextStatusJumpInfo)localObject2).jumpType;
        label325:
        this.MIR = d.beE((String)localObject1);
        if (localObject2 == null) {
          break label361;
        }
      }
      label361:
      for (localObject1 = ((TextStatusJumpInfo)localObject2).jumpType;; localObject1 = null)
      {
        this.MIS = ((String)localObject1);
        break;
        localObject1 = null;
        break label325;
      }
    }
  }
  
  public final boolean d(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(235760);
    i locali = this.MIT;
    if (locali != null)
    {
      boolean bool = locali.d(paramFrameLayout);
      AppMethodBeat.o(235760);
      return bool;
    }
    AppMethodBeat.o(235760);
    return false;
  }
  
  public final String dDG()
  {
    AppMethodBeat.i(235770);
    Object localObject = this.MIT;
    if (localObject != null)
    {
      String str = ((i)localObject).dDG();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(235770);
    return localObject;
  }
  
  public final boolean dDH()
  {
    AppMethodBeat.i(235774);
    i locali = this.MIT;
    if (locali != null)
    {
      boolean bool = locali.dDH();
      AppMethodBeat.o(235774);
      return bool;
    }
    AppMethodBeat.o(235774);
    return false;
  }
  
  public final CharSequence dDJ()
  {
    AppMethodBeat.i(235762);
    Object localObject = this.MIT;
    if (localObject != null)
    {
      CharSequence localCharSequence = ((i)localObject).dDJ();
      localObject = localCharSequence;
      if (localCharSequence != null) {}
    }
    else
    {
      localObject = (CharSequence)"";
    }
    AppMethodBeat.o(235762);
    return localObject;
  }
  
  public final CharSequence dDK()
  {
    AppMethodBeat.i(235766);
    Object localObject = this.MIT;
    if (localObject != null)
    {
      CharSequence localCharSequence = ((i)localObject).dDK();
      localObject = localCharSequence;
      if (localCharSequence != null) {}
    }
    else
    {
      localObject = (CharSequence)"";
    }
    AppMethodBeat.o(235766);
    return localObject;
  }
  
  public final boolean dDL()
  {
    AppMethodBeat.i(235754);
    i locali = this.MIR;
    if (locali != null)
    {
      boolean bool = locali.dDL();
      AppMethodBeat.o(235754);
      return bool;
    }
    AppMethodBeat.o(235754);
    return false;
  }
  
  public final boolean dOW()
  {
    AppMethodBeat.i(235772);
    i locali = this.MIT;
    if (locali != null)
    {
      boolean bool = locali.dOW();
      AppMethodBeat.o(235772);
      return bool;
    }
    AppMethodBeat.o(235772);
    return true;
  }
  
  public final boolean dOX()
  {
    AppMethodBeat.i(235768);
    i locali = this.MIT;
    if (locali != null)
    {
      boolean bool = locali.dOX();
      AppMethodBeat.o(235768);
      return bool;
    }
    AppMethodBeat.o(235768);
    return true;
  }
  
  public final q dOY()
  {
    AppMethodBeat.i(235775);
    Object localObject = this.MIT;
    if (localObject != null)
    {
      localObject = ((i)localObject).dOY();
      AppMethodBeat.o(235775);
      return localObject;
    }
    AppMethodBeat.o(235775);
    return null;
  }
  
  public final boolean e(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(235749);
    i locali = this.MIR;
    if (locali != null)
    {
      boolean bool = locali.e(paramFrameLayout);
      AppMethodBeat.o(235749);
      return bool;
    }
    AppMethodBeat.o(235749);
    return false;
  }
  
  public final boolean f(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(235764);
    i locali = this.MIT;
    if (locali != null)
    {
      boolean bool = locali.f(paramFrameLayout);
      AppMethodBeat.o(235764);
      return bool;
    }
    AppMethodBeat.o(235764);
    return false;
  }
  
  public final boolean fA(Context paramContext)
  {
    AppMethodBeat.i(235759);
    p.k(paramContext, "context");
    i locali = this.MIT;
    if (locali != null)
    {
      boolean bool = locali.fA(paramContext);
      AppMethodBeat.o(235759);
      return bool;
    }
    AppMethodBeat.o(235759);
    return false;
  }
  
  public final boolean ffP()
  {
    AppMethodBeat.i(235751);
    i locali = this.MIR;
    if (locali != null)
    {
      boolean bool = locali.ffP();
      AppMethodBeat.o(235751);
      return bool;
    }
    AppMethodBeat.o(235751);
    return false;
  }
  
  public final boolean fz(Context paramContext)
  {
    AppMethodBeat.i(235745);
    i locali = this.MIR;
    if (locali != null)
    {
      boolean bool = locali.fz(paramContext);
      AppMethodBeat.o(235745);
      return bool;
    }
    AppMethodBeat.o(235745);
    return false;
  }
  
  public final boolean gkH()
  {
    AppMethodBeat.i(235741);
    boolean bool = p.h(this.MIT, this.MIR);
    AppMethodBeat.o(235741);
    return bool;
  }
  
  public final boolean iv(Context paramContext)
  {
    AppMethodBeat.i(235756);
    i locali = this.MIT;
    if (locali != null)
    {
      boolean bool = locali.iv(paramContext);
      AppMethodBeat.o(235756);
      return bool;
    }
    AppMethodBeat.o(235756);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(235742);
    i locali = this.MIR;
    if (locali != null) {
      locali.onDetach();
    }
    this.MIR = null;
    this.MIS = "";
    locali = this.MIT;
    if (locali != null) {
      locali.onDetach();
    }
    this.MIT = null;
    this.MIU = "";
    AppMethodBeat.o(235742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.c
 * JD-Core Version:    0.7.0.1
 */