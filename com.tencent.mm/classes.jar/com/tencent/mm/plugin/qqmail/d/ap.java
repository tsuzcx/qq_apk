package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import java.util.LinkedList;

public final class ap
  extends dpc
{
  public boolean Btc;
  public String Btd;
  public String Bte;
  public int Btf;
  public int channel;
  public String fileid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.e(2, this.fileid);
      }
      paramVarArgs.cc(3, this.Btc);
      if (this.Btd != null) {
        paramVarArgs.e(4, this.Btd);
      }
      if (this.Bte != null) {
        paramVarArgs.e(5, this.Bte);
      }
      paramVarArgs.aM(6, this.Btf);
      paramVarArgs.aM(7, this.channel);
      AppMethodBeat.o(198634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fileid != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.fileid);
      }
      i += g.a.a.b.b.a.fS(3) + 1;
      paramInt = i;
      if (this.Btd != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Btd);
      }
      i = paramInt;
      if (this.Bte != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Bte);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.Btf);
      int j = g.a.a.b.b.a.bu(7, this.channel);
      AppMethodBeat.o(198634);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(198634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198634);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localap.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(198634);
          return 0;
        case 2: 
          localap.fileid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(198634);
          return 0;
        case 3: 
          localap.Btc = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(198634);
          return 0;
        case 4: 
          localap.Btd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(198634);
          return 0;
        case 5: 
          localap.Bte = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(198634);
          return 0;
        case 6: 
          localap.Btf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(198634);
          return 0;
        }
        localap.channel = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(198634);
        return 0;
      }
      AppMethodBeat.o(198634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ap
 * JD-Core Version:    0.7.0.1
 */