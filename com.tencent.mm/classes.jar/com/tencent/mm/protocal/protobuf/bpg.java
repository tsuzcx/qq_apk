package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public class bpg
  extends com.tencent.mm.bx.a
{
  public String ZXR;
  public b ZXS;
  public String appName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258114);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appName != null) {
        paramVarArgs.g(1, this.appName);
      }
      if (this.ZXR != null) {
        paramVarArgs.g(2, this.ZXR);
      }
      if (this.ZXS != null) {
        paramVarArgs.d(3, this.ZXS);
      }
      AppMethodBeat.o(258114);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appName == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.appName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZXR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZXR);
      }
      i = paramInt;
      if (this.ZXS != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZXS);
      }
      AppMethodBeat.o(258114);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258114);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bpg localbpg = (bpg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258114);
          return -1;
        case 1: 
          localbpg.appName = locala.ajGk.readString();
          AppMethodBeat.o(258114);
          return 0;
        case 2: 
          localbpg.ZXR = locala.ajGk.readString();
          AppMethodBeat.o(258114);
          return 0;
        }
        localbpg.ZXS = locala.ajGk.kFX();
        AppMethodBeat.o(258114);
        return 0;
      }
      AppMethodBeat.o(258114);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpg
 * JD-Core Version:    0.7.0.1
 */