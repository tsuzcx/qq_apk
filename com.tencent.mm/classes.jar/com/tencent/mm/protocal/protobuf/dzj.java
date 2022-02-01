package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzj
  extends com.tencent.mm.bw.a
{
  public String GfC;
  public String GfD;
  public String dlQ;
  public String pinyin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GfC != null) {
        paramVarArgs.d(1, this.GfC);
      }
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.pinyin != null) {
        paramVarArgs.d(3, this.pinyin);
      }
      if (this.GfD != null) {
        paramVarArgs.d(4, this.GfD);
      }
      AppMethodBeat.o(152729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GfC == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.GfC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.pinyin != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pinyin);
      }
      paramInt = i;
      if (this.GfD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GfD);
      }
      AppMethodBeat.o(152729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152729);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzj localdzj = (dzj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152729);
          return -1;
        case 1: 
          localdzj.GfC = locala.LVo.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 2: 
          localdzj.dlQ = locala.LVo.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 3: 
          localdzj.pinyin = locala.LVo.readString();
          AppMethodBeat.o(152729);
          return 0;
        }
        localdzj.GfD = locala.LVo.readString();
        AppMethodBeat.o(152729);
        return 0;
      }
      AppMethodBeat.o(152729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzj
 * JD-Core Version:    0.7.0.1
 */