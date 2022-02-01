package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmc
  extends esc
{
  public String AzS;
  public long mMJ;
  public long object_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259039);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.object_id);
      paramVarArgs.bv(3, this.mMJ);
      if (this.AzS != null) {
        paramVarArgs.g(4, this.AzS);
      }
      AppMethodBeat.o(259039);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label432;
      }
    }
    label432:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.object_id) + i.a.a.b.b.a.q(3, this.mMJ);
      paramInt = i;
      if (this.AzS != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.AzS);
      }
      AppMethodBeat.o(259039);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259039);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bmc localbmc = (bmc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259039);
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
            localbmc.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259039);
          return 0;
        case 2: 
          localbmc.object_id = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259039);
          return 0;
        case 3: 
          localbmc.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259039);
          return 0;
        }
        localbmc.AzS = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259039);
        return 0;
      }
      AppMethodBeat.o(259039);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmc
 * JD-Core Version:    0.7.0.1
 */