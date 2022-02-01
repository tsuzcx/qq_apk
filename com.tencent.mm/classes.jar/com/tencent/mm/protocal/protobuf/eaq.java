package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaq
  extends com.tencent.mm.bw.a
{
  public double Ggr;
  public long Ggs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153324);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.Ggr);
      paramVarArgs.aO(2, this.Ggs);
      AppMethodBeat.o(153324);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.p(2, this.Ggs);
      AppMethodBeat.o(153324);
      return paramInt + 8 + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153324);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eaq localeaq = (eaq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153324);
        return -1;
      case 1: 
        localeaq.Ggr = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(153324);
        return 0;
      }
      localeaq.Ggs = locala.LVo.xG();
      AppMethodBeat.o(153324);
      return 0;
    }
    AppMethodBeat.o(153324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaq
 * JD-Core Version:    0.7.0.1
 */