package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ajw
  extends com.tencent.mm.bw.a
{
  public int EEt;
  public int continueFlag;
  public String dlj;
  public int offset;
  public LinkedList<FinderObject> qJK;
  public String query;
  public LinkedList<anr> rHC;
  public b rmJ;
  
  public ajw()
  {
    AppMethodBeat.i(168958);
    this.qJK = new LinkedList();
    this.rHC = new LinkedList();
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
      paramVarArgs.e(4, 8, this.qJK);
      if (this.rmJ != null) {
        paramVarArgs.c(5, this.rmJ);
      }
      paramVarArgs.aR(6, this.EEt);
      if (this.dlj != null) {
        paramVarArgs.d(7, this.dlj);
      }
      paramVarArgs.e(8, 8, this.rHC);
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
      int i = paramInt + f.a.a.b.b.a.bx(2, this.offset) + f.a.a.b.b.a.bx(3, this.continueFlag) + f.a.a.a.c(4, 8, this.qJK);
      paramInt = i;
      if (this.rmJ != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.rmJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.EEt);
      paramInt = i;
      if (this.dlj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dlj);
      }
      i = f.a.a.a.c(8, 8, this.rHC);
      AppMethodBeat.o(168959);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qJK.clear();
        this.rHC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajw localajw = (ajw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168959);
          return -1;
        case 1: 
          localajw.query = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168959);
          return 0;
        case 2: 
          localajw.offset = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168959);
          return 0;
        case 3: 
          localajw.continueFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168959);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajw.qJK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168959);
          return 0;
        case 5: 
          localajw.rmJ = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168959);
          return 0;
        case 6: 
          localajw.EEt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168959);
          return 0;
        case 7: 
          localajw.dlj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168959);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((anr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localajw.rHC.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajw
 * JD-Core Version:    0.7.0.1
 */