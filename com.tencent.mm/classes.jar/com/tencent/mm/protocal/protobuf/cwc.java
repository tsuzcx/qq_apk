package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cwc
  extends com.tencent.mm.bw.a
{
  public int Fih;
  public int GSm;
  public int GgG;
  public cwf HHa;
  public cwe HHb;
  public int HHc;
  public String HHd;
  public int HHe;
  public int HHf;
  public int HHg;
  public int HcW;
  public int Hzh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HHd == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Hzh);
      if (this.HHa != null)
      {
        paramVarArgs.lJ(2, this.HHa.computeSize());
        this.HHa.writeFields(paramVarArgs);
      }
      if (this.HHb != null)
      {
        paramVarArgs.lJ(3, this.HHb.computeSize());
        this.HHb.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GSm);
      paramVarArgs.aS(5, this.HHc);
      if (this.HHd != null) {
        paramVarArgs.d(6, this.HHd);
      }
      paramVarArgs.aS(7, this.GgG);
      paramVarArgs.aS(8, this.HHe);
      paramVarArgs.aS(9, this.Fih);
      paramVarArgs.aS(10, this.HHf);
      paramVarArgs.aS(11, this.HHg);
      paramVarArgs.aS(12, this.HcW);
      AppMethodBeat.o(152668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hzh) + 0;
      paramInt = i;
      if (this.HHa != null) {
        paramInt = i + f.a.a.a.lI(2, this.HHa.computeSize());
      }
      i = paramInt;
      if (this.HHb != null) {
        i = paramInt + f.a.a.a.lI(3, this.HHb.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(4, this.GSm) + f.a.a.b.b.a.bz(5, this.HHc);
      paramInt = i;
      if (this.HHd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HHd);
      }
      i = f.a.a.b.b.a.bz(7, this.GgG);
      int j = f.a.a.b.b.a.bz(8, this.HHe);
      int k = f.a.a.b.b.a.bz(9, this.Fih);
      int m = f.a.a.b.b.a.bz(10, this.HHf);
      int n = f.a.a.b.b.a.bz(11, this.HHg);
      int i1 = f.a.a.b.b.a.bz(12, this.HcW);
      AppMethodBeat.o(152668);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HHd == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cwc localcwc = (cwc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152668);
        return -1;
      case 1: 
        localcwc.Hzh = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwc.HHa = ((cwf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwc.HHb = ((cwe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 4: 
        localcwc.GSm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 5: 
        localcwc.HHc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 6: 
        localcwc.HHd = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152668);
        return 0;
      case 7: 
        localcwc.GgG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 8: 
        localcwc.HHe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 9: 
        localcwc.Fih = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 10: 
        localcwc.HHf = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 11: 
        localcwc.HHg = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152668);
        return 0;
      }
      localcwc.HcW = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(152668);
      return 0;
    }
    AppMethodBeat.o(152668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwc
 * JD-Core Version:    0.7.0.1
 */