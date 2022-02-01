package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fbe
  extends esc
{
  public String aazh;
  public int oOu;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32449);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32449);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.oOu);
      paramVarArgs.bS(3, this.vhJ);
      if (this.aazh != null) {
        paramVarArgs.g(4, this.aazh);
      }
      AppMethodBeat.o(32449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.oOu) + i.a.a.b.b.a.cJ(3, this.vhJ);
      paramInt = i;
      if (this.aazh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aazh);
      }
      AppMethodBeat.o(32449);
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
          AppMethodBeat.o(32449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fbe localfbe = (fbe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32449);
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
            localfbe.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(32449);
          return 0;
        case 2: 
          localfbe.oOu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32449);
          return 0;
        case 3: 
          localfbe.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32449);
          return 0;
        }
        localfbe.aazh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32449);
        return 0;
      }
      AppMethodBeat.o(32449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbe
 * JD-Core Version:    0.7.0.1
 */