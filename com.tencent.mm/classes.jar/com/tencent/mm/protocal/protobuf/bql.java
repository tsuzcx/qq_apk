package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bql
  extends erp
{
  public int ACR;
  public atz YIY;
  public aur ZDQ;
  public String finderUsername;
  public b lastBuffer;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257724);
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
      if (this.YIY != null)
      {
        paramVarArgs.qD(3, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(4, this.finderUsername);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(5, this.lastBuffer);
      }
      paramVarArgs.bS(6, this.ACR);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(7, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label776;
      }
    }
    label776:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(3, this.YIY.computeSize());
      }
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.finderUsername);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.lastBuffer);
      }
      i += i.a.a.b.b.a.cJ(6, this.ACR);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(7, this.ZDQ.computeSize());
      }
      AppMethodBeat.o(257724);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257724);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bql localbql = (bql)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257724);
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
            localbql.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257724);
          return 0;
        case 2: 
          localbql.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257724);
          return 0;
        case 3: 
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
            localbql.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257724);
          return 0;
        case 4: 
          localbql.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257724);
          return 0;
        case 5: 
          localbql.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257724);
          return 0;
        case 6: 
          localbql.ACR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257724);
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
          localbql.ZDQ = ((aur)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257724);
        return 0;
      }
      AppMethodBeat.o(257724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bql
 * JD-Core Version:    0.7.0.1
 */