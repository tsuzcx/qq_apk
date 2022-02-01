package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ux
  extends esc
{
  public int CreateTime;
  public String IMg;
  public String IMh;
  public long Njv;
  public String YFJ;
  public String YKw;
  public String ZaC;
  public String ZaN;
  public int ZaS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152512);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152512);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZaC != null) {
        paramVarArgs.g(3, this.ZaC);
      }
      if (this.IMh != null) {
        paramVarArgs.g(4, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(5, this.IMg);
      }
      paramVarArgs.bS(9, this.CreateTime);
      paramVarArgs.bv(10, this.Njv);
      if (this.ZaN != null) {
        paramVarArgs.g(11, this.ZaN);
      }
      if (this.YKw != null) {
        paramVarArgs.g(12, this.YKw);
      }
      if (this.YFJ != null) {
        paramVarArgs.g(13, this.YFJ);
      }
      paramVarArgs.bS(14, this.ZaS);
      AppMethodBeat.o(152512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label852;
      }
    }
    label852:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZaC != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZaC);
      }
      i = paramInt;
      if (this.IMh != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IMh);
      }
      paramInt = i;
      if (this.IMg != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IMg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.CreateTime) + i.a.a.b.b.a.q(10, this.Njv);
      paramInt = i;
      if (this.ZaN != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZaN);
      }
      i = paramInt;
      if (this.YKw != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.YKw);
      }
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.YFJ);
      }
      i = i.a.a.b.b.a.cJ(14, this.ZaS);
      AppMethodBeat.o(152512);
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
          AppMethodBeat.o(152512);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152512);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ux localux = (ux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152512);
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
            localux.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(152512);
          return 0;
        case 3: 
          localux.ZaC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 4: 
          localux.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 5: 
          localux.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 9: 
          localux.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152512);
          return 0;
        case 10: 
          localux.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(152512);
          return 0;
        case 11: 
          localux.ZaN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 12: 
          localux.YKw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 13: 
          localux.YFJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152512);
          return 0;
        }
        localux.ZaS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152512);
        return 0;
      }
      AppMethodBeat.o(152512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ux
 * JD-Core Version:    0.7.0.1
 */