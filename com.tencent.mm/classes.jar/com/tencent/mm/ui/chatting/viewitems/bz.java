package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.cc;

public class bz
  extends c
{
  public Bundle OMx;
  public long WMB;
  public int WMC;
  public String acdC;
  public boolean aeXN;
  public boolean aeXO;
  public boolean aeXP;
  public String aeXQ;
  public boolean aeXR;
  public Bundle aeXS;
  public ab aeXT;
  public int aeXU = -1;
  public String aeXV;
  public String aeXW;
  public String aeXX;
  public String aeXY;
  public int aeXZ;
  public int aeYa;
  public boolean aedO;
  public String businessId;
  public String chatroomName;
  public String desc;
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public String extId;
  public String finderUsername;
  public k.b hWV;
  public String iaa;
  public String iab;
  public String iconUrl;
  public String ihx;
  public int iiA = 0;
  public String kLg;
  public String nTr;
  public int olT = 0;
  public int opType;
  public int pageType;
  public String pageUrl;
  public int position;
  public String productId;
  public String secondUrl;
  public String thumbUrl;
  public int tid;
  public String title;
  public String userName;
  
  public bz() {}
  
  public bz(cc paramcc, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this.hTm = paramcc;
    this.aedO = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.aeXN = false;
    this.title = paramString2;
    this.iaa = paramString3;
    this.iab = paramString4;
    this.acdC = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.kLg = paramString8;
  }
  
  public bz(cc paramcc, String paramString)
  {
    this(paramString);
    this.hTm = paramcc;
  }
  
  public bz(cc paramcc, String paramString1, String paramString2)
  {
    this.hTm = paramcc;
    this.userName = paramString1;
    this.hTm = paramcc;
    this.pageUrl = paramString2;
  }
  
  private bz(cc paramcc, boolean paramBoolean, int paramInt, String paramString)
  {
    this(paramcc, paramBoolean, paramInt, paramString, false, null, null, null);
  }
  
  private bz(cc paramcc, boolean paramBoolean, int paramInt, String paramString, byte paramByte)
  {
    this(paramcc, paramBoolean, paramInt, paramString);
  }
  
  public bz(cc paramcc, boolean paramBoolean, int paramInt, String paramString, char paramChar)
  {
    this(paramcc, paramBoolean, paramInt, paramString, (byte)0);
  }
  
  public bz(cc paramcc, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(paramcc, paramBoolean, paramInt, paramString1, (byte)0);
    this.chatroomName = paramString2;
  }
  
  public bz(cc paramcc, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(paramcc, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, null);
  }
  
  public bz(cc paramcc, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramcc, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
  }
  
  public bz(cc paramcc, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.hTm = paramcc;
    this.aedO = paramBoolean1;
    this.position = paramInt;
    this.userName = paramString1;
    this.aeXN = paramBoolean2;
    this.title = paramString2;
    this.iaa = paramString3;
    this.iab = paramString4;
    this.acdC = paramString5;
    this.productId = paramString6;
    this.kLg = paramString7;
    this.aeXO = paramBoolean3;
    this.aeXP = paramBoolean4;
  }
  
  private bz(String paramString)
  {
    this.userName = paramString;
  }
  
  public bz(String paramString1, String paramString2)
  {
    this.userName = paramString1;
    this.chatroomName = paramString2;
  }
  
  public static bz a(k.b paramb, cc paramcc)
  {
    AppMethodBeat.i(37554);
    bz localbz = new bz();
    localbz.hWV = paramb;
    localbz.hTm = paramcc;
    AppMethodBeat.o(37554);
    return localbz;
  }
  
  public static bz b(cc paramcc, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37555);
    bz localbz = new bz();
    localbz.hTm = paramcc;
    localbz.aedO = paramBoolean;
    localbz.position = paramInt;
    localbz.aeXR = false;
    AppMethodBeat.o(37555);
    return localbz;
  }
  
  public static bz bBE(String paramString)
  {
    AppMethodBeat.i(37553);
    bz localbz = new bz();
    localbz.kLg = paramString;
    AppMethodBeat.o(37553);
    return localbz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bz
 * JD-Core Version:    0.7.0.1
 */