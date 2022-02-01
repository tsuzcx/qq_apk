package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akh
  extends com.tencent.mm.bx.a
{
  public LinkedList<aki> Zqv;
  public String content;
  public String title;
  
  public akh()
  {
    AppMethodBeat.i(91433);
    this.Zqv = new LinkedList();
    AppMethodBeat.o(91433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91434);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Zqv);
      if (this.content != null) {
        paramVarArgs.g(2, this.content);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      AppMethodBeat.o(91434);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.Zqv) + 0;
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.content);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      AppMethodBeat.o(91434);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zqv.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91434);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      akh localakh = (akh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91434);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aki localaki = new aki();
          if ((localObject != null) && (localObject.length > 0)) {
            localaki.parseFrom((byte[])localObject);
          }
          localakh.Zqv.add(localaki);
          paramInt += 1;
        }
        AppMethodBeat.o(91434);
        return 0;
      case 2: 
        localakh.content = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91434);
        return 0;
      }
      localakh.title = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(91434);
      return 0;
    }
    AppMethodBeat.o(91434);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akh
 * JD-Core Version:    0.7.0.1
 */