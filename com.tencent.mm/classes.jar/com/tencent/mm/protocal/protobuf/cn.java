package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cn
  extends cvw
{
  public int FJf;
  public String FJg;
  public String FNs;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32106);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FNs != null) {
        paramVarArgs.d(2, this.FNs);
      }
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aS(4, this.FJf);
      if (this.FJg != null) {
        paramVarArgs.d(5, this.FJg);
      }
      AppMethodBeat.o(32106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label545;
      }
    }
    label545:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FNs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FNs);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Url);
      }
      i += f.a.a.b.b.a.bz(4, this.FJf);
      paramInt = i;
      if (this.FJg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FJg);
      }
      AppMethodBeat.o(32106);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cn localcn = (cn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32106);
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
            localcn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32106);
          return 0;
        case 2: 
          localcn.FNs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32106);
          return 0;
        case 3: 
          localcn.Url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32106);
          return 0;
        case 4: 
          localcn.FJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32106);
          return 0;
        }
        localcn.FJg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32106);
        return 0;
      }
      AppMethodBeat.o(32106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cn
 * JD-Core Version:    0.7.0.1
 */