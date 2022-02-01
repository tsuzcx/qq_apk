package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pd
  extends com.tencent.mm.bx.a
{
  public String YSA;
  public LinkedList<gdt> YSw;
  public LinkedList<String> YSy;
  public String YSz;
  
  public pd()
  {
    AppMethodBeat.i(258417);
    this.YSw = new LinkedList();
    this.YSy = new LinkedList();
    AppMethodBeat.o(258417);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258420);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(15, 8, this.YSw);
      paramVarArgs.e(17, 1, this.YSy);
      if (this.YSz != null) {
        paramVarArgs.g(18, this.YSz);
      }
      if (this.YSA != null) {
        paramVarArgs.g(19, this.YSA);
      }
      AppMethodBeat.o(258420);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(15, 8, this.YSw) + 0 + i.a.a.a.c(17, 1, this.YSy);
      paramInt = i;
      if (this.YSz != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.YSz);
      }
      i = paramInt;
      if (this.YSA != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.YSA);
      }
      AppMethodBeat.o(258420);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YSw.clear();
      this.YSy.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258420);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      pd localpd = (pd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 16: 
      default: 
        AppMethodBeat.o(258420);
        return -1;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gdt localgdt = new gdt();
          if ((localObject != null) && (localObject.length > 0)) {
            localgdt.parseFrom((byte[])localObject);
          }
          localpd.YSw.add(localgdt);
          paramInt += 1;
        }
        AppMethodBeat.o(258420);
        return 0;
      case 17: 
        localpd.YSy.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(258420);
        return 0;
      case 18: 
        localpd.YSz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258420);
        return 0;
      }
      localpd.YSA = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258420);
      return 0;
    }
    AppMethodBeat.o(258420);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pd
 * JD-Core Version:    0.7.0.1
 */