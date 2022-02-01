package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.bx.a
{
  public a mem;
  public t men;
  public m meo;
  public d mep;
  public c meq;
  public b mer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231433);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mem != null)
      {
        paramVarArgs.qD(1, this.mem.computeSize());
        this.mem.writeFields(paramVarArgs);
      }
      if (this.men != null)
      {
        paramVarArgs.qD(2, this.men.computeSize());
        this.men.writeFields(paramVarArgs);
      }
      if (this.meo != null)
      {
        paramVarArgs.qD(3, this.meo.computeSize());
        this.meo.writeFields(paramVarArgs);
      }
      if (this.mep != null)
      {
        paramVarArgs.qD(4, this.mep.computeSize());
        this.mep.writeFields(paramVarArgs);
      }
      if (this.meq != null)
      {
        paramVarArgs.qD(5, this.meq.computeSize());
        this.meq.writeFields(paramVarArgs);
      }
      if (this.mer != null)
      {
        paramVarArgs.qD(6, this.mer.computeSize());
        this.mer.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(231433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mem == null) {
        break label946;
      }
    }
    label946:
    for (int i = i.a.a.a.qC(1, this.mem.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.men != null) {
        paramInt = i + i.a.a.a.qC(2, this.men.computeSize());
      }
      i = paramInt;
      if (this.meo != null) {
        i = paramInt + i.a.a.a.qC(3, this.meo.computeSize());
      }
      paramInt = i;
      if (this.mep != null) {
        paramInt = i + i.a.a.a.qC(4, this.mep.computeSize());
      }
      i = paramInt;
      if (this.meq != null) {
        i = paramInt + i.a.a.a.qC(5, this.meq.computeSize());
      }
      paramInt = i;
      if (this.mer != null) {
        paramInt = i + i.a.a.a.qC(6, this.mer.computeSize());
      }
      AppMethodBeat.o(231433);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(231433);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231433);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localp.mem = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231433);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new t();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((t)localObject2).parseFrom((byte[])localObject1);
            }
            localp.men = ((t)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231433);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localp.meo = ((m)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231433);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localp.mep = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231433);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new c();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((c)localObject2).parseFrom((byte[])localObject1);
            }
            localp.meq = ((c)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231433);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new b();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((b)localObject2).parseFrom((byte[])localObject1);
          }
          localp.mer = ((b)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(231433);
        return 0;
      }
      AppMethodBeat.o(231433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a.p
 * JD-Core Version:    0.7.0.1
 */