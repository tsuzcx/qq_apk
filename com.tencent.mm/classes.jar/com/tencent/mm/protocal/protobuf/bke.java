package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bke
  extends com.tencent.mm.bv.a
{
  public int cyU = -1;
  public String czq = "";
  public long endTime = 0L;
  public long startTime = 0L;
  public String wXg = "";
  public String xkf = "";
  public boolean xyD = false;
  public long xyE = 0L;
  public String xyF;
  public boolean xyG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152448);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.czq != null) {
        paramVarArgs.e(1, this.czq);
      }
      paramVarArgs.aS(2, this.xyD);
      paramVarArgs.am(3, this.xyE);
      paramVarArgs.am(4, this.startTime);
      paramVarArgs.am(5, this.endTime);
      paramVarArgs.aO(6, this.cyU);
      if (this.xkf != null) {
        paramVarArgs.e(7, this.xkf);
      }
      if (this.wXg != null) {
        paramVarArgs.e(8, this.wXg);
      }
      if (this.xyF != null) {
        paramVarArgs.e(9, this.xyF);
      }
      paramVarArgs.aS(10, this.xyG);
      AppMethodBeat.o(152448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.czq == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = e.a.a.b.b.a.f(1, this.czq) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 1) + e.a.a.b.b.a.p(3, this.xyE) + e.a.a.b.b.a.p(4, this.startTime) + e.a.a.b.b.a.p(5, this.endTime) + e.a.a.b.b.a.bl(6, this.cyU);
      paramInt = i;
      if (this.xkf != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xkf);
      }
      i = paramInt;
      if (this.wXg != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wXg);
      }
      paramInt = i;
      if (this.xyF != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xyF);
      }
      i = e.a.a.b.b.a.eW(10);
      AppMethodBeat.o(152448);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152448);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bke localbke = (bke)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152448);
          return -1;
        case 1: 
          localbke.czq = locala.CLY.readString();
          AppMethodBeat.o(152448);
          return 0;
        case 2: 
          localbke.xyD = locala.CLY.emu();
          AppMethodBeat.o(152448);
          return 0;
        case 3: 
          localbke.xyE = locala.CLY.sm();
          AppMethodBeat.o(152448);
          return 0;
        case 4: 
          localbke.startTime = locala.CLY.sm();
          AppMethodBeat.o(152448);
          return 0;
        case 5: 
          localbke.endTime = locala.CLY.sm();
          AppMethodBeat.o(152448);
          return 0;
        case 6: 
          localbke.cyU = locala.CLY.sl();
          AppMethodBeat.o(152448);
          return 0;
        case 7: 
          localbke.xkf = locala.CLY.readString();
          AppMethodBeat.o(152448);
          return 0;
        case 8: 
          localbke.wXg = locala.CLY.readString();
          AppMethodBeat.o(152448);
          return 0;
        case 9: 
          localbke.xyF = locala.CLY.readString();
          AppMethodBeat.o(152448);
          return 0;
        }
        localbke.xyG = locala.CLY.emu();
        AppMethodBeat.o(152448);
        return 0;
      }
      AppMethodBeat.o(152448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bke
 * JD-Core Version:    0.7.0.1
 */