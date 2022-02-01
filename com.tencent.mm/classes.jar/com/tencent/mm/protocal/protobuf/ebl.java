package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebl
  extends com.tencent.mm.bw.a
{
  public String FKz;
  public boolean IgV;
  public String IgW;
  public int IgX;
  public int IgY;
  public int IgZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147805);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.IgV);
      if (this.FKz != null) {
        paramVarArgs.d(2, this.FKz);
      }
      if (this.IgW != null) {
        paramVarArgs.d(3, this.IgW);
      }
      paramVarArgs.aS(4, this.IgX);
      paramVarArgs.aS(5, this.IgY);
      paramVarArgs.aS(6, this.IgZ);
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0;
      paramInt = i;
      if (this.FKz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FKz);
      }
      i = paramInt;
      if (this.IgW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IgW);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.IgX);
      int j = f.a.a.b.b.a.bz(5, this.IgY);
      int k = f.a.a.b.b.a.bz(6, this.IgZ);
      AppMethodBeat.o(147805);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ebl localebl = (ebl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147805);
        return -1;
      case 1: 
        localebl.IgV = locala.OmT.gvY();
        AppMethodBeat.o(147805);
        return 0;
      case 2: 
        localebl.FKz = locala.OmT.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 3: 
        localebl.IgW = locala.OmT.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 4: 
        localebl.IgX = locala.OmT.zc();
        AppMethodBeat.o(147805);
        return 0;
      case 5: 
        localebl.IgY = locala.OmT.zc();
        AppMethodBeat.o(147805);
        return 0;
      }
      localebl.IgZ = locala.OmT.zc();
      AppMethodBeat.o(147805);
      return 0;
    }
    AppMethodBeat.o(147805);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebl
 * JD-Core Version:    0.7.0.1
 */