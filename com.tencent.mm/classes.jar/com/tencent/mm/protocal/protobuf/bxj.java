package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxj
  extends cld
{
  public String DTN;
  public bxm DTR;
  public LinkedList<bxj> DTS;
  public int DTT;
  public String type;
  public String upD;
  
  public bxj()
  {
    AppMethodBeat.i(117539);
    this.DTS = new LinkedList();
    AppMethodBeat.o(117539);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DTR != null)
      {
        paramVarArgs.kX(2, this.DTR.computeSize());
        this.DTR.writeFields(paramVarArgs);
      }
      if (this.DTN != null) {
        paramVarArgs.d(3, this.DTN);
      }
      if (this.upD != null) {
        paramVarArgs.d(4, this.upD);
      }
      if (this.type != null) {
        paramVarArgs.d(5, this.type);
      }
      paramVarArgs.e(6, 8, this.DTS);
      paramVarArgs.aR(7, this.DTT);
      AppMethodBeat.o(117540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DTR != null) {
        paramInt = i + f.a.a.a.kW(2, this.DTR.computeSize());
      }
      i = paramInt;
      if (this.DTN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DTN);
      }
      paramInt = i;
      if (this.upD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.upD);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.type);
      }
      paramInt = f.a.a.a.c(6, 8, this.DTS);
      int j = f.a.a.b.b.a.bA(7, this.DTT);
      AppMethodBeat.o(117540);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DTS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxj localbxj = (bxj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117540);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxj.DTR = ((bxm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 3: 
          localbxj.DTN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 4: 
          localbxj.upD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 5: 
          localbxj.type = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxj.DTS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        }
        localbxj.DTT = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117540);
        return 0;
      }
      AppMethodBeat.o(117540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxj
 * JD-Core Version:    0.7.0.1
 */