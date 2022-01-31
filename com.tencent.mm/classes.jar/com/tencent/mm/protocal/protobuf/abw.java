package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abw
  extends com.tencent.mm.bv.a
{
  public String SmallImgUrl;
  public String jJA;
  public int jJS;
  public String jKG;
  public String wSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28406);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.wSo != null) {
        paramVarArgs.e(2, this.wSo);
      }
      if (this.jKG != null) {
        paramVarArgs.e(3, this.jKG);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.e(4, this.SmallImgUrl);
      }
      paramVarArgs.aO(5, this.jJS);
      AppMethodBeat.o(28406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label449;
      }
    }
    label449:
    for (int i = e.a.a.b.b.a.f(1, this.jJA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wSo != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wSo);
      }
      i = paramInt;
      if (this.jKG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jKG);
      }
      paramInt = i;
      if (this.SmallImgUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.SmallImgUrl);
      }
      i = e.a.a.b.b.a.bl(5, this.jJS);
      AppMethodBeat.o(28406);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28406);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        abw localabw = (abw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28406);
          return -1;
        case 1: 
          localabw.jJA = locala.CLY.readString();
          AppMethodBeat.o(28406);
          return 0;
        case 2: 
          localabw.wSo = locala.CLY.readString();
          AppMethodBeat.o(28406);
          return 0;
        case 3: 
          localabw.jKG = locala.CLY.readString();
          AppMethodBeat.o(28406);
          return 0;
        case 4: 
          localabw.SmallImgUrl = locala.CLY.readString();
          AppMethodBeat.o(28406);
          return 0;
        }
        localabw.jJS = locala.CLY.sl();
        AppMethodBeat.o(28406);
        return 0;
      }
      AppMethodBeat.o(28406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abw
 * JD-Core Version:    0.7.0.1
 */