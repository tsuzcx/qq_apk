package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coj
  extends com.tencent.mm.cd.a
{
  public boolean Twp;
  public dvp Twq;
  public int jump_type;
  public String oDJ;
  public String oDK;
  public String title;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91528);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jump_type);
      paramVarArgs.co(2, this.Twp);
      if (this.wording != null) {
        paramVarArgs.f(3, this.wording);
      }
      if (this.oDJ != null) {
        paramVarArgs.f(4, this.oDJ);
      }
      if (this.oDK != null) {
        paramVarArgs.f(5, this.oDK);
      }
      if (this.Twq != null)
      {
        paramVarArgs.oE(6, this.Twq.computeSize());
        this.Twq.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.f(7, this.title);
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.jump_type) + 0 + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.wording);
      }
      i = paramInt;
      if (this.oDJ != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.oDJ);
      }
      paramInt = i;
      if (this.oDK != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.oDK);
      }
      i = paramInt;
      if (this.Twq != null) {
        i = paramInt + g.a.a.a.oD(6, this.Twq.computeSize());
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.title);
      }
      AppMethodBeat.o(91528);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      coj localcoj = (coj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91528);
        return -1;
      case 1: 
        localcoj.jump_type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91528);
        return 0;
      case 2: 
        localcoj.Twp = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(91528);
        return 0;
      case 3: 
        localcoj.wording = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 4: 
        localcoj.oDJ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 5: 
        localcoj.oDK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dvp localdvp = new dvp();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvp.parseFrom((byte[])localObject);
          }
          localcoj.Twq = localdvp;
          paramInt += 1;
        }
        AppMethodBeat.o(91528);
        return 0;
      }
      localcoj.title = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(91528);
      return 0;
    }
    AppMethodBeat.o(91528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coj
 * JD-Core Version:    0.7.0.1
 */