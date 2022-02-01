package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ij
  extends com.tencent.mm.bx.a
{
  public String CNU;
  public String CzQ;
  public String CzR;
  public String title;
  public int uxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91354);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      paramVarArgs.aS(2, this.uxt);
      if (this.CNU != null) {
        paramVarArgs.d(3, this.CNU);
      }
      if (this.CzQ != null) {
        paramVarArgs.d(4, this.CzQ);
      }
      if (this.CzR != null) {
        paramVarArgs.d(5, this.CzR);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.uxt);
      paramInt = i;
      if (this.CNU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CNU);
      }
      i = paramInt;
      if (this.CzQ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CzQ);
      }
      paramInt = i;
      if (this.CzR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CzR);
      }
      AppMethodBeat.o(91354);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91354);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ij localij = (ij)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91354);
          return -1;
        case 1: 
          localij.title = locala.NPN.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 2: 
          localij.uxt = locala.NPN.zc();
          AppMethodBeat.o(91354);
          return 0;
        case 3: 
          localij.CNU = locala.NPN.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 4: 
          localij.CzQ = locala.NPN.readString();
          AppMethodBeat.o(91354);
          return 0;
        }
        localij.CzR = locala.NPN.readString();
        AppMethodBeat.o(91354);
        return 0;
      }
      AppMethodBeat.o(91354);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ij
 * JD-Core Version:    0.7.0.1
 */