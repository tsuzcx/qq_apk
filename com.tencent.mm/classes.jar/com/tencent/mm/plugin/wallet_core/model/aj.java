package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gz;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.ecv;
import com.tencent.mm.protocal.protobuf.edb;
import com.tencent.mm.protocal.protobuf.edc;
import com.tencent.mm.protocal.protobuf.ede;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class aj
  extends gz
{
  public static c.a info;
  private cjx Dsj;
  public ecv Dsk;
  public edc Dsl;
  public boolean Dsm;
  public String Dsn;
  public String Dso;
  public String Dsp;
  public String Dsq;
  public String vCm;
  
  static
  {
    AppMethodBeat.i(70471);
    c.a locala = new c.a();
    locala.IBL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_region";
    locala.IBN.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "wallet_region";
    locala.columns[1] = "wallet_grey_item_buf";
    locala.IBN.put("wallet_grey_item_buf", "BLOB");
    localStringBuilder.append(" wallet_grey_item_buf BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70471);
  }
  
  public aj()
  {
    AppMethodBeat.i(70469);
    this.Dsj = new cjx();
    this.Dsk = null;
    this.Dsl = null;
    this.Dsm = false;
    this.Dsn = "";
    this.Dso = "";
    this.Dsp = "";
    this.vCm = "";
    this.Dsq = "";
    if (this.Dsk == null) {
      this.Dsk = new ecv();
    }
    if (this.Dsl == null) {
      this.Dsl = new edc();
    }
    AppMethodBeat.o(70469);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70470);
    super.convertFrom(paramCursor);
    this.Dsj = new cjx();
    try
    {
      this.Dsj = ((cjx)this.Dsj.parseFrom(this.field_wallet_grey_item_buf));
      this.Dsk = this.Dsj.Hwt;
      this.Dsl = this.Dsj.Hwu;
      this.Dsm = this.Dsj.Hwv;
      this.Dsq = "";
      paramCursor = this.Dsj.Hww.iterator();
      for (;;)
      {
        if (paramCursor.hasNext())
        {
          String str = (String)paramCursor.next();
          this.Dsq = (this.Dsq + str + "\n");
          continue;
          if (this.Dsk != null) {
            break;
          }
        }
      }
    }
    catch (Exception paramCursor)
    {
      ae.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
    }
    for (;;)
    {
      this.Dsk = new ecv();
      if (this.Dsl == null) {
        this.Dsl = new edc();
      }
      AppMethodBeat.o(70470);
      return;
      if (this.Dsj.Hwr != null)
      {
        this.Dsn = z.a(this.Dsj.Hwr.Iik);
        this.Dso = z.a(this.Dsj.Hwr.Iil);
      }
      if (this.Dsj.Hws != null)
      {
        this.Dsp = z.a(this.Dsj.Hws.Iii);
        this.vCm = z.a(this.Dsj.Hws.Iij);
      }
      ae.v("WalletRegionGreyItem", "noticeContent %s", new Object[] { this.Dsp });
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