package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bou
  extends com.tencent.mm.bw.a
{
  public LinkedList<bov> GLC;
  public LinkedList<dwx> GLD;
  public LinkedList<bov> Hcl;
  public int aHQ;
  public int count;
  public String dAa;
  public String duQ;
  public long duration;
  public long startTime;
  
  public bou()
  {
    AppMethodBeat.i(122512);
    this.duQ = "";
    this.startTime = 0L;
    this.duration = 0L;
    this.dAa = "";
    this.GLC = new LinkedList();
    this.count = 1;
    this.Hcl = new LinkedList();
    this.GLD = new LinkedList();
    AppMethodBeat.o(122512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duQ != null) {
        paramVarArgs.d(1, this.duQ);
      }
      paramVarArgs.aZ(2, this.startTime);
      paramVarArgs.aZ(3, this.duration);
      if (this.dAa != null) {
        paramVarArgs.d(4, this.dAa);
      }
      paramVarArgs.e(5, 8, this.GLC);
      paramVarArgs.aS(6, this.count);
      paramVarArgs.e(7, 8, this.Hcl);
      paramVarArgs.e(8, 8, this.GLD);
      paramVarArgs.aS(9, this.aHQ);
      AppMethodBeat.o(122513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duQ == null) {
        break label886;
      }
    }
    label886:
    for (paramInt = f.a.a.b.b.a.e(1, this.duQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.startTime) + f.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.dAa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dAa);
      }
      i = f.a.a.a.c(5, 8, this.GLC);
      int j = f.a.a.b.b.a.bz(6, this.count);
      int k = f.a.a.a.c(7, 8, this.Hcl);
      int m = f.a.a.a.c(8, 8, this.GLD);
      int n = f.a.a.b.b.a.bz(9, this.aHQ);
      AppMethodBeat.o(122513);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLC.clear();
        this.Hcl.clear();
        this.GLD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bou localbou = (bou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122513);
          return -1;
        case 1: 
          localbou.duQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 2: 
          localbou.startTime = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122513);
          return 0;
        case 3: 
          localbou.duration = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122513);
          return 0;
        case 4: 
          localbou.dAa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bov();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbou.GLC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 6: 
          localbou.count = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122513);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bov();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbou.Hcl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbou.GLD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        }
        localbou.aHQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122513);
        return 0;
      }
      AppMethodBeat.o(122513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bou
 * JD-Core Version:    0.7.0.1
 */