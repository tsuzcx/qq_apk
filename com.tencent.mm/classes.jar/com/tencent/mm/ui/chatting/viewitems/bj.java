package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.t;

public class bj
  extends c
{
  public long CqW;
  public int CqX;
  public boolean HJB;
  public boolean IqQ;
  public String IqR;
  public boolean IqS;
  public boolean IqT;
  public String IqU;
  public boolean IqV;
  public Bundle IqW;
  public t IqX;
  public int IqY = -1;
  public String chatroomName;
  public String dBy;
  public int dCr = 0;
  public String dcO;
  public String desc;
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public k.b dsB;
  public String dvl;
  public String dvm;
  public String eSb;
  public String hjT;
  public int hoz = 0;
  public String iconUrl;
  public int pageType;
  public String pageUrl;
  public int position;
  public String secondUrl;
  public int tid;
  public String title;
  public String userName;
  
  public bj() {}
  
  public bj(bo parambo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this.dpq = parambo;
    this.HJB = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.IqQ = false;
    this.title = paramString2;
    this.dvl = paramString3;
    this.dvm = paramString4;
    this.IqR = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.eSb = paramString8;
  }
  
  public bj(bo parambo, String paramString)
  {
    this(paramString);
    this.dpq = parambo;
  }
  
  public bj(bo parambo, String paramString1, String paramString2)
  {
    this.dpq = parambo;
    this.userName = paramString1;
    this.dpq = parambo;
    this.pageUrl = paramString2;
  }
  
  private bj(bo parambo, boolean paramBoolean, int paramInt, String paramString)
  {
    this(parambo, paramBoolean, paramInt, paramString, false, null, null, null);
  }
  
  private bj(bo parambo, boolean paramBoolean, int paramInt, String paramString, byte paramByte)
  {
    this(parambo, paramBoolean, paramInt, paramString);
  }
  
  public bj(bo parambo, boolean paramBoolean, int paramInt, String paramString, char paramChar)
  {
    this(parambo, paramBoolean, paramInt, paramString, (byte)0);
  }
  
  public bj(bo parambo, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(parambo, paramBoolean, paramInt, paramString1, (byte)0);
    this.chatroomName = paramString2;
  }
  
  public bj(bo parambo, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(parambo, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, null);
  }
  
  public bj(bo parambo, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(parambo, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
  }
  
  public bj(bo parambo, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.dpq = parambo;
    this.HJB = paramBoolean1;
    this.position = paramInt;
    this.userName = paramString1;
    this.IqQ = paramBoolean2;
    this.title = paramString2;
    this.dvl = paramString3;
    this.dvm = paramString4;
    this.IqR = paramString5;
    this.dcO = paramString6;
    this.eSb = paramString7;
    this.IqS = paramBoolean3;
    this.IqT = paramBoolean4;
  }
  
  private bj(String paramString)
  {
    this.userName = paramString;
  }
  
  public bj(String paramString1, String paramString2)
  {
    this.userName = paramString1;
    this.chatroomName = paramString2;
  }
  
  public static bj a(k.b paramb, bo parambo)
  {
    AppMethodBeat.i(37554);
    bj localbj = new bj();
    localbj.dsB = paramb;
    localbj.dpq = parambo;
    AppMethodBeat.o(37554);
    return localbj;
  }
  
  public static bj aQO(String paramString)
  {
    AppMethodBeat.i(37553);
    bj localbj = new bj();
    localbj.eSb = paramString;
    AppMethodBeat.o(37553);
    return localbj;
  }
  
  public static bj b(bo parambo, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37555);
    bj localbj = new bj();
    localbj.dpq = parambo;
    localbj.HJB = paramBoolean;
    localbj.position = paramInt;
    localbj.IqV = false;
    AppMethodBeat.o(37555);
    return localbj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj
 * JD-Core Version:    0.7.0.1
 */