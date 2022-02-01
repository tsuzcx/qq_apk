package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asp
  extends dyl
{
  public aqe SDi;
  public int fSo;
  public String finderUsername;
  public String objectNonceId;
  public String sessionBuffer;
  public long wGo;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201359);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(3, this.xbk);
      paramVarArgs.aY(4, this.fSo);
      if (this.objectNonceId != null) {
        paramVarArgs.f(5, this.objectNonceId);
      }
      paramVarArgs.bm(6, this.wGo);
      if (this.finderUsername != null) {
        paramVarArgs.f(7, this.finderUsername);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.f(8, this.sessionBuffer);
      }
      AppMethodBeat.o(201359);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = i + g.a.a.b.b.a.p(3, this.xbk) + g.a.a.b.b.a.bM(4, this.fSo);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.objectNonceId);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.wGo);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.finderUsername);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.sessionBuffer);
      }
      AppMethodBeat.o(201359);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201359);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        asp localasp = (asp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201359);
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
            localasp.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201359);
          return 0;
        case 2: 
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
            localasp.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201359);
          return 0;
        case 3: 
          localasp.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(201359);
          return 0;
        case 4: 
          localasp.fSo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(201359);
          return 0;
        case 5: 
          localasp.objectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(201359);
          return 0;
        case 6: 
          localasp.wGo = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(201359);
          return 0;
        case 7: 
          localasp.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(201359);
          return 0;
        }
        localasp.sessionBuffer = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(201359);
        return 0;
      }
      AppMethodBeat.o(201359);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asp
 * JD-Core Version:    0.7.0.1
 */