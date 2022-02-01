package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.w;

public class bk
  extends c
{
  public int EmA;
  public long Emz;
  public boolean JSi;
  public boolean KDO;
  public String KDP;
  public boolean KDQ;
  public boolean KDR;
  public String KDS;
  public boolean KDT;
  public Bundle KDU;
  public w KDV;
  public int KDW = -1;
  public String KDX;
  public String chatroomName;
  public k.b dFz;
  public String dIt;
  public String dIu;
  public int dPU = 0;
  public String dPb;
  public String desc;
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public String dpp;
  public String fmn;
  public String hEQ;
  public int hJJ = 0;
  public String iconUrl;
  public int opType;
  public int pageType;
  public String pageUrl;
  public int position;
  public String secondUrl;
  public int tid;
  public String title;
  public String userName;
  
  public bk() {}
  
  public bk(bv parambv, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this.dCi = parambv;
    this.JSi = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.KDO = false;
    this.title = paramString2;
    this.dIt = paramString3;
    this.dIu = paramString4;
    this.KDP = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.fmn = paramString8;
  }
  
  public bk(bv parambv, String paramString)
  {
    this(paramString);
    this.dCi = parambv;
  }
  
  public bk(bv parambv, String paramString1, String paramString2)
  {
    this.dCi = parambv;
    this.userName = paramString1;
    this.dCi = parambv;
    this.pageUrl = paramString2;
  }
  
  private bk(bv parambv, boolean paramBoolean, int paramInt, String paramString)
  {
    this(parambv, paramBoolean, paramInt, paramString, false, null, null, null);
  }
  
  private bk(bv parambv, boolean paramBoolean, int paramInt, String paramString, byte paramByte)
  {
    this(parambv, paramBoolean, paramInt, paramString);
  }
  
  public bk(bv parambv, boolean paramBoolean, int paramInt, String paramString, char paramChar)
  {
    this(parambv, paramBoolean, paramInt, paramString, (byte)0);
  }
  
  public bk(bv parambv, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(parambv, paramBoolean, paramInt, paramString1, (byte)0);
    this.chatroomName = paramString2;
  }
  
  public bk(bv parambv, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(parambv, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, null);
  }
  
  public bk(bv parambv, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(parambv, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
  }
  
  public bk(bv parambv, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.dCi = parambv;
    this.JSi = paramBoolean1;
    this.position = paramInt;
    this.userName = paramString1;
    this.KDO = paramBoolean2;
    this.title = paramString2;
    this.dIt = paramString3;
    this.dIu = paramString4;
    this.KDP = paramString5;
    this.dpp = paramString6;
    this.fmn = paramString7;
    this.KDQ = paramBoolean3;
    this.KDR = paramBoolean4;
  }
  
  private bk(String paramString)
  {
    this.userName = paramString;
  }
  
  public bk(String paramString1, String paramString2)
  {
    this.userName = paramString1;
    this.chatroomName = paramString2;
  }
  
  public static bk a(k.b paramb, bv parambv)
  {
    AppMethodBeat.i(37554);
    bk localbk = new bk();
    localbk.dFz = paramb;
    localbk.dCi = parambv;
    AppMethodBeat.o(37554);
    return localbk;
  }
  
  public static bk aYj(String paramString)
  {
    AppMethodBeat.i(37553);
    bk localbk = new bk();
    localbk.fmn = paramString;
    AppMethodBeat.o(37553);
    return localbk;
  }
  
  public static bk b(bv parambv, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37555);
    bk localbk = new bk();
    localbk.dCi = parambv;
    localbk.JSi = paramBoolean;
    localbk.position = paramInt;
    localbk.KDT = false;
    AppMethodBeat.o(37555);
    return localbk;
  }
  
  public final bk aYk(String paramString)
  {
    this.dPb = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk
 * JD-Core Version:    0.7.0.1
 */