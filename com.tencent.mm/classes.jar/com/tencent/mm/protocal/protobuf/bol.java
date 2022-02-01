package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bol
  extends com.tencent.mm.bx.a
{
  public String DLQ;
  public String DLR;
  public String DLS;
  public String gKD;
  public String gKF;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103209);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.gKF != null) {
        paramVarArgs.d(2, this.gKF);
      }
      if (this.gKD != null) {
        paramVarArgs.d(3, this.gKD);
      }
      if (this.DLQ != null) {
        paramVarArgs.d(4, this.DLQ);
      }
      if (this.DLR != null) {
        paramVarArgs.d(5, this.DLR);
      }
      if (this.DLS != null) {
        paramVarArgs.d(6, this.DLS);
      }
      AppMethodBeat.o(103209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gKF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gKF);
      }
      i = paramInt;
      if (this.gKD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKD);
      }
      paramInt = i;
      if (this.DLQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLQ);
      }
      i = paramInt;
      if (this.DLR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DLR);
      }
      paramInt = i;
      if (this.DLS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DLS);
      }
      AppMethodBeat.o(103209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103209);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bol localbol = (bol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103209);
          return -1;
        case 1: 
          localbol.title = locala.KhF.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 2: 
          localbol.gKF = locala.KhF.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 3: 
          localbol.gKD = locala.KhF.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 4: 
          localbol.DLQ = locala.KhF.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 5: 
          localbol.DLR = locala.KhF.readString();
          AppMethodBeat.o(103209);
          return 0;
        }
        localbol.DLS = locala.KhF.readString();
        AppMethodBeat.o(103209);
        return 0;
      }
      AppMethodBeat.o(103209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bol
 * JD-Core Version:    0.7.0.1
 */