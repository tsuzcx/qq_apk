package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfx
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String title;
  public String wFW;
  public String wPJ;
  public int xuN;
  public int xuO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56863);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.wPJ != null) {
        paramVarArgs.e(3, this.wPJ);
      }
      paramVarArgs.aO(4, this.xuN);
      paramVarArgs.aO(5, this.xuO);
      if (this.wFW != null) {
        paramVarArgs.e(6, this.wFW);
      }
      AppMethodBeat.o(56863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label482;
      }
    }
    label482:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.wPJ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wPJ);
      }
      i = i + e.a.a.b.b.a.bl(4, this.xuN) + e.a.a.b.b.a.bl(5, this.xuO);
      paramInt = i;
      if (this.wFW != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wFW);
      }
      AppMethodBeat.o(56863);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56863);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bfx localbfx = (bfx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56863);
          return -1;
        case 1: 
          localbfx.title = locala.CLY.readString();
          AppMethodBeat.o(56863);
          return 0;
        case 2: 
          localbfx.desc = locala.CLY.readString();
          AppMethodBeat.o(56863);
          return 0;
        case 3: 
          localbfx.wPJ = locala.CLY.readString();
          AppMethodBeat.o(56863);
          return 0;
        case 4: 
          localbfx.xuN = locala.CLY.sl();
          AppMethodBeat.o(56863);
          return 0;
        case 5: 
          localbfx.xuO = locala.CLY.sl();
          AppMethodBeat.o(56863);
          return 0;
        }
        localbfx.wFW = locala.CLY.readString();
        AppMethodBeat.o(56863);
        return 0;
      }
      AppMethodBeat.o(56863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfx
 * JD-Core Version:    0.7.0.1
 */