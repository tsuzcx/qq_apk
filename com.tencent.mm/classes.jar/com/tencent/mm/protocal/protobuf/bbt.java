package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbt
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public int scene;
  public String wAa;
  public String wBZ;
  public long xqP;
  public long xqQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124323);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.scene);
      if (this.wAa != null) {
        paramVarArgs.e(2, this.wAa);
      }
      paramVarArgs.am(3, this.xqP);
      paramVarArgs.am(4, this.xqQ);
      if (this.wBZ != null) {
        paramVarArgs.e(5, this.wBZ);
      }
      paramVarArgs.aO(6, this.jKs);
      AppMethodBeat.o(124323);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.scene) + 0;
      paramInt = i;
      if (this.wAa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wAa);
      }
      i = paramInt + e.a.a.b.b.a.p(3, this.xqP) + e.a.a.b.b.a.p(4, this.xqQ);
      paramInt = i;
      if (this.wBZ != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wBZ);
      }
      i = e.a.a.b.b.a.bl(6, this.jKs);
      AppMethodBeat.o(124323);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124323);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bbt localbbt = (bbt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124323);
        return -1;
      case 1: 
        localbbt.scene = locala.CLY.sl();
        AppMethodBeat.o(124323);
        return 0;
      case 2: 
        localbbt.wAa = locala.CLY.readString();
        AppMethodBeat.o(124323);
        return 0;
      case 3: 
        localbbt.xqP = locala.CLY.sm();
        AppMethodBeat.o(124323);
        return 0;
      case 4: 
        localbbt.xqQ = locala.CLY.sm();
        AppMethodBeat.o(124323);
        return 0;
      case 5: 
        localbbt.wBZ = locala.CLY.readString();
        AppMethodBeat.o(124323);
        return 0;
      }
      localbbt.jKs = locala.CLY.sl();
      AppMethodBeat.o(124323);
      return 0;
    }
    AppMethodBeat.o(124323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbt
 * JD-Core Version:    0.7.0.1
 */