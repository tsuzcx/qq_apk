package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqr
  extends ckq
{
  public LinkedList<bqt> CEH;
  public int Cxl;
  public int DOP;
  public LinkedList<bqq> DOQ;
  public int DOR;
  public String DOS;
  public int Scene;
  
  public bqr()
  {
    AppMethodBeat.i(127498);
    this.DOQ = new LinkedList();
    this.CEH = new LinkedList();
    AppMethodBeat.o(127498);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Cxl);
      paramVarArgs.aR(3, this.DOP);
      paramVarArgs.e(4, 8, this.DOQ);
      paramVarArgs.aR(5, this.DOR);
      paramVarArgs.e(6, 8, this.CEH);
      if (this.DOS != null) {
        paramVarArgs.d(7, this.DOS);
      }
      paramVarArgs.aR(8, this.Scene);
      AppMethodBeat.o(127499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Cxl) + f.a.a.b.b.a.bA(3, this.DOP) + f.a.a.a.c(4, 8, this.DOQ) + f.a.a.b.b.a.bA(5, this.DOR) + f.a.a.a.c(6, 8, this.CEH);
      paramInt = i;
      if (this.DOS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DOS);
      }
      i = f.a.a.b.b.a.bA(8, this.Scene);
      AppMethodBeat.o(127499);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DOQ.clear();
        this.CEH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqr localbqr = (bqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127499);
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
            localbqr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 2: 
          localbqr.Cxl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127499);
          return 0;
        case 3: 
          localbqr.DOP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127499);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqr.DOQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 5: 
          localbqr.DOR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127499);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqr.CEH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 7: 
          localbqr.DOS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127499);
          return 0;
        }
        localbqr.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127499);
        return 0;
      }
      AppMethodBeat.o(127499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqr
 * JD-Core Version:    0.7.0.1
 */