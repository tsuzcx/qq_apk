package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class etk
  extends dop
{
  public int LsZ;
  public long Lta;
  public String MKC;
  public int MKg;
  public long NpN;
  public eus NqI;
  public int NqJ;
  public int NqK;
  public String xNG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115868);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NqI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115868);
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
      if (this.xNG != null) {
        paramVarArgs.e(6, this.xNG);
      }
      if (this.NqI != null)
      {
        paramVarArgs.ni(8, this.NqI.computeSize());
        this.NqI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.NqJ);
      paramVarArgs.bb(10, this.NpN);
      paramVarArgs.aM(11, this.MKg);
      paramVarArgs.aM(12, this.NqK);
      AppMethodBeat.o(115868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MKC != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MKC);
      }
      i = i + g.a.a.b.b.a.bu(3, this.LsZ) + g.a.a.b.b.a.r(4, this.Lta);
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xNG);
      }
      i = paramInt;
      if (this.NqI != null) {
        i = paramInt + g.a.a.a.nh(8, this.NqI.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(9, this.NqJ);
      int j = g.a.a.b.b.a.r(10, this.NpN);
      int k = g.a.a.b.b.a.bu(11, this.MKg);
      int m = g.a.a.b.b.a.bu(12, this.NqK);
      AppMethodBeat.o(115868);
      return i + paramInt + j + k + m;
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
          AppMethodBeat.o(115868);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115868);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        etk localetk = (etk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(115868);
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
            localetk.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 2: 
          localetk.MKC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 3: 
          localetk.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115868);
          return 0;
        case 4: 
          localetk.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115868);
          return 0;
        case 6: 
          localetk.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eus();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localetk.NqI = ((eus)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 9: 
          localetk.NqJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115868);
          return 0;
        case 10: 
          localetk.NpN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115868);
          return 0;
        case 11: 
          localetk.MKg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115868);
          return 0;
        }
        localetk.NqK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115868);
        return 0;
      }
      AppMethodBeat.o(115868);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etk
 * JD-Core Version:    0.7.0.1
 */