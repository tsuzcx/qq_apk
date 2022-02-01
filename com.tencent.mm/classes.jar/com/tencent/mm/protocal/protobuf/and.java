package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class and
  extends cvw
{
  public alw GEg;
  public int dGO;
  public String objectNonceId;
  public long rAG;
  public long rRn;
  public String sbR;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189326);
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
      paramVarArgs.aZ(3, this.rRn);
      paramVarArgs.aS(4, this.dGO);
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      paramVarArgs.aZ(6, this.rAG);
      if (this.sbR != null) {
        paramVarArgs.d(7, this.sbR);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(8, this.sessionBuffer);
      }
      AppMethodBeat.o(189326);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GEg != null) {
        i = paramInt + f.a.a.a.lI(2, this.GEg.computeSize());
      }
      i = i + f.a.a.b.b.a.p(3, this.rRn) + f.a.a.b.b.a.bz(4, this.dGO);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.rAG);
      paramInt = i;
      if (this.sbR != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sbR);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sessionBuffer);
      }
      AppMethodBeat.o(189326);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189326);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        and localand = (and)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189326);
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
            localand.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189326);
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
            localand.GEg = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189326);
          return 0;
        case 3: 
          localand.rRn = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(189326);
          return 0;
        case 4: 
          localand.dGO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189326);
          return 0;
        case 5: 
          localand.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189326);
          return 0;
        case 6: 
          localand.rAG = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(189326);
          return 0;
        case 7: 
          localand.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189326);
          return 0;
        }
        localand.sessionBuffer = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189326);
        return 0;
      }
      AppMethodBeat.o(189326);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.and
 * JD-Core Version:    0.7.0.1
 */