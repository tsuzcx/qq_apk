package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bai
  extends cvw
{
  public LinkedList<cxn> FNk;
  public int GQn;
  public int GQo;
  public LinkedList<cxn> GQp;
  public int GQq;
  public LinkedList<cxn> GQr;
  public int GQs;
  public cxn GQt;
  
  public bai()
  {
    AppMethodBeat.i(32232);
    this.FNk = new LinkedList();
    this.GQp = new LinkedList();
    this.GQr = new LinkedList();
    AppMethodBeat.o(32232);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32233);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GQn);
      paramVarArgs.e(3, 8, this.FNk);
      paramVarArgs.aS(4, this.GQo);
      paramVarArgs.e(5, 8, this.GQp);
      paramVarArgs.aS(6, this.GQq);
      paramVarArgs.e(7, 8, this.GQr);
      paramVarArgs.aS(8, this.GQs);
      if (this.GQt != null)
      {
        paramVarArgs.lJ(9, this.GQt.computeSize());
        this.GQt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32233);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1069;
      }
    }
    label1069:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GQn) + f.a.a.a.c(3, 8, this.FNk) + f.a.a.b.b.a.bz(4, this.GQo) + f.a.a.a.c(5, 8, this.GQp) + f.a.a.b.b.a.bz(6, this.GQq) + f.a.a.a.c(7, 8, this.GQr) + f.a.a.b.b.a.bz(8, this.GQs);
      paramInt = i;
      if (this.GQt != null) {
        paramInt = i + f.a.a.a.lI(9, this.GQt.computeSize());
      }
      AppMethodBeat.o(32233);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNk.clear();
        this.GQp.clear();
        this.GQr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32233);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bai localbai = (bai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32233);
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
            localbai.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 2: 
          localbai.GQn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32233);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbai.FNk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 4: 
          localbai.GQo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32233);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbai.GQp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 6: 
          localbai.GQq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32233);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbai.GQr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 8: 
          localbai.GQs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32233);
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
          localbai.GQt = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32233);
        return 0;
      }
      AppMethodBeat.o(32233);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bai
 * JD-Core Version:    0.7.0.1
 */