package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cdl
  extends com.tencent.mm.bw.a
{
  public String KPz;
  public String LoI;
  public dqi Mjj;
  public int Mjk;
  public String UserName;
  public int rBx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155423);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.rBx);
      if (this.Mjj != null)
      {
        paramVarArgs.ni(2, this.Mjj.computeSize());
        this.Mjj.writeFields(paramVarArgs);
      }
      if (this.KPz != null) {
        paramVarArgs.e(3, this.KPz);
      }
      if (this.LoI != null) {
        paramVarArgs.e(4, this.LoI);
      }
      if (this.UserName != null) {
        paramVarArgs.e(5, this.UserName);
      }
      paramVarArgs.aM(6, this.Mjk);
      AppMethodBeat.o(155423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.rBx) + 0;
      paramInt = i;
      if (this.Mjj != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mjj.computeSize());
      }
      i = paramInt;
      if (this.KPz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KPz);
      }
      paramInt = i;
      if (this.LoI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LoI);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.UserName);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.Mjk);
      AppMethodBeat.o(155423);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Mjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      AppMethodBeat.o(155423);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cdl localcdl = (cdl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155423);
        return -1;
      case 1: 
        localcdl.rBx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155423);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcdl.Mjj = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155423);
        return 0;
      case 3: 
        localcdl.KPz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 4: 
        localcdl.LoI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 5: 
        localcdl.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155423);
        return 0;
      }
      localcdl.Mjk = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(155423);
      return 0;
    }
    AppMethodBeat.o(155423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdl
 * JD-Core Version:    0.7.0.1
 */