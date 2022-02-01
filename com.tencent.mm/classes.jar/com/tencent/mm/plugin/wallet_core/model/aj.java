package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hk;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.exd;
import com.tencent.mm.protocal.protobuf.exj;
import com.tencent.mm.protocal.protobuf.exk;
import com.tencent.mm.protocal.protobuf.exm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class aj
  extends hk
{
  public static IAutoDBItem.MAutoDBInfo info;
  public String IbA;
  public String IbB;
  public String IbC;
  private daf Ibv;
  public exd Ibw;
  public exk Ibx;
  public boolean Iby;
  public String Ibz;
  public String yXn;
  
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
  
  public aj()
  {
    AppMethodBeat.i(70469);
    this.Ibv = new daf();
    this.Ibw = null;
    this.Ibx = null;
    this.Iby = false;
    this.Ibz = "";
    this.IbA = "";
    this.IbB = "";
    this.yXn = "";
    this.IbC = "";
    if (this.Ibw == null) {
      this.Ibw = new exd();
    }
    if (this.Ibx == null) {
      this.Ibx = new exk();
    }
    AppMethodBeat.o(70469);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70470);
    super.convertFrom(paramCursor);
    this.Ibv = new daf();
    try
    {
      this.Ibv = ((daf)this.Ibv.parseFrom(this.field_wallet_grey_item_buf));
      this.Ibw = this.Ibv.MFs;
      this.Ibx = this.Ibv.MFt;
      this.Iby = this.Ibv.MFu;
      this.IbC = "";
      paramCursor = this.Ibv.MFv.iterator();
      for (;;)
      {
        if (paramCursor.hasNext())
        {
          String str = (String)paramCursor.next();
          this.IbC = (this.IbC + str + "\n");
          continue;
          if (this.Ibw != null) {
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
      this.Ibw = new exd();
      if (this.Ibx == null) {
        this.Ibx = new exk();
      }
      AppMethodBeat.o(70470);
      return;
      if (this.Ibv.MFq != null)
      {
        this.Ibz = z.a(this.Ibv.MFq.NuO);
        this.IbA = z.a(this.Ibv.MFq.NuP);
      }
      if (this.Ibv.MFr != null)
      {
        this.IbB = z.a(this.Ibv.MFr.NuM);
        this.yXn = z.a(this.Ibv.MFr.NuN);
      }
      Log.v("WalletRegionGreyItem", "noticeContent %s", new Object[] { this.IbB });
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aj
 * JD-Core Version:    0.7.0.1
 */