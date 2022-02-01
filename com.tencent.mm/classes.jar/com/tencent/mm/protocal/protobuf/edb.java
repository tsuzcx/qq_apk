package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class edb
  extends esc
{
  public gol aaFS;
  public int aaFT;
  public String aaFU;
  public int aaFV;
  public int abip;
  public String abiq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91611);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91611);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaFS != null)
      {
        paramVarArgs.qD(2, this.aaFS.computeSize());
        this.aaFS.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aaFT);
      if (this.aaFU != null) {
        paramVarArgs.g(4, this.aaFU);
      }
      paramVarArgs.bS(5, this.aaFV);
      paramVarArgs.bS(6, this.abip);
      if (this.abiq != null) {
        paramVarArgs.g(7, this.abiq);
      }
      AppMethodBeat.o(91611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaFS != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaFS.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.aaFT);
      paramInt = i;
      if (this.aaFU != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaFU);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaFV) + i.a.a.b.b.a.cJ(6, this.abip);
      paramInt = i;
      if (this.abiq != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abiq);
      }
      AppMethodBeat.o(91611);
      return paramInt;
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
          AppMethodBeat.o(91611);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91611);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        edb localedb = (edb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91611);
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
            localedb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
          return 0;
        case 2: 
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
            localedb.aaFS = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
          return 0;
        case 3: 
          localedb.aaFT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91611);
          return 0;
        case 4: 
          localedb.aaFU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91611);
          return 0;
        case 5: 
          localedb.aaFV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91611);
          return 0;
        case 6: 
          localedb.abip = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91611);
          return 0;
        }
        localedb.abiq = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91611);
        return 0;
      }
      AppMethodBeat.o(91611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edb
 * JD-Core Version:    0.7.0.1
 */