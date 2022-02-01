package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exs
  extends esc
{
  public long YKx;
  public String aaWy;
  public String abzs;
  public int abzt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259352);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abzs != null) {
        paramVarArgs.g(3, this.abzs);
      }
      if (this.aaWy != null) {
        paramVarArgs.g(4, this.aaWy);
      }
      paramVarArgs.bv(5, this.YKx);
      paramVarArgs.bS(6, this.abzt);
      AppMethodBeat.o(259352);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label500;
      }
    }
    label500:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abzs != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abzs);
      }
      i = paramInt;
      if (this.aaWy != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaWy);
      }
      paramInt = i.a.a.b.b.a.q(5, this.YKx);
      int j = i.a.a.b.b.a.cJ(6, this.abzt);
      AppMethodBeat.o(259352);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259352);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        exs localexs = (exs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(259352);
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
            localexs.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259352);
          return 0;
        case 3: 
          localexs.abzs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259352);
          return 0;
        case 4: 
          localexs.aaWy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259352);
          return 0;
        case 5: 
          localexs.YKx = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259352);
          return 0;
        }
        localexs.abzt = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259352);
        return 0;
      }
      AppMethodBeat.o(259352);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exs
 * JD-Core Version:    0.7.0.1
 */