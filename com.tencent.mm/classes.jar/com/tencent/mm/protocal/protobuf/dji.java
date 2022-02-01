package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dji
  extends com.tencent.mm.cd.a
{
  public long RFU;
  public String RFV;
  public String RFW;
  public String RFX;
  public String RFY;
  public String city;
  public double latitude;
  public double longitude;
  public String province;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152660);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.province != null) {
        paramVarArgs.f(1, this.province);
      }
      if (this.city != null) {
        paramVarArgs.f(2, this.city);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.bm(5, this.RFU);
      if (this.RFV != null) {
        paramVarArgs.f(6, this.RFV);
      }
      if (this.RFW != null) {
        paramVarArgs.f(7, this.RFW);
      }
      if (this.RFX != null) {
        paramVarArgs.f(8, this.RFX);
      }
      if (this.RFY != null) {
        paramVarArgs.f(9, this.RFY);
      }
      AppMethodBeat.o(152660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.province == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = g.a.a.b.b.a.g(1, this.province) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.city != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.city);
      }
      i = i + (g.a.a.b.b.a.gL(3) + 8) + (g.a.a.b.b.a.gL(4) + 8) + g.a.a.b.b.a.p(5, this.RFU);
      paramInt = i;
      if (this.RFV != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RFV);
      }
      i = paramInt;
      if (this.RFW != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RFW);
      }
      paramInt = i;
      if (this.RFX != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RFX);
      }
      i = paramInt;
      if (this.RFY != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RFY);
      }
      AppMethodBeat.o(152660);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152660);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dji localdji = (dji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152660);
          return -1;
        case 1: 
          localdji.province = locala.abFh.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 2: 
          localdji.city = locala.abFh.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 3: 
          localdji.latitude = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(152660);
          return 0;
        case 4: 
          localdji.longitude = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(152660);
          return 0;
        case 5: 
          localdji.RFU = locala.abFh.AN();
          AppMethodBeat.o(152660);
          return 0;
        case 6: 
          localdji.RFV = locala.abFh.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 7: 
          localdji.RFW = locala.abFh.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 8: 
          localdji.RFX = locala.abFh.readString();
          AppMethodBeat.o(152660);
          return 0;
        }
        localdji.RFY = locala.abFh.readString();
        AppMethodBeat.o(152660);
        return 0;
      }
      AppMethodBeat.o(152660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dji
 * JD-Core Version:    0.7.0.1
 */