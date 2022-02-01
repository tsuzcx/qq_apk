package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ecy
  extends com.tencent.mm.bw.a
{
  public b Ndn;
  public aiq Ndo;
  public aip Ndp;
  public int height;
  public String path;
  public int type;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201301);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.path != null) {
        paramVarArgs.e(2, this.path);
      }
      if (this.Ndn != null) {
        paramVarArgs.c(3, this.Ndn);
      }
      paramVarArgs.aM(4, this.width);
      paramVarArgs.aM(5, this.height);
      if (this.Ndo != null)
      {
        paramVarArgs.ni(6, this.Ndo.computeSize());
        this.Ndo.writeFields(paramVarArgs);
      }
      if (this.Ndp != null)
      {
        paramVarArgs.ni(7, this.Ndp.computeSize());
        this.Ndp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(201301);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.path);
      }
      i = paramInt;
      if (this.Ndn != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Ndn);
      }
      i = i + g.a.a.b.b.a.bu(4, this.width) + g.a.a.b.b.a.bu(5, this.height);
      paramInt = i;
      if (this.Ndo != null) {
        paramInt = i + g.a.a.a.nh(6, this.Ndo.computeSize());
      }
      i = paramInt;
      if (this.Ndp != null) {
        i = paramInt + g.a.a.a.nh(7, this.Ndp.computeSize());
      }
      AppMethodBeat.o(201301);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(201301);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ecy localecy = (ecy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(201301);
        return -1;
      case 1: 
        localecy.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(201301);
        return 0;
      case 2: 
        localecy.path = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(201301);
        return 0;
      case 3: 
        localecy.Ndn = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(201301);
        return 0;
      case 4: 
        localecy.width = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(201301);
        return 0;
      case 5: 
        localecy.height = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(201301);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aiq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aiq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localecy.Ndo = ((aiq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201301);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aip();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aip)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localecy.Ndp = ((aip)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(201301);
      return 0;
    }
    AppMethodBeat.o(201301);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecy
 * JD-Core Version:    0.7.0.1
 */