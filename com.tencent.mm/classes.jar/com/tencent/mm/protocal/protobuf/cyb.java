package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyb
  extends com.tencent.mm.bw.a
{
  public String FDG;
  public String FHu;
  public int Height;
  public String MD5;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aR(2, this.Width);
      paramVarArgs.aR(3, this.Height);
      if (this.FDG != null) {
        paramVarArgs.d(4, this.FDG);
      }
      if (this.FHu != null) {
        paramVarArgs.d(5, this.FHu);
      }
      AppMethodBeat.o(32452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label433;
      }
    }
    label433:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Width) + f.a.a.b.b.a.bx(3, this.Height);
      paramInt = i;
      if (this.FDG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FDG);
      }
      i = paramInt;
      if (this.FHu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FHu);
      }
      AppMethodBeat.o(32452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32452);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cyb localcyb = (cyb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32452);
          return -1;
        case 1: 
          localcyb.MD5 = locala.LVo.readString();
          AppMethodBeat.o(32452);
          return 0;
        case 2: 
          localcyb.Width = locala.LVo.xF();
          AppMethodBeat.o(32452);
          return 0;
        case 3: 
          localcyb.Height = locala.LVo.xF();
          AppMethodBeat.o(32452);
          return 0;
        case 4: 
          localcyb.FDG = locala.LVo.readString();
          AppMethodBeat.o(32452);
          return 0;
        }
        localcyb.FHu = locala.LVo.readString();
        AppMethodBeat.o(32452);
        return 0;
      }
      AppMethodBeat.o(32452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyb
 * JD-Core Version:    0.7.0.1
 */