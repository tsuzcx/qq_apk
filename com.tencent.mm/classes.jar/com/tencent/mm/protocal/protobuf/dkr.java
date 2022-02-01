package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkr
  extends erp
{
  public String aaoj;
  public String app_id;
  public String wwH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82453);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.g(2, this.app_id);
      }
      if (this.aaoj != null) {
        paramVarArgs.g(3, this.aaoj);
      }
      if (this.wwH != null) {
        paramVarArgs.g(4, this.wwH);
      }
      AppMethodBeat.o(82453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.app_id);
      }
      i = paramInt;
      if (this.aaoj != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaoj);
      }
      paramInt = i;
      if (this.wwH != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wwH);
      }
      AppMethodBeat.o(82453);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dkr localdkr = (dkr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82453);
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
            localdkr.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82453);
          return 0;
        case 2: 
          localdkr.app_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82453);
          return 0;
        case 3: 
          localdkr.aaoj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82453);
          return 0;
        }
        localdkr.wwH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(82453);
        return 0;
      }
      AppMethodBeat.o(82453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkr
 * JD-Core Version:    0.7.0.1
 */