package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvh
  extends com.tencent.mm.cd.a
{
  public erh SpR;
  public String Ubm;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91664);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.Ubm != null) {
        paramVarArgs.f(2, this.Ubm);
      }
      if (this.SpR != null)
      {
        paramVarArgs.oE(3, this.SpR.computeSize());
        this.SpR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.Ubm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Ubm);
      }
      i = paramInt;
      if (this.SpR != null) {
        i = paramInt + g.a.a.a.oD(3, this.SpR.computeSize());
      }
      AppMethodBeat.o(91664);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dvh localdvh = (dvh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91664);
        return -1;
      case 1: 
        localdvh.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91664);
        return 0;
      case 2: 
        localdvh.Ubm = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91664);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        erh localerh = new erh();
        if ((localObject != null) && (localObject.length > 0)) {
          localerh.parseFrom((byte[])localObject);
        }
        localdvh.SpR = localerh;
        paramInt += 1;
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    AppMethodBeat.o(91664);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvh
 * JD-Core Version:    0.7.0.1
 */