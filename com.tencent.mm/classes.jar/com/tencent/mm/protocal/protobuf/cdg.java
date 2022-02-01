package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdg
  extends com.tencent.mm.bw.a
{
  public ddc Mjc;
  public ddc Mjd;
  public int Mje;
  public String dQx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214314);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      if (this.Mjc != null)
      {
        paramVarArgs.ni(2, this.Mjc.computeSize());
        this.Mjc.writeFields(paramVarArgs);
      }
      if (this.Mjd != null)
      {
        paramVarArgs.ni(3, this.Mjd.computeSize());
        this.Mjd.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.Mje);
      AppMethodBeat.o(214314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label570;
      }
    }
    label570:
    for (int i = g.a.a.b.b.a.f(1, this.dQx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mjc != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mjc.computeSize());
      }
      i = paramInt;
      if (this.Mjd != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mjd.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Mje);
      AppMethodBeat.o(214314);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdg localcdg = (cdg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214314);
          return -1;
        case 1: 
          localcdg.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214314);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcdg.Mjc = ((ddc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214314);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcdg.Mjd = ((ddc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214314);
          return 0;
        }
        localcdg.Mje = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(214314);
        return 0;
      }
      AppMethodBeat.o(214314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdg
 * JD-Core Version:    0.7.0.1
 */