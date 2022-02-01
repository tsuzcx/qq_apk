package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bj
  extends com.tencent.mm.bw.a
{
  public dol FLG;
  public String FLH = "";
  public String FLI = "";
  public String FLJ = "";
  public long FLK = 0L;
  public int FLL = 0;
  public int flags = -1;
  public int state = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FLG != null)
      {
        paramVarArgs.lJ(1, this.FLG.computeSize());
        this.FLG.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.flags);
      paramVarArgs.aS(3, this.state);
      if (this.FLH != null) {
        paramVarArgs.d(4, this.FLH);
      }
      if (this.FLI != null) {
        paramVarArgs.d(5, this.FLI);
      }
      if (this.FLJ != null) {
        paramVarArgs.d(6, this.FLJ);
      }
      paramVarArgs.aZ(7, this.FLK);
      paramVarArgs.aS(8, this.FLL);
      AppMethodBeat.o(122482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FLG == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.a.lI(1, this.FLG.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.flags) + f.a.a.b.b.a.bz(3, this.state);
      paramInt = i;
      if (this.FLH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FLH);
      }
      i = paramInt;
      if (this.FLI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FLI);
      }
      paramInt = i;
      if (this.FLJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FLJ);
      }
      i = f.a.a.b.b.a.p(7, this.FLK);
      int j = f.a.a.b.b.a.bz(8, this.FLL);
      AppMethodBeat.o(122482);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122482);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bj localbj = (bj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122482);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dol();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dol)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbj.FLG = ((dol)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122482);
          return 0;
        case 2: 
          localbj.flags = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122482);
          return 0;
        case 3: 
          localbj.state = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122482);
          return 0;
        case 4: 
          localbj.FLH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 5: 
          localbj.FLI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 6: 
          localbj.FLJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 7: 
          localbj.FLK = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122482);
          return 0;
        }
        localbj.FLL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122482);
        return 0;
      }
      AppMethodBeat.o(122482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bj
 * JD-Core Version:    0.7.0.1
 */