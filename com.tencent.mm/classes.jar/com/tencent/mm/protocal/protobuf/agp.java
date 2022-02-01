package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agp
  extends com.tencent.mm.bx.a
{
  public int Cxp;
  public String Cxq;
  public String Desc;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138174);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      paramVarArgs.aR(3, this.Cxp);
      if (this.Cxq != null) {
        paramVarArgs.d(4, this.Cxq);
      }
      AppMethodBeat.o(138174);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Desc);
      }
      i += f.a.a.b.b.a.bA(3, this.Cxp);
      paramInt = i;
      if (this.Cxq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Cxq);
      }
      AppMethodBeat.o(138174);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(138174);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agp localagp = (agp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138174);
          return -1;
        case 1: 
          localagp.Title = locala.KhF.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 2: 
          localagp.Desc = locala.KhF.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 3: 
          localagp.Cxp = locala.KhF.xS();
          AppMethodBeat.o(138174);
          return 0;
        }
        localagp.Cxq = locala.KhF.readString();
        AppMethodBeat.o(138174);
        return 0;
      }
      AppMethodBeat.o(138174);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agp
 * JD-Core Version:    0.7.0.1
 */