package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avk
  extends com.tencent.mm.bw.a
{
  public String LGb;
  public int LGc;
  public String LGd;
  public String LGe;
  public awx LGf;
  public LinkedList<awx> LGg;
  public String LnW;
  public String Lob;
  public int Loh;
  
  public avk()
  {
    AppMethodBeat.i(209503);
    this.LGg = new LinkedList();
    AppMethodBeat.o(209503);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Loh);
      if (this.LGb != null) {
        paramVarArgs.e(2, this.LGb);
      }
      paramVarArgs.aM(3, this.LGc);
      if (this.LnW != null) {
        paramVarArgs.e(4, this.LnW);
      }
      if (this.LGd != null) {
        paramVarArgs.e(5, this.LGd);
      }
      if (this.LGe != null) {
        paramVarArgs.e(6, this.LGe);
      }
      if (this.Lob != null) {
        paramVarArgs.e(7, this.Lob);
      }
      if (this.LGf != null)
      {
        paramVarArgs.ni(8, this.LGf.computeSize());
        this.LGf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.LGg);
      AppMethodBeat.o(209504);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Loh) + 0;
      paramInt = i;
      if (this.LGb != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LGb);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.LGc);
      paramInt = i;
      if (this.LnW != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LnW);
      }
      i = paramInt;
      if (this.LGd != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LGd);
      }
      paramInt = i;
      if (this.LGe != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LGe);
      }
      i = paramInt;
      if (this.Lob != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lob);
      }
      paramInt = i;
      if (this.LGf != null) {
        paramInt = i + g.a.a.a.nh(8, this.LGf.computeSize());
      }
      i = g.a.a.a.c(9, 8, this.LGg);
      AppMethodBeat.o(209504);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LGg.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209504);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      avk localavk = (avk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209504);
        return -1;
      case 1: 
        localavk.Loh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209504);
        return 0;
      case 2: 
        localavk.LGb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209504);
        return 0;
      case 3: 
        localavk.LGc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209504);
        return 0;
      case 4: 
        localavk.LnW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209504);
        return 0;
      case 5: 
        localavk.LGd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209504);
        return 0;
      case 6: 
        localavk.LGe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209504);
        return 0;
      case 7: 
        localavk.Lob = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209504);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localavk.LGf = ((awx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209504);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new awx();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((awx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localavk.LGg.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209504);
      return 0;
    }
    AppMethodBeat.o(209504);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avk
 * JD-Core Version:    0.7.0.1
 */