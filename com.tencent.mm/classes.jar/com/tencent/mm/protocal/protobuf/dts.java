package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dts
  extends cvw
{
  public cxn HZn;
  public cxn HZo;
  public int HZp;
  public int HZq;
  public int HZr;
  public int HZs;
  public int udg;
  public int xsB;
  public int xsC;
  public int xsD;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HZn == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientMediaId");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.HZo == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataMD5");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HZn != null)
      {
        paramVarArgs.lJ(2, this.HZn.computeSize());
        this.HZn.writeFields(paramVarArgs);
      }
      if (this.HZo != null)
      {
        paramVarArgs.lJ(3, this.HZo.computeSize());
        this.HZo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.xsB);
      paramVarArgs.aS(5, this.xsC);
      paramVarArgs.aS(6, this.xsD);
      if (this.xsE != null)
      {
        paramVarArgs.lJ(7, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.udg);
      paramVarArgs.aS(9, this.HZp);
      paramVarArgs.aS(10, this.HZq);
      paramVarArgs.aS(11, this.HZr);
      paramVarArgs.aS(12, this.HZs);
      AppMethodBeat.o(148659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1286;
      }
    }
    label1286:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HZn != null) {
        paramInt = i + f.a.a.a.lI(2, this.HZn.computeSize());
      }
      i = paramInt;
      if (this.HZo != null) {
        i = paramInt + f.a.a.a.lI(3, this.HZo.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(4, this.xsB) + f.a.a.b.b.a.bz(5, this.xsC) + f.a.a.b.b.a.bz(6, this.xsD);
      paramInt = i;
      if (this.xsE != null) {
        paramInt = i + f.a.a.a.lI(7, this.xsE.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.udg);
      int j = f.a.a.b.b.a.bz(9, this.HZp);
      int k = f.a.a.b.b.a.bz(10, this.HZq);
      int m = f.a.a.b.b.a.bz(11, this.HZr);
      int n = f.a.a.b.b.a.bz(12, this.HZs);
      AppMethodBeat.o(148659);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HZn == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientMediaId");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.HZo == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataMD5");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.xsE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dts localdts = (dts)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148659);
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
            localdts.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdts.HZn = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
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
            localdts.HZo = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 4: 
          localdts.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 5: 
          localdts.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 6: 
          localdts.xsD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdts.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 8: 
          localdts.udg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 9: 
          localdts.HZp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 10: 
          localdts.HZq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 11: 
          localdts.HZr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148659);
          return 0;
        }
        localdts.HZs = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148659);
        return 0;
      }
      AppMethodBeat.o(148659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dts
 * JD-Core Version:    0.7.0.1
 */