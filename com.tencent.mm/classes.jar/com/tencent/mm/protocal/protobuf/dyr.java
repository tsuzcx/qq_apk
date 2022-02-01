package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyr
  extends erp
{
  public String Vyh;
  public String abdA;
  public String hOg;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129970);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abdA != null) {
        paramVarArgs.g(2, this.abdA);
      }
      if (this.signature != null) {
        paramVarArgs.g(3, this.signature);
      }
      if (this.Vyh != null) {
        paramVarArgs.g(4, this.Vyh);
      }
      if (this.hOg != null) {
        paramVarArgs.g(5, this.hOg);
      }
      AppMethodBeat.o(129970);
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
      if (this.abdA != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abdA);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.signature);
      }
      paramInt = i;
      if (this.Vyh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Vyh);
      }
      i = paramInt;
      if (this.hOg != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hOg);
      }
      AppMethodBeat.o(129970);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(129970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dyr localdyr = (dyr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(129970);
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
            localdyr.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(129970);
          return 0;
        case 2: 
          localdyr.abdA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(129970);
          return 0;
        case 3: 
          localdyr.signature = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(129970);
          return 0;
        case 4: 
          localdyr.Vyh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(129970);
          return 0;
        }
        localdyr.hOg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(129970);
        return 0;
      }
      AppMethodBeat.o(129970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyr
 * JD-Core Version:    0.7.0.1
 */