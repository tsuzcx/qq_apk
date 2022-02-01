package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class ag
  extends esc
{
  public com.tencent.mm.bx.b TpC;
  public LinkedList<an> TpD;
  public boolean TpE;
  
  public ag()
  {
    AppMethodBeat.i(290009);
    this.TpD = new LinkedList();
    AppMethodBeat.o(290009);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290022);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(290022);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TpD);
      if (this.TpC != null) {
        paramVarArgs.d(3, this.TpC);
      }
      paramVarArgs.di(4, this.TpE);
      AppMethodBeat.o(290022);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.TpD);
      paramInt = i;
      if (this.TpC != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.TpC);
      }
      i = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(290022);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TpD.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(290022);
          throw paramVarArgs;
        }
        AppMethodBeat.o(290022);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(290022);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localag.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(290022);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new an();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((an)localObject2).parseFrom((byte[])localObject1);
            }
            localag.TpD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(290022);
          return 0;
        case 3: 
          localag.TpC = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(290022);
          return 0;
        }
        localag.TpE = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(290022);
        return 0;
      }
      AppMethodBeat.o(290022);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ag
 * JD-Core Version:    0.7.0.1
 */