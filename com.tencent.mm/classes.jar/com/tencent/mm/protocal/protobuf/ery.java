package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ery
  extends dop
{
  public String NoW;
  public String NoX;
  public esc Npm;
  public LinkedList<erx> Npq;
  
  public ery()
  {
    AppMethodBeat.i(239534);
    this.Npq = new LinkedList();
    AppMethodBeat.o(239534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(239535);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.NoW != null) {
        paramVarArgs.e(2, this.NoW);
      }
      if (this.NoX != null) {
        paramVarArgs.e(3, this.NoX);
      }
      if (this.Npm != null)
      {
        paramVarArgs.ni(4, this.Npm.computeSize());
        this.Npm.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.Npq);
      AppMethodBeat.o(239535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NoW != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NoW);
      }
      i = paramInt;
      if (this.NoX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NoX);
      }
      paramInt = i;
      if (this.Npm != null) {
        paramInt = i + g.a.a.a.nh(4, this.Npm.computeSize());
      }
      i = g.a.a.a.c(5, 8, this.Npq);
      AppMethodBeat.o(239535);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Npq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(239535);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ery localery = (ery)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(239535);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localery.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(239535);
          return 0;
        case 2: 
          localery.NoW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239535);
          return 0;
        case 3: 
          localery.NoX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239535);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localery.Npm = ((esc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(239535);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new erx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((erx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localery.Npq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(239535);
        return 0;
      }
      AppMethodBeat.o(239535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ery
 * JD-Core Version:    0.7.0.1
 */