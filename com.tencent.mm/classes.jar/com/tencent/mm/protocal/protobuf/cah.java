package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cah
  extends com.tencent.mm.bx.a
{
  public dbp Cvo;
  public dbp Cvp;
  public bhl DWP;
  public LinkedList<rf> DWQ;
  public bsw DWR;
  
  public cah()
  {
    AppMethodBeat.i(91613);
    this.DWQ = new LinkedList();
    AppMethodBeat.o(91613);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91614);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWP != null)
      {
        paramVarArgs.kX(1, this.DWP.computeSize());
        this.DWP.writeFields(paramVarArgs);
      }
      if (this.Cvo != null)
      {
        paramVarArgs.kX(2, this.Cvo.computeSize());
        this.Cvo.writeFields(paramVarArgs);
      }
      if (this.Cvp != null)
      {
        paramVarArgs.kX(3, this.Cvp.computeSize());
        this.Cvp.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.DWQ);
      if (this.DWR != null)
      {
        paramVarArgs.kX(5, this.DWR.computeSize());
        this.DWR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWP == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.kW(1, this.DWP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Cvo != null) {
        paramInt = i + f.a.a.a.kW(2, this.Cvo.computeSize());
      }
      i = paramInt;
      if (this.Cvp != null) {
        i = paramInt + f.a.a.a.kW(3, this.Cvp.computeSize());
      }
      i += f.a.a.a.c(4, 8, this.DWQ);
      paramInt = i;
      if (this.DWR != null) {
        paramInt = i + f.a.a.a.kW(5, this.DWR.computeSize());
      }
      AppMethodBeat.o(91614);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DWQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cah localcah = (cah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91614);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcah.DWP = ((bhl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcah.Cvo = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcah.Cvp = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcah.DWQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcah.DWR = ((bsw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      AppMethodBeat.o(91614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cah
 * JD-Core Version:    0.7.0.1
 */