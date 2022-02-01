package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhs
  extends dpc
{
  public String Cjv;
  public String Cjw;
  public String MMB;
  public int MMC;
  public String MMD;
  public String MME;
  public String MMF;
  public String MMG;
  public int dDN;
  public String jCp;
  public String qwn;
  public int state;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72567);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72567);
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
      paramVarArgs.aM(4, this.state);
      if (this.MMB != null) {
        paramVarArgs.e(5, this.MMB);
      }
      paramVarArgs.aM(6, this.yRL);
      paramVarArgs.aM(7, this.MMC);
      if (this.Cjv != null) {
        paramVarArgs.e(8, this.Cjv);
      }
      if (this.MMD != null) {
        paramVarArgs.e(9, this.MMD);
      }
      if (this.Cjw != null) {
        paramVarArgs.e(10, this.Cjw);
      }
      if (this.MME != null) {
        paramVarArgs.e(11, this.MME);
      }
      if (this.MMF != null) {
        paramVarArgs.e(12, this.MMF);
      }
      if (this.MMG != null) {
        paramVarArgs.e(14, this.MMG);
      }
      if (this.jCp != null) {
        paramVarArgs.e(15, this.jCp);
      }
      AppMethodBeat.o(72567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.state);
      paramInt = i;
      if (this.MMB != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MMB);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.yRL) + g.a.a.b.b.a.bu(7, this.MMC);
      paramInt = i;
      if (this.Cjv != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Cjv);
      }
      i = paramInt;
      if (this.MMD != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MMD);
      }
      paramInt = i;
      if (this.Cjw != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Cjw);
      }
      i = paramInt;
      if (this.MME != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.MME);
      }
      paramInt = i;
      if (this.MMF != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MMF);
      }
      i = paramInt;
      if (this.MMG != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.MMG);
      }
      paramInt = i;
      if (this.jCp != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.jCp);
      }
      AppMethodBeat.o(72567);
      return paramInt;
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
          AppMethodBeat.o(72567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhs localdhs = (dhs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 13: 
        default: 
          AppMethodBeat.o(72567);
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
            localdhs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72567);
          return 0;
        case 2: 
          localdhs.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72567);
          return 0;
        case 3: 
          localdhs.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 4: 
          localdhs.state = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72567);
          return 0;
        case 5: 
          localdhs.MMB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 6: 
          localdhs.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72567);
          return 0;
        case 7: 
          localdhs.MMC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72567);
          return 0;
        case 8: 
          localdhs.Cjv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 9: 
          localdhs.MMD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 10: 
          localdhs.Cjw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 11: 
          localdhs.MME = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 12: 
          localdhs.MMF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 14: 
          localdhs.MMG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72567);
          return 0;
        }
        localdhs.jCp = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72567);
        return 0;
      }
      AppMethodBeat.o(72567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhs
 * JD-Core Version:    0.7.0.1
 */