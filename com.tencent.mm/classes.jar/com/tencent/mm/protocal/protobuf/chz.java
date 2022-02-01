package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chz
  extends com.tencent.mm.bx.a
{
  public String doh;
  public int number;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72576);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.type != null) {
        paramVarArgs.d(1, this.type);
      }
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      paramVarArgs.aR(3, this.number);
      AppMethodBeat.o(72576);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.doh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.doh);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.number);
      AppMethodBeat.o(72576);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72576);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chz localchz = (chz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72576);
          return -1;
        case 1: 
          localchz.type = locala.KhF.readString();
          AppMethodBeat.o(72576);
          return 0;
        case 2: 
          localchz.doh = locala.KhF.readString();
          AppMethodBeat.o(72576);
          return 0;
        }
        localchz.number = locala.KhF.xS();
        AppMethodBeat.o(72576);
        return 0;
      }
      AppMethodBeat.o(72576);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chz
 * JD-Core Version:    0.7.0.1
 */