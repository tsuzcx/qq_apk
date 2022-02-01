package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boz
  extends com.tencent.mm.bx.a
{
  public String EVK;
  public int ZMg;
  public int ZMh;
  public float ZMi;
  public int ZPI;
  public String hVy;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184203);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hVy != null) {
        paramVarArgs.g(1, this.hVy);
      }
      paramVarArgs.bS(2, this.ZMg);
      paramVarArgs.bS(3, this.ZPI);
      if (this.EVK != null) {
        paramVarArgs.g(4, this.EVK);
      }
      paramVarArgs.bS(5, this.ZMh);
      paramVarArgs.l(6, this.ZMi);
      paramVarArgs.bS(7, this.width);
      paramVarArgs.bS(8, this.height);
      AppMethodBeat.o(184203);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hVy == null) {
        break label545;
      }
    }
    label545:
    for (paramInt = i.a.a.b.b.a.h(1, this.hVy) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZMg) + i.a.a.b.b.a.cJ(3, this.ZPI);
      paramInt = i;
      if (this.EVK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.EVK);
      }
      i = i.a.a.b.b.a.cJ(5, this.ZMh);
      int j = i.a.a.b.b.a.ko(6);
      int k = i.a.a.b.b.a.cJ(7, this.width);
      int m = i.a.a.b.b.a.cJ(8, this.height);
      AppMethodBeat.o(184203);
      return paramInt + i + (j + 4) + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(184203);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        boz localboz = (boz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184203);
          return -1;
        case 1: 
          localboz.hVy = locala.ajGk.readString();
          AppMethodBeat.o(184203);
          return 0;
        case 2: 
          localboz.ZMg = locala.ajGk.aar();
          AppMethodBeat.o(184203);
          return 0;
        case 3: 
          localboz.ZPI = locala.ajGk.aar();
          AppMethodBeat.o(184203);
          return 0;
        case 4: 
          localboz.EVK = locala.ajGk.readString();
          AppMethodBeat.o(184203);
          return 0;
        case 5: 
          localboz.ZMh = locala.ajGk.aar();
          AppMethodBeat.o(184203);
          return 0;
        case 6: 
          localboz.ZMi = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(184203);
          return 0;
        case 7: 
          localboz.width = locala.ajGk.aar();
          AppMethodBeat.o(184203);
          return 0;
        }
        localboz.height = locala.ajGk.aar();
        AppMethodBeat.o(184203);
        return 0;
      }
      AppMethodBeat.o(184203);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boz
 * JD-Core Version:    0.7.0.1
 */