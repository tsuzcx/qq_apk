package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anh
  extends cvw
{
  public alw GDR;
  public int GFm;
  public int GFn;
  public long id;
  public String objectNonceId;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.id);
      paramVarArgs.aS(3, this.GFm);
      paramVarArgs.aS(4, this.GFn);
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(6, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(7, this.sessionBuffer);
      }
      AppMethodBeat.o(168960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.id) + f.a.a.b.b.a.bz(3, this.GFm) + f.a.a.b.b.a.bz(4, this.GFn);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      i = paramInt;
      if (this.GDR != null) {
        i = paramInt + f.a.a.a.lI(6, this.GDR.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sessionBuffer);
      }
      AppMethodBeat.o(168960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168960);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anh localanh = (anh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168960);
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
            localanh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168960);
          return 0;
        case 2: 
          localanh.id = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168960);
          return 0;
        case 3: 
          localanh.GFm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168960);
          return 0;
        case 4: 
          localanh.GFn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168960);
          return 0;
        case 5: 
          localanh.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168960);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanh.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168960);
          return 0;
        }
        localanh.sessionBuffer = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(168960);
        return 0;
      }
      AppMethodBeat.o(168960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anh
 * JD-Core Version:    0.7.0.1
 */