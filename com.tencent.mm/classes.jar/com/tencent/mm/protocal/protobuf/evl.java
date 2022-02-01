package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class evl
  extends esc
{
  public gol aaqV;
  public long aaqY;
  public String abyl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104835);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.abyl == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchResult");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abyl != null) {
        paramVarArgs.g(2, this.abyl);
      }
      if (this.aaqV != null)
      {
        paramVarArgs.qD(3, this.aaqV.computeSize());
        this.aaqV.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(4, this.aaqY);
      AppMethodBeat.o(104835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label618;
      }
    }
    label618:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abyl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abyl);
      }
      i = paramInt;
      if (this.aaqV != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaqV.computeSize());
      }
      paramInt = i.a.a.b.b.a.q(4, this.aaqY);
      AppMethodBeat.o(104835);
      return i + paramInt;
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
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        if (this.abyl == null)
        {
          paramVarArgs = new b("Not all required fields were included: SearchResult");
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        evl localevl = (evl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104835);
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
            localevl.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        case 2: 
          localevl.abyl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104835);
          return 0;
        case 3: 
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
            localevl.aaqV = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        }
        localevl.aaqY = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(104835);
        return 0;
      }
      AppMethodBeat.o(104835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evl
 * JD-Core Version:    0.7.0.1
 */