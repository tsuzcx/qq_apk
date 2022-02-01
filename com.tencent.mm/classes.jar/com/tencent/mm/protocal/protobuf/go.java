package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class go
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> RLB;
  public long RLC;
  public String fAo;
  public String fHp;
  public String lWt;
  
  public go()
  {
    AppMethodBeat.i(138168);
    this.RLB = new LinkedList();
    AppMethodBeat.o(138168);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138169);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: roomname");
        AppMethodBeat.o(138169);
        throw paramVarArgs;
      }
      if (this.fHp != null) {
        paramVarArgs.f(1, this.fHp);
      }
      if (this.fAo != null) {
        paramVarArgs.f(2, this.fAo);
      }
      if (this.lWt != null) {
        paramVarArgs.f(3, this.lWt);
      }
      paramVarArgs.e(4, 1, this.RLB);
      paramVarArgs.bm(5, this.RLC);
      AppMethodBeat.o(138169);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fHp == null) {
        break label486;
      }
    }
    label486:
    for (int i = g.a.a.b.b.a.g(1, this.fHp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fAo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fAo);
      }
      i = paramInt;
      if (this.lWt != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lWt);
      }
      paramInt = g.a.a.a.c(4, 1, this.RLB);
      int j = g.a.a.b.b.a.p(5, this.RLC);
      AppMethodBeat.o(138169);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RLB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: roomname");
          AppMethodBeat.o(138169);
          throw paramVarArgs;
        }
        AppMethodBeat.o(138169);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        go localgo = (go)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138169);
          return -1;
        case 1: 
          localgo.fHp = locala.abFh.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 2: 
          localgo.fAo = locala.abFh.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 3: 
          localgo.lWt = locala.abFh.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 4: 
          localgo.RLB.add(locala.abFh.readString());
          AppMethodBeat.o(138169);
          return 0;
        }
        localgo.RLC = locala.abFh.AN();
        AppMethodBeat.o(138169);
        return 0;
      }
      AppMethodBeat.o(138169);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.go
 * JD-Core Version:    0.7.0.1
 */