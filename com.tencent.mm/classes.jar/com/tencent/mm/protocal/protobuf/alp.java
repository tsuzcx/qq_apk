package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alp
  extends cpx
{
  public aiu EDL;
  public int EFi;
  public String EFj;
  public long commentId;
  public String objectNonceId;
  public int opType;
  public long qWK;
  public long qXP;
  public int scene;
  public String sessionBuffer;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169002);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.qXP);
      paramVarArgs.aO(3, this.commentId);
      paramVarArgs.aR(4, this.opType);
      paramVarArgs.aO(5, this.qWK);
      paramVarArgs.aR(6, this.EFi);
      if (this.username != null) {
        paramVarArgs.d(7, this.username);
      }
      paramVarArgs.aR(8, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.d(9, this.objectNonceId);
      }
      if (this.EDL != null)
      {
        paramVarArgs.ln(10, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(11, this.sessionBuffer);
      }
      if (this.EFj != null) {
        paramVarArgs.d(12, this.EFj);
      }
      AppMethodBeat.o(169002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label974;
      }
    }
    label974:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.qXP) + f.a.a.b.b.a.p(3, this.commentId) + f.a.a.b.b.a.bx(4, this.opType) + f.a.a.b.b.a.p(5, this.qWK) + f.a.a.b.b.a.bx(6, this.EFi);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.username);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.objectNonceId);
      }
      i = paramInt;
      if (this.EDL != null) {
        i = paramInt + f.a.a.a.lm(10, this.EDL.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.sessionBuffer);
      }
      i = paramInt;
      if (this.EFj != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EFj);
      }
      AppMethodBeat.o(169002);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169002);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alp localalp = (alp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169002);
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
            localalp.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 2: 
          localalp.qXP = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169002);
          return 0;
        case 3: 
          localalp.commentId = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169002);
          return 0;
        case 4: 
          localalp.opType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169002);
          return 0;
        case 5: 
          localalp.qWK = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169002);
          return 0;
        case 6: 
          localalp.EFi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169002);
          return 0;
        case 7: 
          localalp.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 8: 
          localalp.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169002);
          return 0;
        case 9: 
          localalp.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalp.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 11: 
          localalp.sessionBuffer = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169002);
          return 0;
        }
        localalp.EFj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169002);
        return 0;
      }
      AppMethodBeat.o(169002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alp
 * JD-Core Version:    0.7.0.1
 */