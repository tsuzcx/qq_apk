package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfm
  extends com.tencent.mm.bw.a
{
  public boolean Mlw;
  public dlx Mlx;
  public String dQx;
  public String lHA;
  public String lHB;
  public String title;
  public int uSc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91528);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.uSc);
      paramVarArgs.cc(2, this.Mlw);
      if (this.dQx != null) {
        paramVarArgs.e(3, this.dQx);
      }
      if (this.lHA != null) {
        paramVarArgs.e(4, this.lHA);
      }
      if (this.lHB != null) {
        paramVarArgs.e(5, this.lHB);
      }
      if (this.Mlx != null)
      {
        paramVarArgs.ni(6, this.Mlx.computeSize());
        this.Mlx.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.e(7, this.title);
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.uSc) + 0 + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dQx);
      }
      i = paramInt;
      if (this.lHA != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.lHA);
      }
      paramInt = i;
      if (this.lHB != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.lHB);
      }
      i = paramInt;
      if (this.Mlx != null) {
        i = paramInt + g.a.a.a.nh(6, this.Mlx.computeSize());
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.title);
      }
      AppMethodBeat.o(91528);
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
      AppMethodBeat.o(91528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cfm localcfm = (cfm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91528);
        return -1;
      case 1: 
        localcfm.uSc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91528);
        return 0;
      case 2: 
        localcfm.Mlw = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(91528);
        return 0;
      case 3: 
        localcfm.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 4: 
        localcfm.lHA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 5: 
        localcfm.lHB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dlx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcfm.Mlx = ((dlx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91528);
        return 0;
      }
      localcfm.title = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91528);
      return 0;
    }
    AppMethodBeat.o(91528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfm
 * JD-Core Version:    0.7.0.1
 */