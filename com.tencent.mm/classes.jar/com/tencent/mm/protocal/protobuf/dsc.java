package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dsc
  extends dyl
{
  public ja Slc;
  public int Smo;
  public int Smp;
  public int TYL;
  public b TYM;
  public b TYN;
  public b TYO;
  public int TYP;
  public dsd TYQ;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91653);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Slc != null)
      {
        paramVarArgs.oE(2, this.Slc.computeSize());
        this.Slc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.TYL);
      if (this.TYM != null) {
        paramVarArgs.c(4, this.TYM);
      }
      if (this.TYN != null) {
        paramVarArgs.c(5, this.TYN);
      }
      if (this.TYO != null) {
        paramVarArgs.c(6, this.TYO);
      }
      paramVarArgs.aY(7, this.Smp);
      paramVarArgs.aY(8, this.Smo);
      paramVarArgs.aY(9, this.TYP);
      paramVarArgs.bm(10, this.timestamp);
      if (this.TYQ != null)
      {
        paramVarArgs.oE(11, this.TYQ.computeSize());
        this.TYQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label960;
      }
    }
    label960:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Slc != null) {
        i = paramInt + g.a.a.a.oD(2, this.Slc.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.TYL);
      paramInt = i;
      if (this.TYM != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.TYM);
      }
      i = paramInt;
      if (this.TYN != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.TYN);
      }
      paramInt = i;
      if (this.TYO != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.TYO);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Smp) + g.a.a.b.b.a.bM(8, this.Smo) + g.a.a.b.b.a.bM(9, this.TYP) + g.a.a.b.b.a.p(10, this.timestamp);
      paramInt = i;
      if (this.TYQ != null) {
        paramInt = i + g.a.a.a.oD(11, this.TYQ.computeSize());
      }
      AppMethodBeat.o(91653);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dsc localdsc = (dsc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91653);
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
            localdsc.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ja();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ja)localObject2).parseFrom((byte[])localObject1);
            }
            localdsc.Slc = ((ja)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 3: 
          localdsc.TYL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91653);
          return 0;
        case 4: 
          localdsc.TYM = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(91653);
          return 0;
        case 5: 
          localdsc.TYN = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(91653);
          return 0;
        case 6: 
          localdsc.TYO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(91653);
          return 0;
        case 7: 
          localdsc.Smp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91653);
          return 0;
        case 8: 
          localdsc.Smo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91653);
          return 0;
        case 9: 
          localdsc.TYP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91653);
          return 0;
        case 10: 
          localdsc.timestamp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91653);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dsd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dsd)localObject2).parseFrom((byte[])localObject1);
          }
          localdsc.TYQ = ((dsd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      AppMethodBeat.o(91653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsc
 * JD-Core Version:    0.7.0.1
 */