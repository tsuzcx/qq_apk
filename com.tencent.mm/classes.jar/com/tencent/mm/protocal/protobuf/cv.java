package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cv
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int DQa;
  public crm DQb;
  public int DQc;
  public crm DQd;
  public int DQe;
  public int tit;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133144);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DQb == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomId");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.DQd == null)
      {
        paramVarArgs = new b("Not all required fields were included: DigestContent");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.DQb != null)
      {
        paramVarArgs.ln(1, this.DQb.computeSize());
        this.DQb.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.vTQ);
      paramVarArgs.aR(3, this.DQa);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.DQc);
      if (this.DQd != null)
      {
        paramVarArgs.ln(6, this.DQd.computeSize());
        this.DQd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.DQe);
      paramVarArgs.aR(8, this.tit);
      AppMethodBeat.o(133144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DQb == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.lm(1, this.DQb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.vTQ) + f.a.a.b.b.a.bx(3, this.DQa) + f.a.a.b.b.a.bx(4, this.CreateTime) + f.a.a.b.b.a.bx(5, this.DQc);
      paramInt = i;
      if (this.DQd != null) {
        paramInt = i + f.a.a.a.lm(6, this.DQd.computeSize());
      }
      i = f.a.a.b.b.a.bx(7, this.DQe);
      int j = f.a.a.b.b.a.bx(8, this.tit);
      AppMethodBeat.o(133144);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DQb == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomId");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        if (this.DQd == null)
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
        cv localcv = (cv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133144);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcv.DQb = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 2: 
          localcv.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(133144);
          return 0;
        case 3: 
          localcv.DQa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133144);
          return 0;
        case 4: 
          localcv.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133144);
          return 0;
        case 5: 
          localcv.DQc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133144);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcv.DQd = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 7: 
          localcv.DQe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133144);
          return 0;
        }
        localcv.tit = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133144);
        return 0;
      }
      AppMethodBeat.o(133144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cv
 * JD-Core Version:    0.7.0.1
 */