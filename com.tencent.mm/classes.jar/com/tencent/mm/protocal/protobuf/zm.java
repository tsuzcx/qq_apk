package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zm
  extends com.tencent.mm.bv.a
{
  public int Ret;
  public long pIG;
  public int pIx;
  public int pIy;
  public String wQr;
  public int wQx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(53872);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Ret);
      paramVarArgs.aO(2, this.pIy);
      paramVarArgs.aO(3, this.pIx);
      if (this.wQr != null) {
        paramVarArgs.e(4, this.wQr);
      }
      paramVarArgs.aO(5, this.wQx);
      paramVarArgs.am(6, this.pIG);
      AppMethodBeat.o(53872);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.Ret) + 0 + e.a.a.b.b.a.bl(2, this.pIy) + e.a.a.b.b.a.bl(3, this.pIx);
      paramInt = i;
      if (this.wQr != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wQr);
      }
      i = e.a.a.b.b.a.bl(5, this.wQx);
      int j = e.a.a.b.b.a.p(6, this.pIG);
      AppMethodBeat.o(53872);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(53872);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      zm localzm = (zm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(53872);
        return -1;
      case 1: 
        localzm.Ret = locala.CLY.sl();
        AppMethodBeat.o(53872);
        return 0;
      case 2: 
        localzm.pIy = locala.CLY.sl();
        AppMethodBeat.o(53872);
        return 0;
      case 3: 
        localzm.pIx = locala.CLY.sl();
        AppMethodBeat.o(53872);
        return 0;
      case 4: 
        localzm.wQr = locala.CLY.readString();
        AppMethodBeat.o(53872);
        return 0;
      case 5: 
        localzm.wQx = locala.CLY.sl();
        AppMethodBeat.o(53872);
        return 0;
      }
      localzm.pIG = locala.CLY.sm();
      AppMethodBeat.o(53872);
      return 0;
    }
    AppMethodBeat.o(53872);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zm
 * JD-Core Version:    0.7.0.1
 */