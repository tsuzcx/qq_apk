package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gy;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebk;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class aj
  extends gy
{
  public static c.a info;
  private cjd DaF;
  public ebe DaG;
  public ebl DaH;
  public boolean DaI;
  public String DaJ;
  public String DaK;
  public String DaL;
  public String DaM;
  public String vqh;
  
  static
  {
    AppMethodBeat.i(70471);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_region";
    locala.IhC.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "wallet_region";
    locala.columns[1] = "wallet_grey_item_buf";
    locala.IhC.put("wallet_grey_item_buf", "BLOB");
    localStringBuilder.append(" wallet_grey_item_buf BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70471);
  }
  
  public aj()
  {
    AppMethodBeat.i(70469);
    this.DaF = new cjd();
    this.DaG = null;
    this.DaH = null;
    this.DaI = false;
    this.DaJ = "";
    this.DaK = "";
    this.DaL = "";
    this.vqh = "";
    this.DaM = "";
    if (this.DaG == null) {
      this.DaG = new ebe();
    }
    if (this.DaH == null) {
      this.DaH = new ebl();
    }
    AppMethodBeat.o(70469);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70470);
    super.convertFrom(paramCursor);
    this.DaF = new cjd();
    try
    {
      this.DaF = ((cjd)this.DaF.parseFrom(this.field_wallet_grey_item_buf));
      this.DaG = this.DaF.HcT;
      this.DaH = this.DaF.HcU;
      this.DaI = this.DaF.HcV;
      this.DaM = "";
      paramCursor = this.DaF.HcW.iterator();
      for (;;)
      {
        if (paramCursor.hasNext())
        {
          String str = (String)paramCursor.next();
          this.DaM = (this.DaM + str + "\n");
          continue;
          if (this.DaG != null) {
            break;
          }
        }
      }
    }
    catch (Exception paramCursor)
    {
      ad.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
    }
    for (;;)
    {
      this.DaG = new ebe();
      if (this.DaH == null) {
        this.DaH = new ebl();
      }
      AppMethodBeat.o(70470);
      return;
      if (this.DaF.HcR != null)
      {
        this.DaJ = z.a(this.DaF.HcR.HOd);
        this.DaK = z.a(this.DaF.HcR.HOe);
      }
      if (this.DaF.HcS != null)
      {
        this.DaL = z.a(this.DaF.HcS.HOb);
        this.vqh = z.a(this.DaF.HcS.HOc);
      }
      ad.v("WalletRegionGreyItem", "noticeContent %s", new Object[] { this.DaL });
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aj
 * JD-Core Version:    0.7.0.1
 */