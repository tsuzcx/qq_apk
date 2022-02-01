package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cw
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int FNN;
  public cxn FNO;
  public int FNP;
  public cxn FNQ;
  public int FNR;
  public int urJ;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133144);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNO == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomId");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.FNQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: DigestContent");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.FNO != null)
      {
        paramVarArgs.lJ(1, this.FNO.computeSize());
        this.FNO.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.xrk);
      paramVarArgs.aS(3, this.FNN);
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(5, this.FNP);
      if (this.FNQ != null)
      {
        paramVarArgs.lJ(6, this.FNQ.computeSize());
        this.FNQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.FNR);
      paramVarArgs.aS(8, this.urJ);
      AppMethodBeat.o(133144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNO == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.lI(1, this.FNO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.xrk) + f.a.a.b.b.a.bz(3, this.FNN) + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(5, this.FNP);
      paramInt = i;
      if (this.FNQ != null) {
        paramInt = i + f.a.a.a.lI(6, this.FNQ.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.FNR);
      int j = f.a.a.b.b.a.bz(8, this.urJ);
      AppMethodBeat.o(133144);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FNO == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomId");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        if (this.FNQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: DigestContent");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cw localcw = (cw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133144);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcw.FNO = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 2: 
          localcw.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(133144);
          return 0;
        case 3: 
          localcw.FNN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133144);
          return 0;
        case 4: 
          localcw.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133144);
          return 0;
        case 5: 
          localcw.FNP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133144);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcw.FNQ = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 7: 
          localcw.FNR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133144);
          return 0;
        }
        localcw.urJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133144);
        return 0;
      }
      AppMethodBeat.o(133144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cw
 * JD-Core Version:    0.7.0.1
 */