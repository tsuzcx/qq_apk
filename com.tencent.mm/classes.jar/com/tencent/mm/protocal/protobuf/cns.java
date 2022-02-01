package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cns
  extends com.tencent.mm.cd.a
{
  public String JdV;
  public int Tvn;
  public LinkedList<String> Tvo;
  public String scope;
  
  public cns()
  {
    AppMethodBeat.i(82449);
    this.Tvo = new LinkedList();
    AppMethodBeat.o(82449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82450);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.f(1, this.scope);
      }
      paramVarArgs.aY(2, this.Tvn);
      if (this.JdV != null) {
        paramVarArgs.f(3, this.JdV);
      }
      paramVarArgs.e(4, 1, this.Tvo);
      AppMethodBeat.o(82450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.g(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Tvn);
      paramInt = i;
      if (this.JdV != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.JdV);
      }
      i = g.a.a.a.c(4, 1, this.Tvo);
      AppMethodBeat.o(82450);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tvo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82450);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cns localcns = (cns)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82450);
          return -1;
        case 1: 
          localcns.scope = locala.abFh.readString();
          AppMethodBeat.o(82450);
          return 0;
        case 2: 
          localcns.Tvn = locala.abFh.AK();
          AppMethodBeat.o(82450);
          return 0;
        case 3: 
          localcns.JdV = locala.abFh.readString();
          AppMethodBeat.o(82450);
          return 0;
        }
        localcns.Tvo.add(locala.abFh.readString());
        AppMethodBeat.o(82450);
        return 0;
      }
      AppMethodBeat.o(82450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cns
 * JD-Core Version:    0.7.0.1
 */