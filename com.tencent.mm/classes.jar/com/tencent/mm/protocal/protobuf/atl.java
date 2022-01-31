package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atl
  extends com.tencent.mm.bv.a
{
  public int Ret;
  public String jJA;
  public String jKG;
  public String wYu;
  public String wvt;
  public String xiH;
  public String xiI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73720);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wvt != null) {
        paramVarArgs.e(1, this.wvt);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      if (this.xiH != null) {
        paramVarArgs.e(3, this.xiH);
      }
      if (this.xiI != null) {
        paramVarArgs.e(4, this.xiI);
      }
      paramVarArgs.aO(5, this.Ret);
      if (this.jKG != null) {
        paramVarArgs.e(6, this.jKG);
      }
      if (this.wYu != null) {
        paramVarArgs.e(7, this.wYu);
      }
      AppMethodBeat.o(73720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wvt == null) {
        break label562;
      }
    }
    label562:
    for (int i = e.a.a.b.b.a.f(1, this.wvt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = paramInt;
      if (this.xiH != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xiH);
      }
      paramInt = i;
      if (this.xiI != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xiI);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.Ret);
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.jKG);
      }
      i = paramInt;
      if (this.wYu != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wYu);
      }
      AppMethodBeat.o(73720);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73720);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        atl localatl = (atl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(73720);
          return -1;
        case 1: 
          localatl.wvt = locala.CLY.readString();
          AppMethodBeat.o(73720);
          return 0;
        case 2: 
          localatl.jJA = locala.CLY.readString();
          AppMethodBeat.o(73720);
          return 0;
        case 3: 
          localatl.xiH = locala.CLY.readString();
          AppMethodBeat.o(73720);
          return 0;
        case 4: 
          localatl.xiI = locala.CLY.readString();
          AppMethodBeat.o(73720);
          return 0;
        case 5: 
          localatl.Ret = locala.CLY.sl();
          AppMethodBeat.o(73720);
          return 0;
        case 6: 
          localatl.jKG = locala.CLY.readString();
          AppMethodBeat.o(73720);
          return 0;
        }
        localatl.wYu = locala.CLY.readString();
        AppMethodBeat.o(73720);
        return 0;
      }
      AppMethodBeat.o(73720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atl
 * JD-Core Version:    0.7.0.1
 */