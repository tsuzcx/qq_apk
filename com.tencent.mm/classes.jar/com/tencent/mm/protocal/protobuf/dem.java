package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dem
  extends erp
{
  public String YzM;
  public String aaIL;
  public String aaqn;
  public String appid;
  public int fZW;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90969);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.YzM != null) {
        paramVarArgs.g(3, this.YzM);
      }
      if (this.signature != null) {
        paramVarArgs.g(4, this.signature);
      }
      paramVarArgs.bS(5, this.fZW);
      if (this.aaIL != null) {
        paramVarArgs.g(6, this.aaIL);
      }
      if (this.aaqn != null) {
        paramVarArgs.g(7, this.aaqn);
      }
      AppMethodBeat.o(90969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.YzM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YzM);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.signature);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.fZW);
      paramInt = i;
      if (this.aaIL != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaIL);
      }
      i = paramInt;
      if (this.aaqn != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaqn);
      }
      AppMethodBeat.o(90969);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(90969);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dem localdem = (dem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90969);
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
            localdem.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(90969);
          return 0;
        case 2: 
          localdem.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 3: 
          localdem.YzM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 4: 
          localdem.signature = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 5: 
          localdem.fZW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(90969);
          return 0;
        case 6: 
          localdem.aaIL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(90969);
          return 0;
        }
        localdem.aaqn = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(90969);
        return 0;
      }
      AppMethodBeat.o(90969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dem
 * JD-Core Version:    0.7.0.1
 */