package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cny
  extends cvw
{
  public int Gxq;
  public long Gxr;
  public long Hzw;
  public long Hzz;
  public int nJb;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32388);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uvG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32388);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uvG != null) {
        paramVarArgs.d(2, this.uvG);
      }
      paramVarArgs.aS(3, this.Gxq);
      paramVarArgs.aZ(4, this.Gxr);
      paramVarArgs.aZ(5, this.Hzw);
      paramVarArgs.aZ(6, this.Hzz);
      paramVarArgs.aS(7, this.nJb);
      AppMethodBeat.o(32388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label667;
      }
    }
    label667:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uvG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uvG);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Gxq);
      int j = f.a.a.b.b.a.p(4, this.Gxr);
      int k = f.a.a.b.b.a.p(5, this.Hzw);
      int m = f.a.a.b.b.a.p(6, this.Hzz);
      int n = f.a.a.b.b.a.bz(7, this.nJb);
      AppMethodBeat.o(32388);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uvG == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(32388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32388);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cny localcny = (cny)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32388);
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
            localcny.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32388);
          return 0;
        case 2: 
          localcny.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32388);
          return 0;
        case 3: 
          localcny.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32388);
          return 0;
        case 4: 
          localcny.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32388);
          return 0;
        case 5: 
          localcny.Hzw = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32388);
          return 0;
        case 6: 
          localcny.Hzz = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32388);
          return 0;
        }
        localcny.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32388);
        return 0;
      }
      AppMethodBeat.o(32388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cny
 * JD-Core Version:    0.7.0.1
 */