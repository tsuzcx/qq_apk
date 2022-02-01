package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cgs
  extends esc
{
  public LinkedList<String> wrh;
  public int wrj;
  public int wrk;
  public int wrl;
  
  public cgs()
  {
    AppMethodBeat.i(114018);
    this.wrh = new LinkedList();
    AppMethodBeat.o(114018);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114019);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114019);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.wrh);
      paramVarArgs.bS(3, this.wrj);
      paramVarArgs.bS(4, this.wrk);
      paramVarArgs.bS(5, this.wrl);
      AppMethodBeat.o(114019);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label532;
      }
    }
    label532:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.wrh);
      int j = i.a.a.b.b.a.cJ(3, this.wrj);
      int k = i.a.a.b.b.a.cJ(4, this.wrk);
      int m = i.a.a.b.b.a.cJ(5, this.wrl);
      AppMethodBeat.o(114019);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wrh.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114019);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114019);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cgs localcgs = (cgs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114019);
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
            localcgs.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(114019);
          return 0;
        case 2: 
          localcgs.wrh.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(114019);
          return 0;
        case 3: 
          localcgs.wrj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114019);
          return 0;
        case 4: 
          localcgs.wrk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114019);
          return 0;
        }
        localcgs.wrl = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(114019);
        return 0;
      }
      AppMethodBeat.o(114019);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgs
 * JD-Core Version:    0.7.0.1
 */