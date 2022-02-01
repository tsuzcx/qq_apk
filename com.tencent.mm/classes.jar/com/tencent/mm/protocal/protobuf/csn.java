package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csn
  extends erp
{
  public String aayF;
  public String aayG;
  public String appid;
  public String mdG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258350);
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
      if (this.aayF != null) {
        paramVarArgs.g(3, this.aayF);
      }
      if (this.mdG != null) {
        paramVarArgs.g(4, this.mdG);
      }
      if (this.aayG != null) {
        paramVarArgs.g(5, this.aayG);
      }
      AppMethodBeat.o(258350);
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
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.aayF != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aayF);
      }
      paramInt = i;
      if (this.mdG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.mdG);
      }
      i = paramInt;
      if (this.aayG != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aayG);
      }
      AppMethodBeat.o(258350);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258350);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        csn localcsn = (csn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258350);
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
            localcsn.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258350);
          return 0;
        case 2: 
          localcsn.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258350);
          return 0;
        case 3: 
          localcsn.aayF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258350);
          return 0;
        case 4: 
          localcsn.mdG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258350);
          return 0;
        }
        localcsn.aayG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258350);
        return 0;
      }
      AppMethodBeat.o(258350);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csn
 * JD-Core Version:    0.7.0.1
 */