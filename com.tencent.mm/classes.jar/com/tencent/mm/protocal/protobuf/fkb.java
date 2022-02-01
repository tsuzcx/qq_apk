package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fkb
  extends esc
{
  public String YIV;
  public int aaiK;
  public String aaiL;
  public String aalP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91705);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91705);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YIV != null) {
        paramVarArgs.g(2, this.YIV);
      }
      if (this.aalP != null) {
        paramVarArgs.g(3, this.aalP);
      }
      paramVarArgs.bS(4, this.aaiK);
      if (this.aaiL != null) {
        paramVarArgs.g(5, this.aaiL);
      }
      AppMethodBeat.o(91705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label556;
      }
    }
    label556:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIV != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YIV);
      }
      i = paramInt;
      if (this.aalP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aalP);
      }
      i += i.a.a.b.b.a.cJ(4, this.aaiK);
      paramInt = i;
      if (this.aaiL != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaiL);
      }
      AppMethodBeat.o(91705);
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
          AppMethodBeat.o(91705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fkb localfkb = (fkb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91705);
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
            localfkb.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91705);
          return 0;
        case 2: 
          localfkb.YIV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91705);
          return 0;
        case 3: 
          localfkb.aalP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91705);
          return 0;
        case 4: 
          localfkb.aaiK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91705);
          return 0;
        }
        localfkb.aaiL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91705);
        return 0;
      }
      AppMethodBeat.o(91705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkb
 * JD-Core Version:    0.7.0.1
 */