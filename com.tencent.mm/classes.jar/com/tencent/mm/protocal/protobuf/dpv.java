package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpv
  extends dyl
{
  public int DgI;
  public String OOx;
  public String OmF;
  public int Oms;
  public String TUW;
  public int TWH;
  public int TWI;
  public int TWJ;
  public String Tyf;
  public String Tyg;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Tyg != null) {
        paramVarArgs.f(2, this.Tyg);
      }
      paramVarArgs.aY(3, this.TWH);
      paramVarArgs.aY(4, this.DgI);
      if (this.Tyf != null) {
        paramVarArgs.f(5, this.Tyf);
      }
      if (this.TUW != null) {
        paramVarArgs.f(7, this.TUW);
      }
      paramVarArgs.aY(8, this.Oms);
      if (this.fvP != null) {
        paramVarArgs.f(9, this.fvP);
      }
      if (this.OOx != null) {
        paramVarArgs.f(10, this.OOx);
      }
      paramVarArgs.aY(11, this.TWI);
      paramVarArgs.aY(12, this.TWJ);
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(91636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label924;
      }
    }
    label924:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tyg != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Tyg);
      }
      i = i + g.a.a.b.b.a.bM(3, this.TWH) + g.a.a.b.b.a.bM(4, this.DgI);
      paramInt = i;
      if (this.Tyf != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Tyf);
      }
      i = paramInt;
      if (this.TUW != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TUW);
      }
      i += g.a.a.b.b.a.bM(8, this.Oms);
      paramInt = i;
      if (this.fvP != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.fvP);
      }
      i = paramInt;
      if (this.OOx != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.OOx);
      }
      i = i + g.a.a.b.b.a.bM(11, this.TWI) + g.a.a.b.b.a.bM(12, this.TWJ);
      paramInt = i;
      if (this.OmF != null) {
        paramInt = i + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(91636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dpv localdpv = (dpv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91636);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdpv.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91636);
          return 0;
        case 2: 
          localdpv.Tyg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 3: 
          localdpv.TWH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91636);
          return 0;
        case 4: 
          localdpv.DgI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91636);
          return 0;
        case 5: 
          localdpv.Tyf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 7: 
          localdpv.TUW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 8: 
          localdpv.Oms = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91636);
          return 0;
        case 9: 
          localdpv.fvP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 10: 
          localdpv.OOx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 11: 
          localdpv.TWI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91636);
          return 0;
        case 12: 
          localdpv.TWJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91636);
          return 0;
        }
        localdpv.OmF = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91636);
        return 0;
      }
      AppMethodBeat.o(91636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpv
 * JD-Core Version:    0.7.0.1
 */