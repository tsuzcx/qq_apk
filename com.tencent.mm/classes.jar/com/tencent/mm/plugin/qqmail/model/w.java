package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class w
  extends esc
{
  public String Nkn;
  public String Nko;
  public String Nkp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267074);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(267074);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Nkn != null) {
        paramVarArgs.g(2, this.Nkn);
      }
      if (this.Nko != null) {
        paramVarArgs.g(3, this.Nko);
      }
      if (this.Nkp != null) {
        paramVarArgs.g(4, this.Nkp);
      }
      AppMethodBeat.o(267074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label512;
      }
    }
    label512:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nkn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Nkn);
      }
      i = paramInt;
      if (this.Nko != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Nko);
      }
      paramInt = i;
      if (this.Nkp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Nkp);
      }
      AppMethodBeat.o(267074);
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
          AppMethodBeat.o(267074);
          throw paramVarArgs;
        }
        AppMethodBeat.o(267074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267074);
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
            localw.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(267074);
          return 0;
        case 2: 
          localw.Nkn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267074);
          return 0;
        case 3: 
          localw.Nko = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267074);
          return 0;
        }
        localw.Nkp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(267074);
        return 0;
      }
      AppMethodBeat.o(267074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.w
 * JD-Core Version:    0.7.0.1
 */