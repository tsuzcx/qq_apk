package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bd
  extends com.tencent.mm.cd.a
{
  public long RFU;
  public String RFV;
  public String RFW;
  public String RFX;
  public String RFY;
  public String RFZ;
  public String city;
  public double latitude;
  public double longitude;
  public String province;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91341);
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
      if (this.RFZ != null) {
        paramVarArgs.f(10, this.RFZ);
      }
      AppMethodBeat.o(91341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.province == null) {
        break label716;
      }
    }
    label716:
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
      paramInt = i;
      if (this.RFZ != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RFZ);
      }
      AppMethodBeat.o(91341);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91341);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bd localbd = (bd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91341);
          return -1;
        case 1: 
          localbd.province = locala.abFh.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 2: 
          localbd.city = locala.abFh.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 3: 
          localbd.latitude = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(91341);
          return 0;
        case 4: 
          localbd.longitude = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(91341);
          return 0;
        case 5: 
          localbd.RFU = locala.abFh.AN();
          AppMethodBeat.o(91341);
          return 0;
        case 6: 
          localbd.RFV = locala.abFh.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 7: 
          localbd.RFW = locala.abFh.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 8: 
          localbd.RFX = locala.abFh.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 9: 
          localbd.RFY = locala.abFh.readString();
          AppMethodBeat.o(91341);
          return 0;
        }
        localbd.RFZ = locala.abFh.readString();
        AppMethodBeat.o(91341);
        return 0;
      }
      AppMethodBeat.o(91341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bd
 * JD-Core Version:    0.7.0.1
 */