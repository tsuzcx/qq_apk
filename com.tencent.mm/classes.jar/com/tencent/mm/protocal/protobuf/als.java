package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class als
  extends cvc
{
  public String Glu;
  public alk Glv;
  public String clientId;
  public long commentId;
  public String content;
  public String objectNonceId;
  public int opType;
  public long rID;
  public long rIZ;
  public int rTD;
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
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aY(3, this.rIZ);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aY(5, this.commentId);
      paramVarArgs.aY(6, this.replyCommentId);
      if (this.Glu != null) {
        paramVarArgs.d(7, this.Glu);
      }
      paramVarArgs.aS(8, this.opType);
      if (this.clientId != null) {
        paramVarArgs.d(9, this.clientId);
      }
      paramVarArgs.aY(10, this.rID);
      paramVarArgs.aS(11, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.d(12, this.objectNonceId);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(13, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(14, this.sessionBuffer);
      }
      paramVarArgs.aS(15, this.rTD);
      AppMethodBeat.o(168942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1150;
      }
    }
    label1150:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i += f.a.a.b.b.a.p(3, this.rIZ);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.commentId) + f.a.a.b.b.a.p(6, this.replyCommentId);
      paramInt = i;
      if (this.Glu != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Glu);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.opType);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.p(10, this.rID) + f.a.a.b.b.a.bz(11, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.objectNonceId);
      }
      i = paramInt;
      if (this.Glv != null) {
        i = paramInt + f.a.a.a.lB(13, this.Glv.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.sessionBuffer);
      }
      i = f.a.a.b.b.a.bz(15, this.rTD);
      AppMethodBeat.o(168942);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        als localals = (als)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168942);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localals.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 2: 
          localals.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 3: 
          localals.rIZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168942);
          return 0;
        case 4: 
          localals.content = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 5: 
          localals.commentId = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168942);
          return 0;
        case 6: 
          localals.replyCommentId = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168942);
          return 0;
        case 7: 
          localals.Glu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 8: 
          localals.opType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168942);
          return 0;
        case 9: 
          localals.clientId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 10: 
          localals.rID = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168942);
          return 0;
        case 11: 
          localals.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168942);
          return 0;
        case 12: 
          localals.objectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localals.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 14: 
          localals.sessionBuffer = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168942);
          return 0;
        }
        localals.rTD = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168942);
        return 0;
      }
      AppMethodBeat.o(168942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.als
 * JD-Core Version:    0.7.0.1
 */