package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eha
  extends com.tencent.mm.bx.a
{
  public String YMe;
  public boolean abmp;
  public fcx abmq;
  public fcx abmr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91632);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.abmp);
      if (this.abmq != null)
      {
        paramVarArgs.qD(2, this.abmq.computeSize());
        this.abmq.writeFields(paramVarArgs);
      }
      if (this.abmr != null)
      {
        paramVarArgs.qD(3, this.abmr.computeSize());
        this.abmr.writeFields(paramVarArgs);
      }
      if (this.YMe != null) {
        paramVarArgs.g(4, this.YMe);
      }
      AppMethodBeat.o(91632);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.abmq != null) {
        paramInt = i + i.a.a.a.qC(2, this.abmq.computeSize());
      }
      i = paramInt;
      if (this.abmr != null) {
        i = paramInt + i.a.a.a.qC(3, this.abmr.computeSize());
      }
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YMe);
      }
      AppMethodBeat.o(91632);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91632);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      eha localeha = (eha)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      fcx localfcx;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91632);
        return -1;
      case 1: 
        localeha.abmp = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(91632);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfcx = new fcx();
          if ((localObject != null) && (localObject.length > 0)) {
            localfcx.parseFrom((byte[])localObject);
          }
          localeha.abmq = localfcx;
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfcx = new fcx();
          if ((localObject != null) && (localObject.length > 0)) {
            localfcx.parseFrom((byte[])localObject);
          }
          localeha.abmr = localfcx;
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      }
      localeha.YMe = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(91632);
      return 0;
    }
    AppMethodBeat.o(91632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eha
 * JD-Core Version:    0.7.0.1
 */