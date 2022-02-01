package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chk
  extends com.tencent.mm.bx.a
{
  public int HaO = 0;
  public String HaP;
  public int HaQ = -1;
  public chh HaR;
  public String HaS = "";
  public boolean HaT = false;
  public String HaU = "";
  public boolean HaV = false;
  public int HaW = 0;
  public long endTime = 0L;
  public int hQn = -1;
  public long seq = 0L;
  public String sessionId;
  public String ssn = "";
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
      paramVarArgs.aY(2, this.seq);
      paramVarArgs.aS(3, this.HaO);
      if (this.HaP != null) {
        paramVarArgs.d(4, this.HaP);
      }
      paramVarArgs.aS(5, this.HaQ);
      paramVarArgs.aY(6, this.startTime);
      paramVarArgs.aY(7, this.endTime);
      if (this.HaR != null)
      {
        paramVarArgs.lC(8, this.HaR.computeSize());
        this.HaR.writeFields(paramVarArgs);
      }
      if (this.HaS != null) {
        paramVarArgs.d(9, this.HaS);
      }
      paramVarArgs.bt(10, this.HaT);
      if (this.userName != null) {
        paramVarArgs.d(11, this.userName);
      }
      if (this.HaU != null) {
        paramVarArgs.d(12, this.HaU);
      }
      paramVarArgs.aS(13, this.hQn);
      paramVarArgs.bt(14, this.HaV);
      paramVarArgs.aS(15, this.HaW);
      if (this.ssn != null) {
        paramVarArgs.d(16, this.ssn);
      }
      AppMethodBeat.o(122525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label1070;
      }
    }
    label1070:
    for (paramInt = f.a.a.b.b.a.e(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.seq) + f.a.a.b.b.a.bz(3, this.HaO);
      paramInt = i;
      if (this.HaP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HaP);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HaQ) + f.a.a.b.b.a.p(6, this.startTime) + f.a.a.b.b.a.p(7, this.endTime);
      paramInt = i;
      if (this.HaR != null) {
        paramInt = i + f.a.a.a.lB(8, this.HaR.computeSize());
      }
      i = paramInt;
      if (this.HaS != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HaS);
      }
      i += f.a.a.b.b.a.alV(10);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.userName);
      }
      i = paramInt;
      if (this.HaU != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HaU);
      }
      i = i + f.a.a.b.b.a.bz(13, this.hQn) + f.a.a.b.b.a.alV(14) + f.a.a.b.b.a.bz(15, this.HaW);
      paramInt = i;
      if (this.ssn != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.ssn);
      }
      AppMethodBeat.o(122525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chk localchk = (chk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122525);
          return -1;
        case 1: 
          localchk.sessionId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 2: 
          localchk.seq = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122525);
          return 0;
        case 3: 
          localchk.HaO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122525);
          return 0;
        case 4: 
          localchk.HaP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 5: 
          localchk.HaQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122525);
          return 0;
        case 6: 
          localchk.startTime = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122525);
          return 0;
        case 7: 
          localchk.endTime = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122525);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((chh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchk.HaR = ((chh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122525);
          return 0;
        case 9: 
          localchk.HaS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 10: 
          localchk.HaT = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(122525);
          return 0;
        case 11: 
          localchk.userName = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 12: 
          localchk.HaU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 13: 
          localchk.hQn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122525);
          return 0;
        case 14: 
          localchk.HaV = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(122525);
          return 0;
        case 15: 
          localchk.HaW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122525);
          return 0;
        }
        localchk.ssn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122525);
        return 0;
      }
      AppMethodBeat.o(122525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chk
 * JD-Core Version:    0.7.0.1
 */