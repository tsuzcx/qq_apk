package com.tencent.pb.common.c;

import com.tencent.pb.common.b.a;

final class f$1
  implements a
{
  public final void fb(String paramString, int paramInt)
  {
    if ("CsCmd.Cmd_CSClientReportReq".equals(paramString))
    {
      if (paramInt == 0) {
        f.clearData();
      }
      c.w("yunying", new Object[] { "reportStatisticsData isCommonData:  errCode: ".concat(String.valueOf(paramInt)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.c.f.1
 * JD-Core Version:    0.7.0.1
 */