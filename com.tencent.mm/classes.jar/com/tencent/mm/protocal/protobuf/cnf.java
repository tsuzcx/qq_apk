package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnf
  extends com.tencent.mm.bw.a
{
  public String MtA;
  public String MtB;
  public int MtC;
  public String MtD;
  public un MtE;
  public String MtF;
  public String Mtz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201347);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mtz != null) {
        paramVarArgs.e(1, this.Mtz);
      }
      if (this.MtA != null) {
        paramVarArgs.e(2, this.MtA);
      }
      if (this.MtB != null) {
        paramVarArgs.e(3, this.MtB);
      }
      paramVarArgs.aM(4, this.MtC);
      if (this.MtD != null) {
        paramVarArgs.e(5, this.MtD);
      }
      if (this.MtE != null)
      {
        paramVarArgs.ni(6, this.MtE.computeSize());
        this.MtE.writeFields(paramVarArgs);
      }
      if (this.MtF != null) {
        paramVarArgs.e(7, this.MtF);
      }
      AppMethodBeat.o(201347);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mtz == null) {
        break label658;
      }
    }
    label658:
    for (int i = g.a.a.b.b.a.f(1, this.Mtz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MtA != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MtA);
      }
      i = paramInt;
      if (this.MtB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MtB);
      }
      i += g.a.a.b.b.a.bu(4, this.MtC);
      paramInt = i;
      if (this.MtD != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MtD);
      }
      i = paramInt;
      if (this.MtE != null) {
        i = paramInt + g.a.a.a.nh(6, this.MtE.computeSize());
      }
      paramInt = i;
      if (this.MtF != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MtF);
      }
      AppMethodBeat.o(201347);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(201347);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnf localcnf = (cnf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201347);
          return -1;
        case 1: 
          localcnf.Mtz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201347);
          return 0;
        case 2: 
          localcnf.MtA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201347);
          return 0;
        case 3: 
          localcnf.MtB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201347);
          return 0;
        case 4: 
          localcnf.MtC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201347);
          return 0;
        case 5: 
          localcnf.MtD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201347);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcnf.MtE = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201347);
          return 0;
        }
        localcnf.MtF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(201347);
        return 0;
      }
      AppMethodBeat.o(201347);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnf
 * JD-Core Version:    0.7.0.1
 */