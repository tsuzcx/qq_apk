package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bwm
  extends com.tencent.mm.bw.a
{
  public dww GhB;
  public float dBu;
  public float dzE;
  public String jGd;
  public String yew;
  public agg yfj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yew == null)
      {
        paramVarArgs = new b("Not all required fields were included: cityName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.jGd == null)
      {
        paramVarArgs = new b("Not all required fields were included: poiName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.GhB == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.yew != null) {
        paramVarArgs.d(1, this.yew);
      }
      if (this.jGd != null) {
        paramVarArgs.d(2, this.jGd);
      }
      if (this.GhB != null)
      {
        paramVarArgs.lJ(4, this.GhB.computeSize());
        this.GhB.writeFields(paramVarArgs);
      }
      paramVarArgs.y(5, this.dBu);
      paramVarArgs.y(6, this.dzE);
      if (this.yfj != null)
      {
        paramVarArgs.lJ(7, this.yfj.computeSize());
        this.yfj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yew == null) {
        break label820;
      }
    }
    label820:
    for (int i = f.a.a.b.b.a.e(1, this.yew) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jGd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jGd);
      }
      i = paramInt;
      if (this.GhB != null) {
        i = paramInt + f.a.a.a.lI(4, this.GhB.computeSize());
      }
      i = i + f.a.a.b.b.a.amE(5) + f.a.a.b.b.a.amE(6);
      paramInt = i;
      if (this.yfj != null) {
        paramInt = i + f.a.a.a.lI(7, this.yfj.computeSize());
      }
      AppMethodBeat.o(140927);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.yew == null)
        {
          paramVarArgs = new b("Not all required fields were included: cityName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.jGd == null)
        {
          paramVarArgs = new b("Not all required fields were included: poiName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.GhB == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwm localbwm = (bwm)paramVarArgs[1];
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
          localbwm.yew = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 2: 
          localbwm.jGd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwm.GhB = ((dww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140927);
          return 0;
        case 5: 
          localbwm.dBu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(140927);
          return 0;
        case 6: 
          localbwm.dzE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(140927);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwm.yfj = ((agg)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwm
 * JD-Core Version:    0.7.0.1
 */