package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ctr
  extends com.tencent.mm.bw.a
{
  public String KLO;
  public int Leu;
  public SKBuiltinBuffer_t Lev;
  public abo MyZ;
  public int Mza;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133186);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MyZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.Lev == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.MyZ != null)
      {
        paramVarArgs.ni(1, this.MyZ.computeSize());
        this.MyZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Leu);
      if (this.Lev != null)
      {
        paramVarArgs.ni(3, this.Lev.computeSize());
        this.Lev.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.Scene);
      if (this.KLO != null) {
        paramVarArgs.e(5, this.KLO);
      }
      paramVarArgs.aM(6, this.Mza);
      AppMethodBeat.o(133186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MyZ == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = g.a.a.a.nh(1, this.MyZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Leu);
      paramInt = i;
      if (this.Lev != null) {
        paramInt = i + g.a.a.a.nh(3, this.Lev.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Scene);
      paramInt = i;
      if (this.KLO != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KLO);
      }
      i = g.a.a.b.b.a.bu(6, this.Mza);
      AppMethodBeat.o(133186);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MyZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        if (this.Lev == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ctr localctr = (ctr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133186);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctr.MyZ = ((abo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 2: 
          localctr.Leu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133186);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctr.Lev = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 4: 
          localctr.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133186);
          return 0;
        case 5: 
          localctr.KLO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133186);
          return 0;
        }
        localctr.Mza = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133186);
        return 0;
      }
      AppMethodBeat.o(133186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctr
 * JD-Core Version:    0.7.0.1
 */