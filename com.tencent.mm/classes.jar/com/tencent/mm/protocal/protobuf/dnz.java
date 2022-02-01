package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnz
  extends erp
{
  public dnf aaUG;
  public dnh aaUt;
  public String clientId;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258362);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.clientId != null) {
        paramVarArgs.g(3, this.clientId);
      }
      if (this.aaUt != null)
      {
        paramVarArgs.qD(4, this.aaUt.computeSize());
        this.aaUt.writeFields(paramVarArgs);
      }
      if (this.aaUG != null)
      {
        paramVarArgs.qD(5, this.aaUG.computeSize());
        this.aaUG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.clientId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.clientId);
      }
      paramInt = i;
      if (this.aaUt != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaUt.computeSize());
      }
      i = paramInt;
      if (this.aaUG != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaUG.computeSize());
      }
      AppMethodBeat.o(258362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dnz localdnz = (dnz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258362);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdnz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258362);
          return 0;
        case 2: 
          localdnz.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258362);
          return 0;
        case 3: 
          localdnz.clientId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258362);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dnh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dnh)localObject2).parseFrom((byte[])localObject1);
            }
            localdnz.aaUt = ((dnh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258362);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dnf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dnf)localObject2).parseFrom((byte[])localObject1);
          }
          localdnz.aaUG = ((dnf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258362);
        return 0;
      }
      AppMethodBeat.o(258362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnz
 * JD-Core Version:    0.7.0.1
 */