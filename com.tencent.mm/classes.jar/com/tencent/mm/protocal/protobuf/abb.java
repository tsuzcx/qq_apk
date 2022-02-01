package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class abb
  extends esc
{
  public int Zjw;
  public int Zjx;
  public int Zjy;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127629);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127629);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.Zjw);
      paramVarArgs.bS(4, this.Zjx);
      paramVarArgs.bS(5, this.Zjy);
      AppMethodBeat.o(127629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vhJ);
      int j = i.a.a.b.b.a.cJ(3, this.Zjw);
      int k = i.a.a.b.b.a.cJ(4, this.Zjx);
      int m = i.a.a.b.b.a.cJ(5, this.Zjy);
      AppMethodBeat.o(127629);
      return paramInt + i + j + k + m;
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
          AppMethodBeat.o(127629);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        abb localabb = (abb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127629);
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
            localabb.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(127629);
          return 0;
        case 2: 
          localabb.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127629);
          return 0;
        case 3: 
          localabb.Zjw = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127629);
          return 0;
        case 4: 
          localabb.Zjx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127629);
          return 0;
        }
        localabb.Zjy = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127629);
        return 0;
      }
      AppMethodBeat.o(127629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abb
 * JD-Core Version:    0.7.0.1
 */