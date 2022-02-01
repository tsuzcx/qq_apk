package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avd
  extends erp
{
  public long ABa;
  public int AJo;
  public atz CJv;
  public LinkedList<avc> ZDI;
  public String ZFu;
  public LinkedList<String> ZFv;
  public String clientId;
  public long commentId;
  public String content;
  public long hKN;
  public String objectNonceId;
  public int opType;
  public long replyCommentId;
  public int scene;
  public String sessionBuffer;
  public String username;
  
  public avd()
  {
    AppMethodBeat.i(257605);
    this.ZDI = new LinkedList();
    this.ZFv = new LinkedList();
    AppMethodBeat.o(257605);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168942);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      paramVarArgs.bv(3, this.hKN);
      if (this.content != null) {
        paramVarArgs.g(4, this.content);
      }
      paramVarArgs.bv(5, this.commentId);
      paramVarArgs.bv(6, this.replyCommentId);
      if (this.ZFu != null) {
        paramVarArgs.g(7, this.ZFu);
      }
      paramVarArgs.bS(8, this.opType);
      if (this.clientId != null) {
        paramVarArgs.g(9, this.clientId);
      }
      paramVarArgs.bv(10, this.ABa);
      paramVarArgs.bS(11, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.g(12, this.objectNonceId);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(13, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.g(14, this.sessionBuffer);
      }
      paramVarArgs.bS(15, this.AJo);
      paramVarArgs.e(16, 8, this.ZDI);
      paramVarArgs.e(17, 1, this.ZFv);
      AppMethodBeat.o(168942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1284;
      }
    }
    label1284:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.username);
      }
      i += i.a.a.b.b.a.q(3, this.hKN);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.content);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.commentId) + i.a.a.b.b.a.q(6, this.replyCommentId);
      paramInt = i;
      if (this.ZFu != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZFu);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.opType);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.clientId);
      }
      i = paramInt + i.a.a.b.b.a.q(10, this.ABa) + i.a.a.b.b.a.cJ(11, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.objectNonceId);
      }
      i = paramInt;
      if (this.CJv != null) {
        i = paramInt + i.a.a.a.qC(13, this.CJv.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.sessionBuffer);
      }
      i = i.a.a.b.b.a.cJ(15, this.AJo);
      int j = i.a.a.a.c(16, 8, this.ZDI);
      int k = i.a.a.a.c(17, 1, this.ZFv);
      AppMethodBeat.o(168942);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZDI.clear();
        this.ZFv.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        avd localavd = (avd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168942);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localavd.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 2: 
          localavd.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 3: 
          localavd.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168942);
          return 0;
        case 4: 
          localavd.content = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 5: 
          localavd.commentId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168942);
          return 0;
        case 6: 
          localavd.replyCommentId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168942);
          return 0;
        case 7: 
          localavd.ZFu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 8: 
          localavd.opType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168942);
          return 0;
        case 9: 
          localavd.clientId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 10: 
          localavd.ABa = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168942);
          return 0;
        case 11: 
          localavd.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168942);
          return 0;
        case 12: 
          localavd.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localavd.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        case 14: 
          localavd.sessionBuffer = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168942);
          return 0;
        case 15: 
          localavd.AJo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168942);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avc)localObject2).parseFrom((byte[])localObject1);
            }
            localavd.ZDI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168942);
          return 0;
        }
        localavd.ZFv.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(168942);
        return 0;
      }
      AppMethodBeat.o(168942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avd
 * JD-Core Version:    0.7.0.1
 */