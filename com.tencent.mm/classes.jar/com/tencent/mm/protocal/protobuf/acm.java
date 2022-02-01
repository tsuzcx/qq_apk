package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acm
  extends com.tencent.mm.bw.a
{
  public dlh LmZ;
  public LinkedList<jn> Lna;
  public boolean Lnb;
  public dlh Lnc;
  
  public acm()
  {
    AppMethodBeat.i(201286);
    this.Lna = new LinkedList();
    AppMethodBeat.o(201286);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201287);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LmZ != null)
      {
        paramVarArgs.ni(1, this.LmZ.computeSize());
        this.LmZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Lna);
      paramVarArgs.cc(3, this.Lnb);
      if (this.Lnc != null)
      {
        paramVarArgs.ni(4, this.Lnc.computeSize());
        this.Lnc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(201287);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LmZ == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.a.nh(1, this.LmZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Lna) + (g.a.a.b.b.a.fS(3) + 1);
      paramInt = i;
      if (this.Lnc != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lnc.computeSize());
      }
      AppMethodBeat.o(201287);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lna.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(201287);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        acm localacm = (acm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201287);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localacm.LmZ = ((dlh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201287);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localacm.Lna.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201287);
          return 0;
        case 3: 
          localacm.Lnb = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(201287);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localacm.Lnc = ((dlh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201287);
        return 0;
      }
      AppMethodBeat.o(201287);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acm
 * JD-Core Version:    0.7.0.1
 */