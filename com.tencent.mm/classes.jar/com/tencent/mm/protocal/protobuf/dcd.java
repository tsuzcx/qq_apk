package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcd
  extends com.tencent.mm.cd.a
{
  public erh RGf;
  public String ROQ;
  public LinkedList<erh> Sfr;
  public String TJE;
  
  public dcd()
  {
    AppMethodBeat.i(91553);
    this.Sfr = new LinkedList();
    AppMethodBeat.o(91553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91554);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RGf != null)
      {
        paramVarArgs.oE(1, this.RGf.computeSize());
        this.RGf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Sfr);
      if (this.ROQ != null) {
        paramVarArgs.f(3, this.ROQ);
      }
      if (this.TJE != null) {
        paramVarArgs.f(4, this.TJE);
      }
      AppMethodBeat.o(91554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RGf == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.a.oD(1, this.RGf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Sfr);
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ROQ);
      }
      i = paramInt;
      if (this.TJE != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TJE);
      }
      AppMethodBeat.o(91554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sfr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dcd localdcd = (dcd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        erh localerh;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91554);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localerh = new erh();
            if ((localObject != null) && (localObject.length > 0)) {
              localerh.parseFrom((byte[])localObject);
            }
            localdcd.RGf = localerh;
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localerh = new erh();
            if ((localObject != null) && (localObject.length > 0)) {
              localerh.parseFrom((byte[])localObject);
            }
            localdcd.Sfr.add(localerh);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 3: 
          localdcd.ROQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91554);
          return 0;
        }
        localdcd.TJE = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91554);
        return 0;
      }
      AppMethodBeat.o(91554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcd
 * JD-Core Version:    0.7.0.1
 */