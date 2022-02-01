package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class flz
  extends com.tencent.mm.cd.a
{
  public String Cqt;
  public String Md5;
  public int UKR;
  public int UKS;
  public fmc UKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110857);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.Cqt == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.f(1, this.Md5);
      }
      if (this.Cqt != null) {
        paramVarArgs.f(2, this.Cqt);
      }
      paramVarArgs.aY(3, this.UKR);
      paramVarArgs.aY(4, this.UKS);
      if (this.UKT != null)
      {
        paramVarArgs.oE(5, this.UKT.computeSize());
        this.UKT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label592;
      }
    }
    label592:
    for (paramInt = g.a.a.b.b.a.g(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Cqt != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Cqt);
      }
      i = i + g.a.a.b.b.a.bM(3, this.UKR) + g.a.a.b.b.a.bM(4, this.UKS);
      paramInt = i;
      if (this.UKT != null) {
        paramInt = i + g.a.a.a.oD(5, this.UKT.computeSize());
      }
      AppMethodBeat.o(110857);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        if (this.Cqt == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        flz localflz = (flz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110857);
          return -1;
        case 1: 
          localflz.Md5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 2: 
          localflz.Cqt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 3: 
          localflz.UKR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(110857);
          return 0;
        case 4: 
          localflz.UKS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(110857);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fmc localfmc = new fmc();
          if ((localObject != null) && (localObject.length > 0)) {
            localfmc.parseFrom((byte[])localObject);
          }
          localflz.UKT = localfmc;
          paramInt += 1;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      AppMethodBeat.o(110857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flz
 * JD-Core Version:    0.7.0.1
 */