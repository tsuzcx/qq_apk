package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aha
  extends erp
{
  public String YBL;
  public String Zqd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259257);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Zqd != null) {
        paramVarArgs.g(2, this.Zqd);
      }
      if (this.YBL != null) {
        paramVarArgs.g(3, this.YBL);
      }
      AppMethodBeat.o(259257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zqd != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zqd);
      }
      i = paramInt;
      if (this.YBL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YBL);
      }
      AppMethodBeat.o(259257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259257);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aha localaha = (aha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259257);
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
            localaha.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259257);
          return 0;
        case 2: 
          localaha.Zqd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259257);
          return 0;
        }
        localaha.YBL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259257);
        return 0;
      }
      AppMethodBeat.o(259257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aha
 * JD-Core Version:    0.7.0.1
 */