package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyw
  extends com.tencent.mm.bw.a
{
  public String Gfh;
  public boolean Gfi;
  public int Gfj;
  public int Gfk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110856);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gfh != null) {
        paramVarArgs.d(1, this.Gfh);
      }
      paramVarArgs.bl(2, this.Gfi);
      paramVarArgs.aR(3, this.Gfj);
      paramVarArgs.aR(4, this.Gfk);
      AppMethodBeat.o(110856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gfh == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gfh) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.bx(3, this.Gfj);
      int k = f.a.a.b.b.a.bx(4, this.Gfk);
      AppMethodBeat.o(110856);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(110856);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dyw localdyw = (dyw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110856);
          return -1;
        case 1: 
          localdyw.Gfh = locala.LVo.readString();
          AppMethodBeat.o(110856);
          return 0;
        case 2: 
          localdyw.Gfi = locala.LVo.fZX();
          AppMethodBeat.o(110856);
          return 0;
        case 3: 
          localdyw.Gfj = locala.LVo.xF();
          AppMethodBeat.o(110856);
          return 0;
        }
        localdyw.Gfk = locala.LVo.xF();
        AppMethodBeat.o(110856);
        return 0;
      }
      AppMethodBeat.o(110856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyw
 * JD-Core Version:    0.7.0.1
 */