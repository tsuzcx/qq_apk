package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccs
  extends com.tencent.mm.bw.a
{
  public String FqZ = "";
  public int Frc = 0;
  public String Frd;
  public int Fre = -1;
  public ccp Frf;
  public String Frg = "";
  public boolean Frh = false;
  public String Fri = "";
  public boolean Frj = false;
  public long endTime = 0L;
  public int hxS = -1;
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
      paramVarArgs.aO(2, this.seq);
      paramVarArgs.aR(3, this.Frc);
      if (this.Frd != null) {
        paramVarArgs.d(4, this.Frd);
      }
      paramVarArgs.aR(5, this.Fre);
      paramVarArgs.aO(6, this.startTime);
      paramVarArgs.aO(7, this.endTime);
      if (this.Frf != null)
      {
        paramVarArgs.ln(8, this.Frf.computeSize());
        this.Frf.writeFields(paramVarArgs);
      }
      if (this.Frg != null) {
        paramVarArgs.d(9, this.Frg);
      }
      paramVarArgs.bl(10, this.Frh);
      if (this.userName != null) {
        paramVarArgs.d(11, this.userName);
      }
      if (this.Fri != null) {
        paramVarArgs.d(12, this.Fri);
      }
      paramVarArgs.aR(13, this.hxS);
      paramVarArgs.bl(14, this.Frj);
      if (this.FqZ != null) {
        paramVarArgs.d(15, this.FqZ);
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
      int i = paramInt + f.a.a.b.b.a.p(2, this.seq) + f.a.a.b.b.a.bx(3, this.Frc);
      paramInt = i;
      if (this.Frd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Frd);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Fre) + f.a.a.b.b.a.p(6, this.startTime) + f.a.a.b.b.a.p(7, this.endTime);
      paramInt = i;
      if (this.Frf != null) {
        paramInt = i + f.a.a.a.lm(8, this.Frf.computeSize());
      }
      i = paramInt;
      if (this.Frg != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Frg);
      }
      i += f.a.a.b.b.a.fK(10) + 1;
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.userName);
      }
      i = paramInt;
      if (this.Fri != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Fri);
      }
      i = i + f.a.a.b.b.a.bx(13, this.hxS) + (f.a.a.b.b.a.fK(14) + 1);
      paramInt = i;
      if (this.FqZ != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FqZ);
      }
      AppMethodBeat.o(122525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccs localccs = (ccs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122525);
          return -1;
        case 1: 
          localccs.sessionId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 2: 
          localccs.seq = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122525);
          return 0;
        case 3: 
          localccs.Frc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122525);
          return 0;
        case 4: 
          localccs.Frd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 5: 
          localccs.Fre = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122525);
          return 0;
        case 6: 
          localccs.startTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122525);
          return 0;
        case 7: 
          localccs.endTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122525);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ccp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccs.Frf = ((ccp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122525);
          return 0;
        case 9: 
          localccs.Frg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 10: 
          localccs.Frh = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(122525);
          return 0;
        case 11: 
          localccs.userName = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 12: 
          localccs.Fri = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 13: 
          localccs.hxS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122525);
          return 0;
        case 14: 
          localccs.Frj = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(122525);
          return 0;
        }
        localccs.FqZ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122525);
        return 0;
      }
      AppMethodBeat.o(122525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccs
 * JD-Core Version:    0.7.0.1
 */