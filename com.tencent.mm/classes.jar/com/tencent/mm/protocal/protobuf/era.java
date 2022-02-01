package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class era
  extends com.tencent.mm.bw.a
{
  public ado Nor;
  public boolean Nos = true;
  public eqn Not;
  public String Nou;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117943);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nor != null)
      {
        paramVarArgs.ni(1, this.Nor.computeSize());
        this.Nor.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(2, this.Nos);
      if (this.Not != null)
      {
        paramVarArgs.ni(3, this.Not.computeSize());
        this.Not.writeFields(paramVarArgs);
      }
      if (this.Nou != null) {
        paramVarArgs.e(4, this.Nou);
      }
      AppMethodBeat.o(117943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nor == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = g.a.a.a.nh(1, this.Nor.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.Not != null) {
        paramInt = i + g.a.a.a.nh(3, this.Not.computeSize());
      }
      i = paramInt;
      if (this.Nou != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Nou);
      }
      AppMethodBeat.o(117943);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        era localera = (era)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117943);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ado();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ado)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localera.Nor = ((ado)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        case 2: 
          localera.Nos = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(117943);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eqn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eqn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localera.Not = ((eqn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        }
        localera.Nou = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117943);
        return 0;
      }
      AppMethodBeat.o(117943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.era
 * JD-Core Version:    0.7.0.1
 */