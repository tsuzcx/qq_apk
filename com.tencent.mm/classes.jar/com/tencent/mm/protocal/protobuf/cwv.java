package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cwv
  extends esc
{
  public String YMd;
  public String YYd;
  public gjx ZiP;
  public String aaCe;
  public int aaCf;
  public String aaCg;
  public LinkedList<dtp> aaCh;
  public int aaCi;
  public String aaCj;
  public String aaCk;
  public int aaCl;
  public String aaCm;
  public int aaCn;
  public int aaCo;
  public dtp aaCp;
  public int uYb;
  public String wording;
  
  public cwv()
  {
    AppMethodBeat.i(123591);
    this.aaCh = new LinkedList();
    AppMethodBeat.o(123591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123592);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZiP != null)
      {
        paramVarArgs.qD(2, this.ZiP.computeSize());
        this.ZiP.writeFields(paramVarArgs);
      }
      if (this.aaCe != null) {
        paramVarArgs.g(3, this.aaCe);
      }
      paramVarArgs.bS(4, this.aaCf);
      paramVarArgs.bS(5, this.uYb);
      if (this.aaCg != null) {
        paramVarArgs.g(6, this.aaCg);
      }
      paramVarArgs.e(7, 8, this.aaCh);
      paramVarArgs.bS(8, this.aaCi);
      if (this.aaCj != null) {
        paramVarArgs.g(9, this.aaCj);
      }
      if (this.aaCk != null) {
        paramVarArgs.g(10, this.aaCk);
      }
      paramVarArgs.bS(11, this.aaCl);
      if (this.wording != null) {
        paramVarArgs.g(12, this.wording);
      }
      if (this.YMd != null) {
        paramVarArgs.g(13, this.YMd);
      }
      if (this.YYd != null) {
        paramVarArgs.g(14, this.YYd);
      }
      if (this.aaCm != null) {
        paramVarArgs.g(15, this.aaCm);
      }
      paramVarArgs.bS(16, this.aaCn);
      paramVarArgs.bS(17, this.aaCo);
      if (this.aaCp != null)
      {
        paramVarArgs.qD(18, this.aaCp.computeSize());
        this.aaCp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1482;
      }
    }
    label1482:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZiP != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZiP.computeSize());
      }
      i = paramInt;
      if (this.aaCe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaCe);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.aaCf) + i.a.a.b.b.a.cJ(5, this.uYb);
      paramInt = i;
      if (this.aaCg != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaCg);
      }
      i = paramInt + i.a.a.a.c(7, 8, this.aaCh) + i.a.a.b.b.a.cJ(8, this.aaCi);
      paramInt = i;
      if (this.aaCj != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaCj);
      }
      i = paramInt;
      if (this.aaCk != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aaCk);
      }
      i += i.a.a.b.b.a.cJ(11, this.aaCl);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.wording);
      }
      i = paramInt;
      if (this.YMd != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.YMd);
      }
      paramInt = i;
      if (this.YYd != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.YYd);
      }
      i = paramInt;
      if (this.aaCm != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.aaCm);
      }
      i = i + i.a.a.b.b.a.cJ(16, this.aaCn) + i.a.a.b.b.a.cJ(17, this.aaCo);
      paramInt = i;
      if (this.aaCp != null) {
        paramInt = i + i.a.a.a.qC(18, this.aaCp.computeSize());
      }
      AppMethodBeat.o(123592);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaCh.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cwv localcwv = (cwv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123592);
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
            localcwv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gjx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gjx)localObject2).parseFrom((byte[])localObject1);
            }
            localcwv.ZiP = ((gjx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 3: 
          localcwv.aaCe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 4: 
          localcwv.aaCf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123592);
          return 0;
        case 5: 
          localcwv.uYb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123592);
          return 0;
        case 6: 
          localcwv.aaCg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtp)localObject2).parseFrom((byte[])localObject1);
            }
            localcwv.aaCh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 8: 
          localcwv.aaCi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123592);
          return 0;
        case 9: 
          localcwv.aaCj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 10: 
          localcwv.aaCk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 11: 
          localcwv.aaCl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123592);
          return 0;
        case 12: 
          localcwv.wording = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 13: 
          localcwv.YMd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 14: 
          localcwv.YYd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 15: 
          localcwv.aaCm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 16: 
          localcwv.aaCn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123592);
          return 0;
        case 17: 
          localcwv.aaCo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123592);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dtp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dtp)localObject2).parseFrom((byte[])localObject1);
          }
          localcwv.aaCp = ((dtp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      AppMethodBeat.o(123592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwv
 * JD-Core Version:    0.7.0.1
 */