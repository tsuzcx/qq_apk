package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fmm
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> ULh;
  public LinkedList<fml> ULi;
  public int version;
  
  public fmm()
  {
    AppMethodBeat.i(250530);
    this.ULh = new LinkedList();
    this.ULi = new LinkedList();
    AppMethodBeat.o(250530);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250533);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.version);
      paramVarArgs.e(2, 1, this.ULh);
      paramVarArgs.e(3, 8, this.ULi);
      AppMethodBeat.o(250533);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.version);
      i = g.a.a.a.c(2, 1, this.ULh);
      int j = g.a.a.a.c(3, 8, this.ULi);
      AppMethodBeat.o(250533);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ULh.clear();
      this.ULi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(250533);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fmm localfmm = (fmm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(250533);
        return -1;
      case 1: 
        localfmm.version = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(250533);
        return 0;
      case 2: 
        localfmm.ULh.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(250533);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fml localfml = new fml();
        if ((localObject != null) && (localObject.length > 0)) {
          localfml.parseFrom((byte[])localObject);
        }
        localfmm.ULi.add(localfml);
        paramInt += 1;
      }
      AppMethodBeat.o(250533);
      return 0;
    }
    AppMethodBeat.o(250533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmm
 * JD-Core Version:    0.7.0.1
 */