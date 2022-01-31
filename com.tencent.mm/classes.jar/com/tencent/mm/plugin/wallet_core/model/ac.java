package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.h.c.ew;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.chx;
import com.tencent.mm.protocal.c.cib;
import com.tencent.mm.protocal.c.cic;
import com.tencent.mm.protocal.c.cie;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ac
  extends ew
{
  public static c.a buS;
  public String lRp = "";
  private bdo qyQ = new bdo();
  public chx qyR = null;
  public cic qyS = null;
  public boolean qyT = false;
  public String qyU = "";
  public String qyV = "";
  public String qyW = "";
  public String qyX = "";
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_region";
    locala.ujN.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "wallet_region";
    locala.columns[1] = "wallet_grey_item_buf";
    locala.ujN.put("wallet_grey_item_buf", "BLOB");
    localStringBuilder.append(" wallet_grey_item_buf BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public ac()
  {
    if (this.qyR == null) {
      this.qyR = new chx();
    }
    if (this.qyS == null) {
      this.qyS = new cic();
    }
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
    this.qyQ = new bdo();
    try
    {
      this.qyQ = ((bdo)this.qyQ.aH(this.field_wallet_grey_item_buf));
      this.qyR = this.qyQ.tyJ;
      this.qyS = this.qyQ.tyK;
      this.qyT = this.qyQ.tyL;
      this.qyX = "";
      paramCursor = this.qyQ.tyM.iterator();
      for (;;)
      {
        if (paramCursor.hasNext())
        {
          String str = (String)paramCursor.next();
          this.qyX = (this.qyX + str + "\n");
          continue;
          if (this.qyR != null) {
            break;
          }
        }
      }
    }
    catch (Exception paramCursor)
    {
      y.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
    }
    for (;;)
    {
      this.qyR = new chx();
      if (this.qyS == null) {
        this.qyS = new cic();
      }
      return;
      if (this.qyQ.tyH != null)
      {
        this.qyU = aa.a(this.qyQ.tyH.tWH);
        this.qyV = aa.a(this.qyQ.tyH.tWI);
      }
      if (this.qyQ.tyI != null)
      {
        this.qyW = aa.a(this.qyQ.tyI.tWF);
        this.lRp = aa.a(this.qyQ.tyI.tWG);
      }
      y.v("WalletRegionGreyItem", "noticeContent %s", new Object[] { this.qyW });
    }
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ac
 * JD-Core Version:    0.7.0.1
 */