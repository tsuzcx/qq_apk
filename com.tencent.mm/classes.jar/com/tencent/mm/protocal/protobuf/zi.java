package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zi
  extends com.tencent.mm.bx.a
{
  public int ika;
  public String ikb;
  public String ikc;
  public String ikd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ika);
      if (this.ikb != null) {
        paramVarArgs.d(2, this.ikb);
      }
      if (this.ikc != null) {
        paramVarArgs.d(3, this.ikc);
      }
      if (this.ikd != null) {
        paramVarArgs.d(4, this.ikd);
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.ika) + 0;
      paramInt = i;
      if (this.ikb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikb);
      }
      i = paramInt;
      if (this.ikc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ikc);
      }
      paramInt = i;
      if (this.ikd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ikd);
      }
      AppMethodBeat.o(117864);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      zi localzi = (zi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117864);
        return -1;
      case 1: 
        localzi.ika = locala.KhF.xS();
        AppMethodBeat.o(117864);
        return 0;
      case 2: 
        localzi.ikb = locala.KhF.readString();
        AppMethodBeat.o(117864);
        return 0;
      case 3: 
        localzi.ikc = locala.KhF.readString();
        AppMethodBeat.o(117864);
        return 0;
      }
      localzi.ikd = locala.KhF.readString();
      AppMethodBeat.o(117864);
      return 0;
    }
    AppMethodBeat.o(117864);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zi
 * JD-Core Version:    0.7.0.1
 */