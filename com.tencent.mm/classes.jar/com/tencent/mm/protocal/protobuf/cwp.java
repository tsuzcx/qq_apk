package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwp
  extends com.tencent.mm.cd.a
{
  public String KFu;
  public int KFw;
  public String SOz;
  public String city;
  public String country;
  public float latitude;
  public float longitude;
  public String poiName;
  public String province;
  public String region;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208293);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.longitude);
      paramVarArgs.i(2, this.latitude);
      if (this.city != null) {
        paramVarArgs.f(3, this.city);
      }
      if (this.poiName != null) {
        paramVarArgs.f(4, this.poiName);
      }
      if (this.KFu != null) {
        paramVarArgs.f(5, this.KFu);
      }
      if (this.SOz != null) {
        paramVarArgs.f(6, this.SOz);
      }
      paramVarArgs.aY(7, this.KFw);
      if (this.province != null) {
        paramVarArgs.f(8, this.province);
      }
      if (this.region != null) {
        paramVarArgs.f(9, this.region);
      }
      if (this.country != null) {
        paramVarArgs.f(10, this.country);
      }
      AppMethodBeat.o(208293);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 4 + 0 + (g.a.a.b.b.a.gL(2) + 4);
      paramInt = i;
      if (this.city != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.city);
      }
      i = paramInt;
      if (this.poiName != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.poiName);
      }
      paramInt = i;
      if (this.KFu != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.KFu);
      }
      i = paramInt;
      if (this.SOz != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SOz);
      }
      i += g.a.a.b.b.a.bM(7, this.KFw);
      paramInt = i;
      if (this.province != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.province);
      }
      i = paramInt;
      if (this.region != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.region);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.country);
      }
      AppMethodBeat.o(208293);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(208293);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cwp localcwp = (cwp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208293);
        return -1;
      case 1: 
        localcwp.longitude = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(208293);
        return 0;
      case 2: 
        localcwp.latitude = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(208293);
        return 0;
      case 3: 
        localcwp.city = locala.abFh.readString();
        AppMethodBeat.o(208293);
        return 0;
      case 4: 
        localcwp.poiName = locala.abFh.readString();
        AppMethodBeat.o(208293);
        return 0;
      case 5: 
        localcwp.KFu = locala.abFh.readString();
        AppMethodBeat.o(208293);
        return 0;
      case 6: 
        localcwp.SOz = locala.abFh.readString();
        AppMethodBeat.o(208293);
        return 0;
      case 7: 
        localcwp.KFw = locala.abFh.AK();
        AppMethodBeat.o(208293);
        return 0;
      case 8: 
        localcwp.province = locala.abFh.readString();
        AppMethodBeat.o(208293);
        return 0;
      case 9: 
        localcwp.region = locala.abFh.readString();
        AppMethodBeat.o(208293);
        return 0;
      }
      localcwp.country = locala.abFh.readString();
      AppMethodBeat.o(208293);
      return 0;
    }
    AppMethodBeat.o(208293);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwp
 * JD-Core Version:    0.7.0.1
 */