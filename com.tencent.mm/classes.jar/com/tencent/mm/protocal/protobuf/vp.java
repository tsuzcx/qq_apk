package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vp
  extends com.tencent.mm.bw.a
{
  public int EpS;
  public String dlQ;
  public String title;
  public String vxw;
  public String wNd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.vxw != null) {
        paramVarArgs.d(3, this.vxw);
      }
      if (this.wNd != null) {
        paramVarArgs.d(4, this.wNd);
      }
      paramVarArgs.aR(5, this.EpS);
      AppMethodBeat.o(72459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.vxw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vxw);
      }
      paramInt = i;
      if (this.wNd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wNd);
      }
      i = f.a.a.b.b.a.bx(5, this.EpS);
      AppMethodBeat.o(72459);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72459);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        vp localvp = (vp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72459);
          return -1;
        case 1: 
          localvp.title = locala.LVo.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 2: 
          localvp.dlQ = locala.LVo.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 3: 
          localvp.vxw = locala.LVo.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 4: 
          localvp.wNd = locala.LVo.readString();
          AppMethodBeat.o(72459);
          return 0;
        }
        localvp.EpS = locala.LVo.xF();
        AppMethodBeat.o(72459);
        return 0;
      }
      AppMethodBeat.o(72459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vp
 * JD-Core Version:    0.7.0.1
 */