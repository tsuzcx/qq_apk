package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ia
  extends com.tencent.mm.bx.a
{
  public String CDx;
  public String dca;
  public String szi;
  public String uoo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91356);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CDx != null) {
        paramVarArgs.d(1, this.CDx);
      }
      if (this.dca != null) {
        paramVarArgs.d(2, this.dca);
      }
      if (this.szi != null) {
        paramVarArgs.d(3, this.szi);
      }
      if (this.uoo != null) {
        paramVarArgs.d(4, this.uoo);
      }
      AppMethodBeat.o(91356);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CDx == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.CDx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dca != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dca);
      }
      i = paramInt;
      if (this.szi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.szi);
      }
      paramInt = i;
      if (this.uoo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uoo);
      }
      AppMethodBeat.o(91356);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91356);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ia localia = (ia)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91356);
          return -1;
        case 1: 
          localia.CDx = locala.KhF.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 2: 
          localia.dca = locala.KhF.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 3: 
          localia.szi = locala.KhF.readString();
          AppMethodBeat.o(91356);
          return 0;
        }
        localia.uoo = locala.KhF.readString();
        AppMethodBeat.o(91356);
        return 0;
      }
      AppMethodBeat.o(91356);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ia
 * JD-Core Version:    0.7.0.1
 */