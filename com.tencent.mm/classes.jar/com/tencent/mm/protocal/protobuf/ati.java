package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ati
  extends dpc
{
  public String LEh;
  public int LEi;
  public String LEj;
  public azj LEk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209443);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LEh != null) {
        paramVarArgs.e(2, this.LEh);
      }
      paramVarArgs.aM(3, this.LEi);
      if (this.LEj != null) {
        paramVarArgs.e(4, this.LEj);
      }
      if (this.LEk != null)
      {
        paramVarArgs.ni(5, this.LEk.computeSize());
        this.LEk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LEh != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LEh);
      }
      i += g.a.a.b.b.a.bu(3, this.LEi);
      paramInt = i;
      if (this.LEj != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LEj);
      }
      i = paramInt;
      if (this.LEk != null) {
        i = paramInt + g.a.a.a.nh(5, this.LEk.computeSize());
      }
      AppMethodBeat.o(209443);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ati localati = (ati)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209443);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localati.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209443);
          return 0;
        case 2: 
          localati.LEh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209443);
          return 0;
        case 3: 
          localati.LEi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209443);
          return 0;
        case 4: 
          localati.LEj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209443);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localati.LEk = ((azj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209443);
        return 0;
      }
      AppMethodBeat.o(209443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ati
 * JD-Core Version:    0.7.0.1
 */