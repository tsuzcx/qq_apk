package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byi
  extends esc
{
  public String ADt;
  public boolean TGl;
  public int dIY;
  public int osy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169069);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.osy);
      paramVarArgs.bS(3, this.dIY);
      if (this.ADt != null) {
        paramVarArgs.g(4, this.ADt);
      }
      paramVarArgs.di(5, this.TGl);
      AppMethodBeat.o(169069);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.osy) + i.a.a.b.b.a.cJ(3, this.dIY);
      paramInt = i;
      if (this.ADt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ADt);
      }
      i = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(169069);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169069);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        byi localbyi = (byi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169069);
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
            localbyi.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(169069);
          return 0;
        case 2: 
          localbyi.osy = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169069);
          return 0;
        case 3: 
          localbyi.dIY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169069);
          return 0;
        case 4: 
          localbyi.ADt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169069);
          return 0;
        }
        localbyi.TGl = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(169069);
        return 0;
      }
      AppMethodBeat.o(169069);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byi
 * JD-Core Version:    0.7.0.1
 */