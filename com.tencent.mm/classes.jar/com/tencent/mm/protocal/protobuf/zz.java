package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zz
  extends com.tencent.mm.bv.a
{
  public String color;
  public int qgh;
  public String qgi;
  public String qgj;
  public int qgk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48840);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.qgh);
      if (this.qgi != null) {
        paramVarArgs.e(2, this.qgi);
      }
      if (this.qgj != null) {
        paramVarArgs.e(3, this.qgj);
      }
      paramVarArgs.aO(4, this.qgk);
      if (this.color != null) {
        paramVarArgs.e(5, this.color);
      }
      AppMethodBeat.o(48840);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.qgh) + 0;
      paramInt = i;
      if (this.qgi != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.qgi);
      }
      i = paramInt;
      if (this.qgj != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.qgj);
      }
      i += e.a.a.b.b.a.bl(4, this.qgk);
      paramInt = i;
      if (this.color != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.color);
      }
      AppMethodBeat.o(48840);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48840);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      zz localzz = (zz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(48840);
        return -1;
      case 1: 
        localzz.qgh = locala.CLY.sl();
        AppMethodBeat.o(48840);
        return 0;
      case 2: 
        localzz.qgi = locala.CLY.readString();
        AppMethodBeat.o(48840);
        return 0;
      case 3: 
        localzz.qgj = locala.CLY.readString();
        AppMethodBeat.o(48840);
        return 0;
      case 4: 
        localzz.qgk = locala.CLY.sl();
        AppMethodBeat.o(48840);
        return 0;
      }
      localzz.color = locala.CLY.readString();
      AppMethodBeat.o(48840);
      return 0;
    }
    AppMethodBeat.o(48840);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zz
 * JD-Core Version:    0.7.0.1
 */