package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cka
  extends com.tencent.mm.bw.a
{
  public String Cfy;
  public ain Cgj;
  public erc Lce;
  public float dTj;
  public String kHV;
  public float latitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140927);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Cfy == null)
      {
        paramVarArgs = new b("Not all required fields were included: cityName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.kHV == null)
      {
        paramVarArgs = new b("Not all required fields were included: poiName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.Lce == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.Cfy != null) {
        paramVarArgs.e(1, this.Cfy);
      }
      if (this.kHV != null) {
        paramVarArgs.e(2, this.kHV);
      }
      if (this.Lce != null)
      {
        paramVarArgs.ni(4, this.Lce.computeSize());
        this.Lce.writeFields(paramVarArgs);
      }
      paramVarArgs.E(5, this.dTj);
      paramVarArgs.E(6, this.latitude);
      if (this.Cgj != null)
      {
        paramVarArgs.ni(7, this.Cgj.computeSize());
        this.Cgj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cfy == null) {
        break label824;
      }
    }
    label824:
    for (int i = g.a.a.b.b.a.f(1, this.Cfy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kHV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.kHV);
      }
      i = paramInt;
      if (this.Lce != null) {
        i = paramInt + g.a.a.a.nh(4, this.Lce.computeSize());
      }
      i = i + (g.a.a.b.b.a.fS(5) + 4) + (g.a.a.b.b.a.fS(6) + 4);
      paramInt = i;
      if (this.Cgj != null) {
        paramInt = i + g.a.a.a.nh(7, this.Cgj.computeSize());
      }
      AppMethodBeat.o(140927);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Cfy == null)
        {
          paramVarArgs = new b("Not all required fields were included: cityName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.kHV == null)
        {
          paramVarArgs = new b("Not all required fields were included: poiName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.Lce == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cka localcka = (cka)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(140927);
          return -1;
        case 1: 
          localcka.Cfy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 2: 
          localcka.kHV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcka.Lce = ((erc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140927);
          return 0;
        case 5: 
          localcka.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(140927);
          return 0;
        case 6: 
          localcka.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(140927);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ain();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ain)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcka.Cgj = ((ain)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(140927);
        return 0;
      }
      AppMethodBeat.o(140927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cka
 * JD-Core Version:    0.7.0.1
 */