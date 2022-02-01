package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class foo
  extends com.tencent.mm.cd.a
{
  public boolean UMB;
  public String UMJ;
  public b UMK;
  public int UML;
  public int UMM;
  public int UMN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50123);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.UMB);
      if (this.UMJ != null) {
        paramVarArgs.f(2, this.UMJ);
      }
      if (this.UMK != null) {
        paramVarArgs.c(3, this.UMK);
      }
      paramVarArgs.aY(4, this.UML);
      paramVarArgs.aY(5, this.UMM);
      paramVarArgs.aY(6, this.UMN);
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0;
      paramInt = i;
      if (this.UMJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UMJ);
      }
      i = paramInt;
      if (this.UMK != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.UMK);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.UML);
      int j = g.a.a.b.b.a.bM(5, this.UMM);
      int k = g.a.a.b.b.a.bM(6, this.UMN);
      AppMethodBeat.o(50123);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      foo localfoo = (foo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50123);
        return -1;
      case 1: 
        localfoo.UMB = locala.abFh.AB();
        AppMethodBeat.o(50123);
        return 0;
      case 2: 
        localfoo.UMJ = locala.abFh.readString();
        AppMethodBeat.o(50123);
        return 0;
      case 3: 
        localfoo.UMK = locala.abFh.iUw();
        AppMethodBeat.o(50123);
        return 0;
      case 4: 
        localfoo.UML = locala.abFh.AK();
        AppMethodBeat.o(50123);
        return 0;
      case 5: 
        localfoo.UMM = locala.abFh.AK();
        AppMethodBeat.o(50123);
        return 0;
      }
      localfoo.UMN = locala.abFh.AK();
      AppMethodBeat.o(50123);
      return 0;
    }
    AppMethodBeat.o(50123);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foo
 * JD-Core Version:    0.7.0.1
 */