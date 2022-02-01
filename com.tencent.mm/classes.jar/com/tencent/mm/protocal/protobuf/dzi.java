package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dzi
  extends com.tencent.mm.bx.a
{
  public b Gdx;
  public int HMA;
  public int HpZ;
  public int ape;
  public String category;
  public int inh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147790);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.inh);
      paramVarArgs.aS(2, this.ape);
      if (this.category != null) {
        paramVarArgs.d(3, this.category);
      }
      if (this.Gdx != null) {
        paramVarArgs.c(4, this.Gdx);
      }
      paramVarArgs.aS(5, this.HpZ);
      paramVarArgs.aS(6, this.HMA);
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.inh) + 0 + f.a.a.b.b.a.bz(2, this.ape);
      paramInt = i;
      if (this.category != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.category);
      }
      i = paramInt;
      if (this.Gdx != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Gdx);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.HpZ);
      int j = f.a.a.b.b.a.bz(6, this.HMA);
      AppMethodBeat.o(147790);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzi localdzi = (dzi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147790);
        return -1;
      case 1: 
        localdzi.inh = locala.NPN.zc();
        AppMethodBeat.o(147790);
        return 0;
      case 2: 
        localdzi.ape = locala.NPN.zc();
        AppMethodBeat.o(147790);
        return 0;
      case 3: 
        localdzi.category = locala.NPN.readString();
        AppMethodBeat.o(147790);
        return 0;
      case 4: 
        localdzi.Gdx = locala.NPN.gxI();
        AppMethodBeat.o(147790);
        return 0;
      case 5: 
        localdzi.HpZ = locala.NPN.zc();
        AppMethodBeat.o(147790);
        return 0;
      }
      localdzi.HMA = locala.NPN.zc();
      AppMethodBeat.o(147790);
      return 0;
    }
    AppMethodBeat.o(147790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzi
 * JD-Core Version:    0.7.0.1
 */