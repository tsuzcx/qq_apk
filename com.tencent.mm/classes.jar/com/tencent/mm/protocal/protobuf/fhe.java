package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fhe
  extends com.tencent.mm.cd.a
{
  public eae RIH;
  public String RRu;
  public eae RRy;
  public String UHm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133207);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RRy == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.RIH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.UHm != null) {
        paramVarArgs.f(1, this.UHm);
      }
      if (this.RRy != null)
      {
        paramVarArgs.oE(2, this.RRy.computeSize());
        this.RRy.writeFields(paramVarArgs);
      }
      if (this.RRu != null) {
        paramVarArgs.f(3, this.RRu);
      }
      if (this.RIH != null)
      {
        paramVarArgs.oE(4, this.RIH.computeSize());
        this.RIH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UHm == null) {
        break label638;
      }
    }
    label638:
    for (int i = g.a.a.b.b.a.g(1, this.UHm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RRy != null) {
        paramInt = i + g.a.a.a.oD(2, this.RRy.computeSize());
      }
      i = paramInt;
      if (this.RRu != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RRu);
      }
      paramInt = i;
      if (this.RIH != null) {
        paramInt = i + g.a.a.a.oD(4, this.RIH.computeSize());
      }
      AppMethodBeat.o(133207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RRy == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        if (this.RIH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fhe localfhe = (fhe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eae localeae;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133207);
          return -1;
        case 1: 
          localfhe.UHm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(133207);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeae = new eae();
            if ((localObject != null) && (localObject.length > 0)) {
              localeae.dd((byte[])localObject);
            }
            localfhe.RRy = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(133207);
          return 0;
        case 3: 
          localfhe.RRu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(133207);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localfhe.RIH = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      AppMethodBeat.o(133207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhe
 * JD-Core Version:    0.7.0.1
 */