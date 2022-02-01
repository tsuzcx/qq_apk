package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecs
  extends com.tencent.mm.bw.a
{
  public String HYl;
  public String IhQ;
  public String IhR;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91726);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.IhQ != null) {
        paramVarArgs.d(2, this.IhQ);
      }
      if (this.HYl != null) {
        paramVarArgs.d(3, this.HYl);
      }
      if (this.IhR != null) {
        paramVarArgs.d(4, this.IhR);
      }
      AppMethodBeat.o(91726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IhQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IhQ);
      }
      i = paramInt;
      if (this.HYl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HYl);
      }
      paramInt = i;
      if (this.IhR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IhR);
      }
      AppMethodBeat.o(91726);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91726);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecs localecs = (ecs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91726);
          return -1;
        case 1: 
          localecs.title = locala.OmT.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 2: 
          localecs.IhQ = locala.OmT.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 3: 
          localecs.HYl = locala.OmT.readString();
          AppMethodBeat.o(91726);
          return 0;
        }
        localecs.IhR = locala.OmT.readString();
        AppMethodBeat.o(91726);
        return 0;
      }
      AppMethodBeat.o(91726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecs
 * JD-Core Version:    0.7.0.1
 */