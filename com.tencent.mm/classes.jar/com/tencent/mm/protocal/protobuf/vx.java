package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vx
  extends com.tencent.mm.bx.a
{
  public String FVu;
  public double FVv;
  public double FVw;
  public double FVx;
  public double FVy;
  public double FVz;
  public int ujD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87874);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVu != null) {
        paramVarArgs.d(1, this.FVu);
      }
      paramVarArgs.e(2, this.FVv);
      paramVarArgs.e(3, this.FVw);
      paramVarArgs.e(4, this.FVx);
      paramVarArgs.e(5, this.FVy);
      paramVarArgs.e(6, this.FVz);
      paramVarArgs.aS(7, this.ujD);
      AppMethodBeat.o(87874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVu == null) {
        break label489;
      }
    }
    label489:
    for (paramInt = f.a.a.b.b.a.e(1, this.FVu) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.alT(2);
      int j = f.a.a.b.b.a.alT(3);
      int k = f.a.a.b.b.a.alT(4);
      int m = f.a.a.b.b.a.alT(5);
      int n = f.a.a.b.b.a.alT(6);
      int i1 = f.a.a.b.b.a.bz(7, this.ujD);
      AppMethodBeat.o(87874);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(87874);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        vx localvx = (vx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87874);
          return -1;
        case 1: 
          localvx.FVu = locala.NPN.readString();
          AppMethodBeat.o(87874);
          return 0;
        case 2: 
          localvx.FVv = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(87874);
          return 0;
        case 3: 
          localvx.FVw = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(87874);
          return 0;
        case 4: 
          localvx.FVx = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(87874);
          return 0;
        case 5: 
          localvx.FVy = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(87874);
          return 0;
        case 6: 
          localvx.FVz = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(87874);
          return 0;
        }
        localvx.ujD = locala.NPN.zc();
        AppMethodBeat.o(87874);
        return 0;
      }
      AppMethodBeat.o(87874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vx
 * JD-Core Version:    0.7.0.1
 */