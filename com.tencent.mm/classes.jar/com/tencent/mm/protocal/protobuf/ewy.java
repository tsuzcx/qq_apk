package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ewy
  extends esc
{
  public int CreateTime;
  public String IMg;
  public String IMh;
  public int Njs;
  public long Njv;
  public String YHk;
  public String ZaN;
  public int ZaS;
  public String oOI;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32427);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32427);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.IMh != null) {
        paramVarArgs.g(3, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(4, this.IMg);
      }
      paramVarArgs.bS(5, this.Njs);
      if (this.YHk != null) {
        paramVarArgs.g(6, this.YHk);
      }
      paramVarArgs.bS(7, this.CreateTime);
      paramVarArgs.bS(8, this.vhJ);
      paramVarArgs.bv(9, this.Njv);
      if (this.ZaN != null) {
        paramVarArgs.g(10, this.ZaN);
      }
      paramVarArgs.bS(12, this.ZaS);
      AppMethodBeat.o(32427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label885;
      }
    }
    label885:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.IMh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMh);
      }
      paramInt = i;
      if (this.IMg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IMg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Njs);
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YHk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.CreateTime) + i.a.a.b.b.a.cJ(8, this.vhJ) + i.a.a.b.b.a.q(9, this.Njv);
      paramInt = i;
      if (this.ZaN != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZaN);
      }
      i = i.a.a.b.b.a.cJ(12, this.ZaS);
      AppMethodBeat.o(32427);
      return paramInt + i;
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
          AppMethodBeat.o(32427);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ewy localewy = (ewy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(32427);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localewy.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(32427);
          return 0;
        case 2: 
          localewy.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 3: 
          localewy.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 4: 
          localewy.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 5: 
          localewy.Njs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32427);
          return 0;
        case 6: 
          localewy.YHk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 7: 
          localewy.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32427);
          return 0;
        case 8: 
          localewy.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32427);
          return 0;
        case 9: 
          localewy.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32427);
          return 0;
        case 10: 
          localewy.ZaN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32427);
          return 0;
        }
        localewy.ZaS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32427);
        return 0;
      }
      AppMethodBeat.o(32427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewy
 * JD-Core Version:    0.7.0.1
 */