package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckd
  extends com.tencent.mm.bx.a
{
  public String HdH;
  public String HdI;
  public String HdJ;
  public String HdK;
  public boolean HdL;
  public String HdM;
  public String dkR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72547);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HdH != null) {
        paramVarArgs.d(1, this.HdH);
      }
      if (this.HdI != null) {
        paramVarArgs.d(2, this.HdI);
      }
      if (this.dkR != null) {
        paramVarArgs.d(3, this.dkR);
      }
      if (this.HdJ != null) {
        paramVarArgs.d(4, this.HdJ);
      }
      if (this.HdK != null) {
        paramVarArgs.d(5, this.HdK);
      }
      paramVarArgs.bt(6, this.HdL);
      if (this.HdM != null) {
        paramVarArgs.d(7, this.HdM);
      }
      AppMethodBeat.o(72547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HdH == null) {
        break label558;
      }
    }
    label558:
    for (int i = f.a.a.b.b.a.e(1, this.HdH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HdI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HdI);
      }
      i = paramInt;
      if (this.dkR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dkR);
      }
      paramInt = i;
      if (this.HdJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HdJ);
      }
      i = paramInt;
      if (this.HdK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HdK);
      }
      i += f.a.a.b.b.a.alV(6);
      paramInt = i;
      if (this.HdM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HdM);
      }
      AppMethodBeat.o(72547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72547);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckd localckd = (ckd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72547);
          return -1;
        case 1: 
          localckd.HdH = locala.NPN.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 2: 
          localckd.HdI = locala.NPN.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 3: 
          localckd.dkR = locala.NPN.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 4: 
          localckd.HdJ = locala.NPN.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 5: 
          localckd.HdK = locala.NPN.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 6: 
          localckd.HdL = locala.NPN.grw();
          AppMethodBeat.o(72547);
          return 0;
        }
        localckd.HdM = locala.NPN.readString();
        AppMethodBeat.o(72547);
        return 0;
      }
      AppMethodBeat.o(72547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckd
 * JD-Core Version:    0.7.0.1
 */