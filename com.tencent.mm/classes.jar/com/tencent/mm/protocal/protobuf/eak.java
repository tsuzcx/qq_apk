package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eak
  extends com.tencent.mm.bx.a
{
  public String HNw;
  public String HNx;
  public String Hfq;
  public String ufR;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hfq != null) {
        paramVarArgs.d(1, this.Hfq);
      }
      if (this.HNw != null) {
        paramVarArgs.d(2, this.HNw);
      }
      if (this.ukj != null) {
        paramVarArgs.d(3, this.ukj);
      }
      if (this.ufR != null) {
        paramVarArgs.d(4, this.ufR);
      }
      if (this.HNx != null) {
        paramVarArgs.d(5, this.HNx);
      }
      AppMethodBeat.o(32506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hfq == null) {
        break label465;
      }
    }
    label465:
    for (int i = f.a.a.b.b.a.e(1, this.Hfq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HNw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HNw);
      }
      i = paramInt;
      if (this.ukj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ukj);
      }
      paramInt = i;
      if (this.ufR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufR);
      }
      i = paramInt;
      if (this.HNx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HNx);
      }
      AppMethodBeat.o(32506);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32506);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eak localeak = (eak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32506);
          return -1;
        case 1: 
          localeak.Hfq = locala.NPN.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 2: 
          localeak.HNw = locala.NPN.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 3: 
          localeak.ukj = locala.NPN.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 4: 
          localeak.ufR = locala.NPN.readString();
          AppMethodBeat.o(32506);
          return 0;
        }
        localeak.HNx = locala.NPN.readString();
        AppMethodBeat.o(32506);
        return 0;
      }
      AppMethodBeat.o(32506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eak
 * JD-Core Version:    0.7.0.1
 */