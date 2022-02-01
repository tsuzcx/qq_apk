package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bos
  extends erp
{
  public atz YIY;
  public aur ZDQ;
  public String finderUsername;
  public b lastBuffer;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258279);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.userName != null) {
        paramVarArgs.g(3, this.userName);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(4, this.finderUsername);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(5, this.lastBuffer);
      }
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(6, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258279);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label732;
      }
    }
    label732:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.userName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.userName);
      }
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.finderUsername);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.lastBuffer);
      }
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZDQ.computeSize());
      }
      AppMethodBeat.o(258279);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258279);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bos localbos = (bos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258279);
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
            localbos.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258279);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbos.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258279);
          return 0;
        case 3: 
          localbos.userName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258279);
          return 0;
        case 4: 
          localbos.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258279);
          return 0;
        case 5: 
          localbos.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258279);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aur();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aur)localObject2).parseFrom((byte[])localObject1);
          }
          localbos.ZDQ = ((aur)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258279);
        return 0;
      }
      AppMethodBeat.o(258279);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bos
 * JD-Core Version:    0.7.0.1
 */