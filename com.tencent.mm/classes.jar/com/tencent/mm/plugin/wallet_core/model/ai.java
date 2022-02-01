package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.go;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ai
  extends go
{
  public static c.a info;
  private cee BAn;
  public dvh BAo;
  public dvm BAp;
  public boolean BAq;
  public String BAr;
  public String BAs;
  public String BAt;
  public String BAu;
  public String unB;
  
  static
  {
    AppMethodBeat.i(70471);
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_region";
    locala.GvH.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "wallet_region";
    locala.columns[1] = "wallet_grey_item_buf";
    locala.GvH.put("wallet_grey_item_buf", "BLOB");
    localStringBuilder.append(" wallet_grey_item_buf BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70471);
  }
  
  public ai()
  {
    AppMethodBeat.i(70469);
    this.BAn = new cee();
    this.BAo = null;
    this.BAp = null;
    this.BAq = false;
    this.BAr = "";
    this.BAs = "";
    this.BAt = "";
    this.unB = "";
    this.BAu = "";
    if (this.BAo == null) {
      this.BAo = new dvh();
    }
    if (this.BAp == null) {
      this.BAp = new dvm();
    }
    AppMethodBeat.o(70469);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70470);
    super.convertFrom(paramCursor);
    this.BAn = new cee();
    try
    {
      this.BAn = ((cee)this.BAn.parseFrom(this.field_wallet_grey_item_buf));
      this.BAo = this.BAn.FsM;
      this.BAp = this.BAn.FsN;
      this.BAq = this.BAn.FsO;
      this.BAu = "";
      paramCursor = this.BAn.FsP.iterator();
      for (;;)
      {
        if (paramCursor.hasNext())
        {
          String str = (String)paramCursor.next();
          this.BAu = (this.BAu + str + "\n");
          continue;
          if (this.BAo != null) {
            break;
          }
        }
      }
    }
    catch (Exception paramCursor)
    {
      ac.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
    }
    for (;;)
    {
      this.BAo = new dvh();
      if (this.BAp == null) {
        this.BAp = new dvm();
      }
      AppMethodBeat.o(70470);
      return;
      if (this.BAn.FsK != null)
      {
        this.BAr = z.a(this.BAn.FsK.GcX);
        this.BAs = z.a(this.BAn.FsK.GcY);
      }
      if (this.BAn.FsL != null)
      {
        this.BAt = z.a(this.BAn.FsL.GcV);
        this.unB = z.a(this.BAn.FsL.GcW);
      }
      ac.v("WalletRegionGreyItem", "noticeContent %s", new Object[] { this.BAt });
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ai
 * JD-Core Version:    0.7.0.1
 */