package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public LinkedList<a> YzI;
  public int YzJ;
  public int id;
  public String msg;
  public String title;
  
  public b()
  {
    AppMethodBeat.i(123717);
    this.YzI = new LinkedList();
    AppMethodBeat.o(123717);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123718);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.id);
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.msg != null) {
        paramVarArgs.g(3, this.msg);
      }
      paramVarArgs.e(4, 8, this.YzI);
      paramVarArgs.bS(5, this.YzJ);
      AppMethodBeat.o(123718);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.id) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.msg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.msg);
      }
      paramInt = i.a.a.a.c(4, 8, this.YzI);
      int j = i.a.a.b.b.a.cJ(5, this.YzJ);
      AppMethodBeat.o(123718);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YzI.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(123718);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123718);
        return -1;
      case 1: 
        localb.id = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(123718);
        return 0;
      case 2: 
        localb.title = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123718);
        return 0;
      case 3: 
        localb.msg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123718);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          a locala = new a();
          if ((localObject != null) && (localObject.length > 0)) {
            locala.parseFrom((byte[])localObject);
          }
          localb.YzI.add(locala);
          paramInt += 1;
        }
        AppMethodBeat.o(123718);
        return 0;
      }
      localb.YzJ = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(123718);
      return 0;
    }
    AppMethodBeat.o(123718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.b
 * JD-Core Version:    0.7.0.1
 */