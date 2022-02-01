package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqi
  extends com.tencent.mm.bw.a
{
  public String Ffk;
  public String Ffl;
  public int Ffm;
  public int Ffn;
  public long Ffo;
  public long Ffp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ffk != null) {
        paramVarArgs.d(1, this.Ffk);
      }
      if (this.Ffl != null) {
        paramVarArgs.d(2, this.Ffl);
      }
      paramVarArgs.aR(3, this.Ffm);
      paramVarArgs.aR(4, this.Ffn);
      paramVarArgs.aO(5, this.Ffo);
      paramVarArgs.aO(6, this.Ffp);
      AppMethodBeat.o(190892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ffk == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ffk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ffl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ffl);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Ffm);
      int j = f.a.a.b.b.a.bx(4, this.Ffn);
      int k = f.a.a.b.b.a.p(5, this.Ffo);
      int m = f.a.a.b.b.a.p(6, this.Ffp);
      AppMethodBeat.o(190892);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(190892);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqi localbqi = (bqi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(190892);
          return -1;
        case 1: 
          localbqi.Ffk = locala.LVo.readString();
          AppMethodBeat.o(190892);
          return 0;
        case 2: 
          localbqi.Ffl = locala.LVo.readString();
          AppMethodBeat.o(190892);
          return 0;
        case 3: 
          localbqi.Ffm = locala.LVo.xF();
          AppMethodBeat.o(190892);
          return 0;
        case 4: 
          localbqi.Ffn = locala.LVo.xF();
          AppMethodBeat.o(190892);
          return 0;
        case 5: 
          localbqi.Ffo = locala.LVo.xG();
          AppMethodBeat.o(190892);
          return 0;
        }
        localbqi.Ffp = locala.LVo.xG();
        AppMethodBeat.o(190892);
        return 0;
      }
      AppMethodBeat.o(190892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqi
 * JD-Core Version:    0.7.0.1
 */