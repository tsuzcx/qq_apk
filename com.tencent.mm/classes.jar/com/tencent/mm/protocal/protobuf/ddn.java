package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddn
  extends com.tencent.mm.cd.a
{
  public String iconUrl;
  public String recommendReason;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      if (this.iconUrl != null) {
        paramVarArgs.f(2, this.iconUrl);
      }
      if (this.recommendReason != null) {
        paramVarArgs.f(3, this.recommendReason);
      }
      AppMethodBeat.o(200507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.iconUrl);
      }
      i = paramInt;
      if (this.recommendReason != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.recommendReason);
      }
      AppMethodBeat.o(200507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200507);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ddn localddn = (ddn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200507);
          return -1;
        case 1: 
          localddn.wording = locala.abFh.readString();
          AppMethodBeat.o(200507);
          return 0;
        case 2: 
          localddn.iconUrl = locala.abFh.readString();
          AppMethodBeat.o(200507);
          return 0;
        }
        localddn.recommendReason = locala.abFh.readString();
        AppMethodBeat.o(200507);
        return 0;
      }
      AppMethodBeat.o(200507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddn
 * JD-Core Version:    0.7.0.1
 */