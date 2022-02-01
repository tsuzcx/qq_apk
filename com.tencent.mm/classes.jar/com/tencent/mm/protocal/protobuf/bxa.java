package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxa
  extends com.tencent.mm.bw.a
{
  public String DWw;
  public dhb FlT;
  public LinkedList<cqx> FlU;
  public int type;
  
  public bxa()
  {
    AppMethodBeat.i(91548);
    this.FlU = new LinkedList();
    AppMethodBeat.o(91548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FlT != null)
      {
        paramVarArgs.ln(1, this.FlT.computeSize());
        this.FlT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FlU);
      paramVarArgs.aR(3, this.type);
      if (this.DWw != null) {
        paramVarArgs.d(4, this.DWw);
      }
      AppMethodBeat.o(91549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FlT == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lm(1, this.FlT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FlU) + f.a.a.b.b.a.bx(3, this.type);
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DWw);
      }
      AppMethodBeat.o(91549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FlU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxa localbxa = (bxa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91549);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxa.FlT = ((dhb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxa.FlU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
          return 0;
        case 3: 
          localbxa.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91549);
          return 0;
        }
        localbxa.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91549);
        return 0;
      }
      AppMethodBeat.o(91549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxa
 * JD-Core Version:    0.7.0.1
 */