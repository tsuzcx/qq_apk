package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ehv
  extends com.tencent.mm.bw.a
{
  public int GcL;
  public int Gdl;
  public long Ilq;
  public boolean Ilr;
  public String Ils;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123692);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aS(2, this.GcL);
      paramVarArgs.aS(3, this.Gdl);
      paramVarArgs.aZ(4, this.Ilq);
      paramVarArgs.bC(5, this.Ilr);
      if (this.Ils != null) {
        paramVarArgs.d(6, this.Ils);
      }
      AppMethodBeat.o(123692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label442;
      }
    }
    label442:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GcL) + f.a.a.b.b.a.bz(3, this.Gdl) + f.a.a.b.b.a.p(4, this.Ilq) + f.a.a.b.b.a.amF(5);
      paramInt = i;
      if (this.Ils != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ils);
      }
      AppMethodBeat.o(123692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123692);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehv localehv = (ehv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123692);
          return -1;
        case 1: 
          localehv.username = locala.OmT.readString();
          AppMethodBeat.o(123692);
          return 0;
        case 2: 
          localehv.GcL = locala.OmT.zc();
          AppMethodBeat.o(123692);
          return 0;
        case 3: 
          localehv.Gdl = locala.OmT.zc();
          AppMethodBeat.o(123692);
          return 0;
        case 4: 
          localehv.Ilq = locala.OmT.zd();
          AppMethodBeat.o(123692);
          return 0;
        case 5: 
          localehv.Ilr = locala.OmT.gvY();
          AppMethodBeat.o(123692);
          return 0;
        }
        localehv.Ils = locala.OmT.readString();
        AppMethodBeat.o(123692);
        return 0;
      }
      AppMethodBeat.o(123692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehv
 * JD-Core Version:    0.7.0.1
 */