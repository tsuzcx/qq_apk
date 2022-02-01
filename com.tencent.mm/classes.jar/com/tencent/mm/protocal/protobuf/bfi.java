package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfi
  extends com.tencent.mm.bx.a
{
  public dce DCA;
  public cdt DCB;
  public cdt DCC;
  public String doh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DCA != null)
      {
        paramVarArgs.kX(1, this.DCA.computeSize());
        this.DCA.writeFields(paramVarArgs);
      }
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      if (this.DCB != null)
      {
        paramVarArgs.kX(3, this.DCB.computeSize());
        this.DCB.writeFields(paramVarArgs);
      }
      if (this.DCC != null)
      {
        paramVarArgs.kX(4, this.DCC.computeSize());
        this.DCC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DCA == null) {
        break label678;
      }
    }
    label678:
    for (int i = f.a.a.a.kW(1, this.DCA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt;
      if (this.DCB != null) {
        i = paramInt + f.a.a.a.kW(3, this.DCB.computeSize());
      }
      paramInt = i;
      if (this.DCC != null) {
        paramInt = i + f.a.a.a.kW(4, this.DCC.computeSize());
      }
      AppMethodBeat.o(195470);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(195470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfi localbfi = (bfi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195470);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dce();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dce)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfi.DCA = ((dce)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195470);
          return 0;
        case 2: 
          localbfi.doh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195470);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfi.DCB = ((cdt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195470);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbfi.DCC = ((cdt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195470);
        return 0;
      }
      AppMethodBeat.o(195470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfi
 * JD-Core Version:    0.7.0.1
 */