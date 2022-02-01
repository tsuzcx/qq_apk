package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgc
  extends com.tencent.mm.bx.a
{
  public String DDP;
  public LinkedList<bgd> DDQ;
  public LinkedList<bgd> Dod;
  public int count;
  public String dpw;
  public long duration;
  public long startTime;
  
  public bgc()
  {
    AppMethodBeat.i(122512);
    this.DDP = "";
    this.startTime = 0L;
    this.duration = 0L;
    this.dpw = "";
    this.Dod = new LinkedList();
    this.count = 1;
    this.DDQ = new LinkedList();
    AppMethodBeat.o(122512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DDP != null) {
        paramVarArgs.d(1, this.DDP);
      }
      paramVarArgs.aG(2, this.startTime);
      paramVarArgs.aG(3, this.duration);
      if (this.dpw != null) {
        paramVarArgs.d(4, this.dpw);
      }
      paramVarArgs.e(5, 8, this.Dod);
      paramVarArgs.aR(6, this.count);
      paramVarArgs.e(7, 8, this.DDQ);
      AppMethodBeat.o(122513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DDP == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.b.b.a.e(1, this.DDP) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.startTime) + f.a.a.b.b.a.q(3, this.duration);
      paramInt = i;
      if (this.dpw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dpw);
      }
      i = f.a.a.a.c(5, 8, this.Dod);
      int j = f.a.a.b.b.a.bA(6, this.count);
      int k = f.a.a.a.c(7, 8, this.DDQ);
      AppMethodBeat.o(122513);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dod.clear();
        this.DDQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgc localbgc = (bgc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122513);
          return -1;
        case 1: 
          localbgc.DDP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 2: 
          localbgc.startTime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122513);
          return 0;
        case 3: 
          localbgc.duration = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122513);
          return 0;
        case 4: 
          localbgc.dpw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgc.Dod.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 6: 
          localbgc.count = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122513);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgc.DDQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122513);
        return 0;
      }
      AppMethodBeat.o(122513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgc
 * JD-Core Version:    0.7.0.1
 */