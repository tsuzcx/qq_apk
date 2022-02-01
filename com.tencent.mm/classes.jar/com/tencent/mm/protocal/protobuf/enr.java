package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class enr
  extends esc
{
  public String SessionId;
  public LinkedList<eng> aaqZ;
  public com.tencent.mm.bx.b aaui;
  
  public enr()
  {
    AppMethodBeat.i(104832);
    this.aaqZ = new LinkedList();
    AppMethodBeat.o(104832);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104833);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104833);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaqZ);
      if (this.SessionId != null) {
        paramVarArgs.g(3, this.SessionId);
      }
      if (this.aaui != null) {
        paramVarArgs.d(4, this.aaui);
      }
      AppMethodBeat.o(104833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaqZ);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.SessionId);
      }
      i = paramInt;
      if (this.aaui != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.aaui);
      }
      AppMethodBeat.o(104833);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaqZ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104833);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104833);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        enr localenr = (enr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104833);
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
            localenr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104833);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eng();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eng)localObject2).parseFrom((byte[])localObject1);
            }
            localenr.aaqZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104833);
          return 0;
        case 3: 
          localenr.SessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104833);
          return 0;
        }
        localenr.aaui = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(104833);
        return 0;
      }
      AppMethodBeat.o(104833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enr
 * JD-Core Version:    0.7.0.1
 */