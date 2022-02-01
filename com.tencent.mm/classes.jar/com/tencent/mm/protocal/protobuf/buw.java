package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class buw
  extends dyl
{
  public String RRZ;
  public String SkY;
  public dji TdD;
  public float TeT;
  public long TeV;
  public String TeW;
  public b TeX;
  public boolean TeY;
  public String action_data;
  public int live_type;
  public String person_id;
  public int scene;
  public String ufq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104371);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.person_id != null) {
        paramVarArgs.f(2, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.f(3, this.action_data);
      }
      paramVarArgs.i(4, this.TeT);
      if (this.TeW != null) {
        paramVarArgs.f(5, this.TeW);
      }
      if (this.RRZ != null) {
        paramVarArgs.f(6, this.RRZ);
      }
      paramVarArgs.aY(7, this.scene);
      if (this.SkY != null) {
        paramVarArgs.f(8, this.SkY);
      }
      if (this.ufq != null) {
        paramVarArgs.f(9, this.ufq);
      }
      if (this.TdD != null)
      {
        paramVarArgs.oE(10, this.TdD.computeSize());
        this.TdD.writeFields(paramVarArgs);
      }
      if (this.TeX != null) {
        paramVarArgs.c(11, this.TeX);
      }
      paramVarArgs.co(12, this.TeY);
      paramVarArgs.aY(13, this.live_type);
      paramVarArgs.bm(14, this.TeV);
      AppMethodBeat.o(104371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1081;
      }
    }
    label1081:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.person_id != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.person_id);
      }
      i = paramInt;
      if (this.action_data != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.action_data);
      }
      i += g.a.a.b.b.a.gL(4) + 4;
      paramInt = i;
      if (this.TeW != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TeW);
      }
      i = paramInt;
      if (this.RRZ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RRZ);
      }
      i += g.a.a.b.b.a.bM(7, this.scene);
      paramInt = i;
      if (this.SkY != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SkY);
      }
      i = paramInt;
      if (this.ufq != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.ufq);
      }
      paramInt = i;
      if (this.TdD != null) {
        paramInt = i + g.a.a.a.oD(10, this.TdD.computeSize());
      }
      i = paramInt;
      if (this.TeX != null) {
        i = paramInt + g.a.a.b.b.a.b(11, this.TeX);
      }
      paramInt = g.a.a.b.b.a.gL(12);
      int j = g.a.a.b.b.a.bM(13, this.live_type);
      int k = g.a.a.b.b.a.p(14, this.TeV);
      AppMethodBeat.o(104371);
      return i + (paramInt + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        buw localbuw = (buw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104371);
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
            localbuw.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 2: 
          localbuw.person_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 3: 
          localbuw.action_data = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 4: 
          localbuw.TeT = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(104371);
          return 0;
        case 5: 
          localbuw.TeW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 6: 
          localbuw.RRZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 7: 
          localbuw.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104371);
          return 0;
        case 8: 
          localbuw.SkY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 9: 
          localbuw.ufq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dji();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dji)localObject2).parseFrom((byte[])localObject1);
            }
            localbuw.TdD = ((dji)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 11: 
          localbuw.TeX = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(104371);
          return 0;
        case 12: 
          localbuw.TeY = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(104371);
          return 0;
        case 13: 
          localbuw.live_type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104371);
          return 0;
        }
        localbuw.TeV = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(104371);
        return 0;
      }
      AppMethodBeat.o(104371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buw
 * JD-Core Version:    0.7.0.1
 */