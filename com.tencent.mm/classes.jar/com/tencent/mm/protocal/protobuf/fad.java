package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fad
  extends dyl
{
  public int RLe;
  public eae ROR;
  public String RRt;
  public eaf RRx;
  public eae RRy;
  public eaf TmK;
  public String UAd;
  public eaf UAe;
  public int Ujp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43133);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      if (this.UAd != null) {
        paramVarArgs.f(3, this.UAd);
      }
      if (this.RRt != null) {
        paramVarArgs.f(4, this.RRt);
      }
      if (this.TmK != null)
      {
        paramVarArgs.oE(5, this.TmK.computeSize());
        this.TmK.writeFields(paramVarArgs);
      }
      if (this.UAe != null)
      {
        paramVarArgs.oE(6, this.UAe.computeSize());
        this.UAe.writeFields(paramVarArgs);
      }
      if (this.RRx != null)
      {
        paramVarArgs.oE(7, this.RRx.computeSize());
        this.RRx.writeFields(paramVarArgs);
      }
      if (this.RRy != null)
      {
        paramVarArgs.oE(8, this.RRy.computeSize());
        this.RRy.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.Ujp);
      if (this.ROR != null)
      {
        paramVarArgs.oE(10, this.ROR.computeSize());
        this.ROR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1166;
      }
    }
    label1166:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLe);
      paramInt = i;
      if (this.UAd != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UAd);
      }
      i = paramInt;
      if (this.RRt != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RRt);
      }
      paramInt = i;
      if (this.TmK != null) {
        paramInt = i + g.a.a.a.oD(5, this.TmK.computeSize());
      }
      i = paramInt;
      if (this.UAe != null) {
        i = paramInt + g.a.a.a.oD(6, this.UAe.computeSize());
      }
      paramInt = i;
      if (this.RRx != null) {
        paramInt = i + g.a.a.a.oD(7, this.RRx.computeSize());
      }
      i = paramInt;
      if (this.RRy != null) {
        i = paramInt + g.a.a.a.oD(8, this.RRy.computeSize());
      }
      i += g.a.a.b.b.a.bM(9, this.Ujp);
      paramInt = i;
      if (this.ROR != null) {
        paramInt = i + g.a.a.a.oD(10, this.ROR.computeSize());
      }
      AppMethodBeat.o(43133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fad localfad = (fad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43133);
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
            localfad.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 2: 
          localfad.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43133);
          return 0;
        case 3: 
          localfad.UAd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 4: 
          localfad.RRt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localfad.TmK = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localfad.UAe = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localfad.RRx = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localfad.RRy = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 9: 
          localfad.Ujp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43133);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localfad.ROR = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      AppMethodBeat.o(43133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fad
 * JD-Core Version:    0.7.0.1
 */