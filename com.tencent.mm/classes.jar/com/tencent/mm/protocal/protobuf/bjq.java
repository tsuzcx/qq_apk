package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjq
  extends cvw
{
  public int GXe;
  public int uqD;
  public String usS;
  public LinkedList<cxn> utD;
  public int utT;
  public int utU;
  
  public bjq()
  {
    AppMethodBeat.i(152596);
    this.utD = new LinkedList();
    AppMethodBeat.o(152596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152597);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.uqD);
      paramVarArgs.aS(3, this.utT);
      paramVarArgs.aS(4, this.utU);
      if (this.usS != null) {
        paramVarArgs.d(5, this.usS);
      }
      paramVarArgs.aS(6, this.GXe);
      paramVarArgs.e(7, 8, this.utD);
      AppMethodBeat.o(152597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.uqD) + f.a.a.b.b.a.bz(3, this.utT) + f.a.a.b.b.a.bz(4, this.utU);
      paramInt = i;
      if (this.usS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.usS);
      }
      i = f.a.a.b.b.a.bz(6, this.GXe);
      int j = f.a.a.a.c(7, 8, this.utD);
      AppMethodBeat.o(152597);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.utD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjq localbjq = (bjq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152597);
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
            localbjq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152597);
          return 0;
        case 2: 
          localbjq.uqD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152597);
          return 0;
        case 3: 
          localbjq.utT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152597);
          return 0;
        case 4: 
          localbjq.utU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152597);
          return 0;
        case 5: 
          localbjq.usS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152597);
          return 0;
        case 6: 
          localbjq.GXe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152597);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjq.utD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      AppMethodBeat.o(152597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjq
 * JD-Core Version:    0.7.0.1
 */