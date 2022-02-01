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
  private int DxM = 0;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private a l(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202120);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(202120);
      return null;
    }
    try
    {
      paramSnsInfo = paramSnsInfo.getAdInfo(this.DxM);
      if (paramSnsInfo == null)
      {
        AppMethodBeat.o(202120);
        return null;
      }
      if (paramSnsInfo.adActionType == 11)
      {
        paramSnsInfo = new com.tencent.mm.plugin.sns.ad.timeline.a.d.a.a();
        AppMethodBeat.o(202120);
        return paramSnsInfo;
      }
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(202120);
    }
    return null;
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(202119);
    this.DxM = paramInt;
    boolean bool = super.a(paramView, paramInt, paramSnsInfo, paramd);
    AppMethodBeat.o(202119);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d.b
 * JD-Core Version:    0.7.0.1
 */