package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqb
  extends dyl
{
  public long HnP;
  public long RUQ;
  public String TRa;
  public int TWP;
  public long TWQ;
  public int TWR;
  public long TWS;
  public long appid;
  public int fvK;
  public int platform;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TWP);
      paramVarArgs.bm(3, this.TWQ);
      paramVarArgs.bm(4, this.appid);
      paramVarArgs.bm(5, this.RUQ);
      paramVarArgs.aY(6, this.TWR);
      paramVarArgs.aY(7, this.scene);
      paramVarArgs.aY(8, this.fvK);
      paramVarArgs.bm(9, this.HnP);
      paramVarArgs.bm(10, this.TWS);
      paramVarArgs.aY(11, this.platform);
      if (this.TRa != null) {
        paramVarArgs.f(12, this.TRa);
      }
      AppMethodBeat.o(124539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label784;
      }
    }
    label784:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TWP) + g.a.a.b.b.a.p(3, this.TWQ) + g.a.a.b.b.a.p(4, this.appid) + g.a.a.b.b.a.p(5, this.RUQ) + g.a.a.b.b.a.bM(6, this.TWR) + g.a.a.b.b.a.bM(7, this.scene) + g.a.a.b.b.a.bM(8, this.fvK) + g.a.a.b.b.a.p(9, this.HnP) + g.a.a.b.b.a.p(10, this.TWS) + g.a.a.b.b.a.bM(11, this.platform);
      paramInt = i;
      if (this.TRa != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TRa);
      }
      AppMethodBeat.o(124539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dqb localdqb = (dqb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124539);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdqb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(124539);
          return 0;
        case 2: 
          localdqb.TWP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124539);
          return 0;
        case 3: 
          localdqb.TWQ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(124539);
          return 0;
        case 4: 
          localdqb.appid = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(124539);
          return 0;
        case 5: 
          localdqb.RUQ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(124539);
          return 0;
        case 6: 
          localdqb.TWR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124539);
          return 0;
        case 7: 
          localdqb.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124539);
          return 0;
        case 8: 
          localdqb.fvK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124539);
          return 0;
        case 9: 
          localdqb.HnP = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(124539);
          return 0;
        case 10: 
          localdqb.TWS = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(124539);
          return 0;
        case 11: 
          localdqb.platform = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124539);
          return 0;
        }
        localdqb.TRa = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(124539);
        return 0;
      }
      AppMethodBeat.o(124539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqb
 * JD-Core Version:    0.7.0.1
 */