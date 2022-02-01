package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dab
  extends dpc
{
  public String LQv;
  public String LQw;
  public String MFk;
  public int rBL;
  public String rBM;
  public String xIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91584);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91584);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LQv != null) {
        paramVarArgs.e(2, this.LQv);
      }
      if (this.xIy != null) {
        paramVarArgs.e(3, this.xIy);
      }
      if (this.LQw != null) {
        paramVarArgs.e(4, this.LQw);
      }
      paramVarArgs.aM(5, this.rBL);
      if (this.rBM != null) {
        paramVarArgs.e(6, this.rBM);
      }
      if (this.MFk != null) {
        paramVarArgs.e(7, this.MFk);
      }
      AppMethodBeat.o(91584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LQv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LQv);
      }
      i = paramInt;
      if (this.xIy != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xIy);
      }
      paramInt = i;
      if (this.LQw != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LQw);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.rBL);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.rBM);
      }
      i = paramInt;
      if (this.MFk != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MFk);
      }
      AppMethodBeat.o(91584);
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
          AppMethodBeat.o(91584);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91584);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dab localdab = (dab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91584);
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
            localdab.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91584);
          return 0;
        case 2: 
          localdab.LQv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91584);
          return 0;
        case 3: 
          localdab.xIy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91584);
          return 0;
        case 4: 
          localdab.LQw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91584);
          return 0;
        case 5: 
          localdab.rBL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91584);
          return 0;
        case 6: 
          localdab.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91584);
          return 0;
        }
        localdab.MFk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91584);
        return 0;
      }
      AppMethodBeat.o(91584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dab
 * JD-Core Version:    0.7.0.1
 */