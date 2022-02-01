package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gk;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dpq;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.protocal.protobuf.dpv;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ai
  extends gk
{
  public static c.a info;
  private bzi AhT;
  public dpq AhU;
  public dpv AhV;
  public boolean AhW;
  public String AhX;
  public String AhY;
  public String AhZ;
  public String Aia;
  public String tfm;
  
  static
  {
    AppMethodBeat.i(70471);
    c.a locala = new c.a();
    locala.EYt = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_region";
    locala.EYv.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "wallet_region";
    locala.columns[1] = "wallet_grey_item_buf";
    locala.EYv.put("wallet_grey_item_buf", "BLOB");
    localStringBuilder.append(" wallet_grey_item_buf BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70471);
  }
  
  public ai()
  {
    AppMethodBeat.i(70469);
    this.AhT = new bzi();
    this.AhU = null;
    this.AhV = null;
    this.AhW = false;
    this.AhX = "";
    this.AhY = "";
    this.AhZ = "";
    this.tfm = "";
    this.Aia = "";
    if (this.AhU == null) {
      this.AhU = new dpq();
    }
    if (this.AhV == null) {
      this.AhV = new dpv();
    }
    AppMethodBeat.o(70469);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70470);
    super.convertFrom(paramCursor);
    this.AhT = new bzi();
    try
    {
      this.AhT = ((bzi)this.AhT.parseFrom(this.field_wallet_grey_item_buf));
      this.AhU = this.AhT.DVY;
      this.AhV = this.AhT.DVZ;
      this.AhW = this.AhT.DWa;
      this.Aia = "";
      paramCursor = this.AhT.DWb.iterator();
      for (;;)
      {
        if (paramCursor.hasNext())
        {
          String str = (String)paramCursor.next();
          this.Aia = (this.Aia + str + "\n");
          continue;
          if (this.AhU != null) {
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
      this.AhU = new dpq();
      if (this.AhV == null) {
        this.AhV = new dpv();
      }
      AppMethodBeat.o(70470);
      return;
      if (this.AhT.DVW != null)
      {
        this.AhX = z.a(this.AhT.DVW.EFL);
        this.AhY = z.a(this.AhT.DVW.EFM);
      }
      if (this.AhT.DVX != null)
      {
        this.AhZ = z.a(this.AhT.DVX.EFJ);
        this.tfm = z.a(this.AhT.DVX.EFK);
      }
      ad.v("WalletRegionGreyItem", "noticeContent %s", new Object[] { this.AhZ });
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ai
 * JD-Core Version:    0.7.0.1
 */