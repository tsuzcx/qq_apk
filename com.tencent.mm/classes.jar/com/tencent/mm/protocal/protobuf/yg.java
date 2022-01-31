package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yg
  extends com.tencent.mm.bv.a
{
  public int channels;
  public int kKH;
  public int wNb;
  public int wPo;
  public int wPp;
  public int wPq;
  public int wPr;
  public int wPs;
  public int wPt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145885);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wPo);
      paramVarArgs.aO(2, this.wPp);
      paramVarArgs.aO(3, this.channels);
      paramVarArgs.aO(4, this.wPq);
      paramVarArgs.aO(5, this.wNb);
      paramVarArgs.aO(6, this.kKH);
      paramVarArgs.aO(7, this.wPr);
      paramVarArgs.aO(8, this.wPs);
      paramVarArgs.aO(9, this.wPt);
      AppMethodBeat.o(145885);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wPo);
      int i = e.a.a.b.b.a.bl(2, this.wPp);
      int j = e.a.a.b.b.a.bl(3, this.channels);
      int k = e.a.a.b.b.a.bl(4, this.wPq);
      int m = e.a.a.b.b.a.bl(5, this.wNb);
      int n = e.a.a.b.b.a.bl(6, this.kKH);
      int i1 = e.a.a.b.b.a.bl(7, this.wPr);
      int i2 = e.a.a.b.b.a.bl(8, this.wPs);
      int i3 = e.a.a.b.b.a.bl(9, this.wPt);
      AppMethodBeat.o(145885);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(145885);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      yg localyg = (yg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(145885);
        return -1;
      case 1: 
        localyg.wPo = locala.CLY.sl();
        AppMethodBeat.o(145885);
        return 0;
      case 2: 
        localyg.wPp = locala.CLY.sl();
        AppMethodBeat.o(145885);
        return 0;
      case 3: 
        localyg.channels = locala.CLY.sl();
        AppMethodBeat.o(145885);
        return 0;
      case 4: 
        localyg.wPq = locala.CLY.sl();
        AppMethodBeat.o(145885);
        return 0;
      case 5: 
        localyg.wNb = locala.CLY.sl();
        AppMethodBeat.o(145885);
        return 0;
      case 6: 
        localyg.kKH = locala.CLY.sl();
        AppMethodBeat.o(145885);
        return 0;
      case 7: 
        localyg.wPr = locala.CLY.sl();
        AppMethodBeat.o(145885);
        return 0;
      case 8: 
        localyg.wPs = locala.CLY.sl();
        AppMethodBeat.o(145885);
        return 0;
      }
      localyg.wPt = locala.CLY.sl();
      AppMethodBeat.o(145885);
      return 0;
    }
    AppMethodBeat.o(145885);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yg
 * JD-Core Version:    0.7.0.1
 */