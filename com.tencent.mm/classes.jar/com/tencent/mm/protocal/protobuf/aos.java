package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.i;
import java.util.LinkedList;

public final class aos
  extends esc
{
  public LinkedList<i> ZvT;
  public int ZvU;
  public g.a.a.a ZvV;
  public String wuA;
  public int wuz;
  
  public aos()
  {
    AppMethodBeat.i(91444);
    this.ZvT = new LinkedList();
    AppMethodBeat.o(91444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91445);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.e(4, 8, this.ZvT);
      paramVarArgs.bS(5, this.ZvU);
      if (this.ZvV != null)
      {
        paramVarArgs.qD(6, this.ZvV.computeSize());
        this.ZvV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label684;
      }
    }
    label684:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.a.c(4, 8, this.ZvT) + i.a.a.b.b.a.cJ(5, this.ZvU);
      paramInt = i;
      if (this.ZvV != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZvV.computeSize());
      }
      AppMethodBeat.o(91445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZvT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aos localaos = (aos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91445);
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
            localaos.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91445);
          return 0;
        case 2: 
          localaos.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91445);
          return 0;
        case 3: 
          localaos.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91445);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new i();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((i)localObject2).parseFrom((byte[])localObject1);
            }
            localaos.ZvT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91445);
          return 0;
        case 5: 
          localaos.ZvU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91445);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new g.a.a.a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((g.a.a.a)localObject2).parseFrom((byte[])localObject1);
          }
          localaos.ZvV = ((g.a.a.a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91445);
        return 0;
      }
      AppMethodBeat.o(91445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aos
 * JD-Core Version:    0.7.0.1
 */