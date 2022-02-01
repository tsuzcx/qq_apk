package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class apj
  extends ckq
{
  public int DqT;
  public String app_id;
  public int nBZ;
  public String nCa;
  public String nCb;
  public String nCc;
  public String nCd;
  public String nrr;
  public b ntX;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114000);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.d(2, this.app_id);
      }
      paramVarArgs.aR(3, this.nBZ);
      if (this.nCa != null) {
        paramVarArgs.d(4, this.nCa);
      }
      if (this.nCb != null) {
        paramVarArgs.d(5, this.nCb);
      }
      paramVarArgs.aR(6, this.time_stamp);
      if (this.nCc != null) {
        paramVarArgs.d(7, this.nCc);
      }
      if (this.nrr != null) {
        paramVarArgs.d(8, this.nrr);
      }
      if (this.nCd != null) {
        paramVarArgs.d(9, this.nCd);
      }
      if (this.ntX != null) {
        paramVarArgs.c(10, this.ntX);
      }
      paramVarArgs.aR(11, this.DqT);
      AppMethodBeat.o(114000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.app_id);
      }
      i += f.a.a.b.b.a.bA(3, this.nBZ);
      paramInt = i;
      if (this.nCa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nCa);
      }
      i = paramInt;
      if (this.nCb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nCb);
      }
      i += f.a.a.b.b.a.bA(6, this.time_stamp);
      paramInt = i;
      if (this.nCc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nCc);
      }
      i = paramInt;
      if (this.nrr != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.nrr);
      }
      paramInt = i;
      if (this.nCd != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nCd);
      }
      i = paramInt;
      if (this.ntX != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.ntX);
      }
      paramInt = f.a.a.b.b.a.bA(11, this.DqT);
      AppMethodBeat.o(114000);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apj localapj = (apj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114000);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114000);
          return 0;
        case 2: 
          localapj.app_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 3: 
          localapj.nBZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114000);
          return 0;
        case 4: 
          localapj.nCa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 5: 
          localapj.nCb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 6: 
          localapj.time_stamp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114000);
          return 0;
        case 7: 
          localapj.nCc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 8: 
          localapj.nrr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 9: 
          localapj.nCd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 10: 
          localapj.ntX = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(114000);
          return 0;
        }
        localapj.DqT = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(114000);
        return 0;
      }
      AppMethodBeat.o(114000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apj
 * JD-Core Version:    0.7.0.1
 */