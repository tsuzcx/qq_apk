package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xx
  extends cvw
{
  public String GpR;
  public LinkedList<dei> GpS;
  public LinkedList<dek> GpT;
  public LinkedList<deh> GpU;
  public LinkedList<deg> GpV;
  public LinkedList<dej> GpW;
  public int nJA;
  
  public xx()
  {
    AppMethodBeat.i(32163);
    this.GpS = new LinkedList();
    this.GpT = new LinkedList();
    this.GpU = new LinkedList();
    this.GpV = new LinkedList();
    this.GpW = new LinkedList();
    AppMethodBeat.o(32163);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32164);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nJA);
      if (this.GpR != null) {
        paramVarArgs.d(3, this.GpR);
      }
      paramVarArgs.e(4, 8, this.GpS);
      paramVarArgs.e(5, 8, this.GpT);
      paramVarArgs.e(6, 8, this.GpU);
      paramVarArgs.e(7, 8, this.GpV);
      paramVarArgs.e(8, 8, this.GpW);
      AppMethodBeat.o(32164);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1140;
      }
    }
    label1140:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJA);
      paramInt = i;
      if (this.GpR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GpR);
      }
      i = f.a.a.a.c(4, 8, this.GpS);
      int j = f.a.a.a.c(5, 8, this.GpT);
      int k = f.a.a.a.c(6, 8, this.GpU);
      int m = f.a.a.a.c(7, 8, this.GpV);
      int n = f.a.a.a.c(8, 8, this.GpW);
      AppMethodBeat.o(32164);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GpS.clear();
        this.GpT.clear();
        this.GpU.clear();
        this.GpV.clear();
        this.GpW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xx localxx = (xx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32164);
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
            localxx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 2: 
          localxx.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32164);
          return 0;
        case 3: 
          localxx.GpR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32164);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dei();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dei)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxx.GpS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dek();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxx.GpT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new deh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((deh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxx.GpU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new deg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((deg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxx.GpV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dej();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dej)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localxx.GpW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      AppMethodBeat.o(32164);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xx
 * JD-Core Version:    0.7.0.1
 */