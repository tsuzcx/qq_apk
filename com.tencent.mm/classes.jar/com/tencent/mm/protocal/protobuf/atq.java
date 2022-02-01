package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atq
  extends cvw
{
  public String FWe;
  public String GKA;
  public String GKy;
  public String GKz;
  public String wTF;
  public String xrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GKy != null) {
        paramVarArgs.d(2, this.GKy);
      }
      if (this.FWe != null) {
        paramVarArgs.d(3, this.FWe);
      }
      if (this.wTF != null) {
        paramVarArgs.d(4, this.wTF);
      }
      if (this.GKz != null) {
        paramVarArgs.d(5, this.GKz);
      }
      if (this.GKA != null) {
        paramVarArgs.d(6, this.GKA);
      }
      if (this.xrf != null) {
        paramVarArgs.d(7, this.xrf);
      }
      AppMethodBeat.o(91466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GKy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GKy);
      }
      i = paramInt;
      if (this.FWe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FWe);
      }
      paramInt = i;
      if (this.wTF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wTF);
      }
      i = paramInt;
      if (this.GKz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GKz);
      }
      paramInt = i;
      if (this.GKA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKA);
      }
      i = paramInt;
      if (this.xrf != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.xrf);
      }
      AppMethodBeat.o(91466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atq localatq = (atq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91466);
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
            localatq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91466);
          return 0;
        case 2: 
          localatq.GKy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 3: 
          localatq.FWe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 4: 
          localatq.wTF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 5: 
          localatq.GKz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 6: 
          localatq.GKA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91466);
          return 0;
        }
        localatq.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91466);
        return 0;
      }
      AppMethodBeat.o(91466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atq
 * JD-Core Version:    0.7.0.1
 */