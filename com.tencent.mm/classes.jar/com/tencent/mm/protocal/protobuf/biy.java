package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class biy
  extends dyl
{
  public aqe SDi;
  public b SLc;
  public String finderUsername;
  public long liveId;
  public int liveStatus;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199962);
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
      paramVarArgs.bm(3, this.liveId);
      if (this.SLc != null) {
        paramVarArgs.c(4, this.SLc);
      }
      paramVarArgs.bm(5, this.xbk);
      if (this.finderUsername != null) {
        paramVarArgs.f(6, this.finderUsername);
      }
      paramVarArgs.aY(7, this.liveStatus);
      AppMethodBeat.o(199962);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i += g.a.a.b.b.a.p(3, this.liveId);
      paramInt = i;
      if (this.SLc != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.SLc);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.xbk);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.finderUsername);
      }
      i = g.a.a.b.b.a.bM(7, this.liveStatus);
      AppMethodBeat.o(199962);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199962);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        biy localbiy = (biy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199962);
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
            localbiy.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199962);
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
            localbiy.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199962);
          return 0;
        case 3: 
          localbiy.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(199962);
          return 0;
        case 4: 
          localbiy.SLc = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(199962);
          return 0;
        case 5: 
          localbiy.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(199962);
          return 0;
        case 6: 
          localbiy.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(199962);
          return 0;
        }
        localbiy.liveStatus = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199962);
        return 0;
      }
      AppMethodBeat.o(199962);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biy
 * JD-Core Version:    0.7.0.1
 */