package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class frd
  extends com.tencent.mm.bx.a
{
  public String JFk;
  public String MDt;
  public String YLA;
  public String YLB;
  public String hAk;
  public String nQG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72615);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAk != null) {
        paramVarArgs.g(1, this.hAk);
      }
      if (this.nQG != null) {
        paramVarArgs.g(2, this.nQG);
      }
      if (this.JFk != null) {
        paramVarArgs.g(3, this.JFk);
      }
      if (this.MDt != null) {
        paramVarArgs.g(4, this.MDt);
      }
      if (this.YLA != null) {
        paramVarArgs.g(5, this.YLA);
      }
      if (this.YLB != null) {
        paramVarArgs.g(6, this.YLB);
      }
      AppMethodBeat.o(72615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAk == null) {
        break label514;
      }
    }
    label514:
    for (int i = i.a.a.b.b.a.h(1, this.hAk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nQG);
      }
      i = paramInt;
      if (this.JFk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.JFk);
      }
      paramInt = i;
      if (this.MDt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MDt);
      }
      i = paramInt;
      if (this.YLA != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YLA);
      }
      paramInt = i;
      if (this.YLB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YLB);
      }
      AppMethodBeat.o(72615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72615);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        frd localfrd = (frd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72615);
          return -1;
        case 1: 
          localfrd.hAk = locala.ajGk.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 2: 
          localfrd.nQG = locala.ajGk.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 3: 
          localfrd.JFk = locala.ajGk.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 4: 
          localfrd.MDt = locala.ajGk.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 5: 
          localfrd.YLA = locala.ajGk.readString();
          AppMethodBeat.o(72615);
          return 0;
        }
        localfrd.YLB = locala.ajGk.readString();
        AppMethodBeat.o(72615);
        return 0;
      }
      AppMethodBeat.o(72615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.frd
 * JD-Core Version:    0.7.0.1
 */