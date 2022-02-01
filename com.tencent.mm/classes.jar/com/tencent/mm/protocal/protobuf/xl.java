package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class xl
  extends esc
{
  public String Zga;
  public String Zgb;
  public String Zgc;
  public String Zgd;
  public int hAV;
  public String hSC;
  public String title;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258236);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258236);
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
      if (this.title != null) {
        paramVarArgs.g(4, this.title);
      }
      if (this.hSC != null) {
        paramVarArgs.g(5, this.hSC);
      }
      if (this.Zga != null) {
        paramVarArgs.g(6, this.Zga);
      }
      if (this.Zgb != null) {
        paramVarArgs.g(7, this.Zgb);
      }
      if (this.Zgc != null) {
        paramVarArgs.g(8, this.Zgc);
      }
      if (this.Zgd != null) {
        paramVarArgs.g(9, this.Zgd);
      }
      AppMethodBeat.o(258236);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label804;
      }
    }
    label804:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.title);
      }
      paramInt = i;
      if (this.hSC != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hSC);
      }
      i = paramInt;
      if (this.Zga != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Zga);
      }
      paramInt = i;
      if (this.Zgb != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zgb);
      }
      i = paramInt;
      if (this.Zgc != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Zgc);
      }
      paramInt = i;
      if (this.Zgd != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Zgd);
      }
      AppMethodBeat.o(258236);
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
          AppMethodBeat.o(258236);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258236);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        xl localxl = (xl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258236);
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
            localxl.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258236);
          return 0;
        case 2: 
          localxl.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258236);
          return 0;
        case 3: 
          localxl.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258236);
          return 0;
        case 4: 
          localxl.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258236);
          return 0;
        case 5: 
          localxl.hSC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258236);
          return 0;
        case 6: 
          localxl.Zga = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258236);
          return 0;
        case 7: 
          localxl.Zgb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258236);
          return 0;
        case 8: 
          localxl.Zgc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258236);
          return 0;
        }
        localxl.Zgd = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258236);
        return 0;
      }
      AppMethodBeat.o(258236);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xl
 * JD-Core Version:    0.7.0.1
 */