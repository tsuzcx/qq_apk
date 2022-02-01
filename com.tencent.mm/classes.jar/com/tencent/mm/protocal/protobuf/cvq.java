package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvq
  extends com.tencent.mm.bw.a
{
  public int LDk;
  public int LYP;
  public cvs LYQ;
  public int MAZ;
  public cvr MBa;
  public int MBb;
  public int MBc;
  public int MBd;
  public String app_id;
  public String jHa;
  public int zqk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152631);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jHa != null) {
        paramVarArgs.e(1, this.jHa);
      }
      paramVarArgs.aM(2, this.MAZ);
      if (this.MBa != null)
      {
        paramVarArgs.ni(3, this.MBa.computeSize());
        this.MBa.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.LYP);
      if (this.LYQ != null)
      {
        paramVarArgs.ni(5, this.LYQ.computeSize());
        this.LYQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.MBb);
      paramVarArgs.aM(7, this.MBc);
      paramVarArgs.aM(8, this.zqk);
      paramVarArgs.aM(9, this.MBd);
      if (this.app_id != null) {
        paramVarArgs.e(10, this.app_id);
      }
      paramVarArgs.aM(11, this.LDk);
      AppMethodBeat.o(152631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jHa == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = g.a.a.b.b.a.f(1, this.jHa) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MAZ);
      paramInt = i;
      if (this.MBa != null) {
        paramInt = i + g.a.a.a.nh(3, this.MBa.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.LYP);
      paramInt = i;
      if (this.LYQ != null) {
        paramInt = i + g.a.a.a.nh(5, this.LYQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.MBb) + g.a.a.b.b.a.bu(7, this.MBc) + g.a.a.b.b.a.bu(8, this.zqk) + g.a.a.b.b.a.bu(9, this.MBd);
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.app_id);
      }
      i = g.a.a.b.b.a.bu(11, this.LDk);
      AppMethodBeat.o(152631);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cvq localcvq = (cvq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152631);
          return -1;
        case 1: 
          localcvq.jHa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152631);
          return 0;
        case 2: 
          localcvq.MAZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152631);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcvq.MBa = ((cvr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 4: 
          localcvq.LYP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152631);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcvq.LYQ = ((cvs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 6: 
          localcvq.MBb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152631);
          return 0;
        case 7: 
          localcvq.MBc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152631);
          return 0;
        case 8: 
          localcvq.zqk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152631);
          return 0;
        case 9: 
          localcvq.MBd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152631);
          return 0;
        case 10: 
          localcvq.app_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152631);
          return 0;
        }
        localcvq.LDk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152631);
        return 0;
      }
      AppMethodBeat.o(152631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvq
 * JD-Core Version:    0.7.0.1
 */