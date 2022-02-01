package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fay
  extends esc
{
  public int Idd;
  public String MRj;
  public LinkedList<faw> abAT;
  public int abAU;
  public int vgN;
  
  public fay()
  {
    AppMethodBeat.i(32442);
    this.abAT = new LinkedList();
    AppMethodBeat.o(32442);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32443);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32443);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(3, 8, this.abAT);
      if (this.MRj != null) {
        paramVarArgs.g(4, this.MRj);
      }
      paramVarArgs.bS(5, this.abAU);
      paramVarArgs.bS(6, this.Idd);
      AppMethodBeat.o(32443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vgN) + i.a.a.a.c(3, 8, this.abAT);
      paramInt = i;
      if (this.MRj != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MRj);
      }
      i = i.a.a.b.b.a.cJ(5, this.abAU);
      int j = i.a.a.b.b.a.cJ(6, this.Idd);
      AppMethodBeat.o(32443);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abAT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32443);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fay localfay = (fay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32443);
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
            localfay.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 2: 
          localfay.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32443);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new faw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((faw)localObject2).parseFrom((byte[])localObject1);
            }
            localfay.abAT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 4: 
          localfay.MRj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32443);
          return 0;
        case 5: 
          localfay.abAU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32443);
          return 0;
        }
        localfay.Idd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32443);
        return 0;
      }
      AppMethodBeat.o(32443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fay
 * JD-Core Version:    0.7.0.1
 */