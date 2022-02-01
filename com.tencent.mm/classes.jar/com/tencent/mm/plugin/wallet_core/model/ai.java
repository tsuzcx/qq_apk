package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.in;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.ecd;
import com.tencent.mm.protocal.protobuf.gec;
import com.tencent.mm.protocal.protobuf.gei;
import com.tencent.mm.protocal.protobuf.gej;
import com.tencent.mm.protocal.protobuf.gel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.LinkedList;

public final class ai
  extends in
{
  public static IAutoDBItem.MAutoDBInfo info;
  public String Kuq;
  private ecd VJN;
  public gec VJO;
  public gej VJP;
  public boolean VJQ;
  public String VJR;
  public String VJS;
  public String VJT;
  public String VJU;
  
  static
  {
    AppMethodBeat.i(70471);
    info = aJm();
    AppMethodBeat.o(70471);
  }
  
  public ai()
  {
    AppMethodBeat.i(70469);
    this.VJN = new ecd();
    this.VJO = null;
    this.VJP = null;
    this.VJQ = false;
    this.VJR = "";
    this.VJS = "";
    this.VJT = "";
    this.Kuq = "";
    this.VJU = "";
    if (this.VJO == null) {
      this.VJO = new gec();
    }
    if (this.VJP == null) {
      this.VJP = new gej();
    }
    AppMethodBeat.o(70469);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70470);
    super.convertFrom(paramCursor);
    this.VJN = new ecd();
    try
    {
      this.VJN = ((ecd)this.VJN.parseFrom(this.field_wallet_grey_item_buf));
      this.VJO = this.VJN.abhD;
      this.VJP = this.VJN.abhE;
      this.VJQ = this.VJN.abhF;
      this.VJU = "";
      paramCursor = this.VJN.abhG.iterator();
      for (;;)
      {
        if (paramCursor.hasNext())
        {
          String str = (String)paramCursor.next();
          this.VJU = (this.VJU + str + "\n");
          continue;
          if (this.VJO != null) {
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
      this.VJO = new gec();
      if (this.VJP == null) {
        this.VJP = new gej();
      }
      AppMethodBeat.o(70470);
      return;
      if (this.VJN.abhB != null)
      {
        this.VJR = w.a(this.VJN.abhB.acbY);
        this.VJS = w.a(this.VJN.abhB.acbZ);
      }
      if (this.VJN.abhC != null)
      {
        this.VJT = w.a(this.VJN.abhC.acbW);
        this.Kuq = w.a(this.VJN.abhC.acbX);
      }
      Log.v("WalletRegionGreyItem", "noticeContent %s", new Object[] { this.VJT });
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ai
 * JD-Core Version:    0.7.0.1
 */