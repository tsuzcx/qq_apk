package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wd
  extends com.tencent.mm.bv.a
{
  public int gxd;
  public String gxe;
  public String gxf;
  public String gxg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124312);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.gxd);
      if (this.gxe != null) {
        paramVarArgs.e(2, this.gxe);
      }
      if (this.gxf != null) {
        paramVarArgs.e(3, this.gxf);
      }
      if (this.gxg != null) {
        paramVarArgs.e(4, this.gxg);
      }
      AppMethodBeat.o(124312);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.gxd) + 0;
      paramInt = i;
      if (this.gxe != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.gxe);
      }
      i = paramInt;
      if (this.gxf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.gxf);
      }
      paramInt = i;
      if (this.gxg != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.gxg);
      }
      AppMethodBeat.o(124312);
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
      AppMethodBeat.o(124312);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      wd localwd = (wd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124312);
        return -1;
      case 1: 
        localwd.gxd = locala.CLY.sl();
        AppMethodBeat.o(124312);
        return 0;
      case 2: 
        localwd.gxe = locala.CLY.readString();
        AppMethodBeat.o(124312);
        return 0;
      case 3: 
        localwd.gxf = locala.CLY.readString();
        AppMethodBeat.o(124312);
        return 0;
      }
      localwd.gxg = locala.CLY.readString();
      AppMethodBeat.o(124312);
      return 0;
    }
    AppMethodBeat.o(124312);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wd
 * JD-Core Version:    0.7.0.1
 */