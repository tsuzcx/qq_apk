package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bif
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public dbp DFM;
  public LinkedList<dav> DFN;
  public dbp DFO;
  
  public bif()
  {
    AppMethodBeat.i(91526);
    this.DFN = new LinkedList();
    AppMethodBeat.o(91526);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DFM != null)
      {
        paramVarArgs.kX(1, this.DFM.computeSize());
        this.DFM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.DFN);
      if (this.DFO != null)
      {
        paramVarArgs.kX(3, this.DFO.computeSize());
        this.DFO.writeFields(paramVarArgs);
      }
      if (this.CDW != null) {
        paramVarArgs.d(4, this.CDW);
      }
      AppMethodBeat.o(91527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DFM == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.a.kW(1, this.DFM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.DFN);
      paramInt = i;
      if (this.DFO != null) {
        paramInt = i + f.a.a.a.kW(3, this.DFO.computeSize());
      }
      i = paramInt;
      if (this.CDW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CDW);
      }
      AppMethodBeat.o(91527);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DFN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91527);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bif localbif = (bif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91527);
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
            localbif.DFM = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dav();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dav)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbif.DFN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
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
            localbif.DFO = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        }
        localbif.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91527);
        return 0;
      }
      AppMethodBeat.o(91527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bif
 * JD-Core Version:    0.7.0.1
 */