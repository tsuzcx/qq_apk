package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;

public class by
  extends c
{
  public Bundle IGp;
  public long PVT;
  public int PVU;
  public String UJu;
  public boolean Wwx;
  public boolean XmI;
  public boolean XmJ;
  public boolean XmK;
  public String XmL;
  public boolean XmM;
  public Bundle XmN;
  public z XmO;
  public int XmP = -1;
  public String XmQ;
  public String XmR;
  public String XmS;
  public int XmT;
  public int XmU;
  public String chatroomName;
  public String desc;
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public k.b fQY;
  public String fUd;
  public String fUe;
  public String finderUsername;
  public String gbn;
  public int gco = 0;
  public String iconUrl;
  public String ilh;
  public String loo;
  public int luu = 0;
  public int opType;
  public int pageType;
  public String pageUrl;
  public int position;
  public String productId;
  public String secondUrl;
  public int tid;
  public String title;
  public String userName;
  
  public by() {}
  
  public by(ca paramca, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this.fNz = paramca;
    this.Wwx = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.XmI = false;
    this.title = paramString2;
    this.fUd = paramString3;
    this.fUe = paramString4;
    this.UJu = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.ilh = paramString8;
  }
  
  public by(ca paramca, String paramString)
  {
    this(paramString);
    this.fNz = paramca;
  }
  
  public by(ca paramca, String paramString1, String paramString2)
  {
    this.fNz = paramca;
    this.userName = paramString1;
    this.fNz = paramca;
    this.pageUrl = paramString2;
  }
  
  private by(ca paramca, boolean paramBoolean, int paramInt, String paramString)
  {
    this(paramca, paramBoolean, paramInt, paramString, false, null, null, null);
  }
  
  private by(ca paramca, boolean paramBoolean, int paramInt, String paramString, byte paramByte)
  {
    this(paramca, paramBoolean, paramInt, paramString);
  }
  
  public by(ca paramca, boolean paramBoolean, int paramInt, String paramString, char paramChar)
  {
    this(paramca, paramBoolean, paramInt, paramString, (byte)0);
  }
  
  public by(ca paramca, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(paramca, paramBoolean, paramInt, paramString1, (byte)0);
    this.chatroomName = paramString2;
  }
  
  public by(ca paramca, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(paramca, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, null);
  }
  
  public by(ca paramca, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramca, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
  }
  
  public by(ca paramca, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.fNz = paramca;
    this.Wwx = paramBoolean1;
    this.position = paramInt;
    this.userName = paramString1;
    this.XmI = paramBoolean2;
    this.title = paramString2;
    this.fUd = paramString3;
    this.fUe = paramString4;
    this.UJu = paramString5;
    this.productId = paramString6;
    this.ilh = paramString7;
    this.XmJ = paramBoolean3;
    this.XmK = paramBoolean4;
  }
  
  private by(String paramString)
  {
    this.userName = paramString;
  }
  
  public by(String paramString1, String paramString2)
  {
    this.userName = paramString1;
    this.chatroomName = paramString2;
  }
  
  public static by a(k.b paramb, ca paramca)
  {
    AppMethodBeat.i(37554);
    by localby = new by();
    localby.fQY = paramb;
    localby.fNz = paramca;
    AppMethodBeat.o(37554);
    return localby;
  }
  
  public static by b(ca paramca, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37555);
    by localby = new by();
    localby.fNz = paramca;
    localby.Wwx = paramBoolean;
    localby.position = paramInt;
    localby.XmM = false;
    AppMethodBeat.o(37555);
    return localby;
  }
  
  public static by bzO(String paramString)
  {
    AppMethodBeat.i(37553);
    by localby = new by();
    localby.ilh = paramString;
    AppMethodBeat.o(37553);
    return localby;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.by
 * JD-Core Version:    0.7.0.1
 */