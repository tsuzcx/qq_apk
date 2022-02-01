package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ne
  extends erp
{
  public String YOV;
  public String YOW;
  public long YOX;
  public String mac;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82394);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YOV != null) {
        paramVarArgs.g(2, this.YOV);
      }
      if (this.YOW != null) {
        paramVarArgs.g(3, this.YOW);
      }
      if (this.mac != null) {
        paramVarArgs.g(4, this.mac);
      }
      paramVarArgs.bv(5, this.YOX);
      AppMethodBeat.o(82394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label508;
      }
    }
    label508:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YOV != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YOV);
      }
      i = paramInt;
      if (this.YOW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YOW);
      }
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.mac);
      }
      i = i.a.a.b.b.a.q(5, this.YOX);
      AppMethodBeat.o(82394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ne localne = (ne)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82394);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localne.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82394);
          return 0;
        case 2: 
          localne.YOV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 3: 
          localne.YOW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 4: 
          localne.mac = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82394);
          return 0;
        }
        localne.YOX = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(82394);
        return 0;
      }
      AppMethodBeat.o(82394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ne
 * JD-Core Version:    0.7.0.1
 */