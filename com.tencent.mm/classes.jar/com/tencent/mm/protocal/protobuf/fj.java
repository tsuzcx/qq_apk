package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fj
  extends com.tencent.mm.bw.a
{
  public long DSs;
  public int DSt;
  public String DSu;
  public int DSv;
  public int Scene;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6390);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      paramVarArgs.aO(2, this.DSs);
      paramVarArgs.aR(3, this.DSt);
      if (this.DSu != null) {
        paramVarArgs.d(4, this.DSu);
      }
      paramVarArgs.aR(5, this.Scene);
      paramVarArgs.aR(6, this.DSv);
      AppMethodBeat.o(6390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.DSs) + f.a.a.b.b.a.bx(3, this.DSt);
      paramInt = i;
      if (this.DSu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DSu);
      }
      i = f.a.a.b.b.a.bx(5, this.Scene);
      int j = f.a.a.b.b.a.bx(6, this.DSv);
      AppMethodBeat.o(6390);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(6390);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fj localfj = (fj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6390);
          return -1;
        case 1: 
          localfj.Url = locala.LVo.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 2: 
          localfj.DSs = locala.LVo.xG();
          AppMethodBeat.o(6390);
          return 0;
        case 3: 
          localfj.DSt = locala.LVo.xF();
          AppMethodBeat.o(6390);
          return 0;
        case 4: 
          localfj.DSu = locala.LVo.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 5: 
          localfj.Scene = locala.LVo.xF();
          AppMethodBeat.o(6390);
          return 0;
        }
        localfj.DSv = locala.LVo.xF();
        AppMethodBeat.o(6390);
        return 0;
      }
      AppMethodBeat.o(6390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fj
 * JD-Core Version:    0.7.0.1
 */