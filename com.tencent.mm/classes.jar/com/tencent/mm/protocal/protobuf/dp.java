package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dp
  extends com.tencent.mm.bw.a
{
  public String FOp;
  public String dyI;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168751);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.FOp != null) {
        paramVarArgs.d(3, this.FOp);
      }
      AppMethodBeat.o(168751);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.FOp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FOp);
      }
      AppMethodBeat.o(168751);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168751);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dp localdp = (dp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168751);
          return -1;
        case 1: 
          localdp.title = locala.OmT.readString();
          AppMethodBeat.o(168751);
          return 0;
        case 2: 
          localdp.dyI = locala.OmT.readString();
          AppMethodBeat.o(168751);
          return 0;
        }
        localdp.FOp = locala.OmT.readString();
        AppMethodBeat.o(168751);
        return 0;
      }
      AppMethodBeat.o(168751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dp
 * JD-Core Version:    0.7.0.1
 */