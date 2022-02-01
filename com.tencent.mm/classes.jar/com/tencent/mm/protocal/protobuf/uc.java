package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uc
  extends com.tencent.mm.bw.a
{
  public String Eol;
  public double Eom;
  public double Eon;
  public double Eoo;
  public double Eop;
  public double Eoq;
  public int tlu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87874);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eol != null) {
        paramVarArgs.d(1, this.Eol);
      }
      paramVarArgs.e(2, this.Eom);
      paramVarArgs.e(3, this.Eon);
      paramVarArgs.e(4, this.Eoo);
      paramVarArgs.e(5, this.Eop);
      paramVarArgs.e(6, this.Eoq);
      paramVarArgs.aR(7, this.tlu);
      AppMethodBeat.o(87874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eol == null) {
        break label501;
      }
    }
    label501:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eol) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      int n = f.a.a.b.b.a.fK(6);
      int i1 = f.a.a.b.b.a.bx(7, this.tlu);
      AppMethodBeat.o(87874);
      return paramInt + (i + 8) + (j + 8) + (k + 8) + (m + 8) + (n + 8) + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(87874);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        uc localuc = (uc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87874);
          return -1;
        case 1: 
          localuc.Eol = locala.LVo.readString();
          AppMethodBeat.o(87874);
          return 0;
        case 2: 
          localuc.Eom = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(87874);
          return 0;
        case 3: 
          localuc.Eon = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(87874);
          return 0;
        case 4: 
          localuc.Eoo = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(87874);
          return 0;
        case 5: 
          localuc.Eop = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(87874);
          return 0;
        case 6: 
          localuc.Eoq = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(87874);
          return 0;
        }
        localuc.tlu = locala.LVo.xF();
        AppMethodBeat.o(87874);
        return 0;
      }
      AppMethodBeat.o(87874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uc
 * JD-Core Version:    0.7.0.1
 */