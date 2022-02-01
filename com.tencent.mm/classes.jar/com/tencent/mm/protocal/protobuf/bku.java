package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bku
  extends cvw
{
  public boolean GYf;
  public String GYg;
  public String hDm;
  public String qsG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32281);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qsG == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32281);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.GYf);
      if (this.hDm != null) {
        paramVarArgs.d(3, this.hDm);
      }
      if (this.qsG != null) {
        paramVarArgs.d(4, this.qsG);
      }
      if (this.GYg != null) {
        paramVarArgs.d(5, this.GYg);
      }
      AppMethodBeat.o(32281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label593;
      }
    }
    label593:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2);
      paramInt = i;
      if (this.hDm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.hDm);
      }
      i = paramInt;
      if (this.qsG != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.qsG);
      }
      paramInt = i;
      if (this.GYg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GYg);
      }
      AppMethodBeat.o(32281);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.qsG == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32281);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bku localbku = (bku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32281);
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
            localbku.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32281);
          return 0;
        case 2: 
          localbku.GYf = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(32281);
          return 0;
        case 3: 
          localbku.hDm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32281);
          return 0;
        case 4: 
          localbku.qsG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32281);
          return 0;
        }
        localbku.GYg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32281);
        return 0;
      }
      AppMethodBeat.o(32281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bku
 * JD-Core Version:    0.7.0.1
 */