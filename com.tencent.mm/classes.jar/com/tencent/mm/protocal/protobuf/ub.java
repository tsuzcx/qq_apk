package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ub
  extends com.tencent.mm.bw.a
{
  public String Ldh;
  public String Ldi;
  public String Ldj;
  public int Ldk;
  public un Ldl;
  public int Ldm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113953);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ldh != null) {
        paramVarArgs.e(1, this.Ldh);
      }
      if (this.Ldi != null) {
        paramVarArgs.e(2, this.Ldi);
      }
      if (this.Ldj != null) {
        paramVarArgs.e(3, this.Ldj);
      }
      paramVarArgs.aM(4, this.Ldk);
      if (this.Ldl != null)
      {
        paramVarArgs.ni(5, this.Ldl.computeSize());
        this.Ldl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.Ldm);
      AppMethodBeat.o(113953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ldh == null) {
        break label582;
      }
    }
    label582:
    for (int i = g.a.a.b.b.a.f(1, this.Ldh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ldi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Ldi);
      }
      i = paramInt;
      if (this.Ldj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Ldj);
      }
      i += g.a.a.b.b.a.bu(4, this.Ldk);
      paramInt = i;
      if (this.Ldl != null) {
        paramInt = i + g.a.a.a.nh(5, this.Ldl.computeSize());
      }
      i = g.a.a.b.b.a.bu(6, this.Ldm);
      AppMethodBeat.o(113953);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ub localub = (ub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113953);
          return -1;
        case 1: 
          localub.Ldh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 2: 
          localub.Ldi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 3: 
          localub.Ldj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 4: 
          localub.Ldk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113953);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localub.Ldl = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113953);
          return 0;
        }
        localub.Ldm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113953);
        return 0;
      }
      AppMethodBeat.o(113953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ub
 * JD-Core Version:    0.7.0.1
 */