package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bjk
  extends dyy
{
  public bji STA;
  public LinkedList<bjh> STB;
  public boolean STC;
  public LinkedList<FinderObject> STz;
  public int continueFlag;
  public b lastBuffer;
  
  public bjk()
  {
    AppMethodBeat.i(229575);
    this.STz = new LinkedList();
    this.STB = new LinkedList();
    AppMethodBeat.o(229575);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229578);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.STz);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aY(4, this.continueFlag);
      if (this.STA != null)
      {
        paramVarArgs.oE(5, this.STA.computeSize());
        this.STA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.STB);
      paramVarArgs.co(7, this.STC);
      AppMethodBeat.o(229578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label810;
      }
    }
    label810:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.STz);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.continueFlag);
      paramInt = i;
      if (this.STA != null) {
        paramInt = i + g.a.a.a.oD(5, this.STA.computeSize());
      }
      i = g.a.a.a.c(6, 8, this.STB);
      int j = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(229578);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.STz.clear();
        this.STB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229578);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bjk localbjk = (bjk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229578);
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
            localbjk.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229578);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbjk.STz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229578);
          return 0;
        case 3: 
          localbjk.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(229578);
          return 0;
        case 4: 
          localbjk.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229578);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bji();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bji)localObject2).parseFrom((byte[])localObject1);
            }
            localbjk.STA = ((bji)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229578);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjh)localObject2).parseFrom((byte[])localObject1);
            }
            localbjk.STB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229578);
          return 0;
        }
        localbjk.STC = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(229578);
        return 0;
      }
      AppMethodBeat.o(229578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjk
 * JD-Core Version:    0.7.0.1
 */