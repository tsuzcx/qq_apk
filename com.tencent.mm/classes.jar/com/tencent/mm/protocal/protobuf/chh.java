package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chh
  extends com.tencent.mm.bx.a
{
  public String EcM;
  public String EcN;
  public int EcO;
  public int EcP = 0;
  public String EcQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117895);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EcM != null) {
        paramVarArgs.d(1, this.EcM);
      }
      if (this.EcN != null) {
        paramVarArgs.d(2, this.EcN);
      }
      paramVarArgs.aR(3, this.EcO);
      paramVarArgs.aR(4, this.EcP);
      if (this.EcQ != null) {
        paramVarArgs.d(5, this.EcQ);
      }
      AppMethodBeat.o(117895);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EcM == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.EcM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EcN != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EcN);
      }
      i = i + f.a.a.b.b.a.bA(3, this.EcO) + f.a.a.b.b.a.bA(4, this.EcP);
      paramInt = i;
      if (this.EcQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EcQ);
      }
      AppMethodBeat.o(117895);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117895);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chh localchh = (chh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117895);
          return -1;
        case 1: 
          localchh.EcM = locala.KhF.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 2: 
          localchh.EcN = locala.KhF.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 3: 
          localchh.EcO = locala.KhF.xS();
          AppMethodBeat.o(117895);
          return 0;
        case 4: 
          localchh.EcP = locala.KhF.xS();
          AppMethodBeat.o(117895);
          return 0;
        }
        localchh.EcQ = locala.KhF.readString();
        AppMethodBeat.o(117895);
        return 0;
      }
      AppMethodBeat.o(117895);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chh
 * JD-Core Version:    0.7.0.1
 */