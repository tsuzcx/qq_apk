package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsj
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public dbp DPC;
  public LinkedList<clq> DPD;
  public int type;
  
  public bsj()
  {
    AppMethodBeat.i(91548);
    this.DPD = new LinkedList();
    AppMethodBeat.o(91548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPC != null)
      {
        paramVarArgs.kX(1, this.DPC.computeSize());
        this.DPC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.DPD);
      paramVarArgs.aR(3, this.type);
      if (this.CDW != null) {
        paramVarArgs.d(4, this.CDW);
      }
      AppMethodBeat.o(91549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPC == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.kW(1, this.DPC.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.DPD) + f.a.a.b.b.a.bA(3, this.type);
      paramInt = i;
      if (this.CDW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CDW);
      }
      AppMethodBeat.o(91549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DPD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsj localbsj = (bsj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91549);
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
            localbsj.DPC = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
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
            localbsj.DPD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
          return 0;
        case 3: 
          localbsj.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91549);
          return 0;
        }
        localbsj.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91549);
        return 0;
      }
      AppMethodBeat.o(91549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsj
 * JD-Core Version:    0.7.0.1
 */