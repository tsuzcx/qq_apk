package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fmv
  extends esc
{
  public String IMu;
  public int YFu;
  public int YRq;
  public long YVJ;
  public String YVP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258621);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258621);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.YVJ);
      paramVarArgs.bS(3, this.YFu);
      paramVarArgs.bS(4, this.YRq);
      if (this.YVP != null) {
        paramVarArgs.g(5, this.YVP);
      }
      if (this.IMu != null) {
        paramVarArgs.g(6, this.IMu);
      }
      AppMethodBeat.o(258621);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.YVJ) + i.a.a.b.b.a.cJ(3, this.YFu) + i.a.a.b.b.a.cJ(4, this.YRq);
      paramInt = i;
      if (this.YVP != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YVP);
      }
      i = paramInt;
      if (this.IMu != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.IMu);
      }
      AppMethodBeat.o(258621);
      return i;
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
          AppMethodBeat.o(258621);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258621);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fmv localfmv = (fmv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258621);
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
            localfmv.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258621);
          return 0;
        case 2: 
          localfmv.YVJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258621);
          return 0;
        case 3: 
          localfmv.YFu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258621);
          return 0;
        case 4: 
          localfmv.YRq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258621);
          return 0;
        case 5: 
          localfmv.YVP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258621);
          return 0;
        }
        localfmv.IMu = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258621);
        return 0;
      }
      AppMethodBeat.o(258621);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmv
 * JD-Core Version:    0.7.0.1
 */