package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;

public class aw
  extends c
{
  public String bJd;
  public g.a bWy;
  public String bYG;
  public String bYH;
  public String cQF;
  public String ceb;
  public int cfb = 0;
  public String chatroomName;
  public String dSN;
  public String desc;
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public String iconUrl;
  public int pageType;
  public int position;
  public long rgL;
  public int rgM;
  public String secondUrl;
  public int tid;
  public String title;
  public String userName;
  public boolean vHj;
  public String vHk;
  public boolean vHl;
  public boolean vHm;
  public String vHn;
  public boolean vHo;
  public String vHp;
  public Bundle vHq;
  public q vHr;
  public int vHs;
  public boolean vgB;
  
  public aw() {}
  
  public aw(bi parambi, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this.bWO = parambi;
    this.vgB = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.vHj = false;
    this.title = paramString2;
    this.bYG = paramString3;
    this.bYH = paramString4;
    this.vHk = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.cQF = paramString8;
  }
  
  public aw(bi parambi, String paramString)
  {
    this(paramString);
    this.bWO = parambi;
  }
  
  public aw(bi parambi, String paramString1, String paramString2)
  {
    this.bWO = parambi;
    this.userName = paramString1;
    this.bWO = parambi;
    this.vHp = paramString2;
  }
  
  private aw(bi parambi, boolean paramBoolean, int paramInt, String paramString)
  {
    this(parambi, paramBoolean, paramInt, paramString, false, null, null, null);
  }
  
  private aw(bi parambi, boolean paramBoolean, int paramInt, String paramString, byte paramByte)
  {
    this(parambi, paramBoolean, paramInt, paramString);
  }
  
  public aw(bi parambi, boolean paramBoolean, int paramInt, String paramString, char paramChar)
  {
    this(parambi, paramBoolean, paramInt, paramString, (byte)0);
  }
  
  public aw(bi parambi, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(parambi, paramBoolean, paramInt, paramString1, (byte)0);
    this.chatroomName = paramString2;
  }
  
  public aw(bi parambi, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(parambi, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, null);
  }
  
  public aw(bi parambi, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(parambi, paramBoolean1, paramInt, paramString1, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
  }
  
  public aw(bi parambi, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.bWO = parambi;
    this.vgB = paramBoolean1;
    this.position = paramInt;
    this.userName = paramString1;
    this.vHj = paramBoolean2;
    this.title = paramString2;
    this.bYG = paramString3;
    this.bYH = paramString4;
    this.vHk = paramString5;
    this.bJd = paramString6;
    this.cQF = paramString7;
    this.vHl = paramBoolean3;
    this.vHm = paramBoolean4;
  }
  
  private aw(String paramString)
  {
    this.userName = paramString;
  }
  
  public aw(String paramString1, String paramString2)
  {
    this.userName = paramString1;
    this.chatroomName = paramString2;
  }
  
  public static aw a(g.a parama, bi parambi)
  {
    aw localaw = new aw();
    localaw.bWy = parama;
    localaw.bWO = parambi;
    return localaw;
  }
  
  public static aw adO(String paramString)
  {
    aw localaw = new aw();
    localaw.cQF = paramString;
    return localaw;
  }
  
  public static aw b(bi parambi, boolean paramBoolean, int paramInt)
  {
    aw localaw = new aw();
    localaw.bWO = parambi;
    localaw.vgB = paramBoolean;
    localaw.position = paramInt;
    localaw.vHo = false;
    return localaw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw
 * JD-Core Version:    0.7.0.1
 */