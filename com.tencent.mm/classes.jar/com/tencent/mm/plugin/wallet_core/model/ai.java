package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fm;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ai
  extends fm
{
  public static c.a info;
  public String oph;
  public cvj ulA;
  public cvo ulB;
  public boolean ulC;
  public String ulD;
  public String ulE;
  public String ulF;
  public String ulG;
  private bli ulz;
  
  static
  {
    AppMethodBeat.i(46943);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_region";
    locala.yrM.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "wallet_region";
    locala.columns[1] = "wallet_grey_item_buf";
    locala.yrM.put("wallet_grey_item_buf", "BLOB");
    localStringBuilder.append(" wallet_grey_item_buf BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(46943);
  }
  
  public ai()
  {
    AppMethodBeat.i(46941);
    this.ulz = new bli();
    this.ulA = null;
    this.ulB = null;
    this.ulC = false;
    this.ulD = "";
    this.ulE = "";
    this.ulF = "";
    this.oph = "";
    this.ulG = "";
    if (this.ulA == null) {
      this.ulA = new cvj();
    }
    if (this.ulB == null) {
      this.ulB = new cvo();
    }
    AppMethodBeat.o(46941);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(46942);
    super.convertFrom(paramCursor);
    this.ulz = new bli();
    try
    {
      this.ulz = ((bli)this.ulz.parseFrom(this.field_wallet_grey_item_buf));
      this.ulA = this.ulz.xzR;
      this.ulB = this.ulz.xzS;
      this.ulC = this.ulz.xzT;
      this.ulG = "";
      paramCursor = this.ulz.xzU.iterator();
      for (;;)
      {
        if (paramCursor.hasNext())
        {
          String str = (String)paramCursor.next();
          this.ulG = (this.ulG + str + "\n");
          continue;
          if (this.ulA != null) {
            break;
          }
        }
      }
    }
    catch (Exception paramCursor)
    {
      ab.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
    }
    for (;;)
    {
      this.ulA = new cvj();
      if (this.ulB == null) {
        this.ulB = new cvo();
      }
      AppMethodBeat.o(46942);
      return;
      if (this.ulz.xzP != null)
      {
        this.ulD = aa.a(this.ulz.xzP.ydZ);
        this.ulE = aa.a(this.ulz.xzP.yea);
      }
      if (this.ulz.xzQ != null)
      {
        this.ulF = aa.a(this.ulz.xzQ.ydX);
        this.oph = aa.a(this.ulz.xzQ.ydY);
      }
      ab.v("WalletRegionGreyItem", "noticeContent %s", new Object[] { this.ulF });
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ai
 * JD-Core Version:    0.7.0.1
 */