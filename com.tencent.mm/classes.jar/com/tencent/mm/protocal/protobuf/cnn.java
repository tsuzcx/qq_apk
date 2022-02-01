package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnn
  extends cvw
{
  public String HzA;
  public String HzB;
  public String HzC;
  public String HzD;
  public String HzE;
  public int HzF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HzA != null) {
        paramVarArgs.d(2, this.HzA);
      }
      if (this.HzB != null) {
        paramVarArgs.d(3, this.HzB);
      }
      if (this.HzC != null) {
        paramVarArgs.d(4, this.HzC);
      }
      if (this.HzD != null) {
        paramVarArgs.d(5, this.HzD);
      }
      if (this.HzE != null) {
        paramVarArgs.d(6, this.HzE);
      }
      paramVarArgs.aS(7, this.HzF);
      AppMethodBeat.o(32374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label671;
      }
    }
    label671:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HzA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HzA);
      }
      i = paramInt;
      if (this.HzB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HzB);
      }
      paramInt = i;
      if (this.HzC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HzC);
      }
      i = paramInt;
      if (this.HzD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HzD);
      }
      paramInt = i;
      if (this.HzE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HzE);
      }
      i = f.a.a.b.b.a.bz(7, this.HzF);
      AppMethodBeat.o(32374);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnn localcnn = (cnn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32374);
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
            localcnn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32374);
          return 0;
        case 2: 
          localcnn.HzA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 3: 
          localcnn.HzB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 4: 
          localcnn.HzC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 5: 
          localcnn.HzD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 6: 
          localcnn.HzE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32374);
          return 0;
        }
        localcnn.HzF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32374);
        return 0;
      }
      AppMethodBeat.o(32374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnn
 * JD-Core Version:    0.7.0.1
 */