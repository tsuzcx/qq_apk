package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cts
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public dbp DPC;
  public clq Elm;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91693);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPC != null)
      {
        paramVarArgs.kX(1, this.DPC.computeSize());
        this.DPC.writeFields(paramVarArgs);
      }
      if (this.Elm != null)
      {
        paramVarArgs.kX(2, this.Elm.computeSize());
        this.Elm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.type);
      if (this.CDW != null) {
        paramVarArgs.d(4, this.CDW);
      }
      AppMethodBeat.o(91693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPC == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.kW(1, this.DPC.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Elm != null) {
        i = paramInt + f.a.a.a.kW(2, this.Elm.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.type);
      paramInt = i;
      if (this.CDW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CDW);
      }
      AppMethodBeat.o(91693);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cts localcts = (cts)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91693);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcts.DPC = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91693);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcts.Elm = ((clq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91693);
          return 0;
        case 3: 
          localcts.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91693);
          return 0;
        }
        localcts.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91693);
        return 0;
      }
      AppMethodBeat.o(91693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cts
 * JD-Core Version:    0.7.0.1
 */