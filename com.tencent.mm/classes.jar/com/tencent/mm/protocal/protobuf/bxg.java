package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxg
  extends dyy
{
  public com.tencent.mm.cd.b RLO;
  public int SOs;
  public LinkedList<crs> TgV;
  public LinkedList<String> TgW;
  public int TgX;
  public boolean TgY;
  public crn TgZ;
  
  public bxg()
  {
    AppMethodBeat.i(200824);
    this.TgV = new LinkedList();
    this.TgW = new LinkedList();
    AppMethodBeat.o(200824);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200832);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(200832);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TgV);
      if (this.RLO != null) {
        paramVarArgs.c(3, this.RLO);
      }
      paramVarArgs.aY(4, this.SOs);
      paramVarArgs.e(5, 1, this.TgW);
      paramVarArgs.aY(6, this.TgX);
      paramVarArgs.co(7, this.TgY);
      if (this.TgZ != null)
      {
        paramVarArgs.oE(8, this.TgZ.computeSize());
        this.TgZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label836;
      }
    }
    label836:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.TgV);
      paramInt = i;
      if (this.RLO != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.RLO);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.SOs) + g.a.a.a.c(5, 1, this.TgW) + g.a.a.b.b.a.bM(6, this.TgX) + (g.a.a.b.b.a.gL(7) + 1);
      paramInt = i;
      if (this.TgZ != null) {
        paramInt = i + g.a.a.a.oD(8, this.TgZ.computeSize());
      }
      AppMethodBeat.o(200832);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TgV.clear();
        this.TgW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(200832);
          throw paramVarArgs;
        }
        AppMethodBeat.o(200832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bxg localbxg = (bxg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200832);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbxg.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200832);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new crs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((crs)localObject2).parseFrom((byte[])localObject1);
            }
            localbxg.TgV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200832);
          return 0;
        case 3: 
          localbxg.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(200832);
          return 0;
        case 4: 
          localbxg.SOs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(200832);
          return 0;
        case 5: 
          localbxg.TgW.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(200832);
          return 0;
        case 6: 
          localbxg.TgX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(200832);
          return 0;
        case 7: 
          localbxg.TgY = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(200832);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new crn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((crn)localObject2).parseFrom((byte[])localObject1);
          }
          localbxg.TgZ = ((crn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200832);
        return 0;
      }
      AppMethodBeat.o(200832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxg
 * JD-Core Version:    0.7.0.1
 */