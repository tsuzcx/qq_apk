package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayc
  extends com.tencent.mm.bv.a
{
  public String qFg;
  public String scope;
  public int xnh;
  public LinkedList<String> xni;
  
  public ayc()
  {
    AppMethodBeat.i(10212);
    this.xni = new LinkedList();
    AppMethodBeat.o(10212);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10213);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.e(1, this.scope);
      }
      paramVarArgs.aO(2, this.xnh);
      if (this.qFg != null) {
        paramVarArgs.e(3, this.qFg);
      }
      paramVarArgs.e(4, 1, this.xni);
      AppMethodBeat.o(10213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = e.a.a.b.b.a.f(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xnh);
      paramInt = i;
      if (this.qFg != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.qFg);
      }
      i = e.a.a.a.c(4, 1, this.xni);
      AppMethodBeat.o(10213);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xni.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10213);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ayc localayc = (ayc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10213);
          return -1;
        case 1: 
          localayc.scope = locala.CLY.readString();
          AppMethodBeat.o(10213);
          return 0;
        case 2: 
          localayc.xnh = locala.CLY.sl();
          AppMethodBeat.o(10213);
          return 0;
        case 3: 
          localayc.qFg = locala.CLY.readString();
          AppMethodBeat.o(10213);
          return 0;
        }
        localayc.xni.add(locala.CLY.readString());
        AppMethodBeat.o(10213);
        return 0;
      }
      AppMethodBeat.o(10213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayc
 * JD-Core Version:    0.7.0.1
 */