package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbu
  extends com.tencent.mm.bw.a
{
  public String MOt;
  public String NxU;
  public String dQx;
  public String pinyin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152729);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MOt != null) {
        paramVarArgs.e(1, this.MOt);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.pinyin != null) {
        paramVarArgs.e(3, this.pinyin);
      }
      if (this.NxU != null) {
        paramVarArgs.e(4, this.NxU);
      }
      AppMethodBeat.o(152729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MOt == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.MOt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.pinyin != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.pinyin);
      }
      paramInt = i;
      if (this.NxU != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NxU);
      }
      AppMethodBeat.o(152729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152729);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbu localfbu = (fbu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152729);
          return -1;
        case 1: 
          localfbu.MOt = locala.UbS.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 2: 
          localfbu.dQx = locala.UbS.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 3: 
          localfbu.pinyin = locala.UbS.readString();
          AppMethodBeat.o(152729);
          return 0;
        }
        localfbu.NxU = locala.UbS.readString();
        AppMethodBeat.o(152729);
        return 0;
      }
      AppMethodBeat.o(152729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbu
 * JD-Core Version:    0.7.0.1
 */