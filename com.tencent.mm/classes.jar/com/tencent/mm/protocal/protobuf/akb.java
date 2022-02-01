package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akb
  extends cpx
{
  public aiu EDL;
  public String EEg;
  public int opType;
  public long refObjectId;
  public String refObjectNonceId;
  public String rfC;
  public String sessionBuffer;
  public int urD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EEg != null) {
        paramVarArgs.d(2, this.EEg);
      }
      paramVarArgs.aR(3, this.opType);
      paramVarArgs.aO(4, this.refObjectId);
      if (this.rfC != null) {
        paramVarArgs.d(5, this.rfC);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.EDL != null)
      {
        paramVarArgs.ln(7, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(8, this.sessionBuffer);
      }
      paramVarArgs.aR(9, this.urD);
      AppMethodBeat.o(168964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EEg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EEg);
      }
      i = i + f.a.a.b.b.a.bx(3, this.opType) + f.a.a.b.b.a.p(4, this.refObjectId);
      paramInt = i;
      if (this.rfC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.rfC);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      paramInt = i;
      if (this.EDL != null) {
        paramInt = i + f.a.a.a.lm(7, this.EDL.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sessionBuffer);
      }
      paramInt = f.a.a.b.b.a.bx(9, this.urD);
      AppMethodBeat.o(168964);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akb localakb = (akb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168964);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakb.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 2: 
          localakb.EEg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 3: 
          localakb.opType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168964);
          return 0;
        case 4: 
          localakb.refObjectId = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168964);
          return 0;
        case 5: 
          localakb.rfC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 6: 
          localakb.refObjectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakb.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 8: 
          localakb.sessionBuffer = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168964);
          return 0;
        }
        localakb.urD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168964);
        return 0;
      }
      AppMethodBeat.o(168964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akb
 * JD-Core Version:    0.7.0.1
 */