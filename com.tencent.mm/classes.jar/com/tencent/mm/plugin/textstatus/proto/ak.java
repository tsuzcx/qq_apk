package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class ak
  extends esc
{
  public com.tencent.mm.bx.b TpC;
  public boolean TpE;
  public LinkedList<bc> TpH;
  public LinkedList<bk> TpI;
  
  public ak()
  {
    AppMethodBeat.i(289974);
    this.TpH = new LinkedList();
    this.TpI = new LinkedList();
    AppMethodBeat.o(289974);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289990);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(289990);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TpH);
      if (this.TpC != null) {
        paramVarArgs.d(3, this.TpC);
      }
      paramVarArgs.di(4, this.TpE);
      paramVarArgs.e(5, 8, this.TpI);
      AppMethodBeat.o(289990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label672;
      }
    }
    label672:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.TpH);
      paramInt = i;
      if (this.TpC != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.TpC);
      }
      i = i.a.a.b.b.a.ko(4);
      int j = i.a.a.a.c(5, 8, this.TpI);
      AppMethodBeat.o(289990);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TpH.clear();
        this.TpI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(289990);
          throw paramVarArgs;
        }
        AppMethodBeat.o(289990);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289990);
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
            localak.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(289990);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bc)localObject2).parseFrom((byte[])localObject1);
            }
            localak.TpH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(289990);
          return 0;
        case 3: 
          localak.TpC = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(289990);
          return 0;
        case 4: 
          localak.TpE = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(289990);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bk)localObject2).parseFrom((byte[])localObject1);
          }
          localak.TpI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(289990);
        return 0;
      }
      AppMethodBeat.o(289990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ak
 * JD-Core Version:    0.7.0.1
 */