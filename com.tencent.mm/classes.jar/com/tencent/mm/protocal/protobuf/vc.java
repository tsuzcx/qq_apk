package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vc
  extends com.tencent.mm.cd.a
{
  public String SgA;
  public String appid;
  public String code;
  public String tnX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113977);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.tnX != null) {
        paramVarArgs.f(1, this.tnX);
      }
      if (this.code != null) {
        paramVarArgs.f(2, this.code);
      }
      if (this.SgA != null) {
        paramVarArgs.f(3, this.SgA);
      }
      if (this.appid != null) {
        paramVarArgs.f(4, this.appid);
      }
      AppMethodBeat.o(113977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tnX == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.tnX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.code != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.code);
      }
      i = paramInt;
      if (this.SgA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SgA);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.appid);
      }
      AppMethodBeat.o(113977);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113977);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        vc localvc = (vc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113977);
          return -1;
        case 1: 
          localvc.tnX = locala.abFh.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 2: 
          localvc.code = locala.abFh.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 3: 
          localvc.SgA = locala.abFh.readString();
          AppMethodBeat.o(113977);
          return 0;
        }
        localvc.appid = locala.abFh.readString();
        AppMethodBeat.o(113977);
        return 0;
      }
      AppMethodBeat.o(113977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vc
 * JD-Core Version:    0.7.0.1
 */