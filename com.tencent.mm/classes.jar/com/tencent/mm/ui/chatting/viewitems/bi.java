package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.s;

public class bi
  extends c
{
  public long AYJ;
  public int AYK;
  public boolean GQP;
  public String GQQ;
  public boolean GQR;
  public boolean GQS;
  public String GQT;
  public boolean GQU;
  public Bundle GQV;
  public s GQW;
  public int GQX = -1;
  public boolean GjM;
  public String chatroomName;
  public String dDM;
  public int dEF = 0;
  public String desc;
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public String dft;
  public k.b duP;
  public String dxA;
  public String dxz;
  public String eOT;
  public String gJt;
  public int gNZ = 0;
  public String iconUrl;
  public String jzG;
  public int pageType;
  public int position;
  public String secondUrl;
  public int tid;
  public String title;
  public String userName;
  
  public bi() {}
  
  public bi(bl parambl, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this.drF = parambl;
    this.GjM = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.GQP = false;
    this.title = paramString2;
    this.dxz = paramString3;
    this.dxA = paramString4;
    this.GQQ = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.eOT = paramString8;
  }
  
  public bi(bl parambl, String paramString)
  {
    this(paramString);
    this.drF = parambl;
  }
  
  public bi(bl parambl, String paramString1, String paramString2)
  {
    this.drF = parambl;
    this.userName = paramString1;
    this.drF = parambl;
    this.jzG = paramString2;
  }
  
  private bi(bl parambl, boolean paramBoolean, int paramInt, String paramString)
  {
    this(parambl, paramBoolean, paramInt, paramString, false, null, null, null);
  }
  
  private bi(bl parambl, boolean paramBoolean, int paramInt, String paramString, byte paramByte)
  {
    this(parambl, paramBoolean, paramInt, paramString);
  }
  
  public bi(bl parambl, boolean paramBoolean, int paramInt, String paramString, char paramChar)
  {
    this(parambl, paramBoolean, paramInt, paramString, (byte)0);
  }
  
  public bi(bl parambl, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(parambl, paramBoolean, paramInt, paramString1, (byte)0);
    this.chatroomName = paramString2;
  }
  
  public bi(bl parambl, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(parambl, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, null);
  }
  
  public bi(bl parambl, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(parambl, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
  }
  
  public bi(bl parambl, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.drF = parambl;
    this.GjM = paramBoolean1;
    this.position = paramInt;
    this.userName = paramString1;
    this.GQP = paramBoolean2;
    this.title = paramString2;
    this.dxz = paramString3;
    this.dxA = paramString4;
    this.GQQ = paramString5;
    this.dft = paramString6;
    this.eOT = paramString7;
    this.GQR = paramBoolean3;
    this.GQS = paramBoolean4;
  }
  
  private bi(String paramString)
  {
    this.userName = paramString;
  }
  
  public bi(String paramString1, String paramString2)
  {
    this.userName = paramString1;
    this.chatroomName = paramString2;
  }
  
  public static bi a(k.b paramb, bl parambl)
  {
    AppMethodBeat.i(37554);
    bi localbi = new bi();
    localbi.duP = paramb;
    localbi.drF = parambl;
    AppMethodBeat.o(37554);
    return localbi;
  }
  
  public static bi aLk(String paramString)
  {
    AppMethodBeat.i(37553);
    bi localbi = new bi();
    localbi.eOT = paramString;
    AppMethodBeat.o(37553);
    return localbi;
  }
  
  public static bi b(bl parambl, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37555);
    bi localbi = new bi();
    localbi.drF = parambl;
    localbi.GjM = paramBoolean;
    localbi.position = paramInt;
    localbi.GQU = false;
    AppMethodBeat.o(37555);
    return localbi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bi
 * JD-Core Version:    0.7.0.1
 */