package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cia
  extends com.tencent.mm.bw.a
{
  public boolean Hug = false;
  public String Huh;
  public boolean Hui;
  public int aHQ = 0;
  public String dAa = "";
  public String duQ = "";
  public int dzC = -1;
  public long endTime = 0L;
  public String sCx = "";
  public long seq = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122521);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dAa != null) {
        paramVarArgs.d(1, this.dAa);
      }
      paramVarArgs.bC(2, this.Hug);
      paramVarArgs.aZ(3, this.seq);
      paramVarArgs.aZ(4, this.startTime);
      paramVarArgs.aZ(5, this.endTime);
      paramVarArgs.aS(6, this.dzC);
      if (this.duQ != null) {
        paramVarArgs.d(7, this.duQ);
      }
      paramVarArgs.aS(8, this.aHQ);
      if (this.Huh != null) {
        paramVarArgs.d(9, this.Huh);
      }
      paramVarArgs.bC(10, this.Hui);
      if (this.sCx != null) {
        paramVarArgs.d(11, this.sCx);
      }
      AppMethodBeat.o(122521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dAa == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = f.a.a.b.b.a.e(1, this.dAa) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2) + f.a.a.b.b.a.p(3, this.seq) + f.a.a.b.b.a.p(4, this.startTime) + f.a.a.b.b.a.p(5, this.endTime) + f.a.a.b.b.a.bz(6, this.dzC);
      paramInt = i;
      if (this.duQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.duQ);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.aHQ);
      paramInt = i;
      if (this.Huh != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Huh);
      }
      i = paramInt + f.a.a.b.b.a.amF(10);
      paramInt = i;
      if (this.sCx != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.sCx);
      }
      AppMethodBeat.o(122521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122521);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cia localcia = (cia)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122521);
          return -1;
        case 1: 
          localcia.dAa = locala.OmT.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 2: 
          localcia.Hug = locala.OmT.gvY();
          AppMethodBeat.o(122521);
          return 0;
        case 3: 
          localcia.seq = locala.OmT.zd();
          AppMethodBeat.o(122521);
          return 0;
        case 4: 
          localcia.startTime = locala.OmT.zd();
          AppMethodBeat.o(122521);
          return 0;
        case 5: 
          localcia.endTime = locala.OmT.zd();
          AppMethodBeat.o(122521);
          return 0;
        case 6: 
          localcia.dzC = locala.OmT.zc();
          AppMethodBeat.o(122521);
          return 0;
        case 7: 
          localcia.duQ = locala.OmT.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 8: 
          localcia.aHQ = locala.OmT.zc();
          AppMethodBeat.o(122521);
          return 0;
        case 9: 
          localcia.Huh = locala.OmT.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 10: 
          localcia.Hui = locala.OmT.gvY();
          AppMethodBeat.o(122521);
          return 0;
        }
        localcia.sCx = locala.OmT.readString();
        AppMethodBeat.o(122521);
        return 0;
      }
      AppMethodBeat.o(122521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cia
 * JD-Core Version:    0.7.0.1
 */