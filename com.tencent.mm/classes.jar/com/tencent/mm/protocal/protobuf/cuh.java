package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cuh
  extends com.tencent.mm.bw.a
{
  public String FZa;
  public long HFh;
  public int HFi;
  public boolean HFj;
  public boolean HFk;
  public int HFl;
  public boolean HFm;
  public int uvb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZa != null) {
        paramVarArgs.d(1, this.FZa);
      }
      paramVarArgs.aZ(2, this.HFh);
      paramVarArgs.aS(3, this.HFi);
      paramVarArgs.bC(4, this.HFj);
      paramVarArgs.bC(5, this.HFk);
      paramVarArgs.aS(6, this.HFl);
      paramVarArgs.aS(7, this.uvb);
      paramVarArgs.bC(8, this.HFm);
      AppMethodBeat.o(124546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZa == null) {
        break label530;
      }
    }
    label530:
    for (paramInt = f.a.a.b.b.a.e(1, this.FZa) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HFh);
      int j = f.a.a.b.b.a.bz(3, this.HFi);
      int k = f.a.a.b.b.a.amF(4);
      int m = f.a.a.b.b.a.amF(5);
      int n = f.a.a.b.b.a.bz(6, this.HFl);
      int i1 = f.a.a.b.b.a.bz(7, this.uvb);
      int i2 = f.a.a.b.b.a.amF(8);
      AppMethodBeat.o(124546);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124546);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cuh localcuh = (cuh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124546);
          return -1;
        case 1: 
          localcuh.FZa = locala.OmT.readString();
          AppMethodBeat.o(124546);
          return 0;
        case 2: 
          localcuh.HFh = locala.OmT.zd();
          AppMethodBeat.o(124546);
          return 0;
        case 3: 
          localcuh.HFi = locala.OmT.zc();
          AppMethodBeat.o(124546);
          return 0;
        case 4: 
          localcuh.HFj = locala.OmT.gvY();
          AppMethodBeat.o(124546);
          return 0;
        case 5: 
          localcuh.HFk = locala.OmT.gvY();
          AppMethodBeat.o(124546);
          return 0;
        case 6: 
          localcuh.HFl = locala.OmT.zc();
          AppMethodBeat.o(124546);
          return 0;
        case 7: 
          localcuh.uvb = locala.OmT.zc();
          AppMethodBeat.o(124546);
          return 0;
        }
        localcuh.HFm = locala.OmT.gvY();
        AppMethodBeat.o(124546);
        return 0;
      }
      AppMethodBeat.o(124546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuh
 * JD-Core Version:    0.7.0.1
 */