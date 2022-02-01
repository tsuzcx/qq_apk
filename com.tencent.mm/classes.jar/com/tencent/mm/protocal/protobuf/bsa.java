package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bsa
  extends cvw
{
  public int GuE;
  public int HeQ;
  public int HeR;
  public eio HeS;
  public String Hff;
  public String ikm;
  public b nIq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.nIq != null) {
        paramVarArgs.c(3, this.nIq);
      }
      if (this.Hff != null) {
        paramVarArgs.d(4, this.Hff);
      }
      paramVarArgs.aS(5, this.HeQ);
      paramVarArgs.aS(6, this.HeR);
      if (this.HeS != null)
      {
        paramVarArgs.lJ(7, this.HeS.computeSize());
        this.HeS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.GuE);
      AppMethodBeat.o(123618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.nIq != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.nIq);
      }
      paramInt = i;
      if (this.Hff != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hff);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HeQ) + f.a.a.b.b.a.bz(6, this.HeR);
      paramInt = i;
      if (this.HeS != null) {
        paramInt = i + f.a.a.a.lI(7, this.HeS.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.GuE);
      AppMethodBeat.o(123618);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsa localbsa = (bsa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123618);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsa.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        case 2: 
          localbsa.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 3: 
          localbsa.nIq = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(123618);
          return 0;
        case 4: 
          localbsa.Hff = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 5: 
          localbsa.HeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123618);
          return 0;
        case 6: 
          localbsa.HeR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123618);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsa.HeS = ((eio)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        }
        localbsa.GuE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123618);
        return 0;
      }
      AppMethodBeat.o(123618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsa
 * JD-Core Version:    0.7.0.1
 */