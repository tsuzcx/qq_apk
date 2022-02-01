package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class yl
  extends esc
{
  public String Oln;
  public String ZgS;
  public String ZgT;
  public String ZgU;
  public String Zhh;
  public int amount;
  public int hAV;
  public String hMy;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72438);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72438);
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
      if (this.hMy != null) {
        paramVarArgs.g(4, this.hMy);
      }
      if (this.ZgU != null) {
        paramVarArgs.g(5, this.ZgU);
      }
      if (this.Oln != null) {
        paramVarArgs.g(6, this.Oln);
      }
      paramVarArgs.bS(7, this.amount);
      if (this.Zhh != null) {
        paramVarArgs.g(8, this.Zhh);
      }
      if (this.ZgT != null) {
        paramVarArgs.g(9, this.ZgT);
      }
      if (this.ZgS != null) {
        paramVarArgs.g(10, this.ZgS);
      }
      AppMethodBeat.o(72438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label852;
      }
    }
    label852:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.hMy != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.hMy);
      }
      paramInt = i;
      if (this.ZgU != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZgU);
      }
      i = paramInt;
      if (this.Oln != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Oln);
      }
      i += i.a.a.b.b.a.cJ(7, this.amount);
      paramInt = i;
      if (this.Zhh != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Zhh);
      }
      i = paramInt;
      if (this.ZgT != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZgT);
      }
      paramInt = i;
      if (this.ZgS != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZgS);
      }
      AppMethodBeat.o(72438);
      return paramInt;
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
          AppMethodBeat.o(72438);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        yl localyl = (yl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72438);
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
            localyl.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(72438);
          return 0;
        case 2: 
          localyl.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72438);
          return 0;
        case 3: 
          localyl.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 4: 
          localyl.hMy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 5: 
          localyl.ZgU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 6: 
          localyl.Oln = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 7: 
          localyl.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72438);
          return 0;
        case 8: 
          localyl.Zhh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 9: 
          localyl.ZgT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72438);
          return 0;
        }
        localyl.ZgS = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72438);
        return 0;
      }
      AppMethodBeat.o(72438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yl
 * JD-Core Version:    0.7.0.1
 */