package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class flj
  extends com.tencent.mm.bx.a
{
  public fle abLK;
  public LinkedList<String> abLL;
  public apx abLM;
  public int abLN;
  public enc abLO;
  public String abLP;
  public long abry;
  public int abrz;
  public String event;
  public String hRR;
  public long lastUpdateTime;
  public int pos;
  public int style;
  public int weight;
  
  public flj()
  {
    AppMethodBeat.i(124563);
    this.abLL = new LinkedList();
    AppMethodBeat.o(124563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124564);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abLK != null)
      {
        paramVarArgs.qD(1, this.abLK.computeSize());
        this.abLK.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.lastUpdateTime);
      paramVarArgs.bS(3, this.pos);
      paramVarArgs.bS(4, this.weight);
      paramVarArgs.bv(5, this.abry);
      paramVarArgs.e(6, 1, this.abLL);
      paramVarArgs.bS(7, this.style);
      if (this.event != null) {
        paramVarArgs.g(8, this.event);
      }
      if (this.abLM != null)
      {
        paramVarArgs.qD(9, this.abLM.computeSize());
        this.abLM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.abLN);
      if (this.abLO != null)
      {
        paramVarArgs.qD(11, this.abLO.computeSize());
        this.abLO.writeFields(paramVarArgs);
      }
      if (this.abLP != null) {
        paramVarArgs.g(12, this.abLP);
      }
      if (this.hRR != null) {
        paramVarArgs.g(13, this.hRR);
      }
      paramVarArgs.bS(14, this.abrz);
      AppMethodBeat.o(124564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abLK == null) {
        break label1104;
      }
    }
    label1104:
    for (paramInt = i.a.a.a.qC(1, this.abLK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.lastUpdateTime) + i.a.a.b.b.a.cJ(3, this.pos) + i.a.a.b.b.a.cJ(4, this.weight) + i.a.a.b.b.a.q(5, this.abry) + i.a.a.a.c(6, 1, this.abLL) + i.a.a.b.b.a.cJ(7, this.style);
      paramInt = i;
      if (this.event != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.event);
      }
      i = paramInt;
      if (this.abLM != null) {
        i = paramInt + i.a.a.a.qC(9, this.abLM.computeSize());
      }
      i += i.a.a.b.b.a.cJ(10, this.abLN);
      paramInt = i;
      if (this.abLO != null) {
        paramInt = i + i.a.a.a.qC(11, this.abLO.computeSize());
      }
      i = paramInt;
      if (this.abLP != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abLP);
      }
      paramInt = i;
      if (this.hRR != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.hRR);
      }
      i = i.a.a.b.b.a.cJ(14, this.abrz);
      AppMethodBeat.o(124564);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abLL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124564);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        flj localflj = (flj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124564);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fle();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fle)localObject2).parseFrom((byte[])localObject1);
            }
            localflj.abLK = ((fle)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 2: 
          localflj.lastUpdateTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(124564);
          return 0;
        case 3: 
          localflj.pos = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124564);
          return 0;
        case 4: 
          localflj.weight = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124564);
          return 0;
        case 5: 
          localflj.abry = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(124564);
          return 0;
        case 6: 
          localflj.abLL.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(124564);
          return 0;
        case 7: 
          localflj.style = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124564);
          return 0;
        case 8: 
          localflj.event = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124564);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apx)localObject2).parseFrom((byte[])localObject1);
            }
            localflj.abLM = ((apx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 10: 
          localflj.abLN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124564);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enc)localObject2).parseFrom((byte[])localObject1);
            }
            localflj.abLO = ((enc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 12: 
          localflj.abLP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124564);
          return 0;
        case 13: 
          localflj.hRR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124564);
          return 0;
        }
        localflj.abrz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(124564);
        return 0;
      }
      AppMethodBeat.o(124564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flj
 * JD-Core Version:    0.7.0.1
 */