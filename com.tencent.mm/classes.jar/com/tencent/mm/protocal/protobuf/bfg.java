package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bfg
  extends dpc
{
  public boolean LOQ = false;
  public int dDN = 0;
  public int egY;
  public int egZ;
  public int eha;
  public String qwn = "ok";
  public String yPK;
  public String yQE;
  public String yVb;
  public int yVm;
  public String yVy;
  public String yXR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214300);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(214300);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.yQE != null) {
        paramVarArgs.e(4, this.yQE);
      }
      if (this.yPK != null) {
        paramVarArgs.e(5, this.yPK);
      }
      paramVarArgs.aM(6, this.yVm);
      paramVarArgs.aM(7, this.eha);
      paramVarArgs.aM(8, this.egZ);
      if (this.yVb != null) {
        paramVarArgs.e(9, this.yVb);
      }
      paramVarArgs.aM(10, this.egY);
      if (this.yVy != null) {
        paramVarArgs.e(11, this.yVy);
      }
      if (this.yXR != null) {
        paramVarArgs.e(12, this.yXR);
      }
      paramVarArgs.cc(13, this.LOQ);
      AppMethodBeat.o(214300);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.yQE != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.yQE);
      }
      paramInt = i;
      if (this.yPK != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.yPK);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.yVm) + g.a.a.b.b.a.bu(7, this.eha) + g.a.a.b.b.a.bu(8, this.egZ);
      paramInt = i;
      if (this.yVb != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.yVb);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.egY);
      paramInt = i;
      if (this.yVy != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.yVy);
      }
      i = paramInt;
      if (this.yXR != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.yXR);
      }
      paramInt = g.a.a.b.b.a.fS(13);
      AppMethodBeat.o(214300);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(214300);
          throw paramVarArgs;
        }
        AppMethodBeat.o(214300);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bfg localbfg = (bfg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214300);
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
            localbfg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214300);
          return 0;
        case 2: 
          localbfg.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214300);
          return 0;
        case 3: 
          localbfg.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214300);
          return 0;
        case 4: 
          localbfg.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214300);
          return 0;
        case 5: 
          localbfg.yPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214300);
          return 0;
        case 6: 
          localbfg.yVm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214300);
          return 0;
        case 7: 
          localbfg.eha = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214300);
          return 0;
        case 8: 
          localbfg.egZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214300);
          return 0;
        case 9: 
          localbfg.yVb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214300);
          return 0;
        case 10: 
          localbfg.egY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214300);
          return 0;
        case 11: 
          localbfg.yVy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214300);
          return 0;
        case 12: 
          localbfg.yXR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214300);
          return 0;
        }
        localbfg.LOQ = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(214300);
        return 0;
      }
      AppMethodBeat.o(214300);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfg
 * JD-Core Version:    0.7.0.1
 */