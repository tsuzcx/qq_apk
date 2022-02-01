package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vl
  extends ckq
{
  public LinkedList<csu> CXA;
  public LinkedList<csr> CXB;
  public LinkedList<csq> CXC;
  public LinkedList<cst> CXD;
  public String CXy;
  public LinkedList<css> CXz;
  public int mBH;
  
  public vl()
  {
    AppMethodBeat.i(32163);
    this.CXz = new LinkedList();
    this.CXA = new LinkedList();
    this.CXB = new LinkedList();
    this.CXC = new LinkedList();
    this.CXD = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mBH);
      if (this.CXy != null) {
        paramVarArgs.d(3, this.CXy);
      }
      paramVarArgs.e(4, 8, this.CXz);
      paramVarArgs.e(5, 8, this.CXA);
      paramVarArgs.e(6, 8, this.CXB);
      paramVarArgs.e(7, 8, this.CXC);
      paramVarArgs.e(8, 8, this.CXD);
      AppMethodBeat.o(32164);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1140;
      }
    }
    label1140:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH);
      paramInt = i;
      if (this.CXy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CXy);
      }
      i = f.a.a.a.c(4, 8, this.CXz);
      int j = f.a.a.a.c(5, 8, this.CXA);
      int k = f.a.a.a.c(6, 8, this.CXB);
      int m = f.a.a.a.c(7, 8, this.CXC);
      int n = f.a.a.a.c(8, 8, this.CXD);
      AppMethodBeat.o(32164);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CXz.clear();
        this.CXA.clear();
        this.CXB.clear();
        this.CXC.clear();
        this.CXD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vl localvl = (vl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32164);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 2: 
          localvl.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32164);
          return 0;
        case 3: 
          localvl.CXy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32164);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new css();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((css)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvl.CXz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvl.CXA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvl.CXB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvl.CXC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cst();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cst)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localvl.CXD.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vl
 * JD-Core Version:    0.7.0.1
 */