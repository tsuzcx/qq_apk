package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqx
  extends dyl
{
  public String SEa;
  public String clientId;
  public long commentId;
  public String content;
  public String objectNonceId;
  public int opType;
  public long replyCommentId;
  public int scene;
  public String sessionBuffer;
  public String username;
  public long xbP;
  public long xbk;
  public int xkX;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168942);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      paramVarArgs.bm(3, this.xbk);
      if (this.content != null) {
        paramVarArgs.f(4, this.content);
      }
      paramVarArgs.bm(5, this.commentId);
      paramVarArgs.bm(6, this.replyCommentId);
      if (this.SEa != null) {
        paramVarArgs.f(7, this.SEa);
      }
      paramVarArgs.aY(8, this.opType);
      if (this.clientId != null) {
        paramVarArgs.f(9, this.clientId);
      }
      paramVarArgs.bm(10, this.xbP);
      paramVarArgs.aY(11, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.f(12, this.objectNonceId);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(13, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.f(14, this.sessionBuffer);
      }
      paramVarArgs.aY(15, this.xkX);
      AppMethodBeat.o(168942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1106;
      }
    }
    label1106:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.username);
      }
      i += g.a.a.b.b.a.p(3, this.xbk);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.content);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.commentId) + g.a.a.b.b.a.p(6, this.replyCommentId);
      paramInt = i;
      if (this.SEa != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SEa);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.opType);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.clientId);
      }
      i = paramInt + g.a.a.b.b.a.p(10, this.xbP) + g.a.a.b.b.a.bM(11, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.objectNonceId);
      }
      i = paramInt;
      if (this.yjp != null) {
        i = paramInt + g.a.a.a.oD(13, this.yjp.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.sessionBuffer);
      }
      i = g.a.a.b.b.a.bM(15, this.xkX);
      AppMethodBeat.o(168942);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqx localaqx = (aqx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168942);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localaqx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 2: 
          localaqx.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 3: 
          localaqx.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168942);
          return 0;
        case 4: 
          localaqx.content = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 5: 
          localaqx.commentId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168942);
          return 0;
        case 6: 
          localaqx.replyCommentId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168942);
          return 0;
        case 7: 
          localaqx.SEa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 8: 
          localaqx.opType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168942);
          return 0;
        case 9: 
          localaqx.clientId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 10: 
          localaqx.xbP = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168942);
          return 0;
        case 11: 
          localaqx.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168942);
          return 0;
        case 12: 
          localaqx.objectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localaqx.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 14: 
          localaqx.sessionBuffer = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168942);
          return 0;
        }
        localaqx.xkX = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168942);
        return 0;
      }
      AppMethodBeat.o(168942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqx
 * JD-Core Version:    0.7.0.1
 */