package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class czb
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public gol YLa;
  public long aaEe;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32320);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32320);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.aaEe);
      paramVarArgs.bS(2, this.CreateTime);
      if (this.YLa != null)
      {
        paramVarArgs.qD(3, this.YLa.computeSize());
        this.YLa.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.vhJ);
      AppMethodBeat.o(32320);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.aaEe) + 0 + i.a.a.b.b.a.cJ(2, this.CreateTime);
      paramInt = i;
      if (this.YLa != null) {
        paramInt = i + i.a.a.a.qC(3, this.YLa.computeSize());
      }
      i = i.a.a.b.b.a.cJ(4, this.vhJ);
      AppMethodBeat.o(32320);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32320);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32320);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      czb localczb = (czb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32320);
        return -1;
      case 1: 
        localczb.aaEe = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(32320);
        return 0;
      case 2: 
        localczb.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32320);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gol localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localczb.YLa = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(32320);
        return 0;
      }
      localczb.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(32320);
      return 0;
    }
    AppMethodBeat.o(32320);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czb
 * JD-Core Version:    0.7.0.1
 */