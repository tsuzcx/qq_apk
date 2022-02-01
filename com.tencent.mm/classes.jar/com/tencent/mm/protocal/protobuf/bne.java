package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bne
  extends com.tencent.mm.bx.a
{
  public String CGX;
  public int CVe;
  public String DKO;
  public String DKP;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DKO != null) {
        paramVarArgs.d(1, this.DKO);
      }
      if (this.CGX != null) {
        paramVarArgs.d(2, this.CGX);
      }
      if (this.type != null) {
        paramVarArgs.d(3, this.type);
      }
      paramVarArgs.aR(4, this.CVe);
      if (this.DKP != null) {
        paramVarArgs.d(5, this.DKP);
      }
      AppMethodBeat.o(116340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DKO == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.DKO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CGX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CGX);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.type);
      }
      i += f.a.a.b.b.a.bA(4, this.CVe);
      paramInt = i;
      if (this.DKP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DKP);
      }
      AppMethodBeat.o(116340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116340);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bne localbne = (bne)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116340);
          return -1;
        case 1: 
          localbne.DKO = locala.KhF.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 2: 
          localbne.CGX = locala.KhF.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 3: 
          localbne.type = locala.KhF.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 4: 
          localbne.CVe = locala.KhF.xS();
          AppMethodBeat.o(116340);
          return 0;
        }
        localbne.DKP = locala.KhF.readString();
        AppMethodBeat.o(116340);
        return 0;
      }
      AppMethodBeat.o(116340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bne
 * JD-Core Version:    0.7.0.1
 */