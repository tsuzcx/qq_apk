package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class tv
  extends com.tencent.mm.bw.a
{
  public String CeI;
  public LinkedList<sy> Lbb;
  public erc Lce;
  public int Lcf;
  public int Lcg;
  
  public tv()
  {
    AppMethodBeat.i(218978);
    this.Lbb = new LinkedList();
    AppMethodBeat.o(218978);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218979);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lce == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(218979);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.Lbb);
      if (this.Lce != null)
      {
        paramVarArgs.ni(2, this.Lce.computeSize());
        this.Lce.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.Lcf);
      paramVarArgs.aM(4, this.Lcg);
      if (this.CeI != null) {
        paramVarArgs.e(5, this.CeI);
      }
      AppMethodBeat.o(218979);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Lbb) + 0;
      paramInt = i;
      if (this.Lce != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lce.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Lcf) + g.a.a.b.b.a.bu(4, this.Lcg);
      paramInt = i;
      if (this.CeI != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.CeI);
      }
      AppMethodBeat.o(218979);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lbb.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Lce == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(218979);
        throw paramVarArgs;
      }
      AppMethodBeat.o(218979);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      tv localtv = (tv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(218979);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localtv.Lbb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(218979);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new erc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((erc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localtv.Lce = ((erc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(218979);
        return 0;
      case 3: 
        localtv.Lcf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(218979);
        return 0;
      case 4: 
        localtv.Lcg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(218979);
        return 0;
      }
      localtv.CeI = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(218979);
      return 0;
    }
    AppMethodBeat.o(218979);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tv
 * JD-Core Version:    0.7.0.1
 */