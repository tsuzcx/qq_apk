package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahk
  extends com.tencent.mm.bx.a
{
  public int FMH;
  public String Name;
  public String PriceType;
  public int ukh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      paramVarArgs.aS(2, this.FMH);
      if (this.PriceType != null) {
        paramVarArgs.d(3, this.PriceType);
      }
      paramVarArgs.aS(4, this.ukh);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FMH);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.PriceType);
      }
      i = f.a.a.b.b.a.bz(4, this.ukh);
      AppMethodBeat.o(91446);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91446);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahk localahk = (ahk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91446);
          return -1;
        case 1: 
          localahk.Name = locala.NPN.readString();
          AppMethodBeat.o(91446);
          return 0;
        case 2: 
          localahk.FMH = locala.NPN.zc();
          AppMethodBeat.o(91446);
          return 0;
        case 3: 
          localahk.PriceType = locala.NPN.readString();
          AppMethodBeat.o(91446);
          return 0;
        }
        localahk.ukh = locala.NPN.zc();
        AppMethodBeat.o(91446);
        return 0;
      }
      AppMethodBeat.o(91446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahk
 * JD-Core Version:    0.7.0.1
 */