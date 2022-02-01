package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnj
  extends com.tencent.mm.bw.a
{
  public boolean Hzu;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91635);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.bC(3, this.Hzu);
      AppMethodBeat.o(91635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      paramInt = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(91635);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91635);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cnj localcnj = (cnj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91635);
          return -1;
        case 1: 
          localcnj.title = locala.OmT.readString();
          AppMethodBeat.o(91635);
          return 0;
        case 2: 
          localcnj.url = locala.OmT.readString();
          AppMethodBeat.o(91635);
          return 0;
        }
        localcnj.Hzu = locala.OmT.gvY();
        AppMethodBeat.o(91635);
        return 0;
      }
      AppMethodBeat.o(91635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnj
 * JD-Core Version:    0.7.0.1
 */