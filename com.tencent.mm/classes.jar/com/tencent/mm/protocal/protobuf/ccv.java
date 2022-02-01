package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ccv
  extends com.tencent.mm.bw.a
{
  public String MiH;
  public String MiL;
  public String MiM;
  public String MiN;
  public cyc MiO;
  public int dVv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72508);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MiH == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.dVv);
      if (this.MiH != null) {
        paramVarArgs.e(2, this.MiH);
      }
      if (this.MiL != null) {
        paramVarArgs.e(3, this.MiL);
      }
      if (this.MiM != null) {
        paramVarArgs.e(4, this.MiM);
      }
      if (this.MiN != null) {
        paramVarArgs.e(5, this.MiN);
      }
      if (this.MiO != null)
      {
        paramVarArgs.ni(6, this.MiO.computeSize());
        this.MiO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.dVv) + 0;
      paramInt = i;
      if (this.MiH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MiH);
      }
      i = paramInt;
      if (this.MiL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MiL);
      }
      paramInt = i;
      if (this.MiM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MiM);
      }
      i = paramInt;
      if (this.MiN != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MiN);
      }
      paramInt = i;
      if (this.MiO != null) {
        paramInt = i + g.a.a.a.nh(6, this.MiO.computeSize());
      }
      AppMethodBeat.o(72508);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MiH == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ccv localccv = (ccv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72508);
        return -1;
      case 1: 
        localccv.dVv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72508);
        return 0;
      case 2: 
        localccv.MiH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 3: 
        localccv.MiL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 4: 
        localccv.MiM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 5: 
        localccv.MiN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72508);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cyc();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cyc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localccv.MiO = ((cyc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    AppMethodBeat.o(72508);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccv
 * JD-Core Version:    0.7.0.1
 */