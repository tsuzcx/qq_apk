package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dti
  extends dpc
{
  public int Brl;
  public long Brn;
  public int CreateTime;
  public String KIz;
  public String LbJ;
  public int LbO;
  public String jfi;
  public int oUv;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32427);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32427);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.xNH != null) {
        paramVarArgs.e(3, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(4, this.xNG);
      }
      paramVarArgs.aM(5, this.Brl);
      if (this.KIz != null) {
        paramVarArgs.e(6, this.KIz);
      }
      paramVarArgs.aM(7, this.CreateTime);
      paramVarArgs.aM(8, this.oUv);
      paramVarArgs.bb(9, this.Brn);
      if (this.LbJ != null) {
        paramVarArgs.e(10, this.LbJ);
      }
      paramVarArgs.aM(12, this.LbO);
      AppMethodBeat.o(32427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label911;
      }
    }
    label911:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.xNH != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNH);
      }
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xNG);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Brl);
      paramInt = i;
      if (this.KIz != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KIz);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.CreateTime) + g.a.a.b.b.a.bu(8, this.oUv) + g.a.a.b.b.a.r(9, this.Brn);
      paramInt = i;
      if (this.LbJ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LbJ);
      }
      i = g.a.a.b.b.a.bu(12, this.LbO);
      AppMethodBeat.o(32427);
      return paramInt + i;
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
          AppMethodBeat.o(32427);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dti localdti = (dti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(32427);
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
            localdti.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32427);
          return 0;
        case 2: 
          localdti.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 3: 
          localdti.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 4: 
          localdti.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 5: 
          localdti.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32427);
          return 0;
        case 6: 
          localdti.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 7: 
          localdti.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32427);
          return 0;
        case 8: 
          localdti.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32427);
          return 0;
        case 9: 
          localdti.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32427);
          return 0;
        case 10: 
          localdti.LbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32427);
          return 0;
        }
        localdti.LbO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32427);
        return 0;
      }
      AppMethodBeat.o(32427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dti
 * JD-Core Version:    0.7.0.1
 */