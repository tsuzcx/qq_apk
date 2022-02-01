package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aod
  extends cvw
{
  public alw GEg;
  public b lastBuffer;
  public String objectNonceId;
  public long rRn;
  public String rRy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189344);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GEg != null)
      {
        paramVarArgs.lJ(2, this.GEg.computeSize());
        this.GEg.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.rRy != null) {
        paramVarArgs.d(4, this.rRy);
      }
      paramVarArgs.aZ(5, this.rRn);
      if (this.objectNonceId != null) {
        paramVarArgs.d(6, this.objectNonceId);
      }
      AppMethodBeat.o(189344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GEg != null) {
        paramInt = i + f.a.a.a.lI(2, this.GEg.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      paramInt = i;
      if (this.rRy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rRy);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.rRn);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.objectNonceId);
      }
      AppMethodBeat.o(189344);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189344);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aod localaod = (aod)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189344);
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
            localaod.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189344);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaod.GEg = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189344);
          return 0;
        case 3: 
          localaod.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(189344);
          return 0;
        case 4: 
          localaod.rRy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189344);
          return 0;
        case 5: 
          localaod.rRn = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(189344);
          return 0;
        }
        localaod.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189344);
        return 0;
      }
      AppMethodBeat.o(189344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aod
 * JD-Core Version:    0.7.0.1
 */