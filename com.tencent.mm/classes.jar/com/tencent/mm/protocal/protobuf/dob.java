package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dob
  extends com.tencent.mm.bx.a
{
  public String HCp;
  public String HCq;
  public LinkedList<akz> HCr;
  
  public dob()
  {
    AppMethodBeat.i(153008);
    this.HCr = new LinkedList();
    AppMethodBeat.o(153008);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153009);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HCp != null) {
        paramVarArgs.d(1, this.HCp);
      }
      if (this.HCq != null) {
        paramVarArgs.d(2, this.HCq);
      }
      paramVarArgs.e(3, 8, this.HCr);
      AppMethodBeat.o(153009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HCp == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.HCp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HCq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HCq);
      }
      paramInt = f.a.a.a.c(3, 8, this.HCr);
      AppMethodBeat.o(153009);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HCr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dob localdob = (dob)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153009);
          return -1;
        case 1: 
          localdob.HCp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153009);
          return 0;
        case 2: 
          localdob.HCq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153009);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((akz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdob.HCr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      AppMethodBeat.o(153009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dob
 * JD-Core Version:    0.7.0.1
 */