package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckm
  extends com.tencent.mm.bv.a
{
  public String kwH;
  public String sign;
  public String wYQ;
  public String xUr;
  public int xUs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56989);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xUr != null) {
        paramVarArgs.e(4, this.xUr);
      }
      if (this.sign != null) {
        paramVarArgs.e(5, this.sign);
      }
      if (this.kwH != null) {
        paramVarArgs.e(6, this.kwH);
      }
      paramVarArgs.aO(7, this.xUs);
      if (this.wYQ != null) {
        paramVarArgs.e(8, this.wYQ);
      }
      AppMethodBeat.o(56989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xUr == null) {
        break label446;
      }
    }
    label446:
    for (int i = e.a.a.b.b.a.f(4, this.xUr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.sign);
      }
      i = paramInt;
      if (this.kwH != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.kwH);
      }
      i += e.a.a.b.b.a.bl(7, this.xUs);
      paramInt = i;
      if (this.wYQ != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wYQ);
      }
      AppMethodBeat.o(56989);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56989);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ckm localckm = (ckm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56989);
          return -1;
        case 4: 
          localckm.xUr = locala.CLY.readString();
          AppMethodBeat.o(56989);
          return 0;
        case 5: 
          localckm.sign = locala.CLY.readString();
          AppMethodBeat.o(56989);
          return 0;
        case 6: 
          localckm.kwH = locala.CLY.readString();
          AppMethodBeat.o(56989);
          return 0;
        case 7: 
          localckm.xUs = locala.CLY.sl();
          AppMethodBeat.o(56989);
          return 0;
        }
        localckm.wYQ = locala.CLY.readString();
        AppMethodBeat.o(56989);
        return 0;
      }
      AppMethodBeat.o(56989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckm
 * JD-Core Version:    0.7.0.1
 */