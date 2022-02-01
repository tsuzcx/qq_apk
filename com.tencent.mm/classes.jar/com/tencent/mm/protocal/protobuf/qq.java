package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qq
  extends com.tencent.mm.bx.a
{
  public String CPR;
  public String CPS;
  public String CPT;
  public String CPU;
  public String CPV;
  public LinkedList<qp> CPW;
  public int CPX;
  public String CPY;
  public String CPZ;
  public String CQa;
  public int CQb;
  public String CQc;
  public int CQd;
  public String CQe;
  public int CQf;
  public String CQg;
  public rc CQh;
  public String CQi;
  public String CuA;
  
  public qq()
  {
    AppMethodBeat.i(113951);
    this.CPW = new LinkedList();
    AppMethodBeat.o(113951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CuA != null) {
        paramVarArgs.d(1, this.CuA);
      }
      if (this.CPR != null) {
        paramVarArgs.d(2, this.CPR);
      }
      if (this.CPS != null) {
        paramVarArgs.d(3, this.CPS);
      }
      if (this.CPT != null) {
        paramVarArgs.d(4, this.CPT);
      }
      if (this.CPU != null) {
        paramVarArgs.d(5, this.CPU);
      }
      if (this.CPV != null) {
        paramVarArgs.d(6, this.CPV);
      }
      paramVarArgs.e(7, 8, this.CPW);
      paramVarArgs.aR(8, this.CPX);
      if (this.CPY != null) {
        paramVarArgs.d(9, this.CPY);
      }
      if (this.CPZ != null) {
        paramVarArgs.d(10, this.CPZ);
      }
      if (this.CQa != null) {
        paramVarArgs.d(11, this.CQa);
      }
      paramVarArgs.aR(12, this.CQb);
      if (this.CQc != null) {
        paramVarArgs.d(13, this.CQc);
      }
      paramVarArgs.aR(14, this.CQd);
      if (this.CQe != null) {
        paramVarArgs.d(15, this.CQe);
      }
      paramVarArgs.aR(16, this.CQf);
      if (this.CQg != null) {
        paramVarArgs.d(17, this.CQg);
      }
      if (this.CQh != null)
      {
        paramVarArgs.kX(18, this.CQh.computeSize());
        this.CQh.writeFields(paramVarArgs);
      }
      if (this.CQi != null) {
        paramVarArgs.d(19, this.CQi);
      }
      AppMethodBeat.o(113952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CuA == null) {
        break label1434;
      }
    }
    label1434:
    for (int i = f.a.a.b.b.a.e(1, this.CuA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CPR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CPR);
      }
      i = paramInt;
      if (this.CPS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CPS);
      }
      paramInt = i;
      if (this.CPT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CPT);
      }
      i = paramInt;
      if (this.CPU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CPU);
      }
      paramInt = i;
      if (this.CPV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CPV);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.CPW) + f.a.a.b.b.a.bA(8, this.CPX);
      paramInt = i;
      if (this.CPY != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CPY);
      }
      i = paramInt;
      if (this.CPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CPZ);
      }
      paramInt = i;
      if (this.CQa != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CQa);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.CQb);
      paramInt = i;
      if (this.CQc != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CQc);
      }
      i = paramInt + f.a.a.b.b.a.bA(14, this.CQd);
      paramInt = i;
      if (this.CQe != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CQe);
      }
      i = paramInt + f.a.a.b.b.a.bA(16, this.CQf);
      paramInt = i;
      if (this.CQg != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.CQg);
      }
      i = paramInt;
      if (this.CQh != null) {
        i = paramInt + f.a.a.a.kW(18, this.CQh.computeSize());
      }
      paramInt = i;
      if (this.CQi != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.CQi);
      }
      AppMethodBeat.o(113952);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CPW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113952);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qq localqq = (qq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113952);
          return -1;
        case 1: 
          localqq.CuA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 2: 
          localqq.CPR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 3: 
          localqq.CPS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 4: 
          localqq.CPT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 5: 
          localqq.CPU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 6: 
          localqq.CPV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqq.CPW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 8: 
          localqq.CPX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113952);
          return 0;
        case 9: 
          localqq.CPY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 10: 
          localqq.CPZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 11: 
          localqq.CQa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 12: 
          localqq.CQb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113952);
          return 0;
        case 13: 
          localqq.CQc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 14: 
          localqq.CQd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113952);
          return 0;
        case 15: 
          localqq.CQe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 16: 
          localqq.CQf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113952);
          return 0;
        case 17: 
          localqq.CQg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqq.CQh = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        }
        localqq.CQi = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113952);
        return 0;
      }
      AppMethodBeat.o(113952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qq
 * JD-Core Version:    0.7.0.1
 */