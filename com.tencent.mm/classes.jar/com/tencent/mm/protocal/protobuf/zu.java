package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zu
  extends erp
{
  public String JFk;
  public String Zip;
  public String Ziq;
  public String hAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72452);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Zip != null) {
        paramVarArgs.g(2, this.Zip);
      }
      if (this.Ziq != null) {
        paramVarArgs.g(3, this.Ziq);
      }
      if (this.JFk != null) {
        paramVarArgs.g(4, this.JFk);
      }
      if (this.hAk != null) {
        paramVarArgs.g(5, this.hAk);
      }
      AppMethodBeat.o(72452);
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
      if (this.Zip != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zip);
      }
      i = paramInt;
      if (this.Ziq != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Ziq);
      }
      paramInt = i;
      if (this.JFk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.JFk);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hAk);
      }
      AppMethodBeat.o(72452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        zu localzu = (zu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72452);
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
            localzu.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72452);
          return 0;
        case 2: 
          localzu.Zip = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 3: 
          localzu.Ziq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 4: 
          localzu.JFk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72452);
          return 0;
        }
        localzu.hAk = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72452);
        return 0;
      }
      AppMethodBeat.o(72452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zu
 * JD-Core Version:    0.7.0.1
 */