package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwh
  extends com.tencent.mm.cd.a
{
  public coi Ucm;
  public coi Ucn;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72578);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      if (this.Ucm != null)
      {
        paramVarArgs.oE(2, this.Ucm.computeSize());
        this.Ucm.writeFields(paramVarArgs);
      }
      if (this.Ucn != null)
      {
        paramVarArgs.oE(3, this.Ucn.computeSize());
        this.Ucn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label482;
      }
    }
    label482:
    for (int i = g.a.a.b.b.a.g(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ucm != null) {
        paramInt = i + g.a.a.a.oD(2, this.Ucm.computeSize());
      }
      i = paramInt;
      if (this.Ucn != null) {
        i = paramInt + g.a.a.a.oD(3, this.Ucn.computeSize());
      }
      AppMethodBeat.o(72578);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dwh localdwh = (dwh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        coi localcoi;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72578);
          return -1;
        case 1: 
          localdwh.wording = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72578);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localcoi = new coi();
            if ((localObject != null) && (localObject.length > 0)) {
              localcoi.parseFrom((byte[])localObject);
            }
            localdwh.Ucm = localcoi;
            paramInt += 1;
          }
          AppMethodBeat.o(72578);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localcoi = new coi();
          if ((localObject != null) && (localObject.length > 0)) {
            localcoi.parseFrom((byte[])localObject);
          }
          localdwh.Ucn = localcoi;
          paramInt += 1;
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      AppMethodBeat.o(72578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwh
 * JD-Core Version:    0.7.0.1
 */