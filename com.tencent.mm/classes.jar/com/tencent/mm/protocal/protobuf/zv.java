package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class zv
  extends esc
{
  public String OcL;
  public String OcM;
  public String OcN;
  public String YIM;
  public geo Zir;
  public int hAV;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72453);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72453);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.OcL != null) {
        paramVarArgs.g(4, this.OcL);
      }
      if (this.OcM != null) {
        paramVarArgs.g(5, this.OcM);
      }
      if (this.OcN != null) {
        paramVarArgs.g(6, this.OcN);
      }
      if (this.YIM != null) {
        paramVarArgs.g(7, this.YIM);
      }
      if (this.Zir != null)
      {
        paramVarArgs.qD(8, this.Zir.computeSize());
        this.Zir.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.OcL != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.OcL);
      }
      paramInt = i;
      if (this.OcM != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.OcM);
      }
      i = paramInt;
      if (this.OcN != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.OcN);
      }
      paramInt = i;
      if (this.YIM != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YIM);
      }
      i = paramInt;
      if (this.Zir != null) {
        i = paramInt + i.a.a.a.qC(8, this.Zir.computeSize());
      }
      AppMethodBeat.o(72453);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        zv localzv = (zv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72453);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localzv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72453);
          return 0;
        case 2: 
          localzv.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72453);
          return 0;
        case 3: 
          localzv.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 4: 
          localzv.OcL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 5: 
          localzv.OcM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 6: 
          localzv.OcN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 7: 
          localzv.YIM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72453);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new geo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((geo)localObject2).parseFrom((byte[])localObject1);
          }
          localzv.Zir = ((geo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72453);
        return 0;
      }
      AppMethodBeat.o(72453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zv
 * JD-Core Version:    0.7.0.1
 */