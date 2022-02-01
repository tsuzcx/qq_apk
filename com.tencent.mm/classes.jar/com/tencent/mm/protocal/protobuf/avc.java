package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avc
  extends com.tencent.mm.bw.a
{
  public int DQa;
  public crm ENj;
  public int ENk;
  public int ENl;
  public int ENm = 1;
  public int ENn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ENj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatroomId");
        AppMethodBeat.o(101809);
        throw paramVarArgs;
      }
      if (this.ENj != null)
      {
        paramVarArgs.ln(1, this.ENj.computeSize());
        this.ENj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DQa);
      paramVarArgs.aR(3, this.ENk);
      paramVarArgs.aR(4, this.ENl);
      paramVarArgs.aR(5, this.ENm);
      paramVarArgs.aR(6, this.ENn);
      AppMethodBeat.o(101809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ENj == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lm(1, this.ENj.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.DQa);
      int j = f.a.a.b.b.a.bx(3, this.ENk);
      int k = f.a.a.b.b.a.bx(4, this.ENl);
      int m = f.a.a.b.b.a.bx(5, this.ENm);
      int n = f.a.a.b.b.a.bx(6, this.ENn);
      AppMethodBeat.o(101809);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ENj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatroomId");
          AppMethodBeat.o(101809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avc localavc = (avc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavc.ENj = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101809);
          return 0;
        case 2: 
          localavc.DQa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101809);
          return 0;
        case 3: 
          localavc.ENk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101809);
          return 0;
        case 4: 
          localavc.ENl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101809);
          return 0;
        case 5: 
          localavc.ENm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101809);
          return 0;
        }
        localavc.ENn = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(101809);
        return 0;
      }
      AppMethodBeat.o(101809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avc
 * JD-Core Version:    0.7.0.1
 */