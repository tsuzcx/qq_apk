package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asq
  extends ckq
{
  public LinkedList<cmf> Cxc;
  public int DsF;
  public int DsG;
  public LinkedList<cmf> DsH;
  public int DsI;
  public LinkedList<cmf> DsJ;
  public int DsK;
  public cmf DsL;
  
  public asq()
  {
    AppMethodBeat.i(32232);
    this.Cxc = new LinkedList();
    this.DsH = new LinkedList();
    this.DsJ = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DsF);
      paramVarArgs.e(3, 8, this.Cxc);
      paramVarArgs.aR(4, this.DsG);
      paramVarArgs.e(5, 8, this.DsH);
      paramVarArgs.aR(6, this.DsI);
      paramVarArgs.e(7, 8, this.DsJ);
      paramVarArgs.aR(8, this.DsK);
      if (this.DsL != null)
      {
        paramVarArgs.kX(9, this.DsL.computeSize());
        this.DsL.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DsF) + f.a.a.a.c(3, 8, this.Cxc) + f.a.a.b.b.a.bA(4, this.DsG) + f.a.a.a.c(5, 8, this.DsH) + f.a.a.b.b.a.bA(6, this.DsI) + f.a.a.a.c(7, 8, this.DsJ) + f.a.a.b.b.a.bA(8, this.DsK);
      paramInt = i;
      if (this.DsL != null) {
        paramInt = i + f.a.a.a.kW(9, this.DsL.computeSize());
      }
      AppMethodBeat.o(32233);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Cxc.clear();
        this.DsH.clear();
        this.DsJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32233);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asq localasq = (asq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32233);
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
            localasq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 2: 
          localasq.DsF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32233);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasq.Cxc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 4: 
          localasq.DsG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32233);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasq.DsH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 6: 
          localasq.DsI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32233);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasq.DsJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 8: 
          localasq.DsK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32233);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasq.DsL = ((cmf)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asq
 * JD-Core Version:    0.7.0.1
 */