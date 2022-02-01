package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aik
  extends com.tencent.mm.bx.a
{
  public int Dlc;
  public int continueFlag;
  public String dnB;
  public int offset;
  public b qHz;
  public LinkedList<aky> qMq;
  public LinkedList<FinderObject> qbe;
  public String query;
  
  public aik()
  {
    AppMethodBeat.i(168958);
    this.qbe = new LinkedList();
    this.qMq = new LinkedList();
    AppMethodBeat.o(168958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.query != null) {
        paramVarArgs.d(1, this.query);
      }
      paramVarArgs.aR(2, this.offset);
      paramVarArgs.aR(3, this.continueFlag);
      paramVarArgs.e(4, 8, this.qbe);
      if (this.qHz != null) {
        paramVarArgs.c(5, this.qHz);
      }
      paramVarArgs.aR(6, this.Dlc);
      if (this.dnB != null) {
        paramVarArgs.d(7, this.dnB);
      }
      paramVarArgs.e(8, 8, this.qMq);
      AppMethodBeat.o(168959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.query == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.b.b.a.e(1, this.query) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.offset) + f.a.a.b.b.a.bA(3, this.continueFlag) + f.a.a.a.c(4, 8, this.qbe);
      paramInt = i;
      if (this.qHz != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.qHz);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.Dlc);
      paramInt = i;
      if (this.dnB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dnB);
      }
      i = f.a.a.a.c(8, 8, this.qMq);
      AppMethodBeat.o(168959);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qbe.clear();
        this.qMq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aik localaik = (aik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168959);
          return -1;
        case 1: 
          localaik.query = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168959);
          return 0;
        case 2: 
          localaik.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168959);
          return 0;
        case 3: 
          localaik.continueFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168959);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaik.qbe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168959);
          return 0;
        case 5: 
          localaik.qHz = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168959);
          return 0;
        case 6: 
          localaik.Dlc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168959);
          return 0;
        case 7: 
          localaik.dnB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168959);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aky();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaik.qMq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      AppMethodBeat.o(168959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aik
 * JD-Core Version:    0.7.0.1
 */