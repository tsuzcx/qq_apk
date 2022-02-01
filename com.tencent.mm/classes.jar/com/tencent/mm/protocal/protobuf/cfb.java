package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfb
  extends com.tencent.mm.bx.a
{
  public bi Zbi;
  public String Zhn;
  public LinkedList<String> aaoM;
  
  public cfb()
  {
    AppMethodBeat.i(91482);
    this.aaoM = new LinkedList();
    AppMethodBeat.o(91482);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91483);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.aaoM);
      if (this.Zbi != null)
      {
        paramVarArgs.qD(2, this.Zbi.computeSize());
        this.Zbi.writeFields(paramVarArgs);
      }
      if (this.Zhn != null) {
        paramVarArgs.g(3, this.Zhn);
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 1, this.aaoM) + 0;
      paramInt = i;
      if (this.Zbi != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zbi.computeSize());
      }
      i = paramInt;
      if (this.Zhn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zhn);
      }
      AppMethodBeat.o(91483);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaoM.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cfb localcfb = (cfb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91483);
        return -1;
      case 1: 
        localcfb.aaoM.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(91483);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bi localbi = new bi();
          if ((localObject != null) && (localObject.length > 0)) {
            localbi.parseFrom((byte[])localObject);
          }
          localcfb.Zbi = localbi;
          paramInt += 1;
        }
        AppMethodBeat.o(91483);
        return 0;
      }
      localcfb.Zhn = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(91483);
      return 0;
    }
    AppMethodBeat.o(91483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfb
 * JD-Core Version:    0.7.0.1
 */