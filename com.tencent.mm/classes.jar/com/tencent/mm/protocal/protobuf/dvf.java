package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dvf
  extends com.tencent.mm.bw.a
{
  public b GcJ;
  public String description;
  public String pBl;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pBl != null) {
        paramVarArgs.d(1, this.pBl);
      }
      if (this.GcJ != null) {
        paramVarArgs.c(2, this.GcJ);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.description != null) {
        paramVarArgs.d(4, this.description);
      }
      AppMethodBeat.o(209579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pBl == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.pBl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GcJ != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GcJ);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.description);
      }
      AppMethodBeat.o(209579);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(209579);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvf localdvf = (dvf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209579);
          return -1;
        case 1: 
          localdvf.pBl = locala.LVo.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 2: 
          localdvf.GcJ = locala.LVo.gfk();
          AppMethodBeat.o(209579);
          return 0;
        case 3: 
          localdvf.title = locala.LVo.readString();
          AppMethodBeat.o(209579);
          return 0;
        }
        localdvf.description = locala.LVo.readString();
        AppMethodBeat.o(209579);
        return 0;
      }
      AppMethodBeat.o(209579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvf
 * JD-Core Version:    0.7.0.1
 */