package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsi
  extends esc
{
  public int HWO;
  public int YES;
  public int aaYe;
  public boolean aaYf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259765);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.HWO);
      paramVarArgs.bS(3, this.YES);
      paramVarArgs.bS(4, this.aaYe);
      paramVarArgs.di(5, this.aaYf);
      AppMethodBeat.o(259765);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label464;
      }
    }
    label464:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.HWO);
      int j = i.a.a.b.b.a.cJ(3, this.YES);
      int k = i.a.a.b.b.a.cJ(4, this.aaYe);
      int m = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(259765);
      return paramInt + i + j + k + (m + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259765);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dsi localdsi = (dsi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259765);
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
            localdsi.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259765);
          return 0;
        case 2: 
          localdsi.HWO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259765);
          return 0;
        case 3: 
          localdsi.YES = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259765);
          return 0;
        case 4: 
          localdsi.aaYe = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259765);
          return 0;
        }
        localdsi.aaYf = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(259765);
        return 0;
      }
      AppMethodBeat.o(259765);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsi
 * JD-Core Version:    0.7.0.1
 */