package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doi
  extends com.tencent.mm.cd.a
{
  public LinkedList<doh> NlY;
  public String TVA;
  public String TVB;
  public LinkedList<edf> TVz;
  
  public doi()
  {
    AppMethodBeat.i(226573);
    this.NlY = new LinkedList();
    this.TVz = new LinkedList();
    AppMethodBeat.o(226573);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226582);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.NlY);
      paramVarArgs.e(2, 8, this.TVz);
      if (this.TVA != null) {
        paramVarArgs.f(3, this.TVA);
      }
      if (this.TVB != null) {
        paramVarArgs.f(4, this.TVB);
      }
      AppMethodBeat.o(226582);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.NlY) + 0 + g.a.a.a.c(2, 8, this.TVz);
      paramInt = i;
      if (this.TVA != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TVA);
      }
      i = paramInt;
      if (this.TVB != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TVB);
      }
      AppMethodBeat.o(226582);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NlY.clear();
      this.TVz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(226582);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      doi localdoi = (doi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(226582);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new doh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((doh)localObject2).parseFrom((byte[])localObject1);
          }
          localdoi.NlY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(226582);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new edf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((edf)localObject2).parseFrom((byte[])localObject1);
          }
          localdoi.TVz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(226582);
        return 0;
      case 3: 
        localdoi.TVA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(226582);
        return 0;
      }
      localdoi.TVB = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(226582);
      return 0;
    }
    AppMethodBeat.o(226582);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doi
 * JD-Core Version:    0.7.0.1
 */