package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czb
  extends com.tencent.mm.bv.a
{
  public int wwX;
  public String yfZ;
  public String yga;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96319);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wwX);
      if (this.yfZ != null) {
        paramVarArgs.e(2, this.yfZ);
      }
      if (this.yga != null) {
        paramVarArgs.e(3, this.yga);
      }
      AppMethodBeat.o(96319);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wwX) + 0;
      paramInt = i;
      if (this.yfZ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.yfZ);
      }
      i = paramInt;
      if (this.yga != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.yga);
      }
      AppMethodBeat.o(96319);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96319);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      czb localczb = (czb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96319);
        return -1;
      case 1: 
        localczb.wwX = locala.CLY.sl();
        AppMethodBeat.o(96319);
        return 0;
      case 2: 
        localczb.yfZ = locala.CLY.readString();
        AppMethodBeat.o(96319);
        return 0;
      }
      localczb.yga = locala.CLY.readString();
      AppMethodBeat.o(96319);
      return 0;
    }
    AppMethodBeat.o(96319);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czb
 * JD-Core Version:    0.7.0.1
 */