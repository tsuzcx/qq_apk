package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doy
  extends com.tencent.mm.bw.a
{
  public String HWc;
  public String HWd;
  public LinkedList<alj> HWe;
  
  public doy()
  {
    AppMethodBeat.i(153008);
    this.HWe = new LinkedList();
    AppMethodBeat.o(153008);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153009);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HWc != null) {
        paramVarArgs.d(1, this.HWc);
      }
      if (this.HWd != null) {
        paramVarArgs.d(2, this.HWd);
      }
      paramVarArgs.e(3, 8, this.HWe);
      AppMethodBeat.o(153009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HWc == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.HWc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HWd != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HWd);
      }
      paramInt = f.a.a.a.c(3, 8, this.HWe);
      AppMethodBeat.o(153009);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HWe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        doy localdoy = (doy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153009);
          return -1;
        case 1: 
          localdoy.HWc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153009);
          return 0;
        case 2: 
          localdoy.HWd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153009);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((alj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdoy.HWe.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doy
 * JD-Core Version:    0.7.0.1
 */