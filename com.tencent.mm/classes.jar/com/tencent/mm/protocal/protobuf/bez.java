package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bez
  extends cvw
{
  public cxn FNG;
  public cxn FNH;
  public int GUb;
  public int xri;
  public long xrk;
  public int xsB;
  public int xsC;
  public int xsD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.FNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xri);
      if (this.FNG != null)
      {
        paramVarArgs.lJ(3, this.FNG.computeSize());
        this.FNG.writeFields(paramVarArgs);
      }
      if (this.FNH != null)
      {
        paramVarArgs.lJ(4, this.FNH.computeSize());
        this.FNH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.xsB);
      paramVarArgs.aS(6, this.xsC);
      paramVarArgs.aS(7, this.xsD);
      paramVarArgs.aS(8, this.GUb);
      paramVarArgs.aZ(9, this.xrk);
      AppMethodBeat.o(152572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xri);
      paramInt = i;
      if (this.FNG != null) {
        paramInt = i + f.a.a.a.lI(3, this.FNG.computeSize());
      }
      i = paramInt;
      if (this.FNH != null) {
        i = paramInt + f.a.a.a.lI(4, this.FNH.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(5, this.xsB);
      int j = f.a.a.b.b.a.bz(6, this.xsC);
      int k = f.a.a.b.b.a.bz(7, this.xsD);
      int m = f.a.a.b.b.a.bz(8, this.GUb);
      int n = f.a.a.b.b.a.p(9, this.xrk);
      AppMethodBeat.o(152572);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FNG == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        if (this.FNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bez localbez = (bez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152572);
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
            localbez.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 2: 
          localbez.xri = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152572);
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
            localbez.FNG = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
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
            localbez.FNH = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 5: 
          localbez.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152572);
          return 0;
        case 6: 
          localbez.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152572);
          return 0;
        case 7: 
          localbez.xsD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152572);
          return 0;
        case 8: 
          localbez.GUb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152572);
          return 0;
        }
        localbez.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(152572);
        return 0;
      }
      AppMethodBeat.o(152572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bez
 * JD-Core Version:    0.7.0.1
 */