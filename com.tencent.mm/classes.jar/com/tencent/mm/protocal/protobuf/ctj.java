package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ctj
  extends buy
{
  public cti yaW;
  public long yab;
  public int ycA;
  public LinkedList<bwc> ycB;
  public cti ycw;
  public cti ycx;
  public cti ycy;
  public cti ycz;
  
  public ctj()
  {
    AppMethodBeat.i(5275);
    this.ycB = new LinkedList();
    AppMethodBeat.o(5275);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5276);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yaW == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(5276);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yaW != null)
      {
        paramVarArgs.iQ(2, this.yaW.computeSize());
        this.yaW.writeFields(paramVarArgs);
      }
      if (this.ycw != null)
      {
        paramVarArgs.iQ(3, this.ycw.computeSize());
        this.ycw.writeFields(paramVarArgs);
      }
      if (this.ycx != null)
      {
        paramVarArgs.iQ(4, this.ycx.computeSize());
        this.ycx.writeFields(paramVarArgs);
      }
      if (this.ycy != null)
      {
        paramVarArgs.iQ(5, this.ycy.computeSize());
        this.ycy.writeFields(paramVarArgs);
      }
      paramVarArgs.am(6, this.yab);
      if (this.ycz != null)
      {
        paramVarArgs.iQ(7, this.ycz.computeSize());
        this.ycz.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.ycA);
      paramVarArgs.e(9, 8, this.ycB);
      AppMethodBeat.o(5276);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1385;
      }
    }
    label1385:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yaW != null) {
        paramInt = i + e.a.a.a.iP(2, this.yaW.computeSize());
      }
      i = paramInt;
      if (this.ycw != null) {
        i = paramInt + e.a.a.a.iP(3, this.ycw.computeSize());
      }
      paramInt = i;
      if (this.ycx != null) {
        paramInt = i + e.a.a.a.iP(4, this.ycx.computeSize());
      }
      i = paramInt;
      if (this.ycy != null) {
        i = paramInt + e.a.a.a.iP(5, this.ycy.computeSize());
      }
      i += e.a.a.b.b.a.p(6, this.yab);
      paramInt = i;
      if (this.ycz != null) {
        paramInt = i + e.a.a.a.iP(7, this.ycz.computeSize());
      }
      i = e.a.a.b.b.a.bl(8, this.ycA);
      int j = e.a.a.a.c(9, 8, this.ycB);
      AppMethodBeat.o(5276);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ycB.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.yaW == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(5276);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5276);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ctj localctj = (ctj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5276);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctj.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5276);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cti();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cti)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctj.yaW = ((cti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5276);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cti();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cti)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctj.ycw = ((cti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5276);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cti();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cti)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctj.ycx = ((cti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5276);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cti();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cti)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctj.ycy = ((cti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5276);
          return 0;
        case 6: 
          localctj.yab = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5276);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cti();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cti)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctj.ycz = ((cti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5276);
          return 0;
        case 8: 
          localctj.ycA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5276);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localctj.ycB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5276);
        return 0;
      }
      AppMethodBeat.o(5276);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctj
 * JD-Core Version:    0.7.0.1
 */