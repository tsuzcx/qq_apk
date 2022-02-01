package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhs
  extends com.tencent.mm.cd.a
{
  public String GaM;
  public ajc IcZ;
  public fbn Sdr;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204321);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GaM == null)
      {
        paramVarArgs = new b("Not all required fields were included: pagPath");
        AppMethodBeat.o(204321);
        throw paramVarArgs;
      }
      if (this.Sdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(204321);
        throw paramVarArgs;
      }
      if (this.GaM != null) {
        paramVarArgs.f(1, this.GaM);
      }
      if (this.text != null) {
        paramVarArgs.f(2, this.text);
      }
      if (this.Sdr != null)
      {
        paramVarArgs.oE(3, this.Sdr.computeSize());
        this.Sdr.writeFields(paramVarArgs);
      }
      if (this.IcZ != null)
      {
        paramVarArgs.oE(4, this.IcZ.computeSize());
        this.IcZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(204321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GaM == null) {
        break label638;
      }
    }
    label638:
    for (int i = g.a.a.b.b.a.g(1, this.GaM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.text != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.text);
      }
      i = paramInt;
      if (this.Sdr != null) {
        i = paramInt + g.a.a.a.oD(3, this.Sdr.computeSize());
      }
      paramInt = i;
      if (this.IcZ != null) {
        paramInt = i + g.a.a.a.oD(4, this.IcZ.computeSize());
      }
      AppMethodBeat.o(204321);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.GaM == null)
        {
          paramVarArgs = new b("Not all required fields were included: pagPath");
          AppMethodBeat.o(204321);
          throw paramVarArgs;
        }
        if (this.Sdr == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(204321);
          throw paramVarArgs;
        }
        AppMethodBeat.o(204321);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhs localdhs = (dhs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204321);
          return -1;
        case 1: 
          localdhs.GaM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204321);
          return 0;
        case 2: 
          localdhs.text = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204321);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbn)localObject2).parseFrom((byte[])localObject1);
            }
            localdhs.Sdr = ((fbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204321);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ajc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ajc)localObject2).parseFrom((byte[])localObject1);
          }
          localdhs.IcZ = ((ajc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(204321);
        return 0;
      }
      AppMethodBeat.o(204321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhs
 * JD-Core Version:    0.7.0.1
 */