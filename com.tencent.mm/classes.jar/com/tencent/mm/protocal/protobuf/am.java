package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends cvw
{
  public String FJN;
  public String FJO;
  public int FJP;
  public LinkedList<th> FJS;
  public int dJd;
  
  public am()
  {
    AppMethodBeat.i(113924);
    this.FJS = new LinkedList();
    AppMethodBeat.o(113924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FJS);
      paramVarArgs.aS(3, this.dJd);
      if (this.FJN != null) {
        paramVarArgs.d(4, this.FJN);
      }
      if (this.FJO != null) {
        paramVarArgs.d(5, this.FJO);
      }
      paramVarArgs.aS(6, this.FJP);
      AppMethodBeat.o(113925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FJS) + f.a.a.b.b.a.bz(3, this.dJd);
      paramInt = i;
      if (this.FJN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FJN);
      }
      i = paramInt;
      if (this.FJO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FJO);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.FJP);
      AppMethodBeat.o(113925);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113925);
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
            localam.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new th();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((th)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localam.FJS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 3: 
          localam.dJd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113925);
          return 0;
        case 4: 
          localam.FJN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113925);
          return 0;
        case 5: 
          localam.FJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113925);
          return 0;
        }
        localam.FJP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113925);
        return 0;
      }
      AppMethodBeat.o(113925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.am
 * JD-Core Version:    0.7.0.1
 */