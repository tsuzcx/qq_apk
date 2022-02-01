package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class azr
  extends dyl
{
  public b RLO;
  public aqe SDi;
  public long SKW;
  public String finderUsername;
  public String jDI;
  public b lastBuffer;
  public long liveId;
  public int scene;
  public String xHT;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231209);
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
      if (this.finderUsername != null) {
        paramVarArgs.f(3, this.finderUsername);
      }
      paramVarArgs.bm(4, this.liveId);
      paramVarArgs.bm(5, this.xbk);
      paramVarArgs.bm(6, this.SKW);
      if (this.xHT != null) {
        paramVarArgs.f(7, this.xHT);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(8, this.lastBuffer);
      }
      if (this.jDI != null) {
        paramVarArgs.f(9, this.jDI);
      }
      if (this.RLO != null) {
        paramVarArgs.c(10, this.RLO);
      }
      paramVarArgs.aY(11, this.scene);
      AppMethodBeat.o(231209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.finderUsername);
      }
      i = i + g.a.a.b.b.a.p(4, this.liveId) + g.a.a.b.b.a.p(5, this.xbk) + g.a.a.b.b.a.p(6, this.SKW);
      paramInt = i;
      if (this.xHT != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.xHT);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(8, this.lastBuffer);
      }
      paramInt = i;
      if (this.jDI != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.jDI);
      }
      i = paramInt;
      if (this.RLO != null) {
        i = paramInt + g.a.a.b.b.a.b(10, this.RLO);
      }
      paramInt = g.a.a.b.b.a.bM(11, this.scene);
      AppMethodBeat.o(231209);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231209);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azr localazr = (azr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231209);
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
            localazr.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231209);
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
            localazr.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231209);
          return 0;
        case 3: 
          localazr.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231209);
          return 0;
        case 4: 
          localazr.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231209);
          return 0;
        case 5: 
          localazr.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231209);
          return 0;
        case 6: 
          localazr.SKW = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231209);
          return 0;
        case 7: 
          localazr.xHT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231209);
          return 0;
        case 8: 
          localazr.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(231209);
          return 0;
        case 9: 
          localazr.jDI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231209);
          return 0;
        case 10: 
          localazr.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(231209);
          return 0;
        }
        localazr.scene = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(231209);
        return 0;
      }
      AppMethodBeat.o(231209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azr
 * JD-Core Version:    0.7.0.1
 */