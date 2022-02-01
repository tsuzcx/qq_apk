package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqp
  extends com.tencent.mm.bx.a
{
  public String FBo;
  public String FBp;
  public String dkR;
  public String hzB;
  public String uJF;
  public String wBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72615);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dkR != null) {
        paramVarArgs.d(1, this.dkR);
      }
      if (this.hzB != null) {
        paramVarArgs.d(2, this.hzB);
      }
      if (this.uJF != null) {
        paramVarArgs.d(3, this.uJF);
      }
      if (this.wBI != null) {
        paramVarArgs.d(4, this.wBI);
      }
      if (this.FBo != null) {
        paramVarArgs.d(5, this.FBo);
      }
      if (this.FBp != null) {
        paramVarArgs.d(6, this.FBp);
      }
      AppMethodBeat.o(72615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dkR == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.dkR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hzB);
      }
      i = paramInt;
      if (this.uJF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uJF);
      }
      paramInt = i;
      if (this.wBI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wBI);
      }
      i = paramInt;
      if (this.FBo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FBo);
      }
      paramInt = i;
      if (this.FBp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FBp);
      }
      AppMethodBeat.o(72615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72615);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqp localdqp = (dqp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72615);
          return -1;
        case 1: 
          localdqp.dkR = locala.NPN.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 2: 
          localdqp.hzB = locala.NPN.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 3: 
          localdqp.uJF = locala.NPN.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 4: 
          localdqp.wBI = locala.NPN.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 5: 
          localdqp.FBo = locala.NPN.readString();
          AppMethodBeat.o(72615);
          return 0;
        }
        localdqp.FBp = locala.NPN.readString();
        AppMethodBeat.o(72615);
        return 0;
      }
      AppMethodBeat.o(72615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqp
 * JD-Core Version:    0.7.0.1
 */