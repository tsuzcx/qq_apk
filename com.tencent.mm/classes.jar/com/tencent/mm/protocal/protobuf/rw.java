package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class rw
  extends cvw
{
  public b Ggt;
  public b Ggu;
  public int Ggv;
  public int Ggw;
  public int Ggx;
  public int iqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217516);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ggt != null) {
        paramVarArgs.c(2, this.Ggt);
      }
      paramVarArgs.aS(3, this.iqb);
      if (this.Ggu != null) {
        paramVarArgs.c(4, this.Ggu);
      }
      paramVarArgs.aS(5, this.Ggv);
      paramVarArgs.aS(6, this.Ggw);
      paramVarArgs.aS(7, this.Ggx);
      AppMethodBeat.o(217516);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ggt != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.Ggt);
      }
      i += f.a.a.b.b.a.bz(3, this.iqb);
      paramInt = i;
      if (this.Ggu != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Ggu);
      }
      i = f.a.a.b.b.a.bz(5, this.Ggv);
      int j = f.a.a.b.b.a.bz(6, this.Ggw);
      int k = f.a.a.b.b.a.bz(7, this.Ggx);
      AppMethodBeat.o(217516);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(217516);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rw localrw = (rw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(217516);
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
            localrw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(217516);
          return 0;
        case 2: 
          localrw.Ggt = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(217516);
          return 0;
        case 3: 
          localrw.iqb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(217516);
          return 0;
        case 4: 
          localrw.Ggu = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(217516);
          return 0;
        case 5: 
          localrw.Ggv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(217516);
          return 0;
        case 6: 
          localrw.Ggw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(217516);
          return 0;
        }
        localrw.Ggx = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(217516);
        return 0;
      }
      AppMethodBeat.o(217516);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rw
 * JD-Core Version:    0.7.0.1
 */