package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxn
  extends com.tencent.mm.bw.a
{
  public dhb DNJ;
  public String DWw;
  public LinkedList<dhb> EjR;
  public String Fmo;
  
  public bxn()
  {
    AppMethodBeat.i(91553);
    this.EjR = new LinkedList();
    AppMethodBeat.o(91553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DNJ != null)
      {
        paramVarArgs.ln(1, this.DNJ.computeSize());
        this.DNJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.EjR);
      if (this.DWw != null) {
        paramVarArgs.d(3, this.DWw);
      }
      if (this.Fmo != null) {
        paramVarArgs.d(4, this.Fmo);
      }
      AppMethodBeat.o(91554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DNJ == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.lm(1, this.DNJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EjR);
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DWw);
      }
      i = paramInt;
      if (this.Fmo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Fmo);
      }
      AppMethodBeat.o(91554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EjR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxn localbxn = (bxn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91554);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxn.DNJ = ((dhb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxn.EjR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 3: 
          localbxn.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91554);
          return 0;
        }
        localbxn.Fmo = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91554);
        return 0;
      }
      AppMethodBeat.o(91554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxn
 * JD-Core Version:    0.7.0.1
 */