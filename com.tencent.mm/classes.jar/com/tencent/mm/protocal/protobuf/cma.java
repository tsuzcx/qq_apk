package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cma
  extends com.tencent.mm.cd.a
{
  public dms TtR;
  public dms TtS;
  public int TtT;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276512);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      if (this.TtR != null)
      {
        paramVarArgs.oE(2, this.TtR.computeSize());
        this.TtR.writeFields(paramVarArgs);
      }
      if (this.TtS != null)
      {
        paramVarArgs.oE(3, this.TtS.computeSize());
        this.TtS.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.TtT);
      AppMethodBeat.o(276512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label526;
      }
    }
    label526:
    for (int i = g.a.a.b.b.a.g(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TtR != null) {
        paramInt = i + g.a.a.a.oD(2, this.TtR.computeSize());
      }
      i = paramInt;
      if (this.TtS != null) {
        i = paramInt + g.a.a.a.oD(3, this.TtS.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.TtT);
      AppMethodBeat.o(276512);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(276512);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cma localcma = (cma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dms localdms;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(276512);
          return -1;
        case 1: 
          localcma.wording = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(276512);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdms = new dms();
            if ((localObject != null) && (localObject.length > 0)) {
              localdms.parseFrom((byte[])localObject);
            }
            localcma.TtR = localdms;
            paramInt += 1;
          }
          AppMethodBeat.o(276512);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdms = new dms();
            if ((localObject != null) && (localObject.length > 0)) {
              localdms.parseFrom((byte[])localObject);
            }
            localcma.TtS = localdms;
            paramInt += 1;
          }
          AppMethodBeat.o(276512);
          return 0;
        }
        localcma.TtT = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(276512);
        return 0;
      }
      AppMethodBeat.o(276512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cma
 * JD-Core Version:    0.7.0.1
 */