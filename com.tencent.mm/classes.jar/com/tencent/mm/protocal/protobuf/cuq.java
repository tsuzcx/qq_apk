package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class cuq
  extends esc
{
  public int YJF;
  public String aaAf;
  public String aaAg;
  public LinkedList<String> aaAh;
  
  public cuq()
  {
    AppMethodBeat.i(147767);
    this.aaAh = new LinkedList();
    AppMethodBeat.o(147767);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147768);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(147768);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaAf != null) {
        paramVarArgs.g(2, this.aaAf);
      }
      paramVarArgs.bS(3, this.YJF);
      if (this.aaAg != null) {
        paramVarArgs.g(4, this.aaAg);
      }
      paramVarArgs.e(5, 1, this.aaAh);
      AppMethodBeat.o(147768);
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
      int i = paramInt;
      if (this.aaAf != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaAf);
      }
      i += i.a.a.b.b.a.cJ(3, this.YJF);
      paramInt = i;
      if (this.aaAg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaAg);
      }
      i = i.a.a.a.c(5, 1, this.aaAh);
      AppMethodBeat.o(147768);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaAh.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(147768);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147768);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cuq localcuq = (cuq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147768);
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
            localcuq.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(147768);
          return 0;
        case 2: 
          localcuq.aaAf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(147768);
          return 0;
        case 3: 
          localcuq.YJF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(147768);
          return 0;
        case 4: 
          localcuq.aaAg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(147768);
          return 0;
        }
        localcuq.aaAh.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(147768);
        return 0;
      }
      AppMethodBeat.o(147768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuq
 * JD-Core Version:    0.7.0.1
 */