package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class ah
  extends esc
{
  public String Njt;
  public int NkN;
  public int NkO;
  public String nUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122800);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122800);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.NkO);
      if (this.Njt != null) {
        paramVarArgs.g(3, this.Njt);
      }
      paramVarArgs.bS(4, this.NkN);
      if (this.nUv != null) {
        paramVarArgs.g(5, this.nUv);
      }
      AppMethodBeat.o(122800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkO);
      paramInt = i;
      if (this.Njt != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Njt);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.NkN);
      paramInt = i;
      if (this.nUv != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nUv);
      }
      AppMethodBeat.o(122800);
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
          AppMethodBeat.o(122800);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122800);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ah localah = (ah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122800);
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
            localah.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(122800);
          return 0;
        case 2: 
          localah.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122800);
          return 0;
        case 3: 
          localah.Njt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122800);
          return 0;
        case 4: 
          localah.NkN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122800);
          return 0;
        }
        localah.nUv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(122800);
        return 0;
      }
      AppMethodBeat.o(122800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ah
 * JD-Core Version:    0.7.0.1
 */