package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class qf
  extends esc
{
  public int YLL;
  public long YPK;
  public String YQb;
  public boolean YVa;
  public String hMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258012);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258012);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YQb != null) {
        paramVarArgs.g(2, this.YQb);
      }
      if (this.hMy != null) {
        paramVarArgs.g(3, this.hMy);
      }
      paramVarArgs.di(4, this.YVa);
      paramVarArgs.bv(11, this.YPK);
      paramVarArgs.bS(15, this.YLL);
      AppMethodBeat.o(258012);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label612;
      }
    }
    label612:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YQb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YQb);
      }
      i = paramInt;
      if (this.hMy != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hMy);
      }
      paramInt = i.a.a.b.b.a.ko(4);
      int j = i.a.a.b.b.a.q(11, this.YPK);
      int k = i.a.a.b.b.a.cJ(15, this.YLL);
      AppMethodBeat.o(258012);
      return i + (paramInt + 1) + j + k;
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
          AppMethodBeat.o(258012);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258012);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        qf localqf = (qf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258012);
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
            localqf.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258012);
          return 0;
        case 2: 
          localqf.YQb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258012);
          return 0;
        case 3: 
          localqf.hMy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258012);
          return 0;
        case 4: 
          localqf.YVa = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258012);
          return 0;
        case 11: 
          localqf.YPK = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258012);
          return 0;
        }
        localqf.YLL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258012);
        return 0;
      }
      AppMethodBeat.o(258012);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qf
 * JD-Core Version:    0.7.0.1
 */