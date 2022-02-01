package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efn
  extends com.tencent.mm.cd.a
{
  public dhx UiN;
  public dht UiO;
  public dhx UiP;
  public dht UiQ;
  public boolean UiR = false;
  public boolean UiS = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(251354);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UiN != null)
      {
        paramVarArgs.oE(1, this.UiN.computeSize());
        this.UiN.writeFields(paramVarArgs);
      }
      if (this.UiO != null)
      {
        paramVarArgs.oE(2, this.UiO.computeSize());
        this.UiO.writeFields(paramVarArgs);
      }
      if (this.UiP != null)
      {
        paramVarArgs.oE(3, this.UiP.computeSize());
        this.UiP.writeFields(paramVarArgs);
      }
      if (this.UiQ != null)
      {
        paramVarArgs.oE(4, this.UiQ.computeSize());
        this.UiQ.writeFields(paramVarArgs);
      }
      paramVarArgs.co(5, this.UiR);
      paramVarArgs.co(6, this.UiS);
      AppMethodBeat.o(251354);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UiN == null) {
        break label774;
      }
    }
    label774:
    for (int i = g.a.a.a.oD(1, this.UiN.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UiO != null) {
        paramInt = i + g.a.a.a.oD(2, this.UiO.computeSize());
      }
      i = paramInt;
      if (this.UiP != null) {
        i = paramInt + g.a.a.a.oD(3, this.UiP.computeSize());
      }
      paramInt = i;
      if (this.UiQ != null) {
        paramInt = i + g.a.a.a.oD(4, this.UiQ.computeSize());
      }
      i = g.a.a.b.b.a.gL(5);
      int j = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(251354);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(251354);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        efn localefn = (efn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(251354);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhx)localObject2).parseFrom((byte[])localObject1);
            }
            localefn.UiN = ((dhx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(251354);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dht();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dht)localObject2).parseFrom((byte[])localObject1);
            }
            localefn.UiO = ((dht)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(251354);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhx)localObject2).parseFrom((byte[])localObject1);
            }
            localefn.UiP = ((dhx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(251354);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dht();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dht)localObject2).parseFrom((byte[])localObject1);
            }
            localefn.UiQ = ((dht)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(251354);
          return 0;
        case 5: 
          localefn.UiR = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(251354);
          return 0;
        }
        localefn.UiS = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(251354);
        return 0;
      }
      AppMethodBeat.o(251354);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efn
 * JD-Core Version:    0.7.0.1
 */