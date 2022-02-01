package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class oj
  extends cvw
{
  public long FUP;
  public String FZa;
  public b GbW;
  public int GbY;
  public int GbZ;
  public int Gca;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124443);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FZa != null) {
        paramVarArgs.d(2, this.FZa);
      }
      paramVarArgs.aS(3, this.GbY);
      if (this.GbW != null) {
        paramVarArgs.c(4, this.GbW);
      }
      paramVarArgs.aS(5, this.GbZ);
      paramVarArgs.aZ(6, this.FUP);
      paramVarArgs.aS(7, this.Gca);
      paramVarArgs.aS(8, this.Scene);
      AppMethodBeat.o(124443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FZa != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FZa);
      }
      i += f.a.a.b.b.a.bz(3, this.GbY);
      paramInt = i;
      if (this.GbW != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GbW);
      }
      i = f.a.a.b.b.a.bz(5, this.GbZ);
      int j = f.a.a.b.b.a.p(6, this.FUP);
      int k = f.a.a.b.b.a.bz(7, this.Gca);
      int m = f.a.a.b.b.a.bz(8, this.Scene);
      AppMethodBeat.o(124443);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oj localoj = (oj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124443);
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
            localoj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124443);
          return 0;
        case 2: 
          localoj.FZa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124443);
          return 0;
        case 3: 
          localoj.GbY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124443);
          return 0;
        case 4: 
          localoj.GbW = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(124443);
          return 0;
        case 5: 
          localoj.GbZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124443);
          return 0;
        case 6: 
          localoj.FUP = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124443);
          return 0;
        case 7: 
          localoj.Gca = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124443);
          return 0;
        }
        localoj.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124443);
        return 0;
      }
      AppMethodBeat.o(124443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oj
 * JD-Core Version:    0.7.0.1
 */