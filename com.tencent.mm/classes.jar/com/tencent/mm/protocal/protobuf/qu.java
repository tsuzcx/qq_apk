package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qu
  extends com.tencent.mm.bx.a
{
  public String CPU;
  public String CQH;
  public int CQf;
  public String CQg;
  public rc CQh;
  public String CQi;
  public String CuA;
  public String dyc;
  public int lpz;
  public String nsK;
  public String odo;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192643);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyc != null) {
        paramVarArgs.d(1, this.dyc);
      }
      if (this.CuA != null) {
        paramVarArgs.d(2, this.CuA);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.nsK != null) {
        paramVarArgs.d(4, this.nsK);
      }
      if (this.CQH != null) {
        paramVarArgs.d(5, this.CQH);
      }
      if (this.CPU != null) {
        paramVarArgs.d(6, this.CPU);
      }
      paramVarArgs.aR(7, this.lpz);
      if (this.odo != null) {
        paramVarArgs.d(8, this.odo);
      }
      paramVarArgs.aR(9, this.CQf);
      if (this.CQg != null) {
        paramVarArgs.d(10, this.CQg);
      }
      if (this.CQh != null)
      {
        paramVarArgs.kX(11, this.CQh.computeSize());
        this.CQh.writeFields(paramVarArgs);
      }
      if (this.CQi != null) {
        paramVarArgs.d(12, this.CQi);
      }
      AppMethodBeat.o(192643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyc == null) {
        break label954;
      }
    }
    label954:
    for (int i = f.a.a.b.b.a.e(1, this.dyc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CuA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CuA);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.nsK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nsK);
      }
      i = paramInt;
      if (this.CQH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CQH);
      }
      paramInt = i;
      if (this.CPU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CPU);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.lpz);
      paramInt = i;
      if (this.odo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.odo);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.CQf);
      paramInt = i;
      if (this.CQg != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CQg);
      }
      i = paramInt;
      if (this.CQh != null) {
        i = paramInt + f.a.a.a.kW(11, this.CQh.computeSize());
      }
      paramInt = i;
      if (this.CQi != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CQi);
      }
      AppMethodBeat.o(192643);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(192643);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qu localqu = (qu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192643);
          return -1;
        case 1: 
          localqu.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192643);
          return 0;
        case 2: 
          localqu.CuA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192643);
          return 0;
        case 3: 
          localqu.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192643);
          return 0;
        case 4: 
          localqu.nsK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192643);
          return 0;
        case 5: 
          localqu.CQH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192643);
          return 0;
        case 6: 
          localqu.CPU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192643);
          return 0;
        case 7: 
          localqu.lpz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192643);
          return 0;
        case 8: 
          localqu.odo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192643);
          return 0;
        case 9: 
          localqu.CQf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192643);
          return 0;
        case 10: 
          localqu.CQg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192643);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqu.CQh = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192643);
          return 0;
        }
        localqu.CQi = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(192643);
        return 0;
      }
      AppMethodBeat.o(192643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qu
 * JD-Core Version:    0.7.0.1
 */