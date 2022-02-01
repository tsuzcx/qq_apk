package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cxi
  extends com.tencent.mm.cd.a
{
  public int CreateTime;
  public eaf RIE;
  public String RII;
  public String ScZ;
  public int TFR;
  public String lpy;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43104);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43104);
        throw paramVarArgs;
      }
      if (this.RIE != null)
      {
        paramVarArgs.oE(1, this.RIE.computeSize());
        this.RIE.writeFields(paramVarArgs);
      }
      if (this.lpy != null) {
        paramVarArgs.f(2, this.lpy);
      }
      paramVarArgs.aY(3, this.rWu);
      paramVarArgs.aY(4, this.CreateTime);
      paramVarArgs.aY(5, this.TFR);
      if (this.RII != null) {
        paramVarArgs.f(6, this.RII);
      }
      if (this.ScZ != null) {
        paramVarArgs.f(9, this.ScZ);
      }
      AppMethodBeat.o(43104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RIE == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = g.a.a.a.oD(1, this.RIE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lpy);
      }
      i = i + g.a.a.b.b.a.bM(3, this.rWu) + g.a.a.b.b.a.bM(4, this.CreateTime) + g.a.a.b.b.a.bM(5, this.TFR);
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RII);
      }
      i = paramInt;
      if (this.ScZ != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.ScZ);
      }
      AppMethodBeat.o(43104);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RIE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(43104);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cxi localcxi = (cxi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(43104);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eaf localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localcxi.RIE = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(43104);
          return 0;
        case 2: 
          localcxi.lpy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(43104);
          return 0;
        case 3: 
          localcxi.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(43104);
          return 0;
        case 4: 
          localcxi.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(43104);
          return 0;
        case 5: 
          localcxi.TFR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(43104);
          return 0;
        case 6: 
          localcxi.RII = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(43104);
          return 0;
        }
        localcxi.ScZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(43104);
        return 0;
      }
      AppMethodBeat.o(43104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxi
 * JD-Core Version:    0.7.0.1
 */