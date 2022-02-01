package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class ai
  extends esc
{
  public int TpF;
  public int TpG;
  public int live_member_count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289978);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(289978);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.TpF);
      paramVarArgs.bS(3, this.live_member_count);
      paramVarArgs.bS(4, this.TpG);
      AppMethodBeat.o(289978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.TpF);
      int j = i.a.a.b.b.a.cJ(3, this.live_member_count);
      int k = i.a.a.b.b.a.cJ(4, this.TpG);
      AppMethodBeat.o(289978);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(289978);
          throw paramVarArgs;
        }
        AppMethodBeat.o(289978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289978);
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
            localai.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(289978);
          return 0;
        case 2: 
          localai.TpF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289978);
          return 0;
        case 3: 
          localai.live_member_count = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289978);
          return 0;
        }
        localai.TpG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(289978);
        return 0;
      }
      AppMethodBeat.o(289978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ai
 * JD-Core Version:    0.7.0.1
 */