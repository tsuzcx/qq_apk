package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fvz
  extends esc
{
  public LinkedList<String> abUd;
  public int ytv;
  public String ytw;
  
  public fvz()
  {
    AppMethodBeat.i(82484);
    this.abUd = new LinkedList();
    AppMethodBeat.o(82484);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82485);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ytv);
      if (this.ytw != null) {
        paramVarArgs.g(3, this.ytw);
      }
      paramVarArgs.e(4, 1, this.abUd);
      AppMethodBeat.o(82485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ytv);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ytw);
      }
      i = i.a.a.a.c(4, 1, this.abUd);
      AppMethodBeat.o(82485);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abUd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fvz localfvz = (fvz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82485);
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
            localfvz.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(82485);
          return 0;
        case 2: 
          localfvz.ytv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82485);
          return 0;
        case 3: 
          localfvz.ytw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82485);
          return 0;
        }
        localfvz.abUd.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(82485);
        return 0;
      }
      AppMethodBeat.o(82485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvz
 * JD-Core Version:    0.7.0.1
 */