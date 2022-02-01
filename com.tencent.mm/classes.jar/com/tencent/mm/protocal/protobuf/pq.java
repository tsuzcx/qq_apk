package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pq
  extends com.tencent.mm.bx.a
{
  public String dub;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.dub != null) {
        paramVarArgs.d(3, this.dub);
      }
      AppMethodBeat.o(32152);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label343;
      }
    }
    label343:
    for (int i = f.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.dub != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dub);
      }
      AppMethodBeat.o(32152);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32152);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pq localpq = (pq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32152);
          return -1;
        case 1: 
          localpq.url = locala.KhF.readString();
          AppMethodBeat.o(32152);
          return 0;
        case 2: 
          localpq.title = locala.KhF.readString();
          AppMethodBeat.o(32152);
          return 0;
        }
        localpq.dub = locala.KhF.readString();
        AppMethodBeat.o(32152);
        return 0;
      }
      AppMethodBeat.o(32152);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pq
 * JD-Core Version:    0.7.0.1
 */