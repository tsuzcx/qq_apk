package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class boi
  extends com.tencent.mm.bx.a
{
  public String ReU;
  public int ReW;
  public String ZWG;
  public String city;
  public String country;
  public float latitude;
  public float longitude;
  public String poiName;
  public String province;
  public String region;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169004);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.longitude);
      paramVarArgs.l(2, this.latitude);
      if (this.city != null) {
        paramVarArgs.g(3, this.city);
      }
      if (this.poiName != null) {
        paramVarArgs.g(4, this.poiName);
      }
      if (this.ReU != null) {
        paramVarArgs.g(5, this.ReU);
      }
      if (this.ZWG != null) {
        paramVarArgs.g(6, this.ZWG);
      }
      paramVarArgs.bS(7, this.ReW);
      if (this.province != null) {
        paramVarArgs.g(8, this.province);
      }
      if (this.region != null) {
        paramVarArgs.g(9, this.region);
      }
      if (this.country != null) {
        paramVarArgs.g(10, this.country);
      }
      paramVarArgs.bS(11, this.source);
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 4 + 0 + (i.a.a.b.b.a.ko(2) + 4);
      paramInt = i;
      if (this.city != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.city);
      }
      i = paramInt;
      if (this.poiName != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.poiName);
      }
      paramInt = i;
      if (this.ReU != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ReU);
      }
      i = paramInt;
      if (this.ZWG != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZWG);
      }
      i += i.a.a.b.b.a.cJ(7, this.ReW);
      paramInt = i;
      if (this.province != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.province);
      }
      i = paramInt;
      if (this.region != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.region);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.country);
      }
      i = i.a.a.b.b.a.cJ(11, this.source);
      AppMethodBeat.o(169004);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      boi localboi = (boi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169004);
        return -1;
      case 1: 
        localboi.longitude = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(169004);
        return 0;
      case 2: 
        localboi.latitude = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(169004);
        return 0;
      case 3: 
        localboi.city = locala.ajGk.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 4: 
        localboi.poiName = locala.ajGk.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 5: 
        localboi.ReU = locala.ajGk.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 6: 
        localboi.ZWG = locala.ajGk.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 7: 
        localboi.ReW = locala.ajGk.aar();
        AppMethodBeat.o(169004);
        return 0;
      case 8: 
        localboi.province = locala.ajGk.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 9: 
        localboi.region = locala.ajGk.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 10: 
        localboi.country = locala.ajGk.readString();
        AppMethodBeat.o(169004);
        return 0;
      }
      localboi.source = locala.ajGk.aar();
      AppMethodBeat.o(169004);
      return 0;
    }
    AppMethodBeat.o(169004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boi
 * JD-Core Version:    0.7.0.1
 */