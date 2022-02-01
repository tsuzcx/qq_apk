package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnc
  extends com.tencent.mm.cd.a
{
  public evb TUs;
  public int Tgp;
  public String Tgq;
  public String Tgr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32369);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Tgp);
      if (this.Tgq != null) {
        paramVarArgs.f(2, this.Tgq);
      }
      if (this.Tgr != null) {
        paramVarArgs.f(3, this.Tgr);
      }
      if (this.TUs != null)
      {
        paramVarArgs.oE(4, this.TUs.computeSize());
        this.TUs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Tgp) + 0;
      paramInt = i;
      if (this.Tgq != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tgq);
      }
      i = paramInt;
      if (this.Tgr != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tgr);
      }
      paramInt = i;
      if (this.TUs != null) {
        paramInt = i + g.a.a.a.oD(4, this.TUs.computeSize());
      }
      AppMethodBeat.o(32369);
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
      AppMethodBeat.o(32369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dnc localdnc = (dnc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32369);
        return -1;
      case 1: 
        localdnc.Tgp = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32369);
        return 0;
      case 2: 
        localdnc.Tgq = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32369);
        return 0;
      case 3: 
        localdnc.Tgr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32369);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        evb localevb = new evb();
        if ((localObject != null) && (localObject.length > 0)) {
          localevb.parseFrom((byte[])localObject);
        }
        localdnc.TUs = localevb;
        paramInt += 1;
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    AppMethodBeat.o(32369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnc
 * JD-Core Version:    0.7.0.1
 */