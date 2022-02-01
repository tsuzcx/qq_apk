package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfp
  extends com.tencent.mm.cd.a
{
  public String SQm;
  public String xml;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199868);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xml != null) {
        paramVarArgs.f(1, this.xml);
      }
      if (this.SQm != null) {
        paramVarArgs.f(2, this.SQm);
      }
      AppMethodBeat.o(199868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xml == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.xml) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SQm != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SQm);
      }
      AppMethodBeat.o(199868);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199868);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfp localbfp = (bfp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199868);
          return -1;
        case 1: 
          localbfp.xml = locala.abFh.readString();
          AppMethodBeat.o(199868);
          return 0;
        }
        localbfp.SQm = locala.abFh.readString();
        AppMethodBeat.o(199868);
        return 0;
      }
      AppMethodBeat.o(199868);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfp
 * JD-Core Version:    0.7.0.1
 */