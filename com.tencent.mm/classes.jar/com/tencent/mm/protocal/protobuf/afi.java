package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afi
  extends com.tencent.mm.bw.a
{
  public cwl GcB;
  public String GvK;
  public String GvL;
  public int GvM;
  public String GvN;
  public String nIJ;
  public int uqI;
  public String uqf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117866);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcB != null)
      {
        paramVarArgs.lJ(1, this.GcB.computeSize());
        this.GcB.writeFields(paramVarArgs);
      }
      if (this.uqf != null) {
        paramVarArgs.d(2, this.uqf);
      }
      if (this.GvK != null) {
        paramVarArgs.d(3, this.GvK);
      }
      paramVarArgs.aS(4, this.uqI);
      if (this.nIJ != null) {
        paramVarArgs.d(5, this.nIJ);
      }
      if (this.GvL != null) {
        paramVarArgs.d(6, this.GvL);
      }
      paramVarArgs.aS(7, this.GvM);
      if (this.GvN != null) {
        paramVarArgs.d(8, this.GvN);
      }
      AppMethodBeat.o(117866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcB == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.a.lI(1, this.GcB.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqf);
      }
      i = paramInt;
      if (this.GvK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GvK);
      }
      i += f.a.a.b.b.a.bz(4, this.uqI);
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.nIJ);
      }
      i = paramInt;
      if (this.GvL != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GvL);
      }
      i += f.a.a.b.b.a.bz(7, this.GvM);
      paramInt = i;
      if (this.GvN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GvN);
      }
      AppMethodBeat.o(117866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afi localafi = (afi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117866);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cwl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafi.GcB = ((cwl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117866);
          return 0;
        case 2: 
          localafi.uqf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 3: 
          localafi.GvK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 4: 
          localafi.uqI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117866);
          return 0;
        case 5: 
          localafi.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 6: 
          localafi.GvL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 7: 
          localafi.GvM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117866);
          return 0;
        }
        localafi.GvN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117866);
        return 0;
      }
      AppMethodBeat.o(117866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afi
 * JD-Core Version:    0.7.0.1
 */