package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.w;

public class bk
  extends c
{
  public long DUA;
  public int DUB;
  public boolean Jxs;
  public w KhA;
  public int KhB = -1;
  public int KhC;
  public String KhD;
  public boolean Kht;
  public String Khu;
  public boolean Khv;
  public boolean Khw;
  public String Khx;
  public boolean Khy;
  public Bundle Khz;
  public String chatroomName;
  public k.b dEu;
  public String dHo;
  public String dHp;
  public String dNL;
  public int dOE = 0;
  public String desc;
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public String dok;
  public String fkq;
  public String hCc;
  public int hGR = 0;
  public String iconUrl;
  public int pageType;
  public String pageUrl;
  public int position;
  public String secondUrl;
  public int tid;
  public String title;
  public String userName;
  
  public bk() {}
  
  public bk(bu parambu, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this.dBd = parambu;
    this.Jxs = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.Kht = false;
    this.title = paramString2;
    this.dHo = paramString3;
    this.dHp = paramString4;
    this.Khu = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.fkq = paramString8;
  }
  
  public bk(bu parambu, String paramString)
  {
    this(paramString);
    this.dBd = parambu;
  }
  
  public bk(bu parambu, String paramString1, String paramString2)
  {
    this.dBd = parambu;
    this.userName = paramString1;
    this.dBd = parambu;
    this.pageUrl = paramString2;
  }
  
  private bk(bu parambu, boolean paramBoolean, int paramInt, String paramString)
  {
    this(parambu, paramBoolean, paramInt, paramString, false, null, null, null);
  }
  
  private bk(bu parambu, boolean paramBoolean, int paramInt, String paramString, byte paramByte)
  {
    this(parambu, paramBoolean, paramInt, paramString);
  }
  
  public bk(bu parambu, boolean paramBoolean, int paramInt, String paramString, char paramChar)
  {
    this(parambu, paramBoolean, paramInt, paramString, (byte)0);
  }
  
  public bk(bu parambu, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(parambu, paramBoolean, paramInt, paramString1, (byte)0);
    this.chatroomName = paramString2;
  }
  
  public bk(bu parambu, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(parambu, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, null);
  }
  
  public bk(bu parambu, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(parambu, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
  }
  
  public bk(bu parambu, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.dBd = parambu;
    this.Jxs = paramBoolean1;
    this.position = paramInt;
    this.userName = paramString1;
    this.Kht = paramBoolean2;
    this.title = paramString2;
    this.dHo = paramString3;
    this.dHp = paramString4;
    this.Khu = paramString5;
    this.dok = paramString6;
    this.fkq = paramString7;
    this.Khv = paramBoolean3;
    this.Khw = paramBoolean4;
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
  
  public static bk a(k.b paramb, bu parambu)
  {
    AppMethodBeat.i(37554);
    bk localbk = new bk();
    localbk.dEu = paramb;
    localbk.dBd = parambu;
    AppMethodBeat.o(37554);
    return localbk;
  }
  
  public static bk aWI(String paramString)
  {
    AppMethodBeat.i(37553);
    bk localbk = new bk();
    localbk.fkq = paramString;
    AppMethodBeat.o(37553);
    return localbk;
  }
  
  public static bk b(bu parambu, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37555);
    bk localbk = new bk();
    localbk.dBd = parambu;
    localbk.Jxs = paramBoolean;
    localbk.position = paramInt;
    localbk.Khy = false;
    AppMethodBeat.o(37555);
    return localbk;
  }
  
  public final bk aWJ(String paramString)
  {
    this.dNL = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk
 * JD-Core Version:    0.7.0.1
 */