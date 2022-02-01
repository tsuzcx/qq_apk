package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class o
  extends cvw
{
  public String FIe;
  public String FIf;
  public long FIv;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91326);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FIe != null) {
        paramVarArgs.d(2, this.FIe);
      }
      paramVarArgs.aZ(3, this.FIv);
      paramVarArgs.aS(4, this.scene);
      if (this.FIf != null) {
        paramVarArgs.d(5, this.FIf);
      }
      AppMethodBeat.o(91326);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FIe != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FIe);
      }
      i = i + f.a.a.b.b.a.p(3, this.FIv) + f.a.a.b.b.a.bz(4, this.scene);
      paramInt = i;
      if (this.FIf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FIf);
      }
      AppMethodBeat.o(91326);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91326);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91326);
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
            localo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91326);
          return 0;
        case 2: 
          localo.FIe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91326);
          return 0;
        case 3: 
          localo.FIv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91326);
          return 0;
        case 4: 
          localo.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91326);
          return 0;
        }
        localo.FIf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91326);
        return 0;
      }
      AppMethodBeat.o(91326);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.o
 * JD-Core Version:    0.7.0.1
 */