package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ecq
  extends com.tencent.mm.bw.a
{
  public b IhN;
  public String description;
  public String qlv;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qlv != null) {
        paramVarArgs.d(1, this.qlv);
      }
      if (this.IhN != null) {
        paramVarArgs.c(2, this.IhN);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.description != null) {
        paramVarArgs.d(4, this.description);
      }
      AppMethodBeat.o(188965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qlv == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.qlv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IhN != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.IhN);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.description);
      }
      AppMethodBeat.o(188965);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188965);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecq localecq = (ecq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(188965);
          return -1;
        case 1: 
          localecq.qlv = locala.OmT.readString();
          AppMethodBeat.o(188965);
          return 0;
        case 2: 
          localecq.IhN = locala.OmT.gCk();
          AppMethodBeat.o(188965);
          return 0;
        case 3: 
          localecq.title = locala.OmT.readString();
          AppMethodBeat.o(188965);
          return 0;
        }
        localecq.description = locala.OmT.readString();
        AppMethodBeat.o(188965);
        return 0;
      }
      AppMethodBeat.o(188965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecq
 * JD-Core Version:    0.7.0.1
 */