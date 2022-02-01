package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmm
  extends com.tencent.mm.bw.a
{
  public int KXD;
  public int LUr;
  public doo LVf;
  public boolean LVl;
  public boolean LVm;
  public String LVn;
  public int dIZ;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175245);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dIZ);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.e(3, this.md5);
      }
      paramVarArgs.aM(4, this.LUr);
      paramVarArgs.aM(5, this.KXD);
      paramVarArgs.cc(6, this.LVl);
      paramVarArgs.cc(7, this.LVm);
      if (this.LVf != null)
      {
        paramVarArgs.ni(20, this.LVf.computeSize());
        this.LVf.writeFields(paramVarArgs);
      }
      if (this.LVn != null) {
        paramVarArgs.e(21, this.LVn);
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.dIZ) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.md5);
      }
      i = i + g.a.a.b.b.a.bu(4, this.LUr) + g.a.a.b.b.a.bu(5, this.KXD) + (g.a.a.b.b.a.fS(6) + 1) + (g.a.a.b.b.a.fS(7) + 1);
      paramInt = i;
      if (this.LVf != null) {
        paramInt = i + g.a.a.a.nh(20, this.LVf.computeSize());
      }
      i = paramInt;
      if (this.LVn != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.LVn);
      }
      AppMethodBeat.o(175245);
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
      AppMethodBeat.o(175245);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bmm localbmm = (bmm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        AppMethodBeat.o(175245);
        return -1;
      case 1: 
        localbmm.dIZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(175245);
        return 0;
      case 2: 
        localbmm.url = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 3: 
        localbmm.md5 = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 4: 
        localbmm.LUr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(175245);
        return 0;
      case 5: 
        localbmm.KXD = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(175245);
        return 0;
      case 6: 
        localbmm.LVl = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(175245);
        return 0;
      case 7: 
        localbmm.LVm = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(175245);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((doo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbmm.LVf = ((doo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(175245);
        return 0;
      }
      localbmm.LVn = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(175245);
      return 0;
    }
    AppMethodBeat.o(175245);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmm
 * JD-Core Version:    0.7.0.1
 */