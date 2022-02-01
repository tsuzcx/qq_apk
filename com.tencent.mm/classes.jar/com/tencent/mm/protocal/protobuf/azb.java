package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azb
  extends dyl
{
  public aqe SDi;
  public long SKW;
  public int SKX;
  public String SKY;
  public baj SKZ;
  public int SLa;
  public long liveId;
  public String nonceId;
  public int opType;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230601);
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
      paramVarArgs.bm(4, this.xbk);
      paramVarArgs.bm(5, this.SKW);
      paramVarArgs.aY(6, this.SKX);
      if (this.SKY != null) {
        paramVarArgs.f(7, this.SKY);
      }
      if (this.SKZ != null)
      {
        paramVarArgs.oE(8, this.SKZ.computeSize());
        this.SKZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.SLa);
      paramVarArgs.aY(10, this.opType);
      if (this.nonceId != null) {
        paramVarArgs.f(11, this.nonceId);
      }
      AppMethodBeat.o(230601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label940;
      }
    }
    label940:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = i + g.a.a.b.b.a.p(3, this.liveId) + g.a.a.b.b.a.p(4, this.xbk) + g.a.a.b.b.a.p(5, this.SKW) + g.a.a.b.b.a.bM(6, this.SKX);
      paramInt = i;
      if (this.SKY != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SKY);
      }
      i = paramInt;
      if (this.SKZ != null) {
        i = paramInt + g.a.a.a.oD(8, this.SKZ.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(9, this.SLa) + g.a.a.b.b.a.bM(10, this.opType);
      paramInt = i;
      if (this.nonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.nonceId);
      }
      AppMethodBeat.o(230601);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azb localazb = (azb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230601);
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
            localazb.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230601);
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
            localazb.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230601);
          return 0;
        case 3: 
          localazb.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230601);
          return 0;
        case 4: 
          localazb.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230601);
          return 0;
        case 5: 
          localazb.SKW = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230601);
          return 0;
        case 6: 
          localazb.SKX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230601);
          return 0;
        case 7: 
          localazb.SKY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230601);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new baj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((baj)localObject2).parseFrom((byte[])localObject1);
            }
            localazb.SKZ = ((baj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230601);
          return 0;
        case 9: 
          localazb.SLa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230601);
          return 0;
        case 10: 
          localazb.opType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230601);
          return 0;
        }
        localazb.nonceId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(230601);
        return 0;
      }
      AppMethodBeat.o(230601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azb
 * JD-Core Version:    0.7.0.1
 */