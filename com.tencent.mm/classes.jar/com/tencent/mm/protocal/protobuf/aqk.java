package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqk
  extends com.tencent.mm.bw.a
{
  public int LCy;
  public long LCz;
  public int LzC;
  public FinderContact contact;
  public String coverImgUrl;
  public String description;
  public String eventName;
  public int tUe;
  public long twd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209374);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.twd);
      if (this.contact != null)
      {
        paramVarArgs.ni(2, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.eventName != null) {
        paramVarArgs.e(3, this.eventName);
      }
      if (this.description != null) {
        paramVarArgs.e(4, this.description);
      }
      paramVarArgs.aM(5, this.LCy);
      if (this.coverImgUrl != null) {
        paramVarArgs.e(6, this.coverImgUrl);
      }
      paramVarArgs.bb(7, this.LCz);
      paramVarArgs.aM(8, this.LzC);
      paramVarArgs.aM(9, this.tUe);
      AppMethodBeat.o(209374);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.twd) + 0;
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + g.a.a.a.nh(2, this.contact.computeSize());
      }
      i = paramInt;
      if (this.eventName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.eventName);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.description);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LCy);
      paramInt = i;
      if (this.coverImgUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.coverImgUrl);
      }
      i = g.a.a.b.b.a.r(7, this.LCz);
      int j = g.a.a.b.b.a.bu(8, this.LzC);
      int k = g.a.a.b.b.a.bu(9, this.tUe);
      AppMethodBeat.o(209374);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209374);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aqk localaqk = (aqk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209374);
        return -1;
      case 1: 
        localaqk.twd = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209374);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaqk.contact = ((FinderContact)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209374);
        return 0;
      case 3: 
        localaqk.eventName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209374);
        return 0;
      case 4: 
        localaqk.description = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209374);
        return 0;
      case 5: 
        localaqk.LCy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209374);
        return 0;
      case 6: 
        localaqk.coverImgUrl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209374);
        return 0;
      case 7: 
        localaqk.LCz = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209374);
        return 0;
      case 8: 
        localaqk.LzC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209374);
        return 0;
      }
      localaqk.tUe = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(209374);
      return 0;
    }
    AppMethodBeat.o(209374);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqk
 * JD-Core Version:    0.7.0.1
 */