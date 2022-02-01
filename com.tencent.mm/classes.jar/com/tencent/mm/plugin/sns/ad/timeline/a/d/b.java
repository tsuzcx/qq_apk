package com.tencent.mm.plugin.sns.ad.timeline.a.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public final class b
  extends com.tencent.mm.plugin.sns.ad.timeline.a.b<a>
{
  private int JCO = 0;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private a l(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(252008);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(252008);
      return null;
    }
    try
    {
      paramSnsInfo = paramSnsInfo.getAdInfo(this.JCO);
      if (paramSnsInfo == null)
      {
        AppMethodBeat.o(252008);
        return null;
      }
      if (paramSnsInfo.adActionType == 11)
      {
        paramSnsInfo = new com.tencent.mm.plugin.sns.ad.timeline.a.d.a.a();
        AppMethodBeat.o(252008);
        return paramSnsInfo;
      }
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(252008);
    }
    return null;
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(252006);
    this.JCO = paramInt;
    boolean bool = super.a(paramView, paramInt, paramSnsInfo, paramd);
    AppMethodBeat.o(252006);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d.b
 * JD-Core Version:    0.7.0.1
 */