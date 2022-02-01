package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coe
  extends cvw
{
  public int CPO;
  public String CPZ;
  public String HAb;
  public int HAc;
  public String HAd;
  public String HyB;
  public int uIM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91636);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HAb != null) {
        paramVarArgs.d(2, this.HAb);
      }
      paramVarArgs.aS(3, this.HAc);
      paramVarArgs.aS(4, this.uIM);
      if (this.HAd != null) {
        paramVarArgs.d(5, this.HAd);
      }
      if (this.HyB != null) {
        paramVarArgs.d(7, this.HyB);
      }
      paramVarArgs.aS(8, this.CPO);
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(91636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HAb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HAb);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HAc) + f.a.a.b.b.a.bz(4, this.uIM);
      paramInt = i;
      if (this.HAd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HAd);
      }
      i = paramInt;
      if (this.HyB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HyB);
      }
      i += f.a.a.b.b.a.bz(8, this.CPO);
      paramInt = i;
      if (this.CPZ != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(91636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coe localcoe = (coe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91636);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoe.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91636);
          return 0;
        case 2: 
          localcoe.HAb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 3: 
          localcoe.HAc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91636);
          return 0;
        case 4: 
          localcoe.uIM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91636);
          return 0;
        case 5: 
          localcoe.HAd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 7: 
          localcoe.HyB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 8: 
          localcoe.CPO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91636);
          return 0;
        }
        localcoe.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91636);
        return 0;
      }
      AppMethodBeat.o(91636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coe
 * JD-Core Version:    0.7.0.1
 */