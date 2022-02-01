package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmv
  extends cvw
{
  public String HyQ;
  public String HyR;
  public int HyS;
  public String ProductID;
  public String uvT;
  public int wTg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91630);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(2, this.ProductID);
      }
      if (this.HyQ != null) {
        paramVarArgs.d(3, this.HyQ);
      }
      if (this.HyR != null) {
        paramVarArgs.d(4, this.HyR);
      }
      paramVarArgs.aS(5, this.wTg);
      if (this.uvT != null) {
        paramVarArgs.d(7, this.uvT);
      }
      paramVarArgs.aS(8, this.HyS);
      AppMethodBeat.o(91630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ProductID);
      }
      i = paramInt;
      if (this.HyQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HyQ);
      }
      paramInt = i;
      if (this.HyR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HyR);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.wTg);
      paramInt = i;
      if (this.uvT != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uvT);
      }
      i = f.a.a.b.b.a.bz(8, this.HyS);
      AppMethodBeat.o(91630);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91630);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmv localcmv = (cmv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91630);
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
            localcmv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91630);
          return 0;
        case 2: 
          localcmv.ProductID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 3: 
          localcmv.HyQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 4: 
          localcmv.HyR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 5: 
          localcmv.wTg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91630);
          return 0;
        case 7: 
          localcmv.uvT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91630);
          return 0;
        }
        localcmv.HyS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91630);
        return 0;
      }
      AppMethodBeat.o(91630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmv
 * JD-Core Version:    0.7.0.1
 */