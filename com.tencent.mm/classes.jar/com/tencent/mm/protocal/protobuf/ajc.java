package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajc
  extends cpx
{
  public String EDK;
  public aiu EDL;
  public String clientId;
  public long commentId;
  public String content;
  public String objectNonceId;
  public int opType;
  public long qXP;
  public long qXu;
  public long replyCommentId;
  public int scene;
  public String sessionBuffer;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168942);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aO(3, this.qXP);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aO(5, this.commentId);
      paramVarArgs.aO(6, this.replyCommentId);
      if (this.EDK != null) {
        paramVarArgs.d(7, this.EDK);
      }
      paramVarArgs.aR(8, this.opType);
      if (this.clientId != null) {
        paramVarArgs.d(9, this.clientId);
      }
      paramVarArgs.aO(10, this.qXu);
      paramVarArgs.aR(11, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.d(12, this.objectNonceId);
      }
      if (this.EDL != null)
      {
        paramVarArgs.ln(13, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(14, this.sessionBuffer);
      }
      AppMethodBeat.o(168942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1102;
      }
    }
    label1102:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i += f.a.a.b.b.a.p(3, this.qXP);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.commentId) + f.a.a.b.b.a.p(6, this.replyCommentId);
      paramInt = i;
      if (this.EDK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EDK);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.opType);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.p(10, this.qXu) + f.a.a.b.b.a.bx(11, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.objectNonceId);
      }
      i = paramInt;
      if (this.EDL != null) {
        i = paramInt + f.a.a.a.lm(13, this.EDL.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.sessionBuffer);
      }
      AppMethodBeat.o(168942);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajc localajc = (ajc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168942);
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
            localajc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 2: 
          localajc.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 3: 
          localajc.qXP = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168942);
          return 0;
        case 4: 
          localajc.content = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 5: 
          localajc.commentId = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168942);
          return 0;
        case 6: 
          localajc.replyCommentId = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168942);
          return 0;
        case 7: 
          localajc.EDK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 8: 
          localajc.opType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168942);
          return 0;
        case 9: 
          localajc.clientId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 10: 
          localajc.qXu = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168942);
          return 0;
        case 11: 
          localajc.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168942);
          return 0;
        case 12: 
          localajc.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajc.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        }
        localajc.sessionBuffer = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(168942);
        return 0;
      }
      AppMethodBeat.o(168942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajc
 * JD-Core Version:    0.7.0.1
 */