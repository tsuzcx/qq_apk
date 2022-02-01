package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bfv
  extends com.tencent.mm.cd.a
{
  public String SQA;
  public int SQB;
  public String eventName;
  public long xdR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209353);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.xdR);
      if (this.eventName != null) {
        paramVarArgs.f(2, this.eventName);
      }
      if (this.SQA != null) {
        paramVarArgs.f(3, this.SQA);
      }
      paramVarArgs.aY(4, this.SQB);
      AppMethodBeat.o(209353);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.xdR) + 0;
      paramInt = i;
      if (this.eventName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.eventName);
      }
      i = paramInt;
      if (this.SQA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SQA);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.SQB);
      AppMethodBeat.o(209353);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(209353);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bfv localbfv = (bfv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209353);
        return -1;
      case 1: 
        localbfv.xdR = locala.abFh.AN();
        AppMethodBeat.o(209353);
        return 0;
      case 2: 
        localbfv.eventName = locala.abFh.readString();
        AppMethodBeat.o(209353);
        return 0;
      case 3: 
        localbfv.SQA = locala.abFh.readString();
        AppMethodBeat.o(209353);
        return 0;
      }
      localbfv.SQB = locala.abFh.AK();
      AppMethodBeat.o(209353);
      return 0;
    }
    AppMethodBeat.o(209353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfv
 * JD-Core Version:    0.7.0.1
 */