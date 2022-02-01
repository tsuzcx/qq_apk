package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cff
  extends cvw
{
  public String FVJ;
  public String HrR;
  public int dDd;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FVJ != null) {
        paramVarArgs.d(2, this.FVJ);
      }
      if (this.HrR != null) {
        paramVarArgs.d(3, this.HrR);
      }
      paramVarArgs.aS(4, this.dDd);
      if (this.token != null) {
        paramVarArgs.d(5, this.token);
      }
      AppMethodBeat.o(72528);
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
      if (this.FVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FVJ);
      }
      i = paramInt;
      if (this.HrR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HrR);
      }
      i += f.a.a.b.b.a.bz(4, this.dDd);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.token);
      }
      AppMethodBeat.o(72528);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72528);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cff localcff = (cff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72528);
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
            localcff.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72528);
          return 0;
        case 2: 
          localcff.FVJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72528);
          return 0;
        case 3: 
          localcff.HrR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72528);
          return 0;
        case 4: 
          localcff.dDd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72528);
          return 0;
        }
        localcff.token = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72528);
        return 0;
      }
      AppMethodBeat.o(72528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cff
 * JD-Core Version:    0.7.0.1
 */