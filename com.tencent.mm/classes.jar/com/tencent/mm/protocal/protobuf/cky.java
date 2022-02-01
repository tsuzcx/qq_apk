package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cky
  extends esc
{
  public boolean CGI;
  public String Vpa;
  public String Vpb;
  public String Vpc;
  public String Vpd;
  public String Vpe;
  public String Vpf;
  public String Vpg;
  public LinkedList<czl> aasX;
  public int hAV;
  public boolean hJQ;
  public String wYI;
  
  public cky()
  {
    AppMethodBeat.i(72486);
    this.hAV = 0;
    this.wYI = "ok";
    this.aasX = new LinkedList();
    AppMethodBeat.o(72486);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72487);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72487);
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
      if (this.Vpa != null) {
        paramVarArgs.g(4, this.Vpa);
      }
      paramVarArgs.di(6, this.hJQ);
      if (this.Vpb != null) {
        paramVarArgs.g(7, this.Vpb);
      }
      if (this.Vpc != null) {
        paramVarArgs.g(8, this.Vpc);
      }
      if (this.Vpd != null) {
        paramVarArgs.g(9, this.Vpd);
      }
      if (this.Vpe != null) {
        paramVarArgs.g(10, this.Vpe);
      }
      if (this.Vpf != null) {
        paramVarArgs.g(11, this.Vpf);
      }
      if (this.Vpg != null) {
        paramVarArgs.g(12, this.Vpg);
      }
      paramVarArgs.e(13, 8, this.aasX);
      paramVarArgs.di(14, this.CGI);
      AppMethodBeat.o(72487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1086;
      }
    }
    label1086:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.Vpa != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Vpa);
      }
      i += i.a.a.b.b.a.ko(6) + 1;
      paramInt = i;
      if (this.Vpb != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Vpb);
      }
      i = paramInt;
      if (this.Vpc != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Vpc);
      }
      paramInt = i;
      if (this.Vpd != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Vpd);
      }
      i = paramInt;
      if (this.Vpe != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.Vpe);
      }
      paramInt = i;
      if (this.Vpf != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.Vpf);
      }
      i = paramInt;
      if (this.Vpg != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.Vpg);
      }
      paramInt = i.a.a.a.c(13, 8, this.aasX);
      int j = i.a.a.b.b.a.ko(14);
      AppMethodBeat.o(72487);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aasX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cky localcky = (cky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(72487);
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
            localcky.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        case 2: 
          localcky.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72487);
          return 0;
        case 3: 
          localcky.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 4: 
          localcky.Vpa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 6: 
          localcky.hJQ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72487);
          return 0;
        case 7: 
          localcky.Vpb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 8: 
          localcky.Vpc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 9: 
          localcky.Vpd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 10: 
          localcky.Vpe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 11: 
          localcky.Vpf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 12: 
          localcky.Vpg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new czl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((czl)localObject2).parseFrom((byte[])localObject1);
            }
            localcky.aasX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        }
        localcky.CGI = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(72487);
        return 0;
      }
      AppMethodBeat.o(72487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cky
 * JD-Core Version:    0.7.0.1
 */