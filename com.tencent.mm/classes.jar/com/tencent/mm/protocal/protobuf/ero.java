package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ero
  extends esc
{
  public long Oll;
  public String Zga;
  public String Zgc;
  public String Zgd;
  public int hAV;
  public String title;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258526);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
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
      if (this.Zga != null) {
        paramVarArgs.g(5, this.Zga);
      }
      if (this.Zgc != null) {
        paramVarArgs.g(6, this.Zgc);
      }
      paramVarArgs.bv(7, this.Oll);
      if (this.Zgd != null) {
        paramVarArgs.g(8, this.Zgd);
      }
      AppMethodBeat.o(258526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label680;
      }
    }
    label680:
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
      if (this.Zga != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Zga);
      }
      i = paramInt;
      if (this.Zgc != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Zgc);
      }
      i += i.a.a.b.b.a.q(7, this.Oll);
      paramInt = i;
      if (this.Zgd != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Zgd);
      }
      AppMethodBeat.o(258526);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258526);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ero localero = (ero)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258526);
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
            localero.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258526);
          return 0;
        case 2: 
          localero.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258526);
          return 0;
        case 3: 
          localero.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258526);
          return 0;
        case 4: 
          localero.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258526);
          return 0;
        case 5: 
          localero.Zga = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258526);
          return 0;
        case 6: 
          localero.Zgc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258526);
          return 0;
        case 7: 
          localero.Oll = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258526);
          return 0;
        }
        localero.Zgd = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258526);
        return 0;
      }
      AppMethodBeat.o(258526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ero
 * JD-Core Version:    0.7.0.1
 */