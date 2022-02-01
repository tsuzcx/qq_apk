package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ceb
  extends esc
{
  public dbf aaom;
  public dbg aaon;
  public int hNv;
  public String hNw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72477);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72477);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hNv);
      if (this.hNw != null) {
        paramVarArgs.g(3, this.hNw);
      }
      if (this.aaom != null)
      {
        paramVarArgs.qD(4, this.aaom.computeSize());
        this.aaom.writeFields(paramVarArgs);
      }
      if (this.aaon != null)
      {
        paramVarArgs.qD(5, this.aaon.computeSize());
        this.aaon.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label700;
      }
    }
    label700:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hNv);
      paramInt = i;
      if (this.hNw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hNw);
      }
      i = paramInt;
      if (this.aaom != null) {
        i = paramInt + i.a.a.a.qC(4, this.aaom.computeSize());
      }
      paramInt = i;
      if (this.aaon != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaon.computeSize());
      }
      AppMethodBeat.o(72477);
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
          AppMethodBeat.o(72477);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ceb localceb = (ceb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72477);
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
            localceb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72477);
          return 0;
        case 2: 
          localceb.hNv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72477);
          return 0;
        case 3: 
          localceb.hNw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72477);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbf)localObject2).parseFrom((byte[])localObject1);
            }
            localceb.aaom = ((dbf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72477);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbg)localObject2).parseFrom((byte[])localObject1);
          }
          localceb.aaon = ((dbg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72477);
        return 0;
      }
      AppMethodBeat.o(72477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceb
 * JD-Core Version:    0.7.0.1
 */