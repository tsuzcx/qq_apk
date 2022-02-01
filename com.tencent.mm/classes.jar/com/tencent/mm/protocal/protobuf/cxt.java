package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxt
  extends cvw
{
  public int FMa;
  public String GXS;
  public int doj;
  public String dwb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147776);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      if (this.GXS != null) {
        paramVarArgs.d(3, this.GXS);
      }
      paramVarArgs.aS(4, this.doj);
      paramVarArgs.aS(5, this.FMa);
      AppMethodBeat.o(147776);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = paramInt;
      if (this.GXS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GXS);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.doj);
      int j = f.a.a.b.b.a.bz(5, this.FMa);
      AppMethodBeat.o(147776);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147776);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxt localcxt = (cxt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147776);
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
            localcxt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147776);
          return 0;
        case 2: 
          localcxt.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147776);
          return 0;
        case 3: 
          localcxt.GXS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147776);
          return 0;
        case 4: 
          localcxt.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147776);
          return 0;
        }
        localcxt.FMa = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(147776);
        return 0;
      }
      AppMethodBeat.o(147776);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxt
 * JD-Core Version:    0.7.0.1
 */