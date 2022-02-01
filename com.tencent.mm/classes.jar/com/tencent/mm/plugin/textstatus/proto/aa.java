package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class aa
  extends erp
{
  public String Tov;
  public bl Tpw;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289998);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.Tov != null) {
        paramVarArgs.g(3, this.Tov);
      }
      if (this.Tpw != null)
      {
        paramVarArgs.qD(4, this.Tpw.computeSize());
        this.Tpw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(289998);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label538;
      }
    }
    label538:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.Tov != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Tov);
      }
      paramInt = i;
      if (this.Tpw != null) {
        paramInt = i + i.a.a.a.qC(4, this.Tpw.computeSize());
      }
      AppMethodBeat.o(289998);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289998);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289998);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localaa.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(289998);
          return 0;
        case 2: 
          localaa.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(289998);
          return 0;
        case 3: 
          localaa.Tov = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(289998);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bl)localObject2).parseFrom((byte[])localObject1);
          }
          localaa.Tpw = ((bl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(289998);
        return 0;
      }
      AppMethodBeat.o(289998);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.aa
 * JD-Core Version:    0.7.0.1
 */