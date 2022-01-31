package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aw
  extends com.tencent.mm.bv.a
{
  public String city;
  public double latitude;
  public double longitude;
  public String province;
  public long wmP;
  public String wmQ;
  public String wmR;
  public String wmS;
  public String wmT;
  public String wmU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56697);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.province != null) {
        paramVarArgs.e(1, this.province);
      }
      if (this.city != null) {
        paramVarArgs.e(2, this.city);
      }
      paramVarArgs.f(3, this.latitude);
      paramVarArgs.f(4, this.longitude);
      paramVarArgs.am(5, this.wmP);
      if (this.wmQ != null) {
        paramVarArgs.e(6, this.wmQ);
      }
      if (this.wmR != null) {
        paramVarArgs.e(7, this.wmR);
      }
      if (this.wmS != null) {
        paramVarArgs.e(8, this.wmS);
      }
      if (this.wmT != null) {
        paramVarArgs.e(9, this.wmT);
      }
      if (this.wmU != null) {
        paramVarArgs.e(10, this.wmU);
      }
      AppMethodBeat.o(56697);
      return 0;
    }
    if (paramInt == 1) {
      if (this.province == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = e.a.a.b.b.a.f(1, this.province) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.city != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.city);
      }
      i = i + (e.a.a.b.b.a.eW(3) + 8) + (e.a.a.b.b.a.eW(4) + 8) + e.a.a.b.b.a.p(5, this.wmP);
      paramInt = i;
      if (this.wmQ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wmQ);
      }
      i = paramInt;
      if (this.wmR != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wmR);
      }
      paramInt = i;
      if (this.wmS != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wmS);
      }
      i = paramInt;
      if (this.wmT != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wmT);
      }
      paramInt = i;
      if (this.wmU != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wmU);
      }
      AppMethodBeat.o(56697);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56697);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56697);
          return -1;
        case 1: 
          localaw.province = locala.CLY.readString();
          AppMethodBeat.o(56697);
          return 0;
        case 2: 
          localaw.city = locala.CLY.readString();
          AppMethodBeat.o(56697);
          return 0;
        case 3: 
          localaw.latitude = Double.longBitsToDouble(locala.CLY.emy());
          AppMethodBeat.o(56697);
          return 0;
        case 4: 
          localaw.longitude = Double.longBitsToDouble(locala.CLY.emy());
          AppMethodBeat.o(56697);
          return 0;
        case 5: 
          localaw.wmP = locala.CLY.sm();
          AppMethodBeat.o(56697);
          return 0;
        case 6: 
          localaw.wmQ = locala.CLY.readString();
          AppMethodBeat.o(56697);
          return 0;
        case 7: 
          localaw.wmR = locala.CLY.readString();
          AppMethodBeat.o(56697);
          return 0;
        case 8: 
          localaw.wmS = locala.CLY.readString();
          AppMethodBeat.o(56697);
          return 0;
        case 9: 
          localaw.wmT = locala.CLY.readString();
          AppMethodBeat.o(56697);
          return 0;
        }
        localaw.wmU = locala.CLY.readString();
        AppMethodBeat.o(56697);
        return 0;
      }
      AppMethodBeat.o(56697);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aw
 * JD-Core Version:    0.7.0.1
 */