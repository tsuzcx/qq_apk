package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fmz
  extends esc
{
  public LinkedList<fnc> abNc;
  public int abNd;
  public int abNe;
  public int abNf;
  public boolean abNg;
  
  public fmz()
  {
    AppMethodBeat.i(124567);
    this.abNc = new LinkedList();
    AppMethodBeat.o(124567);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124568);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124568);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.abNc);
      paramVarArgs.bS(3, this.abNd);
      paramVarArgs.bS(4, this.abNe);
      paramVarArgs.bS(5, this.abNf);
      paramVarArgs.di(9, this.abNg);
      AppMethodBeat.o(124568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.abNc);
      int j = i.a.a.b.b.a.cJ(3, this.abNd);
      int k = i.a.a.b.b.a.cJ(4, this.abNe);
      int m = i.a.a.b.b.a.cJ(5, this.abNf);
      int n = i.a.a.b.b.a.ko(9);
      AppMethodBeat.o(124568);
      return paramInt + i + j + k + m + (n + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abNc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124568);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fmz localfmz = (fmz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(124568);
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
            localfmz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124568);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnc)localObject2).parseFrom((byte[])localObject1);
            }
            localfmz.abNc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124568);
          return 0;
        case 3: 
          localfmz.abNd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124568);
          return 0;
        case 4: 
          localfmz.abNe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124568);
          return 0;
        case 5: 
          localfmz.abNf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124568);
          return 0;
        }
        localfmz.abNg = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(124568);
        return 0;
      }
      AppMethodBeat.o(124568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmz
 * JD-Core Version:    0.7.0.1
 */