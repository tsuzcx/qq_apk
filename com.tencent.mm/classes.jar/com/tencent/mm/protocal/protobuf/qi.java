package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qi
  extends cvw
{
  public dk GdN;
  public String Gee;
  public int Gew;
  public int Gex;
  public long Gey;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91376);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GdN != null)
      {
        paramVarArgs.lJ(2, this.GdN.computeSize());
        this.GdN.writeFields(paramVarArgs);
      }
      if (this.Gee != null) {
        paramVarArgs.d(3, this.Gee);
      }
      paramVarArgs.aS(4, this.Gew);
      paramVarArgs.aS(5, this.Gex);
      paramVarArgs.aZ(6, this.Gey);
      AppMethodBeat.o(91376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GdN != null) {
        paramInt = i + f.a.a.a.lI(2, this.GdN.computeSize());
      }
      i = paramInt;
      if (this.Gee != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gee);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Gew);
      int j = f.a.a.b.b.a.bz(5, this.Gex);
      int k = f.a.a.b.b.a.p(6, this.Gey);
      AppMethodBeat.o(91376);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qi localqi = (qi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91376);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqi.GdN = ((dk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 3: 
          localqi.Gee = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91376);
          return 0;
        case 4: 
          localqi.Gew = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91376);
          return 0;
        case 5: 
          localqi.Gex = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91376);
          return 0;
        }
        localqi.Gey = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91376);
        return 0;
      }
      AppMethodBeat.o(91376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qi
 * JD-Core Version:    0.7.0.1
 */