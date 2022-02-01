package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apj
  extends dop
{
  public String LBr;
  public String clientId;
  public long commentId;
  public String content;
  public long hFK;
  public String objectNonceId;
  public int opType;
  public long replyCommentId;
  public int scene;
  public String sessionBuffer;
  public int tCE;
  public long tuf;
  public aov uli;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168942);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.bb(3, this.hFK);
      if (this.content != null) {
        paramVarArgs.e(4, this.content);
      }
      paramVarArgs.bb(5, this.commentId);
      paramVarArgs.bb(6, this.replyCommentId);
      if (this.LBr != null) {
        paramVarArgs.e(7, this.LBr);
      }
      paramVarArgs.aM(8, this.opType);
      if (this.clientId != null) {
        paramVarArgs.e(9, this.clientId);
      }
      paramVarArgs.bb(10, this.tuf);
      paramVarArgs.aM(11, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.e(12, this.objectNonceId);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(13, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.e(14, this.sessionBuffer);
      }
      paramVarArgs.aM(15, this.tCE);
      AppMethodBeat.o(168942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1150;
      }
    }
    label1150:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.username);
      }
      i += g.a.a.b.b.a.r(3, this.hFK);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.content);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.commentId) + g.a.a.b.b.a.r(6, this.replyCommentId);
      paramInt = i;
      if (this.LBr != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LBr);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.opType);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.clientId);
      }
      i = paramInt + g.a.a.b.b.a.r(10, this.tuf) + g.a.a.b.b.a.bu(11, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.objectNonceId);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(13, this.uli.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.sessionBuffer);
      }
      i = g.a.a.b.b.a.bu(15, this.tCE);
      AppMethodBeat.o(168942);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        apj localapj = (apj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168942);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localapj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 2: 
          localapj.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 3: 
          localapj.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168942);
          return 0;
        case 4: 
          localapj.content = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 5: 
          localapj.commentId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168942);
          return 0;
        case 6: 
          localapj.replyCommentId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168942);
          return 0;
        case 7: 
          localapj.LBr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 8: 
          localapj.opType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168942);
          return 0;
        case 9: 
          localapj.clientId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 10: 
          localapj.tuf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168942);
          return 0;
        case 11: 
          localapj.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168942);
          return 0;
        case 12: 
          localapj.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localapj.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 14: 
          localapj.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168942);
          return 0;
        }
        localapj.tCE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168942);
        return 0;
      }
      AppMethodBeat.o(168942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apj
 * JD-Core Version:    0.7.0.1
 */