package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bed
  extends ckq
{
  public String DBL;
  public int DBM;
  public String dyc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114041);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyc == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.DBL == null)
      {
        paramVarArgs = new b("Not all required fields were included: to_username");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dyc != null) {
        paramVarArgs.d(2, this.dyc);
      }
      if (this.DBL != null) {
        paramVarArgs.d(3, this.DBL);
      }
      paramVarArgs.aR(4, this.DBM);
      AppMethodBeat.o(114041);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dyc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyc);
      }
      i = paramInt;
      if (this.DBL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DBL);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.DBM);
      AppMethodBeat.o(114041);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.dyc == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(114041);
          throw paramVarArgs;
        }
        if (this.DBL == null)
        {
          paramVarArgs = new b("Not all required fields were included: to_username");
          AppMethodBeat.o(114041);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114041);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bed localbed = (bed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114041);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbed.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114041);
          return 0;
        case 2: 
          localbed.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114041);
          return 0;
        case 3: 
          localbed.DBL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114041);
          return 0;
        }
        localbed.DBM = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(114041);
        return 0;
      }
      AppMethodBeat.o(114041);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bed
 * JD-Core Version:    0.7.0.1
 */