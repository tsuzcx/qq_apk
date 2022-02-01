package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bco
  extends com.tencent.mm.cd.a
{
  public String SNP;
  public boolean enable;
  public String jDP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229478);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SNP != null) {
        paramVarArgs.f(1, this.SNP);
      }
      if (this.jDP != null) {
        paramVarArgs.f(2, this.jDP);
      }
      paramVarArgs.co(3, this.enable);
      AppMethodBeat.o(229478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SNP == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.SNP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jDP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.jDP);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(229478);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229478);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bco localbco = (bco)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(229478);
          return -1;
        case 1: 
          localbco.SNP = locala.abFh.readString();
          AppMethodBeat.o(229478);
          return 0;
        case 2: 
          localbco.jDP = locala.abFh.readString();
          AppMethodBeat.o(229478);
          return 0;
        }
        localbco.enable = locala.abFh.AB();
        AppMethodBeat.o(229478);
        return 0;
      }
      AppMethodBeat.o(229478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bco
 * JD-Core Version:    0.7.0.1
 */