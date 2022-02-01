package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmw
  extends cvw
{
  public int FNw;
  public int GbY;
  public int Gxq;
  public long Gxr;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32462);
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
      paramVarArgs.aS(4, this.GbY);
      paramVarArgs.aS(5, this.FNw);
      paramVarArgs.aS(6, this.Scene);
      AppMethodBeat.o(32462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gxq);
      int j = f.a.a.b.b.a.p(3, this.Gxr);
      int k = f.a.a.b.b.a.bz(4, this.GbY);
      int m = f.a.a.b.b.a.bz(5, this.FNw);
      int n = f.a.a.b.b.a.bz(6, this.Scene);
      AppMethodBeat.o(32462);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32462);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmw localdmw = (dmw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32462);
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
            localdmw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32462);
          return 0;
        case 2: 
          localdmw.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32462);
          return 0;
        case 3: 
          localdmw.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32462);
          return 0;
        case 4: 
          localdmw.GbY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32462);
          return 0;
        case 5: 
          localdmw.FNw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32462);
          return 0;
        }
        localdmw.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32462);
        return 0;
      }
      AppMethodBeat.o(32462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmw
 * JD-Core Version:    0.7.0.1
 */