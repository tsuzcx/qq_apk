package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wa
  extends com.tencent.mm.bw.a
{
  public String GnT;
  public double GnU;
  public double GnV;
  public double GnW;
  public double GnX;
  public double GnY;
  public int uvb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87874);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GnT != null) {
        paramVarArgs.d(1, this.GnT);
      }
      paramVarArgs.e(2, this.GnU);
      paramVarArgs.e(3, this.GnV);
      paramVarArgs.e(4, this.GnW);
      paramVarArgs.e(5, this.GnX);
      paramVarArgs.e(6, this.GnY);
      paramVarArgs.aS(7, this.uvb);
      AppMethodBeat.o(87874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GnT == null) {
        break label489;
      }
    }
    label489:
    for (paramInt = f.a.a.b.b.a.e(1, this.GnT) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amD(2);
      int j = f.a.a.b.b.a.amD(3);
      int k = f.a.a.b.b.a.amD(4);
      int m = f.a.a.b.b.a.amD(5);
      int n = f.a.a.b.b.a.amD(6);
      int i1 = f.a.a.b.b.a.bz(7, this.uvb);
      AppMethodBeat.o(87874);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(87874);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        wa localwa = (wa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87874);
          return -1;
        case 1: 
          localwa.GnT = locala.OmT.readString();
          AppMethodBeat.o(87874);
          return 0;
        case 2: 
          localwa.GnU = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(87874);
          return 0;
        case 3: 
          localwa.GnV = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(87874);
          return 0;
        case 4: 
          localwa.GnW = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(87874);
          return 0;
        case 5: 
          localwa.GnX = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(87874);
          return 0;
        case 6: 
          localwa.GnY = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(87874);
          return 0;
        }
        localwa.uvb = locala.OmT.zc();
        AppMethodBeat.o(87874);
        return 0;
      }
      AppMethodBeat.o(87874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wa
 * JD-Core Version:    0.7.0.1
 */