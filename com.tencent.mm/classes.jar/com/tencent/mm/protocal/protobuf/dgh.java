package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgh
  extends dop
{
  public long Btv;
  public long KTS;
  public String MFo;
  public int MKU;
  public long MKV;
  public int MKW;
  public long MKX;
  public long appid;
  public int dDe;
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
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MKU);
      paramVarArgs.bb(3, this.MKV);
      paramVarArgs.bb(4, this.appid);
      paramVarArgs.bb(5, this.KTS);
      paramVarArgs.aM(6, this.MKW);
      paramVarArgs.aM(7, this.scene);
      paramVarArgs.aM(8, this.dDe);
      paramVarArgs.bb(9, this.Btv);
      paramVarArgs.bb(10, this.MKX);
      paramVarArgs.aM(11, this.platform);
      if (this.MFo != null) {
        paramVarArgs.e(12, this.MFo);
      }
      AppMethodBeat.o(124539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MKU) + g.a.a.b.b.a.r(3, this.MKV) + g.a.a.b.b.a.r(4, this.appid) + g.a.a.b.b.a.r(5, this.KTS) + g.a.a.b.b.a.bu(6, this.MKW) + g.a.a.b.b.a.bu(7, this.scene) + g.a.a.b.b.a.bu(8, this.dDe) + g.a.a.b.b.a.r(9, this.Btv) + g.a.a.b.b.a.r(10, this.MKX) + g.a.a.b.b.a.bu(11, this.platform);
      paramInt = i;
      if (this.MFo != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MFo);
      }
      AppMethodBeat.o(124539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgh localdgh = (dgh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124539);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124539);
          return 0;
        case 2: 
          localdgh.MKU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124539);
          return 0;
        case 3: 
          localdgh.MKV = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124539);
          return 0;
        case 4: 
          localdgh.appid = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124539);
          return 0;
        case 5: 
          localdgh.KTS = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124539);
          return 0;
        case 6: 
          localdgh.MKW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124539);
          return 0;
        case 7: 
          localdgh.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124539);
          return 0;
        case 8: 
          localdgh.dDe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124539);
          return 0;
        case 9: 
          localdgh.Btv = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124539);
          return 0;
        case 10: 
          localdgh.MKX = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124539);
          return 0;
        case 11: 
          localdgh.platform = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124539);
          return 0;
        }
        localdgh.MFo = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124539);
        return 0;
      }
      AppMethodBeat.o(124539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgh
 * JD-Core Version:    0.7.0.1
 */