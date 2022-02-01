package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccp
  extends com.tencent.mm.bw.a
{
  public String GUc;
  public int GsP;
  public int Hpj;
  public String Hpk;
  public String Hpl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GUc != null) {
        paramVarArgs.d(1, this.GUc);
      }
      paramVarArgs.aS(2, this.Hpj);
      if (this.Hpk != null) {
        paramVarArgs.d(3, this.Hpk);
      }
      paramVarArgs.aS(4, this.GsP);
      if (this.Hpl != null) {
        paramVarArgs.d(5, this.Hpl);
      }
      AppMethodBeat.o(115847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GUc == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.GUc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hpj);
      paramInt = i;
      if (this.Hpk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Hpk);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GsP);
      paramInt = i;
      if (this.Hpl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hpl);
      }
      AppMethodBeat.o(115847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccp localccp = (ccp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115847);
          return -1;
        case 1: 
          localccp.GUc = locala.OmT.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 2: 
          localccp.Hpj = locala.OmT.zc();
          AppMethodBeat.o(115847);
          return 0;
        case 3: 
          localccp.Hpk = locala.OmT.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 4: 
          localccp.GsP = locala.OmT.zc();
          AppMethodBeat.o(115847);
          return 0;
        }
        localccp.Hpl = locala.OmT.readString();
        AppMethodBeat.o(115847);
        return 0;
      }
      AppMethodBeat.o(115847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccp
 * JD-Core Version:    0.7.0.1
 */