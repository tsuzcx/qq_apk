package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnl
  extends cvw
{
  public int Gxq;
  public long Gxr;
  public long Hzw;
  public int Hzx;
  public String Hzy;
  public long Hzz;
  public String uvF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32372);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      if (this.uvF != null) {
        paramVarArgs.d(4, this.uvF);
      }
      paramVarArgs.aZ(5, this.Hzw);
      paramVarArgs.aS(6, this.Hzx);
      if (this.Hzy != null) {
        paramVarArgs.d(7, this.Hzy);
      }
      paramVarArgs.aZ(8, this.Hzz);
      AppMethodBeat.o(32372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gxq) + f.a.a.b.b.a.p(3, this.Gxr);
      paramInt = i;
      if (this.uvF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uvF);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.Hzw) + f.a.a.b.b.a.bz(6, this.Hzx);
      paramInt = i;
      if (this.Hzy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hzy);
      }
      i = f.a.a.b.b.a.p(8, this.Hzz);
      AppMethodBeat.o(32372);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32372);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnl localcnl = (cnl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32372);
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
            localcnl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32372);
          return 0;
        case 2: 
          localcnl.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32372);
          return 0;
        case 3: 
          localcnl.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32372);
          return 0;
        case 4: 
          localcnl.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32372);
          return 0;
        case 5: 
          localcnl.Hzw = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32372);
          return 0;
        case 6: 
          localcnl.Hzx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32372);
          return 0;
        case 7: 
          localcnl.Hzy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32372);
          return 0;
        }
        localcnl.Hzz = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(32372);
        return 0;
      }
      AppMethodBeat.o(32372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnl
 * JD-Core Version:    0.7.0.1
 */