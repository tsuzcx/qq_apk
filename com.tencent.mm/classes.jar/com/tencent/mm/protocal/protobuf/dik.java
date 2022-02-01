package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dik
  extends dop
{
  public jl LjV;
  public int Llf;
  public int Llg;
  public int MMR;
  public b MMS;
  public b MMT;
  public b MMU;
  public int MMV;
  public dil MMW;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91653);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LjV != null)
      {
        paramVarArgs.ni(2, this.LjV.computeSize());
        this.LjV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.MMR);
      if (this.MMS != null) {
        paramVarArgs.c(4, this.MMS);
      }
      if (this.MMT != null) {
        paramVarArgs.c(5, this.MMT);
      }
      if (this.MMU != null) {
        paramVarArgs.c(6, this.MMU);
      }
      paramVarArgs.aM(7, this.Llg);
      paramVarArgs.aM(8, this.Llf);
      paramVarArgs.aM(9, this.MMV);
      paramVarArgs.bb(10, this.timestamp);
      if (this.MMW != null)
      {
        paramVarArgs.ni(11, this.MMW.computeSize());
        this.MMW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LjV != null) {
        i = paramInt + g.a.a.a.nh(2, this.LjV.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.MMR);
      paramInt = i;
      if (this.MMS != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.MMS);
      }
      i = paramInt;
      if (this.MMT != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.MMT);
      }
      paramInt = i;
      if (this.MMU != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.MMU);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.Llg) + g.a.a.b.b.a.bu(8, this.Llf) + g.a.a.b.b.a.bu(9, this.MMV) + g.a.a.b.b.a.r(10, this.timestamp);
      paramInt = i;
      if (this.MMW != null) {
        paramInt = i + g.a.a.a.nh(11, this.MMW.computeSize());
      }
      AppMethodBeat.o(91653);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dik localdik = (dik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91653);
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
            localdik.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdik.LjV = ((jl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 3: 
          localdik.MMR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91653);
          return 0;
        case 4: 
          localdik.MMS = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91653);
          return 0;
        case 5: 
          localdik.MMT = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91653);
          return 0;
        case 6: 
          localdik.MMU = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91653);
          return 0;
        case 7: 
          localdik.Llg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91653);
          return 0;
        case 8: 
          localdik.Llf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91653);
          return 0;
        case 9: 
          localdik.MMV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91653);
          return 0;
        case 10: 
          localdik.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91653);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dil();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dil)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdik.MMW = ((dil)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      AppMethodBeat.o(91653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dik
 * JD-Core Version:    0.7.0.1
 */