package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fgc
  extends erp
{
  public String Username;
  public String abGa;
  public String abGb;
  public String abGc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257868);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(257868);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Username != null) {
        paramVarArgs.g(2, this.Username);
      }
      if (this.abGa != null) {
        paramVarArgs.g(3, this.abGa);
      }
      if (this.abGb != null) {
        paramVarArgs.g(4, this.abGb);
      }
      if (this.abGc != null) {
        paramVarArgs.g(5, this.abGc);
      }
      AppMethodBeat.o(257868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Username);
      }
      i = paramInt;
      if (this.abGa != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abGa);
      }
      paramInt = i;
      if (this.abGb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abGb);
      }
      i = paramInt;
      if (this.abGc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abGc);
      }
      AppMethodBeat.o(257868);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(257868);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257868);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fgc localfgc = (fgc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257868);
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
            localfgc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257868);
          return 0;
        case 2: 
          localfgc.Username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257868);
          return 0;
        case 3: 
          localfgc.abGa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257868);
          return 0;
        case 4: 
          localfgc.abGb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257868);
          return 0;
        }
        localfgc.abGc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257868);
        return 0;
      }
      AppMethodBeat.o(257868);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgc
 * JD-Core Version:    0.7.0.1
 */