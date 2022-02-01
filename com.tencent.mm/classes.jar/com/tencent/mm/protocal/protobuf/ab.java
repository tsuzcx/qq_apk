package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ab
  extends esc
{
  public String YAA;
  public int YAB;
  public int YAC;
  public String YAD;
  public String YAE;
  public int hAV;
  public LinkedList<n> hfF;
  public String wYI;
  
  public ab()
  {
    AppMethodBeat.i(91337);
    this.hAV = 268513600;
    this.wYI = "请求不成功，请稍候再试";
    this.hfF = new LinkedList();
    AppMethodBeat.o(91337);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91338);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91338);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      paramVarArgs.e(4, 8, this.hfF);
      if (this.YAE != null) {
        paramVarArgs.g(5, this.YAE);
      }
      if (this.YAA != null) {
        paramVarArgs.g(6, this.YAA);
      }
      paramVarArgs.bS(7, this.YAB);
      paramVarArgs.bS(8, this.YAC);
      if (this.YAD != null) {
        paramVarArgs.g(9, this.YAD);
      }
      AppMethodBeat.o(91338);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.a.c(4, 8, this.hfF);
      paramInt = i;
      if (this.YAE != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YAE);
      }
      i = paramInt;
      if (this.YAA != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YAA);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.YAB) + i.a.a.b.b.a.cJ(8, this.YAC);
      paramInt = i;
      if (this.YAD != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YAD);
      }
      AppMethodBeat.o(91338);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hfF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91338);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91338);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ab localab = (ab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91338);
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
            localab.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 2: 
          localab.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91338);
          return 0;
        case 3: 
          localab.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new n();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((n)localObject2).parseFrom((byte[])localObject1);
            }
            localab.hfF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 5: 
          localab.YAE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 6: 
          localab.YAA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 7: 
          localab.YAB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91338);
          return 0;
        case 8: 
          localab.YAC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91338);
          return 0;
        }
        localab.YAD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91338);
        return 0;
      }
      AppMethodBeat.o(91338);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ab
 * JD-Core Version:    0.7.0.1
 */