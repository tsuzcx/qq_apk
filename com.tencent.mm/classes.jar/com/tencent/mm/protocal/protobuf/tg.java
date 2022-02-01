package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tg
  extends com.tencent.mm.bx.a
{
  public String CzQ;
  public String CzR;
  public int Dhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CzQ != null) {
        paramVarArgs.d(1, this.CzQ);
      }
      if (this.CzR != null) {
        paramVarArgs.d(2, this.CzR);
      }
      paramVarArgs.aS(3, this.Dhk);
      AppMethodBeat.o(113965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CzQ == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.CzQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CzR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CzR);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Dhk);
      AppMethodBeat.o(113965);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113965);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        tg localtg = (tg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113965);
          return -1;
        case 1: 
          localtg.CzQ = locala.NPN.readString();
          AppMethodBeat.o(113965);
          return 0;
        case 2: 
          localtg.CzR = locala.NPN.readString();
          AppMethodBeat.o(113965);
          return 0;
        }
        localtg.Dhk = locala.NPN.zc();
        AppMethodBeat.o(113965);
        return 0;
      }
      AppMethodBeat.o(113965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tg
 * JD-Core Version:    0.7.0.1
 */