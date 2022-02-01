package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;

public class bq
  extends c
{
  public Bundle CAJ;
  public long IZC;
  public int IZD;
  public String Nwj;
  public boolean PQC;
  public boolean PQD;
  public boolean PQE;
  public String PQF;
  public boolean PQG;
  public Bundle PQH;
  public z PQI;
  public int PQJ = -1;
  public String PQK;
  public boolean Pdm;
  public String chatroomName;
  public k.b dXm;
  public String desc;
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public String eag;
  public String eah;
  public String egX;
  public int ehX = 0;
  public String fQR;
  public int iEt = 0;
  public String iconUrl;
  public String iyW;
  public int opType;
  public int pageType;
  public String pageUrl;
  public int position;
  public String productId;
  public String secondUrl;
  public int tid;
  public String title;
  public String userName;
  
  public bq() {}
  
  public bq(ca paramca, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this.dTX = paramca;
    this.Pdm = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.PQC = false;
    this.title = paramString2;
    this.eag = paramString3;
    this.eah = paramString4;
    this.Nwj = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.fQR = paramString8;
  }
  
  public bq(ca paramca, String paramString)
  {
    this(paramString);
    this.dTX = paramca;
  }
  
  public bq(ca paramca, String paramString1, String paramString2)
  {
    this.dTX = paramca;
    this.userName = paramString1;
    this.dTX = paramca;
    this.pageUrl = paramString2;
  }
  
  private bq(ca paramca, boolean paramBoolean, int paramInt, String paramString)
  {
    this(paramca, paramBoolean, paramInt, paramString, false, null, null, null);
  }
  
  private bq(ca paramca, boolean paramBoolean, int paramInt, String paramString, byte paramByte)
  {
    this(paramca, paramBoolean, paramInt, paramString);
  }
  
  public bq(ca paramca, boolean paramBoolean, int paramInt, String paramString, char paramChar)
  {
    this(paramca, paramBoolean, paramInt, paramString, (byte)0);
  }
  
  public bq(ca paramca, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(paramca, paramBoolean, paramInt, paramString1, (byte)0);
    this.chatroomName = paramString2;
  }
  
  public bq(ca paramca, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(paramca, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, null);
  }
  
  public bq(ca paramca, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramca, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
  }
  
  public bq(ca paramca, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.dTX = paramca;
    this.Pdm = paramBoolean1;
    this.position = paramInt;
    this.userName = paramString1;
    this.PQC = paramBoolean2;
    this.title = paramString2;
    this.eag = paramString3;
    this.eah = paramString4;
    this.Nwj = paramString5;
    this.productId = paramString6;
    this.fQR = paramString7;
    this.PQD = paramBoolean3;
    this.PQE = paramBoolean4;
  }
  
  private bq(String paramString)
  {
    this.userName = paramString;
  }
  
  public bq(String paramString1, String paramString2)
  {
    this.userName = paramString1;
    this.chatroomName = paramString2;
  }
  
  public static bq a(k.b paramb, ca paramca)
  {
    AppMethodBeat.i(37554);
    bq localbq = new bq();
    localbq.dXm = paramb;
    localbq.dTX = paramca;
    AppMethodBeat.o(37554);
    return localbq;
  }
  
  public static bq b(ca paramca, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37555);
    bq localbq = new bq();
    localbq.dTX = paramca;
    localbq.Pdm = paramBoolean;
    localbq.position = paramInt;
    localbq.PQG = false;
    AppMethodBeat.o(37555);
    return localbq;
  }
  
  public static bq bnn(String paramString)
  {
    AppMethodBeat.i(37553);
    bq localbq = new bq();
    localbq.fQR = paramString;
    AppMethodBeat.o(37553);
    return localbq;
  }
  
  public final bq bno(String paramString)
  {
    this.egX = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bq
 * JD-Core Version:    0.7.0.1
 */