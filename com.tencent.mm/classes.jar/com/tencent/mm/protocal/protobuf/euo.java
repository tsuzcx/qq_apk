package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class euo
  extends dop
{
  public double KUt;
  public double KUu;
  public LinkedList<eby> LWv;
  public int Llx;
  public int LsZ;
  public long Lta;
  public long NsG;
  public dqi NsH;
  public dqi NsI;
  public int NsJ;
  
  public euo()
  {
    AppMethodBeat.i(115913);
    this.LWv = new LinkedList();
    AppMethodBeat.o(115913);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115914);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NsH == null)
      {
        paramVarArgs = new b("Not all required fields were included: NetName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.NsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: WifiName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.NsG);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.aM(4, this.Llx);
      if (this.NsH != null)
      {
        paramVarArgs.ni(5, this.NsH.computeSize());
        this.NsH.writeFields(paramVarArgs);
      }
      if (this.NsI != null)
      {
        paramVarArgs.ni(6, this.NsI.computeSize());
        this.NsI.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, this.KUt);
      paramVarArgs.e(8, this.KUu);
      paramVarArgs.aM(9, this.LsZ);
      paramVarArgs.aM(10, this.NsJ);
      paramVarArgs.e(11, 8, this.LWv);
      AppMethodBeat.o(115914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1184;
      }
    }
    label1184:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.NsG) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.Llx);
      paramInt = i;
      if (this.NsH != null) {
        paramInt = i + g.a.a.a.nh(5, this.NsH.computeSize());
      }
      i = paramInt;
      if (this.NsI != null) {
        i = paramInt + g.a.a.a.nh(6, this.NsI.computeSize());
      }
      paramInt = g.a.a.b.b.a.fS(7);
      int j = g.a.a.b.b.a.fS(8);
      int k = g.a.a.b.b.a.bu(9, this.LsZ);
      int m = g.a.a.b.b.a.bu(10, this.NsJ);
      int n = g.a.a.a.c(11, 8, this.LWv);
      AppMethodBeat.o(115914);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LWv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NsH == null)
        {
          paramVarArgs = new b("Not all required fields were included: NetName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        if (this.NsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: WifiName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        euo localeuo = (euo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115914);
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
            localeuo.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 2: 
          localeuo.NsG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115914);
          return 0;
        case 3: 
          localeuo.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115914);
          return 0;
        case 4: 
          localeuo.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115914);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeuo.NsH = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeuo.NsI = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 7: 
          localeuo.KUt = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(115914);
          return 0;
        case 8: 
          localeuo.KUu = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(115914);
          return 0;
        case 9: 
          localeuo.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115914);
          return 0;
        case 10: 
          localeuo.NsJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115914);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eby();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eby)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeuo.LWv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      AppMethodBeat.o(115914);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euo
 * JD-Core Version:    0.7.0.1
 */