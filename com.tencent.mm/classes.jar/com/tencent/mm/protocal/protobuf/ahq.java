package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahq
  extends com.tencent.mm.cd.a
{
  public LinkedList<ahr> Srt;
  public String content;
  public String title;
  
  public ahq()
  {
    AppMethodBeat.i(91433);
    this.Srt = new LinkedList();
    AppMethodBeat.o(91433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91434);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Srt);
      if (this.content != null) {
        paramVarArgs.f(2, this.content);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      AppMethodBeat.o(91434);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Srt) + 0;
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.content);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      AppMethodBeat.o(91434);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Srt.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91434);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ahq localahq = (ahq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91434);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ahr localahr = new ahr();
          if ((localObject != null) && (localObject.length > 0)) {
            localahr.parseFrom((byte[])localObject);
          }
          localahq.Srt.add(localahr);
          paramInt += 1;
        }
        AppMethodBeat.o(91434);
        return 0;
      case 2: 
        localahq.content = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91434);
        return 0;
      }
      localahq.title = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(91434);
      return 0;
    }
    AppMethodBeat.o(91434);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahq
 * JD-Core Version:    0.7.0.1
 */