package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public class bag
  extends com.tencent.mm.cd.a
{
  public int CKC;
  public b SMi;
  public int SMj;
  public String SMk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199003);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CKC);
      if (this.SMi != null) {
        paramVarArgs.c(2, this.SMi);
      }
      paramVarArgs.aY(3, this.SMj);
      if (this.SMk != null) {
        paramVarArgs.f(4, this.SMk);
      }
      AppMethodBeat.o(199003);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CKC) + 0;
      paramInt = i;
      if (this.SMi != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.SMi);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.SMj);
      paramInt = i;
      if (this.SMk != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SMk);
      }
      AppMethodBeat.o(199003);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(199003);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bag localbag = (bag)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199003);
        return -1;
      case 1: 
        localbag.CKC = locala.abFh.AK();
        AppMethodBeat.o(199003);
        return 0;
      case 2: 
        localbag.SMi = locala.abFh.iUw();
        AppMethodBeat.o(199003);
        return 0;
      case 3: 
        localbag.SMj = locala.abFh.AK();
        AppMethodBeat.o(199003);
        return 0;
      }
      localbag.SMk = locala.abFh.readString();
      AppMethodBeat.o(199003);
      return 0;
    }
    AppMethodBeat.o(199003);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bag
 * JD-Core Version:    0.7.0.1
 */