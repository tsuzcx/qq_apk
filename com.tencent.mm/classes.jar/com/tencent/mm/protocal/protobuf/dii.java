package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dii
  extends dyl
{
  public String TPD;
  public dik TPE;
  public int TPF;
  public b TPG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217114);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TPD != null) {
        paramVarArgs.f(2, this.TPD);
      }
      if (this.TPE != null)
      {
        paramVarArgs.oE(3, this.TPE.computeSize());
        this.TPE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.TPF);
      if (this.TPG != null) {
        paramVarArgs.c(5, this.TPG);
      }
      AppMethodBeat.o(217114);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TPD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TPD);
      }
      i = paramInt;
      if (this.TPE != null) {
        i = paramInt + g.a.a.a.oD(3, this.TPE.computeSize());
      }
      i += g.a.a.b.b.a.bM(4, this.TPF);
      paramInt = i;
      if (this.TPG != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.TPG);
      }
      AppMethodBeat.o(217114);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(217114);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dii localdii = (dii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(217114);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localdii.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(217114);
          return 0;
        case 2: 
          localdii.TPD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(217114);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dik();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dik)localObject2).parseFrom((byte[])localObject1);
            }
            localdii.TPE = ((dik)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(217114);
          return 0;
        case 4: 
          localdii.TPF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(217114);
          return 0;
        }
        localdii.TPG = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(217114);
        return 0;
      }
      AppMethodBeat.o(217114);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dii
 * JD-Core Version:    0.7.0.1
 */