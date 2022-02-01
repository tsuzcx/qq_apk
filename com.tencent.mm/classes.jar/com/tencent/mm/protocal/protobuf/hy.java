package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hy
  extends com.tencent.mm.bx.a
{
  public String title;
  public int uaQ;
  public String zHs;
  public String zHt;
  public String zVl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91354);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      paramVarArgs.aR(2, this.uaQ);
      if (this.zVl != null) {
        paramVarArgs.d(3, this.zVl);
      }
      if (this.zHs != null) {
        paramVarArgs.d(4, this.zHs);
      }
      if (this.zHt != null) {
        paramVarArgs.d(5, this.zHt);
      }
      AppMethodBeat.o(91354);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.uaQ);
      paramInt = i;
      if (this.zVl != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.zVl);
      }
      i = paramInt;
      if (this.zHs != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.zHs);
      }
      paramInt = i;
      if (this.zHt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.zHt);
      }
      AppMethodBeat.o(91354);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91354);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hy localhy = (hy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91354);
          return -1;
        case 1: 
          localhy.title = locala.KhF.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 2: 
          localhy.uaQ = locala.KhF.xS();
          AppMethodBeat.o(91354);
          return 0;
        case 3: 
          localhy.zVl = locala.KhF.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 4: 
          localhy.zHs = locala.KhF.readString();
          AppMethodBeat.o(91354);
          return 0;
        }
        localhy.zHt = locala.KhF.readString();
        AppMethodBeat.o(91354);
        return 0;
      }
      AppMethodBeat.o(91354);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hy
 * JD-Core Version:    0.7.0.1
 */