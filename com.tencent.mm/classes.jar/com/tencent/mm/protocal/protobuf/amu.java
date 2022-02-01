package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amu
  extends cvw
{
  public alw GDR;
  public String GEX;
  public long id;
  public String objectNonceId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.id);
      if (this.GEX != null) {
        paramVarArgs.d(3, this.GEX);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(4, this.objectNonceId);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(5, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.id);
      paramInt = i;
      if (this.GEX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GEX);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.objectNonceId);
      }
      paramInt = i;
      if (this.GDR != null) {
        paramInt = i + f.a.a.a.lI(5, this.GDR.computeSize());
      }
      AppMethodBeat.o(168950);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amu localamu = (amu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168950);
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
            localamu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168950);
          return 0;
        case 2: 
          localamu.id = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168950);
          return 0;
        case 3: 
          localamu.GEX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168950);
          return 0;
        case 4: 
          localamu.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168950);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamu.GDR = ((alw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168950);
        return 0;
      }
      AppMethodBeat.o(168950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amu
 * JD-Core Version:    0.7.0.1
 */