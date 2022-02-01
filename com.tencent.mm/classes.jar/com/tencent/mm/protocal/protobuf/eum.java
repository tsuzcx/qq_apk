package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eum
  extends dop
{
  public int LsZ;
  public long Lta;
  public String MKC;
  public long NpN;
  public eus NqI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115911);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NqI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115911);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MKC != null) {
        paramVarArgs.e(2, this.MKC);
      }
      paramVarArgs.aM(3, this.LsZ);
      paramVarArgs.bb(4, this.Lta);
      if (this.NqI != null)
      {
        paramVarArgs.ni(5, this.NqI.computeSize());
        this.NqI.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.NpN);
      AppMethodBeat.o(115911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MKC != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MKC);
      }
      i = i + g.a.a.b.b.a.bu(3, this.LsZ) + g.a.a.b.b.a.r(4, this.Lta);
      paramInt = i;
      if (this.NqI != null) {
        paramInt = i + g.a.a.a.nh(5, this.NqI.computeSize());
      }
      i = g.a.a.b.b.a.r(6, this.NpN);
      AppMethodBeat.o(115911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NqI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115911);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eum localeum = (eum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115911);
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
            localeum.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        case 2: 
          localeum.MKC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115911);
          return 0;
        case 3: 
          localeum.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115911);
          return 0;
        case 4: 
          localeum.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115911);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eus();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeum.NqI = ((eus)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        }
        localeum.NpN = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(115911);
        return 0;
      }
      AppMethodBeat.o(115911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eum
 * JD-Core Version:    0.7.0.1
 */