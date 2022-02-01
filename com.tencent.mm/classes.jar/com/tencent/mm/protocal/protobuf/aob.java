package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aob
  extends cvw
{
  public alw GEg;
  public b lastBuffer;
  public b likeBuffer;
  public String objectNonceId;
  public long rRn;
  public String sbR;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189341);
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
      if (this.sbR != null) {
        paramVarArgs.d(3, this.sbR);
      }
      paramVarArgs.aS(4, this.scene);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.aZ(6, this.rRn);
      if (this.objectNonceId != null) {
        paramVarArgs.d(7, this.objectNonceId);
      }
      if (this.likeBuffer != null) {
        paramVarArgs.c(8, this.likeBuffer);
      }
      AppMethodBeat.o(189341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GEg != null) {
        paramInt = i + f.a.a.a.lI(2, this.GEg.computeSize());
      }
      i = paramInt;
      if (this.sbR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sbR);
      }
      i += f.a.a.b.b.a.bz(4, this.scene);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.rRn);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.objectNonceId);
      }
      i = paramInt;
      if (this.likeBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.likeBuffer);
      }
      AppMethodBeat.o(189341);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aob localaob = (aob)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189341);
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
            localaob.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189341);
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
            localaob.GEg = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189341);
          return 0;
        case 3: 
          localaob.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189341);
          return 0;
        case 4: 
          localaob.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189341);
          return 0;
        case 5: 
          localaob.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(189341);
          return 0;
        case 6: 
          localaob.rRn = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(189341);
          return 0;
        case 7: 
          localaob.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189341);
          return 0;
        }
        localaob.likeBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(189341);
        return 0;
      }
      AppMethodBeat.o(189341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aob
 * JD-Core Version:    0.7.0.1
 */