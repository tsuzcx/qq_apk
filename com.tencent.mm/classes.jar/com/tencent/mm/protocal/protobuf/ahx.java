package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahx
  extends ckq
{
  public String Dkv;
  public aht Dkw;
  public String clientId;
  public long commentId;
  public String content;
  public long objectId;
  public String objectNonceId;
  public int opType;
  public long qoB;
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aG(3, this.objectId);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aG(5, this.commentId);
      paramVarArgs.aG(6, this.replyCommentId);
      if (this.Dkv != null) {
        paramVarArgs.d(7, this.Dkv);
      }
      paramVarArgs.aR(8, this.opType);
      if (this.clientId != null) {
        paramVarArgs.d(9, this.clientId);
      }
      paramVarArgs.aG(10, this.qoB);
      paramVarArgs.aR(11, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.d(12, this.objectNonceId);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(13, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i += f.a.a.b.b.a.q(3, this.objectId);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.commentId) + f.a.a.b.b.a.q(6, this.replyCommentId);
      paramInt = i;
      if (this.Dkv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dkv);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.opType);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.q(10, this.qoB) + f.a.a.b.b.a.bA(11, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.objectNonceId);
      }
      i = paramInt;
      if (this.Dkw != null) {
        i = paramInt + f.a.a.a.kW(13, this.Dkw.computeSize());
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
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ahx localahx = (ahx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168942);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahx.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 2: 
          localahx.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 3: 
          localahx.objectId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168942);
          return 0;
        case 4: 
          localahx.content = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 5: 
          localahx.commentId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168942);
          return 0;
        case 6: 
          localahx.replyCommentId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168942);
          return 0;
        case 7: 
          localahx.Dkv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 8: 
          localahx.opType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168942);
          return 0;
        case 9: 
          localahx.clientId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 10: 
          localahx.qoB = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168942);
          return 0;
        case 11: 
          localahx.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168942);
          return 0;
        case 12: 
          localahx.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahx.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        }
        localahx.sessionBuffer = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(168942);
        return 0;
      }
      AppMethodBeat.o(168942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahx
 * JD-Core Version:    0.7.0.1
 */