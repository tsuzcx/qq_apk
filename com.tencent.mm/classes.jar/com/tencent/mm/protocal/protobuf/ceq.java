package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ceq
  extends com.tencent.mm.bw.a
{
  public int Ftm;
  public String Ftn;
  public String hkM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ftm);
      if (this.Ftn != null) {
        paramVarArgs.d(2, this.Ftn);
      }
      if (this.hkM != null) {
        paramVarArgs.d(3, this.hkM);
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ftm) + 0;
      paramInt = i;
      if (this.Ftn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ftn);
      }
      i = paramInt;
      if (this.hkM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hkM);
      }
      AppMethodBeat.o(124538);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ceq localceq = (ceq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124538);
        return -1;
      case 1: 
        localceq.Ftm = locala.LVo.xF();
        AppMethodBeat.o(124538);
        return 0;
      case 2: 
        localceq.Ftn = locala.LVo.readString();
        AppMethodBeat.o(124538);
        return 0;
      }
      localceq.hkM = locala.LVo.readString();
      AppMethodBeat.o(124538);
      return 0;
    }
    AppMethodBeat.o(124538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceq
 * JD-Core Version:    0.7.0.1
 */