package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aoj
  extends cvw
{
  public String GDP;
  public alw GDR;
  public long GFO;
  public b lastBuffer;
  public String rRD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.GFO);
      if (this.GDP != null) {
        paramVarArgs.d(3, this.GDP);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(5, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      if (this.rRD != null) {
        paramVarArgs.d(6, this.rRD);
      }
      AppMethodBeat.o(168985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GFO);
      paramInt = i;
      if (this.GDP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GDP);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = i;
      if (this.GDR != null) {
        paramInt = i + f.a.a.a.lI(5, this.GDR.computeSize());
      }
      i = paramInt;
      if (this.rRD != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.rRD);
      }
      AppMethodBeat.o(168985);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoj localaoj = (aoj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168985);
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
            localaoj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        case 2: 
          localaoj.GFO = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168985);
          return 0;
        case 3: 
          localaoj.GDP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168985);
          return 0;
        case 4: 
          localaoj.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168985);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        }
        localaoj.rRD = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(168985);
        return 0;
      }
      AppMethodBeat.o(168985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoj
 * JD-Core Version:    0.7.0.1
 */