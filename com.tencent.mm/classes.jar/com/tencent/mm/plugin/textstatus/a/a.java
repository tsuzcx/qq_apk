package com.tencent.mm.plugin.textstatus.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import java.util.Set;

public final class a
{
  public static Set<String> Thq;
  
  static
  {
    AppMethodBeat.i(289805);
    Thq = new a.1();
    AppMethodBeat.o(289805);
  }
  
  public static TextStatusJumpInfo hFn()
  {
    AppMethodBeat.i(289799);
    TextStatusJumpInfo localTextStatusJumpInfo = new TextStatusJumpInfo();
    localTextStatusJumpInfo.jumpType = "3";
    localTextStatusJumpInfo.busiBuf = "https://support.weixin.qq.com/security/readtemplate?t=w_security_center_website/upgrade&scene=1#wechat_redirect";
    AppMethodBeat.o(289799);
    return localTextStatusJumpInfo;
  }
  
  public static int ki(Context paramContext)
  {
    AppMethodBeat.i(289772);
    int i = kk(paramContext)[1];
    int j = kl(paramContext)[1];
    AppMethodBeat.o(289772);
    return i - j;
  }
  
  public static boolean kj(Context paramContext)
  {
    AppMethodBeat.i(289776);
    paramContext = ao.mX(paramContext);
    int i = paramContext.width;
    if (paramContext.height / i > 0.8F)
    {
      AppMethodBeat.o(289776);
      return true;
    }
    AppMethodBeat.o(289776);
    return false;
  }
  
  public static int[] kk(Context paramContext)
  {
    AppMethodBeat.i(289786);
    paramContext = ao.mX(paramContext);
    int i = paramContext.width;
    int j = paramContext.height;
    int k = (int)(i * 1.777778F);
    paramContext = new int[2];
    if (k <= j)
    {
      paramContext[0] = i;
      paramContext[1] = k;
    }
    for (;;)
    {
      AppMethodBeat.o(289786);
      return paramContext;
      paramContext[0] = i;
      paramContext[1] = j;
    }
  }
  
  public static int[] kl(Context paramContext)
  {
    AppMethodBeat.i(289793);
    paramContext = kk(paramContext);
    paramContext[1] = ((int)(paramContext[1] / 1.777778F));
    AppMethodBeat.o(289793);
    return paramContext;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(289803);
      ThD = new b("CONVERSATION_LIST", 0);
      ThE = new b("CONTACT_LIST", 1);
      ThF = new b("GROUP_CHAT", 2);
      ThG = new b("SNS_FEED", 3);
      ThH = new b("SNS_COMMENT", 4);
      ThI = new b("SNS_NOTIFICATION", 5);
      ThJ = new b("PLANET", 6);
      ThK = new b("PATMSG_WITH_BG", 7);
      ThL = new b("PATMSG_NO_BG", 8);
      ThM = new b("PRIVATE_CONVERSATION_LIST", 9);
      ThN = new b[] { ThD, ThE, ThF, ThG, ThH, ThI, ThJ, ThK, ThL, ThM };
      AppMethodBeat.o(289803);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.a
 * JD-Core Version:    0.7.0.1
 */