package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fzm
  extends esc
{
  public long ZvA;
  public int Zvz;
  public int abWO;
  public int abWY;
  public gbb abWZ;
  public int abXa;
  public int abXb;
  public int abXc;
  public int abXd;
  public gol abXe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115859);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115859);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bS(4, this.abWY);
      if (this.abWZ != null)
      {
        paramVarArgs.qD(5, this.abWZ.computeSize());
        this.abWZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.abWO);
      paramVarArgs.bS(7, this.abXa);
      paramVarArgs.bS(8, this.abXb);
      paramVarArgs.bS(9, this.abXc);
      paramVarArgs.bS(10, this.abXd);
      if (this.abXe != null)
      {
        paramVarArgs.qD(11, this.abXe.computeSize());
        this.abXe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label948;
      }
    }
    label948:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zvz) + i.a.a.b.b.a.q(3, this.ZvA) + i.a.a.b.b.a.cJ(4, this.abWY);
      paramInt = i;
      if (this.abWZ != null) {
        paramInt = i + i.a.a.a.qC(5, this.abWZ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abWO) + i.a.a.b.b.a.cJ(7, this.abXa) + i.a.a.b.b.a.cJ(8, this.abXb) + i.a.a.b.b.a.cJ(9, this.abXc) + i.a.a.b.b.a.cJ(10, this.abXd);
      paramInt = i;
      if (this.abXe != null) {
        paramInt = i + i.a.a.a.qC(11, this.abXe.computeSize());
      }
      AppMethodBeat.o(115859);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fzm localfzm = (fzm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115859);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfzm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 2: 
          localfzm.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115859);
          return 0;
        case 3: 
          localfzm.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115859);
          return 0;
        case 4: 
          localfzm.abWY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115859);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbb)localObject2).parseFrom((byte[])localObject1);
            }
            localfzm.abWZ = ((gbb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 6: 
          localfzm.abWO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115859);
          return 0;
        case 7: 
          localfzm.abXa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115859);
          return 0;
        case 8: 
          localfzm.abXb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115859);
          return 0;
        case 9: 
          localfzm.abXc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115859);
          return 0;
        case 10: 
          localfzm.abXd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115859);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localfzm.abXe = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      AppMethodBeat.o(115859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzm
 * JD-Core Version:    0.7.0.1
 */