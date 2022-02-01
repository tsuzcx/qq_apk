package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class arz
  extends dop
{
  public aov LAI;
  public apc LAv;
  public int dLS;
  public String finderUsername;
  public b lastBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209405);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LAI != null)
      {
        paramVarArgs.ni(2, this.LAI.computeSize());
        this.LAI.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.e(3, this.finderUsername);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      paramVarArgs.aM(5, this.dLS);
      if (this.LAv != null)
      {
        paramVarArgs.ni(6, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LAI != null) {
        paramInt = i + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.finderUsername);
      }
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.dLS);
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(6, this.LAv.computeSize());
      }
      AppMethodBeat.o(209405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209405);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        arz localarz = (arz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209405);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localarz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209405);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localarz.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209405);
          return 0;
        case 3: 
          localarz.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209405);
          return 0;
        case 4: 
          localarz.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209405);
          return 0;
        case 5: 
          localarz.dLS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209405);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localarz.LAv = ((apc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209405);
        return 0;
      }
      AppMethodBeat.o(209405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arz
 * JD-Core Version:    0.7.0.1
 */