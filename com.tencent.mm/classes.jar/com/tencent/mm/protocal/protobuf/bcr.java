package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcr
  extends erp
{
  public long AyP;
  public atz CJv;
  public int Dom;
  public int Eis;
  public int ZNE;
  public String ZNF;
  public LinkedList<Integer> ZNG;
  public long commentId;
  public long hKN;
  public String objectNonceId;
  public int opType;
  public int scene;
  public String sessionBuffer;
  public String username;
  
  public bcr()
  {
    AppMethodBeat.i(259292);
    this.ZNG = new LinkedList();
    AppMethodBeat.o(259292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169002);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.hKN);
      paramVarArgs.bv(3, this.commentId);
      paramVarArgs.bS(4, this.opType);
      paramVarArgs.bv(5, this.AyP);
      paramVarArgs.bS(6, this.ZNE);
      if (this.username != null) {
        paramVarArgs.g(7, this.username);
      }
      paramVarArgs.bS(8, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.g(9, this.objectNonceId);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(10, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.g(11, this.sessionBuffer);
      }
      if (this.ZNF != null) {
        paramVarArgs.g(12, this.ZNF);
      }
      paramVarArgs.bS(13, this.Dom);
      paramVarArgs.bS(14, this.Eis);
      paramVarArgs.e(15, 2, this.ZNG);
      AppMethodBeat.o(169002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1089;
      }
    }
    label1089:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.hKN) + i.a.a.b.b.a.q(3, this.commentId) + i.a.a.b.b.a.cJ(4, this.opType) + i.a.a.b.b.a.q(5, this.AyP) + i.a.a.b.b.a.cJ(6, this.ZNE);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.username);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.objectNonceId);
      }
      i = paramInt;
      if (this.CJv != null) {
        i = paramInt + i.a.a.a.qC(10, this.CJv.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.sessionBuffer);
      }
      i = paramInt;
      if (this.ZNF != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.ZNF);
      }
      paramInt = i.a.a.b.b.a.cJ(13, this.Dom);
      int j = i.a.a.b.b.a.cJ(14, this.Eis);
      int k = i.a.a.a.c(15, 2, this.ZNG);
      AppMethodBeat.o(169002);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZNG.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169002);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bcr localbcr = (bcr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169002);
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
            localbcr.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 2: 
          localbcr.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169002);
          return 0;
        case 3: 
          localbcr.commentId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169002);
          return 0;
        case 4: 
          localbcr.opType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169002);
          return 0;
        case 5: 
          localbcr.AyP = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169002);
          return 0;
        case 6: 
          localbcr.ZNE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169002);
          return 0;
        case 7: 
          localbcr.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 8: 
          localbcr.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169002);
          return 0;
        case 9: 
          localbcr.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 10: 
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
            localbcr.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 11: 
          localbcr.sessionBuffer = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 12: 
          localbcr.ZNF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 13: 
          localbcr.Dom = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169002);
          return 0;
        case 14: 
          localbcr.Eis = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169002);
          return 0;
        }
        localbcr.ZNG.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
        AppMethodBeat.o(169002);
        return 0;
      }
      AppMethodBeat.o(169002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcr
 * JD-Core Version:    0.7.0.1
 */