package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asp
  extends cvp
{
  public FinderContact Glf;
  public int GqC;
  public String GqD;
  public String GqE;
  public String GqF;
  public int GqG;
  public int GqH;
  public ach GqI;
  public int GqJ;
  public int GqK;
  public int actionType;
  public int sBK;
  public int sEk;
  public apx verifyInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169074);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.actionType);
      if (this.verifyInfo != null)
      {
        paramVarArgs.lC(3, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      if (this.Glf != null)
      {
        paramVarArgs.lC(4, this.Glf.computeSize());
        this.Glf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.GqC);
      if (this.GqD != null) {
        paramVarArgs.d(6, this.GqD);
      }
      if (this.GqE != null) {
        paramVarArgs.d(7, this.GqE);
      }
      if (this.GqF != null) {
        paramVarArgs.d(8, this.GqF);
      }
      paramVarArgs.aS(9, this.GqG);
      paramVarArgs.aS(10, this.sEk);
      paramVarArgs.aS(11, this.GqH);
      paramVarArgs.aS(12, this.sBK);
      if (this.GqI != null)
      {
        paramVarArgs.lC(13, this.GqI.computeSize());
        this.GqI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.GqJ);
      paramVarArgs.aS(15, this.GqK);
      AppMethodBeat.o(169074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1322;
      }
    }
    label1322:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.actionType);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + f.a.a.a.lB(3, this.verifyInfo.computeSize());
      }
      i = paramInt;
      if (this.Glf != null) {
        i = paramInt + f.a.a.a.lB(4, this.Glf.computeSize());
      }
      i += f.a.a.b.b.a.bz(5, this.GqC);
      paramInt = i;
      if (this.GqD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GqD);
      }
      i = paramInt;
      if (this.GqE != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GqE);
      }
      paramInt = i;
      if (this.GqF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GqF);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GqG) + f.a.a.b.b.a.bz(10, this.sEk) + f.a.a.b.b.a.bz(11, this.GqH) + f.a.a.b.b.a.bz(12, this.sBK);
      paramInt = i;
      if (this.GqI != null) {
        paramInt = i + f.a.a.a.lB(13, this.GqI.computeSize());
      }
      i = f.a.a.b.b.a.bz(14, this.GqJ);
      int j = f.a.a.b.b.a.bz(15, this.GqK);
      AppMethodBeat.o(169074);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asp localasp = (asp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169074);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 2: 
          localasp.actionType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasp.verifyInfo = ((apx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasp.Glf = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 5: 
          localasp.GqC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 6: 
          localasp.GqD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 7: 
          localasp.GqE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 8: 
          localasp.GqF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 9: 
          localasp.GqG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 10: 
          localasp.sEk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 11: 
          localasp.GqH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 12: 
          localasp.sBK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ach();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ach)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasp.GqI = ((ach)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 14: 
          localasp.GqJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169074);
          return 0;
        }
        localasp.GqK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169074);
        return 0;
      }
      AppMethodBeat.o(169074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asp
 * JD-Core Version:    0.7.0.1
 */