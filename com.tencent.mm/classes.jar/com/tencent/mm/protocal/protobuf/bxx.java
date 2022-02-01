package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxx
  extends com.tencent.mm.bx.a
{
  public String DUm = "";
  public int DUp = 0;
  public String DUq;
  public int DUr = -1;
  public bxu DUs;
  public String DUt = "";
  public boolean DUu = false;
  public String DUv = "";
  public boolean DUw = false;
  public long endTime = 0L;
  public int gXt = -1;
  public long seq = 0L;
  public String sessionId;
  public long startTime = 0L;
  public String userName = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122525);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      paramVarArgs.aG(2, this.seq);
      paramVarArgs.aR(3, this.DUp);
      if (this.DUq != null) {
        paramVarArgs.d(4, this.DUq);
      }
      paramVarArgs.aR(5, this.DUr);
      paramVarArgs.aG(6, this.startTime);
      paramVarArgs.aG(7, this.endTime);
      if (this.DUs != null)
      {
        paramVarArgs.kX(8, this.DUs.computeSize());
        this.DUs.writeFields(paramVarArgs);
      }
      if (this.DUt != null) {
        paramVarArgs.d(9, this.DUt);
      }
      paramVarArgs.bg(10, this.DUu);
      if (this.userName != null) {
        paramVarArgs.d(11, this.userName);
      }
      if (this.DUv != null) {
        paramVarArgs.d(12, this.DUv);
      }
      paramVarArgs.aR(13, this.gXt);
      paramVarArgs.bg(14, this.DUw);
      if (this.DUm != null) {
        paramVarArgs.d(15, this.DUm);
      }
      AppMethodBeat.o(122525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = f.a.a.b.b.a.e(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.seq) + f.a.a.b.b.a.bA(3, this.DUp);
      paramInt = i;
      if (this.DUq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DUq);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DUr) + f.a.a.b.b.a.q(6, this.startTime) + f.a.a.b.b.a.q(7, this.endTime);
      paramInt = i;
      if (this.DUs != null) {
        paramInt = i + f.a.a.a.kW(8, this.DUs.computeSize());
      }
      i = paramInt;
      if (this.DUt != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DUt);
      }
      i += f.a.a.b.b.a.fY(10) + 1;
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.userName);
      }
      i = paramInt;
      if (this.DUv != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DUv);
      }
      i = i + f.a.a.b.b.a.bA(13, this.gXt) + (f.a.a.b.b.a.fY(14) + 1);
      paramInt = i;
      if (this.DUm != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DUm);
      }
      AppMethodBeat.o(122525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxx localbxx = (bxx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122525);
          return -1;
        case 1: 
          localbxx.sessionId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 2: 
          localbxx.seq = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122525);
          return 0;
        case 3: 
          localbxx.DUp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122525);
          return 0;
        case 4: 
          localbxx.DUq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 5: 
          localbxx.DUr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122525);
          return 0;
        case 6: 
          localbxx.startTime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122525);
          return 0;
        case 7: 
          localbxx.endTime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122525);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bxu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxx.DUs = ((bxu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122525);
          return 0;
        case 9: 
          localbxx.DUt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 10: 
          localbxx.DUu = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122525);
          return 0;
        case 11: 
          localbxx.userName = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 12: 
          localbxx.DUv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 13: 
          localbxx.gXt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122525);
          return 0;
        case 14: 
          localbxx.DUw = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122525);
          return 0;
        }
        localbxx.DUm = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122525);
        return 0;
      }
      AppMethodBeat.o(122525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxx
 * JD-Core Version:    0.7.0.1
 */