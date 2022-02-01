package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oo
  extends com.tencent.mm.cd.a
{
  public qg RWA;
  public mz RWB;
  public acj RWw;
  public qa RWx;
  public oj RWy;
  public qh RWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124434);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RWw != null)
      {
        paramVarArgs.oE(1, this.RWw.computeSize());
        this.RWw.writeFields(paramVarArgs);
      }
      if (this.RWx != null)
      {
        paramVarArgs.oE(2, this.RWx.computeSize());
        this.RWx.writeFields(paramVarArgs);
      }
      if (this.RWy != null)
      {
        paramVarArgs.oE(3, this.RWy.computeSize());
        this.RWy.writeFields(paramVarArgs);
      }
      if (this.RWz != null)
      {
        paramVarArgs.oE(4, this.RWz.computeSize());
        this.RWz.writeFields(paramVarArgs);
      }
      if (this.RWA != null)
      {
        paramVarArgs.oE(5, this.RWA.computeSize());
        this.RWA.writeFields(paramVarArgs);
      }
      if (this.RWB != null)
      {
        paramVarArgs.oE(6, this.RWB.computeSize());
        this.RWB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RWw == null) {
        break label950;
      }
    }
    label950:
    for (int i = g.a.a.a.oD(1, this.RWw.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RWx != null) {
        paramInt = i + g.a.a.a.oD(2, this.RWx.computeSize());
      }
      i = paramInt;
      if (this.RWy != null) {
        i = paramInt + g.a.a.a.oD(3, this.RWy.computeSize());
      }
      paramInt = i;
      if (this.RWz != null) {
        paramInt = i + g.a.a.a.oD(4, this.RWz.computeSize());
      }
      i = paramInt;
      if (this.RWA != null) {
        i = paramInt + g.a.a.a.oD(5, this.RWA.computeSize());
      }
      paramInt = i;
      if (this.RWB != null) {
        paramInt = i + g.a.a.a.oD(6, this.RWB.computeSize());
      }
      AppMethodBeat.o(124434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        oo localoo = (oo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124434);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acj)localObject2).parseFrom((byte[])localObject1);
            }
            localoo.RWw = ((acj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qa)localObject2).parseFrom((byte[])localObject1);
            }
            localoo.RWx = ((qa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new oj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((oj)localObject2).parseFrom((byte[])localObject1);
            }
            localoo.RWy = ((oj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qh)localObject2).parseFrom((byte[])localObject1);
            }
            localoo.RWz = ((qh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qg)localObject2).parseFrom((byte[])localObject1);
            }
            localoo.RWA = ((qg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((mz)localObject2).parseFrom((byte[])localObject1);
          }
          localoo.RWB = ((mz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      AppMethodBeat.o(124434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oo
 * JD-Core Version:    0.7.0.1
 */