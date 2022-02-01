package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class act
  extends com.tencent.mm.cd.a
{
  public duz Soq;
  public LinkedList<jc> Sor;
  public boolean Sos;
  public duz Sot;
  
  public act()
  {
    AppMethodBeat.i(255060);
    this.Sor = new LinkedList();
    AppMethodBeat.o(255060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255065);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Soq != null)
      {
        paramVarArgs.oE(1, this.Soq.computeSize());
        this.Soq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Sor);
      paramVarArgs.co(3, this.Sos);
      if (this.Sot != null)
      {
        paramVarArgs.oE(4, this.Sot.computeSize());
        this.Sot.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(255065);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Soq == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = g.a.a.a.oD(1, this.Soq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Sor) + (g.a.a.b.b.a.gL(3) + 1);
      paramInt = i;
      if (this.Sot != null) {
        paramInt = i + g.a.a.a.oD(4, this.Sot.computeSize());
      }
      AppMethodBeat.o(255065);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sor.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(255065);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        act localact = (act)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(255065);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duz)localObject2).parseFrom((byte[])localObject1);
            }
            localact.Soq = ((duz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255065);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jc)localObject2).parseFrom((byte[])localObject1);
            }
            localact.Sor.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255065);
          return 0;
        case 3: 
          localact.Sos = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(255065);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new duz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((duz)localObject2).parseFrom((byte[])localObject1);
          }
          localact.Sot = ((duz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255065);
        return 0;
      }
      AppMethodBeat.o(255065);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.act
 * JD-Core Version:    0.7.0.1
 */