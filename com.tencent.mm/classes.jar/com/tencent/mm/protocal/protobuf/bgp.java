package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgp
  extends com.tencent.mm.cd.a
{
  public long SHt;
  public String SRm;
  public aza SRn;
  public FinderContact contact;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209039);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.oE(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.SRm != null) {
        paramVarArgs.f(2, this.SRm);
      }
      paramVarArgs.bm(3, this.SHt);
      if (this.SRn != null)
      {
        paramVarArgs.oE(4, this.SRn.computeSize());
        this.SRn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209039);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.a.oD(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SRm != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SRm);
      }
      i += g.a.a.b.b.a.p(3, this.SHt);
      paramInt = i;
      if (this.SRn != null) {
        paramInt = i + g.a.a.a.oD(4, this.SRn.computeSize());
      }
      AppMethodBeat.o(209039);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(209039);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgp localbgp = (bgp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209039);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbgp.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(209039);
          return 0;
        case 2: 
          localbgp.SRm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(209039);
          return 0;
        case 3: 
          localbgp.SHt = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(209039);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aza();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aza)localObject2).parseFrom((byte[])localObject1);
          }
          localbgp.SRn = ((aza)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(209039);
        return 0;
      }
      AppMethodBeat.o(209039);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgp
 * JD-Core Version:    0.7.0.1
 */