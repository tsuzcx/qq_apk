package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bi
  extends com.tencent.mm.bx.a
{
  public long YCI;
  public String YCJ;
  public String YCK;
  public String YCL;
  public String YCM;
  public String YCN;
  public String city;
  public double latitude;
  public double longitude;
  public String province;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91341);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.province != null) {
        paramVarArgs.g(1, this.province);
      }
      if (this.city != null) {
        paramVarArgs.g(2, this.city);
      }
      paramVarArgs.d(3, this.latitude);
      paramVarArgs.d(4, this.longitude);
      paramVarArgs.bv(5, this.YCI);
      if (this.YCJ != null) {
        paramVarArgs.g(6, this.YCJ);
      }
      if (this.YCK != null) {
        paramVarArgs.g(7, this.YCK);
      }
      if (this.YCL != null) {
        paramVarArgs.g(8, this.YCL);
      }
      if (this.YCM != null) {
        paramVarArgs.g(9, this.YCM);
      }
      if (this.YCN != null) {
        paramVarArgs.g(10, this.YCN);
      }
      AppMethodBeat.o(91341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.province == null) {
        break label712;
      }
    }
    label712:
    for (paramInt = i.a.a.b.b.a.h(1, this.province) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.city != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.city);
      }
      i = i + (i.a.a.b.b.a.ko(3) + 8) + (i.a.a.b.b.a.ko(4) + 8) + i.a.a.b.b.a.q(5, this.YCI);
      paramInt = i;
      if (this.YCJ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YCJ);
      }
      i = paramInt;
      if (this.YCK != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YCK);
      }
      paramInt = i;
      if (this.YCL != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YCL);
      }
      i = paramInt;
      if (this.YCM != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YCM);
      }
      paramInt = i;
      if (this.YCN != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YCN);
      }
      AppMethodBeat.o(91341);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91341);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bi localbi = (bi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91341);
          return -1;
        case 1: 
          localbi.province = locala.ajGk.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 2: 
          localbi.city = locala.ajGk.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 3: 
          localbi.latitude = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(91341);
          return 0;
        case 4: 
          localbi.longitude = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(91341);
          return 0;
        case 5: 
          localbi.YCI = locala.ajGk.aaw();
          AppMethodBeat.o(91341);
          return 0;
        case 6: 
          localbi.YCJ = locala.ajGk.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 7: 
          localbi.YCK = locala.ajGk.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 8: 
          localbi.YCL = locala.ajGk.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 9: 
          localbi.YCM = locala.ajGk.readString();
          AppMethodBeat.o(91341);
          return 0;
        }
        localbi.YCN = locala.ajGk.readString();
        AppMethodBeat.o(91341);
        return 0;
      }
      AppMethodBeat.o(91341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bi
 * JD-Core Version:    0.7.0.1
 */