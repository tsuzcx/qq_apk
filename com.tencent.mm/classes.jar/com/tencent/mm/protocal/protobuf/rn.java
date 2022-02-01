package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class rn
  extends com.tencent.mm.cd.a
{
  public LinkedList<ru> COK;
  public long Sap;
  public int Saq;
  public LinkedList<String> Sar;
  public String Sas;
  public int Sat;
  public String fwr;
  public int rVW;
  
  public rn()
  {
    AppMethodBeat.i(117842);
    this.Sar = new LinkedList();
    this.COK = new LinkedList();
    AppMethodBeat.o(117842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117843);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sas == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.Sap);
      paramVarArgs.aY(2, this.Saq);
      if (this.fwr != null) {
        paramVarArgs.f(3, this.fwr);
      }
      paramVarArgs.e(4, 1, this.Sar);
      paramVarArgs.e(5, 8, this.COK);
      paramVarArgs.aY(6, this.rVW);
      if (this.Sas != null) {
        paramVarArgs.f(7, this.Sas);
      }
      paramVarArgs.aY(8, this.Sat);
      AppMethodBeat.o(117843);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Sap) + 0 + g.a.a.b.b.a.bM(2, this.Saq);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fwr);
      }
      i = paramInt + g.a.a.a.c(4, 1, this.Sar) + g.a.a.a.c(5, 8, this.COK) + g.a.a.b.b.a.bM(6, this.rVW);
      paramInt = i;
      if (this.Sas != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sas);
      }
      i = g.a.a.b.b.a.bM(8, this.Sat);
      AppMethodBeat.o(117843);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Sar.clear();
      this.COK.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.Sas == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117843);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      rn localrn = (rn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117843);
        return -1;
      case 1: 
        localrn.Sap = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(117843);
        return 0;
      case 2: 
        localrn.Saq = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(117843);
        return 0;
      case 3: 
        localrn.fwr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(117843);
        return 0;
      case 4: 
        localrn.Sar.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(117843);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ru localru = new ru();
          if ((localObject != null) && (localObject.length > 0)) {
            localru.parseFrom((byte[])localObject);
          }
          localrn.COK.add(localru);
          paramInt += 1;
        }
        AppMethodBeat.o(117843);
        return 0;
      case 6: 
        localrn.rVW = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(117843);
        return 0;
      case 7: 
        localrn.Sas = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(117843);
        return 0;
      }
      localrn.Sat = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(117843);
      return 0;
    }
    AppMethodBeat.o(117843);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rn
 * JD-Core Version:    0.7.0.1
 */