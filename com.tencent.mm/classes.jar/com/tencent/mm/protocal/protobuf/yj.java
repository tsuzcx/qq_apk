package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yj
  extends com.tencent.mm.bw.a
{
  public int DSk;
  public String DSl;
  public int ErY;
  public int ErZ;
  public int count;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DSl != null) {
        paramVarArgs.d(1, this.DSl);
      }
      paramVarArgs.aR(2, this.DSk);
      paramVarArgs.aR(3, this.ErY);
      paramVarArgs.aR(4, this.ErZ);
      paramVarArgs.aR(5, this.scene);
      paramVarArgs.aR(6, this.count);
      AppMethodBeat.o(103205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DSl == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = f.a.a.b.b.a.e(1, this.DSl) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.DSk);
      int j = f.a.a.b.b.a.bx(3, this.ErY);
      int k = f.a.a.b.b.a.bx(4, this.ErZ);
      int m = f.a.a.b.b.a.bx(5, this.scene);
      int n = f.a.a.b.b.a.bx(6, this.count);
      AppMethodBeat.o(103205);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103205);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        yj localyj = (yj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103205);
          return -1;
        case 1: 
          localyj.DSl = locala.LVo.readString();
          AppMethodBeat.o(103205);
          return 0;
        case 2: 
          localyj.DSk = locala.LVo.xF();
          AppMethodBeat.o(103205);
          return 0;
        case 3: 
          localyj.ErY = locala.LVo.xF();
          AppMethodBeat.o(103205);
          return 0;
        case 4: 
          localyj.ErZ = locala.LVo.xF();
          AppMethodBeat.o(103205);
          return 0;
        case 5: 
          localyj.scene = locala.LVo.xF();
          AppMethodBeat.o(103205);
          return 0;
        }
        localyj.count = locala.LVo.xF();
        AppMethodBeat.o(103205);
        return 0;
      }
      AppMethodBeat.o(103205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yj
 * JD-Core Version:    0.7.0.1
 */