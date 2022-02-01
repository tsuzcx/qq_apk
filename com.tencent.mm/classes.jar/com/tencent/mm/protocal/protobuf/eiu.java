package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eiu
  extends com.tencent.mm.bw.a
{
  public int IlX;
  public int IlY;
  public int IlZ;
  public int Ima;
  public int Imb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50122);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IlX);
      paramVarArgs.aS(2, this.IlY);
      paramVarArgs.aS(3, this.IlZ);
      paramVarArgs.aS(4, this.Ima);
      paramVarArgs.aS(5, this.Imb);
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.IlX);
      int i = f.a.a.b.b.a.bz(2, this.IlY);
      int j = f.a.a.b.b.a.bz(3, this.IlZ);
      int k = f.a.a.b.b.a.bz(4, this.Ima);
      int m = f.a.a.b.b.a.bz(5, this.Imb);
      AppMethodBeat.o(50122);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eiu localeiu = (eiu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50122);
        return -1;
      case 1: 
        localeiu.IlX = locala.OmT.zc();
        AppMethodBeat.o(50122);
        return 0;
      case 2: 
        localeiu.IlY = locala.OmT.zc();
        AppMethodBeat.o(50122);
        return 0;
      case 3: 
        localeiu.IlZ = locala.OmT.zc();
        AppMethodBeat.o(50122);
        return 0;
      case 4: 
        localeiu.Ima = locala.OmT.zc();
        AppMethodBeat.o(50122);
        return 0;
      }
      localeiu.Imb = locala.OmT.zc();
      AppMethodBeat.o(50122);
      return 0;
    }
    AppMethodBeat.o(50122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiu
 * JD-Core Version:    0.7.0.1
 */