package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class agw
  extends erp
{
  public int IJG;
  public LinkedList<doe> YFm;
  public etl ZpU;
  public gol ZpV;
  public String ZpW;
  public int lyF;
  public String oOI;
  
  public agw()
  {
    AppMethodBeat.i(101797);
    this.YFm = new LinkedList();
    AppMethodBeat.o(101797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101798);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZpU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101798);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZpU != null)
      {
        paramVarArgs.qD(2, this.ZpU.computeSize());
        this.ZpU.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.lyF);
      paramVarArgs.e(4, 8, this.YFm);
      paramVarArgs.bS(5, this.IJG);
      if (this.ZpV != null)
      {
        paramVarArgs.qD(6, this.ZpV.computeSize());
        this.ZpV.writeFields(paramVarArgs);
      }
      if (this.ZpW != null) {
        paramVarArgs.g(7, this.ZpW);
      }
      if (this.oOI != null) {
        paramVarArgs.g(8, this.oOI);
      }
      AppMethodBeat.o(101798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZpU != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZpU.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.lyF) + i.a.a.a.c(4, 8, this.YFm) + i.a.a.b.b.a.cJ(5, this.IJG);
      paramInt = i;
      if (this.ZpV != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZpV.computeSize());
      }
      i = paramInt;
      if (this.ZpW != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZpW);
      }
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.oOI);
      }
      AppMethodBeat.o(101798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZpU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101798);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        agw localagw = (agw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101798);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localagw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localagw.ZpU = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 3: 
          localagw.lyF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101798);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new doe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((doe)localObject2).parseFrom((byte[])localObject1);
            }
            localagw.YFm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 5: 
          localagw.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101798);
          return 0;
        case 6: 
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
            localagw.ZpV = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 7: 
          localagw.ZpW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101798);
          return 0;
        }
        localagw.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(101798);
        return 0;
      }
      AppMethodBeat.o(101798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agw
 * JD-Core Version:    0.7.0.1
 */