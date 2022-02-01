package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwx
  extends com.tencent.mm.bw.a
{
  public String FLQ;
  public String ikm;
  public String uuo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      if (this.uuo != null) {
        paramVarArgs.d(2, this.uuo);
      }
      if (this.FLQ != null) {
        paramVarArgs.d(3, this.FLQ);
      }
      AppMethodBeat.o(209904);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.ikm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uuo);
      }
      i = paramInt;
      if (this.FLQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FLQ);
      }
      AppMethodBeat.o(209904);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(209904);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwx localcwx = (cwx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209904);
          return -1;
        case 1: 
          localcwx.ikm = locala.OmT.readString();
          AppMethodBeat.o(209904);
          return 0;
        case 2: 
          localcwx.uuo = locala.OmT.readString();
          AppMethodBeat.o(209904);
          return 0;
        }
        localcwx.FLQ = locala.OmT.readString();
        AppMethodBeat.o(209904);
        return 0;
      }
      AppMethodBeat.o(209904);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwx
 * JD-Core Version:    0.7.0.1
 */