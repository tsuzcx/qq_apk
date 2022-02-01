package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vf
  extends com.tencent.mm.bx.a
{
  public int CXj;
  public String doh;
  public String title;
  public String uoA;
  public String vCY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      if (this.uoA != null) {
        paramVarArgs.d(3, this.uoA);
      }
      if (this.vCY != null) {
        paramVarArgs.d(4, this.vCY);
      }
      paramVarArgs.aR(5, this.CXj);
      AppMethodBeat.o(72459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt;
      if (this.uoA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uoA);
      }
      paramInt = i;
      if (this.vCY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vCY);
      }
      i = f.a.a.b.b.a.bA(5, this.CXj);
      AppMethodBeat.o(72459);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72459);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        vf localvf = (vf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72459);
          return -1;
        case 1: 
          localvf.title = locala.KhF.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 2: 
          localvf.doh = locala.KhF.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 3: 
          localvf.uoA = locala.KhF.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 4: 
          localvf.vCY = locala.KhF.readString();
          AppMethodBeat.o(72459);
          return 0;
        }
        localvf.CXj = locala.KhF.xS();
        AppMethodBeat.o(72459);
        return 0;
      }
      AppMethodBeat.o(72459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vf
 * JD-Core Version:    0.7.0.1
 */