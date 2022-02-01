package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bdc
  extends dyl
{
  public aqe SDi;
  public long SKW;
  public int fSo;
  public String finderUsername;
  public String ilo;
  public String jDI;
  public long liveId;
  public long seq;
  public b xak;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229929);
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
      paramVarArgs.bm(4, this.liveId);
      paramVarArgs.bm(5, this.seq);
      paramVarArgs.aY(6, this.fSo);
      if (this.xak != null) {
        paramVarArgs.c(7, this.xak);
      }
      if (this.ilo != null) {
        paramVarArgs.f(8, this.ilo);
      }
      paramVarArgs.bm(9, this.SKW);
      if (this.finderUsername != null) {
        paramVarArgs.f(10, this.finderUsername);
      }
      if (this.jDI != null) {
        paramVarArgs.f(11, this.jDI);
      }
      AppMethodBeat.o(229929);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label886;
      }
    }
    label886:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = i + g.a.a.b.b.a.p(3, this.xbk) + g.a.a.b.b.a.p(4, this.liveId) + g.a.a.b.b.a.p(5, this.seq) + g.a.a.b.b.a.bM(6, this.fSo);
      paramInt = i;
      if (this.xak != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.xak);
      }
      i = paramInt;
      if (this.ilo != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.ilo);
      }
      i += g.a.a.b.b.a.p(9, this.SKW);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.finderUsername);
      }
      i = paramInt;
      if (this.jDI != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.jDI);
      }
      AppMethodBeat.o(229929);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229929);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bdc localbdc = (bdc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229929);
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
            localbdc.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229929);
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
            localbdc.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229929);
          return 0;
        case 3: 
          localbdc.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229929);
          return 0;
        case 4: 
          localbdc.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229929);
          return 0;
        case 5: 
          localbdc.seq = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229929);
          return 0;
        case 6: 
          localbdc.fSo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229929);
          return 0;
        case 7: 
          localbdc.xak = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(229929);
          return 0;
        case 8: 
          localbdc.ilo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229929);
          return 0;
        case 9: 
          localbdc.SKW = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229929);
          return 0;
        case 10: 
          localbdc.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229929);
          return 0;
        }
        localbdc.jDI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(229929);
        return 0;
      }
      AppMethodBeat.o(229929);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdc
 * JD-Core Version:    0.7.0.1
 */