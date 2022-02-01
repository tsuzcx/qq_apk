package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bve
  extends cvw
{
  public int HhT;
  public LinkedList<cxn> HhU;
  public int HhV;
  public LinkedList<cxn> HhW;
  public String xrf;
  
  public bve()
  {
    AppMethodBeat.i(155434);
    this.HhU = new LinkedList();
    this.HhW = new LinkedList();
    AppMethodBeat.o(155434);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xrf != null) {
        paramVarArgs.d(2, this.xrf);
      }
      paramVarArgs.aS(3, this.HhT);
      paramVarArgs.e(4, 8, this.HhU);
      paramVarArgs.aS(5, this.HhV);
      paramVarArgs.e(6, 8, this.HhW);
      AppMethodBeat.o(155435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xrf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xrf);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HhT);
      int j = f.a.a.a.c(4, 8, this.HhU);
      int k = f.a.a.b.b.a.bz(5, this.HhV);
      int m = f.a.a.a.c(6, 8, this.HhW);
      AppMethodBeat.o(155435);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HhU.clear();
        this.HhW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bve localbve = (bve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155435);
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
            localbve.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 2: 
          localbve.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155435);
          return 0;
        case 3: 
          localbve.HhT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155435);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbve.HhU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 5: 
          localbve.HhV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155435);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbve.HhW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      AppMethodBeat.o(155435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bve
 * JD-Core Version:    0.7.0.1
 */