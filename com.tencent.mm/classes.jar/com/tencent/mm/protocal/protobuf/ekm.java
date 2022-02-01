package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekm
  extends cvw
{
  public String FSe;
  public String Inz;
  public String qkN;
  public int uqt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152731);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.qkN != null) {
        paramVarArgs.d(2, this.qkN);
      }
      if (this.FSe != null) {
        paramVarArgs.d(3, this.FSe);
      }
      if (this.Inz != null) {
        paramVarArgs.d(4, this.Inz);
      }
      paramVarArgs.aS(5, this.uqt);
      AppMethodBeat.o(152731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qkN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qkN);
      }
      i = paramInt;
      if (this.FSe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FSe);
      }
      paramInt = i;
      if (this.Inz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Inz);
      }
      i = f.a.a.b.b.a.bz(5, this.uqt);
      AppMethodBeat.o(152731);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ekm localekm = (ekm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152731);
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
            localekm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152731);
          return 0;
        case 2: 
          localekm.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 3: 
          localekm.FSe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 4: 
          localekm.Inz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152731);
          return 0;
        }
        localekm.uqt = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152731);
        return 0;
      }
      AppMethodBeat.o(152731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekm
 * JD-Core Version:    0.7.0.1
 */