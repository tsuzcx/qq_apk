package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class axn
  extends com.tencent.mm.bx.a
{
  public int AYX;
  public LinkedList<FinderObject> ZIQ;
  public int lNX;
  public String username;
  
  public axn()
  {
    AppMethodBeat.i(259800);
    this.ZIQ = new LinkedList();
    AppMethodBeat.o(259800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259804);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.AYX);
      paramVarArgs.e(2, 8, this.ZIQ);
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      paramVarArgs.bS(4, this.lNX);
      AppMethodBeat.o(259804);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.AYX) + 0 + i.a.a.a.c(2, 8, this.ZIQ);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.username);
      }
      i = i.a.a.b.b.a.cJ(4, this.lNX);
      AppMethodBeat.o(259804);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZIQ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259804);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      axn localaxn = (axn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259804);
        return -1;
      case 1: 
        localaxn.AYX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259804);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderObject localFinderObject = new FinderObject();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderObject.parseFrom((byte[])localObject);
          }
          localaxn.ZIQ.add(localFinderObject);
          paramInt += 1;
        }
        AppMethodBeat.o(259804);
        return 0;
      case 3: 
        localaxn.username = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259804);
        return 0;
      }
      localaxn.lNX = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(259804);
      return 0;
    }
    AppMethodBeat.o(259804);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axn
 * JD-Core Version:    0.7.0.1
 */