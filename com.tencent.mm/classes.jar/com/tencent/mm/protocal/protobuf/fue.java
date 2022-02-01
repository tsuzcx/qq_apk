package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fue
  extends esc
{
  public int Njs;
  public long Njv;
  public String YFJ;
  public String YHk;
  public String ZaN;
  public int ZaS;
  public int aaSI;
  public int abSg;
  public String abSw;
  public boolean abSy;
  public boolean abSz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127181);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127181);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YHk != null) {
        paramVarArgs.g(2, this.YHk);
      }
      paramVarArgs.bS(3, this.Njs);
      paramVarArgs.bS(4, this.aaSI);
      paramVarArgs.bS(5, this.abSg);
      paramVarArgs.bv(6, this.Njv);
      if (this.ZaN != null) {
        paramVarArgs.g(7, this.ZaN);
      }
      if (this.YFJ != null) {
        paramVarArgs.g(8, this.YFJ);
      }
      paramVarArgs.bS(9, this.ZaS);
      paramVarArgs.di(10, this.abSy);
      paramVarArgs.di(11, this.abSz);
      if (this.abSw != null) {
        paramVarArgs.g(12, this.abSw);
      }
      AppMethodBeat.o(127181);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label880;
      }
    }
    label880:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YHk != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YHk);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.Njs) + i.a.a.b.b.a.cJ(4, this.aaSI) + i.a.a.b.b.a.cJ(5, this.abSg) + i.a.a.b.b.a.q(6, this.Njv);
      paramInt = i;
      if (this.ZaN != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZaN);
      }
      i = paramInt;
      if (this.YFJ != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YFJ);
      }
      i = i + i.a.a.b.b.a.cJ(9, this.ZaS) + (i.a.a.b.b.a.ko(10) + 1) + (i.a.a.b.b.a.ko(11) + 1);
      paramInt = i;
      if (this.abSw != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abSw);
      }
      AppMethodBeat.o(127181);
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
          AppMethodBeat.o(127181);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127181);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fue localfue = (fue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127181);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localfue.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(127181);
          return 0;
        case 2: 
          localfue.YHk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 3: 
          localfue.Njs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127181);
          return 0;
        case 4: 
          localfue.aaSI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127181);
          return 0;
        case 5: 
          localfue.abSg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127181);
          return 0;
        case 6: 
          localfue.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(127181);
          return 0;
        case 7: 
          localfue.ZaN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 8: 
          localfue.YFJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 9: 
          localfue.ZaS = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127181);
          return 0;
        case 10: 
          localfue.abSy = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(127181);
          return 0;
        case 11: 
          localfue.abSz = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(127181);
          return 0;
        }
        localfue.abSw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127181);
        return 0;
      }
      AppMethodBeat.o(127181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fue
 * JD-Core Version:    0.7.0.1
 */