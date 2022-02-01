package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.hr;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.protocal.protobuf.fhq;
import com.tencent.mm.protocal.protobuf.fhw;
import com.tencent.mm.protocal.protobuf.fhx;
import com.tencent.mm.protocal.protobuf.fhz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ak
  extends hr
{
  public static IAutoDBItem.MAutoDBInfo info;
  public String EBs;
  private djt OTH;
  public fhq OTI;
  public fhx OTJ;
  public boolean OTK;
  public String OTL;
  public String OTM;
  public String OTN;
  public String OTO;
  
  static
  {
    AppMethodBeat.i(70471);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "wallet_region";
    localMAutoDBInfo.colsMap.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "wallet_region";
    localMAutoDBInfo.columns[1] = "wallet_grey_item_buf";
    localMAutoDBInfo.colsMap.put("wallet_grey_item_buf", "BLOB");
    localStringBuilder.append(" wallet_grey_item_buf BLOB");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(70471);
  }
  
  public ak()
  {
    AppMethodBeat.i(70469);
    this.OTH = new djt();
    this.OTI = null;
    this.OTJ = null;
    this.OTK = false;
    this.OTL = "";
    this.OTM = "";
    this.OTN = "";
    this.EBs = "";
    this.OTO = "";
    if (this.OTI == null) {
      this.OTI = new fhq();
    }
    if (this.OTJ == null) {
      this.OTJ = new fhx();
    }
    AppMethodBeat.o(70469);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70470);
    super.convertFrom(paramCursor);
    this.OTH = new djt();
    try
    {
      this.OTH = ((djt)this.OTH.parseFrom(this.field_wallet_grey_item_buf));
      this.OTI = this.OTH.TRe;
      this.OTJ = this.OTH.TRf;
      this.OTK = this.OTH.TRg;
      this.OTO = "";
      paramCursor = this.OTH.TRh.iterator();
      for (;;)
      {
        if (paramCursor.hasNext())
        {
          String str = (String)paramCursor.next();
          this.OTO = (this.OTO + str + "\n");
          continue;
          if (this.OTI != null) {
            break;
          }
        }
      }
    }
    catch (Exception paramCursor)
    {
      Log.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
    }
    for (;;)
    {
      this.OTI = new fhq();
      if (this.OTJ == null) {
        this.OTJ = new fhx();
      }
      AppMethodBeat.o(70470);
      return;
      if (this.OTH.TRc != null)
      {
        this.OTL = z.a(this.OTH.TRc.UHP);
        this.OTM = z.a(this.OTH.TRc.UHQ);
      }
      if (this.OTH.TRd != null)
      {
        this.OTN = z.a(this.OTH.TRd.UHN);
        this.EBs = z.a(this.OTH.TRd.UHO);
      }
      Log.v("WalletRegionGreyItem", "noticeContent %s", new Object[] { this.OTN });
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ak
 * JD-Core Version:    0.7.0.1
 */