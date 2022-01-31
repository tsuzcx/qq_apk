package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ph
  extends com.tencent.mm.bv.a
{
  public String code;
  public String cwc;
  public String kml;
  public String wGM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89044);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kml != null) {
        paramVarArgs.e(1, this.kml);
      }
      if (this.code != null) {
        paramVarArgs.e(2, this.code);
      }
      if (this.wGM != null) {
        paramVarArgs.e(3, this.wGM);
      }
      if (this.cwc != null) {
        paramVarArgs.e(4, this.cwc);
      }
      AppMethodBeat.o(89044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kml == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.kml) + 0;; i = 0)
    {
      paramInt = i;
      if (this.code != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.code);
      }
      i = paramInt;
      if (this.wGM != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wGM);
      }
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.cwc);
      }
      AppMethodBeat.o(89044);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89044);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ph localph = (ph)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89044);
          return -1;
        case 1: 
          localph.kml = locala.CLY.readString();
          AppMethodBeat.o(89044);
          return 0;
        case 2: 
          localph.code = locala.CLY.readString();
          AppMethodBeat.o(89044);
          return 0;
        case 3: 
          localph.wGM = locala.CLY.readString();
          AppMethodBeat.o(89044);
          return 0;
        }
        localph.cwc = locala.CLY.readString();
        AppMethodBeat.o(89044);
        return 0;
      }
      AppMethodBeat.o(89044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ph
 * JD-Core Version:    0.7.0.1
 */