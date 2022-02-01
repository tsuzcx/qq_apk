package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ciz
  extends com.tencent.mm.bx.a
{
  public String ProductID;
  public gol YGU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104796);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104796);
        throw paramVarArgs;
      }
      if (this.YGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104796);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.g(1, this.ProductID);
      }
      if (this.YGU != null)
      {
        paramVarArgs.qD(2, this.YGU.computeSize());
        this.YGU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = i.a.a.b.b.a.h(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YGU != null) {
        i = paramInt + i.a.a.a.qC(2, this.YGU.computeSize());
      }
      AppMethodBeat.o(104796);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104796);
          throw paramVarArgs;
        }
        if (this.YGU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104796);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ciz localciz = (ciz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104796);
          return -1;
        case 1: 
          localciz.ProductID = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104796);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gol localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localciz.YGU = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(104796);
        return 0;
      }
      AppMethodBeat.o(104796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciz
 * JD-Core Version:    0.7.0.1
 */