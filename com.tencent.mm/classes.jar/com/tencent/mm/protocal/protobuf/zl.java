package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zl
  extends cvw
{
  public String CPZ;
  public String Gro;
  public int uIM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91420);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gro != null) {
        paramVarArgs.d(2, this.Gro);
      }
      paramVarArgs.aS(3, this.uIM);
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(91420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gro != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gro);
      }
      i += f.a.a.b.b.a.bz(3, this.uIM);
      paramInt = i;
      if (this.CPZ != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(91420);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zl localzl = (zl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91420);
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
            localzl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91420);
          return 0;
        case 2: 
          localzl.Gro = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91420);
          return 0;
        case 3: 
          localzl.uIM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91420);
          return 0;
        }
        localzl.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91420);
        return 0;
      }
      AppMethodBeat.o(91420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zl
 * JD-Core Version:    0.7.0.1
 */