package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class asr
  extends com.tencent.mm.cd.a
{
  public int continueFlag;
  public b lastBuffer;
  public LinkedList<FinderObject> wHI;
  public String wording;
  
  public asr()
  {
    AppMethodBeat.i(204181);
    this.wHI = new LinkedList();
    AppMethodBeat.o(204181);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204182);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wHI);
      if (this.lastBuffer != null) {
        paramVarArgs.c(2, this.lastBuffer);
      }
      paramVarArgs.aY(3, this.continueFlag);
      if (this.wording != null) {
        paramVarArgs.f(4, this.wording);
      }
      AppMethodBeat.o(204182);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.wHI) + 0;
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.continueFlag);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.wording);
      }
      AppMethodBeat.o(204182);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wHI.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(204182);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      asr localasr = (asr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(204182);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderObject localFinderObject = new FinderObject();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderObject.parseFrom((byte[])localObject);
          }
          localasr.wHI.add(localFinderObject);
          paramInt += 1;
        }
        AppMethodBeat.o(204182);
        return 0;
      case 2: 
        localasr.lastBuffer = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(204182);
        return 0;
      case 3: 
        localasr.continueFlag = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(204182);
        return 0;
      }
      localasr.wording = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(204182);
      return 0;
    }
    AppMethodBeat.o(204182);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asr
 * JD-Core Version:    0.7.0.1
 */