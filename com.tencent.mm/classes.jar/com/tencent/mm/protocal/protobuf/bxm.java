package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public class bxm
  extends com.tencent.mm.bx.a
{
  public b JaK;
  public int YDl;
  public String aagn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258280);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aagn != null) {
        paramVarArgs.g(1, this.aagn);
      }
      paramVarArgs.bS(2, this.YDl);
      if (this.JaK != null) {
        paramVarArgs.d(3, this.JaK);
      }
      AppMethodBeat.o(258280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aagn == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.aagn) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YDl);
      paramInt = i;
      if (this.JaK != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.JaK);
      }
      AppMethodBeat.o(258280);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258280);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bxm localbxm = (bxm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258280);
          return -1;
        case 1: 
          localbxm.aagn = locala.ajGk.readString();
          AppMethodBeat.o(258280);
          return 0;
        case 2: 
          localbxm.YDl = locala.ajGk.aar();
          AppMethodBeat.o(258280);
          return 0;
        }
        localbxm.JaK = locala.ajGk.kFX();
        AppMethodBeat.o(258280);
        return 0;
      }
      AppMethodBeat.o(258280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxm
 * JD-Core Version:    0.7.0.1
 */