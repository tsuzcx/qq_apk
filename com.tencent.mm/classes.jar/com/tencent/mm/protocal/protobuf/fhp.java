package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhp
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public int UHA;
  public fht UHB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(254190);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UHA);
      if (this.CMP != null) {
        paramVarArgs.f(2, this.CMP);
      }
      if (this.UHB != null)
      {
        paramVarArgs.oE(3, this.UHB.computeSize());
        this.UHB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(254190);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.UHA) + 0;
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMP);
      }
      i = paramInt;
      if (this.UHB != null) {
        i = paramInt + g.a.a.a.oD(3, this.UHB.computeSize());
      }
      AppMethodBeat.o(254190);
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
      AppMethodBeat.o(254190);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fhp localfhp = (fhp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(254190);
        return -1;
      case 1: 
        localfhp.UHA = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(254190);
        return 0;
      case 2: 
        localfhp.CMP = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(254190);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fht localfht = new fht();
        if ((localObject != null) && (localObject.length > 0)) {
          localfht.parseFrom((byte[])localObject);
        }
        localfhp.UHB = localfht;
        paramInt += 1;
      }
      AppMethodBeat.o(254190);
      return 0;
    }
    AppMethodBeat.o(254190);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhp
 * JD-Core Version:    0.7.0.1
 */