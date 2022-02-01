package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dxy
  extends cvw
{
  public int FQT;
  public int FQW;
  public int GeT;
  public String HZg;
  public int HZh;
  public int HZi;
  public int IcU;
  public int IcV;
  public LinkedList<cxn> IcW;
  public LinkedList<SKBuiltinBuffer_t> IcX;
  public int ijY;
  public String nIJ;
  public SKBuiltinBuffer_t xsE;
  
  public dxy()
  {
    AppMethodBeat.i(148663);
    this.IcW = new LinkedList();
    this.IcX = new LinkedList();
    AppMethodBeat.o(148663);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148664);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.xsE != null)
      {
        paramVarArgs.lJ(3, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GeT);
      if (this.HZg != null) {
        paramVarArgs.d(5, this.HZg);
      }
      paramVarArgs.aS(6, this.ijY);
      paramVarArgs.aS(7, this.HZh);
      paramVarArgs.aS(8, this.FQW);
      paramVarArgs.aS(9, this.HZi);
      paramVarArgs.aS(10, this.FQT);
      paramVarArgs.aS(11, this.IcU);
      paramVarArgs.aS(12, this.IcV);
      paramVarArgs.e(13, 8, this.IcW);
      paramVarArgs.e(14, 8, this.IcX);
      AppMethodBeat.o(148664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.xsE != null) {
        i = paramInt + f.a.a.a.lI(3, this.xsE.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.GeT);
      paramInt = i;
      if (this.HZg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HZg);
      }
      i = f.a.a.b.b.a.bz(6, this.ijY);
      int j = f.a.a.b.b.a.bz(7, this.HZh);
      int k = f.a.a.b.b.a.bz(8, this.FQW);
      int m = f.a.a.b.b.a.bz(9, this.HZi);
      int n = f.a.a.b.b.a.bz(10, this.FQT);
      int i1 = f.a.a.b.b.a.bz(11, this.IcU);
      int i2 = f.a.a.b.b.a.bz(12, this.IcV);
      int i3 = f.a.a.a.c(13, 8, this.IcW);
      int i4 = f.a.a.a.c(14, 8, this.IcX);
      AppMethodBeat.o(148664);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IcW.clear();
        this.IcX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.xsE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148664);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxy localdxy = (dxy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148664);
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
            localdxy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 2: 
          localdxy.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxy.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 4: 
          localdxy.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 5: 
          localdxy.HZg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 6: 
          localdxy.ijY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 7: 
          localdxy.HZh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 8: 
          localdxy.FQW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 9: 
          localdxy.HZi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 10: 
          localdxy.FQT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 11: 
          localdxy.IcU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 12: 
          localdxy.IcV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxy.IcW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxy.IcX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      AppMethodBeat.o(148664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxy
 * JD-Core Version:    0.7.0.1
 */