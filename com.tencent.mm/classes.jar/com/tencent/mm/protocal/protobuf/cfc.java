package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cfc
  extends esc
{
  public LinkedList<String> Vxy;
  public String aaoN;
  public int hAV;
  public String wYI;
  
  public cfc()
  {
    AppMethodBeat.i(91484);
    this.Vxy = new LinkedList();
    AppMethodBeat.o(91484);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91485);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.Vxy);
      paramVarArgs.bS(3, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(4, this.wYI);
      }
      if (this.aaoN != null) {
        paramVarArgs.g(5, this.aaoN);
      }
      AppMethodBeat.o(91485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.Vxy) + i.a.a.b.b.a.cJ(3, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wYI);
      }
      i = paramInt;
      if (this.aaoN != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaoN);
      }
      AppMethodBeat.o(91485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Vxy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cfc localcfc = (cfc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91485);
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
            localcfc.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91485);
          return 0;
        case 2: 
          localcfc.Vxy.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(91485);
          return 0;
        case 3: 
          localcfc.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91485);
          return 0;
        case 4: 
          localcfc.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91485);
          return 0;
        }
        localcfc.aaoN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91485);
        return 0;
      }
      AppMethodBeat.o(91485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfc
 * JD-Core Version:    0.7.0.1
 */