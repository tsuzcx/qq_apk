package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dba
  extends com.tencent.mm.bx.a
{
  public String HqQ;
  public String HqR;
  public String dtL;
  public String qXk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122526);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qXk != null) {
        paramVarArgs.d(1, this.qXk);
      }
      if (this.HqQ != null) {
        paramVarArgs.d(2, this.HqQ);
      }
      if (this.dtL != null) {
        paramVarArgs.d(3, this.dtL);
      }
      if (this.HqR != null) {
        paramVarArgs.d(4, this.HqR);
      }
      AppMethodBeat.o(122526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qXk == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.qXk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HqQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HqQ);
      }
      i = paramInt;
      if (this.dtL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dtL);
      }
      paramInt = i;
      if (this.HqR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HqR);
      }
      AppMethodBeat.o(122526);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122526);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dba localdba = (dba)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122526);
          return -1;
        case 1: 
          localdba.qXk = locala.NPN.readString();
          AppMethodBeat.o(122526);
          return 0;
        case 2: 
          localdba.HqQ = locala.NPN.readString();
          AppMethodBeat.o(122526);
          return 0;
        case 3: 
          localdba.dtL = locala.NPN.readString();
          AppMethodBeat.o(122526);
          return 0;
        }
        localdba.HqR = locala.NPN.readString();
        AppMethodBeat.o(122526);
        return 0;
      }
      AppMethodBeat.o(122526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dba
 * JD-Core Version:    0.7.0.1
 */