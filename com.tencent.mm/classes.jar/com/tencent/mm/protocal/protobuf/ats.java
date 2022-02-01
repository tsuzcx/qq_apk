package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ats
  extends dyl
{
  public aqo SCW;
  public long SGr;
  public int SGs;
  public String SGt;
  public int SGu;
  public int SGv;
  public int SGw;
  public bbk SGx;
  public int direction;
  public String finderUsername;
  public b lastBuffer;
  public float latitude;
  public b likeBuffer;
  public float longitude;
  public String objectNonceId;
  public int scene;
  public long xbP;
  public long xbT;
  public int xbW;
  public long xbk;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168973);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.xbk);
      paramVarArgs.bm(3, this.SGr);
      paramVarArgs.aY(4, this.SGs);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.bm(6, this.xbP);
      if (this.finderUsername != null) {
        paramVarArgs.f(7, this.finderUsername);
      }
      paramVarArgs.bm(8, this.xbT);
      paramVarArgs.aY(9, this.scene);
      paramVarArgs.aY(10, this.direction);
      if (this.SGt != null) {
        paramVarArgs.f(11, this.SGt);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.f(12, this.objectNonceId);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(13, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.SGu);
      paramVarArgs.aY(15, this.xbW);
      if (this.likeBuffer != null) {
        paramVarArgs.c(16, this.likeBuffer);
      }
      paramVarArgs.aY(17, this.SGv);
      paramVarArgs.aY(18, this.SGw);
      paramVarArgs.i(19, this.longitude);
      paramVarArgs.i(20, this.latitude);
      if (this.SCW != null)
      {
        paramVarArgs.oE(21, this.SCW.computeSize());
        this.SCW.writeFields(paramVarArgs);
      }
      if (this.SGx != null)
      {
        paramVarArgs.oE(22, this.SGx.computeSize());
        this.SGx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1576;
      }
    }
    label1576:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.xbk) + g.a.a.b.b.a.p(3, this.SGr) + g.a.a.b.b.a.bM(4, this.SGs);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.xbP);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.finderUsername);
      }
      i = paramInt + g.a.a.b.b.a.p(8, this.xbT) + g.a.a.b.b.a.bM(9, this.scene) + g.a.a.b.b.a.bM(10, this.direction);
      paramInt = i;
      if (this.SGt != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.SGt);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.objectNonceId);
      }
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(13, this.yjp.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.SGu) + g.a.a.b.b.a.bM(15, this.xbW);
      paramInt = i;
      if (this.likeBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(16, this.likeBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.SGv) + g.a.a.b.b.a.bM(18, this.SGw) + (g.a.a.b.b.a.gL(19) + 4) + (g.a.a.b.b.a.gL(20) + 4);
      paramInt = i;
      if (this.SCW != null) {
        paramInt = i + g.a.a.a.oD(21, this.SCW.computeSize());
      }
      i = paramInt;
      if (this.SGx != null) {
        i = paramInt + g.a.a.a.oD(22, this.SGx.computeSize());
      }
      AppMethodBeat.o(168973);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168973);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ats localats = (ats)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168973);
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
            localats.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 2: 
          localats.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168973);
          return 0;
        case 3: 
          localats.SGr = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168973);
          return 0;
        case 4: 
          localats.SGs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168973);
          return 0;
        case 5: 
          localats.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168973);
          return 0;
        case 6: 
          localats.xbP = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168973);
          return 0;
        case 7: 
          localats.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 8: 
          localats.xbT = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168973);
          return 0;
        case 9: 
          localats.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168973);
          return 0;
        case 10: 
          localats.direction = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168973);
          return 0;
        case 11: 
          localats.SGt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 12: 
          localats.objectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168973);
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
            localats.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 14: 
          localats.SGu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168973);
          return 0;
        case 15: 
          localats.xbW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168973);
          return 0;
        case 16: 
          localats.likeBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168973);
          return 0;
        case 17: 
          localats.SGv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168973);
          return 0;
        case 18: 
          localats.SGw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168973);
          return 0;
        case 19: 
          localats.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(168973);
          return 0;
        case 20: 
          localats.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(168973);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqo)localObject2).parseFrom((byte[])localObject1);
            }
            localats.SCW = ((aqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bbk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bbk)localObject2).parseFrom((byte[])localObject1);
          }
          localats.SGx = ((bbk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168973);
        return 0;
      }
      AppMethodBeat.o(168973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ats
 * JD-Core Version:    0.7.0.1
 */