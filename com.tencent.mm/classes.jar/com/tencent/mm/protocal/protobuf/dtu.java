package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtu
  extends cvw
{
  public boolean HZt;
  public int gvw;
  public String ikm;
  public int nJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123666);
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
      paramVarArgs.aS(3, this.nJz);
      paramVarArgs.bC(4, this.HZt);
      paramVarArgs.aS(5, this.gvw);
      AppMethodBeat.o(123666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ikm);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.nJz);
      int j = f.a.a.b.b.a.amF(4);
      int k = f.a.a.b.b.a.bz(5, this.gvw);
      AppMethodBeat.o(123666);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtu localdtu = (dtu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123666);
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
            localdtu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123666);
          return 0;
        case 2: 
          localdtu.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123666);
          return 0;
        case 3: 
          localdtu.nJz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123666);
          return 0;
        case 4: 
          localdtu.HZt = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123666);
          return 0;
        }
        localdtu.gvw = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123666);
        return 0;
      }
      AppMethodBeat.o(123666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtu
 * JD-Core Version:    0.7.0.1
 */