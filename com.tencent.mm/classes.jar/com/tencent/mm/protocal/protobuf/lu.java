package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lu
  extends cvw
{
  public String FWT;
  public String FWU;
  public long FWV;
  public String mac;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FWT != null) {
        paramVarArgs.d(2, this.FWT);
      }
      if (this.FWU != null) {
        paramVarArgs.d(3, this.FWU);
      }
      if (this.mac != null) {
        paramVarArgs.d(4, this.mac);
      }
      paramVarArgs.aZ(5, this.FWV);
      AppMethodBeat.o(82394);
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
      if (this.FWT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FWT);
      }
      i = paramInt;
      if (this.FWU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FWU);
      }
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mac);
      }
      i = f.a.a.b.b.a.p(5, this.FWV);
      AppMethodBeat.o(82394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lu locallu = (lu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82394);
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
            locallu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82394);
          return 0;
        case 2: 
          locallu.FWT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 3: 
          locallu.FWU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 4: 
          locallu.mac = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82394);
          return 0;
        }
        locallu.FWV = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(82394);
        return 0;
      }
      AppMethodBeat.o(82394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lu
 * JD-Core Version:    0.7.0.1
 */