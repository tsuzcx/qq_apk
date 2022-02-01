package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ame
  extends cvw
{
  public alw GDR;
  public String GEx;
  public String clientId;
  public long commentId;
  public String content;
  public String objectNonceId;
  public int opType;
  public long rQN;
  public long rRn;
  public long replyCommentId;
  public int scene;
  public int sch;
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aZ(3, this.rRn);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aZ(5, this.commentId);
      paramVarArgs.aZ(6, this.replyCommentId);
      if (this.GEx != null) {
        paramVarArgs.d(7, this.GEx);
      }
      paramVarArgs.aS(8, this.opType);
      if (this.clientId != null) {
        paramVarArgs.d(9, this.clientId);
      }
      paramVarArgs.aZ(10, this.rQN);
      paramVarArgs.aS(11, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.d(12, this.objectNonceId);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(13, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(14, this.sessionBuffer);
      }
      paramVarArgs.aS(15, this.sch);
      AppMethodBeat.o(168942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1150;
      }
    }
    label1150:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i += f.a.a.b.b.a.p(3, this.rRn);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.commentId) + f.a.a.b.b.a.p(6, this.replyCommentId);
      paramInt = i;
      if (this.GEx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GEx);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.opType);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.p(10, this.rQN) + f.a.a.b.b.a.bz(11, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.objectNonceId);
      }
      i = paramInt;
      if (this.GDR != null) {
        i = paramInt + f.a.a.a.lI(13, this.GDR.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.sessionBuffer);
      }
      i = f.a.a.b.b.a.bz(15, this.sch);
      AppMethodBeat.o(168942);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ame localame = (ame)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168942);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localame.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 2: 
          localame.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 3: 
          localame.rRn = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168942);
          return 0;
        case 4: 
          localame.content = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 5: 
          localame.commentId = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168942);
          return 0;
        case 6: 
          localame.replyCommentId = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168942);
          return 0;
        case 7: 
          localame.GEx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 8: 
          localame.opType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168942);
          return 0;
        case 9: 
          localame.clientId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 10: 
          localame.rQN = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168942);
          return 0;
        case 11: 
          localame.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168942);
          return 0;
        case 12: 
          localame.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localame.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 14: 
          localame.sessionBuffer = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168942);
          return 0;
        }
        localame.sch = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168942);
        return 0;
      }
      AppMethodBeat.o(168942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ame
 * JD-Core Version:    0.7.0.1
 */