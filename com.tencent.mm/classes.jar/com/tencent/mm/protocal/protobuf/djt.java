package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class djt
  extends dyy
{
  public int EOJ;
  public String OTO;
  public fhz TRc;
  public fhw TRd;
  public fhq TRe;
  public fhx TRf;
  public boolean TRg;
  public LinkedList<String> TRh;
  public fhu TRi;
  public String errmsg;
  public int fBP;
  
  public djt()
  {
    AppMethodBeat.i(91588);
    this.TRh = new LinkedList();
    AppMethodBeat.o(91588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91589);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fBP);
      if (this.errmsg != null) {
        paramVarArgs.f(3, this.errmsg);
      }
      if (this.TRc != null)
      {
        paramVarArgs.oE(4, this.TRc.computeSize());
        this.TRc.writeFields(paramVarArgs);
      }
      if (this.TRd != null)
      {
        paramVarArgs.oE(5, this.TRd.computeSize());
        this.TRd.writeFields(paramVarArgs);
      }
      if (this.TRe != null)
      {
        paramVarArgs.oE(6, this.TRe.computeSize());
        this.TRe.writeFields(paramVarArgs);
      }
      if (this.TRf != null)
      {
        paramVarArgs.oE(7, this.TRf.computeSize());
        this.TRf.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.EOJ);
      paramVarArgs.co(9, this.TRg);
      if (this.OTO != null) {
        paramVarArgs.f(10, this.OTO);
      }
      paramVarArgs.e(11, 1, this.TRh);
      if (this.TRi != null)
      {
        paramVarArgs.oE(12, this.TRi.computeSize());
        this.TRi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1318;
      }
    }
    label1318:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fBP);
      paramInt = i;
      if (this.errmsg != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.errmsg);
      }
      i = paramInt;
      if (this.TRc != null) {
        i = paramInt + g.a.a.a.oD(4, this.TRc.computeSize());
      }
      paramInt = i;
      if (this.TRd != null) {
        paramInt = i + g.a.a.a.oD(5, this.TRd.computeSize());
      }
      i = paramInt;
      if (this.TRe != null) {
        i = paramInt + g.a.a.a.oD(6, this.TRe.computeSize());
      }
      paramInt = i;
      if (this.TRf != null) {
        paramInt = i + g.a.a.a.oD(7, this.TRf.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.EOJ) + (g.a.a.b.b.a.gL(9) + 1);
      paramInt = i;
      if (this.OTO != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.OTO);
      }
      i = paramInt + g.a.a.a.c(11, 1, this.TRh);
      paramInt = i;
      if (this.TRi != null) {
        paramInt = i + g.a.a.a.oD(12, this.TRi.computeSize());
      }
      AppMethodBeat.o(91589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TRh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djt localdjt = (djt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91589);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdjt.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 2: 
          localdjt.fBP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91589);
          return 0;
        case 3: 
          localdjt.errmsg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhz)localObject2).parseFrom((byte[])localObject1);
            }
            localdjt.TRc = ((fhz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhw)localObject2).parseFrom((byte[])localObject1);
            }
            localdjt.TRd = ((fhw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhq)localObject2).parseFrom((byte[])localObject1);
            }
            localdjt.TRe = ((fhq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhx)localObject2).parseFrom((byte[])localObject1);
            }
            localdjt.TRf = ((fhx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 8: 
          localdjt.EOJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91589);
          return 0;
        case 9: 
          localdjt.TRg = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91589);
          return 0;
        case 10: 
          localdjt.OTO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 11: 
          localdjt.TRh.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(91589);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhu)localObject2).parseFrom((byte[])localObject1);
          }
          localdjt.TRi = ((fhu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      AppMethodBeat.o(91589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djt
 * JD-Core Version:    0.7.0.1
 */