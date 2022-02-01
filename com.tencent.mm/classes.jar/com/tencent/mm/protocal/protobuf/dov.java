package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dov
  extends com.tencent.mm.bw.a
{
  public int JZb;
  public int LWr;
  public int Lbj;
  public int MJT;
  public doy MSk;
  public dox MSl;
  public int MSm;
  public String MSn;
  public int MSo;
  public int MSp;
  public int MSq;
  public int MhZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152668);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MSn == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.MJT);
      if (this.MSk != null)
      {
        paramVarArgs.ni(2, this.MSk.computeSize());
        this.MSk.writeFields(paramVarArgs);
      }
      if (this.MSl != null)
      {
        paramVarArgs.ni(3, this.MSl.computeSize());
        this.MSl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.LWr);
      paramVarArgs.aM(5, this.MSm);
      if (this.MSn != null) {
        paramVarArgs.e(6, this.MSn);
      }
      paramVarArgs.aM(7, this.Lbj);
      paramVarArgs.aM(8, this.MSo);
      paramVarArgs.aM(9, this.JZb);
      paramVarArgs.aM(10, this.MSp);
      paramVarArgs.aM(11, this.MSq);
      paramVarArgs.aM(12, this.MhZ);
      AppMethodBeat.o(152668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MJT) + 0;
      paramInt = i;
      if (this.MSk != null) {
        paramInt = i + g.a.a.a.nh(2, this.MSk.computeSize());
      }
      i = paramInt;
      if (this.MSl != null) {
        i = paramInt + g.a.a.a.nh(3, this.MSl.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(4, this.LWr) + g.a.a.b.b.a.bu(5, this.MSm);
      paramInt = i;
      if (this.MSn != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MSn);
      }
      i = g.a.a.b.b.a.bu(7, this.Lbj);
      int j = g.a.a.b.b.a.bu(8, this.MSo);
      int k = g.a.a.b.b.a.bu(9, this.JZb);
      int m = g.a.a.b.b.a.bu(10, this.MSp);
      int n = g.a.a.b.b.a.bu(11, this.MSq);
      int i1 = g.a.a.b.b.a.bu(12, this.MhZ);
      AppMethodBeat.o(152668);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MSn == null)
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
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dov localdov = (dov)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152668);
        return -1;
      case 1: 
        localdov.MJT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152668);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdov.MSk = ((doy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dox();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dox)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdov.MSl = ((dox)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 4: 
        localdov.LWr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152668);
        return 0;
      case 5: 
        localdov.MSm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152668);
        return 0;
      case 6: 
        localdov.MSn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152668);
        return 0;
      case 7: 
        localdov.Lbj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152668);
        return 0;
      case 8: 
        localdov.MSo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152668);
        return 0;
      case 9: 
        localdov.JZb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152668);
        return 0;
      case 10: 
        localdov.MSp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152668);
        return 0;
      case 11: 
        localdov.MSq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152668);
        return 0;
      }
      localdov.MhZ = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(152668);
      return 0;
    }
    AppMethodBeat.o(152668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dov
 * JD-Core Version:    0.7.0.1
 */