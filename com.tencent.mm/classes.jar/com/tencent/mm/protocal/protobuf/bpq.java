package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpq
  extends com.tencent.mm.bw.a
{
  public String Hdj;
  public String Title;
  public String Url;
  public String uuo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Hdj != null) {
        paramVarArgs.d(3, this.Hdj);
      }
      if (this.uuo != null) {
        paramVarArgs.d(4, this.uuo);
      }
      AppMethodBeat.o(32328);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label404;
      }
    }
    label404:
    for (int i = f.a.a.b.b.a.e(1, this.Url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Hdj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hdj);
      }
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uuo);
      }
      AppMethodBeat.o(32328);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32328);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpq localbpq = (bpq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32328);
          return -1;
        case 1: 
          localbpq.Url = locala.OmT.readString();
          AppMethodBeat.o(32328);
          return 0;
        case 2: 
          localbpq.Title = locala.OmT.readString();
          AppMethodBeat.o(32328);
          return 0;
        case 3: 
          localbpq.Hdj = locala.OmT.readString();
          AppMethodBeat.o(32328);
          return 0;
        }
        localbpq.uuo = locala.OmT.readString();
        AppMethodBeat.o(32328);
        return 0;
      }
      AppMethodBeat.o(32328);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpq
 * JD-Core Version:    0.7.0.1
 */