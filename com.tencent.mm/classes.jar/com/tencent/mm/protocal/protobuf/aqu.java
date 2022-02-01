package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aqu
  extends cvw
{
  public alw GDR;
  public b lastBuffer;
  public long refObjectId;
  public String refObjectNonceId;
  public String sbR;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169032);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aZ(3, this.refObjectId);
      if (this.sbR != null) {
        paramVarArgs.d(4, this.sbR);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(7, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169032);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i += f.a.a.b.b.a.p(3, this.refObjectId);
      paramInt = i;
      if (this.sbR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sbR);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.lastBuffer);
      }
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.GDR != null) {
        i = paramInt + f.a.a.a.lI(7, this.GDR.computeSize());
      }
      AppMethodBeat.o(169032);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169032);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqu localaqu = (aqu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169032);
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
            localaqu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169032);
          return 0;
        case 2: 
          localaqu.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169032);
          return 0;
        case 3: 
          localaqu.refObjectId = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169032);
          return 0;
        case 4: 
          localaqu.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169032);
          return 0;
        case 5: 
          localaqu.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(169032);
          return 0;
        case 6: 
          localaqu.refObjectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169032);
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
          localaqu.GDR = ((alw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169032);
        return 0;
      }
      AppMethodBeat.o(169032);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqu
 * JD-Core Version:    0.7.0.1
 */