package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aec
  extends com.tencent.mm.bx.a
{
  public int CNG;
  public String Name;
  public String PriceType;
  public int sdO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      paramVarArgs.aR(2, this.CNG);
      if (this.PriceType != null) {
        paramVarArgs.d(3, this.PriceType);
      }
      paramVarArgs.aR(4, this.sdO);
      AppMethodBeat.o(91446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CNG);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.PriceType);
      }
      i = f.a.a.b.b.a.bA(4, this.sdO);
      AppMethodBeat.o(91446);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91446);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aec localaec = (aec)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91446);
          return -1;
        case 1: 
          localaec.Name = locala.KhF.readString();
          AppMethodBeat.o(91446);
          return 0;
        case 2: 
          localaec.CNG = locala.KhF.xS();
          AppMethodBeat.o(91446);
          return 0;
        case 3: 
          localaec.PriceType = locala.KhF.readString();
          AppMethodBeat.o(91446);
          return 0;
        }
        localaec.sdO = locala.KhF.xS();
        AppMethodBeat.o(91446);
        return 0;
      }
      AppMethodBeat.o(91446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aec
 * JD-Core Version:    0.7.0.1
 */