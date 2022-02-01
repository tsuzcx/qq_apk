package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eip
  extends com.tencent.mm.bw.a
{
  public int LHa;
  public int NhL;
  public String NhM;
  public eio NhN;
  public boolean dEF;
  public String id;
  public int iqg;
  public String lYE;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153001);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LHa);
      paramVarArgs.aM(2, this.iqg);
      paramVarArgs.aM(3, this.NhL);
      paramVarArgs.aM(4, this.type);
      if (this.id != null) {
        paramVarArgs.e(5, this.id);
      }
      if (this.lYE != null) {
        paramVarArgs.e(6, this.lYE);
      }
      if (this.NhM != null) {
        paramVarArgs.e(7, this.NhM);
      }
      if (this.NhN != null)
      {
        paramVarArgs.ni(8, this.NhN.computeSize());
        this.NhN.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(9, this.dEF);
      AppMethodBeat.o(153001);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LHa) + 0 + g.a.a.b.b.a.bu(2, this.iqg) + g.a.a.b.b.a.bu(3, this.NhL) + g.a.a.b.b.a.bu(4, this.type);
      paramInt = i;
      if (this.id != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.id);
      }
      i = paramInt;
      if (this.lYE != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.lYE);
      }
      paramInt = i;
      if (this.NhM != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.NhM);
      }
      i = paramInt;
      if (this.NhN != null) {
        i = paramInt + g.a.a.a.nh(8, this.NhN.computeSize());
      }
      paramInt = g.a.a.b.b.a.fS(9);
      AppMethodBeat.o(153001);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153001);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eip localeip = (eip)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153001);
        return -1;
      case 1: 
        localeip.LHa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153001);
        return 0;
      case 2: 
        localeip.iqg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153001);
        return 0;
      case 3: 
        localeip.NhL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153001);
        return 0;
      case 4: 
        localeip.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153001);
        return 0;
      case 5: 
        localeip.id = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 6: 
        localeip.lYE = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 7: 
        localeip.NhM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eio();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eio)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeip.NhN = ((eio)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153001);
        return 0;
      }
      localeip.dEF = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(153001);
      return 0;
    }
    AppMethodBeat.o(153001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eip
 * JD-Core Version:    0.7.0.1
 */