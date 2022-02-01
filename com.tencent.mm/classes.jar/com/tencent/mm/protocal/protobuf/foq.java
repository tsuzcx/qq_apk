package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class foq
  extends erp
{
  public String abGp;
  public String abGq;
  public String abGr;
  public String hOg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129977);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abGq != null) {
        paramVarArgs.g(2, this.abGq);
      }
      if (this.abGp != null) {
        paramVarArgs.g(3, this.abGp);
      }
      if (this.abGr != null) {
        paramVarArgs.g(4, this.abGr);
      }
      if (this.hOg != null) {
        paramVarArgs.g(5, this.hOg);
      }
      AppMethodBeat.o(129977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label524;
      }
    }
    label524:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abGq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abGq);
      }
      i = paramInt;
      if (this.abGp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abGp);
      }
      paramInt = i;
      if (this.abGr != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abGr);
      }
      i = paramInt;
      if (this.hOg != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hOg);
      }
      AppMethodBeat.o(129977);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(129977);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        foq localfoq = (foq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(129977);
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
            localfoq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(129977);
          return 0;
        case 2: 
          localfoq.abGq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(129977);
          return 0;
        case 3: 
          localfoq.abGp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(129977);
          return 0;
        case 4: 
          localfoq.abGr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(129977);
          return 0;
        }
        localfoq.hOg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(129977);
        return 0;
      }
      AppMethodBeat.o(129977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foq
 * JD-Core Version:    0.7.0.1
 */