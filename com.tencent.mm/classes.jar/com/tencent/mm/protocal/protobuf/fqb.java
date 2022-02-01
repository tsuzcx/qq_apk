package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fqb
  extends esc
{
  public dfc abPG;
  public int abPI;
  public LinkedList<dfp> abPP;
  public String wuA;
  public int wuz;
  
  public fqb()
  {
    AppMethodBeat.i(72610);
    this.abPP = new LinkedList();
    AppMethodBeat.o(72610);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72611);
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
      paramVarArgs.bS(4, this.abPI);
      paramVarArgs.e(5, 8, this.abPP);
      if (this.abPG != null)
      {
        paramVarArgs.qD(6, this.abPG.computeSize());
        this.abPG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72611);
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
      i = paramInt + i.a.a.b.b.a.cJ(4, this.abPI) + i.a.a.a.c(5, 8, this.abPP);
      paramInt = i;
      if (this.abPG != null) {
        paramInt = i + i.a.a.a.qC(6, this.abPG.computeSize());
      }
      AppMethodBeat.o(72611);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abPP.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72611);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fqb localfqb = (fqb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72611);
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
            localfqb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72611);
          return 0;
        case 2: 
          localfqb.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72611);
          return 0;
        case 3: 
          localfqb.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72611);
          return 0;
        case 4: 
          localfqb.abPI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72611);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfp)localObject2).parseFrom((byte[])localObject1);
            }
            localfqb.abPP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72611);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dfc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dfc)localObject2).parseFrom((byte[])localObject1);
          }
          localfqb.abPG = ((dfc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72611);
        return 0;
      }
      AppMethodBeat.o(72611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqb
 * JD-Core Version:    0.7.0.1
 */