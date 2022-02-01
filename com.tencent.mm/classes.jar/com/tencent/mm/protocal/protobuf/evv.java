package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class evv
  extends com.tencent.mm.bw.a
{
  public evr NtD;
  public evh NtE;
  public String NtF;
  public String NtG;
  public String NtH;
  public int NtI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147809);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NtD != null)
      {
        paramVarArgs.ni(1, this.NtD.computeSize());
        this.NtD.writeFields(paramVarArgs);
      }
      if (this.NtE != null)
      {
        paramVarArgs.ni(2, this.NtE.computeSize());
        this.NtE.writeFields(paramVarArgs);
      }
      if (this.NtF != null) {
        paramVarArgs.e(3, this.NtF);
      }
      if (this.NtG != null) {
        paramVarArgs.e(4, this.NtG);
      }
      if (this.NtH != null) {
        paramVarArgs.e(5, this.NtH);
      }
      paramVarArgs.aM(6, this.NtI);
      AppMethodBeat.o(147809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NtD == null) {
        break label690;
      }
    }
    label690:
    for (int i = g.a.a.a.nh(1, this.NtD.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NtE != null) {
        paramInt = i + g.a.a.a.nh(2, this.NtE.computeSize());
      }
      i = paramInt;
      if (this.NtF != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NtF);
      }
      paramInt = i;
      if (this.NtG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NtG);
      }
      i = paramInt;
      if (this.NtH != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NtH);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.NtI);
      AppMethodBeat.o(147809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        evv localevv = (evv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147809);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new evr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((evr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localevv.NtD = ((evr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new evh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((evh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localevv.NtE = ((evh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 3: 
          localevv.NtF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 4: 
          localevv.NtG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 5: 
          localevv.NtH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147809);
          return 0;
        }
        localevv.NtI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(147809);
        return 0;
      }
      AppMethodBeat.o(147809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evv
 * JD-Core Version:    0.7.0.1
 */