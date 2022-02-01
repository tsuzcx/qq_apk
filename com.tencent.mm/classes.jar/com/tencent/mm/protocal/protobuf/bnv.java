package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnv
  extends com.tencent.mm.cd.a
{
  public int RTb;
  public int SYQ;
  public String SYR;
  public String SYS;
  public String lVG;
  public com.tencent.mm.cd.b rVk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50086);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: AppId");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.rVk == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.SYS == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: EventInfo");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.lVG != null) {
        paramVarArgs.f(1, this.lVG);
      }
      paramVarArgs.aY(2, this.RTb);
      paramVarArgs.aY(3, this.SYQ);
      if (this.rVk != null) {
        paramVarArgs.c(4, this.rVk);
      }
      if (this.SYR != null) {
        paramVarArgs.f(5, this.SYR);
      }
      if (this.SYS != null) {
        paramVarArgs.f(6, this.SYS);
      }
      AppMethodBeat.o(50086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVG == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = g.a.a.b.b.a.g(1, this.lVG) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RTb) + g.a.a.b.b.a.bM(3, this.SYQ);
      paramInt = i;
      if (this.rVk != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.rVk);
      }
      i = paramInt;
      if (this.SYR != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SYR);
      }
      paramInt = i;
      if (this.SYS != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SYS);
      }
      AppMethodBeat.o(50086);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.lVG == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: AppId");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.rVk == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.SYS == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: EventInfo");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50086);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bnv localbnv = (bnv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50086);
          return -1;
        case 1: 
          localbnv.lVG = locala.abFh.readString();
          AppMethodBeat.o(50086);
          return 0;
        case 2: 
          localbnv.RTb = locala.abFh.AK();
          AppMethodBeat.o(50086);
          return 0;
        case 3: 
          localbnv.SYQ = locala.abFh.AK();
          AppMethodBeat.o(50086);
          return 0;
        case 4: 
          localbnv.rVk = locala.abFh.iUw();
          AppMethodBeat.o(50086);
          return 0;
        case 5: 
          localbnv.SYR = locala.abFh.readString();
          AppMethodBeat.o(50086);
          return 0;
        }
        localbnv.SYS = locala.abFh.readString();
        AppMethodBeat.o(50086);
        return 0;
      }
      AppMethodBeat.o(50086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnv
 * JD-Core Version:    0.7.0.1
 */