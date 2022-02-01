package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hl;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.ffr;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.LinkedList;

public final class u
  extends hl
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(97471);
    info = hl.aJm();
    AppMethodBeat.o(97471);
  }
  
  public final void a(ffr paramffr)
  {
    AppMethodBeat.i(97467);
    if (paramffr == null)
    {
      AppMethodBeat.o(97467);
      return;
    }
    try
    {
      this.field_snsYearMonthInfo = paramffr.toByteArray();
      AppMethodBeat.o(97467);
      return;
    }
    catch (Exception paramffr)
    {
      AppMethodBeat.o(97467);
    }
  }
  
  public final void a(ffs paramffs)
  {
    AppMethodBeat.i(97468);
    if (paramffs == null)
    {
      AppMethodBeat.o(97468);
      return;
    }
    try
    {
      this.field_snsuser = paramffs.toByteArray();
      AppMethodBeat.o(97468);
      return;
    }
    catch (Exception paramffs)
    {
      AppMethodBeat.o(97468);
    }
  }
  
  public final boolean dqH()
  {
    return (this.field_local_flag & 0x1) > 0;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final void hkN()
  {
    this.field_local_flag &= 0xFFFFFFFE;
  }
  
  public final void hkO()
  {
    this.field_local_flag &= 0xFFFFFFFD;
  }
  
  public final ffr hkP()
  {
    AppMethodBeat.i(97466);
    ffr localffr = new ffr();
    if (!Util.isNullOrNil(this.field_snsYearMonthInfo)) {}
    try
    {
      localffr.parseFrom(this.field_snsYearMonthInfo);
      label32:
      AppMethodBeat.o(97466);
      return localffr;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final boolean hkQ()
  {
    return (this.field_local_flag & 0x2) > 0;
  }
  
  public final ffs hkR()
  {
    AppMethodBeat.i(97469);
    try
    {
      ffs localffs = (ffs)new ffs().parseFrom(this.field_snsuser);
      AppMethodBeat.o(97469);
      return localffs;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97469);
    }
    return null;
  }
  
  public final arc hkS()
  {
    AppMethodBeat.i(97470);
    new can();
    localObject1 = new arc();
    Object localObject2 = localObject1;
    if (!Util.isNullOrNil(this.field_faultS)) {}
    try
    {
      localObject2 = (can)new can().parseFrom(this.field_faultS);
      if (((can)localObject2).aajy.size() <= 0) {
        break label89;
      }
      localObject2 = (arc)((can)localObject2).aajy.getFirst();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
    localObject2 = localObject1;
    AppMethodBeat.o(97470);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.u
 * JD-Core Version:    0.7.0.1
 */