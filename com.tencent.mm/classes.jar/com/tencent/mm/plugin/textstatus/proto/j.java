package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class j
  extends esc
{
  public String ToJ;
  public String ToK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290020);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ToK != null) {
        paramVarArgs.g(2, this.ToK);
      }
      if (this.ToJ != null) {
        paramVarArgs.g(5, this.ToJ);
      }
      AppMethodBeat.o(290020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label412;
      }
    }
    label412:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ToK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ToK);
      }
      i = paramInt;
      if (this.ToJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ToJ);
      }
      AppMethodBeat.o(290020);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290020);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(290020);
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
            localj.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(290020);
          return 0;
        case 2: 
          localj.ToK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290020);
          return 0;
        }
        localj.ToJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(290020);
        return 0;
      }
      AppMethodBeat.o(290020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.j
 * JD-Core Version:    0.7.0.1
 */