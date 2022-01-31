package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;

public class az
  extends c
{
  public j.b cEn;
  public String cGN;
  public String cGO;
  public String cMO;
  public int cNH = 0;
  public String chatroomName;
  public String cqx;
  public String dGR;
  public String desc;
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public String fiM;
  public String hAg;
  public String iconUrl;
  public int pageType;
  public int position;
  public String secondUrl;
  public int tid;
  public String title;
  public long uWZ;
  public int uXa;
  public String userName;
  public boolean zYF;
  public String zYG;
  public boolean zYH;
  public boolean zYI;
  public String zYJ;
  public boolean zYK;
  public Bundle zYL;
  public q zYM;
  public int zYN;
  public boolean zvB;
  
  public az() {}
  
  public az(bi parambi, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this.cEE = parambi;
    this.zvB = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.zYF = false;
    this.title = paramString2;
    this.cGN = paramString3;
    this.cGO = paramString4;
    this.zYG = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.dGR = paramString8;
  }
  
  public az(bi parambi, String paramString)
  {
    this(paramString);
    this.cEE = parambi;
  }
  
  public az(bi parambi, String paramString1, String paramString2)
  {
    this.cEE = parambi;
    this.userName = paramString1;
    this.cEE = parambi;
    this.hAg = paramString2;
  }
  
  private az(bi parambi, boolean paramBoolean, int paramInt, String paramString)
  {
    this(parambi, paramBoolean, paramInt, paramString, false, null, null, null);
  }
  
  private az(bi parambi, boolean paramBoolean, int paramInt, String paramString, byte paramByte)
  {
    this(parambi, paramBoolean, paramInt, paramString);
  }
  
  public az(bi parambi, boolean paramBoolean, int paramInt, String paramString, char paramChar)
  {
    this(parambi, paramBoolean, paramInt, paramString, (byte)0);
  }
  
  public az(bi parambi, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(parambi, paramBoolean, paramInt, paramString1, (byte)0);
    this.chatroomName = paramString2;
  }
  
  public az(bi parambi, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(parambi, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, null);
  }
  
  public az(bi parambi, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(parambi, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
  }
  
  public az(bi parambi, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.cEE = parambi;
    this.zvB = paramBoolean1;
    this.position = paramInt;
    this.userName = paramString1;
    this.zYF = paramBoolean2;
    this.title = paramString2;
    this.cGN = paramString3;
    this.cGO = paramString4;
    this.zYG = paramString5;
    this.cqx = paramString6;
    this.dGR = paramString7;
    this.zYH = paramBoolean3;
    this.zYI = paramBoolean4;
  }
  
  private az(String paramString)
  {
    this.userName = paramString;
  }
  
  public az(String paramString1, String paramString2)
  {
    this.userName = paramString1;
    this.chatroomName = paramString2;
  }
  
  public static az a(j.b paramb, bi parambi)
  {
    AppMethodBeat.i(33444);
    az localaz = new az();
    localaz.cEn = paramb;
    localaz.cEE = parambi;
    AppMethodBeat.o(33444);
    return localaz;
  }
  
  public static az auv(String paramString)
  {
    AppMethodBeat.i(33443);
    az localaz = new az();
    localaz.dGR = paramString;
    AppMethodBeat.o(33443);
    return localaz;
  }
  
  public static az b(bi parambi, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(33445);
    az localaz = new az();
    localaz.cEE = parambi;
    localaz.zvB = paramBoolean;
    localaz.position = paramInt;
    localaz.zYK = false;
    AppMethodBeat.o(33445);
    return localaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az
 * JD-Core Version:    0.7.0.1
 */