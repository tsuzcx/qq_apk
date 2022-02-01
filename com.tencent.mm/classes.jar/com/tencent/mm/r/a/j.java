package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class j
  extends esc
{
  public String mdK;
  public int mdL;
  public String mdM;
  public boolean show_entrance;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231423);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(231423);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.show_entrance);
      if (this.mdK != null) {
        paramVarArgs.g(3, this.mdK);
      }
      paramVarArgs.bS(4, this.mdL);
      if (this.mdM != null) {
        paramVarArgs.g(5, this.mdM);
      }
      AppMethodBeat.o(231423);
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
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.mdK != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.mdK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.mdL);
      paramInt = i;
      if (this.mdM != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.mdM);
      }
      AppMethodBeat.o(231423);
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
          AppMethodBeat.o(231423);
          throw paramVarArgs;
        }
        AppMethodBeat.o(231423);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231423);
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
            localj.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(231423);
          return 0;
        case 2: 
          localj.show_entrance = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(231423);
          return 0;
        case 3: 
          localj.mdK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231423);
          return 0;
        case 4: 
          localj.mdL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(231423);
          return 0;
        }
        localj.mdM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(231423);
        return 0;
      }
      AppMethodBeat.o(231423);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.r.a.j
 * JD-Core Version:    0.7.0.1
 */