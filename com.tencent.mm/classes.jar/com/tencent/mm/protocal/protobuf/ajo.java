package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajo
  extends cvw
{
  public long GyV;
  public String GyW;
  public String Gzd;
  public int doj;
  public String dwb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104365);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.GyV);
      if (this.Gzd != null) {
        paramVarArgs.d(3, this.Gzd);
      }
      if (this.dwb != null) {
        paramVarArgs.d(4, this.dwb);
      }
      if (this.GyW != null) {
        paramVarArgs.d(5, this.GyW);
      }
      paramVarArgs.aS(6, this.doj);
      AppMethodBeat.o(104365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GyV);
      paramInt = i;
      if (this.Gzd != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gzd);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dwb);
      }
      paramInt = i;
      if (this.GyW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GyW);
      }
      i = f.a.a.b.b.a.bz(6, this.doj);
      AppMethodBeat.o(104365);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajo localajo = (ajo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104365);
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
            localajo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104365);
          return 0;
        case 2: 
          localajo.GyV = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(104365);
          return 0;
        case 3: 
          localajo.Gzd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 4: 
          localajo.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 5: 
          localajo.GyW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104365);
          return 0;
        }
        localajo.doj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104365);
        return 0;
      }
      AppMethodBeat.o(104365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajo
 * JD-Core Version:    0.7.0.1
 */