package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fal
  extends com.tencent.mm.cd.a
{
  public String Izj;
  public int RKI;
  public String SZI;
  public String Tav;
  public String UAm;
  public int UAn;
  public String UAo;
  public String UAp;
  public int UAq;
  public String UAr;
  public int UAs;
  public eae UAt;
  public eae UAu;
  public String UeN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152723);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Izj != null) {
        paramVarArgs.f(1, this.Izj);
      }
      if (this.UAm != null) {
        paramVarArgs.f(2, this.UAm);
      }
      if (this.Tav != null) {
        paramVarArgs.f(3, this.Tav);
      }
      paramVarArgs.aY(4, this.UAn);
      if (this.UeN != null) {
        paramVarArgs.f(5, this.UeN);
      }
      if (this.UAo != null) {
        paramVarArgs.f(6, this.UAo);
      }
      if (this.UAp != null) {
        paramVarArgs.f(7, this.UAp);
      }
      paramVarArgs.aY(8, this.UAq);
      if (this.UAr != null) {
        paramVarArgs.f(9, this.UAr);
      }
      paramVarArgs.aY(10, this.UAs);
      if (this.UAt != null)
      {
        paramVarArgs.oE(11, this.UAt.computeSize());
        this.UAt.writeFields(paramVarArgs);
      }
      if (this.SZI != null) {
        paramVarArgs.f(12, this.SZI);
      }
      paramVarArgs.aY(13, this.RKI);
      if (this.UAu != null)
      {
        paramVarArgs.oE(14, this.UAu.computeSize());
        this.UAu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Izj == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = g.a.a.b.b.a.g(1, this.Izj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UAm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UAm);
      }
      i = paramInt;
      if (this.Tav != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tav);
      }
      i += g.a.a.b.b.a.bM(4, this.UAn);
      paramInt = i;
      if (this.UeN != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UeN);
      }
      i = paramInt;
      if (this.UAo != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.UAo);
      }
      paramInt = i;
      if (this.UAp != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UAp);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.UAq);
      paramInt = i;
      if (this.UAr != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.UAr);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.UAs);
      paramInt = i;
      if (this.UAt != null) {
        paramInt = i + g.a.a.a.oD(11, this.UAt.computeSize());
      }
      i = paramInt;
      if (this.SZI != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.SZI);
      }
      i += g.a.a.b.b.a.bM(13, this.RKI);
      paramInt = i;
      if (this.UAu != null) {
        paramInt = i + g.a.a.a.oD(14, this.UAu.computeSize());
      }
      AppMethodBeat.o(152723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fal localfal = (fal)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eae localeae;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152723);
          return -1;
        case 1: 
          localfal.Izj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 2: 
          localfal.UAm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 3: 
          localfal.Tav = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 4: 
          localfal.UAn = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152723);
          return 0;
        case 5: 
          localfal.UeN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 6: 
          localfal.UAo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 7: 
          localfal.UAp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 8: 
          localfal.UAq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152723);
          return 0;
        case 9: 
          localfal.UAr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 10: 
          localfal.UAs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152723);
          return 0;
        case 11: 
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
            localfal.UAt = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(152723);
          return 0;
        case 12: 
          localfal.SZI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 13: 
          localfal.RKI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152723);
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
          localfal.UAu = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      AppMethodBeat.o(152723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fal
 * JD-Core Version:    0.7.0.1
 */