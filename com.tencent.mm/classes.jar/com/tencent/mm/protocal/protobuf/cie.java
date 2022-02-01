package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cie
  extends com.tencent.mm.bw.a
{
  public int Huo = 0;
  public String Hup;
  public int Huq = -1;
  public cib Hur;
  public String Hus = "";
  public boolean Hut = false;
  public String Huu = "";
  public boolean Huv = false;
  public int Huw = 0;
  public long endTime = 0L;
  public int hTf = -1;
  public String sCx = "";
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
      paramVarArgs.aZ(2, this.seq);
      paramVarArgs.aS(3, this.Huo);
      if (this.Hup != null) {
        paramVarArgs.d(4, this.Hup);
      }
      paramVarArgs.aS(5, this.Huq);
      paramVarArgs.aZ(6, this.startTime);
      paramVarArgs.aZ(7, this.endTime);
      if (this.Hur != null)
      {
        paramVarArgs.lJ(8, this.Hur.computeSize());
        this.Hur.writeFields(paramVarArgs);
      }
      if (this.Hus != null) {
        paramVarArgs.d(9, this.Hus);
      }
      paramVarArgs.bC(10, this.Hut);
      if (this.userName != null) {
        paramVarArgs.d(11, this.userName);
      }
      if (this.Huu != null) {
        paramVarArgs.d(12, this.Huu);
      }
      paramVarArgs.aS(13, this.hTf);
      paramVarArgs.bC(14, this.Huv);
      paramVarArgs.aS(15, this.Huw);
      if (this.sCx != null) {
        paramVarArgs.d(16, this.sCx);
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
      int i = paramInt + f.a.a.b.b.a.p(2, this.seq) + f.a.a.b.b.a.bz(3, this.Huo);
      paramInt = i;
      if (this.Hup != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hup);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Huq) + f.a.a.b.b.a.p(6, this.startTime) + f.a.a.b.b.a.p(7, this.endTime);
      paramInt = i;
      if (this.Hur != null) {
        paramInt = i + f.a.a.a.lI(8, this.Hur.computeSize());
      }
      i = paramInt;
      if (this.Hus != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Hus);
      }
      i += f.a.a.b.b.a.amF(10);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.userName);
      }
      i = paramInt;
      if (this.Huu != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Huu);
      }
      i = i + f.a.a.b.b.a.bz(13, this.hTf) + f.a.a.b.b.a.amF(14) + f.a.a.b.b.a.bz(15, this.Huw);
      paramInt = i;
      if (this.sCx != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.sCx);
      }
      AppMethodBeat.o(122525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cie localcie = (cie)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122525);
          return -1;
        case 1: 
          localcie.sessionId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 2: 
          localcie.seq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122525);
          return 0;
        case 3: 
          localcie.Huo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122525);
          return 0;
        case 4: 
          localcie.Hup = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 5: 
          localcie.Huq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122525);
          return 0;
        case 6: 
          localcie.startTime = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122525);
          return 0;
        case 7: 
          localcie.endTime = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122525);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cib();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cib)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcie.Hur = ((cib)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122525);
          return 0;
        case 9: 
          localcie.Hus = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 10: 
          localcie.Hut = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122525);
          return 0;
        case 11: 
          localcie.userName = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 12: 
          localcie.Huu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 13: 
          localcie.hTf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122525);
          return 0;
        case 14: 
          localcie.Huv = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122525);
          return 0;
        case 15: 
          localcie.Huw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122525);
          return 0;
        }
        localcie.sCx = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122525);
        return 0;
      }
      AppMethodBeat.o(122525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cie
 * JD-Core Version:    0.7.0.1
 */