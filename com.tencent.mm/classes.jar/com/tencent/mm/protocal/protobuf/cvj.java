package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cvj
  extends erp
{
  public gol YOj;
  public String YOu;
  public int aaAT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32289);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOj == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(32289);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaAT);
      if (this.YOu != null) {
        paramVarArgs.g(3, this.YOu);
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(4, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32289);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaAT);
      paramInt = i;
      if (this.YOu != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YOu);
      }
      i = paramInt;
      if (this.YOj != null) {
        i = paramInt + i.a.a.a.qC(4, this.YOj.computeSize());
      }
      AppMethodBeat.o(32289);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YOj == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(32289);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32289);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cvj localcvj = (cvj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32289);
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
            localcvj.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32289);
          return 0;
        case 2: 
          localcvj.aaAT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32289);
          return 0;
        case 3: 
          localcvj.YOu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32289);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localcvj.YOj = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32289);
        return 0;
      }
      AppMethodBeat.o(32289);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvj
 * JD-Core Version:    0.7.0.1
 */