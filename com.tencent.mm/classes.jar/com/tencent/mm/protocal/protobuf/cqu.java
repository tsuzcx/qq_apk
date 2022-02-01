package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqu
  extends com.tencent.mm.cd.a
{
  public String AesKey;
  public String Md5;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.f(1, this.Url);
      }
      if (this.AesKey != null) {
        paramVarArgs.f(2, this.AesKey);
      }
      if (this.Md5 != null) {
        paramVarArgs.f(3, this.Md5);
      }
      AppMethodBeat.o(104817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.Url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.AesKey);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Md5);
      }
      AppMethodBeat.o(104817);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104817);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cqu localcqu = (cqu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104817);
          return -1;
        case 1: 
          localcqu.Url = locala.abFh.readString();
          AppMethodBeat.o(104817);
          return 0;
        case 2: 
          localcqu.AesKey = locala.abFh.readString();
          AppMethodBeat.o(104817);
          return 0;
        }
        localcqu.Md5 = locala.abFh.readString();
        AppMethodBeat.o(104817);
        return 0;
      }
      AppMethodBeat.o(104817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqu
 * JD-Core Version:    0.7.0.1
 */