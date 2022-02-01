package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arw
  extends com.tencent.mm.bw.a
{
  public String GGA;
  public float dBu;
  public float dzE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164044);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GGA != null) {
        paramVarArgs.d(1, this.GGA);
      }
      paramVarArgs.y(2, this.dBu);
      paramVarArgs.y(3, this.dzE);
      AppMethodBeat.o(164044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GGA == null) {
        break label304;
      }
    }
    label304:
    for (paramInt = f.a.a.b.b.a.e(1, this.GGA) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amE(2);
      int j = f.a.a.b.b.a.amE(3);
      AppMethodBeat.o(164044);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(164044);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        arw localarw = (arw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(164044);
          return -1;
        case 1: 
          localarw.GGA = locala.OmT.readString();
          AppMethodBeat.o(164044);
          return 0;
        case 2: 
          localarw.dBu = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(164044);
          return 0;
        }
        localarw.dzE = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(164044);
        return 0;
      }
      AppMethodBeat.o(164044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arw
 * JD-Core Version:    0.7.0.1
 */