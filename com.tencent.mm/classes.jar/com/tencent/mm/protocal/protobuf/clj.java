package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clj
  extends com.tencent.mm.bw.a
{
  public int COB;
  public String COC;
  public String COw;
  public String COx;
  public dpp HxC;
  public ccc HxD;
  public bzy HxE;
  public long dPq;
  public String dlT;
  public int fMJ;
  public int state;
  public String uVs;
  public String wSp;
  public String yhW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.fMJ);
      paramVarArgs.aZ(2, this.dPq);
      if (this.dlT != null) {
        paramVarArgs.d(3, this.dlT);
      }
      if (this.wSp != null) {
        paramVarArgs.d(4, this.wSp);
      }
      if (this.COw != null) {
        paramVarArgs.d(5, this.COw);
      }
      if (this.COx != null) {
        paramVarArgs.d(6, this.COx);
      }
      if (this.HxC != null)
      {
        paramVarArgs.lJ(7, this.HxC.computeSize());
        this.HxC.writeFields(paramVarArgs);
      }
      if (this.HxD != null)
      {
        paramVarArgs.lJ(8, this.HxD.computeSize());
        this.HxD.writeFields(paramVarArgs);
      }
      if (this.HxE != null)
      {
        paramVarArgs.lJ(9, this.HxE.computeSize());
        this.HxE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.COB);
      paramVarArgs.aS(11, this.state);
      if (this.uVs != null) {
        paramVarArgs.d(12, this.uVs);
      }
      if (this.yhW != null) {
        paramVarArgs.d(13, this.yhW);
      }
      if (this.COC != null) {
        paramVarArgs.d(14, this.COC);
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.fMJ) + 0 + f.a.a.b.b.a.p(2, this.dPq);
      paramInt = i;
      if (this.dlT != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dlT);
      }
      i = paramInt;
      if (this.wSp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.wSp);
      }
      paramInt = i;
      if (this.COw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.COw);
      }
      i = paramInt;
      if (this.COx != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.COx);
      }
      paramInt = i;
      if (this.HxC != null) {
        paramInt = i + f.a.a.a.lI(7, this.HxC.computeSize());
      }
      i = paramInt;
      if (this.HxD != null) {
        i = paramInt + f.a.a.a.lI(8, this.HxD.computeSize());
      }
      paramInt = i;
      if (this.HxE != null) {
        paramInt = i + f.a.a.a.lI(9, this.HxE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.COB) + f.a.a.b.b.a.bz(11, this.state);
      paramInt = i;
      if (this.uVs != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uVs);
      }
      i = paramInt;
      if (this.yhW != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.yhW);
      }
      paramInt = i;
      if (this.COC != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.COC);
      }
      AppMethodBeat.o(91618);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      clj localclj = (clj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91618);
        return -1;
      case 1: 
        localclj.fMJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91618);
        return 0;
      case 2: 
        localclj.dPq = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91618);
        return 0;
      case 3: 
        localclj.dlT = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 4: 
        localclj.wSp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 5: 
        localclj.COw = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 6: 
        localclj.COx = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclj.HxC = ((dpp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclj.HxD = ((ccc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bzy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclj.HxE = ((bzy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 10: 
        localclj.COB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91618);
        return 0;
      case 11: 
        localclj.state = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91618);
        return 0;
      case 12: 
        localclj.uVs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 13: 
        localclj.yhW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91618);
        return 0;
      }
      localclj.COC = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(91618);
      return 0;
    }
    AppMethodBeat.o(91618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clj
 * JD-Core Version:    0.7.0.1
 */