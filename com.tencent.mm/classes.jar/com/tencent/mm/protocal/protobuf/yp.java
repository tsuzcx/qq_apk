package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class yp
  extends dpc
{
  public long LjE;
  public long LjF;
  public String LjG;
  public String LjH;
  public int pTZ;
  public String pUa;
  public String qGB;
  public String yPK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72458);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72458);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.bb(4, this.LjE);
      paramVarArgs.bb(5, this.LjF);
      if (this.LjG != null) {
        paramVarArgs.e(6, this.LjG);
      }
      if (this.LjH != null) {
        paramVarArgs.e(7, this.LjH);
      }
      if (this.yPK != null) {
        paramVarArgs.e(8, this.yPK);
      }
      if (this.qGB != null) {
        paramVarArgs.e(9, this.qGB);
      }
      AppMethodBeat.o(72458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.r(4, this.LjE) + g.a.a.b.b.a.r(5, this.LjF);
      paramInt = i;
      if (this.LjG != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LjG);
      }
      i = paramInt;
      if (this.LjH != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LjH);
      }
      paramInt = i;
      if (this.yPK != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.yPK);
      }
      i = paramInt;
      if (this.qGB != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.qGB);
      }
      AppMethodBeat.o(72458);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72458);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        yp localyp = (yp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72458);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localyp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72458);
          return 0;
        case 2: 
          localyp.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72458);
          return 0;
        case 3: 
          localyp.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 4: 
          localyp.LjE = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(72458);
          return 0;
        case 5: 
          localyp.LjF = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(72458);
          return 0;
        case 6: 
          localyp.LjG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 7: 
          localyp.LjH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 8: 
          localyp.yPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72458);
          return 0;
        }
        localyp.qGB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72458);
        return 0;
      }
      AppMethodBeat.o(72458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yp
 * JD-Core Version:    0.7.0.1
 */