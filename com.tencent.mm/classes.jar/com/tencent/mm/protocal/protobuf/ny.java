package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ny
  extends esc
{
  public String DUR;
  public int YLL;
  public long YPK;
  public int YPT;
  public GoodsObject YPW;
  public int YQm;
  public String YQn;
  public String hMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258496);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258496);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YPT);
      if (this.hMy != null) {
        paramVarArgs.g(7, this.hMy);
      }
      if (this.DUR != null) {
        paramVarArgs.g(8, this.DUR);
      }
      if (this.YPW != null)
      {
        paramVarArgs.qD(9, this.YPW.computeSize());
        this.YPW.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(11, this.YPK);
      paramVarArgs.bS(14, this.YQm);
      paramVarArgs.bS(15, this.YLL);
      if (this.YQn != null) {
        paramVarArgs.g(21, this.YQn);
      }
      AppMethodBeat.o(258496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YPT);
      paramInt = i;
      if (this.hMy != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.hMy);
      }
      i = paramInt;
      if (this.DUR != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.DUR);
      }
      paramInt = i;
      if (this.YPW != null) {
        paramInt = i + i.a.a.a.qC(9, this.YPW.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(11, this.YPK) + i.a.a.b.b.a.cJ(14, this.YQm) + i.a.a.b.b.a.cJ(15, this.YLL);
      paramInt = i;
      if (this.YQn != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.YQn);
      }
      AppMethodBeat.o(258496);
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
          AppMethodBeat.o(258496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ny localny = (ny)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 10: 
        case 12: 
        case 13: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(258496);
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
            localny.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258496);
          return 0;
        case 2: 
          localny.YPT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258496);
          return 0;
        case 7: 
          localny.hMy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258496);
          return 0;
        case 8: 
          localny.DUR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258496);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new GoodsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((GoodsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localny.YPW = ((GoodsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258496);
          return 0;
        case 11: 
          localny.YPK = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258496);
          return 0;
        case 14: 
          localny.YQm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258496);
          return 0;
        case 15: 
          localny.YLL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258496);
          return 0;
        }
        localny.YQn = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258496);
        return 0;
      }
      AppMethodBeat.o(258496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ny
 * JD-Core Version:    0.7.0.1
 */