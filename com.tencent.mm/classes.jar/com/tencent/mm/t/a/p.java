package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.cd.a
{
  public a jEq;
  public t jEr;
  public m jEs;
  public d jEt;
  public c jEu;
  public b jEv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249423);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jEq != null)
      {
        paramVarArgs.oE(1, this.jEq.computeSize());
        this.jEq.writeFields(paramVarArgs);
      }
      if (this.jEr != null)
      {
        paramVarArgs.oE(2, this.jEr.computeSize());
        this.jEr.writeFields(paramVarArgs);
      }
      if (this.jEs != null)
      {
        paramVarArgs.oE(3, this.jEs.computeSize());
        this.jEs.writeFields(paramVarArgs);
      }
      if (this.jEt != null)
      {
        paramVarArgs.oE(4, this.jEt.computeSize());
        this.jEt.writeFields(paramVarArgs);
      }
      if (this.jEu != null)
      {
        paramVarArgs.oE(5, this.jEu.computeSize());
        this.jEu.writeFields(paramVarArgs);
      }
      if (this.jEv != null)
      {
        paramVarArgs.oE(6, this.jEv.computeSize());
        this.jEv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(249423);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jEq == null) {
        break label950;
      }
    }
    label950:
    for (int i = g.a.a.a.oD(1, this.jEq.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jEr != null) {
        paramInt = i + g.a.a.a.oD(2, this.jEr.computeSize());
      }
      i = paramInt;
      if (this.jEs != null) {
        i = paramInt + g.a.a.a.oD(3, this.jEs.computeSize());
      }
      paramInt = i;
      if (this.jEt != null) {
        paramInt = i + g.a.a.a.oD(4, this.jEt.computeSize());
      }
      i = paramInt;
      if (this.jEu != null) {
        i = paramInt + g.a.a.a.oD(5, this.jEu.computeSize());
      }
      paramInt = i;
      if (this.jEv != null) {
        paramInt = i + g.a.a.a.oD(6, this.jEv.computeSize());
      }
      AppMethodBeat.o(249423);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(249423);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249423);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localp.jEq = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249423);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new t();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((t)localObject2).parseFrom((byte[])localObject1);
            }
            localp.jEr = ((t)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249423);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localp.jEs = ((m)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249423);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localp.jEt = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249423);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new c();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((c)localObject2).parseFrom((byte[])localObject1);
            }
            localp.jEu = ((c)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249423);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new b();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((b)localObject2).parseFrom((byte[])localObject1);
          }
          localp.jEv = ((b)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(249423);
        return 0;
      }
      AppMethodBeat.o(249423);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.p
 * JD-Core Version:    0.7.0.1
 */