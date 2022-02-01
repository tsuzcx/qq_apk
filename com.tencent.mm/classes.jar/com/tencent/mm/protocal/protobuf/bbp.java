package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbp
  extends com.tencent.mm.bx.a
{
  public String EVK;
  public int ZMg;
  public int ZMh;
  public float ZMi;
  public int bitrate;
  public String hVy;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259675);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hVy != null) {
        paramVarArgs.g(1, this.hVy);
      }
      paramVarArgs.bS(2, this.ZMg);
      paramVarArgs.bS(3, this.bitrate);
      if (this.EVK != null) {
        paramVarArgs.g(4, this.EVK);
      }
      paramVarArgs.bS(5, this.ZMh);
      paramVarArgs.l(6, this.ZMi);
      paramVarArgs.bS(7, this.width);
      paramVarArgs.bS(8, this.height);
      AppMethodBeat.o(259675);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZMg) + i.a.a.b.b.a.cJ(3, this.bitrate);
      paramInt = i;
      if (this.EVK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.EVK);
      }
      i = i.a.a.b.b.a.cJ(5, this.ZMh);
      int j = i.a.a.b.b.a.ko(6);
      int k = i.a.a.b.b.a.cJ(7, this.width);
      int m = i.a.a.b.b.a.cJ(8, this.height);
      AppMethodBeat.o(259675);
      return paramInt + i + (j + 4) + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259675);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bbp localbbp = (bbp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259675);
          return -1;
        case 1: 
          localbbp.hVy = locala.ajGk.readString();
          AppMethodBeat.o(259675);
          return 0;
        case 2: 
          localbbp.ZMg = locala.ajGk.aar();
          AppMethodBeat.o(259675);
          return 0;
        case 3: 
          localbbp.bitrate = locala.ajGk.aar();
          AppMethodBeat.o(259675);
          return 0;
        case 4: 
          localbbp.EVK = locala.ajGk.readString();
          AppMethodBeat.o(259675);
          return 0;
        case 5: 
          localbbp.ZMh = locala.ajGk.aar();
          AppMethodBeat.o(259675);
          return 0;
        case 6: 
          localbbp.ZMi = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(259675);
          return 0;
        case 7: 
          localbbp.width = locala.ajGk.aar();
          AppMethodBeat.o(259675);
          return 0;
        }
        localbbp.height = locala.ajGk.aar();
        AppMethodBeat.o(259675);
        return 0;
      }
      AppMethodBeat.o(259675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbp
 * JD-Core Version:    0.7.0.1
 */